package clan.blue.droid.hinto.atoms.user;

import clan.blue.droid.common.util.DateTimeUtil;
import clan.blue.droid.common.util.StringUtils;
import junit.framework.TestCase;

public class UserDefinedDataTest extends TestCase {
    
    protected void setUp() throws Exception {
        super.setUp();
        userDefinedData = UserDefinedData.Factory.create(createDefaultName());
        assertNotNull(userDefinedData);
    }
    
    private String createDefaultName() {
        StringBuilder sb = new StringBuilder();

        String rightNow = DateTimeUtil.rightNowToDateStringFull();
        sb.append(String.format("%s[%s]", DEFAULT_NAME_PREFIX, rightNow));

        return sb.toString();
    }

    protected void tearDown() throws Exception {
        userDefinedData = null;
        super.tearDown();
    }
    
    public void testThatEachIdIsUnique() {
        UserDefinedData first = userDefinedData;
        UserDefinedData another = UserDefinedData.Factory.create(createDefaultName());
        assertNotNull(another);
        
        String firstId = first.getId();
        assertNotNull(firstId);
        
        String secondId = another.getId();
        assertNotNull(secondId);

        assertNotSame(firstId, secondId);
    }

    public void testGetName() {
        String name = userDefinedData.getName();
        assertTrue(StringUtils.isNotBlank(name));
    }

    public void testGetId() {
        String id = userDefinedData.getId();
        assertTrue(StringUtils.isNotBlank(id));
    }

    protected static final String DEFAULT_NAME_PREFIX = UserDefinedData.class.getSimpleName();
    private UserDefinedData userDefinedData;
}
