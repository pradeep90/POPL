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
            return (this.value.equals(other.value))
                    && (this.store.equals(other.store));
        }
        return false;
    }
}
