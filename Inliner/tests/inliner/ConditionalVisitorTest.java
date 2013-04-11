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

public class ConditionalVisitorTest{
    FlowVar argFlowVar = new FlowVar("Foo", "bar", "yoBoyzInt");
    ConditionalVisitor conditionalVisitor = new ConditionalVisitor(null, "ComputeFac", Arrays.<FlowVar>asList(argFlowVar));
    
    @Before
    public void setUp(){
    }
    
    @After
    public void tearDown(){
    }
    
    /**
     * Test method for {@link ConditionalVisitor#ConditionalVisitor()}.
     */
    @Test
    public final void testConditionalVisitor(){
        Node node = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/Factorial.java");

        node.accept(conditionalVisitor);
        ConditionalConstraint expected = new ConditionalConstraint(
            "Fac",
            null,
            new PropagationConstraint(argFlowVar,
                                      new FlowVar("Fac", "ComputeFac", "num")));
        assertEquals(1, conditionalVisitor.constraints.size());
        assertEquals(expected.toString(),
                     conditionalVisitor.constraints.get(0).toString());
    }
    
    /**
     * Test method for {@link ConditionalVisitor#ConditionalVisitor()}.
     */
    @Test
    public final void testConditionalVisitor____NewMainClass____(){
        Node node = InlinerHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/Factorial.java");

        conditionalVisitor.messageMethodName = "____Main____";
        node.accept(conditionalVisitor);

        ConditionalConstraint expected = new ConditionalConstraint(
            "____NewMainClass____",
            null,
            new PropagationConstraint(argFlowVar,
                                      new FlowVar("____NewMainClass____",
                                                  "____Main____",
                                                  "____arg_length____")));

        assertEquals(1, conditionalVisitor.constraints.size());
        assertEquals(expected.toString(),
                     conditionalVisitor.constraints.get(0).toString());
    }
}
