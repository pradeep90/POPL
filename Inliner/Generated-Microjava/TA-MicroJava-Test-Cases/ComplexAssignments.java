 class ComplexAssignments {
public static void main ( String [ ] a ) {
new CATest ( ) . ____Main____ ( ) ; } }  class CATest { int  b ;   int [ ]
   arr ; public void ____Main____ ( ) { int  ___VAR0 ;  int  ___VAR1 ; ___VAR0
   = 10 ;  b = 20 ;  arr = new int [ ( ( ___VAR0 * b ) + ( b - ___VAR0 ) ) ] ;
   System.out.println ( arr . length ) ;  ___VAR1 = arr . length - 1 ;
   System.out.println ( arr [ ___VAR1 ] ) ;  arr [ 2 ] = ( ( ( ___VAR0 + b ) *
   ( b ) ) ) ;  arr [ 0 ] = ( ( arr [ 2 ] ) + ( ( arr [ 2 ] ) + ( ___VAR0 * b )
   ) ) ;  if ( ( ( arr [ 0 ] ) < ( arr [ 2 ] ) ) ) arr [ 3 ] = ( ( arr [ 0 ] )
   - 3 ) ;  else arr [ 3 ] = 5 ;   System.out.println ( arr [ 3 ] ) ; } } 