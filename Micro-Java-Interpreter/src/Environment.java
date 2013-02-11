import syntaxtree.*;
import visitor.*;
import java.util.*;

public class Environment {
    public List<Binding> bindingList;

    public Environment() {
        bindingList = new LinkedList<Binding>();
    }

    /** 
     * Create a new Environment with parentEnvironment.
     *
     * Ensure that extensions to this environment will not make
     * extensions to the parentEnvironment. However, changing values
     * of pre-existing bindings in the parentEnvironment is OK.
     */
    public Environment(Environment parentEnvironment){
        bindingList = new LinkedList<Binding>(parentEnvironment.bindingList);
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

    public void extend(String name, Value value){
        extend(new Binding(name, value));
    }

    public void extend(Identifier identifier, Value value){
        extend(new Binding(getIdentifierName(identifier), value));
    }

    public void extend(ThisExpression thisExpression, Value value){
        extend(new Binding("this", value));
    }

    /** 
     * @return Value corresponding to name in this environment.
     */
    public Value lookup(String name){
        for (Binding b : bindingList){
            if (b.name.equals(name)){
                return b.value;
            }
        }

        // TODO(spradeep): Throw some kind of exception here

        // TODO(spradeep): Change this 
        return null;
    }

    public Value lookup(Identifier identifier){
        return lookup(getIdentifierName(identifier));
    }
    
    public Value lookup(ThisExpression thisExpression){
        return lookup("this");
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
        if (o instanceof Environment) {
            Environment other = (Environment) o;
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
