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
    NodeToken nodeToken3;
    ExpansionNode node;
    ExpansionNode node2;
    NodeListOptional precedingNodeList;
    NodeListOptional varDeclarations;

    @Before
    public void setUp(){
        nodeToken = new NodeToken("foo");
        nodeToken2 = new NodeToken("bar");
        nodeToken3 = new NodeToken("baz");
        precedingNodeList = new NodeListOptional(nodeToken);
        varDeclarations = new NodeListOptional(nodeToken2);
        varDeclarations.addNode(nodeToken3);
        node = new ExpansionNode(nodeToken);
        node2 = new ExpansionNode(nodeToken, varDeclarations, precedingNodeList);
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
     * Test method for {@link ExpansionNode#hasPrecedingNodes()}.
     */
    @Test
    public final void testHasPrecedingNodes(){
        assertEquals(false, node.hasPrecedingNodes());
        assertEquals(true, node2.hasPrecedingNodes());
    }

    /**
     * Test method for {@link ExpansionNode#hasVarDeclarations()}.
     */
    @Test
    public final void testHasVarDeclarations(){
        assertEquals(false, node.hasVarDeclarations());
        assertEquals(true, node2.hasVarDeclarations());
    }
}
