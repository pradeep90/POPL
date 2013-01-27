class BinaryTree {
   public static void main(String [] a){
      new ____NewMainClass____().____Main____(0);
   }
}
class BT{
   int ____1234Start4321____;

   public void Start(){
      Tree root;
      boolean ntb;
      int nti;
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
      boolean ___tmp20;
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
      root.Print();
      ___tmp6 = root.____1234Print4321____;
      ntb = ___tmp6;
      root = root;
      root.Insert(24);
      ___tmp8 = root.____1234Insert4321____;
      ntb = ___tmp8;
      root = root;
      root.Insert(4);
      ___tmp10 = root.____1234Insert4321____;
      ntb = ___tmp10;
      root = root;
      root.Insert(12);
      ___tmp12 = root.____1234Insert4321____;
      ntb = ___tmp12;
      root = root;
      root.Insert(20);
      ___tmp14 = root.____1234Insert4321____;
      ntb = ___tmp14;
      root = root;
      root.Insert(28);
      ___tmp16 = root.____1234Insert4321____;
      ntb = ___tmp16;
      root = root;
      root.Insert(14);
      ___tmp18 = root.____1234Insert4321____;
      ntb = ___tmp18;
      root = root;
      root.Print();
      ___tmp20 = root.____1234Print4321____;
      ntb = ___tmp20;
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
      boolean cont;
      int key_aux;
      Tree current_node;
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
      boolean is_root;
      int key_aux;
      boolean ntb;
      int ____writeable____v_key;
      int ___tmp59;
      Tree ___tmp61;
      boolean ___tmp63;
      Tree ___tmp65;
      boolean ___tmp67;
      Tree ___tmp70;
      boolean ___tmp69;
      boolean ____tmp71;
      boolean ___tmp72;
      boolean ____tmp74;
      boolean ___tmp75;
      Tree ___tmp78;
      boolean ___tmp77;

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
                           ___tmp72 = current_node.____1234GetHas_Right4321____;
                           ____tmp71 = !___tmp72;
                           current_node = current_node;
                           current_node.GetHas_Left();
                           ___tmp75 = current_node.____1234GetHas_Left4321____;
                           ____tmp74 = !___tmp75;
                           if( ____tmp71&____tmp74 ){
                              ntb = true;
                           } else {
                              ___tmp70 = this;
                              ___tmp70.Remove(parent_node,current_node);
                              ___tmp69 = ___tmp70.____1234Remove4321____;
                              ntb = ___tmp69;
                           }
                        } else {
                           ___tmp78 = this;
                           ___tmp78.Remove(parent_node,current_node);
                           ___tmp77 = ___tmp78.____1234Remove4321____;
                           ntb = ___tmp77;
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
      Tree ___tmp80;
      boolean ___tmp79;
      Tree ___tmp82;
      boolean ___tmp81;
      int ___tmp83;
      Tree ___tmp86;
      int ___tmp85;
      Tree ____tmp92;
      Tree ___tmp95;
      boolean ___tmp97;
      boolean ___tmp99;
      boolean ___tmp101;
      boolean ___tmp103;
      Tree ___tmp106;
      boolean ___tmp105;
      boolean ___tmp107;
      boolean ___tmp109;

      ____writeable____c_node = c_node;
      ____writeable____p_node = p_node;
      ____writeable____c_node = ____writeable____c_node;
      ____writeable____c_node.GetHas_Left();
      ___tmp109 = ____writeable____c_node.____1234GetHas_Left4321____;
      if( ___tmp109 ){
         ___tmp80 = this;
         ___tmp80.RemoveLeft(____writeable____p_node,____writeable____c_node);
         ___tmp79 = ___tmp80.____1234RemoveLeft4321____;
         ntb = ___tmp79;
      } else {
         ____writeable____c_node = ____writeable____c_node;
         ____writeable____c_node.GetHas_Right();
         ___tmp107 = ____writeable____c_node.____1234GetHas_Right4321____;
         if( ___tmp107 ){
            ___tmp82 = this;
            ___tmp82.RemoveRight(____writeable____p_node,____writeable____c_node);
            ___tmp81 = ___tmp82.____1234RemoveRight4321____;
            ntb = ___tmp81;
         } else {{
               ____writeable____c_node = ____writeable____c_node;
               ____writeable____c_node.GetKey();
               ___tmp83 = ____writeable____c_node.____1234GetKey4321____;
               auxkey1 = ___tmp83;
               ____writeable____p_node = ____writeable____p_node;
               ____writeable____p_node.GetLeft();
               ___tmp95 = ____writeable____p_node.____1234GetLeft4321____;
               ____tmp92 = ___tmp95;
               ___tmp86 = ____tmp92;
               ___tmp86.GetKey();
               ___tmp85 = ___tmp86.____1234GetKey4321____;
               auxkey2 = ___tmp85;
               ___tmp106 = this;
               ___tmp106.Compare(auxkey1,auxkey2);
               ___tmp105 = ___tmp106.____1234Compare4321____;
               if( ___tmp105 ){{
                     ____writeable____p_node = ____writeable____p_node;
                     ____writeable____p_node.SetLeft(my_null);
                     ___tmp97 = ____writeable____p_node.____1234SetLeft4321____;
                     ntb = ___tmp97;
                     ____writeable____p_node = ____writeable____p_node;
                     ____writeable____p_node.SetHas_Left(false);
                     ___tmp99 = ____writeable____p_node.____1234SetHas_Left4321____;
                     ntb = ___tmp99;
                  }
               } else {{
                     ____writeable____p_node = ____writeable____p_node;
                     ____writeable____p_node.SetRight(my_null);
                     ___tmp101 = ____writeable____p_node.____1234SetRight4321____;
                     ntb = ___tmp101;
                     ____writeable____p_node = ____writeable____p_node;
                     ____writeable____p_node.SetHas_Right(false);
                     ___tmp103 = ____writeable____p_node.____1234SetHas_Right4321____;
                     ntb = ___tmp103;
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
      boolean ___tmp111;
      boolean ___tmp113;
      Tree ___tmp116;
      int ___tmp115;
      Tree ____tmp122;
      Tree ___tmp125;
      Tree ___tmp127;
      boolean ___tmp129;
      boolean ___tmp131;

      ____writeable____c_node = c_node;
      ____writeable____p_node = p_node;
      ____writeable____c_node = ____writeable____c_node;
      ____writeable____c_node.GetHas_Right();
      ___tmp111 = ____writeable____c_node.____1234GetHas_Right4321____;
      while ( ___tmp111 ){{
               ____writeable____c_node = ____writeable____c_node;
               ____writeable____c_node = ____writeable____c_node;
               ____writeable____c_node.GetRight();
               ___tmp125 = ____writeable____c_node.____1234GetRight4321____;
               ____tmp122 = ___tmp125;
               ___tmp116 = ____tmp122;
               ___tmp116.GetKey();
               ___tmp115 = ___tmp116.____1234GetKey4321____;
               ____writeable____c_node.SetKey(___tmp115);
               ___tmp113 = ____writeable____c_node.____1234SetKey4321____;
               ntb = ___tmp113;
               ____writeable____p_node = ____writeable____c_node;
               ____writeable____c_node = ____writeable____c_node;
               ____writeable____c_node.GetRight();
               ___tmp127 = ____writeable____c_node.____1234GetRight4321____;
               ____writeable____c_node = ___tmp127;
            }
            ____writeable____c_node = ____writeable____c_node;
            ____writeable____c_node.GetHas_Right();
            ___tmp111 = ____writeable____c_node.____1234GetHas_Right4321____;
         }
      ____writeable____p_node = ____writeable____p_node;
      ____writeable____p_node.SetRight(my_null);
      ___tmp129 = ____writeable____p_node.____1234SetRight4321____;
      ntb = ___tmp129;
      ____writeable____p_node = ____writeable____p_node;
      ____writeable____p_node.SetHas_Right(false);
      ___tmp131 = ____writeable____p_node.____1234SetHas_Right4321____;
      ntb = ___tmp131;
      ____1234RemoveRight4321____ = true;
   }
   public void RemoveLeft(Tree p_node,
      Tree c_node){
      boolean ntb;
      Tree ____writeable____p_node;
      Tree ____writeable____c_node;
      boolean ___tmp133;
      boolean ___tmp135;
      Tree ___tmp138;
      int ___tmp137;
      Tree ____tmp144;
      Tree ___tmp147;
      Tree ___tmp149;
      boolean ___tmp151;
      boolean ___tmp153;

      ____writeable____c_node = c_node;
      ____writeable____p_node = p_node;
      ____writeable____c_node = ____writeable____c_node;
      ____writeable____c_node.GetHas_Left();
      ___tmp133 = ____writeable____c_node.____1234GetHas_Left4321____;
      while ( ___tmp133 ){{
               ____writeable____c_node = ____writeable____c_node;
               ____writeable____c_node = ____writeable____c_node;
               ____writeable____c_node.GetLeft();
               ___tmp147 = ____writeable____c_node.____1234GetLeft4321____;
               ____tmp144 = ___tmp147;
               ___tmp138 = ____tmp144;
               ___tmp138.GetKey();
               ___tmp137 = ___tmp138.____1234GetKey4321____;
               ____writeable____c_node.SetKey(___tmp137);
               ___tmp135 = ____writeable____c_node.____1234SetKey4321____;
               ntb = ___tmp135;
               ____writeable____p_node = ____writeable____c_node;
               ____writeable____c_node = ____writeable____c_node;
               ____writeable____c_node.GetLeft();
               ___tmp149 = ____writeable____c_node.____1234GetLeft4321____;
               ____writeable____c_node = ___tmp149;
            }
            ____writeable____c_node = ____writeable____c_node;
            ____writeable____c_node.GetHas_Left();
            ___tmp133 = ____writeable____c_node.____1234GetHas_Left4321____;
         }
      ____writeable____p_node = ____writeable____p_node;
      ____writeable____p_node.SetLeft(my_null);
      ___tmp151 = ____writeable____p_node.____1234SetLeft4321____;
      ntb = ___tmp151;
      ____writeable____p_node = ____writeable____p_node;
      ____writeable____p_node.SetHas_Left(false);
      ___tmp153 = ____writeable____p_node.____1234SetHas_Left4321____;
      ntb = ___tmp153;
      ____1234RemoveLeft4321____ = true;
   }
   public void Search(int v_key){
      boolean cont;
      int ifound;
      Tree current_node;
      int key_aux;
      int ____writeable____v_key;
      int ___tmp155;
      Tree ___tmp157;
      boolean ___tmp159;
      Tree ___tmp161;
      boolean ___tmp163;

      ____writeable____v_key = v_key;
      current_node = this;
      cont = true;
      ifound = 0;
      while ( cont ){{
               current_node = current_node;
               current_node.GetKey();
               ___tmp155 = current_node.____1234GetKey4321____;
               key_aux = ___tmp155;
               if( ____writeable____v_key<key_aux ){
                  current_node = current_node;
                  current_node.GetHas_Left();
                  ___tmp159 = current_node.____1234GetHas_Left4321____;
                  if( ___tmp159 ){
                     current_node = current_node;
                     current_node.GetLeft();
                     ___tmp157 = current_node.____1234GetLeft4321____;
                     current_node = ___tmp157;
                  } else {
                     cont = false;
                  }
               } else {
                  if( key_aux<____writeable____v_key ){
                     current_node = current_node;
                     current_node.GetHas_Right();
                     ___tmp163 = current_node.____1234GetHas_Right4321____;
                     if( ___tmp163 ){
                        current_node = current_node;
                        current_node.GetRight();
                        ___tmp161 = current_node.____1234GetRight4321____;
                        current_node = ___tmp161;
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
      Tree current_node;
      boolean ntb;
      Tree ___tmp166;
      boolean ___tmp165;

      current_node = this;
      ___tmp166 = this;
      ___tmp166.RecPrint(current_node);
      ___tmp165 = ___tmp166.____1234RecPrint4321____;
      ntb = ___tmp165;
      ____1234Print4321____ = true;
   }
   public void RecPrint(Tree node){
      boolean ntb;
      Tree ____writeable____node;
      Tree ___tmp168;
      boolean ___tmp167;
      Tree ___tmp169;
      boolean ___tmp171;
      int ___tmp173;
      Tree ___tmp176;
      boolean ___tmp175;
      Tree ___tmp177;
      boolean ___tmp179;

      ____writeable____node = node;
      ____writeable____node = ____writeable____node;
      ____writeable____node.GetHas_Left();
      ___tmp171 = ____writeable____node.____1234GetHas_Left4321____;
      if( ___tmp171 ){{
            ___tmp168 = this;
            ____writeable____node = ____writeable____node;
            ____writeable____node.GetLeft();
            ___tmp169 = ____writeable____node.____1234GetLeft4321____;
            ___tmp168.RecPrint(___tmp169);
            ___tmp167 = ___tmp168.____1234RecPrint4321____;
            ntb = ___tmp167;
         }
      } else {
         ntb = true;
      }
      ____writeable____node = ____writeable____node;
      ____writeable____node.GetKey();
      ___tmp173 = ____writeable____node.____1234GetKey4321____;
      System.out.println(___tmp173);
      ____writeable____node = ____writeable____node;
      ____writeable____node.GetHas_Right();
      ___tmp179 = ____writeable____node.____1234GetHas_Right4321____;
      if( ___tmp179 ){{
            ___tmp176 = this;
            ____writeable____node = ____writeable____node;
            ____writeable____node.GetRight();
            ___tmp177 = ____writeable____node.____1234GetRight4321____;
            ___tmp176.RecPrint(___tmp177);
            ___tmp175 = ___tmp176.____1234RecPrint4321____;
            ntb = ___tmp175;
         }
      } else {
         ntb = true;
      }
      ____1234RecPrint4321____ = true;
   }
}
class ____NewMainClass____{

   public void ____Main____(int ____arg_length____){
      int ____printMe____;
      BT ___tmp182;
      int ___tmp181;

      ___tmp182 =
         new BT();
      ___tmp182.Start();
      ___tmp181 = ___tmp182.____1234Start4321____;
      ____printMe____ = ___tmp181;
      System.out.println(____printMe____);
   }
}
