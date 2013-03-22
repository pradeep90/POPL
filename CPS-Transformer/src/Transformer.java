import visitor.*;
import nano.syntaxtree.*;

import java.util.Enumeration;
import java.util.List;
import java.util.ArrayList;

public class Transformer extends GJNoArguDepthFirst<Node> {
    public String CONTINUATION_BASE_CLASS_NAME = "Continuation";

    public String currentContinuationName = "k";

    public List<MethodDeclaration> currentClassContinuationMethods =
            new ArrayList<MethodDeclaration>();
    public List<ClassDeclaration> continuationClasses =
            new ArrayList<ClassDeclaration>();

    public MethodDeclaration currMethod;
    public String currClassName;

    public Transformer() {}

    public MessageSendStatement getDefaultContinuationCall(){
        return new MessageSendStatement(
            CPSHelper.getNewIdentifier(currentContinuationName),
            CPSHelper.getNewIdentifier("call"),
            new NodeOptional());
    }

    /** 
     * @return Nano equivalent of Block{statement}.
     */
    public Block getNanoBlock(syntaxtree.Statement statement){
        syntaxtree.Block tempBlock =
                new syntaxtree.Block(new syntaxtree.NodeListOptional(statement));
        return (Block) tempBlock.accept(this);
    }

    /**
     * Note: Considering MessageSendStatement to be a tailform statement.
     * 
     * @return true iff node is a non-tailform statement
     */
    public boolean isSimpleStatement(syntaxtree.Node node){
        syntaxtree.Statement statement = (syntaxtree.Statement) node;

        switch(statement.f0.which){
            case 1:
            case 2:
            case 5:
                return true;
            default:
                return false;
        }
    }

    /** 
     * Make a ClassDeclaration to represent current Continuation.
     */
    public ClassDeclaration makeContinuationClass(MethodDeclaration continuationMethod){
        return null;
    }

    /** 
     * Make a continuation out of nodes and update the global variables.  
     * 
     * @param nodes Statements
     * 
     * @return the necessary NanoJava instantiation and initialization
     * statements for the continuation.
     */
    public NodeListOptional makeContinuation(
        syntaxtree.NodeListOptional nodes){
        syntaxtree.MethodDeclaration tempMethod = new syntaxtree.MethodDeclaration(
            CPSHelper.getNewMicroIdentifier("TEMP_METHOD"),
            new syntaxtree.NodeOptional(),
            new syntaxtree.NodeListOptional(),
            nodes);

        // TODO: Take all the params and local variables of the
        // original method and make them params for the Continuation method
        MethodDeclaration continuationMethodNano =
                (MethodDeclaration) tempMethod.accept(this);

        currentClassContinuationMethods.add(continuationMethodNano);
        ClassDeclaration continuationClass = makeContinuationClass(
            continuationMethodNano);
        continuationClasses.add(continuationClass);

        // TODO: Have a Statement to set each field of continuationClass.
        NodeListOptional initStatements = new NodeListOptional();
        return initStatements;
    }

