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
    ConstraintGenerator constraintGenerator;
    
    @Before
    public void setUp(){
        constraintGenerator = new ConstraintGenerator();
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
        // TODO: 
        // Node node = InlinerHelper.getMicroJavaNodeFromFile(
        //     "Example-Microjava/Factorial.java");
        // node.accept(constraintGenerator);

        // Solver solver = new Solver(constraintGenerator.beginningConstraints,
        //                            constraintGenerator.propagationConstraints,
        //                            constraintGenerator.conditionalConstraints);

        // solver.computeFlowSets();

        // methodInliner = new MethodInliner((Goal) node,
        //                                   new VarNameUniquifier(),
        //                                   solver.flowSetMap);
        // MethodDeclaration result = methodInliner.getMethod("Fac", "ComputeFac", (Goal) node);
        // System.out.println("here"); 
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
        
        String expected = "class Factorial {public static void main ( String [ ] a ) {new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ; } }  class Fac { int ____1234ComputeFac4321____ ; public void ComputeFac ( int  num  ) { int num_aux ;  int  ____writeable____num ;  int  ____tmp0 ;  Fac  ___tmp4 ;  int ___tmp3 ; ____writeable____num = num ;  if ( ____writeable____num < 1 ) {num_aux = 1 ; }  else { ___tmp4 = this ;  ___tmp4 . ComputeFac (____writeable____num - 1  ) ;  ___tmp3 = ___tmp4 . ____1234ComputeFac4321____ ;  ____tmp0 = ___tmp3 ;  num_aux = ____writeable____num * ____tmp0 ; }   ____1234ComputeFac4321____ = num_aux ;} } class ____NewMainClass____ { public void ____Main____ ( int  ____arg_length____) { int  ____printMe____ ;  Fac  ___tmp6 ;  int  ___tmp5 ;  int  ___VAR1 ; int  ___VAR2 ;  int  ___VAR3 ;  Fac  ___VAR4 ;  int  ___VAR5 ;  int  ___VAR0 ; ___tmp6 = new Fac ( ) ;  { ___VAR0 = 10 ;  ___VAR2 = ___VAR0 ;  if (___VAR2 < 1 ) { ___VAR1 = 1 ; }  else { ___VAR4 = ___tmp6 ;  ___VAR4 . ComputeFac ( ___VAR2 - 1  ) ;  ___VAR5 = ___VAR4 . ____1234ComputeFac4321____ ;  ___VAR3 = ___VAR5 ;  ___VAR1 = ___VAR2 * ___VAR3 ; }   ___tmp6 . ____1234ComputeFac4321____ = ___VAR1 ; }  ___tmp5 = ___tmp6 . ____1234ComputeFac4321____ ;  ____printMe____ = ___tmp5 ; System.out.println ( ____printMe____ ) ; } } ";
        assertBigStringEquals(expected,
                              getFormattedString(node.accept(methodInliner)));
    }
}
