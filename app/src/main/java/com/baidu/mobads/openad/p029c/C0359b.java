package com.baidu.mobads.openad.p029c;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.baidu.mobads.AppActivity;
import com.baidu.mobads.command.C0271a;
import com.baidu.mobads.command.p026a.C0270a;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils.ApkInfo;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.p021j.C0336j;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p023b.C0260a;
import com.baidu.mobads.p023b.C0263b;
import com.baidu.mobads.p025c.C0265a;
import com.baidu.mobads.production.C0375a;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

/* renamed from: com.baidu.mobads.openad.c.b */
public class C0359b implements Observer {
    /* renamed from: a */
    private static NotificationManager f759a;
    /* renamed from: b */
    private static int f760b = 10091;
    /* renamed from: g */
    private static HashMap<String, C0359b> f761g = new HashMap();
    /* renamed from: c */
    private C0271a f762c = null;
    /* renamed from: d */
    private Context f763d;
    /* renamed from: e */
    private C0263b f764e = null;
    /* renamed from: f */
    private String f765f = "";
    /* renamed from: h */
    private Handler f766h = new Handler(Looper.getMainLooper());

    public C0359b(Context context, C0271a c0271a) {
        C0338m.m569a().mo5033f().mo4922d("OAdApkDownloaderObserver", "observer created");
        if (f759a == null) {
            f759a = (NotificationManager) context.getSystemService("notification");
        }
        this.f763d = context.getApplicationContext();
        this.f762c = c0271a;
        C0359b.m628a(this.f762c.f472i, this);
    }

    /* renamed from: a */
    public static synchronized C0359b m626a(String str) {
        C0359b c0359b;
        synchronized (C0359b.class) {
            c0359b = (C0359b) f761g.get(str);
        }
        return c0359b;
    }

    /* renamed from: a */
    public static synchronized void m628a(String str, C0359b c0359b) {
        synchronized (C0359b.class) {
            f761g.put(str, c0359b);
        }
    }

    /* renamed from: b */
    public static synchronized C0359b m630b(String str) {
        C0359b c0359b;
        synchronized (C0359b.class) {
            c0359b = (C0359b) f761g.remove(str);
        }
        return c0359b;
    }

    /* renamed from: c */
    public static synchronized int m631c(String str) {
        int i;
        synchronized (C0359b.class) {
            C0359b c0359b = (C0359b) f761g.get(str);
            if (c0359b == null || c0359b.mo5083a() == null) {
                i = f760b;
                f760b = i + 1;
            } else {
                i = c0359b.mo5083a().f469f;
            }
        }
        return i;
    }

    @TargetApi(16)
    /* renamed from: d */
    private Notification m633d() {
        CharSequence charSequence = this.f762c.f464a;
        CharSequence charSequence2 = "正在下载 " + this.f762c.f464a;
        CharSequence charSequence3 = "";
        int i = 17301633;
        Object charSequence4;
        Object charSequence32;
        if (this.f762c.f470g == DownloadStatus.COMPLETED) {
            charSequence4 = this.f762c.f470g.getMessage() + ": " + charSequence4;
            charSequence32 = " 点击这里安装应用";
            i = 17301634;
        } else if (this.f762c.f470g == DownloadStatus.PAUSED) {
            charSequence4 = this.f762c.f470g.getMessage() + ": " + charSequence4;
            Object charSequence22 = "已为您暂停下载， 点击通知栏继续下载";
            charSequence32 = "目前不在wifi网络下， 点击这里继续下载";
            i = 17301634;
        } else if (this.f762c.f470g == DownloadStatus.ERROR) {
            charSequence4 = this.f762c.f470g.getMessage() + ": " + charSequence4;
            charSequence32 = " 稍后点击这里重新下载";
            i = 17301634;
        } else if (this.f762c.f470g == DownloadStatus.DOWNLOADING) {
            charSequence4 = this.f762c.f470g.getMessage() + ": " + charSequence4;
            charSequence32 = "下载进度: " + this.f762c.f468e + "%  应用大小: " + this.f765f;
        } else if (this.f762c.f470g == DownloadStatus.INITING) {
            charSequence4 = this.f762c.f470g.getMessage() + ": " + charSequence4;
            charSequence32 = this.f762c.f470g.getMessage();
        }
        Intent intent = new Intent(this.f763d, AppActivity.class);
        intent.putExtra("dealWithDownload", true);
        intent.putExtra("status", this.f762c.f470g.getCode());
        intent.putExtra(IXAdRequestInfo.PACKAGE, this.f762c.f472i);
        intent.putExtra("localApkPath", this.f762c.f466c + this.f762c.f465b);
        intent.putExtra("title", charSequence4);
        intent.addFlags(268435456);
        intent.setAction(Long.toString(System.currentTimeMillis()));
        PendingIntent activity = PendingIntent.getActivity(this.f763d, this.f762c.f469f, intent, 134217728);
        if (VERSION.SDK_INT >= 16) {
            if (this.f762c.f471h == null) {
                this.f762c.f471h = new Builder(this.f763d);
            }
            return ((Builder) this.f762c.f471h).setContentTitle(charSequence4).setContentText(charSequence32).setTicker(charSequence22).setSmallIcon(i).setContentIntent(activity).setAutoCancel(true).setProgress(100, this.f762c.f468e, false).build();
        }
        if (this.f762c.f471h == null) {
            this.f762c.f471h = new Notification();
        }
        Notification notification = (Notification) this.f762c.f471h;
        notification.icon = i;
        notification.flags |= 16;
        notification.tickerText = charSequence22;
        notification.contentIntent = activity;
        try {
            notification.getClass().getMethod("setLatestEventInfo", new Class[]{Context.class, CharSequence.class, CharSequence.class, PendingIntent.class}).invoke(notification, new Object[]{this.f763d, charSequence4, charSequence32, activity});
            return notification;
        } catch (NoSuchMethodException e) {
            return notification;
        } catch (IllegalAccessException e2) {
            return notification;
        } catch (IllegalArgumentException e3) {
            return notification;
        } catch (InvocationTargetException e4) {
            return notification;
        }
    }

