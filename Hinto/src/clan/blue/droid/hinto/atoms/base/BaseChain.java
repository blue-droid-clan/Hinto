package clan.blue.droid.hinto.atoms.base;

import clan.blue.droid.hinto.atoms.Chain;
import clan.blue.droid.hinto.atoms.Data;

public class BaseChain extends BaseFunction implements Chain {

    public BaseChain() {
        // TODO: cleanup
        super(Data.Factory.createTimestamped().getValue());
    }
    
    @Override
    public Data getNumberOfLinksInChain() {
        // TODO: rewrite this using user-defined data & functions
        int numberOfLinks = 0;
        Data next = getNext();
        
        while (notAtLinkEnd(next)) {
            numberOfLinks++;
            next = next.getNext();
        };
        
        Integer numberOfLinksInChain = new Integer(numberOfLinks);
        return Data.Factory.create(numberOfLinksInChain.toString());
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