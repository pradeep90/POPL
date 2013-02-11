import syntaxtree.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InterpreterTest{
    Environment env;
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
        arrayAssignmentStatement = new ArrayAssignmentStatement(identifier, expression3,
                                                                expression);
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

    public Identifier getNewIdentifier(String name){
        return new Identifier(new NodeToken(name));
    }

    /**
     * Test method for {@link Interpreter#TrueLiteral()}.
     */
    @Test
    public final void testTrueLiteral(){
        assertEquals(new BooleanValue(true),
                     interpreter.visit(trueLiteral, env));
    }

    /**
     * Test method for {@link Interpreter#FalseLiteral()}.
     */
    @Test
    public final void testFalseLiteral(){
        assertEquals(new BooleanValue(false),
                     interpreter.visit(falseLiteral, env));
    }

    /**
     * Test method for {@link Interpreter#Identifier()}.
     */
    @Test
    public final void testIdentifier(){
        env.extend(identifier, integerValue1);

        assertEquals(integerValue1, interpreter.visit(identifier, env));
    }

    /**
     * Test method for {@link Interpreter#ThisExpression()}.
     */
    @Test
    public final void testThisExpression(){
        // TODO(spradeep): This integerValue is just for testing
        // purposes. Later test with actual object.
        env.extend("this", integerValue1);

        assertEquals(integerValue1, interpreter.visit(thisExpression, env));
    }

    /**
     * Test method for {@link Interpreter#IntegerLiteral()}.
     */
    @Test
    public final void testIntegerLiteral(){
        assertEquals(new IntegerValue(75),
                     interpreter.visit(integerLiteral, env));
    }

    /**
     * Test method for {@link Interpreter#ArrayAllocationExpression()}.
     */
    @Test
    public final void testArrayAllocationExpression(){
        assertEquals(new ArrayValue(75),
                     interpreter.visit(arrayAllocationExpression, env));
    }

    /**
     * Test method for {@link Interpreter#BracketExpression()}.
     */
    @Test
    public final void testBracketExpression(){
        assertEquals(new IntegerValue(75),
                     interpreter.visit(bracketExpression, env));
    }

    /**
     * Test method for {@link Interpreter#NotExpression()}.
     */
    @Test
    public final void testNotExpression(){
        assertEquals(new BooleanValue(false),
                     interpreter.visit(notExpression2, env));

        // TODO(spradeep): Test for null objects being false 
    }

    // // /**
    // //  * Test method for {@link Interpreter#ExpressionRest()}.
    // //  */
    // // @Test
    // // public final void testExpressionRest(){
    // //     assertEquals(new BooleanValue(false),
    // //                  interpreter.visit(notExpression2, env));
    // // }

    /**
     * Test method for {@link Interpreter#PrintStatement()}.
     */
    @Test
    public final void testPrintStatement(){
        assertEquals(null, interpreter.visit(printStatement, env));
    }

    /**
     * Test method for {@link Interpreter#TimesExpression()}.
     */
    @Test
    public final void testTimesExpression(){
        assertEquals(new IntegerValue(75 * 89),
                     interpreter.visit(timesExpression, env));
    }

    /**
     * Test method for {@link Interpreter#MinusExpression()}.
     */
    @Test
    public final void testMinusExpression(){
        assertEquals(new IntegerValue(75 - 89),
                     interpreter.visit(minusExpression, env));
    }

    /**
     * Test method for {@link Interpreter#PlusExpression()}.
     */
    @Test
    public final void testPlusExpression(){
        assertEquals(new IntegerValue(75 + 89),
                     interpreter.visit(plusExpression, env));
    }

    /**
     * Test method for {@link Interpreter#CompareExpression()}.
     */
    @Test
    public final void testCompareExpression(){
        assertEquals(new BooleanValue(75 < 89),
                     interpreter.visit(compareExpression, env));
    }

    /**
     * Test method for {@link Interpreter#AndExpression()}.
     */
    @Test
    public final void testAndExpression(){
        assertEquals(new BooleanValue(true && false),
                     interpreter.visit(andExpression, env));
    }

    /**
     * Test method for {@link Interpreter#IntegerType()}.
     */
    @Test
    public final void testIntegerType(){
        assertEquals(new IntegerValue(), interpreter.visit(integerType, env));
    }

    /**
     * Test method for {@link Interpreter#BooleanType()}.
     */
    @Test
    public final void testBooleanType(){
        assertEquals(new BooleanValue(), interpreter.visit(booleanType, env));
    }

    /**
     * Test method for {@link Interpreter#ArrayType()}.
     */
    @Test
    public final void testArrayType(){
        assertEquals(new ArrayValue(), interpreter.visit(arrayType, env));
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

        assertEquals(new ArrayValue(), interpreter.visit(type0, env));
        assertEquals(new BooleanValue(), interpreter.visit(type1, env));
        assertEquals(new IntegerValue(), interpreter.visit(type2, env));
        assertEquals(null, interpreter.visit(type3, env));
    }

    /**
     * Test method for {@link Interpreter#VarDeclaration()}.
     */
    @Test
    public final void testVarDeclaration(){
        Value expectedVarValue = new IntegerValue();
        Value actual = interpreter.visit(varDeclaration, env);

        assertEquals(null, actual);
        assertEquals(expectedVarValue, env.lookup(identifier));
    }

    /**
     * Test method for {@link Interpreter#VarRef()}.
     */
    @Test
    public final void testVarRef(){
        env.extend(identifier, integerValue1);
        assertEquals(integerValue1, interpreter.visit(varRef, env));

        // TODO(spradeep): Test for dot expression
    }

    /**
     * Test method for {@link Interpreter#ArrayLookup()}.
     */
    @Test
    public final void testArrayLookup(){
        ArrayValue arrayValue = new ArrayValue(75);
        env.extend("foo", arrayValue);
        arrayValue.arr[63] = 10001;

        VarRef varRef = new VarRef(new NodeChoice(getNewIdentifier("foo"), 1));
        PrimaryExpression arrayPrimaryExpression = new PrimaryExpression(new NodeChoice(
            varRef, 3));

        ArrayLookup arrayLookup = new ArrayLookup(arrayPrimaryExpression,
                                                  primaryExpression3);
        assertEquals(new IntegerValue(10001),
                     interpreter.visit(arrayLookup, env));
    }

    /**
     * Test method for {@link Interpreter#ArrayAssignmentStatement()}.
     */
    @Test
    public final void testArrayAssignmentStatement(){
        ArrayValue arrayValue = new ArrayValue(75);
        env.extend("FooBar", arrayValue);

        assertEquals(null, interpreter.visit(arrayAssignmentStatement, env));
        ArrayValue actual = (ArrayValue) env.lookup("FooBar");
        assertEquals(75, actual.arr[63]);
    }

    /**
     * Test method for {@link Interpreter#AssignmentStatement()}.
     */
    @Test
    public final void testAssignmentStatement(){
        IntegerValue expected = new IntegerValue();
        env.extend("FooBar", expected);
        assertEquals(null, interpreter.visit(assignmentStatement, env));
        assertEquals(75, expected.integerValue);
    }

    /**
     * Test method for {@link Interpreter#IfStatement()}.
     */
    @Test
    public final void testIfStatement_True(){
        PrimaryExpression trueBooleanPrim = new PrimaryExpression(new NodeChoice(trueLiteral, 1));

        Expression trueCondExpr = new Expression(new NodeChoice(trueBooleanPrim, 6));

        IfStatement ifStatement1 = new IfStatement(trueCondExpr,
                                                   statement,
                                                   statement2);
        IntegerValue integerValue1 = new IntegerValue();
        IntegerValue integerValue2 = new IntegerValue();

        env.extend(identifier, integerValue1);
        env.extend(identifier2, integerValue2);

        assertEquals(null, interpreter.visit(ifStatement1, env));
        assertEquals(75, integerValue1.integerValue);
        assertEquals(new IntegerValue(), integerValue2);
    }

    /**
     * Test method for {@link Interpreter#IfStatement()}.
     */
    @Test
    public final void testIfStatement_False(){
        PrimaryExpression falseBooleanPrim = new PrimaryExpression(new NodeChoice(falseLiteral, 1));

        Expression falseCondExpr = new Expression(new NodeChoice(falseBooleanPrim, 6));

        IfStatement ifStatement1 = new IfStatement(falseCondExpr,
                                                   statement,
                                                   statement2);
        IntegerValue integerValue1 = new IntegerValue();
        IntegerValue integerValue2 = new IntegerValue();

        env.extend(identifier, integerValue1);
        env.extend(identifier2, integerValue2);

        assertEquals(null, interpreter.visit(ifStatement1, env));
        assertEquals(new IntegerValue(), integerValue1);
        assertEquals(89, integerValue2.integerValue);
    }

    /**
     * Test method for {@link Interpreter#WhileStatement()}.
     */
    @Test
    public final void testWhileStatement_NormalExecution(){
        IntegerValue integerValue = new IntegerValue();
        env.extend("foo", integerValue);

        
        VarRef varRef = new VarRef(new NodeChoice(getNewIdentifier("foo"), 1));
        PrimaryExpression varRefPrimaryExpression = new PrimaryExpression(new NodeChoice(
            varRef, 3));
        
        Expression compareExpression = new Expression(new NodeChoice(new CompareExpression(
            varRefPrimaryExpression,
            primaryExpression2), 1));

        // Creating another copy so that TreeFormatter doesn't give an error
        VarRef sameVarRef = new VarRef(new NodeChoice(getNewIdentifier("foo"), 1));
        PrimaryExpression sameVarRefPrimaryExpression = new PrimaryExpression(new NodeChoice(
            sameVarRef, 3));

        IntegerLiteral oneIntegerLiteral = new IntegerLiteral(new NodeToken("1"));
        PrimaryExpression incrPrimaryExpression = new PrimaryExpression(
            new NodeChoice(oneIntegerLiteral, 0));

        Expression plusExpression = new Expression(new NodeChoice(
            new PlusExpression(sameVarRefPrimaryExpression,
                               incrPrimaryExpression), 2));
        Statement incrStatement = new Statement(new NodeChoice(new AssignmentStatement(
            sameVarRef, plusExpression), 1));

        WhileStatement whileStatement = new WhileStatement(compareExpression,
                                                           incrStatement);

        assertEquals(null, interpreter.visit(whileStatement, env));
        assertEquals(89, integerValue.integerValue);
    }

    /**
     * Test method for {@link Interpreter#WhileStatement()}.
     */
    @Test
    public final void testWhileStatement_NoExecution(){
        IntegerValue integerValue = new IntegerValue(300);
        env.extend("foo", integerValue);

        
        VarRef varRef = new VarRef(new NodeChoice(getNewIdentifier("foo"), 1));
        PrimaryExpression varRefPrimaryExpression = new PrimaryExpression(new NodeChoice(
            varRef, 3));
        
        Expression compareExpression = new Expression(new NodeChoice(new CompareExpression(
            varRefPrimaryExpression,
            primaryExpression2), 1));

        // Creating another copy so that TreeFormatter doesn't give an error
        VarRef sameVarRef = new VarRef(new NodeChoice(getNewIdentifier("foo"), 1));
        PrimaryExpression sameVarRefPrimaryExpression = new PrimaryExpression(new NodeChoice(
            sameVarRef, 3));

        IntegerLiteral oneIntegerLiteral = new IntegerLiteral(new NodeToken("1"));
        PrimaryExpression incrPrimaryExpression = new PrimaryExpression(
            new NodeChoice(oneIntegerLiteral, 0));

        Expression plusExpression = new Expression(new NodeChoice(
            new PlusExpression(sameVarRefPrimaryExpression,
                               incrPrimaryExpression), 2));
        Statement incrStatement = new Statement(new NodeChoice(new AssignmentStatement(
            sameVarRef, plusExpression), 1));

        WhileStatement whileStatement = new WhileStatement(compareExpression,
                                                           incrStatement);

        assertEquals(null, interpreter.visit(whileStatement, env));
        assertEquals(300, integerValue.integerValue);
    }

    /**
     * Test method for {@link Interpreter#Block()}.
     */
    @Test
    public final void testBlock(){
        IntegerValue integerValue0 = new IntegerValue();
        IntegerValue integerValue1 = new IntegerValue();
        env.extend(identifier, integerValue0);
        env.extend(identifier2, integerValue1);

        assertEquals(null, interpreter.visit(block, env));
        assertEquals(75, integerValue0.integerValue);
        assertEquals(89, integerValue1.integerValue);
    }

    /**
     * Test method for {@link Interpreter#MethodDeclaration()}.
     */
    @Test
    public final void testMethodDeclaration(){
        String body = "";
        String codeString =
                "class MainOnly {" +
                "   public static void main(String [] a){" +
                "      new ____NewMainClass____().fooMethod();" +
                "   }" +
                "}" +
                "" +
                "class ____NewMainClass____{" +
                "" +
                "   public void fooMethod(){" +
                "" +
                body +
                "   }" +
                "}";

        Goal goal = (Goal)
                MicroJavaHelper.getMicroJavaNodeFromString(codeString);
        TypeDeclaration typeDeclaration =
                (TypeDeclaration) goal.f1.nodes.get(0);
        ClassDeclaration classDeclaration =
                (ClassDeclaration)
                typeDeclaration.f0.choice;
        MethodDeclaration methodDeclaration = (MethodDeclaration)
                classDeclaration.f4.nodes.get(0);

        System.out.println("MicroJavaHelper.getFormattedString(methodDeclaration): " + MicroJavaHelper.getFormattedString(methodDeclaration));

        ClosureValue expected = new ClosureValue(methodDeclaration);
        assertEquals(expected, interpreter.visit(methodDeclaration, env));
    }

    /**
     * Test method for {@link Interpreter#ClassDeclaration()}.
     */
    @Test
    public final void testClassDeclaration(){
        String body = "";
        String codeString =
                "class MainOnly {" +
                "   public static void main(String [] a){" +
                "      new ____NewMainClass____().fooMethod();" +
                "   }" +
                "}" +
                "" +
                "class ____NewMainClass____{" +
                "" +
                "   public void fooMethod(){" +
                "" +
                body +
                "   }" +
                "}";

        Goal goal = (Goal) MicroJavaHelper.getMicroJavaNodeFromString(codeString);
        TypeDeclaration typeDeclaration = (TypeDeclaration) goal.f1.nodes.get(0);
        ClassDeclaration classDeclaration = (ClassDeclaration) typeDeclaration.f0.choice;
        System.out.println("MicroJavaHelper.getFormattedString(classDeclaration): " + MicroJavaHelper.getFormattedString(classDeclaration));
        MethodDeclaration methodDeclaration = (MethodDeclaration)
                classDeclaration.f4.nodes.get(0);

        Environment methodTable = new Environment();
        methodTable.extend("fooMethod", new ClosureValue(methodDeclaration));
        ClassValue expected = new ClassValue(classDeclaration, methodTable);
        assertEquals(expected, interpreter.visit(classDeclaration, env));
    }

    /**
     * Test method for {@link Interpreter#ClassExtendsDeclaration()}.
     */
    @Test
    public final void testClassExtendsDeclaration(){
        String body = "";
        String codeString =
                "class MainOnly {" +
                "   public static void main(String [] a){" +
                "      new ____NewMainClass____().fooMethod();" +
                "   }" +
                "}" +
                "" +
                "class ____NewMainClass____ extends MainOnly{" +
                "" +
                "   public void fooMethod(){" +
                "" +
                body +
                "   }" +
                "}";

        Goal goal = (Goal) MicroJavaHelper.getMicroJavaNodeFromString(codeString);
        TypeDeclaration typeDeclaration = (TypeDeclaration) goal.f1.nodes.get(0);
        ClassExtendsDeclaration classExtendsDeclaration =
                (ClassExtendsDeclaration) typeDeclaration.f0.choice;
        System.out.println("MicroJavaHelper.getFormattedString(classExtendsDeclaration): " + MicroJavaHelper.getFormattedString(classExtendsDeclaration));

        MethodDeclaration methodDeclaration = (MethodDeclaration)
                classExtendsDeclaration.f6.nodes.get(0);

        Environment methodTable = new Environment();
        methodTable.extend("fooMethod", new ClosureValue(methodDeclaration));
        ClassValue expected = new ClassValue(classExtendsDeclaration, methodTable);
        assertEquals(expected, interpreter.visit(classExtendsDeclaration, env));
    }

    /**
     * Test method for {@link Interpreter#TypeDeclaration()}.
     */
    @Test
    public final void testTypeDeclaration(){
        String body = "";
        String codeString =
                "class MainOnly {" +
                "   public static void main(String [] a){" +
                "      new ____NewMainClass____().fooMethod();" +
                "   }" +
                "}" +
                "" +
                "class ____NewMainClass____ extends MainOnly{" +
                "" +
                "   public void fooMethod(){" +
                "" +
                body +
                "   }" +
                "}";

        Goal goal = (Goal) MicroJavaHelper.getMicroJavaNodeFromString(codeString);
        TypeDeclaration typeDeclaration = (TypeDeclaration) goal.f1.nodes.get(0);
        ClassExtendsDeclaration classExtendsDeclaration =
                (ClassExtendsDeclaration) typeDeclaration.f0.choice;
        MethodDeclaration methodDeclaration = (MethodDeclaration)
                classExtendsDeclaration.f6.nodes.get(0);

        Environment methodTable = new Environment();
        methodTable.extend("fooMethod", new ClosureValue(methodDeclaration));
        ClassValue expected = new ClassValue(classExtendsDeclaration, methodTable);
        assertEquals(null, interpreter.visit(typeDeclaration, env));
        assertEquals(expected, interpreter.symbolTable.get("____NewMainClass____"));
    }
}

