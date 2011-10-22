package clan.blue.droid.hinto.atoms.base;

import clan.blue.droid.common.util.StringUtils;
import clan.blue.droid.hinto.atoms.Data;

public class BaseData implements Data {

    public BaseData(String value, Object ... optionalType) {
        this.value = value;
        this.type = optionalType.length > 0 ? optionalType[0] : DefaultType;
    }
    
    protected BaseData() { this(StringUtils.EMPTY, SystemAtomTypes.DataType); }
    
    @Override public String getValue() { return value; }
    @Override public Data getNext() { return next;  }
    @Override public Object getType() { return type; }
    
    @Override public Data attach(Data next) { 
        this.next = next;
        return this;
    }

    private static final Object DefaultType = SystemAtomTypes.DataType;
    private String value;
    private Data next;
    private Object type;
}
