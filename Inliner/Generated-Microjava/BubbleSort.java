 class BubbleSort {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ; } }  class BBS { int [ ]
   number ;   int  size ;   int  ____1234Start4321____ ;   int
   ____1234Sort4321____ ;   int  ____1234Print4321____ ;   int
   ____1234Init4321____ ; public void Start ( int  ___VAR0  ) { int  ___VAR1 ;
   int  ___VAR2 ;  BBS  ___VAR3 ;  int  ___VAR4 ;  BBS  ___VAR5 ;  int  ___VAR6
   ;  BBS  ___VAR7 ;  int  ___VAR8 ;  BBS  ___VAR9 ;  int  ___VAR10 ;  int
   ___VAR30 ;  int  ___VAR29 ;  int  ___VAR31 ;  int  ___VAR32 ;  int  ___VAR33
   ;  int  ___VAR34 ;  int  ___VAR35 ;  int  ___VAR36 ;  int  ___VAR37 ;  int
   ___VAR38 ;  int  ___VAR39 ;  int  ___VAR40 ;  int  ___VAR41 ;  int  ___VAR42
   ;  int  ___VAR43 ;  int  ___VAR44 ; ___VAR2 = ___VAR0 ;  ___VAR3 = this ;  {
   ___VAR29 = ___VAR2 ;  ___VAR30 = ___VAR29 ;  ___VAR3 . size = ___VAR30 ;
   ___VAR3 . number = new int [ ___VAR30 ] ;  number [ 0 ] = 20 ;  number [ 1 ]
   = 7 ;  number [ 2 ] = 12 ;  number [ 3 ] = 18 ;  number [ 4 ] = 2 ;  number
   [ 5 ] = 11 ;  number [ 6 ] = 6 ;  number [ 7 ] = 9 ;  number [ 8 ] = 19 ;
   number [ 9 ] = 5 ;  ___VAR3 . ____1234Init4321____ = 0 ; }  ___VAR4 =
   ___VAR3 . ____1234Init4321____ ;  ___VAR1 = ___VAR4 ;  ___VAR5 = this ;  {
   ___VAR31 = 0 ;  ___VAR32 = ___VAR5 . size ;  while ( ___VAR31 < ___VAR32 ) {
   { System.out.println ( ___VAR5 . number [ ___VAR31 ] ) ;  ___VAR31 =
   ___VAR31 + 1 ; }  ___VAR32 = ___VAR5 . size ; }   ___VAR5 .
   ____1234Print4321____ = 0 ; }  ___VAR6 = ___VAR5 . ____1234Print4321____ ;
   ___VAR1 = ___VAR6 ;  System.out.println ( 99999 ) ;  ___VAR7 = this ;  {
   ___VAR34 = ___VAR7 . size - 1 ;  ___VAR35 = 0 - 1 ;  while ( ___VAR35 <
   ___VAR34 ) { { ___VAR40 = 1 ;  ___VAR42 = ___VAR34 + 1 ;  while ( ___VAR40 <
   ___VAR42 ) { { ___VAR39 = ___VAR40 - 1 ;  ___VAR36 = ___VAR7 . number [
   ___VAR39 ] ;  ___VAR37 = ___VAR7 . number [ ___VAR40 ] ;  if ( ___VAR37 <
   ___VAR36 ) { { ___VAR38 = ___VAR40 - 1 ;  ___VAR41 = ___VAR7 . number [
   ___VAR38 ] ;  number [ ___VAR38 ] = ___VAR7 . number [ ___VAR40 ] ;  number
   [ ___VAR40 ] = ___VAR41 ; } }  else { ___VAR33 = 0 ; }   ___VAR40 = ___VAR40
   + 1 ; }  ___VAR42 = ___VAR34 + 1 ; }   ___VAR34 = ___VAR34 - 1 ; } }
   ___VAR7 . ____1234Sort4321____ = 0 ; }  ___VAR8 = ___VAR7 .
   ____1234Sort4321____ ;  ___VAR1 = ___VAR8 ;  ___VAR9 = this ;  { ___VAR43 =
   0 ;  ___VAR44 = ___VAR9 . size ;  while ( ___VAR43 < ___VAR44 ) { {
   System.out.println ( ___VAR9 . number [ ___VAR43 ] ) ;  ___VAR43 = ___VAR43
   + 1 ; }  ___VAR44 = ___VAR9 . size ; }   ___VAR9 . ____1234Print4321____ = 0
   ; }  ___VAR10 = ___VAR9 . ____1234Print4321____ ;  ___VAR1 = ___VAR10 ;
   ____1234Start4321____ = 0 ; }   public void Sort ( ) { int  ___VAR11 ;  int
   ___VAR12 ;  int  ___VAR13 ;  int  ___VAR14 ;  int  ___VAR15 ;  int  ___VAR16
   ;  int  ___VAR17 ;  int  ___VAR18 ;  int  ___VAR19 ;  int  ___VAR20 ;
   ___VAR12 = size - 1 ;  ___VAR13 = 0 - 1 ;  while ( ___VAR13 < ___VAR12 ) { {
   ___VAR18 = 1 ;  ___VAR20 = ___VAR12 + 1 ;  while ( ___VAR18 < ___VAR20 ) { {
   ___VAR17 = ___VAR18 - 1 ;  ___VAR14 = number [ ___VAR17 ] ;  ___VAR15 =
   number [ ___VAR18 ] ;  if ( ___VAR15 < ___VAR14 ) { { ___VAR16 = ___VAR18 -
   1 ;  ___VAR19 = number [ ___VAR16 ] ;  number [ ___VAR16 ] = number [
   ___VAR18 ] ;  number [ ___VAR18 ] = ___VAR19 ; } }  else { ___VAR11 = 0 ; }
   ___VAR18 = ___VAR18 + 1 ; }  ___VAR20 = ___VAR12 + 1 ; }   ___VAR12 =
   ___VAR12 - 1 ; } }   ____1234Sort4321____ = 0 ; }   public void Print ( ) {
   int  ___VAR21 ;  int  ___VAR22 ; ___VAR21 = 0 ;  ___VAR22 = size ;  while (
   ___VAR21 < ___VAR22 ) { { System.out.println ( number [ ___VAR21 ] ) ;
   ___VAR21 = ___VAR21 + 1 ; }  ___VAR22 = size ; }   ____1234Print4321____ = 0
   ; }   public void Init ( int  ___VAR23  ) { int  ___VAR24 ; ___VAR24 =
   ___VAR23 ;  size = ___VAR24 ;  number = new int [ ___VAR24 ] ;  number [ 0 ]
   = 20 ;  number [ 1 ] = 7 ;  number [ 2 ] = 12 ;  number [ 3 ] = 18 ;  number
   [ 4 ] = 2 ;  number [ 5 ] = 11 ;  number [ 6 ] = 6 ;  number [ 7 ] = 9 ;
   number [ 8 ] = 19 ;  number [ 9 ] = 5 ;  ____1234Init4321____ = 0 ; } }
