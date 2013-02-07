 class ReturnCalls {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ; } }  class Rcalls { int
   ____1234Start4321____ ;   Rcalls  ____1234foo4321____ ;   Rcalls
   ____1234bar4321____ ;   int  ____1234fbar4321____ ; public void Start ( int
   x  ) { int  z ;  Rcalls  rc ;  Rcalls  ___tmp6 ;  int  ___tmp7 ;  Rcalls
   ___tmp4 ;  Rcalls  ___tmp5 ;  Rcalls  ___tmp2 ;  Rcalls  ___tmp3 ; rc = new
   Rcalls ( ) ;  ___tmp2 = rc ;  ___tmp2 . foo ( ) ;  ___tmp3 = ___tmp2 .
   ____1234foo4321____ ;  ___tmp4 = ( ___tmp3 ) ;  ___tmp4 . bar ( ) ;  ___tmp5
   = ___tmp4 . ____1234bar4321____ ;  ___tmp6 = ( ___tmp5 ) ;  ___tmp6 . fbar (
   ) ;  ___tmp7 = ___tmp6 . ____1234fbar4321____ ;  z = ___tmp7 ;
   ____1234Start4321____ = z + x ; }   public void foo (  ) { Rcalls  rx ; rx =
   new Rcalls ( ) ;  ____1234foo4321____ = rx ; }   public void bar (  ) {
   Rcalls  rx ; rx = new Rcalls ( ) ;  ____1234bar4321____ = rx ; }   public
   void fbar (  ) { ____1234fbar4321____ = 10 ; } }
class ____NewMainClass____ { public void ____Main____ ( int  ____arg_length____
   ) { Rcalls  ___tmp0 ;  int  ___tmp1 ; ___tmp0 = new Rcalls ( ) ;  ___tmp0 .
   Start ( 10  ) ;  ___tmp1 = ___tmp0 . ____1234Start4321____ ;
   System.out.println ( ___tmp1 ) ; } } 