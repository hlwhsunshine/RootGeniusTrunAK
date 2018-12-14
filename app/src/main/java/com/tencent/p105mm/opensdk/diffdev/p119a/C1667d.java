package com.tencent.p105mm.opensdk.diffdev.p119a;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Base64;
import com.tencent.p105mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.p105mm.opensdk.diffdev.OAuthListener;
import com.tencent.p105mm.opensdk.utils.Log;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.d */
public final class C1667d extends AsyncTask<Void, Void, C1666a> {
    /* renamed from: h */
    private static final String f4753h = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/oauth_qrcode.png");
    /* renamed from: i */
    private static String f4754i;
    private String appId;
    /* renamed from: j */
    private String f4755j;
    /* renamed from: k */
    private String f4756k;
    /* renamed from: l */
    private OAuthListener f4757l;
    /* renamed from: m */
    private C1670f f4758m;
    private String scope;
    private String signature;

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.d$a */
    static class C1666a {
        /* renamed from: n */
        public OAuthErrCode f4746n;
        /* renamed from: o */
        public String f4747o;
        /* renamed from: p */
        public String f4748p;
        /* renamed from: q */
        public String f4749q;
        /* renamed from: r */
        public int f4750r;
        /* renamed from: s */
        public String f4751s;
        /* renamed from: t */
        public byte[] f4752t;

        private C1666a() {
        }

        /* renamed from: a */
        public static C1666a m4570a(byte[] bArr) {
            C1666a c1666a = new C1666a();
            if (bArr == null || bArr.length == 0) {
                Log.m4580e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
                c1666a.f4746n = OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                        int i = jSONObject.getInt("errcode");
                        if (i != 0) {
                            Log.m4580e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", new Object[]{Integer.valueOf(i)}));
                            c1666a.f4746n = OAuthErrCode.WechatAuth_Err_NormalErr;
                            c1666a.f4750r = i;
                            c1666a.f4751s = jSONObject.optString("errmsg");
                        } else {
                            String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                            if (string == null || string.length() == 0) {
                                Log.m4580e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                                c1666a.f4746n = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                            } else {
                                byte[] decode = Base64.decode(string, 0);
                                if (decode == null || decode.length == 0) {
                                    Log.m4580e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                                    c1666a.f4746n = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                                } else {
                                    c1666a.f4746n = OAuthErrCode.WechatAuth_Err_OK;
                                    c1666a.f4752t = decode;
                                    c1666a.f4747o = jSONObject.getString("uuid");
                                    c1666a.f4748p = jSONObject.getString("appname");
                                    Log.m4579d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", new Object[]{c1666a.f4747o, c1666a.f4748p, Integer.valueOf(c1666a.f4752t.length)}));
                                }
                            }
                        }
                    } catch (Exception e) {
                        Log.m4580e("MicroMsg.SDK.GetQRCodeResult", String.format("parse json fail, ex = %s", new Object[]{e.getMessage()}));
                        c1666a.f4746n = OAuthErrCode.WechatAuth_Err_NormalErr;
                    }
                } catch (Exception e2) {
                    Log.m4580e("MicroMsg.SDK.GetQRCodeResult", String.format("parse fail, build String fail, ex = %s", new Object[]{e2.getMessage()}));
                    c1666a.f4746n = OAuthErrCode.WechatAuth_Err_NormalErr;
                }
            }
            return c1666a;
        }
    }

    static {
        f4754i = null;
        f4754i = "https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
    }

    public C1667d(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.appId = str;
        this.scope = str2;
        this.f4755j = str3;
        this.f4756k = str4;
        this.signature = str5;
        this.f4757l = oAuthListener;
    }

    /* renamed from: a */
    public final boolean mo7687a() {
        Log.m4581i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        return this.f4758m == null ? cancel(true) : this.f4758m.cancel(true);
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        Log.m4581i("MicroMsg.SDK.GetQRCodeTask", "external storage available = false");
        String format = String.format(f4754i, new Object[]{this.appId, this.f4755j, this.f4756k, this.scope, this.signature});
        long currentTimeMillis = System.currentTimeMillis();
        byte[] a = C1668e.m4572a(format, -1);
        Log.m4579d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", new Object[]{format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
        return C1666a.m4570a(a);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        C1666a c1666a = (C1666a) obj;
        if (c1666a.f4746n == OAuthErrCode.WechatAuth_Err_OK) {
            Log.m4579d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success");
            this.f4757l.onAuthGotQrcode(c1666a.f4749q, c1666a.f4752t);
            this.f4758m = new C1670f(c1666a.f4747o, this.f4757l);
            C1670f c1670f = this.f4758m;
            if (VERSION.SDK_INT >= 11) {
                c1670f.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else {
                c1670f.execute(new Void[0]);
                return;
            }
        }
        Log.m4580e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", new Object[]{c1666a.f4746n}));
        this.f4757l.onAuthFinish(c1666a.f4746n, null);
    }
}
