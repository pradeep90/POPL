 class NextedWhile {
public static void main ( String [ ] a ) {
new NWTest ( ) . ____Main____ ( new Continuation()  ) ; } }  class NWTest { int
   a ;   int  b ;   int  c ;   int  sum ; public void ____Main____ (
   Continuation  ___k ) { boolean  check ;  NWTest  nx ;  int  i ;  NWTest
   ___pseudoThis ;  ___ContinuationClasscontinuationMethod0  ___k1 ;
   ___pseudoThis = this;  nx = new NWTest();  a = 1;  i = 0;  c = 0;  b = 1000;
   check = true;  ___k1 = new ___ContinuationClasscontinuationMethod0();  ___k1
   .nx = nx;  ___k1.___k = ___k;  ___k1.object = this; ___pseudoThis.
   whileMethod4(check , nx , i , ___k1); }  public void continuationMethod0 (
   NWTest  nx , Continuation  ___k  ) { NWTest  ___pseudoThis ; ___pseudoThis =
   this;  System.out.println ( nx.sum ) ; ___k.call(); }  public void
   continuationMethod3 (boolean  check , NWTest  nx   , int  i   , Continuation
   ___k  ) { NWTest  ___pseudoThis ; ___pseudoThis = this; ___pseudoThis.
   whileMethod1(check , nx , i , ___k); }  public void continuationMethod2 (
   boolean  check , NWTest  nx   , int  i   , Continuation  ___k  ) { NWTest
   ___pseudoThis ;  ___ContinuationClasscontinuationMethod3  ___k1 ;
   ___pseudoThis = this; if ( 10 < c ) { check = false;  ___k1 = new
   ___ContinuationClasscontinuationMethod3();  ___k1.check = check;  ___k1.nx =
   nx;  ___k1.i = i;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call(); }
   else { System.out.println ( sum ) ;  ___k1 = new
   ___ContinuationClasscontinuationMethod3();  ___k1.check = check;  ___k1.nx =
   nx;  ___k1.i = i;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call(); }
   }  public void continuationMethod4 (boolean  check , NWTest  nx   , int  i
   , Continuation  ___k  ) { NWTest  ___pseudoThis ; ___pseudoThis = this;  c =
   c + 1; ___pseudoThis.whileMethod2(check , nx , i , ___k); }  public void
   whileMethod3 (boolean  check , NWTest  nx   , int  i   , Continuation  ___k
   ) { NWTest  ___pseudoThis ; ___pseudoThis = this; if ( i < 10 ) { nx.sum =
   nx.sum + 1;  i = i + 1; ___pseudoThis.whileMethod3(check , nx , i , ___k); }
   else { ___k.call(); }  }  public void whileMethod2 (boolean  check , NWTest
   nx   , int  i   , Continuation  ___k  ) { NWTest  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod4  ___k1 ; ___pseudoThis = this; if (
   (c < 10) & (4 < c)  ) { ___k1 = new ___ContinuationClasscontinuationMethod4(
   );  ___k1.check = check;  ___k1.nx = nx;  ___k1.i = i;  ___k1.___k = ___k;
   ___k1.object = this; ___pseudoThis.whileMethod3(check , nx , i , ___k1); }
   else { ___k.call(); }  }  public void continuationMethod1 (boolean  check ,
   NWTest  nx   , int  i   , Continuation  ___k  ) { NWTest  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod2  ___k1 ; ___pseudoThis = this;
   ___k1 = new ___ContinuationClasscontinuationMethod2();  ___k1.check = check;
   ___k1.nx = nx;  ___k1.i = i;  ___k1.___k = ___k;  ___k1.object = this;
   ___pseudoThis.whileMethod3(check , nx , i , ___k1); }  public void
   whileMethod4 (boolean  check , NWTest  nx   , int  i   , Continuation  ___k
   ) { NWTest  ___pseudoThis ; ___pseudoThis = this; if ( c < 5 ) { a = a * (a
   + 1);  sum = sum + 999;  c = c + 1; ___pseudoThis.whileMethod4(check , nx ,
   i , ___k); }  else { ___k.call(); }  }  public void whileMethod1 (boolean
   check , NWTest  nx   , int  i   , Continuation  ___k  ) { NWTest
   ___pseudoThis ;  ___ContinuationClasscontinuationMethod1  ___k1 ;
   ___pseudoThis = this; if ( (a < b) & check  ) { ___k1 = new
   ___ContinuationClasscontinuationMethod1();  ___k1.check = check;  ___k1.nx =
   nx;  ___k1.i = i;  ___k1.___k = ___k;  ___k1.object = this; ___pseudoThis.
   whileMethod4(check , nx , i , ___k1); }  else { ___k.call(); }  }}
class ___ContinuationClasscontinuationMethod0 extends Continuation { NWTest  nx
   ; Continuation  ___k ; NWTest  object ; public void call () { object.
   continuationMethod0(nx , ___k); }}
class ___ContinuationClasscontinuationMethod3 extends Continuation { boolean
   check ; NWTest  nx ; int  i ; Continuation  ___k ; NWTest  object ; public
   void call () { object.continuationMethod3(check , nx , i , ___k); }}
class ___ContinuationClasscontinuationMethod2 extends Continuation { boolean
   check ; NWTest  nx ; int  i ; Continuation  ___k ; NWTest  object ; public
   void call () { object.continuationMethod2(check , nx , i , ___k); }}
class ___ContinuationClasscontinuationMethod4 extends Continuation { boolean
   check ; NWTest  nx ; int  i ; Continuation  ___k ; NWTest  object ; public
   void call () { object.continuationMethod4(check , nx , i , ___k); }}
class ___ContinuationClasscontinuationMethod1 extends Continuation { boolean
   check ; NWTest  nx ; int  i ; Continuation  ___k ; NWTest  object ; public
   void call () { object.continuationMethod1(check , nx , i , ___k); }}
class Continuation { public void call () { }} 