 class RandomChecks {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ; } }  class Rchecks { int
   ____1234Start4321____ ;   Rchecks  ____1234Bar4321____ ;   int
   ____1234Foo4321____ ; public void Start (  ) { Rchecks  yy ;  Rchecks  zz ;
   int  retVal ;  Rchecks  ___tmp2 ;  Rchecks  ___tmp3 ;  Rchecks  ___tmp4 ;
   int  ___tmp5 ; yy = new Ychecks ( ) ;  ___tmp2 = yy ;  ___tmp2 . Bar ( ) ;
   ___tmp3 = ___tmp2 . ____1234Bar4321____ ;  zz = ___tmp3 ;  ___tmp4 = zz ;
   ___tmp4 . Foo ( ) ;  ___tmp5 = ___tmp4 . ____1234Foo4321____ ;
   ____1234Start4321____ = ___tmp5 ; }   public void Bar (  ) {
   ____1234Bar4321____ = null ; }   public void Foo (  ) { ____1234Foo4321____
   = 0 ; } }
class Ychecks extends Rchecks { public void Foo (  ) { ____1234Foo4321____ = 15
   ; } public void Bar (  ) { int  x ;  Rchecks  rx ;  Ychecks  ___tmp6 ;  int
   ___tmp7 ; rx = new Rchecks ( ) ;  ___tmp6 = this ;  ___tmp6 . Foo ( ) ;
   ___tmp7 = ___tmp6 . ____1234Foo4321____ ;  x = ___tmp7 ;  System.out.println
   ( x ) ;  ____1234Bar4321____ = rx ; } }
class ____NewMainClass____ { public void ____Main____ ( int  ____arg_length____
   ) { Rchecks  ___tmp0 ;  int  ___tmp1 ; ___tmp0 = new Rchecks ( ) ;  ___tmp0
   . Start ( ) ;  ___tmp1 = ___tmp0 . ____1234Start4321____ ;
   System.out.println ( ___tmp1 ) ; } } 