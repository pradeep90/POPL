import syntaxtree.*;
import java.util.*;
import visitor.TreeFormatter;
import visitor.TreeDumper;
import nano.*;

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
     * Test method for {@link CPSHelper#getMicroFormattedString()}.
     */
    @Test
    public final void testGetMicroFormattedString()
            throws FileNotFoundException, ParseException{
        InputStream in1 = new FileInputStream(
            "/home/pradeep/Dropbox/Acads/POPL/Code/CPS-Transformer/Example-Microjava/Factorial.java");
        InputStream in2 = new FileInputStream(
            "/home/pradeep/Dropbox/Acads/POPL/Code/CPS-Transformer/Example-Microjava/Factorial.java");
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
            "/home/pradeep/Dropbox/Acads/POPL/Code/CPS-Transformer/Example-Microjava/Factorial.java");
    }

    /**
     * Test method for {@link CPSHelper#getFormattedString()}.
     */
    @Test
    public final void testGetFormattedString()
            throws FileNotFoundException, nano.ParseException{
        InputStream in1 = new FileInputStream(
            "/home/pradeep/Dropbox/Acads/POPL/Code/CPS-Transformer/Example-Nanojava/SimpleSum.java");
        InputStream in2 = new FileInputStream(
            "/home/pradeep/Dropbox/Acads/POPL/Code/CPS-Transformer/Example-Nanojava/SimpleSum.java");
        nano.syntaxtree.Node root1 = new NanoJavaParser(in1).Goal();
        nano.syntaxtree.Node root2 = new NanoJavaParser(in2).Goal();

        String code1 = CPSHelper.getFormattedString(root1);
        String code2 = CPSHelper.getFormattedString(root2);
        
        assertEquals(code1, code2);
    }

    /** 
     * Assert that node1 and node2 are equal NanoJava nodes.
     */
    public void assertEqualNanoJavaNodes(nano.syntaxtree.Node expected,
                                         nano.syntaxtree.Node actual){
        assertEquals(CPSHelper.getFormattedString(expected),
                     CPSHelper.getFormattedString(actual));
    }

    // /**
    //  * Test method for {@link CPSHelper#getNanoJavaNodeFromFile()}.
    //  */
    // @Test
    // public final void testGetNanoJavaNodeFromFileNoException(){
    //     CPSHelper.getNanoJavaNodeFromFile(
    //         "/home/pradeep/Dropbox/Acads/POPL/Code/CPS-Transformer/Example-Nanojava/Factorial.java");
    // }
}
