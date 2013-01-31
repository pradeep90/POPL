// import visitor.*;
// import syntaxtree.*;
import visitor.GJNoArguDepthFirst;
import java.util.*;
import microjavaparser.visitor.TreeFormatter;
import microjavaparser.visitor.TreeDumper;
import microjavaparser.syntaxtree.*;
import microjavaparser.*;

// import java.text.ParseException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/** 
 * Visitor to build a MicroJava syntax tree from a MiniJava syntax
 * tree.
 */
public class MicroJavaOutputter extends GJNoArguDepthFirst<Node> {
    public static final int INDENT_AMOUNT = 3;
    public static final int WRAP_WIDTH = 80;
    public static final String NEW_MAIN_METHOD_NAME = "____Main____";
    public static final String NEW_MAIN_CLASS_NAME = "____NewMainClass____";
    public static final String MAIN_METHOD_PARAM_NAME = "____arg_length____";
    public static final String PRINT_ME_STRING = "____printMe____";

    public static final Identifier pseudoMainClassName = new Identifier(
        new NodeToken(NEW_MAIN_CLASS_NAME));
    public static final Identifier pseudoMainMethod = new Identifier(
        new NodeToken(NEW_MAIN_METHOD_NAME));
    public static final NodeOptional mainMethodArg = new NodeOptional(
        new ExpressionList(new Expression(new NodeChoice(new PrimaryExpression(
            new NodeChoice(new IntegerLiteral(new NodeToken("0")), 0)), 6)),
                           new NodeListOptional()));
    
    public boolean isInMiniMain = false;

    public String finalMainClass = "";
    public String outputCodeString = "";

    public Node syntaxTree = null;
    public Node newMainClass = null;

