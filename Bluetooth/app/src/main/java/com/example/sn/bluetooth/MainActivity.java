package com.example.sn.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter btAdapter;
    TextView statusUpdate;
    Button connect, disconnect;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UI();
    }

    private void UI() {
        statusUpdate = (TextView) findViewById(R.id.textView);
        connect = (Button) findViewById(R.id.button);
        disconnect = (Button) findViewById(R.id.button2);
        logo = (ImageView) findViewById(R.id.imageView);

        disconnect.setVisibility(View.GONE);
        logo.setVisibility(View.GONE);

        btAdapter = BluetoothAdapter.getDefaultAdapter();

        final BroadcastReceiver bluetoothState = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String prevStateExtra = BluetoothAdapter.EXTRA_PREVIOUS_STATE;
                String stateExtra = BluetoothAdapter.EXTRA_STATE;
                int state = intent.getIntExtra(stateExtra, -1);
                //int previousState = intent.getIntExtra(prevStateExtra,-1);
                String toastText = "";

                switch (state) {
                    case (BluetoothAdapter.STATE_TURNING_ON): {
                        toastText = "Bluetooth turning on";
                        Toast.makeText(MainActivity.this, toastText, Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case (BluetoothAdapter.STATE_ON): {
                        toastText = "Bluetooth on";
                        Toast.makeText(MainActivity.this, toastText, Toast.LENGTH_SHORT).show();
                        UI();
                        break;
                    }
                    case (BluetoothAdapter.STATE_TURNING_OFF): {
                        toastText = "Bluetooth turning off";
                        Toast.makeText(MainActivity.this, toastText, Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case (BluetoothAdapter.STATE_OFF): {
                        toastText = "Bluetooth off";
                        Toast.makeText(MainActivity.this, toastText, Toast.LENGTH_SHORT).show();
                        UI();
                        break;
                    }
                    default:
                        break;
                }
            }


        };

        if (btAdapter.isEnabled()) {
            String address = btAdapter.getAddress();
            String name = btAdapter.getName();
            String statusText = name + " : " + address;
            statusUpdate.setText(statusText);
            disconnect.setVisibility(View.VISIBLE);
            logo.setVisibility(View.VISIBLE);
            connect.setVisibility(View.GONE);
        } else {
            statusUpdate.setText("Bluetooth is not on");
        }


        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String actionStateChanged = BluetoothAdapter.ACTION_STATE_CHANGED;
                String actionRequestEnable = BluetoothAdapter.ACTION_REQUEST_ENABLE;
                IntentFilter filter = new IntentFilter(actionStateChanged);
                registerReceiver(bluetoothState,filter);
                startActivityForResult(new Intent(actionRequestEnable), 0);

            }
        });

        disconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btAdapter.disable();
                disconnect.setVisibility(View.GONE);
                logo.setVisibility(View.GONE);
                connect.setVisibility(View.VISIBLE);
                statusUpdate.setText("Bluetooth Off");
            }
        });


    }
}





