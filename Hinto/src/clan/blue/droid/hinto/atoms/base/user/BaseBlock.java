package clan.blue.droid.hinto.atoms.base.user;

import clan.blue.droid.hinto.atoms.Chain;
import clan.blue.droid.hinto.atoms.Data;
import clan.blue.droid.hinto.atoms.Function;
import clan.blue.droid.hinto.atoms.user.Block;

public class BaseBlock extends BaseUserDefinedData implements Block {

    public BaseBlock(String name) {
        super(name);
        actionsToPerform = Chain.Factory.create();
    }

    @Override
    public Data perform(Data input) {
        Function nextStep = actionsToPerform.getNextStep();
        Data result = nextStep.perform(input);
        return result;
    }

    @Override
    public void appendStep(Function step) {
        actionsToPerform.attach(step);
    }

    @Override
    public Data getNumberOfSteps() {
        return actionsToPerform.getNumberOfLinksInChain();
    }

    private Chain actionsToPerform;
}
