 class BubbleSort {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0 , new Continuation() ) ; } }
   class BBS { int [ ]   number ;   int  size ;   int  ____1234Start4321____ ;
   int  ____1234Sort4321____ ;   int  ____1234Print4321____ ;   int
   ____1234Init4321____ ; public void Start (int  sz , Continuation  ___k  ) {
   int  aux01 ;  int  ____writeable____sz ;  BBS  ___tmp1 ;  int  ___tmp0 ;
   BBS  ___tmp3 ;  int  ___tmp2 ;  BBS  ___tmp5 ;  int  ___tmp4 ;  BBS  ___tmp7
   ;  int  ___tmp6 ;  BBS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod0  ___k1 ; ___pseudoThis = this;
   ____writeable____sz = sz;  ___tmp1 = this;  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.sz = sz;  ___k1.___tmp1 =
   ___tmp1;  ___k1.___k = ___k;  ___k1.object = this; ___tmp1.Init(
   ____writeable____sz , ___k1); }  public void Sort (Continuation  ___k ) {
   int  nt ;  int  i ;  int  aux02 ;  int  aux04 ;  int  aux05 ;  int  aux06 ;
   int  aux07 ;  int  j ;  int  t ;  int  ____tmp8 ;  BBS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod4  ___k1 ; ___pseudoThis = this;  i =
   size - 1;  aux02 = 0 - 1;  ___k1 = new
   ___ContinuationClasscontinuationMethod4();  ___k1.___k = ___k;  ___k1.object
   = this; ___pseudoThis.whileMethod2(i , aux02 , ___k1); }  public void Print
   (Continuation  ___k ) { int  j ;  int  ____tmp9 ;  BBS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod7  ___k1 ; ___pseudoThis = this;  j =
   0;  ____tmp9 = size;  ___k1 = new ___ContinuationClasscontinuationMethod7();
   ___k1.___k = ___k;  ___k1.object = this; ___pseudoThis.whileMethod3(j ,
   ____tmp9 , ___k1); }  public void Init (int  sz , Continuation  ___k  ) {
   int  ____writeable____sz ;  BBS  ___pseudoThis ; ___pseudoThis = this;
   ____writeable____sz = sz;  size = ____writeable____sz;  number = new int[
   ____writeable____sz];  number[0] = 20;  number[1] = 7;  number[2] = 12;
   number[3] = 18;  number[4] = 2;  number[5] = 11;  number[6] = 6;  number[7]
   = 9;  number[8] = 19;  number[9] = 5;  ____1234Init4321____ = 0; ___k.call()
   ; }  public void continuationMethod3 (int  sz , BBS  ___tmp1   , BBS
   ___tmp3   , BBS  ___tmp5   , BBS  ___tmp7   , Continuation  ___k  ) { int
   aux01 ;  int  ___tmp6 ;  BBS  ___pseudoThis ; ___pseudoThis = this;  ___tmp6
   = ___tmp7.____1234Print4321____;  aux01 = ___tmp6;  ____1234Start4321____ =
   0; ___k.call(); }  public void continuationMethod2 (int  sz , BBS  ___tmp1
   , BBS  ___tmp3   , BBS  ___tmp5   , Continuation  ___k  ) { int  aux01 ;
   int  ___tmp4 ;  BBS  ___tmp7 ;  BBS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod3  ___k1 ; ___pseudoThis = this;
   ___tmp4 = ___tmp5.____1234Sort4321____;  aux01 = ___tmp4;  ___tmp7 = this;
   ___k1 = new ___ContinuationClasscontinuationMethod3();  ___k1.sz = sz;
   ___k1.___tmp1 = ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;
   ___k1.___tmp7 = ___tmp7;  ___k1.___k = ___k;  ___k1.object = this; ___tmp7.
   Print(___k1 ); }  public void continuationMethod1 (int  sz , BBS  ___tmp1
   , BBS  ___tmp3   , Continuation  ___k  ) { int  aux01 ;  int  ___tmp2 ;  BBS
   ___tmp5 ;  BBS  ___pseudoThis ;  ___ContinuationClasscontinuationMethod2
   ___k1 ; ___pseudoThis = this;  ___tmp2 = ___tmp3.____1234Print4321____;
   aux01 = ___tmp2;  System.out.println ( 99999 ) ;  ___tmp5 = this;  ___k1 =
   new ___ContinuationClasscontinuationMethod2();  ___k1.sz = sz;  ___k1.
   ___tmp1 = ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;
   ___k1.___k = ___k;  ___k1.object = this; ___tmp5.Sort(___k1 ); }  public
   void continuationMethod0 (int  sz , BBS  ___tmp1   , Continuation  ___k  ) {
   int  aux01 ;  int  ___tmp0 ;  BBS  ___tmp3 ;  BBS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod1  ___k1 ; ___pseudoThis = this;
   ___tmp0 = ___tmp1.____1234Init4321____;  aux01 = ___tmp0;  ___tmp3 = this;
   ___k1 = new ___ContinuationClasscontinuationMethod1();  ___k1.sz = sz;
   ___k1.___tmp1 = ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___k = ___k;
   ___k1.object = this; ___tmp3.Print(___k1 ); }  public void
   continuationMethod4 (Continuation  ___k ) { BBS  ___pseudoThis ;
   ___pseudoThis = this;  ____1234Sort4321____ = 0; ___k.call(); }  public void
   continuationMethod5 (int  i , int  aux02   , Continuation  ___k  ) { BBS
   ___pseudoThis ; ___pseudoThis = this;  i = i - 1; ___pseudoThis.whileMethod1
   (i , aux02 , ___k); }  public void continuationMethod6 (int  i , int  aux02
   , int  j   , int  ____tmp8   , Continuation  ___k  ) { BBS  ___pseudoThis ;
   ___pseudoThis = this;  j = j + 1;  ____tmp8 = i + 1; ___pseudoThis.
   whileMethod2(i , aux02 , j , ____tmp8 , ___k); }  public void whileMethod2 (
   int  i , int  aux02   , int  j   , int  ____tmp8   , Continuation  ___k  ) {
   int  nt ;  int  aux04 ;  int  aux05 ;  int  aux06 ;  int  aux07 ;  int  t ;
   BBS  ___pseudoThis ;  ___ContinuationClasscontinuationMethod6  ___k1 ;
   ___pseudoThis = this; if ( j < ____tmp8 ) { aux07 = j - 1;  aux04 = number [
   aux07 ];  aux05 = number [ j ]; if ( aux05 < aux04 ) { aux06 = j - 1;  t =
   number [ aux06 ];  number[aux06] = number [ j ];  number[j] = t;  ___k1 =
   new ___ContinuationClasscontinuationMethod6();  ___k1.i = i;  ___k1.aux02 =
   aux02;  ___k1.j = j;  ___k1.____tmp8 = ____tmp8;  ___k1.___k = ___k;  ___k1.
   object = this; ___k1.call(); }  else { nt = 0;  ___k1 = new
   ___ContinuationClasscontinuationMethod6();  ___k1.i = i;  ___k1.aux02 =
   aux02;  ___k1.j = j;  ___k1.____tmp8 = ____tmp8;  ___k1.___k = ___k;  ___k1.
   object = this; ___k1.call(); }  }  else { ___k.call(); }  }  public void
   whileMethod1 (int  i , int  aux02   , Continuation  ___k  ) { int  nt ;  int
   aux04 ;  int  aux05 ;  int  aux06 ;  int  aux07 ;  int  j ;  int  t ;  int
   ____tmp8 ;  BBS  ___pseudoThis ;  ___ContinuationClasscontinuationMethod5
   ___k1 ; ___pseudoThis = this; if ( aux02 < i ) { j = 1;  ____tmp8 = i + 1;
   ___k1 = new ___ContinuationClasscontinuationMethod5();  ___k1.i = i;  ___k1.
   aux02 = aux02;  ___k1.___k = ___k;  ___k1.object = this; ___pseudoThis.
   whileMethod2(i , aux02 , j , ____tmp8 , ___k1); }  else { ___k.call(); }  }
   public void continuationMethod7 (Continuation  ___k ) { BBS  ___pseudoThis ;
   ___pseudoThis = this;  ____1234Print4321____ = 0; ___k.call(); }  public
   void whileMethod3 (int  j , int  ____tmp9   , Continuation  ___k  ) { BBS
   ___pseudoThis ; ___pseudoThis = this; if ( j < ____tmp9 ) {
   System.out.println ( number [ j ] ) ;  j = j + 1;  ____tmp9 = size;
   ___pseudoThis.whileMethod3(j , ____tmp9 , ___k); }  else { ___k.call(); }  }
   }
