
class WhileTest {
	public static void main(String[] a) {
    	System.out.println(new TestWhile().Start(10));
    }
}
    
class TestWhile {
	int c;
	int d;
    public int Start(int x) {
    	c = 5;
    	d = 14;
    	while(!(true & (c < d)))
    	{
    		if(true)
    		{
    			c = c + d;
    		}
    		else
    		{
    			d = c * d;
    		}
    	}
    	
    	return 15+c;
    }
}
