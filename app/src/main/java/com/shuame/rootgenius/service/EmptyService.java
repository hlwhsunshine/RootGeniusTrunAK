package com.shuame.rootgenius.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class EmptyService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }
}
