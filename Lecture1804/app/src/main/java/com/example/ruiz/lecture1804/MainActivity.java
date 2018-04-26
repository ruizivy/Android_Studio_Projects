package com.example.ruiz.lecture1804;

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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;

    EditText message, contactnumber;
    Button btn_send;
    ListView lst_Messages;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = (EditText) findViewById(R.id.etMessage);
        contactnumber = (EditText) findViewById(R.id.etContactNumber);

        btn_send = (Button) findViewById(R.id.btnSend);

        lst_Messages = (ListView) findViewById(R.id.lstMessages);

        adapter = new ArrayAdapter<String>(this, R.layout.list_item);
        lst_Messages.setAdapter(adapter);

        Cursor cursor = getContentResolver().query(Uri.parse("content://sms//inbox"), null, null, null, " thread_id ASC ");

        while (cursor.moveToNext()) {
            adapter.add("From: " + cursor.getString(2) + " "
                    + "Message: " + cursor.getString(12));
        }
        cursor.close();

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = contactnumber.getText().toString();
                String mess = message.getText().toString();
                if (number.length() != 0 && mess.length() != 0) {
                    sendMessage(number, mess);
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter a number and message", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void sendMessage(String number, String message) {
        String SENT_MESSAGE = "SMS_SENT";
        String DELIVERED_MESSAGE = "SMS_DELIVERED";

        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0, new Intent(SENT_MESSAGE), 0);

        PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0, new Intent(DELIVERED_MESSAGE), 0);

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context c, Intent i) {
                String status = "";
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        status = "SMS Sent";
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        status = "Cannot send message ";
                        break;
                }
                Toast.makeText(getApplicationContext(), status, Toast.LENGTH_SHORT).show();
            }
        },new IntentFilter(SENT_MESSAGE));

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context c, Intent i) {
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        Toast.makeText(getApplicationContext(), "SMS Delivered", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(getApplicationContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }, new IntentFilter(DELIVERED_MESSAGE));

        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage(number, null, message, sentPI, deliveredPI);

    }
}

