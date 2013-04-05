class BubbleSort {
   public static void main(String [] a){
      new ____NewMainClass____().____Main____(0);
   }
}
class BBS{
   int[] number;
   int size;
   int ____1234Start4321____;
   int ____1234Sort4321____;
   int ____1234Print4321____;
   int ____1234Init4321____;

   public void Start(int sz){
      int aux01;
      int ____writeable____sz;
      BBS ___tmp1;
      int ___tmp0;
      BBS ___tmp3;
      int ___tmp2;
      BBS ___tmp5;
      int ___tmp4;
      BBS ___tmp7;
      int ___tmp6;

      ____writeable____sz = sz;
      ___tmp1 = this;
      ___tmp1.Init(____writeable____sz);
      ___tmp0 = ___tmp1.____1234Init4321____;
      aux01 = ___tmp0;
      ___tmp3 = this;
      ___tmp3.Print();
      ___tmp2 = ___tmp3.____1234Print4321____;
      aux01 = ___tmp2;
      System.out.println(99999);
      ___tmp5 = this;
      ___tmp5.Sort();
      ___tmp4 = ___tmp5.____1234Sort4321____;
      aux01 = ___tmp4;
      ___tmp7 = this;
      ___tmp7.Print();
      ___tmp6 = ___tmp7.____1234Print4321____;
      aux01 = ___tmp6;
      ____1234Start4321____ = 0;
   }
   public void Sort(){
      int nt;
      int i;
      int aux02;
      int aux04;
      int aux05;
      int aux06;
      int aux07;
      int j;
      int t;
      int ____tmp8;

      i = size-1;
      aux02 = 0-1;
      while ( aux02<i ){{
               j = 1;
               ____tmp8 = i+1;
               while ( j<____tmp8 ){{
                        aux07 = j-1;
                        aux04 = number[aux07];
                        aux05 = number[j];
                        if( aux05<aux04 ){{
                              aux06 = j-1;
                              t = number[aux06];
                              number[aux06] = number[j];
                              number[j] = t;
                           }
                        } else {
                           nt = 0;
                        }
                        j = j+1;
                     }
                     ____tmp8 = i+1;
                  }
               i = i-1;
            }
         }
      ____1234Sort4321____ = 0;
   }
   public void Print(){
      int j;
      int ____tmp9;

      j = 0;
      ____tmp9 = size;
      while ( j<____tmp9 ){{
               System.out.println(number[j]);
               j = j+1;
            }
            ____tmp9 = size;
         }
      ____1234Print4321____ = 0;
   }
   public void Init(int sz){
      int ____writeable____sz;

      ____writeable____sz = sz;
      size = ____writeable____sz;
      number =
         new int[____writeable____sz];
      number[0] = 20;
      number[1] = 7;
      number[2] = 12;
      number[3] = 18;
      number[4] = 2;
      number[5] = 11;
      number[6] = 6;
      number[7] = 9;
      number[8] = 19;
      number[9] = 5;
      ____1234Init4321____ = 0;
   }
}
class ____NewMainClass____{

   public void ____Main____(int ____arg_length____){
      int ____printMe____;
      BBS ___tmp11;
      int ___tmp10;

      ___tmp11 =
         new BBS();
      ___tmp11.Start(10);
      ___tmp10 = ___tmp11.____1234Start4321____;
      ____printMe____ = ___tmp10;
      System.out.println(____printMe____);
   }
}
