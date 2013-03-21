import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import visitor.*;
import syntaxtree.*;

public class TransformerTest{
    Transformer transformer;

    NodeToken nodeToken;
    nano.syntaxtree.NodeToken nodeTokenNano;

    @Before
    public void setUp(){
        nodeToken = new NodeToken("foo");
        nodeTokenNano = new nano.syntaxtree.NodeToken("foo");
        transformer = new Transformer();
    }
    
    @After
    public void tearDown(){
    }
    
    /** 
     * Assert that NanoJava transformation of microJavaNode is the
     * same as expectedNanoJavaNode.
     */
    public void assertEqualAfterTransform(
        nano.syntaxtree.Node expectedNanoJavaNode,
        Node microJavaNode){

        assertEquals(CPSHelper.getFormattedString(expectedNanoJavaNode),
                     CPSHelper.getFormattedString(
                         microJavaNode.accept(transformer)));
    }

    /** 
     * Assert that node1 and node2 are equal NanoJava nodes.
     */
    public void assertEqualNanoJavaNodes(nano.syntaxtree.Node expected,
                                         nano.syntaxtree.Node actual){
        assertEquals(CPSHelper.getFormattedString(expected),
                     CPSHelper.getFormattedString(actual));
    }

    /**
     * Test method for {@link Transformer#NodeToken()}.
     */
    @Test
    public final void testNodeToken(){
        assertEqualAfterTransform(nodeTokenNano, nodeToken);
    }
}
