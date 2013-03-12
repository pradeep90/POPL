import syntaxtree.*;
import visitor.*;
import java.util.*;

public class TypeEquationCollector extends GJDepthFirst<Type, TypeEnvironment> {
    Unifier unifier;

    Set<TypeEquation> allEquations = new HashSet<TypeEquation>();
    
    public TypeEquationCollector() {
        
    }

    /** 
     * Add a TypeEquation (t1 = t2) to allEquations.
     */
    public void addEquation(Type t1, Type t2){
        allEquations.add(new TypeEquation(t1, t2));
    }

    //
    // Auto class visitors--probably don't need to be overridden.
    //
    public Type visit(NodeList n, TypeEnvironment arg) {
        Type _ret=null;
        int _count=0;
        for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,arg);
            _count++;
        }
        return _ret;
    }

    public Type visit(NodeListOptional n, TypeEnvironment arg) {
        if ( n.present() ) {
            Type _ret=null;
            int _count=0;
            for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
                e.nextElement().accept(this,arg);
                _count++;
            }
            return _ret;
        }
        else
            return null;
    }

    public Type visit(NodeOptional n, TypeEnvironment arg) {
        if ( n.present() )
            return n.node.accept(this,arg);
        else
            return null;
    }

    public Type visit(NodeSequence n, TypeEnvironment arg) {
        Type _ret=null;
        int _count=0;
        for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,arg);
            _count++;
        }
        return _ret;
    }

    public Type visit(NodeToken n, TypeEnvironment arg) { return null; }

    //
    // User-generated visitor methods below
    //

    /**
     * f0 -> Expression()
     * f1 -> <EOF>
     */
    public Type visit(Goal n, TypeEnvironment arg) {
        Type _ret=null;
        Type f0;
        try {
            f0 = n.f0.accept(this, arg);
        } catch(RuntimeException e) {
            System.out.println("Program does not type check"); 
            return null;
        }

        // System.out.println("f0: " + f0);

        // System.out.println("allEquations: " + allEquations);
        unifier = new Unifier(allEquations);
        if (!unifier.unify()){
            System.out.println("Program does not type check"); 
        }
        else {
            // substitute in f0 and write the result
            // System.out.println("f0.substitute(unifier.unification): " + f0.substitute(unifier.unification));
            System.out.println(f0.substitute(unifier.unification));
        }
        return f0.substitute(unifier.unification);
    }

    /**
     * f0 -> IntegerLiteral()
     *       | TrueLiteral()
     *       | FalseLiteral()
     *       | PlusExpression()
     *       | IfExpression()
     *       | LetExpression()
     *       | Identifier()
     *       | Assignment()
     *       | ProcedureExp()
     *       | Application()
     *       | RecExpression()
     */
    public Type visit(Expression n, TypeEnvironment arg) {
        Type _ret=null;
        _ret = n.f0.accept(this, arg);
        return _ret;
    }

    /**
     * f0 -> <INTEGER_LITERAL>
     */
    public Type visit(IntegerLiteral n, TypeEnvironment arg) {
        Type _ret=null;
        _ret = new IntType();
        return _ret;
    }

    /**
     * f0 -> "#t"
     */
    public Type visit(TrueLiteral n, TypeEnvironment arg) {
        Type _ret=null;
        _ret = new BooleanType();
        return _ret;
    }

    /**
     * f0 -> "#f"
     */
    public Type visit(FalseLiteral n, TypeEnvironment arg) {
        Type _ret=null;
        _ret = new BooleanType();
        return _ret;
    }

    /**
     * f0 -> "("
     * f1 -> "+"
     * f2 -> Expression()
     * f3 -> Expression()
     * f4 -> ")"
     */
    public Type visit(PlusExpression n, TypeEnvironment arg) {
        Type _ret=null;
        Type t1 = n.f2.accept(this, arg);
        Type t2 = n.f3.accept(this, arg);
        addEquation(t1, new IntType());
        addEquation(t2, new IntType());
        _ret = new IntType();
        return _ret;
    }

    /**
     * f0 -> "("
     * f1 -> "if"
     * f2 -> Expression()
     * f3 -> Expression()
     * f4 -> Expression()
     * f5 -> ")"
     */
    public Type visit(IfExpression n, TypeEnvironment arg) {
        Type _ret=null;
        Type f2 = n.f2.accept(this, arg);
        Type f3 = n.f3.accept(this, arg);
        Type f4 = n.f4.accept(this, arg);

        _ret = new UnknownType();
        addEquation(f2, new BooleanType());
        addEquation(f3, _ret);
        addEquation(f4, _ret);
        return _ret;
    }

    /**
     * f0 -> "("
     * f1 -> "let"
     * f2 -> "("
     * f3 -> ( Declaration() )*
     * f4 -> ")"
     * f5 -> Expression()
     * f6 -> ")"
     */
    public Type visit(LetExpression n, TypeEnvironment arg) {
        Type _ret=null;
        TypeEnvironment letTypeEnvironment = new TypeEnvironment(arg);

        // VVIP: We're evaluating each declaration in the parent
        // TypeEnvironment of let so that there are no recursive
        // declarations
        for (Node node : n.f3.nodes){
            Declaration currDeclaration = (Declaration) node;
            Type type = this.visit(currDeclaration, arg);

            if (type == null){
                // The declaration referred to one of the let identifiers
                // System.out.println("Program does not type check"); 

                // System.exit(0);
                throw new RuntimeException("Program does not type check");
            }

            letTypeEnvironment.extend(
                TypeHelper.getIdentifierName(currDeclaration.f1), type);
        }
        Type f5 = n.f5.accept(this, letTypeEnvironment);
        _ret = f5;
        return _ret;
    }

    /**
     * f0 -> <IDENTIFIER>
     */
    public Type visit(Identifier n, TypeEnvironment arg) {
        Type _ret=null;
        _ret = arg.lookup(TypeHelper.getIdentifierName(n));
        return _ret;
    }

    /**
     * f0 -> "("
     * f1 -> "set!"
     * f2 -> Identifier()
     * f3 -> Expression()
     * f4 -> ")"
     */
    public Type visit(Assignment n, TypeEnvironment arg) {
        Type _ret=null;
        Type f3 = n.f3.accept(this, arg);

        // Return the old type of Identifier
        _ret = arg.lookup(TypeHelper.getIdentifierName(n.f2));
        arg.extend(TypeHelper.getIdentifierName(n.f2),
                   f3);
        return _ret;
    }

    /**
     * f0 -> "("
     * f1 -> "lambda"
     * f2 -> "("
     * f3 -> ( Identifier() )*
     * f4 -> ")"
     * f5 -> Expression()
     * f6 -> ")"
     */
    public Type visit(ProcedureExp n, TypeEnvironment arg) {
        Type _ret=null;
        TypeEnvironment lambdaTypeEnvironment = new TypeEnvironment(arg);
        List<Type> paramTypes = new ArrayList<Type>();
      
        for (Node node : n.f3.nodes){
            Identifier currIdentifier = (Identifier) node;
            Type currType = new UnknownType();
            lambdaTypeEnvironment.extend(
                TypeHelper.getIdentifierName(currIdentifier),
                currType);
            paramTypes.add(currType);
        }

        Type returnType = n.f5.accept(this, lambdaTypeEnvironment);

        _ret = FunctionType.getFunctionType(paramTypes, returnType);
        return _ret;
    }

    /**
     * f0 -> "("
     * f1 -> Expression()
     * f2 -> ( Expression() )*
     * f3 -> ")"
     */
    public Type visit(Application n, TypeEnvironment arg) {
        Type _ret=null;
        Type f1 = n.f1.accept(this, arg);

        // VVIP: The function (say int -> int -> int) could have
        // multiple parameters (f 3) gives (int -> int) whereas (f 3
        // 4) gives int. So, keep the return type a variable and unify
        // it based on the number of arguments actually given.
        _ret = new UnknownType();
        List<Type> paramTypes = new ArrayList<Type>();
        for (Node node : n.f2.nodes){
            paramTypes.add(node.accept(this, arg));
        }

        // Construct a FunctionType out of the given argument types.
        // Make sure it is of the same type as the actual function.
        Type givenArgsType = FunctionType.getFunctionType(paramTypes, _ret);
        addEquation(givenArgsType, f1);
        return _ret;
    }

    /**
     * f0 -> "("
     * f1 -> "letrec"
     * f2 -> "("
     * f3 -> ( RecDeclaration() )*
     * f4 -> ")"
     * f5 -> Expression()
     * f6 -> ")"
     */
    public Type visit(RecExpression n, TypeEnvironment arg) {
        Type _ret=null;

        TypeEnvironment recLetTypeEnvironment = new TypeEnvironment(arg);

        // VVIP: Have initial UnknownType for each declaration identifier so
        // that they can refer to each other mutually.
        for (Node node : n.f3.nodes){
            RecDeclaration currRecDeclaration = (RecDeclaration) node;
            Type identifierType = new UnknownType();
            recLetTypeEnvironment.extend(TypeHelper.getIdentifierName(currRecDeclaration.f1),
                                         identifierType);
        }
        n.f3.accept(this, recLetTypeEnvironment);
        Type f5 = n.f5.accept(this, recLetTypeEnvironment);
        _ret = f5;
        return _ret;
    }

    /**
     * f0 -> "("
     * f1 -> Identifier()
     * f2 -> Expression()
     * f3 -> ")"
     */
    public Type visit(Declaration n, TypeEnvironment arg) {
        Type _ret=null;
        Type f2 = null;
        try {
            f2 = n.f2.accept(this, arg);
        } catch(Exception e) {
            // e.printStackTrace();
        }
        _ret = f2;
        return _ret;
    }

    /**
     * f0 -> "("
     * f1 -> Identifier()
     * f2 -> ProcedureExp()
     * f3 -> ")"
     */
    public Type visit(RecDeclaration n, TypeEnvironment arg) {
        Type _ret=null;
        Type f2 = n.f2.accept(this, arg);
        addEquation(arg.lookup(TypeHelper.getIdentifierName(n.f1)), f2);
        return _ret;
    }
}
