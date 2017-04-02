package com.example.sn.camera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.FitWindowsFrameLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.net.URI;

public class MainActivity extends Activity{

    Button b;
    ImageView imageView;
    static final int cam_request = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button)findViewById(R.id.button);
        imageView = (ImageView)findViewById(R.id.imageview);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                camera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera,cam_request);
            }
        });
    }

    private File getFile()
    {
        File folder = new File("sdcard/camera_app");

        if(!folder.exists())
        {
            folder.mkdir();
        }
        File image_file = new File(folder,"cam_image.jpg");

        return image_file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        String path = "sdcard/camera_app/cam_image.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(path));
    }
}
