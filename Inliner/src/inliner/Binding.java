package inliner;

import inliner.syntaxtree.*;
import inliner.visitor.*;

public class Binding {
    String oldName;
    String newName;

    public Binding(String oldName, String newName) {
        this.oldName = oldName;
        this.newName = newName;
    }

    public String toString(){
        String result = "";
        result += oldName + ": " + newName;
        return result;
    }

    public boolean equals(Object o) {
        if (o instanceof Binding) {
            Binding other = (Binding) o;
            return this.oldName.equals(other.oldName) && this.newName.equals(other.newName);
        }
        return false;
    }

}
