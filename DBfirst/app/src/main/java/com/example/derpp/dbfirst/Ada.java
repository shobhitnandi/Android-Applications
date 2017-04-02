package com.example.derpp.dbfirst;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Derpp on 3/24/2017.
 */

public class Ada extends BaseAdapter {
    Context ct;
    ArrayList<Details> det;
    public Ada(Context context, ArrayList<Details> det) {
        ct=context;
        this.det=det;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Activity a=(Activity)ct;
        Details ob=det.get(position);
        LayoutInflater li=a.getLayoutInflater();
        View v=li.inflate(R.layout.clist,null);
        ImageView v1=(ImageView)v.findViewById(R.id.i11);
        TextView t1=(TextView)v.findViewById(R.id.t11);
        TextView t2=(TextView)v.findViewById(R.id.t22);
        v1.setImageResource(ob.getImage());
        t1.setText(ob.getName());
        t2.setText(ob.getBalance());
        return v;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return det.get(position);
    }

    @Override
    public int getCount() {
        return det.size();
    }
}
