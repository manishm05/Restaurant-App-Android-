package com.project.restaurant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class database extends SQLiteOpenHelper {
    database(Context context) {
        super(context, "login", null, 1);
    }


    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String string1 = "Create Table customer(name TEXT, email_id TEXT,phone_no TEXT, date TEXT, time TEXT, no_of_person INTEGER);";
        sqLiteDatabase.execSQL(string1);
        String string2= "Create Table rating(cust int,cust_rating DOUBLE(1,1),avg_rating DOUBLE(1,1));";
        sqLiteDatabase.execSQL(string2);
        String string= "Create Table sign(first_name TEXT, last_name TEXT, email_id TEXT, password TEXT, gender TEXT);";
        sqLiteDatabase.execSQL(string);
        String string3="Create Table booking(table_no int, date TEXT, time DOUBLE(2,2));";
        sqLiteDatabase.execSQL(string3);

    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
