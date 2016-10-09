class NestedTest {
    public static void main(String [] a){
        new ____NewMainClass____().____Main____(0);
    }
}

class ____NewMainClass____{
    int ___fib;
    
    public void ____Main____(int ____arg_length____){
        // int i;
        // int j;
        // int sum;
    
        // i = 3;
        
        // if (i < 4){{
        //         sum = 4;
        //         if (2 < i){{
        //                 sum = 6;
        //             }
        //         } else {
        //             sum = 7;
        //         }
        //     }
        // } else{
        //     sum = 5;
        // }
        // System.out.println(sum);

        ____NewMainClass____ curr;
        curr = this;
        curr.fib(6);
        System.out.println(___fib);
    }

    public void fib(int n){
        int temp;
        ____NewMainClass____ curr;
        
        if (n < 3){
            ___fib = 1;
        } else {
            curr = this;
            curr.fib(n - 1);
            temp = ___fib;
            curr.fib(n - 2);
            ___fib = temp + ___fib;
        }
    }
}
