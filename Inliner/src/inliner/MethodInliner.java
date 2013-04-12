package inliner;

import inliner.syntaxtree.*;
import inliner.visitor.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static inliner.InlinerHelper.*;

/** 
 * Visitor to inline each MessageSendStatement whose object has a
 * Singleton flow set.
 */
public class MethodInliner extends IdentityVisitor {
    VarNameUniquifier varNameUniquifier;
    Goal originalParseTree;
    HashMap<FlowVar, HashSet<String>> flowSetMap;

    NodeListOptional currMethodVarDeclarations;
    
    public MethodInliner(Goal originalParseTree,
                         VarNameUniquifier varNameUniquifier,
                         HashMap<FlowVar, HashSet<String>> flowSetMap) {
        this.varNameUniquifier = varNameUniquifier;
        this.originalParseTree = originalParseTree;
        this.flowSetMap = flowSetMap;
    }

    /**
     * f0 -> MainClass()
     * f1 -> ( TypeDeclaration() )*
     * f2 -> <EOF>
     */
    @Override
    public Node visit(Goal n) {
        originalParseTree = n;
        return super.visit(n);
    }

    /**
     * f0 -> "public"
     * f1 -> "void"
     * f2 -> Identifier()
     * f3 -> "("
     * f4 -> ( FormalParameterList() )?
     * f5 -> ")"
     * f6 -> "{"
     * f7 -> ( VarDeclaration() )*
     * f8 -> ( Statement() )*
     * f9 -> "}"
     */
    @Override
    public Node visit(MethodDeclaration n) {
        currMethodVarDeclarations = new NodeListOptional();

        MethodDeclaration _ret = (MethodDeclaration) super.visit(n);

        // Add the varDeclarations for inlined method calls
        _ret.f7.nodes.addAll(currMethodVarDeclarations.nodes);
        return _ret;
    }

    /**
     * f0 -> Block()
     *       | AssignmentStatement()
     *       | ArrayAssignmentStatement()
     *       | IfStatement()
     *       | WhileStatement()
     *       | PrintStatement()
     *       | MessageSendStatement()
     */
    @Override
    public Node visit(Statement n) {
        Statement _ret = (Statement) super.visit(n);

        // It is supposedly a MessageSendStatement
        if (_ret.f0.which == 6){
            // If it is actually a Block (cos of inlining)
            if (_ret.f0.choice instanceof Block){
                _ret = new Statement(new NodeChoice(_ret.f0.choice, 0));
            }
        }

        return _ret;
    }

    /**
     * f0 -> Identifier()
     * f1 -> "."
     * f2 -> Identifier()
     * f3 -> "("
     * f4 -> ( ExpressionList() )?
     * f5 -> ")"
     * f6 -> ";"
     */
    @Override
    public Node visit(MessageSendStatement n) {
        Node _ret;
        _ret = super.visit(n);
        
        // Identifier f0 = (Identifier) n.f0.accept(this);
        // Identifier f2 = (Identifier) n.f2.accept(this);
        // NodeOptional f4 = (NodeOptional) n.f4.accept(this);
        // _ret = new MessageSendStatement(f0, f2, f4);

        if (isSingleton(getIdentifierName(n.f0))
            // Non-recursive call
            && !this.currMethodName.equals(getIdentifierName(n.f2))){
            MethodTransformer methodTransformer = new MethodTransformer(
                getMethod(getIdentifierName(n.f0),
                          getIdentifierName(n.f2),
                          originalParseTree),
                getIdentifierName(n.f0),
                getSaneExpressionList(n.f4),
                varNameUniquifier);

            methodTransformer.computeTransformedMethod();
            currMethodVarDeclarations.nodes.addAll(
                methodTransformer.varDeclarations.nodes);
            _ret = new Block(methodTransformer.statementList);
        }

        return _ret;
    }

    public MethodDeclaration getMethod(String objectName,
                                       String methodName,
                                       Goal goal){
        FlowVar objectFlowVar = new FlowVar(this.currClassName,
                                            this.currMethodName,
                                            objectName);
        String className = flowSetMap.get(objectFlowVar).iterator().next();
        TypeDeclaration typeDeclaration = null;

        for (Node node : goal.f1.nodes){
            typeDeclaration = (TypeDeclaration) node;
            if (getClassName(typeDeclaration).equals(className)){
                break;
            }
        }

        if (typeDeclaration == null){
            return null;
        }

        for (Node node : getMethodList(typeDeclaration).nodes){
            MethodDeclaration methodDeclaration = (MethodDeclaration) node;
            if (getIdentifierName(methodDeclaration.f2).equals(methodName)){
                return methodDeclaration;
            }
        }
        return null;
    }

    public static NodeListOptional getMethodList(TypeDeclaration typeDeclaration){
        return typeDeclaration.f0.which == 0?
                ((ClassDeclaration) typeDeclaration.f0.choice).f4:
                ((ClassExtendsDeclaration) typeDeclaration.f0.choice).f6;
    }

    public boolean isSingleton(String objectName){
        FlowVar objectFlowVar = new FlowVar(this.currClassName,
                                            this.currMethodName,
                                            objectName);
        return (flowSetMap.get(objectFlowVar).size() == 1);
    }
}
