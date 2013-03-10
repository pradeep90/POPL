public class TypeEquation {
    Type type1;
    Type type2;
    
    public TypeEquation(Type type1, Type type2) {
        this.type1 = type1;
        this.type2 = type2;
    }

    public boolean equals(Object o) {
        if (o instanceof TypeEquation) {
            TypeEquation other = (TypeEquation) o;
            return type1.equals(other.type1)
                    && type2.equals(other.type2);
        }
        return false;
    }

    public int hashCode(){
        int hash = 0;
        hash += type1.hashCode();
        hash += type2.hashCode();
        return hash;
    }

    public String toString(){
        String result = "<TypeEquation: ";
        result += type1;
        result += ", ";
        result += type2;
        result += ">";
        return result;
    }
}

