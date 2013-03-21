class WhileCheck {
	public static void main(String [] a){
	      new WCTest().____Main____();
	   }
}

class WCTest{
	int a;
	int b;
	public void ____Main____(){
		boolean check;
		a = 1;
		b = 100;
		check = false;
		while(a < b){
			a = a + 10;
			System.out.println(a);
		}
	}
}
