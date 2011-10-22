package clan.blue.droid.hinto.engine;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import clan.blue.droid.common.data.Values;
import clan.blue.droid.common.util.StringUtils;

import android.os.Handler;
import android.util.Log;


public class MainLoop {
    private final AtomicBoolean running;
    private final Map<String, LoopTickListener> loopTickListeners;
    private Handler handler;
    private Drone drone;
    
    public MainLoop(LoopTickListener loopTickListener) {
        running = new AtomicBoolean(false);
        loopTickListeners = new ConcurrentHashMap<String, MainLoop.LoopTickListener>();
        handler = new Handler();
        drone = new Drone();
        
        addLoopTickListener(loopTickListener);
    }
    
    public void destroy() {
        pause();
        loopTickListeners.clear();
        handler.removeCallbacks(drone);
        handler = null;
        drone = null;
    }
    
    public void resume() {
        running.set(true);
        handler.postDelayed(drone, LOOP_REFRESH_DELAY_MILLIS);
    }
    
    public void pause() {
        handler.removeCallbacks(drone);
        running.set(false);
    }
    
    public String addLoopTickListener(LoopTickListener listener) {
        if (listener == null)
            return Values.EMPTY_STRING;
        
        String key = createKey();
        loopTickListeners.put(key, listener);
        
        return key;
    }
    
    private String createKey() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    
    public LoopTickListener removeLoopTickListener(String listenerKey) {
        if (StringUtils.isBlank(listenerKey))
            return LoopTickListener.Empty;
        
        LoopTickListener listener = loopTickListeners.remove(listenerKey);
        
        return listener == null ? LoopTickListener.Empty : listener;
    }
    
    private class Drone implements Runnable {
        @Override
        public void run() {
            Log.i(TAG, String.format("run() - %d", System.currentTimeMillis()));
            if (isRunning()) {
                handler.postDelayed(drone, LOOP_REFRESH_DELAY_MILLIS);
            }
        }
    }
    
    public static interface LoopTickListener {
        public void onLoopTick(long currentSystemTime);
        public static final LoopTickListener Empty = new LoopTickListener() { @Override public void onLoopTick(long currentSystemTime) {}};
    }
    
    public boolean isRunning() { return running.get(); }
    public static final int LOOP_REFRESH_DELAY_MILLIS = 1000;//60;
    private static final String TAG = MainLoop.class.getSimpleName();
}
