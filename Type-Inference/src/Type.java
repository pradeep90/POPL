import syntaxtree.*;

/** 
 * Abstract Class to represent the Type of an Expression.
 */
public abstract class Type {
    public abstract boolean equals(Object o);

    public int hashCode(){
        int hash = 0;
        hash += this.getClass().getSimpleName().hashCode();
        return hash;
    }
}
