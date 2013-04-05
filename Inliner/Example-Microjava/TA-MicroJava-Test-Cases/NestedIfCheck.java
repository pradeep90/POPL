class NestedIfCheck {
	public static void main(String [] a){
	      new NICTest().____Main____();
	   }
}

class NICTest{
	int a;
	int b;
	public void ____Main____(){
		boolean check;
		a = 1;
		b = 100;
		check = false;
		if(!(check))
		{
			if(b < a)
			{
				a = a * 100;
			}
			else
			{
				a = a * (a + 1);
				if(a < b)
				{
					a = a * (a + 1);	
				}
				else
				{
					a = a + 999; 
				}
			}	
			a = a * (a + 1);
		}
		else
		{
			a = b;
		}
		System.out.println(a);
	}
}