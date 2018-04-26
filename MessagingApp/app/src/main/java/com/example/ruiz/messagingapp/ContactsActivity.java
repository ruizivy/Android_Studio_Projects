package com.example.ruiz.messagingapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {

    ListView lstContactList;

    ArrayList<Contacts> contactsList = new ArrayList<Contacts>();

    private  Contacts_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        lstContactList = (ListView)findViewById(R.id.lstcontacts);
        lstContactList.setOnItemClickListener(new ItemClickListener());

        adapter = new Contacts_Adapter(ContactsActivity.this , contactsList);
        lstContactList.setAdapter(adapter);

        LoadCOntacts();

    }

    public  void LoadCOntacts(){

        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null , null , null, " display_name ASC ");
        contactsList.clear();

        while (cursor.moveToNext()){
            String name  = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String number =  cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            contactsList.add(new Contacts(name , number));
            lstContactList.setAdapter(adapter);
        }
        cursor.close();
    }
    public class ItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
           Contacts c = contactsList.get(pos);
            String number = c.getNumber();
            String num = number;
            Intent intent = new Intent(ContactsActivity.this , NewMesaageActivity.class);
            intent.putExtra("number", num);
            startActivityForResult(intent , 2);

        }
    }
}
