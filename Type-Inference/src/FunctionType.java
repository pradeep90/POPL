import java.util.List;

public class FunctionType extends Type {
    public Type paramType;
    public Type returnType;
    
    public FunctionType(Type paramType, Type returnType) {
        this.paramType = paramType;
        this.returnType = returnType;
    }

    @Override
    public boolean areSameBasicType(Type other){
        // FunctionType is not a basic type
        return false;
    }

    @Override
    public boolean areIncompatibleTypes(Type other){
        if (other instanceof IntType){
            return true;
        }
        else if (other instanceof BooleanType){
            return true;
        }
        return false;
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

    @Override
    public Type substitute(TypeEnvironment unification){
        return new FunctionType(paramType.substitute(unification),
                                returnType.substitute(unification));
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

    public int hashCode(){
        int hash = 0;
        hash += paramType.hashCode();
        hash += returnType.hashCode();
        return hash;
    }
}
