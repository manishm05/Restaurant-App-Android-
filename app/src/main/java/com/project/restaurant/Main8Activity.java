package com.project.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main8Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        Intent intent= getIntent();
        String s= intent.getStringExtra("abc");
        TextView textView= (TextView)findViewById(R.id.textView38);
        textView.setText(s);
    }
}
