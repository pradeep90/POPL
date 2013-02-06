import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LocationTest{
    Location location1;
    Location location2;

    @Before
    public void setUp(){
        location1 = new Location();
        location2 = new Location();
    }
    
    @After
    public void tearDown(){
    }

    /**
     * Test method for {@link Location#Location()}.
     */
    @Test
    public final void testLocation(){
        assertTrue(location1.index != location2.index); 
        Location foo = new Location(7);
        assertEquals(7, foo.index);
    }

    /**
     * Test method for {@link Location#equals()}.
     */
    @Test
    public final void testEquals(){
        assertEquals(location1, location1);
        assertFalse(location1.equals(location2));
    }
}
