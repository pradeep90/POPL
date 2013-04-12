package inliner;

import inliner.syntaxtree.*;
import inliner.visitor.*;

/** 
 * Visitor to simply build up a copy of the original Microjava tree.
 * Have Environment as an argument to emulate scope.
 *
 * Other Visitors that only modify a few visit() functions can extend
 * this Visitor.
 *
 * Keep track of the currClassName and currMethodName along the way.
 */
public class IdentityWithArgVisitor extends GJDepthFirst<Node, Environment> {
    String currClassName;
    String currMethodName;
    
    public IdentityWithArgVisitor() {
        
    }

    //
    // Auto class visitors--probably don't need to be overridden.
    //
    public Node visit(NodeList n, Environment env) {
        Node _ret = null;
        NodeList nodeList = new NodeList();
        for (Node node : n.nodes){
            nodeList.addNode(node.accept(this, env));
        }
        _ret = nodeList;
        return _ret;
    }

    public Node visit(NodeListOptional n, Environment env) {
        Node _ret=null;
        NodeListOptional nodeListOptional = new NodeListOptional();
        if ( n.present() ) {
            for (Node node : n.nodes){
                nodeListOptional.addNode(node.accept(this, env));
            }
        }
        _ret = nodeListOptional;
        return _ret;
    }

    public Node visit(NodeOptional n, Environment env) {
        if ( n.present() )
            return new NodeOptional(n.node.accept(this, env));
        else
            return new NodeOptional();
    }

    // public Node visit(NodeSequence n, Environment env) {
    //     Node _ret=null;
    //     int _count=0;
    //     for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
    //         e.nextElement().accept(this, env);
    //         _count++;
    //     }
    //     return _ret;
    // }

