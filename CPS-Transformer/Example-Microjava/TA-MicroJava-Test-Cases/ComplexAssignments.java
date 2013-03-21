
class ComplexAssignments {
	public static void main(String [] a){
	      new CATest().____Main____();
	   }
}

class CATest{
	int b;
	int[] arr;
	public void ____Main____(){
		int a;
		int x;
		a = 10;
		b = 20;
		arr = new int[((a * b) + (b - a))];
		System.out.println(arr.length);
		x = arr.length - 1;
		System.out.println(arr[x]);

		arr[2] = (((a + b) * (b)));
		arr[0] = ((arr[2]) + ((arr[2]) + (a * b)));
		if(((arr[0]) < (arr[2])))
			arr[3] = ((arr[0]) - 3);
		else
			arr[3] = 5;
		System.out.println(arr[3]);
	}
}
