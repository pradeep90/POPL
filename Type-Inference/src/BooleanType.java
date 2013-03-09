public class BooleanType extends Type {
    
    public BooleanType() {
        
    }

    public boolean equals(Object o) {
        if (o instanceof BooleanType) {
            return true;
        }
        return false;
    }

}
