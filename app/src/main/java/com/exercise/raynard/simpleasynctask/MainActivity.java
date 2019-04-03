package com.exercise.raynard.simpleasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextview;
    private static final String TEXT_STATE = "currentText";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the state of the TextView// Save the state of the TextView
        outState.putString(TEXT_STATE, mTextview.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextview = findViewById(R.id.textView1);

        // Restore TextView if there is a savedInstanceState
        if (savedInstanceState != null) {
            mTextview.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    public void startTask(View view) {
        //Put a message in the text view
        mTextview.setText(R.string.napping);

        // Start the AsyncTask.
        new SimpleAsyncTask(mTextview).execute();
    }
}
