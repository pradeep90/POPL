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

    /** 
     * @return Location corresponding to identifier in this environment.
     */
    public Location lookup(Identifier identifier){
        for (Binding b : bindingList){
            if (b.identifier.f0.tokenImage == identifier.f0.tokenImage){
                return b.value;
            }
        }

        // TODO(spradeep): Throw some kind of exception here

        // TODO(spradeep): Change this 
        return null;
    }

    public Location lookup(String identifierName){
        return lookup(new Identifier(new NodeToken(identifierName)));
    }
}
