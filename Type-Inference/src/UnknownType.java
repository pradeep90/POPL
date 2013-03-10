public class UnknownType extends Type {
    int id;

    public static int counter = 0;
    
    public UnknownType(int id) {
        this.id = id;
    }
    
    public UnknownType() {
        this.id = counter++;
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
}
