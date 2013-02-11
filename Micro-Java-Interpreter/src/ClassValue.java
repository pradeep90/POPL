import syntaxtree.*;

/** 
 * Class to represent a Class Value.
 *
 * i.e., the result of interpretation of a Class.
 */
public class ClassValue extends Value {
    TypeDeclaration typeDeclaration;
    ClassDeclaration classDeclaration;
    ClassExtendsDeclaration classExtendsDeclaration;
    Environment methodTable;
    
    public ClassValue(TypeDeclaration typeDeclaration, Environment methodTable) {
        this.typeDeclaration = typeDeclaration;
        this.methodTable = methodTable;
    }

    public ClassValue(ClassDeclaration classDeclaration, Environment methodTable) {
        this.classDeclaration = classDeclaration;
        this.methodTable = methodTable;
    }

    public ClassValue(ClassExtendsDeclaration classExtendsDeclaration,
                      Environment methodTable) {
        this.classExtendsDeclaration = classExtendsDeclaration;
        this.methodTable = methodTable;
    }

    public boolean equals(Object o) {
        if (o instanceof ClassValue) {
            ClassValue other = (ClassValue) o;
            String thisClass = MicroJavaHelper.getFormattedString(this.classDeclaration);
            String otherClass = MicroJavaHelper.getFormattedString(other.classDeclaration);
            return thisClass.equals(otherClass);
        }
        return false;
    }

    public boolean isFalse(){
        return false;
    }

}
