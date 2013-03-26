 class BinarySearch {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0 , new Continuation() ) ; } }
   class BS { int [ ]   number ;   int  size ;   int  ____1234Start4321____ ;
   boolean  ____1234Search4321____ ;   int  ____1234Div4321____ ;   boolean
   ____1234Compare4321____ ;   int  ____1234Print4321____ ;   int
   ____1234Init4321____ ; public void Start (int  sz , Continuation  ___k  ) {
   int  aux01 ;  int  aux02 ;  int  ____writeable____sz ;  BS  ___tmp1 ;  int
   ___tmp0 ;  BS  ___tmp3 ;  int  ___tmp2 ;  BS  ___tmp5 ;  boolean  ___tmp4 ;
   BS  ___tmp7 ;  boolean  ___tmp6 ;  BS  ___tmp9 ;  boolean  ___tmp8 ;  BS
   ___tmp11 ;  boolean  ___tmp10 ;  BS  ___tmp13 ;  boolean  ___tmp12 ;  BS
   ___tmp15 ;  boolean  ___tmp14 ;  BS  ___tmp17 ;  boolean  ___tmp16 ;  BS
   ___tmp19 ;  boolean  ___tmp18 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod0  ___k1 ; ___pseudoThis = this;
   ____writeable____sz = sz;  ___tmp1 = this;  ___k1 = new
   ___ContinuationClasscontinuationMethod0();  ___k1.sz = sz;  ___k1.___tmp1 =
   ___tmp1;  ___k1.___k = ___k;  ___k1.object = this; ___tmp1.Init(
   ____writeable____sz , ___k1); }  public void Search (int  num , Continuation
   ___k  ) { boolean  bs01 ;  int  right ;  int  left ;  boolean  var_cont ;
   int  medium ;  int  aux01 ;  int  nt ;  int  ____writeable____num ;  int [ ]
   ___tmp20 ;  BS  ___tmp22 ;  int  ___tmp21 ;  BS  ___tmp24 ;  boolean
   ___tmp23 ;  BS  ___tmp26 ;  boolean  ___tmp25 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod18  ___k1 ; ___pseudoThis = this;
   ____writeable____num = num;  aux01 = 0;  bs01 = false;  ___tmp20 = number;
   right = ___tmp20.length;  right = right - 1;  left = 0;  var_cont = true;
   ___k1 = new ___ContinuationClasscontinuationMethod18();  ___k1.num = num;
   ___k1.aux01 = aux01;  ___k1.____writeable____num = ____writeable____num;
   ___k1.___k = ___k;  ___k1.object = this; ___pseudoThis.whileMethod1(num ,
   right , left , var_cont , ____writeable____num , ___k1); }  public void Div
   (int  num , Continuation  ___k  ) { int  count01 ;  int  count02 ;  int
   aux03 ;  int  ____writeable____num ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod26  ___k1 ; ___pseudoThis = this;
   ____writeable____num = num;  count01 = 0;  count02 = 0;  aux03 =
   ____writeable____num - 1;  ___k1 = new
   ___ContinuationClasscontinuationMethod26();  ___k1.num = num;  ___k1.count01
   = count01;  ___k1.___k = ___k;  ___k1.object = this; ___pseudoThis.
   whileMethod2(num , count01 , count02 , aux03 , ___k1); }  public void
   Compare (int  num1 , int  num2   , Continuation  ___k  ) { boolean  retval ;
   int  aux02 ;  int  ____writeable____num2 ;  int  ____writeable____num1 ;
   boolean  ____tmp27 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod27  ___k1 ;
   ___ContinuationClasscontinuationMethod28  ___k2 ; ___pseudoThis = this;
   ____writeable____num1 = num1;  ____writeable____num2 = num2;  retval = false
   ;  aux02 = ____writeable____num2 + 1; if ( ____writeable____num1 <
   ____writeable____num2 ) { retval = false;  ___k1 = new
   ___ContinuationClasscontinuationMethod27();  ___k1.num1 = num1;  ___k1.num2
   = num2;  ___k1.retval = retval;  ___k1.___k = ___k;  ___k1.object = this;
   ___k1.call(); }  else { ____tmp27 = ____writeable____num1 < aux02; if ( !
   ____tmp27 ) { retval = false;  ___k2 = new
   ___ContinuationClasscontinuationMethod28();  ___k2.num1 = num1;  ___k2.num2
   = num2;  ___k2.retval = retval;  ___k2.___k = ___k;  ___k2.object = this;
   ___k2.call(); }  else { retval = true;  ___k2 = new
   ___ContinuationClasscontinuationMethod28();  ___k2.num1 = num1;  ___k2.num2
   = num2;  ___k2.retval = retval;  ___k2.___k = ___k;  ___k2.object = this;
   ___k2.call(); }  }  }  public void Print (Continuation  ___k ) { int  j ;
   int  ____tmp28 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod29  ___k1 ; ___pseudoThis = this;  j =
   1;  ____tmp28 = size;  ___k1 = new ___ContinuationClasscontinuationMethod29(
   );  ___k1.___k = ___k;  ___k1.object = this; ___pseudoThis.whileMethod3(j ,
   ____tmp28 , ___k1); }  public void Init (int  sz , Continuation  ___k  ) {
   int  j ;  int  k ;  int  aux02 ;  int  aux01 ;  int  ____writeable____sz ;
   int  ____tmp29 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod30  ___k1 ; ___pseudoThis = this;
   ____writeable____sz = sz;  size = ____writeable____sz;  number = new int[
   ____writeable____sz];  j = 1;  k = size + 1;  ____tmp29 = size;  ___k1 = new
   ___ContinuationClasscontinuationMethod30();  ___k1.sz = sz;  ___k1.___k =
   ___k;  ___k1.object = this; ___pseudoThis.whileMethod4(sz , j , k ,
   ____tmp29 , ___k1); }  public void continuationMethod17 (int  sz , BS
   ___tmp1   , BS  ___tmp3   , BS  ___tmp5   , BS  ___tmp7   , BS  ___tmp9   ,
   BS  ___tmp11   , BS  ___tmp13   , BS  ___tmp15   , BS  ___tmp17   , BS
   ___tmp19   , Continuation  ___k  ) { BS  ___pseudoThis ; ___pseudoThis =
   this;  ____1234Start4321____ = 999; ___k.call(); }  public void
   continuationMethod16 (int  sz , BS  ___tmp1   , BS  ___tmp3   , BS  ___tmp5
   , BS  ___tmp7   , BS  ___tmp9   , BS  ___tmp11   , BS  ___tmp13   , BS
   ___tmp15   , BS  ___tmp17   , BS  ___tmp19   , Continuation  ___k  ) {
   boolean  ___tmp18 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod17  ___k1 ; ___pseudoThis = this;
   ___tmp18 = ___tmp19.____1234Search4321____; if ( ___tmp18 ) {
   System.out.println ( 1 ) ;  ___k1 = new
   ___ContinuationClasscontinuationMethod17();  ___k1.sz = sz;  ___k1.___tmp1 =
   ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;  ___k1.___tmp7
   = ___tmp7;  ___k1.___tmp9 = ___tmp9;  ___k1.___tmp11 = ___tmp11;  ___k1.
   ___tmp13 = ___tmp13;  ___k1.___tmp15 = ___tmp15;  ___k1.___tmp17 = ___tmp17;
   ___k1.___tmp19 = ___tmp19;  ___k1.___k = ___k;  ___k1.object = this; ___k1.
   call(); }  else { System.out.println ( 0 ) ;  ___k1 = new
   ___ContinuationClasscontinuationMethod17();  ___k1.sz = sz;  ___k1.___tmp1 =
   ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;  ___k1.___tmp7
   = ___tmp7;  ___k1.___tmp9 = ___tmp9;  ___k1.___tmp11 = ___tmp11;  ___k1.
   ___tmp13 = ___tmp13;  ___k1.___tmp15 = ___tmp15;  ___k1.___tmp17 = ___tmp17;
   ___k1.___tmp19 = ___tmp19;  ___k1.___k = ___k;  ___k1.object = this; ___k1.
   call(); }  }  public void continuationMethod15 (int  sz , BS  ___tmp1   , BS
   ___tmp3   , BS  ___tmp5   , BS  ___tmp7   , BS  ___tmp9   , BS  ___tmp11   ,
   BS  ___tmp13   , BS  ___tmp15   , BS  ___tmp17   , Continuation  ___k  ) {
   BS  ___tmp19 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod16  ___k1 ; ___pseudoThis = this;
   ___tmp19 = this;  ___k1 = new ___ContinuationClasscontinuationMethod16();
   ___k1.sz = sz;  ___k1.___tmp1 = ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.
   ___tmp5 = ___tmp5;  ___k1.___tmp7 = ___tmp7;  ___k1.___tmp9 = ___tmp9;
   ___k1.___tmp11 = ___tmp11;  ___k1.___tmp13 = ___tmp13;  ___k1.___tmp15 =
   ___tmp15;  ___k1.___tmp17 = ___tmp17;  ___k1.___tmp19 = ___tmp19;  ___k1.
   ___k = ___k;  ___k1.object = this; ___tmp19.Search(50 , ___k1); }  public
   void continuationMethod14 (int  sz , BS  ___tmp1   , BS  ___tmp3   , BS
   ___tmp5   , BS  ___tmp7   , BS  ___tmp9   , BS  ___tmp11   , BS  ___tmp13
   , BS  ___tmp15   , BS  ___tmp17   , Continuation  ___k  ) { boolean
   ___tmp16 ;  BS  ___pseudoThis ;  ___ContinuationClasscontinuationMethod15
   ___k1 ; ___pseudoThis = this;  ___tmp16 = ___tmp17.____1234Search4321____;
   if ( ___tmp16 ) { System.out.println ( 1 ) ;  ___k1 = new
   ___ContinuationClasscontinuationMethod15();  ___k1.sz = sz;  ___k1.___tmp1 =
   ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;  ___k1.___tmp7
   = ___tmp7;  ___k1.___tmp9 = ___tmp9;  ___k1.___tmp11 = ___tmp11;  ___k1.
   ___tmp13 = ___tmp13;  ___k1.___tmp15 = ___tmp15;  ___k1.___tmp17 = ___tmp17;
   ___k1.___k = ___k;  ___k1.object = this; ___k1.call(); }  else {
   System.out.println ( 0 ) ;  ___k1 = new
   ___ContinuationClasscontinuationMethod15();  ___k1.sz = sz;  ___k1.___tmp1 =
   ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;  ___k1.___tmp7
   = ___tmp7;  ___k1.___tmp9 = ___tmp9;  ___k1.___tmp11 = ___tmp11;  ___k1.
   ___tmp13 = ___tmp13;  ___k1.___tmp15 = ___tmp15;  ___k1.___tmp17 = ___tmp17;
   ___k1.___k = ___k;  ___k1.object = this; ___k1.call(); }  }  public void
   continuationMethod13 (int  sz , BS  ___tmp1   , BS  ___tmp3   , BS  ___tmp5
   , BS  ___tmp7   , BS  ___tmp9   , BS  ___tmp11   , BS  ___tmp13   , BS
   ___tmp15   , Continuation  ___k  ) { BS  ___tmp17 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod14  ___k1 ; ___pseudoThis = this;
   ___tmp17 = this;  ___k1 = new ___ContinuationClasscontinuationMethod14();
   ___k1.sz = sz;  ___k1.___tmp1 = ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.
   ___tmp5 = ___tmp5;  ___k1.___tmp7 = ___tmp7;  ___k1.___tmp9 = ___tmp9;
   ___k1.___tmp11 = ___tmp11;  ___k1.___tmp13 = ___tmp13;  ___k1.___tmp15 =
   ___tmp15;  ___k1.___tmp17 = ___tmp17;  ___k1.___k = ___k;  ___k1.object =
   this; ___tmp17.Search(39 , ___k1); }  public void continuationMethod12 (int
   sz , BS  ___tmp1   , BS  ___tmp3   , BS  ___tmp5   , BS  ___tmp7   , BS
   ___tmp9   , BS  ___tmp11   , BS  ___tmp13   , BS  ___tmp15   , Continuation
   ___k  ) { boolean  ___tmp14 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod13  ___k1 ; ___pseudoThis = this;
   ___tmp14 = ___tmp15.____1234Search4321____; if ( ___tmp14 ) {
   System.out.println ( 1 ) ;  ___k1 = new
   ___ContinuationClasscontinuationMethod13();  ___k1.sz = sz;  ___k1.___tmp1 =
   ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;  ___k1.___tmp7
   = ___tmp7;  ___k1.___tmp9 = ___tmp9;  ___k1.___tmp11 = ___tmp11;  ___k1.
   ___tmp13 = ___tmp13;  ___k1.___tmp15 = ___tmp15;  ___k1.___k = ___k;  ___k1.
   object = this; ___k1.call(); }  else { System.out.println ( 0 ) ;  ___k1 =
   new ___ContinuationClasscontinuationMethod13();  ___k1.sz = sz;  ___k1.
   ___tmp1 = ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;
   ___k1.___tmp7 = ___tmp7;  ___k1.___tmp9 = ___tmp9;  ___k1.___tmp11 =
   ___tmp11;  ___k1.___tmp13 = ___tmp13;  ___k1.___tmp15 = ___tmp15;  ___k1.
   ___k = ___k;  ___k1.object = this; ___k1.call(); }  }  public void
   continuationMethod11 (int  sz , BS  ___tmp1   , BS  ___tmp3   , BS  ___tmp5
   , BS  ___tmp7   , BS  ___tmp9   , BS  ___tmp11   , BS  ___tmp13   ,
   Continuation  ___k  ) { BS  ___tmp15 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod12  ___k1 ; ___pseudoThis = this;
   ___tmp15 = this;  ___k1 = new ___ContinuationClasscontinuationMethod12();
   ___k1.sz = sz;  ___k1.___tmp1 = ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.
   ___tmp5 = ___tmp5;  ___k1.___tmp7 = ___tmp7;  ___k1.___tmp9 = ___tmp9;
   ___k1.___tmp11 = ___tmp11;  ___k1.___tmp13 = ___tmp13;  ___k1.___tmp15 =
   ___tmp15;  ___k1.___k = ___k;  ___k1.object = this; ___tmp15.Search(38 ,
   ___k1); }  public void continuationMethod10 (int  sz , BS  ___tmp1   , BS
   ___tmp3   , BS  ___tmp5   , BS  ___tmp7   , BS  ___tmp9   , BS  ___tmp11   ,
   BS  ___tmp13   , Continuation  ___k  ) { boolean  ___tmp12 ;  BS
   ___pseudoThis ;  ___ContinuationClasscontinuationMethod11  ___k1 ;
   ___pseudoThis = this;  ___tmp12 = ___tmp13.____1234Search4321____; if (
   ___tmp12 ) { System.out.println ( 1 ) ;  ___k1 = new
   ___ContinuationClasscontinuationMethod11();  ___k1.sz = sz;  ___k1.___tmp1 =
   ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;  ___k1.___tmp7
   = ___tmp7;  ___k1.___tmp9 = ___tmp9;  ___k1.___tmp11 = ___tmp11;  ___k1.
   ___tmp13 = ___tmp13;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call();
   }  else { System.out.println ( 0 ) ;  ___k1 = new
   ___ContinuationClasscontinuationMethod11();  ___k1.sz = sz;  ___k1.___tmp1 =
   ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;  ___k1.___tmp7
   = ___tmp7;  ___k1.___tmp9 = ___tmp9;  ___k1.___tmp11 = ___tmp11;  ___k1.
   ___tmp13 = ___tmp13;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call();
   }  }  public void continuationMethod9 (int  sz , BS  ___tmp1   , BS  ___tmp3
   , BS  ___tmp5   , BS  ___tmp7   , BS  ___tmp9   , BS  ___tmp11   ,
   Continuation  ___k  ) { BS  ___tmp13 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod10  ___k1 ; ___pseudoThis = this;
   ___tmp13 = this;  ___k1 = new ___ContinuationClasscontinuationMethod10();
   ___k1.sz = sz;  ___k1.___tmp1 = ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.
   ___tmp5 = ___tmp5;  ___k1.___tmp7 = ___tmp7;  ___k1.___tmp9 = ___tmp9;
   ___k1.___tmp11 = ___tmp11;  ___k1.___tmp13 = ___tmp13;  ___k1.___k = ___k;
   ___k1.object = this; ___tmp13.Search(37 , ___k1); }  public void
   continuationMethod8 (int  sz , BS  ___tmp1   , BS  ___tmp3   , BS  ___tmp5
   , BS  ___tmp7   , BS  ___tmp9   , BS  ___tmp11   , Continuation  ___k  ) {
   boolean  ___tmp10 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod9  ___k1 ; ___pseudoThis = this;
   ___tmp10 = ___tmp11.____1234Search4321____; if ( ___tmp10 ) {
   System.out.println ( 1 ) ;  ___k1 = new
   ___ContinuationClasscontinuationMethod9();  ___k1.sz = sz;  ___k1.___tmp1 =
   ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;  ___k1.___tmp7
   = ___tmp7;  ___k1.___tmp9 = ___tmp9;  ___k1.___tmp11 = ___tmp11;  ___k1.___k
   = ___k;  ___k1.object = this; ___k1.call(); }  else { System.out.println ( 0
   ) ;  ___k1 = new ___ContinuationClasscontinuationMethod9();  ___k1.sz = sz;
   ___k1.___tmp1 = ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;
   ___k1.___tmp7 = ___tmp7;  ___k1.___tmp9 = ___tmp9;  ___k1.___tmp11 =
   ___tmp11;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call(); }  }
   public void continuationMethod7 (int  sz , BS  ___tmp1   , BS  ___tmp3   ,
   BS  ___tmp5   , BS  ___tmp7   , BS  ___tmp9   , Continuation  ___k  ) { BS
   ___tmp11 ;  BS  ___pseudoThis ;  ___ContinuationClasscontinuationMethod8
   ___k1 ; ___pseudoThis = this;  ___tmp11 = this;  ___k1 = new
   ___ContinuationClasscontinuationMethod8();  ___k1.sz = sz;  ___k1.___tmp1 =
   ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;  ___k1.___tmp7
   = ___tmp7;  ___k1.___tmp9 = ___tmp9;  ___k1.___tmp11 = ___tmp11;  ___k1.___k
   = ___k;  ___k1.object = this; ___tmp11.Search(21 , ___k1); }  public void
   continuationMethod6 (int  sz , BS  ___tmp1   , BS  ___tmp3   , BS  ___tmp5
   , BS  ___tmp7   , BS  ___tmp9   , Continuation  ___k  ) { boolean  ___tmp8 ;
   BS  ___pseudoThis ;  ___ContinuationClasscontinuationMethod7  ___k1 ;
   ___pseudoThis = this;  ___tmp8 = ___tmp9.____1234Search4321____; if (
   ___tmp8 ) { System.out.println ( 1 ) ;  ___k1 = new
   ___ContinuationClasscontinuationMethod7();  ___k1.sz = sz;  ___k1.___tmp1 =
   ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;  ___k1.___tmp7
   = ___tmp7;  ___k1.___tmp9 = ___tmp9;  ___k1.___k = ___k;  ___k1.object =
   this; ___k1.call(); }  else { System.out.println ( 0 ) ;  ___k1 = new
   ___ContinuationClasscontinuationMethod7();  ___k1.sz = sz;  ___k1.___tmp1 =
   ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;  ___k1.___tmp7
   = ___tmp7;  ___k1.___tmp9 = ___tmp9;  ___k1.___k = ___k;  ___k1.object =
   this; ___k1.call(); }  }  public void continuationMethod5 (int  sz , BS
   ___tmp1   , BS  ___tmp3   , BS  ___tmp5   , BS  ___tmp7   , Continuation
   ___k  ) { BS  ___tmp9 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod6  ___k1 ; ___pseudoThis = this;
   ___tmp9 = this;  ___k1 = new ___ContinuationClasscontinuationMethod6();
   ___k1.sz = sz;  ___k1.___tmp1 = ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.
   ___tmp5 = ___tmp5;  ___k1.___tmp7 = ___tmp7;  ___k1.___tmp9 = ___tmp9;
   ___k1.___k = ___k;  ___k1.object = this; ___tmp9.Search(20 , ___k1); }
   public void continuationMethod4 (int  sz , BS  ___tmp1   , BS  ___tmp3   ,
   BS  ___tmp5   , BS  ___tmp7   , Continuation  ___k  ) { boolean  ___tmp6 ;
   BS  ___pseudoThis ;  ___ContinuationClasscontinuationMethod5  ___k1 ;
   ___pseudoThis = this;  ___tmp6 = ___tmp7.____1234Search4321____; if (
   ___tmp6 ) { System.out.println ( 1 ) ;  ___k1 = new
   ___ContinuationClasscontinuationMethod5();  ___k1.sz = sz;  ___k1.___tmp1 =
   ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;  ___k1.___tmp7
   = ___tmp7;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call(); }  else {
   System.out.println ( 0 ) ;  ___k1 = new
   ___ContinuationClasscontinuationMethod5();  ___k1.sz = sz;  ___k1.___tmp1 =
   ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;  ___k1.___tmp7
   = ___tmp7;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call(); }  }
   public void continuationMethod3 (int  sz , BS  ___tmp1   , BS  ___tmp3   ,
   BS  ___tmp5   , Continuation  ___k  ) { BS  ___tmp7 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod4  ___k1 ; ___pseudoThis = this;
   ___tmp7 = this;  ___k1 = new ___ContinuationClasscontinuationMethod4();
   ___k1.sz = sz;  ___k1.___tmp1 = ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.
   ___tmp5 = ___tmp5;  ___k1.___tmp7 = ___tmp7;  ___k1.___k = ___k;  ___k1.
   object = this; ___tmp7.Search(19 , ___k1); }  public void
   continuationMethod2 (int  sz , BS  ___tmp1   , BS  ___tmp3   , BS  ___tmp5
   , Continuation  ___k  ) { int  aux02 ;  boolean  ___tmp4 ;  BS
   ___pseudoThis ;  ___ContinuationClasscontinuationMethod3  ___k1 ;
   ___pseudoThis = this;  ___tmp4 = ___tmp5.____1234Search4321____; if (
   ___tmp4 ) { aux02 = 0;  ___k1 = new ___ContinuationClasscontinuationMethod3(
   );  ___k1.sz = sz;  ___k1.___tmp1 = ___tmp1;  ___k1.___tmp3 = ___tmp3;
   ___k1.___tmp5 = ___tmp5;  ___k1.___k = ___k;  ___k1.object = this; ___k1.
   call(); }  else { aux02 = 1;  ___k1 = new
   ___ContinuationClasscontinuationMethod3();  ___k1.sz = sz;  ___k1.___tmp1 =
   ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;  ___k1.___k =
   ___k;  ___k1.object = this; ___k1.call(); }  }  public void
   continuationMethod1 (int  sz , BS  ___tmp1   , BS  ___tmp3   , Continuation
   ___k  ) { int  aux02 ;  int  ___tmp2 ;  BS  ___tmp5 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod2  ___k1 ; ___pseudoThis = this;
   ___tmp2 = ___tmp3.____1234Print4321____;  aux02 = ___tmp2;  ___tmp5 = this;
   ___k1 = new ___ContinuationClasscontinuationMethod2();  ___k1.sz = sz;
   ___k1.___tmp1 = ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___tmp5 = ___tmp5;
   ___k1.___k = ___k;  ___k1.object = this; ___tmp5.Search(8 , ___k1); }
   public void continuationMethod0 (int  sz , BS  ___tmp1   , Continuation
   ___k  ) { int  aux01 ;  int  ___tmp0 ;  BS  ___tmp3 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod1  ___k1 ; ___pseudoThis = this;
   ___tmp0 = ___tmp1.____1234Init4321____;  aux01 = ___tmp0;  ___tmp3 = this;
   ___k1 = new ___ContinuationClasscontinuationMethod1();  ___k1.sz = sz;
   ___k1.___tmp1 = ___tmp1;  ___k1.___tmp3 = ___tmp3;  ___k1.___k = ___k;
   ___k1.object = this; ___tmp3.Print(___k1 ); }  public void
   continuationMethod20 (int  num , int  aux01   , int  ____writeable____num
   , BS  ___tmp26   , boolean  bs01   , Continuation  ___k  ) { BS
   ___pseudoThis ; ___pseudoThis = this;  ____1234Search4321____ = bs01; ___k.
   call(); }  public void continuationMethod19 (int  num , int  aux01   , int
   ____writeable____num   , BS  ___tmp26   , Continuation  ___k  ) { boolean
   bs01 ;  boolean  ___tmp25 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod20  ___k1 ; ___pseudoThis = this;
   ___tmp25 = ___tmp26.____1234Compare4321____; if ( ___tmp25 ) { bs01 = true;
   ___k1 = new ___ContinuationClasscontinuationMethod20();  ___k1.num = num;
   ___k1.aux01 = aux01;  ___k1.____writeable____num = ____writeable____num;
   ___k1.___tmp26 = ___tmp26;  ___k1.bs01 = bs01;  ___k1.___k = ___k;  ___k1.
   object = this; ___k1.call(); }  else { bs01 = false;  ___k1 = new
   ___ContinuationClasscontinuationMethod20();  ___k1.num = num;  ___k1.aux01 =
   aux01;  ___k1.____writeable____num = ____writeable____num;  ___k1.___tmp26 =
   ___tmp26;  ___k1.bs01 = bs01;  ___k1.___k = ___k;  ___k1.object = this;
   ___k1.call(); }  }  public void continuationMethod18 (int  num , int  aux01
   , int  ____writeable____num   , Continuation  ___k  ) { BS  ___tmp26 ;  BS
   ___pseudoThis ;  ___ContinuationClasscontinuationMethod19  ___k1 ;
   ___pseudoThis = this;  ___tmp26 = this;  ___k1 = new
   ___ContinuationClasscontinuationMethod19();  ___k1.num = num;  ___k1.aux01 =
   aux01;  ___k1.____writeable____num = ____writeable____num;  ___k1.___tmp26 =
   ___tmp26;  ___k1.___k = ___k;  ___k1.object = this; ___tmp26.Compare(aux01 ,
   ____writeable____num , ___k1); }  public void continuationMethod25 (int  num
   , int  right   , int  left   , boolean  var_cont   , int
   ____writeable____num   , BS  ___tmp22   , int  aux01   , BS  ___tmp24   ,
   Continuation  ___k  ) { BS  ___pseudoThis ; ___pseudoThis = this;
   ___pseudoThis.whileMethod1(num , right , left , var_cont ,
   ____writeable____num , ___k); }  public void continuationMethod24 (int  num
   , int  right   , int  left   , boolean  var_cont   , int
   ____writeable____num   , BS  ___tmp22   , int  aux01   , BS  ___tmp24   ,
   Continuation  ___k  ) { int  nt ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod25  ___k1 ; ___pseudoThis = this; if (
   right < left ) { var_cont = false;  ___k1 = new
   ___ContinuationClasscontinuationMethod25();  ___k1.num = num;  ___k1.right =
   right;  ___k1.left = left;  ___k1.var_cont = var_cont;  ___k1.
   ____writeable____num = ____writeable____num;  ___k1.___tmp22 = ___tmp22;
   ___k1.aux01 = aux01;  ___k1.___tmp24 = ___tmp24;  ___k1.___k = ___k;  ___k1.
   object = this; ___k1.call(); }  else { nt = 0;  ___k1 = new
   ___ContinuationClasscontinuationMethod25();  ___k1.num = num;  ___k1.right =
   right;  ___k1.left = left;  ___k1.var_cont = var_cont;  ___k1.
   ____writeable____num = ____writeable____num;  ___k1.___tmp22 = ___tmp22;
   ___k1.aux01 = aux01;  ___k1.___tmp24 = ___tmp24;  ___k1.___k = ___k;  ___k1.
   object = this; ___k1.call(); }  }  public void continuationMethod23 (int
   num , int  right   , int  left   , boolean  var_cont   , int
   ____writeable____num   , BS  ___tmp22   , int  aux01   , BS  ___tmp24   ,
   Continuation  ___k  ) { boolean  ___tmp23 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod24  ___k1 ; ___pseudoThis = this;
   ___tmp23 = ___tmp24.____1234Compare4321____; if ( ___tmp23 ) { var_cont =
   false;  ___k1 = new ___ContinuationClasscontinuationMethod24();  ___k1.num =
   num;  ___k1.right = right;  ___k1.left = left;  ___k1.var_cont = var_cont;
   ___k1.____writeable____num = ____writeable____num;  ___k1.___tmp22 =
   ___tmp22;  ___k1.aux01 = aux01;  ___k1.___tmp24 = ___tmp24;  ___k1.___k =
   ___k;  ___k1.object = this; ___k1.call(); }  else { var_cont = true;  ___k1
   = new ___ContinuationClasscontinuationMethod24();  ___k1.num = num;  ___k1.
   right = right;  ___k1.left = left;  ___k1.var_cont = var_cont;  ___k1.
   ____writeable____num = ____writeable____num;  ___k1.___tmp22 = ___tmp22;
   ___k1.aux01 = aux01;  ___k1.___tmp24 = ___tmp24;  ___k1.___k = ___k;  ___k1.
   object = this; ___k1.call(); }  }  public void continuationMethod22 (int
   num , int  right   , int  left   , boolean  var_cont   , int
   ____writeable____num   , BS  ___tmp22   , int  aux01   , Continuation  ___k
   ) { BS  ___tmp24 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod23  ___k1 ; ___pseudoThis = this;
   ___tmp24 = this;  ___k1 = new ___ContinuationClasscontinuationMethod23();
   ___k1.num = num;  ___k1.right = right;  ___k1.left = left;  ___k1.var_cont =
   var_cont;  ___k1.____writeable____num = ____writeable____num;  ___k1.
   ___tmp22 = ___tmp22;  ___k1.aux01 = aux01;  ___k1.___tmp24 = ___tmp24;
   ___k1.___k = ___k;  ___k1.object = this; ___tmp24.Compare(aux01 ,
   ____writeable____num , ___k1); }  public void continuationMethod21 (int  num
   , int  right   , int  left   , boolean  var_cont   , int
   ____writeable____num   , BS  ___tmp22   , Continuation  ___k  ) { int
   medium ;  int  aux01 ;  int  ___tmp21 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod22  ___k1 ; ___pseudoThis = this;
   ___tmp21 = ___tmp22.____1234Div4321____;  medium = ___tmp21;  aux01 = number
   [ medium ]; if ( ____writeable____num < aux01 ) { right = medium - 1;  ___k1
   = new ___ContinuationClasscontinuationMethod22();  ___k1.num = num;  ___k1.
   right = right;  ___k1.left = left;  ___k1.var_cont = var_cont;  ___k1.
   ____writeable____num = ____writeable____num;  ___k1.___tmp22 = ___tmp22;
   ___k1.aux01 = aux01;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call();
   }  else { left = medium + 1;  ___k1 = new
   ___ContinuationClasscontinuationMethod22();  ___k1.num = num;  ___k1.right =
   right;  ___k1.left = left;  ___k1.var_cont = var_cont;  ___k1.
   ____writeable____num = ____writeable____num;  ___k1.___tmp22 = ___tmp22;
   ___k1.aux01 = aux01;  ___k1.___k = ___k;  ___k1.object = this; ___k1.call();
   }  }  public void whileMethod1 (int  num , int  right   , int  left   ,
   boolean  var_cont   , int  ____writeable____num   , Continuation  ___k  ) {
   boolean  bs01 ;  int  medium ;  int  aux01 ;  int  nt ;  int [ ]   ___tmp20
   ;  BS  ___tmp22 ;  int  ___tmp21 ;  BS  ___tmp24 ;  boolean  ___tmp23 ;  BS
   ___tmp26 ;  boolean  ___tmp25 ;  BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod21  ___k1 ; ___pseudoThis = this; if (
   var_cont ) { medium = left + right;  ___tmp22 = this;  ___k1 = new
   ___ContinuationClasscontinuationMethod21();  ___k1.num = num;  ___k1.right =
   right;  ___k1.left = left;  ___k1.var_cont = var_cont;  ___k1.
   ____writeable____num = ____writeable____num;  ___k1.___tmp22 = ___tmp22;
   ___k1.___k = ___k;  ___k1.object = this; ___tmp22.Div(medium , ___k1); }
   else { ___k.call(); }  }  public void continuationMethod26 (int  num , int
   count01   , Continuation  ___k  ) { BS  ___pseudoThis ; ___pseudoThis = this
   ;  ____1234Div4321____ = count01; ___k.call(); }  public void whileMethod2 (
   int  num , int  count01   , int  count02   , int  aux03   , Continuation
   ___k  ) { int  ____writeable____num ;  BS  ___pseudoThis ; ___pseudoThis =
   this; if ( count02 < aux03 ) { count01 = count01 + 1;  count02 = count02 + 2
   ; ___pseudoThis.whileMethod2(num , count01 , count02 , aux03 , ___k); }
   else { ___k.call(); }  }  public void continuationMethod27 (int  num1 , int
   num2   , boolean  retval   , Continuation  ___k  ) { BS  ___pseudoThis ;
   ___pseudoThis = this;  ____1234Compare4321____ = retval; ___k.call(); }
   public void continuationMethod28 (int  num1 , int  num2   , boolean  retval
   , Continuation  ___k  ) { BS  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod27  ___k1 ; ___pseudoThis = this;
   ___k1 = new ___ContinuationClasscontinuationMethod27();  ___k1.num1 = num1;
   ___k1.num2 = num2;  ___k1.retval = retval;  ___k1.___k = ___k;  ___k1.object
   = this; ___k1.call(); }  public void continuationMethod29 (Continuation
   ___k ) { BS  ___pseudoThis ; ___pseudoThis = this;  System.out.println (
   99999 ) ;  ____1234Print4321____ = 0; ___k.call(); }  public void
   whileMethod3 (int  j , int  ____tmp28   , Continuation  ___k  ) { BS
   ___pseudoThis ; ___pseudoThis = this; if ( j < ____tmp28 ) {
   System.out.println ( number [ j ] ) ;  j = j + 1;  ____tmp28 = size;
   ___pseudoThis.whileMethod3(j , ____tmp28 , ___k); }  else { ___k.call(); }
   }  public void continuationMethod30 (int  sz , Continuation  ___k  ) { BS
   ___pseudoThis ; ___pseudoThis = this;  ____1234Init4321____ = 0; ___k.call()
   ; }  public void whileMethod4 (int  sz , int  j   , int  k   , int
   ____tmp29   , Continuation  ___k  ) { int  aux02 ;  int  aux01 ;  int
   ____writeable____sz ;  BS  ___pseudoThis ; ___pseudoThis = this; if ( j <
   ____tmp29 ) { aux01 = 2 * j;  aux02 = k - 3;  number[j] = aux01 + aux02;  j
   = j + 1;  k = k - 1;  ____tmp29 = size; ___pseudoThis.whileMethod4(sz , j ,
   k , ____tmp29 , ___k); }  else { ___k.call(); }  }}
