package com.example.ruiz.assignmentmessaging;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewMessageActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    private static final int MY_NOTIFICATION_ID = 1;
    private int mNotificationCount = 1;
    String sender = "";
    String body = "";

    private final CharSequence tickerText = "This is really, really super long notification message";
    private final CharSequence contentTitle = "Notification";
    private final CharSequence contentText = "New Message";

    private Intent mNotificationIntent;
    private PendingIntent mContentIntent;

    private Uri soundURI = Uri.parse("android.resource://com.example.ruiz.assignmentmessaging/" + R.raw.alarm_rooster);
    private long[] mVibratePattern = {0, 200, 200, 300};


    Button add_message, btn_contacts, btnBacks;
    EditText lbl_contacts, lblnew_messages;
    Intent dataIntent;
    String num;
    String numberID;
    String name;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
        add_message = (Button) findViewById(R.id.btnnewsend);
        add_message.setOnClickListener(new MyButtonEvent());

        btn_contacts = (Button) findViewById(R.id.btncontacts);
        btn_contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewMessageActivity.this, Contacts.class);
                startActivityForResult(intent, 1);

            }
        });
        btnBacks = (Button) findViewById(R.id.btnback);
        btnBacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewMessageActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        lbl_contacts = (EditText) findViewById(R.id.lblContacts);
        lblnew_messages = (EditText) findViewById(R.id.txt_newmessage);

        dataIntent = getIntent();
        String getnum = dataIntent.getStringExtra("number");
        num = getnum;
        name = dataIntent.getStringExtra("name");
        lbl_contacts.setText(name);
        setResult(2, dataIntent);
    }

    public class MyButtonEvent implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (num != null) {
                String number = num.replace(" ", "");
                String mess = lblnew_messages.getText().toString();
                if (number.length() != 0 && mess.length() != 0) {
                    sendMessage(number, mess);
                    numberID = number;

                } else {
                    Toast.makeText(getApplicationContext(), "Please enter a number and message", Toast.LENGTH_SHORT).show();
                }
            } else {
                String number = lbl_contacts.getText().toString();
                String mess = lblnew_messages.getText().toString();
                if (number.length() != 0 && mess.length() != 0) {
                    sendMessage(number, mess);
                    numberID = number;
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter a number and message", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    public void newIntent(){
        intent = new Intent(NewMessageActivity.this , SecondActivity.class);
        String wala = numberID;
        String names = name;
        intent.putExtra("num" , wala);
        intent.putExtra("wala", getThreadID(numberID));
        intent.putExtra("names", names);
        startActivity(intent);
      //startActivityForResult(1, intent);
        finish();
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
                        newIntent();
                        lbl_contacts.setText("");
                        lblnew_messages.setText("");
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        status = "Cannot send message";
                        break;
                }
                Toast.makeText(getApplicationContext(), status, Toast.LENGTH_SHORT).show();
            }
        }, new IntentFilter(SENT_MESSAGE));
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        //  Toast.makeText(getApplicationContext(),"SMS Delivered",Toast.LENGTH_SHORT).show();break;
                    case Activity.RESULT_CANCELED:
                        //Toast.makeText(getApplicationContext(),"SMS Cancelled",Toast.LENGTH_SHORT).show();break;
                }
            }
        }, new IntentFilter(DELIVERED_MESSAGE));
        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage(number, null, message, sentPI, deliveredPI);
    }
    public String getThreadID(String lid) {
        String id = "";
        Uri mSmsinboxQueryUri = Uri.parse("content://sms");
        String[] projection = new String[]{"_id", "thread_id", "address",
                "person", "date", "body", "type"};
        Cursor cursor = getContentResolver().query(mSmsinboxQueryUri, projection, "address LIKE ?",
                new String[]{lid.replace(" ", "") + "%"}, " thread_id ASC ");

        if (cursor.moveToFirst()) {
            do {
                id = cursor.getString(1);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return id;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            if (resultCode == 2) {
                dataIntent = getIntent();
                String num = dataIntent.getStringExtra("number");
                lbl_contacts.setText(num);
                setResult(2, dataIntent);
                finish();
            }
        }
    }
}
