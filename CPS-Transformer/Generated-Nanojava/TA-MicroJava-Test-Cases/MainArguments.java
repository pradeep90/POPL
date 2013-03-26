 class MainArguments {
public static void main ( String [ ] a ) {
new MainTest ( ) . ____Main____ ( 10 , true , 11 , new Continuation() ) ; } }
   class MainTest { public void ____Main____ (int  arg1 , boolean  flag   , int
   arg2   , Continuation  ___k  ) { int  check ;  MainTest  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod0  ___k1 ; ___pseudoThis = this; if (
   flag ) { check = arg1 + arg2;  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.arg1 = arg1;  ___k1.flag =
   flag;  ___k1.arg2 = arg2;  ___k1.check = check;  ___k1.___k = ___k;  ___k1.
   object = this; ___k1.call(); }  else { check = arg1 * arg2;  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.arg1 = arg1;  ___k1.flag =
   flag;  ___k1.arg2 = arg2;  ___k1.check = check;  ___k1.___k = ___k;  ___k1.
   object = this; ___k1.call(); }  }  public void continuationMethod0 (int
   arg1 , boolean  flag   , int  arg2   , int  check   , Continuation  ___k  )
   { MainTest  ___pseudoThis ; ___pseudoThis = this;  System.out.println (
   check ) ; ___k.call(); }}
class ___ContinuationClasscontinuationMethod0 extends Continuation { int  arg1
   ; boolean  flag ; int  arg2 ; int  check ; Continuation  ___k ; MainTest
   object ; public void call () { object.continuationMethod0(arg1 , flag , arg2
   , check , ___k); }}
class Continuation { public void call () { }} 