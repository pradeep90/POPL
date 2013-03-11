import java.util.List;

public class FunctionType extends Type {
    Type paramType;
    Type returnType;
    
    public FunctionType(Type paramType, Type returnType) {
        this.paramType = paramType;
        this.returnType = returnType;
    }

    /** 
     * Construct a FunctionType out of the paramTypes and returnType.
     */
    public static FunctionType getFunctionType(List<Type> paramTypes, Type returnType){
        // TODO: What to do when paramTypes is empty?

        if (paramTypes.isEmpty()){
            return null;
        }

        if (paramTypes.size() == 1){
            return new FunctionType(paramTypes.get(0), returnType);
        }
        else{
            return new FunctionType(
                paramTypes.get(0),
                getFunctionType(paramTypes.subList(1, paramTypes.size()),
                                returnType));
        }

    }
    
    public boolean equals(Object o) {
        if (o instanceof FunctionType) {
            FunctionType other = (FunctionType) o;
            return this.paramType.equals(other.paramType)
                    && this.returnType.equals(other.returnType);
        }
        return false;
    }

    public String toString(){
        String result = "(";
        result += paramType;
        result += " -> ";
        result += returnType;
        result += ")";
        return result;
    }
}
