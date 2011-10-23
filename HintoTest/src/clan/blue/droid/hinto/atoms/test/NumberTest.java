package clan.blue.droid.hinto.atoms.test;

import clan.blue.droid.hinto.atoms.Number;
import junit.framework.TestCase;

public class NumberTest extends TestCase {

    public void testGetValue() {
        Long numberValue = 42L;
        Number number = Number.Factory.create(numberValue);
        assertNotNull(number);
        String resultRaw = number.getValue();
        java.lang.Number result = Long.parseLong(resultRaw);
        assertEquals(numberValue, result);
    }
}
