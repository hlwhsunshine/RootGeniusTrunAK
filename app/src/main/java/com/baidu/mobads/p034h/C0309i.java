package com.baidu.mobads.p034h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.p034h.C0307g.C0304a;

/* renamed from: com.baidu.mobads.h.i */
class C0309i extends Handler {
    /* renamed from: a */
    final /* synthetic */ C0307g f581a;

    C0309i(C0307g c0307g, Looper looper) {
        this.f581a = c0307g;
        super(looper);
    }

    public void handleMessage(Message message) {
        C0302e c0302e = (C0302e) message.getData().getParcelable("APK_INFO");
        if ("OK".equals(message.getData().getString("CODE"))) {
            C0298b c0298b = new C0298b(c0302e.mo4495e(), this.f581a.f578k, c0302e);
            try {
                if (this.f581a.f574f == C0307g.f571e) {
                    c0298b.mo4482a();
                    c0298b.mo4483a(this.f581a.mo4510e());
                    if (C0307g.f569b != null) {
                        C0307g.f569b.f537a = c0302e.mo4491b();
                    }
                } else {
                    this.f581a.m439a(c0298b);
                    c0298b.mo4483a(this.f581a.mo4510e());
                    this.f581a.m444a(true);
                }
                c0298b.delete();
                return;
            } catch (C0304a e) {
                String str = "download apk file failed: " + e.toString();
                this.f581a.m444a(false);
                this.f581a.f579l.mo4929e("XAdApkLoader", str);
                c0298b.delete();
                return;
            } catch (Throwable th) {
                c0298b.delete();
                throw th;
            }
        }
        this.f581a.f579l.mo4929e("XAdApkLoader", "mOnApkDownloadCompleted: download failed, code: " + r1);
        this.f581a.m444a(false);
    }
}
