 class QuickSort {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0 , new Continuation() ) ; } }
   class QS { int [ ]   number ;   int  size ;   int  ____1234Start4321____ ;
   int  ____1234Sort4321____ ;   int  ____1234Print4321____ ;   int
   ____1234Init4321____ ; public void Start (int  sz , Continuation  ___k  ) {
   int  aux01 ;  int  ____writeable____sz ;  QS  ___tmp1 ;  int  ___tmp0 ;  QS
   ___tmp3 ;  int  ___tmp2 ;  QS  ___tmp5 ;  int  ___tmp4 ;  QS  ___tmp7 ;  int
   ___tmp6 ;  QS  ___pseudoThis ;  ___ContinuationClasscontinuationMethod0
   ___k1 ; ___pseudoThis = this;  ____writeable____sz = sz;  ___tmp1 = this;
   ___k1 = new ___ContinuationClasscontinuationMethod0();  ___k1.sz = sz;
   ___k1.___tmp1 = ___tmp1;  ___k1.___k = ___k;  ___k1.object = this; ___tmp1.
   Init(____writeable____sz , ___k1); }  public void Sort (int  left , int
   right   , Continuation  ___k  ) { int  v ;  int  i ;  int  j ;  int  nt ;
   int  t ;  boolean  cont01 ;  boolean  cont02 ;  int  aux03 ;  int
   ____writeable____right ;  int  ____writeable____left ;  boolean  ____tmp8 ;
   boolean  ____tmp9 ;  int  ____tmp10 ;  QS  ___tmp12 ;  int  ___tmp11 ;  QS
   ___tmp14 ;  int  ___tmp13 ;  QS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod4  ___k1 ;
   ___ContinuationClasscontinuationMethod5  ___k2 ; ___pseudoThis = this;
   ____writeable____left = left;  ____writeable____right = right;  t = 0; if (
   ____writeable____left < ____writeable____right ) { v = number [
   ____writeable____right ];  i = ____writeable____left - 1;  j =
   ____writeable____right;  cont01 = true;  ___k2 = new
   ___ContinuationClasscontinuationMethod5();  ___k2.left = left;  ___k2.right
   = right;  ___k2.i = i;  ___k2.j = j;  ___k2.t = t;  ___k2.
   ____writeable____right = ____writeable____right;  ___k2.
   ____writeable____left = ____writeable____left;  ___k2.___k = ___k;  ___k2.
   object = this; ___pseudoThis.whileMethod3(left , right , v , i , j , cont01
   , ___k2); }  else { nt = 0;  ___k1 = new
   ___ContinuationClasscontinuationMethod4();  ___k1.left = left;  ___k1.right
   = right;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call(); }  }
   public void Print (Continuation  ___k ) { int  j ;  int  ____tmp15 ;  QS
   ___pseudoThis ;  ___ContinuationClasscontinuationMethod13  ___k1 ;
   ___pseudoThis = this;  j = 0;  ____tmp15 = size;  ___k1 = new
   ___ContinuationClasscontinuationMethod13();  ___k1.___k = ___k;  ___k1.
   object = this; ___pseudoThis.whileMethod4(j , ____tmp15 , ___k1); }  public
   void Init (int  sz , Continuation  ___k  ) { int  ____writeable____sz ;  QS
   ___pseudoThis ; ___pseudoThis = this;  ____writeable____sz = sz;  size =
   ____writeable____sz;  number = new int[____writeable____sz];  number[0] = 20
   ;  number[1] = 7;  number[2] = 12;  number[3] = 18;  number[4] = 2;  number[
   5] = 11;  number[6] = 6;  number[7] = 9;  number[8] = 19;  number[9] = 5;
   ____1234Init4321____ = 0; ___k.call(); }  public void continuationMethod3 (
   int  sz , QS  ___tmp1   , QS  ___tmp3   , QS  ___tmp5   , QS  ___tmp7   ,
   Continuation  ___k  ) { int  aux01 ;  int  ___tmp6 ;  QS  ___pseudoThis ;
   ___pseudoThis = this;  ___tmp6 = ___tmp7.____1234Print4321____;  aux01 =
   ___tmp6;  ____1234Start4321____ = 0; ___k.call(); }  public void
   continuationMethod2 (int  sz , QS  ___tmp1   , QS  ___tmp3   , QS  ___tmp5
   , Continuation  ___k  ) { int  aux01 ;  int  ___tmp4 ;  QS  ___tmp7 ;  QS
   ___pseudoThis ;  ___ContinuationClasscontinuationMethod3  ___k1 ;
   ___pseudoThis = this;  ___tmp4 = ___tmp5.____1234Sort4321____;  aux01 =
   ___tmp4;  ___tmp7 = this;  ___k1 = new
   ___ContinuationClasscontinuationMethod3();  ___k1.sz = sz;  ___k1.___tmp1 =
   ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;  ___k1.___tmp7
   = ___tmp7;  ___k1.___k = ___k;  ___k1.object = this; ___tmp7.Print(___k1 );
   }  public void continuationMethod1 (int  sz , QS  ___tmp1   , QS  ___tmp3
   , Continuation  ___k  ) { int  aux01 ;  int  ___tmp2 ;  QS  ___tmp5 ;  QS
   ___pseudoThis ;  ___ContinuationClasscontinuationMethod2  ___k1 ;
   ___pseudoThis = this;  ___tmp2 = ___tmp3.____1234Print4321____;  aux01 =
   ___tmp2;  System.out.println ( 9999 ) ;  aux01 = size - 1;  ___tmp5 = this;
   ___k1 = new ___ContinuationClasscontinuationMethod2();  ___k1.sz = sz;
   ___k1.___tmp1 = ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;
   ___k1.___k = ___k;  ___k1.object = this; ___tmp5.Sort(0 , aux01 , ___k1); }
   public void continuationMethod0 (int  sz , QS  ___tmp1   , Continuation
   ___k  ) { int  aux01 ;  int  ___tmp0 ;  QS  ___tmp3 ;  QS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod1  ___k1 ; ___pseudoThis = this;
   ___tmp0 = ___tmp1.____1234Init4321____;  aux01 = ___tmp0;  ___tmp3 = this;
   ___k1 = new ___ContinuationClasscontinuationMethod1();  ___k1.sz = sz;
   ___k1.___tmp1 = ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___k = ___k;
   ___k1.object = this; ___tmp3.Print(___k1 ); }  public void
   continuationMethod4 (int  left , int  right   , Continuation  ___k  ) { QS
   ___pseudoThis ; ___pseudoThis = this;  ____1234Sort4321____ = 0; ___k.call()
   ; }  public void continuationMethod7 (int  left , int  right   , int  i   ,
   int  j   , int  t   , int  ____writeable____right   , int
   ____writeable____left   , QS  ___tmp12   , QS  ___tmp14   , Continuation
   ___k  ) { int  nt ;  int  ___tmp13 ;  QS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod4  ___k1 ; ___pseudoThis = this;
   ___tmp13 = ___tmp14.____1234Sort4321____;  nt = ___tmp13;  ___k1 = new
   ___ContinuationClasscontinuationMethod4();  ___k1.left = left;  ___k1.right
   = right;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call(); }  public
   void continuationMethod6 (int  left , int  right   , int  i   , int  j   ,
   int  t   , int  ____writeable____right   , int  ____writeable____left   , QS
   ___tmp12   , Continuation  ___k  ) { int  nt ;  int  ___tmp11 ;  QS
   ___tmp14 ;  QS  ___pseudoThis ;  ___ContinuationClasscontinuationMethod7
   ___k1 ; ___pseudoThis = this;  ___tmp11 = ___tmp12.____1234Sort4321____;  nt
   = ___tmp11;  ___tmp14 = this;  ___k1 = new
   ___ContinuationClasscontinuationMethod7();  ___k1.left = left;  ___k1.right
   = right;  ___k1.i = i;  ___k1.j = j;  ___k1.t = t;  ___k1.
   ____writeable____right = ____writeable____right;  ___k1.
   ____writeable____left = ____writeable____left;  ___k1.___tmp12 = ___tmp12;
   ___k1.___tmp14 = ___tmp14;  ___k1.___k = ___k;  ___k1.object = this;
   ___tmp14.Sort(i + 1 , ____writeable____right , ___k1); }  public void
   continuationMethod5 (int  left , int  right   , int  i   , int  j   , int  t
   , int  ____writeable____right   , int  ____writeable____left   ,
   Continuation  ___k  ) { QS  ___tmp12 ;  QS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod6  ___k1 ; ___pseudoThis = this;
   number[j] = number [ i ];  number[i] = number [ ____writeable____right ];
   number[____writeable____right] = t;  ___tmp12 = this;  ___k1 = new
   ___ContinuationClasscontinuationMethod6();  ___k1.left = left;  ___k1.right
   = right;  ___k1.i = i;  ___k1.j = j;  ___k1.t = t;  ___k1.
   ____writeable____right = ____writeable____right;  ___k1.
   ____writeable____left = ____writeable____left;  ___k1.___tmp12 = ___tmp12;
   ___k1.___k = ___k;  ___k1.object = this; ___tmp12.SortFoo(
   ____writeable____left , i - 1 , ___k1); }  public void continuationMethod10
   (int  left , int  right   , int  v   , int  i   , int  j   , boolean  cont01
   , Continuation  ___k  ) { QS  ___pseudoThis ; ___pseudoThis = this;
   ___pseudoThis.whileMethod1(left , right , v , i , j , cont01 , ___k); }
   public void continuationMethod9 (int  left , int  right   , int  v   , int
   i   , int  j   , boolean  cont01   , Continuation  ___k  ) { int  t ;  int
   ____tmp10 ;  QS  ___pseudoThis ;  ___ContinuationClasscontinuationMethod10
   ___k1 ; ___pseudoThis = this;  t = number [ i ];  number[i] = number [ j ];
   number[j] = t;  ____tmp10 = i + 1; if ( j < ____tmp10 ) { cont01 = false;
   ___k1 = new ___ContinuationClasscontinuationMethod10();  ___k1.left = left;
   ___k1.right = right;  ___k1.v = v;  ___k1.i = i;  ___k1.j = j;  ___k1.cont01
   = cont01;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call(); }  else {
   cont01 = true;  ___k1 = new ___ContinuationClasscontinuationMethod10();
   ___k1.left = left;  ___k1.right = right;  ___k1.v = v;  ___k1.i = i;  ___k1.
   j = j;  ___k1.cont01 = cont01;  ___k1.___k = ___k;  ___k1.object = this;
   ___k1.call(); }  }  public void continuationMethod11 (int  left , int  right
   , int  v   , int  i   , int  j   , boolean  cont01   , boolean  cont02   ,
   Continuation  ___k  ) { QS  ___pseudoThis ; ___pseudoThis = this;
   ___pseudoThis.whileMethod2(left , right , v , i , j , cont01 , cont02 , ___k
   ); }  public void whileMethod2 (int  left , int  right   , int  v   , int  i
   , int  j   , boolean  cont01   , boolean  cont02   , Continuation  ___k  ) {
   int  t ;  int  aux03 ;  boolean  ____tmp9 ;  int  ____tmp10 ;  QS
   ___pseudoThis ;  ___ContinuationClasscontinuationMethod11  ___k1 ;
   ___pseudoThis = this; if ( cont02 ) { j = j - 1;  aux03 = number [ j ];
   ____tmp9 = v < aux03; if ( ! ____tmp9 ) { cont02 = false;  ___k1 = new
   ___ContinuationClasscontinuationMethod11();  ___k1.left = left;  ___k1.right
   = right;  ___k1.v = v;  ___k1.i = i;  ___k1.j = j;  ___k1.cont01 = cont01;
   ___k1.cont02 = cont02;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call(
   ); }  else { cont02 = true;  ___k1 = new
   ___ContinuationClasscontinuationMethod11();  ___k1.left = left;  ___k1.right
   = right;  ___k1.v = v;  ___k1.i = i;  ___k1.j = j;  ___k1.cont01 = cont01;
   ___k1.cont02 = cont02;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call(
   ); }  }  else { ___k.call(); }  }  public void continuationMethod8 (int
   left , int  right   , int  v   , int  i   , int  j   , boolean  cont01   ,
   Continuation  ___k  ) { boolean  cont02 ;  QS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod9  ___k1 ; ___pseudoThis = this;
   cont02 = true;  ___k1 = new ___ContinuationClasscontinuationMethod9();
   ___k1.left = left;  ___k1.right = right;  ___k1.v = v;  ___k1.i = i;  ___k1.
   j = j;  ___k1.cont01 = cont01;  ___k1.___k = ___k;  ___k1.object = this;
   ___pseudoThis.whileMethod2(left , right , v , i , j , cont01 , cont02 ,
   ___k1); }  public void continuationMethod12 (int  left , int  right   , int
   v   , int  i   , int  j   , boolean  cont01   , boolean  cont02   ,
   Continuation  ___k  ) { QS  ___pseudoThis ; ___pseudoThis = this;
   ___pseudoThis.whileMethod3(left , right , v , i , j , cont01 , cont02 , ___k
   ); }  public void whileMethod3 (int  left , int  right   , int  v   , int  i
   , int  j   , boolean  cont01   , boolean  cont02   , Continuation  ___k  ) {
   int  nt ;  int  t ;  int  aux03 ;  int  ____writeable____right ;  int
   ____writeable____left ;  boolean  ____tmp8 ;  boolean  ____tmp9 ;  int
   ____tmp10 ;  QS  ___tmp12 ;  int  ___tmp11 ;  QS  ___tmp14 ;  int  ___tmp13
   ;  QS  ___pseudoThis ;  ___ContinuationClasscontinuationMethod12  ___k1 ;
   ___pseudoThis = this; if ( cont02 ) { i = i + 1;  aux03 = number [ i ];
   ____tmp8 = aux03 < v; if ( ! ____tmp8 ) { cont02 = false;  ___k1 = new
   ___ContinuationClasscontinuationMethod12();  ___k1.left = left;  ___k1.right
   = right;  ___k1.v = v;  ___k1.i = i;  ___k1.j = j;  ___k1.cont01 = cont01;
   ___k1.cont02 = cont02;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call(
   ); }  else { cont02 = true;  ___k1 = new
   ___ContinuationClasscontinuationMethod12();  ___k1.left = left;  ___k1.right
   = right;  ___k1.v = v;  ___k1.i = i;  ___k1.j = j;  ___k1.cont01 = cont01;
   ___k1.cont02 = cont02;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call(
   ); }  }  else { ___k.call(); }  }  public void whileMethod1 (int  left , int
   right   , int  v   , int  i   , int  j   , boolean  cont01   , Continuation
   ___k  ) { int  nt ;  int  t ;  boolean  cont02 ;  int  aux03 ;  int
   ____writeable____right ;  int  ____writeable____left ;  boolean  ____tmp8 ;
   boolean  ____tmp9 ;  int  ____tmp10 ;  QS  ___tmp12 ;  int  ___tmp11 ;  QS
   ___tmp14 ;  int  ___tmp13 ;  QS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod8  ___k1 ; ___pseudoThis = this; if (
   cont01 ) { cont02 = true;  ___k1 = new
   ___ContinuationClasscontinuationMethod8();  ___k1.left = left;  ___k1.right
   = right;  ___k1.v = v;  ___k1.i = i;  ___k1.j = j;  ___k1.cont01 = cont01;
   ___k1.___k = ___k;  ___k1.object = this; ___pseudoThis.whileMethod3(left ,
   right , v , i , j , cont01 , cont02 , ___k1); }  else { ___k.call(); }  }
   public void continuationMethod13 (Continuation  ___k ) { QS  ___pseudoThis ;
   ___pseudoThis = this;  ____1234Print4321____ = 0; ___k.call(); }  public
   void whileMethod4 (int  j , int  ____tmp15   , Continuation  ___k  ) { QS
   ___pseudoThis ; ___pseudoThis = this; if ( j < ____tmp15 ) {
   System.out.println ( number [ j ] ) ;  j = j + 1;  ____tmp15 = size;
   ___pseudoThis.whileMethod4(j , ____tmp15 , ___k); }  else { ___k.call(); }
   }}
