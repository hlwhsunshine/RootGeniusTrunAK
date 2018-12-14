package com.tencent.p105mm.opensdk.diffdev.p119a;

import android.os.AsyncTask;
import com.tencent.p105mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.p105mm.opensdk.diffdev.OAuthListener;
import com.tencent.p105mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.f */
final class C1670f extends AsyncTask<Void, Void, C1669a> {
    /* renamed from: l */
    private OAuthListener f4762l;
    /* renamed from: o */
    private String f4763o;
    /* renamed from: u */
    private int f4764u;
    private String url;

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.f$a */
    static class C1669a {
        /* renamed from: n */
        public OAuthErrCode f4759n;
        /* renamed from: v */
        public String f4760v;
        /* renamed from: w */
        public int f4761w;

        C1669a() {
        }

        /* renamed from: b */
        public static com.tencent.p105mm.opensdk.diffdev.p119a.C1670f.C1669a m4573b(byte[] r9) {
            /*
            r8 = 1;
            r7 = 0;
            r0 = new com.tencent.mm.opensdk.diffdev.a.f$a;
            r0.<init>();
            if (r9 == 0) goto L_0x000c;
        L_0x0009:
            r1 = r9.length;
            if (r1 != 0) goto L_0x0018;
        L_0x000c:
            r1 = "MicroMsg.SDK.NoopingResult";
            r2 = "parse fail, buf is null";
            com.tencent.p105mm.opensdk.utils.Log.m4580e(r1, r2);
            r1 = com.tencent.p105mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NetworkErr;
            r0.f4759n = r1;
        L_0x0017:
            return r0;
        L_0x0018:
            r1 = new java.lang.String;	 Catch:{ Exception -> 0x0066 }
            r2 = "utf-8";
            r1.<init>(r9, r2);	 Catch:{ Exception -> 0x0066 }
            r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x004d }
            r2.<init>(r1);	 Catch:{ Exception -> 0x004d }
            r1 = "wx_errcode";
            r1 = r2.getInt(r1);	 Catch:{ Exception -> 0x004d }
            r0.f4761w = r1;	 Catch:{ Exception -> 0x004d }
            r1 = "MicroMsg.SDK.NoopingResult";
            r3 = "nooping uuidStatusCode = %d";
            r4 = 1;
            r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x004d }
            r5 = 0;
            r6 = r0.f4761w;	 Catch:{ Exception -> 0x004d }
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x004d }
            r4[r5] = r6;	 Catch:{ Exception -> 0x004d }
            r3 = java.lang.String.format(r3, r4);	 Catch:{ Exception -> 0x004d }
            com.tencent.p105mm.opensdk.utils.Log.m4579d(r1, r3);	 Catch:{ Exception -> 0x004d }
            r1 = r0.f4761w;	 Catch:{ Exception -> 0x004d }
            switch(r1) {
                case 402: goto L_0x0096;
                case 403: goto L_0x009c;
                case 404: goto L_0x008c;
                case 405: goto L_0x007f;
                case 408: goto L_0x0091;
                case 500: goto L_0x00a2;
                default: goto L_0x0048;
            };	 Catch:{ Exception -> 0x004d }
        L_0x0048:
            r1 = com.tencent.p105mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;	 Catch:{ Exception -> 0x004d }
            r0.f4759n = r1;	 Catch:{ Exception -> 0x004d }
            goto L_0x0017;
        L_0x004d:
            r1 = move-exception;
            r2 = "MicroMsg.SDK.NoopingResult";
            r3 = "parse json fail, ex = %s";
            r4 = new java.lang.Object[r8];
            r1 = r1.getMessage();
            r4[r7] = r1;
            r1 = java.lang.String.format(r3, r4);
            com.tencent.p105mm.opensdk.utils.Log.m4580e(r2, r1);
            r1 = com.tencent.p105mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
            r0.f4759n = r1;
            goto L_0x0017;
        L_0x0066:
            r1 = move-exception;
            r2 = "MicroMsg.SDK.NoopingResult";
            r3 = "parse fail, build String fail, ex = %s";
            r4 = new java.lang.Object[r8];
            r1 = r1.getMessage();
            r4[r7] = r1;
            r1 = java.lang.String.format(r3, r4);
            com.tencent.p105mm.opensdk.utils.Log.m4580e(r2, r1);
            r1 = com.tencent.p105mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
            r0.f4759n = r1;
            goto L_0x0017;
        L_0x007f:
            r1 = com.tencent.p105mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;	 Catch:{ Exception -> 0x004d }
            r0.f4759n = r1;	 Catch:{ Exception -> 0x004d }
            r1 = "wx_code";
            r1 = r2.getString(r1);	 Catch:{ Exception -> 0x004d }
            r0.f4760v = r1;	 Catch:{ Exception -> 0x004d }
            goto L_0x0017;
        L_0x008c:
            r1 = com.tencent.p105mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;	 Catch:{ Exception -> 0x004d }
            r0.f4759n = r1;	 Catch:{ Exception -> 0x004d }
            goto L_0x0017;
        L_0x0091:
            r1 = com.tencent.p105mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;	 Catch:{ Exception -> 0x004d }
            r0.f4759n = r1;	 Catch:{ Exception -> 0x004d }
            goto L_0x0017;
        L_0x0096:
            r1 = com.tencent.p105mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Timeout;	 Catch:{ Exception -> 0x004d }
            r0.f4759n = r1;	 Catch:{ Exception -> 0x004d }
            goto L_0x0017;
        L_0x009c:
            r1 = com.tencent.p105mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Cancel;	 Catch:{ Exception -> 0x004d }
            r0.f4759n = r1;	 Catch:{ Exception -> 0x004d }
            goto L_0x0017;
        L_0x00a2:
            r1 = com.tencent.p105mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;	 Catch:{ Exception -> 0x004d }
            r0.f4759n = r1;	 Catch:{ Exception -> 0x004d }
            goto L_0x0017;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.diffdev.a.f.a.b(byte[]):com.tencent.mm.opensdk.diffdev.a.f$a");
        }
    }

    public C1670f(String str, OAuthListener oAuthListener) {
        this.f4763o = str;
        this.f4762l = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[]{str});
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        C1669a c1669a;
        if (this.f4763o == null || this.f4763o.length() == 0) {
            Log.m4580e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            c1669a = new C1669a();
            c1669a.f4759n = OAuthErrCode.WechatAuth_Err_NormalErr;
            return c1669a;
        }
        while (!isCancelled()) {
            String str = this.url + (this.f4764u == 0 ? "" : "&last=" + this.f4764u);
            long currentTimeMillis = System.currentTimeMillis();
            byte[] a = C1668e.m4572a(str, 60000);
            long currentTimeMillis2 = System.currentTimeMillis();
            c1669a = C1669a.m4573b(a);
            Log.m4579d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", new Object[]{str, c1669a.f4759n.toString(), Integer.valueOf(c1669a.f4761w), Long.valueOf(currentTimeMillis2 - currentTimeMillis)}));
            if (c1669a.f4759n == OAuthErrCode.WechatAuth_Err_OK) {
                this.f4764u = c1669a.f4761w;
                if (c1669a.f4761w == C1671g.UUID_SCANED.getCode()) {
                    this.f4762l.onQrcodeScanned();
                } else if (c1669a.f4761w != C1671g.UUID_KEEP_CONNECT.getCode() && c1669a.f4761w == C1671g.UUID_CONFIRM.getCode()) {
                    if (c1669a.f4760v != null && c1669a.f4760v.length() != 0) {
                        return c1669a;
                    }
                    Log.m4580e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                    c1669a.f4759n = OAuthErrCode.WechatAuth_Err_NormalErr;
                    return c1669a;
                }
            }
            Log.m4580e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", new Object[]{c1669a.f4759n.toString(), Integer.valueOf(c1669a.f4761w)}));
            return c1669a;
        }
        Log.m4581i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
        c1669a = new C1669a();
        c1669a.f4759n = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        return c1669a;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        C1669a c1669a = (C1669a) obj;
        this.f4762l.onAuthFinish(c1669a.f4759n, c1669a.f4760v);
    }
}