class ____NewMainClass____ { public void ____Main____ (int  ____arg_length____
   , Continuation  ___k  ) { int  ____printMe____ ;  BBS  ___tmp11 ;  int
   ___tmp10 ;  ____NewMainClass____  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod8  ___k1 ; ___pseudoThis = this;
   ___tmp11 = new BBS();  ___k1 = new ___ContinuationClasscontinuationMethod8()
   ;  ___k1.____arg_length____ = ____arg_length____;  ___k1.___tmp11 = ___tmp11
   ;  ___k1.___k = ___k;  ___k1.object = this; ___tmp11.Start(10 , ___k1); }
   public void continuationMethod8 (int  ____arg_length____ , BBS  ___tmp11   ,
   Continuation  ___k  ) { int  ____printMe____ ;  int  ___tmp10 ;
   ____NewMainClass____  ___pseudoThis ; ___pseudoThis = this;  ___tmp10 =
   ___tmp11.____1234Start4321____;  ____printMe____ = ___tmp10;
   System.out.println ( ____printMe____ ) ; ___k.call(); }}
class ___ContinuationClasscontinuationMethod3 extends Continuation { int  sz ;
   BBS  ___tmp1 ; BBS  ___tmp3 ; BBS  ___tmp5 ; BBS  ___tmp7 ; Continuation
   ___k ; BBS  object ; public void call () { object.continuationMethod3(sz ,
   ___tmp1 , ___tmp3 , ___tmp5 , ___tmp7 , ___k); }}
