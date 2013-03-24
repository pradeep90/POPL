import visitor.*;
import syntaxtree.*;

import java.util.Enumeration;
import java.util.List;
import java.util.ArrayList;

/** 
 * Class to represent the Operation of checking whether a Variable is
 * live in a given MicroJava node.
 *
 * A variable is live if its prior value is being used in the current node.
 */
public class LiveVariableFinder extends GJNoArguDepthFirst<Boolean> {
    String varName;

    Boolean isLive = false;

    public LiveVariableFinder(String varName) {
        this.varName = varName;
    }

   //
   // Auto class visitors--probably don't need to be overridden.
   //
   // public Boolean visit(NodeList n) {
   //    Boolean _ret=null;
   //    int _count=0;
   //    for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
   //       e.nextElement().accept(this);
   //       _count++;
   //    }
   //    return _ret;
   // }

   public Boolean visit(NodeListOptional n) {
      if ( n.present() ) {
         Boolean _ret = false;
         for (Node node : n.nodes){
             if (node.accept(this)){
                 _ret = true;
                 break;
             }
         }
         return _ret;
      }
      else
         return false;
   }

   public Boolean visit(NodeOptional n) {
      if ( n.present() )
         return n.node.accept(this);
      else
         return false;
   }

   // public Boolean visit(NodeSequence n) {
   //    Boolean _ret=null;
   //    int _count=0;
   //    for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
   //       e.nextElement().accept(this);
   //       _count++;
   //    }
   //    return _ret;
   // }

   // public Boolean visit(NodeToken n) { return null; }

   //
   // User-generated visitor methods below
   //

   // /**
   //  * f0 -> MainClass()
   //  * f1 -> ( TypeDeclaration() )*
   //  * f2 -> <EOF>
   //  */
   // public Boolean visit(Goal n) {
   //    Boolean _ret=null;
   //    n.f0.accept(this);
   //    n.f1.accept(this);
   //    n.f2.accept(this);
   //    return _ret;
   // }

   // /**
   //  * f0 -> "class"
   //  * f1 -> Identifier()
   //  * f2 -> "{"
   //  * f3 -> "public"
   //  * f4 -> "static"
   //  * f5 -> "void"
   //  * f6 -> "main"
   //  * f7 -> "("
   //  * f8 -> "String"
   //  * f9 -> "["
   //  * f10 -> "]"
   //  * f11 -> Identifier()
   //  * f12 -> ")"
   //  * f13 -> "{"
   //  * f14 -> "new"
   //  * f15 -> Identifier()
   //  * f16 -> "("
   //  * f17 -> ")"
   //  * f18 -> "."
   //  * f19 -> Identifier()
   //  * f20 -> "("
   //  * f21 -> ( ExpressionList() )?
   //  * f22 -> ")"
   //  * f23 -> ";"
   //  * f24 -> "}"
   //  * f25 -> "}"
   //  */
   // public Boolean visit(MainClass n) {
   //    Boolean _ret=null;
   //    n.f0.accept(this);
   //    n.f1.accept(this);
   //    n.f2.accept(this);
   //    n.f3.accept(this);
   //    n.f4.accept(this);
   //    n.f5.accept(this);
   //    n.f6.accept(this);
   //    n.f7.accept(this);
   //    n.f8.accept(this);
   //    n.f9.accept(this);
   //    n.f10.accept(this);
   //    n.f11.accept(this);
   //    n.f12.accept(this);
   //    n.f13.accept(this);
   //    n.f14.accept(this);
   //    n.f15.accept(this);
   //    n.f16.accept(this);
   //    n.f17.accept(this);
   //    n.f18.accept(this);
   //    n.f19.accept(this);
   //    n.f20.accept(this);
   //    n.f21.accept(this);
   //    n.f22.accept(this);
   //    n.f23.accept(this);
   //    n.f24.accept(this);
   //    n.f25.accept(this);
   //    return _ret;
   // }

