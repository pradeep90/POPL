package inliner;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;
import inliner.syntaxtree.*;
import static inliner.InlinerHelper.*;
import static inliner.InlinerHelperTest.assertEqualMicroJavaNodes;
import static inliner.InlinerHelperTest.assertBigStringEquals;

public class MethodInlinerTest{
    MethodInliner methodInliner;
    
    @Before
    public void setUp(){
    }
    
    @After
    public void tearDown(){
    }
    
    @Test
    public final void testFoo(){
    	// To avoid "No runnable methods" error
    }

    /**
     * Test method for {@link MethodInliner#getMethod()}.
     */
    @Test
    public final void testGetMethod(){
        Node node = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/Factorial.java");
        // MethodDeclaration result = MethodInliner.getMethod("Fac", "ComputeFac", (Goal) node);
        // System.out.println("getFormattedString(result): " + getFormattedString(result));
    }
    
    /**
     * Test method for {@link MethodInliner#MethodInliner()}.
     */
    @Test
    public final void testMethodInliner(){
        ConstraintGenerator constraintGenerator = new ConstraintGenerator();
        Node node = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/Factorial.java");

        node.accept(constraintGenerator);

        Solver solver = new Solver(constraintGenerator.beginningConstraints,
                                   constraintGenerator.propagationConstraints,
                                   constraintGenerator.conditionalConstraints);

        solver.computeFlowSets();

        methodInliner = new MethodInliner((Goal) node,
                                                        new VarNameUniquifier(),
                                                        solver.flowSetMap);
        // node.accept(methodInliner);
        
        System.out.println("getFormattedString(node.accept(methodInliner)): " + getFormattedString(node.accept(methodInliner)));
    }
}
