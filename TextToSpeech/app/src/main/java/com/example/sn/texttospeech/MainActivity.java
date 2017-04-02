package com.example.sn.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.util.Locale;

import static android.transition.Fade.IN;

public class MainActivity extends AppCompatActivity {

    TextToSpeech tt;
    Button B1;
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        B1 = (Button) findViewById(R.id.but);
        ed = (EditText) findViewById(R.id.et);
        tt = new TextToSpeech(getApplicationContext(),
                new TextToSpeech.OnInitListener() {
                    public void onInit(int status) {
                        if (status != TextToSpeech.ERROR)

                        tt.setLanguage(Locale.UK);
                            //tt.setLanguage(Locale.UK);
                    }
                });
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = ed.getText().toString();
                tt.speak(s, TextToSpeech.QUEUE_FLUSH, null);

            }
        });
    }

    }
