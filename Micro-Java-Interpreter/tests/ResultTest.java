import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ResultTest{
    Value value;
    Store store;
    Result result;

    @Before
    public void setUp(){
        value = new BooleanValue(true);
        store = new Store();
        result = new Result(value, store);
    }
    
    @After
    public void tearDown(){
    }
    
    /**
     * Test method for {@link Result#equals()}.
     */
    @Test
    public final void testEquals(){
        assertEquals(new Result(new BooleanValue(true), new Store()),
                     result);

        assertFalse(new Result(null, new Store()).equals(result));
        assertFalse(result.equals(new Result(null, new Store())));
    }
}
