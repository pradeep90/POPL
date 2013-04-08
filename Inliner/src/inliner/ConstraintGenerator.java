package inliner;

import inliner.syntaxtree.*;
import inliner.visitor.*;
import java.util.Set;
import java.util.HashSet;

import static inliner.InlinerHelper.getFormattedString;

/** 
 * Class to get a Set of Flow Constraints from a Microjava parse tree.
 * 
 */
public class ConstraintGenerator extends IdentityVisitor {
    Set<BeginningConstraint> beginningConstraints;
    Set<PropagationConstraint> propagationConstraints;
    
    public ConstraintGenerator() {
        beginningConstraints = new HashSet<BeginningConstraint>();
        propagationConstraints = new HashSet<PropagationConstraint>();
    }

    public void addBeginningConstraint(String expressionString){
        BeginningConstraint currConstraint = new BeginningConstraint(
            this.currClassName,
            new FlowVar(this.currClassName,
                        this.currMethodName,
                        expressionString));
        beginningConstraints.add(currConstraint);
    }

    /**
     * f0 -> "this"
     */
    @Override
    public Node visit(ThisExpression n) {
        Node _ret=null;
        addBeginningConstraint("this");
        _ret = new ThisExpression();
        return _ret;
    }

    /**
     * f0 -> "new"
     * f1 -> Identifier()
     * f2 -> "("
     * f3 -> ")"
     */
    @Override
    public Node visit(AllocationExpression n) {
        Node _ret=null;
        _ret = new AllocationExpression((Identifier) n.f1.accept(this));
        addBeginningConstraint(getFormattedString(_ret));
        return _ret;
    }

    /**
     * f0 -> VarRef()
     * f1 -> "="
     * f2 -> Expression()
     * f3 -> ";"
     */
    @Override
    public Node visit(AssignmentStatement n) {
        Node _ret=null;
        VarRef f0 = (VarRef) n.f0.accept(this);
        Expression f2 = (Expression) n.f2.accept(this);
        _ret = new AssignmentStatement(f0, f2);

        PropagationConstraint currConstraint = new PropagationConstraint(
            new FlowVar(this.currClassName, this.currMethodName,
                        getFormattedString(f0)),
            new FlowVar(this.currClassName, this.currMethodName,
                        getFormattedString(f2)));
        propagationConstraints.add(currConstraint);
        return _ret;
    }
}
