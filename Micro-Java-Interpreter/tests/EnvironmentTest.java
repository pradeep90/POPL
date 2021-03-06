import syntaxtree.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EnvironmentTest{
    Environment env;
    Identifier identifier1;
    Identifier identifier2;
    Value value1;
    Value value2;
    Value value3;
    Binding binding1;
    Binding binding2;
    
    @Before
    public void setUp(){
        env = new Environment();
        identifier1 = new Identifier(new NodeToken("name1"));
        identifier2 = new Identifier(new NodeToken("name2"));
        value1 = new IntegerValue(74);
        value2 = new IntegerValue(93);
        binding1 = new Binding("name1", value1);
        binding2 = new Binding("name2", value2);
    }
    
    @After
    public void tearDown(){
    }

    @Test
    public final void testEnvironment(){
        assertTrue(env.bindingList.isEmpty());
    }

    /**
     * Test method for {@link Environment#extend()}.
     */
    @Test
    public final void testExtend(){
        env.extend(binding1);
        env.extend(binding2);

        assertEquals(env.lookup("name1"), value1);
        assertEquals(env.lookup("name2"), value2);

        Binding shadowBinding = new Binding("name1", value3);
        env.extend(shadowBinding);
        assertEquals(env.lookup("name1"), value3);
    }

    /**
     * Test method for {@link Environment#lookup()}.
     */
    @Test
    public final void testLookup(){
        env.bindingList = new LinkedList<Binding>();
        env.bindingList.add(binding1);
        env.bindingList.add(binding2);

        assertEquals(env.lookup("name1"), value1);
        assertEquals(env.lookup("name2"), value2);

        // TODO(spradeep): Test for absent binding
    }
}
