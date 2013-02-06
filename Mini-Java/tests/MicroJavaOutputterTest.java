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
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.File;
import java.net.URL;
 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MicroJavaOutputterTest {
    MicroJavaOutputter outputter;

    final String BASE_DIR = "/home/pradeep/Dropbox/Acads/POPL/Code/Mini-Java/tests";
    final String GEN_MICROJAVA_DIR =  "/home/pradeep/Dropbox/Acads/POPL/Code/Mini-Java/gen_microjava";
    final String MICRO_JAVA_DIR = "Micro-Java-Test-Code";
    final String MINI_JAVA_DIR = "Mini-Java-Test-Code";
    final String MICRO_JAVA_EXTENSION = ".microjava";
    final String MINI_JAVA_EXTENSION = ".minijava";

    // MiniJava test fixtures
    NodeToken nodeTokenMini;
    NodeToken nodeTokenMini2;
    NodeToken nodeTokenMini3;
    NodeToken nodeTokenMini4;
    ArrayType arrayTypeMini;
    BooleanType booleanTypeMini;
    IntegerLiteral integerLiteralMini;
    IntegerLiteral integerLiteralMini2;
    IntegerLiteral integerLiteralMini3;
    PrimaryExpression primaryExpressionMini;
    PrimaryExpression primaryExpressionMini2;
    PrimaryExpression primaryExpressionMini3;
    PrimaryExpression primaryExpressionMiniIdentifier;
    PrimaryExpression primaryExpressionMiniAllocation;
    PrimaryExpression primaryExpressionMiniThis;
    Expression expressionMini;
    Expression expressionMini2;
    Expression expressionMini3;
    ArrayLookup arrayLookupMini;
    BracketExpression bracketExpressionMini;
    ExpressionRest expressionRestMini;
    FalseLiteral falseLiteralMini;
    Identifier identifierMini;
    Identifier identifierMini2;
    Identifier identifierMini3;
    Identifier identifierMini4;
    ArrayAssignmentStatement arrayAssignmentStatementMini;
    AllocationExpression allocationExpressionMini;
    ArrayAllocationExpression arrayAllocationExpressionMini;

    AssignmentStatement assignmentStatementMini;
    AssignmentStatement assignmentStatementMini2;
    IntegerType integerTypeMini;
    AndExpression andExpressionMini;
    CompareExpression compareExpressionMini;
    MinusExpression minusExpressionMini;
    NotExpression notExpressionMini;
    PlusExpression plusExpressionMini;
    PrintStatement printStatementMini;
    Statement statementMini;
    Statement statementMini2;
    ThisExpression thisExpressionMini;
    TimesExpression timesExpressionMini;
    TrueLiteral trueLiteralMini;
    Type typeMini;
    Type typeMini2;
    FormalParameter formalParameterMini;
    FormalParameterRest formalParameterRestMini;
    VarDeclaration varDeclarationMini;
    WhileStatement whileStatementMini;
    IfStatement ifStatementMini;
    NodeOptional nodeOptionalMini;
    NodeListOptional nodeListOptionalMini;
    Block blockMini;
    ExpressionList expressionListMini;
    FormalParameterList formalParameterListMini;
    Goal goalMini;
    MainClass mainClassMini;
    ClassDeclaration classDeclarationMini;
    ClassExtendsDeclaration classExtendsDeclarationMini;
    TypeDeclaration typeDeclarationMini;
    TypeDeclaration typeDeclarationMini2;
    ArrayLength arrayLengthMini;
    ArrayLength arrayLengthMini2;
    MethodDeclaration methodDeclarationMini;
    MessageSend messageSendMini;

    // MicroJava test fixtures

    microjavaparser.syntaxtree.NodeToken nodeToken;
    microjavaparser.syntaxtree.NodeToken nodeToken2;
    microjavaparser.syntaxtree.NodeToken nodeToken3;
    microjavaparser.syntaxtree.NodeToken nodeToken4;
    microjavaparser.syntaxtree.ArrayType arrayType;
    microjavaparser.syntaxtree.BooleanType booleanType;
    microjavaparser.syntaxtree.IntegerType integerType;
    microjavaparser.syntaxtree.Type type;
    microjavaparser.syntaxtree.IntegerLiteral integerLiteral;
    microjavaparser.syntaxtree.IntegerLiteral integerLiteral2;
    microjavaparser.syntaxtree.IntegerLiteral integerLiteral3;
    microjavaparser.syntaxtree.PrimaryExpression primaryExpression;
    microjavaparser.syntaxtree.PrimaryExpression primaryExpression2;
    microjavaparser.syntaxtree.PrimaryExpression primaryExpression3;
    microjavaparser.syntaxtree.Expression expression;
    microjavaparser.syntaxtree.Expression expression2;
    microjavaparser.syntaxtree.Expression expression3;
    microjavaparser.syntaxtree.PrintStatement printStatement;
    microjavaparser.syntaxtree.AndExpression andExpression;
    microjavaparser.syntaxtree.CompareExpression compareExpression;
    microjavaparser.syntaxtree.PlusExpression plusExpression;
    microjavaparser.syntaxtree.MinusExpression minusExpression;
    microjavaparser.syntaxtree.TimesExpression timesExpression;
    microjavaparser.syntaxtree.ArrayLookup arrayLookup;
    microjavaparser.syntaxtree.ExpressionRest expressionRest;
    microjavaparser.syntaxtree.TrueLiteral trueLiteral;
    microjavaparser.syntaxtree.FalseLiteral falseLiteral;
    microjavaparser.syntaxtree.Identifier identifier;
    microjavaparser.syntaxtree.Identifier identifier2;
    microjavaparser.syntaxtree.Identifier identifier3;
    microjavaparser.syntaxtree.Identifier identifier4;
    microjavaparser.syntaxtree.ThisExpression thisExpression;
    microjavaparser.syntaxtree.ArrayAssignmentStatement arrayAssignmentStatement;
    microjavaparser.syntaxtree.ArrayAllocationExpression arrayAllocationExpression;
    microjavaparser.syntaxtree.AllocationExpression allocationExpression;
    microjavaparser.syntaxtree.NotExpression notExpression;
    microjavaparser.syntaxtree.BracketExpression bracketExpression;

    microjavaparser.syntaxtree.VarDeclaration varDeclaration;
    microjavaparser.syntaxtree.AssignmentStatement assignmentStatement;
    microjavaparser.syntaxtree.AssignmentStatement assignmentStatement2;

    microjavaparser.syntaxtree.Statement statement;
    microjavaparser.syntaxtree.Statement statement2;
    microjavaparser.syntaxtree.WhileStatement whileStatement;
    microjavaparser.syntaxtree.IfStatement ifStatement;
    microjavaparser.syntaxtree.FormalParameter formalParameter;
    microjavaparser.syntaxtree.FormalParameterRest formalParameterRest;

    microjavaparser.syntaxtree.NodeOptional nodeOptional;

    microjavaparser.syntaxtree.NodeListOptional nodeListOptional;
    microjavaparser.syntaxtree.Block block;
    microjavaparser.syntaxtree.ExpressionList expressionList;
    microjavaparser.syntaxtree.FormalParameterList formalParameterList;
    microjavaparser.syntaxtree.Goal goal;
    microjavaparser.syntaxtree.MainClass mainClass;
    microjavaparser.syntaxtree.ClassDeclaration classDeclaration;
    microjavaparser.syntaxtree.ClassExtendsDeclaration classExtendsDeclaration;
    microjavaparser.syntaxtree.TypeDeclaration typeDeclaration;
    microjavaparser.syntaxtree.TypeDeclaration typeDeclaration2;
    ExpansionNode arrayLength;
    microjavaparser.syntaxtree.MethodDeclaration methodDeclaration;
    microjavaparser.syntaxtree.MethodDeclaration methodDeclaration2;

    // microjavaparser.syntaxtree.MessageSendStatement messageSendStatement = new microjavaparser.syntaxtree.MessageSendStatement();
    // microjavaparser.syntaxtree.VarRef varRef = new microjavaparser.syntaxtree.VarRef();
    // microjavaparser.syntaxtree.DotExpression dotExpression = new microjavaparser.syntaxtree.DotExpression();

    @Before
    public void setUp() {

        // BIG WARNING: Be VERY careful about constructing complex
        // Nodes out of simpler Node instances cos you might end up
        // using the same simple Node instance twice and will then get
        // an error from TreeFormatter.
        
        outputter = new MicroJavaOutputter();

        // MiniJava test fixtures

        nodeTokenMini = new NodeToken("FooBar");
        nodeTokenMini2 = new NodeToken("FooBarTwo");
        nodeTokenMini3 = new NodeToken("FooBarThree");
        nodeTokenMini4 = new NodeToken("FooBarFour");
        arrayTypeMini = new ArrayType();
        booleanTypeMini = new BooleanType();
        integerLiteralMini = new IntegerLiteral(new NodeToken("75"));
        integerLiteralMini2 = new IntegerLiteral(new NodeToken("89"));
        integerLiteralMini3 = new IntegerLiteral(new NodeToken("63"));
        primaryExpressionMini = new PrimaryExpression(
            new NodeChoice(integerLiteralMini, 0));
        primaryExpressionMini2 = new PrimaryExpression(
            new NodeChoice(integerLiteralMini2, 0));
        primaryExpressionMini3 = new PrimaryExpression(
            new NodeChoice(integerLiteralMini3, 0));
        expressionMini = new Expression(new NodeChoice(primaryExpressionMini,
                                                       6));
        expressionMini2 = new Expression(new NodeChoice(primaryExpressionMini2,
                                                        6));
        expressionMini3 = new Expression(new NodeChoice(primaryExpressionMini3,
                                                        6));
        arrayLookupMini = new ArrayLookup(primaryExpressionMini,
                                          primaryExpressionMini2);
        bracketExpressionMini = new BracketExpression(expressionMini);
        expressionRestMini = new ExpressionRest(expressionMini);
        falseLiteralMini = new FalseLiteral(nodeTokenMini);
        identifierMini = new Identifier(nodeTokenMini);

        identifierMini2 = new Identifier(nodeTokenMini2);
        identifierMini3 = new Identifier(nodeTokenMini3);
        identifierMini4 = new Identifier(nodeTokenMini4);
        primaryExpressionMiniIdentifier =
                new PrimaryExpression(new NodeChoice(identifierMini3, 3));
        arrayAssignmentStatementMini = new ArrayAssignmentStatement(identifierMini,
                                                                    expressionMini,
                                                                    expressionMini2);
        allocationExpressionMini = new AllocationExpression(identifierMini3);

        primaryExpressionMiniAllocation =
                new PrimaryExpression(new NodeChoice(allocationExpressionMini, 6));

        arrayAllocationExpressionMini = new ArrayAllocationExpression(expressionMini);

        assignmentStatementMini = new AssignmentStatement(identifierMini,
                                                          expressionMini);
        assignmentStatementMini2 = new AssignmentStatement(identifierMini2,
                                                           expressionMini2);
        integerTypeMini = new IntegerType();
        andExpressionMini = new AndExpression(primaryExpressionMini,
                                              primaryExpressionMini2);
        compareExpressionMini = new CompareExpression(
            primaryExpressionMini,
            primaryExpressionMini2);
        minusExpressionMini = new MinusExpression(primaryExpressionMini,
                                                  primaryExpressionMini2);
        notExpressionMini = new NotExpression(expressionMini);
        plusExpressionMini = new PlusExpression(primaryExpressionMini,
                                                primaryExpressionMini2);
        printStatementMini = new PrintStatement(expressionMini);
        statementMini = new Statement(new NodeChoice(assignmentStatementMini, 1));
        statementMini2 = new Statement(new NodeChoice(assignmentStatementMini2, 1));
        thisExpressionMini = new ThisExpression();

        primaryExpressionMiniThis = new PrimaryExpression(new NodeChoice(thisExpressionMini,
                                                                         4));
        timesExpressionMini = new TimesExpression(primaryExpressionMini,
                                                  primaryExpressionMini2);
        trueLiteralMini = new TrueLiteral(nodeTokenMini);
        typeMini = new Type(new NodeChoice(integerTypeMini, 2));
        typeMini2 = new Type(new NodeChoice(booleanTypeMini, 1));
        formalParameterMini = new FormalParameter(typeMini, identifierMini);
        formalParameterRestMini = new FormalParameterRest(
            formalParameterMini);
        varDeclarationMini = new VarDeclaration(typeMini, identifierMini);
        whileStatementMini = new WhileStatement(expressionMini2, statementMini);
        ifStatementMini = new IfStatement(expressionMini3,
                                          statementMini,
                                          statementMini2);
        nodeOptionalMini = new NodeOptional(ifStatementMini);
        nodeListOptionalMini = new NodeListOptional();
        nodeListOptionalMini.addNode(expressionMini);
        nodeListOptionalMini.addNode(expressionMini2);
        nodeListOptionalMini.addNode(expressionMini3);

        NodeListOptional tempListOptionalMini = new NodeListOptional(statementMini);
        tempListOptionalMini.addNode(statementMini2);
        blockMini = new Block(tempListOptionalMini);
        expressionListMini = new ExpressionList(
            expressionMini2,
            new NodeListOptional(expressionRestMini));

        formalParameterListMini = new FormalParameterList(formalParameterMini,
                                                          new NodeListOptional());

        mainClassMini = new MainClass(identifierMini,
                                      identifierMini2,
                                      printStatementMini);
        goalMini = new Goal(mainClassMini, new NodeListOptional());
        classDeclarationMini = new ClassDeclaration(identifierMini,
                                                    new NodeListOptional(),
                                                    new NodeListOptional());
        classExtendsDeclarationMini = new ClassExtendsDeclaration(identifierMini,
                                                                  identifierMini2,
                                                                  new NodeListOptional(),
                                                                  new NodeListOptional());
        typeDeclarationMini = new TypeDeclaration(
            new NodeChoice(classDeclarationMini, 0));
        typeDeclarationMini2 = new TypeDeclaration(
            new NodeChoice(classExtendsDeclarationMini, 1));
        arrayLengthMini = new ArrayLength(new PrimaryExpression(
            new NodeChoice(arrayAllocationExpressionMini, 5)));
        arrayLengthMini2 = new ArrayLength(new PrimaryExpression(
            new NodeChoice(identifierMini2, 5)));
        methodDeclarationMini = new MethodDeclaration(
            typeMini2,
            identifierMini4,
            new NodeOptional(),
            new NodeListOptional(varDeclarationMini),
            new NodeListOptional(statementMini2),
            expressionMini3);

        messageSendMini = new MessageSend(primaryExpressionMini3,
                                          identifierMini4,
                                          new NodeOptional(expressionListMini));

        // MicroJava test fixtures

        nodeToken = new microjavaparser.syntaxtree.NodeToken("FooBar");
        nodeToken2 = new microjavaparser.syntaxtree.NodeToken("FooBarTwo");
        nodeToken3 = new microjavaparser.syntaxtree.NodeToken("FooBarThree");
        nodeToken4 = new microjavaparser.syntaxtree.NodeToken("FooBarFour");
        arrayType = new microjavaparser.syntaxtree.ArrayType();
        booleanType = new microjavaparser.syntaxtree.BooleanType();
        integerType = new microjavaparser.syntaxtree.IntegerType();
        type = new microjavaparser.syntaxtree.Type(
            new microjavaparser.syntaxtree.NodeChoice(integerType, 2));
        integerLiteral = new microjavaparser.syntaxtree.IntegerLiteral(
            new microjavaparser.syntaxtree.NodeToken("75"));
        integerLiteral2 = new microjavaparser.syntaxtree.IntegerLiteral(
            new microjavaparser.syntaxtree.NodeToken("89"));
        integerLiteral3 = new microjavaparser.syntaxtree.IntegerLiteral(
            new microjavaparser.syntaxtree.NodeToken("63"));
        primaryExpression = new microjavaparser.syntaxtree.PrimaryExpression(
            new microjavaparser.syntaxtree.NodeChoice(integerLiteral, 0));
        primaryExpression2 = new microjavaparser.syntaxtree.PrimaryExpression(
            new microjavaparser.syntaxtree.NodeChoice(integerLiteral2, 0));
        primaryExpression3 = new microjavaparser.syntaxtree.PrimaryExpression(
            new microjavaparser.syntaxtree.NodeChoice(integerLiteral3, 0));
        expression = new microjavaparser.syntaxtree.Expression(
            new microjavaparser.syntaxtree.NodeChoice(primaryExpression, 6));
        expression2 = new microjavaparser.syntaxtree.Expression(
            new microjavaparser.syntaxtree.NodeChoice(primaryExpression2, 6));
        expression3 = new microjavaparser.syntaxtree.Expression(
            new microjavaparser.syntaxtree.NodeChoice(primaryExpression3, 6));
        printStatement = new microjavaparser.syntaxtree.PrintStatement(expression);
        andExpression = new microjavaparser.syntaxtree.AndExpression(primaryExpression,
                                                                     primaryExpression2);
        compareExpression = new microjavaparser.syntaxtree.CompareExpression(
            primaryExpression,
            primaryExpression2);
        plusExpression = new microjavaparser.syntaxtree.PlusExpression(
            primaryExpression, primaryExpression2);
        minusExpression = new microjavaparser.syntaxtree.MinusExpression(primaryExpression,
                                                                         primaryExpression2);
        timesExpression = new microjavaparser.syntaxtree.TimesExpression(primaryExpression, primaryExpression2);
        arrayLookup = new microjavaparser.syntaxtree.ArrayLookup(primaryExpression, primaryExpression2);
        expressionRest = new microjavaparser.syntaxtree.ExpressionRest(expression);
        trueLiteral = new microjavaparser.syntaxtree.TrueLiteral(nodeToken);
        falseLiteral = new microjavaparser.syntaxtree.FalseLiteral(nodeToken);
        identifier = new microjavaparser.syntaxtree.Identifier(nodeToken);
        identifier2 = new microjavaparser.syntaxtree.Identifier(nodeToken2);
        identifier3 = new microjavaparser.syntaxtree.Identifier(nodeToken3);
        identifier4 = new microjavaparser.syntaxtree.Identifier(nodeToken4);
        thisExpression = new microjavaparser.syntaxtree.ThisExpression();
        arrayAssignmentStatement = new microjavaparser.syntaxtree.ArrayAssignmentStatement(identifier, expression, expression2);
        arrayAllocationExpression = new microjavaparser.syntaxtree.ArrayAllocationExpression(expression);
        allocationExpression = new microjavaparser.syntaxtree.AllocationExpression(
            identifier3);
        notExpression = new microjavaparser.syntaxtree.NotExpression(expression);
        bracketExpression = new microjavaparser.syntaxtree.BracketExpression(expression);
        varDeclaration = new microjavaparser.syntaxtree.VarDeclaration(type, identifier);
        assignmentStatement = new microjavaparser.syntaxtree.AssignmentStatement(
            new microjavaparser.syntaxtree.VarRef(
                new microjavaparser.syntaxtree.NodeChoice(identifier, 1)),
            expression);
        assignmentStatement2 = new microjavaparser.syntaxtree.AssignmentStatement(
            new microjavaparser.syntaxtree.VarRef(
                new microjavaparser.syntaxtree.NodeChoice(identifier2, 1)),
            expression2);
        statement = new microjavaparser.syntaxtree.Statement(
            new microjavaparser.syntaxtree.NodeChoice(assignmentStatement, 1));
        statement2 = new microjavaparser.syntaxtree.Statement(
            new microjavaparser.syntaxtree.NodeChoice(assignmentStatement2, 1));
        whileStatement = new microjavaparser.syntaxtree.WhileStatement(expression2,
                                                                       statement);
        ifStatement = new microjavaparser.syntaxtree.IfStatement(expression3,
                                                                 statement,
                                                                 statement2);
        formalParameter = new microjavaparser.syntaxtree.FormalParameter(type, identifier);
        formalParameterRest = new microjavaparser.syntaxtree.FormalParameterRest(formalParameter);

        nodeOptional = new microjavaparser.syntaxtree.NodeOptional(ifStatement);

        nodeListOptional = new microjavaparser.syntaxtree.NodeListOptional();
        nodeListOptional.addNode(expression);
        nodeListOptional.addNode(expression2);
        nodeListOptional.addNode(expression3);

        microjavaparser.syntaxtree.NodeListOptional tempListOptional =
                new microjavaparser.syntaxtree.NodeListOptional(statement);
        tempListOptional.addNode(statement2);
        block = new microjavaparser.syntaxtree.Block(tempListOptional);

        expressionList = new microjavaparser.syntaxtree.ExpressionList(
            expression2,
            new microjavaparser.syntaxtree.NodeListOptional(expressionRest));

        formalParameterList = new microjavaparser.syntaxtree.FormalParameterList(
            formalParameter,
            new microjavaparser.syntaxtree.NodeListOptional());

        mainClass = new microjavaparser.syntaxtree.MainClass(
            identifier,
            identifier2,
            MicroJavaOutputter.pseudoMainClassName,
            MicroJavaOutputter.pseudoMainMethod,
            MicroJavaOutputter.mainMethodArg);

        MicroJavaOutputter tempOutputter = new MicroJavaOutputter();
        goal = new microjavaparser.syntaxtree.Goal(
            mainClass,
            new microjavaparser.syntaxtree.NodeListOptional(
                tempOutputter.getNewMainClass(printStatementMini)));
        classDeclaration = new microjavaparser.syntaxtree.ClassDeclaration(
            identifier,
            new microjavaparser.syntaxtree.NodeListOptional(),
            new microjavaparser.syntaxtree.NodeListOptional());

        classExtendsDeclaration = new microjavaparser.syntaxtree.ClassExtendsDeclaration(
            identifier,
            identifier2,
            new microjavaparser.syntaxtree.NodeListOptional(),
            new microjavaparser.syntaxtree.NodeListOptional());

        typeDeclaration = new microjavaparser.syntaxtree.TypeDeclaration(new microjavaparser.syntaxtree.NodeChoice(classDeclaration, 0));
        typeDeclaration2 = new microjavaparser.syntaxtree.TypeDeclaration(new microjavaparser.syntaxtree.NodeChoice(classExtendsDeclaration, 1));

        microjavaparser.syntaxtree.Expression methodReturnValue = expression2;
        microjavaparser.syntaxtree.Statement methodReturnStatement =
                new microjavaparser.syntaxtree.Statement(new microjavaparser.syntaxtree.NodeChoice(
                    new microjavaparser.syntaxtree.AssignmentStatement(
                        new microjavaparser.syntaxtree.VarRef(new microjavaparser.syntaxtree.NodeChoice(MicroJavaOutputter.getMethodRetVarIdentifier(identifier4), 1)),
                        expression3),
                    1));

        microjavaparser.syntaxtree.NodeListOptional methodStatements = new microjavaparser.syntaxtree.NodeListOptional();
        methodStatements.addNode(statement2);
        methodStatements.addNode(methodReturnStatement);
        methodDeclaration = new microjavaparser.syntaxtree.MethodDeclaration(
            identifier4,
            new microjavaparser.syntaxtree.NodeOptional(),
            new microjavaparser.syntaxtree.NodeListOptional(varDeclaration),
            methodStatements);

        microjavaparser.syntaxtree.Expression methodReturnValue2 = expression2;
        microjavaparser.syntaxtree.Statement methodReturnStatement2 =
                new microjavaparser.syntaxtree.Statement(new microjavaparser.syntaxtree.NodeChoice(
                    new microjavaparser.syntaxtree.AssignmentStatement(
                        new microjavaparser.syntaxtree.VarRef(new microjavaparser.syntaxtree.NodeChoice(MicroJavaOutputter.getMethodRetVarIdentifier(identifier4), 1)),
                        expression3),
                    1));

        microjavaparser.syntaxtree.NodeListOptional methodStatements2
                = new microjavaparser.syntaxtree.NodeListOptional();
        methodStatements2.addNode(statement2);
        methodStatements2.addNode(methodReturnStatement);
        methodDeclaration2 = new microjavaparser.syntaxtree.MethodDeclaration(
            identifier4,
            new microjavaparser.syntaxtree.NodeOptional(),
            new microjavaparser.syntaxtree.NodeListOptional(
                outputter.getVarDeclaration(
                    "test_variable",
                    MicroJavaOutputter.getTempIdentifier(
                        MicroJavaOutputter.getMethodName(identifier4)))),
            methodStatements);

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
     * Assert that node1 and node2 are equal MicroJava nodes.
     */
    public void assertEqualMicroJavaNodes(microjavaparser.syntaxtree.Node expected,
                                          microjavaparser.syntaxtree.Node actual){
        assertEquals(MicroJavaOutputter.getFormattedString(expected),
                     MicroJavaOutputter.getFormattedString(actual));
    }

    /**
     * Test method for {@link MicroJavaOutputter#getNewTempVarName()}.
     */
    @Test
    public final void testGetNewTempVarName(){
        assertEquals("___tmp0", outputter.getNewTempVarName());
        assertEquals("___tmp1", outputter.getNewTempVarName());
        assertEquals("___tmp2", outputter.getNewTempVarName());
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
     * Wrap body in the method of a trivial Main Class so that
     * MicroJavaParser can parse it and return the body of the method
     * as an ExpansionNode.
     * 
     * @return ExpansionNode corresponding to the body.
     */
    public static ExpansionNode convertToExpansionNode(String body){
        String codeString =
                "class MainOnly {" +
                "   public static void main(String [] a){" +
                "      new ____NewMainClass____().____Main____(0);" +
                "   }" +
                "}" +
                "" +
                "class ____NewMainClass____{" +
                "" +
                "   public void ____Main____(int ____arg_length____){" +
                "" +
                body +
                "   }" +
                "}";

        microjavaparser.syntaxtree.Goal goal = (microjavaparser.syntaxtree.Goal)
                MicroJavaOutputter.getMicroJavaNodeFromString(codeString);
        microjavaparser.syntaxtree.TypeDeclaration typeDeclaration =
                (microjavaparser.syntaxtree.TypeDeclaration) goal.f1.nodes.get(0);
        microjavaparser.syntaxtree.ClassDeclaration classDeclaration =
                (microjavaparser.syntaxtree.ClassDeclaration)
                typeDeclaration.f0.choice;
        microjavaparser.syntaxtree.MethodDeclaration methodDeclaration =
                (microjavaparser.syntaxtree.MethodDeclaration)
                classDeclaration.f4.nodes.get(0);
        ExpansionNode result = new ExpansionNode(null);
        result.varDeclarations = methodDeclaration.f7;
        result.precedingNodes = methodDeclaration.f8;
        return result;
    }

    @Test
    public final void testConvertToExpansionNode(){
        String printStatement = "System.out.println(75);";
        ExpansionNode actual = convertToExpansionNode(printStatement);
        // System.out.println("MicroJavaOutputter.getFormattedString(actual.varDeclarations): " + MicroJavaOutputter.getFormattedString(actual.varDeclarations));
        // System.out.println("MicroJavaOutputter.getFormattedString(actual.precedingNodes): " + MicroJavaOutputter.getFormattedString(actual.precedingNodes));
        assertEqualAfterTransform(actual.precedingNodes.nodes.get(0),
                                  printStatementMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#NodeToken()}.
     */
    @Test
    public final void testNodeToken(){
        assertEqualAfterTransform(nodeToken, nodeTokenMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#ThisExpression()}.
     */
    @Test
    public final void testThisExpression(){
        assertEqualAfterTransform(thisExpression, thisExpressionMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#Identifier()}.
     */
    @Test
    public final void testIdentifier(){
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
        // TODO(spradeep): Test the actual expression node usage

        assertEqualAfterTransform(arrayAllocationExpression,
                                  arrayAllocationExpressionMini);

        // String expectedString =
        //         "      int [ ]   ____TEMP____ ;" +
        //         "      ____TEMP____ =  75 + 89;" +
        //         "";

        // ExpansionNode expected = convertToExpansionNode(expectedString);
        // ExpansionNode actual = (ExpansionNode) outputter.getMicroJavaParseTree(
        //     new ArrayAllocationExpression(new Expression(
        //         new NodeChoice(plusExpressionMini, 2))));

        // System.out.println("MicroJavaOutputter.getFormattedString(plusExpression): " + MicroJavaOutputter.getFormattedString(plusExpression));
        // System.out.println("MicroJavaOutputter.getFormattedString(actual): " + MicroJavaOutputter.getFormattedString(actual));

        // System.out.println("MicroJavaOutputter.getFormattedString(varDeclarations): " + MicroJavaOutputter.getFormattedString(expected.varDeclarations));
        // System.out.println("MicroJavaOutputter.getFormattedString(precedingNodes): " + MicroJavaOutputter.getFormattedString(expected.precedingNodes));
        // // System.out.println("MicroJavaOutputter.getFormattedString(node): " + MicroJavaOutputter.getFormattedString(expectedArrayLengthExpansionNode.node));

        // // assertEquals(
        // //     MicroJavaOutputter.getFormattedString(
        // //         expected.varDeclarations),
        // //     MicroJavaOutputter.getFormattedString(actual.varDeclarations));

        // // assertEquals(
        // //     MicroJavaOutputter.getFormattedString(
        // //         expected.precedingNodes),
        // //     MicroJavaOutputter.getFormattedString(actual.precedingNodes));
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
        Type typeMini1 = new Type(new NodeChoice(arrayTypeMini, 0));
        Type typeMini2 = new Type(new NodeChoice(booleanTypeMini, 1));
        Type typeMini3 = new Type(new NodeChoice(integerTypeMini, 2));
        Type typeMini4 = new Type(new NodeChoice(identifierMini, 3));
        microjavaparser.syntaxtree.Type type1 = new microjavaparser.syntaxtree.Type(
            new microjavaparser.syntaxtree.NodeChoice(arrayType, 0));
        microjavaparser.syntaxtree.Type type2 = new microjavaparser.syntaxtree.Type(
            new microjavaparser.syntaxtree.NodeChoice(booleanType, 1));
        microjavaparser.syntaxtree.Type type3 = new microjavaparser.syntaxtree.Type(
            new microjavaparser.syntaxtree.NodeChoice(integerType, 2));
        microjavaparser.syntaxtree.Type type4 = new microjavaparser.syntaxtree.Type(
            new microjavaparser.syntaxtree.NodeChoice(identifier, 3));
        assertEqualAfterTransform(type1, typeMini1);
        assertEqualAfterTransform(type2, typeMini2);
        assertEqualAfterTransform(type3, typeMini3);
        assertEqualAfterTransform(type4, typeMini4);
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

    /**
     * Test method for {@link MicroJavaOutputter#NodeOptional()}.
     */
    @Test
    public final void testNodeOptional(){
        assertEqualAfterTransform(nodeOptional, nodeOptionalMini);
        assertEqualAfterTransform(new microjavaparser.syntaxtree.NodeOptional(),
                                  new NodeOptional());
    }

    /**
     * Test method for {@link MicroJavaOutputter#NodeListOptional()}.
     */
    @Test
    public final void testNodeListOptional(){
        assertEqualAfterTransform(nodeListOptional, nodeListOptionalMini);
        assertEqualAfterTransform(new microjavaparser.syntaxtree.NodeListOptional(),
                                  new NodeListOptional());
    }

    /**
     * Test method for {@link MicroJavaOutputter#Block()}.
     */
    @Test
    public final void testBlock(){
        assertEqualAfterTransform(block, blockMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#ExpressionList()}.
     */
    @Test
    public final void testExpressionList(){
        assertEqualAfterTransform(expressionList, expressionListMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#FormalParameterList()}.
     */
    @Test
    public final void testFormalParameterList(){
        assertEqualAfterTransform(formalParameterList, formalParameterListMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#getNewMainClass()}.
     */
    @Test
    public final void testGetNewMainClass(){
        // We're only testing for the ____NewMainClass____ bit, but
        // have to give the full code cos the parser expects a
        // complete program.
        String expectedNewMainClassString =
                "class MainOnly {" +
                "   public static void main(String [] a){" +
                "      new ____NewMainClass____().____Main____(0);" +
                "   }" +
                "}" +
                "" +
                "class ____NewMainClass____{" +
                "" +
                "   public void ____Main____(int ____arg_length____){" +
                "      System.out.println(75);" +
                "   }" +
                "}";

        microjavaparser.syntaxtree.Goal expectedGoal = (microjavaparser.syntaxtree.Goal)
                MicroJavaOutputter.getMicroJavaNodeFromString(expectedNewMainClassString);
        microjavaparser.syntaxtree.Node expectedNewMainClassNode =
                expectedGoal.f1.nodes.get(0);

        microjavaparser.syntaxtree.Node actualNewMainClassNode =
                outputter.getNewMainClass(printStatementMini);


        assertEquals(MicroJavaOutputter.getFormattedString(expectedNewMainClassNode),
                     MicroJavaOutputter.getFormattedString(actualNewMainClassNode));

        System.out.println("MicroJavaOutputter.getFormattedString(actualNewMainClassNode): " + MicroJavaOutputter.getFormattedString(actualNewMainClassNode));
    }

    /**
     * Test method for {@link MicroJavaOutputter#Goal()}.
     */
    @Test
    public final void testGoal(){
        assertEqualAfterTransform(goal, goalMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#ClassDeclaration()}.
     */
    @Test
    public final void testClassDeclaration(){
        assertEqualAfterTransform(classDeclaration, classDeclarationMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#ClassExtendsDeclaration()}.
     */
    @Test
    public final void testClassExtendsDeclaration(){
        assertEqualAfterTransform(classExtendsDeclaration, classExtendsDeclarationMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#TypeDeclaration()}.
     */
    @Test
    public final void testTypeDeclaration(){
        assertEqualAfterTransform(typeDeclaration, typeDeclarationMini);
        assertEqualAfterTransform(typeDeclaration2, typeDeclarationMini2);
    }

    /**
     * Test method for {@link MicroJavaOutputter#Statement()}.
     */
    @Test
    public final void testStatement(){
        Statement statementMini0 = new Statement(new NodeChoice(blockMini, 0));
        Statement statementMini1 = new Statement(new NodeChoice(assignmentStatementMini, 1));
        Statement statementMini2 = new Statement(new NodeChoice(arrayAssignmentStatementMini, 2));
        Statement statementMini3 = new Statement(new NodeChoice(ifStatementMini, 3));
        Statement statementMini4 = new Statement(new NodeChoice(whileStatementMini, 4));
        Statement statementMini5 = new Statement(new NodeChoice(printStatementMini, 5));

        microjavaparser.syntaxtree.Statement statement0 = new microjavaparser.syntaxtree.Statement(new microjavaparser.syntaxtree.NodeChoice(block, 0));
        microjavaparser.syntaxtree.Statement statement1 = new microjavaparser.syntaxtree.Statement(new microjavaparser.syntaxtree.NodeChoice(assignmentStatement, 1));
        microjavaparser.syntaxtree.Statement statement2 = new microjavaparser.syntaxtree.Statement(new microjavaparser.syntaxtree.NodeChoice(arrayAssignmentStatement, 2));
        microjavaparser.syntaxtree.Statement statement3 = new microjavaparser.syntaxtree.Statement(new microjavaparser.syntaxtree.NodeChoice(ifStatement, 3));
        microjavaparser.syntaxtree.Statement statement4 = new microjavaparser.syntaxtree.Statement(new microjavaparser.syntaxtree.NodeChoice(whileStatement, 4));
        microjavaparser.syntaxtree.Statement statement5 = new microjavaparser.syntaxtree.Statement(new microjavaparser.syntaxtree.NodeChoice(printStatement, 5));

        assertEqualAfterTransform(statement0, statementMini0);
        assertEqualAfterTransform(statement1, statementMini1);
        assertEqualAfterTransform(statement2, statementMini2);
        assertEqualAfterTransform(statement3, statementMini3);
        assertEqualAfterTransform(statement4, statementMini4);
        assertEqualAfterTransform(statement5, statementMini5);
    }

    /**
     * Test method for {@link MicroJavaOutputter#Expression()}.
     */
    @Test
    public final void testExpression(){
        Expression expressionMini0 = new Expression(new NodeChoice(andExpressionMini, 0));
        Expression expressionMini1 = new Expression(new NodeChoice(compareExpressionMini, 1));
        Expression expressionMini2 = new Expression(new NodeChoice(plusExpressionMini, 2));
        Expression expressionMini3 = new Expression(new NodeChoice(minusExpressionMini, 3));
        Expression expressionMini4 = new Expression(new NodeChoice(timesExpressionMini, 4));
        Expression expressionMini5 = new Expression(new NodeChoice(arrayLookupMini, 5));

        // TODO(spradeep): 
        // Expression expressionMini6 = new Expression(new NodeChoice(arrayLengthMini, 6));

        // TODO(spradeep): 
        // Expression expressionMini7 = new Expression(new NodeChoice(messageSendMini, 7));

        Expression expressionMini8 = new Expression(new NodeChoice(primaryExpressionMini, 8));

        microjavaparser.syntaxtree.Expression expression0 = new microjavaparser.syntaxtree.Expression(new microjavaparser.syntaxtree.NodeChoice(andExpression, 0));
        microjavaparser.syntaxtree.Expression expression1 = new microjavaparser.syntaxtree.Expression(new microjavaparser.syntaxtree.NodeChoice(compareExpression, 1));
        microjavaparser.syntaxtree.Expression expression2 = new microjavaparser.syntaxtree.Expression(new microjavaparser.syntaxtree.NodeChoice(plusExpression, 2));
        microjavaparser.syntaxtree.Expression expression3 = new microjavaparser.syntaxtree.Expression(new microjavaparser.syntaxtree.NodeChoice(minusExpression, 3));
        microjavaparser.syntaxtree.Expression expression4 = new microjavaparser.syntaxtree.Expression(new microjavaparser.syntaxtree.NodeChoice(timesExpression, 4));
        microjavaparser.syntaxtree.Expression expression5 = new microjavaparser.syntaxtree.Expression(new microjavaparser.syntaxtree.NodeChoice(arrayLookup, 5));

        // TODO(spradeep): 
        // microjavaparser.syntaxtree.Expression expression6 = new microjavaparser.syntaxtree.Expression(new microjavaparser.syntaxtree.NodeChoice(arrayLength, 6));
        // TODO(spradeep): 
        // microjavaparser.syntaxtree.Expression expression7 = new microjavaparser.syntaxtree.Expression(new microjavaparser.syntaxtree.NodeChoice(messageSend, 7));

        microjavaparser.syntaxtree.Expression expression8 = new microjavaparser.syntaxtree.Expression(new microjavaparser.syntaxtree.NodeChoice(primaryExpression, 8));

        assertEqualAfterTransform(expression0, expressionMini0);
        assertEqualAfterTransform(expression1, expressionMini1);
        assertEqualAfterTransform(expression2, expressionMini2);
        assertEqualAfterTransform(expression3, expressionMini3);
        assertEqualAfterTransform(expression4, expressionMini4);
        assertEqualAfterTransform(expression5, expressionMini5);
        // assertEqualAfterTransform(expression6, expressionMini6);
        // assertEqualAfterTransform(expression7, expressionMini7);
        assertEqualAfterTransform(expression8, expressionMini8);
    }

    /**
     * Test method for {@link MicroJavaOutputter#PrimaryExpression()}.
     */
    @Test
    public final void testPrimaryExpression(){
        PrimaryExpression primaryExpressionMini0 = new PrimaryExpression(new NodeChoice(integerLiteralMini, 0));
        PrimaryExpression primaryExpressionMini1 = new PrimaryExpression(new NodeChoice(trueLiteralMini, 1));
        PrimaryExpression primaryExpressionMini2 = new PrimaryExpression(new NodeChoice(falseLiteralMini, 2));
        PrimaryExpression primaryExpressionMini3 = new PrimaryExpression(new NodeChoice(identifierMini, 3));
        PrimaryExpression primaryExpressionMini4 = new PrimaryExpression(new NodeChoice(thisExpressionMini, 4));
        PrimaryExpression primaryExpressionMini5 = new PrimaryExpression(new NodeChoice(arrayAllocationExpressionMini, 5));
        PrimaryExpression primaryExpressionMini6 = new PrimaryExpression(new NodeChoice(allocationExpressionMini, 6));
        PrimaryExpression primaryExpressionMini7 = new PrimaryExpression(new NodeChoice(notExpressionMini, 7));
        PrimaryExpression primaryExpressionMini8 = new PrimaryExpression(new NodeChoice(bracketExpressionMini, 8));

        microjavaparser.syntaxtree.PrimaryExpression primaryExpression0 = new microjavaparser.syntaxtree.PrimaryExpression(new microjavaparser.syntaxtree.NodeChoice(integerLiteral, 0));
        microjavaparser.syntaxtree.PrimaryExpression primaryExpression1 = new microjavaparser.syntaxtree.PrimaryExpression(new microjavaparser.syntaxtree.NodeChoice(trueLiteral, 1));
        microjavaparser.syntaxtree.PrimaryExpression primaryExpression2 = new microjavaparser.syntaxtree.PrimaryExpression(new microjavaparser.syntaxtree.NodeChoice(falseLiteral, 2));
        microjavaparser.syntaxtree.PrimaryExpression primaryExpression3 = new microjavaparser.syntaxtree.PrimaryExpression(new microjavaparser.syntaxtree.NodeChoice(identifier, 3));
        microjavaparser.syntaxtree.PrimaryExpression primaryExpression4 = new microjavaparser.syntaxtree.PrimaryExpression(new microjavaparser.syntaxtree.NodeChoice(thisExpression, 4));
        microjavaparser.syntaxtree.PrimaryExpression primaryExpression5 = new microjavaparser.syntaxtree.PrimaryExpression(new microjavaparser.syntaxtree.NodeChoice(arrayAllocationExpression, 5));
        microjavaparser.syntaxtree.PrimaryExpression primaryExpression6 = new microjavaparser.syntaxtree.PrimaryExpression(new microjavaparser.syntaxtree.NodeChoice(allocationExpression, 6));
        microjavaparser.syntaxtree.PrimaryExpression primaryExpression7 = new microjavaparser.syntaxtree.PrimaryExpression(new microjavaparser.syntaxtree.NodeChoice(notExpression, 7));
        microjavaparser.syntaxtree.PrimaryExpression primaryExpression8 = new microjavaparser.syntaxtree.PrimaryExpression(new microjavaparser.syntaxtree.NodeChoice(bracketExpression, 8));

        assertEqualAfterTransform(primaryExpression0, primaryExpressionMini0);
        assertEqualAfterTransform(primaryExpression1, primaryExpressionMini1);
        assertEqualAfterTransform(primaryExpression2, primaryExpressionMini2);
        assertEqualAfterTransform(primaryExpression3, primaryExpressionMini3);
        assertEqualAfterTransform(primaryExpression4, primaryExpressionMini4);
        assertEqualAfterTransform(primaryExpression5, primaryExpressionMini5);
        assertEqualAfterTransform(primaryExpression6, primaryExpressionMini6);
        assertEqualAfterTransform(primaryExpression7, primaryExpressionMini7);
        assertEqualAfterTransform(primaryExpression8, primaryExpressionMini8);   
    }

    /**
     * Test method for {@link MicroJavaOutputter#MainClass()}.
     */
    @Test
    public final void testMainClass(){
        assertEqualAfterTransform(mainClass, mainClassMini);
    }

    /**
     * Test method for {@link MicroJavaOutputter#ArrayLength()}.
     */
    @Test
    public final void testArrayLength_ArrayAllocationExpression(){
        // TODO(spradeep): Test the usage of the actual array length
        // expression node

        String expectedArrayLengthString =
                "      int [ ]   ___tmp0 ;" +
                "      ___tmp0 = new int [ 75 ] ;" +
                "";

        ExpansionNode expectedArrayLengthExpansionNode =
                convertToExpansionNode(expectedArrayLengthString);

        System.out.println("MicroJavaOutputter.getFormattedString(varDeclarations): " + MicroJavaOutputter.getFormattedString(expectedArrayLengthExpansionNode.varDeclarations));
        System.out.println("MicroJavaOutputter.getFormattedString(precedingNodes): " + MicroJavaOutputter.getFormattedString(expectedArrayLengthExpansionNode.precedingNodes));
        // System.out.println("MicroJavaOutputter.getFormattedString(node): " + MicroJavaOutputter.getFormattedString(expectedArrayLengthExpansionNode.node));

        ExpansionNode actual = (ExpansionNode) outputter.getMicroJavaParseTree(arrayLengthMini);

        assertEquals(MicroJavaOutputter.getFormattedString(expectedArrayLengthExpansionNode.varDeclarations),
                     MicroJavaOutputter.getFormattedString(actual.varDeclarations));
        assertEquals(MicroJavaOutputter.getFormattedString(expectedArrayLengthExpansionNode.precedingNodes),
                     MicroJavaOutputter.getFormattedString(actual.precedingNodes));
    }

    /**
     * Test method for {@link MicroJavaOutputter#ArrayLength()}.
     */
    @Test
    public final void testArrayLength_Identifier(){
        // TODO(spradeep): Test the usage of the actual array length
        // expression node

        String expectedArrayLengthString =
                "      int [ ]   ___tmp0 ;" +
                "      ___tmp0 = FooBarTwo;" +
                "";

        ExpansionNode expectedArrayLengthExpansionNode =
                convertToExpansionNode(expectedArrayLengthString);
        ExpansionNode actual = (ExpansionNode) outputter.getMicroJavaParseTree(arrayLengthMini2);

        System.out.println("MicroJavaOutputter.getFormattedString(varDeclarations): " + MicroJavaOutputter.getFormattedString(expectedArrayLengthExpansionNode.varDeclarations));
        System.out.println("MicroJavaOutputter.getFormattedString(precedingNodes): " + MicroJavaOutputter.getFormattedString(expectedArrayLengthExpansionNode.precedingNodes));
        // System.out.println("MicroJavaOutputter.getFormattedString(node): " + MicroJavaOutputter.getFormattedString(expectedArrayLengthExpansionNode.node));

        assertEquals(MicroJavaOutputter.getFormattedString(expectedArrayLengthExpansionNode.varDeclarations),
                     MicroJavaOutputter.getFormattedString(actual.varDeclarations));
        assertEquals(MicroJavaOutputter.getFormattedString(expectedArrayLengthExpansionNode.precedingNodes),
                     MicroJavaOutputter.getFormattedString(actual.precedingNodes));
    }

    /**
     * Test method for {@link MicroJavaOutputter#concatenateNodeLists()}.
     */
    @Test
    public final void testConcateNodeLists(){
        microjavaparser.syntaxtree.NodeListOptional list1 = new microjavaparser.syntaxtree.NodeListOptional();
        microjavaparser.syntaxtree.NodeListOptional list2 = nodeListOptional;

        assertEqualMicroJavaNodes(nodeListOptional, MicroJavaOutputter.concatenateNodeLists(list1, list2));
    }

    /**
     * Test method for {@link MicroJavaOutputter#MethodDeclaration()}.
     */
    @Test
    public final void testMethodDeclaration(){
        System.out.println("MicroJavaOutputter.getFormattedString(methodDeclaration): " + MicroJavaOutputter.getFormattedString(methodDeclaration));
        System.out.println("MicroJavaOutputter.getFormattedString(outputter.getMicroJavaParseTree(methodDeclarationMini)): " + MicroJavaOutputter.getFormattedString(outputter.getMicroJavaParseTree(methodDeclarationMini)));

        System.out.println("MicroJavaOutputter.getFormattedString(methodDeclaration2): " + MicroJavaOutputter.getFormattedString(methodDeclaration2));


        assertEqualAfterTransform(methodDeclaration, methodDeclarationMini);
    }

    // /**
    //  * Test method for {@link MicroJavaOutputter#MessageSend()}.
    //  */
    // @Test
    // public final void testMessageSend(){
    //     String expectedString =
    //             "      int ___tmp0 ;" +
    //             "      TYPE_FooBarFour ___tmp1 ;" +
    //             "      ___tmp0 =  63;" +
    //             "      ___tmp0 . FooBarFour ( 89 , 75 ) ;" +
    //             "      ___tmp1 = ___tmp0.____1234FooBarFour4321____ ;" +
    //             "      System.out.println(___tmp1);" +
    //             "";

    //     ExpansionNode expected = convertToExpansionNode(expectedString);
    //     PrintStatement tempPrintStatement = new PrintStatement(new Expression(new NodeChoice(messageSendMini, 7)));
    //     ExpansionNode actual = (ExpansionNode) outputter.getMicroJavaParseTree(tempPrintStatement);

    //     System.out.println("MicroJavaOutputter.getFormattedString(actual): "
    //                        + MicroJavaOutputter.getFormattedString(actual));
    //     assertEqualMicroJavaNodes(expected.varDeclarations, actual.varDeclarations);
    //     assertEqualMicroJavaNodes(
    //         expected.precedingNodes,
    //         MicroJavaOutputter.concatenateNodeLists(
    //             actual.precedingNodes,
    //             new microjavaparser.syntaxtree.NodeListOptional(actual.node)));
    // }

    /**
     * Test method for {@link MicroJavaOutputter#MessageSend()}.
     */
    @Test
    public final void testMessageSendThis(){
        MessageSend messageSendMini = new MessageSend(primaryExpressionMiniThis,
                                                      identifierMini4,
                                                      new NodeOptional(expressionListMini));
        outputter.currClassName = "YoBoyzClass";
        String expectedString =
                "      YoBoyzClass ___tmp0 ;" +
                "      TYPE_FooBarFour ___tmp1 ;" +
                "      ___tmp0 =  this;" +
                "      ___tmp0 . FooBarFour ( 89 , 75 ) ;" +
                "      ___tmp1 = ___tmp0.____1234FooBarFour4321____ ;" +
                "      System.out.println(___tmp1);" +
                "";

        ExpansionNode expected = convertToExpansionNode(expectedString);
        PrintStatement tempPrintStatement = new PrintStatement(new Expression(new NodeChoice(messageSendMini, 7)));
        ExpansionNode actual = (ExpansionNode) outputter.getMicroJavaParseTree(tempPrintStatement);

        System.out.println("MicroJavaOutputter.getFormattedString(actual): "
                           + MicroJavaOutputter.getFormattedString(actual));
        assertEqualMicroJavaNodes(expected.varDeclarations, actual.varDeclarations);
        assertEqualMicroJavaNodes(
            expected.precedingNodes,
            MicroJavaOutputter.concatenateNodeLists(
                actual.precedingNodes,
                new microjavaparser.syntaxtree.NodeListOptional(actual.node)));
    }

    /**
     * Test method for {@link MicroJavaOutputter#lookupVarType()}.
     */
    @Test
    public final void testLookupVarType(){
        microjavaparser.syntaxtree.Identifier identifier5 =
                new microjavaparser.syntaxtree.Identifier(
                    new microjavaparser.syntaxtree.NodeToken("FooBarFive"));
        microjavaparser.syntaxtree.Identifier identifier6 =
                new microjavaparser.syntaxtree.Identifier(
                    new microjavaparser.syntaxtree.NodeToken("FooBarSix"));

        microjavaparser.syntaxtree.Type type4 =
                new microjavaparser.syntaxtree.Type(
                    new microjavaparser.syntaxtree.NodeChoice(identifier5, 3));

        microjavaparser.syntaxtree.VarDeclaration varDeclaration =
                new microjavaparser.syntaxtree.VarDeclaration(
                    type4, identifier6);

        outputter.currMethodVarDeclarations = new microjavaparser.syntaxtree.NodeListOptional(
            varDeclaration);
        assertEquals(type4, outputter.lookupVarType(identifier6));
    }

    /**
     * Test method for {@link MicroJavaOutputter#MessageSend()}.
     */
    @Test
    public final void testMessageSendIdentifier(){
        MessageSend messageSendMini = new MessageSend(primaryExpressionMiniIdentifier,
                                                      identifierMini4,
                                                      new NodeOptional(expressionListMini));

        microjavaparser.syntaxtree.Identifier identifier5 =
                new microjavaparser.syntaxtree.Identifier(
                    new microjavaparser.syntaxtree.NodeToken("FooBarFive"));

        microjavaparser.syntaxtree.Identifier identifierCopy3 =
                new microjavaparser.syntaxtree.Identifier(
                    new microjavaparser.syntaxtree.NodeToken("FooBarThree"));

        microjavaparser.syntaxtree.Type type4 =
                new microjavaparser.syntaxtree.Type(
                    new microjavaparser.syntaxtree.NodeChoice(identifier5, 3));

        microjavaparser.syntaxtree.VarDeclaration varDeclaration =
                new microjavaparser.syntaxtree.VarDeclaration(
                    type4, identifierCopy3);

        outputter.currClassName = "YoBoyzClass";
        outputter.currMethodVarDeclarations = new microjavaparser.syntaxtree.NodeListOptional(
            varDeclaration);

        String expectedString =
                "      FooBarFive ___tmp0 ;" +
                "      TYPE_FooBarFour ___tmp1 ;" +
                "      ___tmp0 =  FooBarThree;" +
                "      ___tmp0 . FooBarFour ( 89 , 75 ) ;" +
                "      ___tmp1 = ___tmp0.____1234FooBarFour4321____ ;" +
                "      System.out.println(___tmp1);" +
                "";

        ExpansionNode expected = convertToExpansionNode(expectedString);
        PrintStatement tempPrintStatement = new PrintStatement(new Expression(new NodeChoice(messageSendMini, 7)));
        ExpansionNode actual = (ExpansionNode) outputter.getMicroJavaParseTree(
            tempPrintStatement);

        System.out.println("MicroJavaOutputter.getFormattedString(actual): "
                           + MicroJavaOutputter.getFormattedString(actual));
        assertEqualMicroJavaNodes(expected.varDeclarations, actual.varDeclarations);
        assertEqualMicroJavaNodes(
            expected.precedingNodes,
            MicroJavaOutputter.concatenateNodeLists(
                actual.precedingNodes,
                new microjavaparser.syntaxtree.NodeListOptional(actual.node)));
    }

    /**
     * Test method for {@link MicroJavaOutputter#MessageSend()}.
     */
    @Test
    public final void testMessageSendAllocation(){

        MessageSend messageSendMini = new MessageSend(primaryExpressionMiniAllocation,
                                                      identifierMini4,
                                                      new NodeOptional(expressionListMini));
        String expectedString =
                "      FooBarThree ___tmp0 ;" +
                "      TYPE_FooBarFour ___tmp1 ;" +
                "      ___tmp0 =  new FooBarThree();" +
                "      ___tmp0 . FooBarFour ( 89 , 75 ) ;" +
                "      ___tmp1 = ___tmp0.____1234FooBarFour4321____ ;" +
                "      System.out.println(___tmp1);" +
                "";

        ExpansionNode expected = convertToExpansionNode(expectedString);
        PrintStatement tempPrintStatement = new PrintStatement(new Expression(new NodeChoice(messageSendMini, 7)));
        ExpansionNode actual = (ExpansionNode) outputter.getMicroJavaParseTree(tempPrintStatement);

        System.out.println("MicroJavaOutputter.getFormattedString(actual): "
                           + MicroJavaOutputter.getFormattedString(actual));
        assertEqualMicroJavaNodes(expected.varDeclarations, actual.varDeclarations);
        assertEqualMicroJavaNodes(
            expected.precedingNodes,
            MicroJavaOutputter.concatenateNodeLists(
                actual.precedingNodes,
                new microjavaparser.syntaxtree.NodeListOptional(actual.node)));
    }

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

        System.out.println(basename); 
        // microjavaparser.syntaxtree.Node expectedMicroParseTree = MicroJavaOutputter.getMicroJavaNodeFromFile(BASE_DIR + File.separator + MICRO_JAVA_DIR + File.separator + basename + MICRO_JAVA_EXTENSION);
        // System.out.println("MicroJavaOutputter.getFormattedString(expectedMicroParseTree): " + MicroJavaOutputter.getFormattedString(expectedMicroParseTree));

        Node root = MicroJavaOutputter.getMiniJavaNodeFromFile(BASE_DIR + File.separator + MINI_JAVA_DIR + File.separator + basename + MINI_JAVA_EXTENSION);
        microjavaparser.syntaxtree.Node actualMicroParseTree =
                outputter.getMicroJavaParseTree(root);

        System.out.println("MicroJavaOutputter.getFormattedString(actualMicroParseTree): " + MicroJavaOutputter.getFormattedString(actualMicroParseTree));

        MicroJavaOutputter.getMicroJavaNodeFromString(MicroJavaOutputter.getFormattedString(actualMicroParseTree));

        writeCodeToFile(MicroJavaOutputter.getFormattedString(actualMicroParseTree),
                        GEN_MICROJAVA_DIR + File.separator + basename + ".java");
        
        // assertEquals(MicroJavaOutputter.getFormattedString(expectedMicroParseTree),
        //              MicroJavaOutputter.getFormattedString(actualMicroParseTree));
    }
    
    public void writeCodeToFile(String code, String filename){
        PrintStream out = null;
        try {
            out = new PrintStream(new FileOutputStream(filename));
            out.print(code);
        } catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if (out != null) out.close();
        }
    }

    @Test
    public final void testMainOnly(){
        doTestMiniAndMicroJava("MainOnly");
    }

    @Test
    public final void testMicroJavaParsing(){
        // Test if the code generated for each of the MiniJava files
        // is valid MicroJava.

        // doTestMiniAndMicroJava("BinarySearch");

        // // doTestMiniAndMicroJava("BinaryTree");

        // doTestMiniAndMicroJava("BubbleSort");
        // doTestMiniAndMicroJava("Factorial");
        // doTestMiniAndMicroJava("LinearSearch");
        // doTestMiniAndMicroJava("LinkedList");
        // doTestMiniAndMicroJava("MainOnly");
        // doTestMiniAndMicroJava("QuickSort");
        // doTestMiniAndMicroJava("TreeVisitor");
    }
}
