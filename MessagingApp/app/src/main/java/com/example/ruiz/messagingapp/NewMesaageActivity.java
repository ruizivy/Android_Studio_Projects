package com.example.ruiz.messagingapp;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NewMesaageActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;

    Button add_message , btn_contacts;
    EditText lbl_contacts , lblnew_messages;
    Intent dataIntent;
    String num;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_mesaage);

        add_message =(Button)findViewById(R.id.btnnewsend);
        add_message.setOnClickListener(new MyButtonEvent());

        btn_contacts = (Button)findViewById(R.id.btncontacts);
        btn_contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewMesaageActivity.this , ContactsActivity.class);
                startActivityForResult(intent , 1);
            }
        });

        lbl_contacts = (EditText)findViewById(R.id.lblContacts);
        lblnew_messages = (EditText)findViewById(R.id.txt_newmessage);

        dataIntent = getIntent();
        String num = dataIntent.getStringExtra("number");
        lbl_contacts.setText(num);
        setResult(2 , dataIntent);

    }
    public class MyButtonEvent implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String number = lbl_contacts.getText().toString();
            String mess = lblnew_messages.getText().toString();
            if (number.length() != 0 && mess.length() != 0) {
                sendMessage(number, mess);
               num = number;
                //lbl_contacts.setText("");
                //lblnew_messages.setText("");
            } else {
                Toast.makeText(getApplicationContext(), "Please enter a number and message", Toast.LENGTH_SHORT).show();
            }
        }
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
                        intent = new Intent(NewMesaageActivity.this, SecondActivity.class);
                        String wala = num;
                        intent.putExtra("number", wala);
                        startActivityForResult(intent , 3);
                        lbl_contacts.setText("");
                        lblnew_messages.setText("");
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        status = "Cannot send message";
                      //  lbl_contacts.setText("");
                        //lblnew_messages.setText("");
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2){
            if(resultCode == 2){
                dataIntent = getIntent();
                String num = dataIntent.getStringExtra("number");
                lbl_contacts.setText(num);
                setResult(2 , dataIntent);
                finish();
            }
        }
    }

}
