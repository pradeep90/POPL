import syntaxtree.*;

/** 
 * Abstract Class to represent the Type of an Expression.
 */
public abstract class Type {
    public abstract boolean equals(Object o);

    public Type substitute(TypeEnvironment unification){
        return this;
    }
    
    public abstract void accept(TripleDVisitor visitor, Type other);
    public abstract void accept(TripleDVisitor visitor, IntType other);
    public abstract void accept(TripleDVisitor visitor, BooleanType other);
    public abstract void accept(TripleDVisitor visitor, FunctionType other);
    public abstract void accept(TripleDVisitor visitor, UnknownType other);

    public int hashCode(){
        int hash = 0;
        hash += this.getClass().getSimpleName().hashCode();
        return hash;
    }
}
