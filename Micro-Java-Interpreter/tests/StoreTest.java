import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StoreTest{
    Store store;

    @Before
    public void setUp(){
        store = new Store();
    }
    
    @After
    public void tearDown(){
    }
    
    /**
     * Test method for {@link Store#Store()}.
     */
    @Test
    public final void testStore(){
        assertTrue(store.isEmpty()); 
    }

    /**
     * Test method for {@link Store#equals()}.
     */
    @Test
    public final void testEquals(){
        Store store2 = new Store();

        assertEquals(store, store2);
    }
}
