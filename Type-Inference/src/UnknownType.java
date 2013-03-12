public class UnknownType extends Type {
    int id;

    public static int counter = 0;
    
    public UnknownType(int id) {
        this.id = id;
    }
    
    public UnknownType() {
        this.id = counter++;
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
     * @return true iff `this` occurs in `other`.
     */
    public boolean occursIn(Type other){
        FunctionType functionType = (FunctionType) other;
        return occursIn(functionType.paramType)
                || occursIn(functionType.returnType);
    }

    @Override
    public Type substitute(TypeEnvironment unification){
        if (unification.lookup("" + id) != null){
            return unification.lookup("" + id);
        }
        return this;
    }

    public boolean equals(Object o) {
        if (o instanceof UnknownType) {
            UnknownType other = (UnknownType) o;
            return this.id == other.id;
        }
        return false;
    }

    public String toString(){
        String result = "<UnknownType: ";
        result += id;
        result += ">";
        return result;
    }

    public int hashCode(){
        int hash = 0;
        hash += id;
        return hash;
    }
}
