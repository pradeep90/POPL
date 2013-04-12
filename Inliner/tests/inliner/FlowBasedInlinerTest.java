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
    }
    
    public String getOutputForFile(String fileName){
        Goal goal = (Goal) getMicroJavaNodeFromFile(
            "Example-Microjava/" + fileName);
        FlowBasedInliner flowBasedInliner = new FlowBasedInliner(goal);
        flowBasedInliner.compute();
        String output = getFormattedString(flowBasedInliner.finalParseTree);
        return output;
    }

    public void doConversionForMicroJavaFile(String fileName){
        // String result = getOutputForFile(fileName);
        // System.out.println("result: " + result);
        
        writeCodeToFile(getOutputForFile(fileName),
                        "Generated-Microjava/" + fileName);
    }

    @Test
    public final void testOutputForFiles(){
        String[] fileNameList = {
            "BinarySearch.java",
            "BinaryTree.java",
            "BubbleSort.java",
            "Factorial.java",
            "LinearSearch.java",
            "LinkedList.java",
            "QuickSort.java",
            "TreeVisitor.java",

            "TA-MicroJava-Test-Cases/ComplexAssignments.java",
            "TA-MicroJava-Test-Cases/DotTest.java",
            "TA-MicroJava-Test-Cases/IfCheck.java",
            "TA-MicroJava-Test-Cases/MainArguments.java",
            "TA-MicroJava-Test-Cases/MethodArgs.java",
            "TA-MicroJava-Test-Cases/MethodReturn.java",
            "TA-MicroJava-Test-Cases/MultilevelInherit.java",
            "TA-MicroJava-Test-Cases/NestedIfCheck.java",
            "TA-MicroJava-Test-Cases/NextedWhile.java",
            "TA-MicroJava-Test-Cases/PrintTest.java",
            "TA-MicroJava-Test-Cases/SimpleAssignments.java",
            "TA-MicroJava-Test-Cases/SimpleMain.java",
            "TA-MicroJava-Test-Cases/ThisExpr.java",
            "TA-MicroJava-Test-Cases/WhileCheck.java",

        };
        for (String fileName : fileNameList){
            System.out.println("fileName: " + fileName);
            try {
                doConversionForMicroJavaFile(fileName);
            } catch(Exception e) {
                e.printStackTrace();
            }

        }
    }
}
