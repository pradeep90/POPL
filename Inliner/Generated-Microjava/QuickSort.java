 class QuickSort {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ; } }  class QS { int [ ]
   number ;   int  size ;   int  ____1234Start4321____ ;   int
   ____1234Sort4321____ ;   int  ____1234Print4321____ ;   int
   ____1234Init4321____ ; public void Start ( int  ___VAR0  ) { int  ___VAR1 ;
   int  ___VAR2 ;  QS  ___VAR3 ;  int  ___VAR4 ;  QS  ___VAR5 ;  int  ___VAR6 ;
   QS  ___VAR7 ;  int  ___VAR8 ;  QS  ___VAR9 ;  int  ___VAR10 ;  int  ___VAR39
   ;  int  ___VAR38 ;  int  ___VAR40 ;  int  ___VAR41 ;  int  ___VAR44 ;  int
   ___VAR45 ;  int  ___VAR46 ;  int  ___VAR47 ;  int  ___VAR48 ;  boolean
   ___VAR49 ;  boolean  ___VAR50 ;  int  ___VAR51 ;  int  ___VAR52 ;  int
   ___VAR53 ;  boolean  ___VAR54 ;  boolean  ___VAR55 ;  int  ___VAR56 ;  QS
   ___VAR57 ;  int  ___VAR58 ;  QS  ___VAR59 ;  int  ___VAR60 ;  int  ___VAR42
   ;  int  ___VAR43 ;  int  ___VAR61 ;  int  ___VAR62 ; ___VAR2 = ___VAR0 ;
   ___VAR3 = this ;  { ___VAR38 = ___VAR2 ;  ___VAR39 = ___VAR38 ;  ___VAR3 .
   size = ___VAR39 ;  ___VAR3 . number = new int [ ___VAR39 ] ;  number [ 0 ] =
   20 ;  number [ 1 ] = 7 ;  number [ 2 ] = 12 ;  number [ 3 ] = 18 ;  number [
   4 ] = 2 ;  number [ 5 ] = 11 ;  number [ 6 ] = 6 ;  number [ 7 ] = 9 ;
   number [ 8 ] = 19 ;  number [ 9 ] = 5 ;  ___VAR3 . ____1234Init4321____ = 0
   ; }  ___VAR4 = ___VAR3 . ____1234Init4321____ ;  ___VAR1 = ___VAR4 ;
   ___VAR5 = this ;  { ___VAR40 = 0 ;  ___VAR41 = ___VAR5 . size ;  while (
   ___VAR40 < ___VAR41 ) { { System.out.println ( ___VAR5 . number [ ___VAR40 ]
   ) ;  ___VAR40 = ___VAR40 + 1 ; }  ___VAR41 = ___VAR5 . size ; }   ___VAR5 .
   ____1234Print4321____ = 0 ; }  ___VAR6 = ___VAR5 . ____1234Print4321____ ;
   ___VAR1 = ___VAR6 ;  System.out.println ( 9999 ) ;  ___VAR1 = size - 1 ;
   ___VAR7 = this ;  { ___VAR42 = 0 ;  ___VAR43 = ___VAR1 ;  ___VAR53 =
   ___VAR42 ;  ___VAR52 = ___VAR43 ;  ___VAR48 = 0 ;  if ( ___VAR53 < ___VAR52
   ) { { ___VAR44 = ___VAR7 . number [ ___VAR52 ] ;  ___VAR45 = ___VAR53 - 1 ;
   ___VAR46 = ___VAR52 ;  ___VAR49 = true ;  while ( ___VAR49 ) { { ___VAR50 =
   true ;  while ( ___VAR50 ) { { ___VAR45 = ___VAR45 + 1 ;  ___VAR51 = ___VAR7
   . number [ ___VAR45 ] ;  ___VAR54 = ___VAR51 < ___VAR44 ;  if ( ! ___VAR54 )
   { ___VAR50 = false ; }  else { ___VAR50 = true ; }  } }   ___VAR50 = true ;
   while ( ___VAR50 ) { { ___VAR46 = ___VAR46 - 1 ;  ___VAR51 = ___VAR7 .
   number [ ___VAR46 ] ;  ___VAR55 = ___VAR44 < ___VAR51 ;  if ( ! ___VAR55 ) {
   ___VAR50 = false ; }  else { ___VAR50 = true ; }  } }   ___VAR48 = ___VAR7 .
   number [ ___VAR45 ] ;  number [ ___VAR45 ] = ___VAR7 . number [ ___VAR46 ] ;
   number [ ___VAR46 ] = ___VAR48 ;  ___VAR56 = ___VAR45 + 1 ;  if ( ___VAR46 <
   ___VAR56 ) { ___VAR49 = false ; }  else { ___VAR49 = true ; }  } }   number
   [ ___VAR46 ] = ___VAR7 . number [ ___VAR45 ] ;  number [ ___VAR45 ] =
   ___VAR7 . number [ ___VAR52 ] ;  number [ ___VAR52 ] = ___VAR48 ;  ___VAR57
   = ___VAR7 ;  ___VAR57 . Sort ( ___VAR53 , ___VAR45 - 1 ) ;  ___VAR58 =
   ___VAR57 . ____1234Sort4321____ ;  ___VAR47 = ___VAR58 ;  ___VAR59 = ___VAR7
   ;  ___VAR59 . Sort ( ___VAR45 + 1 , ___VAR52 ) ;  ___VAR60 = ___VAR59 .
   ____1234Sort4321____ ;  ___VAR47 = ___VAR60 ; } }  else { ___VAR47 = 0 ; }
   ___VAR7 . ____1234Sort4321____ = 0 ; }  ___VAR8 = ___VAR7 .
   ____1234Sort4321____ ;  ___VAR1 = ___VAR8 ;  ___VAR9 = this ;  { ___VAR61 =
   0 ;  ___VAR62 = ___VAR9 . size ;  while ( ___VAR61 < ___VAR62 ) { {
   System.out.println ( ___VAR9 . number [ ___VAR61 ] ) ;  ___VAR61 = ___VAR61
   + 1 ; }  ___VAR62 = ___VAR9 . size ; }   ___VAR9 . ____1234Print4321____ = 0
   ; }  ___VAR10 = ___VAR9 . ____1234Print4321____ ;  ___VAR1 = ___VAR10 ;
   ____1234Start4321____ = 0 ; }   public void Sort ( int  ___VAR11 , int
   ___VAR12   ) { int  ___VAR13 ;  int  ___VAR14 ;  int  ___VAR15 ;  int
   ___VAR16 ;  int  ___VAR17 ;  boolean  ___VAR18 ;  boolean  ___VAR19 ;  int
   ___VAR20 ;  int  ___VAR21 ;  int  ___VAR22 ;  boolean  ___VAR23 ;  boolean
   ___VAR24 ;  int  ___VAR25 ;  QS  ___VAR26 ;  int  ___VAR27 ;  QS  ___VAR28 ;
   int  ___VAR29 ; ___VAR22 = ___VAR11 ;  ___VAR21 = ___VAR12 ;  ___VAR17 = 0 ;
   if ( ___VAR22 < ___VAR21 ) { { ___VAR13 = number [ ___VAR21 ] ;  ___VAR14 =
   ___VAR22 - 1 ;  ___VAR15 = ___VAR21 ;  ___VAR18 = true ;  while ( ___VAR18 )
   { { ___VAR19 = true ;  while ( ___VAR19 ) { { ___VAR14 = ___VAR14 + 1 ;
   ___VAR20 = number [ ___VAR14 ] ;  ___VAR23 = ___VAR20 < ___VAR13 ;  if ( !
   ___VAR23 ) { ___VAR19 = false ; }  else { ___VAR19 = true ; }  } }
   ___VAR19 = true ;  while ( ___VAR19 ) { { ___VAR15 = ___VAR15 - 1 ;
   ___VAR20 = number [ ___VAR15 ] ;  ___VAR24 = ___VAR13 < ___VAR20 ;  if ( !
   ___VAR24 ) { ___VAR19 = false ; }  else { ___VAR19 = true ; }  } }
   ___VAR17 = number [ ___VAR14 ] ;  number [ ___VAR14 ] = number [ ___VAR15 ]
   ;  number [ ___VAR15 ] = ___VAR17 ;  ___VAR25 = ___VAR14 + 1 ;  if (
   ___VAR15 < ___VAR25 ) { ___VAR18 = false ; }  else { ___VAR18 = true ; }  }
   }   number [ ___VAR15 ] = number [ ___VAR14 ] ;  number [ ___VAR14 ] =
   number [ ___VAR21 ] ;  number [ ___VAR21 ] = ___VAR17 ;  ___VAR26 = this ;
   ___VAR26 . Sort ( ___VAR22 , ___VAR14 - 1 ) ;  ___VAR27 = ___VAR26 .
   ____1234Sort4321____ ;  ___VAR16 = ___VAR27 ;  ___VAR28 = this ;  ___VAR28 .
   Sort ( ___VAR14 + 1 , ___VAR21 ) ;  ___VAR29 = ___VAR28 .
   ____1234Sort4321____ ;  ___VAR16 = ___VAR29 ; } }  else { ___VAR16 = 0 ; }
   ____1234Sort4321____ = 0 ; }   public void Print ( ) { int  ___VAR30 ;  int
   ___VAR31 ; ___VAR30 = 0 ;  ___VAR31 = size ;  while ( ___VAR30 < ___VAR31 )
   { { System.out.println ( number [ ___VAR30 ] ) ;  ___VAR30 = ___VAR30 + 1 ;
   }  ___VAR31 = size ; }   ____1234Print4321____ = 0 ; }   public void Init (
   int  ___VAR32  ) { int  ___VAR33 ; ___VAR33 = ___VAR32 ;  size = ___VAR33 ;
   number = new int [ ___VAR33 ] ;  number [ 0 ] = 20 ;  number [ 1 ] = 7 ;
   number [ 2 ] = 12 ;  number [ 3 ] = 18 ;  number [ 4 ] = 2 ;  number [ 5 ] =
   11 ;  number [ 6 ] = 6 ;  number [ 7 ] = 9 ;  number [ 8 ] = 19 ;  number [
   9 ] = 5 ;  ____1234Init4321____ = 0 ; } }
