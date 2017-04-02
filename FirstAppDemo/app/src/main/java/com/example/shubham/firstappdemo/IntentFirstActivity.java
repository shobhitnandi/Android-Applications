package com.example.shubham.firstappdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IntentFirstActivity extends AppCompatActivity {
EditText edt1,edt2,edt3;
    TextView tv1,tv2,tv3;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_first);
    edt1=(EditText)findViewById(R.id.edt1);
       edt2=(EditText)findViewById(R.id.edt2);
        edt3=(EditText)findViewById(R.id.edt3);
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);
    btn1=(Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=edt1.getText().toString();
                String pass=edt2.getText().toString();
                String cnfrm=edt3.getText().toString();
                if(pass.equals(cnfrm)) {
                    Intent i = new Intent(getApplicationContext(), IntentSecondActivity.class);
                    //Bundle b=new Bundle();
                    //b.putString("K1",edt1.getText().toString());
                    //b.puInt("K2",1234);
                    //i.putExtras(b);

                    i.putExtra("name", name);
                    i.putExtra("pass", pass);
                    i.putExtra("cnfrm", cnfrm);
                    startActivity(i);
                }
                else
                {
                  //  Toast.makeText(getApplicationContext(),"Password should be correct",Toast.LENGTH_LONG).show();
                    //inflate is used to make object of xml file
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.mylayout1,//or we can say View v1=getLayotInflater().inflate(R.layout.myLayou1,null)
                            (ViewGroup) findViewById(R.id.customtoast));

                    TextView text = (TextView) layout.findViewById(R.id.text);
                    text.setText("This is a custom toast");

                    Toast toast = new Toast(getApplicationContext());
                    //toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();
                //Toast t=new Toast(getApplicationContext());
                  //  getLayoutInflater().inflate(R.layout.mylayout1,null);
//case R.id.but2
                    //MediaPlayer ml=MediaPlayer.create(this, R.raw.heartless);
                    //m.start();
                    //break;
                }
            }
        });


    }
}
