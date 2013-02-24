import visitor.*;
import syntaxtree.*;

/** 
 * Visitor Class for visiting an Interface parse tree and creating the
 * corresponding TermAutomaton.
 */
public class TermAutomatonCreator extends GJVoidDepthFirst<TermAutomaton> {
    public TermAutomatonCreator() {
        
    }

    /**
     * f0 -> ( Query() )*
     * f1 -> ( InterfaceDeclaration() )*
     * f2 -> <EOF>
     */
    public void visit(Goal n, TermAutomaton arg) {
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        n.f2.accept(this, arg);
    }

    /**
     * f0 -> Identifier()
     * f1 -> "<="
     * f2 -> Identifier()
     * f3 -> "?"
     */
    public void visit(Query n, TermAutomaton arg) {
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        n.f2.accept(this, arg);
        n.f3.accept(this, arg);
    }

    /**
     * f0 -> "interface"
     * f1 -> Identifier()
     * f2 -> InterfaceBody()
     */
    public void visit(InterfaceDeclaration n, TermAutomaton arg) {
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        n.f2.accept(this, arg);
    }

    /**
     * f0 -> "{"
     * f1 -> ( InterfaceMember() )*
     * f2 -> "}"
     */
    public void visit(InterfaceBody n, TermAutomaton arg) {
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        n.f2.accept(this, arg);
    }

    /**
     * f0 -> ResultType()
     * f1 -> Identifier()
     * f2 -> "("
     * f3 -> Type()
     * f4 -> Identifier()
     * f5 -> ")"
     * f6 -> ";"
     */
    public void visit(InterfaceMember n, TermAutomaton arg) {
        n.f0.accept(this, arg);
        n.f1.accept(this, arg);
        n.f2.accept(this, arg);
        n.f3.accept(this, arg);
        n.f4.accept(this, arg);
        n.f5.accept(this, arg);
        n.f6.accept(this, arg);
    }

    /**
     * f0 -> BooleanType()
     *       | IntegerType()
     *       | Identifier()
     */
    public void visit(Type n, TermAutomaton arg) {
        n.f0.accept(this, arg);
    }

    /**
     * f0 -> "boolean"
     */
    public void visit(BooleanType n, TermAutomaton arg) {
        n.f0.accept(this, arg);
    }

    /**
     * f0 -> "int"
     */
    public void visit(IntegerType n, TermAutomaton arg) {
        n.f0.accept(this, arg);
    }

    /**
     * f0 -> VoidType()
     *       | Type()
     */
    public void visit(ResultType n, TermAutomaton arg) {
        n.f0.accept(this, arg);
    }

    /**
     * f0 -> "void"
     */
    public void visit(VoidType n, TermAutomaton arg) {
        n.f0.accept(this, arg);
    }

    /**
     * f0 -> <IDENTIFIER>
     */
    public void visit(Identifier n, TermAutomaton arg) {
        n.f0.accept(this, arg);
    }

}
