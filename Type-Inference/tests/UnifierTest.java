import java.util.Set;
import java.util.HashSet;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UnifierTest{
    Set<TypeEquation> equationSet;
    TypeEquation equation1;
    TypeEquation equation2;
    TypeEquation equation3;
    Unifier unifier;

    @Before
    public void setUp(){
        equationSet = new HashSet<TypeEquation>();
        equation1 = new TypeEquation(new IntType(), new IntType());
        equation2 = new TypeEquation(new IntType(), new UnknownType(0));
        equation3 = new TypeEquation(new BooleanType(), new UnknownType(1));
        equationSet.add(equation1);
        equationSet.add(equation2);
        equationSet.add(equation3);

        unifier = new Unifier(equationSet);
    }

    @After
    public void tearDown(){
    }

    /**
     * Test method for {@link Unifier#removeFromSet()}.
     */
    @Test
    public final void testRemoveFromSet(){
        unifier.removeFromSet(equationSet);
        assertEquals(2, equationSet.size());
        unifier.removeFromSet(equationSet);
        assertEquals(1, equationSet.size());
        unifier.removeFromSet(equationSet);
        assertEquals(0, equationSet.size());
    }

    /**
     * Test method for {@link Unifier#unify()}.
     */
    @Test
    public final void testUnify_basic(){
        assertEquals(true, unifier.unify());
        // System.out.println("unifier.unification: " + unifier.unification);
    }


    /**
     * Test method for {@link Unifier#unify()}.
     */
    @Test
    public final void testUnify_twoUnknownTypes(){
        unifier.equationSet.add(new TypeEquation(new UnknownType(2),
                                                 new UnknownType(3)));
        assertEquals(true, unifier.unify());
        // System.out.println("unifier.unification: " + unifier.unification);
    }

    /**
     * Test that unify() doesn't modify its input equation set.
     */
    @Test
    public final void testUnify_pure(){
        Set<TypeEquation> old = new HashSet<TypeEquation>(equationSet);
        assertTrue(!old.isEmpty());
        unifier.unify();
        assertTrue(!equationSet.isEmpty());
        assertEquals(old, equationSet);
    }
}
