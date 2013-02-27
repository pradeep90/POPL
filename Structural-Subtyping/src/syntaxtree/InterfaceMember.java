//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> ResultType()
 * f1 -> Identifier()
 * f2 -> "("
 * f3 -> Type()
 * f4 -> Identifier()
 * f5 -> ")"
 * f6 -> ";"
 */
public class InterfaceMember implements Node {
   public ResultType f0;
   public Identifier f1;
   public NodeToken f2;
   public Type f3;
   public Identifier f4;
   public NodeToken f5;
   public NodeToken f6;

   public InterfaceMember(ResultType n0, Identifier n1, NodeToken n2, Type n3, Identifier n4, NodeToken n5, NodeToken n6) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
      f5 = n5;
      f6 = n6;
   }

   public InterfaceMember(ResultType n0, Identifier n1, Type n2, Identifier n3) {
      f0 = n0;
      f1 = n1;
      f2 = new NodeToken("(");
      f3 = n2;
      f4 = n3;
      f5 = new NodeToken(")");
      f6 = new NodeToken(";");
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
