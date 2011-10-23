package clan.blue.droid.hinto.atoms;

import clan.blue.droid.common.data.Values;
import clan.blue.droid.common.util.DateTimeUtil;
import clan.blue.droid.hinto.atoms.base.BaseData;

public interface Data {
    public String getValue();
    public Data getNext();
    public Data attach(Data next);
    public Object getType();
    public String getDescription();
    public Data setDescription(String description);
    
    // Note: For potential security reasons, we need to keep this Factory class final.
    public static final class Factory {
        public static Data create(String value) { return new BaseData(value); }
        public static Data createTimestamped() { return new BaseData(createTimestampedValue()); }
        protected static Data create() { return new BaseData(Values.EMPTY_STRING); }
        
        public static Data create(String value, String description) {
            Data data = new BaseData(value);
            data.setDescription(description);
            return data; 
        }
        
        protected static final String createTimestampedValue() {
            StringBuilder sb = new StringBuilder();
            
            sb.append(Data.class.getName())
                .append(".")
                .append(DateTimeUtil.rightNowToDateStringFull());
            
            return sb.toString();
        }
    }
    
    // TODO: this will need to be extracted out; it does not belong in here
    public static final class Converter {
        public static final Data convertFrom(java.lang.Number number) {
            Long numberValue = number.longValue();
            return Data.Factory.create(numberValue.toString());
        }
        public static final java.lang.Number convertFrom(Data data) {
            String dataValue = data.getValue();
            return Long.parseLong(dataValue);
        }
    }
    
    public static final Data Empty = Factory.create();
}
