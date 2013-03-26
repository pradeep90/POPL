 class NestedTest {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0 , new Continuation() ) ; } }
   class ____NewMainClass____ { public void ____Main____ (int
   ____arg_length____ , Continuation  ___k  ) { int  i ;  int  j ;  int  sum ;
   ____NewMainClass____  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod0  ___k1 ;
   ___ContinuationClasscontinuationMethod1  ___k2 ; ___pseudoThis = this;  i =
   3; if ( i < 4 ) { sum = 4; if ( 2 < i ) { sum = 6;  ___k2 = new
   ___ContinuationClasscontinuationMethod1();  ___k2.____arg_length____ =
   ____arg_length____;  ___k2.sum = sum;  ___k2.___k = ___k;  ___k2.object =
   this; ___k2.call(); }  else { sum = 7;  ___k2 = new
   ___ContinuationClasscontinuationMethod1();  ___k2.____arg_length____ =
   ____arg_length____;  ___k2.sum = sum;  ___k2.___k = ___k;  ___k2.object =
   this; ___k2.call(); }  }  else { sum = 5;  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.____arg_length____ =
   ____arg_length____;  ___k1.sum = sum;  ___k1.___k = ___k;  ___k1.object =
   this; ___k1.call(); }  }  public void continuationMethod0 (int
   ____arg_length____ , int  sum   , Continuation  ___k  ) { int  i ;  int  j ;
   ____NewMainClass____  ___pseudoThis ; ___pseudoThis = this;
   System.out.println ( sum ) ; ___k.call(); }  public void continuationMethod1
   (int  ____arg_length____ , int  sum   , Continuation  ___k  ) { int  i ;
   int  j ;  ___ContinuationClasscontinuationMethod0  ___k1 ;
   ____NewMainClass____  ___pseudoThis ; ___pseudoThis = this;  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.____arg_length____ =
   ____arg_length____;  ___k1.sum = sum;  ___k1.___k = ___k;  ___k1.object =
   this; ___k1.call(); }}
class ___ContinuationClasscontinuationMethod0 extends Continuation { int
   ____arg_length____ ; int  sum ; Continuation  ___k ; ____NewMainClass____
   object ; public void call () { object.continuationMethod0(____arg_length____
   , sum , ___k); }}
class ___ContinuationClasscontinuationMethod1 extends Continuation { int
   ____arg_length____ ; int  sum ; Continuation  ___k ; ____NewMainClass____
   object ; public void call () { object.continuationMethod1(____arg_length____
   , sum , ___k); }}
class Continuation { public void call () { }} 