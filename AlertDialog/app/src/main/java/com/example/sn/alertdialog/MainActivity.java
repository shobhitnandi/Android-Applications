package com.example.sn.alertdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relative;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relative  = (RelativeLayout)findViewById(R.id.activity_main);
    }

    public void dothis(View v)
    {

        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("My Alert Dialog");
        //adb.setMessage("Are you Sure");

        /*adb.setItems(R.array.my_array, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(i==0)
                {
                   relative.setBackgroundColor(Color.RED);
                }
                if(i==1)
                {
                    relative.setBackgroundColor(Color.BLUE);
                }
                if(i==2)
                {
                    relative.setBackgroundColor(Color.YELLOW);
                }
            }
        });*/

        adb.setMultiChoiceItems(R.array.my_array, null, new DialogInterface.OnMultiChoiceClickListener()
        {

            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if(i==0)
                {
                    relative.setBackgroundColor(Color.RED);
                }
                if(i==1)
                {

                    relative.setBackgroundColor(Color.BLUE);
                }
                if(i==2)
                {

                    relative.setBackgroundColor(Color.YELLOW);
                }
            }
        });
        adb.setIcon(R.drawable.lpu);
        adb.setCancelable(false);
        adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Positive Clicked",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Negative Clicked",Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        Dialog d = adb.create();
        d.show();

    }
}
