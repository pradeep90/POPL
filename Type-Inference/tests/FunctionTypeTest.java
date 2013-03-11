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
        paramTypes.add(new UnknownType());

        Type returnType = new IntType();

        System.out.println("FunctionType.getFunctionType(paramTypes, returnType): " + FunctionType.getFunctionType(paramTypes, returnType));
    }
}