    //
    // Auto class visitors--probably don't need to be overridden.
    //
    public Node visit(syntaxtree.NodeList n) {
        Node _ret=null;
        int _count=0;
        for ( Enumeration<syntaxtree.Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this);
            _count++;
        }
        return _ret;
    }

    public Node visit(syntaxtree.NodeListOptional n) {
        Node _ret;
        NodeListOptional nodeListOptional = new NodeListOptional();
        if ( n.present() ) {
            for (syntaxtree.Node node : n.nodes){
                nodeListOptional.addNode(node.accept(this));
            }
        }
        _ret = nodeListOptional;
        return _ret;
    }

    public Node visit(syntaxtree.NodeOptional n) {
        if ( n.present() )
            return n.node.accept(this);
        else
            // Cos the caller is gonna do "new NodeOptional(return value)" anyway
            return null;
    }

    public Node visit(syntaxtree.NodeSequence n) {
        Node _ret=null;
        int _count=0;
        for ( Enumeration<syntaxtree.Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this);
            _count++;
        }
        return _ret;
    }

    public Node visit(syntaxtree.NodeToken n) {
        return new NodeToken(n.tokenImage);
    }

    //
    // User-generated visitor methods below
    //

    /**
     * f0 -> MainClass()
     * f1 -> ( TypeDeclaration() )*
     * f2 -> <EOF>
     */
    public Node visit(syntaxtree.Goal n) {
        Node _ret=null;
        MainClass f0 = (MainClass) n.f0.accept(this);
        NodeListOptional f1 = (NodeListOptional) n.f1.accept(this);
        _ret = new Goal(f0, f1);
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
     * f14 -> "new"
     * f15 -> Identifier()
     * f16 -> "("
     * f17 -> ")"
     * f18 -> "."
     * f19 -> Identifier()
     * f20 -> "("
     * f21 -> ( ExpressionList() )?
     * f22 -> ")"
     * f23 -> ";"
     * f24 -> "}"
     * f25 -> "}"
     */
    public Node visit(syntaxtree.MainClass n) {
        Node _ret=null;
        Identifier f1 = (Identifier) n.f1.accept(this);
        Identifier f11 = (Identifier) n.f11.accept(this);
        Identifier f15 = (Identifier) n.f15.accept(this);
        Identifier f19 = (Identifier) n.f19.accept(this);
        NodeOptional f21 = new NodeOptional(n.f21.accept(this));
        _ret = new MainClass(f1, f11, f15, f19, f21);
        return _ret;
    }

    /**
     * f0 -> ClassDeclaration()
     *       | ClassExtendsDeclaration()
     */
    public Node visit(syntaxtree.TypeDeclaration n) {
        Node _ret=null;
        _ret = new TypeDeclaration(new NodeChoice(n.f0.accept(this), n.f0.which));
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
    public Node visit(syntaxtree.ClassDeclaration n) {
        Node _ret=null;
        Identifier f1 = (Identifier) n.f1.accept(this);
        currClassName = CPSHelper.getIdentifierName(f1);
        NodeListOptional f3 = (NodeListOptional) n.f3.accept(this);
        NodeListOptional f4 = (NodeListOptional) n.f4.accept(this);
        _ret = new ClassDeclaration(f1, f3, f4);
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
        Identifier f1 = (Identifier) n.f1.accept(this);
        currClassName = CPSHelper.getIdentifierName(f1);
        Identifier f3 = (Identifier) n.f3.accept(this);
        NodeListOptional f5 = (NodeListOptional) n.f3.accept(this);
        NodeListOptional f6 = (NodeListOptional) n.f4.accept(this);
        _ret = new ClassExtendsDeclaration(f1, f3, f5, f6);
        return _ret;
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     * f2 -> ";"
     */
    public Node visit(syntaxtree.VarDeclaration n) {
        Node _ret=null;
        _ret = new VarDeclaration((Type) n.f0.accept(this), (Identifier) n.f1.accept(this));
        return _ret;
    }

    /**
     * f0 -> "public"
     * f1 -> "void"
     * f2 -> Identifier()
     * f3 -> "("
     * f4 -> ( FormalParameterList() )?
     * f5 -> ")"
     * f6 -> "{"
     * f7 -> ( VarDeclaration() )*
     * f8 -> ( Statement() )*
     * f9 -> "}"
     */
    public Node visit(syntaxtree.MethodDeclaration n) {
        Node _ret=null;
        Identifier f2 = (Identifier) n.f2.accept(this);

        NodeOptional f4 = new NodeOptional(n.f4.accept(this));
        FormalParameter kParam = new FormalParameter(
            CPSHelper.getNewType(CONTINUATION_BASE_CLASS_NAME),
            CPSHelper.getNewIdentifier(currentContinuationName));

        if (f4.present()){
            FormalParameterRest restParam = new FormalParameterRest(kParam);
            ((FormalParameterList) f4.node).f1.addNode(restParam);
        }
        else{
            f4 = new NodeOptional(new FormalParameterList(kParam, new NodeListOptional()));
        }

        NodeListOptional f7 = (NodeListOptional) n.f7.accept(this);

        // Make a new block out of the statement list and extract the
        // resultant NanoJava statement list and JumpPoint.
        Block tempBlock = (Block) (new syntaxtree.Block(n.f8)).accept(this);

        _ret = new MethodDeclaration(f2, f4, f7, tempBlock.f1,
                                     new NodeOptional(tempBlock.f2));
        return _ret;
    }

    /**
     * f0 -> FormalParameter()
     * f1 -> ( FormalParameterRest() )*
     */
    public Node visit(syntaxtree.FormalParameterList n) {
        Node _ret=null;
        _ret = new FormalParameterList((FormalParameter) n.f0.accept(this),
                                       (NodeListOptional) n.f1.accept(this));
        return _ret;
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     */
    public Node visit(syntaxtree.FormalParameter n) {
        Node _ret=null;
        _ret = new FormalParameter((Type) n.f0.accept(this), (Identifier) n.f1.accept(this));
        return _ret;
    }

    /**
     * f0 -> ","
     * f1 -> FormalParameter()
     */
    public Node visit(syntaxtree.FormalParameterRest n) {
        Node _ret=null;
        _ret = new FormalParameterRest((FormalParameter) n.f1.accept(this));
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
        _ret = new ArrayType();
        return _ret;
    }

    /**
     * f0 -> "boolean"
     */
    public Node visit(syntaxtree.BooleanType n) {
        Node _ret=null;
        _ret = new BooleanType();
        return _ret;
    }

    /**
     * f0 -> "int"
     */
    public Node visit(syntaxtree.IntegerType n) {
        Node _ret=null;
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
     *       | MessageSendStatement()
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
        // TODO: Accept Simple statements till you get a Tail form statement
        NodeListOptional finalStatementList = new NodeListOptional();
        JumpPoint jumpPoint = null;
        int i;

        for (i = 0; i < n.f1.nodes.size(); i++){
            syntaxtree.Node currNode = n.f1.nodes.get(i);
            if (isSimpleStatement(currNode)){
                finalStatementList.addNode(currNode.accept(this));
            } else {
                // Make a continuation out of the rest of the nodes  
                syntaxtree.NodeListOptional remainingStatements = new syntaxtree.NodeListOptional();
                remainingStatements.nodes.addAll(
                    n.f1.nodes.subList(i + 1, n.f1.nodes.size()));
                System.out.println("CPSHelper.getMicroFormattedString(remainingStatements): " + CPSHelper.getMicroFormattedString(remainingStatements));
                NodeListOptional kInitializationStatements =
                        makeContinuation(remainingStatements);
                System.out.println("CPSHelper.getFormattedString(kInitializationStatements): " + CPSHelper.getFormattedString(kInitializationStatements));

                finalStatementList.nodes.addAll(kInitializationStatements.nodes);

                // TODO: Make the NanoJava version of the ith
                // Statement into a JumpPoint.
                // TODO: Make IfStatement and MessageSendStatement return a JumpPoint.
                // jumpPoint = 
                break;
            }
        }

        if (jumpPoint == null){
            jumpPoint = new JumpPoint(new NodeChoice(getDefaultContinuationCall(), 1));
        }

        // TODO: Check for the actual JumpPoint.
        _ret = new Block(finalStatementList, jumpPoint);
        return _ret;
    }

    /**
     * f0 -> VarRef()
     * f1 -> "="
     * f2 -> Expression()
     * f3 -> ";"
     */
    public Node visit(syntaxtree.AssignmentStatement n) {
        Node _ret=null;
        VarRef f0 = (VarRef) n.f0.accept(this);
        Expression f2 = (Expression) n.f2.accept(this);
        _ret = new AssignmentStatement(f0, f2);
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
        Node _ret=null;
        Identifier f0 = (Identifier) n.f0.accept(this);
        Expression f2 = (Expression) n.f2.accept(this);
        Expression f5 = (Expression) n.f5.accept(this);
        _ret = new ArrayAssignmentStatement(f0, f2, f5);
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
        Expression f2 = (Expression) n.f2.accept(this);
        Block f4 = getNanoBlock(n.f4);
        Block f6 = getNanoBlock(n.f6);
        _ret = new IfStatement(f2, f4, f6);
        return _ret;
    }

    /**
     * f0 -> "while"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> Statement()
     */
    // TODO: 
    public Node visit(syntaxtree.WhileStatement n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        return _ret;
    }

    /**
     * f0 -> "System.out.println"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> ";"
     */
    public Node visit(syntaxtree.PrintStatement n) {
        Node _ret=null;
        Expression f2 = (Expression) n.f2.accept(this);
        _ret = new PrintStatement(f2);
        return _ret;
    }

    /**
     * f0 -> Identifier()
     * f1 -> "."
     * f2 -> Identifier()
     * f3 -> "("
     * f4 -> ( ExpressionList() )?
     * f5 -> ")"
     * f6 -> ";"
     */
    public Node visit(syntaxtree.MessageSendStatement n) {
        Node _ret=null;
        Identifier f0 = (Identifier) n.f0.accept(this);
        Identifier f2 = (Identifier) n.f2.accept(this);
        NodeOptional f4 = new NodeOptional(n.f4.accept(this));
        _ret = new MessageSendStatement(f0, f2, f4);
        return _ret;
    }

    /**
     * f0 -> AndExpression()
     *       | CompareExpression()
     *       | PlusExpression()
     *       | MinusExpression()
     *       | TimesExpression()
     *       | ArrayLookup()
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
        PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this);
        PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this);
        _ret = new AndExpression(f0, f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "<"
     * f2 -> PrimaryExpression()
     */
    public Node visit(syntaxtree.CompareExpression n) {
        Node _ret=null;
        PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this);
        PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this);
        _ret = new CompareExpression(f0, f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "+"
     * f2 -> PrimaryExpression()
     */
    public Node visit(syntaxtree.PlusExpression n) {
        Node _ret=null;
        PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this);
        PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this);
        _ret = new PlusExpression(f0, f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "-"
     * f2 -> PrimaryExpression()
     */
    public Node visit(syntaxtree.MinusExpression n) {
        Node _ret=null;
        PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this);
        PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this);
        _ret = new MinusExpression(f0, f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "*"
     * f2 -> PrimaryExpression()
     */
    public Node visit(syntaxtree.TimesExpression n) {
        Node _ret=null;
        PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this);
        PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this);
        _ret = new TimesExpression(f0, f2);
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
        PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this);
        PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this);
        _ret = new ArrayLookup(f0, f2);
        return _ret;
    }

    /**
     * f0 -> Expression()
     * f1 -> ( ExpressionRest() )*
     */
    public Node visit(syntaxtree.ExpressionList n) {
        Node _ret=null;
        Expression f0 = (Expression) n.f0.accept(this);
        NodeListOptional f1 = (NodeListOptional) n.f1.accept(this);
        _ret = new ExpressionList(f0, f1);
        return _ret;
    }

    /**
     * f0 -> ","
     * f1 -> Expression()
     */
    public Node visit(syntaxtree.ExpressionRest n) {
        Node _ret=null;
        Expression f1 = (Expression) n.f1.accept(this);
        _ret = new ExpressionRest(f1);
        return _ret;
    }

    /**
     * f0 -> IntegerLiteral()
     *       | TrueLiteral()
     *       | FalseLiteral()
     *       | VarRef()
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
        NodeToken f0 = (NodeToken) n.f0.accept(this);
        _ret = new IntegerLiteral(f0);
        return _ret;
    }

    /**
     * f0 -> "true"
     */
    public Node visit(syntaxtree.TrueLiteral n) {
        Node _ret=null;
        // n.f0.accept(this);
        _ret = new TrueLiteral();
        return _ret;
    }

    /**
     * f0 -> "false"
     */
    public Node visit(syntaxtree.FalseLiteral n) {
        Node _ret=null;
        // n.f0.accept(this);
        _ret = new FalseLiteral();
        return _ret;
    }

    /**
     * f0 -> <IDENTIFIER>
     */
    public Node visit(syntaxtree.Identifier n) {
        Node _ret=null;
        _ret = CPSHelper.getNewIdentifier(CPSHelper.getMicroIdentifierName(n));
        return _ret;
    }

    /**
     * f0 -> "this"
     */
    public Node visit(syntaxtree.ThisExpression n) {
        Node _ret=null;
        _ret = new ThisExpression();
        return _ret;
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
        Expression f3 = (Expression) n.f3.accept(this);
        _ret = new ArrayAllocationExpression(f3);
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
        Identifier f1 = (Identifier) n.f1.accept(this);
        _ret = new AllocationExpression(f1);
        return _ret;
    }

    /**
     * f0 -> "!"
     * f1 -> Expression()
     */
    public Node visit(syntaxtree.NotExpression n) {
        Node _ret=null;
        Expression f1 = (Expression) n.f1.accept(this);
        _ret = new NotExpression(f1);
        return _ret;
    }

    /**
     * f0 -> "("
     * f1 -> Expression()
     * f2 -> ")"
     */
    public Node visit(syntaxtree.BracketExpression n) {
        Node _ret=null;
        Expression f1 = (Expression) n.f1.accept(this);
        _ret = new BracketExpression(f1);
        return _ret;
    }

    /**
     * f0 -> DotExpression()
     *       | Identifier()
     */
    public Node visit(syntaxtree.VarRef n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        _ret = new VarRef(new NodeChoice(f0, n.f0.which));
        return _ret;
    }

    /**
     * f0 -> Identifier()
     * f1 -> "."
     * f2 -> Identifier()
     */
    public Node visit(syntaxtree.DotExpression n) {
        Node _ret=null;
        Identifier f0 = (Identifier) n.f0.accept(this);
        Identifier f2 = (Identifier) n.f2.accept(this);
        _ret = new DotExpression(f0, f2);
        return _ret;
    }
}
