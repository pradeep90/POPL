 class PrintTest {
public static void main ( String [ ] a ) {
new PTTest ( ) . ____Main____ ( ) ; } }  class PTTest { int  a ;   int [ ]
   arr ; public void ____Main____ ( ) { int  ___VAR0 ;  PTTest  ___VAR1 ;
   PTTest  ___VAR2 ; a = 10 ;  ___VAR0 = 12 ;  arr = new int [ 100 ] ;
   System.out.println ( a ) ;  System.out.println ( ( a + ( ___VAR0 * ( a - (
   ___VAR0 ) ) ) ) ) ;  System.out.println ( arr . length ) ;  arr [ 0 ] = 5 ;
   arr [ 5 ] = 7 ;  System.out.println ( ( arr [ 0 ] ) * ( arr [ 5 ] ) ) ;
   ___VAR1 = new PTTest ( ) ;  ___VAR2 = new PTTest ( ) ;  ___VAR1 . a = 16 ;
   ___VAR2 . a = 12 ;  System.out.println ( ___VAR1 . a ) ;  System.out.println
   ( ___VAR1 . a + ___VAR2 . a ) ; } } 