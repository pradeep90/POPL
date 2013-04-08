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

public class ConstraintGeneratorTest{
    ConstraintGenerator constraintGenerator;
    
    @Before
    public void setUp(){
        constraintGenerator = new ConstraintGenerator();
    }
    
    @After
    public void tearDown(){
    }

    /**
     * Test method for {@link ConstraintGenerator#Foo()}.
     */
    @Test
    public final void testFoo(){

    }
}
