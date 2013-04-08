package inliner;

import inliner.syntaxtree.*;
import inliner.visitor.*;
import java.util.Set;
import java.util.HashSet;

/** 
 * Class to get a Set of Flow Constraints from a Microjava parse tree.
 * 
 */
public class ConstraintGenerator extends IdentityVisitor {
    Set<BeginningConstraint> beginningConstraints;
    
    public ConstraintGenerator() {
        beginningConstraints = new HashSet<BeginningConstraint>();
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
        addBeginningConstraint(InlinerHelper.getFormattedString(n));
        _ret = new AllocationExpression((Identifier) n.f1.accept(this));
        return _ret;
    }
}
