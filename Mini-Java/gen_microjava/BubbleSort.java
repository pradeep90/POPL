 class BubbleSort {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ; } }  class BBS { int [ ]
   number ;   int  size ; public void Start ( int  sz  ) { int  aux01 ;  int
   ____TEMP____ ;  int  ____TEMP____ ;  int  ____TEMP____ ;  int  ____TEMP____
   ; ____TEMP____ = this ;  ____TEMP____ = this ;  ____TEMP____ = this ;
   ____TEMP____ = this ;  aux01 = ____TEMP____ . Init ( sz  ) ;  ;  aux01 =
   ____TEMP____ . Print ( ) ;  ;  System.out.println ( 99999 ) ;  aux01 =
   ____TEMP____ . Sort ( ) ;  ;  aux01 = ____TEMP____ . Print ( ) ;  ;
   ____RET_VAL____ = 0 ; }   public void Sort ( ) { int  nt ;  int  i ;  int
   aux02 ;  int  aux04 ;  int  aux05 ;  int  aux06 ;  int  aux07 ;  int  j ;
   int  t ; i = size - 1 ;  aux02 = 0 - 1 ;  while ( aux02 < i ) { j = 1 ;
   while ( j < ( i + 1 ) ) { aux07 = j - 1 ;  aux04 = number [ aux07 ] ;  aux05
   = number [ j ] ;  if ( aux05 < aux04 ) { aux06 = j - 1 ;  t = number [ aux06
   ] ;  number [ aux06 ] = number [ j ] ;  number [ j ] = t ; }  else nt = 0 ;
   j = j + 1 ; }   i = i - 1 ; }   ____RET_VAL____ = 0 ; }   public void Print
   ( ) { int  j ; j = 0 ;  while ( j < ( size ) ) { System.out.println ( number
   [ j ] ) ;  j = j + 1 ; }   ____RET_VAL____ = 0 ; }   public void Init ( int
   sz  ) { size = sz ;  number = new int [ sz ] ;  number [ 0 ] = 20 ;  number
   [ 1 ] = 7 ;  number [ 2 ] = 12 ;  number [ 3 ] = 18 ;  number [ 4 ] = 2 ;
   number [ 5 ] = 11 ;  number [ 6 ] = 6 ;  number [ 7 ] = 9 ;  number [ 8 ] =
   19 ;  number [ 9 ] = 5 ;  ____RET_VAL____ = 0 ; } }
class ____NewMainClass____ { public void ____Main____ ( int  ____arg_length____
   ) { int  ____printMe____ ; ____printMe____ = ____TEMP____ . Start ( 10  ) ;
   ;  System.out.println ( ____printMe____ ) ; } } 