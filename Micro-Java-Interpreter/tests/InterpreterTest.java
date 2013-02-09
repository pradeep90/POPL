import syntaxtree.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InterpreterTest{
    Environment env;
    Store store;
    InterpreterArgument arg;
    Interpreter interpreter;

    IntegerValue integerValue1;

    NodeToken nodeToken;
    NodeToken nodeToken2;
    NodeToken nodeToken3;
    NodeToken nodeToken4;
    ArrayType arrayType;
    BooleanType booleanType;
    IntegerType integerType;
    Type type;
    IntegerLiteral integerLiteral;
    IntegerLiteral integerLiteral2;
    IntegerLiteral integerLiteral3;
    PrimaryExpression primaryExpression;
    PrimaryExpression primaryExpression2;
    PrimaryExpression primaryExpression3;
    PrimaryExpression primaryExpression4;
    PrimaryExpression primaryExpression5;
    PrimaryExpression primaryExpressionArrayAllocation;
    Expression expression;
    Expression expression2;
    Expression expression3;
    Expression expression4;
    PrintStatement printStatement;
    AndExpression andExpression;
    CompareExpression compareExpression;
    PlusExpression plusExpression;
    MinusExpression minusExpression;
    TimesExpression timesExpression;
    ArrayLookup arrayLookup;
    ExpressionRest expressionRest;
    TrueLiteral trueLiteral;
    FalseLiteral falseLiteral;
    Identifier identifier;
    Identifier identifier2;
    Identifier identifier3;
    Identifier identifier4;
    ThisExpression thisExpression;
    ArrayAssignmentStatement arrayAssignmentStatement;
    ArrayAllocationExpression arrayAllocationExpression;
    AllocationExpression allocationExpression;
    NotExpression notExpression;
    NotExpression notExpression2;
    BracketExpression bracketExpression;
    
    VarRef varRef;
    VarDeclaration varDeclaration;
    AssignmentStatement assignmentStatement;
    AssignmentStatement assignmentStatement2;
    
    Statement statement;
    Statement statement2;
    WhileStatement whileStatement;
    IfStatement ifStatement;
    FormalParameter formalParameter;
    FormalParameterRest formalParameterRest;
    
    NodeOptional nodeOptional;
    
    NodeListOptional nodeListOptional;
    Block block;
    ExpressionList expressionList;
    FormalParameterList formalParameterList;
    Goal goal;
    MainClass mainClass;
    ClassDeclaration classDeclaration;
    ClassExtendsDeclaration classExtendsDeclaration;
    TypeDeclaration typeDeclaration;
    TypeDeclaration typeDeclaration2;
    MethodDeclaration methodDeclaration;
    MethodDeclaration methodDeclaration2;

    @Before
    public void setUp(){
        env = new Environment();
        store = new Store();
        arg = new InterpreterArgument(env, store);
        interpreter = new Interpreter();

        integerValue1 = new IntegerValue(75);

        // MicroJava test fixtures

        nodeToken = new NodeToken("FooBar");
        nodeToken2 = new NodeToken("FooBarTwo");
        nodeToken3 = new NodeToken("FooBarThree");
        nodeToken4 = new NodeToken("FooBarFour");
        arrayType = new ArrayType();
        booleanType = new BooleanType();
        integerType = new IntegerType();
        type = new Type(
            new NodeChoice(integerType, 2));
        integerLiteral = new IntegerLiteral(
            new NodeToken("75"));
        integerLiteral2 = new IntegerLiteral(
            new NodeToken("89"));
        integerLiteral3 = new IntegerLiteral(
            new NodeToken("63"));
        primaryExpression = new PrimaryExpression(
            new NodeChoice(integerLiteral, 0));
        primaryExpression2 = new PrimaryExpression(
            new NodeChoice(integerLiteral2, 0));
        primaryExpression3 = new PrimaryExpression(
            new NodeChoice(integerLiteral3, 0));
        primaryExpression4 = new PrimaryExpression(
            new NodeChoice(new TrueLiteral(), 1));
        primaryExpression5 = new PrimaryExpression(
            new NodeChoice(new FalseLiteral(), 2));
        expression = new Expression(
            new NodeChoice(primaryExpression, 6));
        expression2 = new Expression(
            new NodeChoice(primaryExpression2, 6));
        expression3 = new Expression(
            new NodeChoice(primaryExpression3, 6));
        expression4 = new Expression(
            new NodeChoice(primaryExpression4, 6));
        printStatement = new PrintStatement(expression);
        compareExpression = new CompareExpression(
            primaryExpression,
            primaryExpression2);
        plusExpression = new PlusExpression(
            primaryExpression, primaryExpression2);
        minusExpression = new MinusExpression(primaryExpression,
                                              primaryExpression2);
        timesExpression = new TimesExpression(primaryExpression, primaryExpression2);
        expressionRest = new ExpressionRest(expression);
        trueLiteral = new TrueLiteral(nodeToken);
        falseLiteral = new FalseLiteral(nodeToken);

        andExpression = new AndExpression(primaryExpression4,
                                          primaryExpression5);
        identifier = new Identifier(nodeToken);
        identifier2 = new Identifier(nodeToken2);
        identifier3 = new Identifier(nodeToken3);
        identifier4 = new Identifier(nodeToken4);
        thisExpression = new ThisExpression();
        arrayAssignmentStatement = new ArrayAssignmentStatement(identifier, expression, expression2);
        arrayAllocationExpression = new ArrayAllocationExpression(expression);
        primaryExpressionArrayAllocation = new PrimaryExpression(new NodeChoice(
            arrayAllocationExpression, 5));
        arrayLookup = new ArrayLookup(primaryExpressionArrayAllocation,
                                      primaryExpression3);
        allocationExpression = new AllocationExpression(identifier);
        notExpression = new NotExpression(expression);
        notExpression2 = new NotExpression(expression4);
        bracketExpression = new BracketExpression(expression);
        varDeclaration = new VarDeclaration(type, identifier);
        assignmentStatement = new AssignmentStatement(
            new VarRef(
                new NodeChoice(identifier, 1)),
            expression);
        assignmentStatement2 = new AssignmentStatement(
            new VarRef(
                new NodeChoice(identifier2, 1)),
            expression2);
        statement = new Statement(
            new NodeChoice(assignmentStatement, 1));
        statement2 = new Statement(
            new NodeChoice(assignmentStatement2, 1));
        whileStatement = new WhileStatement(expression2,
                                            statement);
        ifStatement = new IfStatement(expression3,
                                      statement,
                                      statement2);
        formalParameter = new FormalParameter(type, identifier);
        formalParameterRest = new FormalParameterRest(formalParameter);

        nodeOptional = new NodeOptional(ifStatement);

        nodeListOptional = new NodeListOptional();
        nodeListOptional.addNode(expression);
        nodeListOptional.addNode(expression2);
        nodeListOptional.addNode(expression3);

        NodeListOptional tempListOptional =
                new NodeListOptional(statement);
        tempListOptional.addNode(statement2);
        block = new Block(tempListOptional);

        expressionList = new ExpressionList(
            expression2,
            new NodeListOptional(expressionRest));

        formalParameterList = new FormalParameterList(
            formalParameter,
            new NodeListOptional());

        // mainClass = new MainClass(
        //     identifier,
        //     identifier2,
        //     MicroJavaOutputter.pseudoMainClassName,
        //     MicroJavaOutputter.pseudoMainMethod,
        //     MicroJavaOutputter.mainMethodArg);

        // goal = new Goal(
        //     mainClass,
        //     new NodeListOptional(tempOutputter.getNewMainClass(printStatementMini)));
        classDeclaration = new ClassDeclaration(
            identifier,
            new NodeListOptional(),
            new NodeListOptional());

        classExtendsDeclaration = new ClassExtendsDeclaration(
            identifier,
            identifier2,
            new NodeListOptional(),
            new NodeListOptional());

        typeDeclaration = new TypeDeclaration(new NodeChoice(classDeclaration, 0));
        typeDeclaration2 = new TypeDeclaration(new NodeChoice(classExtendsDeclaration, 1));

        Expression methodReturnValue = expression2;
        // Statement methodReturnStatement =
        //         new Statement(new NodeChoice(
        //             new AssignmentStatement(
        //                 new VarRef(new NodeChoice(MicroJavaOutputter.getMethodRetVarIdentifier(identifier4), 1)),
        //                 expression3),
        //             1));

        NodeListOptional methodStatements = new NodeListOptional();
        methodStatements.addNode(statement2);
        // methodStatements.addNode(methodReturnStatement);
        methodDeclaration = new MethodDeclaration(
            identifier4,
            new NodeOptional(),
            new NodeListOptional(varDeclaration),
            methodStatements);

        Expression methodReturnValue2 = expression2;
        // Statement methodReturnStatement2 =
        //         new Statement(new NodeChoice(
        //             new AssignmentStatement(
        //                 new VarRef(new NodeChoice(MicroJavaOutputter.getMethodRetVarIdentifier(identifier4), 1)),
        //                 expression3),
        //             1));

        NodeListOptional methodStatements2
                = new NodeListOptional();
        methodStatements2.addNode(statement2);
        // methodStatements2.addNode(methodReturnStatement);
        // methodDeclaration2 = new MethodDeclaration(
        //     identifier4,
        //     new NodeOptional(),
        //     new NodeListOptional(
        //         outputter.getVarDeclaration(
        //             "test_variable",
        //             MicroJavaOutputter.getTempIdentifier(
        //                 MicroJavaOutputter.getMethodName(identifier4)))),
        //     methodStatements);

        varRef = new VarRef(new NodeChoice(identifier, 1));
    }
    
    @After
    public void tearDown(){
    }

    /**
     * Test method for {@link Interpreter#TrueLiteral()}.
     */
    @Test
    public final void testTrueLiteral(){
        assertEquals(new Result(new BooleanValue(true), store),
                     interpreter.visit(trueLiteral, arg));
    }

    /**
     * Test method for {@link Interpreter#FalseLiteral()}.
     */
    @Test
    public final void testFalseLiteral(){
        assertEquals(new Result(new BooleanValue(false), store),
                     interpreter.visit(falseLiteral, arg));
    }

    /**
     * Test method for {@link Interpreter#Identifier()}.
     */
    @Test
    public final void testIdentifier(){
        Location location = new Location();
        store.put(location, integerValue1);
        env.extend(identifier, location);

        assertEquals(new Result(integerValue1, store), 
                     interpreter.visit(identifier, arg));
    }

    /**
     * Test method for {@link Interpreter#ThisExpression()}.
     */
    @Test
    public final void testThisExpression(){
        Location location = new Location();

        // TODO(spradeep): This integerValue is just for testing
        // purposes. Later test with actual object.
        store.put(location, integerValue1);
        env.extend("this",
                   location);

        assertEquals(new Result(integerValue1, store), 
                     interpreter.visit(thisExpression, arg));
    }

    /**
     * Test method for {@link Interpreter#IntegerLiteral()}.
     */
    @Test
    public final void testIntegerLiteral(){
        assertEquals(new Result(new IntegerValue(75), store),
                     interpreter.visit(integerLiteral, arg));
    }

    /**
     * Test method for {@link Interpreter#ArrayAllocationExpression()}.
     */
    @Test
    public final void testArrayAllocationExpression(){
        assertEquals(new Result(new ArrayValue(75), store),
                     interpreter.visit(arrayAllocationExpression, arg));
    }

    /**
     * Test method for {@link Interpreter#BracketExpression()}.
     */
    @Test
    public final void testBracketExpression(){
        assertEquals(new Result(new IntegerValue(75), store),
                     interpreter.visit(bracketExpression, arg));
    }

    /**
     * Test method for {@link Interpreter#NotExpression()}.
     */
    @Test
    public final void testNotExpression(){
        assertEquals(new Result(new BooleanValue(false), store),
                     interpreter.visit(notExpression2, arg));

        // TODO(spradeep): Test for null objects being false 
    }

    // /**
    //  * Test method for {@link Interpreter#ExpressionRest()}.
    //  */
    // @Test
    // public final void testExpressionRest(){
    //     assertEquals(new Result(new BooleanValue(false), store),
    //                  interpreter.visit(notExpression2, arg));
    // }

    /**
     * Test method for {@link Interpreter#PrintStatement()}.
     */
    @Test
    public final void testPrintStatement(){
        assertEquals(new Result(null, store),
                     interpreter.visit(printStatement, arg));
    }

    /**
     * Test method for {@link Interpreter#TimesExpression()}.
     */
    @Test
    public final void testTimesExpression(){
        assertEquals(new Result(new IntegerValue(75 * 89), store),
                     interpreter.visit(timesExpression, arg));
    }

    /**
     * Test method for {@link Interpreter#MinusExpression()}.
     */
    @Test
    public final void testMinusExpression(){
        assertEquals(new Result(new IntegerValue(75 - 89), store),
                     interpreter.visit(minusExpression, arg));
    }

    /**
     * Test method for {@link Interpreter#PlusExpression()}.
     */
    @Test
    public final void testPlusExpression(){
        assertEquals(new Result(new IntegerValue(75 + 89), store),
                     interpreter.visit(plusExpression, arg));
    }

    /**
     * Test method for {@link Interpreter#CompareExpression()}.
     */
    @Test
    public final void testCompareExpression(){
        assertEquals(new Result(new BooleanValue(75 < 89), store),
                     interpreter.visit(compareExpression, arg));
    }

    /**
     * Test method for {@link Interpreter#AndExpression()}.
     */
    @Test
    public final void testAndExpression(){
        assertEquals(new Result(new BooleanValue(true && false), store),
                     interpreter.visit(andExpression, arg));
    }

    /**
     * Test method for {@link Interpreter#IntegerType()}.
     */
    @Test
    public final void testIntegerType(){
        assertEquals(new Result(null, store),
                     interpreter.visit(integerType, arg));
    }

    /**
     * Test method for {@link Interpreter#BooleanType()}.
     */
    @Test
    public final void testBooleanType(){
        assertEquals(new Result(null, store),
                     interpreter.visit(booleanType, arg));
    }

    /**
     * Test method for {@link Interpreter#ArrayType()}.
     */
    @Test
    public final void testArrayType(){
        assertEquals(new Result(null, store),
                     interpreter.visit(arrayType, arg));
    }

    /**
     * Test method for {@link Interpreter#Type()}.
     */
    @Test
    public final void testType(){
        Type type0 = new Type(new NodeChoice(arrayType, 0));
        Type type1 = new Type(new NodeChoice(booleanType, 1));
        Type type2 = new Type(new NodeChoice(integerType, 2));
        Type type3 = new Type(new NodeChoice(identifier, 3));

        assertEquals(new Result(null, store), interpreter.visit(type0, arg));
        assertEquals(new Result(null, store), interpreter.visit(type1, arg));
        assertEquals(new Result(null, store), interpreter.visit(type2, arg));
        assertEquals(new Result(null, store), interpreter.visit(type3, arg));
    }

    // /**
    //  * Test method for {@link Interpreter#VarDeclaration()}.
    //  */
    // @Test
    // public final void testVarDeclaration(){
    //     Result result = interpreter.visit(varDeclaration, arg);
    //     Location location = new Location();
    //     store.put(location, integerValue1);
    //     env.extend(identifier, location);
    //     assertEquals(new Result(null, store),
    //                  result);
    // }

    /**
     * Test method for {@link Interpreter#VarRef()}.
     */
    @Test
    public final void testVarRef(){
        Location location = new Location();
        store.put(location, integerValue1);
        env.extend(identifier, location);

        assertEquals(new Result(integerValue1, store),
                     interpreter.visit(varRef, arg));
    }

    // /**
    //  * Test method for {@link Interpreter#ArrayLookup()}.
    //  */
    // @Test
    // public final void testArrayLookup(){
    //     Location location = new Location();
    //     ArrayValue arrayValue = arrayLookup.f0.f0.choice;
    //     arrayValue.arr[63] = 10001;
    //     store.put(location, arrayValue);
    //     env.extend(identifier, location);

    //     System.out.println("arrayValue.arr: " + arrayValue.arr);
    //     assertEquals(new Result(new IntegerValue(10001), store),
    //                  interpreter.visit(arrayLookup, arg));
    // }
}
