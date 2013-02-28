public class State implements Comparable<State> {
    public String name;
    public String label;
    public String automatonName;

    public static final String INT_LABEL = "Int"; 
    public static final String BOOL_LABEL = "Bool"; 
    public static final String VOID_LABEL = "Void"; 
    public static final String INTERFACE_LABEL = "Interface";
    public static final String NULL_LABEL = "NULL";
    
    public State(String label, String name, String automatonName){
        this.label = label;
        this.name = name;
        this.automatonName = automatonName;
    }

    public State(String label, String name) {
        this(label, name, "");
    }

    public State(State other){
        this.name = other.name;
        this.label = other.label;
        this.automatonName = other.automatonName;
    }

    /** 
     * If this is an Interface state, make sure that
     * this.automatonName is givenAutomatonName.
     */
    public void conformInterfaceAutomatonName(String givenAutomatonName){
        if (label.equals(INTERFACE_LABEL)){
            automatonName = givenAutomatonName;
        }
    }

    public boolean isNullState(){
        return !label.equals(NULL_LABEL);
    }

    // TODO: Should this consider name too??
    public boolean equals(Object o) {
        if (o instanceof State) {
            State other = (State) o;
            return this.label.equals(other.label)
                    && this.name.equals(other.name)
                    && this.automatonName.equals(other.automatonName);
        }
        return false;
    }

    public String toString(){
        String result = "<State: ";
        result += name;
        result += ", ";
        result += label;
        result += ", ";
        result += automatonName;
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
        hash += name.hashCode();
        hash += automatonName.hashCode();
        return hash;
    }

    public int compareTo(State other){
        return this.name.compareTo(other.name);
    }
}
