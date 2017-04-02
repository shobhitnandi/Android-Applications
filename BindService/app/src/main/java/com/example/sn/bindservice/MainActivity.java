package com.example.sn.bindservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    MyService ms;
    boolean isbound = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(this,MyService.class);
        bindService(i,ssc, Context.BIND_AUTO_CREATE);

    }

    public void startboundService(View v)
    {
        tv1= (TextView)findViewById(R.id.tv);
        String s = ms.gettime();
        tv1.setText(s);
    }

    ServiceConnection ssc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
           MyService.MyBinder mb = (MyService.MyBinder) service;
            ms = mb.getService();
            isbound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isbound = false;
        }
    };
}
