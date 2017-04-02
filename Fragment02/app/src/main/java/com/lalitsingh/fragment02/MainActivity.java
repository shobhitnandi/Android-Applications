package com.lalitsingh.fragment02;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MyFrag1 f1;
    MyFrag2 f2;
    FragmentManager manager;
    FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        f1 = new MyFrag1();
        f2 = new MyFrag2();
        ft = manager.beginTransaction();
        ft.add(R.id.linear1,f1);
        ft.add(R.id.linear2,f2);
        ft.commit();
    }
}
