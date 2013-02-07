
class RandomChecks {
	public static void main(String[] a) {
    	System.out.println(new Rchecks().Start());
    }
}
    
class Rchecks {
    public int Start() {
    	Rchecks yy;
    	Rchecks zz;
	int retVal;
    	yy = new Ychecks();
	zz = yy.Bar(); // calls Ychecks.Bar and returns an object of type Rchecks
    	return zz.Foo(); // returns 0
    }
    public Rchecks Bar(){
	    return null;
    }
    public int Foo(){
	    return 0;
    }
}

class Ychecks extends Rchecks{
	public int Foo(){
		return 15;
	}
	public Rchecks Bar(){
		int x;
		Rchecks rx;
		rx = new Rchecks();
		x = this.Foo();
		System.out.println(x);
		return rx;
	}
}
