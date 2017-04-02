package com.example.sn.sharedpreference;

import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4;
    EditText t1,t2;
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
    }

    public void dothis(View v)
    {
        if(v.getId()==b1.getId())
        {
            SharedPreferences sp = getSharedPreferences("file1",MODE_PRIVATE);
            SharedPreferences.Editor spe = sp.edit();

            spe.putString("K1",t1.getText().toString());
            spe.putInt("K2",Integer.parseInt(t2.getText().toString()));
            spe.commit();
            Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show();
        }

        if(v.getId()==b2.getId())
        {
            SharedPreferences sp = getSharedPreferences("file1",MODE_PRIVATE);
            String s = sp.getString("K1","");
            int a = sp.getInt("K2",0);

            Toast.makeText(this, "Name is : "+s+" Password is : "+a, Toast.LENGTH_SHORT).show();
        }

        if(v.getId()==b3.getId())
        {
            SharedPreferences sp = getSharedPreferences("file1",MODE_PRIVATE);
            SharedPreferences.Editor spe = sp.edit();
            spe.remove("K2");

            spe.commit();
        }
        if(v.getId()==b4.getId())
        {
            SharedPreferences sp = getSharedPreferences("file1",MODE_PRIVATE);
            SharedPreferences.Editor spe = sp.edit();
            spe.clear();
            spe.commit();
        }
    }

    @Override
    protected void onResume()
    {

        super.onResume();

        SharedPreferences.OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
             Toast.makeText(getApplicationContext(),"Key Changed is "+key,Toast.LENGTH_SHORT).show();
            }
        };

        SharedPreferences sp = getSharedPreferences("file1",MODE_PRIVATE);
        sp.registerOnSharedPreferenceChangeListener(listener);
    }
}
