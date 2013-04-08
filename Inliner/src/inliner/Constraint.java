package inliner;

public abstract class Constraint {
    
    public Constraint() {
        
    }

    public int hashCode(){
        int hash = 0;
        hash += toString().hashCode();
        return hash;
    }
}
