package com.example.derpp.dbfirst;

import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static final int dbv=1;
    static final String dbname="derp_db";
    DB ob=new DB(this);
    EditText t1,t2;
    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(EditText)findViewById(R.id.editText);
        t2=(EditText)findViewById(R.id.editText2);

    }
    public void input(View v){
        ob.insertVal(t1.getText().toString(),Double.parseDouble(t2.getText().toString()));

    }
    public void showvals(View v)
    {   l=(ListView)findViewById(R.id.list);
        ArrayList<Details> ll=ob.getVal();
        Ada ada=new Ada(this,ll);

        l.setAdapter(ada);

        //ob.getVal();

    }

}
