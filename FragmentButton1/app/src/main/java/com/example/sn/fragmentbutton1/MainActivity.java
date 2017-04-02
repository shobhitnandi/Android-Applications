package com.example.sn.fragmentbutton1;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FirstFragment.CustomInterface {

    EditText et11;
    TextView tv11;

    public void passData(String s) {

        et11.setText(s);
        f2.setdata(s);
    }
    FirstFragment f1;
    SecondFragment f2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et11 =(EditText) findViewById(R.id.et1);
        tv11 =(TextView) findViewById(R.id.tv1);

        FragmentManager fm = getSupportFragmentManager();

        f1 = (FirstFragment) fm.findFragmentById(R.id.frag1);
        f2 = (SecondFragment) fm.findFragmentById(R.id.frag2);
    }
}

