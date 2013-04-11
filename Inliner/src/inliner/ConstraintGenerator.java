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

    Goal originalParseTree;
    
    public ConstraintGenerator() {
        beginningConstraints = new HashSet<BeginningConstraint>();
        propagationConstraints = new HashSet<PropagationConstraint>();
        conditionalConstraints = new HashSet<ConditionalConstraint>();
    }

    public void addBeginningConstraint(String className, String expressionString){
        BeginningConstraint currConstraint = new BeginningConstraint(
            className,
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
        originalParseTree = n;
        return super.visit(n);
    }

    /**
     * f0 -> "this"
     */
    @Override
    public Node visit(ThisExpression n) {
        addBeginningConstraint(this.currClassName, "this");
        return super.visit(n);
    }

    /**
     * f0 -> "new"
     * f1 -> Identifier()
     * f2 -> "("
     * f3 -> ")"
     */
    @Override
    public Node visit(AllocationExpression n) {
        addBeginningConstraint(getIdentifierName(n.f1), getFormattedString(n));
        return super.visit(n);
    }

    /**
     * f0 -> VarRef()
     * f1 -> "="
     * f2 -> Expression()
     * f3 -> ";"
     */
    @Override
    public Node visit(AssignmentStatement n) {
        PropagationConstraint currConstraint = new PropagationConstraint(
            // TODO: Make sure that it IS actually a method-local
            // variable. Else, it is a class variable, so,
            // currMethodName should actually be null.
            new FlowVar(this.currClassName, this.currMethodName,
                        getFormattedString(n.f2)),
            // TODO: Make sure that it IS actually a method-local
            // variable. Else, it is a class variable, so,
            // currMethodName should actually be null.
            new FlowVar(this.currClassName, this.currMethodName,
                        getFormattedString(n.f0)));
        propagationConstraints.add(currConstraint);

        return super.visit(n);
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
        ConditionalVisitor conditionalVisitor = new ConditionalVisitor(
            new FlowVar(this.currClassName,
                        this.currMethodName,
                        getIdentifierName(n.f0)),
            getIdentifierName(n.f2),
            getFlowArgs(getSaneExpressionList(n.f4)));

        originalParseTree.accept(conditionalVisitor);
        conditionalConstraints.addAll(conditionalVisitor.constraints);

        return super.visit(n);
    }

    /** 
     * @return a FlowVar for each Expression in arguments.
     */
    public List<FlowVar> getFlowArgs(List<Expression> arguments){
        List<FlowVar> flowArgs = new ArrayList<FlowVar>();
        for (Expression expression : arguments){
            flowArgs.add(new FlowVar(this.currClassName,
                                     this.currMethodName,
                                     getFormattedString(expression)));
        }
        return flowArgs;
    }

}
