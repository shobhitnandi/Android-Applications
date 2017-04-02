package com.example.sn.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Intent i;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= (Button)findViewById(R.id.but);
        b2= (Button)findViewById(R.id.but1);
    }

    public void startService(View v)
    {
        i = new Intent(this,MyService.class);
        startService(i);
    }

    public void stopService(View v)
    {
        stopService(i);
    }
}
