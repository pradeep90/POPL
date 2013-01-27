class TreeVisitor {
   public static void main(String [] a){
      new ____NewMainClass____().____Main____(0);
   }
}
class TV{
   int ____1234Start4321____;

   public void Start(){
      Tree root;
      boolean ntb;
      int nti;
      MyVisitor v;
      boolean ___tmp0;
      boolean ___tmp2;
      boolean ___tmp4;
      boolean ___tmp6;
      boolean ___tmp8;
      boolean ___tmp10;
      boolean ___tmp12;
      boolean ___tmp14;
      boolean ___tmp16;
      boolean ___tmp18;
      int ___tmp20;
      int ___tmp22;
      int ___tmp24;
      int ___tmp26;
      int ___tmp28;
      int ___tmp30;
      boolean ___tmp32;
      boolean ___tmp34;
      int ___tmp36;

      root =
         new Tree();
      root = root;
      root.Init(16);
      ___tmp0 = root.____1234Init4321____;
      ntb = ___tmp0;
      root = root;
      root.Print();
      ___tmp2 = root.____1234Print4321____;
      ntb = ___tmp2;
      System.out.println(100000000);
      root = root;
      root.Insert(8);
      ___tmp4 = root.____1234Insert4321____;
      ntb = ___tmp4;
      root = root;
      root.Insert(24);
      ___tmp6 = root.____1234Insert4321____;
      ntb = ___tmp6;
      root = root;
      root.Insert(4);
      ___tmp8 = root.____1234Insert4321____;
      ntb = ___tmp8;
      root = root;
      root.Insert(12);
      ___tmp10 = root.____1234Insert4321____;
      ntb = ___tmp10;
      root = root;
      root.Insert(20);
      ___tmp12 = root.____1234Insert4321____;
      ntb = ___tmp12;
      root = root;
      root.Insert(28);
      ___tmp14 = root.____1234Insert4321____;
      ntb = ___tmp14;
      root = root;
      root.Insert(14);
      ___tmp16 = root.____1234Insert4321____;
      ntb = ___tmp16;
      root = root;
      root.Print();
      ___tmp18 = root.____1234Print4321____;
      ntb = ___tmp18;
      System.out.println(100000000);
      v =
         new MyVisitor();
      System.out.println(50000000);
      root = root;
      root.accept(v);
      ___tmp20 = root.____1234accept4321____;
      nti = ___tmp20;
      System.out.println(100000000);
      root = root;
      root.Search(24);
      ___tmp22 = root.____1234Search4321____;
      System.out.println(___tmp22);
      root = root;
      root.Search(12);
      ___tmp24 = root.____1234Search4321____;
      System.out.println(___tmp24);
      root = root;
      root.Search(16);
      ___tmp26 = root.____1234Search4321____;
      System.out.println(___tmp26);
      root = root;
      root.Search(50);
      ___tmp28 = root.____1234Search4321____;
      System.out.println(___tmp28);
      root = root;
      root.Search(12);
      ___tmp30 = root.____1234Search4321____;
      System.out.println(___tmp30);
      root = root;
      root.Delete(12);
      ___tmp32 = root.____1234Delete4321____;
      ntb = ___tmp32;
      root = root;
      root.Print();
      ___tmp34 = root.____1234Print4321____;
      ntb = ___tmp34;
      root = root;
      root.Search(12);
      ___tmp36 = root.____1234Search4321____;
      System.out.println(___tmp36);
      ____1234Start4321____ = 0;
   }
}
class Tree{
   Tree left;
   Tree right;
   int key;
   boolean has_left;
   boolean has_right;
   Tree my_null;
   boolean ____1234Init4321____;
   boolean ____1234SetRight4321____;
   boolean ____1234SetLeft4321____;
   Tree ____1234GetRight4321____;
   Tree ____1234GetLeft4321____;
   int ____1234GetKey4321____;
   boolean ____1234SetKey4321____;
   boolean ____1234GetHas_Right4321____;
   boolean ____1234GetHas_Left4321____;
   boolean ____1234SetHas_Left4321____;
   boolean ____1234SetHas_Right4321____;
   boolean ____1234Compare4321____;
   boolean ____1234Insert4321____;
   boolean ____1234Delete4321____;
   boolean ____1234Remove4321____;
   boolean ____1234RemoveRight4321____;
   boolean ____1234RemoveLeft4321____;
   int ____1234Search4321____;
   boolean ____1234Print4321____;
   boolean ____1234RecPrint4321____;
   int ____1234accept4321____;

