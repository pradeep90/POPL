/** 
 * Visitor to check whether an UnknownType in the pair of argument
 * types occurs in the other type.
 *
 * Note: The only cases for which we will make this check in the
 * Unification algorithm are:
 * + IntType, UnknownType
 * + BooleanType, UnknownType
 * + FunctionType, UnknownType
 * + UnknownType, UnknownType
 */
public class OccursInVisitor extends TripleDVisitor {
    public OccursInVisitor() {
        
    }
  
    @Override
    public void visit(IntType param1, UnknownType param2){
        result = false;
    }

    @Override
    public void visit(BooleanType param1, UnknownType param2){
        result = false;
    }

    @Override
    public void visit(FunctionType param1, UnknownType param2){
        result = runMultiMethod(param1.paramType, param2)
                || runMultiMethod(param1.returnType, param2);
    }

    @Override
    public void visit(UnknownType param1, IntType param2){
        result = false;
    }

    @Override
    public void visit(UnknownType param1, BooleanType param2){
        result = false;
    }

    @Override
    public void visit(UnknownType param1, FunctionType param2){
        visit(param2, param1);
    }

    @Override
    public void visit(UnknownType param1, UnknownType param2){
        if (param1.equals(param2)){
            result = true;
        } else {
            result = false;
        }
    }
}
