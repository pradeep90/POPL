 class LinkedList {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ; } }  class Element { int
   Age ;   int  Salary ;   boolean  Married ;   boolean  ____1234Init4321____ ;
   int  ____1234GetAge4321____ ;   int  ____1234GetSalary4321____ ;   boolean
   ____1234GetMarried4321____ ;   boolean  ____1234Equal4321____ ;   boolean
   ____1234Compare4321____ ; public void Init ( int  v_Age , int  v_Salary   ,
   boolean  v_Married   ) { Age = v_Age ;  Salary = v_Salary ;  Married =
   v_Married ;  ____1234Init4321____ = true ; }   public void GetAge (  ) {
   ____1234GetAge4321____ = Age ; }   public void GetSalary (  ) {
   ____1234GetSalary4321____ = Salary ; }   public void GetMarried (  ) {
   ____1234GetMarried4321____ = Married ; }   public void Equal ( Element
   other  ) { boolean  ret_val ;  int  aux01 ;  int  aux02 ;  int  nt ;
   Element  ___tmp2 ;  int  ___tmp3 ;  Element  ___tmp4 ;  boolean  ___tmp5 ;
   Element  ___tmp6 ;  int  ___tmp7 ;  Element  ___tmp8 ;  boolean  ___tmp9 ;
   Element  ___tmp10 ;  boolean  ___tmp11 ;  Element  ___tmp12 ;  boolean
   ___tmp13 ; ret_val = true ;  ___tmp2 = other ;  ___tmp2 . GetAge ( ) ;
   ___tmp3 = ___tmp2 . ____1234GetAge4321____ ;  aux01 = ___tmp3 ;  ___tmp4 =
   this ;  ___tmp4 . Compare ( aux01 , Age ) ;  ___tmp5 = ___tmp4 .
   ____1234Compare4321____ ;  if ( ! ___tmp5 ) ret_val = false ;  else {
   ___tmp6 = other ;  ___tmp6 . GetSalary ( ) ;  ___tmp7 = ___tmp6 .
   ____1234GetSalary4321____ ;  aux02 = ___tmp7 ;  ___tmp8 = this ;  ___tmp8 .
   Compare ( aux02 , Salary ) ;  ___tmp9 = ___tmp8 . ____1234Compare4321____ ;
   if ( ! ___tmp9 ) ret_val = false ;  else if ( Married ) { ___tmp10 = other ;
   ___tmp10 . GetMarried ( ) ;  ___tmp11 = ___tmp10 .
   ____1234GetMarried4321____ ;  if ( ! ___tmp11 ) ret_val = false ;  else nt =
   0 ;  }  else { ___tmp12 = other ;  ___tmp12 . GetMarried ( ) ;  ___tmp13 =
   ___tmp12 . ____1234GetMarried4321____ ;  if ( ___tmp13 ) ret_val = false ;
   else nt = 0 ;  }   }   ____1234Equal4321____ = ret_val ; }   public void
   Compare ( int  num1 , int  num2   ) { boolean  retval ;  int  aux02 ; retval
   = false ;  aux02 = num2 + 1 ;  if ( num1 < num2 ) retval = false ;  else if
   ( ! ( num1 < aux02 ) ) retval = false ;  else retval = true ;
   ____1234Compare4321____ = retval ; } }
