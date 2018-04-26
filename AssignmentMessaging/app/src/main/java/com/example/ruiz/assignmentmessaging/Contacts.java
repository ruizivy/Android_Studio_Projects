package com.example.ruiz.assignmentmessaging;

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

public class Contacts extends AppCompatActivity {
    ListView lstContactList;
    Button btn_back;
    ArrayList<ContactsList> contactsList = new ArrayList<ContactsList>();
    private ContactsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        lstContactList = (ListView) findViewById(R.id.lstcontacts);
        lstContactList.setOnItemClickListener(new ItemClickListener());

        adapter = new ContactsAdapter(this, contactsList);
        lstContactList.setAdapter(adapter);

        btn_back = (Button) findViewById(R.id.btnback2);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Contacts.this, NewMessageActivity.class);
                startActivity(intent);
                finish();
            }
        });

        LoadCOntacts();
    }

    public void LoadCOntacts() {

        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, " display_name ASC ");
        contactsList.clear();

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            contactsList.add(new ContactsList(name, number));
            lstContactList.setAdapter(adapter);
        }
        cursor.close();
    }

    public class ItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
            ContactsList c = contactsList.get(pos);
            String number = c.getNumber();
            String num = number;
            String name = c.getName();
            String name1 = name;
            Intent intent = new Intent(Contacts.this, NewMessageActivity.class);
            intent.putExtra("number", num);
            intent.putExtra("name", name1);
            startActivityForResult(intent, 1);
            finish();
        }
    }

    public String getContactName(Context context, String phoneNumber) {
        ContentResolver cr = context.getContentResolver();
        Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI,
                Uri.encode(phoneNumber));
        Cursor cursor = cr.query(uri,
                new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME}, null, null, null);
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
