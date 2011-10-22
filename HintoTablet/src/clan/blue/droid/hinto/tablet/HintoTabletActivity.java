package clan.blue.droid.hinto.tablet;

import android.app.Activity;
import android.os.Bundle;
import clan.blue.droid.hinto.Hinto;

public class HintoTabletActivity extends Activity {
    private Hinto hinto;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        hinto = new Hinto();
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
}