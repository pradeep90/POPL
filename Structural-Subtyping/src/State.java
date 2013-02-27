public class State implements Comparable<State> {
    String name;
    String label;
    boolean isNamedInterface;

    public State(String label, String name, boolean isNamedInterface){
        this.label = label;
        this.name = name;
        this.isNamedInterface = isNamedInterface;
    }

    public State(String label, String name) {
        this(label, name, false);
    }

    // TODO: Should this consider name too??
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
        result += name;
        result += ", ";
        result += label;
        result += ", ";
        result += isNamedInterface;
        result += ">";
        return result;
    }

    /** 
     * Note: Not using id in calculating hash cos we don't use it in
     * equals().
     */
    public int hashCode(){
        int hash = 0;
        hash += label != null? label.hashCode(): 0;
        hash += new Boolean(isNamedInterface).hashCode();
        return hash;
    }

    public int compareTo(State other){
        return this.name.compareTo(other.name);
    }
}
