import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SymbolTest{
    Symbol s1;
    Symbol s2;
    Symbol s3;
    
    @Before
    public void setUp(){
        s1 = new Symbol("yo");
        s2 = new Symbol("yo");
        s3 = new Symbol("boyz");
        
    }
    
    @After
    public void tearDown(){
    }

    /**
     * Test method for {@link Symbol#compareTo()}.
     */
    @Test
    public final void testCompareTo(){
        assertTrue(s1.compareTo(s2) == 0); 
        assertTrue(s2.compareTo(s1) == 0); 
        assertTrue(s1.compareTo(s3) > 0); 
        assertTrue(s3.compareTo(s1) < 0); 
    }
}
