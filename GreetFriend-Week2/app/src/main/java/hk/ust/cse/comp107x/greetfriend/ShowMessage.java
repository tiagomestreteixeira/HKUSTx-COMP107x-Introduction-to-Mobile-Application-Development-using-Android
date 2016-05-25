package hk.ust.cse.comp107x.greetfriend;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class ShowMessage extends Activity {

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

}
