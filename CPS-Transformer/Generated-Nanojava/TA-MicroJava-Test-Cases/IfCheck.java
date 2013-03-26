 class IfCheck {
public static void main ( String [ ] a ) {
new ICTest ( ) . ____Main____ ( new Continuation()  ) ; } }  class ICTest { int
   a ;   int  b ; public void ____Main____ (Continuation  ___k ) { boolean
   check ;  ICTest  ___pseudoThis ;  ___ContinuationClasscontinuationMethod0
   ___k1 ; ___pseudoThis = this;  a = 1;  b = 100;  check = false; if ( ! (
   check) ) { a = a * (a + 1);  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.___k = ___k;  ___k1.object
   = this; ___k1.call(); }  else { a = b;  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.___k = ___k;  ___k1.object
   = this; ___k1.call(); }  }  public void continuationMethod1 (Continuation
   ___k ) { ICTest  ___pseudoThis ; ___pseudoThis = this;  System.out.println (
   a ) ; ___k.call(); }  public void continuationMethod0 (Continuation  ___k )
   { ICTest  ___pseudoThis ;  ___ContinuationClasscontinuationMethod1  ___k1 ;
   ___pseudoThis = this; if ( b < a ) { a = a + 999;  ___k1 = new
   ___ContinuationClasscontinuationMethod1();  ___k1.___k = ___k;  ___k1.object
   = this; ___k1.call(); }  else { a = a * (a + 1);  ___k1 = new
   ___ContinuationClasscontinuationMethod1();  ___k1.___k = ___k;  ___k1.object
   = this; ___k1.call(); }  }}
class ___ContinuationClasscontinuationMethod1 extends Continuation {
   Continuation  ___k ; ICTest  object ; public void call () { object.
   continuationMethod1(___k ); }}
class ___ContinuationClasscontinuationMethod0 extends Continuation {
   Continuation  ___k ; ICTest  object ; public void call () { object.
   continuationMethod0(___k ); }}
class Continuation { public void call () { }} 