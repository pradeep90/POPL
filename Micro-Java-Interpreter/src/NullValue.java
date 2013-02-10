/** 
 * Class to represent Null Value.
 *
 * Usually, variables will have Null Value after their declaration.
 */
public class NullValue extends Value{
    public NullValue() {}

    /** 
     * @return true iff the o is of NullValue type.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof NullValue) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFalse(){
        return true;
    }

    public String toString(){
        String result = "NullValue";
        return result;
    }
}