   public void Init(int v_key){
      int ____writeable____v_key;

      ____writeable____v_key = v_key;
      key = ____writeable____v_key;
      has_left = false;
      has_right = false;
      ____1234Init4321____ = true;
   }
   public void SetRight(Tree rn){
      Tree ____writeable____rn;

      ____writeable____rn = rn;
      right = ____writeable____rn;
      ____1234SetRight4321____ = true;
   }
   public void SetLeft(Tree ln){
      Tree ____writeable____ln;

      ____writeable____ln = ln;
      left = ____writeable____ln;
      ____1234SetLeft4321____ = true;
   }
   public void GetRight(){

      ____1234GetRight4321____ = right;
   }
   public void GetLeft(){

      ____1234GetLeft4321____ = left;
   }
   public void GetKey(){

      ____1234GetKey4321____ = key;
   }
   public void SetKey(int v_key){
      int ____writeable____v_key;

      ____writeable____v_key = v_key;
      key = ____writeable____v_key;
      ____1234SetKey4321____ = true;
   }
   public void GetHas_Right(){

      ____1234GetHas_Right4321____ = has_right;
   }
   public void GetHas_Left(){

      ____1234GetHas_Left4321____ = has_left;
   }
   public void SetHas_Left(boolean val){
      boolean ____writeable____val;

      ____writeable____val = val;
      has_left = ____writeable____val;
      ____1234SetHas_Left4321____ = true;
   }
   public void SetHas_Right(boolean val){
      boolean ____writeable____val;

      ____writeable____val = val;
      has_right = ____writeable____val;
      ____1234SetHas_Right4321____ = true;
   }
   public void Compare(int num1,
      int num2){
      boolean ntb;
      int nti;
      int ____writeable____num2;
      int ____writeable____num1;
      boolean ____tmp38;

      ____writeable____num1 = num1;
      ____writeable____num2 = num2;
      ntb = false;
      nti = ____writeable____num2+1;
      if( ____writeable____num1<____writeable____num2 ){
         ntb = false;
      } else {
         ____tmp38 = ____writeable____num1<nti;
         if( !____tmp38 ){
            ntb = false;
         } else {
            ntb = true;
         }
      }
      ____1234Compare4321____ = ntb;
   }
   public void Insert(int v_key){
      Tree new_node;
      boolean ntb;
      Tree current_node;
      boolean cont;
      int key_aux;
      int ____writeable____v_key;
      boolean ___tmp39;
      int ___tmp41;
      Tree ___tmp43;
      boolean ___tmp45;
      boolean ___tmp47;
      boolean ___tmp49;
      Tree ___tmp51;
      boolean ___tmp53;
      boolean ___tmp55;
      boolean ___tmp57;

      ____writeable____v_key = v_key;
      new_node =
         new Tree();
      new_node = new_node;
      new_node.Init(____writeable____v_key);
      ___tmp39 = new_node.____1234Init4321____;
      ntb = ___tmp39;
      current_node = this;
      cont = true;
      while ( cont ){{
               current_node = current_node;
               current_node.GetKey();
               ___tmp41 = current_node.____1234GetKey4321____;
               key_aux = ___tmp41;
               if( ____writeable____v_key<key_aux ){{
                     current_node = current_node;
                     current_node.GetHas_Left();
                     ___tmp49 = current_node.____1234GetHas_Left4321____;
                     if( ___tmp49 ){
                        current_node = current_node;
                        current_node.GetLeft();
                        ___tmp43 = current_node.____1234GetLeft4321____;
                        current_node = ___tmp43;
                     } else {{
                           cont = false;
                           current_node = current_node;
                           current_node.SetHas_Left(true);
                           ___tmp45 = current_node.____1234SetHas_Left4321____;
                           ntb = ___tmp45;
                           current_node = current_node;
                           current_node.SetLeft(new_node);
                           ___tmp47 = current_node.____1234SetLeft4321____;
                           ntb = ___tmp47;
                        }
                     }
                  }
               } else {{
                     current_node = current_node;
                     current_node.GetHas_Right();
                     ___tmp57 = current_node.____1234GetHas_Right4321____;
                     if( ___tmp57 ){
                        current_node = current_node;
                        current_node.GetRight();
                        ___tmp51 = current_node.____1234GetRight4321____;
                        current_node = ___tmp51;
                     } else {{
                           cont = false;
                           current_node = current_node;
                           current_node.SetHas_Right(true);
                           ___tmp53 = current_node.____1234SetHas_Right4321____;
                           ntb = ___tmp53;
                           current_node = current_node;
                           current_node.SetRight(new_node);
                           ___tmp55 = current_node.____1234SetRight4321____;
                           ntb = ___tmp55;
                        }
                     }
                  }
               }
            }
         }
      ____1234Insert4321____ = true;
   }
   public void Delete(int v_key){
      Tree current_node;
      Tree parent_node;
      boolean cont;
      boolean found;
      boolean ntb;
      boolean is_root;
      int key_aux;
      int ____writeable____v_key;
      int ___tmp59;
      Tree ___tmp61;
      boolean ___tmp63;
      Tree ___tmp65;
      boolean ___tmp67;
      Tree ___tmp70;
      boolean ___tmp69;
      boolean ___tmp71;
      boolean ___tmp73;
      Tree ___tmp76;
      boolean ___tmp75;

      ____writeable____v_key = v_key;
      current_node = this;
      parent_node = this;
      cont = true;
      found = false;
      is_root = true;
      while ( cont ){{
               current_node = current_node;
               current_node.GetKey();
               ___tmp59 = current_node.____1234GetKey4321____;
               key_aux = ___tmp59;
               if( ____writeable____v_key<key_aux ){
                  current_node = current_node;
                  current_node.GetHas_Left();
                  ___tmp63 = current_node.____1234GetHas_Left4321____;
                  if( ___tmp63 ){{
                        parent_node = current_node;
                        current_node = current_node;
                        current_node.GetLeft();
                        ___tmp61 = current_node.____1234GetLeft4321____;
                        current_node = ___tmp61;
                     }
                  } else {
                     cont = false;
                  }
               } else {
                  if( key_aux<____writeable____v_key ){
                     current_node = current_node;
                     current_node.GetHas_Right();
                     ___tmp67 = current_node.____1234GetHas_Right4321____;
                     if( ___tmp67 ){{
                           parent_node = current_node;
                           current_node = current_node;
                           current_node.GetRight();
                           ___tmp65 = current_node.____1234GetRight4321____;
                           current_node = ___tmp65;
                        }
                     } else {
                        cont = false;
                     }
                  } else {{
                        if( is_root ){
                           current_node = current_node;
                           current_node.GetHas_Right();
                           ___tmp71 = current_node.____1234GetHas_Right4321____;
                           current_node = current_node;
                           current_node.GetHas_Left();
                           ___tmp73 = current_node.____1234GetHas_Left4321____;
                           if( !___tmp71&!___tmp73 ){
                              ntb = true;
                           } else {
                              ___tmp70 = this;
                              ___tmp70.Remove(parent_node,current_node);
                              ___tmp69 = ___tmp70.____1234Remove4321____;
                              ntb = ___tmp69;
                           }
                        } else {
                           ___tmp76 = this;
                           ___tmp76.Remove(parent_node,current_node);
                           ___tmp75 = ___tmp76.____1234Remove4321____;
                           ntb = ___tmp75;
                        }
                        found = true;
                        cont = false;
                     }
                  }
               }
               is_root = false;
            }
         }
      ____1234Delete4321____ = found;
   }
   public void Remove(Tree p_node,
      Tree c_node){
      boolean ntb;
      int auxkey1;
      int auxkey2;
      Tree ____writeable____p_node;
      Tree ____writeable____c_node;
      Tree ___tmp78;
      boolean ___tmp77;
      Tree ___tmp80;
      boolean ___tmp79;
      int ___tmp81;
      Tree ___tmp84;
      int ___tmp83;
      Tree ____tmp90;
      Tree ___tmp93;
      boolean ___tmp95;
      boolean ___tmp97;
      boolean ___tmp99;
      boolean ___tmp101;
      Tree ___tmp104;
      boolean ___tmp103;
      boolean ___tmp105;
      boolean ___tmp107;

      ____writeable____c_node = c_node;
      ____writeable____p_node = p_node;
      ____writeable____c_node = ____writeable____c_node;
      ____writeable____c_node.GetHas_Left();
      ___tmp107 = ____writeable____c_node.____1234GetHas_Left4321____;
      if( ___tmp107 ){
         ___tmp78 = this;
         ___tmp78.RemoveLeft(____writeable____p_node,____writeable____c_node);
         ___tmp77 = ___tmp78.____1234RemoveLeft4321____;
         ntb = ___tmp77;
      } else {
         ____writeable____c_node = ____writeable____c_node;
         ____writeable____c_node.GetHas_Right();
         ___tmp105 = ____writeable____c_node.____1234GetHas_Right4321____;
         if( ___tmp105 ){
            ___tmp80 = this;
            ___tmp80.RemoveRight(____writeable____p_node,____writeable____c_node);
            ___tmp79 = ___tmp80.____1234RemoveRight4321____;
            ntb = ___tmp79;
         } else {{
               ____writeable____c_node = ____writeable____c_node;
               ____writeable____c_node.GetKey();
               ___tmp81 = ____writeable____c_node.____1234GetKey4321____;
               auxkey1 = ___tmp81;
               ____writeable____p_node = ____writeable____p_node;
               ____writeable____p_node.GetLeft();
               ___tmp93 = ____writeable____p_node.____1234GetLeft4321____;
               ____tmp90 = ___tmp93;
               ___tmp84 = ____tmp90;
               ___tmp84.GetKey();
               ___tmp83 = ___tmp84.____1234GetKey4321____;
               auxkey2 = ___tmp83;
               ___tmp104 = this;
               ___tmp104.Compare(auxkey1,auxkey2);
               ___tmp103 = ___tmp104.____1234Compare4321____;
               if( ___tmp103 ){{
                     ____writeable____p_node = ____writeable____p_node;
                     ____writeable____p_node.SetLeft(my_null);
                     ___tmp95 = ____writeable____p_node.____1234SetLeft4321____;
                     ntb = ___tmp95;
                     ____writeable____p_node = ____writeable____p_node;
                     ____writeable____p_node.SetHas_Left(false);
                     ___tmp97 = ____writeable____p_node.____1234SetHas_Left4321____;
                     ntb = ___tmp97;
                  }
               } else {{
                     ____writeable____p_node = ____writeable____p_node;
                     ____writeable____p_node.SetRight(my_null);
                     ___tmp99 = ____writeable____p_node.____1234SetRight4321____;
                     ntb = ___tmp99;
                     ____writeable____p_node = ____writeable____p_node;
                     ____writeable____p_node.SetHas_Right(false);
                     ___tmp101 = ____writeable____p_node.____1234SetHas_Right4321____;
                     ntb = ___tmp101;
                  }
               }
            }
         }
      }
      ____1234Remove4321____ = true;
   }
   public void RemoveRight(Tree p_node,
      Tree c_node){
      boolean ntb;
      Tree ____writeable____p_node;
      Tree ____writeable____c_node;
      boolean ___tmp109;
      boolean ___tmp111;
      Tree ___tmp114;
      int ___tmp113;
      Tree ____tmp120;
      Tree ___tmp123;
      Tree ___tmp125;
      boolean ___tmp127;
      boolean ___tmp129;

      ____writeable____c_node = c_node;
      ____writeable____p_node = p_node;
      ____writeable____c_node = ____writeable____c_node;
      ____writeable____c_node.GetHas_Right();
      ___tmp109 = ____writeable____c_node.____1234GetHas_Right4321____;
      while ( ___tmp109 ){{
               ____writeable____c_node = ____writeable____c_node;
               ____writeable____c_node = ____writeable____c_node;
               ____writeable____c_node.GetRight();
               ___tmp123 = ____writeable____c_node.____1234GetRight4321____;
               ____tmp120 = ___tmp123;
               ___tmp114 = ____tmp120;
               ___tmp114.GetKey();
               ___tmp113 = ___tmp114.____1234GetKey4321____;
               ____writeable____c_node.SetKey(___tmp113);
               ___tmp111 = ____writeable____c_node.____1234SetKey4321____;
               ntb = ___tmp111;
               ____writeable____p_node = ____writeable____c_node;
               ____writeable____c_node = ____writeable____c_node;
               ____writeable____c_node.GetRight();
               ___tmp125 = ____writeable____c_node.____1234GetRight4321____;
               ____writeable____c_node = ___tmp125;
            }
            ____writeable____c_node = ____writeable____c_node;
            ____writeable____c_node.GetHas_Right();
            ___tmp109 = ____writeable____c_node.____1234GetHas_Right4321____;
         }
      ____writeable____p_node = ____writeable____p_node;
      ____writeable____p_node.SetRight(my_null);
      ___tmp127 = ____writeable____p_node.____1234SetRight4321____;
      ntb = ___tmp127;
      ____writeable____p_node = ____writeable____p_node;
      ____writeable____p_node.SetHas_Right(false);
      ___tmp129 = ____writeable____p_node.____1234SetHas_Right4321____;
      ntb = ___tmp129;
      ____1234RemoveRight4321____ = true;
   }
   public void RemoveLeft(Tree p_node,
      Tree c_node){
      boolean ntb;
      Tree ____writeable____p_node;
      Tree ____writeable____c_node;
      boolean ___tmp131;
      boolean ___tmp133;
      Tree ___tmp136;
      int ___tmp135;
      Tree ____tmp142;
      Tree ___tmp145;
      Tree ___tmp147;
      boolean ___tmp149;
      boolean ___tmp151;

      ____writeable____c_node = c_node;
      ____writeable____p_node = p_node;
      ____writeable____c_node = ____writeable____c_node;
      ____writeable____c_node.GetHas_Left();
      ___tmp131 = ____writeable____c_node.____1234GetHas_Left4321____;
      while ( ___tmp131 ){{
               ____writeable____c_node = ____writeable____c_node;
               ____writeable____c_node = ____writeable____c_node;
               ____writeable____c_node.GetLeft();
               ___tmp145 = ____writeable____c_node.____1234GetLeft4321____;
               ____tmp142 = ___tmp145;
               ___tmp136 = ____tmp142;
               ___tmp136.GetKey();
               ___tmp135 = ___tmp136.____1234GetKey4321____;
               ____writeable____c_node.SetKey(___tmp135);
               ___tmp133 = ____writeable____c_node.____1234SetKey4321____;
               ntb = ___tmp133;
               ____writeable____p_node = ____writeable____c_node;
               ____writeable____c_node = ____writeable____c_node;
               ____writeable____c_node.GetLeft();
               ___tmp147 = ____writeable____c_node.____1234GetLeft4321____;
               ____writeable____c_node = ___tmp147;
            }
            ____writeable____c_node = ____writeable____c_node;
            ____writeable____c_node.GetHas_Left();
            ___tmp131 = ____writeable____c_node.____1234GetHas_Left4321____;
         }
      ____writeable____p_node = ____writeable____p_node;
      ____writeable____p_node.SetLeft(my_null);
      ___tmp149 = ____writeable____p_node.____1234SetLeft4321____;
      ntb = ___tmp149;
      ____writeable____p_node = ____writeable____p_node;
      ____writeable____p_node.SetHas_Left(false);
      ___tmp151 = ____writeable____p_node.____1234SetHas_Left4321____;
      ntb = ___tmp151;
      ____1234RemoveLeft4321____ = true;
   }
   public void Search(int v_key){
      Tree current_node;
      int ifound;
      boolean cont;
      int key_aux;
      int ____writeable____v_key;
      int ___tmp153;
      Tree ___tmp155;
      boolean ___tmp157;
      Tree ___tmp159;
      boolean ___tmp161;

      ____writeable____v_key = v_key;
      current_node = this;
      cont = true;
      ifound = 0;
      while ( cont ){{
               current_node = current_node;
               current_node.GetKey();
               ___tmp153 = current_node.____1234GetKey4321____;
               key_aux = ___tmp153;
               if( ____writeable____v_key<key_aux ){
                  current_node = current_node;
                  current_node.GetHas_Left();
                  ___tmp157 = current_node.____1234GetHas_Left4321____;
                  if( ___tmp157 ){
                     current_node = current_node;
                     current_node.GetLeft();
                     ___tmp155 = current_node.____1234GetLeft4321____;
                     current_node = ___tmp155;
                  } else {
                     cont = false;
                  }
               } else {
                  if( key_aux<____writeable____v_key ){
                     current_node = current_node;
                     current_node.GetHas_Right();
                     ___tmp161 = current_node.____1234GetHas_Right4321____;
                     if( ___tmp161 ){
                        current_node = current_node;
                        current_node.GetRight();
                        ___tmp159 = current_node.____1234GetRight4321____;
                        current_node = ___tmp159;
                     } else {
                        cont = false;
                     }
                  } else {{
                        ifound = 1;
                        cont = false;
                     }
                  }
               }
            }
         }
      ____1234Search4321____ = ifound;
   }
   public void Print(){
      boolean ntb;
      Tree current_node;
      Tree ___tmp164;
      boolean ___tmp163;

      current_node = this;
      ___tmp164 = this;
      ___tmp164.RecPrint(current_node);
      ___tmp163 = ___tmp164.____1234RecPrint4321____;
      ntb = ___tmp163;
      ____1234Print4321____ = true;
   }
   public void RecPrint(Tree node){
      boolean ntb;
      Tree ____writeable____node;
      Tree ___tmp166;
      boolean ___tmp165;
      Tree ___tmp167;
      boolean ___tmp169;
      int ___tmp171;
      Tree ___tmp174;
      boolean ___tmp173;
      Tree ___tmp175;
      boolean ___tmp177;

      ____writeable____node = node;
      ____writeable____node = ____writeable____node;
      ____writeable____node.GetHas_Left();
      ___tmp169 = ____writeable____node.____1234GetHas_Left4321____;
      if( ___tmp169 ){{
            ___tmp166 = this;
            ____writeable____node = ____writeable____node;
            ____writeable____node.GetLeft();
            ___tmp167 = ____writeable____node.____1234GetLeft4321____;
            ___tmp166.RecPrint(___tmp167);
            ___tmp165 = ___tmp166.____1234RecPrint4321____;
            ntb = ___tmp165;
         }
      } else {
         ntb = true;
      }
      ____writeable____node = ____writeable____node;
      ____writeable____node.GetKey();
      ___tmp171 = ____writeable____node.____1234GetKey4321____;
      System.out.println(___tmp171);
      ____writeable____node = ____writeable____node;
      ____writeable____node.GetHas_Right();
      ___tmp177 = ____writeable____node.____1234GetHas_Right4321____;
      if( ___tmp177 ){{
            ___tmp174 = this;
            ____writeable____node = ____writeable____node;
            ____writeable____node.GetRight();
            ___tmp175 = ____writeable____node.____1234GetRight4321____;
            ___tmp174.RecPrint(___tmp175);
            ___tmp173 = ___tmp174.____1234RecPrint4321____;
            ntb = ___tmp173;
         }
      } else {
         ntb = true;
      }
      ____1234RecPrint4321____ = true;
   }
   public void accept(Visitor v){
      int nti;
      Visitor ____writeable____v;
      int ___tmp179;

      ____writeable____v = v;
      System.out.println(333);
      ____writeable____v = ____writeable____v;
      ____writeable____v.visit(this);
      ___tmp179 = ____writeable____v.____1234visit4321____;
      nti = ___tmp179;
      ____1234accept4321____ = 0;
   }
}
class Visitor{
   Tree l;
   Tree r;
   int ____1234visit4321____;

