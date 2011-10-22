package clan.blue.droid.hinto.atoms.user;

import clan.blue.droid.hinto.atoms.Data;
import clan.blue.droid.hinto.atoms.Function;

public interface Block extends Function {
    public void appendStep(Function step);
    public Data getNumberOfSteps();
}
