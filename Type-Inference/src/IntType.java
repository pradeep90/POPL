public class IntType extends Type {
    
    public IntType() {
        
    }

    public boolean equals(Object o) {
        if (o instanceof IntType) {
            return true;
        }
        return false;
    }

    public String toString(){
        String result = "";
        result += "int";
        return result;
    }
}
