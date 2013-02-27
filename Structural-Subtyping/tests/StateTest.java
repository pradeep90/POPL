import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StateTest{
    State state1;
    State state2;
    State state3;
    State state4;
    State state5;

    @Before
    public void setUp(){
        state1 = new State("Yo", "Yo", true);
        state2 = new State("Yo", "Yo", true);
        state3 = new State("Yo", "Yo", false);
        state4 = new State("Boyz", "Boyz");
        state5 = new State("Yo", "Yo");
    }
    
    @After
    public void tearDown(){
    }
    
    /**
     * Test method for {@link State#equals()}.
     */
    @Test
    public final void testEquals(){
        assertTrue(state1.equals(state2)); 
        assertFalse(state1.equals(state3)); 
        assertFalse(state1.equals(state4)); 
        assertTrue(state3.equals(state5)); 
    }

    /**
     * Test method for {@link State#hashCode()}.
     */
    @Test
    public final void testHashCode(){
        assertEquals(4101, "Yo".hashCode() + new Boolean(true).hashCode());
    }

    /**
     * Test method for {@link State#compareTo()}.
     */
    @Test
    public final void testCompareTo(){
        assertTrue(state1.compareTo(state4) > 0); 
        assertTrue(state4.compareTo(state1) < 0); 

        assertTrue(state1.compareTo(state2) == 0); 
        assertTrue(state2.compareTo(state1) == 0); 
    }
}
