package inliner;

import inliner.syntaxtree.*;
import inliner.visitor.*;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

import static inliner.InlinerHelper.*;

/** 
 * Class to get a Set of Flow Constraints from a Microjava parse tree.
 * 
 */
public class ConstraintGenerator extends IdentityVisitor {
    Set<BeginningConstraint> beginningConstraints;
    Set<PropagationConstraint> propagationConstraints;
    Set<ConditionalConstraint> conditionalConstraints;

    Goal originalGoal;
    
    public ConstraintGenerator() {
        beginningConstraints = new HashSet<BeginningConstraint>();
        propagationConstraints = new HashSet<PropagationConstraint>();
        conditionalConstraints = new HashSet<ConditionalConstraint>();
    }

    public void addBeginningConstraint(String expressionString){
        BeginningConstraint currConstraint = new BeginningConstraint(
            this.currClassName,

            // TODO: Make sure that it IS actually a method-local
            // variable. Else, it is a class variable, so,
            // currMethodName should actually be null.
            new FlowVar(this.currClassName,
                        this.currMethodName,
                        expressionString));
        beginningConstraints.add(currConstraint);
    }

    /**
     * f0 -> MainClass()
     * f1 -> ( TypeDeclaration() )*
     * f2 -> <EOF>
     */
    public Node visit(Goal n) {
        Node _ret=null;
        originalGoal = n;

        MainClass f0 = (MainClass) n.f0.accept(this);
        NodeListOptional f1 = (NodeListOptional) n.f1.accept(this);
        _ret = new Goal(f0, f1);
        return _ret;
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
            // TODO: Make sure that it IS actually a method-local
            // variable. Else, it is a class variable, so,
            // currMethodName should actually be null.
            new FlowVar(this.currClassName, this.currMethodName,
                        getFormattedString(f0)),
            // TODO: Make sure that it IS actually a method-local
            // variable. Else, it is a class variable, so,
            // currMethodName should actually be null.
            new FlowVar(this.currClassName, this.currMethodName,
                        getFormattedString(f2)));
        propagationConstraints.add(currConstraint);
        return _ret;
    }

    /**
     * f0 -> Identifier()
     * f1 -> "."
     * f2 -> Identifier()
     * f3 -> "("
     * f4 -> ( ExpressionList() )?
     * f5 -> ")"
     * f6 -> ";"
     */
    @Override
    public Node visit(MessageSendStatement n) {
        Node _ret=null;
        Identifier f0 = (Identifier) n.f0.accept(this);
        Identifier f2 = (Identifier) n.f2.accept(this);
        NodeOptional f4 = (NodeOptional) n.f4.accept(this);
        _ret = new MessageSendStatement(f0, f2, f4);

        List<FlowVar> flowArgs = new ArrayList<FlowVar>();
        for (Expression expression : getSaneExpressionList(n.f4)){
            flowArgs.add(new FlowVar(this.currClassName,
                                     this.currMethodName,
                                     getFormattedString(expression)));
        }

        ConditionalVisitor conditionalVisitor = new ConditionalVisitor(
            new FlowVar(this.currClassName,
                        this.currMethodName,
                        getIdentifierName(f0)),
            getIdentifierName(f2),
            flowArgs);
        originalGoal.accept(conditionalVisitor);
        conditionalConstraints.addAll(conditionalVisitor.constraints);
        return _ret;
    }

}
