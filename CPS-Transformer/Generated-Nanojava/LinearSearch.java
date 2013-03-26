 class LinearSearch {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0 , new Continuation() ) ; } }
   class LS { int [ ]   number ;   int  size ;   int  ____1234Start4321____ ;
   int  ____1234Print4321____ ;   int  ____1234Search4321____ ;   int
   ____1234Init4321____ ; public void Start (int  sz , Continuation  ___k  ) {
   int  aux01 ;  int  aux02 ;  int  ____writeable____sz ;  LS  ___tmp1 ;  int
   ___tmp0 ;  LS  ___tmp3 ;  int  ___tmp2 ;  LS  ___tmp5 ;  int  ___tmp4 ;  LS
   ___tmp7 ;  int  ___tmp6 ;  LS  ___tmp9 ;  int  ___tmp8 ;  LS  ___tmp11 ;
   int  ___tmp10 ;  LS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod0  ___k1 ; ___pseudoThis = this;
   ____writeable____sz = sz;  ___tmp1 = this;  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.sz = sz;  ___k1.___tmp1 =
   ___tmp1;  ___k1.___k = ___k;  ___k1.object = this; ___tmp1.Init(
   ____writeable____sz , ___k1); }  public void Print (Continuation  ___k ) {
   int  j ;  int  ____tmp12 ;  LS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod6  ___k1 ; ___pseudoThis = this;  j =
   1;  ____tmp12 = size;  ___k1 = new ___ContinuationClasscontinuationMethod6()
   ;  ___k1.___k = ___k;  ___k1.object = this; ___pseudoThis.whileMethod1(j ,
   ____tmp12 , ___k1); }  public void Search (int  num , Continuation  ___k  )
   { int  j ;  boolean  ls01 ;  int  ifound ;  int  aux01 ;  int  aux02 ;  int
   nt ;  int  ____writeable____num ;  int  ____tmp13 ;  boolean  ____tmp14 ;
   LS  ___pseudoThis ;  ___ContinuationClasscontinuationMethod7  ___k1 ;
   ___pseudoThis = this;  ____writeable____num = num;  j = 1;  ls01 = false;
   ifound = 0;  ____tmp13 = size;  ___k1 = new
   ___ContinuationClasscontinuationMethod7();  ___k1.num = num;  ___k1.ifound =
   ifound;  ___k1.___k = ___k;  ___k1.object = this; ___pseudoThis.whileMethod2
   (num , j , ____writeable____num , ____tmp13 , ___k1); }  public void Init (
   int  sz , Continuation  ___k  ) { int  j ;  int  k ;  int  aux01 ;  int
   aux02 ;  int  ____writeable____sz ;  int  ____tmp15 ;  LS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod10  ___k1 ; ___pseudoThis = this;
   ____writeable____sz = sz;  size = ____writeable____sz;  number = new int[
   ____writeable____sz];  j = 1;  k = size + 1;  ____tmp15 = size;  ___k1 = new
   ___ContinuationClasscontinuationMethod10();  ___k1.sz = sz;  ___k1.___k =
   ___k;  ___k1.object = this; ___pseudoThis.whileMethod3(sz , j , k ,
   ____tmp15 , ___k1); }  public void continuationMethod5 (int  sz , LS
   ___tmp1   , LS  ___tmp3   , LS  ___tmp5   , LS  ___tmp7   , LS  ___tmp9   ,
   LS  ___tmp11   , Continuation  ___k  ) { int  ___tmp10 ;  LS  ___pseudoThis
   ; ___pseudoThis = this;  ___tmp10 = ___tmp11.____1234Search4321____;
   System.out.println ( ___tmp10 ) ;  ____1234Start4321____ = 55; ___k.call();
   }  public void continuationMethod4 (int  sz , LS  ___tmp1   , LS  ___tmp3
   , LS  ___tmp5   , LS  ___tmp7   , LS  ___tmp9   , Continuation  ___k  ) {
   int  ___tmp8 ;  LS  ___tmp11 ;  LS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod5  ___k1 ; ___pseudoThis = this;
   ___tmp8 = ___tmp9.____1234Search4321____;  System.out.println ( ___tmp8 ) ;
   ___tmp11 = this;  ___k1 = new ___ContinuationClasscontinuationMethod5();
   ___k1.sz = sz;  ___k1.___tmp1 = ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.
   ___tmp5 = ___tmp5;  ___k1.___tmp7 = ___tmp7;  ___k1.___tmp9 = ___tmp9;
   ___k1.___tmp11 = ___tmp11;  ___k1.___k = ___k;  ___k1.object = this;
   ___tmp11.Search(50 , ___k1); }  public void continuationMethod3 (int  sz ,
   LS  ___tmp1   , LS  ___tmp3   , LS  ___tmp5   , LS  ___tmp7   , Continuation
   ___k  ) { int  ___tmp6 ;  LS  ___tmp9 ;  LS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod4  ___k1 ; ___pseudoThis = this;
   ___tmp6 = ___tmp7.____1234Search4321____;  System.out.println ( ___tmp6 ) ;
   ___tmp9 = this;  ___k1 = new ___ContinuationClasscontinuationMethod4();
   ___k1.sz = sz;  ___k1.___tmp1 = ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.
   ___tmp5 = ___tmp5;  ___k1.___tmp7 = ___tmp7;  ___k1.___tmp9 = ___tmp9;
   ___k1.___k = ___k;  ___k1.object = this; ___tmp9.Search(17 , ___k1); }
   public void continuationMethod2 (int  sz , LS  ___tmp1   , LS  ___tmp3   ,
   LS  ___tmp5   , Continuation  ___k  ) { int  ___tmp4 ;  LS  ___tmp7 ;  LS
   ___pseudoThis ;  ___ContinuationClasscontinuationMethod3  ___k1 ;
   ___pseudoThis = this;  ___tmp4 = ___tmp5.____1234Search4321____;
   System.out.println ( ___tmp4 ) ;  ___tmp7 = this;  ___k1 = new
   ___ContinuationClasscontinuationMethod3();  ___k1.sz = sz;  ___k1.___tmp1 =
   ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;  ___k1.___tmp7
   = ___tmp7;  ___k1.___k = ___k;  ___k1.object = this; ___tmp7.Search(12 ,
   ___k1); }  public void continuationMethod1 (int  sz , LS  ___tmp1   , LS
   ___tmp3   , Continuation  ___k  ) { int  aux02 ;  int  ___tmp2 ;  LS
   ___tmp5 ;  LS  ___pseudoThis ;  ___ContinuationClasscontinuationMethod2
   ___k1 ; ___pseudoThis = this;  ___tmp2 = ___tmp3.____1234Print4321____;
   aux02 = ___tmp2;  System.out.println ( 9999 ) ;  ___tmp5 = this;  ___k1 =
   new ___ContinuationClasscontinuationMethod2();  ___k1.sz = sz;  ___k1.
   ___tmp1 = ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;
   ___k1.___k = ___k;  ___k1.object = this; ___tmp5.Search(8 , ___k1); }
   public void continuationMethod0 (int  sz , LS  ___tmp1   , Continuation
   ___k  ) { int  aux01 ;  int  ___tmp0 ;  LS  ___tmp3 ;  LS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod1  ___k1 ; ___pseudoThis = this;
   ___tmp0 = ___tmp1.____1234Init4321____;  aux01 = ___tmp0;  ___tmp3 = this;
   ___k1 = new ___ContinuationClasscontinuationMethod1();  ___k1.sz = sz;
   ___k1.___tmp1 = ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___k = ___k;
   ___k1.object = this; ___tmp3.Print(___k1 ); }  public void
   continuationMethod6 (Continuation  ___k ) { LS  ___pseudoThis ;
   ___pseudoThis = this;  ____1234Print4321____ = 0; ___k.call(); }  public
   void whileMethod1 (int  j , int  ____tmp12   , Continuation  ___k  ) { LS
   ___pseudoThis ; ___pseudoThis = this; if ( j < ____tmp12 ) {
   System.out.println ( number [ j ] ) ;  j = j + 1;  ____tmp12 = size;
   ___pseudoThis.whileMethod1(j , ____tmp12 , ___k); }  else { ___k.call(); }
   }  public void continuationMethod7 (int  num , int  ifound   , Continuation
   ___k  ) { LS  ___pseudoThis ; ___pseudoThis = this;  ____1234Search4321____
   = ifound; ___k.call(); }  public void continuationMethod8 (int  num , int  j
   , int  ____writeable____num   , int  ____tmp13   , Continuation  ___k  ) {
   LS  ___pseudoThis ; ___pseudoThis = this;  j = j + 1;  ____tmp13 = size;
   ___pseudoThis.whileMethod2(num , j , ____writeable____num , ____tmp13 , ___k
   ); }  public void continuationMethod9 (int  num , int  j   , int
   ____writeable____num   , int  ____tmp13   , Continuation  ___k  ) { LS
   ___pseudoThis ;  ___ContinuationClasscontinuationMethod8  ___k1 ;
   ___pseudoThis = this;  ___k1 = new ___ContinuationClasscontinuationMethod8()
   ;  ___k1.num = num;  ___k1.j = j;  ___k1.____writeable____num =
   ____writeable____num;  ___k1.____tmp13 = ____tmp13;  ___k1.___k = ___k;
   ___k1.object = this; ___k1.call(); }  public void whileMethod2 (int  num ,
   int  j   , int  ____writeable____num   , int  ____tmp13   , Continuation
   ___k  ) { boolean  ls01 ;  int  ifound ;  int  aux01 ;  int  aux02 ;  int
   nt ;  boolean  ____tmp14 ;  LS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod8  ___k1 ;
   ___ContinuationClasscontinuationMethod9  ___k2 ; ___pseudoThis = this; if (
   j < ____tmp13 ) { aux01 = number [ j ];  aux02 = ____writeable____num + 1;
   if ( aux01 < ____writeable____num ) { nt = 0;  ___k1 = new
   ___ContinuationClasscontinuationMethod8();  ___k1.num = num;  ___k1.j = j;
   ___k1.____writeable____num = ____writeable____num;  ___k1.____tmp13 =
   ____tmp13;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call(); }  else {
   ____tmp14 = aux01 < aux02; if ( ! ____tmp14 ) { nt = 0;  ___k2 = new
   ___ContinuationClasscontinuationMethod9();  ___k2.num = num;  ___k2.j = j;
   ___k2.____writeable____num = ____writeable____num;  ___k2.____tmp13 =
   ____tmp13;  ___k2.___k = ___k;  ___k2.object = this; ___k2.call(); }  else {
   ls01 = true;  ifound = 1;  j = size;  ___k2 = new
   ___ContinuationClasscontinuationMethod9();  ___k2.num = num;  ___k2.j = j;
   ___k2.____writeable____num = ____writeable____num;  ___k2.____tmp13 =
   ____tmp13;  ___k2.___k = ___k;  ___k2.object = this; ___k2.call(); }  }  }
   else { ___k.call(); }  }  public void continuationMethod10 (int  sz ,
   Continuation  ___k  ) { LS  ___pseudoThis ; ___pseudoThis = this;
   ____1234Init4321____ = 0; ___k.call(); }  public void whileMethod3 (int  sz
   , int  j   , int  k   , int  ____tmp15   , Continuation  ___k  ) { int
   aux01 ;  int  aux02 ;  int  ____writeable____sz ;  LS  ___pseudoThis ;
   ___pseudoThis = this; if ( j < ____tmp15 ) { aux01 = 2 * j;  aux02 = k - 3;
   number[j] = aux01 + aux02;  j = j + 1;  k = k - 1;  ____tmp15 = size;
   ___pseudoThis.whileMethod3(sz , j , k , ____tmp15 , ___k); }  else { ___k.
   call(); }  }}
