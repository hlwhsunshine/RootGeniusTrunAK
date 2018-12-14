package com.baidu.mobads.p021j;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.openad.p029c.C0361d;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

/* renamed from: com.baidu.mobads.j.g */
public class C0333g {
    /* renamed from: a */
    protected final long f674a = 604800000;
    /* renamed from: b */
    private Context f675b;

    /* renamed from: com.baidu.mobads.j.g$a */
    class C0332a implements Observer {
        /* renamed from: b */
        private final Handler f672b;
        /* renamed from: c */
        private final String f673c;

        public C0332a(Handler handler, String str) {
            this.f672b = handler;
            this.f673c = str;
        }

        public void update(Observable observable, Object obj) {
            IOAdDownloader iOAdDownloader = (IOAdDownloader) observable;
            if (iOAdDownloader.getState() == DownloadStatus.COMPLETED) {
                C0333g.this.m545a(this.f672b, iOAdDownloader.getOutputPath());
                C0333g.this.mo5023a(this.f673c);
            }
            if (iOAdDownloader.getState() == DownloadStatus.ERROR) {
                C0333g.this.m543a(this.f672b);
                C0333g.this.mo5023a(this.f673c);
            }
        }
    }

    public C0333g(Context context) {
        this.f675b = context;
    }

    /* renamed from: a */
    private void m543a(Handler handler) {
        m544a(handler, Boolean.valueOf(false), null);
    }

    /* renamed from: a */
    private void m544a(Handler handler, Boolean bool, String str) {
        try {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 0;
            Bundle bundle = new Bundle();
            bundle.putBoolean("caching_result", bool.booleanValue());
            bundle.putString("local_creative_url", str);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
        } catch (Throwable e) {
            C0336j.m550a().mo4924d(e);
        }
    }

    /* renamed from: a */
    private void m545a(Handler handler, String str) {
        m544a(handler, Boolean.valueOf(true), str);
    }

    /* renamed from: a */
    public void mo5023a(String str) {
        new Thread(new C0334h(this, str)).start();
    }

    /* renamed from: a */
    public void mo5024a(String str, String str2, String str3, Handler handler) {
        File file = new File(str2 + str3);
        if (file.exists()) {
            m545a(handler, file.getAbsolutePath());
            return;
        }
        try {
            IOAdDownloader createSimpleFileDownloader = C0361d.m637a(this.f675b).createSimpleFileDownloader(new URL(str), str2, str3, false);
            createSimpleFileDownloader.addObserver(new C0332a(handler, str2));
            createSimpleFileDownloader.start();
        } catch (MalformedURLException e) {
            m543a(handler);
        }
    }
}
