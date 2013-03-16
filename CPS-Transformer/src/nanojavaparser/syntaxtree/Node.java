//
// Generated by JTB 1.3.2
//

package nanojavaparser.syntaxtree;

/**
 * The interface which all syntax tree classes must implement.
 */
public interface Node extends java.io.Serializable {
   public void accept(nanojavaparser.visitor.Visitor v);
   public <R,A> R accept(nanojavaparser.visitor.GJVisitor<R,A> v, A argu);
   public <R> R accept(nanojavaparser.visitor.GJNoArguVisitor<R> v);
   public <A> void accept(nanojavaparser.visitor.GJVoidVisitor<A> v, A argu);
}
