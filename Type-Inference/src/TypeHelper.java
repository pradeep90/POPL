import syntaxtree.*;
import java.util.*;
import visitor.TreeFormatter;
import visitor.TreeDumper;

// import java.text.ParseException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

public class TypeHelper {
    public TypeHelper() {
        
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
     * Parse MiniScheme code in codeString and return the syntax tree.
     * 
     * @return root Node of the MiniScheme syntax tree.
     */
    public static Node getMiniSchemeNodeFromString(
        String codeString){

        InputStream in = new ByteArrayInputStream(codeString.getBytes());

        Node root = null;
        try {
            root = new MiniSchemeParser(in).Goal();
        } catch(ParseException e) {
            e.printStackTrace();
        }

        return root;
    }

    /** 
     * Parse MiniScheme code in file filename and return the syntax tree.
     * 
     * @return root Node of the MiniScheme syntax tree.
     */
    public static Node getMiniSchemeNodeFromFile(String filename){
        InputStream in = null;
        try {
            in = new FileInputStream(filename);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        Node root = null;
        try {
            root = new MiniSchemeParser(in).Goal();
        } catch(ParseException e) {
            e.printStackTrace();
        }

        return root;
    }

    public static String getIdentifierName(Identifier identifier){
        return identifier.f0.tokenImage;
    }

    public static Identifier getNewIdentifier(String name){
        return new Identifier(new NodeToken(name));
    }
}
