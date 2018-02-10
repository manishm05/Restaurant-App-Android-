package com.project.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Thread background =
                new Thread() {
            public void run() {

                try {

                    sleep(2*1000);

                    Intent i=new Intent(getBaseContext(),MainActivity.class);
                    startActivity(i);

                    finish();

                } catch (Exception e) {

                }
            }
        };
        background.start();
    }
}
