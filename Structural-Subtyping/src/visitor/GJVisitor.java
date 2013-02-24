//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * All GJ visitors must implement this interface.
 */

public interface GJVisitor<R,A> {

   //
   // GJ Auto class visitors
   //

   public R visit(NodeList n, A argu);
   public R visit(NodeListOptional n, A argu);
   public R visit(NodeOptional n, A argu);
   public R visit(NodeSequence n, A argu);
   public R visit(NodeToken n, A argu);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> ( Query() )*
    * f1 -> ( InterfaceDeclaration() )*
    * f2 -> <EOF>
    */
   public R visit(Goal n, A argu);

   /**
    * f0 -> Identifier()
    * f1 -> "<="
    * f2 -> Identifier()
    * f3 -> "?"
    */
   public R visit(Query n, A argu);

   /**
    * f0 -> "interface"
    * f1 -> Identifier()
    * f2 -> InterfaceBody()
    */
   public R visit(InterfaceDeclaration n, A argu);

   /**
    * f0 -> "{"
    * f1 -> ( InterfaceMember() )*
    * f2 -> "}"
    */
   public R visit(InterfaceBody n, A argu);

   /**
    * f0 -> ResultType()
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> Type()
    * f4 -> Identifier()
    * f5 -> ")"
    * f6 -> ";"
    */
   public R visit(InterfaceMember n, A argu);

   /**
    * f0 -> BooleanType()
    *       | IntegerType()
    *       | Identifier()
    */
   public R visit(Type n, A argu);

   /**
    * f0 -> "boolean"
    */
   public R visit(BooleanType n, A argu);

   /**
    * f0 -> "int"
    */
   public R visit(IntegerType n, A argu);

   /**
    * f0 -> VoidType()
    *       | Type()
    */
   public R visit(ResultType n, A argu);

   /**
    * f0 -> "void"
    */
   public R visit(VoidType n, A argu);

   /**
    * f0 -> <IDENTIFIER>
    */
   public R visit(Identifier n, A argu);

}
