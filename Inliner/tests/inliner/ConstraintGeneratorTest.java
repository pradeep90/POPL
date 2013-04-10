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

public class ConstraintGeneratorTest{
    ConstraintGenerator constraintGenerator;
    
    @Before
    public void setUp(){
        constraintGenerator = new ConstraintGenerator();
    }
    
    @After
    public void tearDown(){
    }

    /**
     * Test method for {@link ConstraintGenerator#ThisExpression()}.
     */
    @Test
    public final void testThisExpression(){
        Node node = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/Factorial.java");
        node.accept(constraintGenerator);

        assertEquals(2, constraintGenerator.beginningConstraints.size());

        String expected = "[<BeginningConstraint: ____NewMainClass____, <FlowVar: ____NewMainClass____, ____Main____, new Fac ( )>>, <BeginningConstraint: Fac, <FlowVar: Fac, ComputeFac, this>>]";
        assertBigStringEquals(
            expected,
            constraintGenerator.beginningConstraints.toString());
    }

    /**
     * Test method for {@link ConstraintGenerator#AllocationExpression()}.
     */
    @Test
    public final void testAllocationExpression(){
        Node node = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/Factorial.java");

        node.accept(constraintGenerator);

        assertEquals(2, constraintGenerator.beginningConstraints.size());

        String expected = "[<BeginningConstraint: ____NewMainClass____, <FlowVar: ____NewMainClass____, ____Main____, new Fac ( )>>, <BeginningConstraint: Fac, <FlowVar: Fac, ComputeFac, this>>]";
        assertBigStringEquals(
            expected,
            constraintGenerator.beginningConstraints.toString());
    }

    /**
     * Test method for {@link ConstraintGenerator#AssignmentStatement()}.
     */
    @Test
    public final void testAssignmentStatement(){
        Node node = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/Factorial.java");

        node.accept(constraintGenerator);

        assertEquals(10, constraintGenerator.propagationConstraints.size());

        String expected = "[<PropagationConstraint: <FlowVar: ____NewMainClass____, ____Main____, ___tmp6>, <FlowVar: ____NewMainClass____, ____Main____, new Fac ( )>>, <PropagationConstraint: <FlowVar: Fac, ComputeFac, ___tmp4>, <FlowVar: Fac, ComputeFac, this>>, <PropagationConstraint: <FlowVar: Fac, ComputeFac, num_aux>, <FlowVar: Fac, ComputeFac, 1>>, <PropagationConstraint: <FlowVar: ____NewMainClass____, ____Main____, ____printMe____>, <FlowVar: ____NewMainClass____, ____Main____, ___tmp5>>, <PropagationConstraint: <FlowVar: ____NewMainClass____, ____Main____, ___tmp5>, <FlowVar: ____NewMainClass____, ____Main____, ___tmp6 . ____1234ComputeFac4321____>>, <PropagationConstraint: <FlowVar: Fac, ComputeFac, num_aux>, <FlowVar: Fac, ComputeFac, ____writeable____num * ____tmp0>>, <PropagationConstraint: <FlowVar: Fac, ComputeFac, ____1234ComputeFac4321____>, <FlowVar: Fac, ComputeFac, num_aux>>, <PropagationConstraint: <FlowVar: Fac, ComputeFac, ____tmp0>, <FlowVar: Fac, ComputeFac, ___tmp3>>, <PropagationConstraint: <FlowVar: Fac, ComputeFac, ___tmp3>, <FlowVar: Fac, ComputeFac, ___tmp4 . ____1234ComputeFac4321____>>, <PropagationConstraint: <FlowVar: Fac, ComputeFac, ____writeable____num>, <FlowVar: Fac, ComputeFac, num>>]";
        assertBigStringEquals(
            expected,
            constraintGenerator.propagationConstraints.toString());
    }

    /**
     * Test method for {@link ConstraintGenerator#MessageSendStatement()}.
     */
    @Test
    public final void testMessageSendStatement(){
        Node node = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/Factorial.java");

        node.accept(constraintGenerator);
        // System.out.println("constraintGenerator.conditionalConstraints: " + constraintGenerator.conditionalConstraints);

        String expected = "[<ConditionalConstraint: Fac, <FlowVar: Fac, ComputeFac, ___tmp4>, <FlowVar: Fac, ComputeFac, ____writeable____num - 1>, <FlowVar: Fac, ComputeFac, num>>, <ConditionalConstraint: Fac, <FlowVar: ____NewMainClass____, ____Main____, ___tmp6>, <FlowVar: ____NewMainClass____, ____Main____, 10>, <FlowVar: Fac, ComputeFac, num>>]";
        assertBigStringEquals(expected,
                              constraintGenerator.conditionalConstraints.toString());
    }
}
