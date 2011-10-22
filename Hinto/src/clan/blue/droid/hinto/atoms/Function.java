package clan.blue.droid.hinto.atoms;

import clan.blue.droid.hinto.atoms.base.BaseFunction;

public interface Function extends Data {
    public Data perform(Data input);
    
    public static final class Factory {
        public static Function create() { return new BaseFunction(Data.Factory.createTimestampedValue()); }
    }
}
