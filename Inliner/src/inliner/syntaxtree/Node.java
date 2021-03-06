//
// Generated by JTB 1.3.2
//

package inliner.syntaxtree;

/**
 * The interface which all syntax tree classes must implement.
 */
public interface Node extends java.io.Serializable {
   public void accept(inliner.visitor.Visitor v);
   public <R,A> R accept(inliner.visitor.GJVisitor<R,A> v, A argu);
   public <R> R accept(inliner.visitor.GJNoArguVisitor<R> v);
   public <A> void accept(inliner.visitor.GJVoidVisitor<A> v, A argu);
}