class ____NewMainClass____ { public void ____Main____ (int  ____arg_length____
   , Continuation  ___k  ) { int  ____printMe____ ;  BS  ___tmp31 ;  int
   ___tmp30 ;  ____NewMainClass____  ___pseudoThis ;
   ___ContinuationClasscontinuationMethod31  ___k1 ; ___pseudoThis = this;
   ___tmp31 = new BS();  ___k1 = new ___ContinuationClasscontinuationMethod31()
   ;  ___k1.____arg_length____ = ____arg_length____;  ___k1.___tmp31 = ___tmp31
   ;  ___k1.___k = ___k;  ___k1.object = this; ___tmp31.Start(20 , ___k1); }
   public void continuationMethod31 (int  ____arg_length____ , BS  ___tmp31   ,
   Continuation  ___k  ) { int  ____printMe____ ;  int  ___tmp30 ;
   ____NewMainClass____  ___pseudoThis ; ___pseudoThis = this;  ___tmp30 =
   ___tmp31.____1234Start4321____;  ____printMe____ = ___tmp30;
   System.out.println ( ____printMe____ ) ; ___k.call(); }}
class ___ContinuationClasscontinuationMethod17 extends Continuation { int  sz ;
   BS  ___tmp1 ; BS  ___tmp3 ; BS  ___tmp5 ; BS  ___tmp7 ; BS  ___tmp9 ; BS
   ___tmp11 ; BS  ___tmp13 ; BS  ___tmp15 ; BS  ___tmp17 ; BS  ___tmp19 ;
   Continuation  ___k ; BS  object ; public void call () { object.
   continuationMethod17(sz , ___tmp1 , ___tmp3 , ___tmp5 , ___tmp7 , ___tmp9 ,
   ___tmp11 , ___tmp13 , ___tmp15 , ___tmp17 , ___tmp19 , ___k); }}
