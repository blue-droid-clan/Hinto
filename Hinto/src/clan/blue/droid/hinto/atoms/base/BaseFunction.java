package clan.blue.droid.hinto.atoms.base;

import clan.blue.droid.hinto.atoms.Data;
import clan.blue.droid.hinto.atoms.Function;

public class BaseFunction extends BaseData implements Function {

    public BaseFunction(String value) { super(value); }
    
    @Override public Data perform(Data input) { return Data.Empty; }
    @Override public Object getType() { return SystemAtomTypes.FunctionType; }
    @Override public String getDescription() { return "Function: a performable action"; }
}
