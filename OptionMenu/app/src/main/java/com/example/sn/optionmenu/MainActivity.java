package com.example.sn.optionmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.item1:
                Toast.makeText(this, "Item 1", Toast.LENGTH_SHORT)
                        .show();
                break;

            case R.id.item2:
                Toast.makeText(this, "Item 2", Toast.LENGTH_SHORT)
                        .show();
                break;

            case R.id.item4:
                Toast.makeText(this, "Item 4", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.item5:
                Toast.makeText(this, "Item 5", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.item6:
                Toast.makeText(this, "Item 6", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.aa:
                Toast.makeText(this, "Man", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.bb:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }

        return true;
    }

    public void dothis(View v)
    {

    }
}
