import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

/** 
 * Product of two Automata, A and B.
 *
 * We are trying to test whether A <= B.
 * i.e., B is assumed to be the super-class.
 */
public class ProductAutomaton extends Automaton<ProductState> {
    boolean obviouslyNotSubtype = false;
    
    public ProductAutomaton() {
        super();
    }

    public ProductAutomaton(TermAutomaton automatonA, TermAutomaton automatonB) {
        this();

        for (State stateB : automatonB.states){
            for (State stateA : automatonA.states){
                this.states.add(new ProductState(stateA, stateB, 0));
                this.states.add(new ProductState(stateA, stateB, 1));
            }
        }

        this.inputAlphabet = automatonB.inputAlphabet;

        this.startState = new ProductState(automatonA.startState, automatonB.startState, 0);
        
        for (State stateB : automatonB.states){
            for (Symbol currSymbol : automatonB.getEdgeSymbols(stateB)){
                for (State stateA : automatonA.states){
                    for(int parity = 0; parity <= 1; parity++){
                        ProductState targetState = new ProductState(
                            automatonA.getNeighbour(stateA, currSymbol),
                            automatonB.getNeighbour(stateB, currSymbol),
                            parity ^ getParity(currSymbol));
                        this.addEdge(new ProductState(stateA, stateB, parity),
                                     targetState,
                                     currSymbol);
                    }
                }
            }
        }
    }

    /** 
     * If symbol is a "method" or 1, return parity 0.
     * Else, parity 1.
     *
     * Reason: Even number of 0s => parity 0
     * 
     * @return parity of symbol.
     */
    public int getParity(Symbol symbol){
        if (symbol.name.equals("0")){
            return 1;
        }
        return 0;
    }

    /**
     * A <= B iff you cannot reach any final state.
     * 
     * @return true iff A <= B.
     */
    public boolean isSubtype(){
        if (obviouslyNotSubtype){
            return false;
        }

        return !searchFinalState(startState, new HashSet<ProductState>());
    }

    /**
     * If parity is 0 (covariant: A <= B), return neighbours along edges of stateB.
     * Else (contravariant: B <= A), return neighbours along edges of stateA.
     *
     * Note: neighbouring states along edge of stateA would just be
     * those that don't have NULL in the A position.
     * 
     * @param sourceState (stateA, stateB, parity)
     */
    public Collection<ProductState> getNeighboursBasedOnParity(ProductState sourceState){
        Collection<ProductState> allNeighbours = getNeighbours(sourceState);
        Collection<ProductState> parityBasedNeighbours = new ArrayList<ProductState>();
        for (ProductState neighbour : allNeighbours){
            State pertinentState =
                    sourceState.parity == 0? neighbour.stateB: neighbour.stateA;
            if (!pertinentState.isNullState()){
                parityBasedNeighbours.add(neighbour);
            }
        }
        return parityBasedNeighbours;
    }

    /** 
     * Do DFS on the ProductAutomaton to search for any "Final" states.
     * 
     * @return true iff a Final state was found.
     */
    public boolean searchFinalState(ProductState currState, Set<ProductState> seenStates){
        // Stop if you reach something like (Int, Bool) or (->, Void), etc.
        if (currState.isFinalState()){
            return true;
        }

        Collection<ProductState> neighbours = getNeighboursBasedOnParity(currState);

        for (ProductState neighbour : neighbours){
            if (seenStates.contains(neighbour)){
                continue;
            }
            seenStates.add(neighbour);

            if (searchFinalState(neighbour, seenStates)){
                return true;
            }
        }
        return false;
    }
}
