package com.shuame.mobile.module.autoboot.service;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.widget.RemoteViews;
import com.shuame.mobile.module.autoboot.C1151a;
import com.shuame.mobile.module.autoboot.p081b.C1155a;
import com.shuame.mobile.module.autoboot.p083c.C1161a;
import com.shuame.mobile.module.autoboot.p084e.C1163a;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.p098b.C1312a.C1308b;
import com.shuame.rootgenius.p098b.C1312a.C1309c;
import com.shuame.rootgenius.p098b.C1312a.C1310d;
import com.shuame.rootgenius.p098b.C1312a.C1311e;
import java.util.List;

public class AutoBootService extends IntentService {
    /* renamed from: a */
    private static final String f3074a = AutoBootService.class.getSimpleName();
    /* renamed from: b */
    private NotificationManager f3075b;
    /* renamed from: c */
    private PendingIntent f3076c;
    /* renamed from: d */
    private int f3077d = 1;

    public AutoBootService() {
        super("AutobootService");
    }

    public void onCreate() {
        this.f3075b = (NotificationManager) getSystemService("notification");
        Intent intent = new Intent();
        intent.setAction("com.shuame.mobile.module.autoboot.START_AUTOBOOT_ACTIVITY_ACTION");
        this.f3076c = PendingIntent.getBroadcast(this, 222, intent, 134217728);
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected void onHandleIntent(Intent intent) {
        C1155a.m3315a().mo6761c();
        List<C1161a> a = C1155a.m3315a().mo6749a(C1161a.f3055c);
        int b = C1155a.m3315a().mo6756b();
        new StringBuilder("num = ").append(a.size());
        if (b > 0 && a.size() > 0) {
            for (C1161a c1161a : a) {
                if (c1161a.f3062j.equals(intent.getStringExtra("INSTALL_PACKAGE"))) {
                    this.f3077d = PreferenceManager.getDefaultSharedPreferences(C1151a.m3312b()).getInt("AUTOBOOT_OPERATE_COUNT", 1);
                    boolean a2 = C1163a.m3344a("AUTOBOOT_OPERATE", false);
                    new StringBuilder("mCount=").append(this.f3077d).append("; isOperate=").append(a2);
                    if (this.f3077d != 3 || a2 || C1323b.m3698d()) {
                        a2 = true;
                    } else {
                        PreferenceManager.getDefaultSharedPreferences(C1151a.m3312b()).edit().putBoolean("AUTOBOOT", false).commit();
                        a2 = false;
                    }
                    if (a2) {
                        Notification notification = new Notification();
                        RemoteViews remoteViews = new RemoteViews(getPackageName(), C1310d.autoboot_notification);
                        int i = C1309c.text_Left;
                        StringBuilder stringBuilder = new StringBuilder();
                        String str = c1161a.f3060h;
                        int i2 = 6;
                        if (b == 1) {
                            i2 = 10;
                        }
                        StringBuilder append = stringBuilder.append(getString(C1311e.notification_auto_boot_find_left) + (str.length() > i2 ? str.substring(0, i2 - 1) + "..." : str) + getString(C1311e.notification_auto_boot_find_right));
                        String string = getString(C1311e.notification_auto_boot);
                        if (b > 1) {
                            string = String.format(getString(C1311e.notification_auto_boot_note_num), new Object[]{Integer.valueOf(b)}) + string;
                        }
                        remoteViews.setTextViewText(i, append.append(string).toString());
                        remoteViews.setViewVisibility(C1309c.text_right, 8);
                        notification.icon = C1308b.autoboot_notification_icon;
                        notification.flags |= 16;
                        notification.contentView = remoteViews;
                        notification.contentIntent = this.f3076c;
                        this.f3075b.notify(333, notification);
                        int i3 = this.f3077d + 1;
                        this.f3077d = i3;
                        PreferenceManager.getDefaultSharedPreferences(C1151a.m3312b()).edit().putInt("AUTOBOOT_OPERATE_COUNT", i3).commit();
                        return;
                    }
                    return;
                }
            }
        }
    }
}
