import syntaxtree.*;
import visitor.*;
import java.util.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TypeEquationCollectorTest{
    TypeEquationCollector typeInferrer;
    TypeEnvironment typeEnvironment;
    TrueLiteral trueLiteral;
    FalseLiteral falseLiteral;
    IntegerLiteral integerLiteral;
    IntegerLiteral integerLiteral2;
    PlusExpression plusExpression;
    IfExpression ifExpression;
    Expression intExpression1;
    Expression intExpression2;
    Expression boolExpression;
    Identifier identifier;
    Identifier identifier2;
    
    @Before
    public void setUp(){
        typeInferrer = new TypeEquationCollector();
        typeEnvironment = new TypeEnvironment();

        trueLiteral = new TrueLiteral();
        falseLiteral = new FalseLiteral();
        integerLiteral = new IntegerLiteral(new NodeToken("42"));
        integerLiteral2 = new IntegerLiteral(new NodeToken("42"));
        intExpression1 = new Expression(new NodeChoice(integerLiteral, 0));
        intExpression2 = new Expression(new NodeChoice(integerLiteral2, 0));
        plusExpression = new PlusExpression(intExpression1, intExpression2);
        boolExpression = new Expression(new NodeChoice(trueLiteral, 1));
        ifExpression = new IfExpression(boolExpression, intExpression1, intExpression2);
        identifier = new Identifier(new NodeToken("a"));
        identifier2 = new Identifier(new NodeToken("b"));
    }
    
    @After
    public void tearDown(){
    }

    public Node getTopLevelNode(String programString){
        Goal goal = (Goal) TypeHelper.getMiniSchemeNodeFromString(programString);
        return goal.f0.f0.choice;
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

    /**
     * Test method for {@link TypeEquationCollector#Declaration()}.
     */
    @Test
    public final void testDeclaration(){
        String letString = "(let ((a 10) (b 20)) (+ a b))";
        LetExpression letExpression = (LetExpression) getTopLevelNode(letString);
        Declaration declaration1 = (Declaration) letExpression.f3.nodes.get(0);
        assertEquals(new IntType(), typeInferrer.visit(declaration1, typeEnvironment));
    }

    /**
     * Test method for {@link TypeEquationCollector#Identifier()}.
     */
    @Test
    public final void testIdentifier(){
        typeEnvironment.extend("a", new IntType());
        assertEquals(new IntType(), typeInferrer.visit(identifier, typeEnvironment));
    }

    /**
     * Test method for {@link TypeEquationCollector#LetExpression()}.
     */
    @Test
    public final void testLetExpression(){
        String letString = "(let ((a 10) (b 20)) (+ a b))";
        LetExpression letExpression = (LetExpression) getTopLevelNode(letString);
        assertEquals(new IntType(), typeInferrer.visit(letExpression, typeEnvironment));
    }

    /**
     * Test method for {@link TypeEquationCollector#LetExpression()}.
     */
    @Test
    public final void testLetExpression_NotRecursive(){
        String letString = "(let ((a 10) (b a)) (+ a b))";
        LetExpression letExpression = (LetExpression) getTopLevelNode(letString);
        Type type = typeInferrer.visit(letExpression, typeEnvironment);
        fail();
        assertEquals(new IntType(), type);
    }

    /**
     * Test method for {@link TypeEquationCollector#Assignment()}.
     */
    @Test
    public final void testAssignment(){
        String assignmentString = "(let ((a 10) (b #t)) (set! b a))";
        LetExpression letExpression = (LetExpression) getTopLevelNode(assignmentString);
        Assignment assignment = (Assignment) letExpression.f5.f0.choice;
        assertEquals(new BooleanType(), typeInferrer.visit(assignment, typeEnvironment));
    }
}
