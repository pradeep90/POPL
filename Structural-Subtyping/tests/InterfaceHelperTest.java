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

public class InterfaceHelperTest{
    @Before
    public void setUp(){
    }
    
    @After
    public void tearDown(){
    }

    /**
     * Test method for {@link InterfaceHelper#getFormattedString()}.
     */
    @Test
    public final void testGetFormattedString()
            throws FileNotFoundException, ParseException{
        InputStream in1 = new FileInputStream(
            "/home/spradeep/Dropbox/Acads/POPL/Code/Structural-Subtyping/Example-Interfaces/pub0.java");
        InputStream in2 = new FileInputStream(
            "/home/spradeep/Dropbox/Acads/POPL/Code/Structural-Subtyping/Example-Interfaces/pub0.java");
        syntaxtree.Node root1 = new InterfaceParser(in1).Goal();
        syntaxtree.Node root2 = new InterfaceParser(in2).Goal();

        String code1 = InterfaceHelper.getFormattedString(root1);
        String code2 = InterfaceHelper.getFormattedString(root2);
        
        assertEquals(code1, code2);
        System.out.println("code1: " + code1);
        System.out.println("code2: " + code2);
    }

    /** 
     * Assert that node1 and node2 are equal Interface nodes.
     */
    public void assertEqualInterfaceNodes(Node expected,
                                          Node actual){
        assertEquals(InterfaceHelper.getFormattedString(expected),
                     InterfaceHelper.getFormattedString(actual));
    }

    /**
     * Test method for {@link InterfaceHelper#getInterfaceNodeFromFile()}.
     */
    @Test
    public final void testGetInterfaceNodeFromFileNoException(){
        InterfaceHelper.getInterfaceNodeFromFile(
            "/home/spradeep/Dropbox/Acads/POPL/Code/Structural-Subtyping/Example-Interfaces/pub0.java");
    }
}
