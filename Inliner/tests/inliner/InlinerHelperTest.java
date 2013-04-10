package inliner;

import inliner.*;
import java.util.*;
import inliner.syntaxtree.*;
import inliner.visitor.TreeFormatter;
import inliner.visitor.TreeDumper;

import static inliner.InlinerHelper.*;

// import java.text.ParseException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InlinerHelperTest{
    @Before
    public void setUp(){
    }
    
    @After
    public void tearDown(){
    }

    /** 
     * Assert that node1 and node2 are equal MicroJava nodes.
     */
    public static void assertEqualMicroJavaNodes(Node expected,
                                          Node actual){
        assertEquals(getFormattedString(expected),
                     getFormattedString(actual));
    }

    /** 
     * Assert that expected and actual are identical strings when we
     * remove all the whitespace.
     */
    public static void assertBigStringEquals(String expected, String actual){
        assertEquals(expected.replaceAll("(\n|\\s)+", ""),
                     actual.replaceAll("(\n|\\s)+", ""));
    }

    /**
     * Test method for {@link InlinerHelper#getFormattedString()}.
     */
    @Test
    public final void testGetFormattedString()
            throws FileNotFoundException, ParseException{
        InputStream in1 = new FileInputStream(
            "Example-Microjava/Factorial.java");
        InputStream in2 = new FileInputStream(
            "Example-Microjava/Factorial.java");
        Node root1 = new MicroJavaParser(in1).Goal();
        Node root2 = new MicroJavaParser(in2).Goal();

        String code1 = getFormattedString(root1);
        String code2 = getFormattedString(root2);
        
        assertEquals(code1, code2);
    }

    /**
     * Test method for {@link InlinerHelper#getMicroJavaNodeFromFile()}.
     */
    @Test
    public final void testGetMicroJavaNodeFromFileNoException(){
        InlinerHelper.getMicroJavaNodeFromFile("Example-Microjava/Factorial.java");
    }

    // /**
    //  * Test method for {@link InlinerHelper#getMicroJavaNodeFromFile()}.
    //  */
    // @Test
    // public final void testGetMicroJavaNodeFromFileNoException(){
    //     InlinerHelper.getMicroJavaNodeFromFile(
    //         "Example-Microjava/Factorial.java");
    // }

    /**
     * Test method for {@link InlinerHelper#getSaneExpressionList()}.
     */
    @Test
    public final void testGetSaneExpressionList(){
        IntegerLiteral integerLiteral = new IntegerLiteral(new NodeToken("81"));
        IntegerLiteral integerLiteral2 = new IntegerLiteral(new NodeToken("32"));
        PrimaryExpression primaryExpression = new PrimaryExpression(new NodeChoice(integerLiteral, 0));
        PrimaryExpression primaryExpression2 = new PrimaryExpression(new NodeChoice(integerLiteral2, 0));
        Expression expression = new Expression(new NodeChoice(primaryExpression, 6));
        Expression expression2 = new Expression(new NodeChoice(primaryExpression2, 6));
        assertEquals(new ArrayList<Expression>(), getSaneExpressionList(new NodeOptional()));
        assertEquals(
            Arrays.<Expression>asList(expression),
            getSaneExpressionList(
                new NodeOptional(
                    new ExpressionList(
                        expression,
                        new NodeListOptional()))));
        assertEquals(
            Arrays.<Expression>asList(expression, expression2),
            getSaneExpressionList(
                new NodeOptional(
                    new ExpressionList(
                        expression,
                        new NodeListOptional(new ExpressionRest(expression2))))));
    }
}
