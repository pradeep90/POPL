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

}
