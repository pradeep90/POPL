package inliner;

import inliner.syntaxtree.*;
import inliner.visitor.*;
import java.util.List;
import java.util.ArrayList;

import static inliner.InlinerHelper.*;

/** 
 * Visitor to get a list of ConditionalConstraints given a
 * MessageSendStatement.
 *
 * Look at MethodDeclarations whose signature matches the message and
 * generate the RHS of all the conditional constraints.
 *
 * i.e., the RHS of (c \in X) => (Y \sub Z)
 */
public class ConditionalVisitor extends IdentityVisitor {
    // The X part of (c \in X) in each ConditionalConstraint
    FlowVar mainFlowVar;
    String messageMethodName;
    List<FlowVar> arguments;
    List<ConditionalConstraint> constraints;
    
    public ConditionalVisitor(FlowVar mainFlowVar,
                              String messageMethodName,
                              List<FlowVar> arguments) {
        this.mainFlowVar = mainFlowVar;
        this.messageMethodName = messageMethodName;
        this.arguments = arguments;

        constraints = new ArrayList<ConditionalConstraint>();
    }

    public void addConstraints(String currClassName,
                               List<FlowVar> flowParameters){

        List<ConditionalConstraint> currConstraints =
                new ArrayList<ConditionalConstraint>();
        
        for (int i = 0; i < flowParameters.size(); i++){
            currConstraints.add(new ConditionalConstraint(
                currClassName,
                mainFlowVar,
                arguments.get(i),
                flowParameters.get(i)));
        }

        constraints.addAll(currConstraints);
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
        Node _ret=null;
        Identifier f2 = (Identifier) n.f2.accept(this);
        currMethodName = InlinerHelper.getIdentifierName(f2);
        NodeOptional f4 = (NodeOptional) n.f4.accept(this);
        NodeListOptional f7 = (NodeListOptional) n.f7.accept(this);
        NodeListOptional f8 = (NodeListOptional) n.f8.accept(this);
        _ret = new MethodDeclaration(f2, f4, f7, f8);

        if (currMethodName.equals(messageMethodName)
            && getSaneFormalParameterList(n.f4).size() == arguments.size()){

            List<FlowVar> flowParameters = new ArrayList<FlowVar>();
            for (FormalParameter param : getSaneFormalParameterList(n.f4)){
                flowParameters.add(new FlowVar(this.currClassName,
                                               this.currMethodName,
                                               getFormattedString(param.f1)));
            }
            
            addConstraints(this.currClassName, flowParameters);
        }
        return _ret;
    }
}
