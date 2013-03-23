import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import visitor.*;
import syntaxtree.*;

public class TransformerTest{
    Transformer transformer;

    NodeToken nodeToken;
    nano.syntaxtree.NodeToken nodeTokenNano;
    NodeToken nodeToken2;
    nano.syntaxtree.NodeToken nodeTokenNano2;
    Identifier identifier;
    nano.syntaxtree.Identifier identifierNano;
    Identifier identifier2;
    nano.syntaxtree.Identifier identifierNano2;
    IntegerLiteral integerLiteral;
    nano.syntaxtree.IntegerLiteral integerLiteralNano;
    IntegerLiteral integerLiteral2;
    nano.syntaxtree.IntegerLiteral integerLiteralNano2;
    TrueLiteral trueLiteral;
    nano.syntaxtree.TrueLiteral trueLiteralNano;
    FalseLiteral falseLiteral;
    nano.syntaxtree.FalseLiteral falseLiteralNano;

    nano.syntaxtree.Expression currContinuationVarRef;
    MessageSendStatement messageSendStatement;
    nano.syntaxtree.MessageSendStatement messageSendStatementNano;

    PrimaryExpression primaryExpression;
    nano.syntaxtree.PrimaryExpression primaryExpressionNano;
    Expression expression;
    nano.syntaxtree.Expression expressionNano;
    VarRef varRef;
    nano.syntaxtree.VarRef varRefNano;
    AssignmentStatement assignmentStatement;
    nano.syntaxtree.AssignmentStatement assignmentStatementNano;
    Statement statement;
    nano.syntaxtree.Statement statementNano;

    PrimaryExpression primaryExpression2;
    nano.syntaxtree.PrimaryExpression primaryExpressionNano2;
    Expression expression2;
    nano.syntaxtree.Expression expressionNano2;
    VarRef varRef2;
    nano.syntaxtree.VarRef varRefNano2;
    AssignmentStatement assignmentStatement2;
    nano.syntaxtree.AssignmentStatement assignmentStatementNano2;
    Statement statement2;
    nano.syntaxtree.Statement statementNano2;

    Block block;
    nano.syntaxtree.Block blockNano;
    IfStatement ifStatement;
    nano.syntaxtree.IfStatement ifStatementNano;

