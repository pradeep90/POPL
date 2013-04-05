class MethodArgs {
	public static void main(String [] a){
	      new MATest().____Main____();
	   }
}

class MATest{
	MATest m1;
	int[] crr;
	public void ____Main____(){
		MATest mx;
		m1 = new MATest();
		mx = new MATest();
		m1.foo(12);
		m1.bar(true);
		m1.fooBar(mx);
		crr = new int[10];
		m1.complete(true, 10, crr, mx);
	}
	
	public void foo(int x)
	{
		int z;
		z = x + 5;
		System.out.println(z);
	}
	
	public void bar(boolean x){
		if(x)
		{
			m1 = new MATest();
			m1.foo(10);
		}
		else
		{
			m1.bar(false);
		}
	}
	
	public void fooBar(MATest ml){
		ml.bar(true);
	}
	
	public void BarFoo(int[] crr){
		int[] arr;
		arr = crr;
		arr[9] = 5;
		System.out.println(arr[9]);
	}
	
	public void complete(boolean z, int a, int[] brr, MATest ml)
	{
		int[] crr;
		if(z)
		{
			crr = brr;
			ml.BarFoo(crr);
		}
		
		else
		{
			crr = brr;
			crr[5] = ((crr[6]) + a);
			ml.bar(false);
		}
	}
}
