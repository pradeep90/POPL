import visitor.*;
import syntaxtree.*;

import java.util.Set;
import java.util.HashSet;
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
    State currArrowState;
    State currInterfaceState;
    String currInterfaceName;

    public TermAutomatonCreator() {
    }

    /** 
     * Keep including other Automata for which you have the Interface
     * state but not the rest of the Automaton.
     * 
     * @return the complete Automaton for startInterfaceName
     */
    public TermAutomaton getCompleteAutomaton(String startInterfaceName){
        TermAutomaton currAutomaton = new TermAutomaton(
            partialAutomatonHashTable.get(startInterfaceName));
        Set<String> seenInterfaces = new HashSet<String>();

        // Get list of Interface states in your Automaton
        // Pick one unseen state
        // Include the Automaton for that Interface
        // Mark that state as seen
        while (getUnseenInterface(currAutomaton, seenInterfaces) != null){
            String unseenInterfaceName = getUnseenInterface(currAutomaton, seenInterfaces);
            seenInterfaces.add(unseenInterfaceName);
            currAutomaton.includeOtherAutomatonDefinition(
                partialAutomatonHashTable.get(unseenInterfaceName));
        }
        
        return currAutomaton;
    }

    /** 
     * @return an Interface needed by currAutomaton which isn't in seenInterfaces.
     */
    public String getUnseenInterface(TermAutomaton currAutomaton,
                                     Set<String> seenInterfaces){
        for (State state : currAutomaton.states){
            if (state.label.equals(State.INTERFACE_LABEL)
                && !seenInterfaces.contains(state.name)){
                return state.name;
            }
        }

        return null;
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

        // Do DFS, once with each Interface as the start state
        for (String key : partialAutomatonHashTable.keySet()){
            finalAutomatonHashTable.put(key, getCompleteAutomaton(key));
        }
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
        currInterfaceName = InterfaceHelper.getIdentifierName(n.f1);
        currInterfaceState = new State(State.INTERFACE_LABEL,
                                       currInterfaceName,
                                       currInterfaceName);
        currTermAutomaton.states.add(currInterfaceState);
        currTermAutomaton.startState = currInterfaceState;
        partialAutomatonHashTable.put(currInterfaceName,
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
        // Create a state with arrow f1
        currArrowState = new State("->", InterfaceHelper.getIdentifierName(n.f1),
                                   currInterfaceName);

        arg.states.add(currArrowState);

        // Add f1 to input alphabet
        arg.inputAlphabet.add(new Symbol(InterfaceHelper.getIdentifierName(n.f1)));

        // Add 1-edge from -> to f0
        globalParity = 1;
        n.f0.accept(this, arg);

        // Add 0-edge from -> to f3
        globalParity = 0;
        n.f3.accept(this, arg);

        // Add an (f1) edge from Interface to ->
        arg.addEdge(currInterfaceState, currArrowState,
                    new Symbol(InterfaceHelper.getIdentifierName(n.f1)));
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
        arg.states.add(new State(State.BOOL_LABEL,
                                 State.BOOL_LABEL,
                                 currInterfaceName));
        arg.addMethodTypeEdge(currArrowState,
                              new State(State.BOOL_LABEL,
                                        State.BOOL_LABEL,
                                        currInterfaceName),
                              globalParity);
    }

    /**
     * f0 -> "int"
     */
    public void visit(IntegerType n, TermAutomaton arg) {
        arg.states.add(new State(State.INT_LABEL,
                                 State.INT_LABEL,
                                 currInterfaceName));
        arg.addMethodTypeEdge(currArrowState,
                              new State(State.INT_LABEL,
                                        State.INT_LABEL,
                                        currInterfaceName),
                              globalParity);
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
        arg.states.add(new State(State.VOID_LABEL,
                                 State.VOID_LABEL,
                                 currInterfaceName));
        arg.addMethodTypeEdge(currArrowState,
                              new State(State.VOID_LABEL,
                                        State.VOID_LABEL,
                                        currInterfaceName),
                              globalParity);
    }

    /**
     * f0 -> <IDENTIFIER>
     */
    public void visit(Identifier n, TermAutomaton arg) {
        State interfaceState = new State(State.INTERFACE_LABEL,
                                         InterfaceHelper.getIdentifierName(n),
                                         currInterfaceName);

        arg.states.add(interfaceState);

        // Add a temporary state with n's name so that we can
        // substitute the Interface's actual definition later.
        arg.addMethodTypeEdge(currArrowState,
                              interfaceState,
                              globalParity);
    }

}
