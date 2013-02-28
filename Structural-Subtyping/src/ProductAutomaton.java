/** 
 * Product of two Automata, A and B.
 *
 * We are trying to test whether A <= B.
 * i.e., B is assumed to be the super-class.
 */
public class ProductAutomaton extends Automaton<ProductState> {
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
            System.out.println("automatonB.getEdgeSymbols(stateB): " + automatonB.getEdgeSymbols(stateB));
            for (Symbol currSymbol : automatonB.getEdgeSymbols(stateB)){
                for (State stateA : automatonA.states){
                    if (!automatonA.hasNeighbour(stateA, currSymbol)){
                        continue;
                    }

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
     * If symbol is a method or 0, return 0. Else, 1.
     * 
     * @return parity of symbol.
     */
    public int getParity(Symbol symbol){
        if (symbol.name.equals("1")){
            return 1;
        }
        return 0;
    }
}
