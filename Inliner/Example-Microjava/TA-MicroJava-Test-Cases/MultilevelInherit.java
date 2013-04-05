class MultilevelInherit {
	public static void main(String [] a){
	      new MITest().____Main____();
	   }
}

class MITest{
	public void ____Main____(){
		Foo obj;
		FooBar fbs;
		int[] arr;
		obj = new FooBar();
		obj.f1(10);
		obj = new Foo();
		obj.f1(20);
		obj = new FooBar();
		obj.f1(30);
	}
}

class Foo
{
	public void f1(int x){
		System.out.println(x+2);
	}
}

class Bar extends Foo
{
	public void f1(int y){
		System.out.println(y+1);
	}
}

class FooBar extends Bar
{
	public void f1(int z){
		System.out.println(z+3);
	}
}