class ___ContinuationClasscontinuationMethod16 extends Continuation { int  sz ;
   BS  ___tmp1 ; BS  ___tmp3 ; BS  ___tmp5 ; BS  ___tmp7 ; BS  ___tmp9 ; BS
   ___tmp11 ; BS  ___tmp13 ; BS  ___tmp15 ; BS  ___tmp17 ; BS  ___tmp19 ;
   Continuation  ___k ; BS  object ; public void call () { object.
   continuationMethod16(sz , ___tmp1 , ___tmp3 , ___tmp5 , ___tmp7 , ___tmp9 ,
   ___tmp11 , ___tmp13 , ___tmp15 , ___tmp17 , ___tmp19 , ___k); }}
class ___ContinuationClasscontinuationMethod15 extends Continuation { int  sz ;
   BS  ___tmp1 ; BS  ___tmp3 ; BS  ___tmp5 ; BS  ___tmp7 ; BS  ___tmp9 ; BS
   ___tmp11 ; BS  ___tmp13 ; BS  ___tmp15 ; BS  ___tmp17 ; Continuation  ___k ;
   BS  object ; public void call () { object.continuationMethod15(sz , ___tmp1
   , ___tmp3 , ___tmp5 , ___tmp7 , ___tmp9 , ___tmp11 , ___tmp13 , ___tmp15 ,
   ___tmp17 , ___k); }}
