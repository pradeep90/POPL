 class Factorial {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0 , new Continuation() ) ; } }
   class Fac { int  ____1234ComputeFac4321____ ; public void ComputeFac (int
   num , Continuation  ___k  ) { int  num_aux ;  int  ____writeable____num ;
   int  ____tmp0 ;  Fac  ___tmp4 ;  int  ___tmp3 ;
   ___ContinuationClasscontinuationMethod0  ___k1 ;
   ___ContinuationClasscontinuationMethod1  ___k2 ; ____writeable____num = num;
   if ( ____writeable____num < 1 ) { num_aux = 1;  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.num = num;  ___k1.num_aux
   = num_aux;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call(); }  else {
   ___tmp4 = this;  ___k2 = new ___ContinuationClasscontinuationMethod1();
   ___k2.num = num;  ___k2.____writeable____num = ____writeable____num;  ___k2.
   ___tmp4 = ___tmp4;  ___k2.___k = ___k;  ___k2.object = this; ___tmp4.
   ComputeFac(____writeable____num - 1 , ___k2); }  }  public void
   continuationMethod0 (int  num , int  num_aux   , Continuation  ___k  ) { int
   ____writeable____num ;  int  ____tmp0 ;  Fac  ___tmp4 ;  int  ___tmp3 ;
   ____1234ComputeFac4321____ = num_aux; ___k.call(); }  public void
   continuationMethod1 (int  num , int  ____writeable____num   , Fac  ___tmp4
   , Continuation  ___k  ) { int  num_aux ;  int  ____tmp0 ;  int  ___tmp3 ;
   ___ContinuationClasscontinuationMethod0  ___k1 ; ___tmp3 = ___tmp4.
   ____1234ComputeFac4321____;  ____tmp0 = ___tmp3;  num_aux =
   ____writeable____num * ____tmp0;  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.num = num;  ___k1.num_aux
   = num_aux;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call(); }}
class ____NewMainClass____ { public void ____Main____ (int  ____arg_length____
   , Continuation  ___k  ) { int  ____printMe____ ;  Fac  ___tmp6 ;  int
   ___tmp5 ;  ___ContinuationClasscontinuationMethod2  ___k1 ; ___tmp6 = new
   Fac();  ___k1 = new ___ContinuationClasscontinuationMethod2();  ___k1.
   ____arg_length____ = ____arg_length____;  ___k1.___tmp6 = ___tmp6;  ___k1.
   ___k = ___k;  ___k1.object = this; ___tmp6.ComputeFac(10 , ___k1); }  public
   void continuationMethod2 (int  ____arg_length____ , Fac  ___tmp6   ,
   Continuation  ___k  ) { int  ____printMe____ ;  int  ___tmp5 ; ___tmp5 =
   ___tmp6.____1234ComputeFac4321____;  ____printMe____ = ___tmp5;
   System.out.println ( ____printMe____ ) ; ___k.call(); }}
class ___ContinuationClasscontinuationMethod0 extends Continuation { int  num ;
   int  num_aux ; Continuation  ___k ; Fac  object ; public void call () {
   object.continuationMethod0(num , num_aux , ___k); }}
class ___ContinuationClasscontinuationMethod1 extends Continuation { int  num ;
   int  ____writeable____num ; Fac  ___tmp4 ; Continuation  ___k ; Fac  object
   ; public void call () { object.continuationMethod1(num ,
   ____writeable____num , ___tmp4 , ___k); }}
class ___ContinuationClasscontinuationMethod2 extends Continuation { int
   ____arg_length____ ; Fac  ___tmp6 ; Continuation  ___k ;
   ____NewMainClass____  object ; public void call () { object.
   continuationMethod2(____arg_length____ , ___tmp6 , ___k); }}
class Continuation { public void call () { }} 