class ____NewMainClass____ { public void ____Main____ (int  ____arg_length____
   , Continuation  ___k  ) { int  ____printMe____ ;  LS  ___tmp17 ;  int
   ___tmp16 ;  ____NewMainClass____  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod11  ___k1 ; ___pseudoThis = this;
   ___tmp17 = new LS();  ___k1 = new ___ContinuationClasscontinuationMethod11()
   ;  ___k1.____arg_length____ = ____arg_length____;  ___k1.___tmp17 = ___tmp17
   ;  ___k1.___k = ___k;  ___k1.object = this; ___tmp17.Start(10 , ___k1); }
   public void continuationMethod11 (int  ____arg_length____ , LS  ___tmp17   ,
   Continuation  ___k  ) { int  ____printMe____ ;  int  ___tmp16 ;
   ____NewMainClass____  ___pseudoThis ; ___pseudoThis = this;  ___tmp16 =
   ___tmp17.____1234Start4321____;  ____printMe____ = ___tmp16;
   System.out.println ( ____printMe____ ) ; ___k.call(); }}
class ___ContinuationClasscontinuationMethod5 extends Continuation { int  sz ;
   LS  ___tmp1 ; LS  ___tmp3 ; LS  ___tmp5 ; LS  ___tmp7 ; LS  ___tmp9 ; LS
   ___tmp11 ; Continuation  ___k ; LS  object ; public void call () { object.
   continuationMethod5(sz , ___tmp1 , ___tmp3 , ___tmp5 , ___tmp7 , ___tmp9 ,
   ___tmp11 , ___k); }}
