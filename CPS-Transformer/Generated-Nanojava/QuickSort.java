 class QuickSort {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0 , new Continuation() ) ; } }
   class QS { int [ ]   number ;   int  size ;   int  ____1234Start4321____ ;
   int  ____1234Sort4321____ ;   int  ____1234Print4321____ ;   int
   ____1234Init4321____ ; public void Sort (int  left , int  right   ,
   Continuation  ___k  ) { int  v ;  int  i ;  int  j ;  int  nt ;  int  t ;
   boolean  cont01 ;  boolean  cont02 ;  int  aux03 ;  int
   ____writeable____right ;  int  ____writeable____left ;  boolean  ____tmp8 ;
   boolean  ____tmp9 ;  int  ____tmp10 ;  QS  ___tmp12 ;  int  ___tmp11 ;  QS
   ___tmp14 ;  int  ___tmp13 ;  QS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod0  ___k1 ;
   ___ContinuationClasscontinuationMethod1  ___k2 ; ___pseudoThis = this;
   ____writeable____left = left;  ____writeable____right = right;  t = 0; if (
   ____writeable____left < ____writeable____right ) { ___k2 = new
   ___ContinuationClasscontinuationMethod1();  ___k2.left = left;  ___k2.right
   = right;  ___k2.i = i;  ___k2.____writeable____left = ____writeable____left;
   ___k2.___tmp12 = ___tmp12;  ___k2.___k = ___k;  ___k2.object = this;
   ___pseudoThis.whileMethod1(left , right , cont01 , ___k2); }  else { nt = 0;
   ___k1 = new ___ContinuationClasscontinuationMethod0();  ___k1.left = left;
   ___k1.right = right;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call();
   }  }  public void continuationMethod0 (int  left , int  right   ,
   Continuation  ___k  ) { QS  ___pseudoThis ; ___pseudoThis = this;
   ____1234Sort4321____ = 0; ___k.call(); }  public void continuationMethod2 (
   int  left , int  right   , int  i   , int  ____writeable____left   , QS
   ___tmp12   , Continuation  ___k  ) { QS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod0  ___k1 ; ___pseudoThis = this;
   ___k1 = new ___ContinuationClasscontinuationMethod0();  ___k1.left = left;
   ___k1.right = right;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call();
   }  public void continuationMethod1 (int  left , int  right   , int  i   ,
   int  ____writeable____left   , QS  ___tmp12   , Continuation  ___k  ) { QS
   ___pseudoThis ;  ___ContinuationClasscontinuationMethod2  ___k1 ;
   ___pseudoThis = this;  ___k1 = new ___ContinuationClasscontinuationMethod2()
   ;  ___k1.left = left;  ___k1.right = right;  ___k1.i = i;  ___k1.
   ____writeable____left = ____writeable____left;  ___k1.___tmp12 = ___tmp12;
   ___k1.___k = ___k;  ___k1.object = this; ___tmp12.SortFoo(
   ____writeable____left , i - 1 , ___k1); }  public void whileMethod1 (int
   left , int  right   , boolean  cont01   , Continuation  ___k  ) { int  v ;
   int  i ;  int  j ;  int  nt ;  int  t ;  boolean  cont02 ;  int  aux03 ;
   int  ____writeable____right ;  int  ____writeable____left ;  boolean
   ____tmp8 ;  boolean  ____tmp9 ;  int  ____tmp10 ;  QS  ___tmp12 ;  int
   ___tmp11 ;  QS  ___tmp14 ;  int  ___tmp13 ;  QS  ___pseudoThis ;
   ___pseudoThis = this; if ( cont01 ) { ___pseudoThis.whileMethod1(left ,
   right , cont01 , ___k); }  else { ___k.call(); }  }}
class ____NewMainClass____ { public void ____Main____ (int  ____arg_length____
   , Continuation  ___k  ) { int  ____printMe____ ;  QS  ___tmp17 ;  int
   ___tmp16 ;  ____NewMainClass____  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod3  ___k1 ; ___pseudoThis = this;
   ___tmp17 = new QS();  ___k1 = new ___ContinuationClasscontinuationMethod3();
   ___k1.____arg_length____ = ____arg_length____;  ___k1.___tmp17 = ___tmp17;
   ___k1.___k = ___k;  ___k1.object = this; ___tmp17.Start(10 , ___k1); }
   public void continuationMethod3 (int  ____arg_length____ , QS  ___tmp17   ,
   Continuation  ___k  ) { int  ____printMe____ ;  int  ___tmp16 ;
   ____NewMainClass____  ___pseudoThis ; ___pseudoThis = this;  ___tmp16 =
   ___tmp17.____1234Start4321____;  ____printMe____ = ___tmp16;
   System.out.println ( ____printMe____ ) ; ___k.call(); }}
class ___ContinuationClasscontinuationMethod0 extends Continuation { int  left
   ; int  right ; Continuation  ___k ; QS  object ; public void call () {
   object.continuationMethod0(left , right , ___k); }}
class ___ContinuationClasscontinuationMethod2 extends Continuation { int  left
   ; int  right ; int  i ; int  ____writeable____left ; QS  ___tmp12 ;
   Continuation  ___k ; QS  object ; public void call () { object.
   continuationMethod2(left , right , i , ____writeable____left , ___tmp12 ,
   ___k); }}
class ___ContinuationClasscontinuationMethod1 extends Continuation { int  left
   ; int  right ; int  i ; int  ____writeable____left ; QS  ___tmp12 ;
   Continuation  ___k ; QS  object ; public void call () { object.
   continuationMethod1(left , right , i , ____writeable____left , ___tmp12 ,
   ___k); }}
class ___ContinuationClasscontinuationMethod3 extends Continuation { int
   ____arg_length____ ; QS  ___tmp17 ; Continuation  ___k ;
   ____NewMainClass____  object ; public void call () { object.
   continuationMethod3(____arg_length____ , ___tmp17 , ___k); }}
class Continuation { public void call () { }} 