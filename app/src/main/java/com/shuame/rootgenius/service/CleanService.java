package com.shuame.rootgenius.service;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.p015v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.shuame.rootgenius.hook.C1450R;

@SuppressLint({"InlinedApi"})
public class CleanService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (VERSION.SDK_INT < 18) {
            startForeground(C1450R.string.app_name, new Notification());
            return;
        }
        Builder builder = new Builder(this);
        builder.setSmallIcon(C1450R.drawable.transparent);
        builder.setPriority(-2);
        builder.setContent(new RemoteViews(getPackageName(), C1450R.layout.notification_empty));
        startForeground(C1450R.string.app_name, builder.build());
    }

    public void onDestroy() {
        ((NotificationManager) getSystemService("notification")).cancelAll();
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        stopSelf();
        return super.onUnbind(intent);
    }
}
