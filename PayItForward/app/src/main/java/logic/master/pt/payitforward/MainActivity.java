package logic.master.pt.payitforward;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mNumberActions;
    private int numberActions;

    private EditText mNumberDepth;
    private int numberDepth;

    private Button mCalculate;
    private TextView result;

    private static final String TAG = "AppCompatActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mNumberActions = (EditText) findViewById(R.id.numberActionPerPerson);
        mNumberDepth = (EditText) findViewById(R.id.numberDepth);
        mCalculate = (Button) findViewById(R.id.buttonCalculate);
        mCalculate.setEnabled(false);
        result = (TextView) findViewById(R.id.textResult);

        List<EditText> editTexts = new ArrayList<>();
        editTexts.add(mNumberActions);
        editTexts.add(mNumberDepth);
        enableViewOnNonEmptyEditText(editTexts,mCalculate);
    }

    @Override
    public void onClick(View v) {
        numberActions = Integer.parseInt(mNumberActions.getText().toString());
        numberDepth = Integer.parseInt(mNumberDepth.getText().toString());
        int res = 0;
        for(int currentDepth = 0; currentDepth<numberDepth; currentDepth++)
            //for(int currentAction = numberActions; currentAction < numberActions; currentAction++)
                res+=Math.pow(numberActions,currentDepth);
        Log.d(TAG,Integer.toString(res));
        result.setText(Integer.toString(res));
    }

    private void enableViewOnNonEmptyEditText(final List<EditText> editTexts, final View view) {
        for (EditText et : editTexts) {
            et.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    boolean isEmpty = true;
                    for (EditText curET : editTexts) {
                        Log.d(TAG,curET.toString());
                        if (curET.getText().toString().equals(""))
                            isEmpty = false;
                    }
                    view.setEnabled(isEmpty);
                }
            });
        }
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

}
