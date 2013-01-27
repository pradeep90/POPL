class LinkedList {
   public static void main(String [] a){
      new ____NewMainClass____().____Main____(0);
   }
}
class Element{
   int Age;
   int Salary;
   boolean Married;
   boolean ____1234Init4321____;
   int ____1234GetAge4321____;
   int ____1234GetSalary4321____;
   boolean ____1234GetMarried4321____;
   boolean ____1234Equal4321____;
   boolean ____1234Compare4321____;

   public void Init(int v_Age,
      int v_Salary,
      boolean v_Married){
      int ____writeable____v_Age;
      boolean ____writeable____v_Married;
      int ____writeable____v_Salary;

      ____writeable____v_Salary = v_Salary;
      ____writeable____v_Married = v_Married;
      ____writeable____v_Age = v_Age;
      Age = ____writeable____v_Age;
      Salary = ____writeable____v_Salary;
      Married = ____writeable____v_Married;
      ____1234Init4321____ = true;
   }
   public void GetAge(){

      ____1234GetAge4321____ = Age;
   }
   public void GetSalary(){

      ____1234GetSalary4321____ = Salary;
   }
   public void GetMarried(){

      ____1234GetMarried4321____ = Married;
   }
   public void Equal(Element other){
      boolean ret_val;
      int aux01;
      int aux02;
      int nt;
      Element ____writeable____other;
      int ___tmp0;
      int ___tmp2;
      boolean ___tmp4;
      boolean ___tmp6;
      Element ___tmp9;
      boolean ___tmp8;
      Element ___tmp11;
      boolean ___tmp10;

      ____writeable____other = other;
      ret_val = true;
      ____writeable____other = ____writeable____other;
      ____writeable____other.GetAge();
      ___tmp0 = ____writeable____other.____1234GetAge4321____;
      aux01 = ___tmp0;
      ___tmp11 = this;
      ___tmp11.Compare(aux01,Age);
      ___tmp10 = ___tmp11.____1234Compare4321____;
      if( !___tmp10 ){
         ret_val = false;
      } else {{
            ____writeable____other = ____writeable____other;
            ____writeable____other.GetSalary();
            ___tmp2 = ____writeable____other.____1234GetSalary4321____;
            aux02 = ___tmp2;
            ___tmp9 = this;
            ___tmp9.Compare(aux02,Salary);
            ___tmp8 = ___tmp9.____1234Compare4321____;
            if( !___tmp8 ){
               ret_val = false;
            } else {
               if( Married ){
                  ____writeable____other = ____writeable____other;
                  ____writeable____other.GetMarried();
                  ___tmp4 = ____writeable____other.____1234GetMarried4321____;
                  if( !___tmp4 ){
                     ret_val = false;
                  } else {
                     nt = 0;
                  }
               } else {
                  ____writeable____other = ____writeable____other;
                  ____writeable____other.GetMarried();
                  ___tmp6 = ____writeable____other.____1234GetMarried4321____;
                  if( ___tmp6 ){
                     ret_val = false;
                  } else {
                     nt = 0;
                  }
               }
            }
         }
      }
      ____1234Equal4321____ = ret_val;
   }
   public void Compare(int num1,
      int num2){
      boolean retval;
      int aux02;
      int ____writeable____num2;
      int ____writeable____num1;
      boolean ____tmp12;

      ____writeable____num1 = num1;
      ____writeable____num2 = num2;
      retval = false;
      aux02 = ____writeable____num2+1;
      if( ____writeable____num1<____writeable____num2 ){
         retval = false;
      } else {
         ____tmp12 = ____writeable____num1<aux02;
         if( !____tmp12 ){
            retval = false;
         } else {
            retval = true;
         }
      }
      ____1234Compare4321____ = retval;
   }
}
class List{
   Element elem;
   List next;
   boolean end;
   boolean ____1234Init4321____;
   boolean ____1234InitNew4321____;
   List ____1234Insert4321____;
   boolean ____1234SetNext4321____;
   List ____1234Delete4321____;
   int ____1234Search4321____;
   boolean ____1234GetEnd4321____;
   Element ____1234GetElem4321____;
   List ____1234GetNext4321____;
   boolean ____1234Print4321____;

