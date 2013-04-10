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
    ConstraintGenerator constraintGenerator = new ConstraintGenerator();
    Solver solver = new Solver();
    
    @Before
    public void setUp(){
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
}
