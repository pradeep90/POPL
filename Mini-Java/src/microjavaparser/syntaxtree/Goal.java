//
// Generated by JTB 1.3.2
//

package microjavaparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> MainClass()
 * f1 -> ( TypeDeclaration() )*
 * f2 -> <EOF>
 */
public class Goal implements Node {
   public MainClass f0;
   public NodeListOptional f1;
   public NodeToken f2;

   public Goal(MainClass n0, NodeListOptional n1, NodeToken n2) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
   }

   public Goal(MainClass n0, NodeListOptional n1) {
      f0 = n0;
      f1 = n1;
      f2 = new NodeToken("");
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

