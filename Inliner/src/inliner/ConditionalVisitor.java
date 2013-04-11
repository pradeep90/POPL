package inliner;

import inliner.syntaxtree.*;
import inliner.visitor.*;
import java.util.List;
import java.util.ArrayList;

import static inliner.InlinerHelper.*;

/** 
 * Visitor to get a list of ConditionalConstraints given details about
 * a MessageSendStatement.
 *
 * Look at MethodDeclarations whose signature matches
 * messageMethodName and generate the RHS of all the conditional
 * constraints.
 *
 * i.e., the RHS of (c \in X) => (Y \sub Z)
 */
public class ConditionalVisitor extends IdentityVisitor {
    // The X part of (c \in X) in each ConditionalConstraint
    FlowVar mainFlowVar;

    // Details about the method
    String messageMethodName;
    List<FlowVar> arguments;

    // Result
    public List<ConditionalConstraint> constraints;
    
    public ConditionalVisitor(FlowVar mainFlowVar,
                              String messageMethodName,
                              List<FlowVar> arguments) {
        this.mainFlowVar = mainFlowVar;
        this.messageMethodName = messageMethodName;
        this.arguments = arguments;

        constraints = new ArrayList<ConditionalConstraint>();
    }

    /** 
     * Add a ConditionalConstraint for each of the flowParameters.
     */
    public void addConstraints(String currClassName,
                               List<FlowVar> flowParameters){

        List<ConditionalConstraint> currConstraints =
                new ArrayList<ConditionalConstraint>();
        
        for (int i = 0; i < flowParameters.size(); i++){
            currConstraints.add(new ConditionalConstraint(
                currClassName,
                mainFlowVar,
                new PropagationConstraint(arguments.get(i),
                                          flowParameters.get(i))));
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
        Node _ret = super.visit(n);
        if (isMatchingMethodSignature(n)){
            addConstraints(this.currClassName,
                           getFlowParameters(getSaneFormalParameterList(n.f4)));
        }
        return _ret;
    }

    /** 
     * @return true iff the method name of n matches messageMethodName
     * and it has the same number of parameters as the arguments
     * given.
     */
    public boolean isMatchingMethodSignature(MethodDeclaration n){
        return this.currMethodName.equals(this.messageMethodName)
                && getSaneFormalParameterList(n.f4).size() == arguments.size();
    }

    /** 
     * @return a FlowVar for each parameter in parameters.
     */
    public List<FlowVar> getFlowParameters(List<FormalParameter> parameters){
        List<FlowVar> flowParameters = new ArrayList<FlowVar>();
        for (FormalParameter param : parameters){
            flowParameters.add(new FlowVar(this.currClassName,
                                           this.currMethodName,
                                           getFormattedString(param.f1)));
        }
        return flowParameters;
    }
}
