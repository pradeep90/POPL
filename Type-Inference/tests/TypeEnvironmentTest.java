import syntaxtree.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TypeEnvironmentTest{
    TypeEnvironment env;
    Identifier identifier1;
    Identifier identifier2;
    Type type1;
    Type type2;
    Type type3;
    Binding binding1;
    Binding binding2;
    
    @Before
    public void setUp(){
        env = new TypeEnvironment();
        identifier1 = new Identifier(new NodeToken("name1"));
        identifier2 = new Identifier(new NodeToken("name2"));
        type1 = new IntType();
        type2 = new IntType();
        binding1 = new Binding("name1", type1);
        binding2 = new Binding("name2", type2);
    }
    
    @After
    public void tearDown(){
    }

    @Test
    public final void testTypeEnvironment(){
        assertTrue(env.bindingList.isEmpty());
    }

    /**
     * Test method for {@link TypeEnvironment#extend()}.
     */
    @Test
    public final void testExtend(){
        env.extend(binding1);
        env.extend(binding2);

        assertEquals(env.lookup("name1"), type1);
        assertEquals(env.lookup("name2"), type2);

        Binding shadowBinding = new Binding("name1", type3);
        env.extend(shadowBinding);
        assertEquals(env.lookup("name1"), type3);
    }

    /**
     * Test method for {@link TypeEnvironment#lookup()}.
     */
    @Test
    public final void testLookup(){
        env.bindingList = new LinkedList<Binding>();
        env.bindingList.add(binding1);
        env.bindingList.add(binding2);

        assertEquals(env.lookup("name1"), type1);
        assertEquals(env.lookup("name2"), type2);

        // TODO(spradeep): Test for absent binding
    }
}
