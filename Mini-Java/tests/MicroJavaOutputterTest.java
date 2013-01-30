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

    final String BASE_DIR = "/home/spradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests";
    final String MICRO_JAVA_DIR = "Micro-Java-Test-Code";
    final String MINI_JAVA_DIR = "Mini-Java-Test-Code";
    final String MICRO_JAVA_EXTENSION = ".microjava";
    final String MINI_JAVA_EXTENSION = ".minijava";

    NodeToken nodeTokenMini = new NodeToken("FooBar");
    // AndExpression andExpressionMini = new AndExpression();
    // ArrayLength arrayLengthMini = new ArrayLength();
    // ArrayType arrayTypeMini = new ArrayType();
    // AssignmentStatement assignmentStatementMini = new AssignmentStatement();
    // Block blockMini = new Block();
    // BooleanType booleanTypeMini = new BooleanType();
    // ClassDeclaration classDeclarationMini = new ClassDeclaration();
    // ClassExtendsDeclaration classExtendsDeclarationMini = new ClassExtendsDeclaration();
    // CompareExpression compareExpressionMini = new CompareExpression();
    IntegerLiteral integerLiteralMini = new IntegerLiteral(new NodeToken("75"));
    IntegerLiteral integerLiteralMini2 = new IntegerLiteral(new NodeToken("75"));
    PrimaryExpression primaryExpressionMini = new PrimaryExpression(
        new NodeChoice(integerLiteralMini, 0));
    PrimaryExpression primaryExpressionMini2 = new PrimaryExpression(
        new NodeChoice(integerLiteralMini2, 0));
    Expression expressionMini = new Expression(new NodeChoice(primaryExpressionMini,
                                                              6));
    Expression expressionMini2 = new Expression(new NodeChoice(primaryExpressionMini2,
                                                               6));
    ArrayLookup arrayLookupMini = new ArrayLookup(primaryExpressionMini,
                                                  primaryExpressionMini2);
    BracketExpression bracketExpressionMini = new BracketExpression(expressionMini);
    // ExpressionList expressionListMini = new ExpressionList();
    ExpressionRest expressionRestMini = new ExpressionRest(expressionMini);
    FalseLiteral falseLiteralMini = new FalseLiteral(nodeTokenMini);
    // FormalParameter formalParameterMini = new FormalParameter();
    // FormalParameterList formalParameterListMini = new FormalParameterList();
    // FormalParameterRest formalParameterRestMini = new FormalParameterRest();
    // Goal goalMini = new Goal();
    Identifier identifierMini = new Identifier(nodeTokenMini);
    ArrayAssignmentStatement arrayAssignmentStatementMini = new ArrayAssignmentStatement(identifierMini, expressionMini, expressionMini2);
    AllocationExpression allocationExpressionMini = new AllocationExpression(identifierMini);
    ArrayAllocationExpression arrayAllocationExpressionMini = new ArrayAllocationExpression(expressionMini);
    // IfStatement ifStatementMini = new IfStatement();
    // IntegerType integerTypeMini = new IntegerType();
    // MainClass mainClassMini = new MainClass();
    // MessageSend messageSendMini = new MessageSend();
    // MethodDeclaration methodDeclarationMini = new MethodDeclaration();
    // MinusExpression minusExpressionMini = new MinusExpression();
    // NodeList nodeListMini = new NodeList();
    // NodeListOptional nodeListOptionalMini = new NodeListOptional();
    // NodeOptional nodeOptionalMini = new NodeOptional();
    // NodeSequence nodeSequenceMini = new NodeSequence();
    NotExpression notExpressionMini = new NotExpression(expressionMini);
    // PlusExpression plusExpressionMini = new PlusExpression();
    PrintStatement printStatementMini = new PrintStatement(expressionMini);
    // Statement statementMini = new Statement();
    ThisExpression thisExpressionMini = new ThisExpression();
    TimesExpression timesExpressionMini = new TimesExpression(primaryExpressionMini, primaryExpressionMini2);
    TrueLiteral trueLiteralMini = new TrueLiteral(nodeTokenMini);
    // Type typeMini = new Type();
    // TypeDeclaration typeDeclarationMini = new TypeDeclaration();
    // VarDeclaration varDeclarationMini = new VarDeclaration();
    // WhileStatement whileStatementMini = new WhileStatement();

    // microjavaparser.syntaxtree.NodeList nodeList = new microjavaparser.syntaxtree.NodeList();
    // microjavaparser.syntaxtree.NodeListOptional nodeListOptional = new microjavaparser.syntaxtree.NodeListOptional();
    // microjavaparser.syntaxtree.NodeOptional nodeOptional = new microjavaparser.syntaxtree.NodeOptional();
    // microjavaparser.syntaxtree.NodeSequence nodeSequence = new microjavaparser.syntaxtree.NodeSequence();
    microjavaparser.syntaxtree.NodeToken nodeToken = new microjavaparser.syntaxtree.NodeToken("FooBar");
    // microjavaparser.syntaxtree.Goal goal = new microjavaparser.syntaxtree.Goal();
    // microjavaparser.syntaxtree.MainClass mainClass = new microjavaparser.syntaxtree.MainClass();
    // microjavaparser.syntaxtree.TypeDeclaration typeDeclaration = new microjavaparser.syntaxtree.TypeDeclaration();
    // microjavaparser.syntaxtree.ClassDeclaration classDeclaration = new microjavaparser.syntaxtree.ClassDeclaration();
    // microjavaparser.syntaxtree.ClassExtendsDeclaration classExtendsDeclaration = new microjavaparser.syntaxtree.ClassExtendsDeclaration();
    // microjavaparser.syntaxtree.VarDeclaration varDeclaration = new microjavaparser.syntaxtree.VarDeclaration();
    // microjavaparser.syntaxtree.MethodDeclaration methodDeclaration = new microjavaparser.syntaxtree.MethodDeclaration();
    // microjavaparser.syntaxtree.FormalParameterList formalParameterList = new microjavaparser.syntaxtree.FormalParameterList();
    // microjavaparser.syntaxtree.FormalParameter formalParameter = new microjavaparser.syntaxtree.FormalParameter();
    // microjavaparser.syntaxtree.FormalParameterRest formalParameterRest = new microjavaparser.syntaxtree.FormalParameterRest();
    // microjavaparser.syntaxtree.Type type = new microjavaparser.syntaxtree.Type();
    // microjavaparser.syntaxtree.ArrayType arrayType = new microjavaparser.syntaxtree.ArrayType();
    // microjavaparser.syntaxtree.BooleanType booleanType = new microjavaparser.syntaxtree.BooleanType();
    // microjavaparser.syntaxtree.IntegerType integerType = new microjavaparser.syntaxtree.IntegerType();
    // microjavaparser.syntaxtree.Statement statement = new microjavaparser.syntaxtree.Statement();
    // microjavaparser.syntaxtree.Block block = new microjavaparser.syntaxtree.Block();
    // microjavaparser.syntaxtree.AssignmentStatement assignmentStatement = new microjavaparser.syntaxtree.AssignmentStatement();
    // microjavaparser.syntaxtree.IfStatement ifStatement = new microjavaparser.syntaxtree.IfStatement();
    // microjavaparser.syntaxtree.WhileStatement whileStatement = new microjavaparser.syntaxtree.WhileStatement();
    // microjavaparser.syntaxtree.MessageSendStatement messageSendStatement = new microjavaparser.syntaxtree.MessageSendStatement();
    microjavaparser.syntaxtree.IntegerLiteral integerLiteral = new microjavaparser.syntaxtree.IntegerLiteral(new microjavaparser.syntaxtree.NodeToken("75"));
    microjavaparser.syntaxtree.IntegerLiteral integerLiteral2 = new microjavaparser.syntaxtree.IntegerLiteral(new microjavaparser.syntaxtree.NodeToken("75"));
    microjavaparser.syntaxtree.PrimaryExpression primaryExpression =
            new microjavaparser.syntaxtree.PrimaryExpression(
                new microjavaparser.syntaxtree.NodeChoice(integerLiteral, 0));
    microjavaparser.syntaxtree.PrimaryExpression primaryExpression2 =
            new microjavaparser.syntaxtree.PrimaryExpression(
                new microjavaparser.syntaxtree.NodeChoice(integerLiteral2, 0));
    microjavaparser.syntaxtree.Expression expression =
            new microjavaparser.syntaxtree.Expression(
                new microjavaparser.syntaxtree.NodeChoice(primaryExpression, 6));
    microjavaparser.syntaxtree.Expression expression2 =
            new microjavaparser.syntaxtree.Expression(
                new microjavaparser.syntaxtree.NodeChoice(primaryExpression2, 6));
    microjavaparser.syntaxtree.PrintStatement printStatement =
            new microjavaparser.syntaxtree.PrintStatement(expression);
    // microjavaparser.syntaxtree.AndExpression andExpression = new microjavaparser.syntaxtree.AndExpression();
    // microjavaparser.syntaxtree.CompareExpression compareExpression = new microjavaparser.syntaxtree.CompareExpression();
    // microjavaparser.syntaxtree.PlusExpression plusExpression = new microjavaparser.syntaxtree.PlusExpression();
    // microjavaparser.syntaxtree.MinusExpression minusExpression = new microjavaparser.syntaxtree.MinusExpression();
    microjavaparser.syntaxtree.TimesExpression timesExpression = new microjavaparser.syntaxtree.TimesExpression(primaryExpression, primaryExpression2);
    microjavaparser.syntaxtree.ArrayLookup arrayLookup = new microjavaparser.syntaxtree.ArrayLookup(primaryExpression, primaryExpression2);
    // microjavaparser.syntaxtree.ExpressionList expressionList = new microjavaparser.syntaxtree.ExpressionList();
    microjavaparser.syntaxtree.ExpressionRest expressionRest = new microjavaparser.syntaxtree.ExpressionRest(expression);
    microjavaparser.syntaxtree.TrueLiteral trueLiteral = new microjavaparser.syntaxtree.TrueLiteral(nodeToken);
    microjavaparser.syntaxtree.FalseLiteral falseLiteral = new microjavaparser.syntaxtree.FalseLiteral(nodeToken);
    microjavaparser.syntaxtree.Identifier identifier = new microjavaparser.syntaxtree.Identifier(nodeToken);
    microjavaparser.syntaxtree.ThisExpression thisExpression = new microjavaparser.syntaxtree.ThisExpression();
    microjavaparser.syntaxtree.ArrayAssignmentStatement arrayAssignmentStatement = new microjavaparser.syntaxtree.ArrayAssignmentStatement(identifier, expression, expression2);
    microjavaparser.syntaxtree.ArrayAllocationExpression arrayAllocationExpression = new microjavaparser.syntaxtree.ArrayAllocationExpression(expression);
    microjavaparser.syntaxtree.AllocationExpression allocationExpression = new microjavaparser.syntaxtree.AllocationExpression(identifier);
    microjavaparser.syntaxtree.NotExpression notExpression = new microjavaparser.syntaxtree.NotExpression(expression);
    microjavaparser.syntaxtree.BracketExpression bracketExpression = new microjavaparser.syntaxtree.BracketExpression(expression);
    // microjavaparser.syntaxtree.VarRef varRef = new microjavaparser.syntaxtree.VarRef();
    // microjavaparser.syntaxtree.DotExpression dotExpression = new microjavaparser.syntaxtree.DotExpression();

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
            "/home/spradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Micro-Java-Test-Code/MainOnly.microjava");
        InputStream in2 = new FileInputStream(
            "/home/spradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Micro-Java-Test-Code/MainOnly.WithWhitespace.microjava");
        microjavaparser.syntaxtree.Node root1 = new MicroJavaParser(in1).Goal();

        microjavaparser.syntaxtree.Node root2 = new MicroJavaParser(in2).Goal();

        String code1 = MicroJavaOutputter.getFormattedString(root1);
        String code2 = MicroJavaOutputter.getFormattedString(root2);
        
        assertEquals(code1, code2);
    }

    /**
     * Test method for {@link MicroJavaOutputter#getMicroJavaNodeFromFile()}.
     */
    @Test
    public final void testGetMicroJavaNodeFromFileNoException(){
        MicroJavaOutputter.getMicroJavaNodeFromFile("/home/spradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Micro-Java-Test-Code/MainOnly.microjava");
    }

    /**
     * Test method for {@link MiniJavaOutputter#getMiniJavaNodeFromFile()}.
     */
    @Test
    public final void testGetMiniJavaNodeFromFileNoException(){
        MicroJavaOutputter.getMiniJavaNodeFromFile("/home/spradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests/Mini-Java-Test-Code/MainOnly.minijava");
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
