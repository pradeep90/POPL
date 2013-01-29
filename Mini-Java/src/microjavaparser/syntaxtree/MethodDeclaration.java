//
// Generated by JTB 1.3.2
//

package microjavaparser.syntaxtree;

/**
 * Grammar production:
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
public class MethodDeclaration implements Node {
   public NodeToken f0;
   public NodeToken f1;
   public Identifier f2;
   public NodeToken f3;
   public NodeOptional f4;
   public NodeToken f5;
   public NodeToken f6;
   public NodeListOptional f7;
   public NodeListOptional f8;
   public NodeToken f9;

   public MethodDeclaration(NodeToken n0, NodeToken n1, Identifier n2, NodeToken n3, NodeOptional n4, NodeToken n5, NodeToken n6, NodeListOptional n7, NodeListOptional n8, NodeToken n9) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
      f5 = n5;
      f6 = n6;
      f7 = n7;
      f8 = n8;
      f9 = n9;
   }

   public MethodDeclaration(Identifier n0, NodeOptional n1, NodeListOptional n2, NodeListOptional n3) {
      f0 = new NodeToken("public");
      f1 = new NodeToken("void");
      f2 = n0;
      f3 = new NodeToken("(");
      f4 = n1;
      f5 = new NodeToken(")");
      f6 = new NodeToken("{");
      f7 = n2;
      f8 = n3;
      f9 = new NodeToken("}");
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

