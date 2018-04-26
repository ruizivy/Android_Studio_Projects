package com.example.ruiz.messagingapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by Ruiz on 8/9/2017.
 */

public class SMSReciever extends BroadcastReceiver {
    private static final int MY_NOTIFICATION_ID = 1;
    private int mNotificationCount = 0;

    private final CharSequence tickerText = "This is really, really super long notification message";
    private final CharSequence contentTitle = "Notification";
    private final CharSequence contentText = "New Message";

    private Intent mNotificationIntent;
    private PendingIntent mContentIntent;

    private Uri soundURI = Uri.parse("android.resource://com.example.messagingapp/" + R.raw.alarm_rooster);
    private long [] mVibratePattern = { 0, 200, 200, 300};
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = null;
        String contents = "";
        mNotificationIntent = new Intent(context, MainActivity.class);
        mNotificationIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContentIntent = PendingIntent.getActivity(context, 0, mNotificationIntent, 0);

        if(bundle != null){
            Object[] pdus = (Object[])bundle.get("pdus");
            messages = new SmsMessage[pdus.length];
            for(int i =0; i < messages.length; i++) {
                messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                contents += "Message from : " + messages[i].getOriginatingAddress();
                contents += " : ";
                contents += messages[i].getMessageBody().toString() + "\n";

                Notification.Builder notificationBuilder = new Notification.Builder(context)
                        .setTicker(tickerText)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setAutoCancel(true)
                        .setContentTitle(contentTitle)
                        .setContentText(contentText + " ( " + messages[i].getOriginatingAddress() + " ) ")
                        .setContentIntent(mContentIntent).setSound(soundURI)
                        .setVibrate(mVibratePattern);

                NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.notify(MY_NOTIFICATION_ID, notificationBuilder.build());
                mNotificationManager.notify((int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE), notificationBuilder.build());
            }
                Toast.makeText(context, contents, Toast.LENGTH_SHORT).show();

        }
    }
}
