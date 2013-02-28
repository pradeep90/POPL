public class ProductState {
    State stateA;
    State stateB;
    int parity;
    
    public ProductState() {
        
    }

    public ProductState(State stateA, State stateB, int parity){
        this.stateA = stateA;
        this.stateB = stateB;
        this.parity = parity;
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
