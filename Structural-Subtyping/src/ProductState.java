public class ProductState {
    public State stateA;
    public State stateB;
    public int parity;
    
    public ProductState() {
        
    }

    public ProductState(State stateA, State stateB, int parity){
        this.stateA = stateA;
        this.stateB = stateB;
        this.parity = parity;
    }

    /**
     * Since there are no supertypes among the current set of labels,
     * the only case in which stateA <= stateB is when label(stateA)
     * == label(stateB)
     * 
     * @return false iff label(stateA) <=_parity label(stateB)
     */
    public boolean isFinalState(){
        return !stateA.label.equals(stateB.label);
    }

    /** 
     * @return true iff A and B are interfaces.
     */
    public boolean areBothInterfaces(){
        return stateA.label.equals(State.INTERFACE_LABEL)
                && stateB.label.equals(State.INTERFACE_LABEL);
    }

    public boolean equals(Object o) {
        if (o instanceof ProductState) {
            ProductState other = (ProductState) o;
            return this.stateA.equals(other.stateA)
                    && this.stateB.equals(other.stateB)
                    && this.parity == other.parity;
        }
        return false;
    }

    public int hashCode(){
        int hash = 0;
        hash += stateA.hashCode();
        hash += stateB.hashCode();
        hash += parity;
        return hash;
    }

    public String toString(){
        String result = "<Product State:";
        result += stateA.name;
        result += " ";
        result += stateB.name;
        result += " ";
        result += parity;
        result += ">";
        return result;
    }
}
