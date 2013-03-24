class BlockTest1 {
    public static void main(String [] a){
        new ____NewMainClass____().____Main____(0);
    }
}
// class Fac{
//    int ____1234ComputeFac4321____;

//    public void ComputeFac(int num){
//       int num_aux;
//       int ____writeable____num;
//       int ____tmp0;
//       Fac ___tmp4;
//       int ___tmp3;

//       ____writeable____num = num;
//       if( ____writeable____num<1 ){
//          num_aux = 1;
//       } else {
//          ___tmp4 = this;
//          ___tmp4.ComputeFac(____writeable____num-1);
//          ___tmp3 = ___tmp4.____1234ComputeFac4321____;
//          ____tmp0 = ___tmp3;
//          num_aux = ____writeable____num*____tmp0;
//       }
//       ____1234ComputeFac4321____ = num_aux;
//    }
// }

class ____NewMainClass____{

    public void ____Main____(int ____arg_length____){
        int ____printMe____;
        // Fac ___tmp6;
        int ___tmp5;

        // ___tmp6 = new Fac();
        // ___tmp6.ComputeFac(10);
        // ___tmp5 = ___tmp6.____1234ComputeFac4321____;
        ____printMe____ = 5;
        System.out.println(____printMe____);
    }

    public void method2(int a, int b){
        int c;
        int d;
        Foo foo;
        c = a + b;
        foo.bar();
        c = a + 3;
        d = c + b;
    }

    public void method3(int a, int b){
        int c;
        int d;
        Foo foo;
        c = a + b;
        d = 4;
        foo.bar();
        c = 77;
        d = a + b;
        foo.baz();
    }

    public void method4(int a, int b){
        int c;
        boolean d;
        
        c = a + b;
        d = true;
    }

    public void method5(){
        int x;
        boolean y;
        // x = 3 + 5;
    }

    public void method6(int m, int n){
        System.out.println(m + n);
    }

    public void method7(){
        
    }

    public void methodNestedIfs(){
        if (x < 1){
            a = 4;
            if (y < 1){
                if (z < 2){
                    x = 101;
                } else {
                    x = 102;
                }
                b = 5;
            } else {
                c = 6;
            }
            d = 7;
        } else {
            e = 8;
            if (y < 100){
                f = 9;
            } else {
                g = 10;
            }
            h = 11;
        }
        i = 12;
    }

    public void methodFlattenBlock(){
        { x = y; }
        { { x = y; } }
        { x = y; foo.bar(3); }
        { {x = y; a = 4; } foo.bar(3); }
    }
}
