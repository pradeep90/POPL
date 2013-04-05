class DotTest {
	public static void main(String [] a){
	      new DTTest().____Main____();
	   }
}

class DTTest{
	int a;
	int b;
	boolean flag;
	DTTest dt1;
	int[] arr;
	public void ____Main____(){
		DTTest obj;
		FooClass fc;
		dt1 = new DTTest();
		dt1.b = 10;
		dt1.a = dt1.b + dt1.b;
		fc = new FooClass();
		fc.foo(dt1.a);
		obj = new DTTest();
		obj.a = dt1.b;
		fc.foo(obj.a + dt1.a);
		dt1.flag = true;
		obj.flag = dt1.flag & true;
		fc.bar(obj.flag, dt1.a);
		obj.flag = !(obj.flag);
		fc.bar(obj.flag, dt1.a);
		arr = new int[20];
		arr[0] = dt1.b;
		fc.fbar(arr);
	}
}

class FooClass {
	public void foo(int a){
		System.out.println(a + 10);
	}
	
	public void bar(boolean x, int a){
		if(x)
			System.out.println(a);
		else
			System.out.println(15);
	}
	
	public void fbar(int[] arr){
		System.out.println(arr[0]);
	}
}
