package inliner;

import inliner.syntaxtree.*;
import inliner.visitor.*;
import java.util.List;
import java.util.ArrayList;

import static inliner.InlinerHelper.*;

/** 
 * Visitor to transform a given method into a form suitable for
 * inlining.
 */
public class MethodTransformer extends IdentityVisitor {
    MethodDeclaration methodDeclaration;
    String objectName;
    List<Expression> arguments;
    VarNameUniquifier varNameUniquifier;

    MethodDeclaration transformedMethod;
    MethodDeclaration uniquifiedTransformedMethod;
    
    // Result
    public NodeListOptional varDeclarations;
    public NodeListOptional statementList;

    NodeListOptional initStatements;

    NodeListOptional localVars;
    // Note: This is list of VarDeclaration, not FormalParameterList
    NodeListOptional paramVars;
    List<String> localVarParamNames;
    
    public MethodTransformer(MethodDeclaration methodDeclaration,
                             String objectName,
                             List<Expression> arguments,
                             VarNameUniquifier varNameUniquifier) {
        this.methodDeclaration = getCopy(methodDeclaration);
        this.objectName = objectName;
        this.arguments = arguments;
        this.varNameUniquifier = varNameUniquifier;

        computeLocalVars();
    }

    public void computeLocalVars(){
        localVars = new NodeListOptional();
        localVars.nodes.addAll(methodDeclaration.f7.nodes);

        paramVars = getVarDeclarationsFromParameterList(methodDeclaration.f4.node);

        localVarParamNames = new ArrayList<String>();
        for (Node varDeclaration : localVars.nodes){
            localVarParamNames.add(getIdentifierName(
                ((VarDeclaration) varDeclaration).f1));
        }
        for (Node varDeclaration : paramVars.nodes){
            localVarParamNames.add(getIdentifierName(
                ((VarDeclaration) varDeclaration).f1));
        }
    }

    public void computeTransformedMethod(){
        transformedMethod = (MethodDeclaration) visit(methodDeclaration);

        // TODO: Uniquify transformedMethod
        uniquifiedTransformedMethod =
                (MethodDeclaration) transformedMethod.accept(varNameUniquifier,
                                                             new Environment());
        initStatements = new NodeListOptional();

        paramVars = getVarDeclarationsFromParameterList(
            uniquifiedTransformedMethod.f4.node);
        
        // paramVar = arg
        for (int i = 0; i < paramVars.nodes.size(); i++){
            VarDeclaration currVarDeclaration =
                    (VarDeclaration) paramVars.nodes.get(i);
            initStatements.addNode(
                new Statement(new NodeChoice(
                    new AssignmentStatement(
                        new VarRef(new NodeChoice(
                            getCopy(currVarDeclaration.f1), 1)),
                        arguments.get(i)),
                    0)));
        }

        varDeclarations = uniquifiedTransformedMethod.f7;
        varDeclarations.nodes.addAll(paramVars.nodes);
        
        statementList = initStatements;
        statementList.nodes.addAll(uniquifiedTransformedMethod.f8.nodes);
    }

    /**
     * f0 -> IntegerLiteral()
     *       | TrueLiteral()
     *       | FalseLiteral()
     *       | VarRef()
     *       | ThisExpression()
     *       | ArrayAllocationExpression()
     *       | AllocationExpression()
     *       | NotExpression()
     *       | BracketExpression()
     */
    @Override
    public Node visit(PrimaryExpression n) {
        Node _ret = super.visit(n);

        // If it's a ThisExpression
        if (((PrimaryExpression) _ret).f0.which == 4){
            _ret = new PrimaryExpression(
                new NodeChoice(new VarRef(
                    new NodeChoice(getNewIdentifier(objectName), 1)), 3));
        }

        return _ret;
    }

    /**
     * f0 -> DotExpression()
     *       | Identifier()
     */
    @Override
    public Node visit(VarRef n) {
        VarRef _ret = (VarRef) super.visit(n);

        // non-local var: foo -> obj.foo
        if (_ret.f0.which == 1
            && !isLocalVar(getIdentifierName((Identifier) _ret.f0.choice))){

            _ret = new VarRef(new NodeChoice(
                new DotExpression(getNewIdentifier(objectName),
                                  getCopy((Identifier) _ret.f0.choice)),
                0));
        }

        return _ret;
    }

    public boolean isLocalVar(String varName){
        return localVarParamNames.contains(varName);
    }
}
