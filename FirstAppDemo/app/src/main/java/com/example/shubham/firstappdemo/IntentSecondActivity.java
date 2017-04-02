package com.example.shubham.firstappdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class IntentSecondActivity extends AppCompatActivity {
TextView tv1;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_second);
        tv1=(TextView)findViewById(R.id.tv1);
        btn1=(Button)findViewById(R.id.btn1);
       Intent i=getIntent();
        Bundle b=i.getExtras();
        // or  we can do like this way tv.setText(tv.getText().toString()+ " "+b.getString("K1"));



String name=b.getString("name");
        String pass=b.getString("pass");

tv1.setText("user name is ="+name+ "\n" + "password is ="+pass );

        Toast.makeText(getApplicationContext(),"user are:\n Username: "+name+
                "\n password: "+pass,Toast.LENGTH_LONG).show();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),IntentFirstActivity.class);
                startActivity(i);
            }
        });
    }
}
