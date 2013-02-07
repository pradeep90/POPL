class ReturnCalls {
	public static void main(String[] a) {
    	System.out.println(new Rcalls().Start(10));
    }
}
    
class Rcalls {
    	public int Start(int x) {
		int z;
		Rcalls rc;
		rc = new Rcalls();
		z = ((rc.foo()).bar()).fbar();
		return z+x;	
    	}
    	
    	public Rcalls foo(){
    		Rcalls rx;
    		rx = new Rcalls();
    		return rx;
    	}
    	
    	public Rcalls bar(){
    		Rcalls rx;
    		rx = new Rcalls();
    		return rx;
    	}
    	
    	public int fbar(){
    		return 10;
    	}
}
