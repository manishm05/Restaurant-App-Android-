package com.project.restaurant;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        final EditText text = (EditText) findViewById(R.id.editText3);
        final EditText text1 = (EditText) findViewById(R.id.editText4);
        final EditText text2 = (EditText) findViewById(R.id.editText5);
        final EditText text3 = (EditText) findViewById(R.id.editText8);
        Button button = (Button) findViewById(R.id.button4);
        final RadioButton radioButton = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = text.getText().toString();
                String str1 = text1.getText().toString();
                String str2 = text2.getText().toString();
                String str3 = text3.getText().toString();
                String str4 = "";

                if (str.matches("")) {
                    Toast.makeText(getApplicationContext(), "FIRST NAME FIELD IS EMPTY", Toast.LENGTH_LONG).show();
                }
                else if (str1.matches("")) {
                    Toast.makeText(getApplicationContext(), "LAST NAME FIELD IS EMPTY", Toast.LENGTH_LONG).show();
                }
                else if (str2.matches("")) {
                    Toast.makeText(getApplicationContext(), "EMAIL-ID NAME FIELD IS EMPTY or EMAIL IS INCORRECT", Toast.LENGTH_LONG).show();
                }
                else if (!radioButton.isChecked() && !radioButton2.isChecked()) {
                    Toast.makeText(getApplicationContext(), "PLEASE SPECIFY GENDER", Toast.LENGTH_LONG).show();
                }
                else if (str3.matches("")) {
                    Toast.makeText(getApplicationContext(), "PASSWORD FIELD IS EMPTY", Toast.LENGTH_LONG).show();
                }
                else {
                    ContentValues data = new ContentValues();
                    data.put("first_name", str);
                    data.put("last_name", str1);
                    data.put("email_id", str2);
                    data.put("password", str3);
                    data.put("gender", str4);
                    database db = new database(view.getContext());
                    db.getWritableDatabase().insert("sign", null, data);
                    Intent intent = new Intent(Main6Activity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
