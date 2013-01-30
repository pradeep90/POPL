import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import visitor.*;
import syntaxtree.*;
import microjavaparser.*;
import microjavaparser.visitor.TreeFormatter;
import microjavaparser.visitor.TreeDumper;

// import java.text.ParseException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.File;
import java.net.URL;
 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MicroJavaOutputterTest {
    MicroJavaOutputter outputter;

    final String BASE_DIR = "/home/pradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests";
    final String MICRO_JAVA_DIR = "Micro-Java-Test-Code";
    final String MINI_JAVA_DIR = "Mini-Java-Test-Code";
    final String MICRO_JAVA_EXTENSION = ".microjava";
    final String MINI_JAVA_EXTENSION = ".minijava";

    // MiniJava test fixtures
    NodeToken nodeTokenMini = new NodeToken("FooBar");
    NodeToken nodeTokenMini2 = new NodeToken("FooBarTwo");
    ArrayType arrayTypeMini = new ArrayType();
    BooleanType booleanTypeMini = new BooleanType();
    IntegerLiteral integerLiteralMini = new IntegerLiteral(new NodeToken("75"));
    IntegerLiteral integerLiteralMini2 = new IntegerLiteral(new NodeToken("89"));
    IntegerLiteral integerLiteralMini3 = new IntegerLiteral(new NodeToken("63"));
    PrimaryExpression primaryExpressionMini = new PrimaryExpression(
        new NodeChoice(integerLiteralMini, 0));
    PrimaryExpression primaryExpressionMini2 = new PrimaryExpression(
        new NodeChoice(integerLiteralMini2, 0));
    PrimaryExpression primaryExpressionMini3 = new PrimaryExpression(
        new NodeChoice(integerLiteralMini3, 0));
    Expression expressionMini = new Expression(new NodeChoice(primaryExpressionMini,
                                                              6));
    Expression expressionMini2 = new Expression(new NodeChoice(primaryExpressionMini2,
                                                               6));
    Expression expressionMini3 = new Expression(new NodeChoice(primaryExpressionMini3,
                                                               6));
    ArrayLookup arrayLookupMini = new ArrayLookup(primaryExpressionMini,
                                                  primaryExpressionMini2);
    BracketExpression bracketExpressionMini = new BracketExpression(expressionMini);
    ExpressionRest expressionRestMini = new ExpressionRest(expressionMini);
    FalseLiteral falseLiteralMini = new FalseLiteral(nodeTokenMini);
    Identifier identifierMini = new Identifier(nodeTokenMini);
    Identifier identifierMini2 = new Identifier(nodeTokenMini2);
    ArrayAssignmentStatement arrayAssignmentStatementMini = new ArrayAssignmentStatement(identifierMini, expressionMini, expressionMini2);
    AllocationExpression allocationExpressionMini = new AllocationExpression(identifierMini);
    ArrayAllocationExpression arrayAllocationExpressionMini = new ArrayAllocationExpression(expressionMini);

    AssignmentStatement assignmentStatementMini = new AssignmentStatement(identifierMini,
                                                                          expressionMini);
    AssignmentStatement assignmentStatementMini2 = new AssignmentStatement(identifierMini2,
                                                                          expressionMini2);
    IntegerType integerTypeMini = new IntegerType();
    AndExpression andExpressionMini = new AndExpression(primaryExpressionMini,
                                                        primaryExpressionMini2);
    CompareExpression compareExpressionMini = new CompareExpression(
        primaryExpressionMini,
        primaryExpressionMini2);
    MinusExpression minusExpressionMini = new MinusExpression(primaryExpressionMini,
                                                              primaryExpressionMini2);
    NotExpression notExpressionMini = new NotExpression(expressionMini);
    PlusExpression plusExpressionMini = new PlusExpression(primaryExpressionMini,
                                                           primaryExpressionMini2);
    PrintStatement printStatementMini = new PrintStatement(expressionMini);
    Statement statementMini = new Statement(new NodeChoice(assignmentStatementMini, 1));
    Statement statementMini2 = new Statement(new NodeChoice(assignmentStatementMini2, 1));
    ThisExpression thisExpressionMini = new ThisExpression();
    TimesExpression timesExpressionMini = new TimesExpression(primaryExpressionMini,
                                                              primaryExpressionMini2);
    TrueLiteral trueLiteralMini = new TrueLiteral(nodeTokenMini);
    Type typeMini = new Type(new NodeChoice(integerTypeMini, 2));
    FormalParameter formalParameterMini = new FormalParameter(typeMini, identifierMini);
    FormalParameterRest formalParameterRestMini = new FormalParameterRest(
        formalParameterMini);
    VarDeclaration varDeclarationMini = new VarDeclaration(typeMini, identifierMini);
    WhileStatement whileStatementMini = new WhileStatement(expressionMini2, statementMini);
    IfStatement ifStatementMini = new IfStatement(expressionMini3,
                                                  statementMini,
                                                  statementMini2);

    // TODO(spradeep): 
    // MainClass mainClassMini = new MainClass(identifierMini, identifierMini2,
    //                                         new Identifier(new NodeToken("YoClass")),
    //                                         new Identifier(new NodeToken("BoyzMainMethod")),
    //                                         new NodeOptional());

    // ArrayLength arrayLengthMini = new ArrayLength();
    // Block blockMini = new Block();
    // ClassDeclaration classDeclarationMini = new ClassDeclaration();
    // ClassExtendsDeclaration classExtendsDeclarationMini = new ClassExtendsDeclaration();
    // ExpressionList expressionListMini = new ExpressionList();
    // Goal goalMini = new Goal();
    // MessageSend messageSendMini = new MessageSend();
    // MethodDeclaration methodDeclarationMini = new MethodDeclaration();
    // NodeList nodeListMini = new NodeList();
    // NodeListOptional nodeListOptionalMini = new NodeListOptional();
    // FormalParameterList formalParameterListMini = new FormalParameterList();
    // TypeDeclaration typeDeclarationMini = new TypeDeclaration();

    // NodeOptional nodeOptionalMini = new NodeOptional();
    // NodeSequence nodeSequenceMini = new NodeSequence();


    // MicroJava test fixtures

    microjavaparser.syntaxtree.NodeToken nodeToken = new microjavaparser.syntaxtree.NodeToken("FooBar");
    microjavaparser.syntaxtree.NodeToken nodeToken2 = new microjavaparser.syntaxtree.NodeToken("FooBarTwo");
    microjavaparser.syntaxtree.ArrayType arrayType = new microjavaparser.syntaxtree.ArrayType();
    microjavaparser.syntaxtree.BooleanType booleanType = new microjavaparser.syntaxtree.BooleanType();
    microjavaparser.syntaxtree.IntegerType integerType = new microjavaparser.syntaxtree.IntegerType();
    microjavaparser.syntaxtree.Type type = new microjavaparser.syntaxtree.Type(
        new microjavaparser.syntaxtree.NodeChoice(integerType, 2));
    microjavaparser.syntaxtree.IntegerLiteral integerLiteral = new microjavaparser.syntaxtree.IntegerLiteral(new microjavaparser.syntaxtree.NodeToken("75"));
    microjavaparser.syntaxtree.IntegerLiteral integerLiteral2 = new microjavaparser.syntaxtree.IntegerLiteral(new microjavaparser.syntaxtree.NodeToken("89"));
    microjavaparser.syntaxtree.IntegerLiteral integerLiteral3 = new microjavaparser.syntaxtree.IntegerLiteral(new microjavaparser.syntaxtree.NodeToken("63"));
    microjavaparser.syntaxtree.PrimaryExpression primaryExpression =
            new microjavaparser.syntaxtree.PrimaryExpression(
                new microjavaparser.syntaxtree.NodeChoice(integerLiteral, 0));
    microjavaparser.syntaxtree.PrimaryExpression primaryExpression2 =
            new microjavaparser.syntaxtree.PrimaryExpression(
                new microjavaparser.syntaxtree.NodeChoice(integerLiteral2, 0));
    microjavaparser.syntaxtree.PrimaryExpression primaryExpression3 =
            new microjavaparser.syntaxtree.PrimaryExpression(
                new microjavaparser.syntaxtree.NodeChoice(integerLiteral3, 0));
    microjavaparser.syntaxtree.Expression expression =
            new microjavaparser.syntaxtree.Expression(
                new microjavaparser.syntaxtree.NodeChoice(primaryExpression, 6));
    microjavaparser.syntaxtree.Expression expression2 =
            new microjavaparser.syntaxtree.Expression(
                new microjavaparser.syntaxtree.NodeChoice(primaryExpression2, 6));
    microjavaparser.syntaxtree.Expression expression3 =
            new microjavaparser.syntaxtree.Expression(
                new microjavaparser.syntaxtree.NodeChoice(primaryExpression3, 6));
    microjavaparser.syntaxtree.PrintStatement printStatement =
            new microjavaparser.syntaxtree.PrintStatement(expression);
    microjavaparser.syntaxtree.AndExpression andExpression =
            new microjavaparser.syntaxtree.AndExpression(primaryExpression,
                                                         primaryExpression2);
    microjavaparser.syntaxtree.CompareExpression compareExpression =
            new microjavaparser.syntaxtree.CompareExpression(primaryExpression,
                                                             primaryExpression2);
    microjavaparser.syntaxtree.PlusExpression plusExpression = new microjavaparser.syntaxtree.PlusExpression(primaryExpression, primaryExpression2);
    microjavaparser.syntaxtree.MinusExpression minusExpression =
            new microjavaparser.syntaxtree.MinusExpression(primaryExpression,
                                                           primaryExpression2);
    microjavaparser.syntaxtree.TimesExpression timesExpression = new microjavaparser.syntaxtree.TimesExpression(primaryExpression, primaryExpression2);
    microjavaparser.syntaxtree.ArrayLookup arrayLookup = new microjavaparser.syntaxtree.ArrayLookup(primaryExpression, primaryExpression2);
    microjavaparser.syntaxtree.ExpressionRest expressionRest = new microjavaparser.syntaxtree.ExpressionRest(expression);
    microjavaparser.syntaxtree.TrueLiteral trueLiteral = new microjavaparser.syntaxtree.TrueLiteral(nodeToken);
    microjavaparser.syntaxtree.FalseLiteral falseLiteral = new microjavaparser.syntaxtree.FalseLiteral(nodeToken);
    microjavaparser.syntaxtree.Identifier identifier = new microjavaparser.syntaxtree.Identifier(nodeToken);
    microjavaparser.syntaxtree.Identifier identifier2 = new microjavaparser.syntaxtree.Identifier(nodeToken2);
    microjavaparser.syntaxtree.ThisExpression thisExpression = new microjavaparser.syntaxtree.ThisExpression();
    microjavaparser.syntaxtree.ArrayAssignmentStatement arrayAssignmentStatement = new microjavaparser.syntaxtree.ArrayAssignmentStatement(identifier, expression, expression2);
    microjavaparser.syntaxtree.ArrayAllocationExpression arrayAllocationExpression = new microjavaparser.syntaxtree.ArrayAllocationExpression(expression);
    microjavaparser.syntaxtree.AllocationExpression allocationExpression = new microjavaparser.syntaxtree.AllocationExpression(identifier);
    microjavaparser.syntaxtree.NotExpression notExpression = new microjavaparser.syntaxtree.NotExpression(expression);
    microjavaparser.syntaxtree.BracketExpression bracketExpression = new microjavaparser.syntaxtree.BracketExpression(expression);

    microjavaparser.syntaxtree.VarDeclaration varDeclaration = new microjavaparser.syntaxtree.VarDeclaration(type, identifier);
    microjavaparser.syntaxtree.AssignmentStatement assignmentStatement =
            new microjavaparser.syntaxtree.AssignmentStatement(
                new microjavaparser.syntaxtree.VarRef(
                    new microjavaparser.syntaxtree.NodeChoice(identifier, 1)),
                expression);
    microjavaparser.syntaxtree.AssignmentStatement assignmentStatement2 =
            new microjavaparser.syntaxtree.AssignmentStatement(
                new microjavaparser.syntaxtree.VarRef(
                    new microjavaparser.syntaxtree.NodeChoice(identifier2, 1)),
                expression2);

    microjavaparser.syntaxtree.Statement statement =
            new microjavaparser.syntaxtree.Statement(
                new microjavaparser.syntaxtree.NodeChoice(assignmentStatement, 1));
    microjavaparser.syntaxtree.Statement statement2 =
            new microjavaparser.syntaxtree.Statement(
                new microjavaparser.syntaxtree.NodeChoice(assignmentStatement2, 1));
    microjavaparser.syntaxtree.WhileStatement whileStatement = new microjavaparser.syntaxtree.WhileStatement(expression2, statement);
    microjavaparser.syntaxtree.IfStatement ifStatement =
            new microjavaparser.syntaxtree.IfStatement(expression3,
                                                       statement,
                                                       statement2);
    microjavaparser.syntaxtree.FormalParameter formalParameter =
            new microjavaparser.syntaxtree.FormalParameter(type, identifier);
    microjavaparser.syntaxtree.FormalParameterRest formalParameterRest =
            new microjavaparser.syntaxtree.FormalParameterRest(formalParameter);

    // TODO(spradeep): 
    // microjavaparser.syntaxtree.MainClass mainClass = new microjavaparser.syntaxtree.MainClass(
    //     identifier,
    //     identifier2,
    //     new microjavaparser.syntaxtree.Identifier(
    //         new microjavaparser.syntaxtree.NodeToken("YoClass")),
    //     new microjavaparser.syntaxtree.Identifier(
    //         new microjavaparser.syntaxtree.NodeToken("BoyzMainMethod")),
    //     new microjavaparser.syntaxtree.NodeOptional());


    // microjavaparser.syntaxtree.NodeList nodeList = new microjavaparser.syntaxtree.NodeList();
    // microjavaparser.syntaxtree.NodeListOptional nodeListOptional = new microjavaparser.syntaxtree.NodeListOptional();
    // microjavaparser.syntaxtree.Goal goal = new microjavaparser.syntaxtree.Goal();
    // microjavaparser.syntaxtree.TypeDeclaration typeDeclaration = new microjavaparser.syntaxtree.TypeDeclaration();
    // microjavaparser.syntaxtree.ClassDeclaration classDeclaration = new microjavaparser.syntaxtree.ClassDeclaration();
    // microjavaparser.syntaxtree.ClassExtendsDeclaration classExtendsDeclaration = new microjavaparser.syntaxtree.ClassExtendsDeclaration();
    // microjavaparser.syntaxtree.MethodDeclaration methodDeclaration = new microjavaparser.syntaxtree.MethodDeclaration();
    // microjavaparser.syntaxtree.Block block = new microjavaparser.syntaxtree.Block();
    // microjavaparser.syntaxtree.MessageSendStatement messageSendStatement = new microjavaparser.syntaxtree.MessageSendStatement();
    // microjavaparser.syntaxtree.ExpressionList expressionList = new microjavaparser.syntaxtree.ExpressionList();
    // microjavaparser.syntaxtree.FormalParameterList formalParameterList = new microjavaparser.syntaxtree.FormalParameterList();
    // microjavaparser.syntaxtree.VarRef varRef = new microjavaparser.syntaxtree.VarRef();
    // microjavaparser.syntaxtree.DotExpression dotExpression = new microjavaparser.syntaxtree.DotExpression();

    // microjavaparser.syntaxtree.NodeOptional nodeOptional = new microjavaparser.syntaxtree.NodeOptional();
    // microjavaparser.syntaxtree.NodeSequence nodeSequence = new microjavaparser.syntaxtree.NodeSequence();

    @Before
    public void setUp() {
        outputter = new MicroJavaOutputter();

    }
    
    @After
    public void tearDown() {
    }

    /**
     * From
     * http://stackoverflow.com/questions/309424/read-convert-an-inputstream-to-a-string#answer-309718
     */
    public static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    /** 
     * Assert that MicroJava transformation of miniJavaNode is the
     * same as expectedMicroJavaNode.
     */
    public void assertEqualAfterTransform(
        microjavaparser.syntaxtree.Node expectedMicroJavaNode,
        Node miniJavaNode){

        assertEquals(MicroJavaOutputter.getFormattedString(expectedMicroJavaNode),
                     MicroJavaOutputter.getFormattedString(
                         outputter.getMicroJavaParseTree(miniJavaNode)));
    }

    /**
     * Test method for {@link MicroJavaOutputter#getFormattedString()}.
     */
    @Test
    public final void testGetFormattedString()
            throws FileNotFoundException, microjavaparser.ParseException{
        InputStream in1 = new FileInputStream(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Micro-Java-Test-Code/MainOnly.microjava");
        InputStream in2 = new FileInputStream(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Micro-Java-Test-Code/MainOnly.WithWhitespace.microjava");
        microjavaparser.syntaxtree.Node root1 = new MicroJavaParser(in1).Goal();

        microjavaparser.syntaxtree.Node root2 = new MicroJavaParser(in2).Goal();

        String code1 = MicroJavaOutputter.getFormattedString(root1);
        String code2 = MicroJavaOutputter.getFormattedString(root2);
        
        assertEquals(code1, code2);
        System.out.println("code1: " + code1);
        System.out.println("code2: " + code2);
    }

    /**
     * Test method for {@link MicroJavaOutputter#getMicroJavaNodeFromFile()}.
     */
    @Test
    public final void testGetMicroJavaNodeFromFileNoException(){
        MicroJavaOutputter.getMicroJavaNodeFromFile("/home/pradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Micro-Java-Test-Code/MainOnly.microjava");
    }

    /**
     * Test method for {@link MiniJavaOutputter#getMiniJavaNodeFromFile()}.
     */
    @Test
    public final void testGetMiniJavaNodeFromFileNoException(){
        MicroJavaOutputter.getMiniJavaNodeFromFile("/home/pradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Mini-Java-Test-Code/MainOnly.minijava");
    }

    /**
     * Test method for {@link MicroJavaOutputter#visitNodeToken()}.
     */
    @Test
    public final void testVisitNodeToken(){
        assertEqualAfterTransform(nodeToken, nodeTokenMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#visitThisExpression()}.
     */
    @Test
    public final void testVisitThisExpression(){
        assertEqualAfterTransform(thisExpression, thisExpressionMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#visitIdentifier()}.
     */
    @Test
    public final void testVisitIdentifier(){
        assertEqualAfterTransform(identifier, identifierMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#FalseLiteral()}.
     */
    @Test
    public final void testFalseLiteral(){
        assertEqualAfterTransform(falseLiteral, falseLiteralMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#TrueLiteral()}.
     */
    @Test
    public final void testTrueLiteral(){
        assertEqualAfterTransform(trueLiteral, trueLiteralMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#IntegerLiteral()}.
     */
    @Test
    public final void testIntegerLiteral(){
        assertEqualAfterTransform(integerLiteral, integerLiteralMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#ArrayAllocationExpression()}.
     */
    @Test
    public final void testArrayAllocationExpression(){
        assertEqualAfterTransform(arrayAllocationExpression,
                                  arrayAllocationExpressionMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#AllocationExpression()}.
     */
    @Test
    public final void testAllocationExpression(){
        assertEqualAfterTransform(allocationExpression, allocationExpressionMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#BracketExpression()}.
     */
    @Test
    public final void testBracketExpression(){
        assertEqualAfterTransform(bracketExpression, bracketExpressionMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#NotExpression()}.
     */
    @Test
    public final void testNotExpression(){
        assertEqualAfterTransform(notExpression, notExpressionMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#ExpressionRest()}.
     */
    @Test
    public final void testExpressionRest(){
        assertEqualAfterTransform(expressionRest, expressionRestMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#PrintStatement()}.
     */
    @Test
    public final void testPrintStatement(){
        assertEqualAfterTransform(printStatement, printStatementMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#ArrayAssignmentStatement()}.
     */
    @Test
    public final void testArrayAssignmentStatement(){
        assertEqualAfterTransform(arrayAssignmentStatement,
                                  arrayAssignmentStatementMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#TimesExpression()}.
     */
    @Test
    public final void testTimesExpression(){
        assertEqualAfterTransform(timesExpression, timesExpressionMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#ArrayLookup()}.
     */
    @Test
    public final void testArrayLookup(){
        assertEqualAfterTransform(arrayLookup, arrayLookupMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#MinusExpression()}.
     */
    @Test
    public final void testMinusExpression(){
        assertEqualAfterTransform(minusExpression, minusExpressionMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#PlusExpression()}.
     */
    @Test
    public final void testPlusExpression(){
        assertEqualAfterTransform(plusExpression, plusExpressionMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#CompareExpression()}.
     */
    @Test
    public final void testCompareExpression(){
        assertEqualAfterTransform(compareExpression, compareExpressionMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#AndExpression()}.
     */
    @Test
    public final void testAndExpression(){
        assertEqualAfterTransform(andExpression, andExpressionMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#AssignmentStatement()}.
     */
    @Test
    public final void testAssignmentStatement(){
        assertEqualAfterTransform(assignmentStatement, assignmentStatementMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#IntegerType()}.
     */
    @Test
    public final void testIntegerType(){
        assertEqualAfterTransform(integerType, integerTypeMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#BooleanType()}.
     */
    @Test
    public final void testBooleanType(){
        assertEqualAfterTransform(booleanType, booleanTypeMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#ArrayType()}.
     */
    @Test
    public final void testArrayType(){
        assertEqualAfterTransform(arrayType, arrayTypeMini);
    }
    
    /**
     * Test method for {@link MicroJavaOutputter#Type()}.
     */
    @Test
    public final void testType(){
        assertEqualAfterTransform(type, typeMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#FormalParameter()}.
     */
    @Test
    public final void testFormalParameter(){
        assertEqualAfterTransform(formalParameter, formalParameterMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#FormalParameterRest()}.
     */
    @Test
    public final void testFormalParameterRest(){
        assertEqualAfterTransform(formalParameterRest, formalParameterRestMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#VarDeclaration()}.
     */
    @Test
    public final void testVarDeclaration(){
        assertEqualAfterTransform(varDeclaration, varDeclarationMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#WhileStatement()}.
     */
    @Test
    public final void testWhileStatement(){
        assertEqualAfterTransform(whileStatement, whileStatementMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#IfStatement()}.
     */
    @Test
    public final void testIfStatement(){
        assertEqualAfterTransform(ifStatement, ifStatementMini);
    }

    // TODO(spradeep): 
    // /**
    //  * Test method for {@link MicroJavaOutputter#MainClass()}.
    //  */
    // @Test
    // public final void testMainClass(){
    //     assertEqualAfterTransform(mainClass, mainClassMini);
    // }

    // TODO(spradeep): 
    // /**
    //  * Test method for {@link MicroJavaOutputter#PrimaryExpression()}.
    //  */
    // @Test
    // public final void testPrimaryExpression(){
        
    // }

    // /**
    //  * Test method for {@link MicroJavaOutputter#visitVarDeclaration()}.
    //  */
    // @Test
    // public final void testVisitVarDeclaration(){
    //     VarDeclaration var = new VarDeclaration(
    //         new Type(new NodeChoice(new IntegerType(), 2)),
    //         new Identifier(new NodeToken("foo")));
    //     System.out.println("MicroJavaOutputter.getFormattedString(var): " + MicroJavaOutputter.getFormattedString(outputter.getMicroJavaParseTree(var)));
    // }

    ///////////////////////
    // Integration Tests //
    ///////////////////////

    /** 
     * Run test to see if MicroJava translation of MiniJava filename
     * is the same as the MicroJava filename.
     * 
     * @param basename filename (without extension) for both MicroJava
     * and MiniJava test code files.
     */
    public void doTestMiniAndMicroJava(String basename){
        // // Trying to get relative paths working.
        // URL url = this.getClass().getResource("foo.txt");
        // System.out.println("url.getFile(): " + url.getFile());
        // InputStream in = this.getClass().getResourceAsStream("Mini-Java-Test-Code/MainOnly.minijava");
        // System.out.println("convertStreamToString(in): " + convertStreamToString(in));

        microjavaparser.syntaxtree.Node expectedMicroParseTree = MicroJavaOutputter.getMicroJavaNodeFromFile(BASE_DIR + File.separator + MICRO_JAVA_DIR + File.separator + basename + MICRO_JAVA_EXTENSION);

        Node root = MicroJavaOutputter.getMiniJavaNodeFromFile(BASE_DIR + File.separator + MINI_JAVA_DIR + File.separator + basename + MINI_JAVA_EXTENSION);
        microjavaparser.syntaxtree.Node actualMicroParseTree =
                outputter.getMicroJavaParseTree(root);

        assertEquals(MicroJavaOutputter.getFormattedString(expectedMicroParseTree),
                     MicroJavaOutputter.getFormattedString(actualMicroParseTree));

        System.out.println("outputter.getFullMicroJavaCode(): "
                           + outputter.getFullMicroJavaCode());
    }

    // /**
    //  * Test method for {@link MicroJavaOutputter#simpleTransformer()}.
    //  */
    // @Test
    // public final void testMainOnly(){
    //     doTestMiniAndMicroJava("MainOnly");
    // }
}
