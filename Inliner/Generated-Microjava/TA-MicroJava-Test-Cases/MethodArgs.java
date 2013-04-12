 class MethodArgs {
public static void main ( String [ ] a ) {
new MATest ( ) . ____Main____ ( ) ; } }  class MATest { MATest  m1 ;   int [ ]
   crr ; public void ____Main____ ( ) { MATest  ___VAR0 ;  int  ___VAR13 ;  int
   ___VAR12 ;  boolean  ___VAR14 ;  MATest  ___VAR15 ;  int [ ]   ___VAR20 ;
   boolean  ___VAR16 ;  int  ___VAR17 ;  int [ ]   ___VAR18 ;  MATest  ___VAR19
   ; m1 = new MATest ( ) ;  ___VAR0 = new MATest ( ) ;  { ___VAR12 = 12 ;
   ___VAR13 = ___VAR12 + 5 ;  System.out.println ( ___VAR13 ) ; }  { ___VAR14 =
   true ;  if ( ___VAR14 ) { m1 . m1 = new MATest ( ) ;  m1 . foo ( 10  ) ; }
   else { m1 . bar ( false  ) ; }  }  { ___VAR15 = ___VAR0 ;  ___VAR15 . bar (
   true  ) ; }  crr = new int [ 10 ] ;  { ___VAR16 = true ;  ___VAR17 = 10 ;
   ___VAR18 = crr ;  ___VAR19 = ___VAR0 ;  if ( ___VAR16 ) { ___VAR20 =
   ___VAR18 ;  ___VAR19 . BarFoo ( ___VAR20  ) ; }  else { ___VAR20 = ___VAR18
   ;  ___VAR20 [ 5 ] = ( ( ___VAR20 [ 6 ] ) + ___VAR17 ) ;  ___VAR19 . bar (
   false  ) ; }  } }   public void foo ( int  ___VAR1  ) { int  ___VAR2 ;
   ___VAR2 = ___VAR1 + 5 ;  System.out.println ( ___VAR2 ) ; }   public void
   bar ( boolean  ___VAR3  ) { int  ___VAR22 ;  int  ___VAR21 ; if ( ___VAR3 )
   { m1 = new MATest ( ) ;  { ___VAR21 = 10 ;  ___VAR22 = ___VAR21 + 5 ;
   System.out.println ( ___VAR22 ) ; } }  else { m1 . bar ( false  ) ; }  }
   public void fooBar ( MATest  ___VAR4  ) { boolean  ___VAR23 ; { ___VAR23 =
   true ;  if ( ___VAR23 ) { ___VAR4 . m1 = new MATest ( ) ;  m1 . foo ( 10  )
   ; }  else { m1 . bar ( false  ) ; }  } }   public void BarFoo ( int [ ]
   ___VAR5  ) { int [ ]   ___VAR6 ; ___VAR6 = ___VAR5 ;  ___VAR6 [ 9 ] = 5 ;
   System.out.println ( ___VAR6 [ 9 ] ) ; }   public void complete ( boolean
   ___VAR7 , int  ___VAR8   , int [ ]   ___VAR9   , MATest  ___VAR10   ) { int
   [ ]   ___VAR11 ;  int [ ]   ___VAR25 ;  int [ ]   ___VAR24 ;  boolean
   ___VAR26 ; if ( ___VAR7 ) { ___VAR11 = ___VAR9 ;  { ___VAR24 = ___VAR11 ;
   ___VAR25 = ___VAR24 ;  ___VAR25 [ 9 ] = 5 ;  System.out.println ( ___VAR25 [
   9 ] ) ; } }  else { ___VAR11 = ___VAR9 ;  ___VAR11 [ 5 ] = ( ( ___VAR11 [ 6
   ] ) + ___VAR8 ) ;  { ___VAR26 = false ;  if ( ___VAR26 ) { ___VAR10 . m1 =
   new MATest ( ) ;  m1 . foo ( 10  ) ; }  else { m1 . bar ( false  ) ; }  } }
   } } 