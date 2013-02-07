 class TreeVisitor {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ; } }  class TV { int
   ____1234Start4321____ ; public void Start (  ) { Tree  root ;  boolean  ntb
   ;  int  nti ;  MyVisitor  v ;  Tree  ___tmp2 ;  boolean  ___tmp3 ;  Tree
   ___tmp4 ;  boolean  ___tmp5 ;  Tree  ___tmp6 ;  boolean  ___tmp7 ;  Tree
   ___tmp8 ;  boolean  ___tmp9 ;  Tree  ___tmp10 ;  boolean  ___tmp11 ;  Tree
   ___tmp12 ;  boolean  ___tmp13 ;  Tree  ___tmp14 ;  boolean  ___tmp15 ;  Tree
   ___tmp16 ;  boolean  ___tmp17 ;  Tree  ___tmp18 ;  boolean  ___tmp19 ;  Tree
   ___tmp20 ;  boolean  ___tmp21 ;  Tree  ___tmp22 ;  int  ___tmp23 ;  Tree
   ___tmp24 ;  int  ___tmp25 ;  Tree  ___tmp26 ;  int  ___tmp27 ;  Tree
   ___tmp28 ;  int  ___tmp29 ;  Tree  ___tmp30 ;  int  ___tmp31 ;  Tree
   ___tmp32 ;  int  ___tmp33 ;  Tree  ___tmp34 ;  boolean  ___tmp35 ;  Tree
   ___tmp36 ;  boolean  ___tmp37 ;  Tree  ___tmp38 ;  int  ___tmp39 ; root =
   new Tree ( ) ;  ___tmp2 = root ;  ___tmp2 . Init ( 16  ) ;  ___tmp3 =
   ___tmp2 . ____1234Init4321____ ;  ntb = ___tmp3 ;  ___tmp4 = root ;  ___tmp4
   . Print ( ) ;  ___tmp5 = ___tmp4 . ____1234Print4321____ ;  ntb = ___tmp5 ;
   System.out.println ( 100000000 ) ;  ___tmp6 = root ;  ___tmp6 . Insert ( 8
   ) ;  ___tmp7 = ___tmp6 . ____1234Insert4321____ ;  ntb = ___tmp7 ;  ___tmp8
   = root ;  ___tmp8 . Insert ( 24  ) ;  ___tmp9 = ___tmp8 .
   ____1234Insert4321____ ;  ntb = ___tmp9 ;  ___tmp10 = root ;  ___tmp10 .
   Insert ( 4  ) ;  ___tmp11 = ___tmp10 . ____1234Insert4321____ ;  ntb =
   ___tmp11 ;  ___tmp12 = root ;  ___tmp12 . Insert ( 12  ) ;  ___tmp13 =
   ___tmp12 . ____1234Insert4321____ ;  ntb = ___tmp13 ;  ___tmp14 = root ;
   ___tmp14 . Insert ( 20  ) ;  ___tmp15 = ___tmp14 . ____1234Insert4321____ ;
   ntb = ___tmp15 ;  ___tmp16 = root ;  ___tmp16 . Insert ( 28  ) ;  ___tmp17 =
   ___tmp16 . ____1234Insert4321____ ;  ntb = ___tmp17 ;  ___tmp18 = root ;
   ___tmp18 . Insert ( 14  ) ;  ___tmp19 = ___tmp18 . ____1234Insert4321____ ;
   ntb = ___tmp19 ;  ___tmp20 = root ;  ___tmp20 . Print ( ) ;  ___tmp21 =
   ___tmp20 . ____1234Print4321____ ;  ntb = ___tmp21 ;  System.out.println (
   100000000 ) ;  v = new MyVisitor ( ) ;  System.out.println ( 50000000 ) ;
   ___tmp22 = root ;  ___tmp22 . accept ( v  ) ;  ___tmp23 = ___tmp22 .
   ____1234accept4321____ ;  nti = ___tmp23 ;  System.out.println ( 100000000 )
   ;  ___tmp24 = root ;  ___tmp24 . Search ( 24  ) ;  ___tmp25 = ___tmp24 .
   ____1234Search4321____ ;  System.out.println ( ___tmp25 ) ;  ___tmp26 = root
   ;  ___tmp26 . Search ( 12  ) ;  ___tmp27 = ___tmp26 . ____1234Search4321____
   ;  System.out.println ( ___tmp27 ) ;  ___tmp28 = root ;  ___tmp28 . Search (
   16  ) ;  ___tmp29 = ___tmp28 . ____1234Search4321____ ;  System.out.println
   ( ___tmp29 ) ;  ___tmp30 = root ;  ___tmp30 . Search ( 50  ) ;  ___tmp31 =
   ___tmp30 . ____1234Search4321____ ;  System.out.println ( ___tmp31 ) ;
   ___tmp32 = root ;  ___tmp32 . Search ( 12  ) ;  ___tmp33 = ___tmp32 .
   ____1234Search4321____ ;  System.out.println ( ___tmp33 ) ;  ___tmp34 = root
   ;  ___tmp34 . Delete ( 12  ) ;  ___tmp35 = ___tmp34 . ____1234Delete4321____
   ;  ntb = ___tmp35 ;  ___tmp36 = root ;  ___tmp36 . Print ( ) ;  ___tmp37 =
   ___tmp36 . ____1234Print4321____ ;  ntb = ___tmp37 ;  ___tmp38 = root ;
   ___tmp38 . Search ( 12  ) ;  ___tmp39 = ___tmp38 . ____1234Search4321____ ;
   System.out.println ( ___tmp39 ) ;  ____1234Start4321____ = 0 ; } }
