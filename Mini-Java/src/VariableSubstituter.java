import microjavaparser.visitor.GJNoArguDepthFirst;
import java.util.*;
import microjavaparser.visitor.TreeFormatter;
import microjavaparser.visitor.TreeDumper;
import microjavaparser.syntaxtree.Node;
import microjavaparser.syntaxtree.*;
import microjavaparser.*;

// import java.text.ParseException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class VariableSubstituter extends GJNoArguDepthFirst<Node> {

    public HashMap<String, Type> methodReturnTypeHash = new HashMap<String, Type>();

    // public void addBinding(Identifier methodIdentifier, Type returnType){
    //     methodReturnTypeHash.put(getMethodName(methodIdentifier),
    //                              returnType);
    // }

    public Type getCopyOfType(Type type){
        Node currType = type.f0.choice;
        if (currType instanceof ArrayType){
            return new Type(new NodeChoice(new ArrayType(), 0));
        }
        else if (currType instanceof BooleanType){
            return new Type(new NodeChoice(new BooleanType(), 1));
        }
        else if (currType instanceof IntegerType){
            return new Type(new NodeChoice(new IntegerType(), 2));
        }
        else if (currType instanceof Identifier){
            // System.out.println("((Identifier)currType).f0.tokenImage: "
                               // + ((Identifier)currType).f0.tokenImage);
            return new Type(new NodeChoice(new Identifier(new NodeToken(MicroJavaOutputter.getMethodName((Identifier) currType))), 3));
        }
        return null;
    }

    //
    // Auto class visitors--probably don't need to be overridden.
    //
    public Node visit(NodeList n) {
        Node _ret=null;
        int _count=0;
        for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this);
            _count++;
        }
        return n;
    }

    public Node visit(NodeListOptional n) {
        if ( n.present() ) {
            NodeListOptional _ret=null;
            _ret = new NodeListOptional();
            int _count=0;
            for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
                _ret.addNode(e.nextElement().accept(this));
                _count++;
            }
            n = _ret;
            return n;
        }
        else
            return new NodeListOptional();
    }

    public Node visit(NodeOptional n) {
        if ( n.present() )
            return new NodeOptional(n.node.accept(this));
        else
            return new NodeOptional();
    }

    public Node visit(NodeSequence n) {
        Node _ret=null;
        int _count=0;
        for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this);
            _count++;
        }
        return n;
    }

    public Node visit(NodeToken n) {
        return n;
    }

    //
    // User-generated visitor methods below
    //

    /**
     * f0 -> MainClass()
     * f1 -> ( TypeDeclaration() )*
     * f2 -> <EOF>
     */
    public Node visit(Goal n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        return new Goal((MainClass) f0,
                        (NodeListOptional) f1,
                        (NodeToken) f2);
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
    public Node visit(MainClass n) {
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
        Node f14 = n.f14.accept(this);
        Node f15 = n.f15.accept(this);
        Node f16 = n.f16.accept(this);
        Node f17 = n.f17.accept(this);
        Node f18 = n.f18.accept(this);
        Node f19 = n.f19.accept(this);
        Node f20 = n.f20.accept(this);
        Node f21 = n.f21.accept(this);
        Node f22 = n.f22.accept(this);
        Node f23 = n.f23.accept(this);
        Node f24 = n.f24.accept(this);
        Node f25 = n.f25.accept(this);
        n = new MainClass((Identifier) f1,
                          (Identifier) f11,
                          (Identifier) f15,
                          (Identifier) f19,
                          (NodeOptional) f21);
        return n;
    }

    /**
     * f0 -> ClassDeclaration()
     *       | ClassExtendsDeclaration()
     */
    public Node visit(TypeDeclaration n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);

        n = new TypeDeclaration(new NodeChoice(f0, n.f0.which));
        return n;
    }

    /**
     * f0 -> "class"
     * f1 -> Identifier()
     * f2 -> "{"
     * f3 -> ( VarDeclaration() )*
     * f4 -> ( MethodDeclaration() )*
     * f5 -> "}"
     */
    public Node visit(ClassDeclaration n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        Node f3 = n.f3.accept(this);
        Node f4 = n.f4.accept(this);
        Node f5 = n.f5.accept(this);
        n = new ClassDeclaration((Identifier) f1,
                                 (NodeListOptional) f3,
                                 (NodeListOptional) f4);
        return n;
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
    public Node visit(ClassExtendsDeclaration n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        Node f3 = n.f3.accept(this);
        Node f4 = n.f4.accept(this);
        Node f5 = n.f5.accept(this);
        Node f6 = n.f6.accept(this);
        Node f7 = n.f7.accept(this);
        n = new ClassExtendsDeclaration((Identifier) f1,
                                        (Identifier) f3,
                                        (NodeListOptional) f5,
                                        (NodeListOptional) f6);
        return n;
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     * f2 -> ";"
     */
    public Node visit(VarDeclaration n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        Node f2 = n.f2.accept(this);
        n = new VarDeclaration((Type) f0,
                               (Identifier) f1);
        return n;
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
    public Node visit(MethodDeclaration n) {
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
        n = new MethodDeclaration((Identifier) f2,
                                  new NodeOptional(f4),
                                  (NodeListOptional) f7,
                                  (NodeListOptional) f8);
        return n;
    }

    /**
     * f0 -> FormalParameter()
     * f1 -> ( FormalParameterRest() )*
     */
    public Node visit(FormalParameterList n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        return new FormalParameterList((FormalParameter) f0,
                                       (NodeListOptional) f1);
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     */
    public Node visit(FormalParameter n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        return new FormalParameter((Type) f0,
                                   (Identifier) f1);
    }

    /**
     * f0 -> ","
     * f1 -> FormalParameter()
     */
    public Node visit(FormalParameterRest n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        Node f1 = n.f1.accept(this);
        n = new FormalParameterRest((FormalParameter) f1);
        return n;
    }

    /**
     * f0 -> ArrayType()
     *       | BooleanType()
     *       | IntegerType()
     *       | Identifier()
     */
    public Node visit(Type n) {
        Node _ret=null;
        n.f0.accept(this);

        if (((NodeChoice) n.f0).choice instanceof Identifier){
            Identifier curr = (Identifier) ((NodeChoice) n.f0).choice;
            String name = MicroJavaOutputter.getMethodName(curr);
            if (name.startsWith("TYPE_")){
                // System.out.println("name.substring(5): " + name.substring(5));
                // System.out.println("methodReturnTypeHash.get(name.substring(5)): " + methodReturnTypeHash.get(name.substring(5)));
                return getCopyOfType(methodReturnTypeHash.get(name.substring(5)));
            }
        }
        return n;
    }

    /**
     * f0 -> "int"
     * f1 -> "["
     * f2 -> "]"
     */
    public Node visit(ArrayType n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        return n;
    }

    /**
     * f0 -> "boolean"
     */
    public Node visit(BooleanType n) {
        Node _ret=null;
        n.f0.accept(this);
        return n;
    }

    /**
     * f0 -> "int"
     */
    public Node visit(IntegerType n) {
        Node _ret=null;
        n.f0.accept(this);
        return n;
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
    public Node visit(Statement n) {
        Node _ret=null;
        n.f0.accept(this);
        return n;
    }

    /**
     * f0 -> "{"
     * f1 -> ( Statement() )*
     * f2 -> "}"
     */
    public Node visit(Block n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        return n;
    }

    /**
     * f0 -> VarRef()
     * f1 -> "="
     * f2 -> Expression()
     * f3 -> ";"
     */
    public Node visit(AssignmentStatement n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        return n;
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
    public Node visit(ArrayAssignmentStatement n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);
        n.f6.accept(this);
        return n;
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
    public Node visit(IfStatement n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);
        n.f6.accept(this);
        return n;
    }

    /**
     * f0 -> "while"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> Statement()
     */
    public Node visit(WhileStatement n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        return n;
    }

    /**
     * f0 -> "System.out.println"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> ";"
     */
    public Node visit(PrintStatement n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        return n;
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
    public Node visit(MessageSendStatement n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);
        n.f6.accept(this);
        return n;
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
    public Node visit(Expression n) {
        Node _ret=null;
        n.f0.accept(this);
        return n;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "&"
     * f2 -> PrimaryExpression()
     */
    public Node visit(AndExpression n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        return n;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "<"
     * f2 -> PrimaryExpression()
     */
    public Node visit(CompareExpression n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        return n;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "+"
     * f2 -> PrimaryExpression()
     */
    public Node visit(PlusExpression n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        return n;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "-"
     * f2 -> PrimaryExpression()
     */
    public Node visit(MinusExpression n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        return n;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "*"
     * f2 -> PrimaryExpression()
     */
    public Node visit(TimesExpression n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        return n;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "["
     * f2 -> PrimaryExpression()
     * f3 -> "]"
     */
    public Node visit(ArrayLookup n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        return n;
    }

    /**
     * f0 -> Expression()
     * f1 -> ( ExpressionRest() )*
     */
    public Node visit(ExpressionList n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        return n;
    }

    /**
     * f0 -> ","
     * f1 -> Expression()
     */
    public Node visit(ExpressionRest n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        return n;
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
    public Node visit(PrimaryExpression n) {
        Node _ret=null;
        n.f0.accept(this);
        return n;
    }

    /**
     * f0 -> <INTEGER_LITERAL>
     */
    public Node visit(IntegerLiteral n) {
        Node _ret=null;
        n.f0.accept(this);
        return n;
    }

    /**
     * f0 -> "true"
     */
    public Node visit(TrueLiteral n) {
        Node _ret=null;
        n.f0.accept(this);
        return n;
    }

    /**
     * f0 -> "false"
     */
    public Node visit(FalseLiteral n) {
        Node _ret=null;
        n.f0.accept(this);
        return n;
    }

    /**
     * f0 -> <IDENTIFIER>
     */
    public Node visit(Identifier n) {
        Node _ret=null;
        n.f0.accept(this);
        return n;
    }

    /**
     * f0 -> "this"
     */
    public Node visit(ThisExpression n) {
        Node _ret=null;
        n.f0.accept(this);
        return n;
    }

    /**
     * f0 -> "new"
     * f1 -> "int"
     * f2 -> "["
     * f3 -> Expression()
     * f4 -> "]"
     */
    public Node visit(ArrayAllocationExpression n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        return n;
    }

    /**
     * f0 -> "new"
     * f1 -> Identifier()
     * f2 -> "("
     * f3 -> ")"
     */
    public Node visit(AllocationExpression n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        return n;
    }

    /**
     * f0 -> "!"
     * f1 -> Expression()
     */
    public Node visit(NotExpression n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        return n;
    }

    /**
     * f0 -> "("
     * f1 -> Expression()
     * f2 -> ")"
     */
    public Node visit(BracketExpression n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        return n;
    }

    /**
     * f0 -> DotExpression()
     *       | Identifier()
     */
    public Node visit(VarRef n) {
        Node _ret=null;
        n.f0.accept(this);
        return n;
    }

    /**
     * f0 -> Identifier()
     * f1 -> "."
     * f2 -> Identifier()
     */
    public Node visit(DotExpression n) {
        Node _ret=null;
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        return n;
    }

}
