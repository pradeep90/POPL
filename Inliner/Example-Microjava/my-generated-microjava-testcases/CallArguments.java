 class CallArguments {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ; } }  class CArgs { int
   ____1234Start4321____ ;   int  ____1234foo4321____ ;   int
   ____1234bar4321____ ;   int  ____1234fbar4321____ ; public void Start ( int
   x  ) { int  z ;  CArgs  rc ;  CArgs  rx ;  CArgs  ry ;  CArgs  ___tmp6 ;
   int  ___tmp7 ;  CArgs  ___tmp4 ;  int  ___tmp5 ;  CArgs  ___tmp2 ;  int
   ___tmp3 ; rc = new CArgs ( ) ;  rx = new CArgs ( ) ;  ry = new CArgs ( ) ;
   ___tmp6 = rc ;  ___tmp4 = rx ;  ___tmp2 = ry ;  ___tmp2 . fbar ( ) ;
   ___tmp3 = ___tmp2 . ____1234fbar4321____ ;  ___tmp4 . bar ( ___tmp3  ) ;
   ___tmp5 = ___tmp4 . ____1234bar4321____ ;  ___tmp6 . foo ( ___tmp5  ) ;
   ___tmp7 = ___tmp6 . ____1234foo4321____ ;  z = ___tmp7 ;
   ____1234Start4321____ = z + x ; }   public void foo ( int  x  ) {
   ____1234foo4321____ = x + 20 ; }   public void bar ( int  x  ) {
   ____1234bar4321____ = x + 30 ; }   public void fbar (  ) {
   ____1234fbar4321____ = 10 ; } }
class ____NewMainClass____ { public void ____Main____ ( int  ____arg_length____
   ) { CArgs  ___tmp0 ;  int  ___tmp1 ; ___tmp0 = new CArgs ( ) ;  ___tmp0 .
   Start ( 10  ) ;  ___tmp1 = ___tmp0 . ____1234Start4321____ ;
   System.out.println ( ___tmp1 ) ; } } 