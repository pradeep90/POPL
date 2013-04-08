class SameVarName {
    public static void main(String [] a){
        new Foo().method1(0);
    }
}

class Bar {
    bool x;
    public void method1(int x, int y) {
        
    }

    public void method2(){
        x = true;
    }
}

class Foo {
    
    public void method1(bool y){
        
    }

    public void method2(SameVarName x, SameVarName y, bool z) {
        
    }

}
