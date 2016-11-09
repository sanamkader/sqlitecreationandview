package com.sanam.db;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewActivity extends Activity {
 
 SQLiteHelper SQLITEHELPER;
 SQLiteDatabase SQLITEDATABASE;
 Cursor cursor;
 SQLiteListAdapter ListAdapter ;

 ArrayList<String> ID_ArrayList = new ArrayList<String>();
 ArrayList<String> FNAME_ArrayList = new ArrayList<String>();
 ArrayList<String> LNAME_ArrayList = new ArrayList<String>();
 ListView LISTVIEW;

 @Override
 public void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.listview_item);

 LISTVIEW = (ListView) findViewById(R.id.listView1);

 SQLITEHELPER = new SQLiteHelper(this);
 
 }

 @Override
 protected void onResume() {

 ShowSQLiteDBdata() ;
 
 super.onResume();
 }

 private void ShowSQLiteDBdata() {
 
 SQLITEDATABASE = SQLITEHELPER.getWritableDatabase();
 
 cursor = SQLITEDATABASE.rawQuery("SELECT * FROM demoTable", null);

 ID_ArrayList.clear();
 FNAME_ArrayList.clear();
 LNAME_ArrayList.clear();
 
 if (cursor.moveToFirst()) {
 do {
 ID_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_ID)));
 
 FNAME_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_FNAME)));
 
 LNAME_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_LNAME)));


 } while (cursor.moveToNext());
 }
 
 ListAdapter = new SQLiteListAdapter(ListViewActivity.this,
 
 ID_ArrayList,
 FNAME_ArrayList,
 LNAME_ArrayList
 
 );
 
 LISTVIEW.setAdapter(ListAdapter);
 
 cursor.close();
 }
}