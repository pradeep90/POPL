package inliner;

public class FlowVar {
    public String className;
    public String methodName;
    public String expressionString;
    
    public FlowVar(String className, String methodName, String expressionString) {
        this.className = className;
        this.methodName = methodName;
        this.expressionString = expressionString;
    }
}
