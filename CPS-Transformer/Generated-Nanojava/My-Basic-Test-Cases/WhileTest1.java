 class WhileTest1 {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0 , new Continuation() ) ; } }
   class ____NewMainClass____ { public void ____Main____ (int
   ____arg_length____ , Continuation  ___k  ) { int  ____printMe____ ;  int
   ___tmp5 ;  ____NewMainClass____  ___pseudoThis ; ___pseudoThis = this;
   ____printMe____ = 5;  System.out.println ( ____printMe____ ) ; ___k.call();
   }  public void methodLiveVariables (int  a , int  b   , Continuation  ___k
   ) { int  x ;  int  y ;  int  z ;  ____NewMainClass____  ___pseudoThis ;
   ___pseudoThis = this;  x = 3;  y = 4;  z = 8; ___pseudoThis.whileMethod1(a ,
   b , y , ___k); }  public void nestedWhile (int  a , int  b   , Continuation
   ___k  ) { int  x ;  int  y ;  ____NewMainClass____  ___pseudoThis ;
   ___pseudoThis = this;  x = 7; ___pseudoThis.whileMethod3(a , b , x , ___k);
   }  public void continuationMethod0 (int  a , int  b   , int  y   ,
   Continuation  ___k  ) { int  x ;  int  z ;  ____NewMainClass____
   ___pseudoThis ; ___pseudoThis = this; ___pseudoThis.whileMethod1(a , b , y ,
   ___k); }  public void whileMethod1 (int  a , int  b   , int  y   ,
   Continuation  ___k  ) { int  x ;  int  z ;  ____NewMainClass____
   ___pseudoThis ;  ___ContinuationClasscontinuationMethod0  ___k1 ;
   ___pseudoThis = this; if ( y < 3 ) { a = b;  x = 7;  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.a = a;  ___k1.b = b;
   ___k1.y = y;  ___k1.___k = ___k;  ___k1.object = this; foo.bar(___k1 ); }
   else { ___k.call(); }  }  public void continuationMethod1 (int  a , int  b
   , int  x   , Continuation  ___k  ) { int  y ;  ____NewMainClass____
   ___pseudoThis ; ___pseudoThis = this;  x = x - 2; ___pseudoThis.whileMethod2
   (a , b , x , ___k); }  public void whileMethod3 (int  a , int  b   , int  x
   , int  y   , Continuation  ___k  ) { ____NewMainClass____  ___pseudoThis ;
   ___pseudoThis = this; if ( 1 < y ) { y = y - 1; ___pseudoThis.whileMethod3(a
   , b , x , y , ___k); }  else { ___k.call(); }  }  public void whileMethod2 (
   int  a , int  b   , int  x   , Continuation  ___k  ) { int  y ;
   ____NewMainClass____  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod1  ___k1 ; ___pseudoThis = this; if (
   2 < x ) { y = 3;  ___k1 = new ___ContinuationClasscontinuationMethod1();
   ___k1.a = a;  ___k1.b = b;  ___k1.x = x;  ___k1.___k = ___k;  ___k1.object =
   this; ___pseudoThis.whileMethod3(a , b , x , y , ___k1); }  else { ___k.call
   (); }  }}
class ___ContinuationClasscontinuationMethod0 extends Continuation { int  a ;
   int  b ; int  y ; Continuation  ___k ; ____NewMainClass____  object ; public
   void call () { object.continuationMethod0(a , b , y , ___k); }}
class ___ContinuationClasscontinuationMethod1 extends Continuation { int  a ;
   int  b ; int  x ; Continuation  ___k ; ____NewMainClass____  object ; public
   void call () { object.continuationMethod1(a , b , x , ___k); }}
class Continuation { public void call () { }} 