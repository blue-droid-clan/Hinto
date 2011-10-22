package clan.blue.droid.hinto;

import android.util.Log;
import clan.blue.droid.hinto.atoms.Data;
import clan.blue.droid.hinto.engine.MainLoop;
import clan.blue.droid.hinto.engine.MainLoop.LoopTickListener;

public class Hinto implements LoopTickListener {
    private MainLoop mainLoop;
    
    public Hinto() {
        mainLoop = new MainLoop(this);
    }
    
    public void addData(Data data) {
        if (data == null)
            return;
        
        updateMainChain(data);
    }
    
    private void updateMainChain(Data data) {
    }
    
    public void recycleData(Data data) {
        if (data == null)
            return;
        removeFromMainChain(data);
    }
    
    private void removeFromMainChain(Data data) {
    }
    
    public void resume() {
        Log.i(TAG, String.format("*********************** resume() - %d", System.currentTimeMillis()));
        mainLoop.resume();
    }
    
    public void pause() {
        Log.i(TAG, String.format("*********************** pause() - %d", System.currentTimeMillis()));
        mainLoop.pause();
    }
    
    public void destroy() {
        Log.i(TAG, String.format("*********************** destroy() - ", System.currentTimeMillis()));
        mainLoop.destroy();
    }
    
    @Override
    public void onLoopTick(long currentSystemTime) {
        Log.i(TAG, String.format("onLoopTick() - %d", System.currentTimeMillis()));
    }
    
    private static final String TAG = Hinto.class.getSimpleName();
}