    @Before
    public void setUp(){
        transformer = new Transformer();
        // For testing purposes
        transformer.currClassName = "____NewMainClass____";

        nodeToken = new NodeToken("foo");
        nodeTokenNano = new nano.syntaxtree.NodeToken("foo");
        nodeToken2 = new NodeToken("foo2");
        nodeTokenNano2 = new nano.syntaxtree.NodeToken("foo2");
        identifier = new Identifier(nodeToken);
        identifierNano = new nano.syntaxtree.Identifier(nodeTokenNano);
        identifier2 = new Identifier(nodeToken2);
        identifierNano2 = new nano.syntaxtree.Identifier(nodeTokenNano2);
        integerLiteral = new IntegerLiteral(new NodeToken("81"));
        integerLiteralNano = new nano.syntaxtree.IntegerLiteral(
            new nano.syntaxtree.NodeToken("81"));
        integerLiteral2 = new IntegerLiteral(new NodeToken("32"));
        integerLiteralNano2 = new nano.syntaxtree.IntegerLiteral(
            new nano.syntaxtree.NodeToken("32"));
        trueLiteral = new TrueLiteral();
        trueLiteralNano = new nano.syntaxtree.TrueLiteral();
        falseLiteral = new FalseLiteral();
        falseLiteralNano = new nano.syntaxtree.FalseLiteral();

        currContinuationVarRef = new nano.syntaxtree.Expression(new nano.syntaxtree.NodeChoice(
            new nano.syntaxtree.PrimaryExpression(
                new nano.syntaxtree.NodeChoice(
                    new nano.syntaxtree.VarRef(
                        new nano.syntaxtree.NodeChoice(CPSHelper.getNewIdentifier(
                            transformer.getCurrentContinuationName()), 1)),
                    3)), 6));
        messageSendStatement = new MessageSendStatement(identifier, identifier2,
                                                        new NodeOptional());
        messageSendStatementNano = new nano.syntaxtree.MessageSendStatement(
            identifierNano, identifierNano2, new nano.syntaxtree.NodeOptional(
                new nano.syntaxtree.ExpressionList(
                    currContinuationVarRef, new nano.syntaxtree.NodeListOptional())));

        primaryExpression = new PrimaryExpression(new NodeChoice(integerLiteral, 0));
        primaryExpressionNano = new nano.syntaxtree.PrimaryExpression(
            new nano.syntaxtree.NodeChoice(integerLiteralNano, 0));
        primaryExpression2 = new PrimaryExpression(new NodeChoice(integerLiteral2, 0));
        primaryExpressionNano2 = new nano.syntaxtree.PrimaryExpression(
            new nano.syntaxtree.NodeChoice(integerLiteralNano2, 0));
        expression = new Expression(new NodeChoice(primaryExpression, 6));
        expressionNano = new nano.syntaxtree.Expression(
            new nano.syntaxtree.NodeChoice(primaryExpressionNano, 6));
        expression2 = new Expression(new NodeChoice(primaryExpression2, 6));
        expressionNano2 = new nano.syntaxtree.Expression(
            new nano.syntaxtree.NodeChoice(primaryExpressionNano2, 6));
        varRef = new VarRef(new NodeChoice(identifier, 1));
        varRefNano = new nano.syntaxtree.VarRef(
            new nano.syntaxtree.NodeChoice(identifierNano, 1));
        varRef2 = new VarRef(new NodeChoice(identifier2, 1));
        varRefNano2 = new nano.syntaxtree.VarRef(
            new nano.syntaxtree.NodeChoice(identifierNano2, 1));

        assignmentStatement = new AssignmentStatement(varRef, expression);
        assignmentStatementNano = new nano.syntaxtree.AssignmentStatement(
            varRefNano, expressionNano);
        assignmentStatement2 = new AssignmentStatement(varRef2, expression2);
        assignmentStatementNano2 = new nano.syntaxtree.AssignmentStatement(
            varRefNano2, expressionNano2);

        statement = new Statement(new NodeChoice(assignmentStatement, 1));
        statementNano = new nano.syntaxtree.Statement(
            new nano.syntaxtree.NodeChoice(assignmentStatementNano, 0));

        statement2 = new Statement(new NodeChoice(assignmentStatement2, 1));
        statementNano2 = new nano.syntaxtree.Statement(
            new nano.syntaxtree.NodeChoice(assignmentStatementNano2, 0));

        NodeListOptional statementList = new NodeListOptional();
        statementList.addNode(statement);
        // statementList.addNode(new Statement(new NodeChoice(messageSendStatement, 6)));
        block = new Block(statementList);

        nano.syntaxtree.NodeListOptional statementListNano =
                new nano.syntaxtree.NodeListOptional();
        statementListNano.addNode(statementNano);
        blockNano = new nano.syntaxtree.Block(
            statementListNano,
            new nano.syntaxtree.JumpPoint(new nano.syntaxtree.NodeChoice(transformer.getDefaultContinuationCall(), 1)));

        ifStatement = new IfStatement(expression, statement, statement2);
        ifStatementNano = new nano.syntaxtree.IfStatement(
            expressionNano,
            transformer.getNanoBlock(statement),
            transformer.getNanoBlock(statement2));}
    
    
    @After
    public void tearDown(){
    }
    
    /** 
     * Assert that NanoJava transformation of microJavaNode is the
     * same as expectedNanoJavaNode.
     */
    public void assertEqualAfterTransform(
        nano.syntaxtree.Node expectedNanoJavaNode,
        Node microJavaNode){

        assertEquals(CPSHelper.getFormattedString(expectedNanoJavaNode),
                     CPSHelper.getFormattedString(
                         microJavaNode.accept(transformer)));
    }

    /** 
     * Assert that node1 and node2 are equal NanoJava nodes.
     */
    public void assertEqualNanoJavaNodes(nano.syntaxtree.Node expected,
                                         nano.syntaxtree.Node actual){
        assertEquals(CPSHelper.getFormattedString(expected),
                     CPSHelper.getFormattedString(actual));
    }

    public static ClassDeclaration getClassDeclaration(Node node){
        Goal goal = (Goal) node;
        ClassDeclaration classDeclaration = (ClassDeclaration)
                ((TypeDeclaration) goal.f1.nodes.get(0)).f0.choice;
        return classDeclaration;
    }

    public static ClassDeclaration getClassDeclaration(String code){
        Goal goal = (Goal) CPSHelper.getMicroJavaNodeFromString(code);
        return getClassDeclaration(goal);
    }

