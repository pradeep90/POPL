 class IfCheck {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ; } }  class Test6 { boolean
   a ;   int  ____1234Start4321____ ;   boolean  ____1234Foo4321____ ; public
   void Start ( int  x  ) { Test6  tx ;  Test6  ___tmp2 ;  boolean  ___tmp3 ;
   Test6  ___tmp4 ;  boolean  ___tmp5 ; tx = new Test6 ( ) ;  a = true ;
   ___tmp2 = tx ;  ___tmp2 . Foo ( ) ;  ___tmp3 = ___tmp2 . ____1234Foo4321____
   ;  if ( a & ( ___tmp3 )  ) { a = ( true & false  ) ; }  else { ___tmp4 = tx
   ;  ___tmp4 . Foo ( ) ;  ___tmp5 = ___tmp4 . ____1234Foo4321____ ;  if ( !
   ___tmp5 ) { a = false ; }  else a = true ;  }   ____1234Start4321____ = 10 +
   x ; }   public void Foo (  ) { ____1234Foo4321____ = ( true & false  ) ; } }
class ____NewMainClass____ { public void ____Main____ ( int  ____arg_length____
   ) { Test6  ___tmp0 ;  int  ___tmp1 ; ___tmp0 = new Test6 ( ) ;  ___tmp0 .
   Start ( 10  ) ;  ___tmp1 = ___tmp0 . ____1234Start4321____ ;
   System.out.println ( ___tmp1 ) ; } } 