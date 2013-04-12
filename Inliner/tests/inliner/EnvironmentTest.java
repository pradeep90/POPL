package inliner;

import inliner.syntaxtree.*;
import inliner.visitor.*;

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
    String newName1;
    String newName2;
    String newName3;
    Binding binding1;
    Binding binding2;
    
    @Before
    public void setUp(){
        env = new Environment();
        binding1 = new Binding("oldName1", "newName1");
        binding2 = new Binding("oldName2", "newName2");
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

        assertEquals(env.lookup("oldName1"), "newName1");
        assertEquals(env.lookup("oldName2"), "newName2");

        Binding shadowBinding = new Binding("oldName1", "newName3");
        env.extend(shadowBinding);
        assertEquals(env.lookup("oldName1"), "newName3");
    }

    /**
     * Test method for {@link Environment#lookup()}.
     */
    @Test
    public final void testLookup(){
        env.bindingList = new LinkedList<Binding>();
        env.bindingList.add(binding1);
        env.bindingList.add(binding2);

        assertEquals(env.lookup("oldName1"), "newName1");
        assertEquals(env.lookup("oldName2"), "newName2");

        // TODO(spradeep): Test for absent binding
    }
}
