import visitor.*;
import syntaxtree.*;

import java.util.Enumeration;

public class Transformer extends GJNoArguDepthFirst<nano.syntaxtree.Node> {
    
    public Transformer() {
        
    }

   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public nano.syntaxtree.Node visit(NodeList n) {
      nano.syntaxtree.Node _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this);
         _count++;
      }
      return _ret;
   }

   public nano.syntaxtree.Node visit(NodeListOptional n) {
      if ( n.present() ) {
         nano.syntaxtree.Node _ret=null;
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this);
            _count++;
         }
         return _ret;
      }
      else
         return null;
   }

   public nano.syntaxtree.Node visit(NodeOptional n) {
      if ( n.present() )
         return n.node.accept(this);
      else
         return null;
   }

   public nano.syntaxtree.Node visit(NodeSequence n) {
      nano.syntaxtree.Node _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this);
         _count++;
      }
      return _ret;
   }

   public nano.syntaxtree.Node visit(NodeToken n) {
       return new nano.syntaxtree.NodeToken(n.tokenImage);
   }

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> MainClass()
    * f1 -> ( TypeDeclaration() )*
    * f2 -> <EOF>
    */
   public nano.syntaxtree.Node visit(Goal n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> "class"
    * f1 -> Identifier()
    * f2 -> "{"
    * f3 -> "public"
    * f4 -> "static"
    * f5 -> "void"
    * f6 -> "main"
    * f7 -> "("
    * f8 -> "String"
    * f9 -> "["
    * f10 -> "]"
    * f11 -> Identifier()
    * f12 -> ")"
    * f13 -> "{"
    * f14 -> "new"
    * f15 -> Identifier()
    * f16 -> "("
    * f17 -> ")"
    * f18 -> "."
    * f19 -> Identifier()
    * f20 -> "("
    * f21 -> ( ExpressionList() )?
    * f22 -> ")"
    * f23 -> ";"
    * f24 -> "}"
    * f25 -> "}"
    */
   public nano.syntaxtree.Node visit(MainClass n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      n.f7.accept(this);
      n.f8.accept(this);
      n.f9.accept(this);
      n.f10.accept(this);
      n.f11.accept(this);
      n.f12.accept(this);
      n.f13.accept(this);
      n.f14.accept(this);
      n.f15.accept(this);
      n.f16.accept(this);
      n.f17.accept(this);
      n.f18.accept(this);
      n.f19.accept(this);
      n.f20.accept(this);
      n.f21.accept(this);
      n.f22.accept(this);
      n.f23.accept(this);
      n.f24.accept(this);
      n.f25.accept(this);
      return _ret;
   }

   /**
    * f0 -> ClassDeclaration()
    *       | ClassExtendsDeclaration()
    */
   public nano.syntaxtree.Node visit(TypeDeclaration n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "class"
    * f1 -> Identifier()
    * f2 -> "{"
    * f3 -> ( VarDeclaration() )*
    * f4 -> ( MethodDeclaration() )*
    * f5 -> "}"
    */
   public nano.syntaxtree.Node visit(ClassDeclaration n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      return _ret;
   }

   /**
    * f0 -> "class"
    * f1 -> Identifier()
    * f2 -> "extends"
    * f3 -> Identifier()
    * f4 -> "{"
    * f5 -> ( VarDeclaration() )*
    * f6 -> ( MethodDeclaration() )*
    * f7 -> "}"
    */
   public nano.syntaxtree.Node visit(ClassExtendsDeclaration n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      n.f7.accept(this);
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> ";"
    */
   public nano.syntaxtree.Node visit(VarDeclaration n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> "public"
    * f1 -> "void"
    * f2 -> Identifier()
    * f3 -> "("
    * f4 -> ( FormalParameterList() )?
    * f5 -> ")"
    * f6 -> "{"
    * f7 -> ( VarDeclaration() )*
    * f8 -> ( Statement() )*
    * f9 -> "}"
    */
   public nano.syntaxtree.Node visit(MethodDeclaration n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      n.f7.accept(this);
      n.f8.accept(this);
      n.f9.accept(this);
      return _ret;
   }

   /**
    * f0 -> FormalParameter()
    * f1 -> ( FormalParameterRest() )*
    */
   public nano.syntaxtree.Node visit(FormalParameterList n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    */
   public nano.syntaxtree.Node visit(FormalParameter n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> ","
    * f1 -> FormalParameter()
    */
   public nano.syntaxtree.Node visit(FormalParameterRest n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> ArrayType()
    *       | BooleanType()
    *       | IntegerType()
    *       | Identifier()
    */
   public nano.syntaxtree.Node visit(Type n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "int"
    * f1 -> "["
    * f2 -> "]"
    */
   public nano.syntaxtree.Node visit(ArrayType n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> "boolean"
    */
   public nano.syntaxtree.Node visit(BooleanType n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "int"
    */
   public nano.syntaxtree.Node visit(IntegerType n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
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
   public nano.syntaxtree.Node visit(Statement n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "{"
    * f1 -> ( Statement() )*
    * f2 -> "}"
    */
   public nano.syntaxtree.Node visit(Block n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> VarRef()
    * f1 -> "="
    * f2 -> Expression()
    * f3 -> ";"
    */
   public nano.syntaxtree.Node visit(AssignmentStatement n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
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
   public nano.syntaxtree.Node visit(ArrayAssignmentStatement n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
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
   public nano.syntaxtree.Node visit(IfStatement n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      return _ret;
   }

   /**
    * f0 -> "while"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public nano.syntaxtree.Node visit(WhileStatement n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      return _ret;
   }

   /**
    * f0 -> "System.out.println"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> ";"
    */
   public nano.syntaxtree.Node visit(PrintStatement n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
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
   public nano.syntaxtree.Node visit(MessageSendStatement n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
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
   public nano.syntaxtree.Node visit(Expression n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "&"
    * f2 -> PrimaryExpression()
    */
   public nano.syntaxtree.Node visit(AndExpression n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "<"
    * f2 -> PrimaryExpression()
    */
   public nano.syntaxtree.Node visit(CompareExpression n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "+"
    * f2 -> PrimaryExpression()
    */
   public nano.syntaxtree.Node visit(PlusExpression n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "-"
    * f2 -> PrimaryExpression()
    */
   public nano.syntaxtree.Node visit(MinusExpression n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "*"
    * f2 -> PrimaryExpression()
    */
   public nano.syntaxtree.Node visit(TimesExpression n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "["
    * f2 -> PrimaryExpression()
    * f3 -> "]"
    */
   public nano.syntaxtree.Node visit(ArrayLookup n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      return _ret;
   }

   /**
    * f0 -> Expression()
    * f1 -> ( ExpressionRest() )*
    */
   public nano.syntaxtree.Node visit(ExpressionList n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> ","
    * f1 -> Expression()
    */
   public nano.syntaxtree.Node visit(ExpressionRest n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
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
   public nano.syntaxtree.Node visit(PrimaryExpression n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> <INTEGER_LITERAL>
    */
   public nano.syntaxtree.Node visit(IntegerLiteral n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "true"
    */
   public nano.syntaxtree.Node visit(TrueLiteral n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "false"
    */
   public nano.syntaxtree.Node visit(FalseLiteral n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public nano.syntaxtree.Node visit(Identifier n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "this"
    */
   public nano.syntaxtree.Node visit(ThisExpression n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "new"
    * f1 -> "int"
    * f2 -> "["
    * f3 -> Expression()
    * f4 -> "]"
    */
   public nano.syntaxtree.Node visit(ArrayAllocationExpression n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      return _ret;
   }

   /**
    * f0 -> "new"
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> ")"
    */
   public nano.syntaxtree.Node visit(AllocationExpression n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      return _ret;
   }

   /**
    * f0 -> "!"
    * f1 -> Expression()
    */
   public nano.syntaxtree.Node visit(NotExpression n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> "("
    * f1 -> Expression()
    * f2 -> ")"
    */
   public nano.syntaxtree.Node visit(BracketExpression n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> DotExpression()
    *       | Identifier()
    */
   public nano.syntaxtree.Node visit(VarRef n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "."
    * f2 -> Identifier()
    */
   public nano.syntaxtree.Node visit(DotExpression n) {
      nano.syntaxtree.Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

}
