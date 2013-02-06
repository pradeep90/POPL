 class BubbleSort {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ; } }  class BBS { int [ ]
   number ;   int  size ;   int  ____1234Start4321____ ;   int
   ____1234Sort4321____ ;   int  ____1234Print4321____ ;   int
   ____1234Init4321____ ; public void Start ( int  sz  ) { int  aux01 ;  BBS
   ___tmp2 ;  int  ___tmp3 ;  BBS  ___tmp4 ;  int  ___tmp5 ;  BBS  ___tmp6 ;
   int  ___tmp7 ;  BBS  ___tmp8 ;  int  ___tmp9 ; ___tmp2 = this ;  ___tmp2 .
   Init ( sz  ) ;  ___tmp3 = ___tmp2 . ____1234Init4321____ ;  aux01 = ___tmp3
   ;  ___tmp4 = this ;  ___tmp4 . Print ( ) ;  ___tmp5 = ___tmp4 .
   ____1234Print4321____ ;  aux01 = ___tmp5 ;  System.out.println ( 99999 ) ;
   ___tmp6 = this ;  ___tmp6 . Sort ( ) ;  ___tmp7 = ___tmp6 .
   ____1234Sort4321____ ;  aux01 = ___tmp7 ;  ___tmp8 = this ;  ___tmp8 . Print
   ( ) ;  ___tmp9 = ___tmp8 . ____1234Print4321____ ;  aux01 = ___tmp9 ;
   ____1234Start4321____ = 0 ; }   public void Sort (  ) { int  nt ;  int  i ;
   int  aux02 ;  int  aux04 ;  int  aux05 ;  int  aux06 ;  int  aux07 ;  int  j
   ;  int  t ; i = size - 1 ;  aux02 = 0 - 1 ;  while ( aux02 < i ) { j = 1 ;
   while ( j < ( i + 1 ) ) { aux07 = j - 1 ;  aux04 = number [ aux07 ] ;  aux05
   = number [ j ] ;  if ( aux05 < aux04 ) { aux06 = j - 1 ;  t = number [ aux06
   ] ;  number [ aux06 ] = number [ j ] ;  number [ j ] = t ; }  else nt = 0 ;
   j = j + 1 ; }   i = i - 1 ; }   ____1234Sort4321____ = 0 ; }   public void
   Print (  ) { int  j ; j = 0 ;  while ( j < ( size ) ) { System.out.println (
   number [ j ] ) ;  j = j + 1 ; }   ____1234Print4321____ = 0 ; }   public
   void Init ( int  sz  ) { size = sz ;  number = new int [ sz ] ;  number [ 0
   ] = 20 ;  number [ 1 ] = 7 ;  number [ 2 ] = 12 ;  number [ 3 ] = 18 ;
   number [ 4 ] = 2 ;  number [ 5 ] = 11 ;  number [ 6 ] = 6 ;  number [ 7 ] =
   9 ;  number [ 8 ] = 19 ;  number [ 9 ] = 5 ;  ____1234Init4321____ = 0 ; } }
class ____NewMainClass____ { public void ____Main____ ( int  ____arg_length____
   ) { BBS  ___tmp0 ;  int  ___tmp1 ; ___tmp0 = new BBS ( ) ;  ___tmp0 . Start
   ( 10  ) ;  ___tmp1 = ___tmp0 . ____1234Start4321____ ;  System.out.println (
   ___tmp1 ) ; } } 