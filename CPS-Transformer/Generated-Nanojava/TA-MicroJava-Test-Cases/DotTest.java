 class DotTest {
public static void main ( String [ ] a ) {
new DTTest ( ) . ____Main____ ( new Continuation()  ) ; } }  class DTTest { int
   a ;   int  b ;   boolean  flag ;   DTTest  dt1 ;   int [ ]   arr ; public
   void ____Main____ (Continuation  ___k ) { DTTest  obj ;  FooClass  fc ;
   ___ContinuationClasscontinuationMethod0  ___k1 ; dt1 = new DTTest();  dt1.b
   = 10;  dt1.a = dt1.b + dt1.b;  fc = new FooClass();  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.fc = fc;  ___k1.___k =
   ___k;  ___k1.object = this; fc.foo(dt1.a , ___k1); }  public void
   continuationMethod3 (FooClass  fc , DTTest  obj   , Continuation  ___k  ) {
   arr = new int[20];  arr[0] = dt1.b; fc.fbar(arr , ___k); }  public void
   continuationMethod2 (FooClass  fc , DTTest  obj   , Continuation  ___k  ) {
   ___ContinuationClasscontinuationMethod3  ___k1 ; obj.flag = ! (obj.flag);
   ___k1 = new ___ContinuationClasscontinuationMethod3();  ___k1.fc = fc;
   ___k1.obj = obj;  ___k1.___k = ___k;  ___k1.object = this; fc.bar(obj.flag ,
   dt1.a , ___k1); }  public void continuationMethod1 (FooClass  fc ,
   Continuation  ___k  ) { DTTest  obj ;
   ___ContinuationClasscontinuationMethod2  ___k1 ; dt1.flag = true;  obj.flag
   = dt1.flag & true ;  ___k1 = new ___ContinuationClasscontinuationMethod2();
   ___k1.fc = fc;  ___k1.obj = obj;  ___k1.___k = ___k;  ___k1.object = this;
   fc.bar(obj.flag , dt1.a , ___k1); }  public void continuationMethod0 (
   FooClass  fc , Continuation  ___k  ) { DTTest  obj ;
   ___ContinuationClasscontinuationMethod1  ___k1 ; obj = new DTTest();  obj.a
   = dt1.b;  ___k1 = new ___ContinuationClasscontinuationMethod1();  ___k1.fc =
   fc;  ___k1.___k = ___k;  ___k1.object = this; fc.foo(obj.a + dt1.a , ___k1);
   }}
class FooClass { public void foo (int  a , Continuation  ___k  ) {
   System.out.println ( a + 10 ) ; ___k.call(); }  public void bar (boolean  x
   , int  a   , Continuation  ___k  ) { if ( x ) { System.out.println ( a ) ;
   ___k.call(); }  else { System.out.println ( 15 ) ; ___k.call(); }  }  public
   void fbar (int [ ]   arr , Continuation  ___k  ) { System.out.println ( arr
   [ 0 ] ) ; ___k.call(); }}
class ___ContinuationClasscontinuationMethod3 extends Continuation { FooClass
   fc ; DTTest  obj ; Continuation  ___k ; DTTest  object ; public void call ()
   { object.continuationMethod3(fc , obj , ___k); }}
class ___ContinuationClasscontinuationMethod2 extends Continuation { FooClass
   fc ; DTTest  obj ; Continuation  ___k ; DTTest  object ; public void call ()
   { object.continuationMethod2(fc , obj , ___k); }}
class ___ContinuationClasscontinuationMethod1 extends Continuation { FooClass
   fc ; Continuation  ___k ; DTTest  object ; public void call () { object.
   continuationMethod1(fc , ___k); }}
class ___ContinuationClasscontinuationMethod0 extends Continuation { FooClass
   fc ; Continuation  ___k ; DTTest  object ; public void call () { object.
   continuationMethod0(fc , ___k); }}
class Continuation { public void call () { }} 