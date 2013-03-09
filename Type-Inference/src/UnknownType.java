public class UnknownType extends Type {
    
    public UnknownType() {
        
    }

    public boolean equals(Object o) {
        if (o instanceof UnknownType) {
            return true;
        }
        return false;
    }

}
