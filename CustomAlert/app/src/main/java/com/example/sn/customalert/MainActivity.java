package com.example.sn.customalert;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button)findViewById(R.id.b);


    }


    public void dothis(View v)
    {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);

        View v1 = getLayoutInflater().inflate(R.layout.custom_alert,null);
        adb.setView(v1);
        adb.setCancelable(false);

        final Dialog d = adb.create();
        b1 = (Button)v1.findViewById(R.id.but1);
        b2 = (Button)v1.findViewById(R.id.but2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    d.dismiss();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(in);
            }
        });


        d.show();

        /*try
        {

        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }*/




    }
}
