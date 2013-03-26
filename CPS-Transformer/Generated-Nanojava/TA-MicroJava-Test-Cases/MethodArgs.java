 class MethodArgs {
public static void main ( String [ ] a ) {
new MATest ( ) . ____Main____ ( new Continuation()  ) ; } }  class MATest {
   MATest  m1 ;   int [ ]   crr ; public void ____Main____ (Continuation  ___k
   ) { MATest  mx ;  MATest  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod0  ___k1 ; ___pseudoThis = this;  m1 =
   new MATest();  mx = new MATest();  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.mx = mx;  ___k1.___k =
   ___k;  ___k1.object = this; m1.foo(12 , ___k1); }  public void foo (int  x ,
   Continuation  ___k  ) { int  z ;  MATest  ___pseudoThis ; ___pseudoThis =
   this;  z = x + 5;  System.out.println ( z ) ; ___k.call(); }  public void
   bar (boolean  x , Continuation  ___k  ) { MATest  ___pseudoThis ;
   ___pseudoThis = this; if ( x ) { m1 = new MATest(); m1.foo(10 , ___k); }
   else { m1.bar(false , ___k); }  }  public void fooBar (MATest  ml ,
   Continuation  ___k  ) { MATest  ___pseudoThis ; ___pseudoThis = this; ml.bar
   (true , ___k); }  public void BarFoo (int [ ]   crr , Continuation  ___k  )
   { int [ ]   arr ;  MATest  ___pseudoThis ; ___pseudoThis = this;  arr = crr;
   arr[9] = 5;  System.out.println ( arr [ 9 ] ) ; ___k.call(); }  public void
   complete (boolean  z , int  a   , int [ ]   brr   , MATest  ml   ,
   Continuation  ___k  ) { int [ ]   crr ;  MATest  ___pseudoThis ;
   ___pseudoThis = this; if ( z ) { crr = brr; ml.BarFoo(crr , ___k); }  else {
   crr = brr;  crr[5] = ((crr [ 6 ]) + a); ml.bar(false , ___k); }  }  public
   void continuationMethod2 (MATest  mx , Continuation  ___k  ) { MATest
   ___pseudoThis ; ___pseudoThis = this;  crr = new int[10]; m1.complete(true ,
   10 , crr , mx , ___k); }  public void continuationMethod1 (MATest  mx ,
   Continuation  ___k  ) { MATest  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod2  ___k1 ; ___pseudoThis = this;
   ___k1 = new ___ContinuationClasscontinuationMethod2();  ___k1.mx = mx;
   ___k1.___k = ___k;  ___k1.object = this; m1.fooBar(mx , ___k1); }  public
   void continuationMethod0 (MATest  mx , Continuation  ___k  ) { MATest
   ___pseudoThis ;  ___ContinuationClasscontinuationMethod1  ___k1 ;
   ___pseudoThis = this;  ___k1 = new ___ContinuationClasscontinuationMethod1()
   ;  ___k1.mx = mx;  ___k1.___k = ___k;  ___k1.object = this; m1.bar(true ,
   ___k1); }}
class ___ContinuationClasscontinuationMethod2 extends Continuation { MATest  mx
   ; Continuation  ___k ; MATest  object ; public void call () { object.
   continuationMethod2(mx , ___k); }}
class ___ContinuationClasscontinuationMethod1 extends Continuation { MATest  mx
   ; Continuation  ___k ; MATest  object ; public void call () { object.
   continuationMethod1(mx , ___k); }}
class ___ContinuationClasscontinuationMethod0 extends Continuation { MATest  mx
   ; Continuation  ___k ; MATest  object ; public void call () { object.
   continuationMethod0(mx , ___k); }}
class Continuation { public void call () { }} 