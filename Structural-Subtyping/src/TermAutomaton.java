import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class TermAutomaton {
    // TODO: Make this a Set
    public Set<Symbol> inputAlphabet;
    public Set<State> states;
    public State startState;
    // Not really needed
    public State finalState;
    public HashMap<State, HashMap<Symbol, State> > deltaAdjacencyList; 

    public TermAutomaton() {
        inputAlphabet = new TreeSet<Symbol>();
        inputAlphabet.add(new Symbol("0"));
        inputAlphabet.add(new Symbol("1"));

        states = new TreeSet<State>();
 
        finalState = null;
        deltaAdjacencyList = new HashMap<State, HashMap<Symbol, State> >();
    }

    public TermAutomaton(TreeSet<Symbol> inputAlphabet,
                         Set<State> states,
                         State startState,
                         State finalState,
                         HashMap<State, HashMap<Symbol, State> > deltaAdjacencyList) {

        this.inputAlphabet = inputAlphabet;
        this.states = states;
        this.startState = startState;
        this.finalState = finalState;
        this.deltaAdjacencyList = deltaAdjacencyList;
    }
    
    /** 
     * Add edge from sourceState to targetState with label.
     */
    public void addEdge(State sourceState, State targetState, Symbol label){
        HashMap<Symbol, State> edgesForSource = deltaAdjacencyList.get(sourceState);

        if (edgesForSource == null){
            // No edges for source yet. Add new hash map of edges.
            edgesForSource = new HashMap<Symbol, State>();
            deltaAdjacencyList.put(sourceState, edgesForSource);
        }

        edgesForSource.put(label, targetState);
    }

    /** 
     * Add edge from -> to targetState with label parity.
     */
    public void addMethodTypeEdge(State arrowState, State targetState, int parity){
        addEdge(arrowState, targetState, new Symbol("" + parity));
    }

    public boolean equals(Object o) {
        if (o instanceof TermAutomaton) {
            TermAutomaton other = (TermAutomaton) o;
            return (this.states.equals(other.states))
                    && (this.startState.equals(other.startState))
                    && (this.inputAlphabet.equals(other.inputAlphabet))
                    && (this.deltaAdjacencyList.equals(other.deltaAdjacencyList));
        }
        return false;
    }

    public String toString(){
        String result = "<TermAutomaton: ";
        result += inputAlphabet.toString();
        result += "\n";
        result += states.toString();
        result += "\n";
        result += startState.toString();
        result += "\n";
        if (finalState != null){
            result += finalState.toString();
            result += "\n";
        }
        result += deltaAdjacencyList.toString();
        result += ">";
        return result;
    }

    public String getAutomatonName(){
        return this.startState.name;
    }

    /** 
     * Include the definition of other Automaton in this automaton
     * (called A).
     *
     * Basically replace State "J" with the automaton for J.
     * + First, add in all of J's states and symbols.
     * + Then, add all of its edges (X, s, Y).
     * If X or Y is an Identifier(name: X, automaton: Z), then make it
     * an Identifier(name: X, automaton: A)
     */
    public void includeOtherAutomatonDefinition(TermAutomaton other){
        // TODO: 
        inputAlphabet.addAll(other.inputAlphabet);
        for (State state : other.states){
            State copiedState = new State(state);
            copiedState.conformInterfaceAutomatonName(this.getAutomatonName());
            this.states.add(copiedState);
        }

        for (Map.Entry<State, HashMap<Symbol, State>> entry :
                     other.deltaAdjacencyList.entrySet()){
            State sourceState = new State(entry.getKey());
            sourceState.conformInterfaceAutomatonName(this.getAutomatonName());

            for (Map.Entry<Symbol, State> edgeEntry : entry.getValue().entrySet()){
                Symbol edgeSymbol = edgeEntry.getKey();
                State targetState = new State(edgeEntry.getValue());
                targetState.conformInterfaceAutomatonName(this.getAutomatonName());

                addEdge(sourceState, targetState, edgeSymbol);
            }
        }
    }
}

