package clan.blue.droid.hinto;

import android.app.Activity;
import android.os.Bundle;

public class HintoActivity extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    }
    
    @SuppressWarnings("unused")
    private static final String TAG = HintoActivity.class.getSimpleName();
}