    /**
     * Output codeString to stdout.
     *
     * Also, append it to outputCodeString.
     */
    public void output(String codeString){
        System.out.print(codeString + "\n");
        if (isInMiniMain){
            finalMainClass += codeString + "\n";
        }
        else{
            outputCodeString += codeString + "\n";
        }
    }

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
        } catch(microjavaparser.ParseException e) {
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
        } catch(microjavaparser.ParseException e) {
            e.printStackTrace();
        }

        return root;
    }

    /** 
     * Parse MiniJava code in file filename and return the syntax tree.
     * 
     * @return root Node of the MiniJava syntax tree.
     */
    public static syntaxtree.Node getMiniJavaNodeFromFile(String filename){
        InputStream in = null;
        try {
            in = new FileInputStream(filename);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        syntaxtree.Node root = null;
        try {
            root = new MiniJavaParser(in).Goal();
        } catch(ParseException e) {
            e.printStackTrace();
        }

        return root;   
    }

    /**
     * Use this visitor to convert miniJavaRoot to a MicroJava syntax
     * tree.
     * 
     * @return MicroJava equivalent of miniJavaRoot.
     */
    public Node getMicroJavaParseTree(syntaxtree.Node miniJavaRoot){
        return miniJavaRoot.accept(this);
    }

    /** 
     * Wrap printStatement in a "new main class".
     * 
     * @return the ClassDeclaration Node typecast to Node.
     */
    public Node getNewMainClass(syntaxtree.PrintStatement printStatement){
        FormalParameterList params = new FormalParameterList(
            new FormalParameter(
                new Type(new NodeChoice(new IntegerType(), 2)),
                new Identifier(new NodeToken(MAIN_METHOD_PARAM_NAME))),
            new NodeListOptional());

        // TODO(spradeep): What if expression is made up of multiple
        // expressions? => Fill mainMethodBodyStatements with the
        // direct MicroJava equivalent of printStatement. It will take
        // care of everything.

        NodeListOptional mainMethodBodyStatements = new NodeListOptional(
            new AssignmentStatement(
                new VarRef(new NodeChoice(new Identifier(new NodeToken(PRINT_ME_STRING)),
                                          1)),
                (Expression) printStatement.f2.accept(this)));
        mainMethodBodyStatements.addNode(new PrintStatement(
            new Expression(new NodeChoice(
                new PrimaryExpression(
                    new NodeChoice(
                        new VarRef(new NodeChoice(new Identifier(
                            new NodeToken(PRINT_ME_STRING)) ,1)),
                        3)),
                6))));
        MethodDeclaration mainMethod = new MethodDeclaration(
            new Identifier(new NodeToken(NEW_MAIN_METHOD_NAME)),
            new NodeOptional(params),
            new NodeListOptional(new VarDeclaration(
                new Type(new NodeChoice(new IntegerType(), 2)),
                new Identifier(new NodeToken(PRINT_ME_STRING)))),
            mainMethodBodyStatements);
        return new ClassDeclaration(new Identifier(new NodeToken(NEW_MAIN_CLASS_NAME)),
                                    new NodeListOptional(),
                                    new NodeListOptional(mainMethod));
    }

    // //
    // // Auto class visitors--probably don't need to be overridden.
    // //
    // public Node visit(syntaxtree.NodeList n) {
    //     Node _ret=null;
    //     int _count=0;
    //     for ( Enumeration<syntaxtree.Node> e = n.elements(); e.hasMoreElements(); ) {
    //         e.nextElement().accept(this);
    //         _count++;
    //     }
    //     return _ret;
    // }

    public Node visit(syntaxtree.NodeListOptional n) {
        if ( n.present() ) {
            Node _ret=null;
            NodeListOptional result = new NodeListOptional();
            int _count=0;
            for ( Enumeration<syntaxtree.Node> e = n.elements(); e.hasMoreElements(); ) {
                result.addNode(e.nextElement().accept(this));
                _count++;
            }
            return result;
        }
        else
            return new NodeListOptional();
        // return null;
    }

    public Node visit(syntaxtree.NodeOptional n) {
        if ( n.present() )
            return new NodeOptional(n.node.accept(this));
        else
            return new NodeOptional();
    }

    // public Node visit(syntaxtree.NodeSequence n) {
    //     Node _ret=null;
    //     int _count=0;
    //     for ( Enumeration<syntaxtree.Node> e = n.elements(); e.hasMoreElements(); ) {
    //         e.nextElement().accept(this);
    //         _count++;
    //     }
    //     return _ret;
    // }

    public Node visit(syntaxtree.NodeToken n) {
        output(n.tokenImage);
        return new NodeToken(n.tokenImage);
    }

    // //
    // // User-generated visitor methods below
    // //

    /**
     * f0 -> MainClass()
     * f1 -> ( TypeDeclaration() )*
     * f2 -> <EOF>
     */
    public Node visit(syntaxtree.Goal n) {
        Node _ret=null;
        output(finalMainClass);
        MainClass f0 = (MainClass) n.f0.accept(this);
        NodeListOptional f1 = (NodeListOptional) n.f1.accept(this);
        f1.addNode(newMainClass);
        NodeToken f2 = (NodeToken) n.f2.accept(this);
        _ret = new Goal (f0, f1, f2);
        return _ret;
    }

    /**
     * f0 -> "class"
     * f1 -> Identifier()
     * f2 -> "{"
     * f3 -> "public"
     * f4 -> "static"
     * f5 -> "void"
     * f6 -> "main"
     * f7 -> "("
     * f8 -> "String"
     * f9 -> "["
     * f10 -> "]"
     * f11 -> Identifier()
     * f12 -> ")"
     * f13 -> "{"
     * f14 -> PrintStatement()
     * f15 -> "}"
     * f16 -> "}"
     */
    public Node visit(syntaxtree.MainClass n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        Node f3 = n.f3.accept(this);
        Node f4 = n.f4.accept(this);
        Node f5 = n.f5.accept(this);
        Node f6 = n.f6.accept(this);
        Node f7 = n.f7.accept(this);
        Node f8 = n.f8.accept(this);
        Node f9 = n.f9.accept(this);
        Node f10 = n.f10.accept(this);
        Node f11 = n.f11.accept(this);
        Node f12 = n.f12.accept(this);
        Node f13 = n.f13.accept(this);

        this.newMainClass = getNewMainClass(n.f14);

        Node f15 = n.f15.accept(this);
        Node f16 = n.f16.accept(this);

        _ret = new MainClass((Identifier) f1,
                             (Identifier) f11,
                             pseudoMainClassName,
                             pseudoMainMethod,
                             mainMethodArg);
        return _ret;
    }

    /**
     * f0 -> ClassDeclaration()
     *       | ClassExtendsDeclaration()
     */
    public Node visit(syntaxtree.TypeDeclaration n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        return new TypeDeclaration(new NodeChoice(f0, n.f0.which));
    }

    /**
     * f0 -> "class"
     * f1 -> Identifier()
     * f2 -> "{"
     * f3 -> ( VarDeclaration() )*
     * f4 -> ( MethodDeclaration() )*
     * f5 -> "}"
     */
    public Node visit(syntaxtree.ClassDeclaration n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        Node f3 = n.f3.accept(this);
        Node f4 = n.f4.accept(this);
        Node f5 = n.f5.accept(this);
        _ret = new ClassDeclaration((Identifier) f1,
                                    (NodeListOptional) f3,
                                    (NodeListOptional) f4);
        return _ret;
    }

    /**
     * f0 -> "class"
     * f1 -> Identifier()
     * f2 -> "extends"
     * f3 -> Identifier()
     * f4 -> "{"
     * f5 -> ( VarDeclaration() )*
     * f6 -> ( MethodDeclaration() )*
     * f7 -> "}"
     */
    public Node visit(syntaxtree.ClassExtendsDeclaration n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        Node f3 = n.f3.accept(this);
        Node f4 = n.f4.accept(this);
        Node f5 = n.f5.accept(this);
        Node f6 = n.f6.accept(this);
        Node f7 = n.f7.accept(this);
        _ret = new ClassExtendsDeclaration((Identifier) f1,
                                           (Identifier) f3,
                                           (NodeListOptional) f5,
                                           (NodeListOptional) f6);
        return _ret;
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     * f2 -> ";"
     */
    public Node visit(syntaxtree.VarDeclaration n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        _ret = new VarDeclaration((Type) f0,
                                  (Identifier) f1);
        return _ret;
    }

    /**
     * f0 -> "public"
     * f1 -> Type()
     * f2 -> Identifier()
     * f3 -> "("
     * f4 -> ( FormalParameterList() )?
     * f5 -> ")"
     * f6 -> "{"
     * f7 -> ( VarDeclaration() )*
     * f8 -> ( Statement() )*
     * f9 -> "return"
     * f10 -> Expression()
     * f11 -> ";"
     * f12 -> "}"
     */
    public Node visit(syntaxtree.MethodDeclaration n) {
        
        // TODO(spradeep): writable_arg variable
        
        Node _ret=null;
        // n.f0.accept(this);
        // output("void");
        // // n.f1.accept(this);
        // n.f2.accept(this);
        // n.f3.accept(this);
        // n.f4.accept(this);
        // n.f5.accept(this);
        // n.f6.accept(this);
        // n.f7.accept(this);
        // n.f8.accept(this);
        // // n.f9.accept(this);
        // output("foo = ");
        // n.f10.accept(this);
        // output(";\n");
        // output("____1234Foo4321____ = foo;\n");
        // n.f11.accept(this);
        // n.f12.accept(this);

        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        Node f3 = n.f3.accept(this);
        Node f4 = n.f4.accept(this);
        Node f5 = n.f5.accept(this);
        Node f6 = n.f6.accept(this);
        Node f7 = n.f7.accept(this);
        Node f8 = n.f8.accept(this);
        Node f9 = n.f9.accept(this);
        Node f10 = n.f10.accept(this);
        Node f11 = n.f11.accept(this);
        Node f12 = n.f12.accept(this);
        _ret = new MethodDeclaration((Identifier) f2,
                                     (NodeOptional) f4,
                                     (NodeListOptional) f7,
                                     (NodeListOptional) f8);
        return _ret;
    }

    /**
     * f0 -> FormalParameter()
     * f1 -> ( FormalParameterRest() )*
     */
    public Node visit(syntaxtree.FormalParameterList n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        _ret = new FormalParameterList((FormalParameter) f0,
                                       (NodeListOptional) f1);
        return _ret;
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     */
    public Node visit(syntaxtree.FormalParameter n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        _ret = new FormalParameter((Type) f0,
                                   (Identifier) f1);
        return _ret;
    }

    /**
     * f0 -> ","
     * f1 -> FormalParameter()
     */
    public Node visit(syntaxtree.FormalParameterRest n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        _ret = new FormalParameterRest((FormalParameter) f1);
        return _ret;
    }

    /**
     * f0 -> ArrayType()
     *       | BooleanType()
     *       | IntegerType()
     *       | Identifier()
     */
    public Node visit(syntaxtree.Type n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        _ret = new Type(new NodeChoice(f0, n.f0.which));
        return _ret;
    }

    /**
     * f0 -> "int"
     * f1 -> "["
     * f2 -> "]"
     */
    public Node visit(syntaxtree.ArrayType n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        _ret = new ArrayType();
        return _ret;
    }

    /**
     * f0 -> "boolean"
     */
    public Node visit(syntaxtree.BooleanType n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        _ret = new BooleanType();
        return _ret;
    }

    /**
     * f0 -> "int"
     */
    public Node visit(syntaxtree.IntegerType n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        _ret = new IntegerType();
        return _ret;
    }

    /**
     * f0 -> Block()
     *       | AssignmentStatement()
     *       | ArrayAssignmentStatement()
     *       | IfStatement()
     *       | WhileStatement()
     *       | PrintStatement()
     */
    public Node visit(syntaxtree.Statement n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        _ret = new Statement(new NodeChoice(f0, n.f0.which));
        return _ret;
    }

    /**
     * f0 -> "{"
     * f1 -> ( Statement() )*
     * f2 -> "}"
     */
    public Node visit(syntaxtree.Block n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        _ret = new Block((NodeToken) f0,
                         (NodeListOptional) f1,
                         (NodeToken) f2);
        return _ret;
    }

    // TODO(spradeep): Check this thoroughly later.
    /**
     * f0 -> Identifier()
     * f1 -> "="
     * f2 -> Expression()
     * f3 -> ";"
     */
    public Node visit(syntaxtree.AssignmentStatement n) {
        Node _ret=null;
        System.out.println("syntaxtree.AssignmentStatement"); 
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        Node f3 = n.f3.accept(this);
        _ret = new AssignmentStatement(new VarRef(new NodeChoice(f0, 1)),
                                       (NodeToken) f1,
                                       (Expression) f2,
                                       (NodeToken) f3);
        return _ret;
    }

    /**
     * f0 -> Identifier()
     * f1 -> "["
     * f2 -> Expression()
     * f3 -> "]"
     * f4 -> "="
     * f5 -> Expression()
     * f6 -> ";"
     */
    public Node visit(syntaxtree.ArrayAssignmentStatement n) {
        // TODO(spradeep): See if the order of expansion of f2 and f5
        // makes a big difference. Remember, there can be multiple Nodes
        // on expansion of Expression.
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        Node f3 = n.f3.accept(this);
        Node f4 = n.f4.accept(this);
        Node f5 = n.f5.accept(this);
        Node f6 = n.f6.accept(this);
        _ret = new ArrayAssignmentStatement((Identifier) f0,
                                            (NodeToken) f1,
                                            (Expression) f2,
                                            (NodeToken) f3,
                                            (NodeToken) f4,
                                            (Expression) f5,
                                            (NodeToken) f6);
        return _ret;
    }

    /**
     * f0 -> "if"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> Statement()
     * f5 -> "else"
     * f6 -> Statement()
     */
    public Node visit(syntaxtree.IfStatement n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        Node f3 = n.f3.accept(this);
        Node f4 = n.f4.accept(this);
        Node f5 = n.f5.accept(this);
        Node f6 = n.f6.accept(this);
        _ret = new IfStatement((NodeToken) f0,
                               (NodeToken) f1,
                               (Expression) f2,
                               (NodeToken) f3,
                               (Statement) f4,
                               (NodeToken) f5,
                               (Statement) f6);
        return _ret;
    }

    /**
     * f0 -> "while"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> Statement()
     */
    public Node visit(syntaxtree.WhileStatement n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        Node f3 = n.f3.accept(this);
        Node f4 = n.f4.accept(this);
        _ret = new WhileStatement((NodeToken) f0,
                                  (NodeToken) f1,
                                  (Expression) f2,
                                  (NodeToken) f3,
                                  (Statement) f4);
        return _ret;
    }

    // TODO(spradeep): Take care of MiniJava Expressions that are not
    // valid MicroJava expressions.
    /**
     * f0 -> "System.out.println"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> ";"
     */
    public Node visit(syntaxtree.PrintStatement n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        Node f3 = n.f3.accept(this);
        Node f4 = n.f4.accept(this);
        _ret = new PrintStatement((NodeToken) f0,
                                  (NodeToken) f1,
                                  (Expression) f2,
                                  (NodeToken) f3,
                                  (NodeToken) f4);
        return _ret;
    }

    /**
     * f0 -> AndExpression()
     *       | CompareExpression()
     *       | PlusExpression()
     *       | MinusExpression()
     *       | TimesExpression()
     *       | ArrayLookup()
     *       | ArrayLength()
     *       | MessageSend()
     *       | PrimaryExpression()
     */
    public Node visit(syntaxtree.Expression n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        _ret = new Expression(new NodeChoice(f0, n.f0.which));
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "&"
     * f2 -> PrimaryExpression()
     */
    public Node visit(syntaxtree.AndExpression n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        _ret = new AndExpression((PrimaryExpression) f0,
                                 (NodeToken) f1,
                                 (PrimaryExpression) f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "<"
     * f2 -> PrimaryExpression()
     */
    public Node visit(syntaxtree.CompareExpression n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        _ret = new CompareExpression((PrimaryExpression) f0,
                                     (NodeToken) f1,
                                     (PrimaryExpression) f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "+"
     * f2 -> PrimaryExpression()
     */
    public Node visit(syntaxtree.PlusExpression n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        _ret = new PlusExpression((PrimaryExpression) f0,
                                  (NodeToken) f1,
                                  (PrimaryExpression) f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "-"
     * f2 -> PrimaryExpression()
     */
    public Node visit(syntaxtree.MinusExpression n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        _ret = new MinusExpression((PrimaryExpression) f0,
                                   (NodeToken) f1,
                                   (PrimaryExpression) f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "*"
     * f2 -> PrimaryExpression()
     */
    public Node visit(syntaxtree.TimesExpression n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        _ret = new TimesExpression((PrimaryExpression) f0,
                                   (NodeToken) f1,
                                   (PrimaryExpression) f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "["
     * f2 -> PrimaryExpression()
     * f3 -> "]"
     */
    public Node visit(syntaxtree.ArrayLookup n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        Node f3 = n.f3.accept(this);
        _ret = new ArrayLookup((PrimaryExpression) f0,
                               (NodeToken) f1,
                               (PrimaryExpression) f2,
                               (NodeToken) f3);
        return _ret;
    }

    // /**
    //  * f0 -> PrimaryExpression()
    //  * f1 -> "."
    //  * f2 -> "length"
    //  */
    // public Node visit(syntaxtree.ArrayLength n) {
    //     // TODO(spradeep): PrimaryExpression could have precedingNodes
    //     // as well.
    //     Node _ret=null;
    //     Node f0 = n.f0.accept(this);
    //     Node f1 = n.f1.accept(this);
    //     Node f2 = n.f2.accept(this);
    //     _ret = new ArrayLength();
    //     return _ret;
    // }

    // /**
    //  * f0 -> PrimaryExpression()
    //  * f1 -> "."
    //  * f2 -> Identifier()
    //  * f3 -> "("
    //  * f4 -> ( ExpressionList() )?
    //  * f5 -> ")"
    //  */
    // public Node visit(syntaxtree.MessageSend n) {
    //     // System.out.println("Function Call??"); 
    //     Node _ret=null;
    //     Node f0 = n.f0.accept(this);
    //     Node f1 = n.f1.accept(this);
    //     Node f2 = n.f2.accept(this);
    //     Node f3 = n.f3.accept(this);
    //     Node f4 = n.f4.accept(this);
    //     Node f5 = n.f5.accept(this);
    //     _ret = new MessageSend();
    //     return _ret;
    // }

    /**
     * f0 -> Expression()
     * f1 -> ( ExpressionRest() )*
     */
    public Node visit(syntaxtree.ExpressionList n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        _ret = new ExpressionList((Expression) f0,
                                  (NodeListOptional) f1);
        return _ret;
    }

    /**
     * f0 -> ","
     * f1 -> Expression()
     */
    public Node visit(syntaxtree.ExpressionRest n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        _ret = new ExpressionRest((NodeToken) f0,
                                  (Expression) f1);
        return _ret;
    }

    /**
     * f0 -> IntegerLiteral()
     *       | TrueLiteral()
     *       | FalseLiteral()
     *       | Identifier()
     *       | ThisExpression()
     *       | ArrayAllocationExpression()
     *       | AllocationExpression()
     *       | NotExpression()
     *       | BracketExpression()
     */
    public Node visit(syntaxtree.PrimaryExpression n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        _ret = new PrimaryExpression(new NodeChoice(f0, n.f0.which));
        return _ret;
    }

    /**
     * f0 -> <INTEGER_LITERAL>
     */
    public Node visit(syntaxtree.IntegerLiteral n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        _ret = new IntegerLiteral((NodeToken) f0);
        return _ret;
    }

    /**
     * f0 -> "true"
     */
    public Node visit(syntaxtree.TrueLiteral n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        _ret = new TrueLiteral((NodeToken) f0);
        return _ret;
    }

    /**
     * f0 -> "false"
     */
    public Node visit(syntaxtree.FalseLiteral n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        _ret = new FalseLiteral((NodeToken) f0);
        return _ret;
    }

    /**
     * f0 -> <IDENTIFIER>
     */
    public Node visit(syntaxtree.Identifier n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        _ret = new Identifier((NodeToken) f0);
        return _ret;
    }

    /**
     * f0 -> "this"
     */
    public Node visit(syntaxtree.ThisExpression n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        return new ThisExpression((NodeToken) f0);
    }

    /**
     * f0 -> "new"
     * f1 -> "int"
     * f2 -> "["
     * f3 -> Expression()
     * f4 -> "]"
     */
    public Node visit(syntaxtree.ArrayAllocationExpression n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        Node f3 = n.f3.accept(this);
        Node f4 = n.f4.accept(this);
        _ret = new ArrayAllocationExpression((NodeToken) f0,
                                             (NodeToken) f1,
                                             (NodeToken) f2,
                                             (Expression) f3,
                                             (NodeToken) f4);
        return _ret;
    }

    /**
     * f0 -> "new"
     * f1 -> Identifier()
     * f2 -> "("
     * f3 -> ")"
     */
    public Node visit(syntaxtree.AllocationExpression n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        Node f3 = n.f3.accept(this);
        _ret = new AllocationExpression((NodeToken) f0,
                                        (Identifier) f1,
                                        (NodeToken) f2,
                                        (NodeToken) f3);
        return _ret;
    }

    /**
     * f0 -> "!"
     * f1 -> Expression()
     */
    public Node visit(syntaxtree.NotExpression n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        _ret = new NotExpression((NodeToken) f0,
                                 (Expression) f1);
        return _ret;
    }

    /**
     * f0 -> "("
     * f1 -> Expression()
     * f2 -> ")"
     */
    public Node visit(syntaxtree.BracketExpression n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        _ret = new BracketExpression((NodeToken) f0,
                                     (Expression) f1,
                                     (NodeToken) f2);
        return _ret;
    }

    public String getMicroJavaCode(){
        return outputCodeString;
    }

    public String getFullMicroJavaCode(){
        return outputCodeString;
        // return getFormattedString(getMicroJavaNodeFromString(outputCodeString));
    }
}

