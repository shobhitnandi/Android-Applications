package com.example.sn.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class showData extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        lv = (ListView) findViewById(R.id.lv1);

        Intent i = getIntent();
        Bundle d = i.getExtras();

        String s = d.getString("name");
        int a = Integer.parseInt(d.getString("pass"));

        ArrayList<String> al = new ArrayList<String>();

        al.add("Name is "+s+"\nPassword is "+a);

        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,al);

        lv.setAdapter(ad);
     }
}
