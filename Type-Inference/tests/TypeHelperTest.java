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

public class TypeHelperTest{
    @Before
    public void setUp(){
    }
    
    @After
    public void tearDown(){
    }

    /**
     * Test method for {@link TypeHelper#getFormattedString()}.
     */
    @Test
    public final void testGetFormattedString()
            throws FileNotFoundException, ParseException{
        InputStream in1 = new FileInputStream(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Type-Inference/Examples-Scheme/pub1.scm");
        InputStream in2 = new FileInputStream(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Type-Inference/Examples-Scheme/pub1.scm");
        syntaxtree.Node root1 = new MiniSchemeParser(in1).Goal();
        syntaxtree.Node root2 = new MiniSchemeParser(in2).Goal();

        String code1 = TypeHelper.getFormattedString(root1);
        String code2 = TypeHelper.getFormattedString(root2);
        
        assertEquals(code1, code2);
    }

    /** 
     * Assert that node1 and node2 are equal Type nodes.
     */
    public void assertEqualMiniSchemeNodes(Node expected,
                                          Node actual){
        assertEquals(TypeHelper.getFormattedString(expected),
                     TypeHelper.getFormattedString(actual));
    }

    /**
     * Test method for {@link TypeHelper#getMiniSchemeNodeFromFile()}.
     */
    @Test
    public final void testGetMiniSchemeNodeFromFileNoException(){
        TypeHelper.getMiniSchemeNodeFromFile(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Type-Inference/Examples-Scheme/pub1.scm");
    }
}
