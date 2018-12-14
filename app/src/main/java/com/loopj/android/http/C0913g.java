package com.loopj.android.http;

import android.os.Message;
import com.p070qq.p071e.comm.constants.ErrorCode.InitError;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

/* renamed from: com.loopj.android.http.g */
public final class C0913g extends C0911e {
    /* renamed from: a */
    private static String[] f2249a = new String[]{"image/jpeg", "image/png"};

    /* renamed from: a */
    protected final void mo6012a(Message message) {
        switch (message.what) {
            case 0:
                ((Integer) ((Object[]) message.obj)[0]).intValue();
                return;
            case 1:
                Object obj = message.obj;
                return;
            default:
                super.mo6012a(message);
                return;
        }
    }

    /* renamed from: a */
    protected final void mo6014a(Throwable th, byte[] bArr) {
        mo6017b(mo6009a(1, new Object[]{th, bArr}));
    }

    /* renamed from: a */
    final void mo6015a(HttpResponse httpResponse) {
        StatusLine statusLine = httpResponse.getStatusLine();
        Header[] headers = httpResponse.getHeaders("Content-Type");
        if (headers.length != 1) {
            mo6014a(new HttpResponseException(statusLine.getStatusCode(), "None, or more than one, Content-Type Header found!"), null);
            return;
        }
        Header header = headers[0];
        int i = 0;
        for (String equals : f2249a) {
            if (equals.equals(header.getValue().trim())) {
                i = 1;
            }
        }
        if (i == 0) {
            mo6014a(new HttpResponseException(statusLine.getStatusCode(), "Content-Type not allowed!"), null);
            return;
        }
        byte[] toByteArray;
        try {
            HttpEntity entity = httpResponse.getEntity();
            toByteArray = EntityUtils.toByteArray(entity != null ? new BufferedHttpEntity(entity) : null);
        } catch (Throwable e) {
            mo6014a(e, null);
            toByteArray = null;
        }
        if (statusLine.getStatusCode() >= InitError.INIT_AD_ERROR) {
            mo6014a(new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()), toByteArray);
        } else {
            mo6017b(mo6009a(0, new Object[]{Integer.valueOf(statusLine.getStatusCode()), toByteArray}));
        }
    }
}
