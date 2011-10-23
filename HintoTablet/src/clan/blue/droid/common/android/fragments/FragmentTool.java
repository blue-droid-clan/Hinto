package clan.blue.droid.common.android.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

public class FragmentTool {
    
    public void showFragment(int containerViewId, Fragment fragment, String tag) {
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(containerViewId, fragment, tag);
        transaction.show(fragment);
        transaction.commit();
    }
    
    public FragmentTool(FragmentManager fm) { this.fm = fm; }
    
    private final FragmentManager fm;
}
