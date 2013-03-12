import java.util.List;

public class FunctionType extends Type {
    public Type paramType;
    public Type returnType;

    public static final Type VOID_TYPE = new UnknownType(10001);
    
    public FunctionType(Type paramType, Type returnType) {
        this.paramType = paramType;
        this.returnType = returnType;
    }
    
    public void accept(TripleDVisitor visitor, Type other){
        other.accept(visitor, this);
    }
    
    public void accept(TripleDVisitor visitor, IntType other){
        visitor.visit(this, other);
    }
    
    public void accept(TripleDVisitor visitor, BooleanType other){
        visitor.visit(this, other);
    }

    public void accept(TripleDVisitor visitor, FunctionType other){
        visitor.visit(this, other);
    }

    public void accept(TripleDVisitor visitor, UnknownType other){
        visitor.visit(this, other);
    }

    /** 
     * Construct a FunctionType out of the paramTypes and returnType.
     */
    public static FunctionType getFunctionType(List<Type> paramTypes, Type returnType){
        // TODO: What to do when paramTypes is empty?

        if (paramTypes.isEmpty()){
            return new FunctionType(VOID_TYPE, returnType);
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
