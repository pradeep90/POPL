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
            "/home/spradeep/Dropbox/Acads/POPL/Code/Structural-Subtyping/Example-Interfaces/pub0.java");

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
            "/home/spradeep/Dropbox/Acads/POPL/Code/Structural-Subtyping/Example-Interfaces/pub0.java");
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

        State interfaceStateA = new State("interface", "A");

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

        State interfaceStateB = new State("interface", "B");

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
        
        // assertEquals(expectedAutomatonA, automatonA);
        // assertEquals(expectedAutomatonB, automatonB);
    }

    // @Test
    // public final void testSelfRecursiveInterfaceType(){

    //     Node root = InterfaceHelper.getInterfaceNodeFromFile(
    //         "/home/spradeep/Dropbox/Acads/POPL/Code/Structural-Subtyping/Example-Interfaces/pub1.java");

    //     root.accept(termAutomatonCreator, null);

    //     TermAutomaton automatonA =
    //             termAutomatonCreator.partialAutomatonHashTable.get("A");
    //     TermAutomaton automatonB =
    //             termAutomatonCreator.partialAutomatonHashTable.get("B");

    //     TermAutomaton expectedAutomatonA = new TermAutomaton();
    //     expectedAutomatonA.inputAlphabet.add(new Symbol("m"));

    //     expectedAutomatonA.states.add(TermAutomaton.INT_STATE);
    //     expectedAutomatonA.states.add(TermAutomaton.INTERFACE_STATE);
    //     expectedAutomatonA.states.add(TermAutomaton.ARROW_STATE);
    //     // expectedAutomatonA.states.add(new State("A"));

    //     expectedAutomatonA.addMethodTypeEdge(TermAutomaton.INT_STATE, 0);
    //     expectedAutomatonA.addMethodTypeEdge(new State("A"), 1);

    //     expectedAutomatonA.addEdge(TermAutomaton.INTERFACE_STATE, TermAutomaton.ARROW_STATE, new Symbol("m"));
        
    //     TermAutomaton expectedAutomatonB = new TermAutomaton();
    //     expectedAutomatonB.inputAlphabet.add(new Symbol("m"));
    //     expectedAutomatonB.inputAlphabet.add(new Symbol("p"));

    //     expectedAutomatonB.states.add(TermAutomaton.INT_STATE);
    //     expectedAutomatonB.states.add(TermAutomaton.VOID_STATE);
    //     expectedAutomatonB.states.add(TermAutomaton.BOOL_STATE);
    //     expectedAutomatonB.states.add(TermAutomaton.INTERFACE_STATE);
    //     expectedAutomatonB.states.add(TermAutomaton.ARROW_STATE);
    //     // expectedAutomatonB.states.add(new State("B"));

    //     expectedAutomatonB.addMethodTypeEdge(TermAutomaton.INT_STATE, 0);
    //     expectedAutomatonB.addMethodTypeEdge(new State("B"), 1);
    //     expectedAutomatonB.addMethodTypeEdge(TermAutomaton.BOOL_STATE, 0);
    //     expectedAutomatonB.addMethodTypeEdge(TermAutomaton.VOID_STATE, 1);

    //     expectedAutomatonB.addEdge(TermAutomaton.INTERFACE_STATE, TermAutomaton.ARROW_STATE, new Symbol("m"));
    //     expectedAutomatonB.addEdge(TermAutomaton.INTERFACE_STATE, TermAutomaton.ARROW_STATE, new Symbol("p"));

    //     assertEquals(expectedAutomatonA, automatonA);
    //     assertEquals(expectedAutomatonB, automatonB);
    // }

    // @Test
    // public final void testMutuallyRecursiveInterfaceType(){

    //     Node root = InterfaceHelper.getInterfaceNodeFromFile(
    //         "/home/spradeep/Dropbox/Acads/POPL/Code/Structural-Subtyping/Example-Interfaces/pub4.java");

    //     root.accept(termAutomatonCreator, null);

    //     TermAutomaton automatonA =
    //             termAutomatonCreator.partialAutomatonHashTable.get("A");
    //     TermAutomaton automatonB =
    //             termAutomatonCreator.partialAutomatonHashTable.get("B");

    //     TermAutomaton expectedAutomatonA = new TermAutomaton();
    //     expectedAutomatonA.inputAlphabet.add(new Symbol("m"));

    //     expectedAutomatonA.states.add(TermAutomaton.INT_STATE);
    //     expectedAutomatonA.states.add(TermAutomaton.INTERFACE_STATE);
    //     expectedAutomatonA.states.add(TermAutomaton.ARROW_STATE);
    //     // expectedAutomatonA.states.add(new State("A"));

    //     expectedAutomatonA.addMethodTypeEdge(new State("B"), 0);
    //     expectedAutomatonA.addMethodTypeEdge(TermAutomaton.INT_STATE, 1);

    //     expectedAutomatonA.addEdge(TermAutomaton.INTERFACE_STATE, TermAutomaton.ARROW_STATE, new Symbol("m"));
        
    //     TermAutomaton expectedAutomatonB = new TermAutomaton();
    //     expectedAutomatonB.inputAlphabet.add(new Symbol("m"));

    //     // expectedAutomatonB.states.add(new State("B"));
    //     expectedAutomatonB.states.add(TermAutomaton.VOID_STATE);
    //     expectedAutomatonB.states.add(TermAutomaton.INTERFACE_STATE);
    //     expectedAutomatonB.states.add(TermAutomaton.ARROW_STATE);

    //     expectedAutomatonB.addMethodTypeEdge(new State("A"), 0);
    //     expectedAutomatonB.addMethodTypeEdge(TermAutomaton.VOID_STATE, 1);

    //     expectedAutomatonB.addEdge(TermAutomaton.INTERFACE_STATE, TermAutomaton.ARROW_STATE, new Symbol("m"));

    //     assertEquals(expectedAutomatonA, automatonA);
    //     assertEquals(expectedAutomatonB, automatonB);
    // }
}
