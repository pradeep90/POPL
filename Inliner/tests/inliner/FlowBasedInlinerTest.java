package inliner;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;
import inliner.syntaxtree.*;
import static inliner.InlinerHelper.*;
import static inliner.InlinerHelperTest.assertEqualMicroJavaNodes;
import static inliner.InlinerHelperTest.assertBigStringEquals;

public class FlowBasedInlinerTest{
    FlowBasedInliner flowBasedInliner;
    
    @Before
    public void setUp(){
    }
    
    @After
    public void tearDown(){
    }
    
    /**
     * Test method for {@link FlowBasedInliner#FlowBasedInliner()}.
     */
    @Test
    public final void testFlowBasedInliner(){
        Node node = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/Factorial.java");

        flowBasedInliner = new FlowBasedInliner((Goal) node);

        flowBasedInliner.compute();

        System.out.println("getFormattedString(flowBasedInliner.finalParseTree): " + getFormattedString(flowBasedInliner.finalParseTree));
    }
}
