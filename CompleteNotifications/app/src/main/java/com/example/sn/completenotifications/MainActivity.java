package com.example.sn.completenotifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.but1);
        b2 = (Button)findViewById(R.id.but2);
        b3 = (Button)findViewById(R.id.but3);

    }

    public void dothis(View v)
    {
        Intent i = new Intent(getApplicationContext(),Main2Activity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,i,0);
        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        if(v.getId()==b1.getId())
        {
            NotificationCompat.Builder nib = new NotificationCompat.Builder(this);

            nib.setContentTitle("My First Notifications");
            nib.setContentText("Lovely Professional University");
            nib.setSmallIcon(R.drawable.lpu);
            nib.addAction(R.drawable.lpu,"This is first action",pendingIntent);
            //nib.setContentIntent(pendingIntent);
            Notification ni = nib.build();
            nm.notify(0,ni);
        }

        if(v.getId()==b2.getId())
        {
            nm.cancel(0);
        }

        if(v.getId()==b3.getId())
        {
            NotificationCompat.Builder nib = new NotificationCompat.Builder(this);

            nib.setContentTitle("My Second Notifications");
            nib.setContentText("Punjab Technical University");
            nib.setSmallIcon(R.drawable.lpu);
            nib.addAction(R.drawable.lpu,"This is second action",pendingIntent);
            //nib.setContentIntent(pendingIntent);
            Notification ni = nib.build();
            nm.notify(1,ni);
        }
    }

    public void listv(View v)
    {
        Intent i = new Intent(this,ListView1.class);
        startActivity(i);
    }

}
