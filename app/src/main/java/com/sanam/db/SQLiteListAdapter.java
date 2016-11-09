package com.sanam.db;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SQLiteListAdapter extends BaseAdapter {
 
 Context context;
 ArrayList<String> userID;
 ArrayList<String> UserFName;
 ArrayList<String> UserLastname;
 ArrayList<String> UserSubject ;
 

 public SQLiteListAdapter(
 Context context2,
 ArrayList<String> id,
 ArrayList<String> fname,
 ArrayList<String> lname
 ) 
 {
 
 this.context = context2;
 this.userID = id;
 this.UserFName = fname;
 this.UserLastname = lname;
 }

 public int getCount() {
 // TODO Auto-generated method stub
 return userID.size();
 }

 public Object getItem(int position) {
 // TODO Auto-generated method stub
 return null;
 }

 public long getItemId(int position) {
 // TODO Auto-generated method stub
 return 0;
 }

 public View getView(int position, View child, ViewGroup parent) {
 
 Holder holder;
 
 LayoutInflater layoutInflater;
 
 if (child == null) {
 layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 child = layoutInflater.inflate(R.layout.listviewdata_layout, null);
 
 holder = new Holder();
 
 holder.textviewid = (TextView) child.findViewById(R.id.textViewID);
 holder.textviewfname = (TextView) child.findViewById(R.id.textViewNAME);
 holder.textviewlname = (TextView) child.findViewById(R.id.textViewPHONE_NUMBER);
 child.setTag(holder);
 
 } else {
 
 holder = (Holder) child.getTag();
 }
 holder.textviewid.setText(userID.get(position));
 holder.textviewfname.setText(UserFName.get(position));
 holder.textviewlname.setText(UserLastname.get(position));

 return child;
 }

 public class Holder {
 TextView textviewid;
 TextView textviewfname;
 TextView textviewlname;
 }

}