 class PrintTest {
public static void main ( String [ ] a ) {
new PTTest ( ) . ____Main____ ( new Continuation()  ) ; } }  class PTTest { int
   a ;   int [ ]   arr ; public void ____Main____ (Continuation  ___k ) { int
   b ;  PTTest  obj ;  PTTest  obj1 ; a = 10;  b = 12;  arr = new int[100];
   System.out.println ( a ) ;  System.out.println ( (a + (b * (a - (b)))) ) ;
   System.out.println ( arr.length ) ;  arr[0] = 5;  arr[5] = 7;
   System.out.println ( (arr [ 0 ]) * (arr [ 5 ]) ) ;  obj = new PTTest();
   obj1 = new PTTest();  obj.a = 16;  obj1.a = 12;  System.out.println ( obj.a
   ) ;  System.out.println ( obj.a + obj1.a ) ; ___k.call(); }}
class Continuation { public void call () { }} 