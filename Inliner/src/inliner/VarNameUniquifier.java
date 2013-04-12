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

    boolean inMethod = false;
    
    public VarNameUniquifier() {
    }

    /**
     * f0 -> "public"
     * f1 -> "void"
     * f2 -> Identifier()
     * f3 -> "("
     * f4 -> ( FormalParameterList() )?
     * f5 -> ")"
     * f6 -> "{"
     * f7 -> ( VarDeclaration() )*
     * f8 -> ( Statement() )*
     * f9 -> "}"
     */
    @Override
    public Node visit(MethodDeclaration n, Environment env) {
        inMethod = true;
        Node _ret = super.visit(n, env);
        inMethod = false;
        return _ret;
    }

    /**
     * f0 -> Identifier()
     * f1 -> "."
     * f2 -> Identifier()
     * f3 -> "("
     * f4 -> ( ExpressionList() )?
     * f5 -> ")"
     * f6 -> ";"
     */
    @Override
    public Node visit(MessageSendStatement n, Environment env) {
        Node _ret = null;
        Identifier f0;
        
        if (env.lookup(getIdentifierName(n.f0)) == null){
            f0 = (Identifier) super.visit(n.f0, env);
        } else {
            f0 = getNewIdentifier(env.lookup(
                getIdentifierName(n.f0)));
        }
        
        Identifier f2 = (Identifier) n.f2.accept(this, env);
        NodeOptional f4 = (NodeOptional) n.f4.accept(this, env);
        _ret = new MessageSendStatement(f0, f2, f4);
        return _ret;
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     * f2 -> ";"
     */
    @Override
    public Node visit(VarDeclaration n, Environment env) {
        Node _ret = null;
        if (inMethod){
            Type f0 = (Type) n.f0.accept(this, env);
            Identifier f1 = getNewIdentifier(insertAndLookup(
                getIdentifierName(n.f1), env));
            _ret = new VarDeclaration(f0, f1);
        } else {
            _ret = super.visit(n, env);
        }
        
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
            if (env.lookup(getIdentifierName(
                    (Identifier) n.f0.choice)) == null){
                _ret = super.visit(n, env);
            } else {
                _ret = new VarRef(new NodeChoice(
                    getNewIdentifier(env.lookup(
                        getIdentifierName((Identifier) n.f0.choice))),
                    n.f0.which));
            }
        } else {
            _ret = new VarRef(new NodeChoice(n.f0.accept(this, env),
                                             n.f0.which));
        }
        return _ret;
    }

    /**
     * f0 -> Identifier()
     * f1 -> "."
     * f2 -> Identifier()
     */
    @Override
    public Node visit(DotExpression n, Environment env) {
        Node _ret=null;

        if (env.lookup(getIdentifierName(n.f0)) == null){
            _ret = super.visit(n, env);
        } else {
            Identifier f0 = getNewIdentifier(env.lookup(
                getIdentifierName(n.f0)));
            Identifier f2 = (Identifier) n.f2.accept(this, env);
            _ret = new DotExpression(f0, f2);
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
        System.out.println("insertAndLookup"); 
        System.out.println("oldName: " + oldName);
        System.out.println("env: " + env);
        env.extend(oldName, getVarName(counter++));
        return env.lookup(oldName);
    }
}