class ___ContinuationClasscontinuationMethod14 extends Continuation { int  sz ;
   BS  ___tmp1 ; BS  ___tmp3 ; BS  ___tmp5 ; BS  ___tmp7 ; BS  ___tmp9 ; BS
   ___tmp11 ; BS  ___tmp13 ; BS  ___tmp15 ; BS  ___tmp17 ; Continuation  ___k ;
   BS  object ; public void call () { object.continuationMethod14(sz , ___tmp1
   , ___tmp3 , ___tmp5 , ___tmp7 , ___tmp9 , ___tmp11 , ___tmp13 , ___tmp15 ,
   ___tmp17 , ___k); }}
class ___ContinuationClasscontinuationMethod13 extends Continuation { int  sz ;
   BS  ___tmp1 ; BS  ___tmp3 ; BS  ___tmp5 ; BS  ___tmp7 ; BS  ___tmp9 ; BS
   ___tmp11 ; BS  ___tmp13 ; BS  ___tmp15 ; Continuation  ___k ; BS  object ;
   public void call () { object.continuationMethod13(sz , ___tmp1 , ___tmp3 ,
   ___tmp5 , ___tmp7 , ___tmp9 , ___tmp11 , ___tmp13 , ___tmp15 , ___k); }}
class ___ContinuationClasscontinuationMethod12 extends Continuation { int  sz ;
   BS  ___tmp1 ; BS  ___tmp3 ; BS  ___tmp5 ; BS  ___tmp7 ; BS  ___tmp9 ; BS
   ___tmp11 ; BS  ___tmp13 ; BS  ___tmp15 ; Continuation  ___k ; BS  object ;
   public void call () { object.continuationMethod12(sz , ___tmp1 , ___tmp3 ,
   ___tmp5 , ___tmp7 , ___tmp9 , ___tmp11 , ___tmp13 , ___tmp15 , ___k); }}
