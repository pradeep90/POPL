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

    public int hashCode(){
        int hash = 0;
        if (className != null){
            hash += className.hashCode();
        }
        if (methodName != null){
            hash += methodName.hashCode();
        }
        if (expressionString != null){
            hash += expressionString.hashCode();
        }
        return hash;
    }

    public boolean equals(Object o) {
        if (o instanceof FlowVar) {
            FlowVar other = (FlowVar) o;
            return this.className.equals(other.className)
                    && this.methodName.equals(other.methodName)
                    && this.expressionString.equals(other.expressionString);
        }
        return false;
    }

}
