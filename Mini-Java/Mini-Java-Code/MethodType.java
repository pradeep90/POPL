
class MethodType {
    public static void main(String[] a) {
    	System.out.println(new Foo().Start(10));
    }
}
    
class Foo {
    public int Start(int x) {
    	int[] y;
    	boolean flag;
    	Foo f1;
    	f1 = new Foo();
    	flag = f1.Go();
    	f1 = f1.Stop(flag);
    	y = f1.Run();
    	return (20+(y[0]));
    }
    
    public int[] Run(){
    	int[] a;
    	a = new int[10];
	a[0] = 4;
    	return a;
    }
    
    public boolean Go(){
    	return true;
    }
    
    public Foo Stop(boolean flag){
    	Foo f1;
	if (flag)
    		f1 = new Foo();
	else
		f1 = null;
    	return f1;
    }
    
}
