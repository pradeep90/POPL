
class MethodReturnMore {
	public static void main(String[] a) {
    	System.out.println(new Test3().Start(10));
    }
}
    
class Test3 {
    public int Start(int x) {
    	int y;
    	Test3 t1;
    	boolean flag;
    	t1 = new Test3();
    	flag = t1.BoolRet(x);
    	t1 = t1.Identifieer(flag);

    	y = t1.MessageSendIden(10);
    	y = t1.Allocation(y);
    	y = t1.ThisRet(y);
    	return 20+y;
    }
    
    public int MessageSendIden(int x){
    	Test3 t1;
    	t1 = new Test3();
    	return (t1.Foo(x));
    }
    
    public Test3 Identifieer(boolean x){ // x is unused.
    	Test3 t1;
    	t1 = new Test3();
    	return t1;
    }
    
    public boolean BoolRet(int x){ // x is unused.
    	boolean bol;
    	bol = true;
    	return bol;
    }
    
    public int Allocation(int x){
    	return (new Test3().Foo(x));
    }
    
    public int ThisRet(int x){
    	return this.Foo(x);
    }
    
    public int Foo(int x){
    	return x;
    }
    
}
