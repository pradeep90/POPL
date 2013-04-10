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

public class VarNameUniquifierTest{
    VarNameUniquifier varNameUniquifier = new VarNameUniquifier();

    @Before
    public void setUp(){
    }
    
    @After
    public void tearDown(){
    }

    /**
     * Test method for {@link VarNameUniquifier#foo()}.
     */
    @Test
    public final void testFoo(){
    }

    @Test
    public final void testIdentityVisitor(){
        Node expectedNode = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/My-Basic-Test-Cases/SameVarName.java");
        assertEqualMicroJavaNodes(
            expectedNode,
            expectedNode.accept(varNameUniquifier));
    }
}
