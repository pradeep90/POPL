import nano.syntaxtree.*;
import java.util.*;
import nano.visitor.TreeFormatter;
import nano.visitor.TreeDumper;
import nano.NanoJavaParser;

// import java.text.ParseException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.PrintStream;
import java.io.FileOutputStream;

// import java.io.FileInputStream;
// import java.io.FileNotFoundException;
// import java.io.ByteArrayInputStream;
// import java.io.IOException;
// import java.io.InputStream;
// import java.io.StringWriter;
// import java.io.File;

public class CPSHelper {
    
    public CPSHelper() {
        
    }

    public static final int INDENT_AMOUNT = 3;
    public static final int WRAP_WIDTH = 80;

    /**
     * Format the source code in the syntax tree using TreeFormatter,
     * then dump it to a string using TreeDumper.
     * 
     * @return pretty-printed string version of root.
     */
    public static String getFormattedString(Node root){
        StringWriter out = new StringWriter();
        final TreeDumper dumper = new TreeDumper(out);

        // This updates the location information in each Node
        root.accept(new TreeFormatter(INDENT_AMOUNT, WRAP_WIDTH));
        dumper.resetPosition();
        root.accept(dumper);
        return out.toString();
    }

    /** 
     * Parse NanoJava code in codeString and return the syntax tree.
     * 
     * @return root Node of the NanoJava syntax tree.
     */
    public static Node getNanoJavaNodeFromString(
        String codeString){

        InputStream in = new ByteArrayInputStream(codeString.getBytes());

        Node root = null;
        try {
            root = new NanoJavaParser(in).Goal();
        } catch(nano.ParseException e) {
            e.printStackTrace();
        }

        return root;
    }

