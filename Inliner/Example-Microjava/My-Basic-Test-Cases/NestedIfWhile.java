class NestedIfWhile {
    public static void main(String [] a){
        new ____NewMainClass____().____Main____(0);
    }
}

class ____NewMainClass____{

    public void ____Main____(int ____arg_length____){
        int ____printMe____;
        int ___tmp5;
        int x;
        int y;

        ____printMe____ = 5;
        System.out.println(____printMe____);
    }

    public void nestedIfWhile(int a, int b){
        int x;
        int y;
        ____NewMainClass____ foo;
        
        foo = this;
        x = 7;
        if (2 < x){
            if( 1 < y){
                y = y - 1;
            }else{
                y = y + 1;
            }
            foo.nestedIfWhile(3, 4);
        } else {
            x = 4;
        }
        x = 3;
    }

    // public void nestedWhileIf(int a, int b){
    //     int x;
    //     int y;
    //     x = 7;
    //     while (2 < x){
    //         y = 3;
    //         if( 1 < y){
    //             y = y - 1;
    //         } else {
    //             y = 0;
    //         }
    //         x = x - 2;
    //     }
    // }
}
