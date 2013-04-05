 class DifferentPrints {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ; } }  class Dprints { int [
   ]   a ;   int  ____1234Start4321____ ;   int  ____1234RetFunc4321____ ;
   public void Start ( int  x  ) { int [ ]   b ;  Dprints  r1 ;  Dprints
   ___tmp2 ;  int  ___tmp3 ; r1 = new Dprints ( ) ;  System.out.println ( x + 2
   ) ;  System.out.println ( x * 2 ) ;  System.out.println ( x - 2 ) ;
   System.out.println ( ( ( x + 2 ) ) ) ;  System.out.println ( ( x + ( x * ( x
   - 2 ) ) ) ) ;  a = new int [ 1000 ] ;  System.out.println ( a [ x ] ) ;
   System.out.println ( a [ ( x + ( x * ( x - 2 ) ) ) ] ) ;  b = new int [ 1000
   ] ;  ___tmp2 = r1 ;  ___tmp2 . RetFunc ( 10  ) ;  ___tmp3 = ___tmp2 .
   ____1234RetFunc4321____ ;  System.out.println ( ___tmp3 ) ;
   System.out.println ( ( a [ 0 ] ) * ( b [ 0 ] ) ) ;  ____1234Start4321____ =
   10 + x ; }   public void RetFunc ( int  x  ) { ____1234RetFunc4321____ = 5 ;
   } }
class ____NewMainClass____ { public void ____Main____ ( int  ____arg_length____
   ) { Dprints  ___tmp0 ;  int  ___tmp1 ; ___tmp0 = new Dprints ( ) ;  ___tmp0
   . Start ( 10  ) ;  ___tmp1 = ___tmp0 . ____1234Start4321____ ;
   System.out.println ( ___tmp1 ) ; } } 