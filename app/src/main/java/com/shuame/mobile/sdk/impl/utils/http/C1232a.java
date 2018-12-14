package com.shuame.mobile.sdk.impl.utils.http;

import android.text.TextUtils;
import com.shuame.mobile.sdk.impl.utils.C1220b;
import com.shuame.mobile.sdk.impl.utils.C1227f;
import com.shuame.mobile.sdk.impl.utils.C1228g;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.shuame.mobile.sdk.impl.utils.http.a */
public class C1232a implements Runnable {
    /* renamed from: a */
    private static final String f3249a = C1232a.class.getSimpleName();
    /* renamed from: b */
    private TaskInfo f3250b;
    /* renamed from: c */
    private OnDownloadListener f3251c;
    /* renamed from: d */
    private HttpURLConnection f3252d;
    /* renamed from: e */
    private Proxy f3253e;
    /* renamed from: f */
    private volatile boolean f3254f;
    /* renamed from: g */
    private int f3255g;
    /* renamed from: h */
    private long f3256h;
    /* renamed from: i */
    private long f3257i;
    /* renamed from: j */
    private int f3258j;
    /* renamed from: k */
    private int f3259k;
    /* renamed from: l */
    private int f3260l;
    /* renamed from: m */
    private int f3261m;
    /* renamed from: n */
    private long f3262n;
    /* renamed from: o */
    private long f3263o;

    /* renamed from: com.shuame.mobile.sdk.impl.utils.http.a$a */
    private class C1231a extends Exception {
        private C1231a() {
        }

        /* synthetic */ C1231a(C1232a c1232a, C1231a c1231a) {
            this();
        }
    }

    public C1232a(TaskInfo taskInfo, OnDownloadListener onDownloadListener) {
        this.f3250b = taskInfo;
        this.f3251c = onDownloadListener;
    }

    /* renamed from: d */
    private void m3464d() {
        if (this.f3254f) {
            throw new C1231a(this, null);
        }
    }

