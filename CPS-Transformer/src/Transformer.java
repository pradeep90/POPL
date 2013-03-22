import visitor.*;
import nano.syntaxtree.*;

import java.util.Enumeration;

public class Transformer extends GJNoArguDepthFirst<Node> {
    
    public Transformer() {
        
    }

   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public Node visit(syntaxtree.NodeList n) {
      Node _ret=null;
      int _count=0;
      for ( Enumeration<syntaxtree.Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this);
         _count++;
      }
      return _ret;
   }

   public Node visit(syntaxtree.NodeListOptional n) {
      if ( n.present() ) {
         Node _ret=null;
         int _count=0;
         for ( Enumeration<syntaxtree.Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this);
            _count++;
         }
         return _ret;
      }
      else
         return null;
   }

   public Node visit(syntaxtree.NodeOptional n) {
      if ( n.present() )
         return n.node.accept(this);
      else
         return null;
   }

   public Node visit(syntaxtree.NodeSequence n) {
      Node _ret=null;
      int _count=0;
      for ( Enumeration<syntaxtree.Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this);
         _count++;
      }
      return _ret;
   }

   public Node visit(syntaxtree.NodeToken n) {
       return new NodeToken(n.tokenImage);
   }

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> MainClass()
    * f1 -> ( TypeDeclaration() )*
    * f2 -> <EOF>
    */
   public Node visit(syntaxtree.Goal n) {
      Node _ret=null;
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
   public Node visit(syntaxtree.MainClass n) {
      Node _ret=null;
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
   public Node visit(syntaxtree.TypeDeclaration n) {
      Node _ret=null;
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
   public Node visit(syntaxtree.ClassDeclaration n) {
      Node _ret=null;
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
   public Node visit(syntaxtree.ClassExtendsDeclaration n) {
      Node _ret=null;
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
   public Node visit(syntaxtree.VarDeclaration n) {
      Node _ret=null;
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
   public Node visit(syntaxtree.MethodDeclaration n) {
      Node _ret=null;
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
   public Node visit(syntaxtree.FormalParameterList n) {
      Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    */
   public Node visit(syntaxtree.FormalParameter n) {
      Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> ","
    * f1 -> FormalParameter()
    */
   public Node visit(syntaxtree.FormalParameterRest n) {
      Node _ret=null;
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
   public Node visit(syntaxtree.Type n) {
      Node _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "int"
    * f1 -> "["
    * f2 -> "]"
    */
   public Node visit(syntaxtree.ArrayType n) {
      Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> "boolean"
    */
   public Node visit(syntaxtree.BooleanType n) {
      Node _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "int"
    */
   public Node visit(syntaxtree.IntegerType n) {
      Node _ret=null;
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
   public Node visit(syntaxtree.Statement n) {
      Node _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "{"
    * f1 -> ( Statement() )*
    * f2 -> "}"
    */
   public Node visit(syntaxtree.Block n) {
      Node _ret=null;
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
   public Node visit(syntaxtree.AssignmentStatement n) {
      Node _ret=null;
      VarRef f0 = (VarRef) n.f0.accept(this);
      Expression f2 = (Expression) n.f2.accept(this);
      _ret = new AssignmentStatement(f0, f2);
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
   public Node visit(syntaxtree.ArrayAssignmentStatement n) {
      Node _ret=null;
      Identifier f0 = (Identifier) n.f0.accept(this);
      Expression f2 = (Expression) n.f2.accept(this);
      Expression f5 = (Expression) n.f5.accept(this);
      _ret = new ArrayAssignmentStatement(f0, f2, f5);
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
   public Node visit(syntaxtree.IfStatement n) {
      Node _ret=null;
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
   public Node visit(syntaxtree.WhileStatement n) {
      Node _ret=null;
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
   public Node visit(syntaxtree.PrintStatement n) {
      Node _ret=null;
      Expression f2 = (Expression) n.f2.accept(this);
      _ret = new PrintStatement(f2);
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
   public Node visit(syntaxtree.MessageSendStatement n) {
      Node _ret=null;
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
   public Node visit(syntaxtree.Expression n) {
      Node _ret=null;
      Node f0 = n.f0.accept(this);
      _ret = new Expression(new NodeChoice(f0, n.f0.which));
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "&"
    * f2 -> PrimaryExpression()
    */
   public Node visit(syntaxtree.AndExpression n) {
      Node _ret=null;
      PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this);
      PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this);
      _ret = new AndExpression(f0, f2);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "<"
    * f2 -> PrimaryExpression()
    */
   public Node visit(syntaxtree.CompareExpression n) {
      Node _ret=null;
      PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this);
      PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this);
      _ret = new CompareExpression(f0, f2);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "+"
    * f2 -> PrimaryExpression()
    */
   public Node visit(syntaxtree.PlusExpression n) {
      Node _ret=null;
      PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this);
      PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this);
      _ret = new PlusExpression(f0, f2);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "-"
    * f2 -> PrimaryExpression()
    */
   public Node visit(syntaxtree.MinusExpression n) {
      Node _ret=null;
      PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this);
      PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this);
      _ret = new MinusExpression(f0, f2);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "*"
    * f2 -> PrimaryExpression()
    */
   public Node visit(syntaxtree.TimesExpression n) {
      Node _ret=null;
      PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this);
      PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this);
      _ret = new TimesExpression(f0, f2);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "["
    * f2 -> PrimaryExpression()
    * f3 -> "]"
    */
   public Node visit(syntaxtree.ArrayLookup n) {
      Node _ret=null;
      PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this);
      PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this);
      _ret = new ArrayLookup(f0, f2);
      return _ret;
   }

   /**
    * f0 -> Expression()
    * f1 -> ( ExpressionRest() )*
    */
   public Node visit(syntaxtree.ExpressionList n) {
      Node _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> ","
    * f1 -> Expression()
    */
   public Node visit(syntaxtree.ExpressionRest n) {
      Node _ret=null;
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
   public Node visit(syntaxtree.PrimaryExpression n) {
      Node _ret=null;
      Node f0 = n.f0.accept(this);
      _ret = new PrimaryExpression(new NodeChoice(f0, n.f0.which));
      return _ret;
   }

   /**
    * f0 -> <INTEGER_LITERAL>
    */
   public Node visit(syntaxtree.IntegerLiteral n) {
      Node _ret=null;
      NodeToken f0 = (NodeToken) n.f0.accept(this);
      _ret = new IntegerLiteral(f0);
      return _ret;
   }

   /**
    * f0 -> "true"
    */
   public Node visit(syntaxtree.TrueLiteral n) {
      Node _ret=null;
      // n.f0.accept(this);
      _ret = new TrueLiteral();
      return _ret;
   }

   /**
    * f0 -> "false"
    */
   public Node visit(syntaxtree.FalseLiteral n) {
      Node _ret=null;
      // n.f0.accept(this);
      _ret = new FalseLiteral();
      return _ret;
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public Node visit(syntaxtree.Identifier n) {
      Node _ret=null;
      _ret = CPSHelper.getNewIdentifier(CPSHelper.getMicroIdentifierName(n));
      return _ret;
   }

   /**
    * f0 -> "this"
    */
   public Node visit(syntaxtree.ThisExpression n) {
      Node _ret=null;
      _ret = new ThisExpression();
      return _ret;
   }

   /**
    * f0 -> "new"
    * f1 -> "int"
    * f2 -> "["
    * f3 -> Expression()
    * f4 -> "]"
    */
   public Node visit(syntaxtree.ArrayAllocationExpression n) {
      Node _ret=null;
      Expression f3 = (Expression) n.f3.accept(this);
      _ret = new ArrayAllocationExpression(f3);
      return _ret;
   }

   /**
    * f0 -> "new"
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> ")"
    */
   public Node visit(syntaxtree.AllocationExpression n) {
      Node _ret=null;
      Identifier f1 = (Identifier) n.f1.accept(this);
      _ret = new AllocationExpression(f1);
      return _ret;
   }

   /**
    * f0 -> "!"
    * f1 -> Expression()
    */
   public Node visit(syntaxtree.NotExpression n) {
      Node _ret=null;
      Expression f1 = (Expression) n.f1.accept(this);
      _ret = new NotExpression(f1);
      return _ret;
   }

   /**
    * f0 -> "("
    * f1 -> Expression()
    * f2 -> ")"
    */
   public Node visit(syntaxtree.BracketExpression n) {
      Node _ret=null;
      Expression f1 = (Expression) n.f1.accept(this);
      _ret = new BracketExpression(f1);
      return _ret;
   }

   /**
    * f0 -> DotExpression()
    *       | Identifier()
    */
   public Node visit(syntaxtree.VarRef n) {
      Node _ret=null;
      Node f0 = n.f0.accept(this);
      _ret = new VarRef(new NodeChoice(f0, n.f0.which));
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "."
    * f2 -> Identifier()
    */
   public Node visit(syntaxtree.DotExpression n) {
      Node _ret=null;
      Identifier f0 = (Identifier) n.f0.accept(this);
      Identifier f2 = (Identifier) n.f2.accept(this);
      _ret = new DotExpression(f0, f2);
      return _ret;
   }
}
