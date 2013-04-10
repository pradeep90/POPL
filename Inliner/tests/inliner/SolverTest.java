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
        assertBigStringEquals("[Fac, ____NewMainClass____]",
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
        String expected = "[Visitor, Tree, MyVisitor, ____NewMainClass____, TV]";
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
        String expected = "[<FlowVar: ____NewMainClass____, ____Main____, ____printMe____>, <FlowVar: Fac, ComputeFac, ____tmp0>, <FlowVar: ____NewMainClass____, ____Main____, ___tmp6 . ____1234ComputeFac4321____>, <FlowVar: Fac, ComputeFac, num>, <FlowVar: ____NewMainClass____, ____Main____, ___tmp6>, <FlowVar: Fac, ComputeFac, ____1234ComputeFac4321____>, <FlowVar: Fac, ComputeFac, ____writeable____num>, <FlowVar: ____NewMainClass____, ____Main____, ___tmp5>, <FlowVar: ____NewMainClass____, ____Main____, 10>, <FlowVar: Fac, ComputeFac, this>, <FlowVar: Fac, ComputeFac, ____writeable____num - 1>, <FlowVar: Fac, ComputeFac, ___tmp4 . ____1234ComputeFac4321____>, <FlowVar: ____NewMainClass____, ____Main____, new Fac ( )>, <FlowVar: Fac, ComputeFac, ___tmp3>, <FlowVar: Fac, ComputeFac, ___tmp4>, <FlowVar: Fac, ComputeFac, num_aux>, <FlowVar: Fac, ComputeFac, ____writeable____num * ____tmp0>, <FlowVar: Fac, ComputeFac, 1>]";
        assertBigStringEquals(expected,
                              solver.getFlowVars().toString());
    }
}
