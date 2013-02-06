class CallArguments {
	public static void main(String[] a) {
    	System.out.println(new CArgs().Start(10));
    }
}
    
class CArgs {
    	public int Start(int x) {
		int z;
		CArgs rc;
		CArgs rx;
		CArgs ry;
		rc = new CArgs();
		rx = new CArgs();
		ry = new CArgs();
		z = rc.foo(rx.bar(ry.fbar()));
		return z+x;	
    	}
    	
    	public int foo(int x){
    		return x + 20;
    	}
    	
    	public int bar(int x){
    		return x + 30;
    	}
    	
    	public int fbar(){
    		return 10;
    	}
}
