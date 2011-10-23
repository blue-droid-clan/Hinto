package clan.blue.droid.hinto.tablet.workspace.views;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import clan.blue.droid.common.util.DateTimeUtil;
import clan.blue.droid.hinto.tablet.R;
import clan.blue.droid.hinto.workspace.Workspace;

public class WorkspaceFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.workspace_view, null);
        
        initViewLayoutParams(view);
        storeWidgetHandles(view);
        initClickListeners();
        updateWidgetDisplay();
        
        // TODO: putting this here temporarily until it's available from Workspace
        updateStatus(String.format("Workspace created at %s", DateTimeUtil.rightNowToDateStringFull()));
        return view;
    }
    
    private void initViewLayoutParams(View view) {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);
    }
    
    private void storeWidgetHandles(View view) {
        workspaceNameLabel = (TextView) view.findViewById(R.id.workspace_name_display);
        workspaceAtomPalette = view.findViewById(R.id.workspace_atom_palette);
        workspaceStatusView = (TextView) view.findViewById(R.id.workspace_status_view);
        workspaceSandboxContainer = (ViewGroup) view.findViewById(R.id.workspace_sandbox_container);
    }
    
    private void initClickListeners() {
        initClickListener(R.id.atom_palette_data_view, new OnClickListener() { @Override public void onClick(View v) { onDataClicked(); }});
        initClickListener(R.id.atom_palette_function_view, new OnClickListener() { @Override public void onClick(View v) { onFunctionClicked(); }});
        initClickListener(R.id.atom_palette_chain_view, new OnClickListener() { @Override public void onClick(View v) { onChainClicked(); }});
    }
    
    private void initClickListener(int resId, OnClickListener onClickListener) {
        View view = workspaceAtomPalette.findViewById(resId);
        if (view == null)
            return;
        view.setOnClickListener(onClickListener);
    }
    
    private void onDataClicked() {
        Log.i(TAG, String.format("onDataClicked() - %s", ""));
        
        View dataView = getActivity().getLayoutInflater().inflate(R.layout.data_view, null);
        if (dataView == null)
            return;
        
        int width = workspaceSandboxContainer.getWidth();
        int height = workspaceSandboxContainer.getHeight();
        int x = (width - 100) / 2;
        int y = (height - 100) / 2;
        dataView.setX(x);
        dataView.setY(y);
        
        dataView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i(TAG, String.format("onTouch() - %d | %4.2f, %4.2f", event.getPointerCount(), event.getRawX(), event.getRawY()));
                return false;
            }
        });
        dataView.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Log.i(TAG, String.format("onDrag() - %d | %4.2f, %4.2f", event.getAction(), event.getX(), event.getY()));
                return false;
            }
        });
        workspaceSandboxContainer.addView(dataView);
    }
    
    private void onFunctionClicked() {
        Log.i(TAG, String.format("onFunctionClicked() - %s", ""));
    }
    
    private void onChainClicked() {
        Log.i(TAG, String.format("onChainClicked() - %s", ""));
    }
    
    protected void updateWidgetDisplay() {
        workspaceNameLabel.setText(workspace.getName());
    }
    
    public void updateStatus(String message) {
        workspaceStatusView.setText(message);
    }

    public WorkspaceFragment(Workspace workspace) { this.workspace = workspace; }

    private static final String TAG = WorkspaceFragment.class.getSimpleName();
    private Workspace workspace;
    private TextView workspaceNameLabel;
    private View workspaceAtomPalette;
    private TextView workspaceStatusView;
    private ViewGroup workspaceSandboxContainer;
}
