package com.example.ruiz.messagingapp;

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
    Button send;
    EditText txtMessage;
    public  static String getnumber = "09281469733";

    String numberto , nameto;
    String contactName;
    String num;
    int thread_id;
    private CustomListConvo adapter;
    ArrayList<ConvoMessages> cnMessage = new ArrayList<ConvoMessages>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtNumber = (TextView) findViewById(R.id.txt_number);
        txtMessage = (EditText)findViewById(R.id.txt_message);

        send = (Button)findViewById(R.id.btnsend);
        send.setOnClickListener(new MyButtonEvent());

        lstConvo = (ListView) findViewById(R.id.lstfrom);

        adapter = new CustomListConvo(this , cnMessage);
        lstConvo.setAdapter(adapter);

        Intent intent = getIntent();
        String nums = intent.getStringExtra("number");
        getnumber = nums;
        String names = intent.getStringExtra("name");
        contactName = names;
        int ids = intent.getIntExtra("thread_id" , 1);
        thread_id = ids;
        LoadMessage();
        txtNumber.setText(contactName);
        setResult(1, intent);
        Intent dataIntent = getIntent();
        String wala = dataIntent.getStringExtra("number");
        if(wala != null) {
            getnumber = wala;
            txtNumber.setText(getnumber);
            LoadMessage();
            setResult(3, dataIntent);
        }
    }

    public class MyButtonEvent implements View.OnClickListener{

        @Override
        public void onClick(View view) {

            String number = getnumber;
            String mess = txtMessage.getText().toString();
            if (number.length() != 0 && mess.length() != 0) {
                sendMessage(number, mess);
                num = number;
            } else {
                Toast.makeText(getApplicationContext(), "Please enter a number and message", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public  void LoadMessage() {
        cnMessage.clear();
        Uri mSmsinboxQueryUri = Uri.parse("content://sms");
        String numIn = "09360273537";
        String[] projection = new String[]{"_id", "thread_id", "address",
                "person", "date", "body", "type"};

        //Cursor cursor = getContentResolver().query(Telephony.Sms.CONTENT_URI,
               // projection, " thread_id = " + thread_id , null , " thread_id ASC ");
        Cursor cursor = getContentResolver().query(mSmsinboxQueryUri,
                projection, "address LIKE ?", new String[]{getnumber + "%" }, " thread_id ASC ");


        // Cursor cursor = getContentResolver().query(mSmsinboxQueryUri,
        //        projection, " address = " + getnumber, null, " thread_id ASC ");
        //Cursor cursor = getContentResolver().query(Uri.parse("content://sms//inbox"), null, " thread_id IS NOT NULL) GROUP BY (thread_id ", null, "thread_id DESC");
        while (cursor.moveToNext()) {
            String numberfrom = cursor.getString(2);
            String body = cursor.getString(5);
            int type = cursor.getInt(6);
            Date date1 = new Date(cursor.getLong(4));
            String formattedDate = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss").format(date1);
            String name = getContactName(
                    getApplicationContext(),
                    cursor.getString(cursor
                            .getColumnIndexOrThrow("address")));
            cnMessage.add(new ConvoMessages(numberfrom, body, type , formattedDate , name));
            lstConvo.setAdapter(adapter);
        }
        cursor.close();
    }
    private void sendMessage(String number, String message){
        String SENT_MESSAGE = "SMS_SENT";
        String DELIVERED_MESSAGE = "SMS_DELIVERED";
        PendingIntent sentPI = PendingIntent.getBroadcast(getApplicationContext(),0,new Intent(SENT_MESSAGE),0);
        PendingIntent deliveredPI = PendingIntent.getBroadcast(getApplicationContext(),0,new Intent(DELIVERED_MESSAGE),0);
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String status = "";
                switch (getResultCode()){
                    case Activity.RESULT_OK:
                        status = "SMS Sent";
                        LoadMessage();
                        txtMessage.setText("");
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        status = "Cannot send message";
                        break;
                }
                Toast.makeText(getApplicationContext(),status,Toast.LENGTH_SHORT).show();
            }
        }, new IntentFilter(SENT_MESSAGE));
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                switch (getResultCode()){
                    case Activity.RESULT_OK:
                        Toast.makeText(getApplicationContext(),"SMS Delivered",Toast.LENGTH_SHORT).show();break;
                    case Activity.RESULT_CANCELED:
                        Toast.makeText(getApplicationContext(),"SMS Cancelled",Toast.LENGTH_SHORT).show();break;
                }
            }
        },new IntentFilter(DELIVERED_MESSAGE));
        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage(number,null,message,sentPI,deliveredPI);
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
