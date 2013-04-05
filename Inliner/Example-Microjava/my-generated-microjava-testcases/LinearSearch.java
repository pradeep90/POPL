 class LinearSearch {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ; } }  class LS { int [ ]
   number ;   int  size ;   int  ____1234Start4321____ ;   int
   ____1234Print4321____ ;   int  ____1234Search4321____ ;   int
   ____1234Init4321____ ; public void Start ( int  sz  ) { int  aux01 ;  int
   aux02 ;  LS  ___tmp2 ;  int  ___tmp3 ;  LS  ___tmp4 ;  int  ___tmp5 ;  LS
   ___tmp6 ;  int  ___tmp7 ;  LS  ___tmp8 ;  int  ___tmp9 ;  LS  ___tmp10 ;
   int  ___tmp11 ;  LS  ___tmp12 ;  int  ___tmp13 ; ___tmp2 = this ;  ___tmp2 .
   Init ( sz  ) ;  ___tmp3 = ___tmp2 . ____1234Init4321____ ;  aux01 = ___tmp3
   ;  ___tmp4 = this ;  ___tmp4 . Print ( ) ;  ___tmp5 = ___tmp4 .
   ____1234Print4321____ ;  aux02 = ___tmp5 ;  System.out.println ( 9999 ) ;
   ___tmp6 = this ;  ___tmp6 . Search ( 8  ) ;  ___tmp7 = ___tmp6 .
   ____1234Search4321____ ;  System.out.println ( ___tmp7 ) ;  ___tmp8 = this ;
   ___tmp8 . Search ( 12  ) ;  ___tmp9 = ___tmp8 . ____1234Search4321____ ;
   System.out.println ( ___tmp9 ) ;  ___tmp10 = this ;  ___tmp10 . Search ( 17
   ) ;  ___tmp11 = ___tmp10 . ____1234Search4321____ ;  System.out.println (
   ___tmp11 ) ;  ___tmp12 = this ;  ___tmp12 . Search ( 50  ) ;  ___tmp13 =
   ___tmp12 . ____1234Search4321____ ;  System.out.println ( ___tmp13 ) ;
   ____1234Start4321____ = 55 ; }   public void Print (  ) { int  j ; j = 1 ;
   while ( j < ( size ) ) { System.out.println ( number [ j ] ) ;  j = j + 1 ;
   }   ____1234Print4321____ = 0 ; }   public void Search ( int  num  ) { int
   j ;  boolean  ls01 ;  int  ifound ;  int  aux01 ;  int  aux02 ;  int  nt ; j
   = 1 ;  ls01 = false ;  ifound = 0 ;  while ( j < ( size ) ) { aux01 = number
   [ j ] ;  aux02 = num + 1 ;  if ( aux01 < num ) nt = 0 ;  else if ( ! ( aux01
   < aux02 ) ) nt = 0 ;  else { ls01 = true ;  ifound = 1 ;  j = size ; }    j
   = j + 1 ; }   ____1234Search4321____ = ifound ; }   public void Init ( int
   sz  ) { int  j ;  int  k ;  int  aux01 ;  int  aux02 ; size = sz ;  number =
   new int [ sz ] ;  j = 1 ;  k = size + 1 ;  while ( j < ( size ) ) { aux01 =
   2 * j ;  aux02 = k - 3 ;  number [ j ] = aux01 + aux02 ;  j = j + 1 ;  k = k
   - 1 ; }   ____1234Init4321____ = 0 ; } }
class ____NewMainClass____ { public void ____Main____ ( int  ____arg_length____
   ) { LS  ___tmp0 ;  int  ___tmp1 ; ___tmp0 = new LS ( ) ;  ___tmp0 . Start (
   10  ) ;  ___tmp1 = ___tmp0 . ____1234Start4321____ ;  System.out.println (
   ___tmp1 ) ; } } 