class Tree { Tree  left ;   Tree  right ;   int  key ;   boolean  has_left ;
   boolean  has_right ;   Tree  my_null ;   boolean  ____1234Init4321____ ;
   boolean  ____1234SetRight4321____ ;   boolean  ____1234SetLeft4321____ ;
   Tree  ____1234GetRight4321____ ;   Tree  ____1234GetLeft4321____ ;   int
   ____1234GetKey4321____ ;   boolean  ____1234SetKey4321____ ;   boolean
   ____1234GetHas_Right4321____ ;   boolean  ____1234GetHas_Left4321____ ;
   boolean  ____1234SetHas_Left4321____ ;   boolean
   ____1234SetHas_Right4321____ ;   boolean  ____1234Compare4321____ ;
   boolean  ____1234Insert4321____ ;   boolean  ____1234Delete4321____ ;
   boolean  ____1234Remove4321____ ;   boolean  ____1234RemoveRight4321____ ;
   boolean  ____1234RemoveLeft4321____ ;   int  ____1234Search4321____ ;
   boolean  ____1234Print4321____ ;   boolean  ____1234RecPrint4321____ ;   int
   ____1234accept4321____ ; public void Init ( int  v_key  ) { key = v_key ;
   has_left = false ;  has_right = false ;  ____1234Init4321____ = true ; }
   public void SetRight ( Tree  rn  ) { right = rn ;  ____1234SetRight4321____
   = true ; }   public void SetLeft ( Tree  ln  ) { left = ln ;
   ____1234SetLeft4321____ = true ; }   public void GetRight (  ) {
   ____1234GetRight4321____ = right ; }   public void GetLeft (  ) {
   ____1234GetLeft4321____ = left ; }   public void GetKey (  ) {
   ____1234GetKey4321____ = key ; }   public void SetKey ( int  v_key  ) { key
   = v_key ;  ____1234SetKey4321____ = true ; }   public void GetHas_Right (  )
   { ____1234GetHas_Right4321____ = has_right ; }   public void GetHas_Left (
   ) { ____1234GetHas_Left4321____ = has_left ; }   public void SetHas_Left (
   boolean  val  ) { has_left = val ;  ____1234SetHas_Left4321____ = true ; }
   public void SetHas_Right ( boolean  val  ) { has_right = val ;
   ____1234SetHas_Right4321____ = true ; }   public void Compare ( int  num1 ,
   int  num2   ) { boolean  ntb ;  int  nti ; ntb = false ;  nti = num2 + 1 ;
   if ( num1 < num2 ) ntb = false ;  else if ( ! ( num1 < nti ) ) ntb = false ;
   else ntb = true ;    ____1234Compare4321____ = ntb ; }   public void Insert
   ( int  v_key  ) { Tree  new_node ;  boolean  ntb ;  Tree  current_node ;
   boolean  cont ;  int  key_aux ;  Tree  ___tmp40 ;  boolean  ___tmp41 ;  Tree
   ___tmp42 ;  int  ___tmp43 ;  Tree  ___tmp44 ;  boolean  ___tmp45 ;  Tree
   ___tmp46 ;  Tree  ___tmp47 ;  Tree  ___tmp48 ;  boolean  ___tmp49 ;  Tree
   ___tmp50 ;  boolean  ___tmp51 ;  Tree  ___tmp52 ;  boolean  ___tmp53 ;  Tree
   ___tmp54 ;  Tree  ___tmp55 ;  Tree  ___tmp56 ;  boolean  ___tmp57 ;  Tree
   ___tmp58 ;  boolean  ___tmp59 ; new_node = new Tree ( ) ;  ___tmp40 =
   new_node ;  ___tmp40 . Init ( v_key  ) ;  ___tmp41 = ___tmp40 .
   ____1234Init4321____ ;  ntb = ___tmp41 ;  current_node = this ;  cont = true
   ;  while ( cont ) { ___tmp42 = current_node ;  ___tmp42 . GetKey ( ) ;
   ___tmp43 = ___tmp42 . ____1234GetKey4321____ ;  key_aux = ___tmp43 ;  if (
   v_key < key_aux ) { ___tmp44 = current_node ;  ___tmp44 . GetHas_Left ( ) ;
   ___tmp45 = ___tmp44 . ____1234GetHas_Left4321____ ;  if ( ___tmp45 ) {
   ___tmp46 = current_node ;  ___tmp46 . GetLeft ( ) ;  ___tmp47 = ___tmp46 .
   ____1234GetLeft4321____ ;  current_node = ___tmp47 ; }  else { cont = false
   ;  ___tmp48 = current_node ;  ___tmp48 . SetHas_Left ( true  ) ;  ___tmp49 =
   ___tmp48 . ____1234SetHas_Left4321____ ;  ntb = ___tmp49 ;  ___tmp50 =
   current_node ;  ___tmp50 . SetLeft ( new_node  ) ;  ___tmp51 = ___tmp50 .
   ____1234SetLeft4321____ ;  ntb = ___tmp51 ; }  }  else { ___tmp52 =
   current_node ;  ___tmp52 . GetHas_Right ( ) ;  ___tmp53 = ___tmp52 .
   ____1234GetHas_Right4321____ ;  if ( ___tmp53 ) { ___tmp54 = current_node ;
   ___tmp54 . GetRight ( ) ;  ___tmp55 = ___tmp54 . ____1234GetRight4321____ ;
   current_node = ___tmp55 ; }  else { cont = false ;  ___tmp56 = current_node
   ;  ___tmp56 . SetHas_Right ( true  ) ;  ___tmp57 = ___tmp56 .
   ____1234SetHas_Right4321____ ;  ntb = ___tmp57 ;  ___tmp58 = current_node ;
   ___tmp58 . SetRight ( new_node  ) ;  ___tmp59 = ___tmp58 .
   ____1234SetRight4321____ ;  ntb = ___tmp59 ; }  }  }
   ____1234Insert4321____ = true ; }   public void Delete ( int  v_key  ) {
   Tree  current_node ;  Tree  parent_node ;  boolean  cont ;  boolean  found ;
   boolean  ntb ;  boolean  is_root ;  int  key_aux ;  Tree  ___tmp60 ;  int
   ___tmp61 ;  Tree  ___tmp62 ;  boolean  ___tmp63 ;  Tree  ___tmp64 ;  Tree
   ___tmp65 ;  Tree  ___tmp66 ;  boolean  ___tmp67 ;  Tree  ___tmp68 ;  Tree
   ___tmp69 ;  Tree  ___tmp70 ;  boolean  ___tmp71 ;  Tree  ___tmp72 ;  boolean
   ___tmp73 ;  Tree  ___tmp74 ;  boolean  ___tmp75 ;  Tree  ___tmp76 ;  boolean
   ___tmp77 ; current_node = this ;  parent_node = this ;  cont = true ;  found
   = false ;  is_root = true ;  while ( cont ) { ___tmp60 = current_node ;
   ___tmp60 . GetKey ( ) ;  ___tmp61 = ___tmp60 . ____1234GetKey4321____ ;
   key_aux = ___tmp61 ;  if ( v_key < key_aux ) { ___tmp62 = current_node ;
   ___tmp62 . GetHas_Left ( ) ;  ___tmp63 = ___tmp62 .
   ____1234GetHas_Left4321____ ;  if ( ___tmp63 ) { parent_node = current_node
   ;  ___tmp64 = current_node ;  ___tmp64 . GetLeft ( ) ;  ___tmp65 = ___tmp64
   . ____1234GetLeft4321____ ;  current_node = ___tmp65 ; }  else cont = false
   ;  }  else if ( key_aux < v_key ) { ___tmp66 = current_node ;  ___tmp66 .
   GetHas_Right ( ) ;  ___tmp67 = ___tmp66 . ____1234GetHas_Right4321____ ;  if
   ( ___tmp67 ) { parent_node = current_node ;  ___tmp68 = current_node ;
   ___tmp68 . GetRight ( ) ;  ___tmp69 = ___tmp68 . ____1234GetRight4321____ ;
   current_node = ___tmp69 ; }  else cont = false ;  }  else { if ( is_root ) {
   ___tmp70 = current_node ;  ___tmp70 . GetHas_Right ( ) ;  ___tmp71 =
   ___tmp70 . ____1234GetHas_Right4321____ ;  ___tmp72 = current_node ;
   ___tmp72 . GetHas_Left ( ) ;  ___tmp73 = ___tmp72 .
   ____1234GetHas_Left4321____ ;  if ( ! ___tmp71 & ! ___tmp73  ) ntb = true ;
   else { ___tmp74 = this ;  ___tmp74 . Remove ( parent_node , current_node ) ;
   ___tmp75 = ___tmp74 . ____1234Remove4321____ ;  ntb = ___tmp75 ; }  }  else
   { ___tmp76 = this ;  ___tmp76 . Remove ( parent_node , current_node ) ;
   ___tmp77 = ___tmp76 . ____1234Remove4321____ ;  ntb = ___tmp77 ; }   found =
   true ;  cont = false ; }    is_root = false ; }   ____1234Delete4321____ =
   found ; }   public void Remove ( Tree  p_node , Tree  c_node   ) { boolean
   ntb ;  int  auxkey1 ;  int  auxkey2 ;  Tree  ___tmp78 ;  boolean  ___tmp79 ;
   Tree  ___tmp80 ;  boolean  ___tmp81 ;  Tree  ___tmp82 ;  boolean  ___tmp83 ;
   Tree  ___tmp84 ;  boolean  ___tmp85 ;  Tree  ___tmp86 ;  int  ___tmp87 ;
   Tree  ___tmp90 ;  int  ___tmp91 ;  Tree  ___tmp88 ;  Tree  ___tmp89 ;  Tree
   ___tmp92 ;  boolean  ___tmp93 ;  Tree  ___tmp94 ;  boolean  ___tmp95 ;  Tree
   ___tmp96 ;  boolean  ___tmp97 ;  Tree  ___tmp98 ;  boolean  ___tmp99 ;  Tree
   ___tmp100 ;  boolean  ___tmp101 ; ___tmp78 = c_node ;  ___tmp78 .
   GetHas_Left ( ) ;  ___tmp79 = ___tmp78 . ____1234GetHas_Left4321____ ;  if (
   ___tmp79 ) { ___tmp80 = this ;  ___tmp80 . RemoveLeft ( p_node , c_node ) ;
   ___tmp81 = ___tmp80 . ____1234RemoveLeft4321____ ;  ntb = ___tmp81 ; }  else
   { ___tmp82 = c_node ;  ___tmp82 . GetHas_Right ( ) ;  ___tmp83 = ___tmp82 .
   ____1234GetHas_Right4321____ ;  if ( ___tmp83 ) { ___tmp84 = this ;
   ___tmp84 . RemoveRight ( p_node , c_node ) ;  ___tmp85 = ___tmp84 .
   ____1234RemoveRight4321____ ;  ntb = ___tmp85 ; }  else { ___tmp86 = c_node
   ;  ___tmp86 . GetKey ( ) ;  ___tmp87 = ___tmp86 . ____1234GetKey4321____ ;
   auxkey1 = ___tmp87 ;  ___tmp88 = p_node ;  ___tmp88 . GetLeft ( ) ;
   ___tmp89 = ___tmp88 . ____1234GetLeft4321____ ;  ___tmp90 = ( ___tmp89 ) ;
   ___tmp90 . GetKey ( ) ;  ___tmp91 = ___tmp90 . ____1234GetKey4321____ ;
   auxkey2 = ___tmp91 ;  ___tmp92 = this ;  ___tmp92 . Compare ( auxkey1 ,
   auxkey2 ) ;  ___tmp93 = ___tmp92 . ____1234Compare4321____ ;  if ( ___tmp93
   ) { ___tmp94 = p_node ;  ___tmp94 . SetLeft ( my_null  ) ;  ___tmp95 =
   ___tmp94 . ____1234SetLeft4321____ ;  ntb = ___tmp95 ;  ___tmp96 = p_node ;
   ___tmp96 . SetHas_Left ( false  ) ;  ___tmp97 = ___tmp96 .
   ____1234SetHas_Left4321____ ;  ntb = ___tmp97 ; }  else { ___tmp98 = p_node
   ;  ___tmp98 . SetRight ( my_null  ) ;  ___tmp99 = ___tmp98 .
   ____1234SetRight4321____ ;  ntb = ___tmp99 ;  ___tmp100 = p_node ;
   ___tmp100 . SetHas_Right ( false  ) ;  ___tmp101 = ___tmp100 .
   ____1234SetHas_Right4321____ ;  ntb = ___tmp101 ; }  }  }
   ____1234Remove4321____ = true ; }   public void RemoveRight ( Tree  p_node ,
   Tree  c_node   ) { boolean  ntb ;  Tree  ___tmp102 ;  boolean  ___tmp103 ;
   Tree  ___tmp108 ;  boolean  ___tmp109 ;  Tree  ___tmp106 ;  int  ___tmp107 ;
   Tree  ___tmp104 ;  Tree  ___tmp105 ;  Tree  ___tmp110 ;  Tree  ___tmp111 ;
   Tree  ___tmp112 ;  boolean  ___tmp113 ;  Tree  ___tmp114 ;  boolean
   ___tmp115 ; ___tmp102 = c_node ;  ___tmp102 . GetHas_Right ( ) ;  ___tmp103
   = ___tmp102 . ____1234GetHas_Right4321____ ;  while ( ___tmp103 ) {
   ___tmp108 = c_node ;  ___tmp104 = c_node ;  ___tmp104 . GetRight ( ) ;
   ___tmp105 = ___tmp104 . ____1234GetRight4321____ ;  ___tmp106 = ( ___tmp105
   ) ;  ___tmp106 . GetKey ( ) ;  ___tmp107 = ___tmp106 .
   ____1234GetKey4321____ ;  ___tmp108 . SetKey ( ___tmp107  ) ;  ___tmp109 =
   ___tmp108 . ____1234SetKey4321____ ;  ntb = ___tmp109 ;  p_node = c_node ;
   ___tmp110 = c_node ;  ___tmp110 . GetRight ( ) ;  ___tmp111 = ___tmp110 .
   ____1234GetRight4321____ ;  c_node = ___tmp111 ; }   ___tmp112 = p_node ;
   ___tmp112 . SetRight ( my_null  ) ;  ___tmp113 = ___tmp112 .
   ____1234SetRight4321____ ;  ntb = ___tmp113 ;  ___tmp114 = p_node ;
   ___tmp114 . SetHas_Right ( false  ) ;  ___tmp115 = ___tmp114 .
   ____1234SetHas_Right4321____ ;  ntb = ___tmp115 ;
   ____1234RemoveRight4321____ = true ; }   public void RemoveLeft ( Tree
   p_node , Tree  c_node   ) { boolean  ntb ;  Tree  ___tmp116 ;  boolean
   ___tmp117 ;  Tree  ___tmp122 ;  boolean  ___tmp123 ;  Tree  ___tmp120 ;  int
   ___tmp121 ;  Tree  ___tmp118 ;  Tree  ___tmp119 ;  Tree  ___tmp124 ;  Tree
   ___tmp125 ;  Tree  ___tmp126 ;  boolean  ___tmp127 ;  Tree  ___tmp128 ;
   boolean  ___tmp129 ; ___tmp116 = c_node ;  ___tmp116 . GetHas_Left ( ) ;
   ___tmp117 = ___tmp116 . ____1234GetHas_Left4321____ ;  while ( ___tmp117 ) {
   ___tmp122 = c_node ;  ___tmp118 = c_node ;  ___tmp118 . GetLeft ( ) ;
   ___tmp119 = ___tmp118 . ____1234GetLeft4321____ ;  ___tmp120 = ( ___tmp119 )
   ;  ___tmp120 . GetKey ( ) ;  ___tmp121 = ___tmp120 . ____1234GetKey4321____
   ;  ___tmp122 . SetKey ( ___tmp121  ) ;  ___tmp123 = ___tmp122 .
   ____1234SetKey4321____ ;  ntb = ___tmp123 ;  p_node = c_node ;  ___tmp124 =
   c_node ;  ___tmp124 . GetLeft ( ) ;  ___tmp125 = ___tmp124 .
   ____1234GetLeft4321____ ;  c_node = ___tmp125 ; }   ___tmp126 = p_node ;
   ___tmp126 . SetLeft ( my_null  ) ;  ___tmp127 = ___tmp126 .
   ____1234SetLeft4321____ ;  ntb = ___tmp127 ;  ___tmp128 = p_node ;
   ___tmp128 . SetHas_Left ( false  ) ;  ___tmp129 = ___tmp128 .
   ____1234SetHas_Left4321____ ;  ntb = ___tmp129 ;  ____1234RemoveLeft4321____
   = true ; }   public void Search ( int  v_key  ) { Tree  current_node ;  int
   ifound ;  boolean  cont ;  int  key_aux ;  Tree  ___tmp130 ;  int  ___tmp131
   ;  Tree  ___tmp132 ;  boolean  ___tmp133 ;  Tree  ___tmp134 ;  Tree
   ___tmp135 ;  Tree  ___tmp136 ;  boolean  ___tmp137 ;  Tree  ___tmp138 ;
   Tree  ___tmp139 ; current_node = this ;  cont = true ;  ifound = 0 ;  while
   ( cont ) { ___tmp130 = current_node ;  ___tmp130 . GetKey ( ) ;  ___tmp131 =
   ___tmp130 . ____1234GetKey4321____ ;  key_aux = ___tmp131 ;  if ( v_key <
   key_aux ) { ___tmp132 = current_node ;  ___tmp132 . GetHas_Left ( ) ;
   ___tmp133 = ___tmp132 . ____1234GetHas_Left4321____ ;  if ( ___tmp133 ) {
   ___tmp134 = current_node ;  ___tmp134 . GetLeft ( ) ;  ___tmp135 = ___tmp134
   . ____1234GetLeft4321____ ;  current_node = ___tmp135 ; }  else cont = false
   ;  }  else if ( key_aux < v_key ) { ___tmp136 = current_node ;  ___tmp136 .
   GetHas_Right ( ) ;  ___tmp137 = ___tmp136 . ____1234GetHas_Right4321____ ;
   if ( ___tmp137 ) { ___tmp138 = current_node ;  ___tmp138 . GetRight ( ) ;
   ___tmp139 = ___tmp138 . ____1234GetRight4321____ ;  current_node = ___tmp139
   ; }  else cont = false ;  }  else { ifound = 1 ;  cont = false ; }   }
   ____1234Search4321____ = ifound ; }   public void Print (  ) { boolean  ntb
   ;  Tree  current_node ;  Tree  ___tmp140 ;  boolean  ___tmp141 ;
   current_node = this ;  ___tmp140 = this ;  ___tmp140 . RecPrint (
   current_node  ) ;  ___tmp141 = ___tmp140 . ____1234RecPrint4321____ ;  ntb =
   ___tmp141 ;  ____1234Print4321____ = true ; }   public void RecPrint ( Tree
   node  ) { boolean  ntb ;  Tree  ___tmp142 ;  boolean  ___tmp143 ;  Tree
   ___tmp146 ;  boolean  ___tmp147 ;  Tree  ___tmp144 ;  Tree  ___tmp145 ;
   Tree  ___tmp148 ;  int  ___tmp149 ;  Tree  ___tmp150 ;  boolean  ___tmp151 ;
   Tree  ___tmp154 ;  boolean  ___tmp155 ;  Tree  ___tmp152 ;  Tree  ___tmp153
   ; ___tmp142 = node ;  ___tmp142 . GetHas_Left ( ) ;  ___tmp143 = ___tmp142 .
   ____1234GetHas_Left4321____ ;  if ( ___tmp143 ) { ___tmp146 = this ;
   ___tmp144 = node ;  ___tmp144 . GetLeft ( ) ;  ___tmp145 = ___tmp144 .
   ____1234GetLeft4321____ ;  ___tmp146 . RecPrint ( ___tmp145  ) ;  ___tmp147
   = ___tmp146 . ____1234RecPrint4321____ ;  ntb = ___tmp147 ; }  else ntb =
   true ;   ___tmp148 = node ;  ___tmp148 . GetKey ( ) ;  ___tmp149 = ___tmp148
   . ____1234GetKey4321____ ;  System.out.println ( ___tmp149 ) ;  ___tmp150 =
   node ;  ___tmp150 . GetHas_Right ( ) ;  ___tmp151 = ___tmp150 .
   ____1234GetHas_Right4321____ ;  if ( ___tmp151 ) { ___tmp154 = this ;
   ___tmp152 = node ;  ___tmp152 . GetRight ( ) ;  ___tmp153 = ___tmp152 .
   ____1234GetRight4321____ ;  ___tmp154 . RecPrint ( ___tmp153  ) ;  ___tmp155
   = ___tmp154 . ____1234RecPrint4321____ ;  ntb = ___tmp155 ; }  else ntb =
   true ;   ____1234RecPrint4321____ = true ; }   public void accept ( Visitor
   v  ) { int  nti ;  Visitor  ___tmp156 ;  int  ___tmp157 ; System.out.println
   ( 333 ) ;  ___tmp156 = v ;  ___tmp156 . visit ( this  ) ;  ___tmp157 =
   ___tmp156 . ____1234visit4321____ ;  nti = ___tmp157 ;
   ____1234accept4321____ = 0 ; } }
