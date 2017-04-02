package com.example.sn.checkbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox c1,c2,c3;
    Button b,b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1 = (CheckBox)findViewById(R.id.checkBox);
        c2 = (CheckBox)findViewById(R.id.checkBox2);
        c3 = (CheckBox)findViewById(R.id.checkBox3);
        b = (Button)findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int totalamount=0;
                StringBuilder str = new StringBuilder();
                str.append("Selected Items :");

                if(c1.isChecked())
                {
                    str.append("\nPizza 100Rs");
                    totalamount+=100;
                }

                if(c2.isChecked())
                {
                    str.append("\nBurger 50Rs");
                    totalamount+=50;
                }

                if(c3.isChecked())
                {
                    str.append("\nCoffee 30Rs");
                    totalamount+=30;
                }

                str.append("\nTotal:"+totalamount+" Rs");
                Toast.makeText(getApplicationContext(),str.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        b1 = (Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,spinner.class);
                startActivity(intent);
            }
        });

    }
}
