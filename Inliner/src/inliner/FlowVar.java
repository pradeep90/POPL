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

    public String toString(){
        String result = "<FlowVar: ";
        if (className != null){
            result += className;
            result += ", ";
        }
        if (methodName != null){
            result += methodName;
            result += ", ";
        }
        if (expressionString != null){
            result += expressionString;
        }
        result += ">";
        return result;
    }
}