   public void Init(){

      end = true;
      ____1234Init4321____ = true;
   }
   public void InitNew(Element v_elem,
      List v_next,
      boolean v_end){
      boolean ____writeable____v_end;
      List ____writeable____v_next;
      Element ____writeable____v_elem;

      ____writeable____v_elem = v_elem;
      ____writeable____v_next = v_next;
      ____writeable____v_end = v_end;
      end = ____writeable____v_end;
      elem = ____writeable____v_elem;
      next = ____writeable____v_next;
      ____1234InitNew4321____ = true;
   }
   public void Insert(Element new_elem){
      boolean ret_val;
      List aux03;
      List aux02;
      Element ____writeable____new_elem;
      boolean ___tmp13;

      ____writeable____new_elem = new_elem;
      aux03 = this;
      aux02 =
         new List();
      aux02 = aux02;
      aux02.InitNew(____writeable____new_elem,aux03,false);
      ___tmp13 = aux02.____1234InitNew4321____;
      ret_val = ___tmp13;
      ____1234Insert4321____ = aux02;
   }
   public void SetNext(List v_next){
      List ____writeable____v_next;

      ____writeable____v_next = v_next;
      next = ____writeable____v_next;
      ____1234SetNext4321____ = true;
   }
   public void Delete(Element e){
      List my_head;
      boolean ret_val;
      boolean aux05;
      List aux01;
      List prev;
      boolean var_end;
      Element var_elem;
      int aux04;
      int nt;
      Element ____writeable____e;
      boolean ____tmp15;
      boolean ____tmp16;
      List ___tmp17;
      boolean ___tmp19;
      List ___tmp21;
      boolean ___tmp23;
      List ___tmp25;
      boolean ___tmp27;
      Element ___tmp29;

      ____writeable____e = e;
      my_head = this;
      ret_val = false;
      aux04 = 0-1;
      aux01 = this;
      prev = this;
      var_end = end;
      var_elem = elem;
      ____tmp15 = !var_end;
      ____tmp16 = !ret_val;
      while ( ____tmp15&____tmp16 ){{
               ____writeable____e = ____writeable____e;
               ____writeable____e.Equal(var_elem);
               ___tmp23 = ____writeable____e.____1234Equal4321____;
               if( ___tmp23 ){{
                     ret_val = true;
                     if( aux04<0 ){{
                           aux01 = aux01;
                           aux01.GetNext();
                           ___tmp17 = aux01.____1234GetNext4321____;
                           my_head = ___tmp17;
                        }
                     } else {{
                           System.out.println(0-555);
                           prev = prev;
                           aux01 = aux01;
                           aux01.GetNext();
                           ___tmp21 = aux01.____1234GetNext4321____;
                           prev.SetNext(___tmp21);
                           ___tmp19 = prev.____1234SetNext4321____;
                           aux05 = ___tmp19;
                           System.out.println(0-555);
                        }
                     }
                  }
               } else {
                  nt = 0;
               }
               if( !ret_val ){{
                     prev = aux01;
                     aux01 = aux01;
                     aux01.GetNext();
                     ___tmp25 = aux01.____1234GetNext4321____;
                     aux01 = ___tmp25;
                     aux01 = aux01;
                     aux01.GetEnd();
                     ___tmp27 = aux01.____1234GetEnd4321____;
                     var_end = ___tmp27;
                     aux01 = aux01;
                     aux01.GetElem();
                     ___tmp29 = aux01.____1234GetElem4321____;
                     var_elem = ___tmp29;
                     aux04 = 1;
                  }
               } else {
                  nt = 0;
               }
            }
            ____tmp15 = !var_end;
            ____tmp16 = !ret_val;
         }
      ____1234Delete4321____ = my_head;
   }
   public void Search(Element e){
      int int_ret_val;
      List aux01;
      Element var_elem;
      boolean var_end;
      int nt;
      Element ____writeable____e;
      boolean ___tmp31;
      List ___tmp33;
      boolean ___tmp35;
      Element ___tmp37;

      ____writeable____e = e;
      int_ret_val = 0;
      aux01 = this;
      var_end = end;
      var_elem = elem;
      while ( !var_end ){{
               ____writeable____e = ____writeable____e;
               ____writeable____e.Equal(var_elem);
               ___tmp31 = ____writeable____e.____1234Equal4321____;
               if( ___tmp31 ){{
                     int_ret_val = 1;
                  }
               } else {
                  nt = 0;
               }
               aux01 = aux01;
               aux01.GetNext();
               ___tmp33 = aux01.____1234GetNext4321____;
               aux01 = ___tmp33;
               aux01 = aux01;
               aux01.GetEnd();
               ___tmp35 = aux01.____1234GetEnd4321____;
               var_end = ___tmp35;
               aux01 = aux01;
               aux01.GetElem();
               ___tmp37 = aux01.____1234GetElem4321____;
               var_elem = ___tmp37;
            }
         }
      ____1234Search4321____ = int_ret_val;
   }
   public void GetEnd(){

      ____1234GetEnd4321____ = end;
   }
   public void GetElem(){

      ____1234GetElem4321____ = elem;
   }
   public void GetNext(){

      ____1234GetNext4321____ = next;
   }
   public void Print(){
      List aux01;
      boolean var_end;
      Element var_elem;
      int ___tmp39;
      List ___tmp41;
      boolean ___tmp43;
      Element ___tmp45;

      aux01 = this;
      var_end = end;
      var_elem = elem;
      while ( !var_end ){{
               var_elem = var_elem;
               var_elem.GetAge();
               ___tmp39 = var_elem.____1234GetAge4321____;
               System.out.println(___tmp39);
               aux01 = aux01;
               aux01.GetNext();
               ___tmp41 = aux01.____1234GetNext4321____;
               aux01 = ___tmp41;
               aux01 = aux01;
               aux01.GetEnd();
               ___tmp43 = aux01.____1234GetEnd4321____;
               var_end = ___tmp43;
               aux01 = aux01;
               aux01.GetElem();
               ___tmp45 = aux01.____1234GetElem4321____;
               var_elem = ___tmp45;
            }
         }
      ____1234Print4321____ = true;
   }
}
class LL{
   int ____1234Start4321____;

