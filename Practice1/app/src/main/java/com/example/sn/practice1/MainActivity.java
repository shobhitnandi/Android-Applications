package com.example.sn.practice1;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    Button b;
    ListView lv;
    int start=0;
    RelativeLayout rl;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button)findViewById(R.id.but1);
        lv = (ListView)findViewById(R.id.lv);
        rl = (RelativeLayout)findViewById(R.id.rl);
        String s[] = getResources().getStringArray(R.array.my);

        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,s);

        lv.setAdapter(ad);
        lv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(view.getId() ==0)
                {
                    rl.setBackgroundColor(Color.CYAN);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }



    public void dothis(View v)
    {
        if(v.getId()==R.id.but1)
        {
            pd = new ProgressDialog(this);
            pd.setTitle("Progress Title");
            pd.setMessage("Downloading");
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.setMax(50);

            pd.setButton(DialogInterface.BUTTON_NEGATIVE,"Cancel",new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    //start =0;
                    //pd.setProgress(start);
                }
            });
            pd.setProgress(start);
            pd.show();

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try
                    {
                        while (start<50) {
                            Thread.sleep(200);
                            start = start + 5;
                            pd.setProgress(start);

                        }


                        if(start==50)
                        {
                            pd.dismiss();
                            pd.setProgress(start);
                            start=0;
                        }

                    }
                    catch(InterruptedException e)
                    {

                    }

                }
            });
            t.start();
        }

    }

}
