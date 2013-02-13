import syntaxtree.*;

/** 
 * Class to represent a Class Value.
 *
 * i.e., the result of interpretation of a Class.
 */
public class ClassValue extends Value {
    public String name;
    public String baseClassName;
    public NodeListOptional varDeclarations;
    public Environment methodTable;
    
    public ClassValue(ClassDeclaration classDeclaration) {
        this.name = MicroJavaHelper.getIdentifierName(classDeclaration.f1);
        this.varDeclarations = classDeclaration.f3;
        this.methodTable = getMethodTable(classDeclaration.f4);
    }

    public ClassValue(ClassExtendsDeclaration classExtendsDeclaration,
                      ClassValue baseClassValue) {
        this.name = MicroJavaHelper.getIdentifierName(classExtendsDeclaration.f1);
        this.baseClassName = baseClassValue.name;
        this.varDeclarations = MicroJavaHelper.concatenateNodeLists(
            baseClassValue.varDeclarations,
            classExtendsDeclaration.f5);

        Environment derivedClassMethodTable = getMethodTable(
            classExtendsDeclaration.f6);

        this.methodTable = new Environment(baseClassValue.methodTable);
        for (Binding binding : derivedClassMethodTable.bindingList){
            this.methodTable.extend(binding);
        }
    }

    public Environment getMethodTable(NodeListOptional methodDeclarations){
        Environment methodTable = new Environment();

        Interpreter tempInterpreter = new Interpreter();
        Environment tempEnv = new Environment();

        for (Node node : methodDeclarations.nodes){
            MethodDeclaration currMethodDeclaration = (MethodDeclaration) node;
            methodTable.extend(
                MicroJavaHelper.getIdentifierName(currMethodDeclaration.f2),
                currMethodDeclaration.accept(tempInterpreter, tempEnv));
        }
        return methodTable;
    }

    public boolean equals(Object o) {
        if (o instanceof ClassValue) {
            ClassValue other = (ClassValue) o;

            if (this.baseClassName == null && other.baseClassName != null){
                return false;
            }

            return name.equals(other.name) && methodTable.equals(other.methodTable);
        }
        return false;
    }

    public boolean isFalse(){
        return false;
    }

    public String toString(){
        String result = "";
        result += "name: " + name;
        result += "\n";
        result += "baseClassName: " + baseClassName;
        result += "\n";
        result += "varDeclarations: " + MicroJavaHelper.getFormattedString(varDeclarations);
        result += "\n";
        result += "methodTable: " + methodTable;
        result += "\n";
        return result;
    }
}
