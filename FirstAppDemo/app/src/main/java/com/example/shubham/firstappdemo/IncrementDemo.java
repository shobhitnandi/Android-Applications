package com.example.shubham.firstappdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IncrementDemo extends AppCompatActivity {
    Button b1, b2;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_increment_demo);


        b1 = (Button) findViewById(R.id.btn1);
        b2 = (Button) findViewById(R.id.btn2);
        tv1 = (TextView) findViewById(R.id.tv1);
    }

    public void updown(View v) {
        int k = v.getId();

        if (k == R.id.btn1) {
            String s = tv1.getText().toString();
            int i = Integer.parseInt(s);
            i++;
            tv1.setText("" + i);
        } else if (k == R.id.btn2) {
            String s = tv1.getText().toString();
            int i = Integer.parseInt(s);
            i--;
            tv1.setText("" + i);
        }


    }
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString("Key1",tv1.getText().toString());

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
       String s= savedInstanceState.getString("Key1");
        tv1.setText(s);
    }

}