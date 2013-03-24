 class ComplexAssignments {
public static void main ( String [ ] a ) {
new CATest ( ) . ____Main____ ( new Continuation()  ) ; } }  class CATest { int
   b ;   int [ ]   arr ; public void ____Main____ (Continuation  ___k ) { int
   a ;  int  x ;  ___ContinuationClasscontinuationMethod0  ___k1 ; a = 10;  b =
   20;  arr = new int[((a * b) + (b - a))];  System.out.println ( arr.length )
   ;  x = arr.length - 1;  System.out.println ( arr [ x ] ) ;  arr[2] = (((a +
   b) * (b)));  arr[0] = ((arr [ 2 ]) + ((arr [ 2 ]) + (a * b))); if ( ((arr [
   0 ]) < (arr [ 2 ])) ) { arr[3] = ((arr [ 0 ]) - 3);  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.___k = ___k;  ___k1.object
   = this; ___k1.call(); }  else { arr[3] = 5;  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.___k = ___k;  ___k1.object
   = this; ___k1.call(); }  }  public void continuationMethod0 (Continuation
   ___k ) { int  a ;  int  x ; System.out.println ( arr [ 3 ] ) ; ___k.call();
   }}
class ___ContinuationClasscontinuationMethod0 extends Continuation {
   Continuation  ___k ; CATest  object ; public void call () { object.
   continuationMethod0(___k ); }}
class Continuation { public void call () { }} 