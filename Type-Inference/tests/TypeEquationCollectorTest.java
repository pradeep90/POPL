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

        // Reset it for each test case
        UnknownType.counter = 0;

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
    @Test(expected = RuntimeException.class)
    public final void testLetExpression_NotRecursive(){
        String letString = "(let ((a 10) (b a)) (+ a b))";
        LetExpression letExpression = (LetExpression) getTopLevelNode(letString);
        Type type = typeInferrer.visit(letExpression, typeEnvironment);
    }

    /**
     * Test method for {@link TypeEquationCollector#Assignment()}.
     */
    @Test
    public final void testAssignment(){
        String assignmentString = "(let ((a 10) (b #t)) (set! b a))";
        LetExpression letExpression = (LetExpression) getTopLevelNode(assignmentString);
        assertEquals(new BooleanType(), typeInferrer.visit(letExpression,
                                                           typeEnvironment));
    }
    
    /**
     * Test method for {@link TypeEquationCollector#ProcedureExp()}.
     */
    @Test
    public final void testProcedureExp_OneParam(){
        String procedureString = "(lambda (x) (+ x 5))";
        ProcedureExp procedureExp = (ProcedureExp) getTopLevelNode(procedureString);
        Type expected = new FunctionType(new UnknownType(0), new IntType());
        assertEquals(expected, typeInferrer.visit(procedureExp,
                                                  typeEnvironment));
        assertTrue(typeInferrer.allEquations.contains(
            new TypeEquation(new UnknownType(0), new IntType())));
    }

    /**
     * Test method for {@link TypeEquationCollector#ProcedureExp()}.
     */
    @Test
    public final void testProcedureExp_TwoParam(){
        String procedureString = "(lambda (x y) (+ x y))";
        ProcedureExp procedureExp = (ProcedureExp) getTopLevelNode(procedureString);
        Type expected = new FunctionType(
            new UnknownType(0),
            new FunctionType(new UnknownType(1), new IntType()));

        assertEquals(expected, typeInferrer.visit(procedureExp,
                                                  typeEnvironment));
        assertTrue(typeInferrer.allEquations.contains(
            new TypeEquation(new UnknownType(0), new IntType())));
        assertTrue(typeInferrer.allEquations.contains(
            new TypeEquation(new UnknownType(1), new IntType())));
    }

    /**
     * Test method for {@link TypeEquationCollector#ProcedureExp()}.
     */
    @Test
    public final void testProcedureExp_ThreeParam(){
        String procedureString = "(lambda (f) (f 3))";
        ProcedureExp procedureExp = (ProcedureExp) getTopLevelNode(procedureString);
        Type expected = new FunctionType(
            new UnknownType(0),
            new UnknownType(1));

        assertEquals(expected, typeInferrer.visit(procedureExp,
                                                  typeEnvironment));
        assertTrue(typeInferrer.allEquations.contains(
            new TypeEquation(new FunctionType(new IntType(), new UnknownType(1)),
                             new UnknownType(0))));
    }

    /**
     * Test method for {@link TypeEquationCollector#Application()}.
     */
    @Test
    public final void testApplication_OneParam(){
        String applicationString = "((lambda (x) (+ x 5)) 4)";
        Application application = (Application) getTopLevelNode(applicationString);
        Type expected = new UnknownType(1);
        assertEquals(expected, typeInferrer.visit(application, typeEnvironment));
        assertTrue(typeInferrer.allEquations.contains(
            new TypeEquation(new UnknownType(0), new IntType())));
        assertTrue(typeInferrer.allEquations.contains(
            new TypeEquation(
                new FunctionType(new IntType(), new UnknownType(1)),
                new FunctionType(new UnknownType(0), new IntType()))));
    }

    /**
     * Test method for {@link TypeEquationCollector#Application()}.
     */
    @Test
    public final void testApplication_TwoParam(){
        String applicationString = "((lambda (x y) (+ x y)) 2 3)";
        Application applicationExp = (Application) getTopLevelNode(applicationString);
        Type expected = new UnknownType(2);
        assertEquals(expected, typeInferrer.visit(applicationExp,
                                                  typeEnvironment));
        assertTrue(typeInferrer.allEquations.contains(
            new TypeEquation(new UnknownType(0), new IntType())));
        assertTrue(typeInferrer.allEquations.contains(
            new TypeEquation(new UnknownType(1), new IntType())));
        assertTrue(typeInferrer.allEquations.contains(
            new TypeEquation(
                new FunctionType(
                    new IntType(), new FunctionType(new IntType(),
                                                    new UnknownType(2))),
                new FunctionType(new UnknownType(0),
                                 new FunctionType(new UnknownType(1),
                                                  new IntType())))));
    }

    /**
     * Test method for {@link TypeEquationCollector#RecDeclaration()}.
     */
    @Test
    public final void testRecDeclaration(){
        // Meaningless recursive function
        String recString = "(letrec ((a (lambda (x) (a x)))) (a 4))";
        RecExpression recExpression = (RecExpression) getTopLevelNode(recString);
        assertEquals(new UnknownType(3),
                     typeInferrer.visit(recExpression, typeEnvironment));
        // a = (lambda ...)
        assertTrue(typeInferrer.allEquations.contains(
            new TypeEquation(new UnknownType(0),
                             new FunctionType(new UnknownType(1),
                                              new UnknownType(2)))));
        // (a x) should conform with a's type
        assertTrue(typeInferrer.allEquations.contains(
            new TypeEquation(new FunctionType(new UnknownType(1),
                                              new UnknownType(2)),
                             new UnknownType(0))));
        // (a 4) should conform with a's type
        assertTrue(typeInferrer.allEquations.contains(
            new TypeEquation(new FunctionType(new IntType(),
                                              new UnknownType(3)),
                             new UnknownType(0))));
    }

    /**
     * Test method for {@link TypeEquationCollector#RecExpression()}.
     */
    @Test
    public final void testRecExpression_MutualRecursion(){
        // Meaningless recursive function
        String recString = "(letrec ((a (lambda (x) (b x)))"
                + "(b (lambda (x) (a x)))) (a 4))";
        RecExpression recExpression = (RecExpression) getTopLevelNode(recString);
        assertEquals(new UnknownType(6),
                     typeInferrer.visit(recExpression, typeEnvironment));
        // a's definition
        assertTrue(typeInferrer.allEquations.contains(
            new TypeEquation(new UnknownType(0),
                             new FunctionType(new UnknownType(2),
                                              new UnknownType(3)))));
        // b's definition
        assertTrue(typeInferrer.allEquations.contains(
            new TypeEquation(new UnknownType(1),
                             new FunctionType(new UnknownType(4),
                                              new UnknownType(5)))));
        // a's body
        assertTrue(typeInferrer.allEquations.contains(
            new TypeEquation(new FunctionType(new UnknownType(2),
                                              new UnknownType(3)),
                             new UnknownType(1))));
        // b's body
        assertTrue(typeInferrer.allEquations.contains(
            new TypeEquation(new FunctionType(new UnknownType(4),
                                              new UnknownType(5)),
                             new UnknownType(0))));
        // letrec body
        assertTrue(typeInferrer.allEquations.contains(
            new TypeEquation(new FunctionType(new IntType(),
                                              new UnknownType(6)),
                             new UnknownType(0))));
    }

    // /**
    //  * Test method for {@link TypeEquationCollector#pub1()}.
    //  */
    // @Test
    // public final void testPub1(){
    //     TypeHelper.getMiniSchemeNodeFromFile(
    //         "/home/spradeep/Dropbox/Acads/POPL/Code/Type-Inference/Examples-Scheme/pub1.scm").accept(typeInferrer, typeEnvironment);
    // }

    // /**
    //  * Test method for {@link TypeEquationCollector#pub2()}.
    //  */
    // @Test
    // public final void testPub2(){
    //     TypeHelper.getMiniSchemeNodeFromFile(
    //         "/home/spradeep/Dropbox/Acads/POPL/Code/Type-Inference/Examples-Scheme/pub2.scm").accept(typeInferrer, typeEnvironment);
    // }

    // /**
    //  * Test method for {@link TypeEquationCollector#pub3()}.
    //  */
    // @Test
    // public final void testPub3(){
    //     TypeHelper.getMiniSchemeNodeFromFile(
    //         "/home/spradeep/Dropbox/Acads/POPL/Code/Type-Inference/Examples-Scheme/pub3.scm").accept(typeInferrer, typeEnvironment);
    // }

    // /**
    //  * Test method for {@link TypeEquationCollector#pub4()}.
    //  */
    // @Test
    // public final void testPub4(){
    //     TypeHelper.getMiniSchemeNodeFromFile(
    //         "/home/spradeep/Dropbox/Acads/POPL/Code/Type-Inference/Examples-Scheme/pub4.scm").accept(typeInferrer, typeEnvironment);
    // }

    // /**
    //  * Test method for {@link TypeEquationCollector#pub5()}.
    //  */
    // @Test
    // public final void testPub5(){
    //     TypeHelper.getMiniSchemeNodeFromFile(
    //         "/home/spradeep/Dropbox/Acads/POPL/Code/Type-Inference/Examples-Scheme/pub5.scm").accept(typeInferrer, typeEnvironment);
    // }

}
