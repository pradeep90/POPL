package inliner;

import java.util.*;

import inliner.syntaxtree.*;
import inliner.visitor.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.PrintStream;
import java.io.FileOutputStream;

public class InlinerHelper {
    
    public InlinerHelper() {
        
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
     * Parse MicroJava code in codeString and return the syntax tree.
     * 
     * @return root Node of the MicroJava syntax tree.
     */
    public static Node getMicroJavaNodeFromString(
        String codeString){

        InputStream in = new ByteArrayInputStream(codeString.getBytes());

        Node root = null;
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
    public static Node getMicroJavaNodeFromFile(String filename){
        InputStream in = null;
        try {
            in = new FileInputStream(filename);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        Node root = null;
        try {
            root = new MicroJavaParser(in).Goal();
        } catch(ParseException e) {
            e.printStackTrace();
        }

        return root;
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
        return new VarDeclaration(InlinerHelper.getCopy(parameter.f0),
                                  InlinerHelper.getCopy(parameter.f1));
    }

    /** 
     * @return Expression for VarRef of parameter's identifier
     */
    public static Expression getExpression(FormalParameter parameter){
        return new Expression(new NodeChoice(new PrimaryExpression(
            new NodeChoice(new VarRef(new NodeChoice(InlinerHelper.getCopy(parameter.f1), 1)),
                           3)), 6));
    }

    /** 
     * @return Expression for Identifier of currVarDeclaration.
     */
    public static Expression getExpression(VarDeclaration currVarDeclaration){
        return new Expression(new NodeChoice(
            new PrimaryExpression(new NodeChoice(
                new VarRef(new NodeChoice(InlinerHelper.getCopy(currVarDeclaration.f1), 1)),
                3)), 6));
    }

    // TODO: 
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
     * @return MethodDeclaration containing nodeString as its body
     */
    public static MethodDeclaration getMethodDeclaration(String nodeString){
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

        Goal goal = (Goal) getMicroJavaNodeFromString(codeString);
        ClassDeclaration classDeclaration = (ClassDeclaration)
                ((TypeDeclaration) goal.f1.nodes.get(0)).f0.choice;
        MethodDeclaration methodDeclaration = (MethodDeclaration)
                classDeclaration.f4.nodes.get(1);
        return methodDeclaration;
    }

    public static String getIdentifierName(Identifier identifier){
        return identifier.f0.tokenImage;
    }

    public static Identifier getNewIdentifier(String name){
        return new Identifier(new NodeToken(name));
    }

    public static Identifier getCopy(Identifier identifier){
        return getNewIdentifier(getIdentifierName(identifier));
    }

    
    
    public static Type getNewType(String typeName){
        return new Type(new NodeChoice(getNewIdentifier(typeName), 3));
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
     * Wrap node in a trivial class string, convert the string to a
     * MicroJava node, and extract the new node corresponding to the
     * given node.
     *
     * @param node is NodeListOptional of Statements
     * 
     * @return a deep copy of node
     */
    public static Node getCopyUsingString(Node node){
        String nodeString = getFormattedString(node);
        return getMethodDeclaration(nodeString).f8;
    }

    public static List<Expression> getSaneExpressionList(NodeOptional n){
        List<Expression> list = new ArrayList<Expression>();
        if (!n.present()){
            return list;
        }

        ExpressionList expressions = (ExpressionList) n.node;
        list.add(expressions.f0);
        for (Node expression : expressions.f1.nodes){
            list.add(((ExpressionRest) expression).f1);
        }

        return list;
    }
    
    public static List<FormalParameter> getSaneFormalParameterList(NodeOptional n){
        List<FormalParameter> list = new ArrayList<FormalParameter>();
        if (!n.present()){
            return list;
        }

        FormalParameterList parameters = (FormalParameterList) n.node;
        list.add(parameters.f0);
        for (Node param : parameters.f1.nodes){
            list.add(((FormalParameterRest) param).f1);
        }

        return list;
    }
}
