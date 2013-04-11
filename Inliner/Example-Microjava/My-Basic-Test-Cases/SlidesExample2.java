class SlidesExample2 {
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

        // new A().m(new B()).m(new C());
    }
}

class A implements I {
    I x;

    public I m(I f) {
        x = new D();
        return f.m(x);
    }
}

class B implements I {
    public I m(I g) {
        return this;
    }
}
