 class MethodReturn {
public static void main ( String [ ] a ) {
new MRTest ( ) . ____Main____ ( new Continuation()  ) ; } }  class MRTest { int
   b ;   int  a ;   boolean  z ;   MRTest  m1 ; public void ____Main____ (
   Continuation  ___k ) { int  x ;  ___ContinuationClasscontinuationMethod0
   ___k1 ; z = true;  m1 = new MRTest();  m1.a = 10;  m1.b = 20;  m1.z = true;
   x = m1.a + m1.b;  System.out.println ( x ) ;  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.x = x;  ___k1.___k = ___k;
   ___k1.object = this; m1.foo(x , ___k1); }  public void foo (int  y ,
   Continuation  ___k  ) { int  x ; x = y;  x = x + 5;  System.out.println ( x
   ) ;  a = 5; ___k.call(); }  public void bar (boolean  z1 , int  a1   , int
   b1   , Continuation  ___k  ) { boolean  z ;  int  a ;  int  b ; z = z1;  a =
   a1;  b = b1;  z = false;  a = b + a;  b = a * b; ___k.call(); }  public void
   continuationMethod1 (int  x , Continuation  ___k  ) { if ( z & m1.z  ) {
   System.out.println ( (m1.a + m1.b) ) ; ___k.call(); }  else {
   System.out.println ( 9999 ) ; ___k.call(); }  }  public void
   continuationMethod0 (int  x , Continuation  ___k  ) {
   ___ContinuationClasscontinuationMethod1  ___k1 ; System.out.println ( x ) ;
   System.out.println ( a ) ;  ___k1 = new
   ___ContinuationClasscontinuationMethod1();  ___k1.x = x;  ___k1.___k = ___k;
   ___k1.object = this; m1.bar(m1.z , m1.a , m1.b , ___k1); }}
class ___ContinuationClasscontinuationMethod1 extends Continuation { int  x ;
   Continuation  ___k ; MRTest  object ; public void call () { object.
   continuationMethod1(x , ___k); }}
class ___ContinuationClasscontinuationMethod0 extends Continuation { int  x ;
   Continuation  ___k ; MRTest  object ; public void call () { object.
   continuationMethod0(x , ___k); }}
class Continuation { public void call () { }} 