package inliner;

/** 
 * Represent Constraints of the form (c \in X) => (Y \sub Z)
 */
public class ConditionalConstraint extends Constraint{
    String className;
    FlowVar mainFlowVar;
    PropagationConstraint propagationConstraint;
    
    public ConditionalConstraint(String className, FlowVar mainFlowVar,
                                 PropagationConstraint propagationConstraint) {
        this.className = className;
        this.mainFlowVar = mainFlowVar;
        this.propagationConstraint = propagationConstraint;
    }

    public String toString(){
        String result = "<ConditionalConstraint: ";
        result += className;
        result += ", ";
        result += mainFlowVar;
        result += ", ";
        result += propagationConstraint;
        result += ">";
        return result;
    }
}
