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
import static inliner.InlinerHelperTest.assertBigStringNotEquals;

public class ConstraintGeneratorTest{
    ConstraintGenerator constraintGenerator = new ConstraintGenerator();

    @Before
    public void setUp(){
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

        String expected = "[<BeginningConstraint: Fac, <FlowVar: ____NewMainClass____, ____Main____, new Fac ( )>>, <BeginningConstraint: Fac, <FlowVar: Fac, ComputeFac, this>>]";
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

        String expected = "[<BeginningConstraint: Fac, <FlowVar: ____NewMainClass____, ____Main____, new Fac ( )>>, <BeginningConstraint: Fac, <FlowVar: Fac, ComputeFac, this>>]";
        assertBigStringEquals(
            expected,
            constraintGenerator.beginningConstraints.toString());
    }

    /**
     * Test method for {@link ConstraintGenerator#AssignmentStatement()}.
     */
    @Test
    public final void testAssignmentStatement_Bug(){
        Node node = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/Factorial.java");

        node.accept(constraintGenerator);

        assertEquals(10, constraintGenerator.propagationConstraints.size());

        // System.out.println("constraintGenerator.propagationConstraints.toString(): " + constraintGenerator.propagationConstraints.toString());

        String expected = "[<PropagationConstraint: <FlowVar: ____NewMainClass____, ____Main____, ___tmp6 . ____1234ComputeFac4321____>, <FlowVar: ____NewMainClass____, ____Main____, ___tmp5>>, <PropagationConstraint: <FlowVar: Fac, ComputeFac, 1>, <FlowVar: Fac, ComputeFac, num_aux>>, <PropagationConstraint: <FlowVar: Fac, ComputeFac, num>, <FlowVar: Fac, ComputeFac, ____writeable____num>>, <PropagationConstraint: <FlowVar: Fac, ComputeFac, ____writeable____num * ____tmp0>, <FlowVar: Fac, ComputeFac, num_aux>>, <PropagationConstraint: <FlowVar: ____NewMainClass____, ____Main____, new Fac ( )>, <FlowVar: ____NewMainClass____, ____Main____, ___tmp6>>, <PropagationConstraint: <FlowVar: Fac, ComputeFac, ___tmp3>, <FlowVar: Fac, ComputeFac, ____tmp0>>, <PropagationConstraint: <FlowVar: Fac, ComputeFac, num_aux>, <FlowVar: Fac, ComputeFac, ____1234ComputeFac4321____>>, <PropagationConstraint: <FlowVar: Fac, ComputeFac, ___tmp4 . ____1234ComputeFac4321____>, <FlowVar: Fac, ComputeFac, ___tmp3>>, <PropagationConstraint: <FlowVar: ____NewMainClass____, ____Main____, ___tmp5>, <FlowVar: ____NewMainClass____, ____Main____, ____printMe____>>, <PropagationConstraint: <FlowVar: Fac, ComputeFac, this>, <FlowVar: Fac, ComputeFac, ___tmp4>>]";
        assertBigStringNotEquals(
            expected,
            constraintGenerator.propagationConstraints.toString());
    }

    /**
     * Test method for {@link ConstraintGenerator#AssignmentStatement()}.
     */
    @Test
    public final void testAssignmentStatement_dotExpression(){
        Node node = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/My-Basic-Test-Cases/DotExpression.java");

        node.accept(constraintGenerator);

        assertEquals(1, constraintGenerator.conditionalConstraints.size());
        String expected = "[<ConditionalConstraint: Bar, <FlowVar: Foo, method1, a>, <PropagationConstraint: <FlowVar: Foo, method1, new Foo ( )>, <FlowVar: Bar, x>>>]";
        assertBigStringEquals(
            expected,
            constraintGenerator.conditionalConstraints.toString());
    }

    /**
     * Test method for {@link ConstraintGenerator#MessageSendStatement()}.
     */
    @Test
    public final void testMessageSendStatement_Bug(){
        Node node = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/Factorial.java");

        node.accept(constraintGenerator);

        String expected = "[<ConditionalConstraint: Fac, <FlowVar: Fac, ComputeFac, ___tmp4>, <PropagationConstraint: <FlowVar: Fac, ComputeFac, ____writeable____num - 1>, <FlowVar: Fac, ComputeFac, num>>>, <ConditionalConstraint: Fac, <FlowVar: ____NewMainClass____, ____Main____, ___tmp6>, <PropagationConstraint: <FlowVar: ____NewMainClass____, ____Main____, 10>, <FlowVar: Fac, ComputeFac, num>>>]";
        assertBigStringNotEquals(expected,
                              constraintGenerator.conditionalConstraints.toString());
    }

    /**
     * Test method for {@link ConstraintGenerator#SlidesExample1()}.
     */
    @Test
    public final void testSlidesExample1_Bug(){
        Node node = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/My-Basic-Test-Cases/SlidesExample1.java");

        node.accept(constraintGenerator);

        String expectedBeginningConstraints = "[<BeginningConstraint: Q, <FlowVar: ____NewMainClass____, ____Main____, new Q ( )>>, <BeginningConstraint: B, <FlowVar: ____NewMainClass____, ____Main____, new B ( )>>, <BeginningConstraint: S, <FlowVar: ____NewMainClass____, ____Main____, new S ( )>>, <BeginningConstraint: A, <FlowVar: ____NewMainClass____, ____Main____, new A ( )>>]";
        String expectedPropagationConstraints = "[<PropagationConstraint: <FlowVar: ____NewMainClass____, ____Main____, new B ( )>, <FlowVar: ____NewMainClass____, ____Main____, y>>, <PropagationConstraint: <FlowVar: ____NewMainClass____, ____Main____, new A ( )>, <FlowVar: ____NewMainClass____, ____Main____, x>>, <PropagationConstraint: <FlowVar: ____NewMainClass____, ____Main____, 5>, <FlowVar: ____NewMainClass____, ____Main____, ____printMe____>>]";
        String expectedConditionalConstraints = "[<ConditionalConstraint: B, <FlowVar: ____NewMainClass____, ____Main____, x>, <PropagationConstraint: <FlowVar: ____NewMainClass____, ____Main____, new Q ( )>, <FlowVar: B, m, arg>>>, <ConditionalConstraint: A, <FlowVar: ____NewMainClass____, ____Main____, y>, <PropagationConstraint: <FlowVar: ____NewMainClass____, ____Main____, new S ( )>, <FlowVar: A, m, arg>>>, <ConditionalConstraint: B, <FlowVar: ____NewMainClass____, ____Main____, y>, <PropagationConstraint: <FlowVar: ____NewMainClass____, ____Main____, new S ( )>, <FlowVar: B, m, arg>>>, <ConditionalConstraint: A, <FlowVar: ____NewMainClass____, ____Main____, x>, <PropagationConstraint: <FlowVar: ____NewMainClass____, ____Main____, new Q ( )>, <FlowVar: A, m, arg>>>]";
        assertBigStringNotEquals(expectedBeginningConstraints,
                              constraintGenerator.beginningConstraints.toString());
        assertBigStringNotEquals(expectedPropagationConstraints,
                              constraintGenerator.propagationConstraints.toString());
        assertBigStringNotEquals(expectedConditionalConstraints,
                              constraintGenerator.conditionalConstraints.toString());
    }
}
