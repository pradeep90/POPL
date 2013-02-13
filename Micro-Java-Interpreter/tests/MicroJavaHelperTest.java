import syntaxtree.*;
import java.util.*;
import visitor.TreeFormatter;
import visitor.TreeDumper;

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

public class MicroJavaHelperTest{
    @Before
    public void setUp(){
    }
    
    @After
    public void tearDown(){
    }

    /**
     * Test method for {@link MicroJavaHelper#getFormattedString()}.
     */
    @Test
    public final void testGetFormattedString()
            throws FileNotFoundException, ParseException{
        InputStream in1 = new FileInputStream(
            "/home/spradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Micro-Java-Test-Code/MainOnly.microjava");
        InputStream in2 = new FileInputStream(
            "/home/spradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Micro-Java-Test-Code/MainOnly.WithWhitespace.microjava");
        syntaxtree.Node root1 = new MicroJavaParser(in1).Goal();

        syntaxtree.Node root2 = new MicroJavaParser(in2).Goal();

        String code1 = MicroJavaHelper.getFormattedString(root1);
        String code2 = MicroJavaHelper.getFormattedString(root2);
        
        assertEquals(code1, code2);
        System.out.println("code1: " + code1);
        System.out.println("code2: " + code2);
    }

    /** 
     * Assert that node1 and node2 are equal MicroJava nodes.
     */
    public void assertEqualMicroJavaNodes(Node expected,
                                          Node actual){
        assertEquals(MicroJavaHelper.getFormattedString(expected),
                     MicroJavaHelper.getFormattedString(actual));
    }

    /**
     * Test method for {@link MicroJavaHelper#getMicroJavaNodeFromFile()}.
     */
    @Test
    public final void testGetMicroJavaNodeFromFileNoException(){
        MicroJavaHelper.getMicroJavaNodeFromFile("/home/spradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Micro-Java-Test-Code/MainOnly.microjava");
    }
}
