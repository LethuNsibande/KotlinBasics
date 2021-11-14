package com.nsibandelh.notifications01;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class NotificationView extends Activity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        //--Look up the notification manager service--
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        //--Cancel the notification--
        notificationManager.cancel(getIntent().getExtras().getInt("notificationID"));
    }
}
