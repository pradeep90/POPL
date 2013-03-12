/** 
 * Visitor for Triple Dispatch on (Type, Type, Operation).
 */
public abstract class TripleDVisitor {
    boolean result;
    
    public TripleDVisitor() {
        
    }

    public boolean runMultiMethod(Type type1, Type type2){
        type2.accept(this, type1);
        return result;
    }

    public void visit(IntType param1, IntType param2){}
    public void visit(IntType param1, BooleanType param2){}
    public void visit(IntType param1, FunctionType param2){}
    public void visit(IntType param1, UnknownType param2){}
    public void visit(BooleanType param1, IntType param2){}
    public void visit(BooleanType param1, BooleanType param2){}
    public void visit(BooleanType param1, FunctionType param2){}
    public void visit(BooleanType param1, UnknownType param2){}
    public void visit(FunctionType param1, IntType param2){}
    public void visit(FunctionType param1, BooleanType param2){}
    public void visit(FunctionType param1, FunctionType param2){}
    public void visit(FunctionType param1, UnknownType param2){}
    public void visit(UnknownType param1, IntType param2){}
    public void visit(UnknownType param1, BooleanType param2){}
    public void visit(UnknownType param1, FunctionType param2){}
    public void visit(UnknownType param1, UnknownType param2){}
    
}