class ____NewMainClass____ { public void ____Main____ ( int  ___VAR25  ) { int
   ___VAR26 ;  BBS  ___VAR27 ;  int  ___VAR28 ;  int  ___VAR46 ;  int  ___VAR47
   ;  BBS  ___VAR48 ;  int  ___VAR49 ;  BBS  ___VAR50 ;  int  ___VAR51 ;  BBS
   ___VAR52 ;  int  ___VAR53 ;  BBS  ___VAR54 ;  int  ___VAR55 ;  int  ___VAR45
   ; ___VAR27 = new BBS ( ) ;  { ___VAR45 = 10 ;  ___VAR47 = ___VAR45 ;
   ___VAR48 = ___VAR27 ;  ___VAR48 . Init ( ___VAR47  ) ;  ___VAR49 = ___VAR48
   . ____1234Init4321____ ;  ___VAR46 = ___VAR49 ;  ___VAR50 = ___VAR27 ;
   ___VAR50 . Print ( ) ;  ___VAR51 = ___VAR50 . ____1234Print4321____ ;
   ___VAR46 = ___VAR51 ;  System.out.println ( 99999 ) ;  ___VAR52 = ___VAR27 ;
   ___VAR52 . Sort ( ) ;  ___VAR53 = ___VAR52 . ____1234Sort4321____ ;
   ___VAR46 = ___VAR53 ;  ___VAR54 = ___VAR27 ;  ___VAR54 . Print ( ) ;
   ___VAR55 = ___VAR54 . ____1234Print4321____ ;  ___VAR46 = ___VAR55 ;
   ___VAR27 . ____1234Start4321____ = 0 ; }  ___VAR28 = ___VAR27 .
   ____1234Start4321____ ;  ___VAR26 = ___VAR28 ;  System.out.println (
   ___VAR26 ) ; } } 