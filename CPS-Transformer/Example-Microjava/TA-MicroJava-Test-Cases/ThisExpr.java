class ThisExpr {
	public static void main(String [] a){
	      new TETest().____Main____();
	   }
}

class TETest{
	public void ____Main____(){
		TFooBar fbs;
		fbs = new TFooBar();
		fbs.f1ex(10, true);
	}
}

class TFoo
{
	public void f1(int x){
		TFoo tmp;
		tmp = this;
		System.out.println(x);

		tmp.f2(3);
		
	}
	public void f2(int y){
		System.out.println(y+1);		
	}
}

class TBar extends TFoo
{
	public void f1x(int x, int[] arr){
		TBar tmp;
		arr[9] = x;
		System.out.println(arr[9]);

		tmp=this;
		tmp.f2(3);
	}
	public void f2(int y){
		System.out.println(y+2);		
	}
}

class TFooBar extends TBar
{
	int[] arr;
	public void f1ex(int z, boolean flag){
		TFooBar tx;
		tx = this;
		tx.f1(z);
		arr = new int[10];
		tx.f1x(z, arr);

		tx=this;
		tx.f2(3);

	}
	public void f2(int y){
		System.out.println(y+3);		
	}
}
