package inliner;

import inliner.*;
import java.util.*;
import inliner.syntaxtree.*;
import inliner.visitor.TreeFormatter;
import inliner.visitor.TreeDumper;

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

        String code1 = InlinerHelper.getFormattedString(root1);
        String code2 = InlinerHelper.getFormattedString(root2);
        
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
     * Assert that node1 and node2 are equal MicroJava nodes.
     */
    public static void assertEqualMicroJavaNodes(Node expected,
                                          Node actual){
        assertEquals(InlinerHelper.getFormattedString(expected),
                     InlinerHelper.getFormattedString(actual));
    }
}
