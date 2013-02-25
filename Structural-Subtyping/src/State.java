public class State {
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
}
