import syntaxtree.*;

/** 
 * Class to represent a Class Value.
 *
 * i.e., the result of interpretation of a Class.
 */
public class ClassValue extends Value {
    String name;
    String baseClassName;
    NodeListOptional varDeclarations;
    Environment methodTable;
    
    public ClassValue(ClassDeclaration classDeclaration, Environment methodTable) {
        this.name = MicroJavaHelper.getIdentifierName(classDeclaration.f1);
        this.varDeclarations = classDeclaration.f3;
        this.methodTable = methodTable;
    }

    public ClassValue(ClassExtendsDeclaration classExtendsDeclaration,
                      Environment methodTable) {
        this.name = MicroJavaHelper.getIdentifierName(classExtendsDeclaration.f1);
        this.baseClassName = MicroJavaHelper.getIdentifierName(classExtendsDeclaration.f3);
        this.varDeclarations = classExtendsDeclaration.f5;
        this.methodTable = methodTable;
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
}
