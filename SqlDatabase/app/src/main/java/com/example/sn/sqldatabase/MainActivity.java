package com.example.sn.sqldatabase;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4;
    EditText t1,t2;
    MyDatabase md;
    ListView l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (EditText)findViewById(R.id.et1);
        t2 = (EditText)findViewById(R.id.et2);

        b1 = (Button)findViewById(R.id.but1);
        b2 = (Button)findViewById(R.id.but2);
        b3 = (Button)findViewById(R.id.but3);
        b4 = (Button)findViewById(R.id.but4);
        l1 = (ListView)findViewById(R.id.lv);
        md = new MyDatabase(this);
    }

    public void dothis(View v)
    {
        if(v.getId()==b1.getId())
        {
            md.insertValue(t1.getText().toString(),Integer.parseInt(t2.getText().toString()));
            t1.setText("");
            t2.setText("");
        }

        if(v.getId()==b2.getId())
        {
            ArrayList<String> al1 = new ArrayList<String>();
            al1 = md.showValues();
            ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,al1);
            l1.setAdapter(ad);
        }

        if(v.getId()==b3.getId())
        {
            md.deleteValues();
            Toast.makeText(this,"Deleted Successfully",Toast.LENGTH_SHORT).show();

            ArrayList<String> al1 = new ArrayList<String>();
            al1 = md.showValues();

            ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,al1);

            l1.setAdapter(ad);
        }

        if(v.getId()==b4.getId())
        {
            md.updateValue(t1.getText().toString(),Integer.parseInt(t2.getText().toString()));
            Toast.makeText(this,"Update Successfully",Toast.LENGTH_SHORT).show();
            t1.setText("");
            t2.setText("");
        }
    }
}
