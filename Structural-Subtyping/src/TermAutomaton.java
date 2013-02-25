import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class TermAutomaton {
    // TODO: Make this a Set
    List<Symbol> inputAlphabet;
    List<State> states;
    State startState;
    // Not really needed
    State finalState;
    HashMap<State, HashMap<Symbol, State> > deltaAdjacencyList; 

    public static final State INT_STATE = new State("Int");
    public static final State BOOL_STATE = new State("Bool");
    public static final State VOID_STATE = new State("Void");
    public static final State ARROW_STATE = new State("->");
    public static final State INTERFACE_STATE = new State("Interface");
    
    public TermAutomaton() {
        inputAlphabet = new ArrayList<Symbol>();
        inputAlphabet.add(new Symbol("0"));
        inputAlphabet.add(new Symbol("1"));

        states = new ArrayList<State>();
        states.add(new State("Int"));
        states.add(new State("Bool"));
        states.add(new State("Void"));
        states.add(new State("->"));
        states.add(new State("Interface"));
        
        startState = new State("Interface");
        finalState = null;
        deltaAdjacencyList = new HashMap<State, HashMap<Symbol, State> >();
    }

    public TermAutomaton(List<Symbol> inputAlphabet,
                         List<State> states,
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
    public void addMethodTypeEdge(State targetState, int parity){
        addEdge(ARROW_STATE, targetState, new Symbol("" + parity));
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
}