class ___ContinuationClasscontinuationMethod2 extends Continuation { int  sz ;
   BBS  ___tmp1 ; BBS  ___tmp3 ; BBS  ___tmp5 ; Continuation  ___k ; BBS
   object ; public void call () { object.continuationMethod2(sz , ___tmp1 ,
   ___tmp3 , ___tmp5 , ___k); }}
class ___ContinuationClasscontinuationMethod1 extends Continuation { int  sz ;
   BBS  ___tmp1 ; BBS  ___tmp3 ; Continuation  ___k ; BBS  object ; public void
   call () { object.continuationMethod1(sz , ___tmp1 , ___tmp3 , ___k); }}
class ___ContinuationClasscontinuationMethod0 extends Continuation { int  sz ;
   BBS  ___tmp1 ; Continuation  ___k ; BBS  object ; public void call () {
   object.continuationMethod0(sz , ___tmp1 , ___k); }}
class ___ContinuationClasscontinuationMethod4 extends Continuation {
   Continuation  ___k ; BBS  object ; public void call () { object.
   continuationMethod4(___k ); }}
class ___ContinuationClasscontinuationMethod5 extends Continuation { int  i ;
   int  aux02 ; Continuation  ___k ; BBS  object ; public void call () { object
   .continuationMethod5(i , aux02 , ___k); }}
class ___ContinuationClasscontinuationMethod6 extends Continuation { int  i ;
   int  aux02 ; int  j ; int  ____tmp8 ; Continuation  ___k ; BBS  object ;
   public void call () { object.continuationMethod6(i , aux02 , j , ____tmp8 ,
   ___k); }}
class ___ContinuationClasscontinuationMethod7 extends Continuation {
   Continuation  ___k ; BBS  object ; public void call () { object.
   continuationMethod7(___k ); }}
class ___ContinuationClasscontinuationMethod8 extends Continuation { int
   ____arg_length____ ; BBS  ___tmp11 ; Continuation  ___k ;
   ____NewMainClass____  object ; public void call () { object.
   continuationMethod8(____arg_length____ , ___tmp11 , ___k); }}
class Continuation { public void call () { }} 