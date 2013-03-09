//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> "("
 * f1 -> Identifier()
 * f2 -> ProcedureExp()
 * f3 -> ")"
 */
public class RecDeclaration implements Node {
   public NodeToken f0;
   public Identifier f1;
   public ProcedureExp f2;
   public NodeToken f3;

   public RecDeclaration(NodeToken n0, Identifier n1, ProcedureExp n2, NodeToken n3) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
   }

   public RecDeclaration(Identifier n0, ProcedureExp n1) {
      f0 = new NodeToken("(");
      f1 = n0;
      f2 = n1;
      f3 = new NodeToken(")");
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

