package clan.blue.droid.hinto.atoms.base;

import clan.blue.droid.hinto.atoms.Chain;
import clan.blue.droid.hinto.atoms.Data;

public class BaseChain extends BaseFunction implements Chain {

    public BaseChain() {
        // TODO: clean
        super(Data.Factory.createTimestamped().getValue());
    }

    @Override
    public Data perform(Data input) {
        return null;
    }

    @Override
    public Object getType() {
        return SystemAtomTypes.ChainType;
    }

}