    public static MethodDeclaration getMethodDeclaration(String code){
        MethodDeclaration methodDeclaration = (MethodDeclaration)
                getClassDeclaration(code).f4.nodes.get(0);
        return methodDeclaration;
    }

    public static MethodDeclaration getMethodDeclaration(){
        String code = "" +
                "class MainClass {" +
                "   public static void main(String [] a){" +
                "      new ____NewMainClass____().____Main____(0);" +
                "   }" +
                "}" +
                "class ____NewMainClass____{" +
                "" +
                "   public void ____Main____(int ____arg_length____){" +
                "      int ____printMe____;" +
                "      Fac ___tmp6;" +
                "      int ___tmp5;" +
                "" +
                "      ___tmp6 =" +
                "         new Fac();" +
                "      ___tmp6.ComputeFac(10);" +
                "      ___tmp5 = ___tmp6.____1234ComputeFac4321____;" +
                "      ____printMe____ = ___tmp5;" +
                "      System.out.println(____printMe____);" +
                "   }" +
                "   public void foo(){}" +
                "}";
        return getMethodDeclaration(code);
    }

    public static ClassDeclaration getClassDeclaration(){
        String code = "" +
                "class MainClass {" +
                "   public static void main(String [] a){" +
                "      new ____NewMainClass____().____Main____(0);" +
                "   }" +
                "}" +
                "class ____NewMainClass____{" +
                "" +
                "   public void ____Main____(int ____arg_length____){" +
                "      int ____printMe____;" +
                "      Fac ___tmp6;" +
                "      int ___tmp5;" +
                "" +
                "      ___tmp6 =" +
                "         new Fac();" +
                "      ___tmp6.ComputeFac(10);" +
                "      ___tmp5 = ___tmp6.____1234ComputeFac4321____;" +
                "      ____printMe____ = ___tmp5;" +
                "      System.out.println(____printMe____);" +
                "   }" +
                "   public void foo(){}" +
                "}";
        return getClassDeclaration(code);
    }

    /**
     * Test method for {@link Transformer#NodeToken()}.
     */
    @Test
    public final void testNodeToken(){
        assertEqualAfterTransform(nodeTokenNano, nodeToken);
    }

    /**
     * Test method for {@link Transformer#IntegerLiteral()}.
     */
    @Test
    public final void testIntegerLiteral(){
        assertEqualAfterTransform(integerLiteralNano, integerLiteral);
    }

    /**
     * Test method for {@link Transformer#TrueLiteral()}.
     */
    @Test
    public final void testTrueLiteral(){
        assertEqualAfterTransform(trueLiteralNano, trueLiteral);
    }

    /**
     * Test method for {@link Transformer#FalseLiteral()}.
     */
    @Test
    public final void testFalseLiteral(){
        assertEqualAfterTransform(falseLiteralNano, falseLiteral);
    }

    /**
     * Test method for {@link Transformer#Identifier()}.
     */
    @Test
    public final void testIdentifier(){
        assertEqualAfterTransform(identifierNano, identifier);
    }

    /**
     * Test method for {@link Transformer#MessageSendStatement()}.
     */
    @Test
    public final void testMessageSendStatement(){
        assertEqualAfterTransform(messageSendStatementNano, messageSendStatement);
    }

    /**
     * Test method for {@link Transformer#VarRef()}.
     */
    @Test
    public final void testVarRef(){
        assertEqualAfterTransform(varRefNano, varRef);
    }

    /**
     * Test method for {@link Transformer#Expression()}.
     */
    @Test
    public final void testExpression(){
        assertEqualAfterTransform(expressionNano, expression);
    }

    /**
     * Test method for {@link Transformer#AssignmentStatement()}.
     */
    @Test
    public final void testAssignmentStatement(){
        assertEqualAfterTransform(assignmentStatementNano, assignmentStatement);
    }

    /**
     * Test method for {@link Transformer#Statement()}.
     */
    @Test
    public final void testStatement(){
        assertEqualAfterTransform(statementNano, statement);
    }

    /**
     * Test method for {@link Transformer#Block()}.
     */
    @Test
    public final void testBlock_Simple(){
        assertEqualAfterTransform(blockNano, block);
    }

    /**
     * Test method for {@link Transformer#IfStatement()}.
     */
    @Test
    public final void testIfStatement(){
        assertEqualAfterTransform(ifStatementNano, ifStatement);
    }

