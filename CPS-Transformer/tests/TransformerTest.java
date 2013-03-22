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
    Identifier identifier;
    nano.syntaxtree.Identifier identifierNano;
    IntegerLiteral integerLiteral;
    nano.syntaxtree.IntegerLiteral integerLiteralNano;
    TrueLiteral trueLiteral;
    nano.syntaxtree.TrueLiteral trueLiteralNano;
    FalseLiteral falseLiteral;
    nano.syntaxtree.FalseLiteral falseLiteralNano;

    @Before
    public void setUp(){
        transformer = new Transformer();

        nodeToken = new NodeToken("foo");
        nodeTokenNano = new nano.syntaxtree.NodeToken("foo");
        identifier = new Identifier(nodeToken);
        identifierNano = new nano.syntaxtree.Identifier(nodeTokenNano);
        integerLiteral = new IntegerLiteral(nodeToken);
        integerLiteralNano = new nano.syntaxtree.IntegerLiteral(nodeTokenNano);
        trueLiteral = new TrueLiteral();
        trueLiteralNano = new nano.syntaxtree.TrueLiteral();
        falseLiteral = new FalseLiteral();
        falseLiteralNano = new nano.syntaxtree.FalseLiteral();
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

    /**
     * Test method for {@link Transformer#IntegerLiteral()}.
     */
    @Test
    public final void testIntegerLiteral(){
        assertEqualAfterTransform(integerLiteralNano, integerLiteral);
    }

    /**
     * Test method for {@link Transformer#TrueLiteral()}.
     */
    @Test
    public final void testTrueLiteral(){
        assertEqualAfterTransform(trueLiteralNano, trueLiteral);
    }

    /**
     * Test method for {@link Transformer#FalseLiteral()}.
     */
    @Test
    public final void testFalseLiteral(){
        assertEqualAfterTransform(falseLiteralNano, falseLiteral);
    }

    /**
     * Test method for {@link Transformer#Identifier()}.
     */
    @Test
    public final void testIdentifier(){
        assertEqualAfterTransform(identifierNano, identifier);
    }
}
