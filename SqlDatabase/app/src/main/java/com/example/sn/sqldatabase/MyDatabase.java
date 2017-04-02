package com.example.sn.sqldatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by SN on 21-03-2017.
 */

public class MyDatabase extends SQLiteOpenHelper {

    public static final String PASS = "password";
    public static final int dbv = 1;
    public static final String dbname = "my_db";
    Context ct;

    MyDatabase(Context context)
    {
        super(context,dbname,null,dbv);
        ct = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        Toast.makeText(ct,"In onCreate",Toast.LENGTH_SHORT).show();
        String s = "create table info (id INTEGER PRIMARY KEY AUTOINCREMENT, name text, password number )";
        db.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public void insertValue(String s1,int a)
    {
        SQLiteDatabase sl = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name",s1);
        cv.put("password",a);

        sl.insert("info",null,cv);
        Toast.makeText(ct,"Insertion Completed",Toast.LENGTH_SHORT).show();
    }

    public ArrayList<String> showValues()
    {
        SQLiteDatabase sr = getReadableDatabase();
        ArrayList<String> al = new ArrayList<String>();
        String s2= "select * from info";

        Cursor cr = sr.rawQuery(s2,null);

        while (cr.moveToNext())
        {
            int a = cr.getInt(0);
            String b = cr.getString(1);
            int c = cr.getInt(2);

            al.add("Id is "+a+"\nName is :"+b +"\nPassword is : "+c);
           // Toast.makeText(ct,"Id is : "+a+" Name is : "+b+"\nPassword is : "+c,Toast.LENGTH_LONG).show();
        }
        return al;
    }

    public void updateValue(String s1, int a)
    {
        SQLiteDatabase sq = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", s1);
        sq.update("info", values, PASS+"="+a, null);
    }

    public void deleteValues()
    {
        SQLiteDatabase sq = getWritableDatabase();
        sq.delete("info", null, null);
        sq.close();
    }
}
