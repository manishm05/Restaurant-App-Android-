package com.project.restaurant;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Main5Activity extends AppCompatActivity {
    database d;
        int p=0;
    String ab="0";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        d=new database(getApplicationContext());
        final RatingBar ratingBar1 = (RatingBar) findViewById(R.id.ratingBar);
        final TextView textView = (TextView) findViewById(R.id.textView8);
        Button button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                String string=String.valueOf(ratingBar1.getRating());
                float rat=ratingBar1.getRating();
                float rating=rat/p;
                ContentValues data=new ContentValues();
                data.put("avg_rating",rating);
                data.put("cust",p++);
                data.put("cust_rating", string);
                database db = new database(view.getContext());
                db.getWritableDatabase().insert("rating", null, data);
                String f="select avg(cust_rating) from rating;";
               SQLiteDatabase d=db.getReadableDatabase();
                Cursor cursor =d.query("rating", new String[]{"AVG(cust_rating)as rating"},null,null,null,null,null);
                cursor.moveToFirst();
                textView.setText(cursor.getString(0));
            }

        });
    }
        }