   public void visit(Tree n){
      int nti;
      Tree ____writeable____n;
      Tree ___tmp181;
      int ___tmp183;
      boolean ___tmp185;
      Tree ___tmp187;
      int ___tmp189;
      boolean ___tmp191;

      ____writeable____n = n;
      ____writeable____n = ____writeable____n;
      ____writeable____n.GetHas_Right();
      ___tmp185 = ____writeable____n.____1234GetHas_Right4321____;
      if( ___tmp185 ){{
            ____writeable____n = ____writeable____n;
            ____writeable____n.GetRight();
            ___tmp181 = ____writeable____n.____1234GetRight4321____;
            r = ___tmp181;
            r = r;
            r.accept(this);
            ___tmp183 = r.____1234accept4321____;
            nti = ___tmp183;
         }
      } else {
         nti = 0;
      }
      ____writeable____n = ____writeable____n;
      ____writeable____n.GetHas_Left();
      ___tmp191 = ____writeable____n.____1234GetHas_Left4321____;
      if( ___tmp191 ){{
            ____writeable____n = ____writeable____n;
            ____writeable____n.GetLeft();
            ___tmp187 = ____writeable____n.____1234GetLeft4321____;
            l = ___tmp187;
            l = l;
            l.accept(this);
            ___tmp189 = l.____1234accept4321____;
            nti = ___tmp189;
         }
      } else {
         nti = 0;
      }
      ____1234visit4321____ = 0;
   }
}
class MyVisitor extends Visitor{

