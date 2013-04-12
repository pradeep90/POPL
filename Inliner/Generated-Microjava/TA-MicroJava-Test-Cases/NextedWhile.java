 class NextedWhile {
public static void main ( String [ ] a ) {
new NWTest ( ) . ____Main____ ( ) ; } }  class NWTest { int  a ;   int  b ;
   int  c ;   int  sum ; public void ____Main____ ( ) { boolean  ___VAR0 ;
   NWTest  ___VAR1 ;  int  ___VAR2 ; ___VAR1 = new NWTest ( ) ;  a = 1 ;
   ___VAR2 = 0 ;  c = 0 ;  b = 1000 ;  ___VAR0 = true ;  while ( ( a < b ) &
   ___VAR0  ) { while ( c < 5 ) { a = a * ( a + 1 ) ;  sum = sum + 999 ;  c = c
   + 1 ; }   while ( ( c < 10 ) & ( 4 < c )  ) { while ( ___VAR2 < 10 ) {
   ___VAR1 . sum = ___VAR1 . sum + 1 ;  ___VAR2 = ___VAR2 + 1 ; }   c = c + 1 ;
   }   if ( 10 < c ) { ___VAR0 = false ; }  else { System.out.println ( sum ) ;
   }  }   System.out.println ( ___VAR1 . sum ) ; } } 