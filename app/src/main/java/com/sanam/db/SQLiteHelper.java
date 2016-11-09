package com.sanam.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
 
 static String DATABASE_NAME="DemoDataBase";
 
 public static final String KEY_ID="id";
 
 public static final String TABLE_NAME="userTable";
 
 public static final String KEY_FNAME="fname";
 
 public static final String KEY_LNAME="lname";

 
 public SQLiteHelper(Context context) {
 
 super(context, DATABASE_NAME, null, 1);
 
 }

 @Override
 public void onCreate(SQLiteDatabase database) {
 
 String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+KEY_ID+" INTEGER PRIMARY KEY, "+KEY_FNAME+" VARCHAR, "+KEY_LNAME+" VARCHAR)";
 database.execSQL(CREATE_TABLE);

 }

 @Override
 public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
 onCreate(db);

 }

}