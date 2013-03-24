 class NestedIfCheck {
public static void main ( String [ ] a ) {
new NICTest ( ) . ____Main____ ( new Continuation()  ) ; } }  class NICTest {
   int  a ;   int  b ; public void ____Main____ (Continuation  ___k ) { boolean
   check ;  ___ContinuationClasscontinuationMethod0  ___k1 ;
   ___ContinuationClasscontinuationMethod1  ___k2 ;
   ___ContinuationClasscontinuationMethod2  ___k3 ; a = 1;  b = 100;  check =
   false; if ( ! (check) ) { if ( b < a ) { a = a * 100;  ___k2 = new
   ___ContinuationClasscontinuationMethod1();  ___k2.___k = ___k;  ___k2.object
   = this; ___k2.call(); }  else { a = a * (a + 1); if ( a < b ) { a = a * (a +
   1);  ___k3 = new ___ContinuationClasscontinuationMethod2();  ___k3.___k =
   ___k;  ___k3.object = this; ___k3.call(); }  else { a = a + 999;  ___k3 =
   new ___ContinuationClasscontinuationMethod2();  ___k3.___k = ___k;  ___k3.
   object = this; ___k3.call(); }  }  }  else { a = b;  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.___k = ___k;  ___k1.object
   = this; ___k1.call(); }  }  public void continuationMethod0 (Continuation
   ___k ) { boolean  check ; System.out.println ( a ) ; ___k.call(); }  public
   void continuationMethod1 (Continuation  ___k ) { boolean  check ;
   ___ContinuationClasscontinuationMethod0  ___k1 ; a = a * (a + 1);  ___k1 =
   new ___ContinuationClasscontinuationMethod0();  ___k1.___k = ___k;  ___k1.
   object = this; ___k1.call(); }  public void continuationMethod2 (
   Continuation  ___k ) { boolean  check ;
   ___ContinuationClasscontinuationMethod1  ___k2 ; ___k2 = new
   ___ContinuationClasscontinuationMethod1();  ___k2.___k = ___k;  ___k2.object
   = this; ___k2.call(); }}
class ___ContinuationClasscontinuationMethod0 extends Continuation {
   Continuation  ___k ; NICTest  object ; public void call () { object.
   continuationMethod0(___k ); }}
class ___ContinuationClasscontinuationMethod1 extends Continuation {
   Continuation  ___k ; NICTest  object ; public void call () { object.
   continuationMethod1(___k ); }}
class ___ContinuationClasscontinuationMethod2 extends Continuation {
   Continuation  ___k ; NICTest  object ; public void call () { object.
   continuationMethod2(___k ); }}
class Continuation { public void call () { }} 