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

    public void extend(String name, Location location){
        extend(new Binding(name, location));
    }

    public void extend(Identifier identifier, Location location){
        extend(new Binding(getIdentifierName(identifier), location));
    }

    public void extend(ThisExpression thisExpression, Location location){
        extend(new Binding("this", location));
    }

    /** 
     * @return Location corresponding to name in this environment.
     */
    public Location lookup(String name){
        for (Binding b : bindingList){
            if (b.name.equals(name)){
                return b.value;
            }
        }

        // TODO(spradeep): Throw some kind of exception here

        // TODO(spradeep): Change this 
        return null;
    }

    public Location lookup(Identifier identifier){
        return lookup(getIdentifierName(identifier));
    }
    
    public Location lookup(ThisExpression thisExpression){
        return lookup("this");
    }

    public String getIdentifierName(Identifier identifier){
        return identifier.f0.tokenImage;
    }
}
