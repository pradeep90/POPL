import syntaxtree.*;
import visitor.*;
import java.util.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TypeInferrerTest{
    TrueLiteral trueLiteral;
    FalseLiteral falseLiteral;
    IntegerLiteral integerLiteral;
    TypeInferrer typeInferrer;
    
    @Before
    public void setUp(){
        typeInferrer = new TypeInferrer();
        trueLiteral = new TrueLiteral();
        falseLiteral = new FalseLiteral();
        integerLiteral = new IntegerLiteral(new NodeToken("42"));
    }
    
    @After
    public void tearDown(){
    }
    
    /**
     * Test method for {@link TypeInferrer#TrueLiteral()}.
     */
    @Test
    public final void testTrueLiteral(){
        assertEquals(new BooleanType(),
                     typeInferrer.visit(trueLiteral, null));
    }

    /**
     * Test method for {@link TypeInferrer#FalseLiteral()}.
     */
    @Test
    public final void testFalseLiteral(){
        assertEquals(new BooleanType(),
                     typeInferrer.visit(falseLiteral, null));
    }

    /**
     * Test method for {@link TypeInferrer#IntegerLiteral()}.
     */
    @Test
    public final void testIntegerLiteral(){
        assertEquals(new IntType(),
                     typeInferrer.visit(integerLiteral, null));
    }
}
