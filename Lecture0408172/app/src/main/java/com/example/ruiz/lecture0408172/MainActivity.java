package com.example.ruiz.lecture0408172;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button btn_Read , btn_Call;
    ListView lst_Contacts;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Read =(Button)findViewById(R.id.btnRead);
        btn_Call =(Button)findViewById(R.id.btnCall);

        lst_Contacts =(ListView)findViewById(R.id.lstContacts);

        adapter = new ArrayAdapter<String>(this, R.layout.list_item);
        lst_Contacts.setAdapter(adapter);

        btn_Read.setOnClickListener(new MyButtonListener());
        btn_Call.setOnClickListener(new MyButtonListener());
    }

    private class MyButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(view == btn_Read){
                Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null , null , null, " display_name ASC ");
                adapter.clear();
                while (cursor.moveToNext()){
                    String name  = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String number =  cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    adapter.add(name + " " + number);
                }
                cursor.close();
            }else if(view == btn_Call){
                try{

                    Intent intent  = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:+639281469733"));
                    startActivity(intent);

                }catch (SecurityException e){

                }
            }
        }
    }
}
