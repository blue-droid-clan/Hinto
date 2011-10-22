package clan.blue.droid.hinto.atoms.user;

import clan.blue.droid.hinto.atoms.Data;
import clan.blue.droid.hinto.atoms.base.user.BaseUserDefinedData;

public interface UserDefinedData extends Data {
    public String getName();
    public String getId();
    
    public static final class Factory {
        public static UserDefinedData create(String name) {
            return new BaseUserDefinedData(name);
        }
    }
}