class ____NewMainClass____ { public void ____Main____ (int  ____arg_length____
   , Continuation  ___k  ) { int  ____printMe____ ;  QS  ___tmp17 ;  int
   ___tmp16 ;  ____NewMainClass____  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod14  ___k1 ; ___pseudoThis = this;
   ___tmp17 = new QS();  ___k1 = new ___ContinuationClasscontinuationMethod14()
   ;  ___k1.____arg_length____ = ____arg_length____;  ___k1.___tmp17 = ___tmp17
   ;  ___k1.___k = ___k;  ___k1.object = this; ___tmp17.Start(10 , ___k1); }
   public void continuationMethod14 (int  ____arg_length____ , QS  ___tmp17   ,
   Continuation  ___k  ) { int  ____printMe____ ;  int  ___tmp16 ;
   ____NewMainClass____  ___pseudoThis ; ___pseudoThis = this;  ___tmp16 =
   ___tmp17.____1234Start4321____;  ____printMe____ = ___tmp16;
   System.out.println ( ____printMe____ ) ; ___k.call(); }}
class ___ContinuationClasscontinuationMethod3 extends Continuation { int  sz ;
   QS  ___tmp1 ; QS  ___tmp3 ; QS  ___tmp5 ; QS  ___tmp7 ; Continuation  ___k ;
   QS  object ; public void call () { object.continuationMethod3(sz , ___tmp1 ,
   ___tmp3 , ___tmp5 , ___tmp7 , ___k); }}