class List { Element  elem ;   List  next ;   boolean  end ;   boolean
   ____1234Init4321____ ;   boolean  ____1234InitNew4321____ ;   List
   ____1234Insert4321____ ;   boolean  ____1234SetNext4321____ ;   List
   ____1234Delete4321____ ;   int  ____1234Search4321____ ;   boolean
   ____1234GetEnd4321____ ;   Element  ____1234GetElem4321____ ;   List
   ____1234GetNext4321____ ;   boolean  ____1234Print4321____ ; public void
   Init (  ) { end = true ;  ____1234Init4321____ = true ; }   public void
   InitNew ( Element  v_elem , List  v_next   , boolean  v_end   ) { end =
   v_end ;  elem = v_elem ;  next = v_next ;  ____1234InitNew4321____ = true ;
   }   public void Insert ( Element  new_elem  ) { boolean  ret_val ;  List
   aux03 ;  List  aux02 ;  List  ___tmp14 ;  boolean  ___tmp15 ; aux03 = this ;
   aux02 = new List ( ) ;  ___tmp14 = aux02 ;  ___tmp14 . InitNew ( new_elem ,
   aux03 , false ) ;  ___tmp15 = ___tmp14 . ____1234InitNew4321____ ;  ret_val
   = ___tmp15 ;  ____1234Insert4321____ = aux02 ; }   public void SetNext (
   List  v_next  ) { next = v_next ;  ____1234SetNext4321____ = true ; }
   public void Delete ( Element  e  ) { List  my_head ;  boolean  ret_val ;
   boolean  aux05 ;  List  aux01 ;  List  prev ;  boolean  var_end ;  Element
   var_elem ;  int  aux04 ;  int  nt ;  Element  ___tmp16 ;  boolean  ___tmp17
   ;  List  ___tmp18 ;  List  ___tmp19 ;  List  ___tmp22 ;  boolean  ___tmp23 ;
   List  ___tmp20 ;  List  ___tmp21 ;  List  ___tmp24 ;  List  ___tmp25 ;  List
   ___tmp26 ;  boolean  ___tmp27 ;  List  ___tmp28 ;  Element  ___tmp29 ;
   my_head = this ;  ret_val = false ;  aux04 = 0 - 1 ;  aux01 = this ;  prev =
   this ;  var_end = end ;  var_elem = elem ;  while ( ( ! var_end ) & ( !
   ret_val )  ) { ___tmp16 = e ;  ___tmp16 . Equal ( var_elem  ) ;  ___tmp17 =
   ___tmp16 . ____1234Equal4321____ ;  if ( ___tmp17 ) { ret_val = true ;  if (
   aux04 < 0 ) { ___tmp18 = aux01 ;  ___tmp18 . GetNext ( ) ;  ___tmp19 =
   ___tmp18 . ____1234GetNext4321____ ;  my_head = ___tmp19 ; }  else {
   System.out.println ( 0 - 555 ) ;  ___tmp22 = prev ;  ___tmp20 = aux01 ;
   ___tmp20 . GetNext ( ) ;  ___tmp21 = ___tmp20 . ____1234GetNext4321____ ;
   ___tmp22 . SetNext ( ___tmp21  ) ;  ___tmp23 = ___tmp22 .
   ____1234SetNext4321____ ;  aux05 = ___tmp23 ;  System.out.println ( 0 - 555
   ) ; }  }  else nt = 0 ;   if ( ! ret_val ) { prev = aux01 ;  ___tmp24 =
   aux01 ;  ___tmp24 . GetNext ( ) ;  ___tmp25 = ___tmp24 .
   ____1234GetNext4321____ ;  aux01 = ___tmp25 ;  ___tmp26 = aux01 ;  ___tmp26
   . GetEnd ( ) ;  ___tmp27 = ___tmp26 . ____1234GetEnd4321____ ;  var_end =
   ___tmp27 ;  ___tmp28 = aux01 ;  ___tmp28 . GetElem ( ) ;  ___tmp29 =
   ___tmp28 . ____1234GetElem4321____ ;  var_elem = ___tmp29 ;  aux04 = 1 ; }
   else nt = 0 ;  }   ____1234Delete4321____ = my_head ; }   public void Search
   ( Element  e  ) { int  int_ret_val ;  List  aux01 ;  Element  var_elem ;
   boolean  var_end ;  int  nt ;  Element  ___tmp30 ;  boolean  ___tmp31 ;
   List  ___tmp32 ;  List  ___tmp33 ;  List  ___tmp34 ;  boolean  ___tmp35 ;
   List  ___tmp36 ;  Element  ___tmp37 ; int_ret_val = 0 ;  aux01 = this ;
   var_end = end ;  var_elem = elem ;  while ( ! var_end ) { ___tmp30 = e ;
   ___tmp30 . Equal ( var_elem  ) ;  ___tmp31 = ___tmp30 .
   ____1234Equal4321____ ;  if ( ___tmp31 ) { int_ret_val = 1 ; }  else nt = 0
   ;   ___tmp32 = aux01 ;  ___tmp32 . GetNext ( ) ;  ___tmp33 = ___tmp32 .
   ____1234GetNext4321____ ;  aux01 = ___tmp33 ;  ___tmp34 = aux01 ;  ___tmp34
   . GetEnd ( ) ;  ___tmp35 = ___tmp34 . ____1234GetEnd4321____ ;  var_end =
   ___tmp35 ;  ___tmp36 = aux01 ;  ___tmp36 . GetElem ( ) ;  ___tmp37 =
   ___tmp36 . ____1234GetElem4321____ ;  var_elem = ___tmp37 ; }
   ____1234Search4321____ = int_ret_val ; }   public void GetEnd (  ) {
   ____1234GetEnd4321____ = end ; }   public void GetElem (  ) {
   ____1234GetElem4321____ = elem ; }   public void GetNext (  ) {
   ____1234GetNext4321____ = next ; }   public void Print (  ) { List  aux01 ;
   boolean  var_end ;  Element  var_elem ;  Element  ___tmp38 ;  int  ___tmp39
   ;  List  ___tmp40 ;  List  ___tmp41 ;  List  ___tmp42 ;  boolean  ___tmp43 ;
   List  ___tmp44 ;  Element  ___tmp45 ; aux01 = this ;  var_end = end ;
   var_elem = elem ;  while ( ! var_end ) { ___tmp38 = var_elem ;  ___tmp38 .
   GetAge ( ) ;  ___tmp39 = ___tmp38 . ____1234GetAge4321____ ;
   System.out.println ( ___tmp39 ) ;  ___tmp40 = aux01 ;  ___tmp40 . GetNext (
   ) ;  ___tmp41 = ___tmp40 . ____1234GetNext4321____ ;  aux01 = ___tmp41 ;
   ___tmp42 = aux01 ;  ___tmp42 . GetEnd ( ) ;  ___tmp43 = ___tmp42 .
   ____1234GetEnd4321____ ;  var_end = ___tmp43 ;  ___tmp44 = aux01 ;  ___tmp44
   . GetElem ( ) ;  ___tmp45 = ___tmp44 . ____1234GetElem4321____ ;  var_elem =
   ___tmp45 ; }   ____1234Print4321____ = true ; } }
