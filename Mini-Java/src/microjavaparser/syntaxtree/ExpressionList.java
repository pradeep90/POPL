//
// Generated by JTB 1.3.2
//

package microjavaparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> Expression()
 * f1 -> ( ExpressionRest() )*
 */
public class ExpressionList implements Node {
   public Expression f0;
   public NodeListOptional f1;

   public ExpressionList(Expression n0, NodeListOptional n1) {
      f0 = n0;
      f1 = n1;
   }

   public void accept(microjavaparser.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(microjavaparser.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(microjavaparser.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(microjavaparser.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

