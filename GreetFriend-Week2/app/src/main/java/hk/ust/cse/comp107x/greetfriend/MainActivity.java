package hk.ust.cse.comp107x.greetfriend;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.joda.time.DateTimeUtils;
import java.util.Calendar;

public class MainActivity extends Activity implements View.OnClickListener {


    private static final String TAG = "MainActivity";
    private Button greetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        greetButton = (Button) findViewById(R.id.greetButton);
        greetButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        TextView textMessage = (TextView) findViewById(R.id.textMessage);

        EditText editFriendName = (EditText) findViewById(R.id.editFriendName);

        String friendName = editFriendName.getText().toString();

        switch (view.getId()){
            case R.id.greetButton:
                String greetingMessage = selectGreeting();
                Log.d(TAG, greetingMessage);
                textMessage.setText(String.format("%s %s!", greetingMessage, friendName));
                break;
            default:
                break;
        }
    }

    private String selectGreeting(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(DateTimeUtils.currentTimeMillis());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        Log.d(TAG, Integer.toString(hour));

        String messageGreeting="";

        if(hour>=6 && hour< 12)
            messageGreeting += getString(R.string.greetMorningString);
        if(hour>=12 && hour< 17)
            messageGreeting += getString(R.string.greetAfternoonString);
        if(hour>=17 && hour< 21)
            messageGreeting +=  getString(R.string.greetEveningString);
        if(hour>=21 || hour<6)
            messageGreeting += getString(R.string.greetNightString);

        return messageGreeting;
    }

}
