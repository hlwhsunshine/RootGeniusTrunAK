package com.shuame.rootgenius.service;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.p015v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.hook.C1450R;
import java.io.File;

@SuppressLint({"InlinedApi"})
/* renamed from: com.shuame.rootgenius.service.j */
public final class C1492j {
    /* renamed from: b */
    private static C1492j f4108b = new C1492j();
    /* renamed from: a */
    private Builder f4109a;

    private C1492j() {
    }

    /* renamed from: a */
    public static C1492j m4165a() {
        return f4108b;
    }

    /* renamed from: a */
    public static void m4166a(Context context, CharSequence charSequence) {
        if (context != null) {
            Builder builder = new Builder(context);
            builder.setContentTitle(context.getString(C1450R.string.app_name));
            builder.setWhen(0);
            builder.setSmallIcon(C1450R.drawable.app_ico);
            if (VERSION.SDK_INT >= 18) {
                builder.setPriority(1);
            }
            builder.setContentText(charSequence);
            builder.setContentIntent(C1492j.m4172c(context));
            Notification build = builder.build();
            build.flags = 16;
            RootGeniusApp.f3301a.notify(C1450R.layout.activity_update_component_fail, build);
        }
    }

    /* renamed from: a */
    public static void m4167a(Context context, CharSequence charSequence, String str) {
        if (context != null) {
            Builder builder = new Builder(context);
            builder.setContentTitle(context.getString(C1450R.string.app_name));
            builder.setWhen(0);
            builder.setSmallIcon(C1450R.drawable.app_ico);
            if (VERSION.SDK_INT >= 18) {
                builder.setPriority(1);
            }
            builder.setContentText(charSequence);
            Uri fromFile = Uri.fromFile(new File(str));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
            builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, 134217728));
            Notification build = builder.build();
            build.flags = 18;
            RootGeniusApp.f3301a.notify(C1450R.layout.activity_update_component_fail, build);
        }
    }

    /* renamed from: a */
    public static void m4168a(Context context, String str, CharSequence charSequence) {
        if (context != null) {
            Builder builder = new Builder(context);
            builder.setContentTitle(str);
            builder.setWhen(0);
            builder.setSmallIcon(C1450R.drawable.app_ico);
            if (VERSION.SDK_INT >= 18) {
                builder.setPriority(1);
            }
            builder.setContentText(charSequence);
            builder.setContentIntent(C1492j.m4172c(context));
            Notification build = builder.build();
            build.flags = 18;
            RootGeniusApp.f3301a.notify(C1450R.layout.activity_update_component_fail, build);
        }
    }

    /* renamed from: a */
    public static void m4169a(Context context, String str, CharSequence charSequence, PendingIntent pendingIntent) {
        if (context != null) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C1450R.layout.notify_new_support);
            remoteViews.setImageViewResource(C1450R.id.notify_support_ico, C1450R.drawable.app_ico);
            remoteViews.setTextViewText(C1450R.id.notify_support_title, str);
            remoteViews.setTextViewText(C1450R.id.notify_support_msg, charSequence);
            Builder builder = new Builder(context);
            builder.setSmallIcon(C1450R.drawable.app_ico_ticker);
            builder.setTicker(str);
            builder.setWhen(0);
            builder.setOngoing(true);
            if (VERSION.SDK_INT >= 18) {
                builder.setPriority(1);
            }
            builder.setContentIntent(pendingIntent);
            builder.setContent(remoteViews);
            builder.setAutoCancel(false);
            Notification build = builder.build();
            build.flags = 18;
            RootGeniusApp.f3301a.notify(C1450R.layout.alert_dialog, build);
        }
    }

    /* renamed from: b */
    public static void m4170b() {
        RootGeniusApp.f3301a.cancel(C1450R.layout.activity_update);
    }

    /* renamed from: b */
    public static void m4171b(Context context) {
        if (context != null) {
            Builder builder = new Builder(context);
            builder.setContentTitle(context.getString(C1450R.string.app_name));
            builder.setWhen(0);
            builder.setSmallIcon(C1450R.drawable.app_ico);
            if (VERSION.SDK_INT >= 18) {
                builder.setPriority(1);
            }
            builder.setContentText("已连接到Root精灵PC版");
            Intent intent = new Intent("com.shuame.rootgenius.openbuildinfunction");
            intent.putExtra("action", "Connection");
            builder.setContentIntent(PendingIntent.getBroadcast(context, 0, intent, 134217728));
            Notification build = builder.build();
            build.flags = 2;
            RootGeniusApp.f3301a.notify(C1450R.layout.ad_fragment_layout, build);
        }
    }

    /* renamed from: c */
    private static PendingIntent m4172c(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        launchIntentForPackage.setPackage(null);
        return PendingIntent.getActivity(context, 0, launchIntentForPackage, 134217728);
    }

    /* renamed from: c */
    public static void m4173c() {
        RootGeniusApp.f3301a.cancel(C1450R.layout.ad_fragment_layout);
    }

    /* renamed from: d */
    public static void m4174d() {
        RootGeniusApp.f3301a.cancel(C1450R.layout.activity_update_component_fail);
    }

    /* renamed from: e */
    public static void m4175e() {
        C1492j.m4170b();
        C1492j.m4174d();
    }

    /* renamed from: a */
    public final C1492j mo7318a(Context context) {
        if (this.f4109a == null) {
            try {
                this.f4109a = new Builder(context);
                if (VERSION.SDK_INT >= 18) {
                    this.f4109a.setPriority(1);
                }
                this.f4109a.setSmallIcon(C1450R.drawable.app_update);
                this.f4109a.setContentIntent(C1492j.m4172c(context)).setWhen(0).setAutoCancel(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    /* renamed from: a */
    public final C1492j mo7319a(CharSequence charSequence) {
        if (this.f4109a != null) {
            this.f4109a.setContentTitle(charSequence);
        }
        return this;
    }

    /* renamed from: a */
    public final void mo7320a(int i) {
        if (this.f4109a != null) {
            this.f4109a.setProgress(100, i, false).setContentText(i + "%");
            Notification build = this.f4109a.build();
            build.flags = 2;
            RootGeniusApp.f3301a.notify(C1450R.layout.activity_update, build);
        }
    }
}
