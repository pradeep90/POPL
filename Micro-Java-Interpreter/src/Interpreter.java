import syntaxtree.*;
import visitor.*;
import java.util.*;

/**
 * Class to interpret a MicroJava parse tree.
 */
public class Interpreter extends GJDepthFirst<Result,InterpreterArgument> {

    //
    // Auto class visitors--probably don't need to be overridden.
    //
    public Result visit(NodeList n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        int _count=0;
        for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,arg);
            _count++;
        }
        Value value;
        // return new Result(value, store);
        return _ret;
    }

    public Result visit(NodeListOptional n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        if ( n.present() ) {
            Result _ret=null;
            int _count=0;
            for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
                e.nextElement().accept(this,arg);
                _count++;
            }
            Value value;
            // return new Result(value, store);
            return _ret;
        }
        else
            return null;
    }

    public Result visit(NodeOptional n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        if ( n.present() )
            return n.node.accept(this,arg);
        else
            return null;
    }

    public Result visit(NodeSequence n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        int _count=0;
        for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,arg);
            _count++;
        }
        Value value;
        // return new Result(value, store);
        return _ret;
    }

    public Result visit(NodeToken n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store; return null; }

    //
    // User-generated visitor methods below
    //

    /**
     * f0 -> MainClass()
     * f1 -> ( TypeDeclaration() )*
     * f2 -> <EOF>
     */
    public Result visit(Goal n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        n.f2.accept(this, arg);
        Value value;
        // return new Result(value, store);
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
    public Result visit(MainClass n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        n.f2.accept(this, arg);
        n.f3.accept(this, arg);
        n.f4.accept(this, arg);
        n.f5.accept(this, arg);
        n.f6.accept(this, arg);
        n.f7.accept(this, arg);
        n.f8.accept(this, arg);
        n.f9.accept(this, arg);
        n.f10.accept(this, arg);
        n.f11.accept(this, arg);
        n.f12.accept(this, arg);
        n.f13.accept(this, arg);
        n.f14.accept(this, arg);
        n.f15.accept(this, arg);
        n.f16.accept(this, arg);
        n.f17.accept(this, arg);
        n.f18.accept(this, arg);
        n.f19.accept(this, arg);
        n.f20.accept(this, arg);
        n.f21.accept(this, arg);
        n.f22.accept(this, arg);
        n.f23.accept(this, arg);
        n.f24.accept(this, arg);
        n.f25.accept(this, arg);
        Value value;
        // return new Result(value, store);
        return _ret;
    }

    /**
     * f0 -> ClassDeclaration()
     *       | ClassExtendsDeclaration()
     */
    public Result visit(TypeDeclaration n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        Value value;
        // return new Result(value, store);
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
    public Result visit(ClassDeclaration n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        n.f2.accept(this, arg);
        n.f3.accept(this, arg);
        n.f4.accept(this, arg);
        n.f5.accept(this, arg);
        Value value;
        // return new Result(value, store);
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
    public Result visit(ClassExtendsDeclaration n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        n.f2.accept(this, arg);
        n.f3.accept(this, arg);
        n.f4.accept(this, arg);
        n.f5.accept(this, arg);
        n.f6.accept(this, arg);
        n.f7.accept(this, arg);
        Value value;
        // return new Result(value, store);
        return _ret;
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     * f2 -> ";"
     */
    public Result visit(VarDeclaration n, InterpreterArgument arg) {
        // I'm choosing to extend the env with variable declarations
        // directly in the method definition (cos here you don't have
        // access to env).

        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        // n.f0.accept(this, arg);
        // n.f1.accept(this, arg);
        // n.f2.accept(this, arg);
        Value value;
        return new Result(null, store);
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
    public Result visit(MethodDeclaration n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        n.f2.accept(this, arg);
        n.f3.accept(this, arg);
        n.f4.accept(this, arg);
        n.f5.accept(this, arg);
        n.f6.accept(this, arg);
        n.f7.accept(this, arg);
        n.f8.accept(this, arg);
        n.f9.accept(this, arg);
        Value value;
        // return new Result(value, store);
        return _ret;
    }

    /**
     * f0 -> FormalParameter()
     * f1 -> ( FormalParameterRest() )*
     */
    public Result visit(FormalParameterList n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        Value value;
        // return new Result(value, store);
        return _ret;
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     */
    public Result visit(FormalParameter n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        Value value;
        // return new Result(value, store);
        return _ret;
    }

    /**
     * f0 -> ","
     * f1 -> FormalParameter()
     */
    public Result visit(FormalParameterRest n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        Value value;
        // return new Result(value, store);
        return _ret;
    }

    /**
     * f0 -> ArrayType()
     *       | BooleanType()
     *       | IntegerType()
     *       | Identifier()
     */
    public Result visit(Type n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;

        // TODO(spradeep): Should this even call visit(Identifier)???
        // You don't really expect a Type to have a value, do you?

        // Result f1 = n.f0.accept(this, arg);

        Value value;
        return new Result(null, store);
    }

    /**
     * f0 -> "int"
     * f1 -> "["
     * f2 -> "]"
     */
    public Result visit(ArrayType n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        // n.f0.accept(this, arg);
        // n.f1.accept(this, arg);
        // n.f2.accept(this, arg);
        Value value;
        return new Result(null, store);
    }

    /**
     * f0 -> "boolean"
     */
    public Result visit(BooleanType n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        // n.f0.accept(this, arg);
        Value value;
        return new Result(null, store);
    }

    /**
     * f0 -> "int"
     */
    public Result visit(IntegerType n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        // n.f0.accept(this, arg);
        Value value;
        return new Result(null, store);
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
    public Result visit(Statement n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        Value value;
        // return new Result(value, store);
        return _ret;
    }

    /**
     * f0 -> "{"
     * f1 -> ( Statement() )*
     * f2 -> "}"
     */
    public Result visit(Block n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        n.f2.accept(this, arg);
        Value value;
        // return new Result(value, store);
        return _ret;
    }

    /**
     * f0 -> VarRef()
     * f1 -> "="
     * f2 -> Expression()
     * f3 -> ";"
     */
    public Result visit(AssignmentStatement n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        n.f2.accept(this, arg);
        n.f3.accept(this, arg);
        Value value;
        // return new Result(value, store);
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
    public Result visit(ArrayAssignmentStatement n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        Result f0 = n.f0.accept(this, arg);
        // Result f1 = n.f1.accept(this, arg);
        Result f2 = n.f2.accept(this, arg);
        // Result f3 = n.f3.accept(this, arg);
        // Result f4 = n.f4.accept(this, arg);
        Result f5 = n.f5.accept(this, arg);
        // Result f6 = n.f6.accept(this, arg);
        Value value;
        return new Result(null, store);
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
    public Result visit(IfStatement n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        n.f2.accept(this, arg);
        n.f3.accept(this, arg);
        n.f4.accept(this, arg);
        n.f5.accept(this, arg);
        n.f6.accept(this, arg);
        Value value;
        // return new Result(value, store);
        return _ret;
    }

    /**
     * f0 -> "while"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> Statement()
     */
    public Result visit(WhileStatement n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        n.f2.accept(this, arg);
        n.f3.accept(this, arg);
        n.f4.accept(this, arg);
        Value value;
        // return new Result(value, store);
        return _ret;
    }

    /**
     * f0 -> "System.out.println"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> ";"
     */
    public Result visit(PrintStatement n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        Result f2 = n.f2.accept(this, arg);
        n.f3.accept(this, arg);
        n.f4.accept(this, arg);
        Value value;

        // TODO(spradeep): Should I actually print here? 
        System.out.println(((IntegerValue) f2.value).integerValue);
        
        return new Result(null, f2.store);
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
    public Result visit(MessageSendStatement n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        n.f2.accept(this, arg);
        n.f3.accept(this, arg);
        n.f4.accept(this, arg);
        n.f5.accept(this, arg);
        n.f6.accept(this, arg);
        Value value;
        // return new Result(value, store);
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
    public Result visit(Expression n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        Value value;
        Result f0 = n.f0.accept(this, arg);
        return f0;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "&"
     * f2 -> PrimaryExpression()
     */
    public Result visit(AndExpression n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        Result f0 = n.f0.accept(this, arg);
        // n.f1.accept(this, arg);
        Result f2 = n.f2.accept(this, new InterpreterArgument(env, f0.store));
        Value value = new BooleanValue(((BooleanValue) f0.value).booleanValue
                                       && ((BooleanValue) f2.value).booleanValue);
        return new Result(value, f2.store);
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "<"
     * f2 -> PrimaryExpression()
     */
    public Result visit(CompareExpression n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        Result f0 = n.f0.accept(this, arg);
        // n.f1.accept(this, arg);
        Result f2 = n.f2.accept(this, new InterpreterArgument(env, f0.store));
        Value value = new BooleanValue(((IntegerValue) f0.value).integerValue
                                       < ((IntegerValue) f2.value).integerValue);
        return new Result(value, f2.store);
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "+"
     * f2 -> PrimaryExpression()
     */
    public Result visit(PlusExpression n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        Result f0 = n.f0.accept(this, arg);
        // n.f1.accept(this, arg);
        Result f2 = n.f2.accept(this, new InterpreterArgument(env, f0.store));
        Value value = new IntegerValue(((IntegerValue) f0.value).integerValue
                                       + ((IntegerValue) f2.value).integerValue);
        return new Result(value, f2.store);
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "-"
     * f2 -> PrimaryExpression()
     */
    public Result visit(MinusExpression n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        Result f0 = n.f0.accept(this, arg);
        // n.f1.accept(this, arg);
        Result f2 = n.f2.accept(this, new InterpreterArgument(env, f0.store));
        Value value = new IntegerValue(((IntegerValue) f0.value).integerValue
                                       - ((IntegerValue) f2.value).integerValue);
        return new Result(value, f2.store);
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "*"
     * f2 -> PrimaryExpression()
     */
    public Result visit(TimesExpression n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        Result f0 = n.f0.accept(this, arg);
        // n.f1.accept(this, arg);
        Result f2 = n.f2.accept(this, new InterpreterArgument(env, f0.store));
        Value value = new IntegerValue(((IntegerValue) f0.value).integerValue
                                       * ((IntegerValue) f2.value).integerValue);
        return new Result(value, f2.store);
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "["
     * f2 -> PrimaryExpression()
     * f3 -> "]"
     */
    public Result visit(ArrayLookup n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        Result f0 = n.f0.accept(this, arg);
        // n.f1.accept(this, arg);
        Result f1 = n.f2.accept(this, arg);
        // n.f3.accept(this, arg);

        int[] arr = ((ArrayValue) f0.value).arr;
        int index = ((IntegerValue) f1.value).integerValue;

        System.out.println("index: " + index);
        Value value = new IntegerValue(arr[index]);
        return new Result(value, store);
    }

    /**
     * f0 -> Expression()
     * f1 -> ( ExpressionRest() )*
     */
    public Result visit(ExpressionList n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        Value value;
        // return new Result(value, store);
        return _ret;
    }

    /**
     * f0 -> ","
     * f1 -> Expression()
     */
    public Result visit(ExpressionRest n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        Value value;
        // return new Result(value, store);
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
    public Result visit(PrimaryExpression n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        Value value;
        Result f0 = n.f0.accept(this, arg);
        return f0;
    }

    /**
     * f0 -> <INTEGER_LITERAL>
     */
    public Result visit(IntegerLiteral n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        Value value = new IntegerValue(Integer.parseInt(n.f0.tokenImage));
        return new Result(value, store);
    }

    /**
     * f0 -> "true"
     */
    public Result visit(TrueLiteral n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        Value value = new BooleanValue(true);
        return new Result(value, store);
    }

    /**
     * f0 -> "false"
     */
    public Result visit(FalseLiteral n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        Value value = new BooleanValue(false);
        return new Result(value, store);
    }

    /**
     * f0 -> <IDENTIFIER>
     */
    public Result visit(Identifier n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        Value value = store.get(env.lookup(n));
        return new Result(value, store);
    }

    /**
     * f0 -> "this"
     */
    public Result visit(ThisExpression n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        Value value = store.get(env.lookup(n));
        return new Result(value, store);
    }

    /**
     * f0 -> "new"
     * f1 -> "int"
     * f2 -> "["
     * f3 -> Expression()
     * f4 -> "]"
     */
    public Result visit(ArrayAllocationExpression n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        n.f2.accept(this, arg);
        Result f3 = n.f3.accept(this, arg);
        n.f4.accept(this, arg);
        Value value = new ArrayValue(((IntegerValue) f3.value).integerValue);
        return new Result(value, store);
    }

    /**
     * f0 -> "new"
     * f1 -> Identifier()
     * f2 -> "("
     * f3 -> ")"
     */
    public Result visit(AllocationExpression n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        n.f2.accept(this, arg);
        n.f3.accept(this, arg);
        Value value;
        // return new Result(value, store);
        return _ret;
    }

    /**
     * f0 -> "!"
     * f1 -> Expression()
     */
    public Result visit(NotExpression n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        // n.f0.accept(this, arg);
        Result f1 = n.f1.accept(this, arg);
        Value value = new BooleanValue(!f1.value.isTrue());
        return new Result(value, f1.store);
    }

    /**
     * f0 -> "("
     * f1 -> Expression()
     * f2 -> ")"
     */
    public Result visit(BracketExpression n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        // n.f0.accept(this, arg);
        Result f1 = n.f1.accept(this, arg);
        // n.f2.accept(this, arg);
        return f1;
    }

    /**
     * f0 -> DotExpression()
     *       | Identifier()
     */
    public Result visit(VarRef n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        Value value;

        if (n.f0.which == 0){
            _ret = n.f0.accept(this, arg);
        } else {
            value = store.get(env.lookup((Identifier) n.f0.choice));
            _ret = new Result(value, store);
        }
        return _ret;
    }

    /**
     * f0 -> Identifier()
     * f1 -> "."
     * f2 -> Identifier()
     */
    public Result visit(DotExpression n, InterpreterArgument arg) {
        Environment env = arg.env;
        Store store = arg.store;
        Result _ret=null;
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        n.f2.accept(this, arg);
        Value value;
        // value = n.f0.accept(this, arg);
        // return new Result(value, store);
        return _ret;
    }
}
