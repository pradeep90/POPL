package inliner;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;
import inliner.syntaxtree.*;
import static inliner.InlinerHelperTest.assertEqualMicroJavaNodes;
import static inliner.InlinerHelperTest.assertBigStringEquals;

public class SolverTest{
    ConstraintGenerator constraintGenerator;
    Solver solver;
    
    @Before
    public void setUp(){
        constraintGenerator = new ConstraintGenerator();
        solver = new Solver();
    }
    
    @After
    public void tearDown(){
    }

    /**
     * Test method for {@link Solver#Foo()}.
     */
    @Test
    public final void testFoo(){
    }

    /**
     * Test method for {@link Solver#getClassNames()}.
     */
    @Test
    public final void testGetClassNames_Simple(){
        Node node = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/Factorial.java");

        node.accept(constraintGenerator);

        solver.beginningConstraints = new ArrayList<BeginningConstraint>(
            constraintGenerator.beginningConstraints);
        solver.conditionalConstraints = new ArrayList<ConditionalConstraint>(
            constraintGenerator.conditionalConstraints);
        assertBigStringEquals("[Fac]",
                              solver.getClassNames().toString());
    }

    /**
     * Test method for {@link Solver#getClassNames()}.
     */
    @Test
    public final void testGetClassNames_SubClass(){
        Node node = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/TreeVisitor.java");

        node.accept(constraintGenerator);

        solver.beginningConstraints = new ArrayList<BeginningConstraint>(
            constraintGenerator.beginningConstraints);
        solver.conditionalConstraints = new ArrayList<ConditionalConstraint>(
            constraintGenerator.conditionalConstraints);
        String expected = "[Visitor, Tree, MyVisitor, TV]";
        assertBigStringEquals(expected,
                              solver.getClassNames().toString());
    }

    /**
     * Test method for {@link Solver#getFlowVars()}.
     */
    @Test
    public final void testGetFlowVars_Simple(){
        Node node = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/Factorial.java");

        node.accept(constraintGenerator);

        solver.beginningConstraints = new ArrayList<BeginningConstraint>(
            constraintGenerator.beginningConstraints);
        solver.propagationConstraints = new ArrayList<PropagationConstraint>(
            constraintGenerator.propagationConstraints);
        solver.conditionalConstraints = new ArrayList<ConditionalConstraint>(
            constraintGenerator.conditionalConstraints);
        // System.out.println("solver.getFlowVars().toString(): " + solver.getFlowVars().toString());
        String expected = "[<FlowVar: ____NewMainClass____, ____Main____, ____printMe____>, <FlowVar: Fac, ComputeFac, ____tmp0>, <FlowVar: ____NewMainClass____, ____Main____, ___tmp6 . ____1234ComputeFac4321____>, <FlowVar: Fac, ComputeFac, num>, <FlowVar: ____NewMainClass____, ____Main____, ___tmp6>, <FlowVar: Fac, ComputeFac, ____1234ComputeFac4321____>, <FlowVar: ____NewMainClass____, ____Main____, ___tmp5>, <FlowVar: Fac, ComputeFac, ____writeable____num>, <FlowVar: ____NewMainClass____, ____Main____, 10>, <FlowVar: Fac, ComputeFac, this>, <FlowVar: Fac, ComputeFac, ____writeable____num - 1>, <FlowVar: Fac, ComputeFac, ___tmp4 . ____1234ComputeFac4321____>, <FlowVar: ____NewMainClass____, ____Main____, new Fac ( )>, <FlowVar: Fac, ComputeFac, ___tmp3>, <FlowVar: Fac, ComputeFac, ___tmp4>, <FlowVar: Fac, ComputeFac, num_aux>, <FlowVar: Fac, ComputeFac, ____writeable____num * ____tmp0>, <FlowVar: Fac, ComputeFac, 1>]";
        assertBigStringEquals(expected,
                              solver.getFlowVars().toString());
    }

    /**
     * Test method for {@link Solver#getClassIndexMap()}.
     */
    @Test
    public final void testGetClassIndexMap(){
        HashMap<String, Integer> expected = new HashMap<String, Integer>();
        expected.put("foo", 0);
        expected.put("bar", 1);
        
        assertEquals(expected,
                     Solver.getClassIndexMap(Arrays.<String>asList("foo", "bar")));
    }

    /**
     * Test method for {@link Solver#Example1()}.
     */
    @Test
    public final void testExample1(){
        Node node = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/My-Basic-Test-Cases/SlidesExample1.java");

        node.accept(constraintGenerator);

        Solver solver = new Solver(constraintGenerator.beginningConstraints,
                                   constraintGenerator.propagationConstraints,
                                   constraintGenerator.conditionalConstraints);

        solver.computeFlowSets();
        String expected = "{<FlowVar: ____NewMainClass____, ____Main____, x>=[A], <FlowVar: ____NewMainClass____, ____Main____, ____printMe____>=[], <FlowVar: ____NewMainClass____, ____Main____, y>=[B], <FlowVar: ____NewMainClass____, ____Main____, new B ( )>=[B], <FlowVar: ____NewMainClass____, ____Main____, new A ( )>=[A], <FlowVar: A, m, arg>=[Q], <FlowVar: ____NewMainClass____, ____Main____, new Q ( )>=[Q], <FlowVar: B, m, arg>=[S], <FlowVar: ____NewMainClass____, ____Main____, 5>=[], <FlowVar: ____NewMainClass____, ____Main____, new S ( )>=[S]}";
        assertBigStringEquals(expected,
                              solver.flowSetMap.toString());
    }

    /**
     * Test method for {@link Solver#Factorial()}.
     */
    @Test
    public final void testFactorial(){
        Node node = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/Factorial.java");

        node.accept(constraintGenerator);

        Solver solver = new Solver(constraintGenerator.beginningConstraints,
                                   constraintGenerator.propagationConstraints,
                                   constraintGenerator.conditionalConstraints);

        solver.computeFlowSets();
        String expected = "{<FlowVar: ____NewMainClass____, ____Main____, ____printMe____>=[], <FlowVar: Fac, ComputeFac, ____tmp0>=[], <FlowVar: ____NewMainClass____, ____Main____, ___tmp6 . ____1234ComputeFac4321____>=[], <FlowVar: Fac, ComputeFac, num>=[], <FlowVar: ____NewMainClass____, ____Main____, ___tmp6>=[Fac], <FlowVar: Fac, ComputeFac, ____1234ComputeFac4321____>=[], <FlowVar: ____NewMainClass____, ____Main____, ___tmp5>=[], <FlowVar: Fac, ComputeFac, ____writeable____num>=[], <FlowVar: ____NewMainClass____, ____Main____, 10>=[], <FlowVar: Fac, ComputeFac, this>=[Fac], <FlowVar: Fac, ComputeFac, ____writeable____num - 1>=[], <FlowVar: Fac, ComputeFac, ___tmp3>=[], <FlowVar: Fac, ComputeFac, ___tmp4 . ____1234ComputeFac4321____>=[], <FlowVar: ____NewMainClass____, ____Main____, new Fac ( )>=[Fac], <FlowVar: Fac, ComputeFac, ___tmp4>=[Fac], <FlowVar: Fac, ComputeFac, num_aux>=[], <FlowVar: Fac, ComputeFac, ____writeable____num * ____tmp0>=[], <FlowVar: Fac, ComputeFac, 1>=[]}";
        assertBigStringEquals(expected,
                              solver.flowSetMap.toString());
    }
}
