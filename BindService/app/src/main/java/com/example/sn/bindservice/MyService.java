package com.example.sn.bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Date;

public class MyService extends Service {
    public MyService()
    {
    }

    IBinder myibinder = new MyBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       // throw new UnsupportedOperationException("Not yet implemented");
        return myibinder;
    }

    String gettime()
    {
        Date d = new Date();
        return d.toString();
    }

    class MyBinder extends Binder
    {
        MyService getService()
        {
            return MyService.this;
        }
    }
}


