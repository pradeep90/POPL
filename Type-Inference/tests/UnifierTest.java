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
        equation2 = new TypeEquation(new IntType(), new UnknownType());
        equation3 = new TypeEquation(new BooleanType(), new UnknownType());
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
}
