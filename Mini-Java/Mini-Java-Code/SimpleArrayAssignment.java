
class SimpleArrayAssignment {
    public static void main(String[] a) {
    	System.out.println(new SimpleTest().Start(10));
    }
}
    
class SimpleTest {
    public int Start(int x) {
    	int[] a;
    	a = new int[x];
    	a[0] = 5;
    	return a[0];
    }
}
