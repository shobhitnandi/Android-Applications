package com.example.sn.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class toggle extends AppCompatActivity {

    private ToggleButton t1,t2;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle);

        t1 = (ToggleButton)findViewById(R.id.toggleButton);
        t2 = (ToggleButton)findViewById(R.id.toggleButton2);
        b = (Button)findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder str = new StringBuilder();
                str.append("Toggle Button 1 : ").append(t1.getText());
                str.append("Toggle Button 2 : ").append(t2.getText());

                Toast.makeText(getApplicationContext(),str.toString(),Toast.LENGTH_LONG).show();

            }
        });
    }
}
