package clan.blue.droid.hinto.atoms;

import clan.blue.droid.hinto.atoms.base.BaseNumber;

public interface Number extends Data {
    
    public static final class Factory {
        public static final Number create(java.lang.Number value) {
            Number number = new BaseNumber(value);
            return number;
        }
    }
}
