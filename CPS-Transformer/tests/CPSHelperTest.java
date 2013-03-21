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

public class CPSHelperTest{
    @Before
    public void setUp(){
    }
    
    @After
    public void tearDown(){
    }

    /**
     * Test method for {@link CPSHelper#getFormattedString()}.
     */
    @Test
    public final void testGetFormattedString()
            throws FileNotFoundException, ParseException{
        InputStream in1 = new FileInputStream(
            "/home/spradeep/Dropbox/Acads/POPL/Code/CPS-Transformer/Example-Microjava/Factorial.java");
        InputStream in2 = new FileInputStream(
            "/home/spradeep/Dropbox/Acads/POPL/Code/CPS-Transformer/Example-Microjava/Factorial.java");
        syntaxtree.Node root1 = new MicroJavaParser(in1).Goal();
        syntaxtree.Node root2 = new MicroJavaParser(in2).Goal();

        String code1 = CPSHelper.getMicroFormattedString(root1);
        String code2 = CPSHelper.getMicroFormattedString(root2);
        
        assertEquals(code1, code2);
    }

    /** 
     * Assert that node1 and node2 are equal MicroJava nodes.
     */
    public void assertEqualMicroJavaNodes(Node expected,
                                          Node actual){
        assertEquals(CPSHelper.getMicroFormattedString(expected),
                     CPSHelper.getMicroFormattedString(actual));
    }

    /**
     * Test method for {@link CPSHelper#getMicroJavaNodeFromFile()}.
     */
    @Test
    public final void testGetMicroJavaNodeFromFileNoException(){
        CPSHelper.getMicroJavaNodeFromFile(
            "/home/spradeep/Dropbox/Acads/POPL/Code/CPS-Transformer/Example-Microjava/Factorial.java");
    }
}