   // /**
   //  * f0 -> ClassDeclaration()
   //  *       | ClassExtendsDeclaration()
   //  */
   // public Boolean visit(TypeDeclaration n) {
   //    Boolean _ret=null;
   //    n.f0.accept(this);
   //    return _ret;
   // }

   // /**
   //  * f0 -> "class"
   //  * f1 -> Identifier()
   //  * f2 -> "{"
   //  * f3 -> ( VarDeclaration() )*
   //  * f4 -> ( MethodDeclaration() )*
   //  * f5 -> "}"
   //  */
   // public Boolean visit(ClassDeclaration n) {
   //    Boolean _ret=null;
   //    n.f0.accept(this);
   //    n.f1.accept(this);
   //    n.f2.accept(this);
   //    n.f3.accept(this);
   //    n.f4.accept(this);
   //    n.f5.accept(this);
   //    return _ret;
   // }

   // /**
   //  * f0 -> "class"
   //  * f1 -> Identifier()
   //  * f2 -> "extends"
   //  * f3 -> Identifier()
   //  * f4 -> "{"
   //  * f5 -> ( VarDeclaration() )*
   //  * f6 -> ( MethodDeclaration() )*
   //  * f7 -> "}"
   //  */
   // public Boolean visit(ClassExtendsDeclaration n) {
   //    Boolean _ret=null;
   //    n.f0.accept(this);
   //    n.f1.accept(this);
   //    n.f2.accept(this);
   //    n.f3.accept(this);
   //    n.f4.accept(this);
   //    n.f5.accept(this);
   //    n.f6.accept(this);
   //    n.f7.accept(this);
   //    return _ret;
   // }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> ";"
    */
   public Boolean visit(VarDeclaration n) {
      Boolean _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   // /**
   //  * f0 -> "public"
   //  * f1 -> "void"
   //  * f2 -> Identifier()
   //  * f3 -> "("
   //  * f4 -> ( FormalParameterList() )?
   //  * f5 -> ")"
   //  * f6 -> "{"
   //  * f7 -> ( VarDeclaration() )*
   //  * f8 -> ( Statement() )*
   //  * f9 -> "}"
   //  */
   // public Boolean visit(MethodDeclaration n) {
   //    Boolean _ret=null;
   //    n.f0.accept(this);
   //    n.f1.accept(this);
   //    n.f2.accept(this);
   //    n.f3.accept(this);
   //    n.f4.accept(this);
   //    n.f5.accept(this);
   //    n.f6.accept(this);
   //    n.f7.accept(this);
   //    n.f8.accept(this);
   //    n.f9.accept(this);
   //    return _ret;
   // }

   // /**
   //  * f0 -> FormalParameter()
   //  * f1 -> ( FormalParameterRest() )*
   //  */
   // public Boolean visit(FormalParameterList n) {
   //    Boolean _ret=null;
   //    n.f0.accept(this);
   //    n.f1.accept(this);
   //    return _ret;
   // }

   // /**
   //  * f0 -> Type()
   //  * f1 -> Identifier()
   //  */
   // public Boolean visit(FormalParameter n) {
   //    Boolean _ret=null;
   //    n.f0.accept(this);
   //    n.f1.accept(this);
   //    return _ret;
   // }

   // /**
   //  * f0 -> ","
   //  * f1 -> FormalParameter()
   //  */
   // public Boolean visit(FormalParameterRest n) {
   //    Boolean _ret=null;
   //    n.f1.accept(this);
   //    return _ret;
   // }

   /**
    * f0 -> ArrayType()
    *       | BooleanType()
    *       | IntegerType()
    *       | Identifier()
    */
   public Boolean visit(Type n) {
      Boolean _ret=null;
      _ret = false;
      return _ret;
   }

   /**
    * f0 -> "int"
    * f1 -> "["
    * f2 -> "]"
    */
   public Boolean visit(ArrayType n) {
      Boolean _ret=null;
      _ret = false;
      return _ret;
   }

   /**
    * f0 -> "boolean"
    */
   public Boolean visit(BooleanType n) {
      Boolean _ret=null;
      _ret = false;
      return _ret;
   }

   /**
    * f0 -> "int"
    */
   public Boolean visit(IntegerType n) {
      Boolean _ret=null;
      _ret = false;
      return _ret;
   }

   /**
    * f0 -> Block()
    *       | AssignmentStatement()
    *       | ArrayAssignmentStatement()
    *       | IfStatement()
    *       | WhileStatement()
    *       | PrintStatement()
    *       | MessageSendStatement()
    */
   public Boolean visit(Statement n) {
      Boolean _ret=null;
      _ret = n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "{"
    * f1 -> ( Statement() )*
    * f2 -> "}"
    */
   public Boolean visit(Block n) {
      Boolean _ret=null;
      _ret = n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> VarRef()
    * f1 -> "="
    * f2 -> Expression()
    * f3 -> ";"
    */
   public Boolean visit(AssignmentStatement n) {
      Boolean _ret=null;
      if (n.f2.accept(this)){
          isLive = true;
          return true;
      }
      // VVIP:
      if (n.f0.accept(this)){
          isLive = false;
          return true;
      }
      _ret = false;
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "["
    * f2 -> Expression()
    * f3 -> "]"
    * f4 -> "="
    * f5 -> Expression()
    * f6 -> ";"
    */
   public Boolean visit(ArrayAssignmentStatement n) {
      Boolean _ret=null;
      Boolean f0 = n.f0.accept(this);
      Boolean f2 = n.f2.accept(this);
      Boolean f5 = n.f5.accept(this);
      _ret = f0 || f2 || f5;
      if (_ret){
          isLive = true;
      }
      return _ret;
   }

   /**
    * f0 -> "if"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    * f5 -> "else"
    * f6 -> Statement()
    */
   public Boolean visit(IfStatement n) {
      Boolean _ret=null;
      Boolean f2 = n.f2.accept(this);
      if (f2){
          isLive = true;
          return true;
      }

      _ret = n.f4.accept(this) || n.f6.accept(this);
      return _ret;
   }

   /**
    * f0 -> "while"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public Boolean visit(WhileStatement n) {
      Boolean _ret=null;
      Boolean f2 = n.f2.accept(this);

      if (f2){
          isLive = true;
          return true;
      }

      Boolean f4 = n.f4.accept(this);
      _ret = f4;
      return _ret;
   }

   /**
    * f0 -> "System.out.println"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> ";"
    */
   public Boolean visit(PrintStatement n) {
      Boolean _ret=null;
      _ret = n.f2.accept(this);
      if (_ret){
          isLive = true;
      }
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "."
    * f2 -> Identifier()
    * f3 -> "("
    * f4 -> ( ExpressionList() )?
    * f5 -> ")"
    * f6 -> ";"
    */
   public Boolean visit(MessageSendStatement n) {
      Boolean _ret=null;
      Boolean f0 = n.f0.accept(this);
      Boolean f4 = n.f4.accept(this);
      _ret = f0 || f4;
      if (_ret){
          isLive = true;
      }
      return _ret;
   }

   /**
    * f0 -> AndExpression()
    *       | CompareExpression()
    *       | PlusExpression()
    *       | MinusExpression()
    *       | TimesExpression()
    *       | ArrayLookup()
    *       | PrimaryExpression()
    */
   public Boolean visit(Expression n) {
      Boolean _ret=null;
      _ret = n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "&"
    * f2 -> PrimaryExpression()
    */
   public Boolean visit(AndExpression n) {
      Boolean _ret=null;
      Boolean f0 = n.f0.accept(this);
      Boolean f2 = n.f2.accept(this);
      _ret = f0 || f2;
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "<"
    * f2 -> PrimaryExpression()
    */
   public Boolean visit(CompareExpression n) {
      Boolean _ret=null;
      Boolean f0 = n.f0.accept(this);
      Boolean f2 = n.f2.accept(this);
      _ret = f0 || f2;
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "+"
    * f2 -> PrimaryExpression()
    */
   public Boolean visit(PlusExpression n) {
      Boolean _ret=null;
      Boolean f0 = n.f0.accept(this);
      Boolean f2 = n.f2.accept(this);
      _ret = f0 || f2;
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "-"
    * f2 -> PrimaryExpression()
    */
   public Boolean visit(MinusExpression n) {
      Boolean _ret=null;
      Boolean f0 = n.f0.accept(this);
      Boolean f2 = n.f2.accept(this);
      _ret = f0 || f2;
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "*"
    * f2 -> PrimaryExpression()
    */
   public Boolean visit(TimesExpression n) {
      Boolean _ret=null;
      Boolean f0 = n.f0.accept(this);
      Boolean f2 = n.f2.accept(this);
      _ret = f0 || f2;
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "["
    * f2 -> PrimaryExpression()
    * f3 -> "]"
    */
   public Boolean visit(ArrayLookup n) {
      Boolean _ret=null;
      Boolean f0 = n.f0.accept(this);
      Boolean f2 = n.f2.accept(this);
      _ret = f0 || f2;
      return _ret;
   }

   /**
    * f0 -> Expression()
    * f1 -> ( ExpressionRest() )*
    */
   public Boolean visit(ExpressionList n) {
      Boolean _ret=null;
      Boolean f0 = n.f0.accept(this);
      Boolean f1 = n.f1.accept(this);
      _ret = f0 || f1;
      return _ret;
   }

   /**
    * f0 -> ","
    * f1 -> Expression()
    */
   public Boolean visit(ExpressionRest n) {
      Boolean _ret=null;
      _ret = n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> IntegerLiteral()
    *       | TrueLiteral()
    *       | FalseLiteral()
    *       | VarRef()
    *       | ThisExpression()
    *       | ArrayAllocationExpression()
    *       | AllocationExpression()
    *       | NotExpression()
    *       | BracketExpression()
    */
   public Boolean visit(PrimaryExpression n) {
      Boolean _ret=null;
      _ret = n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> <INTEGER_LITERAL>
    */
   public Boolean visit(IntegerLiteral n) {
      Boolean _ret=null;
      // n.f0.accept(this);
      _ret = false;
      return _ret;
   }

   /**
    * f0 -> "true"
    */
   public Boolean visit(TrueLiteral n) {
      Boolean _ret=null;
      _ret = false;
      return _ret;
   }

   /**
    * f0 -> "false"
    */
   public Boolean visit(FalseLiteral n) {
      Boolean _ret=null;
      _ret = false;
      return _ret;
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public Boolean visit(Identifier n) {
      Boolean _ret=null;
      _ret = varName.equals(CPSHelper.getIdentifierName(n));
      return _ret;
   }

   /**
    * f0 -> "this"
    */
   public Boolean visit(ThisExpression n) {
      Boolean _ret=null;
      _ret = false;
      return _ret;
   }

   /**
    * f0 -> "new"
    * f1 -> "int"
    * f2 -> "["
    * f3 -> Expression()
    * f4 -> "]"
    */
   public Boolean visit(ArrayAllocationExpression n) {
      Boolean _ret=null;
      _ret = n.f3.accept(this);
      return _ret;
   }

   /**
    * f0 -> "new"
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> ")"
    */
   public Boolean visit(AllocationExpression n) {
      Boolean _ret=null;
      _ret = false;
      return _ret;
   }

   /**
    * f0 -> "!"
    * f1 -> Expression()
    */
   public Boolean visit(NotExpression n) {
      Boolean _ret=null;
      _ret = n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> "("
    * f1 -> Expression()
    * f2 -> ")"
    */
   public Boolean visit(BracketExpression n) {
      Boolean _ret=null;
      _ret = n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> DotExpression()
    *       | Identifier()
    */
   public Boolean visit(VarRef n) {
      Boolean _ret=null;
      _ret = n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "."
    * f2 -> Identifier()
    */
   public Boolean visit(DotExpression n) {
      Boolean _ret=null;
      // Only consider the object not the field name
      // i.e., foo.bar => foo is live
      _ret = n.f0.accept(this);
      return _ret;
   }
}
