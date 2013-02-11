import syntaxtree.*;

/** 
 * Class to represent a Class Value.
 *
 * i.e., the result of interpretation of a Class.
 */
public class ClassValue extends Value {
    TypeDeclaration typeDeclaration;
    Environment methodTable;
    
    public ClassValue(TypeDeclaration typeDeclaration, Environment methodTable) {
        this.typeDeclaration = typeDeclaration;
        this.methodTable = methodTable;
    }

    public boolean equals(Object o) {
        if (o instanceof ClassValue) {
            ClassValue other = (ClassValue) o;
            if (typeDeclaration.f0.which == 0){
                return true;

                // TODO(spradeep): 
                // return MicroJavaHelper.getIdentifierName(
                //     ((ClassDeclaration) typeDeclaration.f0.choice).f1);
            }
        }
        return false;
    }

    public boolean isFalse(){
        return false;
    }

}
