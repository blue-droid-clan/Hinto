package clan.blue.droid.hinto.atoms.test;

import clan.blue.droid.hinto.atoms.Chain;
import clan.blue.droid.hinto.atoms.base.SystemAtomTypes;
import junit.framework.TestCase;

public class ChainTest extends TestCase {

    protected void setUp() throws Exception {
        super.setUp();
        chain = Chain.Factory.create();
        assertNotNull(chain);
    }

    protected void tearDown() throws Exception {
        chain = null;
        super.tearDown();
    }
    
    public void testGetType() {
        Object type = chain.getType();
        assertNotNull(type);
        assertEquals(SystemAtomTypes.ChainType, type);
    }
//
//    public void testPerform() {
//        fail("Not yet implemented");
//    }

    private Chain chain;
}
