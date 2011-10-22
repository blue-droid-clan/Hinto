package clan.blue.droid.hinto.atoms;

import clan.blue.droid.hinto.atoms.base.BaseChain;

public interface Chain extends Function {
    public Data getNumberOfLinksInChain();
    public Function getNextStep();
    
    public static final class Factory {
        public static final Chain create() { return new BaseChain(); }
    }
}
