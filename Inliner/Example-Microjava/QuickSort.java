class QuickSort {
   public static void main(String [] a){
      new ____NewMainClass____().____Main____(0);
   }
}
class QS{
   int[] number;
   int size;
   int ____1234Start4321____;
   int ____1234Sort4321____;
   int ____1234Print4321____;
   int ____1234Init4321____;

   public void Start(int sz){
      int aux01;
      int ____writeable____sz;
      QS ___tmp1;
      int ___tmp0;
      QS ___tmp3;
      int ___tmp2;
      QS ___tmp5;
      int ___tmp4;
      QS ___tmp7;
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
      System.out.println(9999);
      aux01 = size-1;
      ___tmp5 = this;
      ___tmp5.Sort(0,aux01);
      ___tmp4 = ___tmp5.____1234Sort4321____;
      aux01 = ___tmp4;
      ___tmp7 = this;
      ___tmp7.Print();
      ___tmp6 = ___tmp7.____1234Print4321____;
      aux01 = ___tmp6;
      ____1234Start4321____ = 0;
   }

   public void Sort(int left,
      int right){
      int v;
      int i;
      int j;
      int nt;
      int t;
      boolean cont01;
      boolean cont02;
      int aux03;
      int ____writeable____right;
      int ____writeable____left;
      boolean ____tmp8;
      boolean ____tmp9;
      int ____tmp10;
      QS ___tmp12;
      int ___tmp11;
      QS ___tmp14;
      int ___tmp13;

      ____writeable____left = left;
      ____writeable____right = right;
      t = 0;
      if( ____writeable____left<____writeable____right ){{
            v = number[____writeable____right];
            i = ____writeable____left-1;
            j = ____writeable____right;
            cont01 = true;
            while ( cont01 ){
                {
                     cont02 = true;
                     while ( cont02 ){{
                              i = i+1;
                              aux03 = number[i];
                              ____tmp8 = aux03<v;
                              if( !____tmp8 ){
                                 cont02 = false;
                              } else {
                                 cont02 = true;
                              }
                           }
                        }
                     cont02 = true;
                     while ( cont02 ){{
                              j = j-1;
                              aux03 = number[j];
                              ____tmp9 = v<aux03;
                              if( !____tmp9 ){
                                 cont02 = false;
                              } else {
                                 cont02 = true;
                              }
                           }
                        }
                     t = number[i];
                     number[i] = number[j];
                     number[j] = t;
                     ____tmp10 = i+1;
                     if( j<____tmp10 ){
                        cont01 = false;
                     } else {
                        cont01 = true;
                     }

                  }
               }

            number[j] = number[i];
            number[i] = number[____writeable____right];
            number[____writeable____right] = t;
            ___tmp12 = this;

            ___tmp12.SortFoo(____writeable____left,i-1);

            ___tmp11 = ___tmp12.____1234Sort4321____;
            nt = ___tmp11;
            ___tmp14 = this;
            ___tmp14.Sort(i+1,____writeable____right);
            ___tmp13 = ___tmp14.____1234Sort4321____;
            nt = ___tmp13;
         }
      } else {
         nt = 0;
      }
      ____1234Sort4321____ = 0;
   }
   public void Print(){
      int j;
      int ____tmp15;

      j = 0;
      ____tmp15 = size;
      while ( j<____tmp15 ){{
               System.out.println(number[j]);
               j = j+1;
            }
            ____tmp15 = size;
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
      QS ___tmp17;
      int ___tmp16;

      ___tmp17 =
         new QS();
      ___tmp17.Start(10);
      ___tmp16 = ___tmp17.____1234Start4321____;
      ____printMe____ = ___tmp16;
      System.out.println(____printMe____);
   }
}
