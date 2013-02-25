import syntaxtree.*;
import visitor.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TermAutomatonCreatorTest{
    @Before
    public void setUp(){
    }
    
    @After
    public void tearDown(){
    }
    
    /**
     * Test method for {@link TermAutomatonCreator#Goal()}.
     */
    @Test
    public final void testGoal(){
        Node root = InterfaceHelper.getInterfaceNodeFromFile(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Structural-Subtyping/Example-Interfaces/pub0.java");
        System.out.println("InterfaceHelper.getFormattedString(root): " + InterfaceHelper.getFormattedString(root));
        root.accept(new TermAutomatonCreator(), null);
    }

    // TODO(spradeep): Test for a simple type Interface
    // TODO(spradeep): Test for a self-recursive Interface
    // TODO(spradeep): Test for mutually-recursive Interfaces
}
