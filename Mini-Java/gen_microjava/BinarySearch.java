 class BinarySearch {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ; } }  class BS { int [ ]
   number ;   int  size ;   int  ____1234Start4321____ ;   boolean
   ____1234Search4321____ ;   int  ____1234Div4321____ ;   boolean
   ____1234Compare4321____ ;   int  ____1234Print4321____ ;   int
   ____1234Init4321____ ; public void Start ( int  sz  ) { int  aux01 ;  int
   aux02 ;  BS  ___tmp2 ;  int  ___tmp3 ;  BS  ___tmp4 ;  int  ___tmp5 ;  BS
   ___tmp6 ;  boolean  ___tmp7 ;  BS  ___tmp8 ;  boolean  ___tmp9 ;  BS
   ___tmp10 ;  boolean  ___tmp11 ;  BS  ___tmp12 ;  boolean  ___tmp13 ;  BS
   ___tmp14 ;  boolean  ___tmp15 ;  BS  ___tmp16 ;  boolean  ___tmp17 ;  BS
   ___tmp18 ;  boolean  ___tmp19 ;  BS  ___tmp20 ;  boolean  ___tmp21 ; ___tmp2
   = this ;  ___tmp2 . Init ( sz  ) ;  ___tmp3 = ___tmp2 . ____1234Init4321____
   ;  ___tmp4 = this ;  ___tmp4 . Print ( ) ;  ___tmp5 = ___tmp4 .
   ____1234Print4321____ ;  ___tmp6 = this ;  ___tmp6 . Search ( 8  ) ;
   ___tmp7 = ___tmp6 . ____1234Search4321____ ;  ___tmp8 = this ;  ___tmp8 .
   Search ( 19  ) ;  ___tmp9 = ___tmp8 . ____1234Search4321____ ;  ___tmp10 =
   this ;  ___tmp10 . Search ( 20  ) ;  ___tmp11 = ___tmp10 .
   ____1234Search4321____ ;  ___tmp12 = this ;  ___tmp12 . Search ( 21  ) ;
   ___tmp13 = ___tmp12 . ____1234Search4321____ ;  ___tmp14 = this ;  ___tmp14
   . Search ( 37  ) ;  ___tmp15 = ___tmp14 . ____1234Search4321____ ;  ___tmp16
   = this ;  ___tmp16 . Search ( 38  ) ;  ___tmp17 = ___tmp16 .
   ____1234Search4321____ ;  ___tmp18 = this ;  ___tmp18 . Search ( 39  ) ;
   ___tmp19 = ___tmp18 . ____1234Search4321____ ;  ___tmp20 = this ;  ___tmp20
   . Search ( 50  ) ;  ___tmp21 = ___tmp20 . ____1234Search4321____ ;  aux01 =
   ___tmp3 ;  aux02 = ___tmp5 ;  if ( ___tmp7 ) System.out.println ( 1 ) ;
   else System.out.println ( 0 ) ;   if ( ___tmp9 ) System.out.println ( 1 ) ;
   else System.out.println ( 0 ) ;   if ( ___tmp11 ) System.out.println ( 1 ) ;
   else System.out.println ( 0 ) ;   if ( ___tmp13 ) System.out.println ( 1 ) ;
   else System.out.println ( 0 ) ;   if ( ___tmp15 ) System.out.println ( 1 ) ;
   else System.out.println ( 0 ) ;   if ( ___tmp17 ) System.out.println ( 1 ) ;
   else System.out.println ( 0 ) ;   if ( ___tmp19 ) System.out.println ( 1 ) ;
   else System.out.println ( 0 ) ;   if ( ___tmp21 ) System.out.println ( 1 ) ;
   else System.out.println ( 0 ) ;   ____1234Start4321____ = 999 ; }   public
   void Search ( int  num  ) { boolean  bs01 ;  int  right ;  int  left ;
   boolean  var_cont ;  int  medium ;  int  aux01 ;  int  nt ;  int [ ]
   ___tmp22 ;  BS  ___tmp23 ;  int  ___tmp24 ;  BS  ___tmp25 ;  boolean
   ___tmp26 ;  BS  ___tmp27 ;  boolean  ___tmp28 ; ___tmp22 = number ;
   ___tmp27 = this ;  ___tmp27 . Compare ( aux01 , num ) ;  ___tmp28 = ___tmp27
   . ____1234Compare4321____ ;  aux01 = 0 ;  bs01 = false ;  right = ___tmp22 .
   length ;  right = right - 1 ;  left = 0 ;  var_cont = true ;  while (
   var_cont ) { ___tmp23 = this ;  ___tmp23 . Div ( medium  ) ;  ___tmp24 =
   ___tmp23 . ____1234Div4321____ ;  ___tmp25 = this ;  ___tmp25 . Compare (
   aux01 , num ) ;  ___tmp26 = ___tmp25 . ____1234Compare4321____ ;  medium =
   left + right ;  medium = ___tmp24 ;  aux01 = number [ medium ] ;  if ( num <
   aux01 ) right = medium - 1 ;  else left = medium + 1 ;   if ( ___tmp26 )
   var_cont = false ;  else var_cont = true ;   if ( right < left ) var_cont =
   false ;  else nt = 0 ;  }   if ( ___tmp28 ) bs01 = true ;  else bs01 = false
   ;   ____1234Search4321____ = bs01 ; }   public void Div ( int  num  ) { int
   count01 ;  int  count02 ;  int  aux03 ; count01 = 0 ;  count02 = 0 ;  aux03
   = num - 1 ;  while ( count02 < aux03 ) { count01 = count01 + 1 ;  count02 =
   count02 + 2 ; }   ____1234Div4321____ = count01 ; }   public void Compare (
   int  num1 , int  num2   ) { boolean  retval ;  int  aux02 ; retval = false ;
   aux02 = num2 + 1 ;  if ( num1 < num2 ) retval = false ;  else if ( ! ( num1
   < aux02 ) ) retval = false ;  else retval = true ;
   ____1234Compare4321____ = retval ; }   public void Print (  ) { int  j ; j =
   1 ;  while ( j < ( size ) ) { System.out.println ( number [ j ] ) ;  j = j +
   1 ; }   System.out.println ( 99999 ) ;  ____1234Print4321____ = 0 ; }
   public void Init ( int  sz  ) { int  j ;  int  k ;  int  aux02 ;  int  aux01
   ; size = sz ;  number = new int [ sz ] ;  j = 1 ;  k = size + 1 ;  while ( j
   < ( size ) ) { aux01 = 2 * j ;  aux02 = k - 3 ;  number [ j ] = aux01 +
   aux02 ;  j = j + 1 ;  k = k - 1 ; }   ____1234Init4321____ = 0 ; } }
class ____NewMainClass____ { public void ____Main____ ( int  ____arg_length____
   ) { BS  ___tmp0 ;  int  ___tmp1 ; ___tmp0 = new BS ( ) ;  ___tmp0 . Start (
   20  ) ;  ___tmp1 = ___tmp0 . ____1234Start4321____ ;  System.out.println (
   ___tmp1 ) ; } } 