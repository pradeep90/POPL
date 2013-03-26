class BinarySearch {
   public static void main(String [] a){
      new ____NewMainClass____().____Main____(0);
   }
}
class BS{
   int[] number;
   int size;
   int ____1234Start4321____;
   boolean ____1234Search4321____;
   int ____1234Div4321____;
   boolean ____1234Compare4321____;
   int ____1234Print4321____;
   int ____1234Init4321____;

    public void Start(int sz){
        int aux01;
        int aux02;
        int ____writeable____sz;
        BS ___tmp1;
        int ___tmp0;
        BS ___tmp3;
        int ___tmp2;
        BS ___tmp5;
        boolean ___tmp4;
        BS ___tmp7;
        boolean ___tmp6;
        BS ___tmp9;
        boolean ___tmp8;
        BS ___tmp11;
        boolean ___tmp10;
        BS ___tmp13;
        boolean ___tmp12;
        BS ___tmp15;
        boolean ___tmp14;
        BS ___tmp17;
        boolean ___tmp16;
        BS ___tmp19;
        boolean ___tmp18;

        ____writeable____sz = sz;
        ___tmp1 = this;
        ___tmp1.Init(____writeable____sz);
        ___tmp0 = ___tmp1.____1234Init4321____;
        aux01 = ___tmp0;
        ___tmp3 = this;
        ___tmp3.Print();
        ___tmp2 = ___tmp3.____1234Print4321____;
        aux02 = ___tmp2;
        ___tmp5 = this;
        ___tmp5.Search(8);
        ___tmp4 = ___tmp5.____1234Search4321____;
        if( ___tmp4 ){
            aux02 = 0;
            // System.out.println(1);
        } else {
            aux02 = 1;
            // System.out.println(0);
        }
        ___tmp7 = this;
        ___tmp7.Search(19);
        ___tmp6 = ___tmp7.____1234Search4321____;
        if( ___tmp6 ){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        ___tmp9 = this;
        ___tmp9.Search(20);
        ___tmp8 = ___tmp9.____1234Search4321____;
        if( ___tmp8 ){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        ___tmp11 = this;
        ___tmp11.Search(21);
        ___tmp10 = ___tmp11.____1234Search4321____;
        if( ___tmp10 ){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        ___tmp13 = this;
        ___tmp13.Search(37);
        ___tmp12 = ___tmp13.____1234Search4321____;
        if( ___tmp12 ){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        ___tmp15 = this;
        ___tmp15.Search(38);
        ___tmp14 = ___tmp15.____1234Search4321____;
        if( ___tmp14 ){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        ___tmp17 = this;
        ___tmp17.Search(39);
        ___tmp16 = ___tmp17.____1234Search4321____;
        if( ___tmp16 ){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        ___tmp19 = this;
        ___tmp19.Search(50);
        ___tmp18 = ___tmp19.____1234Search4321____;
        if( ___tmp18 ){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        ____1234Start4321____ = 999;
    }
   public void Search(int num){
      boolean bs01;
      int right;
      int left;
      boolean var_cont;
      int medium;
      int aux01;
      int nt;
      int ____writeable____num;
      int[] ___tmp20;
      BS ___tmp22;
      int ___tmp21;
      BS ___tmp24;
      boolean ___tmp23;
      BS ___tmp26;
      boolean ___tmp25;

      ____writeable____num = num;
      aux01 = 0;
      bs01 = false;
      ___tmp20 = number;
      right = ___tmp20.length;
      right = right-1;
      left = 0;
      var_cont = true;
      while ( var_cont ){{
               medium = left+right;
               ___tmp22 = this;
               ___tmp22.Div(medium);
               ___tmp21 = ___tmp22.____1234Div4321____;
               medium = ___tmp21;
               aux01 = number[medium];
               if( ____writeable____num<aux01 ){
                  right = medium-1;
               } else {
                  left = medium+1;
               }
               ___tmp24 = this;
               ___tmp24.Compare(aux01,____writeable____num);
               ___tmp23 = ___tmp24.____1234Compare4321____;
               if( ___tmp23 ){
                  var_cont = false;
               } else {
                  var_cont = true;
               }
               if( right<left ){
                  var_cont = false;
               } else {
                  nt = 0;
               }
            }
         }
      ___tmp26 = this;
      ___tmp26.Compare(aux01,____writeable____num);
      ___tmp25 = ___tmp26.____1234Compare4321____;
      if( ___tmp25 ){
         bs01 = true;
      } else {
         bs01 = false;
      }
      ____1234Search4321____ = bs01;
   }
   public void Div(int num){
      int count01;
      int count02;
      int aux03;
      int ____writeable____num;

      ____writeable____num = num;
      count01 = 0;
      count02 = 0;
      aux03 = ____writeable____num-1;
      while ( count02<aux03 ){{
               count01 = count01+1;
               count02 = count02+2;
            }
         }
      ____1234Div4321____ = count01;
   }
   public void Compare(int num1,
      int num2){
      boolean retval;
      int aux02;
      int ____writeable____num2;
      int ____writeable____num1;
      boolean ____tmp27;

      ____writeable____num1 = num1;
      ____writeable____num2 = num2;
      retval = false;
      aux02 = ____writeable____num2+1;
      if( ____writeable____num1<____writeable____num2 ){
         retval = false;
      } else {
         ____tmp27 = ____writeable____num1<aux02;
         if( !____tmp27 ){
            retval = false;
         } else {
            retval = true;
         }
      }
      ____1234Compare4321____ = retval;
   }
   public void Print(){
      int j;
      int ____tmp28;

      j = 1;
      ____tmp28 = size;
      while ( j<____tmp28 ){{
               System.out.println(number[j]);
               j = j+1;
            }
            ____tmp28 = size;
         }
      System.out.println(99999);
      ____1234Print4321____ = 0;
   }
   public void Init(int sz){
      int j;
      int k;
      int aux02;
      int aux01;
      int ____writeable____sz;
      int ____tmp29;

      ____writeable____sz = sz;
      size = ____writeable____sz;
      number =
         new int[____writeable____sz];
      j = 1;
      k = size+1;
      ____tmp29 = size;
      while ( j<____tmp29 ){{
               aux01 = 2*j;
               aux02 = k-3;
               number[j] = aux01+aux02;
               j = j+1;
               k = k-1;
            }
            ____tmp29 = size;
         }
      ____1234Init4321____ = 0;
   }
}
class ____NewMainClass____{

   public void ____Main____(int ____arg_length____){
      int ____printMe____;
      BS ___tmp31;
      int ___tmp30;

      ___tmp31 =
         new BS();
      ___tmp31.Start(20);
      ___tmp30 = ___tmp31.____1234Start4321____;
      ____printMe____ = ___tmp30;
      System.out.println(____printMe____);
   }
}
