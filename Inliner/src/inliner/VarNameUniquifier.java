package inliner;

import inliner.syntaxtree.*;
import inliner.visitor.*;
import java.util.List;
import java.util.ArrayList;

import static inliner.InlinerHelper.*;

/** 
 * Convert Microjava code into Microjava code with unique identifier
 * names
 */
public class VarNameUniquifier extends IdentityWithArgVisitor {
    int counter;
    public final static String VAR_NAME_PREFIX = "___VAR";

    // TODO: 
    // HashMap<String, HashMap<String, String>> classRenamerMap;
    
    public VarNameUniquifier() {
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     * f2 -> ";"
     */
    @Override
    public Node visit(VarDeclaration n, Environment env) {
        Node _ret = null;
        Type f0 = (Type) n.f0.accept(this, env);
        Identifier f1 = getNewIdentifier(insertAndLookup(
            getIdentifierName(n.f1), env));
        _ret = new VarDeclaration(f0, f1);
        return _ret;
    }

    /**
     * f0 -> DotExpression()
     *       | Identifier()
     */
    @Override
    public Node visit(VarRef n, Environment env) {
        Node _ret=null;
        if (n.f0.which == 1){
            _ret = new VarRef(new NodeChoice(
                getNewIdentifier(env.lookup(
                    getIdentifierName((Identifier) n.f0.choice))),
                n.f0.which));
        } else {
            _ret = new VarRef(new NodeChoice(n.f0.accept(this, env), n.f0.which));
        }
        return _ret;
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     */
    @Override
    public Node visit(FormalParameter n, Environment env) {
        Node _ret=null;
        Type f0 = (Type) n.f0.accept(this, env);
        Identifier f1 = getNewIdentifier(insertAndLookup(
            getIdentifierName(n.f1), env));
        _ret = new FormalParameter(f0, f1);
        return _ret;
    }

    public String getNewName(String oldName){
        return null;
    }

    public String getVarName(int counter){
        return VAR_NAME_PREFIX + counter;
    }

    /** 
     * Extend the env and return the newName just inserted.
     */
    public String insertAndLookup(String oldName, Environment env){
        env.extend(oldName, getVarName(counter++));
        return env.lookup(oldName);
    }
}