    /** 
     * Parse NanoJava code in file filename and return the syntax tree.
     * 
     * @return root Node of the NanoJava syntax tree.
     */
    public static Node getNanoJavaNodeFromFile(String filename){
        InputStream in = null;
        try {
            in = new FileInputStream(filename);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        Node root = null;
        try {
            root = new NanoJavaParser(in).Goal();
        } catch(nano.ParseException e) {
            e.printStackTrace();
        }

        return root;
    }

    /**
     * Format the source code in the syntax tree using TreeFormatter,
     * then dump it to a string using TreeDumper.
     * 
     * @return pretty-printed string version of root.
     */
    public static String getMicroFormattedString(syntaxtree.Node root){
        StringWriter out = new StringWriter();
        final visitor.TreeDumper dumper = new visitor.TreeDumper(out);

        // This updates the location information in each Node
        root.accept(new visitor.TreeFormatter(INDENT_AMOUNT, WRAP_WIDTH));
        dumper.resetPosition();
        root.accept(dumper);
        return out.toString();
    }

    /** 
     * Parse MicroJava code in codeString and return the syntax tree.
     * 
     * @return root Node of the MicroJava syntax tree.
     */
    public static syntaxtree.Node getMicroJavaNodeFromString(
        String codeString){

        InputStream in = new ByteArrayInputStream(codeString.getBytes());

        syntaxtree.Node root = null;
        try {
            root = new MicroJavaParser(in).Goal();
        } catch(ParseException e) {
            e.printStackTrace();
        }

        return root;
    }

    /** 
     * Parse MicroJava code in file filename and return the syntax tree.
     * 
     * @return root Node of the MicroJava syntax tree.
     */
    public static syntaxtree.Node getMicroJavaNodeFromFile(String filename){
        InputStream in = null;
        try {
            in = new FileInputStream(filename);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        syntaxtree.Node root = null;
        try {
            root = new MicroJavaParser(in).Goal();
        } catch(ParseException e) {
            e.printStackTrace();
        }

        return root;
    }

    public static String getIdentifierName(Identifier identifier){
        return identifier.f0.tokenImage;
    }

    public static String getIdentifierName(syntaxtree.Identifier identifier){
        return identifier.f0.tokenImage;
    }

    public static Identifier getNewIdentifier(String name){
        return new Identifier(new NodeToken(name));
    }

    public static Identifier getCopy(Identifier identifier){
        return getNewIdentifier(getIdentifierName(identifier));
    }

    public static syntaxtree.Identifier getCopy(syntaxtree.Identifier identifier){
        return getNewMicroIdentifier(getIdentifierName(identifier));
    }

    public static syntaxtree.Identifier getNewMicroIdentifier(String name){
        return new syntaxtree.Identifier(new syntaxtree.NodeToken(name));
    }

    public static Type getNewType(String typeName){
        return new Type(new NodeChoice(getNewIdentifier(typeName), 3));
    }

    public static syntaxtree.Type getNewMicroType(String typeName){
        return new syntaxtree.Type(new syntaxtree.NodeChoice(getNewMicroIdentifier(typeName), 3));
    }

    /** 
     * @param type is of Identifier Type
     */
    public static Type getCopy(Type type){
        switch(type.f0.which){
            case 0:
                return new Type(new NodeChoice(new ArrayType(), 0));
            case 1:
                return new Type(new NodeChoice(new BooleanType(), 1));
            case 2:
                return new Type(new NodeChoice(new IntegerType(), 2));
            default:
                return getNewType(getIdentifierName((Identifier) type.f0.choice));
        }
    }

    /** 
     * @param type is of Identifier Type
     */
    public static syntaxtree.Type getCopy(syntaxtree.Type type){
        switch(type.f0.which){
            case 0:
                return new syntaxtree.Type(new syntaxtree.NodeChoice(new syntaxtree.ArrayType(), 0));
            case 1:
                return new syntaxtree.Type(new syntaxtree.NodeChoice(new syntaxtree.BooleanType(), 1));
            case 2:
                return new syntaxtree.Type(new syntaxtree.NodeChoice(new syntaxtree.IntegerType(), 2));
            default:
                return getNewMicroType(getIdentifierName((syntaxtree.Identifier) type.f0.choice));
        }
    }

    public static syntaxtree.FormalParameter getCopy(
        syntaxtree.FormalParameter parameter){

        return new syntaxtree.FormalParameter(getCopy(parameter.f0), getCopy(parameter.f1));
    }


    public static syntaxtree.FormalParameterList getCopy(
        syntaxtree.FormalParameterList paramList){
        
        syntaxtree.NodeListOptional restParams = new syntaxtree.NodeListOptional();
        for (syntaxtree.Node node : paramList.f1.nodes){
            restParams.addNode(new syntaxtree.FormalParameterRest(getCopy(((syntaxtree.FormalParameterRest) node).f1)));
        }

        return new syntaxtree.FormalParameterList(getCopy(paramList.f0), restParams);
    }

    public static syntaxtree.VarDeclaration getCopy(syntaxtree.VarDeclaration varDeclaration){
        return new syntaxtree.VarDeclaration(getCopy(varDeclaration.f0),
                                             getCopy(varDeclaration.f1));
    }

    /** 
     * Wrap node in a trivial class string, convert the string to a
     * NanoJava node, and extract the new node corresponding to the
     * given node.
     *
     * @param node is NodeListOptional of Statements
     * 
     * @return a deep copy of node
     */
    public static Node getCopyUsingString(Node node){
        String nodeString = getFormattedString(node);
        return getNanoMethodDeclaration(nodeString).f8;
    }

    /** 
     * Convert nanoStatementList -> String -> Micro Goal -> Micro statementList.
     *
     * @param nanoStatementList NodeListOptional of Statements
     * 
     * @return a MicroJava version of nanoStatementList
     */
    public static syntaxtree.NodeListOptional getMicroStatementList(NodeListOptional nanoStatementList){
        String nodeString = getFormattedString(nanoStatementList);
        return getMicroMethodDeclaration(nodeString).f8;
    }

    public static void writeCodeToFile(String code, String filename){
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

    public static NodeListOptional getVarDeclarationsFromParameterList(
        Node parameters){

        NodeListOptional varDeclarations = new NodeListOptional();
        if (parameters == null){
            return varDeclarations;
        }

        FormalParameterList actualParams = (FormalParameterList) parameters;
        varDeclarations.addNode(getVarDeclaration(actualParams.f0));
        for (Node node : actualParams.f1.nodes){
            varDeclarations.addNode(getVarDeclaration(((FormalParameterRest) node).f1));
        }

        return varDeclarations;
    }

    public static VarDeclaration getVarDeclaration(FormalParameter parameter){
        return new VarDeclaration(CPSHelper.getCopy(parameter.f0),
                                  CPSHelper.getCopy(parameter.f1));
    }

    /** 
     * @return Expression for VarRef of parameter's identifier
     */
    public static Expression getExpression(FormalParameter parameter){
        return new Expression(new NodeChoice(new PrimaryExpression(
            new NodeChoice(new VarRef(new NodeChoice(CPSHelper.getCopy(parameter.f1), 1)),
                           3)), 6));
    }

    /** 
     * @return Expression for VarRef of parameter's identifier
     */
    public static syntaxtree.Expression getExpression(syntaxtree.FormalParameter parameter){
        return new syntaxtree.Expression(
            new syntaxtree.NodeChoice(
                new syntaxtree.PrimaryExpression(
                    new syntaxtree.NodeChoice(
                        new syntaxtree.VarRef(
                            new syntaxtree.NodeChoice(CPSHelper.getCopy(parameter.f1), 1)),
                        3)), 6));
    }

    /** 
     * @return Expression for Identifier of currVarDeclaration.
     */
    public static Expression getExpression(VarDeclaration currVarDeclaration){
        return new Expression(new NodeChoice(
            new PrimaryExpression(new NodeChoice(
                new VarRef(new NodeChoice(CPSHelper.getCopy(currVarDeclaration.f1), 1)),
                3)), 6));
    }

    /** 
     * Return the arguments for the call() method of the continuation class.
     *
     * Note: Guaranteed that parameters has at least one parameter (i.e., k).
     */
    public static NodeOptional getArgs(Node parameters){
        FormalParameterList actualParams = (FormalParameterList) parameters;
        NodeListOptional restExpressions = new NodeListOptional();
        for (Node node : actualParams.f1.nodes){
            restExpressions.addNode(new ExpressionRest(
                getExpression(((FormalParameterRest) node).f1)));
        }
        return new NodeOptional(new ExpressionList(getExpression(actualParams.f0),
                                                   restExpressions));
    }

    /** 
     * Return the MicroJava arguments that would correspond to
     * nanoArgs for a method. Basically, just remove the last
     * argument, which is the current continuation.
     * 
     * Note: nanoArgs has at least one argument: the current continuation k
     */
    public static syntaxtree.NodeOptional getMicroArgs(NodeOptional nanoArgs){
        ExpressionList nanoArgList = (ExpressionList) nanoArgs.node;

        MessageSendStatement tempMessageSend = new MessageSendStatement(
            getNewIdentifier("foo"),
            getNewIdentifier("bar"),
            nanoArgs);
        
        NodeListOptional tempStatements = new NodeListOptional();
        tempStatements.addNode(new Statement(new NodeChoice(tempMessageSend, 6)));

        syntaxtree.Statement microMessageStatement = (syntaxtree.Statement) getMicroStatementList(
            tempStatements).nodes.get(0);

        // Guaranteed microArgs is non-empty
        syntaxtree.ExpressionList microArgs =
                (syntaxtree.ExpressionList) ((syntaxtree.MessageSendStatement) microMessageStatement.f0.choice).f4.node;

        // More than one NanoJava argument was present
        if (microArgs.f1.present()){
            // Remove the last argument
            microArgs.f1.nodes.remove(microArgs.f1.nodes.size() - 1);
            return new syntaxtree.NodeOptional(microArgs);
        }
        else {
            // Only one NanoJava argument: the current continuation
            return new syntaxtree.NodeOptional();
        }
    }

    /**
     * If parameters is an empty NodeOptional (i.e., no parameters at
     * all), return empty NodeOptional.
     * 
     * @return the arguments for a call to a MicroJava method given its parameters.
     */
    public static syntaxtree.NodeOptional getArgs(syntaxtree.Node parameters){
        syntaxtree.NodeOptional givenParams = (syntaxtree.NodeOptional) parameters;
        if (!givenParams.present()){
            return new syntaxtree.NodeOptional();
        }

        syntaxtree.FormalParameterList actualParams =
                (syntaxtree.FormalParameterList) givenParams.node;
        syntaxtree.NodeListOptional restExpressions = new syntaxtree.NodeListOptional();
        for (syntaxtree.Node node : actualParams.f1.nodes){
            System.out.println("CPSHelper.getMicroFormattedString(getExpression(((syntaxtree.FormalParameterRest) node).f1)): " + CPSHelper.getMicroFormattedString(getExpression(((syntaxtree.FormalParameterRest) node).f1)));
            restExpressions.addNode(new syntaxtree.ExpressionRest(
                getExpression(((syntaxtree.FormalParameterRest) node).f1)));
        }
        return new syntaxtree.NodeOptional(
            new syntaxtree.ExpressionList(
                getExpression(actualParams.f0),
                restExpressions));
    }

    public static syntaxtree.FormalParameter getFormalParameter(
        syntaxtree.VarDeclaration varDeclaration){

        return new syntaxtree.FormalParameter(CPSHelper.getCopy(varDeclaration.f0),
                                              CPSHelper.getCopy(varDeclaration.f1));
    }

    public static MethodDeclaration getNanoMethodDeclaration(String nodeString){
        String codeString = ""
                + "class DummyClass {"
                + "    public static void main(String [] a){"
                + "        new ____NewMainClass____().____Main____(0);"
                + "    }"
                + "}"
                + ""
                + "class ____NewMainClass____{"
                + "    public void ____Main____(int ____arg_length____){"
                + "    }"
                + "    public void fooMethod(){"
                + nodeString
                + "    }"
                + "}";

        Goal goal = (Goal) getNanoJavaNodeFromString(codeString);
        ClassDeclaration classDeclaration = (ClassDeclaration)
                ((TypeDeclaration) goal.f1.nodes.get(0)).f0.choice;
        MethodDeclaration methodDeclaration = (MethodDeclaration)
                classDeclaration.f4.nodes.get(1);
        return methodDeclaration;
    }

    public static NodeListOptional getNanoVarDeclarations(syntaxtree.NodeListOptional microVars){
        String nodeString = getMicroFormattedString(microVars);

        if (nodeString.trim().isEmpty()){
            return new NodeListOptional();
        }
        return getNanoMethodDeclaration(nodeString).f7;
    }

    public static syntaxtree.MethodDeclaration getMicroMethodDeclaration(String nodeString){
        String codeString = ""
                + "class DummyClass {"
                + "    public static void main(String [] a){"
                + "        new ____NewMainClass____().____Main____(0);"
                + "    }"
                + "}"
                + ""
                + "class ____NewMainClass____{"
                + "    public void ____Main____(int ____arg_length____){"
                + "    }"
                + "    public void fooMethod(){"
                + nodeString
                + "    }"
                + "}";

        syntaxtree.Goal goal = (syntaxtree.Goal) getMicroJavaNodeFromString(codeString);
        syntaxtree.ClassDeclaration classDeclaration = (syntaxtree.ClassDeclaration)
                ((syntaxtree.TypeDeclaration) goal.f1.nodes.get(0)).f0.choice;
        syntaxtree.MethodDeclaration methodDeclaration = (syntaxtree.MethodDeclaration)
                classDeclaration.f4.nodes.get(1);
        return methodDeclaration;
    }
}
