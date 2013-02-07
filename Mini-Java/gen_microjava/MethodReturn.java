 class MethodReturn {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ; } }  class Test1 { int
   ____1234Start4321____ ;   int  ____1234Add4321____ ;   int
   ____1234Mul4321____ ;   int  ____1234Lookup4321____ ;   int
   ____1234Arrayy4321____ ; public void Start ( int  z  ) { int  x ;  Test1  tx
   ;  int  y ;  Test1  ___tmp2 ;  int  ___tmp3 ;  Test1  ___tmp4 ;  int
   ___tmp5 ;  Test1  ___tmp6 ;  int  ___tmp7 ;  Test1  ___tmp8 ;  int  ___tmp9
   ; y = z ;  tx = new Test1 ( ) ;  ___tmp2 = tx ;  ___tmp2 . Add ( 10  ) ;
   ___tmp3 = ___tmp2 . ____1234Add4321____ ;  x = ___tmp3 ;  y = y + x ;
   ___tmp4 = tx ;  ___tmp4 . Mul ( 10  ) ;  ___tmp5 = ___tmp4 .
   ____1234Mul4321____ ;  x = ___tmp5 ;  y = y + x ;  ___tmp6 = tx ;  ___tmp6 .
   Lookup ( 10  ) ;  ___tmp7 = ___tmp6 . ____1234Lookup4321____ ;  x = ___tmp7
   ;  y = y + x ;  ___tmp8 = tx ;  ___tmp8 . Arrayy ( 10  ) ;  ___tmp9 =
   ___tmp8 . ____1234Arrayy4321____ ;  x = ___tmp9 ;  y = y + x ;
   ____1234Start4321____ = 20 + y ; }   public void Add ( int  x  ) { int  a ;
   int  b ; a = 2 ;  b = 3 ;  a = a + b ;  ____1234Add4321____ = a + x ; }
   public void Mul ( int  x  ) { int  a ;  int  b ; a = 2 ;  b = 3 ;
   ____1234Mul4321____ = ( a * ( b * x ) ) ; }   public void Lookup ( int  x  )
   { int [ ]   a ;  int  b ; b = x - 2 ;  a = new int [ x ] ;
   ____1234Lookup4321____ = a [ b ] ; }   public void Arrayy ( int  x  ) { int
   [ ]   a ; a = new int [ x ] ;  ____1234Arrayy4321____ = a [ ( x - 1 ) ] ; }
   }
class ____NewMainClass____ { public void ____Main____ ( int  ____arg_length____
   ) { Test1  ___tmp0 ;  int  ___tmp1 ; ___tmp0 = new Test1 ( ) ;  ___tmp0 .
   Start ( 10  ) ;  ___tmp1 = ___tmp0 . ____1234Start4321____ ;
   System.out.println ( ___tmp1 ) ; } } 