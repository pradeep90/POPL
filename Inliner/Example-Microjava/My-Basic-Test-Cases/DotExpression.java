class DotExpression {
    public static void main(String [] a){
        new Foo().method1(0);
    }
}

class Bar {
    Foo x;
    public void method1(int x, int y) {
    }

    public void method2(){
    }
}

class Foo {
    
    public void method1(bool y){
        Bar a;
        a = new Bar();
        a.x = new Foo();
    }

    public void method2(DotExpression x, DotExpression y, bool z) {
        
    }

}
