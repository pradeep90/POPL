package inliner;

import inliner.syntaxtree.*;
import inliner.visitor.*;

import static inliner.InlinerHelper.getFormattedString;

/** 
 * Class to collect a flow variable for every expression in the given
 * Microjava parse tree.
 */
public class FlowVariableCollector extends IdentityVisitor {
    
    
    public FlowVariableCollector() {
    }

    /**
     * f0 -> AndExpression()
     *       | CompareExpression()
     *       | PlusExpression()
     *       | MinusExpression()
     *       | TimesExpression()
     *       | ArrayLookup()
     *       | PrimaryExpression()
     */
    @Override
    public Node visit(Expression n) {
        Node _ret=null;
        _ret = new Expression(new NodeChoice(n.f0.accept(this), n.f0.which));
        return _ret;
    }
}