   public void visit(Tree n){
      int nti;
      Tree ____writeable____n;
      Tree ___tmp193;
      int ___tmp195;
      boolean ___tmp197;
      int ___tmp199;
      Tree ___tmp201;
      int ___tmp203;
      boolean ___tmp205;

      ____writeable____n = n;
      ____writeable____n = ____writeable____n;
      ____writeable____n.GetHas_Right();
      ___tmp197 = ____writeable____n.____1234GetHas_Right4321____;
      if( ___tmp197 ){{
            ____writeable____n = ____writeable____n;
            ____writeable____n.GetRight();
            ___tmp193 = ____writeable____n.____1234GetRight4321____;
            r = ___tmp193;
            r = r;
            r.accept(this);
            ___tmp195 = r.____1234accept4321____;
            nti = ___tmp195;
         }
      } else {
         nti = 0;
      }
      ____writeable____n = ____writeable____n;
      ____writeable____n.GetKey();
      ___tmp199 = ____writeable____n.____1234GetKey4321____;
      System.out.println(___tmp199);
      ____writeable____n = ____writeable____n;
      ____writeable____n.GetHas_Left();
      ___tmp205 = ____writeable____n.____1234GetHas_Left4321____;
      if( ___tmp205 ){{
            ____writeable____n = ____writeable____n;
            ____writeable____n.GetLeft();
            ___tmp201 = ____writeable____n.____1234GetLeft4321____;
            l = ___tmp201;
            l = l;
            l.accept(this);
            ___tmp203 = l.____1234accept4321____;
            nti = ___tmp203;
         }
      } else {
         nti = 0;
      }
      ____1234visit4321____ = 0;
   }
}

class ____NewMainClass____{

   public void ____Main____(int ____arg_length____){
      int ____printMe____;
      TV ___tmp208;
      int ___tmp207;

      ___tmp208 =
         new TV();
      ___tmp208.Start();
      ___tmp207 = ___tmp208.____1234Start4321____;
      ____printMe____ = ___tmp207;
      System.out.println(____printMe____);
   }
}
