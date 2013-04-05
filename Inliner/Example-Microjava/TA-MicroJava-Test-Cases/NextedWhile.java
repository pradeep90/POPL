class NextedWhile {
	public static void main(String [] a){
		new NWTest().____Main____();
		}
}

class NWTest{
	int a;
	int b;
	int c;
	int sum;
	public void ____Main____(){
		boolean check;
		NWTest nx;
		int i;
		nx = new NWTest();
		a = 1;
		i=0;
		c=0;
		b = 1000;
		check = true;
		while((a < b) & check){
			while(c < 5)
			{
				a = a * (a + 1);
				sum = sum + 999;
				c = c+1;
			}
			
			while((c < 10) & (4 < c))
			{
				while(i < 10)
				{
					nx.sum = nx.sum + 1;
					i = i+1;
				}
				c = c+1;
			}
			
			if(10 < c){
				check = false;
			}
			else
			{
				System.out.println(sum);
			}
		}
		System.out.println(nx.sum);
	}
}