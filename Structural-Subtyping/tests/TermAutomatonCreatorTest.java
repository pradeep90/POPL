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
    State arrowState;

    @Before
    public void setUp(){
        root0 = InterfaceHelper.getInterfaceNodeFromFile(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Structural-Subtyping/Example-Interfaces/pub0.java");

        termAutomatonCreator = new TermAutomatonCreator();
        arrowState = new State("->", "temp");
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
        System.out.println("InterfaceHelper.getFormattedString(root): " + InterfaceHelper.getFormattedString(root));
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

        State interfaceStateA = new State(TermAutomaton.INTERFACE_LABEL, "A");
        expectedAutomatonA.startState = interfaceStateA;

        State aMethodState = new State("->", "a");
        State bMethodState = new State("->", "b");
        State cMethodState = new State("->", "c");

        expectedAutomatonA.states.add(TermAutomaton.INT_STATE);
        expectedAutomatonA.states.add(interfaceStateA);

        expectedAutomatonA.states.add(aMethodState);
        expectedAutomatonA.states.add(bMethodState);
        expectedAutomatonA.states.add(cMethodState);

        expectedAutomatonA.addMethodTypeEdge(aMethodState, TermAutomaton.INT_STATE, 0);
        expectedAutomatonA.addMethodTypeEdge(aMethodState, TermAutomaton.INT_STATE, 1);

        expectedAutomatonA.addMethodTypeEdge(bMethodState, TermAutomaton.INT_STATE, 0);
        expectedAutomatonA.addMethodTypeEdge(bMethodState, TermAutomaton.INT_STATE, 1);

        expectedAutomatonA.addMethodTypeEdge(cMethodState, TermAutomaton.INT_STATE, 0);
        expectedAutomatonA.addMethodTypeEdge(cMethodState, TermAutomaton.INT_STATE, 1);

        expectedAutomatonA.addEdge(interfaceStateA,
                                   aMethodState, new Symbol("a"));
        expectedAutomatonA.addEdge(interfaceStateA,
                                   bMethodState, new Symbol("b"));
        expectedAutomatonA.addEdge(interfaceStateA,
                                   cMethodState, new Symbol("c"));

        TermAutomaton expectedAutomatonB = new TermAutomaton();
        expectedAutomatonB.inputAlphabet.add(new Symbol("x"));
        expectedAutomatonB.inputAlphabet.add(new Symbol("y"));

        State interfaceStateB = new State(TermAutomaton.INTERFACE_LABEL, "B");
        expectedAutomatonB.startState = interfaceStateB;

        State xMethodState = new State("->", "x");
        State yMethodState = new State("->", "y");

        expectedAutomatonB.states.add(TermAutomaton.INT_STATE);
        expectedAutomatonB.states.add(interfaceStateB);

        expectedAutomatonB.states.add(xMethodState);
        expectedAutomatonB.states.add(yMethodState);

        expectedAutomatonB.addMethodTypeEdge(xMethodState, TermAutomaton.INT_STATE, 0);
        expectedAutomatonB.addMethodTypeEdge(xMethodState, TermAutomaton.INT_STATE, 1);

        expectedAutomatonB.addMethodTypeEdge(yMethodState, TermAutomaton.INT_STATE, 0);
        expectedAutomatonB.addMethodTypeEdge(yMethodState, TermAutomaton.INT_STATE, 1);

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

        State interfaceStateA = new State(TermAutomaton.INTERFACE_LABEL, "A");
        expectedAutomatonA.startState = interfaceStateA;

        State mMethodState = new State("->", "m");

        expectedAutomatonA.states.add(TermAutomaton.INT_STATE);
        expectedAutomatonA.states.add(interfaceStateA);

        expectedAutomatonA.states.add(mMethodState);

        TermAutomaton testAutomatonA = new TermAutomaton();

        testAutomatonA.addMethodTypeEdge(mMethodState, TermAutomaton.INT_STATE, 0);
        testAutomatonA.addMethodTypeEdge(mMethodState, interfaceStateA, 1);
        testAutomatonA.addEdge(interfaceStateA,
                                   mMethodState, new Symbol("m"));

        expectedAutomatonA.addMethodTypeEdge(mMethodState, TermAutomaton.INT_STATE, 0);
        expectedAutomatonA.addMethodTypeEdge(mMethodState, interfaceStateA, 1);

        expectedAutomatonA.addEdge(interfaceStateA,
                                   mMethodState, new Symbol("m"));

        assertEquals(testAutomatonA.deltaAdjacencyList, expectedAutomatonA.deltaAdjacencyList);

        TermAutomaton expectedAutomatonB = new TermAutomaton();
        expectedAutomatonB.inputAlphabet.add(new Symbol("m"));
        expectedAutomatonB.inputAlphabet.add(new Symbol("p"));

        State interfaceStateB = new State(TermAutomaton.INTERFACE_LABEL, "B");
        expectedAutomatonB.startState = interfaceStateB;

        State mMethodStateB = new State("->", "m");
        State pMethodState = new State("->", "p");

        expectedAutomatonB.states.add(TermAutomaton.INT_STATE);
        expectedAutomatonB.states.add(TermAutomaton.VOID_STATE);
        expectedAutomatonB.states.add(TermAutomaton.BOOL_STATE);
        expectedAutomatonB.states.add(interfaceStateB);

        expectedAutomatonB.states.add(mMethodStateB);
        expectedAutomatonB.states.add(pMethodState);

        expectedAutomatonB.addMethodTypeEdge(mMethodStateB, TermAutomaton.INT_STATE, 0);
        expectedAutomatonB.addMethodTypeEdge(mMethodStateB, interfaceStateB, 1);

        expectedAutomatonB.addMethodTypeEdge(pMethodState, TermAutomaton.BOOL_STATE, 0);
        expectedAutomatonB.addMethodTypeEdge(pMethodState, TermAutomaton.VOID_STATE, 1);

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

        State interfaceStateA = new State(TermAutomaton.INTERFACE_LABEL, "A");
        State interfaceStateB = new State(TermAutomaton.INTERFACE_LABEL, "B");
        expectedAutomatonA.startState = interfaceStateA;

        State mMethodState = new State("->", "m");

        expectedAutomatonA.states.add(TermAutomaton.INT_STATE);
        expectedAutomatonA.states.add(interfaceStateA);
        expectedAutomatonA.states.add(interfaceStateB);

        expectedAutomatonA.states.add(mMethodState);

        expectedAutomatonA.addMethodTypeEdge(mMethodState, interfaceStateB, 0);
        expectedAutomatonA.addMethodTypeEdge(mMethodState, TermAutomaton.INT_STATE, 1);

        expectedAutomatonA.addEdge(interfaceStateA,
                                   mMethodState, new Symbol("m"));

        TermAutomaton expectedAutomatonB = new TermAutomaton();
        expectedAutomatonB.inputAlphabet.add(new Symbol("m"));
        expectedAutomatonB.startState = interfaceStateB;

        State mMethodStateB = new State("->", "m");

        expectedAutomatonB.states.add(TermAutomaton.VOID_STATE);
        expectedAutomatonB.states.add(interfaceStateA);
        expectedAutomatonB.states.add(interfaceStateB);

        expectedAutomatonB.states.add(mMethodStateB);

        expectedAutomatonB.addMethodTypeEdge(mMethodStateB, TermAutomaton.VOID_STATE, 1);
        expectedAutomatonB.addMethodTypeEdge(mMethodStateB, interfaceStateA, 0);

        expectedAutomatonB.addEdge(interfaceStateB,
                                   mMethodStateB, new Symbol("m"));
        
        assertEquals(expectedAutomatonA, automatonA);
        assertEquals(expectedAutomatonB, automatonB);
    }
}