class ___ContinuationClasscontinuationMethod2 extends Continuation { int  sz ;
   QS  ___tmp1 ; QS  ___tmp3 ; QS  ___tmp5 ; Continuation  ___k ; QS  object ;
   public void call () { object.continuationMethod2(sz , ___tmp1 , ___tmp3 ,
   ___tmp5 , ___k); }}
class ___ContinuationClasscontinuationMethod1 extends Continuation { int  sz ;
   QS  ___tmp1 ; QS  ___tmp3 ; Continuation  ___k ; QS  object ; public void
   call () { object.continuationMethod1(sz , ___tmp1 , ___tmp3 , ___k); }}
class ___ContinuationClasscontinuationMethod0 extends Continuation { int  sz ;
   QS  ___tmp1 ; Continuation  ___k ; QS  object ; public void call () { object
   .continuationMethod0(sz , ___tmp1 , ___k); }}
class ___ContinuationClasscontinuationMethod4 extends Continuation { int  left
   ; int  right ; Continuation  ___k ; QS  object ; public void call () {
   object.continuationMethod4(left , right , ___k); }}
class ___ContinuationClasscontinuationMethod7 extends Continuation { int  left
   ; int  right ; int  i ; int  j ; int  t ; int  ____writeable____right ; int
   ____writeable____left ; QS  ___tmp12 ; QS  ___tmp14 ; Continuation  ___k ;
   QS  object ; public void call () { object.continuationMethod7(left , right ,
   i , j , t , ____writeable____right , ____writeable____left , ___tmp12 ,
   ___tmp14 , ___k); }}
