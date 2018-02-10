package com.project.restaurant;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final EditText e1=(EditText) findViewById(R.id.editText);
        final EditText e2=(EditText)findViewById(R.id.editText2);
        final EditText e3=(EditText) findViewById(R.id.editText3);
        final EditText e4=(EditText) findViewById(R.id.editText4);
        final EditText e5=(EditText) findViewById(R.id.editText5);
        final EditText e6=(EditText) findViewById(R.id.editText6);

        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                String str1= e1.getText().toString();
                String str2= e2.getText().toString();
                String str3= e3.getText().toString();
                String str4= e4.getText().toString();
                String str5= e5.getText().toString();
                String str6= e6.getText().toString();
                if(str1.equals(""))
                {
                    e1.setError("Name is required");
                }
                else if(str2.equals(""))
                {
                    e2.setError("E-" +
                            "Mail is required");
                }
             else   if(str3.equals(""))
                {
                    e3.setError("Phone No. is required");
                }
              else   if(str4.equals(""))
                {
                    e4.setError("Date is required");
                }
              else  if(str5.equals(""))
                {
                    e5.setError("Time is required");
                }
              else   if(str6.equals(""))
                {
                    e1.setError("NO. of seats is required");
                }
                else{
                    ContentValues data = new ContentValues();
                    ContentValues data1= new ContentValues();
                    data.put("name", str1);
                    data.put("email", str2);
                    data.put("phone_no", str3);
                    data.put("date", str4);
                    data.put("time", str5);
                    data.put("no_of_person",str6);
                    database db = new database(view.getContext());
                    db.getWritableDatabase().insert("customer", null, data);
                    data1.put("date", str4);
                    data1.put("time", str5);
                    database db1= new database(view.getContext());
                    db1.getWritableDatabase().insert("booking",null, data1);
                    SQLiteDatabase d1= db1.getReadableDatabase();
                    Cursor cursor=d1.query("booking", new String[]{"table_no"},null,null,null,null,null);
                    cursor.moveToFirst();
                    for(int i=0; i<=10; i++) {
                        if (cursor.getString(i) == null) {
                            data1.put("table_no", i);
                            ++i;
                            Intent intent1 = new Intent(Main2Activity.this, Main8Activity.class);
                            intent1.putExtra("abc", "" + i);
                            startActivity(intent1);
                            break;
                        }
                    }

                //    Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                  //  intent.putExtra("email", str2);
                    //startActivity(intent);

                }

            }

        });
    }
}






