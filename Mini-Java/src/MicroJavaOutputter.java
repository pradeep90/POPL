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
public class MicroJavaOutputter<R> extends GJNoArguDepthFirst<R> {
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

    public R syntaxTree = null;
    public R newMainClass = null;

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
        return (Node) miniJavaRoot.accept(this);
    }

    /** 
     * Wrap printStatement in a "new main class".
     * 
     * @return the ClassDeclaration Node typecast to R.
     */
    public R getNewMainClass(syntaxtree.PrintStatement printStatement){
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
        return (R) new ClassDeclaration(new Identifier(new NodeToken(NEW_MAIN_CLASS_NAME)),
                                        new NodeListOptional(),
                                        new NodeListOptional(mainMethod));
    }

    // //
    // // Auto class visitors--probably don't need to be overridden.
    // //
    // public R visit(syntaxtree.NodeList n) {
    //     R _ret=null;
    //     int _count=0;
    //     for ( Enumeration<syntaxtree.Node> e = n.elements(); e.hasMoreElements(); ) {
    //         e.nextElement().accept(this);
    //         _count++;
    //     }
    //     return _ret;
    // }

    public R visit(syntaxtree.NodeListOptional n) {
        if ( n.present() ) {
            R _ret=null;
            NodeListOptional result = new NodeListOptional();
            int _count=0;
            for ( Enumeration<syntaxtree.Node> e = n.elements(); e.hasMoreElements(); ) {
                result.addNode((Node) e.nextElement().accept(this));
                _count++;
            }
            return (R) result;
        }
        else
            return (R) new NodeListOptional();
        // return null;
    }

    public R visit(syntaxtree.NodeOptional n) {
        if ( n.present() )
            return (R) new NodeOptional((Node) n.node.accept(this));
        else
            return (R) new NodeOptional();
    }

    // public R visit(syntaxtree.NodeSequence n) {
    //     R _ret=null;
    //     int _count=0;
    //     for ( Enumeration<syntaxtree.Node> e = n.elements(); e.hasMoreElements(); ) {
    //         e.nextElement().accept(this);
    //         _count++;
    //     }
    //     return _ret;
    // }

    public R visit(syntaxtree.NodeToken n) {
        output(n.tokenImage);
        return (R) new NodeToken(n.tokenImage);
    }

    // //
    // // User-generated visitor methods below
    // //

    /**
     * f0 -> MainClass()
     * f1 -> ( TypeDeclaration() )*
     * f2 -> <EOF>
     */
    public R visit(syntaxtree.Goal n) {
        R _ret=null;
        output(finalMainClass);
        MainClass f0 = (MainClass) n.f0.accept(this);
        NodeListOptional f1 = (NodeListOptional) n.f1.accept(this);
        f1.addNode((Node) newMainClass);
        NodeToken f2 = (NodeToken) n.f2.accept(this);
        _ret = (R) new Goal (f0, f1, f2);
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
    public R visit(syntaxtree.MainClass n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        R f3 = n.f3.accept(this);
        R f4 = n.f4.accept(this);
        R f5 = n.f5.accept(this);
        R f6 = n.f6.accept(this);
        R f7 = n.f7.accept(this);
        R f8 = n.f8.accept(this);
        R f9 = n.f9.accept(this);
        R f10 = n.f10.accept(this);
        R f11 = n.f11.accept(this);
        R f12 = n.f12.accept(this);
        R f13 = n.f13.accept(this);

        this.newMainClass = getNewMainClass(n.f14);

        R f15 = n.f15.accept(this);
        R f16 = n.f16.accept(this);

        _ret = (R) new MainClass((Identifier) f1,
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
    public R visit(syntaxtree.TypeDeclaration n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        return (R) new TypeDeclaration(new NodeChoice((Node) f0, n.f0.which));
    }

    /**
     * f0 -> "class"
     * f1 -> Identifier()
     * f2 -> "{"
     * f3 -> ( VarDeclaration() )*
     * f4 -> ( MethodDeclaration() )*
     * f5 -> "}"
     */
    public R visit(syntaxtree.ClassDeclaration n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        R f3 = n.f3.accept(this);
        R f4 = n.f4.accept(this);
        R f5 = n.f5.accept(this);
        _ret = (R) new ClassDeclaration((Identifier) f1,
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
    public R visit(syntaxtree.ClassExtendsDeclaration n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        R f3 = n.f3.accept(this);
        R f4 = n.f4.accept(this);
        R f5 = n.f5.accept(this);
        R f6 = n.f6.accept(this);
        R f7 = n.f7.accept(this);
        _ret = (R) new ClassExtendsDeclaration((Identifier) f1,
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
    public R visit(syntaxtree.VarDeclaration n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        _ret = (R) new VarDeclaration((Type) f0,
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
    public R visit(syntaxtree.MethodDeclaration n) {
        
        // TODO(spradeep): writable_arg variable
        
        R _ret=null;
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

        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        R f3 = n.f3.accept(this);
        R f4 = n.f4.accept(this);
        R f5 = n.f5.accept(this);
        R f6 = n.f6.accept(this);
        R f7 = n.f7.accept(this);
        R f8 = n.f8.accept(this);
        R f9 = n.f9.accept(this);
        R f10 = n.f10.accept(this);
        R f11 = n.f11.accept(this);
        R f12 = n.f12.accept(this);
        _ret = (R) new MethodDeclaration((Identifier) f2,
                                         (NodeOptional) f4,
                                         (NodeListOptional) f7,
                                         (NodeListOptional) f8);
        return _ret;
    }

    /**
     * f0 -> FormalParameter()
     * f1 -> ( FormalParameterRest() )*
     */
    public R visit(syntaxtree.FormalParameterList n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        _ret = (R) new FormalParameterList((FormalParameter) f0,
                                           (NodeListOptional) f1);
        return _ret;
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     */
    public R visit(syntaxtree.FormalParameter n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        _ret = (R) new FormalParameter((Type) f0,
                                       (Identifier) f1);
        return _ret;
    }

    /**
     * f0 -> ","
     * f1 -> FormalParameter()
     */
    public R visit(syntaxtree.FormalParameterRest n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        _ret = (R) new FormalParameterRest((FormalParameter) f1);
        return _ret;
    }

    /**
     * f0 -> ArrayType()
     *       | BooleanType()
     *       | IntegerType()
     *       | Identifier()
     */
    public R visit(syntaxtree.Type n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        _ret = (R) new Type(new NodeChoice((Node) f0, n.f0.which));
        return _ret;
    }

    /**
     * f0 -> "int"
     * f1 -> "["
     * f2 -> "]"
     */
    public R visit(syntaxtree.ArrayType n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        _ret = (R) new ArrayType();
        return _ret;
    }

    /**
     * f0 -> "boolean"
     */
    public R visit(syntaxtree.BooleanType n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        _ret = (R) new BooleanType();
        return _ret;
    }

    /**
     * f0 -> "int"
     */
    public R visit(syntaxtree.IntegerType n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        _ret = (R) new IntegerType();
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
    public R visit(syntaxtree.Statement n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        _ret = (R) new Statement(new NodeChoice((Node) f0, n.f0.which));
        return _ret;
    }

    /**
     * f0 -> "{"
     * f1 -> ( Statement() )*
     * f2 -> "}"
     */
    public R visit(syntaxtree.Block n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        _ret = (R) new Block((NodeToken) f0,
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
    public R visit(syntaxtree.AssignmentStatement n) {
        R _ret=null;
        System.out.println("syntaxtree.AssignmentStatement"); 
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        R f3 = n.f3.accept(this);
        _ret = (R) new AssignmentStatement(new VarRef(new NodeChoice((Node) f0, 1)),
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
    public R visit(syntaxtree.ArrayAssignmentStatement n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        R f3 = n.f3.accept(this);
        R f4 = n.f4.accept(this);
        R f5 = n.f5.accept(this);
        R f6 = n.f6.accept(this);
        _ret = (R) new ArrayAssignmentStatement((Identifier) f0,
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
    public R visit(syntaxtree.IfStatement n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        R f3 = n.f3.accept(this);
        R f4 = n.f4.accept(this);
        R f5 = n.f5.accept(this);
        R f6 = n.f6.accept(this);
        _ret = (R) new IfStatement((NodeToken) f0,
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
    public R visit(syntaxtree.WhileStatement n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        R f3 = n.f3.accept(this);
        R f4 = n.f4.accept(this);
        _ret = (R) new WhileStatement((NodeToken) f0,
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
    public R visit(syntaxtree.PrintStatement n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        R f3 = n.f3.accept(this);
        R f4 = n.f4.accept(this);
        _ret = (R) new PrintStatement((NodeToken) f0,
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
    public R visit(syntaxtree.Expression n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        _ret = (R) new Expression(new NodeChoice((Node) f0, n.f0.which));
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "&"
     * f2 -> PrimaryExpression()
     */
    public R visit(syntaxtree.AndExpression n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        _ret = (R) new AndExpression((PrimaryExpression) f0,
                                     (NodeToken) f1,
                                     (PrimaryExpression) f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "<"
     * f2 -> PrimaryExpression()
     */
    public R visit(syntaxtree.CompareExpression n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        _ret = (R) new CompareExpression((PrimaryExpression) f0,
                                         (NodeToken) f1,
                                         (PrimaryExpression) f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "+"
     * f2 -> PrimaryExpression()
     */
    public R visit(syntaxtree.PlusExpression n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        _ret = (R) new PlusExpression((PrimaryExpression) f0,
                                      (NodeToken) f1,
                                      (PrimaryExpression) f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "-"
     * f2 -> PrimaryExpression()
     */
    public R visit(syntaxtree.MinusExpression n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        _ret = (R) new MinusExpression((PrimaryExpression) f0,
                                       (NodeToken) f1,
                                       (PrimaryExpression) f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "*"
     * f2 -> PrimaryExpression()
     */
    public R visit(syntaxtree.TimesExpression n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        _ret = (R) new TimesExpression((PrimaryExpression) f0,
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
    public R visit(syntaxtree.ArrayLookup n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        R f3 = n.f3.accept(this);
        _ret = (R) new ArrayLookup((PrimaryExpression) f0,
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
    // public R visit(syntaxtree.ArrayLength n) {
    //     R _ret=null;
    //     R f0 = n.f0.accept(this);
    //     R f1 = n.f1.accept(this);
    //     R f2 = n.f2.accept(this);
    //     _ret = (R) new ArrayLength();
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
    // public R visit(syntaxtree.MessageSend n) {
    //     // System.out.println("Function Call??"); 
    //     R _ret=null;
    //     R f0 = n.f0.accept(this);
    //     R f1 = n.f1.accept(this);
    //     R f2 = n.f2.accept(this);
    //     R f3 = n.f3.accept(this);
    //     R f4 = n.f4.accept(this);
    //     R f5 = n.f5.accept(this);
    //     _ret = (R) new MessageSend();
    //     return _ret;
    // }

    /**
     * f0 -> Expression()
     * f1 -> ( ExpressionRest() )*
     */
    public R visit(syntaxtree.ExpressionList n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        _ret = (R) new ExpressionList((Expression) f0,
                                      (NodeListOptional) f1);
        return _ret;
    }

    /**
     * f0 -> ","
     * f1 -> Expression()
     */
    public R visit(syntaxtree.ExpressionRest n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        _ret = (R) new ExpressionRest((NodeToken) f0,
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
    public R visit(syntaxtree.PrimaryExpression n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        _ret = (R) new PrimaryExpression(new NodeChoice((Node) f0, n.f0.which));
        return _ret;
    }

    /**
     * f0 -> <INTEGER_LITERAL>
     */
    public R visit(syntaxtree.IntegerLiteral n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        _ret = (R) new IntegerLiteral((NodeToken) f0);
        return _ret;
    }

    /**
     * f0 -> "true"
     */
    public R visit(syntaxtree.TrueLiteral n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        _ret = (R) new TrueLiteral((NodeToken) f0);
        return _ret;
    }

    /**
     * f0 -> "false"
     */
    public R visit(syntaxtree.FalseLiteral n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        _ret = (R) new FalseLiteral((NodeToken) f0);
        return _ret;
    }

    /**
     * f0 -> <IDENTIFIER>
     */
    public R visit(syntaxtree.Identifier n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        _ret = (R) new Identifier((NodeToken) f0);
        return _ret;
    }

    /**
     * f0 -> "this"
     */
    public R visit(syntaxtree.ThisExpression n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        return (R) new ThisExpression((NodeToken) f0);
    }

    /**
     * f0 -> "new"
     * f1 -> "int"
     * f2 -> "["
     * f3 -> Expression()
     * f4 -> "]"
     */
    public R visit(syntaxtree.ArrayAllocationExpression n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        R f3 = n.f3.accept(this);
        R f4 = n.f4.accept(this);
        _ret = (R) new ArrayAllocationExpression((NodeToken) f0,
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
    public R visit(syntaxtree.AllocationExpression n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        R f3 = n.f3.accept(this);
        _ret = (R) new AllocationExpression((NodeToken) f0,
                                            (Identifier) f1,
                                            (NodeToken) f2,
                                            (NodeToken) f3);
        return _ret;
    }

    /**
     * f0 -> "!"
     * f1 -> Expression()
     */
    public R visit(syntaxtree.NotExpression n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        _ret = (R) new NotExpression((NodeToken) f0,
                                     (Expression) f1);
        return _ret;
    }

    /**
     * f0 -> "("
     * f1 -> Expression()
     * f2 -> ")"
     */
    public R visit(syntaxtree.BracketExpression n) {
        R _ret=null;
        R f0 = n.f0.accept(this);
        R f1 = n.f1.accept(this);
        R f2 = n.f2.accept(this);
        _ret = (R) new BracketExpression((NodeToken) f0,
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

