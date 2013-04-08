package inliner;

public class BeginningConstraint extends Constraint {
    String className;
    FlowVar var;
    
    public BeginningConstraint(String className, FlowVar var) {
        this.className = className;
        this.var = var;
    }
}
