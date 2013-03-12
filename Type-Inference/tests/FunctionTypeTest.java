import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FunctionTypeTest{
    @Before
    public void setUp(){
    }
    
    @After
    public void tearDown(){
    }

    /**
     * Test method for {@link FunctionType#getFunctionType()}.
     */
    @Test
    public final void testGetFunctionType(){
        List<Type> paramTypes = new ArrayList<Type>();
        paramTypes.add(new IntType());
        paramTypes.add(new BooleanType());
        paramTypes.add(new IntType());
        paramTypes.add(new UnknownType(0));

        Type returnType = new IntType();

        Type expected = new FunctionType(
            new IntType(),
            new FunctionType(new BooleanType(),
                             new FunctionType(new IntType(),
                                              new FunctionType(new UnknownType(0),
                                                               new IntType()))));

        assertEquals(expected,
                     FunctionType.getFunctionType(paramTypes, returnType));
    }
}
