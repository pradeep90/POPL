
class MainPrint {
    public static void main(String[] a) {
    	System.out.println(new Test().Start(10, true, 100));
    }
}
    
class Test {
    public int Start(int x, boolean value, int num) {
    	return x+num;
    }
}
