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
        // TODO: 
        // termAutomaton.addMethodTypeEdge(state3, state0, 0);
        // TermAutomaton expectedAutomaton = new TermAutomaton();
        // expectedAutomaton.addEdge(state3, state0, new Symbol("0"));
        // assertEquals(expectedAutomaton, termAutomaton);
        // System.out.println("expectedAutomaton: " + expectedAutomaton);
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
}
