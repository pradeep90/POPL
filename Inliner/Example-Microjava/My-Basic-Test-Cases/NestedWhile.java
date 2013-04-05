class NestedTest {
    public static void main(String [] a){
        new ____NewMainClass____().____Main____(0);
    }
}

class ____NewMainClass____{

    public void ____Main____(int ____arg_length____){
        int ____printMe____;
        int ___tmp5;

        ____printMe____ = 5;
        System.out.println(____printMe____);
    }

    public void nestedWhile(int a, int b){
        int x;
        int y;
        x = 7;
        while (2 < x){
            y = 3;
            while( 1 < y){
                y = y - 1;
            }
            x = x - 2;
        }
    }

    public void nestedEvilWhile(int c, int d){
        int x;
        int y;
        x = 7;
        while (2 < x){{
                y = 3;
                while( 1 < y){{
                    
                        y = y - 1;
                    }
                }
                x = x - 2;
            }
        }
    }
}