class LL { int  ____1234Start4321____ ; public void Start (  ) { List  head ;
   List  last_elem ;  boolean  aux01 ;  Element  el01 ;  Element  el02 ;
   Element  el03 ;  List  ___tmp46 ;  boolean  ___tmp47 ;  List  ___tmp48 ;
   boolean  ___tmp49 ;  List  ___tmp50 ;  boolean  ___tmp51 ;  Element
   ___tmp52 ;  boolean  ___tmp53 ;  List  ___tmp54 ;  List  ___tmp55 ;  List
   ___tmp56 ;  boolean  ___tmp57 ;  Element  ___tmp58 ;  boolean  ___tmp59 ;
   List  ___tmp60 ;  List  ___tmp61 ;  List  ___tmp62 ;  boolean  ___tmp63 ;
   Element  ___tmp64 ;  boolean  ___tmp65 ;  List  ___tmp66 ;  List  ___tmp67 ;
   List  ___tmp68 ;  boolean  ___tmp69 ;  Element  ___tmp70 ;  boolean
   ___tmp71 ;  List  ___tmp72 ;  int  ___tmp73 ;  List  ___tmp74 ;  int
   ___tmp75 ;  Element  ___tmp76 ;  boolean  ___tmp77 ;  List  ___tmp78 ;  List
   ___tmp79 ;  List  ___tmp80 ;  boolean  ___tmp81 ;  List  ___tmp82 ;  List
   ___tmp83 ;  List  ___tmp84 ;  boolean  ___tmp85 ;  List  ___tmp86 ;  List
   ___tmp87 ;  List  ___tmp88 ;  boolean  ___tmp89 ; last_elem = new List ( ) ;
   ___tmp46 = last_elem ;  ___tmp46 . Init ( ) ;  ___tmp47 = ___tmp46 .
   ____1234Init4321____ ;  aux01 = ___tmp47 ;  head = last_elem ;  ___tmp48 =
   head ;  ___tmp48 . Init ( ) ;  ___tmp49 = ___tmp48 . ____1234Init4321____ ;
   aux01 = ___tmp49 ;  ___tmp50 = head ;  ___tmp50 . Print ( ) ;  ___tmp51 =
   ___tmp50 . ____1234Print4321____ ;  aux01 = ___tmp51 ;  el01 = new Element (
   ) ;  ___tmp52 = el01 ;  ___tmp52 . Init ( 25 , 37000 , false ) ;  ___tmp53 =
   ___tmp52 . ____1234Init4321____ ;  aux01 = ___tmp53 ;  ___tmp54 = head ;
   ___tmp54 . Insert ( el01  ) ;  ___tmp55 = ___tmp54 . ____1234Insert4321____
   ;  head = ___tmp55 ;  ___tmp56 = head ;  ___tmp56 . Print ( ) ;  ___tmp57 =
   ___tmp56 . ____1234Print4321____ ;  aux01 = ___tmp57 ;  System.out.println (
   10000000 ) ;  el01 = new Element ( ) ;  ___tmp58 = el01 ;  ___tmp58 . Init (
   39 , 42000 , true ) ;  ___tmp59 = ___tmp58 . ____1234Init4321____ ;  aux01 =
   ___tmp59 ;  el02 = el01 ;  ___tmp60 = head ;  ___tmp60 . Insert ( el01  ) ;
   ___tmp61 = ___tmp60 . ____1234Insert4321____ ;  head = ___tmp61 ;  ___tmp62
   = head ;  ___tmp62 . Print ( ) ;  ___tmp63 = ___tmp62 .
   ____1234Print4321____ ;  aux01 = ___tmp63 ;  System.out.println ( 10000000 )
   ;  el01 = new Element ( ) ;  ___tmp64 = el01 ;  ___tmp64 . Init ( 22 , 34000
   , false ) ;  ___tmp65 = ___tmp64 . ____1234Init4321____ ;  aux01 = ___tmp65
   ;  ___tmp66 = head ;  ___tmp66 . Insert ( el01  ) ;  ___tmp67 = ___tmp66 .
   ____1234Insert4321____ ;  head = ___tmp67 ;  ___tmp68 = head ;  ___tmp68 .
   Print ( ) ;  ___tmp69 = ___tmp68 . ____1234Print4321____ ;  aux01 = ___tmp69
   ;  el03 = new Element ( ) ;  ___tmp70 = el03 ;  ___tmp70 . Init ( 27 , 34000
   , false ) ;  ___tmp71 = ___tmp70 . ____1234Init4321____ ;  aux01 = ___tmp71
   ;  ___tmp72 = head ;  ___tmp72 . Search ( el02  ) ;  ___tmp73 = ___tmp72 .
   ____1234Search4321____ ;  System.out.println ( ___tmp73 ) ;  ___tmp74 = head
   ;  ___tmp74 . Search ( el03  ) ;  ___tmp75 = ___tmp74 .
   ____1234Search4321____ ;  System.out.println ( ___tmp75 ) ;
   System.out.println ( 10000000 ) ;  el01 = new Element ( ) ;  ___tmp76 = el01
   ;  ___tmp76 . Init ( 28 , 35000 , false ) ;  ___tmp77 = ___tmp76 .
   ____1234Init4321____ ;  aux01 = ___tmp77 ;  ___tmp78 = head ;  ___tmp78 .
   Insert ( el01  ) ;  ___tmp79 = ___tmp78 . ____1234Insert4321____ ;  head =
   ___tmp79 ;  ___tmp80 = head ;  ___tmp80 . Print ( ) ;  ___tmp81 = ___tmp80 .
   ____1234Print4321____ ;  aux01 = ___tmp81 ;  System.out.println ( 2220000 )
   ;  ___tmp82 = head ;  ___tmp82 . Delete ( el02  ) ;  ___tmp83 = ___tmp82 .
   ____1234Delete4321____ ;  head = ___tmp83 ;  ___tmp84 = head ;  ___tmp84 .
   Print ( ) ;  ___tmp85 = ___tmp84 . ____1234Print4321____ ;  aux01 = ___tmp85
   ;  System.out.println ( 33300000 ) ;  ___tmp86 = head ;  ___tmp86 . Delete (
   el01  ) ;  ___tmp87 = ___tmp86 . ____1234Delete4321____ ;  head = ___tmp87 ;
   ___tmp88 = head ;  ___tmp88 . Print ( ) ;  ___tmp89 = ___tmp88 .
   ____1234Print4321____ ;  aux01 = ___tmp89 ;  System.out.println ( 44440000 )
   ;  ____1234Start4321____ = 0 ; } }
class ____NewMainClass____ { public void ____Main____ ( int  ____arg_length____
   ) { LL  ___tmp0 ;  int  ___tmp1 ; ___tmp0 = new LL ( ) ;  ___tmp0 . Start (
   ) ;  ___tmp1 = ___tmp0 . ____1234Start4321____ ;  System.out.println (
   ___tmp1 ) ; } } 