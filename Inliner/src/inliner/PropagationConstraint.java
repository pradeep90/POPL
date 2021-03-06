package inliner;

/** 
 * Class to represent Constraints of the form X \sub Y.
 */
public class PropagationConstraint extends Constraint{
    FlowVar lhs;
    FlowVar rhs;
    
    public PropagationConstraint(FlowVar lhs, FlowVar rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public String toString(){
        String result = "<PropagationConstraint: ";
        result += lhs;
        result += ", ";
        result += rhs;
        result += ">";
        return result;
    }
}
