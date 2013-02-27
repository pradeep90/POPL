public class State implements Comparable<State> {
    String label;
    boolean isNamedInterface;

    public State(String label, boolean isNamedInterface){
        this.label = label;
        this.isNamedInterface = isNamedInterface;
    }

    public State(String label) {
        this(label, false);
    }

    public boolean equals(Object o) {
        if (o instanceof State) {
            State other = (State) o;
            return this.label.equals(other.label)
                    && this.isNamedInterface == other.isNamedInterface;
        }
        return false;
    }

    public String toString(){
        String result = "<State: ";
        result += label;
        result += ", ";
        result += isNamedInterface;
        result += ">";
        return result;
    }

    public int hashCode(){
        int hash = 0;
        hash += label != null? label.hashCode(): 0;
        hash += new Boolean(isNamedInterface).hashCode();
        return hash;
    }

    public int compareTo(State other){
        if (this.label.compareTo(other.label) == 0){
            return new Boolean(this.isNamedInterface).compareTo(
                new Boolean(other.isNamedInterface));
        }
        return this.label.compareTo(other.label);
    }
}
