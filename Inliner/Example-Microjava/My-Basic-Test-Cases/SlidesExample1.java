class SlidesExample1 {
    public static void main(String [] a){
        new ____NewMainClass____().____Main____(0);
    }
}

class ____NewMainClass____{
    public void ____Main____(int ____arg_length____){
        A x;
        B y;
        
        int ____printMe____;
        ____printMe____ = 5;
        System.out.println(____printMe____);

        x = new A();
        y = new B();
        x.m(new Q());
        y.m(new S());
    }
}

class A{
    public void m (Q arg) {
        arg.p();
    }
}

class B extends A{
    public void m (Q arg) {}
}


class Q {
    public void p() {}
}

class S extends Q {
    public void p() {}
}
