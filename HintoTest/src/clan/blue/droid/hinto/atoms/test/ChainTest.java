package clan.blue.droid.hinto.atoms.test;

import clan.blue.droid.common.util.StringUtils;
import clan.blue.droid.hinto.atoms.Chain;
import clan.blue.droid.hinto.atoms.Data;
import clan.blue.droid.hinto.atoms.Link;
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
    
    public void testAppend() throws Exception {
        Data one = Data.Factory.create(ONE.toString());
        chain.attach(one);
        
        Data next = one.getNext();
        assertNotNull(next);
        assertTrue(Link.Util.isLinkEnd(next));
        
        Data two = Data.Factory.create(TWO.toString());
        chain.attach(two);next = one.getNext();
        assertNotNull(next);
        assertFalse(Link.Util.isLinkEnd(next));
        assertEquals(two, next);
    }
    
    public void testGetNumberOfLinks() throws Exception {
        Data one = Data.Factory.create(ONE.toString());
        chain.attach(one);
        Data result = chain.getNumberOfLinksInChain();
        assertNotNull(result);
        
        String numLinksStr = result.getValue();
        assertFalse(StringUtils.isBlank(numLinksStr));
        assertEquals(ONE.toString(), numLinksStr.toString());
        
        Data two = Data.Factory.create(TWO.toString());
        chain.attach(two);
        result = chain.getNumberOfLinksInChain();
        numLinksStr = result.getValue();
        assertFalse(StringUtils.isBlank(numLinksStr));
        assertEquals(TWO.toString(), numLinksStr.toString());
        
        Data three = Data.Factory.create(THREE.toString());
        chain.attach(three);
        result = chain.getNumberOfLinksInChain();
        numLinksStr = result.getValue();
        assertFalse(StringUtils.isBlank(numLinksStr));
        assertEquals(THREE.toString(), numLinksStr.toString());
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

    private static final Integer ONE = new Integer(1);
    private static final Integer TWO = new Integer(2);
    private static final Integer THREE = new Integer(3);
    private Chain chain;
}
