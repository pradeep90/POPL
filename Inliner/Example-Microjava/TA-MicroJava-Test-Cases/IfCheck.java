class IfCheck {
	public static void main(String [] a){
	      new ICTest().____Main____();
	   }
}

class ICTest{
	int a;
	int b;
	public void ____Main____(){
		boolean check;
		a = 1;
		b = 100;
		check = false;
		if(!(check))
		{
			a = a * (a + 1);
		}
		else
		{
			a = b;
		}
		
		if(b < a)
		{
			a = a + 999;
		}
		else
		{
			a = a * (a + 1); 
		}
		System.out.println(a);
	}
}