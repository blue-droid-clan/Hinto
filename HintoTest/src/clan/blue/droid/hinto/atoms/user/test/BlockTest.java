package clan.blue.droid.hinto.atoms.user.test;

import junit.framework.TestCase;
import clan.blue.droid.common.util.StringUtils;
import clan.blue.droid.hinto.atoms.Data;
import clan.blue.droid.hinto.atoms.Function;
import clan.blue.droid.hinto.atoms.base.BaseFunction;
import clan.blue.droid.hinto.atoms.base.user.BaseBlock;
import clan.blue.droid.hinto.atoms.user.Block;

public class BlockTest extends TestCase {

    protected void setUp() throws Exception {
        super.setUp();
        adder = new Adder(Data.Converter.convertFrom(0L));
    }

    protected void tearDown() throws Exception {
        adder = null;
        super.tearDown();
    }
    
    public void testAppendStep() {
        Long origValue = 10L;
        Function stepOne = new IncrementBy(origValue.toString());
        
        Long incrementByValue = 5L;
        stepOne.attach(Data.Converter.convertFrom(incrementByValue));
        
        adder.appendStep(stepOne);
        Data numSteps = adder.getNumberOfSteps();
        assertNotNull(numSteps);
        
        Number numberOfSteps = Data.Converter.convertFrom(numSteps);
        assertNotNull(numberOfSteps);
    }
    
    public void testPerform() {
        
        Long value1 = 2L;
        Long value2 = 3L;
        Long expected = value1 + value2;
        
        Adder adder = new Adder(Data.Converter.convertFrom(value1));
        
        adder.attach(Data.Converter.convertFrom(value1));
        adder.attach(Data.Converter.convertFrom(value2));
        
        Data result = adder.perform(Data.Empty);
        assertNotNull(result);
        assertEquals(expected.toString(), result.getValue());
    }
    
//    public void testGetNumberOfSteps() {
//        fail("Not yet implemented");
//    }
    
    private static int convertFromDataToInt(Data data) {
        assertNotNull(data);
        
        String valueRaw = data.getValue();
        assertFalse(StringUtils.isBlank(valueRaw));
        
        Integer numberValue = Integer.parseInt(valueRaw);
        return numberValue.intValue();
    }

    private static final class Adder extends BaseBlock {
        
        @Override public Data perform(Data input) {
            Data firstData = getNext();
            assertNotNull(firstData);
            
            Number firstNumber = Data.Converter.convertFrom(firstData);
            assertNotNull(firstNumber);
            
            Data secondData = firstData.getNext();
            assertNotNull(secondData);
            
            Number secondNumber = Data.Converter.convertFrom(secondData);
            assertNotNull(secondNumber);
            
            int first = firstNumber.intValue();
            int second = secondNumber.intValue();
            int resultInt = first + second;
            Long result = new Long(resultInt);
            return Data.Converter.convertFrom(result);
        }
        
        public Adder(Data value) { super(value.toString()); }
    }
    
    // TODO: yeah, we'll wanna extract this out into its own file in the library
    private static final class IncrementBy extends BaseFunction {

        public IncrementBy(String value) { super(value); }
        
        @Override
        public Data perform(Data input) {
            assertNotNull(input);
            
            Data first = input;
            Data amount = input.getNext();
            assertNotNull(amount);
            
            int currentValue = convertFromDataToInt(first);
            int incrementAmount = convertFromDataToInt(amount);
            int newValue = currentValue + incrementAmount;
            Integer numberValue = Integer.valueOf(newValue);
            
            return Data.Factory.create(numberValue.toString());
        }
    }
    
    private Block adder;
}