class ___ContinuationClasscontinuationMethod11 extends Continuation { int  sz ;
   BS  ___tmp1 ; BS  ___tmp3 ; BS  ___tmp5 ; BS  ___tmp7 ; BS  ___tmp9 ; BS
   ___tmp11 ; BS  ___tmp13 ; Continuation  ___k ; BS  object ; public void call
   () { object.continuationMethod11(sz , ___tmp1 , ___tmp3 , ___tmp5 , ___tmp7
   , ___tmp9 , ___tmp11 , ___tmp13 , ___k); }}
class ___ContinuationClasscontinuationMethod10 extends Continuation { int  sz ;
   BS  ___tmp1 ; BS  ___tmp3 ; BS  ___tmp5 ; BS  ___tmp7 ; BS  ___tmp9 ; BS
   ___tmp11 ; BS  ___tmp13 ; Continuation  ___k ; BS  object ; public void call
   () { object.continuationMethod10(sz , ___tmp1 , ___tmp3 , ___tmp5 , ___tmp7
   , ___tmp9 , ___tmp11 , ___tmp13 , ___k); }}
class ___ContinuationClasscontinuationMethod9 extends Continuation { int  sz ;
   BS  ___tmp1 ; BS  ___tmp3 ; BS  ___tmp5 ; BS  ___tmp7 ; BS  ___tmp9 ; BS
   ___tmp11 ; Continuation  ___k ; BS  object ; public void call () { object.
   continuationMethod9(sz , ___tmp1 , ___tmp3 , ___tmp5 , ___tmp7 , ___tmp9 ,
   ___tmp11 , ___k); }}
