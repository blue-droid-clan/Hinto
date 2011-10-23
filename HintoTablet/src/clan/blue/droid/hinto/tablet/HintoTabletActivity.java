package clan.blue.droid.hinto.tablet;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import clan.blue.droid.common.android.fragments.FragmentTool;
import clan.blue.droid.hinto.Hinto;
import clan.blue.droid.hinto.tablet.workspace.views.WorkspaceFragment;
import clan.blue.droid.hinto.workspace.Workspace;

public class HintoTabletActivity extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        hinto = new Hinto();
        initializeFragmentTool();
        showWorkspace();
    }
    
    private void initializeFragmentTool() {
        FragmentManager fm = getFragmentManager();
        fragmentTool = new FragmentTool(fm);
    }
    
    private void showWorkspace() {
        Workspace workspace = Workspace.Factory.create("My Workspace");
        WorkspaceFragment fragment = new WorkspaceFragment(workspace);
        String tag = workspace.getName();
        fragmentTool.showFragment(R.id.main_workspace, fragment, tag);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        if (hinto != null) hinto.resume();
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        if (hinto != null) hinto.pause();
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (hinto != null) hinto.destroy();
    }
    
    private Hinto hinto;
    private FragmentTool fragmentTool;
}