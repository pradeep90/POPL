import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Collection;
import java.util.HashMap;

/** 
 * Generic Class to represent an Automaton.
 * @param <T> the type of the Automaton States.
 */
public class Automaton<T> {
    public Set<Symbol> inputAlphabet;
    public Set<T> states;
    public T startState;
    public HashMap<T, HashMap<Symbol, T>> deltaAdjacencyList; 

    public Automaton() {
        inputAlphabet = new HashSet<Symbol>();
        states = new HashSet<T>();
        deltaAdjacencyList = new HashMap<T, HashMap<Symbol, T> >();
    }

    public Automaton(Set<Symbol> inputAlphabet,
                     Set<T> states,
                     T startState,
                     HashMap<T, HashMap<Symbol, T> > deltaAdjacencyList) {

        this.inputAlphabet = inputAlphabet;
        this.states = states;
        this.startState = startState;
        this.deltaAdjacencyList = deltaAdjacencyList;
    }
    
    /** 
     * Add edge from sourceState to targetState with label.
     */
    public void addEdge(T sourceState, T targetState, Symbol label){
        HashMap<Symbol, T> edgesForSource = deltaAdjacencyList.get(sourceState);

        if (edgesForSource == null){
            // No edges for source yet. Add new hash map of edges.
            edgesForSource = new HashMap<Symbol, T>();
            deltaAdjacencyList.put(sourceState, edgesForSource);
        }

        edgesForSource.put(label, targetState);
    }

    /** 
     * Add edge from -> to targetState with label parity.
     */
    public void addMethodTypeEdge(T arrowState, T targetState, int parity){
        addEdge(arrowState, targetState, new Symbol("" + parity));
    }

    /**
     * If sourceState doesn't have a neighbour along edgeLabel, return
     * NULL state.
     * 
     * @return neighbour of sourceState along edgeLabel.
     */
    public T getNeighbour(T sourceState, Symbol edgeLabel){
        return deltaAdjacencyList.get(sourceState).get(edgeLabel);
    }
    
    /** 
     * @return set of neighbours of sourceState.
     */
    public Collection<T> getNeighbours(T sourceState){
        if (deltaAdjacencyList.get(sourceState) != null){
            return deltaAdjacencyList.get(sourceState).values(); 
        }
        return new ArrayList<T>();
    }

    /** 
     * @return true iff sourceState has a neighbour along edgeLabel.
     */
    public boolean hasNeighbour(T sourceState, Symbol edgeLabel){
        return deltaAdjacencyList.get(sourceState) != null
                && deltaAdjacencyList.get(sourceState).get(edgeLabel) != null;
    }

    /** 
     * @return symbols of all edges going out from sourceState.
     */
    public Set<Symbol> getEdgeSymbols(T sourceState){
        if (deltaAdjacencyList.get(sourceState) != null){
            return deltaAdjacencyList.get(sourceState).keySet(); 
        }
        return new HashSet<Symbol>();
    }

    public boolean equals(Object o) {
        if (o instanceof Automaton) {
            Automaton other = (Automaton) o;
            return (this.states.equals(other.states))
                    && (this.startState.equals(other.startState))
                    && (this.inputAlphabet.equals(other.inputAlphabet))
                    && (this.deltaAdjacencyList.equals(other.deltaAdjacencyList));
        }
        return false;
    }

    public String toString(){
        String result = "<Automaton: ";
        result += inputAlphabet.toString();
        result += "\n";
        result += states.toString();
        result += "\n";
        result += startState.toString();
        result += "\n";
        result += deltaAdjacencyList.toString();
        result += ">";
        return result;
    }
}
