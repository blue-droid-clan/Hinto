package clan.blue.droid.hinto.atoms.test;

import junit.framework.TestCase;
import clan.blue.droid.hinto.atoms.Data;
import clan.blue.droid.hinto.atoms.Function;
import clan.blue.droid.hinto.atoms.base.SystemAtomTypes;

import com.google.android.testing.mocking.AndroidMock;
import com.google.android.testing.mocking.UsesMocks;

public class FunctionTest extends TestCase {

    protected void setUp() throws Exception {
        super.setUp();
        function = Function.Factory.create();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testGetType() {
        Object type = function.getType();
        assertNotNull(type);
        assertEquals(SystemAtomTypes.FunctionType, type);
    }
    
    public void testFactoryCreateReturnsNonNull() throws Exception {
        Function function = Function.Factory.create();
        assertNotNull(function);
    }
    
    public void testFactoryCreateFunctionReturnResultIsNonNull() throws Exception {
        Function function = Function.Factory.create();
        Data input = Data.Factory.createTimestamped();
        Data result = function.perform(input);
        assertNotNull(result);
    }

    @UsesMocks(Function.class)    
    public void testPerformUsingMock() throws Exception {
        Function mockFunction = AndroidMock.createMock(Function.class);
        Data data_fixture = Data.Factory.createTimestamped();
        
        AndroidMock.expect(mockFunction.perform(data_fixture)).andReturn(MOCK_FUNCTION_PERFORM_RETURN_VALUE);
        AndroidMock.replay(mockFunction);
        
        Data result = mockFunction.perform(data_fixture);
        assertEquals(MOCK_FUNCTION_PERFORM_RETURN_VALUE, result);
        
        AndroidMock.verify(mockFunction);
    }
    
    private static final Data MOCK_FUNCTION_PERFORM_RETURN_VALUE = Data.Factory.createTimestamped();
    private Function function;
}
