/** 
 * Abstract Class to represent the Value of an Expression.
 */
public abstract class Value {
    // Later subclass this for the various types of Values.

    // Decide whether you want to have ALL values as Cells (aka Boxes)
    // or ints as ints themselves.
    public abstract boolean equals(Object o);

    public abstract boolean isFalse();

    public void setValue(Value value){}
    
    public boolean isTrue(){
        return !isFalse();
    }
}
