import java.util.HashMap;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TermAutomatonTest{
    TermAutomaton termAutomaton;
    State state0;
    State state1;
    State state2;
    State state3;
    State state4;

    Symbol symbol0;
    Symbol symbol1;

    @Before
    public void setUp(){
        termAutomaton = new TermAutomaton();
        state0 = new State("Int", "Int");
        state1 = new State("Bool", "Bool");
        state2 = new State("Void", "Void");
        state3 = new State("->", "temp");
        state4 = new State("Interface", "foo");

        symbol0 = new Symbol("0");
        symbol1 = new Symbol("1");
    }
    
    @After
    public void tearDown(){
    }

    @Test
    public final void testCopyConstructor(){
        TermAutomaton automatonA = new TermAutomaton();
        automatonA.inputAlphabet.add(new Symbol("m"));

        State interfaceStateA = new State(State.INTERFACE_LABEL,
                                          "A", "A");
        State interfaceStateBInA = new State(State.INTERFACE_LABEL,
                                             "B", "A");
        automatonA.startState = interfaceStateA;

        State mMethodState = new State("->", "m", "A");

        automatonA.states.add(new State(State.INT_LABEL,
                                        State.INT_LABEL,
                                        "A"));
        automatonA.states.add(interfaceStateA);
        automatonA.states.add(interfaceStateBInA);

        automatonA.states.add(mMethodState);

        automatonA.addMethodTypeEdge(mMethodState, interfaceStateBInA, 0);
        automatonA.addMethodTypeEdge(mMethodState, new State(State.INT_LABEL,
                                                             State.INT_LABEL,
                                                             "A"), 1);
        automatonA.addEdge(interfaceStateA,
                           mMethodState, new Symbol("m"));

        TermAutomaton copyAutomaton = new TermAutomaton(automatonA);
        assertEquals(copyAutomaton, automatonA);
        copyAutomaton.startState.name = "foo";
        assertFalse(copyAutomaton.equals(automatonA));
    }

    /**
     * Test method for {@link TermAutomaton#addEdge()}.
     */
    @Test
    public final void testAddEdge(){
        termAutomaton.addEdge(state0, state1, symbol0);

        HashMap<Symbol, State> expectedEdgeMap = new HashMap<Symbol, State>();
        expectedEdgeMap.put(symbol0, state1);

        HashMap<State, HashMap<Symbol, State>> expectedDeltaAdjacencyList =
                new HashMap<State, HashMap<Symbol, State>>();
        expectedDeltaAdjacencyList.put(state0, expectedEdgeMap);

        assertEquals(expectedDeltaAdjacencyList, termAutomaton.deltaAdjacencyList);
    }

    /**
     * Test method for {@link TermAutomaton#addMethodTypeEdge()}.
     */
    @Test
    public final void testAddMethodTypeEdge(){
        State interfaceState = new State("interface", "foo");

        TermAutomaton expectedAutomaton = new TermAutomaton();
        expectedAutomaton.startState = interfaceState;
        
        expectedAutomaton.addEdge(state3, state0, new Symbol("0"));

        termAutomaton.startState = interfaceState;
        termAutomaton.addMethodTypeEdge(state3, state0, 0);
        assertEquals(expectedAutomaton, termAutomaton);
    }

    @Test
    public final void testHashMapEquals(){
        HashMap<Symbol, State> edgeHashMap0 = new HashMap<Symbol, State>();
        HashMap<Symbol, State> edgeHashMap1 = new HashMap<Symbol, State>();
        edgeHashMap0.put(symbol0, state0);
        edgeHashMap1.put(symbol0, state0);

        assertEquals(edgeHashMap0, edgeHashMap1);

        HashMap<State, HashMap<Symbol, State>> adjacencyHash0 =
                new HashMap<State, HashMap<Symbol, State>>();
        adjacencyHash0.put(state3, edgeHashMap0);

        HashMap<State, HashMap<Symbol, State>> adjacencyHash1 =
                new HashMap<State, HashMap<Symbol, State>>();
        adjacencyHash1.put(state3, edgeHashMap0);

        assertEquals(adjacencyHash0, adjacencyHash1);
    }

    /**
     * Test method for {@link TermAutomaton#includeOtherAutomatonDefinition()}.
     */
    @Test
    public final void testIncludeOtherAutomatonDefinition(){
        TermAutomaton automatonA = new TermAutomaton();
        automatonA.inputAlphabet.add(new Symbol("m"));

        State interfaceStateA = new State(State.INTERFACE_LABEL,
                                          "A", "A");
        State interfaceStateBInA = new State(State.INTERFACE_LABEL,
                                             "B", "A");
        automatonA.startState = interfaceStateA;

        State mMethodState = new State("->", "m", "A");

        automatonA.states.add(new State(State.INT_LABEL,
                                                State.INT_LABEL,
                                                "A"));
        automatonA.states.add(interfaceStateA);
        automatonA.states.add(interfaceStateBInA);

        automatonA.states.add(mMethodState);

        automatonA.addMethodTypeEdge(mMethodState, interfaceStateBInA, 0);
        automatonA.addMethodTypeEdge(mMethodState, new State(State.INT_LABEL,
                                                                     State.INT_LABEL,
                                                                     "A"), 1);

        automatonA.addEdge(interfaceStateA,
                                   mMethodState, new Symbol("m"));

        TermAutomaton automatonB = new TermAutomaton();

        State interfaceStateAInB = new State(State.INTERFACE_LABEL,
                                             "A", "B");
        State interfaceStateB = new State(State.INTERFACE_LABEL,
                                          "B", "B");
        automatonB.inputAlphabet.add(new Symbol("m"));
        automatonB.startState = interfaceStateB;

        State mMethodStateB = new State("->", "m", "B");

        automatonB.states.add(new State(State.VOID_LABEL,
                                                State.VOID_LABEL,
                                                "B"));
        automatonB.states.add(interfaceStateAInB);
        automatonB.states.add(interfaceStateB);

        automatonB.states.add(mMethodStateB);
        
        automatonB.addMethodTypeEdge(mMethodStateB, new State(State.VOID_LABEL,
                                                                      State.VOID_LABEL,
                                                                      "B"), 1);
        automatonB.addMethodTypeEdge(mMethodStateB, interfaceStateAInB, 0);

        automatonB.addEdge(interfaceStateB,
                                   mMethodStateB, new Symbol("m"));

        System.out.println("automatonA: " + automatonA);
        System.out.println("automatonB: " + automatonB);

        automatonA.includeOtherAutomatonDefinition(automatonB);
        System.out.println("automatonA: " + automatonA);

        TermAutomaton expectedAutomatonA = new TermAutomaton();
        expectedAutomatonA.inputAlphabet.add(new Symbol("m"));
        expectedAutomatonA.startState = interfaceStateA;
        expectedAutomatonA.states.add(new State(State.INT_LABEL,
                                                State.INT_LABEL,
                                                "A"));
        expectedAutomatonA.states.add(interfaceStateA);
        expectedAutomatonA.states.add(interfaceStateBInA);

        expectedAutomatonA.states.add(mMethodState);

        expectedAutomatonA.addMethodTypeEdge(mMethodState, interfaceStateBInA, 0);
        expectedAutomatonA.addMethodTypeEdge(mMethodState, new State(State.INT_LABEL,
                                                                     State.INT_LABEL,
                                                                     "A"), 1);

        expectedAutomatonA.addEdge(interfaceStateA,
                                   mMethodState, new Symbol("m"));

        expectedAutomatonA.inputAlphabet.add(new Symbol("m"));
        expectedAutomatonA.states.add(new State(State.VOID_LABEL,
                                                State.VOID_LABEL,
                                                "B"));
        expectedAutomatonA.states.add(mMethodStateB);
        
        expectedAutomatonA.addMethodTypeEdge(mMethodStateB, new State(State.VOID_LABEL,
                                                                      State.VOID_LABEL,
                                                                      "B"), 1);
        expectedAutomatonA.addMethodTypeEdge(mMethodStateB, interfaceStateA, 0);

        expectedAutomatonA.addEdge(interfaceStateBInA,
                                   mMethodStateB, new Symbol("m"));

        assertEquals(expectedAutomatonA, automatonA);
    }
}
