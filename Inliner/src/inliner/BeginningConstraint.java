package inliner;

public class BeginningConstraint extends Constraint {
    String className;
    FlowVar var;
    
    public BeginningConstraint(String className, FlowVar var) {
        this.className = className;
        this.var = var;
    }

    public String toString(){
        String result = "<BeginningConstraint: ";
        result += className;
        result += ", ";
        result += var;
        result += ">";
        return result;
    }
}
