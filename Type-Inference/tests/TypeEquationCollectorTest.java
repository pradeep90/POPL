import syntaxtree.*;
import visitor.*;
import java.util.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TypeEquationCollectorTest{
    TrueLiteral trueLiteral;
    FalseLiteral falseLiteral;
    IntegerLiteral integerLiteral;
    TypeEquationCollector typeInferrer;
    
    @Before
    public void setUp(){
        typeInferrer = new TypeEquationCollector();
        trueLiteral = new TrueLiteral();
        falseLiteral = new FalseLiteral();
        integerLiteral = new IntegerLiteral(new NodeToken("42"));
    }
    
    @After
    public void tearDown(){
    }
    
    /**
     * Test method for {@link TypeEquationCollector#TrueLiteral()}.
     */
    @Test
    public final void testTrueLiteral(){
        assertEquals(new BooleanType(),
                     typeInferrer.visit(trueLiteral, null));
    }

    /**
     * Test method for {@link TypeEquationCollector#FalseLiteral()}.
     */
    @Test
    public final void testFalseLiteral(){
        assertEquals(new BooleanType(),
                     typeInferrer.visit(falseLiteral, null));
    }

    /**
     * Test method for {@link TypeEquationCollector#IntegerLiteral()}.
     */
    @Test
    public final void testIntegerLiteral(){
        assertEquals(new IntType(),
                     typeInferrer.visit(integerLiteral, null));
    }
}
