package com.example.sn.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText t1,t2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (EditText)findViewById(R.id.et1);
        t2 = (EditText)findViewById(R.id.et2);

        b1 = (Button)findViewById(R.id.but1);
    }

    public void dothis(View v)
    {
        Intent i = new Intent(this,showData.class);
        i.putExtra("name",t1.getText().toString());
        i.putExtra("pass",t2.getText().toString());
        startActivity(i);
    }
}