class ____NewMainClass____ { public void ____Main____ ( int  ___VAR34  ) { int
   ___VAR35 ;  QS  ___VAR36 ;  int  ___VAR37 ;  int  ___VAR64 ;  int  ___VAR65
   ;  QS  ___VAR66 ;  int  ___VAR67 ;  QS  ___VAR68 ;  int  ___VAR69 ;  QS
   ___VAR70 ;  int  ___VAR71 ;  QS  ___VAR72 ;  int  ___VAR73 ;  int  ___VAR63
   ; ___VAR36 = new QS ( ) ;  { ___VAR63 = 10 ;  ___VAR65 = ___VAR63 ;
   ___VAR66 = ___VAR36 ;  ___VAR66 . Init ( ___VAR65  ) ;  ___VAR67 = ___VAR66
   . ____1234Init4321____ ;  ___VAR64 = ___VAR67 ;  ___VAR68 = ___VAR36 ;
   ___VAR68 . Print ( ) ;  ___VAR69 = ___VAR68 . ____1234Print4321____ ;
   ___VAR64 = ___VAR69 ;  System.out.println ( 9999 ) ;  ___VAR64 = ___VAR36 .
   size - 1 ;  ___VAR70 = ___VAR36 ;  ___VAR70 . Sort ( 0 , ___VAR64 ) ;
   ___VAR71 = ___VAR70 . ____1234Sort4321____ ;  ___VAR64 = ___VAR71 ;
   ___VAR72 = ___VAR36 ;  ___VAR72 . Print ( ) ;  ___VAR73 = ___VAR72 .
   ____1234Print4321____ ;  ___VAR64 = ___VAR73 ;  ___VAR36 .
   ____1234Start4321____ = 0 ; }  ___VAR37 = ___VAR36 . ____1234Start4321____ ;
   ___VAR35 = ___VAR37 ;  System.out.println ( ___VAR35 ) ; } } 