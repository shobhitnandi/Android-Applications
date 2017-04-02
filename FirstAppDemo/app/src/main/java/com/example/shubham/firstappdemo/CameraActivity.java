package com.example.shubham.firstappdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CameraActivity extends AppCompatActivity {
Button btn1;
ImageView im1;
    int k=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        btn1 = (Button) findViewById(R.id.btn11);
        im1 = (ImageView) findViewById(R.id.iv1);

    }


        public void dothis(View v)
    {
        int l = v.getId();
        if (l == R.id.btn11) {
          Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i,k);
        }
    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==k) {
            Bundle b = data.getExtras();
            if(b!=null)
            {
                Toast.makeText(getApplicationContext(), "Camera Result", Toast.LENGTH_SHORT).show();
                Bitmap bp = (Bitmap) b.get("data");
                im1.setImageBitmap(bp);
            }

        }
    }


}
