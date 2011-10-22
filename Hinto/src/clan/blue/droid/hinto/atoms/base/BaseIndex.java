package clan.blue.droid.hinto.atoms.base;

import clan.blue.droid.hinto.atoms.Data;
import clan.blue.droid.hinto.atoms.Index;

public class BaseIndex extends BaseData implements Index {

    @Override
    public void setToLink(Data data) {
        attach(data);
    }
}
