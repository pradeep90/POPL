 class LinkedList {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ; } }  class Element { int
   Age ;   int  Salary ;   boolean  Married ;   boolean  ____1234Init4321____ ;
   int  ____1234GetAge4321____ ;   int  ____1234GetSalary4321____ ;   boolean
   ____1234GetMarried4321____ ;   boolean  ____1234Equal4321____ ;   boolean
   ____1234Compare4321____ ; public void Init ( int  ___VAR0 , int  ___VAR1   ,
   boolean  ___VAR2   ) { int  ___VAR3 ;  boolean  ___VAR4 ;  int  ___VAR5 ;
   ___VAR5 = ___VAR1 ;  ___VAR4 = ___VAR2 ;  ___VAR3 = ___VAR0 ;  Age = ___VAR3
   ;  Salary = ___VAR5 ;  Married = ___VAR4 ;  ____1234Init4321____ = true ; }
   public void GetAge ( ) { ____1234GetAge4321____ = Age ; }   public void
   GetSalary ( ) { ____1234GetSalary4321____ = Salary ; }   public void
   GetMarried ( ) { ____1234GetMarried4321____ = Married ; }   public void
   Equal ( Element  ___VAR6  ) { boolean  ___VAR7 ;  int  ___VAR8 ;  int
   ___VAR9 ;  int  ___VAR10 ;  Element  ___VAR11 ;  int  ___VAR12 ;  int
   ___VAR13 ;  boolean  ___VAR14 ;  boolean  ___VAR15 ;  Element  ___VAR16 ;
   boolean  ___VAR17 ;  Element  ___VAR18 ;  boolean  ___VAR19 ;  boolean
   ___VAR113 ;  int  ___VAR114 ;  int  ___VAR115 ;  int  ___VAR116 ;  boolean
   ___VAR117 ;  int  ___VAR111 ;  int  ___VAR112 ;  boolean  ___VAR120 ;  int
   ___VAR121 ;  int  ___VAR122 ;  int  ___VAR123 ;  boolean  ___VAR124 ;  int
   ___VAR118 ;  int  ___VAR119 ; ___VAR11 = ___VAR6 ;  ___VAR7 = true ;
   ___VAR11 = ___VAR11 ;  ___VAR11 . GetAge ( ) ;  ___VAR12 = ___VAR11 .
   ____1234GetAge4321____ ;  ___VAR8 = ___VAR12 ;  ___VAR18 = this ;  {
   ___VAR111 = ___VAR8 ;  ___VAR112 = Age ;  ___VAR116 = ___VAR111 ;  ___VAR115
   = ___VAR112 ;  ___VAR113 = false ;  ___VAR114 = ___VAR115 + 1 ;  if (
   ___VAR116 < ___VAR115 ) { ___VAR113 = false ; }  else { ___VAR117 =
   ___VAR116 < ___VAR114 ;  if ( ! ___VAR117 ) { ___VAR113 = false ; }  else {
   ___VAR113 = true ; }  }   ___VAR18 . ____1234Compare4321____ = ___VAR113 ; }
   ___VAR19 = ___VAR18 . ____1234Compare4321____ ;  if ( ! ___VAR19 ) { ___VAR7
   = false ; }  else { { ___VAR11 = ___VAR11 ;  ___VAR11 . GetSalary ( ) ;
   ___VAR13 = ___VAR11 . ____1234GetSalary4321____ ;  ___VAR9 = ___VAR13 ;
   ___VAR16 = this ;  { ___VAR118 = ___VAR9 ;  ___VAR119 = Salary ;  ___VAR123
   = ___VAR118 ;  ___VAR122 = ___VAR119 ;  ___VAR120 = false ;  ___VAR121 =
   ___VAR122 + 1 ;  if ( ___VAR123 < ___VAR122 ) { ___VAR120 = false ; }  else
   { ___VAR124 = ___VAR123 < ___VAR121 ;  if ( ! ___VAR124 ) { ___VAR120 =
   false ; }  else { ___VAR120 = true ; }  }   ___VAR16 .
   ____1234Compare4321____ = ___VAR120 ; }  ___VAR17 = ___VAR16 .
   ____1234Compare4321____ ;  if ( ! ___VAR17 ) { ___VAR7 = false ; }  else {
   if ( Married ) { ___VAR11 = ___VAR11 ;  ___VAR11 . GetMarried ( ) ;
   ___VAR14 = ___VAR11 . ____1234GetMarried4321____ ;  if ( ! ___VAR14 ) {
   ___VAR7 = false ; }  else { ___VAR10 = 0 ; }  }  else { ___VAR11 = ___VAR11
   ;  ___VAR11 . GetMarried ( ) ;  ___VAR15 = ___VAR11 .
   ____1234GetMarried4321____ ;  if ( ___VAR15 ) { ___VAR7 = false ; }  else {
   ___VAR10 = 0 ; }  }  }  } }   ____1234Equal4321____ = ___VAR7 ; }   public
   void Compare ( int  ___VAR20 , int  ___VAR21   ) { boolean  ___VAR22 ;  int
   ___VAR23 ;  int  ___VAR24 ;  int  ___VAR25 ;  boolean  ___VAR26 ; ___VAR25 =
   ___VAR20 ;  ___VAR24 = ___VAR21 ;  ___VAR22 = false ;  ___VAR23 = ___VAR24 +
   1 ;  if ( ___VAR25 < ___VAR24 ) { ___VAR22 = false ; }  else { ___VAR26 =
   ___VAR25 < ___VAR23 ;  if ( ! ___VAR26 ) { ___VAR22 = false ; }  else {
   ___VAR22 = true ; }  }   ____1234Compare4321____ = ___VAR22 ; } }
