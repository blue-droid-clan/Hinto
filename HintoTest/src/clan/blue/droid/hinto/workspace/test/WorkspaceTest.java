package clan.blue.droid.hinto.workspace.test;

import clan.blue.droid.hinto.workspace.Workspace;
import junit.framework.TestCase;

public class WorkspaceTest extends TestCase {

    public void testFactoryCreate() {
        Workspace workspace = Workspace.Factory.create(NAME_FIXTURE);
        assertNotNull(workspace);
        
        String name = workspace.getName();
        assertEquals(NAME_FIXTURE, name);
    }

    private static final String NAME_FIXTURE = "name_fixture";
}
