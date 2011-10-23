package clan.blue.droid.hinto.atoms.base.user;

import java.util.UUID;

import clan.blue.droid.hinto.atoms.base.BaseData;
import clan.blue.droid.hinto.atoms.user.UserDefinedData;

public class BaseUserDefinedData extends BaseData implements UserDefinedData {

    public BaseUserDefinedData(String name) {
        super(name); // super(String) sets value to the given value
        this.name = name;
        uuid = UUID.randomUUID();
        id = uuid.toString();
    }
    
    // UserDefinedData functions
    @Override public String getName() { return name; }
    @Override public String getId() { return id.toString(); }
    
    private String name;
    private final String id;
    private final UUID uuid;
}