class List { Element  elem ;   List  next ;   boolean  end ;   boolean
   ____1234Init4321____ ;   boolean  ____1234InitNew4321____ ;   List
   ____1234Insert4321____ ;   boolean  ____1234SetNext4321____ ;   List
   ____1234Delete4321____ ;   int  ____1234Search4321____ ;   boolean
   ____1234GetEnd4321____ ;   Element  ____1234GetElem4321____ ;   List
   ____1234GetNext4321____ ;   boolean  ____1234Print4321____ ; public void
   Init ( ) { end = true ;  ____1234Init4321____ = true ; }   public void
   InitNew ( Element  ___VAR27 , List  ___VAR28   , boolean  ___VAR29   ) {
   boolean  ___VAR30 ;  List  ___VAR31 ;  Element  ___VAR32 ; ___VAR32 =
   ___VAR27 ;  ___VAR31 = ___VAR28 ;  ___VAR30 = ___VAR29 ;  end = ___VAR30 ;
   elem = ___VAR32 ;  next = ___VAR31 ;  ____1234InitNew4321____ = true ; }
   public void Insert ( Element  ___VAR33  ) { boolean  ___VAR34 ;  List
   ___VAR35 ;  List  ___VAR36 ;  Element  ___VAR37 ;  boolean  ___VAR38 ;
   boolean  ___VAR128 ;  List  ___VAR129 ;  Element  ___VAR130 ;  Element
   ___VAR125 ;  List  ___VAR126 ;  boolean  ___VAR127 ; ___VAR37 = ___VAR33 ;
   ___VAR35 = this ;  ___VAR36 = new List ( ) ;  ___VAR36 = ___VAR36 ;  {
   ___VAR125 = ___VAR37 ;  ___VAR126 = ___VAR35 ;  ___VAR127 = false ;
   ___VAR130 = ___VAR125 ;  ___VAR129 = ___VAR126 ;  ___VAR128 = ___VAR127 ;
   ___VAR36 . end = ___VAR128 ;  ___VAR36 . elem = ___VAR130 ;  ___VAR36 . next
   = ___VAR129 ;  ___VAR36 . ____1234InitNew4321____ = true ; }  ___VAR38 =
   ___VAR36 . ____1234InitNew4321____ ;  ___VAR34 = ___VAR38 ;
   ____1234Insert4321____ = ___VAR36 ; }   public void SetNext ( List  ___VAR39
   ) { List  ___VAR40 ; ___VAR40 = ___VAR39 ;  next = ___VAR40 ;
   ____1234SetNext4321____ = true ; }   public void Delete ( Element  ___VAR41
   ) { List  ___VAR42 ;  boolean  ___VAR43 ;  boolean  ___VAR44 ;  List
   ___VAR45 ;  List  ___VAR46 ;  boolean  ___VAR47 ;  Element  ___VAR48 ;  int
   ___VAR49 ;  int  ___VAR50 ;  Element  ___VAR51 ;  boolean  ___VAR52 ;
   boolean  ___VAR53 ;  List  ___VAR54 ;  boolean  ___VAR55 ;  List  ___VAR56 ;
   boolean  ___VAR57 ;  List  ___VAR58 ;  boolean  ___VAR59 ;  Element
   ___VAR60 ;  boolean  ___VAR132 ;  int  ___VAR133 ;  int  ___VAR134 ;  int
   ___VAR135 ;  Element  ___VAR136 ;  int  ___VAR137 ;  int  ___VAR138 ;
   boolean  ___VAR139 ;  boolean  ___VAR140 ;  Element  ___VAR141 ;  boolean
   ___VAR142 ;  Element  ___VAR143 ;  boolean  ___VAR144 ;  Element  ___VAR131
   ;  List  ___VAR146 ;  List  ___VAR145 ; ___VAR51 = ___VAR41 ;  ___VAR42 =
   this ;  ___VAR43 = false ;  ___VAR49 = 0 - 1 ;  ___VAR45 = this ;  ___VAR46
   = this ;  ___VAR47 = end ;  ___VAR48 = elem ;  ___VAR52 = ! ___VAR47 ;
   ___VAR53 = ! ___VAR43 ;  while ( ___VAR52 & ___VAR53  ) { { ___VAR51 =
   ___VAR51 ;  { ___VAR131 = ___VAR48 ;  ___VAR136 = ___VAR131 ;  ___VAR132 =
   true ;  ___VAR136 = ___VAR136 ;  ___VAR136 . GetAge ( ) ;  ___VAR137 =
   ___VAR136 . ____1234GetAge4321____ ;  ___VAR133 = ___VAR137 ;  ___VAR143 =
   ___VAR51 ;  ___VAR143 . Compare ( ___VAR133 , ___VAR51 . Age ) ;  ___VAR144
   = ___VAR143 . ____1234Compare4321____ ;  if ( ! ___VAR144 ) { ___VAR132 =
   false ; }  else { { ___VAR136 = ___VAR136 ;  ___VAR136 . GetSalary ( ) ;
   ___VAR138 = ___VAR136 . ____1234GetSalary4321____ ;  ___VAR134 = ___VAR138 ;
   ___VAR141 = ___VAR51 ;  ___VAR141 . Compare ( ___VAR134 , ___VAR51 . Salary
   ) ;  ___VAR142 = ___VAR141 . ____1234Compare4321____ ;  if ( ! ___VAR142 ) {
   ___VAR132 = false ; }  else { if ( ___VAR51 . Married ) { ___VAR136 =
   ___VAR136 ;  ___VAR136 . GetMarried ( ) ;  ___VAR139 = ___VAR136 .
   ____1234GetMarried4321____ ;  if ( ! ___VAR139 ) { ___VAR132 = false ; }
   else { ___VAR135 = 0 ; }  }  else { ___VAR136 = ___VAR136 ;  ___VAR136 .
   GetMarried ( ) ;  ___VAR140 = ___VAR136 . ____1234GetMarried4321____ ;  if (
   ___VAR140 ) { ___VAR132 = false ; }  else { ___VAR135 = 0 ; }  }  }  } }
   ___VAR51 . ____1234Equal4321____ = ___VAR132 ; }  ___VAR57 = ___VAR51 .
   ____1234Equal4321____ ;  if ( ___VAR57 ) { { ___VAR43 = true ;  if (
   ___VAR49 < 0 ) { { ___VAR45 = ___VAR45 ;  { ___VAR45 .
   ____1234GetNext4321____ = ___VAR45 . next ; }  ___VAR54 = ___VAR45 .
   ____1234GetNext4321____ ;  ___VAR42 = ___VAR54 ; } }  else { {
   System.out.println ( 0 - 555 ) ;  ___VAR46 = ___VAR46 ;  ___VAR45 = ___VAR45
   ;  { ___VAR45 . ____1234GetNext4321____ = ___VAR45 . next ; }  ___VAR56 =
   ___VAR45 . ____1234GetNext4321____ ;  { ___VAR145 = ___VAR56 ;  ___VAR146 =
   ___VAR145 ;  ___VAR46 . next = ___VAR146 ;  ___VAR46 .
   ____1234SetNext4321____ = true ; }  ___VAR55 = ___VAR46 .
   ____1234SetNext4321____ ;  ___VAR44 = ___VAR55 ;  System.out.println ( 0 -
   555 ) ; } }  } }  else { ___VAR50 = 0 ; }   if ( ! ___VAR43 ) { { ___VAR46 =
   ___VAR45 ;  ___VAR45 = ___VAR45 ;  { ___VAR45 . ____1234GetNext4321____ =
   ___VAR45 . next ; }  ___VAR58 = ___VAR45 . ____1234GetNext4321____ ;
   ___VAR45 = ___VAR58 ;  ___VAR45 = ___VAR45 ;  { ___VAR45 .
   ____1234GetEnd4321____ = ___VAR45 . end ; }  ___VAR59 = ___VAR45 .
   ____1234GetEnd4321____ ;  ___VAR47 = ___VAR59 ;  ___VAR45 = ___VAR45 ;  {
   ___VAR45 . ____1234GetElem4321____ = ___VAR45 . elem ; }  ___VAR60 =
   ___VAR45 . ____1234GetElem4321____ ;  ___VAR48 = ___VAR60 ;  ___VAR49 = 1 ;
   } }  else { ___VAR50 = 0 ; }  }  ___VAR52 = ! ___VAR47 ;  ___VAR53 = !
   ___VAR43 ; }   ____1234Delete4321____ = ___VAR42 ; }   public void Search (
   Element  ___VAR61  ) { int  ___VAR62 ;  List  ___VAR63 ;  Element  ___VAR64
   ;  boolean  ___VAR65 ;  int  ___VAR66 ;  Element  ___VAR67 ;  boolean
   ___VAR68 ;  List  ___VAR69 ;  boolean  ___VAR70 ;  Element  ___VAR71 ;
   boolean  ___VAR148 ;  int  ___VAR149 ;  int  ___VAR150 ;  int  ___VAR151 ;
   Element  ___VAR152 ;  int  ___VAR153 ;  int  ___VAR154 ;  boolean  ___VAR155
   ;  boolean  ___VAR156 ;  Element  ___VAR157 ;  boolean  ___VAR158 ;  Element
   ___VAR159 ;  boolean  ___VAR160 ;  Element  ___VAR147 ; ___VAR67 = ___VAR61
   ;  ___VAR62 = 0 ;  ___VAR63 = this ;  ___VAR65 = end ;  ___VAR64 = elem ;
   while ( ! ___VAR65 ) { { ___VAR67 = ___VAR67 ;  { ___VAR147 = ___VAR64 ;
   ___VAR152 = ___VAR147 ;  ___VAR148 = true ;  ___VAR152 = ___VAR152 ;
   ___VAR152 . GetAge ( ) ;  ___VAR153 = ___VAR152 . ____1234GetAge4321____ ;
   ___VAR149 = ___VAR153 ;  ___VAR159 = ___VAR67 ;  ___VAR159 . Compare (
   ___VAR149 , ___VAR67 . Age ) ;  ___VAR160 = ___VAR159 .
   ____1234Compare4321____ ;  if ( ! ___VAR160 ) { ___VAR148 = false ; }  else
   { { ___VAR152 = ___VAR152 ;  ___VAR152 . GetSalary ( ) ;  ___VAR154 =
   ___VAR152 . ____1234GetSalary4321____ ;  ___VAR150 = ___VAR154 ;  ___VAR157
   = ___VAR67 ;  ___VAR157 . Compare ( ___VAR150 , ___VAR67 . Salary ) ;
   ___VAR158 = ___VAR157 . ____1234Compare4321____ ;  if ( ! ___VAR158 ) {
   ___VAR148 = false ; }  else { if ( ___VAR67 . Married ) { ___VAR152 =
   ___VAR152 ;  ___VAR152 . GetMarried ( ) ;  ___VAR155 = ___VAR152 .
   ____1234GetMarried4321____ ;  if ( ! ___VAR155 ) { ___VAR148 = false ; }
   else { ___VAR151 = 0 ; }  }  else { ___VAR152 = ___VAR152 ;  ___VAR152 .
   GetMarried ( ) ;  ___VAR156 = ___VAR152 . ____1234GetMarried4321____ ;  if (
   ___VAR156 ) { ___VAR148 = false ; }  else { ___VAR151 = 0 ; }  }  }  } }
   ___VAR67 . ____1234Equal4321____ = ___VAR148 ; }  ___VAR68 = ___VAR67 .
   ____1234Equal4321____ ;  if ( ___VAR68 ) { { ___VAR62 = 1 ; } }  else {
   ___VAR66 = 0 ; }   ___VAR63 = ___VAR63 ;  { ___VAR63 .
   ____1234GetNext4321____ = ___VAR63 . next ; }  ___VAR69 = ___VAR63 .
   ____1234GetNext4321____ ;  ___VAR63 = ___VAR69 ;  ___VAR63 = ___VAR63 ;  {
   ___VAR63 . ____1234GetEnd4321____ = ___VAR63 . end ; }  ___VAR70 = ___VAR63
   . ____1234GetEnd4321____ ;  ___VAR65 = ___VAR70 ;  ___VAR63 = ___VAR63 ;  {
   ___VAR63 . ____1234GetElem4321____ = ___VAR63 . elem ; }  ___VAR71 =
   ___VAR63 . ____1234GetElem4321____ ;  ___VAR64 = ___VAR71 ; } }
   ____1234Search4321____ = ___VAR62 ; }   public void GetEnd ( ) {
   ____1234GetEnd4321____ = end ; }   public void GetElem ( ) {
   ____1234GetElem4321____ = elem ; }   public void GetNext ( ) {
   ____1234GetNext4321____ = next ; }   public void Print ( ) { List  ___VAR72
   ;  boolean  ___VAR73 ;  Element  ___VAR74 ;  int  ___VAR75 ;  List  ___VAR76
   ;  boolean  ___VAR77 ;  Element  ___VAR78 ; ___VAR72 = this ;  ___VAR73 =
   end ;  ___VAR74 = elem ;  while ( ! ___VAR73 ) { { ___VAR74 = ___VAR74 ;
   ___VAR74 . GetAge ( ) ;  ___VAR75 = ___VAR74 . ____1234GetAge4321____ ;
   System.out.println ( ___VAR75 ) ;  ___VAR72 = ___VAR72 ;  { ___VAR72 .
   ____1234GetNext4321____ = ___VAR72 . next ; }  ___VAR76 = ___VAR72 .
   ____1234GetNext4321____ ;  ___VAR72 = ___VAR76 ;  ___VAR72 = ___VAR72 ;  {
   ___VAR72 . ____1234GetEnd4321____ = ___VAR72 . end ; }  ___VAR77 = ___VAR72
   . ____1234GetEnd4321____ ;  ___VAR73 = ___VAR77 ;  ___VAR72 = ___VAR72 ;  {
   ___VAR72 . ____1234GetElem4321____ = ___VAR72 . elem ; }  ___VAR78 =
   ___VAR72 . ____1234GetElem4321____ ;  ___VAR74 = ___VAR78 ; } }
   ____1234Print4321____ = true ; } }
