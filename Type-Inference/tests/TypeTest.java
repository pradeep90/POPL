import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TypeTest{
    @Before
    public void setUp(){
    }
    
    @After
    public void tearDown(){
    }
    
    /**
     * Test method for {@link FunctionType#runMultiMethod()}.
     */
    @Test
    public final void testRunMultiMethod(){
        IntType intType = new IntType();
        BooleanType booleanType = new BooleanType();
        FunctionType functionType = new FunctionType(new IntType(), new IntType());
        UnknownType unknownType = new UnknownType(0);

        // TripleDVisitor visitor = new TripleDVisitor();
        
        // Type.runMultiMethod(visitor, intType, intType);
        // Type.runMultiMethod(visitor, intType, booleanType);
        // Type.runMultiMethod(visitor, intType, functionType);
        // Type.runMultiMethod(visitor, intType, unknownType);
        // Type.runMultiMethod(visitor, booleanType, intType);
        // Type.runMultiMethod(visitor, booleanType, booleanType);
        // Type.runMultiMethod(visitor, booleanType, functionType);
        // Type.runMultiMethod(visitor, booleanType, unknownType);
        // Type.runMultiMethod(visitor, functionType, intType);
        // Type.runMultiMethod(visitor, functionType, booleanType);
        // Type.runMultiMethod(visitor, functionType, functionType);
        // Type.runMultiMethod(visitor, functionType, unknownType);
        // Type.runMultiMethod(visitor, unknownType, intType);
        // Type.runMultiMethod(visitor, unknownType, booleanType);
        // Type.runMultiMethod(visitor, unknownType, functionType);
        // Type.runMultiMethod(visitor, unknownType, unknownType);
    }
}
