 class MultilevelInherit {
public static void main ( String [ ] a ) {
new MITest ( ) . ____Main____ ( ) ; } }  class MITest { public void
   ____Main____ ( ) { Foo  ___VAR0 ;  FooBar  ___VAR1 ;  int [ ]   ___VAR2 ;
   ___VAR0 = new FooBar ( ) ;  ___VAR0 . f1 ( 10  ) ;  ___VAR0 = new Foo ( ) ;
   ___VAR0 . f1 ( 20  ) ;  ___VAR0 = new FooBar ( ) ;  ___VAR0 . f1 ( 30  ) ; }
   }
class Foo { public void f1 ( int  ___VAR3  ) { System.out.println ( ___VAR3 + 2
   ) ; } }
class Bar extends Foo { public void f1 ( int  ___VAR4  ) { System.out.println (
   ___VAR4 + 1 ) ; } }
class FooBar extends Bar { public void f1 ( int  ___VAR5  ) {
   System.out.println ( ___VAR5 + 3 ) ; } } 