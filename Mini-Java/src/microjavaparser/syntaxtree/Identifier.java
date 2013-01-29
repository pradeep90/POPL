//
// Generated by JTB 1.3.2
//

package microjavaparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> <IDENTIFIER>
 */
public class Identifier implements Node {
   public NodeToken f0;

   public Identifier(NodeToken n0) {
      f0 = n0;
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

