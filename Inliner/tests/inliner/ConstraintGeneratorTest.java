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

        HashSet<BeginningConstraint> expected =
                new HashSet<BeginningConstraint>();
        expected.add(new BeginningConstraint(
            "Fac",
            new FlowVar("Fac",
                        "ComputeFac",
                        "this")));

        assertEquals(2, constraintGenerator.beginningConstraints.size());

        // TODO: 
        // assertEquals(expected, constraintGenerator.beginningConstraints);
        // System.out.println("constraintGenerator.beginningConstraints: " + constraintGenerator.beginningConstraints);
    }

    /**
     * Test method for {@link ConstraintGenerator#AllocationExpression()}.
     */
    @Test
    public final void testAllocationExpression(){
        Node node = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/Factorial.java");

        node.accept(constraintGenerator);

        HashSet<BeginningConstraint> expected =
                new HashSet<BeginningConstraint>();

        // expected.add(new BeginningConstraint(
        //     "Fac",
        //     new FlowVar("Fac",
        //                 "ComputeFac",
        //                 "this")));
        // assertEquals(1, expected.size());

        // TODO: Test the actual value of the set
        // assertEquals(expected, constraintGenerator.beginningConstraints);
        // System.out.println("constraintGenerator.beginningConstraints: " + constraintGenerator.beginningConstraints);
    }
}