    public Node visit(NodeToken n, Environment env) {
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
    public Node visit(Goal n, Environment env) {
        Node _ret=null;
        MainClass f0 = (MainClass) n.f0.accept(this, env);
        NodeListOptional f1 = (NodeListOptional) n.f1.accept(this, env);
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
    public Node visit(MainClass n, Environment env) {
        Node _ret=null;
        Identifier f1 = (Identifier) n.f1.accept(this, env);
        currClassName = InlinerHelper.getIdentifierName(f1);
        Identifier f11 = (Identifier) n.f11.accept(this, env);
        Identifier f15 = (Identifier) n.f15.accept(this, env);
        Identifier f19 = (Identifier) n.f19.accept(this, env);
        NodeOptional f21 = (NodeOptional) n.f21.accept(this, env);
        _ret = new MainClass(f1, f11, f15, f19, f21);
        return _ret;
    }

    /**
     * f0 -> ClassDeclaration()
     *       | ClassExtendsDeclaration()
     */
    public Node visit(TypeDeclaration n, Environment env) {
        Node _ret=null;
        _ret = n.f0.accept(this, env);
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
    public Node visit(ClassDeclaration n, Environment env) {
        Node _ret=null;
        Identifier f1 = (Identifier) n.f1.accept(this, env);
        currClassName = InlinerHelper.getIdentifierName(f1);
        NodeListOptional f3 = (NodeListOptional) n.f3.accept(this, env);
        NodeListOptional f4 = (NodeListOptional) n.f4.accept(this, env);
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
    public Node visit(ClassExtendsDeclaration n, Environment env) {
        Node _ret=null;
        Identifier f1 = (Identifier) n.f1.accept(this, env);
        currClassName = InlinerHelper.getIdentifierName(f1);
        Identifier f3 = (Identifier) n.f3.accept(this, env);
        NodeListOptional f5 = (NodeListOptional) n.f5.accept(this, env);
        NodeListOptional f6 = (NodeListOptional) n.f6.accept(this, env);
        return _ret;
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     * f2 -> ";"
     */
    public Node visit(VarDeclaration n, Environment env) {
        Node _ret=null;
        Type f0 = (Type) n.f0.accept(this, env);
        Identifier f1 = (Identifier) n.f1.accept(this, env);
        _ret = new VarDeclaration(f0, f1);
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
    public Node visit(MethodDeclaration n, Environment env) {
        Node _ret=null;
        Identifier f2 = (Identifier) n.f2.accept(this, env);
        currMethodName = InlinerHelper.getIdentifierName(f2);
        NodeOptional f4 = (NodeOptional) n.f4.accept(this, env);
        NodeListOptional f7 = (NodeListOptional) n.f7.accept(this, env);
        NodeListOptional f8 = (NodeListOptional) n.f8.accept(this, env);
        _ret = new MethodDeclaration(f2, f4, f7, f8);
        return _ret;
    }

    /**
     * f0 -> FormalParameter()
     * f1 -> ( FormalParameterRest() )*
     */
    public Node visit(FormalParameterList n, Environment env) {
        Node _ret=null;
        FormalParameter f0 = (FormalParameter) n.f0.accept(this, env);
        NodeListOptional f1 = (NodeListOptional) n.f1.accept(this, env);
        _ret = new FormalParameterList(f0, f1);
        return _ret;
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     */
    public Node visit(FormalParameter n, Environment env) {
        Node _ret=null;
        Type f0 = (Type) n.f0.accept(this, env);
        Identifier f1 = (Identifier) n.f1.accept(this, env);
        _ret = new FormalParameter(f0, f1);
        return _ret;
    }

    /**
     * f0 -> ","
     * f1 -> FormalParameter()
     */
    public Node visit(FormalParameterRest n, Environment env) {
        Node _ret=null;
        FormalParameter f1 = (FormalParameter) n.f1.accept(this, env);
        _ret = new FormalParameterRest(f1);
        return _ret;
    }

    /**
     * f0 -> ArrayType()
     *       | BooleanType()
     *       | EnvironmentType()
     *       | Identifier()
     */
    public Node visit(Type n, Environment env) {
        Node _ret=null;
        _ret = new Type(new NodeChoice(n.f0.accept(this, env), n.f0.which));
        return _ret;
    }

    /**
     * f0 -> "int"
     * f1 -> "["
     * f2 -> "]"
     */
    public Node visit(ArrayType n, Environment env) {
        Node _ret=null;
        _ret = new ArrayType();
        return _ret;
    }

    /**
     * f0 -> "boolean"
     */
    public Node visit(BooleanType n, Environment env) {
        Node _ret=null;
        _ret = new BooleanType();
        return _ret;
    }

    /**
     * f0 -> "int"
     */
    public Node visit(IntegerType n, Environment env) {
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
    public Node visit(Statement n, Environment env) {
        Node _ret=null;
        _ret = new Statement(new NodeChoice(n.f0.accept(this, env), n.f0.which));
        return _ret;
    }

    /**
     * f0 -> "{"
     * f1 -> ( Statement() )*
     * f2 -> "}"
     */
    public Node visit(Block n, Environment env) {
        Node _ret=null;
        NodeListOptional f1 = (NodeListOptional) n.f1.accept(this, env);
        _ret = new Block(f1);
        return _ret;
    }

    /**
     * f0 -> VarRef()
     * f1 -> "="
     * f2 -> Expression()
     * f3 -> ";"
     */
    public Node visit(AssignmentStatement n, Environment env) {
        Node _ret=null;
        VarRef f0 = (VarRef) n.f0.accept(this, env);
        Expression f2 = (Expression) n.f2.accept(this, env);
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
    public Node visit(ArrayAssignmentStatement n, Environment env) {
        Node _ret=null;
        Identifier f0 = (Identifier) n.f0.accept(this, env);
        Expression f2 = (Expression) n.f2.accept(this, env);
        Expression f5 = (Expression) n.f5.accept(this, env);
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
    public Node visit(IfStatement n, Environment env) {
        Node _ret=null;
        Expression f2 = (Expression) n.f2.accept(this, env);
        Statement f4 = (Statement) n.f4.accept(this, env);
        Statement f6 = (Statement) n.f6.accept(this, env);
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
    public Node visit(WhileStatement n, Environment env) {
        Node _ret=null;
        Expression f2 = (Expression) n.f2.accept(this, env);
        Statement f4 = (Statement) n.f4.accept(this, env);
        _ret = new WhileStatement(f2, f4);
        return _ret;
    }

    /**
     * f0 -> "System.out.println"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> ";"
     */
    public Node visit(PrintStatement n, Environment env) {
        Node _ret=null;
        Expression f2 = (Expression) n.f2.accept(this, env);
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
    public Node visit(MessageSendStatement n, Environment env) {
        Node _ret=null;
        Identifier f0 = (Identifier) n.f0.accept(this, env);
        Identifier f2 = (Identifier) n.f2.accept(this, env);
        NodeOptional f4 = (NodeOptional) n.f4.accept(this, env);
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
    public Node visit(Expression n, Environment env) {
        Node _ret=null;
        _ret = new Expression(new NodeChoice(n.f0.accept(this, env), n.f0.which));
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "&"
     * f2 -> PrimaryExpression()
     */
    public Node visit(AndExpression n, Environment env) {
        Node _ret=null;
        PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this, env);
        PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this, env);
        _ret = new AndExpression(f0, f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "<"
     * f2 -> PrimaryExpression()
     */
    public Node visit(CompareExpression n, Environment env) {
        Node _ret=null;
        PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this, env);
        PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this, env);
        _ret = new CompareExpression(f0, f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "+"
     * f2 -> PrimaryExpression()
     */
    public Node visit(PlusExpression n, Environment env) {
        Node _ret=null;
        PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this, env);
        PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this, env);
        _ret = new PlusExpression(f0, f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "-"
     * f2 -> PrimaryExpression()
     */
    public Node visit(MinusExpression n, Environment env) {
        Node _ret=null;
        PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this, env);
        PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this, env);
        _ret = new MinusExpression(f0, f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "*"
     * f2 -> PrimaryExpression()
     */
    public Node visit(TimesExpression n, Environment env) {
        Node _ret=null;
        PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this, env);
        PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this, env);
        _ret = new TimesExpression(f0, f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "["
     * f2 -> PrimaryExpression()
     * f3 -> "]"
     */
    public Node visit(ArrayLookup n, Environment env) {
        Node _ret=null;
        PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this, env);
        PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this, env);
        _ret = new ArrayLookup(f0, f2);
        return _ret;
    }

    /**
     * f0 -> Expression()
     * f1 -> ( ExpressionRest() )*
     */
    public Node visit(ExpressionList n, Environment env) {
        Node _ret=null;
        Expression f0 = (Expression) n.f0.accept(this, env);
        NodeListOptional f1 = (NodeListOptional) n.f1.accept(this, env);
        _ret = new ExpressionList(f0, f1);
        return _ret;
    }

    /**
     * f0 -> ","
     * f1 -> Expression()
     */
    public Node visit(ExpressionRest n, Environment env) {
        Node _ret=null;
        _ret = new ExpressionRest((Expression) n.f1.accept(this, env));
        return _ret;
    }

    /**
     * f0 -> EnvironmentLiteral()
     *       | TrueLiteral()
     *       | FalseLiteral()
     *       | VarRef()
     *       | ThisExpression()
     *       | ArrayAllocationExpression()
     *       | AllocationExpression()
     *       | NotExpression()
     *       | BracketExpression()
     */
    public Node visit(PrimaryExpression n, Environment env) {
        Node _ret=null;
        _ret = new PrimaryExpression(
            new NodeChoice(n.f0.accept(this, env), n.f0.which));
        return _ret;
    }

    /**
     * f0 -> <INTEGER_LITERAL>
     */
    public Node visit(IntegerLiteral n, Environment env) {
        Node _ret=null;
        _ret = new IntegerLiteral((NodeToken) n.f0.accept(this, env));
        return _ret;
    }

    /**
     * f0 -> "true"
     */
    public Node visit(TrueLiteral n, Environment env) {
        Node _ret=null;
        _ret = new TrueLiteral();
        return _ret;
    }

    /**
     * f0 -> "false"
     */
    public Node visit(FalseLiteral n, Environment env) {
        Node _ret=null;
        _ret = new FalseLiteral();
        return _ret;
    }

    /**
     * f0 -> <IDENTIFIER>
     */
    public Node visit(Identifier n, Environment env) {
        Node _ret=null;
        _ret = new Identifier((NodeToken) n.f0.accept(this, env));
        return _ret;
    }

    /**
     * f0 -> "this"
     */
    public Node visit(ThisExpression n, Environment env) {
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
    public Node visit(ArrayAllocationExpression n, Environment env) {
        Node _ret=null;
        _ret = new ArrayAllocationExpression((Expression) n.f3.accept(this, env));
        return _ret;
    }

    /**
     * f0 -> "new"
     * f1 -> Identifier()
     * f2 -> "("
     * f3 -> ")"
     */
    public Node visit(AllocationExpression n, Environment env) {
        Node _ret=null;
        _ret = new AllocationExpression((Identifier) n.f1.accept(this, env));
        return _ret;
    }

    /**
     * f0 -> "!"
     * f1 -> Expression()
     */
    public Node visit(NotExpression n, Environment env) {
        Node _ret=null;
        _ret = new NotExpression((Expression) n.f1.accept(this, env));
        return _ret;
    }

    /**
     * f0 -> "("
     * f1 -> Expression()
     * f2 -> ")"
     */
    public Node visit(BracketExpression n, Environment env) {
        Node _ret=null;
        _ret = new BracketExpression((Expression) n.f1.accept(this, env));
        return _ret;
    }

    /**
     * f0 -> DotExpression()
     *       | Identifier()
     */
    public Node visit(VarRef n, Environment env) {
        Node _ret=null;
        _ret = new VarRef(new NodeChoice(n.f0.accept(this, env), n.f0.which));
        return _ret;
    }

    /**
     * f0 -> Identifier()
     * f1 -> "."
     * f2 -> Identifier()
     */
    public Node visit(DotExpression n, Environment env) {
        Node _ret=null;
        Identifier f0 = (Identifier) n.f0.accept(this, env);
        Identifier f2 = (Identifier) n.f2.accept(this, env);
        _ret = new DotExpression(f0, f2);
        return _ret;
    }

}
