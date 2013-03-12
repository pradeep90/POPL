public class BooleanType extends Type {
    
    public BooleanType() {
        
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

    public boolean equals(Object o) {
        if (o instanceof BooleanType) {
            return true;
        }
        return false;
    }

    public String toString(){
        String result = "";
        result += "bool";
        return result;
    }
}