    /* renamed from: d */
    private void m634d(String str) {
        Toast.makeText(this.f763d, str, 0).show();
    }

    /* renamed from: a */
    public C0271a mo5083a() {
        return this.f762c;
    }

    /* renamed from: b */
    public void mo5084b() {
        this.f766h.post(new C0360c(this));
    }

    public void update(Observable observable, Object obj) {
        IOAdDownloader iOAdDownloader = (IOAdDownloader) observable;
        this.f762c.f470g = iOAdDownloader.getState();
        if (this.f762c.f470g == DownloadStatus.DOWNLOADING) {
            if (this.f762c.f467d < 0) {
                C0338m.m569a().mo5033f().mo4922d("OAdApkDownloaderObserver", "download update---mExtraInfo.contentLength < 0");
                this.f762c.f467d = (long) iOAdDownloader.getFileSize();
                this.f762c.f474k = iOAdDownloader.getTargetURL();
                this.f762c.mo4410a(this.f763d);
                this.f765f = String.format(Locale.CHINA, "%.1fM", new Object[]{Float.valueOf(((float) this.f762c.f467d) / 1048576.0f)});
            }
            if (iOAdDownloader.getProgress() > 0.0f) {
                int progress = (int) iOAdDownloader.getProgress();
                if (progress > this.f762c.f468e) {
                    this.f762c.f468e = progress;
                    mo5084b();
                    return;
                }
                return;
            }
            return;
        }
        if (this.f762c.f470g == DownloadStatus.COMPLETED) {
            C0338m.m569a().mo5033f().mo4922d("OAdApkDownloaderObserver", "download success-->>" + iOAdDownloader.getOutputPath());
            boolean z = this.f762c.f475l;
            C0338m.m569a().mo5033f().mo4922d("OAdApkDownloaderObserver", "launch installing .............");
            String str = this.f762c.f466c + this.f762c.f465b;
            if (!this.f762c.f472i.contains(".")) {
                ApkInfo localApkFileInfo = C0338m.m569a().mo5039l().getLocalApkFileInfo(this.f763d, str);
                this.f762c.f472i = localApkFileInfo.packageName;
            }
            if (this.f764e == null) {
                BroadcastReceiver c0260a = new C0260a(this.f762c);
                this.f764e = new C0263b(this.f763d, this.f762c.f472i, new File(str), z);
                this.f764e.mo4391a(c0260a);
                this.f764e.mo4390a();
            }
            C0265a.m334a().mo4394a(this.f763d, this.f762c);
            IXAppInfo a = C0270a.m354a(this.f762c);
            if (a != null) {
                C0375a.m682b().getXMonitorActivation(this.f763d, C0336j.m550a()).addAppInfoForMonitor(a);
            }
        } else if (this.f762c.f470g == DownloadStatus.ERROR) {
            this.f762c.f474k = iOAdDownloader.getTargetURL();
            C0338m.m569a().mo5033f().mo4929e("OAdApkDownloaderObserver", "download failed-->>" + iOAdDownloader.getOutputPath());
            C0265a.m334a().mo4396a(this.f762c);
        } else if (iOAdDownloader.getState() == DownloadStatus.INITING) {
            C0271a c0271a = this.f762c;
            c0271a.f480q++;
        }
        mo5084b();
        this.f762c.mo4410a(this.f763d);
    }
}
