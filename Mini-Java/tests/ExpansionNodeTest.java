import visitor.GJNoArguDepthFirst;
import java.util.*;
import microjavaparser.visitor.TreeFormatter;
import microjavaparser.visitor.TreeDumper;
import microjavaparser.syntaxtree.*;
import microjavaparser.*;

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

public class ExpansionNodeTest{
    NodeToken nodeToken;
    NodeToken nodeToken2;
    ExpansionNode node;
    ExpansionNode node2;
    NodeListOptional precedingNodeList;

    @Before
    public void setUp(){
        nodeToken = new NodeToken("foo");
        nodeToken2 = new NodeToken("bar");
        precedingNodeList = new NodeListOptional(nodeToken);
        node = new ExpansionNode(nodeToken);
        node2 = new ExpansionNode(nodeToken, precedingNodeList);
    }
    
    @After
    public void tearDown(){
    }
    
    /**
     * Test method for {@link ExpansionNode#toNode()}.
     */
    @Test
    public final void testToNode(){
        assertEquals(nodeToken, node.toNode());
        assertEquals(nodeToken, node2.toNode());
    }

    /**
     * Test method for {@link ExpansionNode#getPrecedingNodes()}.
     */
    @Test
    public final void testGetPrecedingNodes(){
        assertEquals(precedingNodeList, node2.getPrecedingNodes());
    }

    /**
     * Test method for {@link ExpansionNode#hasPrecedingNodes()}.
     */
    @Test
    public final void testHasPrecedingNodes(){
        assertEquals(false, node.hasPrecedingNodes());
        assertEquals(true, node2.hasPrecedingNodes());
    }
}