class ___ContinuationClasscontinuationMethod8 extends Continuation { int  sz ;
   BS  ___tmp1 ; BS  ___tmp3 ; BS  ___tmp5 ; BS  ___tmp7 ; BS  ___tmp9 ; BS
   ___tmp11 ; Continuation  ___k ; BS  object ; public void call () { object.
   continuationMethod8(sz , ___tmp1 , ___tmp3 , ___tmp5 , ___tmp7 , ___tmp9 ,
   ___tmp11 , ___k); }}
class ___ContinuationClasscontinuationMethod7 extends Continuation { int  sz ;
   BS  ___tmp1 ; BS  ___tmp3 ; BS  ___tmp5 ; BS  ___tmp7 ; BS  ___tmp9 ;
   Continuation  ___k ; BS  object ; public void call () { object.
   continuationMethod7(sz , ___tmp1 , ___tmp3 , ___tmp5 , ___tmp7 , ___tmp9 ,
   ___k); }}
class ___ContinuationClasscontinuationMethod6 extends Continuation { int  sz ;
   BS  ___tmp1 ; BS  ___tmp3 ; BS  ___tmp5 ; BS  ___tmp7 ; BS  ___tmp9 ;
   Continuation  ___k ; BS  object ; public void call () { object.
   continuationMethod6(sz , ___tmp1 , ___tmp3 , ___tmp5 , ___tmp7 , ___tmp9 ,
   ___k); }}
