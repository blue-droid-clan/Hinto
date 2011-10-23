package clan.blue.droid.hinto.atoms.base;

import clan.blue.droid.hinto.atoms.Data;
import clan.blue.droid.hinto.atoms.Number;

public class BaseNumber extends BaseData implements Number {
    public BaseNumber(java.lang.Number value) {
        super(Data.Converter.convertFrom(value).getValue());
    }
}
