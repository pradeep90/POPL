class Factorial {
   public static void main(String [] a){
      new ____NewMainClass____().____Main____(0);
   }
}
class Fac{
   int ____1234ComputeFac4321____;

   public void ComputeFac(int num){
      int num_aux;
      int ____writeable____num;
      int ____tmp0;
      Fac ___tmp4;
      int ___tmp3;

      ____writeable____num = num;
      if( ____writeable____num<1 ){
         num_aux = 1;
      } else {
         ___tmp4 = this;
         ___tmp4.ComputeFac(____writeable____num-1);
         ___tmp3 = ___tmp4.____1234ComputeFac4321____;
         ____tmp0 = ___tmp3;
         num_aux = ____writeable____num*____tmp0;
         // ___tmp4.ComputeFac(____writeable____num-1);
      }
      ____1234ComputeFac4321____ = num_aux;
   }
}

class ____NewMainClass____{

   public void ____Main____(int ____arg_length____){
      int ____printMe____;
      Fac ___tmp6;
      int ___tmp5;

      ___tmp6 =
         new Fac();
      ___tmp6.ComputeFac(10);
      ___tmp5 = ___tmp6.____1234ComputeFac4321____;
      ____printMe____ = ___tmp5;
      System.out.println(____printMe____);
   }
}
