package clan.blue.droid.hinto.atoms.base;

import clan.blue.droid.common.util.StringUtils;
import clan.blue.droid.hinto.atoms.Data;
import clan.blue.droid.hinto.atoms.Link;

public class BaseData implements Data {

    public BaseData(String value, Object ... optionalType) {
        this.value = value;
        this.type = optionalType.length > 0 ? optionalType[0] : DefaultType;
        this.next = Link.End;
        this.end = this.next;
    }
    
    protected BaseData() { this(StringUtils.EMPTY, SystemAtomTypes.DataType); }
    
    @Override public String getValue() { return value; }
    @Override public Data getNext() { return next;  }
    @Override public Object getType() { return type; }
    @Override public String getDescription() { return description; }
    
    @Override
    public Data setDescription(String description) {
        this.description = description;
        return this;
    }
    
    @Override public Data attach(Data next) {
        if (notCurrentlyAtEnd())
            end.attach(next);
        else
            this.next = next;
        
        end = this.next;
        return this;
    }
    
    private boolean notCurrentlyAtEnd() {
        return notAtLinkEnd(end);
    }
    
    protected boolean notAtLinkEnd(Data link) {
        return link != Link.End;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("      value: ").append(value);
        sb.append("       next: ").append(next);
        sb.append("        end: ").append(end);
        sb.append("       type: ").append(type);
        sb.append("description: ").append(description);

        return sb.toString();
    }

    private static final Object DefaultType = SystemAtomTypes.DataType;
    private String value;
    private Data next;
    private Data end;
    private Object type;
    private String description;
}