    /* renamed from: e */
    private boolean m3465e() {
        String a;
        this.f3257i = 0;
        this.f3256h = 0;
        File file = new File(this.f3250b.path);
        if (file.exists() && !TextUtils.isEmpty(this.f3250b.md5)) {
            C1228g.m3458a(f3249a, "start md5File:" + this.f3250b.path);
            a = C1227f.m3456a(file);
            C1228g.m3458a(f3249a, "end md5File:" + this.f3250b.path);
            if (this.f3250b.md5.equalsIgnoreCase(a)) {
                return true;
            }
            C1228g.m3458a(f3249a, "md5File not same, server md5:" + this.f3250b.md5 + "; local md5:" + a);
            file.delete();
        }
        file = new File(new StringBuilder(String.valueOf(this.f3250b.path)).append(".tmp").toString());
        if (file.exists() && !TextUtils.isEmpty(this.f3250b.md5)) {
            C1228g.m3458a(f3249a, "start md5TmpFile:" + file.getAbsolutePath());
            a = C1227f.m3456a(file);
            C1228g.m3458a(f3249a, "end md5TmpFile:" + file.getAbsolutePath());
            if (!this.f3250b.md5.equalsIgnoreCase(a)) {
                C1228g.m3458a(f3249a, "md5TmpFile not same, continue download");
                this.f3256h = file.length();
            } else if (C1220b.m3448a(file.getAbsolutePath(), this.f3250b.path, 3)) {
                return true;
            } else {
                C1228g.m3458a(f3249a, "rename tmpFile error");
                file.delete();
                this.f3256h = 0;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:214:0x075d A:{SYNTHETIC, Splitter: B:214:0x075d} */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0762 A:{SYNTHETIC, Splitter: B:217:0x0762} */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0769 A:{SYNTHETIC, Splitter: B:221:0x0769} */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0774  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x07a5  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x082c  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0901 A:{SYNTHETIC, Splitter: B:268:0x0901} */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0906 A:{SYNTHETIC, Splitter: B:271:0x0906} */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x090d A:{SYNTHETIC, Splitter: B:275:0x090d} */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x0918  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x0949  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x09d0  */
    /* JADX WARNING: Removed duplicated region for block: B:361:0x0be9 A:{SYNTHETIC, Splitter: B:361:0x0be9} */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x0bee A:{SYNTHETIC, Splitter: B:364:0x0bee} */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x0bf5 A:{SYNTHETIC, Splitter: B:368:0x0bf5} */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x0c00  */
    /* JADX WARNING: Removed duplicated region for block: B:378:0x0c31  */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0cb8  */
    /* JADX WARNING: Removed duplicated region for block: B:411:0x0d6c A:{SYNTHETIC, Splitter: B:411:0x0d6c} */
    /* JADX WARNING: Removed duplicated region for block: B:414:0x0d71 A:{SYNTHETIC, Splitter: B:414:0x0d71} */
    /* JADX WARNING: Removed duplicated region for block: B:418:0x0d78 A:{SYNTHETIC, Splitter: B:418:0x0d78} */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0d83  */
    /* JADX WARNING: Removed duplicated region for block: B:428:0x0db4  */
    /* JADX WARNING: Removed duplicated region for block: B:439:0x0e3b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0201 A:{SYNTHETIC, Splitter: B:47:0x0201} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0206 A:{SYNTHETIC, Splitter: B:50:0x0206} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x020d A:{SYNTHETIC, Splitter: B:54:0x020d} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x02d0  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x075d A:{SYNTHETIC, Splitter: B:214:0x075d} */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0762 A:{SYNTHETIC, Splitter: B:217:0x0762} */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0769 A:{SYNTHETIC, Splitter: B:221:0x0769} */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0774  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x07a5  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x082c  */
    /* JADX WARNING: Removed duplicated region for block: B:520:? A:{SYNTHETIC, RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0836  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x08e4 A:{Catch:{ all -> 0x0a5f }} */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0901 A:{SYNTHETIC, Splitter: B:268:0x0901} */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0906 A:{SYNTHETIC, Splitter: B:271:0x0906} */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x090d A:{SYNTHETIC, Splitter: B:275:0x090d} */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x0918  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x0949  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x09d0  */
    /* JADX WARNING: Removed duplicated region for block: B:525:? A:{SYNTHETIC, RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x09da  */
    /* JADX WARNING: Removed duplicated region for block: B:361:0x0be9 A:{SYNTHETIC, Splitter: B:361:0x0be9} */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x0bee A:{SYNTHETIC, Splitter: B:364:0x0bee} */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x0bf5 A:{SYNTHETIC, Splitter: B:368:0x0bf5} */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x0c00  */
    /* JADX WARNING: Removed duplicated region for block: B:378:0x0c31  */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0cb8  */
    /* JADX WARNING: Removed duplicated region for block: B:530:? A:{SYNTHETIC, RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x0cc2  */
    /* JADX WARNING: Removed duplicated region for block: B:411:0x0d6c A:{SYNTHETIC, Splitter: B:411:0x0d6c} */
    /* JADX WARNING: Removed duplicated region for block: B:414:0x0d71 A:{SYNTHETIC, Splitter: B:414:0x0d71} */
    /* JADX WARNING: Removed duplicated region for block: B:418:0x0d78 A:{SYNTHETIC, Splitter: B:418:0x0d78} */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0d83  */
    /* JADX WARNING: Removed duplicated region for block: B:428:0x0db4  */
    /* JADX WARNING: Removed duplicated region for block: B:439:0x0e3b  */
    /* JADX WARNING: Removed duplicated region for block: B:535:? A:{SYNTHETIC, RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:442:0x0e45  */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x0a62 A:{SYNTHETIC, Splitter: B:310:0x0a62} */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x0a67 A:{SYNTHETIC, Splitter: B:313:0x0a67} */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0a6e A:{SYNTHETIC, Splitter: B:317:0x0a6e} */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x0a79  */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x0aab  */
    /* JADX WARNING: Removed duplicated region for block: B:338:0x0b32  */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x0b55  */
    /* renamed from: f */
    private void m3466f() {
        /*
        r14 = this;
        r6 = 0;
        r1 = 0;
        r4 = 0;
        r2 = java.lang.System.currentTimeMillis();
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_UNKNOWN;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r14.f3260l = r0;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r14.m3464d();	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r7 = r14.f3250b;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r7 = r7.url;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0.<init>(r7);	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r7 = r14.f3253e;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        if (r7 == 0) goto L_0x01ed;
    L_0x001c:
        r7 = r14.f3253e;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0 = r0.openConnection(r7);	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r14.f3252d = r0;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
    L_0x0026:
        r0 = r14.f3252d;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r7 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0.setConnectTimeout(r7);	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0 = r14.f3252d;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r7 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0.setReadTimeout(r7);	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0 = r14.f3252d;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r7 = 1;
        r0.setInstanceFollowRedirects(r7);	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0 = r14.f3252d;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r7 = "GET";
        r0.setRequestMethod(r7);	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0 = r14.f3252d;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r7 = 1;
        r0.setDoInput(r7);	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0 = r14.f3252d;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r7 = 0;
        r0.setUseCaches(r7);	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0 = r14.f3252d;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r7 = "Range";
        r8 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r9 = "bytes=";
        r8.<init>(r9);	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r10 = r14.f3256h;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r8 = r8.append(r10);	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r9 = "-";
        r8 = r8.append(r9);	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r8 = r8.toString();	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0.setRequestProperty(r7, r8);	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r14.m3464d();	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r8 = r14.f3256h;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r14.f3262n = r8;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0 = r14.f3252d;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0 = r0.getContentLength();	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r8 = (long) r0;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r14.f3263o = r8;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0 = r14.f3252d;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0 = r0.getResponseCode();	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r14.f3261m = r0;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r8 = r14.f3263o;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r10 = r14.f3256h;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r8 = r8 + r10;
        r14.f3257i = r8;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r14.m3464d();	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0 = r14.f3252d;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r7 = "Content-Type";
        r0 = r0.getHeaderField(r7);	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r7 = "text/html";
        r0 = r7.equalsIgnoreCase(r0);	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        if (r0 == 0) goto L_0x0372;
    L_0x009d:
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_HTML_PAGE;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r14.f3260l = r0;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0 = r14.f3252d;
        if (r0 == 0) goto L_0x00aa;
    L_0x00a5:
        r0 = r14.f3252d;	 Catch:{ Exception -> 0x0359 }
        r0.disconnect();	 Catch:{ Exception -> 0x0359 }
    L_0x00aa:
        r0 = 0;
        r4 = 0;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x00d6;
    L_0x00b2:
        r0 = java.lang.System.currentTimeMillis();
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 <= 0) goto L_0x00c3;
    L_0x00ba:
        r4 = 0;
        r0 = r0 - r2;
        r0 = (double) r0;
        r0 = r4 / r0;
        r0 = (int) r0;
        r14.f3259k = r0;
    L_0x00c3:
        r0 = r14.f3256h;
        r0 = (double) r0;
        r2 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r0 = r0 * r2;
        r2 = r14.f3257i;
        r2 = (double) r2;
        r0 = r0 / r2;
        r0 = (int) r0;
        r14.f3258j = r0;
        r14.mo6855b();
    L_0x00d6:
        r0 = r14.f3256h;
        r2 = r14.f3257i;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0161;
    L_0x00de:
        r1 = new java.io.File;
        r0 = new java.lang.StringBuilder;
        r2 = r14.f3250b;
        r2 = r2.path;
        r2 = java.lang.String.valueOf(r2);
        r0.<init>(r2);
        r2 = ".tmp";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        r0 = r1.exists();
        if (r0 == 0) goto L_0x0161;
    L_0x0100:
        r2 = r1.length();
        r4 = r14.f3257i;
        r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x035f;
    L_0x010a:
        r0 = 1;
    L_0x010b:
        if (r0 == 0) goto L_0x0362;
    L_0x010d:
        r0 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "retry rename: ";
        r2.<init>(r3);
        r3 = r1.getAbsolutePath();
        r2 = r2.append(r3);
        r3 = "=>";
        r2 = r2.append(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r2);
        r0 = r1.getAbsolutePath();
        r1 = r14.f3250b;
        r1 = r1.path;
        r2 = 3;
        r0 = com.shuame.mobile.sdk.impl.utils.C1220b.m3448a(r0, r1, r2);
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "retry rename, isRenameOk:";
        r2.<init>(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        if (r0 != 0) goto L_0x0161;
    L_0x0156:
        r0 = f3249a;
        r1 = "File rename failed";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r1);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_RENAME;
        r14.f3260l = r0;
    L_0x0161:
        r0 = r14.f3254f;
        if (r0 == 0) goto L_0x0169;
    L_0x0165:
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.CANCEL;
        r14.f3260l = r0;
    L_0x0169:
        r0 = r14.f3260l;
        r1 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.f3242OK;
        if (r0 != r1) goto L_0x01ec;
    L_0x016f:
        r0 = r14.f3250b;
        r0 = r0.md5;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x01ec;
    L_0x0179:
        r0 = new java.io.File;
        r1 = r14.f3250b;
        r1 = r1.path;
        r0.<init>(r1);
        r1 = r0.exists();
        if (r1 == 0) goto L_0x01ec;
    L_0x0188:
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "start md5File:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        r0 = com.shuame.mobile.sdk.impl.utils.C1227f.m3456a(r0);
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "end md5File:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        r1 = r14.f3250b;
        r1 = r1.md5;
        r1 = r1.equalsIgnoreCase(r0);
        if (r1 != 0) goto L_0x01ec;
    L_0x01c6:
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "md5File not same, server md5:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.md5;
        r2 = r2.append(r3);
        r3 = "; local md5:";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r0);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_MD5;
        r14.f3260l = r0;
    L_0x01ec:
        return;
    L_0x01ed:
        r0 = r0.openConnection();	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r14.f3252d = r0;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        goto L_0x0026;
    L_0x01f7:
        r0 = move-exception;
    L_0x01f8:
        r0.printStackTrace();	 Catch:{ all -> 0x0a5f }
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_NETWORK;	 Catch:{ all -> 0x0a5f }
        r14.f3260l = r0;	 Catch:{ all -> 0x0a5f }
        if (r6 == 0) goto L_0x0204;
    L_0x0201:
        r6.close();	 Catch:{ IOException -> 0x072e }
    L_0x0204:
        if (r1 == 0) goto L_0x0209;
    L_0x0206:
        r1.close();	 Catch:{ IOException -> 0x0734 }
    L_0x0209:
        r0 = r14.f3252d;
        if (r0 == 0) goto L_0x0212;
    L_0x020d:
        r0 = r14.f3252d;	 Catch:{ Exception -> 0x073a }
        r0.disconnect();	 Catch:{ Exception -> 0x073a }
    L_0x0212:
        r0 = 0;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0241;
    L_0x0218:
        r0 = java.lang.System.currentTimeMillis();
        r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r6 <= 0) goto L_0x022e;
    L_0x0220:
        r4 = (double) r4;
        r6 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r4 = r4 * r6;
        r0 = r0 - r2;
        r0 = (double) r0;
        r0 = r4 / r0;
        r0 = (int) r0;
        r14.f3259k = r0;
    L_0x022e:
        r0 = r14.f3256h;
        r0 = (double) r0;
        r2 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r0 = r0 * r2;
        r2 = r14.f3257i;
        r2 = (double) r2;
        r0 = r0 / r2;
        r0 = (int) r0;
        r14.f3258j = r0;
        r14.mo6855b();
    L_0x0241:
        r0 = r14.f3256h;
        r2 = r14.f3257i;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x02cc;
    L_0x0249:
        r1 = new java.io.File;
        r0 = new java.lang.StringBuilder;
        r2 = r14.f3250b;
        r2 = r2.path;
        r2 = java.lang.String.valueOf(r2);
        r0.<init>(r2);
        r2 = ".tmp";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        r0 = r1.exists();
        if (r0 == 0) goto L_0x02cc;
    L_0x026b:
        r2 = r1.length();
        r4 = r14.f3257i;
        r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0740;
    L_0x0275:
        r0 = 1;
    L_0x0276:
        if (r0 == 0) goto L_0x0743;
    L_0x0278:
        r0 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "retry rename: ";
        r2.<init>(r3);
        r3 = r1.getAbsolutePath();
        r2 = r2.append(r3);
        r3 = "=>";
        r2 = r2.append(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r2);
        r0 = r1.getAbsolutePath();
        r1 = r14.f3250b;
        r1 = r1.path;
        r2 = 3;
        r0 = com.shuame.mobile.sdk.impl.utils.C1220b.m3448a(r0, r1, r2);
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "retry rename, isRenameOk:";
        r2.<init>(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        if (r0 != 0) goto L_0x02cc;
    L_0x02c1:
        r0 = f3249a;
        r1 = "File rename failed";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r1);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_RENAME;
        r14.f3260l = r0;
    L_0x02cc:
        r0 = r14.f3254f;
        if (r0 == 0) goto L_0x02d4;
    L_0x02d0:
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.CANCEL;
        r14.f3260l = r0;
    L_0x02d4:
        r0 = r14.f3260l;
        r1 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.f3242OK;
        if (r0 != r1) goto L_0x01ec;
    L_0x02da:
        r0 = r14.f3250b;
        r0 = r0.md5;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x01ec;
    L_0x02e4:
        r0 = new java.io.File;
        r1 = r14.f3250b;
        r1 = r1.path;
        r0.<init>(r1);
        r1 = r0.exists();
        if (r1 == 0) goto L_0x01ec;
    L_0x02f3:
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "start md5File:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        r0 = com.shuame.mobile.sdk.impl.utils.C1227f.m3456a(r0);
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "end md5File:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        r1 = r14.f3250b;
        r1 = r1.md5;
        r1 = r1.equalsIgnoreCase(r0);
        if (r1 != 0) goto L_0x01ec;
    L_0x0331:
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "md5File not same, server md5:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.md5;
        r2 = r2.append(r3);
        r3 = "; local md5:";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r0);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_MD5;
        r14.f3260l = r0;
        goto L_0x01ec;
    L_0x0359:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x00aa;
    L_0x035f:
        r0 = 0;
        goto L_0x010b;
    L_0x0362:
        r1.delete();
        r0 = f3249a;
        r1 = "File integrity failed";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r1);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_MD5;
        r14.f3260l = r0;
        goto L_0x0161;
    L_0x0372:
        r0 = r14.f3261m;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r7 = 416; // 0x1a0 float:5.83E-43 double:2.055E-321;
        if (r0 != r7) goto L_0x0507;
    L_0x0378:
        r0 = new java.io.File;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r7 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r8 = r14.f3250b;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r8 = r8.path;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r8 = java.lang.String.valueOf(r8);	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r7.<init>(r8);	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r8 = ".tmp";
        r7 = r7.append(r8);	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r7 = r7.toString();	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0.<init>(r7);	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r7 = r0.exists();	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        if (r7 == 0) goto L_0x039d;
    L_0x039a:
        r0.delete();	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
    L_0x039d:
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_RANGE;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r14.f3260l = r0;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0 = r14.f3252d;
        if (r0 == 0) goto L_0x03aa;
    L_0x03a5:
        r0 = r14.f3252d;	 Catch:{ Exception -> 0x04ee }
        r0.disconnect();	 Catch:{ Exception -> 0x04ee }
    L_0x03aa:
        r0 = 0;
        r4 = 0;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x03d6;
    L_0x03b2:
        r0 = java.lang.System.currentTimeMillis();
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 <= 0) goto L_0x03c3;
    L_0x03ba:
        r4 = 0;
        r0 = r0 - r2;
        r0 = (double) r0;
        r0 = r4 / r0;
        r0 = (int) r0;
        r14.f3259k = r0;
    L_0x03c3:
        r0 = r14.f3256h;
        r0 = (double) r0;
        r2 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r0 = r0 * r2;
        r2 = r14.f3257i;
        r2 = (double) r2;
        r0 = r0 / r2;
        r0 = (int) r0;
        r14.f3258j = r0;
        r14.mo6855b();
    L_0x03d6:
        r0 = r14.f3256h;
        r2 = r14.f3257i;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0461;
    L_0x03de:
        r1 = new java.io.File;
        r0 = new java.lang.StringBuilder;
        r2 = r14.f3250b;
        r2 = r2.path;
        r2 = java.lang.String.valueOf(r2);
        r0.<init>(r2);
        r2 = ".tmp";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        r0 = r1.exists();
        if (r0 == 0) goto L_0x0461;
    L_0x0400:
        r2 = r1.length();
        r4 = r14.f3257i;
        r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x04f4;
    L_0x040a:
        r0 = 1;
    L_0x040b:
        if (r0 == 0) goto L_0x04f7;
    L_0x040d:
        r0 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "retry rename: ";
        r2.<init>(r3);
        r3 = r1.getAbsolutePath();
        r2 = r2.append(r3);
        r3 = "=>";
        r2 = r2.append(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r2);
        r0 = r1.getAbsolutePath();
        r1 = r14.f3250b;
        r1 = r1.path;
        r2 = 3;
        r0 = com.shuame.mobile.sdk.impl.utils.C1220b.m3448a(r0, r1, r2);
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "retry rename, isRenameOk:";
        r2.<init>(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        if (r0 != 0) goto L_0x0461;
    L_0x0456:
        r0 = f3249a;
        r1 = "File rename failed";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r1);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_RENAME;
        r14.f3260l = r0;
    L_0x0461:
        r0 = r14.f3254f;
        if (r0 == 0) goto L_0x0469;
    L_0x0465:
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.CANCEL;
        r14.f3260l = r0;
    L_0x0469:
        r0 = r14.f3260l;
        r1 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.f3242OK;
        if (r0 != r1) goto L_0x01ec;
    L_0x046f:
        r0 = r14.f3250b;
        r0 = r0.md5;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x01ec;
    L_0x0479:
        r0 = new java.io.File;
        r1 = r14.f3250b;
        r1 = r1.path;
        r0.<init>(r1);
        r1 = r0.exists();
        if (r1 == 0) goto L_0x01ec;
    L_0x0488:
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "start md5File:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        r0 = com.shuame.mobile.sdk.impl.utils.C1227f.m3456a(r0);
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "end md5File:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        r1 = r14.f3250b;
        r1 = r1.md5;
        r1 = r1.equalsIgnoreCase(r0);
        if (r1 != 0) goto L_0x01ec;
    L_0x04c6:
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "md5File not same, server md5:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.md5;
        r2 = r2.append(r3);
        r3 = "; local md5:";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r0);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_MD5;
        r14.f3260l = r0;
        goto L_0x01ec;
    L_0x04ee:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x03aa;
    L_0x04f4:
        r0 = 0;
        goto L_0x040b;
    L_0x04f7:
        r1.delete();
        r0 = f3249a;
        r1 = "File integrity failed";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r1);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_MD5;
        r14.f3260l = r0;
        goto L_0x0461;
    L_0x0507:
        r0 = r14.f3261m;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r7 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 == r7) goto L_0x0513;
    L_0x050d:
        r0 = r14.f3261m;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r7 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r0 != r7) goto L_0x0566;
    L_0x0513:
        r7 = new java.io.BufferedInputStream;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0 = r14.f3252d;	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r0 = r0.getInputStream();	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r7.<init>(r0);	 Catch:{ MalformedURLException -> 0x01f7, ProtocolException -> 0x0753, IOException -> 0x08da, a -> 0x0bdf, Exception -> 0x0d66 }
        r6 = new java.io.RandomAccessFile;	 Catch:{ MalformedURLException -> 0x0f60, ProtocolException -> 0x0f57, IOException -> 0x0f4e, a -> 0x0f45, Exception -> 0x0f3c, all -> 0x0f33 }
        r0 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0f60, ProtocolException -> 0x0f57, IOException -> 0x0f4e, a -> 0x0f45, Exception -> 0x0f3c, all -> 0x0f33 }
        r8 = r14.f3250b;	 Catch:{ MalformedURLException -> 0x0f60, ProtocolException -> 0x0f57, IOException -> 0x0f4e, a -> 0x0f45, Exception -> 0x0f3c, all -> 0x0f33 }
        r8 = r8.path;	 Catch:{ MalformedURLException -> 0x0f60, ProtocolException -> 0x0f57, IOException -> 0x0f4e, a -> 0x0f45, Exception -> 0x0f3c, all -> 0x0f33 }
        r8 = java.lang.String.valueOf(r8);	 Catch:{ MalformedURLException -> 0x0f60, ProtocolException -> 0x0f57, IOException -> 0x0f4e, a -> 0x0f45, Exception -> 0x0f3c, all -> 0x0f33 }
        r0.<init>(r8);	 Catch:{ MalformedURLException -> 0x0f60, ProtocolException -> 0x0f57, IOException -> 0x0f4e, a -> 0x0f45, Exception -> 0x0f3c, all -> 0x0f33 }
        r8 = ".tmp";
        r0 = r0.append(r8);	 Catch:{ MalformedURLException -> 0x0f60, ProtocolException -> 0x0f57, IOException -> 0x0f4e, a -> 0x0f45, Exception -> 0x0f3c, all -> 0x0f33 }
        r0 = r0.toString();	 Catch:{ MalformedURLException -> 0x0f60, ProtocolException -> 0x0f57, IOException -> 0x0f4e, a -> 0x0f45, Exception -> 0x0f3c, all -> 0x0f33 }
        r8 = "rw";
        r6.<init>(r0, r8);	 Catch:{ MalformedURLException -> 0x0f60, ProtocolException -> 0x0f57, IOException -> 0x0f4e, a -> 0x0f45, Exception -> 0x0f3c, all -> 0x0f33 }
        r0 = r14.f3256h;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r8 = 0;
        r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x0549;
    L_0x0544:
        r0 = r14.f3256h;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r6.seek(r0);	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
    L_0x0549:
        r0 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = new byte[r0];	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
    L_0x0551:
        r1 = r14.f3254f;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        if (r1 != 0) goto L_0x055c;
    L_0x0555:
        r1 = r7.read(r0);	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r8 = -1;
        if (r1 != r8) goto L_0x06c0;
    L_0x055c:
        r0 = r14.f3254f;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        if (r0 == 0) goto L_0x072a;
    L_0x0560:
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.CANCEL;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
    L_0x0562:
        r14.f3260l = r0;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r1 = r6;
        r6 = r7;
    L_0x0566:
        if (r6 == 0) goto L_0x056b;
    L_0x0568:
        r6.close();	 Catch:{ IOException -> 0x0f0e }
    L_0x056b:
        if (r1 == 0) goto L_0x0570;
    L_0x056d:
        r1.close();	 Catch:{ IOException -> 0x0f14 }
    L_0x0570:
        r0 = r14.f3252d;
        if (r0 == 0) goto L_0x0579;
    L_0x0574:
        r0 = r14.f3252d;	 Catch:{ Exception -> 0x0f1a }
        r0.disconnect();	 Catch:{ Exception -> 0x0f1a }
    L_0x0579:
        r0 = 0;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x05a8;
    L_0x057f:
        r0 = java.lang.System.currentTimeMillis();
        r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r6 <= 0) goto L_0x0595;
    L_0x0587:
        r4 = (double) r4;
        r6 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r4 = r4 * r6;
        r0 = r0 - r2;
        r0 = (double) r0;
        r0 = r4 / r0;
        r0 = (int) r0;
        r14.f3259k = r0;
    L_0x0595:
        r0 = r14.f3256h;
        r0 = (double) r0;
        r2 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r0 = r0 * r2;
        r2 = r14.f3257i;
        r2 = (double) r2;
        r0 = r0 / r2;
        r0 = (int) r0;
        r14.f3258j = r0;
        r14.mo6855b();
    L_0x05a8:
        r0 = r14.f3256h;
        r2 = r14.f3257i;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0633;
    L_0x05b0:
        r1 = new java.io.File;
        r0 = new java.lang.StringBuilder;
        r2 = r14.f3250b;
        r2 = r2.path;
        r2 = java.lang.String.valueOf(r2);
        r0.<init>(r2);
        r2 = ".tmp";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        r0 = r1.exists();
        if (r0 == 0) goto L_0x0633;
    L_0x05d2:
        r2 = r1.length();
        r4 = r14.f3257i;
        r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0f20;
    L_0x05dc:
        r0 = 1;
    L_0x05dd:
        if (r0 == 0) goto L_0x0f23;
    L_0x05df:
        r0 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "retry rename: ";
        r2.<init>(r3);
        r3 = r1.getAbsolutePath();
        r2 = r2.append(r3);
        r3 = "=>";
        r2 = r2.append(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r2);
        r0 = r1.getAbsolutePath();
        r1 = r14.f3250b;
        r1 = r1.path;
        r2 = 3;
        r0 = com.shuame.mobile.sdk.impl.utils.C1220b.m3448a(r0, r1, r2);
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "retry rename, isRenameOk:";
        r2.<init>(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        if (r0 != 0) goto L_0x0633;
    L_0x0628:
        r0 = f3249a;
        r1 = "File rename failed";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r1);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_RENAME;
        r14.f3260l = r0;
    L_0x0633:
        r0 = r14.f3254f;
        if (r0 == 0) goto L_0x063b;
    L_0x0637:
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.CANCEL;
        r14.f3260l = r0;
    L_0x063b:
        r0 = r14.f3260l;
        r1 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.f3242OK;
        if (r0 != r1) goto L_0x01ec;
    L_0x0641:
        r0 = r14.f3250b;
        r0 = r0.md5;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x01ec;
    L_0x064b:
        r0 = new java.io.File;
        r1 = r14.f3250b;
        r1 = r1.path;
        r0.<init>(r1);
        r1 = r0.exists();
        if (r1 == 0) goto L_0x01ec;
    L_0x065a:
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "start md5File:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        r0 = com.shuame.mobile.sdk.impl.utils.C1227f.m3456a(r0);
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "end md5File:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        r1 = r14.f3250b;
        r1 = r1.md5;
        r1 = r1.equalsIgnoreCase(r0);
        if (r1 != 0) goto L_0x01ec;
    L_0x0698:
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "md5File not same, server md5:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.md5;
        r2 = r2.append(r3);
        r3 = "; local md5:";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r0);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_MD5;
        r14.f3260l = r0;
        goto L_0x01ec;
    L_0x06c0:
        r8 = 0;
        r6.write(r0, r8, r1);	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r8 = r14.f3256h;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r10 = (long) r1;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r8 = r8 + r10;
        r14.f3256h = r8;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r8 = (long) r1;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r4 = r4 + r8;
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r10 = r8 - r2;
        r12 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r1 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r1 < 0) goto L_0x0551;
    L_0x06d8:
        r10 = (double) r4;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r12 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r10 = r10 * r12;
        r8 = r8 - r2;
        r8 = (double) r8;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r8 = r10 / r8;
        r1 = (int) r8;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r14.f3259k = r1;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r8 = r14.f3256h;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r8 = (double) r8;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r10 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r8 = r8 * r10;
        r10 = r14.f3257i;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r10 = (double) r10;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r8 = r8 / r10;
        r1 = (int) r8;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r14.f3258j = r1;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r14.mo6855b();	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r4 = 0;
        r1 = f3249a;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r8 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r9 = "progress taskId=";
        r8.<init>(r9);	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r9 = r14.f3250b;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r9 = r9.taskId;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r8 = r8.append(r9);	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r9 = ";speed=";
        r8 = r8.append(r9);	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r9 = r14.f3259k;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r8 = r8.append(r9);	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        r8 = r8.toString();	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r8);	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        goto L_0x0551;
    L_0x0725:
        r0 = move-exception;
        r1 = r6;
        r6 = r7;
        goto L_0x01f8;
    L_0x072a:
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.f3242OK;	 Catch:{ MalformedURLException -> 0x0725, ProtocolException -> 0x0f5b, IOException -> 0x0f52, a -> 0x0f49, Exception -> 0x0f40, all -> 0x0f37 }
        goto L_0x0562;
    L_0x072e:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0204;
    L_0x0734:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0209;
    L_0x073a:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0212;
    L_0x0740:
        r0 = 0;
        goto L_0x0276;
    L_0x0743:
        r1.delete();
        r0 = f3249a;
        r1 = "File integrity failed";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r1);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_MD5;
        r14.f3260l = r0;
        goto L_0x02cc;
    L_0x0753:
        r0 = move-exception;
    L_0x0754:
        r0.printStackTrace();	 Catch:{ all -> 0x0a5f }
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_NETWORK;	 Catch:{ all -> 0x0a5f }
        r14.f3260l = r0;	 Catch:{ all -> 0x0a5f }
        if (r6 == 0) goto L_0x0760;
    L_0x075d:
        r6.close();	 Catch:{ IOException -> 0x08b5 }
    L_0x0760:
        if (r1 == 0) goto L_0x0765;
    L_0x0762:
        r1.close();	 Catch:{ IOException -> 0x08bb }
    L_0x0765:
        r0 = r14.f3252d;
        if (r0 == 0) goto L_0x076e;
    L_0x0769:
        r0 = r14.f3252d;	 Catch:{ Exception -> 0x08c1 }
        r0.disconnect();	 Catch:{ Exception -> 0x08c1 }
    L_0x076e:
        r0 = 0;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x079d;
    L_0x0774:
        r0 = java.lang.System.currentTimeMillis();
        r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r6 <= 0) goto L_0x078a;
    L_0x077c:
        r4 = (double) r4;
        r6 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r4 = r4 * r6;
        r0 = r0 - r2;
        r0 = (double) r0;
        r0 = r4 / r0;
        r0 = (int) r0;
        r14.f3259k = r0;
    L_0x078a:
        r0 = r14.f3256h;
        r0 = (double) r0;
        r2 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r0 = r0 * r2;
        r2 = r14.f3257i;
        r2 = (double) r2;
        r0 = r0 / r2;
        r0 = (int) r0;
        r14.f3258j = r0;
        r14.mo6855b();
    L_0x079d:
        r0 = r14.f3256h;
        r2 = r14.f3257i;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0828;
    L_0x07a5:
        r1 = new java.io.File;
        r0 = new java.lang.StringBuilder;
        r2 = r14.f3250b;
        r2 = r2.path;
        r2 = java.lang.String.valueOf(r2);
        r0.<init>(r2);
        r2 = ".tmp";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        r0 = r1.exists();
        if (r0 == 0) goto L_0x0828;
    L_0x07c7:
        r2 = r1.length();
        r4 = r14.f3257i;
        r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x08c7;
    L_0x07d1:
        r0 = 1;
    L_0x07d2:
        if (r0 == 0) goto L_0x08ca;
    L_0x07d4:
        r0 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "retry rename: ";
        r2.<init>(r3);
        r3 = r1.getAbsolutePath();
        r2 = r2.append(r3);
        r3 = "=>";
        r2 = r2.append(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r2);
        r0 = r1.getAbsolutePath();
        r1 = r14.f3250b;
        r1 = r1.path;
        r2 = 3;
        r0 = com.shuame.mobile.sdk.impl.utils.C1220b.m3448a(r0, r1, r2);
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "retry rename, isRenameOk:";
        r2.<init>(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        if (r0 != 0) goto L_0x0828;
    L_0x081d:
        r0 = f3249a;
        r1 = "File rename failed";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r1);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_RENAME;
        r14.f3260l = r0;
    L_0x0828:
        r0 = r14.f3254f;
        if (r0 == 0) goto L_0x0830;
    L_0x082c:
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.CANCEL;
        r14.f3260l = r0;
    L_0x0830:
        r0 = r14.f3260l;
        r1 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.f3242OK;
        if (r0 != r1) goto L_0x01ec;
    L_0x0836:
        r0 = r14.f3250b;
        r0 = r0.md5;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x01ec;
    L_0x0840:
        r0 = new java.io.File;
        r1 = r14.f3250b;
        r1 = r1.path;
        r0.<init>(r1);
        r1 = r0.exists();
        if (r1 == 0) goto L_0x01ec;
    L_0x084f:
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "start md5File:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        r0 = com.shuame.mobile.sdk.impl.utils.C1227f.m3456a(r0);
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "end md5File:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        r1 = r14.f3250b;
        r1 = r1.md5;
        r1 = r1.equalsIgnoreCase(r0);
        if (r1 != 0) goto L_0x01ec;
    L_0x088d:
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "md5File not same, server md5:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.md5;
        r2 = r2.append(r3);
        r3 = "; local md5:";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r0);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_MD5;
        r14.f3260l = r0;
        goto L_0x01ec;
    L_0x08b5:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0760;
    L_0x08bb:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0765;
    L_0x08c1:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x076e;
    L_0x08c7:
        r0 = 0;
        goto L_0x07d2;
    L_0x08ca:
        r1.delete();
        r0 = f3249a;
        r1 = "File integrity failed";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r1);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_MD5;
        r14.f3260l = r0;
        goto L_0x0828;
    L_0x08da:
        r0 = move-exception;
    L_0x08db:
        r0.printStackTrace();	 Catch:{ all -> 0x0a5f }
        r7 = r0.getMessage();	 Catch:{ all -> 0x0a5f }
        if (r7 == 0) goto L_0x0a59;
    L_0x08e4:
        r0 = r0.getMessage();	 Catch:{ all -> 0x0a5f }
        r0 = r0.toLowerCase();	 Catch:{ all -> 0x0a5f }
        r7 = "no space left";
        r0 = r0.contains(r7);	 Catch:{ all -> 0x0a5f }
        if (r0 == 0) goto L_0x0a59;
    L_0x08f4:
        r0 = f3249a;	 Catch:{ all -> 0x0a5f }
        r7 = "No space left";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r7);	 Catch:{ all -> 0x0a5f }
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_NOSPACE;	 Catch:{ all -> 0x0a5f }
        r14.f3260l = r0;	 Catch:{ all -> 0x0a5f }
    L_0x08ff:
        if (r6 == 0) goto L_0x0904;
    L_0x0901:
        r6.close();	 Catch:{ IOException -> 0x0bba }
    L_0x0904:
        if (r1 == 0) goto L_0x0909;
    L_0x0906:
        r1.close();	 Catch:{ IOException -> 0x0bc0 }
    L_0x0909:
        r0 = r14.f3252d;
        if (r0 == 0) goto L_0x0912;
    L_0x090d:
        r0 = r14.f3252d;	 Catch:{ Exception -> 0x0bc6 }
        r0.disconnect();	 Catch:{ Exception -> 0x0bc6 }
    L_0x0912:
        r0 = 0;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0941;
    L_0x0918:
        r0 = java.lang.System.currentTimeMillis();
        r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r6 <= 0) goto L_0x092e;
    L_0x0920:
        r4 = (double) r4;
        r6 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r4 = r4 * r6;
        r0 = r0 - r2;
        r0 = (double) r0;
        r0 = r4 / r0;
        r0 = (int) r0;
        r14.f3259k = r0;
    L_0x092e:
        r0 = r14.f3256h;
        r0 = (double) r0;
        r2 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r0 = r0 * r2;
        r2 = r14.f3257i;
        r2 = (double) r2;
        r0 = r0 / r2;
        r0 = (int) r0;
        r14.f3258j = r0;
        r14.mo6855b();
    L_0x0941:
        r0 = r14.f3256h;
        r2 = r14.f3257i;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x09cc;
    L_0x0949:
        r1 = new java.io.File;
        r0 = new java.lang.StringBuilder;
        r2 = r14.f3250b;
        r2 = r2.path;
        r2 = java.lang.String.valueOf(r2);
        r0.<init>(r2);
        r2 = ".tmp";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        r0 = r1.exists();
        if (r0 == 0) goto L_0x09cc;
    L_0x096b:
        r2 = r1.length();
        r4 = r14.f3257i;
        r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0bcc;
    L_0x0975:
        r0 = 1;
    L_0x0976:
        if (r0 == 0) goto L_0x0bcf;
    L_0x0978:
        r0 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "retry rename: ";
        r2.<init>(r3);
        r3 = r1.getAbsolutePath();
        r2 = r2.append(r3);
        r3 = "=>";
        r2 = r2.append(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r2);
        r0 = r1.getAbsolutePath();
        r1 = r14.f3250b;
        r1 = r1.path;
        r2 = 3;
        r0 = com.shuame.mobile.sdk.impl.utils.C1220b.m3448a(r0, r1, r2);
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "retry rename, isRenameOk:";
        r2.<init>(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        if (r0 != 0) goto L_0x09cc;
    L_0x09c1:
        r0 = f3249a;
        r1 = "File rename failed";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r1);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_RENAME;
        r14.f3260l = r0;
    L_0x09cc:
        r0 = r14.f3254f;
        if (r0 == 0) goto L_0x09d4;
    L_0x09d0:
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.CANCEL;
        r14.f3260l = r0;
    L_0x09d4:
        r0 = r14.f3260l;
        r1 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.f3242OK;
        if (r0 != r1) goto L_0x01ec;
    L_0x09da:
        r0 = r14.f3250b;
        r0 = r0.md5;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x01ec;
    L_0x09e4:
        r0 = new java.io.File;
        r1 = r14.f3250b;
        r1 = r1.path;
        r0.<init>(r1);
        r1 = r0.exists();
        if (r1 == 0) goto L_0x01ec;
    L_0x09f3:
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "start md5File:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        r0 = com.shuame.mobile.sdk.impl.utils.C1227f.m3456a(r0);
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "end md5File:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        r1 = r14.f3250b;
        r1 = r1.md5;
        r1 = r1.equalsIgnoreCase(r0);
        if (r1 != 0) goto L_0x01ec;
    L_0x0a31:
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "md5File not same, server md5:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.md5;
        r2 = r2.append(r3);
        r3 = "; local md5:";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r0);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_MD5;
        r14.f3260l = r0;
        goto L_0x01ec;
    L_0x0a59:
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_NETWORK;	 Catch:{ all -> 0x0a5f }
        r14.f3260l = r0;	 Catch:{ all -> 0x0a5f }
        goto L_0x08ff;
    L_0x0a5f:
        r0 = move-exception;
    L_0x0a60:
        if (r6 == 0) goto L_0x0a65;
    L_0x0a62:
        r6.close();	 Catch:{ IOException -> 0x0ee9 }
    L_0x0a65:
        if (r1 == 0) goto L_0x0a6a;
    L_0x0a67:
        r1.close();	 Catch:{ IOException -> 0x0eef }
    L_0x0a6a:
        r1 = r14.f3252d;
        if (r1 == 0) goto L_0x0a73;
    L_0x0a6e:
        r1 = r14.f3252d;	 Catch:{ Exception -> 0x0ef5 }
        r1.disconnect();	 Catch:{ Exception -> 0x0ef5 }
    L_0x0a73:
        r6 = 0;
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x0aa3;
    L_0x0a79:
        r6 = java.lang.System.currentTimeMillis();
        r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r1 <= 0) goto L_0x0a90;
    L_0x0a81:
        r4 = (double) r4;
        r8 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r4 = r4 * r8;
        r2 = r6 - r2;
        r2 = (double) r2;
        r2 = r4 / r2;
        r1 = (int) r2;
        r14.f3259k = r1;
    L_0x0a90:
        r2 = r14.f3256h;
        r2 = (double) r2;
        r4 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r2 = r2 * r4;
        r4 = r14.f3257i;
        r4 = (double) r4;
        r2 = r2 / r4;
        r1 = (int) r2;
        r14.f3258j = r1;
        r14.mo6855b();
    L_0x0aa3:
        r2 = r14.f3256h;
        r4 = r14.f3257i;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x0b2e;
    L_0x0aab:
        r2 = new java.io.File;
        r1 = new java.lang.StringBuilder;
        r3 = r14.f3250b;
        r3 = r3.path;
        r3 = java.lang.String.valueOf(r3);
        r1.<init>(r3);
        r3 = ".tmp";
        r1 = r1.append(r3);
        r1 = r1.toString();
        r2.<init>(r1);
        r1 = r2.exists();
        if (r1 == 0) goto L_0x0b2e;
    L_0x0acd:
        r4 = r2.length();
        r6 = r14.f3257i;
        r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x0efb;
    L_0x0ad7:
        r1 = 1;
    L_0x0ad8:
        if (r1 == 0) goto L_0x0efe;
    L_0x0ada:
        r1 = f3249a;
        r3 = new java.lang.StringBuilder;
        r4 = "retry rename: ";
        r3.<init>(r4);
        r4 = r2.getAbsolutePath();
        r3 = r3.append(r4);
        r4 = "=>";
        r3 = r3.append(r4);
        r4 = r14.f3250b;
        r4 = r4.path;
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r3);
        r1 = r2.getAbsolutePath();
        r2 = r14.f3250b;
        r2 = r2.path;
        r3 = 3;
        r1 = com.shuame.mobile.sdk.impl.utils.C1220b.m3448a(r1, r2, r3);
        r2 = f3249a;
        r3 = new java.lang.StringBuilder;
        r4 = "retry rename, isRenameOk:";
        r3.<init>(r4);
        r3 = r3.append(r1);
        r3 = r3.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r2, r3);
        if (r1 != 0) goto L_0x0b2e;
    L_0x0b23:
        r1 = f3249a;
        r2 = "File rename failed";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        r1 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_RENAME;
        r14.f3260l = r1;
    L_0x0b2e:
        r1 = r14.f3254f;
        if (r1 == 0) goto L_0x0b36;
    L_0x0b32:
        r1 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.CANCEL;
        r14.f3260l = r1;
    L_0x0b36:
        r1 = r14.f3260l;
        r2 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.f3242OK;
        if (r1 != r2) goto L_0x0bb9;
    L_0x0b3c:
        r1 = r14.f3250b;
        r1 = r1.md5;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x0bb9;
    L_0x0b46:
        r1 = new java.io.File;
        r2 = r14.f3250b;
        r2 = r2.path;
        r1.<init>(r2);
        r2 = r1.exists();
        if (r2 == 0) goto L_0x0bb9;
    L_0x0b55:
        r2 = f3249a;
        r3 = new java.lang.StringBuilder;
        r4 = "start md5File:";
        r3.<init>(r4);
        r4 = r14.f3250b;
        r4 = r4.path;
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r2, r3);
        r1 = com.shuame.mobile.sdk.impl.utils.C1227f.m3456a(r1);
        r2 = f3249a;
        r3 = new java.lang.StringBuilder;
        r4 = "end md5File:";
        r3.<init>(r4);
        r4 = r14.f3250b;
        r4 = r4.path;
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r2, r3);
        r2 = r14.f3250b;
        r2 = r2.md5;
        r2 = r2.equalsIgnoreCase(r1);
        if (r2 != 0) goto L_0x0bb9;
    L_0x0b93:
        r2 = f3249a;
        r3 = new java.lang.StringBuilder;
        r4 = "md5File not same, server md5:";
        r3.<init>(r4);
        r4 = r14.f3250b;
        r4 = r4.md5;
        r3 = r3.append(r4);
        r4 = "; local md5:";
        r3 = r3.append(r4);
        r1 = r3.append(r1);
        r1 = r1.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r2, r1);
        r1 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_MD5;
        r14.f3260l = r1;
    L_0x0bb9:
        throw r0;
    L_0x0bba:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0904;
    L_0x0bc0:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0909;
    L_0x0bc6:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0912;
    L_0x0bcc:
        r0 = 0;
        goto L_0x0976;
    L_0x0bcf:
        r1.delete();
        r0 = f3249a;
        r1 = "File integrity failed";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r1);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_MD5;
        r14.f3260l = r0;
        goto L_0x09cc;
    L_0x0bdf:
        r0 = move-exception;
    L_0x0be0:
        r0.printStackTrace();	 Catch:{ all -> 0x0a5f }
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.CANCEL;	 Catch:{ all -> 0x0a5f }
        r14.f3260l = r0;	 Catch:{ all -> 0x0a5f }
        if (r6 == 0) goto L_0x0bec;
    L_0x0be9:
        r6.close();	 Catch:{ IOException -> 0x0d41 }
    L_0x0bec:
        if (r1 == 0) goto L_0x0bf1;
    L_0x0bee:
        r1.close();	 Catch:{ IOException -> 0x0d47 }
    L_0x0bf1:
        r0 = r14.f3252d;
        if (r0 == 0) goto L_0x0bfa;
    L_0x0bf5:
        r0 = r14.f3252d;	 Catch:{ Exception -> 0x0d4d }
        r0.disconnect();	 Catch:{ Exception -> 0x0d4d }
    L_0x0bfa:
        r0 = 0;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0c29;
    L_0x0c00:
        r0 = java.lang.System.currentTimeMillis();
        r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r6 <= 0) goto L_0x0c16;
    L_0x0c08:
        r4 = (double) r4;
        r6 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r4 = r4 * r6;
        r0 = r0 - r2;
        r0 = (double) r0;
        r0 = r4 / r0;
        r0 = (int) r0;
        r14.f3259k = r0;
    L_0x0c16:
        r0 = r14.f3256h;
        r0 = (double) r0;
        r2 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r0 = r0 * r2;
        r2 = r14.f3257i;
        r2 = (double) r2;
        r0 = r0 / r2;
        r0 = (int) r0;
        r14.f3258j = r0;
        r14.mo6855b();
    L_0x0c29:
        r0 = r14.f3256h;
        r2 = r14.f3257i;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0cb4;
    L_0x0c31:
        r1 = new java.io.File;
        r0 = new java.lang.StringBuilder;
        r2 = r14.f3250b;
        r2 = r2.path;
        r2 = java.lang.String.valueOf(r2);
        r0.<init>(r2);
        r2 = ".tmp";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        r0 = r1.exists();
        if (r0 == 0) goto L_0x0cb4;
    L_0x0c53:
        r2 = r1.length();
        r4 = r14.f3257i;
        r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0d53;
    L_0x0c5d:
        r0 = 1;
    L_0x0c5e:
        if (r0 == 0) goto L_0x0d56;
    L_0x0c60:
        r0 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "retry rename: ";
        r2.<init>(r3);
        r3 = r1.getAbsolutePath();
        r2 = r2.append(r3);
        r3 = "=>";
        r2 = r2.append(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r2);
        r0 = r1.getAbsolutePath();
        r1 = r14.f3250b;
        r1 = r1.path;
        r2 = 3;
        r0 = com.shuame.mobile.sdk.impl.utils.C1220b.m3448a(r0, r1, r2);
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "retry rename, isRenameOk:";
        r2.<init>(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        if (r0 != 0) goto L_0x0cb4;
    L_0x0ca9:
        r0 = f3249a;
        r1 = "File rename failed";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r1);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_RENAME;
        r14.f3260l = r0;
    L_0x0cb4:
        r0 = r14.f3254f;
        if (r0 == 0) goto L_0x0cbc;
    L_0x0cb8:
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.CANCEL;
        r14.f3260l = r0;
    L_0x0cbc:
        r0 = r14.f3260l;
        r1 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.f3242OK;
        if (r0 != r1) goto L_0x01ec;
    L_0x0cc2:
        r0 = r14.f3250b;
        r0 = r0.md5;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x01ec;
    L_0x0ccc:
        r0 = new java.io.File;
        r1 = r14.f3250b;
        r1 = r1.path;
        r0.<init>(r1);
        r1 = r0.exists();
        if (r1 == 0) goto L_0x01ec;
    L_0x0cdb:
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "start md5File:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        r0 = com.shuame.mobile.sdk.impl.utils.C1227f.m3456a(r0);
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "end md5File:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        r1 = r14.f3250b;
        r1 = r1.md5;
        r1 = r1.equalsIgnoreCase(r0);
        if (r1 != 0) goto L_0x01ec;
    L_0x0d19:
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "md5File not same, server md5:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.md5;
        r2 = r2.append(r3);
        r3 = "; local md5:";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r0);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_MD5;
        r14.f3260l = r0;
        goto L_0x01ec;
    L_0x0d41:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0bec;
    L_0x0d47:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0bf1;
    L_0x0d4d:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0bfa;
    L_0x0d53:
        r0 = 0;
        goto L_0x0c5e;
    L_0x0d56:
        r1.delete();
        r0 = f3249a;
        r1 = "File integrity failed";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r1);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_MD5;
        r14.f3260l = r0;
        goto L_0x0cb4;
    L_0x0d66:
        r0 = move-exception;
    L_0x0d67:
        r0.printStackTrace();	 Catch:{ all -> 0x0a5f }
        if (r6 == 0) goto L_0x0d6f;
    L_0x0d6c:
        r6.close();	 Catch:{ IOException -> 0x0ec4 }
    L_0x0d6f:
        if (r1 == 0) goto L_0x0d74;
    L_0x0d71:
        r1.close();	 Catch:{ IOException -> 0x0eca }
    L_0x0d74:
        r0 = r14.f3252d;
        if (r0 == 0) goto L_0x0d7d;
    L_0x0d78:
        r0 = r14.f3252d;	 Catch:{ Exception -> 0x0ed0 }
        r0.disconnect();	 Catch:{ Exception -> 0x0ed0 }
    L_0x0d7d:
        r0 = 0;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0dac;
    L_0x0d83:
        r0 = java.lang.System.currentTimeMillis();
        r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r6 <= 0) goto L_0x0d99;
    L_0x0d8b:
        r4 = (double) r4;
        r6 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r4 = r4 * r6;
        r0 = r0 - r2;
        r0 = (double) r0;
        r0 = r4 / r0;
        r0 = (int) r0;
        r14.f3259k = r0;
    L_0x0d99:
        r0 = r14.f3256h;
        r0 = (double) r0;
        r2 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r0 = r0 * r2;
        r2 = r14.f3257i;
        r2 = (double) r2;
        r0 = r0 / r2;
        r0 = (int) r0;
        r14.f3258j = r0;
        r14.mo6855b();
    L_0x0dac:
        r0 = r14.f3256h;
        r2 = r14.f3257i;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0e37;
    L_0x0db4:
        r1 = new java.io.File;
        r0 = new java.lang.StringBuilder;
        r2 = r14.f3250b;
        r2 = r2.path;
        r2 = java.lang.String.valueOf(r2);
        r0.<init>(r2);
        r2 = ".tmp";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        r0 = r1.exists();
        if (r0 == 0) goto L_0x0e37;
    L_0x0dd6:
        r2 = r1.length();
        r4 = r14.f3257i;
        r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0ed6;
    L_0x0de0:
        r0 = 1;
    L_0x0de1:
        if (r0 == 0) goto L_0x0ed9;
    L_0x0de3:
        r0 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "retry rename: ";
        r2.<init>(r3);
        r3 = r1.getAbsolutePath();
        r2 = r2.append(r3);
        r3 = "=>";
        r2 = r2.append(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r2);
        r0 = r1.getAbsolutePath();
        r1 = r14.f3250b;
        r1 = r1.path;
        r2 = 3;
        r0 = com.shuame.mobile.sdk.impl.utils.C1220b.m3448a(r0, r1, r2);
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "retry rename, isRenameOk:";
        r2.<init>(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        if (r0 != 0) goto L_0x0e37;
    L_0x0e2c:
        r0 = f3249a;
        r1 = "File rename failed";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r1);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_RENAME;
        r14.f3260l = r0;
    L_0x0e37:
        r0 = r14.f3254f;
        if (r0 == 0) goto L_0x0e3f;
    L_0x0e3b:
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.CANCEL;
        r14.f3260l = r0;
    L_0x0e3f:
        r0 = r14.f3260l;
        r1 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.f3242OK;
        if (r0 != r1) goto L_0x01ec;
    L_0x0e45:
        r0 = r14.f3250b;
        r0 = r0.md5;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x01ec;
    L_0x0e4f:
        r0 = new java.io.File;
        r1 = r14.f3250b;
        r1 = r1.path;
        r0.<init>(r1);
        r1 = r0.exists();
        if (r1 == 0) goto L_0x01ec;
    L_0x0e5e:
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "start md5File:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        r0 = com.shuame.mobile.sdk.impl.utils.C1227f.m3456a(r0);
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "end md5File:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.path;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        r1 = r14.f3250b;
        r1 = r1.md5;
        r1 = r1.equalsIgnoreCase(r0);
        if (r1 != 0) goto L_0x01ec;
    L_0x0e9c:
        r1 = f3249a;
        r2 = new java.lang.StringBuilder;
        r3 = "md5File not same, server md5:";
        r2.<init>(r3);
        r3 = r14.f3250b;
        r3 = r3.md5;
        r2 = r2.append(r3);
        r3 = "; local md5:";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r0);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_MD5;
        r14.f3260l = r0;
        goto L_0x01ec;
    L_0x0ec4:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0d6f;
    L_0x0eca:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0d74;
    L_0x0ed0:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0d7d;
    L_0x0ed6:
        r0 = 0;
        goto L_0x0de1;
    L_0x0ed9:
        r1.delete();
        r0 = f3249a;
        r1 = "File integrity failed";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r1);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_MD5;
        r14.f3260l = r0;
        goto L_0x0e37;
    L_0x0ee9:
        r6 = move-exception;
        r6.printStackTrace();
        goto L_0x0a65;
    L_0x0eef:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0a6a;
    L_0x0ef5:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0a73;
    L_0x0efb:
        r1 = 0;
        goto L_0x0ad8;
    L_0x0efe:
        r2.delete();
        r1 = f3249a;
        r2 = "File integrity failed";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);
        r1 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_MD5;
        r14.f3260l = r1;
        goto L_0x0b2e;
    L_0x0f0e:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x056b;
    L_0x0f14:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0570;
    L_0x0f1a:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0579;
    L_0x0f20:
        r0 = 0;
        goto L_0x05dd;
    L_0x0f23:
        r1.delete();
        r0 = f3249a;
        r1 = "File integrity failed";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r0, r1);
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_MD5;
        r14.f3260l = r0;
        goto L_0x0633;
    L_0x0f33:
        r0 = move-exception;
        r6 = r7;
        goto L_0x0a60;
    L_0x0f37:
        r0 = move-exception;
        r1 = r6;
        r6 = r7;
        goto L_0x0a60;
    L_0x0f3c:
        r0 = move-exception;
        r6 = r7;
        goto L_0x0d67;
    L_0x0f40:
        r0 = move-exception;
        r1 = r6;
        r6 = r7;
        goto L_0x0d67;
    L_0x0f45:
        r0 = move-exception;
        r6 = r7;
        goto L_0x0be0;
    L_0x0f49:
        r0 = move-exception;
        r1 = r6;
        r6 = r7;
        goto L_0x0be0;
    L_0x0f4e:
        r0 = move-exception;
        r6 = r7;
        goto L_0x08db;
    L_0x0f52:
        r0 = move-exception;
        r1 = r6;
        r6 = r7;
        goto L_0x08db;
    L_0x0f57:
        r0 = move-exception;
        r6 = r7;
        goto L_0x0754;
    L_0x0f5b:
        r0 = move-exception;
        r1 = r6;
        r6 = r7;
        goto L_0x0754;
    L_0x0f60:
        r0 = move-exception;
        r6 = r7;
        goto L_0x01f8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.mobile.sdk.impl.utils.http.a.f():void");
    }

    /* renamed from: g */
    private String m3467g() {
        String str = "";
        try {
            return InetAddress.getByName(new URL(this.f3250b.url).getHost()).getHostAddress();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return str;
        } catch (UnknownHostException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    /* renamed from: a */
    public void mo6854a() {
        this.f3254f = true;
        if (this.f3252d != null) {
            try {
                this.f3252d.disconnect();
            } catch (Exception e) {
                C1228g.m3458a(f3249a, "cancel disconnect Exception");
                e.printStackTrace();
            }
        }
        Thread.currentThread().interrupt();
    }

    /* renamed from: b */
    public void mo6855b() {
        if (this.f3251c != null) {
            try {
                this.f3251c.onTaskInfo(this.f3250b.taskId, this.f3258j, this.f3259k);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    public void mo6856c() {
        if (this.f3251c != null) {
            try {
                Map hashMap = new HashMap();
                if (!(this.f3260l == DownloadResultCode.f3242OK || this.f3260l == DownloadResultCode.CANCEL)) {
                    hashMap.put("IpAddress", m3467g());
                    hashMap.put("Range", Long.valueOf(this.f3262n));
                    hashMap.put("ContentLength", Long.valueOf(this.f3263o));
                    hashMap.put("StatusCode", Integer.valueOf(this.f3261m));
                    File file = new File(this.f3250b.path);
                    if (file.exists()) {
                        hashMap.put("FileSize", Long.valueOf(file.length()));
                    }
                    file = new File(new StringBuilder(String.valueOf(this.f3250b.path)).append(".tmp").toString());
                    if (file.exists()) {
                        hashMap.put("TmpFileSize", Long.valueOf(file.length()));
                    }
                }
                this.f3251c.onComplete(this.f3250b.taskId, this.f3260l, hashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x006e  */
    public void run() {
        /*
        r6 = this;
        r0 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.ERROR_UNKNOWN;
        r6.f3260l = r0;
        r2 = java.lang.System.currentTimeMillis();
        r0 = 0;
        r1 = 10;
        android.os.Process.setThreadPriority(r1);
        r1 = com.shuame.mobile.sdk.impl.utils.C1219a.m3445a();
        if (r1 == 0) goto L_0x002a;
    L_0x0014:
        r0 = com.shuame.mobile.sdk.impl.utils.C1219a.m3445a();
        r1 = "power";
        r0 = r0.getSystemService(r1);
        r0 = (android.os.PowerManager) r0;
        r1 = 1;
        r4 = "DownloadTaskWakeLock";
        r0 = r0.newWakeLock(r1, r4);
        r0.acquire();
    L_0x002a:
        r1 = r6.f3255g;
        r1 = r1 + 1;
        r6.f3255g = r1;
        r1 = f3249a;
        r4 = new java.lang.StringBuilder;
        r5 = "download try count:";
        r4.<init>(r5);
        r5 = r6.f3255g;
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r4);
        r1 = r6.m3465e();
        if (r1 == 0) goto L_0x009c;
    L_0x004c:
        r1 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.f3242OK;
        r6.f3260l = r1;
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r6.f3261m = r1;
        r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6.f3258j = r1;
        r6.mo6855b();
    L_0x005b:
        r1 = r6.f3260l;
        r4 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.f3242OK;
        if (r1 == r4) goto L_0x006c;
    L_0x0061:
        r1 = r6.f3260l;
        r4 = com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode.CANCEL;
        if (r1 == r4) goto L_0x006c;
    L_0x0067:
        r1 = r6.f3255g;
        r4 = 3;
        if (r1 < r4) goto L_0x002a;
    L_0x006c:
        if (r0 == 0) goto L_0x0071;
    L_0x006e:
        r0.release();
    L_0x0071:
        r6.mo6856c();
        r0 = java.lang.System.currentTimeMillis();
        r0 = r0 - r2;
        r2 = f3249a;
        r3 = new java.lang.StringBuilder;
        r4 = "taskId=";
        r3.<init>(r4);
        r4 = r6.f3250b;
        r4 = r4.taskId;
        r3 = r3.append(r4);
        r4 = ";costTime=";
        r3 = r3.append(r4);
        r0 = r3.append(r0);
        r0 = r0.toString();
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r2, r0);
        return;
    L_0x009c:
        r6.m3466f();
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.mobile.sdk.impl.utils.http.a.run():void");
    }
}
