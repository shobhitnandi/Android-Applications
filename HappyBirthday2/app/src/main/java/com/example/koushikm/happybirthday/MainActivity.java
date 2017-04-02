package com.example.koushikm.happybirthday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText) findViewById(R.id.et);
    }
    public  void doThis(View v)
    {
        Intent i=new Intent(this,Main2Activity.class);
        Bundle b=new Bundle();
        b.putString("key1",et.getText().toString());
        i.putExtras(b);
        startActivity(i);
    }
}
