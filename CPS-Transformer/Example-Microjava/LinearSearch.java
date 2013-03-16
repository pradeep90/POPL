class LinearSearch {
   public static void main(String [] a){
      new ____NewMainClass____().____Main____(0);
   }
}
class LS{
   int[] number;
   int size;
   int ____1234Start4321____;
   int ____1234Print4321____;
   int ____1234Search4321____;
   int ____1234Init4321____;

   public void Start(int sz){
      int aux01;
      int aux02;
      int ____writeable____sz;
      LS ___tmp1;
      int ___tmp0;
      LS ___tmp3;
      int ___tmp2;
      LS ___tmp5;
      int ___tmp4;
      LS ___tmp7;
      int ___tmp6;
      LS ___tmp9;
      int ___tmp8;
      LS ___tmp11;
      int ___tmp10;

      ____writeable____sz = sz;
      ___tmp1 = this;
      ___tmp1.Init(____writeable____sz);
      ___tmp0 = ___tmp1.____1234Init4321____;
      aux01 = ___tmp0;
      ___tmp3 = this;
      ___tmp3.Print();
      ___tmp2 = ___tmp3.____1234Print4321____;
      aux02 = ___tmp2;
      System.out.println(9999);
      ___tmp5 = this;
      ___tmp5.Search(8);
      ___tmp4 = ___tmp5.____1234Search4321____;
      System.out.println(___tmp4);
      ___tmp7 = this;
      ___tmp7.Search(12);
      ___tmp6 = ___tmp7.____1234Search4321____;
      System.out.println(___tmp6);
      ___tmp9 = this;
      ___tmp9.Search(17);
      ___tmp8 = ___tmp9.____1234Search4321____;
      System.out.println(___tmp8);
      ___tmp11 = this;
      ___tmp11.Search(50);
      ___tmp10 = ___tmp11.____1234Search4321____;
      System.out.println(___tmp10);
      ____1234Start4321____ = 55;
   }
   public void Print(){
      int j;
      int ____tmp12;

      j = 1;
      ____tmp12 = size;
      while ( j<____tmp12 ){{
               System.out.println(number[j]);
               j = j+1;
            }
            ____tmp12 = size;
         }
      ____1234Print4321____ = 0;
   }
   public void Search(int num){
      int j;
      boolean ls01;
      int ifound;
      int aux01;
      int aux02;
      int nt;
      int ____writeable____num;
      int ____tmp13;
      boolean ____tmp14;

      ____writeable____num = num;
      j = 1;
      ls01 = false;
      ifound = 0;
      ____tmp13 = size;
      while ( j<____tmp13 ){{
               aux01 = number[j];
               aux02 = ____writeable____num+1;
               if( aux01<____writeable____num ){
                  nt = 0;
               } else {
                  ____tmp14 = aux01<aux02;
                  if( !____tmp14 ){
                     nt = 0;
                  } else {{
                        ls01 = true;
                        ifound = 1;
                        j = size;
                     }
                  }
               }
               j = j+1;
            }
            ____tmp13 = size;
         }
      ____1234Search4321____ = ifound;
   }
   public void Init(int sz){
      int j;
      int k;
      int aux01;
      int aux02;
      int ____writeable____sz;
      int ____tmp15;

      ____writeable____sz = sz;
      size = ____writeable____sz;
      number =
         new int[____writeable____sz];
      j = 1;
      k = size+1;
      ____tmp15 = size;
      while ( j<____tmp15 ){{
               aux01 = 2*j;
               aux02 = k-3;
               number[j] = aux01+aux02;
               j = j+1;
               k = k-1;
            }
            ____tmp15 = size;
         }
      ____1234Init4321____ = 0;
   }
}
class ____NewMainClass____{

   public void ____Main____(int ____arg_length____){
      int ____printMe____;
      LS ___tmp17;
      int ___tmp16;

      ___tmp17 =
         new LS();
      ___tmp17.Start(10);
      ___tmp16 = ___tmp17.____1234Start4321____;
      ____printMe____ = ___tmp16;
      System.out.println(____printMe____);
   }
}
