import syntaxtree.*;

/** 
 * Abstract Class to represent the Type of an Expression.
 */
public abstract class Type {
    public abstract boolean equals(Object o);

    public Type substitute(TypeEnvironment unification){
        return this;
    }

    public abstract boolean areSameBasicType(Type other);

    public abstract boolean areIncompatibleTypes(Type other);

    /** 
     * @return true iff other occurs
     */
    // public abstract boolean occursIn(Type other);

    public int hashCode(){
        int hash = 0;
        hash += this.getClass().getSimpleName().hashCode();
        return hash;
    }
}
