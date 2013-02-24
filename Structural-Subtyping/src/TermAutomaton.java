import java.util.List;
import java.util.Map;


public class TermAutomaton {
    List<Symbol> inputAlphabet;
    List<State> states;
    State startState;
    // Not really needed
    State finalState;
    Map<State, Map<Symbol, State> > deltaAdjacencyList; 
    
    public TermAutomaton() {
        
    }

    public TermAutomaton(List<Symbol> inputAlphabet,
                         List<State> states,
                         State startState,
                         State finalState,
                         Map<State, Map<Symbol, State> > deltaAdjacencyList) {
        
    }
}

