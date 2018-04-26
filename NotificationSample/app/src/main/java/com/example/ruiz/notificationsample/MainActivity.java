package com.example.ruiz.notificationsample;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int MY_NOTIFICATION_ID = 1;
    private int mNotificationCount = 0;

    private final CharSequence tickerText = "This is really, really super long notification message";
    private final CharSequence contentTitle = "Notification";
    private final CharSequence contentText = "You've been notified";

    private Intent mNotificationIntent;
    private PendingIntent mContentIntent;

    private Uri soundURI = Uri.parse("android.resource://com.example.notificationsample" + R.raw.alarm_rooster);
    private long [] mVibratePattern = { 0, 200, 200, 300};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNotificationIntent = new Intent(getApplicationContext(),NotificationSub.class);
        mNotificationIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContentIntent = PendingIntent.getActivity(getApplicationContext(), 0, mNotificationIntent ,0);

        Button button = (Button) findViewById(R.id.btnNotify);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                Notification.Builder notificationBuilder = new Notification.Builder(getApplicationContext())
                        .setTicker(tickerText)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setAutoCancel(true)
                        .setContentTitle(contentTitle)
                        .setContentText(contentText + " ( " + ++mNotificationCount + " ) ")
                        .setContentIntent(mContentIntent).setSound(soundURI)
                        .setVibrate(mVibratePattern);

                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.notify(MY_NOTIFICATION_ID, notificationBuilder.build());
            }

        });

    }
}
