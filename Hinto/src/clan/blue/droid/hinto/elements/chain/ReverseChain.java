package clan.blue.droid.hinto.elements.chain;

import clan.blue.droid.hinto.atoms.Data;
import clan.blue.droid.hinto.atoms.base.BaseFunction;

public class ReverseChain extends BaseFunction {

    public ReverseChain() {
        // TODO: clean
        super(Data.Factory.createTimestamped().getValue());
    }
    
    @Override
    public Data perform(Data input) {
        return null;
    }

}
