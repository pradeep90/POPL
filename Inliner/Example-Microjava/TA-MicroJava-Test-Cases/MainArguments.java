
class MainArguments {
	public static void main(String [] a){
	      new MainTest().____Main____(10, true, 11);
	   }
}

class MainTest{
	public void ____Main____(int arg1, boolean flag, int arg2){
		int check;
		if(flag)
			check = arg1 + arg2;
		else
			check = arg1 * arg2;
		System.out.println(check);
	}
}