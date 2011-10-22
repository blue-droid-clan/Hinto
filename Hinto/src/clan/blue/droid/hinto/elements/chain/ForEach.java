package clan.blue.droid.hinto.elements.chain;

import clan.blue.droid.hinto.atoms.Data;
import clan.blue.droid.hinto.atoms.base.BaseFunction;

public class ForEach extends BaseFunction {

    public ForEach() {
        // TODO: clean
        super(Data.Factory.createTimestamped().getValue());
    }
    
    @Override
    public Data perform(Data input) {
        return Data.Empty;
        /* TODO: rewrite this using a Chain, when it has been created.
         * 
        Data current = input.getNext();
        Function function = (Function) input.getNext();
        Data output = Data.Factory.create();
        
        if (current == null)
            return function.perform(input);
        
        do {
            Data result = function.perform(current);
            output.attach(result);
            current = current.getNext();
            
        } while (current != null);
        
        return output;
        */
    }
    
}
