 class MethodType {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ; } }  class Foo { int
   ____1234Start4321____ ;   int [ ]   ____1234Run4321____ ;   boolean
   ____1234Go4321____ ;   Foo  ____1234Stop4321____ ; public void Start ( int
   x  ) { int [ ]   y ;  boolean  flag ;  Foo  f1 ;  Foo  ___tmp2 ;  boolean
   ___tmp3 ;  Foo  ___tmp4 ;  Foo  ___tmp5 ;  Foo  ___tmp6 ;  int [ ]   ___tmp7
   ; f1 = new Foo ( ) ;  ___tmp2 = f1 ;  ___tmp2 . Go ( ) ;  ___tmp3 = ___tmp2
   . ____1234Go4321____ ;  flag = ___tmp3 ;  ___tmp4 = f1 ;  ___tmp4 . Stop (
   flag  ) ;  ___tmp5 = ___tmp4 . ____1234Stop4321____ ;  f1 = ___tmp5 ;
   ___tmp6 = f1 ;  ___tmp6 . Run ( ) ;  ___tmp7 = ___tmp6 . ____1234Run4321____
   ;  y = ___tmp7 ;  ____1234Start4321____ = ( 20 + ( y [ 0 ] ) ) ; }   public
   void Run (  ) { int [ ]   a ; a = new int [ 10 ] ;  a [ 0 ] = 4 ;
   ____1234Run4321____ = a ; }   public void Go (  ) { ____1234Go4321____ =
   true ; }   public void Stop ( boolean  flag  ) { Foo  f1 ; if ( flag ) f1 =
   new Foo ( ) ;  else f1 = null ;   ____1234Stop4321____ = f1 ; } }
class ____NewMainClass____ { public void ____Main____ ( int  ____arg_length____
   ) { Foo  ___tmp0 ;  int  ___tmp1 ; ___tmp0 = new Foo ( ) ;  ___tmp0 . Start
   ( 10  ) ;  ___tmp1 = ___tmp0 . ____1234Start4321____ ;  System.out.println (
   ___tmp1 ) ; } } 