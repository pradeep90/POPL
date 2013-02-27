import visitor.*;
import syntaxtree.*;

import java.util.HashMap;

/** 
 * Visitor Class for visiting an Interface parse tree and creating the
 * corresponding TermAutomaton.
 */
public class TermAutomatonCreator extends GJVoidDepthFirst<TermAutomaton> {
    // This will contain the Automaton for each Interface defined in
    // terms of other Interfaces (hence partial)
    public HashMap<String, TermAutomaton> partialAutomatonHashTable =
            new HashMap<String, TermAutomaton>();

    // This will contain the final Automaton for each Interface
    public HashMap<String, TermAutomaton> finalAutomatonHashTable =
            new HashMap<String, TermAutomaton>();
    
    int globalParity = 0;

    public TermAutomatonCreator() {
    }

    /**
     * f0 -> ( Query() )*
     * f1 -> ( InterfaceDeclaration() )*
     * f2 -> <EOF>
     */
    public void visit(Goal n, TermAutomaton arg) {
        n.f1.accept(this, null);

        // TODO: Do post-processing to include definitions of other
        // interfaces in each interface and fill up
        // finalAutomatonHashTable.
    }

    /**
     * f0 -> Identifier()
     * f1 -> "<="
     * f2 -> Identifier()
     * f3 -> "?"
     */
    public void visit(Query n, TermAutomaton arg) {
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        n.f2.accept(this, arg);
        n.f3.accept(this, arg);
    }

    /**
     * f0 -> "interface"
     * f1 -> Identifier()
     * f2 -> InterfaceBody()
     */
    public void visit(InterfaceDeclaration n, TermAutomaton arg) {
        // n.f0.accept(this, arg);
        // n.f1.accept(this, arg);
        TermAutomaton currTermAutomaton = new TermAutomaton();
        partialAutomatonHashTable.put(InterfaceHelper.getIdentifierName(n.f1),
                                      currTermAutomaton);

        n.f2.accept(this, currTermAutomaton);
    }

    /**
     * f0 -> "{"
     * f1 -> ( InterfaceMember() )*
     * f2 -> "}"
     */
    public void visit(InterfaceBody n, TermAutomaton arg) {
        n.f1.accept(this, arg);
    }

    /**
     * f0 -> ResultType()
     * f1 -> Identifier()
     * f2 -> "("
     * f3 -> Type()
     * f4 -> Identifier()
     * f5 -> ")"
     * f6 -> ";"
     */
    public void visit(InterfaceMember n, TermAutomaton arg) {
        // Add 1-edge from -> to f0
        globalParity = 1;
        n.f0.accept(this, arg);

        // Add f1 to input alphabet
        arg.inputAlphabet.add(new Symbol(InterfaceHelper.getIdentifierName(n.f1)));

        // Add an (f1) edge from Interface to ->
        arg.addEdge(TermAutomaton.INTERFACE_STATE, TermAutomaton.ARROW_STATE,
                    new Symbol(InterfaceHelper.getIdentifierName(n.f1)));

        // Add 0-edge from -> to f3
        globalParity = 0;
        n.f3.accept(this, arg);
    }

    /**
     * f0 -> BooleanType()
     *       | IntegerType()
     *       | Identifier()
     */
    public void visit(Type n, TermAutomaton arg) {
        n.f0.accept(this, arg);
    }

    /**
     * f0 -> "boolean"
     */
    public void visit(BooleanType n, TermAutomaton arg) {
        arg.addMethodTypeEdge(TermAutomaton.BOOL_STATE, globalParity);
    }

    /**
     * f0 -> "int"
     */
    public void visit(IntegerType n, TermAutomaton arg) {
        arg.addMethodTypeEdge(TermAutomaton.INT_STATE, globalParity);
    }

    /**
     * f0 -> VoidType()
     *       | Type()
     */
    public void visit(ResultType n, TermAutomaton arg) {
        n.f0.accept(this, arg);
    }

    /**
     * f0 -> "void"
     */
    public void visit(VoidType n, TermAutomaton arg) {
        arg.addMethodTypeEdge(TermAutomaton.VOID_STATE, globalParity);
    }

    /**
     * f0 -> <IDENTIFIER>
     */
    public void visit(Identifier n, TermAutomaton arg) {
        // Add a temporary state with n's name so that we can
        // substitute the Interface's actual definition later.
        arg.addMethodTypeEdge(new State(InterfaceHelper.getIdentifierName(n)),
                              globalParity);
    }

}