class ___ContinuationClasscontinuationMethod4 extends Continuation { int  sz ;
   LS  ___tmp1 ; LS  ___tmp3 ; LS  ___tmp5 ; LS  ___tmp7 ; LS  ___tmp9 ;
   Continuation  ___k ; LS  object ; public void call () { object.
   continuationMethod4(sz , ___tmp1 , ___tmp3 , ___tmp5 , ___tmp7 , ___tmp9 ,
   ___k); }}
class ___ContinuationClasscontinuationMethod3 extends Continuation { int  sz ;
   LS  ___tmp1 ; LS  ___tmp3 ; LS  ___tmp5 ; LS  ___tmp7 ; Continuation  ___k ;
   LS  object ; public void call () { object.continuationMethod3(sz , ___tmp1 ,
   ___tmp3 , ___tmp5 , ___tmp7 , ___k); }}
class ___ContinuationClasscontinuationMethod2 extends Continuation { int  sz ;
   LS  ___tmp1 ; LS  ___tmp3 ; LS  ___tmp5 ; Continuation  ___k ; LS  object ;
   public void call () { object.continuationMethod2(sz , ___tmp1 , ___tmp3 ,
   ___tmp5 , ___k); }}
class ___ContinuationClasscontinuationMethod1 extends Continuation { int  sz ;
   LS  ___tmp1 ; LS  ___tmp3 ; Continuation  ___k ; LS  object ; public void
   call () { object.continuationMethod1(sz , ___tmp1 , ___tmp3 , ___k); }}
