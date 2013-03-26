import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import visitor.*;
import syntaxtree.*;
import java.util.List;
import java.util.ArrayList;

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

    public void assertBigStringEquals(String expected, String actual){
        assertEquals(expected.replaceAll("(\n|\\s)+", ""),
                     actual.replaceAll("(\n|\\s)+", ""));
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

    public String getNanoJavaOutputForFile(String fileName){
        Transformer transformer = new Transformer();
        Goal goal = (Goal) CPSHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/" + fileName);
        String output = CPSHelper.getFormattedString(goal.accept(transformer));
        return output;
    }

    public void doConversionForMicroJavaFile(String fileName){
        CPSHelper.writeCodeToFile(getNanoJavaOutputForFile(fileName),
                                  "Generated-Nanojava/" + fileName);
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
        // assertEqualAfterTransform(ifStatementNano, ifStatement);
    }

    /**
     * Test method for {@link Transformer#MethodDeclaration()}.
     */
    @Test
    public final void testMethodDeclaration(){
        System.out.println("testMethodDeclaration"); 
        String output = CPSHelper.getFormattedString(
            getMethodDeclaration().accept(transformer));
    }

    /**
     * Test method for {@link Transformer#Goal()}.
     */
    @Test
    public final void testGoal(){
        Goal goal = (Goal) CPSHelper.getMicroJavaNodeFromFile(
            "Example-Microjava/Factorial.java");
        System.out.println("testGoal"); 
        String output = CPSHelper.getFormattedString(goal.accept(transformer));
    }

    /**
     * Test method for {@link Transformer#Block()}.
     */
    @Test
    public final void testBlock_createContinuationNoOriginalJumpPoint(){
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/BlockTest1.java"));

        // method2
        transformer.currMethod = (MethodDeclaration) classDeclaration.f4.nodes.get(1);
        Block block = new Block(((MethodDeclaration) classDeclaration.f4.nodes.get(1)).f8);
        // System.out.println("CPSHelper.getMicroFormattedString(block): "
        //                    + CPSHelper.getMicroFormattedString(block));

        String expectedBlockString = "{ c = a + b;  ___k1 = new ___ContinuationClasscontinuationMethod0();  ___k1.a = a;  ___k1.b = b; ___k1.___k = ___k; ___k1.object = this; foo.bar(___k1 ); }";
        assertBigStringEquals(expectedBlockString,
                              CPSHelper.getFormattedString(block.accept(transformer)));
    }

    /**
     * Test method for {@link Transformer#Block()}.
     */
    @Test
    public final void testBlock_JumpPointAtEnd(){
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/BlockTest1.java"));
        transformer.currMethod = (MethodDeclaration) classDeclaration.f4.nodes.get(2);

        // method3
        Block block = new Block(((MethodDeclaration) classDeclaration.f4.nodes.get(2)).f8);
        // System.out.println("CPSHelper.getMicroFormattedString(block): "
        //                    + CPSHelper.getMicroFormattedString(block));

        String expectedBlockString = "{ c = a + b;  d = 4;  ___k1 = new ___ContinuationClasscontinuationMethod0();  ___k1.a = a;  ___k1.b = b; ___k1.foo = foo;  ___k1.___k = ___k; ___k1.object = this; foo.bar(___k1 ); }";
        assertBigStringEquals(expectedBlockString, CPSHelper.getFormattedString(block.accept(transformer)));

        String expectedDeclaration = "___ContinuationClasscontinuationMethod0  ___k1 ;";
        assertBigStringEquals(expectedDeclaration,
                              CPSHelper.getFormattedString(transformer.currentMethodContinuationDeclarations.get(0)));
    }

    /**
     * Test method for {@link Transformer#()}.
     */
    @Test
    public final void testMakeContinuationMethod_localsNoParams(){
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/BlockTest1.java"));

        // method5
        MethodDeclaration parentMethod = (MethodDeclaration) classDeclaration.f4.nodes.get(4);
        ContinuationMaker continuationMaker = new ContinuationMaker(
            new NodeListOptional(),
            parentMethod,
            transformer,
            "___k",
            "fooContinuation");
        String expected = "public void fooContinuation (Continuation  ___k  ) { ____NewMainClass_______pseudoThis; ___pseudoThis=this;  ___k.call(); }";

        assertBigStringEquals(expected,
                              CPSHelper.getFormattedString(continuationMaker.continuationMethod));
    }

    /**
     * Test method for {@link Transformer#()}.
     */
    @Test
    public final void testMakeContinuationMethod_paramsNoLocals(){
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/BlockTest1.java"));

        // method6
        MethodDeclaration parentMethod = (MethodDeclaration) classDeclaration.f4.nodes.get(5);
        ContinuationMaker continuationMaker = new ContinuationMaker(
            new NodeListOptional(),
            parentMethod,
            transformer,
            "___k",
            "fooContinuation");

        String expected = "public void fooContinuation (int  m , int  n   , Continuation  ___k  ) {____NewMainClass____ ___pseudoThis; ___pseudoThis = this; ___k.call();}";
        assertBigStringEquals(expected,
                     CPSHelper.getFormattedString(continuationMaker.continuationMethod));
    }

    /**
     * Test method for {@link Transformer#()}.
     */
    @Test
    public final void testMakeContinuationMethod_paramsAndLocals(){
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/BlockTest1.java"));

        // method4
        MethodDeclaration parentMethod = (MethodDeclaration) classDeclaration.f4.nodes.get(3);
        List<nano.syntaxtree.Identifier> initializedVars = new ArrayList<nano.syntaxtree.Identifier>();
        initializedVars.add(CPSHelper.getNewIdentifier("c"));
        ContinuationMaker continuationMaker = new ContinuationMaker(
            new NodeListOptional(),
            parentMethod,
            transformer,
            "___k",
            "fooContinuation");

        String expected = "public void fooContinuation (int  a , int  b, Continuation  ___k  ) { ____NewMainClass____ ___pseudoThis; ___pseudoThis = this; ___k.call();}";

        assertBigStringEquals(expected,
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
            "___k",
            "fooContinuation");
        // System.out.println("CPSHelper.getFormattedString(continuationMaker.continuationMethod): " + CPSHelper.getFormattedString(continuationMaker.continuationMethod));
        String expected = "public void fooContinuation (Continuation  ___k ) { ____NewMainClass____ ___pseudoThis; ___pseudoThis=this; ___k.call(); }";

        assertBigStringEquals(expected,
                              CPSHelper.getFormattedString(continuationMaker.continuationMethod));
    }

    /**
     * Test method for {@link Transformer#()}.
     */
    @Test
    public final void testMakeContinuationMethod_simpleBody(){
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/BlockTest1.java"));

        // method4
        MethodDeclaration parentMethod = (MethodDeclaration) classDeclaration.f4.nodes.get(3);

        NodeListOptional statementList = new NodeListOptional();
        statementList.addNode(statement);
        statementList.addNode(statement2);

        ContinuationMaker continuationMaker = new ContinuationMaker(
            statementList,
            // new NodeListOptional(),
            parentMethod,
            transformer,
            "___k",
            "fooContinuation");
        // System.out.println("CPSHelper.getFormattedString(continuationMaker.continuationMethod): " + CPSHelper.getFormattedString(continuationMaker.continuationMethod));
        String expected = "public void fooContinuation (int  a , int  b   , Continuation  ___k  ) { ____NewMainClass____ ___pseudoThis; ___pseudoThis=this; foo=81; foo2 = 32;  ___k.call();}";

        assertBigStringEquals(expected,
                              CPSHelper.getFormattedString(continuationMaker.continuationMethod));
    }

    /**
     * Test method for {@link Transformer#()}.
     */
    @Test
    public final void testMakeContinuationMethod_initializeOnlyAtEnd(){
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/InitializeAfterTailForm.java"));

        // methodVariableInitializedOnlyAtTheEnd
        MethodDeclaration parentMethod = (MethodDeclaration) classDeclaration.f4.nodes.get(1);

        String codeString = "c = 10;";

        NodeListOptional statementList = CPSHelper.getMicroMethodDeclaration(codeString).f8;
        ContinuationMaker continuationMaker = new ContinuationMaker(
            statementList,
            parentMethod,
            transformer,
            "___k",
            "fooContinuation");
        String expected = "public void fooContinuation (int  a , int  b   , Continuation  ___k  ) { int c; ____NewMainClass____ ___pseudoThis; ___pseudoThis=this; c = 10; ___k.call();}";

        assertBigStringEquals(
            expected,
            CPSHelper.getFormattedString(continuationMaker.continuationMethod));
    }

    /**
     * Test method for {@link Transformer#()}.
     */
    @Test
    public final void testMakeContinuationMethod_initializeAfterPrint(){
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/InitializeAfterPrint.java"));

        // methodContinuationVariableInitializedAfterPrint
        MethodDeclaration parentMethod = (MethodDeclaration) classDeclaration.f4.nodes.get(1);

        String expected = "public void methodContinuationVariableInitializedAfterPrint(inta, intb, Continuation___k) { intc; ____NewMainClass____ foo;____NewMainClass____ ___pseudoThis; ___ContinuationClasscontinuationMethod0 ___k1; ___pseudoThis=this; c=a+b; if(c<2){System.out.println(0);___k1=new___ContinuationClasscontinuationMethod0();___k1.a=a;___k1.b=b;___k1.___k=___k;___k1.object=this;___k1.call();}else{System.out.println(1);___k1=new___ContinuationClasscontinuationMethod0();___k1.a=a;___k1.b=b;___k1.___k=___k;___k1.object=this;___k1.call();}}";

        assertBigStringEquals(
            expected,
            CPSHelper.getFormattedString(parentMethod.accept(transformer)));
    }

    /**
     * Test method for {@link Transformer#()}.
     */
    @Test
    public final void testMake___ContinuationClass(){
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/BlockTest1.java"));
        // method5
        MethodDeclaration parentMethod = (MethodDeclaration) classDeclaration.f4.nodes.get(4);

        NodeListOptional statementList = new NodeListOptional();
        statementList.addNode(statement);
        statementList.addNode(statement2);

        ContinuationMaker continuationMaker = new ContinuationMaker(
            statementList,
            // new NodeListOptional(),
            parentMethod,
            transformer,
            "___k2",
            "fooContinuation");
        // System.out.println("CPSHelper.getFormattedString(continuationMaker.continuationMethod): " + CPSHelper.getFormattedString(continuationMaker.continuationMethod));

        String expected = "class ___ContinuationClassfooContinuation extends Continuation { Continuation  ___k ; ____NewMainClass____  object ; public void call () { object.fooContinuation(___k); }}";
        assertBigStringEquals(expected,
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
            "___k2",
            "fooContinuation");

        String expected = "___k2 = new ___ContinuationClassfooContinuation(); ___k2.___k = ___k; ___k2.object = this;";
        assertBigStringEquals(expected,
                     CPSHelper.getFormattedString(continuationMaker.initStatements));
    }

    /**
     * Test method for {@link Transformer#()}.
     */
    @Test
    public final void testLiveVariable(){
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/LiveVariablesCase.java"));

        // methodLiveVariables
        MethodDeclaration parentMethod = (MethodDeclaration) classDeclaration.f4.nodes.get(1);

        String expectedMethodString = "public void methodLiveVariables (int  a , int  b   , Continuation  ___k  ) {int x ; int  y ; int  z ; ____NewMainClass____ ___pseudoThis; ___ContinuationClasscontinuationMethod0  ___k1 ; ___pseudoThis = this; x = 3; y = 4; ___k1 = new ___ContinuationClasscontinuationMethod0(); ___k1.a = a; ___k1.b = b; ___k1.___k = ___k; ___k1.object = this; foo.bar(___k1 );}";
        // System.out.println("CPSHelper.getFormattedString(parentMethod.accept(transformer)): " + CPSHelper.getFormattedString(parentMethod.accept(transformer)));

        // TODO: 
        assertBigStringEquals(expectedMethodString,
                              CPSHelper.getFormattedString(parentMethod.accept(transformer)));
    }

    /**
     * Test method for {@link Transformer#()}.
     */
    @Test
    public final void testLiveVariable_assignment(){
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/BlockTest1.java"));
        transformer.currMethod = (MethodDeclaration) classDeclaration.f4.nodes.get(2);
        NodeListOptional statements = ((MethodDeclaration) classDeclaration.f4.nodes.get(2)).f8;
        LiveVariableFinder liveVariableFinder1 = new LiveVariableFinder("c");
        Statement currStatement = (Statement) statements.nodes.get(0);
        assertEquals(true, currStatement.accept(liveVariableFinder1));
        assertEquals(false, liveVariableFinder1.isLive);

        LiveVariableFinder liveVariableFinder2 = new LiveVariableFinder("a");
        currStatement = (Statement) statements.nodes.get(0);
        assertEquals(true, currStatement.accept(liveVariableFinder2));
        assertEquals(true, liveVariableFinder2.isLive);
    }

    /**
     * Test method for {@link Transformer#tryFlattenBlock()}.
     */
    @Test
    public final void testTryFlattenBlock(){
        System.out.println("testTryFlattenBlock"); 
        ClassDeclaration classDeclaration = getClassDeclaration(CPSHelper.getMicroJavaNodeFromFile("Example-Microjava/My-Basic-Test-Cases/BlockTest1.java"));
        NodeListOptional statements = ((MethodDeclaration) classDeclaration.f4.nodes.get(8)).f8;
    }

    @Test
    public final void testNestedIfWhile(){
        System.out.println("testNestedIfWhile"); 
        doConversionForMicroJavaFile("My-Basic-Test-Cases/NestedIfWhile.java");
    }

    @Test
    public final void testBinarySearch(){
        System.out.println("testBinarySearch: ");
        doConversionForMicroJavaFile("BinarySearch.java");
    }

    @Test
    public final void testBinaryTree(){
        System.out.println("testBinaryTree: ");
        doConversionForMicroJavaFile("BinaryTree.java");
    }

    // @Test
    // public final void testQuickSort(){
    //     doConversionForMicroJavaFile("QuickSort.java");
    // }

    // @Test
    // public final void testFactorial(){
    //     System.out.println("testFactorial"); 
    //     doConversionForMicroJavaFile("Factorial.java");
    // }

    @Test
    public final void testOutputForFiles(){
        // String fileName = "Factorial.java";
        String[] fileNameList = {
            "BinarySearch.java",
            "BinaryTree.java",
            "BubbleSort.java",
            "Factorial.java",
            "LinearSearch.java",
            "LinkedList.java",
            "QuickSort.java",
            "TreeVisitor.java",

            "TA-MicroJava-Test-Cases/ComplexAssignments.java",
            "TA-MicroJava-Test-Cases/DotTest.java",
            "TA-MicroJava-Test-Cases/IfCheck.java",
            "TA-MicroJava-Test-Cases/MainArguments.java",
            "TA-MicroJava-Test-Cases/MethodArgs.java",
            "TA-MicroJava-Test-Cases/MethodReturn.java",
            "TA-MicroJava-Test-Cases/MultilevelInherit.java",
            "TA-MicroJava-Test-Cases/NestedIfCheck.java",
            "TA-MicroJava-Test-Cases/NextedWhile.java",
            "TA-MicroJava-Test-Cases/PrintTest.java",
            "TA-MicroJava-Test-Cases/SimpleAssignments.java",
            "TA-MicroJava-Test-Cases/SimpleMain.java",
            "TA-MicroJava-Test-Cases/ThisExpr.java",
            "TA-MicroJava-Test-Cases/WhileCheck.java",

        };
        for (String fileName : fileNameList){
            System.out.println("fileName: " + fileName);
            try {
                doConversionForMicroJavaFile(fileName);
            } catch(Exception e) {
                e.printStackTrace();
            }

        }
    }
}
