public class Result {
    Value value;
    Store store;
    
    public Result(Value value, Store store) {
        this.value = value;
        this.store = store;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Result) {
            Result other = (Result) o;
            boolean valueEqual;

            if (this.value == null && other.value == null){
                valueEqual = true;
            }
            else if (this.value == null || other.value == null){
                valueEqual = false;
            }
            else
                valueEqual = this.value.equals(other.value);

            return valueEqual && (this.store.equals(other.store));
        }
        return false;
    }
}