    /**
     * Test method for {@link Transformer#MethodDeclaration()}.
     */
    @Test
    public final void testMethodDeclaration(){
        String output = CPSHelper.getFormattedString(
            getMethodDeclaration().accept(transformer));
    }

    /**
     * Test method for {@link Transformer#Goal()}.
     */
    @Test
    public final void testGoal(){
        Goal goal = (Goal) CPSHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/My-Basic-Test-Cases/BlockTest1.java");
        System.out.println("testGoal"); 
        String output = CPSHelper.getFormattedString(goal.accept(transformer));
        System.out.println("output: " + output);
    }

    /**
     * Test method for {@link Transformer#Block()}.
     */
    @Test
    public final void testBlock_createContinuationNoOriginalJumpPoint(){
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/BlockTest1.java"));
        transformer.currMethod = (MethodDeclaration) classDeclaration.f4.nodes.get(1);
        Block block = new Block(((MethodDeclaration) classDeclaration.f4.nodes.get(1)).f8);
        System.out.println("CPSHelper.getMicroFormattedString(block): "
                           + CPSHelper.getMicroFormattedString(block));

        String expectedBlockString = "{ c = a + b;  k1 = new ContinuationClasscontinuationMethod0();  k1.a = a;  k1.b\n"
                + "   = b;  k1.c = c;  k1.d = d;  k1.foo = foo;  k1.k = k; foo.bar(k1 ); }";
        assertEquals(expectedBlockString, CPSHelper.getFormattedString(block.accept(transformer)));
    }

    /**
     * Test method for {@link Transformer#Block()}.
     */
    @Test
    public final void testBlock_JumpPointAtEnd(){
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/BlockTest1.java"));
        transformer.currMethod = (MethodDeclaration) classDeclaration.f4.nodes.get(2);
        Block block = new Block(((MethodDeclaration) classDeclaration.f4.nodes.get(2)).f8);
        System.out.println("CPSHelper.getMicroFormattedString(block): "
                           + CPSHelper.getMicroFormattedString(block));

        String expectedBlockString = "{ c = a + b;  d = 4;  k1 = new ContinuationClasscontinuationMethod0();  k1.a =\n"
                + "   a;  k1.b = b;  k1.c = c;  k1.d = d;  k1.foo = foo;  k1.k = k; foo.bar(k1 );\n"
                + "   }";
        assertEquals(expectedBlockString, CPSHelper.getFormattedString(block.accept(transformer)));
    }

    /**
     * Test method for {@link Transformer#()}.
     */
    @Test
    public final void testMakeContinuationMethod_localsNoParams(){
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/BlockTest1.java"));
        MethodDeclaration parentMethod = (MethodDeclaration) classDeclaration.f4.nodes.get(4);
        ContinuationMaker continuationMaker = new ContinuationMaker(
            new NodeListOptional(),
            parentMethod,
            transformer,
            "k",
            "fooContinuation");
        // System.out.println("CPSHelper.getFormattedString(continuationMaker.continuationMethod): " + CPSHelper.getFormattedString(continuationMaker.continuationMethod));
        String expected = "public void fooContinuation (int  x , boolean  y   , Continuation  k  ) { k.\n"
                + "   call(); }";

        assertEquals(expected,
                     CPSHelper.getFormattedString(continuationMaker.continuationMethod));
    }

    /**
     * Test method for {@link Transformer#()}.
     */
    @Test
    public final void testMakeContinuationMethod_paramsNoLocals(){
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/BlockTest1.java"));
        MethodDeclaration parentMethod = (MethodDeclaration) classDeclaration.f4.nodes.get(5);
        ContinuationMaker continuationMaker = new ContinuationMaker(
            new NodeListOptional(),
            parentMethod,
            transformer,
            "k",
            "fooContinuation");
        // System.out.println("CPSHelper.getFormattedString(continuationMaker.continuationMethod): " + CPSHelper.getFormattedString(continuationMaker.continuationMethod));
        String expected = "public void fooContinuation (int  m , int  n   , Continuation  k  ) { k.call();\n"
                + "   }";

        assertEquals(expected,
                     CPSHelper.getFormattedString(continuationMaker.continuationMethod));
    }

