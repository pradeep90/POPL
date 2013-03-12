/** 
 * Visitor to take appropriate action on a pair of types which form a
 * TypeEquation.
 */
public class HandleEquationVisitor extends TripleDVisitor {
    Unifier unifier;
    
    public HandleEquationVisitor() {
    }

    public HandleEquationVisitor(Unifier unifier) {
        this.unifier = unifier;
    }

    @Override
    public void visit(IntType param1, IntType param2){
        // Do nothing
    }

    @Override
    public void visit(IntType param1, BooleanType param2){
        unifier.failure = true;
    }

    @Override
    public void visit(IntType param1, FunctionType param2){
        unifier.failure = true;
    }

    @Override
    public void visit(IntType param1, UnknownType param2){
        unifier.unification.updateAndExtend(param2.id + "", param1);
    }

    @Override
    public void visit(BooleanType param1, IntType param2){
        unifier.failure = true;
    }

    @Override
    public void visit(BooleanType param1, BooleanType param2){
        // Do nothing
    }

    @Override
    public void visit(BooleanType param1, FunctionType param2){
        unifier.failure = true;
    }

    @Override
    public void visit(BooleanType param1, UnknownType param2){
        unifier.unification.updateAndExtend(param2.id + "", param1);
    }

    @Override
    public void visit(FunctionType param1, IntType param2){
        unifier.failure = true;
    }

    @Override
    public void visit(FunctionType param1, BooleanType param2){
        unifier.failure = true;
    }

    @Override
    public void visit(FunctionType param1, FunctionType param2){
        unifier.equationSet.add(new TypeEquation(param1.paramType,
                                                 param2.paramType));
        unifier.equationSet.add(new TypeEquation(param1.returnType,
                                                 param2.returnType));
    }

    @Override
    public void visit(FunctionType param1, UnknownType param2){
        if (new OccursInVisitor().runMultiMethod(param1, param2)){
            unifier.failure = true;
            return;
        }

        unifier.unification.updateAndExtend(param2.id + "", param1);
    }

    @Override
    public void visit(UnknownType param1, IntType param2){
        visit(param2, param1);
    }

    @Override
    public void visit(UnknownType param1, BooleanType param2){
        visit(param2, param1);
    }

    @Override
    public void visit(UnknownType param1, FunctionType param2){
        visit(param2, param1);
    }

    @Override
    public void visit(UnknownType param1, UnknownType param2){
        if (param1.equals(param2)){
            return;
        }
            
        unifier.unification.updateAndExtend(param1.id + "", param2);
        unifier.unification.updateAndExtend(param2.id + "", param1);
    }
}
