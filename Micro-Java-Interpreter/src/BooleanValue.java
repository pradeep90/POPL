public class BooleanValue extends Value {
    boolean booleanValue;
    
    public BooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public BooleanValue(){}

    @Override
    public void setValue(Value value){
        BooleanValue otherValue = (BooleanValue) value;
        this.booleanValue = otherValue.booleanValue;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BooleanValue) {
            BooleanValue other = (BooleanValue) o;
            return this.booleanValue == other.booleanValue;
        }
        return false;
    }

    @Override
    public boolean isFalse(){
        return !booleanValue;
    }

    public String toString(){
        String result = "" + booleanValue;
        return result;
    }
}