    /**
     * Test method for {@link Transformer#()}.
     */
    @Test
    public final void testMakeContinuationMethod_paramsAndLocals(){
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/BlockTest1.java"));
        MethodDeclaration parentMethod = (MethodDeclaration) classDeclaration.f4.nodes.get(3);
        ContinuationMaker continuationMaker = new ContinuationMaker(
            new NodeListOptional(),
            parentMethod,
            transformer,
            "k",
            "fooContinuation");
        // System.out.println("CPSHelper.getFormattedString(continuationMaker.continuationMethod): " + CPSHelper.getFormattedString(continuationMaker.continuationMethod));
        String expected = "public void fooContinuation (int  a , int  b   , int  c   , boolean  d   ,\n"
                + "   Continuation  k  ) { k.call(); }";

        assertEquals(expected,
                     CPSHelper.getFormattedString(continuationMaker.continuationMethod));
    }

    /**
     * Test method for {@link Transformer#()}.
     */
    @Test
    public final void testMakeContinuationMethod_noParamsNoLocals(){
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/BlockTest1.java"));
        MethodDeclaration parentMethod = (MethodDeclaration) classDeclaration.f4.nodes.get(6);
        ContinuationMaker continuationMaker = new ContinuationMaker(
            new NodeListOptional(),
            parentMethod,
            transformer,
            "k",
            "fooContinuation");
        // System.out.println("CPSHelper.getFormattedString(continuationMaker.continuationMethod): " + CPSHelper.getFormattedString(continuationMaker.continuationMethod));
        String expected = "public void fooContinuation (Continuation  k ) { k.call(); }";

        assertEquals(expected,
                     CPSHelper.getFormattedString(continuationMaker.continuationMethod));
    }

    /**
     * Test method for {@link Transformer#()}.
     */
    @Test
    public final void testMakeContinuationMethod_simpleBody(){
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/BlockTest1.java"));
        MethodDeclaration parentMethod = (MethodDeclaration) classDeclaration.f4.nodes.get(3);

        NodeListOptional statementList = new NodeListOptional();
        statementList.addNode(statement);
        statementList.addNode(statement2);

        ContinuationMaker continuationMaker = new ContinuationMaker(
            statementList,
            // new NodeListOptional(),
            parentMethod,
            transformer,
            "k",
            "fooContinuation");
        // System.out.println("CPSHelper.getFormattedString(continuationMaker.continuationMethod): " + CPSHelper.getFormattedString(continuationMaker.continuationMethod));
        String expected = "public void fooContinuation (int  a , int  b   , int  c   , boolean  d   ,\n"
                + "   Continuation  k  ) { foo = 81;  foo2 = 32; k.call(); }";

        assertEquals(expected,
                     CPSHelper.getFormattedString(continuationMaker.continuationMethod));
    }

    /**
     * Test method for {@link Transformer#()}.
     */
    @Test
    public final void testMakeContinuationClass(){
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/BlockTest1.java"));
        MethodDeclaration parentMethod = (MethodDeclaration) classDeclaration.f4.nodes.get(4);

        NodeListOptional statementList = new NodeListOptional();
        statementList.addNode(statement);
        statementList.addNode(statement2);

        ContinuationMaker continuationMaker = new ContinuationMaker(
            statementList,
            // new NodeListOptional(),
            parentMethod,
            transformer,
            "k2",
            "fooContinuation");
        // System.out.println("CPSHelper.getFormattedString(continuationMaker.continuationMethod): " + CPSHelper.getFormattedString(continuationMaker.continuationMethod));

        String expected = "class ContinuationClassfooContinuation extends Continuation { int  x ; boolean\n"
                + "   y ; Continuation  k ; ____NewMainClass____  object ; public void call () {\n"
                + "   object.fooContinuation(x , y , k); }}";
        assertEquals(expected,
                     CPSHelper.getFormattedString(continuationMaker.continuationClass));
    }

    /**
     * Test method for {@link Transformer#()}.
     */
    @Test
    public final void testMakeInitStatements(){
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/BlockTest1.java"));
        MethodDeclaration parentMethod = (MethodDeclaration) classDeclaration.f4.nodes.get(4);

        NodeListOptional statementList = new NodeListOptional();
        statementList.addNode(statement);
        statementList.addNode(statement2);

        ContinuationMaker continuationMaker = new ContinuationMaker(
            statementList,
            parentMethod,
            transformer,
            "k2",
            "fooContinuation");

        String expected = "k2 = new ContinuationClassfooContinuation(); k2.x = x; k2.y = y; k2.k = k;";
        assertEquals(expected,
                     CPSHelper.getFormattedString(continuationMaker.initStatements));
    }
}
