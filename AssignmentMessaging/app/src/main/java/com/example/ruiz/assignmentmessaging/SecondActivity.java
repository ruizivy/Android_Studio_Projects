package com.example.ruiz.assignmentmessaging;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SecondActivity extends AppCompatActivity {

    TextView txtNumber;
    ListView lstConvo;
    Button send, back;
    EditText txtMessage;
    public static String getnumber = "09281469733";

    String numberto, nameto;
    String contactName;
    String num;
    String thread_id;
    private CustomListConvo adapter;
    ArrayList<ConvoMessages> cnMessage = new ArrayList<ConvoMessages>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtNumber = (TextView) findViewById(R.id.txt_number);
        txtMessage = (EditText) findViewById(R.id.txt_message);

        send = (Button) findViewById(R.id.btnsend);
        send.setOnClickListener(new MyButtonEvent());
        back = (Button) findViewById(R.id.btnback1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        lstConvo = (ListView) findViewById(R.id.lstfrom);

        adapter = new CustomListConvo(this, cnMessage);
        lstConvo.setAdapter(adapter);

        Intent intent = getIntent();
        String nums = intent.getStringExtra("number");
        getnumber = nums;
        String names = intent.getStringExtra("name");
        contactName = names;
        String ids = intent.getStringExtra("thread_id");
        thread_id = ids;

        if (nums != null) {
            LoadMessage(thread_id);
        }
        if (names != null) {
            txtNumber.setText(contactName);
        } else {
            txtNumber.setText(nums);
        }

        Intent dataIntent = getIntent();
        String wala = dataIntent.getStringExtra("wala");
        String num1 = dataIntent.getStringExtra("num");
        String conName = dataIntent.getStringExtra("names");
        if (wala != null) {
            getnumber = num1;
            thread_id = wala;
            if (conName != null) {
                txtNumber.setText(conName);
            } else {
                txtNumber.setText(getnumber);
            }
            LoadMessage(thread_id);
        }

    }

    public class MyButtonEvent implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            String number = getnumber;
            String mess = txtMessage.getText().toString();
            if (number.length() != 0 && mess.length() != 0) {
                sendMessage(number, mess);

            } else {
                Toast.makeText(getApplicationContext(), "Please enter a number and message", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void LoadMessage(String lid) {
        cnMessage.clear();
        Uri mSmsinboxQueryUri = Uri.parse("content://sms");
        String[] projection = new String[]{"_id", "thread_id", "address",
                "person", "date", "body", "type"};

        //Cursor cursor = getContentResolver().query(Telephony.Sms.CONTENT_URI,
        // projection, " thread_id = " + thread_id , null , " thread_id ASC ");

        Cursor cursor1 = getContentResolver().query(mSmsinboxQueryUri, projection, " thread_id = " + lid, null, " thread_id ASC ");

        while (cursor1.moveToNext()) {
            String numberfrom = cursor1.getString(2);
            String body = cursor1.getString(5);
            int type = cursor1.getInt(6);
            Date date1 = new Date(cursor1.getLong(4));
            String formattedDate = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss").format(date1);
            String name = getContactName(
                    getApplicationContext(),
                    cursor1.getString(cursor1
                            .getColumnIndexOrThrow("address")));
            cnMessage.add(new ConvoMessages(numberfrom, body, type, formattedDate, name));
            lstConvo.setAdapter(adapter);
        }
        cursor1.close();
    }

    public String LastInsertID() {
        String id = "";
        Uri mSmsinboxQueryUri = Uri.parse("content://sms");
        String[] projection = new String[]{"_id", "thread_id", "address",
                "person", "date", "body", "type"};
        Cursor cursor = getContentResolver().query(mSmsinboxQueryUri, projection, "address LIKE ?",
                new String[]{getnumber.replace(" ", "") + "%"}, " thread_id ASC ");

        if (cursor.moveToFirst()) {
            do {
                id = cursor.getString(1);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return id;
    }

    private void sendMessage(String number, String message) {
        String SENT_MESSAGE = "SMS_SENT";
        String DELIVERED_MESSAGE = "SMS_DELIVERED";
        PendingIntent sentPI = PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(SENT_MESSAGE), 0);
        PendingIntent deliveredPI = PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(DELIVERED_MESSAGE), 0);
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String status = "";
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        status = "SMS Sent";
                        txtMessage.setText("");
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        status = "Cannot send message";
                        break;
                }
                LoadMessage(thread_id);
                Toast.makeText(getApplicationContext(), status, Toast.LENGTH_SHORT).show();
            }
        }, new IntentFilter(SENT_MESSAGE));
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        //     Toast.makeText(getApplicationContext(),"SMS Delivered",Toast.LENGTH_SHORT).show();break;
                    case Activity.RESULT_CANCELED:
                        //        Toast.makeText(getApplicationContext(),"SMS Cancelled",Toast.LENGTH_SHORT).show();break;
                }
                LoadMessage(thread_id);
            }
        }, new IntentFilter(DELIVERED_MESSAGE));
        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage(number, null, message, sentPI, deliveredPI);
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
