import syntaxtree.*;
import visitor.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TermAutomatonCreatorTest{
    Node root0;
    TermAutomatonCreator termAutomatonCreator;

    @Before
    public void setUp(){
        root0 = InterfaceHelper.getInterfaceNodeFromFile(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Structural-Subtyping/Example-Interfaces/pub0.java");

        termAutomatonCreator = new TermAutomatonCreator();
    }
    
    @After
    public void tearDown(){
    }
    
    /**
     * Test method for {@link TermAutomatonCreator#Goal()}.
     */
    @Test
    public final void testGoal(){
        Node root = InterfaceHelper.getInterfaceNodeFromFile(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Structural-Subtyping/Example-Interfaces/pub0.java");
        root.accept(new TermAutomatonCreator(), null);
    }

    @Test
    public final void testSimpleInterfaceType(){
        root0.accept(termAutomatonCreator, null);

        TermAutomaton automatonA =
                termAutomatonCreator.partialAutomatonHashTable.get("A");
        TermAutomaton automatonB =
                termAutomatonCreator.partialAutomatonHashTable.get("B");

        TermAutomaton expectedAutomatonA = new TermAutomaton();
        expectedAutomatonA.inputAlphabet.add(new Symbol("a"));
        expectedAutomatonA.inputAlphabet.add(new Symbol("b"));
        expectedAutomatonA.inputAlphabet.add(new Symbol("c"));

        State interfaceStateA = new State(State.INTERFACE_LABEL,
                                          "A", "A");
        expectedAutomatonA.startState = interfaceStateA;

        State aMethodState = new State("->", "a", "A");
        State bMethodState = new State("->", "b", "A");
        State cMethodState = new State("->", "c", "A");

        expectedAutomatonA.states.add(new State(State.INT_LABEL,
                                                State.INT_LABEL,
                                                "A"));
        expectedAutomatonA.states.add(interfaceStateA);

        expectedAutomatonA.states.add(aMethodState);
        expectedAutomatonA.states.add(bMethodState);
        expectedAutomatonA.states.add(cMethodState);

        expectedAutomatonA.addMethodTypeEdge(aMethodState, new State(State.INT_LABEL,
                                                                     State.INT_LABEL,
                                                                     "A"), 0);
        expectedAutomatonA.addMethodTypeEdge(aMethodState, new State(State.INT_LABEL,
                                                                     State.INT_LABEL,
                                                                     "A"), 1);

        expectedAutomatonA.addMethodTypeEdge(bMethodState, new State(State.INT_LABEL,
                                                                     State.INT_LABEL,
                                                                     "A"), 0);
        expectedAutomatonA.addMethodTypeEdge(bMethodState, new State(State.INT_LABEL,
                                                                     State.INT_LABEL,
                                                                     "A"), 1);

        expectedAutomatonA.addMethodTypeEdge(cMethodState, new State(State.INT_LABEL,
                                                                     State.INT_LABEL,
                                                                     "A"), 0);
        expectedAutomatonA.addMethodTypeEdge(cMethodState, new State(State.INT_LABEL,
                                                                     State.INT_LABEL,
                                                                     "A"), 1);

        expectedAutomatonA.addEdge(interfaceStateA,
                                   aMethodState, new Symbol("a"));
        expectedAutomatonA.addEdge(interfaceStateA,
                                   bMethodState, new Symbol("b"));
        expectedAutomatonA.addEdge(interfaceStateA,
                                   cMethodState, new Symbol("c"));

        TermAutomaton expectedAutomatonB = new TermAutomaton();
        expectedAutomatonB.inputAlphabet.add(new Symbol("x"));
        expectedAutomatonB.inputAlphabet.add(new Symbol("y"));

        State interfaceStateB = new State(State.INTERFACE_LABEL,
                                          "B", "B");
        expectedAutomatonB.startState = interfaceStateB;

        State xMethodState = new State("->", "x", "B");
        State yMethodState = new State("->", "y", "B");

        expectedAutomatonB.states.add(new State(State.INT_LABEL,
                                                State.INT_LABEL,
                                                "B"));
        expectedAutomatonB.states.add(interfaceStateB);

        expectedAutomatonB.states.add(xMethodState);
        expectedAutomatonB.states.add(yMethodState);

        expectedAutomatonB.addMethodTypeEdge(xMethodState, new State(State.INT_LABEL,
                                                                     State.INT_LABEL,
                                                                     "B"), 0);
        expectedAutomatonB.addMethodTypeEdge(xMethodState, new State(State.INT_LABEL,
                                                                     State.INT_LABEL,
                                                                     "B"), 1);

        expectedAutomatonB.addMethodTypeEdge(yMethodState, new State(State.INT_LABEL,
                                                                     State.INT_LABEL,
                                                                     "B"), 0);
        expectedAutomatonB.addMethodTypeEdge(yMethodState, new State(State.INT_LABEL,
                                                                     State.INT_LABEL,
                                                                     "B"), 1);

        expectedAutomatonB.addEdge(interfaceStateB,
                                   xMethodState, new Symbol("x"));
        expectedAutomatonB.addEdge(interfaceStateB,
                                   yMethodState, new Symbol("y"));
        
        assertEquals(expectedAutomatonA, automatonA);
        assertEquals(expectedAutomatonB, automatonB);
    }

    @Test
    public final void testSelfRecursiveInterfaceType(){
        Node root = InterfaceHelper.getInterfaceNodeFromFile(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Structural-Subtyping/Example-Interfaces/pub1.java");

        root.accept(termAutomatonCreator, null);

        TermAutomaton automatonA =
                termAutomatonCreator.partialAutomatonHashTable.get("A");
        TermAutomaton automatonB =
                termAutomatonCreator.partialAutomatonHashTable.get("B");

        TermAutomaton expectedAutomatonA = new TermAutomaton();
        expectedAutomatonA.inputAlphabet.add(new Symbol("m"));

        State interfaceStateA = new State(State.INTERFACE_LABEL,
                                          "A", "A");
        expectedAutomatonA.startState = interfaceStateA;

        State mMethodState = new State("->", "m", "A");

        expectedAutomatonA.states.add(new State(State.INT_LABEL,
                                                State.INT_LABEL,
                                                "A"));
        expectedAutomatonA.states.add(interfaceStateA);

        expectedAutomatonA.states.add(mMethodState);

        TermAutomaton testAutomatonA = new TermAutomaton();

        testAutomatonA.addMethodTypeEdge(mMethodState, new State(State.INT_LABEL,
                                                                 State.INT_LABEL,
                                                                 "A"), 0);
        testAutomatonA.addMethodTypeEdge(mMethodState, interfaceStateA, 1);
        testAutomatonA.addEdge(interfaceStateA,
                               mMethodState, new Symbol("m"));

        expectedAutomatonA.addMethodTypeEdge(mMethodState, new State(State.INT_LABEL,
                                                                     State.INT_LABEL,
                                                                     "A"), 0);
        expectedAutomatonA.addMethodTypeEdge(mMethodState, interfaceStateA, 1);

        expectedAutomatonA.addEdge(interfaceStateA,
                                   mMethodState, new Symbol("m"));

        assertEquals(testAutomatonA.deltaAdjacencyList, expectedAutomatonA.deltaAdjacencyList);

        TermAutomaton expectedAutomatonB = new TermAutomaton();
        expectedAutomatonB.inputAlphabet.add(new Symbol("m"));
        expectedAutomatonB.inputAlphabet.add(new Symbol("p"));

        State interfaceStateB = new State(State.INTERFACE_LABEL,
                                          "B", "B");
        expectedAutomatonB.startState = interfaceStateB;

        State mMethodStateB = new State("->", "m", "B");
        State pMethodState = new State("->", "p", "B");

        expectedAutomatonB.states.add(new State(State.INT_LABEL,
                                                State.INT_LABEL,
                                                "B"));
        expectedAutomatonB.states.add(new State(State.VOID_LABEL,
                                                State.VOID_LABEL,
                                                "B"));
        expectedAutomatonB.states.add(new State(State.BOOL_LABEL,
                                                State.BOOL_LABEL,
                                                "B"));
        expectedAutomatonB.states.add(interfaceStateB);

        expectedAutomatonB.states.add(mMethodStateB);
        expectedAutomatonB.states.add(pMethodState);

        expectedAutomatonB.addMethodTypeEdge(mMethodStateB, new State(State.INT_LABEL,
                                                                      State.INT_LABEL,
                                                                      "B"), 0);
        expectedAutomatonB.addMethodTypeEdge(mMethodStateB, interfaceStateB, 1);

        expectedAutomatonB.addMethodTypeEdge(pMethodState, new State(State.BOOL_LABEL,
                                                                     State.BOOL_LABEL,
                                                                     "B"), 0);
        expectedAutomatonB.addMethodTypeEdge(pMethodState, new State(State.VOID_LABEL,
                                                                     State.VOID_LABEL,
                                                                     "B"), 1);

        expectedAutomatonB.addEdge(interfaceStateB,
                                   mMethodStateB, new Symbol("m"));
        expectedAutomatonB.addEdge(interfaceStateB,
                                   pMethodState, new Symbol("p"));
        
        assertEquals(expectedAutomatonA, automatonA);
        assertEquals(expectedAutomatonB, automatonB);
    }

    @Test
    public final void testMutuallyRecursiveInterfaceType(){
        Node root = InterfaceHelper.getInterfaceNodeFromFile(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Structural-Subtyping/Example-Interfaces/pub4.java");

        root.accept(termAutomatonCreator, null);

        TermAutomaton automatonA =
                termAutomatonCreator.partialAutomatonHashTable.get("A");
        TermAutomaton automatonB =
                termAutomatonCreator.partialAutomatonHashTable.get("B");

        TermAutomaton expectedAutomatonA = new TermAutomaton();
        expectedAutomatonA.inputAlphabet.add(new Symbol("m"));

        State interfaceStateA = new State(State.INTERFACE_LABEL,
                                          "A", "A");
        State interfaceStateBInA = new State(State.INTERFACE_LABEL,
                                             "B", "A");
        expectedAutomatonA.startState = interfaceStateA;

        State mMethodState = new State("->", "m", "A");

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

        TermAutomaton expectedAutomatonB = new TermAutomaton();

        State interfaceStateAInB = new State(State.INTERFACE_LABEL,
                                             "A", "B");
        State interfaceStateB = new State(State.INTERFACE_LABEL,
                                          "B", "B");
        expectedAutomatonB.inputAlphabet.add(new Symbol("m"));
        expectedAutomatonB.startState = interfaceStateB;

        State mMethodStateB = new State("->", "m", "B");

        expectedAutomatonB.states.add(new State(State.VOID_LABEL,
                                                State.VOID_LABEL,
                                                "B"));
        expectedAutomatonB.states.add(interfaceStateAInB);
        expectedAutomatonB.states.add(interfaceStateB);

        expectedAutomatonB.states.add(mMethodStateB);
        
        expectedAutomatonB.addMethodTypeEdge(mMethodStateB, new State(State.VOID_LABEL,
                                                                      State.VOID_LABEL,
                                                                      "B"), 1);
        expectedAutomatonB.addMethodTypeEdge(mMethodStateB, interfaceStateAInB, 0);

        expectedAutomatonB.addEdge(interfaceStateB,
                                   mMethodStateB, new Symbol("m"));
        
        assertEquals(expectedAutomatonA, automatonA);
        assertEquals(expectedAutomatonB, automatonB);
    }

    @Test
    public final void testPub0(){
        Node root = InterfaceHelper.getInterfaceNodeFromFile(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Structural-Subtyping/Example-Interfaces/pub0.java");

        root.accept(termAutomatonCreator, null);

        // System.out.println("pub0: " + termAutomatonCreator.finalAutomatonHashTable);
    }

    @Test
    public final void testPub1(){
        Node root = InterfaceHelper.getInterfaceNodeFromFile(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Structural-Subtyping/Example-Interfaces/pub1.java");

        root.accept(termAutomatonCreator, null);

        // System.out.println("pub1: " + termAutomatonCreator.finalAutomatonHashTable);
    }

    @Test
    public final void testPub2(){
        Node root = InterfaceHelper.getInterfaceNodeFromFile(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Structural-Subtyping/Example-Interfaces/pub2.java");

        root.accept(termAutomatonCreator, null);

        // System.out.println("pub2: " + termAutomatonCreator.finalAutomatonHashTable);
    }
    @Test
    public final void testPub3(){
        Node root = InterfaceHelper.getInterfaceNodeFromFile(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Structural-Subtyping/Example-Interfaces/pub3.java");

        root.accept(termAutomatonCreator, null);

        // System.out.println("pub3: " + termAutomatonCreator.finalAutomatonHashTable);
    }
    @Test
    public final void testPub4(){
        Node root = InterfaceHelper.getInterfaceNodeFromFile(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Structural-Subtyping/Example-Interfaces/pub4.java");

        root.accept(termAutomatonCreator, null);

        // System.out.println("pub4: " + termAutomatonCreator.finalAutomatonHashTable);
    }
}
