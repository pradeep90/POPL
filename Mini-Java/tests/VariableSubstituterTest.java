// import visitor.*;
// import syntaxtree.*;
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

public class VariableSubstituterTest{
    VariableSubstituter variableSubstituter;
    @Before
    public void setUp(){

        variableSubstituter = new VariableSubstituter();
        variableSubstituter.methodReturnTypeHash = new HashMap<String, Type> ();
    }
    
    @After
    public void tearDown(){
    }

    /**
     * Test method for {@link VariableSubstituter#()}.
     */
    @Test
    public final void testFoo(){
    }

    /**
     * Test method for {@link VariableSubstituter#Type()}.
     */
    @Test
    public final void testType(){
        Type expected = new Type(new NodeChoice(new IntegerType(), 0));
        Type actual = new Type(new NodeChoice(new Identifier(new NodeToken("TYPE_ComputeFac")), 3));
        variableSubstituter.methodReturnTypeHash.put("ComputeFac", new Type(new NodeChoice(new IntegerType(), 2)));
        System.out.println("variableSubstituter.methodReturnTypeHash: " + variableSubstituter.methodReturnTypeHash);
        assertEquals(MicroJavaOutputter.getFormattedString(expected),
                     MicroJavaOutputter.getFormattedString(variableSubstituter.visit(actual)));
    }
}