class ___ContinuationClasscontinuationMethod6 extends Continuation { int  left
   ; int  right ; int  i ; int  j ; int  t ; int  ____writeable____right ; int
   ____writeable____left ; QS  ___tmp12 ; Continuation  ___k ; QS  object ;
   public void call () { object.continuationMethod6(left , right , i , j , t ,
   ____writeable____right , ____writeable____left , ___tmp12 , ___k); }}
class ___ContinuationClasscontinuationMethod5 extends Continuation { int  left
   ; int  right ; int  i ; int  j ; int  t ; int  ____writeable____right ; int
   ____writeable____left ; Continuation  ___k ; QS  object ; public void call (
   ) { object.continuationMethod5(left , right , i , j , t ,
   ____writeable____right , ____writeable____left , ___k); }}
class ___ContinuationClasscontinuationMethod10 extends Continuation { int  left
   ; int  right ; int  v ; int  i ; int  j ; boolean  cont01 ; Continuation
   ___k ; QS  object ; public void call () { object.continuationMethod10(left ,
   right , v , i , j , cont01 , ___k); }}
class ___ContinuationClasscontinuationMethod9 extends Continuation { int  left
   ; int  right ; int  v ; int  i ; int  j ; boolean  cont01 ; Continuation
   ___k ; QS  object ; public void call () { object.continuationMethod9(left ,
   right , v , i , j , cont01 , ___k); }}