class LL { int  ____1234Start4321____ ; public void Start ( ) { List  ___VAR79
   ;  List  ___VAR80 ;  boolean  ___VAR81 ;  Element  ___VAR82 ;  Element
   ___VAR83 ;  Element  ___VAR84 ;  boolean  ___VAR85 ;  boolean  ___VAR86 ;
   boolean  ___VAR87 ;  boolean  ___VAR88 ;  List  ___VAR89 ;  boolean
   ___VAR90 ;  boolean  ___VAR91 ;  List  ___VAR92 ;  boolean  ___VAR93 ;
   boolean  ___VAR94 ;  List  ___VAR95 ;  boolean  ___VAR96 ;  boolean
   ___VAR97 ;  int  ___VAR98 ;  int  ___VAR99 ;  boolean  ___VAR100 ;  List
   ___VAR101 ;  boolean  ___VAR102 ;  List  ___VAR103 ;  boolean  ___VAR104 ;
   List  ___VAR105 ;  boolean  ___VAR106 ;  List  ___VAR161 ;  boolean
   ___VAR162 ;  Element  ___VAR163 ;  int  ___VAR164 ;  List  ___VAR165 ;
   boolean  ___VAR166 ;  Element  ___VAR167 ;  int  ___VAR171 ;  boolean
   ___VAR172 ;  int  ___VAR173 ;  int  ___VAR168 ;  int  ___VAR169 ;  boolean
   ___VAR170 ;  boolean  ___VAR175 ;  List  ___VAR176 ;  List  ___VAR177 ;
   Element  ___VAR178 ;  boolean  ___VAR179 ;  Element  ___VAR174 ;  List
   ___VAR180 ;  boolean  ___VAR181 ;  Element  ___VAR182 ;  int  ___VAR183 ;
   List  ___VAR184 ;  boolean  ___VAR185 ;  Element  ___VAR186 ;  int
   ___VAR190 ;  boolean  ___VAR191 ;  int  ___VAR192 ;  int  ___VAR187 ;  int
   ___VAR188 ;  boolean  ___VAR189 ;  boolean  ___VAR194 ;  List  ___VAR195 ;
   List  ___VAR196 ;  Element  ___VAR197 ;  boolean  ___VAR198 ;  Element
   ___VAR193 ;  List  ___VAR199 ;  boolean  ___VAR200 ;  Element  ___VAR201 ;
   int  ___VAR202 ;  List  ___VAR203 ;  boolean  ___VAR204 ;  Element
   ___VAR205 ;  int  ___VAR209 ;  boolean  ___VAR210 ;  int  ___VAR211 ;  int
   ___VAR206 ;  int  ___VAR207 ;  boolean  ___VAR208 ;  boolean  ___VAR213 ;
   List  ___VAR214 ;  List  ___VAR215 ;  Element  ___VAR216 ;  boolean
   ___VAR217 ;  Element  ___VAR212 ;  List  ___VAR218 ;  boolean  ___VAR219 ;
   Element  ___VAR220 ;  int  ___VAR221 ;  List  ___VAR222 ;  boolean
   ___VAR223 ;  Element  ___VAR224 ;  int  ___VAR228 ;  boolean  ___VAR229 ;
   int  ___VAR230 ;  int  ___VAR225 ;  int  ___VAR226 ;  boolean  ___VAR227 ;
   int  ___VAR232 ;  List  ___VAR233 ;  Element  ___VAR234 ;  boolean
   ___VAR235 ;  int  ___VAR236 ;  Element  ___VAR237 ;  boolean  ___VAR238 ;
   List  ___VAR239 ;  boolean  ___VAR240 ;  Element  ___VAR241 ;  Element
   ___VAR231 ;  int  ___VAR243 ;  List  ___VAR244 ;  Element  ___VAR245 ;
   boolean  ___VAR246 ;  int  ___VAR247 ;  Element  ___VAR248 ;  boolean
   ___VAR249 ;  List  ___VAR250 ;  boolean  ___VAR251 ;  Element  ___VAR252 ;
   Element  ___VAR242 ;  int  ___VAR256 ;  boolean  ___VAR257 ;  int  ___VAR258
   ;  int  ___VAR253 ;  int  ___VAR254 ;  boolean  ___VAR255 ;  boolean
   ___VAR260 ;  List  ___VAR261 ;  List  ___VAR262 ;  Element  ___VAR263 ;
   boolean  ___VAR264 ;  Element  ___VAR259 ;  List  ___VAR265 ;  boolean
   ___VAR266 ;  Element  ___VAR267 ;  int  ___VAR268 ;  List  ___VAR269 ;
   boolean  ___VAR270 ;  Element  ___VAR271 ;  List  ___VAR273 ;  boolean
   ___VAR274 ;  boolean  ___VAR275 ;  List  ___VAR276 ;  List  ___VAR277 ;
   boolean  ___VAR278 ;  Element  ___VAR279 ;  int  ___VAR280 ;  int  ___VAR281
   ;  Element  ___VAR282 ;  boolean  ___VAR283 ;  boolean  ___VAR284 ;  List
   ___VAR285 ;  boolean  ___VAR286 ;  List  ___VAR287 ;  boolean  ___VAR288 ;
   List  ___VAR289 ;  boolean  ___VAR290 ;  Element  ___VAR291 ;  Element
   ___VAR272 ;  List  ___VAR292 ;  boolean  ___VAR293 ;  Element  ___VAR294 ;
   int  ___VAR295 ;  List  ___VAR296 ;  boolean  ___VAR297 ;  Element
   ___VAR298 ;  List  ___VAR300 ;  boolean  ___VAR301 ;  boolean  ___VAR302 ;
   List  ___VAR303 ;  List  ___VAR304 ;  boolean  ___VAR305 ;  Element
   ___VAR306 ;  int  ___VAR307 ;  int  ___VAR308 ;  Element  ___VAR309 ;
   boolean  ___VAR310 ;  boolean  ___VAR311 ;  List  ___VAR312 ;  boolean
   ___VAR313 ;  List  ___VAR314 ;  boolean  ___VAR315 ;  List  ___VAR316 ;
   boolean  ___VAR317 ;  Element  ___VAR318 ;  Element  ___VAR299 ;  List
   ___VAR319 ;  boolean  ___VAR320 ;  Element  ___VAR321 ;  int  ___VAR322 ;
   List  ___VAR323 ;  boolean  ___VAR324 ;  Element  ___VAR325 ; ___VAR80 = new
   List ( ) ;  ___VAR80 = ___VAR80 ;  { ___VAR80 . end = true ;  ___VAR80 .
   ____1234Init4321____ = true ; }  ___VAR85 = ___VAR80 . ____1234Init4321____
   ;  ___VAR81 = ___VAR85 ;  ___VAR79 = ___VAR80 ;  ___VAR79 = ___VAR79 ;  {
   ___VAR79 . end = true ;  ___VAR79 . ____1234Init4321____ = true ; }
   ___VAR86 = ___VAR79 . ____1234Init4321____ ;  ___VAR81 = ___VAR86 ;
   ___VAR79 = ___VAR79 ;  { ___VAR161 = ___VAR79 ;  ___VAR162 = ___VAR79 . end
   ;  ___VAR163 = ___VAR79 . elem ;  while ( ! ___VAR162 ) { { ___VAR163 =
   ___VAR163 ;  ___VAR163 . GetAge ( ) ;  ___VAR164 = ___VAR163 .
   ____1234GetAge4321____ ;  System.out.println ( ___VAR164 ) ;  ___VAR161 =
   ___VAR161 ;  ___VAR161 . GetNext ( ) ;  ___VAR165 = ___VAR161 .
   ____1234GetNext4321____ ;  ___VAR161 = ___VAR165 ;  ___VAR161 = ___VAR161 ;
   ___VAR161 . GetEnd ( ) ;  ___VAR166 = ___VAR161 . ____1234GetEnd4321____ ;
   ___VAR162 = ___VAR166 ;  ___VAR161 = ___VAR161 ;  ___VAR161 . GetElem ( ) ;
   ___VAR167 = ___VAR161 . ____1234GetElem4321____ ;  ___VAR163 = ___VAR167 ; }
   }   ___VAR79 . ____1234Print4321____ = true ; }  ___VAR87 = ___VAR79 .
   ____1234Print4321____ ;  ___VAR81 = ___VAR87 ;  ___VAR82 = new Element ( ) ;
   ___VAR82 = ___VAR82 ;  { ___VAR168 = 25 ;  ___VAR169 = 37000 ;  ___VAR170 =
   false ;  ___VAR173 = ___VAR169 ;  ___VAR172 = ___VAR170 ;  ___VAR171 =
   ___VAR168 ;  ___VAR82 . Age = ___VAR171 ;  ___VAR82 . Salary = ___VAR173 ;
   ___VAR82 . Married = ___VAR172 ;  ___VAR82 . ____1234Init4321____ = true ; }
   ___VAR88 = ___VAR82 . ____1234Init4321____ ;  ___VAR81 = ___VAR88 ;
   ___VAR79 = ___VAR79 ;  { ___VAR174 = ___VAR82 ;  ___VAR178 = ___VAR174 ;
   ___VAR176 = ___VAR79 ;  ___VAR177 = new List ( ) ;  ___VAR177 = ___VAR177 ;
   ___VAR177 . InitNew ( ___VAR178 , ___VAR176 , false ) ;  ___VAR179 =
   ___VAR177 . ____1234InitNew4321____ ;  ___VAR175 = ___VAR179 ;  ___VAR79 .
   ____1234Insert4321____ = ___VAR177 ; }  ___VAR89 = ___VAR79 .
   ____1234Insert4321____ ;  ___VAR79 = ___VAR89 ;  ___VAR79 = ___VAR79 ;  {
   ___VAR180 = ___VAR79 ;  ___VAR181 = ___VAR79 . end ;  ___VAR182 = ___VAR79 .
   elem ;  while ( ! ___VAR181 ) { { ___VAR182 = ___VAR182 ;  ___VAR182 .
   GetAge ( ) ;  ___VAR183 = ___VAR182 . ____1234GetAge4321____ ;
   System.out.println ( ___VAR183 ) ;  ___VAR180 = ___VAR180 ;  ___VAR180 .
   GetNext ( ) ;  ___VAR184 = ___VAR180 . ____1234GetNext4321____ ;  ___VAR180
   = ___VAR184 ;  ___VAR180 = ___VAR180 ;  ___VAR180 . GetEnd ( ) ;  ___VAR185
   = ___VAR180 . ____1234GetEnd4321____ ;  ___VAR181 = ___VAR185 ;  ___VAR180 =
   ___VAR180 ;  ___VAR180 . GetElem ( ) ;  ___VAR186 = ___VAR180 .
   ____1234GetElem4321____ ;  ___VAR182 = ___VAR186 ; } }   ___VAR79 .
   ____1234Print4321____ = true ; }  ___VAR90 = ___VAR79 .
   ____1234Print4321____ ;  ___VAR81 = ___VAR90 ;  System.out.println (
   10000000 ) ;  ___VAR82 = new Element ( ) ;  ___VAR82 = ___VAR82 ;  {
   ___VAR187 = 39 ;  ___VAR188 = 42000 ;  ___VAR189 = true ;  ___VAR192 =
   ___VAR188 ;  ___VAR191 = ___VAR189 ;  ___VAR190 = ___VAR187 ;  ___VAR82 .
   Age = ___VAR190 ;  ___VAR82 . Salary = ___VAR192 ;  ___VAR82 . Married =
   ___VAR191 ;  ___VAR82 . ____1234Init4321____ = true ; }  ___VAR91 = ___VAR82
   . ____1234Init4321____ ;  ___VAR81 = ___VAR91 ;  ___VAR83 = ___VAR82 ;
   ___VAR79 = ___VAR79 ;  { ___VAR193 = ___VAR82 ;  ___VAR197 = ___VAR193 ;
   ___VAR195 = ___VAR79 ;  ___VAR196 = new List ( ) ;  ___VAR196 = ___VAR196 ;
   ___VAR196 . InitNew ( ___VAR197 , ___VAR195 , false ) ;  ___VAR198 =
   ___VAR196 . ____1234InitNew4321____ ;  ___VAR194 = ___VAR198 ;  ___VAR79 .
   ____1234Insert4321____ = ___VAR196 ; }  ___VAR92 = ___VAR79 .
   ____1234Insert4321____ ;  ___VAR79 = ___VAR92 ;  ___VAR79 = ___VAR79 ;  {
   ___VAR199 = ___VAR79 ;  ___VAR200 = ___VAR79 . end ;  ___VAR201 = ___VAR79 .
   elem ;  while ( ! ___VAR200 ) { { ___VAR201 = ___VAR201 ;  ___VAR201 .
   GetAge ( ) ;  ___VAR202 = ___VAR201 . ____1234GetAge4321____ ;
   System.out.println ( ___VAR202 ) ;  ___VAR199 = ___VAR199 ;  ___VAR199 .
   GetNext ( ) ;  ___VAR203 = ___VAR199 . ____1234GetNext4321____ ;  ___VAR199
   = ___VAR203 ;  ___VAR199 = ___VAR199 ;  ___VAR199 . GetEnd ( ) ;  ___VAR204
   = ___VAR199 . ____1234GetEnd4321____ ;  ___VAR200 = ___VAR204 ;  ___VAR199 =
   ___VAR199 ;  ___VAR199 . GetElem ( ) ;  ___VAR205 = ___VAR199 .
   ____1234GetElem4321____ ;  ___VAR201 = ___VAR205 ; } }   ___VAR79 .
   ____1234Print4321____ = true ; }  ___VAR93 = ___VAR79 .
   ____1234Print4321____ ;  ___VAR81 = ___VAR93 ;  System.out.println (
   10000000 ) ;  ___VAR82 = new Element ( ) ;  ___VAR82 = ___VAR82 ;  {
   ___VAR206 = 22 ;  ___VAR207 = 34000 ;  ___VAR208 = false ;  ___VAR211 =
   ___VAR207 ;  ___VAR210 = ___VAR208 ;  ___VAR209 = ___VAR206 ;  ___VAR82 .
   Age = ___VAR209 ;  ___VAR82 . Salary = ___VAR211 ;  ___VAR82 . Married =
   ___VAR210 ;  ___VAR82 . ____1234Init4321____ = true ; }  ___VAR94 = ___VAR82
   . ____1234Init4321____ ;  ___VAR81 = ___VAR94 ;  ___VAR79 = ___VAR79 ;  {
   ___VAR212 = ___VAR82 ;  ___VAR216 = ___VAR212 ;  ___VAR214 = ___VAR79 ;
   ___VAR215 = new List ( ) ;  ___VAR215 = ___VAR215 ;  ___VAR215 . InitNew (
   ___VAR216 , ___VAR214 , false ) ;  ___VAR217 = ___VAR215 .
   ____1234InitNew4321____ ;  ___VAR213 = ___VAR217 ;  ___VAR79 .
   ____1234Insert4321____ = ___VAR215 ; }  ___VAR95 = ___VAR79 .
   ____1234Insert4321____ ;  ___VAR79 = ___VAR95 ;  ___VAR79 = ___VAR79 ;  {
   ___VAR218 = ___VAR79 ;  ___VAR219 = ___VAR79 . end ;  ___VAR220 = ___VAR79 .
   elem ;  while ( ! ___VAR219 ) { { ___VAR220 = ___VAR220 ;  ___VAR220 .
   GetAge ( ) ;  ___VAR221 = ___VAR220 . ____1234GetAge4321____ ;
   System.out.println ( ___VAR221 ) ;  ___VAR218 = ___VAR218 ;  ___VAR218 .
   GetNext ( ) ;  ___VAR222 = ___VAR218 . ____1234GetNext4321____ ;  ___VAR218
   = ___VAR222 ;  ___VAR218 = ___VAR218 ;  ___VAR218 . GetEnd ( ) ;  ___VAR223
   = ___VAR218 . ____1234GetEnd4321____ ;  ___VAR219 = ___VAR223 ;  ___VAR218 =
   ___VAR218 ;  ___VAR218 . GetElem ( ) ;  ___VAR224 = ___VAR218 .
   ____1234GetElem4321____ ;  ___VAR220 = ___VAR224 ; } }   ___VAR79 .
   ____1234Print4321____ = true ; }  ___VAR96 = ___VAR79 .
   ____1234Print4321____ ;  ___VAR81 = ___VAR96 ;  ___VAR84 = new Element ( ) ;
   ___VAR84 = ___VAR84 ;  { ___VAR225 = 27 ;  ___VAR226 = 34000 ;  ___VAR227 =
   false ;  ___VAR230 = ___VAR226 ;  ___VAR229 = ___VAR227 ;  ___VAR228 =
   ___VAR225 ;  ___VAR84 . Age = ___VAR228 ;  ___VAR84 . Salary = ___VAR230 ;
   ___VAR84 . Married = ___VAR229 ;  ___VAR84 . ____1234Init4321____ = true ; }
   ___VAR97 = ___VAR84 . ____1234Init4321____ ;  ___VAR81 = ___VAR97 ;
   ___VAR79 = ___VAR79 ;  { ___VAR231 = ___VAR83 ;  ___VAR237 = ___VAR231 ;
   ___VAR232 = 0 ;  ___VAR233 = ___VAR79 ;  ___VAR235 = ___VAR79 . end ;
   ___VAR234 = ___VAR79 . elem ;  while ( ! ___VAR235 ) { { ___VAR237 =
   ___VAR237 ;  ___VAR237 . Equal ( ___VAR234  ) ;  ___VAR238 = ___VAR237 .
   ____1234Equal4321____ ;  if ( ___VAR238 ) { { ___VAR232 = 1 ; } }  else {
   ___VAR236 = 0 ; }   ___VAR233 = ___VAR233 ;  ___VAR233 . GetNext ( ) ;
   ___VAR239 = ___VAR233 . ____1234GetNext4321____ ;  ___VAR233 = ___VAR239 ;
   ___VAR233 = ___VAR233 ;  ___VAR233 . GetEnd ( ) ;  ___VAR240 = ___VAR233 .
   ____1234GetEnd4321____ ;  ___VAR235 = ___VAR240 ;  ___VAR233 = ___VAR233 ;
   ___VAR233 . GetElem ( ) ;  ___VAR241 = ___VAR233 . ____1234GetElem4321____ ;
   ___VAR234 = ___VAR241 ; } }   ___VAR79 . ____1234Search4321____ = ___VAR232
   ; }  ___VAR98 = ___VAR79 . ____1234Search4321____ ;  System.out.println (
   ___VAR98 ) ;  ___VAR79 = ___VAR79 ;  { ___VAR242 = ___VAR84 ;  ___VAR248 =
   ___VAR242 ;  ___VAR243 = 0 ;  ___VAR244 = ___VAR79 ;  ___VAR246 = ___VAR79 .
   end ;  ___VAR245 = ___VAR79 . elem ;  while ( ! ___VAR246 ) { { ___VAR248 =
   ___VAR248 ;  ___VAR248 . Equal ( ___VAR245  ) ;  ___VAR249 = ___VAR248 .
   ____1234Equal4321____ ;  if ( ___VAR249 ) { { ___VAR243 = 1 ; } }  else {
   ___VAR247 = 0 ; }   ___VAR244 = ___VAR244 ;  ___VAR244 . GetNext ( ) ;
   ___VAR250 = ___VAR244 . ____1234GetNext4321____ ;  ___VAR244 = ___VAR250 ;
   ___VAR244 = ___VAR244 ;  ___VAR244 . GetEnd ( ) ;  ___VAR251 = ___VAR244 .
   ____1234GetEnd4321____ ;  ___VAR246 = ___VAR251 ;  ___VAR244 = ___VAR244 ;
   ___VAR244 . GetElem ( ) ;  ___VAR252 = ___VAR244 . ____1234GetElem4321____ ;
   ___VAR245 = ___VAR252 ; } }   ___VAR79 . ____1234Search4321____ = ___VAR243
   ; }  ___VAR99 = ___VAR79 . ____1234Search4321____ ;  System.out.println (
   ___VAR99 ) ;  System.out.println ( 10000000 ) ;  ___VAR82 = new Element ( )
   ;  ___VAR82 = ___VAR82 ;  { ___VAR253 = 28 ;  ___VAR254 = 35000 ;  ___VAR255
   = false ;  ___VAR258 = ___VAR254 ;  ___VAR257 = ___VAR255 ;  ___VAR256 =
   ___VAR253 ;  ___VAR82 . Age = ___VAR256 ;  ___VAR82 . Salary = ___VAR258 ;
   ___VAR82 . Married = ___VAR257 ;  ___VAR82 . ____1234Init4321____ = true ; }
   ___VAR100 = ___VAR82 . ____1234Init4321____ ;  ___VAR81 = ___VAR100 ;
   ___VAR79 = ___VAR79 ;  { ___VAR259 = ___VAR82 ;  ___VAR263 = ___VAR259 ;
   ___VAR261 = ___VAR79 ;  ___VAR262 = new List ( ) ;  ___VAR262 = ___VAR262 ;
   ___VAR262 . InitNew ( ___VAR263 , ___VAR261 , false ) ;  ___VAR264 =
   ___VAR262 . ____1234InitNew4321____ ;  ___VAR260 = ___VAR264 ;  ___VAR79 .
   ____1234Insert4321____ = ___VAR262 ; }  ___VAR101 = ___VAR79 .
   ____1234Insert4321____ ;  ___VAR79 = ___VAR101 ;  ___VAR79 = ___VAR79 ;  {
   ___VAR265 = ___VAR79 ;  ___VAR266 = ___VAR79 . end ;  ___VAR267 = ___VAR79 .
   elem ;  while ( ! ___VAR266 ) { { ___VAR267 = ___VAR267 ;  ___VAR267 .
   GetAge ( ) ;  ___VAR268 = ___VAR267 . ____1234GetAge4321____ ;
   System.out.println ( ___VAR268 ) ;  ___VAR265 = ___VAR265 ;  ___VAR265 .
   GetNext ( ) ;  ___VAR269 = ___VAR265 . ____1234GetNext4321____ ;  ___VAR265
   = ___VAR269 ;  ___VAR265 = ___VAR265 ;  ___VAR265 . GetEnd ( ) ;  ___VAR270
   = ___VAR265 . ____1234GetEnd4321____ ;  ___VAR266 = ___VAR270 ;  ___VAR265 =
   ___VAR265 ;  ___VAR265 . GetElem ( ) ;  ___VAR271 = ___VAR265 .
   ____1234GetElem4321____ ;  ___VAR267 = ___VAR271 ; } }   ___VAR79 .
   ____1234Print4321____ = true ; }  ___VAR102 = ___VAR79 .
   ____1234Print4321____ ;  ___VAR81 = ___VAR102 ;  System.out.println (
   2220000 ) ;  ___VAR79 = ___VAR79 ;  { ___VAR272 = ___VAR83 ;  ___VAR282 =
   ___VAR272 ;  ___VAR273 = ___VAR79 ;  ___VAR274 = false ;  ___VAR280 = 0 - 1
   ;  ___VAR276 = ___VAR79 ;  ___VAR277 = ___VAR79 ;  ___VAR278 = ___VAR79 .
   end ;  ___VAR279 = ___VAR79 . elem ;  ___VAR283 = ! ___VAR278 ;  ___VAR284 =
   ! ___VAR274 ;  while ( ___VAR283 & ___VAR284  ) { { ___VAR282 = ___VAR282 ;
   ___VAR282 . Equal ( ___VAR279  ) ;  ___VAR288 = ___VAR282 .
   ____1234Equal4321____ ;  if ( ___VAR288 ) { { ___VAR274 = true ;  if (
   ___VAR280 < 0 ) { { ___VAR276 = ___VAR276 ;  ___VAR276 . GetNext ( ) ;
   ___VAR285 = ___VAR276 . ____1234GetNext4321____ ;  ___VAR273 = ___VAR285 ; }
   }  else { { System.out.println ( 0 - 555 ) ;  ___VAR277 = ___VAR277 ;
   ___VAR276 = ___VAR276 ;  ___VAR276 . GetNext ( ) ;  ___VAR287 = ___VAR276 .
   ____1234GetNext4321____ ;  ___VAR277 . SetNext ( ___VAR287  ) ;  ___VAR286 =
   ___VAR277 . ____1234SetNext4321____ ;  ___VAR275 = ___VAR286 ;
   System.out.println ( 0 - 555 ) ; } }  } }  else { ___VAR281 = 0 ; }   if ( !
   ___VAR274 ) { { ___VAR277 = ___VAR276 ;  ___VAR276 = ___VAR276 ;  ___VAR276
   . GetNext ( ) ;  ___VAR289 = ___VAR276 . ____1234GetNext4321____ ;
   ___VAR276 = ___VAR289 ;  ___VAR276 = ___VAR276 ;  ___VAR276 . GetEnd ( ) ;
   ___VAR290 = ___VAR276 . ____1234GetEnd4321____ ;  ___VAR278 = ___VAR290 ;
   ___VAR276 = ___VAR276 ;  ___VAR276 . GetElem ( ) ;  ___VAR291 = ___VAR276 .
   ____1234GetElem4321____ ;  ___VAR279 = ___VAR291 ;  ___VAR280 = 1 ; } }
   else { ___VAR281 = 0 ; }  }  ___VAR283 = ! ___VAR278 ;  ___VAR284 = !
   ___VAR274 ; }   ___VAR79 . ____1234Delete4321____ = ___VAR273 ; }  ___VAR103
   = ___VAR79 . ____1234Delete4321____ ;  ___VAR79 = ___VAR103 ;  ___VAR79 =
   ___VAR79 ;  { ___VAR292 = ___VAR79 ;  ___VAR293 = ___VAR79 . end ;
   ___VAR294 = ___VAR79 . elem ;  while ( ! ___VAR293 ) { { ___VAR294 =
   ___VAR294 ;  ___VAR294 . GetAge ( ) ;  ___VAR295 = ___VAR294 .
   ____1234GetAge4321____ ;  System.out.println ( ___VAR295 ) ;  ___VAR292 =
   ___VAR292 ;  ___VAR292 . GetNext ( ) ;  ___VAR296 = ___VAR292 .
   ____1234GetNext4321____ ;  ___VAR292 = ___VAR296 ;  ___VAR292 = ___VAR292 ;
   ___VAR292 . GetEnd ( ) ;  ___VAR297 = ___VAR292 . ____1234GetEnd4321____ ;
   ___VAR293 = ___VAR297 ;  ___VAR292 = ___VAR292 ;  ___VAR292 . GetElem ( ) ;
   ___VAR298 = ___VAR292 . ____1234GetElem4321____ ;  ___VAR294 = ___VAR298 ; }
   }   ___VAR79 . ____1234Print4321____ = true ; }  ___VAR104 = ___VAR79 .
   ____1234Print4321____ ;  ___VAR81 = ___VAR104 ;  System.out.println (
   33300000 ) ;  ___VAR79 = ___VAR79 ;  { ___VAR299 = ___VAR82 ;  ___VAR309 =
   ___VAR299 ;  ___VAR300 = ___VAR79 ;  ___VAR301 = false ;  ___VAR307 = 0 - 1
   ;  ___VAR303 = ___VAR79 ;  ___VAR304 = ___VAR79 ;  ___VAR305 = ___VAR79 .
   end ;  ___VAR306 = ___VAR79 . elem ;  ___VAR310 = ! ___VAR305 ;  ___VAR311 =
   ! ___VAR301 ;  while ( ___VAR310 & ___VAR311  ) { { ___VAR309 = ___VAR309 ;
   ___VAR309 . Equal ( ___VAR306  ) ;  ___VAR315 = ___VAR309 .
   ____1234Equal4321____ ;  if ( ___VAR315 ) { { ___VAR301 = true ;  if (
   ___VAR307 < 0 ) { { ___VAR303 = ___VAR303 ;  ___VAR303 . GetNext ( ) ;
   ___VAR312 = ___VAR303 . ____1234GetNext4321____ ;  ___VAR300 = ___VAR312 ; }
   }  else { { System.out.println ( 0 - 555 ) ;  ___VAR304 = ___VAR304 ;
   ___VAR303 = ___VAR303 ;  ___VAR303 . GetNext ( ) ;  ___VAR314 = ___VAR303 .
   ____1234GetNext4321____ ;  ___VAR304 . SetNext ( ___VAR314  ) ;  ___VAR313 =
   ___VAR304 . ____1234SetNext4321____ ;  ___VAR302 = ___VAR313 ;
   System.out.println ( 0 - 555 ) ; } }  } }  else { ___VAR308 = 0 ; }   if ( !
   ___VAR301 ) { { ___VAR304 = ___VAR303 ;  ___VAR303 = ___VAR303 ;  ___VAR303
   . GetNext ( ) ;  ___VAR316 = ___VAR303 . ____1234GetNext4321____ ;
   ___VAR303 = ___VAR316 ;  ___VAR303 = ___VAR303 ;  ___VAR303 . GetEnd ( ) ;
   ___VAR317 = ___VAR303 . ____1234GetEnd4321____ ;  ___VAR305 = ___VAR317 ;
   ___VAR303 = ___VAR303 ;  ___VAR303 . GetElem ( ) ;  ___VAR318 = ___VAR303 .
   ____1234GetElem4321____ ;  ___VAR306 = ___VAR318 ;  ___VAR307 = 1 ; } }
   else { ___VAR308 = 0 ; }  }  ___VAR310 = ! ___VAR305 ;  ___VAR311 = !
   ___VAR301 ; }   ___VAR79 . ____1234Delete4321____ = ___VAR300 ; }  ___VAR105
   = ___VAR79 . ____1234Delete4321____ ;  ___VAR79 = ___VAR105 ;  ___VAR79 =
   ___VAR79 ;  { ___VAR319 = ___VAR79 ;  ___VAR320 = ___VAR79 . end ;
   ___VAR321 = ___VAR79 . elem ;  while ( ! ___VAR320 ) { { ___VAR321 =
   ___VAR321 ;  ___VAR321 . GetAge ( ) ;  ___VAR322 = ___VAR321 .
   ____1234GetAge4321____ ;  System.out.println ( ___VAR322 ) ;  ___VAR319 =
   ___VAR319 ;  ___VAR319 . GetNext ( ) ;  ___VAR323 = ___VAR319 .
   ____1234GetNext4321____ ;  ___VAR319 = ___VAR323 ;  ___VAR319 = ___VAR319 ;
   ___VAR319 . GetEnd ( ) ;  ___VAR324 = ___VAR319 . ____1234GetEnd4321____ ;
   ___VAR320 = ___VAR324 ;  ___VAR319 = ___VAR319 ;  ___VAR319 . GetElem ( ) ;
   ___VAR325 = ___VAR319 . ____1234GetElem4321____ ;  ___VAR321 = ___VAR325 ; }
   }   ___VAR79 . ____1234Print4321____ = true ; }  ___VAR106 = ___VAR79 .
   ____1234Print4321____ ;  ___VAR81 = ___VAR106 ;  System.out.println (
   44440000 ) ;  ____1234Start4321____ = 0 ; } }
