package com.example.prajw.icepick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;
import icepick.State;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;

    @State
    String string = "prajwal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //restsore Instance State using icepick
        Icepick.restoreInstanceState(this, savedInstanceState);

        setContentView(R.layout.activity_main);

        //first prajwal is printed, then orientation changed new prajwal is printed
        Log.d("String", string);
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();

        ButterKnife.bind(this);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        string = "new prajwal";
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }
}