   public void Start(){
      List head;
      List last_elem;
      boolean aux01;
      Element el01;
      Element el02;
      Element el03;
      boolean ___tmp47;
      boolean ___tmp49;
      boolean ___tmp51;
      boolean ___tmp53;
      List ___tmp55;
      boolean ___tmp57;
      boolean ___tmp59;
      List ___tmp61;
      boolean ___tmp63;
      boolean ___tmp65;
      List ___tmp67;
      boolean ___tmp69;
      boolean ___tmp71;
      int ___tmp73;
      int ___tmp75;
      boolean ___tmp77;
      List ___tmp79;
      boolean ___tmp81;
      List ___tmp83;
      boolean ___tmp85;
      List ___tmp87;
      boolean ___tmp89;

      last_elem =
         new List();
      last_elem = last_elem;
      last_elem.Init();
      ___tmp47 = last_elem.____1234Init4321____;
      aux01 = ___tmp47;
      head = last_elem;
      head = head;
      head.Init();
      ___tmp49 = head.____1234Init4321____;
      aux01 = ___tmp49;
      head = head;
      head.Print();
      ___tmp51 = head.____1234Print4321____;
      aux01 = ___tmp51;
      el01 =
         new Element();
      el01 = el01;
      el01.Init(25,37000,false);
      ___tmp53 = el01.____1234Init4321____;
      aux01 = ___tmp53;
      head = head;
      head.Insert(el01);
      ___tmp55 = head.____1234Insert4321____;
      head = ___tmp55;
      head = head;
      head.Print();
      ___tmp57 = head.____1234Print4321____;
      aux01 = ___tmp57;
      System.out.println(10000000);
      el01 =
         new Element();
      el01 = el01;
      el01.Init(39,42000,true);
      ___tmp59 = el01.____1234Init4321____;
      aux01 = ___tmp59;
      el02 = el01;
      head = head;
      head.Insert(el01);
      ___tmp61 = head.____1234Insert4321____;
      head = ___tmp61;
      head = head;
      head.Print();
      ___tmp63 = head.____1234Print4321____;
      aux01 = ___tmp63;
      System.out.println(10000000);
      el01 =
         new Element();
      el01 = el01;
      el01.Init(22,34000,false);
      ___tmp65 = el01.____1234Init4321____;
      aux01 = ___tmp65;
      head = head;
      head.Insert(el01);
      ___tmp67 = head.____1234Insert4321____;
      head = ___tmp67;
      head = head;
      head.Print();
      ___tmp69 = head.____1234Print4321____;
      aux01 = ___tmp69;
      el03 =
         new Element();
      el03 = el03;
      el03.Init(27,34000,false);
      ___tmp71 = el03.____1234Init4321____;
      aux01 = ___tmp71;
      head = head;
      head.Search(el02);
      ___tmp73 = head.____1234Search4321____;
      System.out.println(___tmp73);
      head = head;
      head.Search(el03);
      ___tmp75 = head.____1234Search4321____;
      System.out.println(___tmp75);
      System.out.println(10000000);
      el01 =
         new Element();
      el01 = el01;
      el01.Init(28,35000,false);
      ___tmp77 = el01.____1234Init4321____;
      aux01 = ___tmp77;
      head = head;
      head.Insert(el01);
      ___tmp79 = head.____1234Insert4321____;
      head = ___tmp79;
      head = head;
      head.Print();
      ___tmp81 = head.____1234Print4321____;
      aux01 = ___tmp81;
      System.out.println(2220000);
      head = head;
      head.Delete(el02);
      ___tmp83 = head.____1234Delete4321____;
      head = ___tmp83;
      head = head;
      head.Print();
      ___tmp85 = head.____1234Print4321____;
      aux01 = ___tmp85;
      System.out.println(33300000);
      head = head;
      head.Delete(el01);
      ___tmp87 = head.____1234Delete4321____;
      head = ___tmp87;
      head = head;
      head.Print();
      ___tmp89 = head.____1234Print4321____;
      aux01 = ___tmp89;
      System.out.println(44440000);
      ____1234Start4321____ = 0;
   }
}
class ____NewMainClass____{

   public void ____Main____(int ____arg_length____){
      int ____printMe____;
      LL ___tmp92;
      int ___tmp91;

      ___tmp92 =
         new LL();
      ___tmp92.Start();
      ___tmp91 = ___tmp92.____1234Start4321____;
      ____printMe____ = ___tmp91;
      System.out.println(____printMe____);
   }
}
