import syntaxtree.*;
import visitor.*;
import java.util.*;

public class TypeEnvironment {
    public LinkedList<Binding> bindingList;

    public TypeEnvironment() {
        bindingList = new LinkedList<Binding>();
    }

    /** 
     * Create a new TypeEnvironment with parentTypeEnvironment.
     *
     * Ensure that extensions to this environment will not make
     * extensions to the parentTypeEnvironment. However, changing types
     * of pre-existing bindings in the parentTypeEnvironment is OK.
     */
    public TypeEnvironment(TypeEnvironment parentTypeEnvironment){
        bindingList = new LinkedList<Binding>(parentTypeEnvironment.bindingList);
    }

    /** 
     * Extend this environment with newBinding.
     *
     * For now, just put newBinding at the front of the list of
     * bindings.
     */
    public void extend(Binding newBinding){
        bindingList.add(0, newBinding);
    }

    public void extend(String name, Type type){
        extend(new Binding(name, type));
    }

    /** 
     * @return Type corresponding to name in this environment.
     */
    public Type lookup(String name){
        for (Binding b : bindingList){
            if (b.name.equals(name)){
                return b.type;
            }
        }

        // TODO(spradeep): Throw some kind of exception here

        // TODO(spradeep): Change this 
        return null;
    }

    public Type lookup(Identifier identifier){
        return lookup(getIdentifierName(identifier));
    }
    
    public String getIdentifierName(Identifier identifier){
        return identifier.f0.tokenImage;
    }

    public String toString(){
        String result = "{";
        for (Binding binding : bindingList){
            result += binding + ", ";
        }
        result += "}";

        return result;
    }

    public boolean equals(Object o) {
        if (o instanceof TypeEnvironment) {
            TypeEnvironment other = (TypeEnvironment) o;
            for (int i = 0; i < this.bindingList.size(); i++){
                Binding currBinding = this.bindingList.get(i);
                Binding otherBinding = other.bindingList.get(i);
                if (!currBinding.equals(otherBinding))
                    return false;
            }
            return true;
        }
        return false;
    }
}
