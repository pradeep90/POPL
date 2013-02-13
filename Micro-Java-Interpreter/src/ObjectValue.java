import syntaxtree.*;
import java.util.*;

public class ObjectValue extends Value{
    public Environment env;
    public ClassValue classValue;
    
    public ObjectValue(ClassValue classValue) {
        this.classValue = classValue;
        this.env = new Environment();

        Interpreter tempInterpreter = new Interpreter();
        tempInterpreter.visit(this.classValue.varDeclarations, this.env);
    }

    public ObjectValue(){
        this.env = new Environment();
    }

    /** 
     * Run methodIdentifier method with args.
     */
    public void runMethod(Identifier methodIdentifier, List<Value> args,
                          Interpreter interpreter){
        ClosureValue methodClosure = (ClosureValue) classValue.methodTable.lookup(methodIdentifier);
        methodClosure.runClosure(interpreter, this, this.env, args);
    }

    @Override
    public Value getFieldValue(Identifier field){
        return env.lookup(field);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ObjectValue) {
            ObjectValue other = (ObjectValue) o;
            if (this.classValue == null && other.classValue == null){
                return true;
            }
            else if(this.classValue == null || other.classValue == null){
                return false;
            }
            return this.env.equals(other.env)
                    && this.classValue.equals(other.classValue);
        }
        return false;
    }

    @Override
    public boolean isFalse(){
        return env == null && classValue == null;
    }

    @Override
    public void setValue(Value value){
        ObjectValue otherObjectValue = (ObjectValue) value;
        this.env = otherObjectValue.env;

        // This is where you'd do type-checking, if needed.
        this.classValue = otherObjectValue.classValue;
    }

    public String toString(){
        String result = "";
        result += "env: " + env;
        result += "\n";
        result += "classValue: " + classValue;
        result += "\n";
        return result;
    }
}
