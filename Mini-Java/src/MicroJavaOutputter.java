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
public class MicroJavaOutputter extends GJNoArguDepthFirst<ExpansionNode> {
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

    public HashMap<String, Type> methodReturnTypeHash = new HashMap<String, Type>();

    public int tempCtr = 0;
    
    public boolean isInMiniMain = false;

    public boolean isFirstPass = true;

    public String finalMainClass = "";
    public String outputCodeString = "";

    public ExpansionNode syntaxTree = null;
    public Node newMainClass = null;

    /**
     * Output codeString to stdout.
     *
     * Also, append it to outputCodeString.
     */
    public void output(String codeString){
        // System.out.print(codeString + "\n");
        if (isInMiniMain){
            finalMainClass += codeString + "\n";
        }
        else{
            outputCodeString += codeString + "\n";
        }
    }

    /** 
     * @return NodeListOptional containing nodes of list1 and list2.
     */
    public static NodeListOptional concatenateNodeLists(NodeListOptional list1,
                                                        NodeListOptional list2){
        NodeListOptional result = new NodeListOptional();

        for (Node node : list1.nodes){
            result.addNode(node);
        }

        for (Node node : list2.nodes){
            result.addNode(node);
        }
        return result;
    }

    /** 
     * @param expansionNode has node of NodeListOptional type.
     * 
     * @return precedingNodes + expansionNode.node
     */
    public static NodeListOptional getSquashedNodeList(ExpansionNode expansionNode){
        NodeListOptional middle;
        if (expansionNode.node instanceof NodeListOptional){
            middle = (NodeListOptional) expansionNode.node;
        }
        else {
            middle = new NodeListOptional(expansionNode.node);
        }

        return concatenateNodeLists(expansionNode.precedingNodes,
                                    middle);
    }

    public void addBinding(Identifier methodIdentifier, Type returnType){
        methodReturnTypeHash.put(getMethodName(methodIdentifier),
                                 returnType);
    }


    /** 
     * @return new unique temporary variable name.
     */
    public String getNewTempVarName(){
        return "___tmp" + tempCtr++;
    }


    public static Identifier getTempIdentifier(String varName){
        return new Identifier(new NodeToken(varName));
    }

    public static String getMethodName(Identifier methodIdentifier){
        return methodIdentifier.f0.tokenImage;
    }

    public static String getMethodRetVarName(Identifier methodIdentifier){
        return "____1234" + getMethodName(methodIdentifier) + "4321____";
    }

    public static Identifier getMethodRetVarIdentifier(Identifier methodIdentifier){
        return getTempIdentifier(getMethodRetVarName(methodIdentifier));
    }

    /** 
     * @return VarDeclaration for varName.
     */
    public VarDeclaration getVarDeclaration(String varName){
        return getVarDeclaration(varName, new Type(new NodeChoice(new IntegerType(), 2)));
    }

    /** 
     * @return VarDeclaration for varName given the methodIdentifier.
     */
    public VarDeclaration getVarDeclaration(String varName, Identifier methodIdentifier){
        if (methodReturnTypeHash.containsKey(getMethodName(methodIdentifier))){
            return getVarDeclaration(varName,
                                     methodReturnTypeHash.get(
                                         getMethodName(methodIdentifier)));
        }
        else{
            return getVarDeclaration(varName, new Type(new NodeChoice(
                getTempIdentifier("TYPE_" + getMethodName(methodIdentifier)), 3)));
        }
    }

    /** 
     * @return VarDeclaration for varName with type.
     */
    public VarDeclaration getVarDeclaration(String varName, Type type){
        return new VarDeclaration(type, getTempIdentifier(varName));
    }

