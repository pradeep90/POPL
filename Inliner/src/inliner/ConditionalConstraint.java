package inliner;

/** 
 * Represent Constraints of the form (c \in X) => (Y \sub Z)
 */
public class ConditionalConstraint extends Constraint{
    String className;
    FlowVar mainFlowVar;
    FlowVar antecedent;
    FlowVar consequent;
    
    public ConditionalConstraint(String className, FlowVar mainFlowVar,
                                 FlowVar antecedent, FlowVar consequent) {
        this.className = className;
        this.mainFlowVar = mainFlowVar;
        this.antecedent = antecedent;
        this.consequent = consequent;
    }
}
