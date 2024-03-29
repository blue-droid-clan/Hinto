package clan.blue.droid.hinto.atoms.base;

import clan.blue.droid.common.data.Values;
import clan.blue.droid.hinto.atoms.Chain;
import clan.blue.droid.hinto.atoms.Data;
import clan.blue.droid.hinto.atoms.Function;

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
    public Function getNextStep() {
        Data nextStepData = getNext();
        if (nextStepData instanceof Function)
            return (Function) nextStepData;
        return Function.NoOp;
    }
    
    @Override
    public Data perform(Data input) {
        return Function.NoOp;
    }

    @Override
    public Object getType() {
        return SystemAtomTypes.ChainType;
    }
    
    @Override
    public String getDescription() {
        return "Chain: a collection of Data items that are accessed via Data.getNext(); is a singly-linked list and can only be appended to at the current time.";
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Number numLinksInChain = Data.Converter.convertFrom(getNumberOfLinksInChain());
        sb.append("number of links: ").append(numLinksInChain).append(Values.LINE_FEED);
        
        Data current = getNext();
        int numLinks = numLinksInChain.intValue();
        for (int i = 0; i < numLinks; i++) {
            sb.append(current.toString()).append(Values.LINE_FEED);
            current = current.getNext();
        }
        
        return sb.toString();
    }
}
