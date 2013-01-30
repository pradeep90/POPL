import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import visitor.*;
import syntaxtree.*;
import microjavaparser.*;
import microjavaparser.visitor.TreeFormatter;
import microjavaparser.visitor.TreeDumper;

// import java.text.ParseException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.File;
import java.net.URL;
 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MicroJavaOutputterTest {
    MicroJavaOutputter outputter;

    final String BASE_DIR = "/home/spradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests";
    final String MICRO_JAVA_DIR = "Micro-Java-Test-Code";
    final String MINI_JAVA_DIR = "Mini-Java-Test-Code";
    final String MICRO_JAVA_EXTENSION = ".microjava";
    final String MINI_JAVA_EXTENSION = ".minijava";

    @Before
    public void setUp() {
        outputter = new MicroJavaOutputter();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * From
     * http://stackoverflow.com/questions/309424/read-convert-an-inputstream-to-a-string#answer-309718
     */
    public static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    /** 
     * Assert that MicroJava transformation of miniJavaNode is the
     * same as expectedMicroJavaNode.
     */
    public void assertEqualAfterTransform(
        microjavaparser.syntaxtree.Node expectedMicroJavaNode,
        Node miniJavaNode){

        assertEquals(MicroJavaOutputter.getFormattedString(expectedMicroJavaNode),
                     MicroJavaOutputter.getFormattedString(
                         outputter.getMicroJavaParseTree(miniJavaNode)));
    }

    /**
     * Test method for {@link MicroJavaOutputter#getFormattedString()}.
     */
    @Test
    public final void testGetFormattedString()
            throws FileNotFoundException, microjavaparser.ParseException{
        InputStream in1 = new FileInputStream(
            "/home/spradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Micro-Java-Test-Code/MainOnly.microjava");
        InputStream in2 = new FileInputStream(
            "/home/spradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Micro-Java-Test-Code/MainOnly.WithWhitespace.microjava");
        microjavaparser.syntaxtree.Node root1 = new MicroJavaParser(in1).Goal();

        microjavaparser.syntaxtree.Node root2 = new MicroJavaParser(in2).Goal();

        String code1 = MicroJavaOutputter.getFormattedString(root1);
        String code2 = MicroJavaOutputter.getFormattedString(root2);
        
        assertEquals(code1, code2);
    }

    /**
     * Test method for {@link MicroJavaOutputter#getMicroJavaNodeFromFile()}.
     */
    @Test
    public final void testGetMicroJavaNodeFromFileNoException(){
        MicroJavaOutputter.getMicroJavaNodeFromFile("/home/spradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Micro-Java-Test-Code/MainOnly.microjava");
    }

    /**
     * Test method for {@link MiniJavaOutputter#getMiniJavaNodeFromFile()}.
     */
    @Test
    public final void testGetMiniJavaNodeFromFileNoException(){
        MicroJavaOutputter.getMiniJavaNodeFromFile("/home/spradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Mini-Java-Test-Code/MainOnly.minijava");
    }

    /**
     * Test method for {@link MicroJavaOutputter#visitThisExpression()}.
     */
    @Test
    public final void testVisitThisExpression(){
        ThisExpression expr = new ThisExpression();
        microjavaparser.syntaxtree.Node expected = new microjavaparser.syntaxtree.ThisExpression();
        assertEqualAfterTransform(expected, expr);
    }

    /**
     * Test method for {@link MicroJavaOutputter#visitNodeToken()}.
     */
    @Test
    public final void testVisitNodeToken(){
        NodeToken n = new NodeToken("foobar");
        microjavaparser.syntaxtree.Node expected = new microjavaparser.syntaxtree.NodeToken("foobar");
        assertEqualAfterTransform(expected, n);
    }

    // /**
    //  * Test method for {@link MicroJavaOutputter#visitVarDeclaration()}.
    //  */
    // @Test
    // public final void testVisitVarDeclaration(){
    //     VarDeclaration var = new VarDeclaration(
    //         new Type(new NodeChoice(new IntegerType(), 2)),
    //         new Identifier(new NodeToken("foo")));
    //     System.out.println("MicroJavaOutputter.getFormattedString(var): " + MicroJavaOutputter.getFormattedString(outputter.getMicroJavaParseTree(var)));
    // }

    ///////////////////////
    // Integration Tests //
    ///////////////////////

    /** 
     * Run test to see if MicroJava translation of MiniJava filename
     * is the same as the MicroJava filename.
     * 
     * @param basename filename (without extension) for both MicroJava
     * and MiniJava test code files.
     */
    public void doTestMiniAndMicroJava(String basename){
        // // Trying to get relative paths working.
        // URL url = this.getClass().getResource("foo.txt");
        // System.out.println("url.getFile(): " + url.getFile());
        // InputStream in = this.getClass().getResourceAsStream("Mini-Java-Test-Code/MainOnly.minijava");
        // System.out.println("convertStreamToString(in): " + convertStreamToString(in));

        microjavaparser.syntaxtree.Node expectedMicroParseTree = MicroJavaOutputter.getMicroJavaNodeFromFile(BASE_DIR + File.separator + MICRO_JAVA_DIR + File.separator + basename + MICRO_JAVA_EXTENSION);

        Node root = MicroJavaOutputter.getMiniJavaNodeFromFile(BASE_DIR + File.separator + MINI_JAVA_DIR + File.separator + basename + MINI_JAVA_EXTENSION);
        microjavaparser.syntaxtree.Node actualMicroParseTree =
                outputter.getMicroJavaParseTree(root);

        assertEquals(MicroJavaOutputter.getFormattedString(expectedMicroParseTree),
                     MicroJavaOutputter.getFormattedString(actualMicroParseTree));

        System.out.println("outputter.getFullMicroJavaCode(): "
                           + outputter.getFullMicroJavaCode());
    }

    // /**
    //  * Test method for {@link MicroJavaOutputter#simpleTransformer()}.
    //  */
    // @Test
    // public final void testMainOnly(){
    //     doTestMiniAndMicroJava("MainOnly");
    // }
}
