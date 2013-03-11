public class BooleanType extends Type {
    
    public BooleanType() {
        
    }

    @Override
    public boolean areSameBasicType(Type other){
        if (other instanceof BooleanType){
            return true;
        }
        return false;
    }

    @Override
    public boolean areIncompatibleTypes(Type other){
        if (other instanceof FunctionType){
            return true;
        }
        else if (other instanceof IntType){
            return true;
        }
        return false;
    }

    public boolean equals(Object o) {
        if (o instanceof BooleanType) {
            return true;
        }
        return false;
    }

    public String toString(){
        String result = "";
        result += "bool";
        return result;
    }
}
