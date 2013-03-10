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
    TypeEquationCollector typeInferrer;
    TrueLiteral trueLiteral;
    FalseLiteral falseLiteral;
    IntegerLiteral integerLiteral;
    IntegerLiteral integerLiteral2;
    PlusExpression plusExpression;
    IfExpression ifExpression;
    Expression intExpression1;
    Expression intExpression2;
    Expression boolExpression;
    
    @Before
    public void setUp(){
        typeInferrer = new TypeEquationCollector();
        trueLiteral = new TrueLiteral();
        falseLiteral = new FalseLiteral();
        integerLiteral = new IntegerLiteral(new NodeToken("42"));
        integerLiteral2 = new IntegerLiteral(new NodeToken("42"));
        intExpression1 = new Expression(new NodeChoice(integerLiteral, 0));
        intExpression2 = new Expression(new NodeChoice(integerLiteral2, 0));
        plusExpression = new PlusExpression(intExpression1, intExpression2);
        boolExpression = new Expression(new NodeChoice(trueLiteral, 1));
        ifExpression = new IfExpression(boolExpression, intExpression1, intExpression2);
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

    /**
     * Test method for {@link TypeEquationCollector#PlusExpression()}.
     */
    @Test
    public final void testPlusExpression(){
        assertEquals(new IntType(), typeInferrer.visit(plusExpression, null));
        assertTrue(typeInferrer.allEquations.contains(
            new TypeEquation(new IntType(), new IntType())));
        assertEquals(1, typeInferrer.allEquations.size());
    }

    /**
     * Test method for {@link TypeEquationCollector#IfExpression()}.
     */
    @Test
    public final void testIfExpression(){
        assertEquals(new UnknownType(0), typeInferrer.visit(ifExpression, null));
        assertTrue(typeInferrer.allEquations.contains(
            new TypeEquation(new IntType(), new UnknownType(0))));
        assertTrue(typeInferrer.allEquations.contains(
            new TypeEquation(new BooleanType(), new BooleanType())));
        assertEquals(2, typeInferrer.allEquations.size());
    }
}