class Visitor { Tree  l ;   Tree  r ;   int  ____1234visit4321____ ; public
   void visit ( Tree  n  ) { int  nti ;  Tree  ___tmp158 ;  boolean  ___tmp159
   ;  Tree  ___tmp160 ;  Tree  ___tmp161 ;  Tree  ___tmp162 ;  int  ___tmp163 ;
   Tree  ___tmp164 ;  boolean  ___tmp165 ;  Tree  ___tmp166 ;  Tree  ___tmp167
   ;  Tree  ___tmp168 ;  int  ___tmp169 ; ___tmp158 = n ;  ___tmp158 .
   GetHas_Right ( ) ;  ___tmp159 = ___tmp158 . ____1234GetHas_Right4321____ ;
   if ( ___tmp159 ) { ___tmp160 = n ;  ___tmp160 . GetRight ( ) ;  ___tmp161 =
   ___tmp160 . ____1234GetRight4321____ ;  r = ___tmp161 ;  ___tmp162 = r ;
   ___tmp162 . accept ( this  ) ;  ___tmp163 = ___tmp162 .
   ____1234accept4321____ ;  nti = ___tmp163 ; }  else nti = 0 ;   ___tmp164 =
   n ;  ___tmp164 . GetHas_Left ( ) ;  ___tmp165 = ___tmp164 .
   ____1234GetHas_Left4321____ ;  if ( ___tmp165 ) { ___tmp166 = n ;  ___tmp166
   . GetLeft ( ) ;  ___tmp167 = ___tmp166 . ____1234GetLeft4321____ ;  l =
   ___tmp167 ;  ___tmp168 = l ;  ___tmp168 . accept ( this  ) ;  ___tmp169 =
   ___tmp168 . ____1234accept4321____ ;  nti = ___tmp169 ; }  else nti = 0 ;
   ____1234visit4321____ = 0 ; } }
