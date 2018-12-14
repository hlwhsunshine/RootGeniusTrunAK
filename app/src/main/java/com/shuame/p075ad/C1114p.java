package com.shuame.p075ad;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.text.TextUtils;
import com.google.gson.C0479d;
import com.google.gson.p051a.C0471c;
import com.shuame.p075ad.ChannelConfig.PositionConfig;
import com.shuame.utils.C1620d;
import com.shuame.utils.NetworkUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.shuame.ad.p */
class C1114p {
    /* renamed from: a */
    private static final String f2989a = C1114p.class.getSimpleName();
    /* renamed from: b */
    private ChannelConfig f2990b;
    /* renamed from: c */
    private ChannelConfig f2991c;
    /* renamed from: d */
    private volatile boolean f2992d;
    /* renamed from: e */
    private volatile boolean f2993e;
    /* renamed from: f */
    private Context f2994f;
    /* renamed from: g */
    private C0479d f2995g;
    /* renamed from: h */
    private long f2996h;

    /* renamed from: com.shuame.ad.p$a */
    private static class C1112a {
        @C0471c(a = "imei")
        /* renamed from: a */
        public String f2984a;
        @C0471c(a = "imsi")
        /* renamed from: b */
        public String f2985b;
        @C0471c(a = "mac_address")
        /* renamed from: c */
        public String f2986c;
        @C0471c(a = "qimei")
        /* renamed from: d */
        public String f2987d;

        private C1112a() {
        }

        /* synthetic */ C1112a(byte b) {
            this();
        }
    }

    /* renamed from: com.shuame.ad.p$b */
    private static class C1113b {
        /* renamed from: a */
        private static final C1114p f2988a = new C1114p();
    }

    private C1114p() {
        this.f2992d = false;
        this.f2993e = false;
    }

    /* synthetic */ C1114p(byte b) {
        this();
    }

    /* renamed from: a */
    protected static C1114p m3236a() {
        return C1113b.f2988a;
    }

    /* renamed from: a */
    private static void m3238a(InputStream inputStream, OutputStream outputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
            }
        }
    }

    /* renamed from: b */
    private ChannelConfig m3239b(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.f2995g == null) {
                this.f2995g = new C0479d();
            }
            try {
                return (ChannelConfig) this.f2995g.mo5383a(str, ChannelConfig.class);
            } catch (Exception e) {
                e.toString();
            }
        }
        return null;
    }

    /* renamed from: d */
    private synchronized void m3241d() {
        new StringBuilder("initServerConfig :mInit = ").append(this.f2992d).append(",mIniting = ").append(this.f2993e).append(", Network = ").append(NetworkUtils.m4385a(this.f2994f));
        if (!(this.f2992d || this.f2993e || !NetworkUtils.m4385a(this.f2994f))) {
            this.f2993e = true;
            new Thread(new C1115q(this)).start();
        }
    }

    /* renamed from: e */
    private File m3242e() {
        File file = Environment.getExternalStorageState().equals("mounted") ? new File(Environment.getExternalStorageDirectory(), "Android/data/" + this.f2994f.getPackageName() + "/json") : new File(this.f2994f.getCacheDir(), "json");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, C1620d.m4391a(C1116r.m3248a()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002b A:{SYNTHETIC, Splitter: B:17:0x002b} */
    /* renamed from: f */
    private com.shuame.p075ad.ChannelConfig m3243f() {
        /*
        r5 = this;
        r0 = 0;
        r2 = r5.m3242e();
        r1 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x001b, all -> 0x0025 }
        r3 = new java.io.FileReader;	 Catch:{ Exception -> 0x001b, all -> 0x0025 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x001b, all -> 0x0025 }
        r1.<init>(r3);	 Catch:{ Exception -> 0x001b, all -> 0x0025 }
        r2 = r1.readLine();	 Catch:{ Exception -> 0x0035, all -> 0x0033 }
        r0 = r5.m3239b(r2);	 Catch:{ Exception -> 0x0035, all -> 0x0033 }
        r1.close();	 Catch:{ IOException -> 0x002f }
    L_0x001a:
        return r0;
    L_0x001b:
        r1 = move-exception;
        r1 = r0;
    L_0x001d:
        if (r1 == 0) goto L_0x001a;
    L_0x001f:
        r1.close();	 Catch:{ IOException -> 0x0023 }
        goto L_0x001a;
    L_0x0023:
        r1 = move-exception;
        goto L_0x001a;
    L_0x0025:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0029:
        if (r1 == 0) goto L_0x002e;
    L_0x002b:
        r1.close();	 Catch:{ IOException -> 0x0031 }
    L_0x002e:
        throw r0;
    L_0x002f:
        r1 = move-exception;
        goto L_0x001a;
    L_0x0031:
        r1 = move-exception;
        goto L_0x002e;
    L_0x0033:
        r0 = move-exception;
        goto L_0x0029;
    L_0x0035:
        r2 = move-exception;
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.ad.p.f():com.shuame.ad.ChannelConfig");
    }

    /* renamed from: g */
    private ChannelConfig m3244g() {
        InputStream open;
        OutputStream byteArrayOutputStream;
        OutputStream outputStream;
        InputStream inputStream;
        Throwable th;
        try {
            open = this.f2994f.getAssets().open("adconfig.json");
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (IOException e) {
                outputStream = null;
                inputStream = open;
                C1114p.m3238a(inputStream, outputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                C1114p.m3238a(open, byteArrayOutputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        ChannelConfig b = m3239b(byteArrayOutputStream.toString());
                        new StringBuilder("getDefaultAssetConfig = ").append(b);
                        C1114p.m3238a(open, byteArrayOutputStream);
                        return b;
                    }
                }
            } catch (IOException e2) {
                outputStream = byteArrayOutputStream;
                inputStream = open;
                C1114p.m3238a(inputStream, outputStream);
                return null;
            } catch (Throwable th3) {
                th = th3;
                C1114p.m3238a(open, byteArrayOutputStream);
                throw th;
            }
        } catch (IOException e3) {
            outputStream = null;
            inputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            open = null;
            C1114p.m3238a(open, byteArrayOutputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public final PositionConfig mo6721a(String str) {
        ChannelConfig channelConfig;
        if (this.f2992d) {
            channelConfig = this.f2991c;
        } else {
            m3241d();
            if (this.f2990b == null) {
                this.f2990b = m3244g();
            }
            channelConfig = m3243f();
            new StringBuilder("cacheConfig = ").append(channelConfig);
            if (channelConfig != null) {
                this.f2991c = this.f2990b.mo6659a(channelConfig);
                channelConfig = this.f2991c;
            } else {
                this.f2991c = this.f2990b;
                channelConfig = this.f2991c;
            }
        }
        new StringBuilder("getConfig = ").append(channelConfig.toString());
        for (PositionConfig positionConfig : channelConfig.f2878a) {
            if (positionConfig.name.equals(str)) {
                return positionConfig;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void mo6722a(Context context) {
        this.f2994f = context;
        SharedPreferences sharedPreferences = this.f2994f.getSharedPreferences("first_start_time", 0);
        this.f2996h = sharedPreferences.getLong("first_start_time_key", 0);
        if (this.f2996h == 0) {
            Editor edit = sharedPreferences.edit();
            this.f2996h = System.currentTimeMillis();
            edit.putLong("first_start_time_key", this.f2996h);
            edit.apply();
        }
    }

    /* renamed from: b */
    protected final long mo6723b() {
        new StringBuilder("getFirstLaunchTime = ").append(this.f2996h);
        return this.f2996h;
    }
}
