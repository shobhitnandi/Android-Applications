package com.lalitsingh.fragment01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static TextView mytext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,"Oncreate Activity Started",Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);
        mytext = (TextView)findViewById(R.id.title1);
        Toast.makeText(this,"Oncreate Activity Finished",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"OnStart Activity Started",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"OnPause Activity Started",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"OnResume Activity Started",Toast.LENGTH_SHORT).show();

    }


    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"OnStop Activity Started",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"OnRestart Activity Started",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"OnDestroy Activity Started",Toast.LENGTH_SHORT).show();
    }
}
