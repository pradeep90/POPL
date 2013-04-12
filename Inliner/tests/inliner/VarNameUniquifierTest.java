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
import static inliner.InlinerHelperTest.*;

public class VarNameUniquifierTest{
    VarNameUniquifier varNameUniquifier;

    @Before
    public void setUp(){
        varNameUniquifier = new VarNameUniquifier();
    }
    
    @After
    public void tearDown(){
    }

    /**
     * Test method for {@link VarNameUniquifier#foo()}.
     */
    @Test
    public final void testFoo(){
    }

    @Test
    public final void testVarNameUniquifier(){
        Node expectedNode = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/My-Basic-Test-Cases/SameVarName.java");
        // System.out.println("getFormattedString(expectedNode.accept(varNameUniquifier, new Environment())): " + getFormattedString(expectedNode.accept(varNameUniquifier, new Environment())));
        String expected = "class SameVarName {public static void main ( String [ ] a ) {new Foo ( ) . method1 ( 0  ) ; } }  class Bar { bool  x ; public void method1 (int  ___VAR0 , int  ___VAR1   ) { }   public void method2 ( ) { x = true ; } } class Foo { public void method1 ( bool  ___VAR2  ) { }   public void method2 (SameVarName  ___VAR3 , SameVarName  ___VAR4   , bool  ___VAR5   ) { } } ";

        assertBigStringEquals(
            expected,
            getFormattedString(
                expectedNode.accept(
                    varNameUniquifier, new Environment())));
    }

    @Test
    public final void testVarNameUniquifier_Factorial(){
        Node expectedNode = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/Factorial.java");

        // System.out.println("getFormattedString(expectedNode.accept(varNameUniquifier, new Environment())): " + getFormattedString(expectedNode.accept(varNameUniquifier, new Environment())));
        String expected = "class Factorial {public static void main ( String [ ] a ) {new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ;}} class Fac {int ____1234ComputeFac4321____ ; public void ComputeFac ( int  ___VAR0  ) {int ___VAR1 ; int  ___VAR2 ; int  ___VAR3 ; Fac  ___VAR4 ; int  ___VAR5 ; ___VAR2 = ___VAR0 ; if ( ___VAR2 < 1 ) {___VAR1 = 1 ;} else {___VAR4 = this ; ___VAR4 . ComputeFac ( ___VAR2 - 1  ) ; ___VAR5 = ___VAR4 . ____1234ComputeFac4321____ ; ___VAR3 = ___VAR5 ; ___VAR1 = ___VAR2 * ___VAR3 ;} ____1234ComputeFac4321____ = ___VAR1 ;}} class ____NewMainClass____ {public void ____Main____ ( int  ___VAR6  ) {int ___VAR7 ; Fac  ___VAR8 ; int  ___VAR9 ; ___VAR8 = new Fac ( ) ; ___VAR8 . ComputeFac ( 10  ) ; ___VAR9 = ___VAR8 . ____1234ComputeFac4321____ ; ___VAR7 = ___VAR9 ; System.out.println ( ___VAR7 ) ;}} ";

        assertBigStringEquals(
            expected,
            getFormattedString(
                expectedNode.accept(
                    varNameUniquifier, new Environment())));
    }
}
