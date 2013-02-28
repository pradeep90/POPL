import syntaxtree.*;
import visitor.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProductAutomatonTest{
    @Before
    public void setUp(){
    }
    
    @After
    public void tearDown(){
    }
    
    /**
     * Test method for {@link ProductAutomaton#ProductAutomaton()}.
     */
    @Test
    public final void testProductAutomaton(){
        Node root = InterfaceHelper.getInterfaceNodeFromFile(
            "/home/pradeep/Dropbox/Acads/POPL/Code/Structural-Subtyping/Example-Interfaces/pub4.java");

        TermAutomatonCreator termAutomatonCreator = new TermAutomatonCreator();
        root.accept(termAutomatonCreator, null);

        // System.out.println("termAutomatonCreator.finalAutomatonHashTable.get(A): " + termAutomatonCreator.finalAutomatonHashTable.get("A"));
        // System.out.println("termAutomatonCreator.finalAutomatonHashTable.get(B): " + termAutomatonCreator.finalAutomatonHashTable.get("B"));
         
        // VVIP: Here, A is the super-class. So, we make a
        // ProductAutomaton(B, A) not (A, B)
        ProductAutomaton productAutomaton = new ProductAutomaton(
            termAutomatonCreator.finalAutomatonHashTable.get("B"),
            termAutomatonCreator.finalAutomatonHashTable.get("A"));
        // System.out.println("productAutomaton: " + productAutomaton);
    }
}
