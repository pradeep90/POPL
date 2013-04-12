 class DotTest {
public static void main ( String [ ] a ) {
new DTTest ( ) . ____Main____ ( ) ; } }  class DTTest { int  a ;   int  b ;
   boolean  flag ;   DTTest  dt1 ;   int [ ]   arr ; public void ____Main____ (
   ) { DTTest  ___VAR0 ;  FooClass  ___VAR1 ;  int  ___VAR6 ;  int  ___VAR7 ;
   boolean  ___VAR8 ;  int  ___VAR9 ;  boolean  ___VAR10 ;  int  ___VAR11 ;
   int [ ]   ___VAR12 ; dt1 = new DTTest ( ) ;  dt1 . b = 10 ;  dt1 . a = dt1 .
   b + dt1 . b ;  ___VAR1 = new FooClass ( ) ;  { ___VAR6 = dt1 . a ;
   System.out.println ( ___VAR6 + 10 ) ; }  ___VAR0 = new DTTest ( ) ;  ___VAR0
   . a = dt1 . b ;  { ___VAR7 = ___VAR0 . a + dt1 . a ;  System.out.println (
   ___VAR7 + 10 ) ; }  dt1 . flag = true ;  ___VAR0 . flag = dt1 . flag & true
   ;  { ___VAR8 = ___VAR0 . flag ;  ___VAR9 = dt1 . a ;  if ( ___VAR8 )
   System.out.println ( ___VAR9 ) ;  else System.out.println ( 15 ) ;  }
   ___VAR0 . flag = ! ( ___VAR0 . flag ) ;  { ___VAR10 = ___VAR0 . flag ;
   ___VAR11 = dt1 . a ;  if ( ___VAR10 ) System.out.println ( ___VAR11 ) ;
   else System.out.println ( 15 ) ;  }  arr = new int [ 20 ] ;  arr [ 0 ] = dt1
   . b ;  { ___VAR12 = arr ;  System.out.println ( ___VAR12 [ 0 ] ) ; } } }
class FooClass { public void foo ( int  ___VAR2  ) { System.out.println (
   ___VAR2 + 10 ) ; }   public void bar ( boolean  ___VAR3 , int  ___VAR4   ) {
   if ( ___VAR3 ) System.out.println ( ___VAR4 ) ;  else System.out.println (
   15 ) ;  }   public void fbar ( int [ ]   ___VAR5  ) { System.out.println (
   ___VAR5 [ 0 ] ) ; } } 