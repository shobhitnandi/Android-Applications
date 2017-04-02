package com.example.shubham.firstappdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button b1;
FirstFragment f1;
    SecondFragment f2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

b1=(Button)findViewById(R.id.but1);
FragmentManager fm=getSupportFragmentManager();
f1=(FirstFragment) fm.findFragmentById(R.id.frag1);
f2=(SecondFragment)fm.findFragmentById(R.id.frag2);
    }

    public void dothis(View v)
    {
        String s=f1.edt1.getText().toString();
        f2.setdata(s);
    }

}