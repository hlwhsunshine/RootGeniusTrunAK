package com.kingroot.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.kingroot.sdk.by */
public class C0692by extends Handler {
    /* renamed from: dA */
    private LinkedBlockingQueue<C0672b> f1695dA;
    /* renamed from: dB */
    private C0694bz<C0689bx> f1696dB;
    /* renamed from: dC */
    private C0669a f1697dC;
    /* renamed from: dz */
    private String f1698dz;
    private Context mContext;

    /* renamed from: com.kingroot.sdk.by$a */
    public interface C0669a {
        /* renamed from: a */
        void mo5651a(C0689bx c0689bx);

        /* renamed from: b */
        void mo5652b(C0689bx c0689bx);
    }

    /* renamed from: com.kingroot.sdk.by$b */
    public interface C0672b {
        String getLocalName();

        String getUrl();
    }

    /* renamed from: com.kingroot.sdk.by$1 */
    class C06911 extends C0690cc<C0689bx> {
        C06911() {
        }

        /* renamed from: c */
        public void mo5660b(C0689bx c0689bx) {
            C0692by.this.f1696dB = null;
            C0692by.this.sendMessage(C0692by.this.obtainMessage(2, c0689bx));
        }

        /* renamed from: d */
        public void mo5659a(C0689bx c0689bx) {
            C0692by.this.f1696dB = null;
            C0692by.this.sendMessage(C0692by.this.obtainMessage(3, c0689bx));
        }
    }

    public C0692by(Context context, String str, C0669a c0669a) {
        super(context.getMainLooper());
        this.mContext = context;
        this.f1698dz = str;
        this.f1697dC = c0669a;
    }

    /* renamed from: af */
    private void m1653af() {
        if (this.f1695dA != null && this.f1696dB == null) {
            C0672b c0672b;
            do {
                c0672b = (C0672b) this.f1695dA.poll();
                if (c0672b == null) {
                    return;
                }
            } while (!m1654f(c0672b.getLocalName(), c0672b.getUrl()));
        }
    }

    /* renamed from: f */
    private boolean m1654f(String str, String str2) {
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            return false;
        }
        this.f1696dB = new C0694bz(this.mContext, new C0689bx(str, str2));
        this.f1696dB.mo5668C(this.f1698dz);
        this.f1696dB.mo5669a(new C06911());
        this.f1696dB.mo5670ag();
        return true;
    }

    /* renamed from: g */
    public void mo5666g(List<C0672b> list) {
        if (list != null && list.size() > 0) {
            if (this.f1695dA == null) {
                this.f1695dA = new LinkedBlockingQueue();
            }
            for (int i = 0; i < list.size(); i++) {
                this.f1695dA.offer(list.get(i));
            }
        }
        sendEmptyMessage(1);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                m1653af();
                return;
            case 2:
                if (!(message.obj == null || !(message.obj instanceof C0689bx) || this.f1697dC == null)) {
                    this.f1697dC.mo5651a((C0689bx) message.obj);
                }
                m1653af();
                return;
            case 3:
                if (!(message.obj == null || !(message.obj instanceof C0689bx) || this.f1697dC == null)) {
                    this.f1697dC.mo5652b((C0689bx) message.obj);
                }
                m1653af();
                return;
            default:
                return;
        }
    }
}