class ___ContinuationClasscontinuationMethod5 extends Continuation { int  sz ;
   BS  ___tmp1 ; BS  ___tmp3 ; BS  ___tmp5 ; BS  ___tmp7 ; Continuation  ___k ;
   BS  object ; public void call () { object.continuationMethod5(sz , ___tmp1 ,
   ___tmp3 , ___tmp5 , ___tmp7 , ___k); }}
class ___ContinuationClasscontinuationMethod4 extends Continuation { int  sz ;
   BS  ___tmp1 ; BS  ___tmp3 ; BS  ___tmp5 ; BS  ___tmp7 ; Continuation  ___k ;
   BS  object ; public void call () { object.continuationMethod4(sz , ___tmp1 ,
   ___tmp3 , ___tmp5 , ___tmp7 , ___k); }}
class ___ContinuationClasscontinuationMethod3 extends Continuation { int  sz ;
   BS  ___tmp1 ; BS  ___tmp3 ; BS  ___tmp5 ; Continuation  ___k ; BS  object ;
   public void call () { object.continuationMethod3(sz , ___tmp1 , ___tmp3 ,
   ___tmp5 , ___k); }}
class ___ContinuationClasscontinuationMethod2 extends Continuation { int  sz ;
   BS  ___tmp1 ; BS  ___tmp3 ; BS  ___tmp5 ; Continuation  ___k ; BS  object ;
   public void call () { object.continuationMethod2(sz , ___tmp1 , ___tmp3 ,
   ___tmp5 , ___k); }}
