package com.example.sn.customlist;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv1);
        ArrayList<person> al = new ArrayList<person>();

        String s[] = {"Shobhit Nandi","Anuj Yadav","Hasan","Suraj","Mohit","Devansh","Ramesh","Suresh","Mahesh","Kamlesh","Arpesh","Aman"};
        int a[] =  {R.drawable.lpu,R.drawable.erasan,R.drawable.lpu,R.drawable.erasan,R.drawable.lpu,R.drawable.erasan,R.drawable.lpu,R.drawable.erasan,R.drawable.lpu,R.drawable.erasan,R.drawable.lpu,R.drawable.erasan};

        for(int i=0; i<s.length;i++)
        {
            person p = new person();
            p.setName(s[i]);
            p.setDescription("I am a teacher");
            p.setImage(a[i]);

            al.add(p);
        }

        myadapter md = new myadapter(al,this);
        lv.setAdapter(md);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundColor(Color.BLUE);
            }
        });
    }
}
