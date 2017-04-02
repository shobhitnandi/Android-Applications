package com.example.shubham.firstappdemo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Alertdialog extends AppCompatActivity {
Button b1;
    Button b2,b3;
    EditText edt1,edt2;
RelativeLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertdialog);
        b1=(Button)findViewById(R.id.b1);
    rl=(RelativeLayout)findViewById(R.id.activity_alertdialog);
    }
    public void dothis( View v)
    {
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        View v1=getLayoutInflater().inflate(R.layout.customlayout,null);
        adb.setView(v1);
        edt1=(EditText)v1.findViewById(R.id.username1);
        edt2=(EditText)v1.findViewById(R.id.password1);
        b2=(Button)v1.findViewById(R.id.btn1);
        b3=(Button)v1.findViewById(R.id.btn2);
       adb.setTitle("MY ALERT DIALOG");
        adb.setIcon(R.mipmap.ic_launcher);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //  if(edt1.getText().toString()!=null) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
               // }

            }
        });
/*
 adb.setMultiChoiceItems(R.array.my_array, null, new DialogInterface.OnMultiChoiceClickListener() {
                 public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (which == 0) {
                            if (isChecked)
                                rl.setBackgroundColor(Color.GREEN);
                            else
                                rl.setBackgroundColor(Color.GRAY);
                        }
                     if (which == 1) {
                         if (isChecked)
                             rl.setBackgroundColor(Color.YELLOW);
                         else
                             rl.setBackgroundColor(Color.RED);
                     }
                     if (which == 2) {
                         if (isChecked)
                             rl.setBackgroundColor(Color.MAGENTA);
                         else
                             rl.setBackgroundColor(Color.CYAN);
                     }

                 }

                }
    );*/
        adb.setCancelable(false);//for disapperaing


     /*   adb.setItems(R.array.my_array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        if(which ==0)
                        {
                            rl.setBackgroundColor(Color.RED);
                        }
                        else if(which ==1)
                        {
                            rl.setBackgroundColor(Color.BLUE);
                        }
                        else if(which ==2)
                        {
                            rl.setBackgroundColor(Color.GREEN);
                        }
                    }
                }
        );*/
    //   adb.setMessage("Are you sure");
        adb.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"YES CLICKED",Toast.LENGTH_LONG).show();
            finish();
            }
        })
;
        adb.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"NO CLICKED",Toast.LENGTH_LONG).show();
dialogInterface.cancel();
            }
        })
        ;
    Dialog d=adb.create();
    d.show();
    }

}
//adb.setMultiChoiceItems()