 class NestedIfWhile {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0 , new Continuation() ) ; } }
   class ____NewMainClass____ { public void ____Main____ (int
   ____arg_length____ , Continuation  ___k  ) { int  ____printMe____ ;  int
   ___tmp5 ;  int  x ;  int  y ;  ____NewMainClass____  ___pseudoThis ;
   ___pseudoThis = this;  ____printMe____ = 5;  System.out.println (
   ____printMe____ ) ; ___k.call(); }  public void nestedIfWhile (int  a , int
   b   , Continuation  ___k  ) { int  x ;  int  y ;  ____NewMainClass____  foo
   ;  ____NewMainClass____  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod0  ___k1 ;
   ___ContinuationClasscontinuationMethod1  ___k2 ; ___pseudoThis = this;  foo
   = this;  x = 7; if ( 2 < x ) { if ( 1 < y ) { y = y - 1;  ___k2 = new
   ___ContinuationClasscontinuationMethod1();  ___k2.a = a;  ___k2.b = b;
   ___k2.foo = foo;  ___k2.___k = ___k;  ___k2.object = this; ___k2.call(); }
   else { y = y + 1;  ___k2 = new ___ContinuationClasscontinuationMethod1();
   ___k2.a = a;  ___k2.b = b;  ___k2.foo = foo;  ___k2.___k = ___k;  ___k2.
   object = this; ___k2.call(); }  }  else { x = 4;  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.a = a;  ___k1.b = b;
   ___k1.___k = ___k;  ___k1.object = this; ___k1.call(); }  }  public void
   continuationMethod0 (int  a , int  b   , Continuation  ___k  ) { int  x ;
   ____NewMainClass____  ___pseudoThis ; ___pseudoThis = this;  x = 3; ___k.
   call(); }  public void continuationMethod2 (int  a , int  b   ,
   ____NewMainClass____  foo   , Continuation  ___k  ) { ____NewMainClass____
   ___pseudoThis ;  ___ContinuationClasscontinuationMethod0  ___k1 ;
   ___pseudoThis = this;  ___k1 = new ___ContinuationClasscontinuationMethod0()
   ;  ___k1.a = a;  ___k1.b = b;  ___k1.___k = ___k;  ___k1.object = this;
   ___k1.call(); }  public void continuationMethod1 (int  a , int  b   ,
   ____NewMainClass____  foo   , Continuation  ___k  ) { ____NewMainClass____
   ___pseudoThis ;  ___ContinuationClasscontinuationMethod2  ___k1 ;
   ___pseudoThis = this;  ___k1 = new ___ContinuationClasscontinuationMethod2()
   ;  ___k1.a = a;  ___k1.b = b;  ___k1.foo = foo;  ___k1.___k = ___k;  ___k1.
   object = this; foo.nestedIfWhile(3 , 4 , ___k1); }}
class ___ContinuationClasscontinuationMethod0 extends Continuation { int  a ;
   int  b ; Continuation  ___k ; ____NewMainClass____  object ; public void
   call () { object.continuationMethod0(a , b , ___k); }}
class ___ContinuationClasscontinuationMethod2 extends Continuation { int  a ;
   int  b ; ____NewMainClass____  foo ; Continuation  ___k ;
   ____NewMainClass____  object ; public void call () { object.
   continuationMethod2(a , b , foo , ___k); }}
class ___ContinuationClasscontinuationMethod1 extends Continuation { int  a ;
   int  b ; ____NewMainClass____  foo ; Continuation  ___k ;
   ____NewMainClass____  object ; public void call () { object.
   continuationMethod1(a , b , foo , ___k); }}
class Continuation { public void call () { }} 