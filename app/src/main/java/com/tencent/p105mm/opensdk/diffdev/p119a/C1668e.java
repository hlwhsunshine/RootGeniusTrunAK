package com.tencent.p105mm.opensdk.diffdev.p119a;

import com.tencent.p105mm.opensdk.utils.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.e */
public final class C1668e {
    /* renamed from: a */
    public static byte[] m4572a(String str, int i) {
        byte[] bArr = null;
        if (str == null || str.length() == 0) {
            Log.m4580e("MicroMsg.SDK.NetUtil", "httpGet, url is null");
            return bArr;
        }
        HttpClient defaultHttpClient = new DefaultHttpClient();
        HttpUriRequest httpGet = new HttpGet(str);
        if (i >= 0) {
            try {
                HttpConnectionParams.setSoTimeout(defaultHttpClient.getParams(), i);
            } catch (Exception e) {
                Log.m4580e("MicroMsg.SDK.NetUtil", "httpGet, Exception ex = " + e.getMessage());
                return bArr;
            } catch (IncompatibleClassChangeError e2) {
                Log.m4580e("MicroMsg.SDK.NetUtil", "httpGet, IncompatibleClassChangeError ex = " + e2.getMessage());
                return bArr;
            } catch (Throwable th) {
                Log.m4580e("MicroMsg.SDK.NetUtil", "httpGet, Throwable ex = " + th.getMessage());
                return bArr;
            }
        }
        HttpResponse execute = defaultHttpClient.execute(httpGet);
        if (execute.getStatusLine().getStatusCode() == 200) {
            return EntityUtils.toByteArray(execute.getEntity());
        }
        Log.m4580e("MicroMsg.SDK.NetUtil", "httpGet fail, status code = " + execute.getStatusLine().getStatusCode());
        return bArr;
    }
}
