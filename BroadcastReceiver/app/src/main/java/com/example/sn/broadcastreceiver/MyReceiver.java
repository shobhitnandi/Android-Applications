package com.example.sn.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.


        String s = intent.getAction();

        if(s!=null)
        {
            if(s.equals(Intent.ACTION_POWER_CONNECTED))
                Toast.makeText(context,"Power Connected",Toast.LENGTH_SHORT).show();
            if(s.equals(Intent.ACTION_POWER_DISCONNECTED))
                Toast.makeText(context,"NEED TO CONNECT POWER",Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(context,"Broad",Toast.LENGTH_SHORT).show();

    }
}
