 class NextedWhile {
public static void main ( String [ ] a ) {
new NWTest ( ) . ____Main____ ( new Continuation()  ) ; } }  class NWTest { int
   a ;   int  b ;   int  c ;   int  sum ; public void ____Main____ (
   Continuation  ___k ) { boolean  check ;  NWTest  nx ;  int  i ;
   ___ContinuationClasscontinuationMethod0  ___k1 ;
   ___ContinuationClasscontinuationMethod1  ___k2 ; nx = new NWTest();  a = 1;
   i = 0;  c = 0;  b = 1000;  check = true;  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.nx = nx;  ___k1.___k =
   ___k;  ___k1.object = this; ___k1.call(); }  public void continuationMethod0
   (NWTest  nx , Continuation  ___k  ) { boolean  check ;  int  i ;
   System.out.println ( nx.sum ) ; ___k.call(); }  public void
   continuationMethod2 (NWTest  nx , int  i   , Continuation  ___k  ) { boolean
   check ; if ( 10 < c ) { check = false; ___k.call(); }  else {
   System.out.println ( sum ) ; ___k.call(); }  }  public void
   continuationMethod3 (NWTest  nx , int  i   , Continuation  ___k  ) { boolean
   check ; c = c + 1; ___k.call(); }  public void continuationMethod1 (NWTest
   nx , int  i   , Continuation  ___k  ) { boolean  check ;
   ___ContinuationClasscontinuationMethod2  ___k1 ;
   ___ContinuationClasscontinuationMethod3  ___k2 ; ___k1 = new
   ___ContinuationClasscontinuationMethod2();  ___k1.nx = nx;  ___k1.i = i;
   ___k1.___k = ___k;  ___k1.object = this; ___k1.call(); }}
class ___ContinuationClasscontinuationMethod0 extends Continuation { NWTest  nx
   ; Continuation  ___k ; NWTest  object ; public void call () { object.
   continuationMethod0(nx , ___k); }}
class ___ContinuationClasscontinuationMethod2 extends Continuation { NWTest  nx
   ; int  i ; Continuation  ___k ; NWTest  object ; public void call () {
   object.continuationMethod2(nx , i , ___k); }}
class ___ContinuationClasscontinuationMethod3 extends Continuation { NWTest  nx
   ; int  i ; Continuation  ___k ; NWTest  object ; public void call () {
   object.continuationMethod3(nx , i , ___k); }}
class ___ContinuationClasscontinuationMethod1 extends Continuation { NWTest  nx
   ; int  i ; Continuation  ___k ; NWTest  object ; public void call () {
   object.continuationMethod1(nx , i , ___k); }}
class Continuation { public void call () { }} 