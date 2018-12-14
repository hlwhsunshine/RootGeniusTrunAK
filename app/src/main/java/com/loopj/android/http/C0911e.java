package com.loopj.android.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.p070qq.p071e.comm.constants.ErrorCode.InitError;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

/* renamed from: com.loopj.android.http.e */
public class C0911e {
    /* renamed from: a */
    private boolean f2246a;
    /* renamed from: b */
    private Handler f2247b;

    public C0911e() {
        if (Looper.myLooper() != null) {
            this.f2247b = new C0912f(this);
        }
    }

    /* renamed from: a */
    protected final Message mo6009a(int i, Object obj) {
        if (this.f2247b != null) {
            return this.f2247b.obtainMessage(i, obj);
        }
        Message message = new Message();
        message.what = i;
        message.obj = obj;
        return message;
    }

    /* renamed from: a */
    protected final void mo6010a() {
        mo6017b(mo6009a(2, null));
    }

    /* renamed from: a */
    public void mo6011a(int i, String str) {
    }

    /* renamed from: a */
    protected void mo6012a(Message message) {
        Object[] objArr;
        switch (message.what) {
            case 0:
                objArr = (Object[]) message.obj;
                mo6011a(((Integer) objArr[0]).intValue(), (String) objArr[1]);
                return;
            case 1:
                objArr = (Object[]) message.obj;
                mo6013a((Throwable) objArr[0], (String) objArr[1]);
                return;
            case 4:
                ((Integer) ((Object[]) message.obj)[0]).intValue();
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo6013a(Throwable th, String str) {
    }

    /* renamed from: a */
    protected void mo6014a(Throwable th, byte[] bArr) {
        mo6017b(mo6009a(1, new Object[]{th, bArr}));
    }

    /* renamed from: a */
    void mo6015a(HttpResponse httpResponse) {
        String str = null;
        StatusLine statusLine = httpResponse.getStatusLine();
        try {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                str = EntityUtils.toString(new BufferedHttpEntity(entity), "UTF-8");
            }
        } catch (Throwable e) {
            mo6018b(e, null);
        }
        if (statusLine.getStatusCode() >= InitError.INIT_AD_ERROR) {
            mo6018b(new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()), str);
            return;
        }
        int statusCode = statusLine.getStatusCode();
        mo6017b(mo6009a(0, new Object[]{new Integer(statusCode), str}));
    }

    /* renamed from: b */
    protected final void mo6016b() {
        mo6017b(mo6009a(3, null));
    }

    /* renamed from: b */
    protected final void mo6017b(Message message) {
        if (this.f2246a || this.f2247b == null) {
            mo6012a(message);
        } else {
            this.f2247b.sendMessage(message);
        }
    }

    /* renamed from: b */
    protected final void mo6018b(Throwable th, String str) {
        mo6017b(mo6009a(1, new Object[]{th, str}));
    }
}
