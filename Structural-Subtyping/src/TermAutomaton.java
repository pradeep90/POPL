import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TermAutomaton extends Automaton<State> {
    public TermAutomaton() {
        super();
        this.inputAlphabet.add(new Symbol("0"));
        this.inputAlphabet.add(new Symbol("1"));
    }

    public TermAutomaton(TermAutomaton other){
        this.inputAlphabet = new HashSet<Symbol>(other.inputAlphabet);
        this.states = new HashSet<State>(other.states);
        this.startState = new State(other.startState);
        this.deltaAdjacencyList = new HashMap<State, HashMap<Symbol, State>>();
        for (Map.Entry<State, HashMap<Symbol, State>> entry :
                     other.deltaAdjacencyList.entrySet()){
            State sourceState = new State(entry.getKey());
            for (Map.Entry<Symbol, State> edgeEntry : entry.getValue().entrySet()){
                Symbol edgeSymbol = edgeEntry.getKey();
                State targetState = new State(edgeEntry.getValue());
                addEdge(sourceState, targetState, edgeSymbol);
            }
        }
    }

    /**
     * If sourceState doesn't have a neighbour along edgeLabel, return
     * NULL state.
     * 
     * @return neighbour of sourceState along edgeLabel.
     */
    @Override
    public State getNeighbour(State sourceState, Symbol edgeLabel){
        if (hasNeighbour(sourceState, edgeLabel)){
            return deltaAdjacencyList.get(sourceState).get(edgeLabel);
        }
        return new State(State.NULL_LABEL, State.NULL_LABEL);
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
