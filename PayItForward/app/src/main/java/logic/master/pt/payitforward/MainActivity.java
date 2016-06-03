package logic.master.pt.payitforward;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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
        mCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberActions = Integer.parseInt(mNumberActions.getText().toString());
                numberDepth = Integer.parseInt(mNumberDepth.getText().toString());
                int res = 0;
                for(int currentDepth = 1; currentDepth<=numberDepth; currentDepth++)
                    res+=Math.pow(numberActions,currentDepth);
                result.setText(Integer.toString(res));
            }
        });
        result = (TextView) findViewById(R.id.textResult);

        List<EditText> editTexts = new ArrayList<>();
        editTexts.add(mNumberActions);
        editTexts.add(mNumberDepth);
        enableViewOnNonEmptyEditText(editTexts,mCalculate);
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
                        if (curET.getText().toString().equals(""))
                            isEmpty = false;
                    }
                    view.setEnabled(isEmpty);
                }
            });
        }
    }
}
