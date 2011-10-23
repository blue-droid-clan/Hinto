package clan.blue.droid.hinto.workspace;

import clan.blue.droid.hinto.atoms.user.UserDefinedData;
import clan.blue.droid.hinto.workspace.base.BaseWorkspace;

public interface Workspace extends UserDefinedData {
    
    public static final class Factory {
        public static Workspace create(String name) {
            return new BaseWorkspace(name);
        }
    }
}
