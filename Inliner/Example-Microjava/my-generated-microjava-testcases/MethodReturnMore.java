 class MethodReturnMore {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ; } }  class Test3 { int
   ____1234Start4321____ ;   int  ____1234MessageSendIden4321____ ;   Test3
   ____1234Identifieer4321____ ;   boolean  ____1234BoolRet4321____ ;   int
   ____1234Allocation4321____ ;   int  ____1234ThisRet4321____ ;   int
   ____1234Foo4321____ ; public void Start ( int  x  ) { int  y ;  Test3  t1 ;
   boolean  flag ;  Test3  ___tmp2 ;  boolean  ___tmp3 ;  Test3  ___tmp4 ;
   Test3  ___tmp5 ;  Test3  ___tmp6 ;  int  ___tmp7 ;  Test3  ___tmp8 ;  int
   ___tmp9 ;  Test3  ___tmp10 ;  int  ___tmp11 ; t1 = new Test3 ( ) ;  ___tmp2
   = t1 ;  ___tmp2 . BoolRet ( x  ) ;  ___tmp3 = ___tmp2 .
   ____1234BoolRet4321____ ;  flag = ___tmp3 ;  ___tmp4 = t1 ;  ___tmp4 .
   Identifieer ( flag  ) ;  ___tmp5 = ___tmp4 . ____1234Identifieer4321____ ;
   t1 = ___tmp5 ;  ___tmp6 = t1 ;  ___tmp6 . MessageSendIden ( 10  ) ;  ___tmp7
   = ___tmp6 . ____1234MessageSendIden4321____ ;  y = ___tmp7 ;  ___tmp8 = t1 ;
   ___tmp8 . Allocation ( y  ) ;  ___tmp9 = ___tmp8 .
   ____1234Allocation4321____ ;  y = ___tmp9 ;  ___tmp10 = t1 ;  ___tmp10 .
   ThisRet ( y  ) ;  ___tmp11 = ___tmp10 . ____1234ThisRet4321____ ;  y =
   ___tmp11 ;  ____1234Start4321____ = 20 + y ; }   public void MessageSendIden
   ( int  x  ) { Test3  t1 ;  Test3  ___tmp12 ;  int  ___tmp13 ; t1 = new Test3
   ( ) ;  ___tmp12 = t1 ;  ___tmp12 . Foo ( x  ) ;  ___tmp13 = ___tmp12 .
   ____1234Foo4321____ ;  ____1234MessageSendIden4321____ = ( ___tmp13 ) ; }
   public void Identifieer ( boolean  x  ) { Test3  t1 ; t1 = new Test3 ( ) ;
   ____1234Identifieer4321____ = t1 ; }   public void BoolRet ( int  x  ) {
   boolean  bol ; bol = true ;  ____1234BoolRet4321____ = bol ; }   public void
   Allocation ( int  x  ) { Test3  ___tmp14 ;  int  ___tmp15 ; ___tmp14 = new
   Test3 ( ) ;  ___tmp14 . Foo ( x  ) ;  ___tmp15 = ___tmp14 .
   ____1234Foo4321____ ;  ____1234Allocation4321____ = ( ___tmp15 ) ; }
   public void ThisRet ( int  x  ) { Test3  ___tmp16 ;  int  ___tmp17 ;
   ___tmp16 = this ;  ___tmp16 . Foo ( x  ) ;  ___tmp17 = ___tmp16 .
   ____1234Foo4321____ ;  ____1234ThisRet4321____ = ___tmp17 ; }   public void
   Foo ( int  x  ) { ____1234Foo4321____ = x ; } }
class ____NewMainClass____ { public void ____Main____ ( int  ____arg_length____
   ) { Test3  ___tmp0 ;  int  ___tmp1 ; ___tmp0 = new Test3 ( ) ;  ___tmp0 .
   Start ( 10  ) ;  ___tmp1 = ___tmp0 . ____1234Start4321____ ;
   System.out.println ( ___tmp1 ) ; } } 