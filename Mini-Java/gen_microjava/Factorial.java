 class Factorial {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ; } }  class Fac { int
   ____1234ComputeFac4321____ ; public void ComputeFac ( int  num  ) { int
   num_aux ;  Fac  ___tmp2 ;  int  ___tmp3 ; if ( num < 1 ) num_aux = 1 ;  else
   { ___tmp2 = this ;  ___tmp2 . ComputeFac ( num - 1  ) ;  ___tmp3 = ___tmp2 .
   ____1234ComputeFac4321____ ;  num_aux = num * ( ___tmp3 ) ; }
   ____1234ComputeFac4321____ = num_aux ; } }
class ____NewMainClass____ { public void ____Main____ ( int  ____arg_length____
   ) { Fac  ___tmp0 ;  int  ___tmp1 ; ___tmp0 = new Fac ( ) ;  ___tmp0 .
   ComputeFac ( 10  ) ;  ___tmp1 = ___tmp0 . ____1234ComputeFac4321____ ;
   System.out.println ( ___tmp1 ) ; } } 