class ___ContinuationClasscontinuationMethod11 extends Continuation { int  left
   ; int  right ; int  v ; int  i ; int  j ; boolean  cont01 ; boolean  cont02
   ; Continuation  ___k ; QS  object ; public void call () { object.
   continuationMethod11(left , right , v , i , j , cont01 , cont02 , ___k); }}
class ___ContinuationClasscontinuationMethod8 extends Continuation { int  left
   ; int  right ; int  v ; int  i ; int  j ; boolean  cont01 ; Continuation
   ___k ; QS  object ; public void call () { object.continuationMethod8(left ,
   right , v , i , j , cont01 , ___k); }}
class ___ContinuationClasscontinuationMethod12 extends Continuation { int  left
   ; int  right ; int  v ; int  i ; int  j ; boolean  cont01 ; boolean  cont02
   ; Continuation  ___k ; QS  object ; public void call () { object.
   continuationMethod12(left , right , v , i , j , cont01 , cont02 , ___k); }}
class ___ContinuationClasscontinuationMethod13 extends Continuation {
   Continuation  ___k ; QS  object ; public void call () { object.
   continuationMethod13(___k ); }}
class ___ContinuationClasscontinuationMethod14 extends Continuation { int
   ____arg_length____ ; QS  ___tmp17 ; Continuation  ___k ;
   ____NewMainClass____  object ; public void call () { object.
   continuationMethod14(____arg_length____ , ___tmp17 , ___k); }}
class Continuation { public void call () { }} 