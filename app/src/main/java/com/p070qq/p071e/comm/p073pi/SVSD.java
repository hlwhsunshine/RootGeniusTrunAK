package com.p070qq.p071e.comm.p073pi;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;

/* renamed from: com.qq.e.comm.pi.SVSD */
public interface SVSD {
    IBinder onBind(Intent intent);

    void onConfigurationChanged(Configuration configuration);

    void onCreate();

    void onDestroy();

    void onLowMemory();

    void onRebind(Intent intent);

    int onStartCommand(Intent intent, int i, int i2);

    void onTaskRemoved(Intent intent);

    void onTrimMemory(int i);

    boolean onUnbind(Intent intent);
}
