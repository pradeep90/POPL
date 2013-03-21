class MethodReturn {
	public static void main(String [] a){
	      new MRTest().____Main____();
	   }
}

class MRTest{
	int b;
	int a;
	boolean z;
	MRTest m1;
	public void ____Main____(){
		int x;
		z = true;
		m1 = new MRTest();
		m1.a = 10;
		m1.b = 20;
		m1.z = true;
		x = m1.a + m1.b;
		System.out.println(x);
		m1.foo(x);
		System.out.println(x);
		System.out.println(a);
		m1.bar(m1.z, m1.a, m1.b);
		if(z & m1.z)
			System.out.println((m1.a+m1.b));
		else
			System.out.println(9999);
	}
	
	public void foo(int y)
	{
		int x;
		x = y;
		x = x + 5;
		System.out.println(x);
		a = 5;
	}
	
	public void bar(boolean z1, int a1, int b1)
	{
		boolean z;
		int a; int b;

		z = z1; a = a1; b = b1;

		z = false;
		a = b+a;
		b = a*b;
	}
}
