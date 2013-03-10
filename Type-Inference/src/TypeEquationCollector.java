import syntaxtree.*;
import visitor.*;
import java.util.*;

public class TypeEquationCollector extends GJDepthFirst<Type, TypeEnvironment> {

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
      n.f0.accept(this, arg);
      n.f1.accept(this, arg);
      return _ret;
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
      n.f0.accept(this, arg);
      n.f1.accept(this, arg);
      n.f2.accept(this, arg);
      n.f3.accept(this, arg);
      n.f4.accept(this, arg);
      n.f5.accept(this, arg);
      n.f6.accept(this, arg);
      return _ret;
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public Type visit(Identifier n, TypeEnvironment arg) {
      Type _ret=null;
      n.f0.accept(this, arg);
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
      n.f0.accept(this, arg);
      n.f1.accept(this, arg);
      n.f2.accept(this, arg);
      n.f3.accept(this, arg);
      n.f4.accept(this, arg);
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
      n.f0.accept(this, arg);
      n.f1.accept(this, arg);
      n.f2.accept(this, arg);
      n.f3.accept(this, arg);
      n.f4.accept(this, arg);
      n.f5.accept(this, arg);
      n.f6.accept(this, arg);
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
      n.f0.accept(this, arg);
      n.f1.accept(this, arg);
      n.f2.accept(this, arg);
      n.f3.accept(this, arg);
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
      n.f0.accept(this, arg);
      n.f1.accept(this, arg);
      n.f2.accept(this, arg);
      n.f3.accept(this, arg);
      n.f4.accept(this, arg);
      n.f5.accept(this, arg);
      n.f6.accept(this, arg);
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
      n.f0.accept(this, arg);
      n.f1.accept(this, arg);
      n.f2.accept(this, arg);
      n.f3.accept(this, arg);
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
      n.f0.accept(this, arg);
      n.f1.accept(this, arg);
      n.f2.accept(this, arg);
      n.f3.accept(this, arg);
      return _ret;
   }

}