class ____NewMainClass____ { public void ____Main____ ( int  ___VAR107  ) { int
   ___VAR108 ;  LL  ___VAR109 ;  int  ___VAR110 ;  List  ___VAR326 ;  List
   ___VAR327 ;  boolean  ___VAR328 ;  Element  ___VAR329 ;  Element  ___VAR330
   ;  Element  ___VAR331 ;  boolean  ___VAR332 ;  boolean  ___VAR333 ;  boolean
   ___VAR334 ;  boolean  ___VAR335 ;  List  ___VAR336 ;  boolean  ___VAR337 ;
   boolean  ___VAR338 ;  List  ___VAR339 ;  boolean  ___VAR340 ;  boolean
   ___VAR341 ;  List  ___VAR342 ;  boolean  ___VAR343 ;  boolean  ___VAR344 ;
   int  ___VAR345 ;  int  ___VAR346 ;  boolean  ___VAR347 ;  List  ___VAR348 ;
   boolean  ___VAR349 ;  List  ___VAR350 ;  boolean  ___VAR351 ;  List
   ___VAR352 ;  boolean  ___VAR353 ; ___VAR109 = new LL ( ) ;  { ___VAR327 =
   new List ( ) ;  ___VAR327 = ___VAR327 ;  ___VAR327 . Init ( ) ;  ___VAR332 =
   ___VAR327 . ____1234Init4321____ ;  ___VAR328 = ___VAR332 ;  ___VAR326 =
   ___VAR327 ;  ___VAR326 = ___VAR326 ;  ___VAR326 . Init ( ) ;  ___VAR333 =
   ___VAR326 . ____1234Init4321____ ;  ___VAR328 = ___VAR333 ;  ___VAR326 =
   ___VAR326 ;  ___VAR326 . Print ( ) ;  ___VAR334 = ___VAR326 .
   ____1234Print4321____ ;  ___VAR328 = ___VAR334 ;  ___VAR329 = new Element (
   ) ;  ___VAR329 = ___VAR329 ;  ___VAR329 . Init ( 25 , 37000 , false ) ;
   ___VAR335 = ___VAR329 . ____1234Init4321____ ;  ___VAR328 = ___VAR335 ;
   ___VAR326 = ___VAR326 ;  ___VAR326 . Insert ( ___VAR329  ) ;  ___VAR336 =
   ___VAR326 . ____1234Insert4321____ ;  ___VAR326 = ___VAR336 ;  ___VAR326 =
   ___VAR326 ;  ___VAR326 . Print ( ) ;  ___VAR337 = ___VAR326 .
   ____1234Print4321____ ;  ___VAR328 = ___VAR337 ;  System.out.println (
   10000000 ) ;  ___VAR329 = new Element ( ) ;  ___VAR329 = ___VAR329 ;
   ___VAR329 . Init ( 39 , 42000 , true ) ;  ___VAR338 = ___VAR329 .
   ____1234Init4321____ ;  ___VAR328 = ___VAR338 ;  ___VAR330 = ___VAR329 ;
   ___VAR326 = ___VAR326 ;  ___VAR326 . Insert ( ___VAR329  ) ;  ___VAR339 =
   ___VAR326 . ____1234Insert4321____ ;  ___VAR326 = ___VAR339 ;  ___VAR326 =
   ___VAR326 ;  ___VAR326 . Print ( ) ;  ___VAR340 = ___VAR326 .
   ____1234Print4321____ ;  ___VAR328 = ___VAR340 ;  System.out.println (
   10000000 ) ;  ___VAR329 = new Element ( ) ;  ___VAR329 = ___VAR329 ;
   ___VAR329 . Init ( 22 , 34000 , false ) ;  ___VAR341 = ___VAR329 .
   ____1234Init4321____ ;  ___VAR328 = ___VAR341 ;  ___VAR326 = ___VAR326 ;
   ___VAR326 . Insert ( ___VAR329  ) ;  ___VAR342 = ___VAR326 .
   ____1234Insert4321____ ;  ___VAR326 = ___VAR342 ;  ___VAR326 = ___VAR326 ;
   ___VAR326 . Print ( ) ;  ___VAR343 = ___VAR326 . ____1234Print4321____ ;
   ___VAR328 = ___VAR343 ;  ___VAR331 = new Element ( ) ;  ___VAR331 =
   ___VAR331 ;  ___VAR331 . Init ( 27 , 34000 , false ) ;  ___VAR344 =
   ___VAR331 . ____1234Init4321____ ;  ___VAR328 = ___VAR344 ;  ___VAR326 =
   ___VAR326 ;  ___VAR326 . Search ( ___VAR330  ) ;  ___VAR345 = ___VAR326 .
   ____1234Search4321____ ;  System.out.println ( ___VAR345 ) ;  ___VAR326 =
   ___VAR326 ;  ___VAR326 . Search ( ___VAR331  ) ;  ___VAR346 = ___VAR326 .
   ____1234Search4321____ ;  System.out.println ( ___VAR346 ) ;
   System.out.println ( 10000000 ) ;  ___VAR329 = new Element ( ) ;  ___VAR329
   = ___VAR329 ;  ___VAR329 . Init ( 28 , 35000 , false ) ;  ___VAR347 =
   ___VAR329 . ____1234Init4321____ ;  ___VAR328 = ___VAR347 ;  ___VAR326 =
   ___VAR326 ;  ___VAR326 . Insert ( ___VAR329  ) ;  ___VAR348 = ___VAR326 .
   ____1234Insert4321____ ;  ___VAR326 = ___VAR348 ;  ___VAR326 = ___VAR326 ;
   ___VAR326 . Print ( ) ;  ___VAR349 = ___VAR326 . ____1234Print4321____ ;
   ___VAR328 = ___VAR349 ;  System.out.println ( 2220000 ) ;  ___VAR326 =
   ___VAR326 ;  ___VAR326 . Delete ( ___VAR330  ) ;  ___VAR350 = ___VAR326 .
   ____1234Delete4321____ ;  ___VAR326 = ___VAR350 ;  ___VAR326 = ___VAR326 ;
   ___VAR326 . Print ( ) ;  ___VAR351 = ___VAR326 . ____1234Print4321____ ;
   ___VAR328 = ___VAR351 ;  System.out.println ( 33300000 ) ;  ___VAR326 =
   ___VAR326 ;  ___VAR326 . Delete ( ___VAR329  ) ;  ___VAR352 = ___VAR326 .
   ____1234Delete4321____ ;  ___VAR326 = ___VAR352 ;  ___VAR326 = ___VAR326 ;
   ___VAR326 . Print ( ) ;  ___VAR353 = ___VAR326 . ____1234Print4321____ ;
   ___VAR328 = ___VAR353 ;  System.out.println ( 44440000 ) ;  ___VAR109 .
   ____1234Start4321____ = 0 ; }  ___VAR110 = ___VAR109 . ____1234Start4321____
   ;  ___VAR108 = ___VAR110 ;  System.out.println ( ___VAR108 ) ; } } 