class MyVisitor extends Visitor { public void visit ( Tree  n  ) { int  nti ;
   Tree  ___tmp170 ;  boolean  ___tmp171 ;  Tree  ___tmp172 ;  Tree  ___tmp173
   ;  Tree  ___tmp174 ;  int  ___tmp175 ;  Tree  ___tmp176 ;  int  ___tmp177 ;
   Tree  ___tmp178 ;  boolean  ___tmp179 ;  Tree  ___tmp180 ;  Tree  ___tmp181
   ;  Tree  ___tmp182 ;  int  ___tmp183 ; ___tmp170 = n ;  ___tmp170 .
   GetHas_Right ( ) ;  ___tmp171 = ___tmp170 . ____1234GetHas_Right4321____ ;
   if ( ___tmp171 ) { ___tmp172 = n ;  ___tmp172 . GetRight ( ) ;  ___tmp173 =
   ___tmp172 . ____1234GetRight4321____ ;  r = ___tmp173 ;  ___tmp174 = r ;
   ___tmp174 . accept ( this  ) ;  ___tmp175 = ___tmp174 .
   ____1234accept4321____ ;  nti = ___tmp175 ; }  else nti = 0 ;   ___tmp176 =
   n ;  ___tmp176 . GetKey ( ) ;  ___tmp177 = ___tmp176 .
   ____1234GetKey4321____ ;  System.out.println ( ___tmp177 ) ;  ___tmp178 = n
   ;  ___tmp178 . GetHas_Left ( ) ;  ___tmp179 = ___tmp178 .
   ____1234GetHas_Left4321____ ;  if ( ___tmp179 ) { ___tmp180 = n ;  ___tmp180
   . GetLeft ( ) ;  ___tmp181 = ___tmp180 . ____1234GetLeft4321____ ;  l =
   ___tmp181 ;  ___tmp182 = l ;  ___tmp182 . accept ( this  ) ;  ___tmp183 =
   ___tmp182 . ____1234accept4321____ ;  nti = ___tmp183 ; }  else nti = 0 ;
   ____1234visit4321____ = 0 ; } }
class ____NewMainClass____ { public void ____Main____ ( int  ____arg_length____
   ) { TV  ___tmp0 ;  int  ___tmp1 ; ___tmp0 = new TV ( ) ;  ___tmp0 . Start (
   ) ;  ___tmp1 = ___tmp0 . ____1234Start4321____ ;  System.out.println (
   ___tmp1 ) ; } } 