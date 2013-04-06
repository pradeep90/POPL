package inliner;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;
import inliner.syntaxtree.*;
import static inliner.InlinerHelperTest.assertEqualMicroJavaNodes;

public class IdentityVisitorTest{
    IdentityVisitor identityVisitor;
    
    @Before
    public void setUp(){
        identityVisitor = new IdentityVisitor();
    }
    
    @After
    public void tearDown(){
    }
    
    /**
     * Test method for {@link IdentityVisitor#IdentityVisitor()}.
     */
    @Test
    public final void testIdentityVisitor(){
        Node expectedNode = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/Factorial.java");
        assertEqualMicroJavaNodes(
            expectedNode,
            expectedNode.accept(identityVisitor));
    }
}
