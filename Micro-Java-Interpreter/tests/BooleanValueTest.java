import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BooleanValueTest{
    BooleanValue booleanValue1;
    BooleanValue booleanValue2;
    
    @Before
    public void setUp(){
        booleanValue1 = new BooleanValue(true);
        booleanValue2 = new BooleanValue(false);
    }
    
    @After
    public void tearDown(){
    }
    
    /**
     * Test method for {@link BooleanValue#equals()}.
     */
    @Test
    public final void testEquals(){
        assertFalse(booleanValue1.equals(booleanValue2));
        assertEquals(booleanValue1, booleanValue1);
        assertEquals(booleanValue1, new BooleanValue(true));

        Value value = new BooleanValue(true);
        assertEquals(booleanValue1, value);
    }

    /**
     * Test method for {@link BooleanValue#toString()}.
     */
    @Test
    public final void testToString(){
        assertEquals("true", booleanValue1.toString());
        assertEquals("false", booleanValue2.toString());
    }
}
