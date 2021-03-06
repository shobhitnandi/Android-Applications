package com.example.listviewdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv1);

        ArrayList<Person> al = new ArrayList<Person>();

        for(int i=0; i<4;i++)
        {
            Person p = new Person();
            p.setName("My name is Roshan");
            p.setDescription("I am a teacher");
            p.setImage(R.drawable.lpu);

            al.add(p);
        }

        MyAdapter md = new MyAdapter(al,this);
        lv.setAdapter(md);

        lv.setOnItemClickListener( new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parent.setBackgroundColor(Color.CYAN);
                view.setBackgroundColor(Color.YELLOW);
            }
        });


    }
}
