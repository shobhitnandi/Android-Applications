package com.example.sn.datepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    Button b;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.textView);
        dp = (DatePicker)findViewById(R.id.datePicker);
        b = (Button)findViewById(R.id.button);

        tv.setText(getCurrentDate());

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(getCurrentDate());
            }
        });
    }

    public String getCurrentDate()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Current Date: ");
        builder.append(dp.getDayOfMonth()+"/");
        builder.append((dp.getMonth()+1)+"/");
        builder.append(dp.getYear());
        return builder.toString();
    }
}
