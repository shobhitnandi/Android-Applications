package com.example.sn.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button)findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Notification noti = new Notification.Builder(MainActivity.this)
                        .setTicker("Shobhit Nandi")
                        .setContentTitle("Top Unversity")
                        .setContentText("LPU - Lovely Professional University")
                        .setSmallIcon(R.drawable.car)
                        .getNotification();

              //noti.flags = Notification.FLAG_AUTO_CANCEL;

                NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                nm.notify(0,noti);
            }
        });
    }
}
