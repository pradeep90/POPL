import syntaxtree.*;

/** 
 * Class to represent a Closure.
 */
public class ClosureValue extends Value {
    Environment env;
    Identifier thisIdentifier;
    MethodDeclaration method;
    
    public ClosureValue(Environment env,
                        MethodDeclaration method) {

        this.env = env;
        this.method = method;
    }

    public ClosureValue(MethodDeclaration method) {
        this.method = method;
    }

    // TODO(spradeep): 
    @Override
    public boolean equals(Object o) {
        if (o instanceof ClosureValue) {
            ClosureValue other = (ClosureValue) o;
            boolean isEqual;

            if (this.env == null && other.env == null){
                return true;
            }

            if (this.env.equals(other.env)
                && MicroJavaHelper.getFormattedString(method).equals(
                    MicroJavaHelper.getFormattedString(other.method))){

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isFalse(){
        return method == null;
    }

    @Override
    public void setValue(Value value){
        ClosureValue closureValue = (ClosureValue) value;

        // TODO(spradeep): Should I make a deep copy here???
        
        this.env = closureValue.env;
        this.thisIdentifier = closureValue.thisIdentifier;
        this.method = closureValue.method;
    }

    @Override
    public String toString(){
        String result = "";
        result += "env: " + env;
        result += ", ";
        result += "method: " + MicroJavaHelper.getFormattedString(method);
        return result;
    }

    /** 
     * Run this closure with thisIdentifier and given args.
     * 
     * @param thisIdentifier instance on which to run the closure
     * @param objEnv environment of the instance on which this
     * method is being run
     * @param argList args for the method
     */
    public void runClosure(Interpreter interpreter,
                           Identifier thisIdentifier,
                           Environment objEnv,
                           NodeOptional argList){
        
        // TODO(spradeep): Test runClosure

        Environment env = new Environment(objEnv);

        interpreter.thisIdentifier = thisIdentifier;

        // Formal Parameters
        interpreter.visit(method.f4, env);

        // TODO(spradeep): Interpret argList here

        // Variable Declarations
        interpreter.visit(method.f7, env);

        // Statements
        interpreter.visit(method.f8, env);
    }
}
