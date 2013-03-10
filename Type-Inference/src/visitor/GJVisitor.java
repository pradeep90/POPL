//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * All GJ visitors must implement this interface.
 */

public interface GJVisitor<R,A> {

   //
   // GJ Auto class visitors
   //

   public R visit(NodeList n, A argu);
   public R visit(NodeListOptional n, A argu);
   public R visit(NodeOptional n, A argu);
   public R visit(NodeSequence n, A argu);
   public R visit(NodeToken n, A argu);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> Expression()
    * f1 -> <EOF>
    */
   public R visit(Goal n, A argu);

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
   public R visit(Expression n, A argu);

   /**
    * f0 -> <INTEGER_LITERAL>
    */
   public R visit(IntegerLiteral n, A argu);

   /**
    * f0 -> "#t"
    */
   public R visit(TrueLiteral n, A argu);

   /**
    * f0 -> "#f"
    */
   public R visit(FalseLiteral n, A argu);

   /**
    * f0 -> "("
    * f1 -> "+"
    * f2 -> Expression()
    * f3 -> Expression()
    * f4 -> ")"
    */
   public R visit(PlusExpression n, A argu);

   /**
    * f0 -> "("
    * f1 -> "if"
    * f2 -> Expression()
    * f3 -> Expression()
    * f4 -> Expression()
    * f5 -> ")"
    */
   public R visit(IfExpression n, A argu);

   /**
    * f0 -> "("
    * f1 -> "let"
    * f2 -> "("
    * f3 -> ( Declaration() )*
    * f4 -> ")"
    * f5 -> Expression()
    * f6 -> ")"
    */
   public R visit(LetExpression n, A argu);

   /**
    * f0 -> <IDENTIFIER>
    */
   public R visit(Identifier n, A argu);

   /**
    * f0 -> "("
    * f1 -> "set!"
    * f2 -> Identifier()
    * f3 -> Expression()
    * f4 -> ")"
    */
   public R visit(Assignment n, A argu);

   /**
    * f0 -> "("
    * f1 -> "lambda"
    * f2 -> "("
    * f3 -> ( Identifier() )*
    * f4 -> ")"
    * f5 -> Expression()
    * f6 -> ")"
    */
   public R visit(ProcedureExp n, A argu);

   /**
    * f0 -> "("
    * f1 -> Expression()
    * f2 -> ( Expression() )*
    * f3 -> ")"
    */
   public R visit(Application n, A argu);

   /**
    * f0 -> "("
    * f1 -> "letrec"
    * f2 -> "("
    * f3 -> ( RecDeclaration() )*
    * f4 -> ")"
    * f5 -> Expression()
    * f6 -> ")"
    */
   public R visit(RecExpression n, A argu);

   /**
    * f0 -> "("
    * f1 -> Identifier()
    * f2 -> Expression()
    * f3 -> ")"
    */
   public R visit(Declaration n, A argu);

   /**
    * f0 -> "("
    * f1 -> Identifier()
    * f2 -> ProcedureExp()
    * f3 -> ")"
    */
   public R visit(RecDeclaration n, A argu);

}