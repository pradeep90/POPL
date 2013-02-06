public class IntegerValue extends Value {
    int integerValue;

    public IntegerValue(int integerValue) {
        this.integerValue = integerValue;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof IntegerValue) {
            IntegerValue other = (IntegerValue) o;
            return this.integerValue == other.integerValue;
        }
        return false;
    }

    @Override
    public boolean isFalse(){
        return true;
    }
}
