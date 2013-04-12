 class MethodReturn {
public static void main ( String [ ] a ) {
new MRTest ( ) . ____Main____ ( ) ; } }  class MRTest { int  b ;   int  a ;
   boolean  z ;   MRTest  m1 ; public void ____Main____ ( ) { int  ___VAR0 ;
   int  ___VAR10 ;  int  ___VAR9 ;  boolean  ___VAR14 ;  int  ___VAR15 ;  int
   ___VAR16 ;  boolean  ___VAR11 ;  int  ___VAR12 ;  int  ___VAR13 ; z = true ;
   m1 = new MRTest ( ) ;  m1 . a = 10 ;  m1 . b = 20 ;  m1 . z = true ;
   ___VAR0 = m1 . a + m1 . b ;  System.out.println ( ___VAR0 ) ;  { ___VAR9 =
   ___VAR0 ;  ___VAR10 = ___VAR9 ;  ___VAR10 = ___VAR10 + 5 ;
   System.out.println ( ___VAR10 ) ;  m1 . a = 5 ; }  System.out.println (
   ___VAR0 ) ;  System.out.println ( a ) ;  { ___VAR11 = m1 . z ;  ___VAR12 =
   m1 . a ;  ___VAR13 = m1 . b ;  ___VAR14 = ___VAR11 ;  ___VAR15 = ___VAR12 ;
   ___VAR16 = ___VAR13 ;  ___VAR14 = false ;  ___VAR15 = ___VAR16 + ___VAR15 ;
   ___VAR16 = ___VAR15 * ___VAR16 ; }  if ( z & m1 . z  ) System.out.println (
   ( m1 . a + m1 . b ) ) ;  else System.out.println ( 9999 ) ;  }   public void
   foo ( int  ___VAR1  ) { int  ___VAR2 ; ___VAR2 = ___VAR1 ;  ___VAR2 =
   ___VAR2 + 5 ;  System.out.println ( ___VAR2 ) ;  a = 5 ; }   public void bar
   ( boolean  ___VAR3 , int  ___VAR4   , int  ___VAR5   ) { boolean  ___VAR6 ;
   int  ___VAR7 ;  int  ___VAR8 ; ___VAR6 = ___VAR3 ;  ___VAR7 = ___VAR4 ;
   ___VAR8 = ___VAR5 ;  ___VAR6 = false ;  ___VAR7 = ___VAR8 + ___VAR7 ;
   ___VAR8 = ___VAR7 * ___VAR8 ; } } 