    public AssignmentStatement getAssiStatement(String varName, Node primExprNode){
        return new AssignmentStatement(
            new VarRef(new NodeChoice(getTempIdentifier(varName), 1)),
            new Expression(new NodeChoice(primExprNode, 6)));
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

        ExpansionNode printStatementStuff = printStatement.accept(this);

        MethodDeclaration mainMethod = new MethodDeclaration(
            new Identifier(new NodeToken(NEW_MAIN_METHOD_NAME)),
            new NodeOptional(params),
            printStatementStuff.varDeclarations,
            getSquashedNodeList(printStatementStuff));
        return new ClassDeclaration(
            new Identifier(new NodeToken(NEW_MAIN_CLASS_NAME)),
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

    public ExpansionNode visit(syntaxtree.NodeListOptional n) {
        if ( n.present() ) {
            ExpansionNode _ret = new ExpansionNode();
            NodeListOptional result = new NodeListOptional();
            int _count=0;
            for ( Enumeration<syntaxtree.Node> e = n.elements(); e.hasMoreElements(); ) {
                ExpansionNode curr = e.nextElement().accept(this);
                result.addNode(curr.node);
                _ret.extendAuxiliary(curr);
                _count++;
            }
            _ret.node = result;
            return _ret;
        }
        else
            return new ExpansionNode(new NodeListOptional());
        // return null;
    }

    public ExpansionNode visit(syntaxtree.NodeOptional n) {
        ExpansionNode _ret;
        if ( n.present() ){
            ExpansionNode curr = n.node.accept(this);
            _ret = new ExpansionNode(new NodeOptional(curr));
            _ret.extendAuxiliary(curr);
            return _ret;
        }
        else{
            _ret = new ExpansionNode(new NodeOptional());
            return _ret;
        }
    }

    // public ExpansionNode visit(syntaxtree.NodeSequence n) {
    //     ExpansionNode _ret=null;
    //     int _count=0;
    //     for ( Enumeration<syntaxtree.Node> e = n.elements(); e.hasMoreElements(); ) {
    //         e.nextElement().accept(this);
    //         _count++;
    //     }
    //     return _ret;
    // }

    public ExpansionNode visit(syntaxtree.NodeToken n) {
        output(n.tokenImage);
        return new ExpansionNode(new NodeToken(n.tokenImage));
    }

    // //
    // // User-generated visitor methods below
    // //

    /**
     * f0 -> MainClass()
     * f1 -> ( TypeDeclaration() )*
     * f2 -> <EOF>
     */
    public ExpansionNode visit(syntaxtree.Goal n) {
        // TODO(spradeep): Later, see if you need to use
        // extendAuxiliary here.
        ExpansionNode _ret;
        MainClass f0;
        NodeListOptional f1;
        NodeToken f2;

        // _ret = null;
        // f0 = (MainClass) n.f0.accept(this).node;
        // f1 = (NodeListOptional) n.f1.accept(this).node;
        // f1.addNode(newMainClass);
        // f2 = (NodeToken) n.f2.accept(this).node;
        // _ret = new ExpansionNode(new Goal (f0, f1, f2));

        // isFirstPass = false;

        _ret = null;
        f0 = (MainClass) n.f0.accept(this).node;
        f1 = (NodeListOptional) n.f1.accept(this).node;
        f1.addNode(newMainClass);
        f2 = (NodeToken) n.f2.accept(this).node;
        _ret = new ExpansionNode(new Goal (f0, f1, f2));

        VariableSubstituter variableSubstituter = new VariableSubstituter();
        variableSubstituter.methodReturnTypeHash = methodReturnTypeHash;

        System.out.println("methodReturnTypeHash: " + methodReturnTypeHash);

        // assertEqualMicroJavaNodes(_ret.node, variableSubstituter.visit((Goal)_ret.node));
        return new ExpansionNode(variableSubstituter.visit((Goal)_ret.node));

        // return _ret;
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
    public ExpansionNode visit(syntaxtree.MainClass n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        ExpansionNode f3 = n.f3.accept(this);
        ExpansionNode f4 = n.f4.accept(this);
        ExpansionNode f5 = n.f5.accept(this);
        ExpansionNode f6 = n.f6.accept(this);
        ExpansionNode f7 = n.f7.accept(this);
        ExpansionNode f8 = n.f8.accept(this);
        ExpansionNode f9 = n.f9.accept(this);
        ExpansionNode f10 = n.f10.accept(this);
        ExpansionNode f11 = n.f11.accept(this);
        ExpansionNode f12 = n.f12.accept(this);
        ExpansionNode f13 = n.f13.accept(this);

        this.newMainClass = getNewMainClass(n.f14);

        ExpansionNode f15 = n.f15.accept(this);
        ExpansionNode f16 = n.f16.accept(this);

        _ret = new ExpansionNode(new MainClass((Identifier) f1.node,
                                               (Identifier) f11.node,
                                               pseudoMainClassName,
                                               pseudoMainMethod,
                                               mainMethodArg));
        _ret.extendAuxiliary(f1);
        _ret.extendAuxiliary(f11);
        return _ret;
    }

    /**
     * f0 -> ClassDeclaration()
     *       | ClassExtendsDeclaration()
     */
    public ExpansionNode visit(syntaxtree.TypeDeclaration n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        _ret = new ExpansionNode(new TypeDeclaration(new NodeChoice(f0.node, n.f0.which)));
        _ret.extendAuxiliary(f0);
        return _ret;
    }

    /**
     * f0 -> "class"
     * f1 -> Identifier()
     * f2 -> "{"
     * f3 -> ( VarDeclaration() )*
     * f4 -> ( MethodDeclaration() )*
     * f5 -> "}"
     */
    public ExpansionNode visit(syntaxtree.ClassDeclaration n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        ExpansionNode f3 = n.f3.accept(this);
        ExpansionNode f4 = n.f4.accept(this);
        ExpansionNode f5 = n.f5.accept(this);

        _ret = new ExpansionNode(new ClassDeclaration(
            (Identifier) f1.node,
            concatenateNodeLists((NodeListOptional) f3.node, f4.varDeclarations),
            (NodeListOptional) f4.node));
        // _ret.extendAuxiliary(f1);
        // _ret.extendAuxiliary(f3);
        // _ret.extendAuxiliary(f4);
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
    public ExpansionNode visit(syntaxtree.ClassExtendsDeclaration n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        ExpansionNode f3 = n.f3.accept(this);
        ExpansionNode f4 = n.f4.accept(this);
        ExpansionNode f5 = n.f5.accept(this);
        ExpansionNode f6 = n.f6.accept(this);
        ExpansionNode f7 = n.f7.accept(this);
        _ret = new ExpansionNode(new ClassExtendsDeclaration((Identifier) f1.node,
                                                             (Identifier) f3.node,
                                                             (NodeListOptional) f5.node,
                                                             (NodeListOptional) f6.node));
        _ret.extendAuxiliary(f1);
        _ret.extendAuxiliary(f3);
        _ret.extendAuxiliary(f5);
        _ret.extendAuxiliary(f6);
        return _ret;
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     * f2 -> ";"
     */
    public ExpansionNode visit(syntaxtree.VarDeclaration n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        _ret = new ExpansionNode(new VarDeclaration((Type) f0.node,
                                                    (Identifier) f1.node));
        _ret.extendAuxiliary(f0);
        _ret.extendAuxiliary(f1);
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
    public ExpansionNode visit(syntaxtree.MethodDeclaration n) {
        
        // TODO(spradeep): writable_arg variable
        
        ExpansionNode _ret=null;

        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        ExpansionNode f3 = n.f3.accept(this);
        ExpansionNode f4 = n.f4.accept(this);
        ExpansionNode f5 = n.f5.accept(this);
        ExpansionNode f6 = n.f6.accept(this);
        ExpansionNode f7 = n.f7.accept(this);
        ExpansionNode f8 = n.f8.accept(this);
        ExpansionNode f9 = n.f9.accept(this);
        ExpansionNode f10 = n.f10.accept(this);
        ExpansionNode f11 = n.f11.accept(this);
        ExpansionNode f12 = n.f12.accept(this);

        NodeListOptional allVarDeclarations = concatenateNodeLists((NodeListOptional) f7.node,
                                                                   f8.varDeclarations);
        allVarDeclarations = concatenateNodeLists(allVarDeclarations,
                                                  f10.varDeclarations);
        NodeListOptional allStatements = concatenateNodeLists(f8.precedingNodes,
                                                              (NodeListOptional) f8.node);
        allStatements = concatenateNodeLists(allStatements,
                                             f10.precedingNodes);

        Statement pseudoReturnStatement = new Statement(new NodeChoice(new AssignmentStatement(
            new VarRef(new NodeChoice(getMethodRetVarIdentifier((Identifier) f2.node),
                                      1)),
            (Expression) f10.node), 1));

        allStatements.addNode(pseudoReturnStatement);

        _ret = new ExpansionNode(new MethodDeclaration((Identifier) f2.node,
                                                       (NodeOptional) f4.node,
                                                       allVarDeclarations,
                                                       allStatements));
        VarDeclaration pseudoReturnVariable =
                getVarDeclaration(getMethodRetVarName((Identifier) f2.node),
                                  (Identifier) f2.node);
        _ret.varDeclarations.addNode(pseudoReturnVariable);

        addBinding((Identifier) f2.node, (Type) f1.node);
        return _ret;
    }

    /**
     * f0 -> FormalParameter()
     * f1 -> ( FormalParameterRest() )*
     */
    public ExpansionNode visit(syntaxtree.FormalParameterList n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        _ret = new ExpansionNode(new FormalParameterList((FormalParameter) f0.node,
                                                         (NodeListOptional) f1.node));
        _ret.extendAuxiliary(f0);
        _ret.extendAuxiliary(f1);
        return _ret;
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     */
    public ExpansionNode visit(syntaxtree.FormalParameter n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        _ret = new ExpansionNode(new FormalParameter((Type) f0.node,
                                                     (Identifier) f1.node));
        _ret.extendAuxiliary(f0);
        _ret.extendAuxiliary(f1);
        return _ret;
    }

    /**
     * f0 -> ","
     * f1 -> FormalParameter()
     */
    public ExpansionNode visit(syntaxtree.FormalParameterRest n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        _ret = new ExpansionNode(new FormalParameterRest((FormalParameter) f1.node));
        _ret.extendAuxiliary(f1);
        return _ret;
    }

    /**
     * f0 -> ArrayType()
     *       | BooleanType()
     *       | IntegerType()
     *       | Identifier()
     */
    public ExpansionNode visit(syntaxtree.Type n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        _ret = new ExpansionNode(new Type(new NodeChoice(f0.node, n.f0.which)));
        _ret.extendAuxiliary(f0);
        return _ret;
    }

    /**
     * f0 -> "int"
     * f1 -> "["
     * f2 -> "]"
     */
    public ExpansionNode visit(syntaxtree.ArrayType n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        _ret = new ExpansionNode(new ArrayType());
        return _ret;
    }

    /**
     * f0 -> "boolean"
     */
    public ExpansionNode visit(syntaxtree.BooleanType n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        _ret = new ExpansionNode(new BooleanType());
        return _ret;
    }

    /**
     * f0 -> "int"
     */
    public ExpansionNode visit(syntaxtree.IntegerType n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        _ret = new ExpansionNode(new IntegerType());
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
    public ExpansionNode visit(syntaxtree.Statement n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        _ret = new ExpansionNode(new Statement(new NodeChoice(f0.node, n.f0.which)));
        _ret.extendAuxiliary(f0);
        return _ret;
    }

    /**
     * f0 -> "{"
     * f1 -> ( Statement() )*
     * f2 -> "}"
     */
    public ExpansionNode visit(syntaxtree.Block n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);

        // Put the assignment statements within the block itself.
        _ret = new ExpansionNode(new Block((NodeToken) f0.node,
                                           (NodeListOptional) getSquashedNodeList(f1),
                                           (NodeToken) f2.node));
        _ret.varDeclarations = f1.varDeclarations;
        return _ret;
    }

    /**
     * f0 -> Identifier()
     * f1 -> "="
     * f2 -> Expression()
     * f3 -> ";"
     */
    public ExpansionNode visit(syntaxtree.AssignmentStatement n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        ExpansionNode f3 = n.f3.accept(this);
        _ret = new ExpansionNode(new AssignmentStatement(new VarRef(new NodeChoice(f0.node, 1)),
                                                         (NodeToken) f1.node,
                                                         (Expression) f2.node,
                                                         (NodeToken) f3.node));
        _ret.extendAuxiliary(f2);
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
    public ExpansionNode visit(syntaxtree.ArrayAssignmentStatement n) {
        // TODO(spradeep): See if the order of expansion of f2 and f5
        // makes a big difference. Remember, there can be multiple Nodes
        // on expansion of Expression.
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        ExpansionNode f3 = n.f3.accept(this);
        ExpansionNode f4 = n.f4.accept(this);
        ExpansionNode f5 = n.f5.accept(this);
        ExpansionNode f6 = n.f6.accept(this);
        _ret = new ExpansionNode(new ArrayAssignmentStatement((Identifier) f0.node,
                                                              (NodeToken) f1.node,
                                                              (Expression) f2.node,
                                                              (NodeToken) f3.node,
                                                              (NodeToken) f4.node,
                                                              (Expression) f5.node,
                                                              (NodeToken) f6.node));
        _ret.extendAuxiliary(f2);
        _ret.extendAuxiliary(f5);
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
    public ExpansionNode visit(syntaxtree.IfStatement n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        ExpansionNode f3 = n.f3.accept(this);
        ExpansionNode f4 = n.f4.accept(this);
        ExpansionNode f5 = n.f5.accept(this);
        ExpansionNode f6 = n.f6.accept(this);

        Statement ifBody;
        if (f4.hasPrecedingNodes()){
            ifBody = new Statement(new NodeChoice(new Block(getSquashedNodeList(f4)), 0));
        }
        else
            ifBody = new Statement(new NodeChoice(f4.node, 3));

        Statement elseBody;
        if (f6.hasPrecedingNodes()){
            elseBody = new Statement(new NodeChoice(new Block(getSquashedNodeList(f6)), 0));
        }
        else
            elseBody = new Statement(new NodeChoice(f6.node, 3));

        
        _ret = new ExpansionNode(new IfStatement(
            (NodeToken) f0.node,
            (NodeToken) f1.node,
            (Expression) f2.node,
            (NodeToken) f3.node,
            ifBody,
            (NodeToken) f5.node,
            elseBody));

        _ret.extendAuxiliary(f2);
        _ret.varDeclarations = concatenateNodeLists(_ret.varDeclarations,
                                                    concatenateNodeLists(f4.varDeclarations,
                                                                         f6.varDeclarations));
        return _ret;
    }

    /**
     * f0 -> "while"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> Statement()
     */
    public ExpansionNode visit(syntaxtree.WhileStatement n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        ExpansionNode f3 = n.f3.accept(this);
        ExpansionNode f4 = n.f4.accept(this);

        Statement whileBody;
        if (f4.hasPrecedingNodes()){
            whileBody = new Statement(new NodeChoice(new Block(getSquashedNodeList(f4)), 0));
        }
        else
            whileBody = new Statement(new NodeChoice(f4.node, 3));

        _ret = new ExpansionNode(new WhileStatement((NodeToken) f0.node,
                                                    (NodeToken) f1.node,
                                                    (Expression) f2.node,
                                                    (NodeToken) f3.node,
                                                    whileBody));
        _ret.extendAuxiliary(f2);
        _ret.varDeclarations = concatenateNodeLists(_ret.varDeclarations,
                                                    f4.varDeclarations);
        return _ret;
    }

    /**
     * f0 -> "System.out.println"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> ";"
     */
    public ExpansionNode visit(syntaxtree.PrintStatement n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        ExpansionNode f3 = n.f3.accept(this);
        ExpansionNode f4 = n.f4.accept(this);
        _ret = new ExpansionNode(new PrintStatement((NodeToken) f0.node,
                                                    (NodeToken) f1.node,
                                                    (Expression) f2.node,
                                                    (NodeToken) f3.node,
                                                    (NodeToken) f4.node));
        _ret.extendAuxiliary(f2);
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
    public ExpansionNode visit(syntaxtree.Expression n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        _ret = new ExpansionNode(new Expression(new NodeChoice(f0.node, n.f0.which)),
                                 f0.varDeclarations,
                                 f0.precedingNodes);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "&"
     * f2 -> PrimaryExpression()
     */
    public ExpansionNode visit(syntaxtree.AndExpression n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        _ret = new ExpansionNode(new AndExpression((PrimaryExpression) f0.node,
                                                   (NodeToken) f1.node,
                                                   (PrimaryExpression) f2.node));
        _ret.extendAuxiliary(f0);
        _ret.extendAuxiliary(f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "<"
     * f2 -> PrimaryExpression()
     */
    public ExpansionNode visit(syntaxtree.CompareExpression n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        _ret = new ExpansionNode(new CompareExpression((PrimaryExpression) f0.node,
                                                       (NodeToken) f1.node,
                                                       (PrimaryExpression) f2.node));

        _ret.extendAuxiliary(f0);
        _ret.extendAuxiliary(f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "+"
     * f2 -> PrimaryExpression()
     */
    public ExpansionNode visit(syntaxtree.PlusExpression n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        _ret = new ExpansionNode(new PlusExpression((PrimaryExpression) f0.node,
                                                    (NodeToken) f1.node,
                                                    (PrimaryExpression) f2.node));
        _ret.extendAuxiliary(f0);
        _ret.extendAuxiliary(f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "-"
     * f2 -> PrimaryExpression()
     */
    public ExpansionNode visit(syntaxtree.MinusExpression n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        _ret = new ExpansionNode(new MinusExpression((PrimaryExpression) f0.node,
                                                     (NodeToken) f1.node,
                                                     (PrimaryExpression) f2.node));
        _ret.extendAuxiliary(f0);
        _ret.extendAuxiliary(f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "*"
     * f2 -> PrimaryExpression()
     */
    public ExpansionNode visit(syntaxtree.TimesExpression n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        _ret = new ExpansionNode(new TimesExpression((PrimaryExpression) f0.node,
                                                     (NodeToken) f1.node,
                                                     (PrimaryExpression) f2.node));
        _ret.extendAuxiliary(f0);
        _ret.extendAuxiliary(f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "["
     * f2 -> PrimaryExpression()
     * f3 -> "]"
     */
    public ExpansionNode visit(syntaxtree.ArrayLookup n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        ExpansionNode f3 = n.f3.accept(this);
        _ret = new ExpansionNode(new ArrayLookup((PrimaryExpression) f0.node,
                                                 (NodeToken) f1.node,
                                                 (PrimaryExpression) f2.node,
                                                 (NodeToken) f3.node));
        _ret.extendAuxiliary(f0);
        _ret.extendAuxiliary(f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "."
     * f2 -> "length"
     */
    public ExpansionNode visit(syntaxtree.ArrayLength n) {
        // as well.
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);

        String tempVarName = getNewTempVarName();

        VarDeclaration tempDeclaration = getVarDeclaration(tempVarName,
                                                           new Type(new NodeChoice(
                                                               new ArrayType(), 0)));
        AssignmentStatement tempStatement = getAssiStatement(tempVarName,
                                                             f0.node);
        VarRef tempRef = new VarRef(new NodeChoice(
            new DotExpression(getTempIdentifier(tempVarName),
                              new Identifier(new NodeToken("length"))), 0));

        _ret = new ExpansionNode(tempRef);

        _ret.extendAuxiliary(f0);
        _ret.varDeclarations.addNode(tempDeclaration);
        _ret.precedingNodes.addNode(tempStatement);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "."
     * f2 -> Identifier()
     * f3 -> "("
     * f4 -> ( ExpressionList() )?
     * f5 -> ")"
     */
    public ExpansionNode visit(syntaxtree.MessageSend n) {
        // MicroJava equivalent:

        // Type temp;
        // temp = primaryExpression;
        // temp.foo(args);
        // temp2 = temp.____foo_ret_val____;
        // temp2 is the final expression

        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        ExpansionNode f3 = n.f3.accept(this);
        ExpansionNode f4 = n.f4.accept(this);
        ExpansionNode f5 = n.f5.accept(this);

        String tempVarName = getNewTempVarName();
        String retTempVarName = getNewTempVarName();

        // TODO(spradeep): Get the type of the temp variable
        VarDeclaration tempDeclaration = getVarDeclaration(tempVarName);
        AssignmentStatement tempStatement = getAssiStatement(tempVarName, f0.node);
        MessageSendStatement messageSendStatement = new MessageSendStatement(
            getTempIdentifier(tempVarName),
            (Identifier) f2.node,
            (NodeOptional) f4.node);

        Identifier methodIdentifier = (Identifier) f2.node;
        VarDeclaration retVarDeclaration = getVarDeclaration(retTempVarName,
                                                             methodIdentifier);
        AssignmentStatement returnValueAssignmentStatement = getAssiStatement(
            retTempVarName,
            new PrimaryExpression(new NodeChoice(
                new VarRef(new NodeChoice(new DotExpression(
                    getTempIdentifier(tempVarName),
                    getMethodRetVarIdentifier(methodIdentifier)),
                                          0)), 3)));
        
        _ret = new ExpansionNode(getTempIdentifier(retTempVarName));

        _ret.varDeclarations.addNode(tempDeclaration);
        _ret.varDeclarations.addNode(retVarDeclaration);
        _ret.extendAuxiliary(f0);
        _ret.precedingNodes.addNode(tempStatement);
        _ret.extendAuxiliary(f4);
        _ret.precedingNodes.addNode(messageSendStatement);
        _ret.precedingNodes.addNode(returnValueAssignmentStatement);
        return _ret;
    }

    /**
     * f0 -> Expression()
     * f1 -> ( ExpressionRest() )*
     */
    public ExpansionNode visit(syntaxtree.ExpressionList n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        _ret = new ExpansionNode(new ExpressionList((Expression) f0.node,
                                                    (NodeListOptional) f1.node));
        _ret.extendAuxiliary(f0);
        _ret.extendAuxiliary(f1);
        return _ret;
    }

    /**
     * f0 -> ","
     * f1 -> Expression()
     */
    public ExpansionNode visit(syntaxtree.ExpressionRest n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        _ret = new ExpansionNode(new ExpressionRest((NodeToken) f0.node,
                                                    (Expression) f1.node));
        _ret.extendAuxiliary(f1);
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
    public ExpansionNode visit(syntaxtree.PrimaryExpression n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        _ret = new ExpansionNode(new PrimaryExpression(new NodeChoice(f0.node, n.f0.which)));
        _ret.extendAuxiliary(f0);
        return _ret;
    }

    /**
     * f0 -> <INTEGER_LITERAL>
     */
    public ExpansionNode visit(syntaxtree.IntegerLiteral n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        _ret = new ExpansionNode(new IntegerLiteral((NodeToken) f0.node));
        return _ret;
    }

    /**
     * f0 -> "true"
     */
    public ExpansionNode visit(syntaxtree.TrueLiteral n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        _ret = new ExpansionNode(new TrueLiteral((NodeToken) f0.node));
        return _ret;
    }

    /**
     * f0 -> "false"
     */
    public ExpansionNode visit(syntaxtree.FalseLiteral n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        _ret = new ExpansionNode(new FalseLiteral((NodeToken) f0.node));
        return _ret;
    }

    /**
     * f0 -> <IDENTIFIER>
     */
    public ExpansionNode visit(syntaxtree.Identifier n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        _ret = new ExpansionNode(new Identifier((NodeToken) f0.node));
        return _ret;
    }

    /**
     * f0 -> "this"
     */
    public ExpansionNode visit(syntaxtree.ThisExpression n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        return new ExpansionNode(new ThisExpression((NodeToken) f0.node));
    }

    /**
     * f0 -> "new"
     * f1 -> "int"
     * f2 -> "["
     * f3 -> Expression()
     * f4 -> "]"
     */
    public ExpansionNode visit(syntaxtree.ArrayAllocationExpression n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        ExpansionNode f3 = n.f3.accept(this);
        ExpansionNode f4 = n.f4.accept(this);
        _ret = new ExpansionNode(new ArrayAllocationExpression((NodeToken) f0.node,
                                                               (NodeToken) f1.node,
                                                               (NodeToken) f2.node,
                                                               (Expression) f3.node,
                                                               (NodeToken) f4.node));
        _ret.extendAuxiliary(f3);
        return _ret;
    }

    /**
     * f0 -> "new"
     * f1 -> Identifier()
     * f2 -> "("
     * f3 -> ")"
     */
    public ExpansionNode visit(syntaxtree.AllocationExpression n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        ExpansionNode f3 = n.f3.accept(this);
        _ret = new ExpansionNode(new AllocationExpression((NodeToken) f0.node,
                                                          (Identifier) f1.node,
                                                          (NodeToken) f2.node,
                                                          (NodeToken) f3.node));
        return _ret;
    }

    /**
     * f0 -> "!"
     * f1 -> Expression()
     */
    public ExpansionNode visit(syntaxtree.NotExpression n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        _ret = new ExpansionNode(new NotExpression((NodeToken) f0.node,
                                                   (Expression) f1.node));
        _ret.extendAuxiliary(f1);
        return _ret;
    }

    /**
     * f0 -> "("
     * f1 -> Expression()
     * f2 -> ")"
     */
    public ExpansionNode visit(syntaxtree.BracketExpression n) {
        ExpansionNode _ret=null;
        ExpansionNode f0 = n.f0.accept(this);
        ExpansionNode f1 = n.f1.accept(this);
        ExpansionNode f2 = n.f2.accept(this);
        _ret = new ExpansionNode(new BracketExpression((NodeToken) f0.node,
                                                       (Expression) f1.node,
                                                       (NodeToken) f2.node));
        _ret.extendAuxiliary(f1);
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

