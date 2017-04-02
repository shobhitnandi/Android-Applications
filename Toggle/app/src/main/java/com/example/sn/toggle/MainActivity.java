package com.example.sn.toggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton t1,t2;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (ToggleButton)findViewById(R.id.toggleButton);
        t2 = (ToggleButton)findViewById(R.id.toggleButton2);
        b = (Button)findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder str = new StringBuilder();
                str.append("Toggle Button 1 : ").append(t1.getText());
                str.append("\nToggle Button 2 : ").append(t2.getText());

                Toast.makeText(getApplicationContext(),str.toString(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
