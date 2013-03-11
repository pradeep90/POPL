public class UnknownType extends Type {
    int id;

    public static int counter = 0;
    
    public UnknownType(int id) {
        this.id = id;
    }
    
    public UnknownType() {
        this.id = counter++;
    }

    @Override
    public boolean areSameBasicType(Type other){
        if (other instanceof UnknownType){
            return true;
        }
        return false;
    }

    @Override
    public boolean areIncompatibleTypes(Type other){
        return false;
    }

    @Override
    public Type substitute(TypeEnvironment unification){
        if (unification.lookup("" + id) != null){
            return unification.lookup("" + id);
        }
        return this;
    }

    public boolean equals(Object o) {
        if (o instanceof UnknownType) {
            UnknownType other = (UnknownType) o;
            return this.id == other.id;
        }
        return false;
    }

    public String toString(){
        String result = "<UnknownType: ";
        result += id;
        result += ">";
        return result;
    }

    public int hashCode(){
        int hash = 0;
        hash += id;
        return hash;
    }
}
