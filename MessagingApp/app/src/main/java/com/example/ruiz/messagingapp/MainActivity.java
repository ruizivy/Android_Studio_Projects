package com.example.ruiz.messagingapp;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lstMessage;
    Button add;

    private CustomListMain adapter;

    ArrayList<AllMessages> messages = new ArrayList<AllMessages>();
    String number;
    String name;
    int thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button)findViewById(R.id.btnaddnew);
        add.setOnClickListener(new MyButtonEvent());

        lstMessage = (ListView)findViewById(R.id.lsttitle);
        lstMessage.setOnItemClickListener(new ItemlistClick());

        adapter = new CustomListMain(this, messages);
        lstMessage.setAdapter(adapter);

        LoadMessage();
    }
    public  void LoadMessage(){
        messages.clear();
        Uri mSmsinboxQueryUri = Uri.parse("content://sms");
        String[] projection = new String[] { "_id", "thread_id", "address",
                "person", "date", "body", "type" };
       // Cursor cursor = getContentResolver().query(mSmsinboxQueryUri,
          //      projection, "address LIKE ?", new String[]{" thread_id "+ "%" }," thread_id IS NOT NULL) GROUP BY (thread_id ", " thread_id DESC ");
        Cursor cursor = getContentResolver().query(mSmsinboxQueryUri,projection, " thread_id IS NOT NULL) GROUP BY (thread_id ", null, " date DESC ");
        while (cursor.moveToNext()) {
            String number = cursor.getString(2);
            String name = getContactName(getApplicationContext(), cursor.getString(2));
            String message = cursor.getString(5);
            int thread = cursor.getInt(1);

            messages.add(new AllMessages(name, number , message, thread));
            lstMessage.setAdapter(adapter);
        }
        cursor.close();
    }
    public  class MyButtonEvent implements View.OnClickListener{
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(MainActivity.this , NewMesaageActivity.class);
            startActivity(intent);
        }
    }
    public class ItemlistClick implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            AllMessages a = messages.get(i);
            number = a.getNumber();
            String num = number;
            name = a.getName();
            String conName = name;
            thread = a.getThread();
            int id = thread;
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("number", num);
            intent.putExtra("name" , conName);
            intent.putExtra("thread_id" , id);
            startActivityForResult(intent , 1);
        }
    }
    public String getContactName(Context context, String phoneNumber) {
        ContentResolver cr = context.getContentResolver();
        Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI,
                Uri.encode(phoneNumber));
        Cursor cursor = cr.query(uri,
                new String[] { ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME }, null, null, null);
        if (cursor == null) {
            return null;
        }
        String contactName = null;
        if (cursor.moveToFirst()) {
            contactName = cursor.getString(cursor
                    .getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME));
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return contactName;
    }
}