class ___ContinuationClasscontinuationMethod1 extends Continuation { int  sz ;
   BS  ___tmp1 ; BS  ___tmp3 ; Continuation  ___k ; BS  object ; public void
   call () { object.continuationMethod1(sz , ___tmp1 , ___tmp3 , ___k); }}
class ___ContinuationClasscontinuationMethod0 extends Continuation { int  sz ;
   BS  ___tmp1 ; Continuation  ___k ; BS  object ; public void call () { object
   .continuationMethod0(sz , ___tmp1 , ___k); }}
class ___ContinuationClasscontinuationMethod20 extends Continuation { int  num
   ; int  aux01 ; int  ____writeable____num ; BS  ___tmp26 ; boolean  bs01 ;
   Continuation  ___k ; BS  object ; public void call () { object.
   continuationMethod20(num , aux01 , ____writeable____num , ___tmp26 , bs01 ,
   ___k); }}
class ___ContinuationClasscontinuationMethod19 extends Continuation { int  num
   ; int  aux01 ; int  ____writeable____num ; BS  ___tmp26 ; Continuation  ___k
   ; BS  object ; public void call () { object.continuationMethod19(num , aux01
   , ____writeable____num , ___tmp26 , ___k); }}
class ___ContinuationClasscontinuationMethod18 extends Continuation { int  num
   ; int  aux01 ; int  ____writeable____num ; Continuation  ___k ; BS  object ;
   public void call () { object.continuationMethod18(num , aux01 ,
   ____writeable____num , ___k); }}
class ___ContinuationClasscontinuationMethod25 extends Continuation { int  num
   ; int  right ; int  left ; boolean  var_cont ; int  ____writeable____num ;
   BS  ___tmp22 ; int  aux01 ; BS  ___tmp24 ; Continuation  ___k ; BS  object ;
   public void call () { object.continuationMethod25(num , right , left ,
   var_cont , ____writeable____num , ___tmp22 , aux01 , ___tmp24 , ___k); }}
class ___ContinuationClasscontinuationMethod24 extends Continuation { int  num
   ; int  right ; int  left ; boolean  var_cont ; int  ____writeable____num ;
   BS  ___tmp22 ; int  aux01 ; BS  ___tmp24 ; Continuation  ___k ; BS  object ;
   public void call () { object.continuationMethod24(num , right , left ,
   var_cont , ____writeable____num , ___tmp22 , aux01 , ___tmp24 , ___k); }}
class ___ContinuationClasscontinuationMethod23 extends Continuation { int  num
   ; int  right ; int  left ; boolean  var_cont ; int  ____writeable____num ;
   BS  ___tmp22 ; int  aux01 ; BS  ___tmp24 ; Continuation  ___k ; BS  object ;
   public void call () { object.continuationMethod23(num , right , left ,
   var_cont , ____writeable____num , ___tmp22 , aux01 , ___tmp24 , ___k); }}
class ___ContinuationClasscontinuationMethod22 extends Continuation { int  num
   ; int  right ; int  left ; boolean  var_cont ; int  ____writeable____num ;
   BS  ___tmp22 ; int  aux01 ; Continuation  ___k ; BS  object ; public void
   call () { object.continuationMethod22(num , right , left , var_cont ,
   ____writeable____num , ___tmp22 , aux01 , ___k); }}
class ___ContinuationClasscontinuationMethod21 extends Continuation { int  num
   ; int  right ; int  left ; boolean  var_cont ; int  ____writeable____num ;
   BS  ___tmp22 ; Continuation  ___k ; BS  object ; public void call () {
   object.continuationMethod21(num , right , left , var_cont ,
   ____writeable____num , ___tmp22 , ___k); }}
class ___ContinuationClasscontinuationMethod26 extends Continuation { int  num
   ; int  count01 ; Continuation  ___k ; BS  object ; public void call () {
   object.continuationMethod26(num , count01 , ___k); }}
class ___ContinuationClasscontinuationMethod27 extends Continuation { int  num1
   ; int  num2 ; boolean  retval ; Continuation  ___k ; BS  object ; public
   void call () { object.continuationMethod27(num1 , num2 , retval , ___k); }}
class ___ContinuationClasscontinuationMethod28 extends Continuation { int  num1
   ; int  num2 ; boolean  retval ; Continuation  ___k ; BS  object ; public
   void call () { object.continuationMethod28(num1 , num2 , retval , ___k); }}
class ___ContinuationClasscontinuationMethod29 extends Continuation {
   Continuation  ___k ; BS  object ; public void call () { object.
   continuationMethod29(___k ); }}
class ___ContinuationClasscontinuationMethod30 extends Continuation { int  sz ;
   Continuation  ___k ; BS  object ; public void call () { object.
   continuationMethod30(sz , ___k); }}
class ___ContinuationClasscontinuationMethod31 extends Continuation { int
   ____arg_length____ ; BS  ___tmp31 ; Continuation  ___k ;
   ____NewMainClass____  object ; public void call () { object.
   continuationMethod31(____arg_length____ , ___tmp31 , ___k); }}
class Continuation { public void call () { }} 