import syntaxtree.*;
import visitor.*;
import java.util.*;

/**
 * Class to interpret a MicroJava parse tree.
 */
public class Interpreter extends GJDepthFirst<Value,Environment> {

    HashMap<String, ClassValue> symbolTable = new HashMap<String, ClassValue>();

    //
    // Auto class visitors--probably don't need to be overridden.
    //
    public Value visit(NodeList n, Environment env) {
        Value _ret=null;
        int _count=0;
        for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,env);
            _count++;
        }
        return _ret;
    }

    public Value visit(NodeListOptional n, Environment env) {
        if ( n.present() ) {
            Value _ret=null;
            int _count=0;
            for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
                e.nextElement().accept(this,env);
                _count++;
            }
            return _ret;
        }
        else
            return null;
    }

    public Value visit(NodeOptional n, Environment env) {
        if ( n.present() )
            return n.node.accept(this,env);
        else
            return null;
    }

    public Value visit(NodeSequence n, Environment env) {
        Value _ret=null;
        int _count=0;
        for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,env);
            _count++;
        }
        return _ret;
    }

    public Value visit(NodeToken n, Environment env) {
        return null;
    }
    
    //
    // User-generated visitor methods below
    //

    /**
     * f0 -> MainClass()
     * f1 -> ( TypeDeclaration() )*
     * f2 -> <EOF>
     */
    public Value visit(Goal n, Environment env) {
        Value _ret=null;
        n.f0.accept(this, env);
        n.f1.accept(this, env);
        n.f2.accept(this, env);
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
    public Value visit(MainClass n, Environment env) {
        Value _ret=null;
        n.f0.accept(this, env);
        n.f1.accept(this, env);
        n.f2.accept(this, env);
        n.f3.accept(this, env);
        n.f4.accept(this, env);
        n.f5.accept(this, env);
        n.f6.accept(this, env);
        n.f7.accept(this, env);
        n.f8.accept(this, env);
        n.f9.accept(this, env);
        n.f10.accept(this, env);
        n.f11.accept(this, env);
        n.f12.accept(this, env);
        n.f13.accept(this, env);
        n.f14.accept(this, env);
        n.f15.accept(this, env);
        n.f16.accept(this, env);
        n.f17.accept(this, env);
        n.f18.accept(this, env);
        n.f19.accept(this, env);
        n.f20.accept(this, env);
        n.f21.accept(this, env);
        n.f22.accept(this, env);
        n.f23.accept(this, env);
        n.f24.accept(this, env);
        n.f25.accept(this, env);

        // TODO(spradeep): Just make a MessageSendStatement out of
        // this and run it.

        // tmp = new Foo();
        // tmp.bar(args);

        // MessageSendStatement messageSendStatement = new MessageSendStatement(n.f19, n.f21);

        return _ret;
    }

    /**
     * f0 -> ClassDeclaration()
     *       | ClassExtendsDeclaration()
     */
    public Value visit(TypeDeclaration n, Environment env) {
        Value _ret=null;
        ClassValue classValue = (ClassValue) n.f0.accept(this, env);
        symbolTable.put(classValue.name, classValue);
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
    public Value visit(ClassDeclaration n, Environment env) {
        Value _ret=null;

        Environment methodTable = new Environment();

        for (Node node : n.f4.nodes){
            MethodDeclaration currMethodDeclaration = (MethodDeclaration) node;
            methodTable.extend(MicroJavaHelper.getIdentifierName(currMethodDeclaration.f2),
                               currMethodDeclaration.accept(this, env));
        }
        _ret = new ClassValue(n, methodTable);
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
    public Value visit(ClassExtendsDeclaration n, Environment env) {
        Value _ret=null;

        Environment methodTable = new Environment();

        for (Node node : n.f6.nodes){
            MethodDeclaration currMethodDeclaration = (MethodDeclaration) node;
            methodTable.extend(MicroJavaHelper.getIdentifierName(currMethodDeclaration.f2),
                               currMethodDeclaration.accept(this, env));
        }
        _ret = new ClassValue(n, methodTable);
        return _ret;
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     * f2 -> ";"
     */
    public Value visit(VarDeclaration n, Environment env) {
        Value _ret=null;
        Value f0 = n.f0.accept(this, env);
        env.extend(n.f1, f0);
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
    public Value visit(MethodDeclaration n, Environment env) {
        // Return ClosureValue corresponding to this MethodDeclaration.
        
        // Note: Not using env cos we'll just use the class' env when
        // applying the closure.

        Value _ret=null;
        _ret = new ClosureValue(n);
        return _ret;
    }

    /**
     * f0 -> FormalParameter()
     * f1 -> ( FormalParameterRest() )*
     */
    public Value visit(FormalParameterList n, Environment env) {
        Value _ret=null;
        n.f0.accept(this, env);
        n.f1.accept(this, env);
        return _ret;
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     */
    public Value visit(FormalParameter n, Environment env) {
        Value _ret=null;
        n.f0.accept(this, env);
        n.f1.accept(this, env);
        return _ret;
    }

    /**
     * f0 -> ","
     * f1 -> FormalParameter()
     */
    public Value visit(FormalParameterRest n, Environment env) {
        Value _ret=null;
        n.f0.accept(this, env);
        n.f1.accept(this, env);
        return _ret;
    }

    /**
     * f0 -> ArrayType()
     *       | BooleanType()
     *       | IntegerType()
     *       | Identifier()
     */
    public Value visit(Type n, Environment env) {
        Value _ret=null;

        if (n.f0.which == 3){
            // TODO(spradeep): Return ObjectValue of Identifier type.
        }
        else{
            _ret = n.f0.accept(this, env);
        }
        return _ret;
    }

    /**
     * f0 -> "int"
     * f1 -> "["
     * f2 -> "]"
     */
    public Value visit(ArrayType n, Environment env) {
        Value _ret=null;
        _ret = new ArrayValue();
        return _ret;
    }

    /**
     * f0 -> "boolean"
     */
    public Value visit(BooleanType n, Environment env) {
        Value _ret=null;
        _ret = new BooleanValue();
        return _ret;
    }

    /**
     * f0 -> "int"
     */
    public Value visit(IntegerType n, Environment env) {
        Value _ret=null;
        _ret = new IntegerValue();
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
    public Value visit(Statement n, Environment env) {
        Value _ret=null;
        n.f0.accept(this, env);
        return _ret;
    }

    /**
     * f0 -> "{"
     * f1 -> ( Statement() )*
     * f2 -> "}"
     */
    public Value visit(Block n, Environment env) {
        Value _ret=null;
        n.f1.accept(this, env);
        return _ret;
    }

    /**
     * f0 -> VarRef()
     * f1 -> "="
     * f2 -> Expression()
     * f3 -> ";"
     */
    public Value visit(AssignmentStatement n, Environment env) {
        Value _ret=null;
        Value f0 = n.f0.accept(this, env);
        Value f2 = n.f2.accept(this, env);

        f0.setValue(f2);
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
    public Value visit(ArrayAssignmentStatement n, Environment env) {
        Value _ret=null;
        ArrayValue f0 = (ArrayValue) n.f0.accept(this, env);
        IntegerValue f2 = (IntegerValue) n.f2.accept(this, env);
        IntegerValue f5 = (IntegerValue) n.f5.accept(this, env);
        f0.arr[f2.integerValue] = f5.integerValue;
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
    public Value visit(IfStatement n, Environment env) {
        Value _ret=null;
        BooleanValue ifCond = (BooleanValue) n.f2.accept(this, env);
        if (ifCond.booleanValue){
            n.f4.accept(this, env);
        }
        else{
            n.f6.accept(this, env);
        }
        return _ret;
    }

    /**
     * f0 -> "while"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> Statement()
     */
    public Value visit(WhileStatement n, Environment env) {
        Value _ret=null;
        while (((BooleanValue) n.f2.accept(this, env)).booleanValue){
            n.f4.accept(this, env);
        }
        return _ret;
    }

    /**
     * f0 -> "System.out.println"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> ";"
     */
    public Value visit(PrintStatement n, Environment env) {
        Value _ret=null;
        n.f0.accept(this, env);
        n.f1.accept(this, env);
        Value f2 = n.f2.accept(this, env);
        n.f3.accept(this, env);
        n.f4.accept(this, env);

        // TODO(spradeep): Should I actually print here? 
        System.out.println(((IntegerValue) f2).integerValue);
        
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
    public Value visit(MessageSendStatement n, Environment env) {
        Value _ret=null;
        n.f0.accept(this, env);
        n.f1.accept(this, env);
        n.f2.accept(this, env);
        n.f3.accept(this, env);
        n.f4.accept(this, env);
        n.f5.accept(this, env);
        n.f6.accept(this, env);
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
    public Value visit(Expression n, Environment env) {
        Value _ret=null;
        Value f0 = n.f0.accept(this, env);
        return f0;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "&"
     * f2 -> PrimaryExpression()
     */
    public Value visit(AndExpression n, Environment env) {
        Value _ret=null;
        Value f0 = n.f0.accept(this, env);
        // n.f1.accept(this, env);
        Value f2 = n.f2.accept(this, env);
        _ret = new BooleanValue(((BooleanValue) f0).booleanValue
                                && ((BooleanValue) f2).booleanValue);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "<"
     * f2 -> PrimaryExpression()
     */
    public Value visit(CompareExpression n, Environment env) {
        Value _ret=null;
        Value f0 = n.f0.accept(this, env);
        // n.f1.accept(this, env);
        Value f2 = n.f2.accept(this, env);
        _ret = new BooleanValue(((IntegerValue) f0).integerValue
                                < ((IntegerValue) f2).integerValue);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "+"
     * f2 -> PrimaryExpression()
     */
    public Value visit(PlusExpression n, Environment env) {
        Value _ret=null;
        Value f0 = n.f0.accept(this, env);
        // n.f1.accept(this, env);
        Value f2 = n.f2.accept(this, env);
        _ret = new IntegerValue(((IntegerValue) f0).integerValue
                                + ((IntegerValue) f2).integerValue);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "-"
     * f2 -> PrimaryExpression()
     */
    public Value visit(MinusExpression n, Environment env) {
        Value _ret=null;
        Value f0 = n.f0.accept(this, env);
        // n.f1.accept(this, env);
        Value f2 = n.f2.accept(this, env);
        _ret = new IntegerValue(((IntegerValue) f0).integerValue
                                - ((IntegerValue) f2).integerValue);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "*"
     * f2 -> PrimaryExpression()
     */
    public Value visit(TimesExpression n, Environment env) {
        Value _ret=null;
        Value f0 = n.f0.accept(this, env);
        // n.f1.accept(this, env);
        Value f2 = n.f2.accept(this, env);
        _ret = new IntegerValue(((IntegerValue) f0).integerValue
                                * ((IntegerValue) f2).integerValue);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "["
     * f2 -> PrimaryExpression()
     * f3 -> "]"
     */
    public Value visit(ArrayLookup n, Environment env) {
        Value _ret=null;
        Value f0 = n.f0.accept(this, env);
        // n.f1.accept(this, env);
        Value f2 = n.f2.accept(this, env);
        // n.f3.accept(this, env);

        int[] arr = ((ArrayValue) f0).arr;
        int index = ((IntegerValue) f2).integerValue;

        _ret = new IntegerValue(arr[index]);
        return _ret;
    }

    /**
     * f0 -> Expression()
     * f1 -> ( ExpressionRest() )*
     */
    public Value visit(ExpressionList n, Environment env) {
        Value _ret=null;
        n.f0.accept(this, env);
        n.f1.accept(this, env);
        return _ret;
    }

    /**
     * f0 -> ","
     * f1 -> Expression()
     */
    public Value visit(ExpressionRest n, Environment env) {
        Value _ret=null;
        n.f0.accept(this, env);
        n.f1.accept(this, env);
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
    public Value visit(PrimaryExpression n, Environment env) {
        Value _ret=null;
        Value f0 = n.f0.accept(this, env);
        return f0;
    }

    /**
     * f0 -> <INTEGER_LITERAL>
     */
    public Value visit(IntegerLiteral n, Environment env) {
        Value _ret=null;
        n.f0.accept(this, env);
        _ret = new IntegerValue(Integer.parseInt(n.f0.tokenImage));
        return _ret;
    }

    /**
     * f0 -> "true"
     */
    public Value visit(TrueLiteral n, Environment env) {
        Value _ret=null;
        n.f0.accept(this, env);
        _ret = new BooleanValue(true);
        return _ret;
    }

    /**
     * f0 -> "false"
     */
    public Value visit(FalseLiteral n, Environment env) {
        Value _ret=null;
        n.f0.accept(this, env);
        _ret = new BooleanValue(false);
        return _ret;
    }

    /**
     * f0 -> <IDENTIFIER>
     */
    public Value visit(Identifier n, Environment env) {
        Value _ret=null;
        n.f0.accept(this, env);
        _ret = env.lookup(n);
        return _ret;
    }

    /**
     * f0 -> "this"
     */
    public Value visit(ThisExpression n, Environment env) {
        Value _ret=null;
        n.f0.accept(this, env);
        _ret = env.lookup(n);
        return _ret;
    }

    /**
     * f0 -> "new"
     * f1 -> "int"
     * f2 -> "["
     * f3 -> Expression()
     * f4 -> "]"
     */
    public Value visit(ArrayAllocationExpression n, Environment env) {
        Value _ret=null;
        n.f0.accept(this, env);
        n.f1.accept(this, env);
        n.f2.accept(this, env);
        Value f3 = n.f3.accept(this, env);
        n.f4.accept(this, env);

        // TODO(spradeep): 
        // store.put(value, );
        
        _ret = new ArrayValue(((IntegerValue) f3).integerValue);
        return _ret;
    }

    /**
     * f0 -> "new"
     * f1 -> Identifier()
     * f2 -> "("
     * f3 -> ")"
     */
    public Value visit(AllocationExpression n, Environment env) {
        Value _ret=null;
        n.f0.accept(this, env);
        n.f1.accept(this, env);
        n.f2.accept(this, env);
        n.f3.accept(this, env);
        return _ret;
    }

    /**
     * f0 -> "!"
     * f1 -> Expression()
     */
    public Value visit(NotExpression n, Environment env) {
        Value _ret=null;
        // n.f0.accept(this, env);
        Value f1 = n.f1.accept(this, env);
        _ret = new BooleanValue(!f1.isTrue());
        return _ret;
    }

    /**
     * f0 -> "("
     * f1 -> Expression()
     * f2 -> ")"
     */
    public Value visit(BracketExpression n, Environment env) {
        Value _ret=null;
        // n.f0.accept(this, env);
        Value f1 = n.f1.accept(this, env);
        // n.f2.accept(this, env);
        return f1;
    }

    /**
     * f0 -> DotExpression()
     *       | Identifier()
     */
    public Value visit(VarRef n, Environment env) {
        Value _ret=null;

        if (n.f0.which == 0){
            _ret = n.f0.accept(this, env);
        } else {
            _ret = env.lookup((Identifier) n.f0.choice);
        }
        return _ret;
    }

    /**
     * f0 -> Identifier()
     * f1 -> "."
     * f2 -> Identifier()
     */
    public Value visit(DotExpression n, Environment env) {
        Value _ret=null;
        n.f0.accept(this, env);
        n.f1.accept(this, env);
        n.f2.accept(this, env);
        // value = n.f0.accept(this, env);
        return _ret;
    }
}
