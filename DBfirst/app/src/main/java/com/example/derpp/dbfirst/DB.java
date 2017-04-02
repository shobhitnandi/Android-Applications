package com.example.derpp.dbfirst;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Derpp on 3/22/2017.
 */

public class DB extends SQLiteOpenHelper {
    static final int dbv=1;
    static final String dbname="derp_db2";
    Context ct;
    public DB(Context context) {
        super(context, dbname,null, dbv);
        ct=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String s="create table tab(nid int primary key,name varchar(20),mob varchar(20),image int)";
        db.execSQL(s);

        Toast.makeText(ct,"CREATED",Toast.LENGTH_SHORT).show();
        Log.i("database: ","created tab");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertVal(String s,double num)
    {

        SQLiteDatabase wdb=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",s);
        cv.put("mob",Double.toString(num));
        cv.put("image",R.mipmap.ic_launcher);
        wdb.insert("tab",null,cv);

        Toast.makeText(ct,"Inserted",Toast.LENGTH_SHORT).show();
       // Log.d("logger","HELLO");
        //Log.e("derp","derp");
        wdb.close();
    }
    public ArrayList<Details> getVal()
    {
        SQLiteDatabase rdb=getReadableDatabase();
        ArrayList<Details> list=new ArrayList<>();
        String s1="select*from tab";
        Cursor cr=rdb.rawQuery(s1,null);
        cr.moveToFirst();
        while (!cr.isAfterLast()) {
            String s=cr.getString(1);
            String s2=cr.getString(2);
            int s3=cr.getInt(3);
            Details ob=new Details();
            ob.setName(s);
            ob.setBalance(s2);
            ob.setImage(s3);
            list.add(ob);
            //Log.e("logger",s+" "+s2);
            cr.moveToNext();
        }
        cr.close();

        Toast.makeText(ct,"List made",Toast.LENGTH_SHORT).show();
        return list;
    }
    /*public void getVal()
    {
        SQLiteDatabase rdb=getReadableDatabase();
        //ArrayList<Details> list=new ArrayList<>();
        String s1="select*from tab";
        Cursor cr=rdb.rawQuery(s1,null);
        cr.moveToFirst();
        while (!cr.isAfterLast()) {
            String s=cr.getString(1);
            String s2=cr.getString(2);
            int s3=cr.getInt(3);

                        Log.e("logger",s+" "+s2+" "+s3);
            cr.moveToNext();
        }
        cr.close();
    }*/


}
