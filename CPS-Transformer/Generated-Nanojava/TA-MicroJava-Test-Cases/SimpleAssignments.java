 class SimpleAssignments {
public static void main ( String [ ] a ) {
new SATest ( ) . ____Main____ ( new Continuation()  ) ; } }  class SATest { int
   b ;   boolean  y ; public void ____Main____ (Continuation  ___k ) { int  a ;
   boolean  x ;  boolean  z ;  SATest  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod0  ___k1 ; ___pseudoThis = this;  a =
   10;  b = 20;  a = a + b;  a = a * b;  a = a - b;  x = a < b;  y = true;  z =
   false;  z = y & x ; if ( z ) { a = a + b;  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.a = a;  ___k1.___k = ___k;
   ___k1.object = this; ___k1.call(); }  else { a = b;  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.a = a;  ___k1.___k = ___k;
   ___k1.object = this; ___k1.call(); }  }  public void continuationMethod0 (
   int  a , Continuation  ___k  ) { SATest  ___pseudoThis ; ___pseudoThis =
   this;  System.out.println ( a ) ; ___k.call(); }}
class ___ContinuationClasscontinuationMethod0 extends Continuation { int  a ;
   Continuation  ___k ; SATest  object ; public void call () { object.
   continuationMethod0(a , ___k); }}
class Continuation { public void call () { }} 