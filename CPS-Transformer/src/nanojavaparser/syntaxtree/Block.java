//
// Generated by JTB 1.3.2
//

package nanojavaparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> "{"
 * f1 -> ( Statement() )*
 * f2 -> JumpPoint()
 * f3 -> "}"
 */
public class Block implements Node {
   public NodeToken f0;
   public NodeListOptional f1;
   public JumpPoint f2;
   public NodeToken f3;

   public Block(NodeToken n0, NodeListOptional n1, JumpPoint n2, NodeToken n3) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
   }

   public Block(NodeListOptional n0, JumpPoint n1) {
      f0 = new NodeToken("{");
      f1 = n0;
      f2 = n1;
      f3 = new NodeToken("}");
   }

   public void accept(nanojavaparser.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(nanojavaparser.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(nanojavaparser.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(nanojavaparser.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

