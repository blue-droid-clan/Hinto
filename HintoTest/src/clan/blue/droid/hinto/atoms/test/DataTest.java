package clan.blue.droid.hinto.atoms.test;

import junit.framework.TestCase;
import clan.blue.droid.common.util.DateTimeUtil;
import clan.blue.droid.common.util.StringUtils;
import clan.blue.droid.hinto.atoms.Data;
import clan.blue.droid.hinto.atoms.Link;
import clan.blue.droid.hinto.atoms.base.SystemAtomTypes;

public class DataTest extends TestCase {
    private Data data;
    
    protected void setUp() throws Exception {
        super.setUp();
        data = Data.Factory.create(VALUE_FIXTURE);
    }

    protected void tearDown() throws Exception {
        data = null;
        super.tearDown();
    }
    
    public void testGetDescription() {
        data.setDescription(DESCRIPTION_FIXTURE);
        String result = data.getDescription();
        assertEquals(DESCRIPTION_FIXTURE, result);
    }
    
    public void testGetType() {
        Object type = data.getType();
        assertNotNull(type);
        assertEquals(SystemAtomTypes.DataType, type);
    }
    
    public void createTimestamped() {
        Data timestampedData = Data.Factory.createTimestamped();
        assertNotNull(timestampedData);
        
        String value = timestampedData.getValue();
        assertNotNull(value);
        assertTrue(StringUtils.isNotBlank(value));
    }
    
    public void testGetValue() {
        String value = DateTimeUtil.rightNowToDateStringFull();
        data = Data.Factory.create(value);
        String result = data.getValue();
        assertEquals(value, result);
    }

    public void testGetNextDefaultsToLinkEnd() {
        Data next = data.getNext();
        assertNotNull(next);
        assertTrue(Link.Util.isLinkEnd(next));
    }

    private static final String VALUE_FIXTURE = "value_fixture";
    private static final String DESCRIPTION_FIXTURE = "description_fixture";
}
