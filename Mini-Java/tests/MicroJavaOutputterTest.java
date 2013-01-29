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
import java.net.URL;
 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MicroJavaOutputterTest {
    MicroJavaOutputter outputter;
    String factorialMiniJavaCode;
    String factorialMicroJavaCode;

    @Before
    public void setUp() {
        outputter = new MicroJavaOutputter();
        factorialMiniJavaCode = " class Factorial{" +
                "    public static void main(String[] a){" +
                "        System.out.println(10);" +
                "    }" +
                "}"
                ;

        factorialMicroJavaCode = "class Factorial {" +
                "   public static void main(String [] a){" +
                "      new ____NewMainClass____().____Main____(0);" +
                "   }" +
                "}" +
                "class Fac{" +
                "   int ____1234ComputeFac4321____;" +

                "   public void ComputeFac(int num){" +
                "      int num_aux;" +
                "      int ____writeable____num;" +
                "      int ____tmp0;" +
                "      Fac ___tmp4;" +
                "      int ___tmp3;" +

                "____writeable____num = num;" +
                "      if( ____writeable____num<1 ){" +
                "         num_aux = 1;" +
                "      } else {" +
                "         ___tmp4 = this;" +
                "         ___tmp4.ComputeFac(____writeable____num-1);" +
                "         ___tmp3 = ___tmp4.____1234ComputeFac4321____;" +
                "         ____tmp0 = ___tmp3;" +
                "         num_aux = ____writeable____num*____tmp0;" +
                "      }" +
                "      ____1234ComputeFac4321____ = num_aux;" +
                "   }" +
                "}" +
                "class ____NewMainClass____{" +

                "   public void ____Main____(int ____arg_length____){" +
                "      int ____printMe____;" +
                "      Fac ___tmp6;" +
                "      int ___tmp5;" +

                "      ___tmp6 =" +
                "         new Fac();" +
                "      ___tmp6.ComputeFac(10);" +
                "      ___tmp5 = ___tmp6.____1234ComputeFac4321____;" +
                "      ____printMe____ = ___tmp5;" +
                "      System.out.println(____printMe____);" +
                "   }" +
                "}";
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
     * Test method for {@link MicroJavaOutputter#getFormattedString()}.
     */
    @Test
    public final void testGetFormattedString()
            throws FileNotFoundException, microjavaparser.ParseException{
        InputStream in1 = new FileInputStream(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Micro-Java-Test-Code/MainOnly.microjava");
        InputStream in2 = new FileInputStream(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Micro-Java-Test-Code/MainOnly.WithWhitespace.microjava");
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
        MicroJavaOutputter.getMicroJavaNodeFromFile("/home/pradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Micro-Java-Test-Code/MainOnly.microjava");
    }

    /**
     * Test method for {@link MiniJavaOutputter#getMiniJavaNodeFromFile()}.
     */
    @Test
    public final void testGetMiniJavaNodeFromFileNoException(){
        MicroJavaOutputter.getMiniJavaNodeFromFile("/home/pradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Mini-Java-Test-Code/MainOnly.minijava");
    }

    /**
     * Test method for {@link MicroJavaOutputter#simpleTransformer()}.
     */
    @Test
    public final void testMainOnly()
            throws ParseException, FileNotFoundException, microjavaparser.ParseException {
        InputStream inputCodeStream = new FileInputStream(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Mini-Java-Test-Code/MainOnly.minijava");
        Node root = new MiniJavaParser(inputCodeStream).Goal();
        root.accept(outputter); // Your assignment part is invoked here.

        // // Trying to get relative paths working.
        // URL url = this.getClass().getResource("foo.txt");
        // System.out.println("url.getFile(): " + url.getFile());
        // InputStream in = this.getClass().getResourceAsStream("Mini-Java-Test-Code/MainOnly.minijava");
        // System.out.println("convertStreamToString(in): " + convertStreamToString(in));

        microjavaparser.syntaxtree.Node expectedMicroParseTree = MicroJavaOutputter.getMicroJavaNodeFromFile(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Micro-Java-Test-Code/MainOnly.microjava");

        InputStream actualCodeStream = new ByteArrayInputStream(
            outputter.getMicroJavaCode().getBytes());
        microjavaparser.syntaxtree.Node actualMicroParseTree = new MicroJavaParser(
            actualCodeStream).Goal();

        assertEquals(MicroJavaOutputter.getFormattedString(expectedMicroParseTree),
                     MicroJavaOutputter.getFormattedString(actualMicroParseTree));
    }
}
