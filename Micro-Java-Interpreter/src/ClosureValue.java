import syntaxtree.*;
import java.util.*;

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
     * Run this closure with thisValue and given args.
     * 
     * @param thisValue instance on which to run the closure
     * @param objEnv environment of the instance on which this
     * method is being run
     * @param argExpressionList args for the method
     */
    public void runClosure(Interpreter interpreter,
                           ObjectValue thisValue,
                           Environment objEnv,
                           List<Value> args){
        
        // Note: I'm making a new env here cos the same ClosureValue
        // is seen by all ObjectValues. We don't the same env to be
        // shared by all of them.
        Environment env = new Environment(objEnv);

        ObjectValue oldThisValue = interpreter.thisValue;
        interpreter.thisValue = thisValue;

        // Formal Parameters
        interpreter.visit(method.f4, env);

        if (method.f4.present()){
            List<Identifier> paramList = Interpreter.formalParameterListToValues(
                (FormalParameterList) method.f4.node);

            for (int i = 0; i < paramList.size(); i++){
                env.lookup(paramList.get(i)).setValue(args.get(i));
            }
        }

        // Variable Declarations
        interpreter.visit(method.f7, env);

        // Statements
        interpreter.visit(method.f8, env);

        interpreter.thisValue = oldThisValue;
    }
}
