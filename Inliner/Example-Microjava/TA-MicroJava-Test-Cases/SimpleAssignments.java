
class SimpleAssignments {
	public static void main(String [] a){
	      new SATest().____Main____();
	   }
}

class SATest{
	int b;
	boolean y;
	public void ____Main____(){
		int a;
		boolean x;
		boolean z;
		a = 10;
		b = 20;
		a = a + b;
		a = a * b;
		a = a - b;
		x = a < b;
		y = true;
		z = false;
		z = y & x;
		if(z)
			a = a + b;
		else
			a = b;
		System.out.println(a);
	}
}
