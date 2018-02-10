package com.project.restaurant;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.btn_login);
        final EditText editText = (EditText) findViewById(R.id.input_email);
        final EditText editText2 = (EditText) findViewById(R.id.input_password);
        final TextView textView=(TextView)findViewById(R.id.link_signup);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
              String ab[] = new String[]{editText.getText().toString()};
                database db = new database(view.getContext());
                Cursor cursor = db.getReadableDatabase().query("sign",new String[]{"email_id"}, "email_id=?", ab, null, null, null);
                cursor.moveToFirst();
                String str = cursor.getString(0);
                  if(str.equals(editText.getText().toString()))
                {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                    intent.putExtra("abc",editText.getText().toString());
                startActivity(intent);
                }
            }
        });
        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent=new Intent(MainActivity.this,Main6Activity.class);
                startActivity(intent);
                return false;
            }
        });
    }
}

