package clan.blue.droid.hinto.atoms;

import clan.blue.droid.common.data.Values;
import clan.blue.droid.common.util.DateTimeUtil;
import clan.blue.droid.hinto.atoms.base.BaseData;

public interface Data {
    public String getValue();
    public Data getNext();
    public Data attach(Data next);
    public Object getType();
    
    // Note: For potential security reasons, we need to keep this Factory class final.
    public static final class Factory {
        public static Data create(String value) { return new BaseData(value); }
        public static Data createTimestamped() { return new BaseData(createTimestampedValue()); }
        protected static Data create() { return new BaseData(Values.EMPTY_STRING); }
        
        protected static final String createTimestampedValue() {
            StringBuilder sb = new StringBuilder();
            
            sb.append(Data.class.getName())
                .append(".")
                .append(DateTimeUtil.rightNowToDateStringFull());
            
            return sb.toString();
        }
    }
    public static final Data Empty = Factory.create();
}