class ___ContinuationClasscontinuationMethod0 extends Continuation { int  sz ;
   LS  ___tmp1 ; Continuation  ___k ; LS  object ; public void call () { object
   .continuationMethod0(sz , ___tmp1 , ___k); }}
class ___ContinuationClasscontinuationMethod6 extends Continuation {
   Continuation  ___k ; LS  object ; public void call () { object.
   continuationMethod6(___k ); }}
class ___ContinuationClasscontinuationMethod7 extends Continuation { int  num ;
   int  ifound ; Continuation  ___k ; LS  object ; public void call () { object
   .continuationMethod7(num , ifound , ___k); }}
class ___ContinuationClasscontinuationMethod8 extends Continuation { int  num ;
   int  j ; int  ____writeable____num ; int  ____tmp13 ; Continuation  ___k ;
   LS  object ; public void call () { object.continuationMethod8(num , j ,
   ____writeable____num , ____tmp13 , ___k); }}
class ___ContinuationClasscontinuationMethod9 extends Continuation { int  num ;
   int  j ; int  ____writeable____num ; int  ____tmp13 ; Continuation  ___k ;
   LS  object ; public void call () { object.continuationMethod9(num , j ,
   ____writeable____num , ____tmp13 , ___k); }}
class ___ContinuationClasscontinuationMethod10 extends Continuation { int  sz ;
   Continuation  ___k ; LS  object ; public void call () { object.
   continuationMethod10(sz , ___k); }}
class ___ContinuationClasscontinuationMethod11 extends Continuation { int
   ____arg_length____ ; LS  ___tmp17 ; Continuation  ___k ;
   ____NewMainClass____  object ; public void call () { object.
   continuationMethod11(____arg_length____ , ___tmp17 , ___k); }}
class Continuation { public void call () { }} 