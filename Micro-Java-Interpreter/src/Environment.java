import syntaxtree.*;
import visitor.*;
import java.util.*;

public class Environment {
    public List<Binding> bindingList;

    public Environment() {
        bindingList = new LinkedList<Binding>();
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
}
