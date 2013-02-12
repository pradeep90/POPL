 class QuickSort {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ; } }  class QS { int [ ]
   number ;   int  size ;   int  ____1234Start4321____ ;   int
   ____1234Sort4321____ ;   int  ____1234Print4321____ ;   int
   ____1234Init4321____ ; public void Start ( int  sz  ) { int  aux01 ;  QS
   ___tmp2 ;  int  ___tmp3 ;  QS  ___tmp4 ;  int  ___tmp5 ;  QS  ___tmp6 ;  int
   ___tmp7 ;  QS  ___tmp8 ;  int  ___tmp9 ; ___tmp2 = this ;  ___tmp2 . Init (
   sz  ) ;  ___tmp3 = ___tmp2 . ____1234Init4321____ ;  aux01 = ___tmp3 ;
   ___tmp4 = this ;  ___tmp4 . Print ( ) ;  ___tmp5 = ___tmp4 .
   ____1234Print4321____ ;  aux01 = ___tmp5 ;  System.out.println ( 9999 ) ;
   aux01 = size - 1 ;  ___tmp6 = this ;  ___tmp6 . Sort ( 0 , aux01 ) ;
   ___tmp7 = ___tmp6 . ____1234Sort4321____ ;  aux01 = ___tmp7 ;  ___tmp8 =
   this ;  ___tmp8 . Print ( ) ;  ___tmp9 = ___tmp8 . ____1234Print4321____ ;
   aux01 = ___tmp9 ;  ____1234Start4321____ = 0 ; }   public void Sort ( int
   left , int  right   ) { int  v ;  int  i ;  int  j ;  int  nt ;  int  t ;
   boolean  cont01 ;  boolean  cont02 ;  int  aux03 ;  QS  ___tmp10 ;  int
   ___tmp11 ;  QS  ___tmp12 ;  int  ___tmp13 ; t = 0 ;  if ( left < right ) { v
   = number [ right ] ;  i = left - 1 ;  j = right ;  cont01 = true ;  while (
   cont01 ) { cont02 = true ;  while ( cont02 ) { i = i + 1 ;  aux03 = number [
   i ] ;  if ( ! ( aux03 < v ) ) cont02 = false ;  else cont02 = true ;  }
   cont02 = true ;  while ( cont02 ) { j = j - 1 ;  aux03 = number [ j ] ;  if
   ( ! ( v < aux03 ) ) cont02 = false ;  else cont02 = true ;  }   t = number [
   i ] ;  number [ i ] = number [ j ] ;  number [ j ] = t ;  if ( j < ( i + 1 )
   ) cont01 = false ;  else cont01 = true ;  }   number [ j ] = number [ i ] ;
   number [ i ] = number [ right ] ;  number [ right ] = t ;  ___tmp10 = this ;
   ___tmp10 . Sort ( left , i - 1 ) ;  ___tmp11 = ___tmp10 .
   ____1234Sort4321____ ;  nt = ___tmp11 ;  ___tmp12 = this ;  ___tmp12 . Sort
   ( i + 1 , right ) ;  ___tmp13 = ___tmp12 . ____1234Sort4321____ ;  nt =
   ___tmp13 ; }  else nt = 0 ;   ____1234Sort4321____ = 0 ; }   public void
   Print (  ) { int  j ; j = 0 ;  while ( j < ( size ) ) { System.out.println (
   number [ j ] ) ;  j = j + 1 ; }   ____1234Print4321____ = 0 ; }   public
   void Init ( int  sz  ) { size = sz ;  number = new int [ sz ] ;  number [ 0
   ] = 20 ;  number [ 1 ] = 7 ;  number [ 2 ] = 12 ;  number [ 3 ] = 18 ;
   number [ 4 ] = 2 ;  number [ 5 ] = 11 ;  number [ 6 ] = 6 ;  number [ 7 ] =
   9 ;  number [ 8 ] = 19 ;  number [ 9 ] = 5 ;  ____1234Init4321____ = 0 ; } }
class ____NewMainClass____ { public void ____Main____ ( int  ____arg_length____
   ) { QS  ___tmp0 ;  int  ___tmp1 ; ___tmp0 = new QS ( ) ;  ___tmp0 . Start (
   10  ) ;  ___tmp1 = ___tmp0 . ____1234Start4321____ ;  System.out.println (
   ___tmp1 ) ; } } 