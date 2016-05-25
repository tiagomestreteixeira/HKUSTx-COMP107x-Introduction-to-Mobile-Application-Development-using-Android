package hk.ust.cse.comp107x.greetfriend;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

public class ShowMessage extends Activity {


    private static final String TAG = "ShowMessageactivity";
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_message);

        Intent in = getIntent();
        message = in.getStringExtra("message");

        TextView tv = (TextView)findViewById(R.id.textMessage);
        tv.setText(message);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"in onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"in onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"in onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"in onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"in onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"in onDestroy()");
    }

}
