package com.baidu.mobads.openad.p029c;

import android.content.Context;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p025c.C0265a;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;

/* renamed from: com.baidu.mobads.openad.c.a */
public class C0358a extends Observable implements IOAdDownloader, Runnable {
    /* renamed from: a */
    protected Context f744a;
    /* renamed from: b */
    protected URL f745b;
    /* renamed from: c */
    protected URL f746c;
    /* renamed from: d */
    protected String f747d;
    /* renamed from: e */
    protected int f748e;
    /* renamed from: f */
    protected Boolean f749f = Boolean.valueOf(true);
    /* renamed from: g */
    protected String f750g;
    /* renamed from: h */
    protected int f751h;
    /* renamed from: i */
    protected DownloadStatus f752i;
    /* renamed from: j */
    protected volatile int f753j;
    /* renamed from: k */
    protected int f754k;
    /* renamed from: l */
    protected ArrayList<C0357a> f755l;
    /* renamed from: m */
    C0363g f756m = null;
    /* renamed from: n */
    private String f757n;
    /* renamed from: o */
    private String f758o;

    /* renamed from: com.baidu.mobads.openad.c.a$a */
    protected class C0357a implements Runnable {
        /* renamed from: a */
        protected int f732a;
        /* renamed from: b */
        protected URL f733b;
        /* renamed from: c */
        protected String f734c;
        /* renamed from: d */
        protected int f735d;
        /* renamed from: e */
        protected int f736e;
        /* renamed from: f */
        protected int f737f;
        /* renamed from: g */
        protected boolean f738g;
        /* renamed from: h */
        protected Thread f739h;
        /* renamed from: j */
        private volatile boolean f741j = false;
        /* renamed from: k */
        private volatile int f742k = 0;
        /* renamed from: l */
        private HttpURLConnection f743l;

        public C0357a(int i, URL url, String str, int i2, int i3, int i4) {
            this.f732a = i;
            this.f733b = url;
            this.f734c = str;
            this.f735d = i2;
            this.f736e = i3;
            this.f737f = i4;
            this.f738g = false;
        }

        /* renamed from: a */
        public void mo5070a(HttpURLConnection httpURLConnection) {
            this.f743l = httpURLConnection;
        }

        /* renamed from: a */
        public boolean mo5071a() {
            return this.f738g;
        }

        /* renamed from: b */
        public synchronized void mo5072b() {
            this.f741j = false;
            this.f739h = new Thread(this);
            this.f739h.start();
        }

        /* renamed from: c */
        public synchronized void mo5073c() {
            this.f741j = true;
            this.f742k++;
        }

        /* renamed from: d */
        public void mo5074d() {
            if (this.f739h != null) {
                this.f739h.join();
                return;
            }
            C0338m.m569a().mo5033f().mo4939w("DownloadThread", "Warning: mThread in DownloadThread.waitFinish is null");
        }

        /* JADX WARNING: Removed duplicated region for block: B:137:0x031c A:{SYNTHETIC, Splitter: B:137:0x031c} */
        /* JADX WARNING: Removed duplicated region for block: B:140:0x0321 A:{SYNTHETIC, Splitter: B:140:0x0321} */
        /* JADX WARNING: Removed duplicated region for block: B:143:0x0326 A:{SYNTHETIC, Splitter: B:143:0x0326} */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x012a A:{Catch:{ all -> 0x04a7 }} */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x0165 A:{SYNTHETIC, Splitter: B:50:0x0165} */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x016a A:{SYNTHETIC, Splitter: B:53:0x016a} */
        /* JADX WARNING: Removed duplicated region for block: B:198:? A:{SYNTHETIC, RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x016f A:{SYNTHETIC, Splitter: B:56:0x016f} */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x031c A:{SYNTHETIC, Splitter: B:137:0x031c} */
        /* JADX WARNING: Removed duplicated region for block: B:140:0x0321 A:{SYNTHETIC, Splitter: B:140:0x0321} */
        /* JADX WARNING: Removed duplicated region for block: B:143:0x0326 A:{SYNTHETIC, Splitter: B:143:0x0326} */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x031c A:{SYNTHETIC, Splitter: B:137:0x031c} */
        /* JADX WARNING: Removed duplicated region for block: B:140:0x0321 A:{SYNTHETIC, Splitter: B:140:0x0321} */
        /* JADX WARNING: Removed duplicated region for block: B:143:0x0326 A:{SYNTHETIC, Splitter: B:143:0x0326} */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x031c A:{SYNTHETIC, Splitter: B:137:0x031c} */
        /* JADX WARNING: Removed duplicated region for block: B:140:0x0321 A:{SYNTHETIC, Splitter: B:140:0x0321} */
        /* JADX WARNING: Removed duplicated region for block: B:143:0x0326 A:{SYNTHETIC, Splitter: B:143:0x0326} */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x012a A:{Catch:{ all -> 0x04a7 }} */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x0165 A:{SYNTHETIC, Splitter: B:50:0x0165} */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x016a A:{SYNTHETIC, Splitter: B:53:0x016a} */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x016f A:{SYNTHETIC, Splitter: B:56:0x016f} */
        /* JADX WARNING: Removed duplicated region for block: B:198:? A:{SYNTHETIC, RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x031c A:{SYNTHETIC, Splitter: B:137:0x031c} */
        /* JADX WARNING: Removed duplicated region for block: B:140:0x0321 A:{SYNTHETIC, Splitter: B:140:0x0321} */
        /* JADX WARNING: Removed duplicated region for block: B:143:0x0326 A:{SYNTHETIC, Splitter: B:143:0x0326} */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x012a A:{Catch:{ all -> 0x04a7 }} */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x0165 A:{SYNTHETIC, Splitter: B:50:0x0165} */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x016a A:{SYNTHETIC, Splitter: B:53:0x016a} */
        /* JADX WARNING: Removed duplicated region for block: B:198:? A:{SYNTHETIC, RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x016f A:{SYNTHETIC, Splitter: B:56:0x016f} */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x031c A:{SYNTHETIC, Splitter: B:137:0x031c} */
        /* JADX WARNING: Removed duplicated region for block: B:140:0x0321 A:{SYNTHETIC, Splitter: B:140:0x0321} */
        /* JADX WARNING: Removed duplicated region for block: B:143:0x0326 A:{SYNTHETIC, Splitter: B:143:0x0326} */
        public void run() {
            /*
            r12 = this;
            r2 = 0;
            r11 = 2;
            r10 = 1;
            r9 = 0;
            r5 = r12.f742k;
            r1 = 0;
            r3 = 0;
            r0 = r12.f735d;	 Catch:{ Exception -> 0x04ad, all -> 0x0490 }
            r4 = r12.f737f;	 Catch:{ Exception -> 0x04ad, all -> 0x0490 }
            r0 = r0 + r4;
            r4 = r12.f736e;	 Catch:{ Exception -> 0x04ad, all -> 0x0490 }
            if (r0 < r4) goto L_0x005b;
        L_0x0011:
            r0 = 1;
            r12.f738g = r0;	 Catch:{ Exception -> 0x04ad, all -> 0x0490 }
            r1 = r2;
            r3 = r2;
            r4 = r2;
        L_0x0017:
            r0 = com.baidu.mobads.p021j.C0338m.m569a();
            r0 = r0.mo5033f();
            r2 = "DownloadThread";
            r6 = new java.lang.StringBuilder;
            r7 = "Thread[";
            r6.<init>(r7);
            r7 = r12.f732a;
            r6 = r6.append(r7);
            r7 = "] ver(";
            r6 = r6.append(r7);
            r5 = r6.append(r5);
            r6 = ") executed end; isFinished=";
            r5 = r5.append(r6);
            r6 = r12.f738g;
            r5 = r5.append(r6);
            r5 = r5.toString();
            r0.mo4922d(r2, r5);
            if (r1 == 0) goto L_0x0050;
        L_0x004d:
            r1.close();	 Catch:{ IOException -> 0x03a9 }
        L_0x0050:
            if (r3 == 0) goto L_0x0055;
        L_0x0052:
            r3.close();	 Catch:{ IOException -> 0x03c3 }
        L_0x0055:
            if (r4 == 0) goto L_0x005a;
        L_0x0057:
            r4.disconnect();	 Catch:{ Exception -> 0x03dd }
        L_0x005a:
            return;
        L_0x005b:
            r0 = r12.f743l;	 Catch:{ Exception -> 0x04ad, all -> 0x0490 }
            if (r0 != 0) goto L_0x02d8;
        L_0x005f:
            r0 = r12.f733b;	 Catch:{ Exception -> 0x04ad, all -> 0x0490 }
            r0 = r0.openConnection();	 Catch:{ Exception -> 0x04ad, all -> 0x0490 }
            r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x04ad, all -> 0x0490 }
            r4 = com.baidu.mobads.openad.p029c.C0358a.this;	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r4 = r4.f749f;	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r4 = r4.booleanValue();	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            if (r4 == 0) goto L_0x010d;
        L_0x0071:
            r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r4.<init>();	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r6 = r12.f735d;	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r7 = r12.f737f;	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r6 = r6 + r7;
            r4 = r4.append(r6);	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r6 = "-";
            r4 = r4.append(r6);	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r6 = r12.f736e;	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r4 = r4.append(r6);	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r4 = r4.toString();	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r6 = "Range";
            r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r8 = "bytes=";
            r7.<init>(r8);	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r4 = r7.append(r4);	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r4 = r4.toString();	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r0.setRequestProperty(r6, r4);	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
        L_0x00a3:
            r0.connect();	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r4 = r0.getResponseCode();	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r6 = r12.f742k;	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            if (r5 == r6) goto L_0x018b;
        L_0x00ae:
            r4 = com.baidu.mobads.p021j.C0338m.m569a();
            r4 = r4.mo5033f();
            r6 = "DownloadThread";
            r7 = new java.lang.StringBuilder;
            r8 = "Thread[";
            r7.<init>(r8);
            r8 = r12.f732a;
            r7 = r7.append(r8);
            r8 = "] ver(";
            r7 = r7.append(r8);
            r5 = r7.append(r5);
            r7 = ") executed end; isFinished=";
            r5 = r5.append(r7);
            r7 = r12.f738g;
            r5 = r5.append(r7);
            r5 = r5.toString();
            r4.mo4922d(r6, r5);
            if (r2 == 0) goto L_0x00e7;
        L_0x00e4:
            r3.close();	 Catch:{ IOException -> 0x03f4 }
        L_0x00e7:
            if (r2 == 0) goto L_0x00ec;
        L_0x00e9:
            r1.close();	 Catch:{ IOException -> 0x040e }
        L_0x00ec:
            if (r0 == 0) goto L_0x005a;
        L_0x00ee:
            r0.disconnect();	 Catch:{ Exception -> 0x00f3 }
            goto L_0x005a;
        L_0x00f3:
            r0 = move-exception;
            r1 = com.baidu.mobads.p021j.C0338m.m569a();
            r1 = r1.mo5033f();
            r2 = new java.lang.Object[r11];
            r3 = "DownloadThread";
            r2[r9] = r3;
            r0 = r0.getMessage();
            r2[r10] = r0;
        L_0x0108:
            r1.mo4939w(r2);
            goto L_0x005a;
        L_0x010d:
            r4 = 0;
            r12.f737f = r4;	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            goto L_0x00a3;
        L_0x0111:
            r1 = move-exception;
            r3 = r0;
            r0 = r1;
            r1 = r2;
        L_0x0115:
            r4 = com.baidu.mobads.p021j.C0338m.m569a();	 Catch:{ all -> 0x04a7 }
            r4 = r4.mo5033f();	 Catch:{ all -> 0x04a7 }
            r6 = "DownloadThread";
            r0 = r0.getMessage();	 Catch:{ all -> 0x04a7 }
            r4.mo4922d(r6, r0);	 Catch:{ all -> 0x04a7 }
            r0 = r12.f742k;	 Catch:{ all -> 0x04a7 }
            if (r5 != r0) goto L_0x012f;
        L_0x012a:
            r0 = com.baidu.mobads.openad.p029c.C0358a.this;	 Catch:{ all -> 0x04a7 }
            r0.mo5081b();	 Catch:{ all -> 0x04a7 }
        L_0x012f:
            r0 = com.baidu.mobads.p021j.C0338m.m569a();
            r0 = r0.mo5033f();
            r4 = "DownloadThread";
            r6 = new java.lang.StringBuilder;
            r7 = "Thread[";
            r6.<init>(r7);
            r7 = r12.f732a;
            r6 = r6.append(r7);
            r7 = "] ver(";
            r6 = r6.append(r7);
            r5 = r6.append(r5);
            r6 = ") executed end; isFinished=";
            r5 = r5.append(r6);
            r6 = r12.f738g;
            r5 = r5.append(r6);
            r5 = r5.toString();
            r0.mo4922d(r4, r5);
            if (r1 == 0) goto L_0x0168;
        L_0x0165:
            r1.close();	 Catch:{ IOException -> 0x0375 }
        L_0x0168:
            if (r2 == 0) goto L_0x016d;
        L_0x016a:
            r2.close();	 Catch:{ IOException -> 0x038f }
        L_0x016d:
            if (r3 == 0) goto L_0x005a;
        L_0x016f:
            r3.disconnect();	 Catch:{ Exception -> 0x0174 }
            goto L_0x005a;
        L_0x0174:
            r0 = move-exception;
            r1 = com.baidu.mobads.p021j.C0338m.m569a();
            r1 = r1.mo5033f();
            r2 = new java.lang.Object[r11];
            r3 = "DownloadThread";
            r2[r9] = r3;
            r0 = r0.getMessage();
            r2[r10] = r0;
            goto L_0x0108;
        L_0x018b:
            r4 = r4 / 100;
            if (r4 == r11) goto L_0x01f0;
        L_0x018f:
            r4 = com.baidu.mobads.openad.p029c.C0358a.this;	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r4.mo5081b();	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r4 = com.baidu.mobads.p021j.C0338m.m569a();
            r4 = r4.mo5033f();
            r6 = "DownloadThread";
            r7 = new java.lang.StringBuilder;
            r8 = "Thread[";
            r7.<init>(r8);
            r8 = r12.f732a;
            r7 = r7.append(r8);
            r8 = "] ver(";
            r7 = r7.append(r8);
            r5 = r7.append(r5);
            r7 = ") executed end; isFinished=";
            r5 = r5.append(r7);
            r7 = r12.f738g;
            r5 = r5.append(r7);
            r5 = r5.toString();
            r4.mo4922d(r6, r5);
            if (r2 == 0) goto L_0x01cd;
        L_0x01ca:
            r3.close();	 Catch:{ IOException -> 0x0428 }
        L_0x01cd:
            if (r2 == 0) goto L_0x01d2;
        L_0x01cf:
            r1.close();	 Catch:{ IOException -> 0x0442 }
        L_0x01d2:
            if (r0 == 0) goto L_0x005a;
        L_0x01d4:
            r0.disconnect();	 Catch:{ Exception -> 0x01d9 }
            goto L_0x005a;
        L_0x01d9:
            r0 = move-exception;
            r1 = com.baidu.mobads.p021j.C0338m.m569a();
            r1 = r1.mo5033f();
            r2 = new java.lang.Object[r11];
            r3 = "DownloadThread";
            r2[r9] = r3;
            r0 = r0.getMessage();
            r2[r10] = r0;
            goto L_0x0108;
        L_0x01f0:
            r4 = r0.getContentType();	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r6 = "text/html";
            r4 = r4.equals(r6);	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            if (r4 == 0) goto L_0x025d;
        L_0x01fc:
            r4 = com.baidu.mobads.openad.p029c.C0358a.this;	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r4.mo5081b();	 Catch:{ Exception -> 0x0111, all -> 0x0495 }
            r4 = com.baidu.mobads.p021j.C0338m.m569a();
            r4 = r4.mo5033f();
            r6 = "DownloadThread";
            r7 = new java.lang.StringBuilder;
            r8 = "Thread[";
            r7.<init>(r8);
            r8 = r12.f732a;
            r7 = r7.append(r8);
            r8 = "] ver(";
            r7 = r7.append(r8);
            r5 = r7.append(r5);
            r7 = ") executed end; isFinished=";
            r5 = r5.append(r7);
            r7 = r12.f738g;
            r5 = r5.append(r7);
            r5 = r5.toString();
            r4.mo4922d(r6, r5);
            if (r2 == 0) goto L_0x023a;
        L_0x0237:
            r3.close();	 Catch:{ IOException -> 0x045c }
        L_0x023a:
            if (r2 == 0) goto L_0x023f;
        L_0x023c:
            r1.close();	 Catch:{ IOException -> 0x0476 }
        L_0x023f:
            if (r0 == 0) goto L_0x005a;
        L_0x0241:
            r0.disconnect();	 Catch:{ Exception -> 0x0246 }
            goto L_0x005a;
        L_0x0246:
            r0 = move-exception;
            r1 = com.baidu.mobads.p021j.C0338m.m569a();
            r1 = r1.mo5033f();
            r2 = new java.lang.Object[r11];
            r3 = "DownloadThread";
            r2[r9] = r3;
            r0 = r0.getMessage();
            r2[r10] = r0;
            goto L_0x0108;
        L_0x025d:
            r4 = r0;
        L_0x025e:
            r3 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x04b7, all -> 0x04a0 }
            r0 = r4.getInputStream();	 Catch:{ Exception -> 0x04b7, all -> 0x04a0 }
            r3.<init>(r0);	 Catch:{ Exception -> 0x04b7, all -> 0x04a0 }
            r0 = r12.f735d;	 Catch:{ Exception -> 0x04bc, all -> 0x04a4 }
            r1 = r12.f737f;	 Catch:{ Exception -> 0x04bc, all -> 0x04a4 }
            r0 = r0 + r1;
            r1 = com.baidu.mobads.p021j.C0338m.m569a();	 Catch:{ Exception -> 0x04bc, all -> 0x04a4 }
            r1 = r1.mo5033f();	 Catch:{ Exception -> 0x04bc, all -> 0x04a4 }
            r6 = "DownloadThread";
            r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04bc, all -> 0x04a4 }
            r8 = "tmpStartByte = ";
            r7.<init>(r8);	 Catch:{ Exception -> 0x04bc, all -> 0x04a4 }
            r7 = r7.append(r0);	 Catch:{ Exception -> 0x04bc, all -> 0x04a4 }
            r7 = r7.toString();	 Catch:{ Exception -> 0x04bc, all -> 0x04a4 }
            r1.mo4922d(r6, r7);	 Catch:{ Exception -> 0x04bc, all -> 0x04a4 }
            r1 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x04bc, all -> 0x04a4 }
            r6 = r12.f734c;	 Catch:{ Exception -> 0x04bc, all -> 0x04a4 }
            r7 = "rw";
            r1.<init>(r6, r7);	 Catch:{ Exception -> 0x04bc, all -> 0x04a4 }
            r6 = (long) r0;
            r1.seek(r6);	 Catch:{ Exception -> 0x02d3, all -> 0x02e4 }
            r2 = 102400; // 0x19000 float:1.43493E-40 double:5.05923E-319;
            r2 = new byte[r2];	 Catch:{ Exception -> 0x02d3, all -> 0x02e4 }
        L_0x029a:
            r6 = com.baidu.mobads.openad.p029c.C0358a.this;	 Catch:{ Exception -> 0x02d3, all -> 0x02e4 }
            r6 = r6.f752i;	 Catch:{ Exception -> 0x02d3, all -> 0x02e4 }
            r7 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.DOWNLOADING;	 Catch:{ Exception -> 0x02d3, all -> 0x02e4 }
            if (r6 != r7) goto L_0x02ca;
        L_0x02a2:
            r6 = 0;
            r7 = 102400; // 0x19000 float:1.43493E-40 double:5.05923E-319;
            r6 = r3.read(r2, r6, r7);	 Catch:{ Exception -> 0x02d3, all -> 0x02e4 }
            r7 = -1;
            if (r6 == r7) goto L_0x02ca;
        L_0x02ad:
            r7 = r12.f736e;	 Catch:{ Exception -> 0x02d3, all -> 0x02e4 }
            if (r0 >= r7) goto L_0x02ca;
        L_0x02b1:
            r7 = r12.f742k;	 Catch:{ Exception -> 0x02d3, all -> 0x02e4 }
            if (r5 != r7) goto L_0x02ca;
        L_0x02b5:
            r7 = 0;
            r1.write(r2, r7, r6);	 Catch:{ Exception -> 0x02d3, all -> 0x02e4 }
            r7 = r12.f737f;	 Catch:{ Exception -> 0x02d3, all -> 0x02e4 }
            r7 = r7 + r6;
            r12.f737f = r7;	 Catch:{ Exception -> 0x02d3, all -> 0x02e4 }
            r0 = r0 + r6;
            r7 = com.baidu.mobads.openad.p029c.C0358a.this;	 Catch:{ Exception -> 0x02d3, all -> 0x02e4 }
            r7.mo5077a(r6);	 Catch:{ Exception -> 0x02d3, all -> 0x02e4 }
            monitor-enter(r12);	 Catch:{ Exception -> 0x02d3, all -> 0x02e4 }
            r6 = r12.f741j;	 Catch:{ all -> 0x02e1 }
            if (r6 == 0) goto L_0x02df;
        L_0x02c9:
            monitor-exit(r12);	 Catch:{ all -> 0x02e1 }
        L_0x02ca:
            r2 = r12.f736e;	 Catch:{ Exception -> 0x02d3, all -> 0x02e4 }
            if (r0 < r2) goto L_0x0017;
        L_0x02ce:
            r0 = 1;
            r12.f738g = r0;	 Catch:{ Exception -> 0x02d3, all -> 0x02e4 }
            goto L_0x0017;
        L_0x02d3:
            r0 = move-exception;
            r2 = r3;
            r3 = r4;
            goto L_0x0115;
        L_0x02d8:
            r1 = r12.f743l;	 Catch:{ Exception -> 0x04ad, all -> 0x0490 }
            r0 = 0;
            r12.f743l = r0;	 Catch:{ Exception -> 0x04b2, all -> 0x049b }
            r4 = r1;
            goto L_0x025e;
        L_0x02df:
            monitor-exit(r12);	 Catch:{ all -> 0x02e1 }
            goto L_0x029a;
        L_0x02e1:
            r0 = move-exception;
            monitor-exit(r12);	 Catch:{ all -> 0x02e1 }
            throw r0;	 Catch:{ Exception -> 0x02d3, all -> 0x02e4 }
        L_0x02e4:
            r0 = move-exception;
            r2 = r1;
        L_0x02e6:
            r1 = com.baidu.mobads.p021j.C0338m.m569a();
            r1 = r1.mo5033f();
            r6 = "DownloadThread";
            r7 = new java.lang.StringBuilder;
            r8 = "Thread[";
            r7.<init>(r8);
            r8 = r12.f732a;
            r7 = r7.append(r8);
            r8 = "] ver(";
            r7 = r7.append(r8);
            r5 = r7.append(r5);
            r7 = ") executed end; isFinished=";
            r5 = r5.append(r7);
            r7 = r12.f738g;
            r5 = r5.append(r7);
            r5 = r5.toString();
            r1.mo4922d(r6, r5);
            if (r2 == 0) goto L_0x031f;
        L_0x031c:
            r2.close();	 Catch:{ IOException -> 0x032a }
        L_0x031f:
            if (r3 == 0) goto L_0x0324;
        L_0x0321:
            r3.close();	 Catch:{ IOException -> 0x0343 }
        L_0x0324:
            if (r4 == 0) goto L_0x0329;
        L_0x0326:
            r4.disconnect();	 Catch:{ Exception -> 0x035c }
        L_0x0329:
            throw r0;
        L_0x032a:
            r1 = move-exception;
            r2 = com.baidu.mobads.p021j.C0338m.m569a();
            r2 = r2.mo5033f();
            r5 = new java.lang.Object[r11];
            r6 = "DownloadThread";
            r5[r9] = r6;
            r1 = r1.getMessage();
            r5[r10] = r1;
            r2.mo4939w(r5);
            goto L_0x031f;
        L_0x0343:
            r1 = move-exception;
            r2 = com.baidu.mobads.p021j.C0338m.m569a();
            r2 = r2.mo5033f();
            r3 = new java.lang.Object[r11];
            r5 = "DownloadThread";
            r3[r9] = r5;
            r1 = r1.getMessage();
            r3[r10] = r1;
            r2.mo4939w(r3);
            goto L_0x0324;
        L_0x035c:
            r1 = move-exception;
            r2 = com.baidu.mobads.p021j.C0338m.m569a();
            r2 = r2.mo5033f();
            r3 = new java.lang.Object[r11];
            r4 = "DownloadThread";
            r3[r9] = r4;
            r1 = r1.getMessage();
            r3[r10] = r1;
            r2.mo4939w(r3);
            goto L_0x0329;
        L_0x0375:
            r0 = move-exception;
            r1 = com.baidu.mobads.p021j.C0338m.m569a();
            r1 = r1.mo5033f();
            r4 = new java.lang.Object[r11];
            r5 = "DownloadThread";
            r4[r9] = r5;
            r0 = r0.getMessage();
            r4[r10] = r0;
            r1.mo4939w(r4);
            goto L_0x0168;
        L_0x038f:
            r0 = move-exception;
            r1 = com.baidu.mobads.p021j.C0338m.m569a();
            r1 = r1.mo5033f();
            r2 = new java.lang.Object[r11];
            r4 = "DownloadThread";
            r2[r9] = r4;
            r0 = r0.getMessage();
            r2[r10] = r0;
            r1.mo4939w(r2);
            goto L_0x016d;
        L_0x03a9:
            r0 = move-exception;
            r1 = com.baidu.mobads.p021j.C0338m.m569a();
            r1 = r1.mo5033f();
            r2 = new java.lang.Object[r11];
            r5 = "DownloadThread";
            r2[r9] = r5;
            r0 = r0.getMessage();
            r2[r10] = r0;
            r1.mo4939w(r2);
            goto L_0x0050;
        L_0x03c3:
            r0 = move-exception;
            r1 = com.baidu.mobads.p021j.C0338m.m569a();
            r1 = r1.mo5033f();
            r2 = new java.lang.Object[r11];
            r3 = "DownloadThread";
            r2[r9] = r3;
            r0 = r0.getMessage();
            r2[r10] = r0;
            r1.mo4939w(r2);
            goto L_0x0055;
        L_0x03dd:
            r0 = move-exception;
            r1 = com.baidu.mobads.p021j.C0338m.m569a();
            r1 = r1.mo5033f();
            r2 = new java.lang.Object[r11];
            r3 = "DownloadThread";
            r2[r9] = r3;
            r0 = r0.getMessage();
            r2[r10] = r0;
            goto L_0x0108;
        L_0x03f4:
            r3 = move-exception;
            r4 = com.baidu.mobads.p021j.C0338m.m569a();
            r4 = r4.mo5033f();
            r5 = new java.lang.Object[r11];
            r6 = "DownloadThread";
            r5[r9] = r6;
            r3 = r3.getMessage();
            r5[r10] = r3;
            r4.mo4939w(r5);
            goto L_0x00e7;
        L_0x040e:
            r1 = move-exception;
            r2 = com.baidu.mobads.p021j.C0338m.m569a();
            r2 = r2.mo5033f();
            r3 = new java.lang.Object[r11];
            r4 = "DownloadThread";
            r3[r9] = r4;
            r1 = r1.getMessage();
            r3[r10] = r1;
            r2.mo4939w(r3);
            goto L_0x00ec;
        L_0x0428:
            r3 = move-exception;
            r4 = com.baidu.mobads.p021j.C0338m.m569a();
            r4 = r4.mo5033f();
            r5 = new java.lang.Object[r11];
            r6 = "DownloadThread";
            r5[r9] = r6;
            r3 = r3.getMessage();
            r5[r10] = r3;
            r4.mo4939w(r5);
            goto L_0x01cd;
        L_0x0442:
            r1 = move-exception;
            r2 = com.baidu.mobads.p021j.C0338m.m569a();
            r2 = r2.mo5033f();
            r3 = new java.lang.Object[r11];
            r4 = "DownloadThread";
            r3[r9] = r4;
            r1 = r1.getMessage();
            r3[r10] = r1;
            r2.mo4939w(r3);
            goto L_0x01d2;
        L_0x045c:
            r3 = move-exception;
            r4 = com.baidu.mobads.p021j.C0338m.m569a();
            r4 = r4.mo5033f();
            r5 = new java.lang.Object[r11];
            r6 = "DownloadThread";
            r5[r9] = r6;
            r3 = r3.getMessage();
            r5[r10] = r3;
            r4.mo4939w(r5);
            goto L_0x023a;
        L_0x0476:
            r1 = move-exception;
            r2 = com.baidu.mobads.p021j.C0338m.m569a();
            r2 = r2.mo5033f();
            r3 = new java.lang.Object[r11];
            r4 = "DownloadThread";
            r3[r9] = r4;
            r1 = r1.getMessage();
            r3[r10] = r1;
            r2.mo4939w(r3);
            goto L_0x023f;
        L_0x0490:
            r0 = move-exception;
            r3 = r2;
            r4 = r2;
            goto L_0x02e6;
        L_0x0495:
            r1 = move-exception;
            r3 = r2;
            r4 = r0;
            r0 = r1;
            goto L_0x02e6;
        L_0x049b:
            r0 = move-exception;
            r3 = r2;
            r4 = r1;
            goto L_0x02e6;
        L_0x04a0:
            r0 = move-exception;
            r3 = r2;
            goto L_0x02e6;
        L_0x04a4:
            r0 = move-exception;
            goto L_0x02e6;
        L_0x04a7:
            r0 = move-exception;
            r4 = r3;
            r3 = r2;
            r2 = r1;
            goto L_0x02e6;
        L_0x04ad:
            r0 = move-exception;
            r1 = r2;
            r3 = r2;
            goto L_0x0115;
        L_0x04b2:
            r0 = move-exception;
            r3 = r1;
            r1 = r2;
            goto L_0x0115;
        L_0x04b7:
            r0 = move-exception;
            r1 = r2;
            r3 = r4;
            goto L_0x0115;
        L_0x04bc:
            r0 = move-exception;
            r1 = r2;
            r2 = r3;
            r3 = r4;
            goto L_0x0115;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.openad.c.a.a.run():void");
        }
    }

    public C0358a(Context context, URL url, String str, String str2, int i, String str3, String str4) {
        this.f744a = context;
        this.f745b = url;
        this.f747d = str;
        this.f748e = i;
        if (str2 == null || str2.trim().length() <= 0) {
            String file = url.getFile();
            this.f750g = file.substring(file.lastIndexOf(47) + 1);
        } else {
            this.f750g = str2;
        }
        this.f751h = -1;
        this.f752i = DownloadStatus.NONE;
        this.f753j = 0;
        this.f754k = 0;
        this.f757n = str3;
        this.f758o = str4;
        this.f755l = new ArrayList();
    }

    /* renamed from: a */
    protected void mo5076a() {
        setChanged();
        notifyObservers();
    }

    /* renamed from: a */
    protected synchronized void mo5077a(int i) {
        this.f753j += i;
        int progress = (int) getProgress();
        if (this.f754k < progress) {
            this.f754k = progress;
            mo5076a();
        }
    }

    /* renamed from: a */
    protected void mo5078a(DownloadStatus downloadStatus) {
        this.f752i = downloadStatus;
        mo5076a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x024c A:{SYNTHETIC, EDGE_INSN: B:136:0x024c->B:73:0x024c ?: BREAK  , EDGE_INSN: B:136:0x024c->B:73:0x024c ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0273 A:{SYNTHETIC, EDGE_INSN: B:139:0x0273->B:80:0x0273 ?: BREAK  , EDGE_INSN: B:139:0x0273->B:80:0x0273 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0345  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:145:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02a0  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x024c A:{SYNTHETIC, EDGE_INSN: B:136:0x024c->B:73:0x024c ?: BREAK  , EDGE_INSN: B:136:0x024c->B:73:0x024c ?: BREAK  , EDGE_INSN: B:136:0x024c->B:73:0x024c ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0273 A:{SYNTHETIC, EDGE_INSN: B:139:0x0273->B:80:0x0273 ?: BREAK  , EDGE_INSN: B:139:0x0273->B:80:0x0273 ?: BREAK  , EDGE_INSN: B:139:0x0273->B:80:0x0273 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0345  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02a0  */
    /* JADX WARNING: Removed duplicated region for block: B:145:? A:{SYNTHETIC, RETURN} */
    /* renamed from: a */
    protected void mo5079a(java.net.HttpURLConnection r16) {
        /*
        r15 = this;
        r2 = r15.f746c;
        r4 = r2.toString();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r15.f747d;
        r2 = r2.append(r3);
        r3 = r15.f750g;
        r2 = r2.append(r3);
        r2 = r2.toString();
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r2 = r3.append(r2);
        r3 = ".tmp";
        r2 = r2.append(r3);
        r5 = r2.toString();
        r2 = r15.f755l;
        r2 = r2.size();
        if (r2 != 0) goto L_0x01e4;
    L_0x0036:
        r2 = new java.io.File;
        r3 = r15.f747d;
        r2.<init>(r3);
        r3 = r2.exists();
        if (r3 != 0) goto L_0x0046;
    L_0x0043:
        r2.mkdirs();
    L_0x0046:
        r2 = 0;
        r6 = new java.io.File;
        r6.<init>(r5);
        r3 = r15.f749f;
        r3 = r3.booleanValue();
        if (r3 == 0) goto L_0x00fe;
    L_0x0054:
        r3 = r6.exists();
        if (r3 == 0) goto L_0x00fe;
    L_0x005a:
        r8 = r6.length();
        r3 = r15.f751h;
        r10 = (long) r3;
        r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r3 != 0) goto L_0x00fe;
    L_0x0065:
        r3 = new com.baidu.mobads.openad.c.g;	 Catch:{ Exception -> 0x0396 }
        r7 = r15.f744a;	 Catch:{ Exception -> 0x0396 }
        r3.<init>(r7);	 Catch:{ Exception -> 0x0396 }
        r15.f756m = r3;	 Catch:{ Exception -> 0x0396 }
        r3 = r15.f756m;	 Catch:{ Exception -> 0x0396 }
        r7 = r3.mo5098b(r4, r5);	 Catch:{ Exception -> 0x0396 }
        if (r7 == 0) goto L_0x00fe;
    L_0x0076:
        r3 = r7.size();	 Catch:{ Exception -> 0x0396 }
        if (r3 <= 0) goto L_0x00fe;
    L_0x007c:
        r3 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0396 }
        r3.<init>();	 Catch:{ Exception -> 0x0396 }
        r8 = new java.util.HashSet;	 Catch:{ Exception -> 0x00ef }
        r8.<init>();	 Catch:{ Exception -> 0x00ef }
        r7 = r7.iterator();	 Catch:{ Exception -> 0x00ef }
    L_0x008a:
        r2 = r7.hasNext();	 Catch:{ Exception -> 0x00ef }
        if (r2 == 0) goto L_0x00fd;
    L_0x0090:
        r2 = r7.next();	 Catch:{ Exception -> 0x00ef }
        r2 = (com.baidu.mobads.openad.p029c.C0364h) r2;	 Catch:{ Exception -> 0x00ef }
        r9 = r2.mo5106c();	 Catch:{ Exception -> 0x00ef }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x00ef }
        r9 = r8.contains(r9);	 Catch:{ Exception -> 0x00ef }
        if (r9 != 0) goto L_0x008a;
    L_0x00a4:
        r9 = r2.mo5106c();	 Catch:{ Exception -> 0x00ef }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x00ef }
        r8.add(r9);	 Catch:{ Exception -> 0x00ef }
        r3.add(r2);	 Catch:{ Exception -> 0x00ef }
        r9 = com.baidu.mobads.p021j.C0338m.m569a();	 Catch:{ Exception -> 0x00ef }
        r9 = r9.mo5033f();	 Catch:{ Exception -> 0x00ef }
        r10 = "Downloader";
        r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ef }
        r12 = "resume from db: start=";
        r11.<init>(r12);	 Catch:{ Exception -> 0x00ef }
        r12 = r2.mo5108d();	 Catch:{ Exception -> 0x00ef }
        r11 = r11.append(r12);	 Catch:{ Exception -> 0x00ef }
        r12 = ";end =";
        r11 = r11.append(r12);	 Catch:{ Exception -> 0x00ef }
        r12 = r2.mo5110e();	 Catch:{ Exception -> 0x00ef }
        r11 = r11.append(r12);	 Catch:{ Exception -> 0x00ef }
        r12 = ";complete=";
        r11 = r11.append(r12);	 Catch:{ Exception -> 0x00ef }
        r2 = r2.mo5100a();	 Catch:{ Exception -> 0x00ef }
        r2 = r11.append(r2);	 Catch:{ Exception -> 0x00ef }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00ef }
        r9.mo4922d(r10, r2);	 Catch:{ Exception -> 0x00ef }
        goto L_0x008a;
    L_0x00ef:
        r2 = move-exception;
    L_0x00f0:
        r7 = com.baidu.mobads.p021j.C0338m.m569a();
        r7 = r7.mo5033f();
        r8 = "Downloader";
        r7.mo4923d(r8, r2);
    L_0x00fd:
        r2 = r3;
    L_0x00fe:
        if (r2 == 0) goto L_0x0106;
    L_0x0100:
        r3 = r2.size();
        if (r3 > 0) goto L_0x0192;
    L_0x0106:
        r2 = r6.exists();
        if (r2 == 0) goto L_0x010f;
    L_0x010c:
        r6.delete();
    L_0x010f:
        r6.createNewFile();	 Catch:{ Exception -> 0x0178 }
        r2 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x0178 }
        r3 = "rwd";
        r2.<init>(r6, r3);	 Catch:{ Exception -> 0x0178 }
        r3 = r15.f751h;	 Catch:{ Exception -> 0x0178 }
        r6 = (long) r3;	 Catch:{ Exception -> 0x0178 }
        r2.setLength(r6);	 Catch:{ Exception -> 0x0178 }
        r2.close();	 Catch:{ Exception -> 0x0178 }
        r2 = com.baidu.mobads.p021j.C0338m.m569a();	 Catch:{ Exception -> 0x0178 }
        r2 = r2.mo5033f();	 Catch:{ Exception -> 0x0178 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0178 }
        r6 = "Downloader.init():  建立完random文件 ts:";
        r3.<init>(r6);	 Catch:{ Exception -> 0x0178 }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0178 }
        r3 = r3.append(r6);	 Catch:{ Exception -> 0x0178 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0178 }
        r2.mo4921d(r3);	 Catch:{ Exception -> 0x0178 }
        r9 = new java.util.ArrayList;
        r9.<init>();
        r7 = -1;
        r3 = 0;
        r2 = r15.f748e;
        r6 = 1;
        if (r2 <= r6) goto L_0x01d5;
    L_0x014c:
        r2 = r15.f751h;
        r2 = (float) r2;
        r6 = r15.f748e;
        r6 = (float) r6;
        r2 = r2 / r6;
        r6 = 1204289536; // 0x47c80000 float:102400.0 double:5.949980874E-315;
        r2 = r2 / r6;
        r2 = java.lang.Math.round(r2);
        r6 = 102400; // 0x19000 float:1.43493E-40 double:5.05923E-319;
        r10 = r2 * r6;
    L_0x015f:
        r2 = r15.f751h;
        if (r7 >= r2) goto L_0x0191;
    L_0x0163:
        r6 = r7 + 1;
        r2 = r7 + r10;
        r8 = r15.f751h;
        if (r2 >= r8) goto L_0x018e;
    L_0x016b:
        r7 = r7 + r10;
    L_0x016c:
        r3 = r3 + 1;
        r2 = new com.baidu.mobads.openad.c.h;
        r8 = 0;
        r2.<init>(r3, r4, r5, r6, r7, r8);
        r9.add(r2);
        goto L_0x015f;
    L_0x0178:
        r2 = move-exception;
        r2 = com.baidu.mobads.p021j.C0338m.m569a();
        r2 = r2.mo5033f();
        r3 = "Downloader";
        r4 = " 建立文件失败:";
        r2.mo4922d(r3, r4);
        r2 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;
        r15.mo5078a(r2);
    L_0x018d:
        return;
    L_0x018e:
        r7 = r15.f751h;
        goto L_0x016c;
    L_0x0191:
        r2 = r9;
    L_0x0192:
        r3 = r2.iterator();
    L_0x0196:
        r2 = r3.hasNext();
        if (r2 == 0) goto L_0x01e4;
    L_0x019c:
        r2 = r3.next();
        r2 = (com.baidu.mobads.openad.p029c.C0364h) r2;
        r6 = new com.baidu.mobads.openad.c.a$a;
        r8 = r2.mo5106c();
        r9 = r15.f746c;
        r10 = r2.mo5111f();
        r11 = r2.mo5108d();
        r12 = r2.mo5110e();
        r13 = r2.mo5100a();
        r7 = r15;
        r6.<init>(r8, r9, r10, r11, r12, r13);
        r7 = r2.mo5108d();
        if (r7 != 0) goto L_0x01cf;
    L_0x01c4:
        r2 = r2.mo5100a();
        if (r2 != 0) goto L_0x01cf;
    L_0x01ca:
        r0 = r16;
        r6.mo5070a(r0);
    L_0x01cf:
        r2 = r15.f755l;
        r2.add(r6);
        goto L_0x0196;
    L_0x01d5:
        r7 = r15.f751h;
        r2 = new com.baidu.mobads.openad.c.h;
        r3 = 1;
        r6 = 0;
        r8 = 0;
        r2.<init>(r3, r4, r5, r6, r7, r8);
        r9.add(r2);
        r2 = r9;
        goto L_0x0192;
    L_0x01e4:
        r3 = 0;
        r2 = r15.f749f;
        r2 = r2.booleanValue();
        if (r2 == 0) goto L_0x0207;
    L_0x01ed:
        r2 = 0;
        r6 = r3;
        r3 = r2;
    L_0x01f0:
        r2 = r15.f755l;
        r2 = r2.size();
        if (r3 >= r2) goto L_0x0208;
    L_0x01f8:
        r2 = r15.f755l;
        r2 = r2.get(r3);
        r2 = (com.baidu.mobads.openad.p029c.C0358a.C0357a) r2;
        r2 = r2.f737f;
        r6 = r6 + r2;
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x01f0;
    L_0x0207:
        r6 = r3;
    L_0x0208:
        r15.f753j = r6;
        r2 = r15.getProgress();
        r2 = (int) r2;
        r15.f754k = r2;
        r2 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.DOWNLOADING;
        r15.mo5078a(r2);
        r2 = com.baidu.mobads.p021j.C0338m.m569a();
        r2 = r2.mo5033f();
        r3 = "Downloader";
        r6 = "Downloader starts unfinished threads and waits threads end";
        r2.mo4922d(r3, r6);
        r2 = 0;
        r3 = r2;
    L_0x0227:
        r2 = r15.f755l;
        r2 = r2.size();
        if (r3 >= r2) goto L_0x024c;
    L_0x022f:
        r2 = r15.f755l;
        r2 = r2.get(r3);
        r2 = (com.baidu.mobads.openad.p029c.C0358a.C0357a) r2;
        r2 = r2.mo5071a();
        if (r2 != 0) goto L_0x0248;
    L_0x023d:
        r2 = r15.f755l;
        r2 = r2.get(r3);
        r2 = (com.baidu.mobads.openad.p029c.C0358a.C0357a) r2;
        r2.mo5072b();
    L_0x0248:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0227;
    L_0x024c:
        r2 = 0;
        r3 = r2;
    L_0x024e:
        r2 = r15.f755l;
        r2 = r2.size();
        if (r3 >= r2) goto L_0x0273;
    L_0x0256:
        r2 = r15.f755l;
        r2 = r2.get(r3);
        r2 = (com.baidu.mobads.openad.p029c.C0358a.C0357a) r2;
        r2 = r2.mo5071a();
        if (r2 != 0) goto L_0x026f;
    L_0x0264:
        r2 = r15.f755l;
        r2 = r2.get(r3);
        r2 = (com.baidu.mobads.openad.p029c.C0358a.C0357a) r2;
        r2.mo5074d();
    L_0x026f:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x024e;
    L_0x0273:
        r2 = r15.f752i;
        r3 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.DOWNLOADING;
        if (r2 != r3) goto L_0x0345;
    L_0x0279:
        r6 = 0;
        r2 = 0;
        r3 = r2;
    L_0x027c:
        r2 = r15.f755l;
        r2 = r2.size();
        if (r3 >= r2) goto L_0x039c;
    L_0x0284:
        r2 = r15.f755l;
        r2 = r2.get(r3);
        r2 = (com.baidu.mobads.openad.p029c.C0358a.C0357a) r2;
        r2 = r2.mo5071a();
        if (r2 != 0) goto L_0x0334;
    L_0x0292:
        r2 = 1;
    L_0x0293:
        if (r2 == 0) goto L_0x0339;
    L_0x0295:
        r2 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;
        r15.mo5078a(r2);
    L_0x029a:
        r2 = r15.f752i;
        r3 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.COMPLETED;
        if (r2 == r3) goto L_0x018d;
    L_0x02a0:
        r2 = com.baidu.mobads.p021j.C0338m.m569a();
        r2 = r2.mo5033f();
        r3 = "Downloader";
        r6 = "save database now";
        r2.mo4922d(r3, r6);
        r2 = r15.f749f;
        r2 = r2.booleanValue();
        if (r2 == 0) goto L_0x018d;
    L_0x02b7:
        r2 = r15.f756m;	 Catch:{ Exception -> 0x0324 }
        if (r2 != 0) goto L_0x02c4;
    L_0x02bb:
        r2 = new com.baidu.mobads.openad.c.g;	 Catch:{ Exception -> 0x0324 }
        r3 = r15.f744a;	 Catch:{ Exception -> 0x0324 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0324 }
        r15.f756m = r2;	 Catch:{ Exception -> 0x0324 }
    L_0x02c4:
        r10 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0324 }
        r10.<init>();	 Catch:{ Exception -> 0x0324 }
        r2 = r15.f755l;	 Catch:{ Exception -> 0x0324 }
        r11 = r2.iterator();	 Catch:{ Exception -> 0x0324 }
    L_0x02cf:
        r2 = r11.hasNext();	 Catch:{ Exception -> 0x0324 }
        if (r2 == 0) goto L_0x0380;
    L_0x02d5:
        r2 = r11.next();	 Catch:{ Exception -> 0x0324 }
        r0 = r2;
        r0 = (com.baidu.mobads.openad.p029c.C0358a.C0357a) r0;	 Catch:{ Exception -> 0x0324 }
        r9 = r0;
        r2 = new com.baidu.mobads.openad.c.h;	 Catch:{ Exception -> 0x0324 }
        r3 = r9.f732a;	 Catch:{ Exception -> 0x0324 }
        r6 = r9.f735d;	 Catch:{ Exception -> 0x0324 }
        r7 = r9.f736e;	 Catch:{ Exception -> 0x0324 }
        r8 = r9.f737f;	 Catch:{ Exception -> 0x0324 }
        r2.<init>(r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x0324 }
        r10.add(r2);	 Catch:{ Exception -> 0x0324 }
        r2 = com.baidu.mobads.p021j.C0338m.m569a();	 Catch:{ Exception -> 0x0324 }
        r2 = r2.mo5033f();	 Catch:{ Exception -> 0x0324 }
        r3 = "Downloader";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0324 }
        r7 = "save to db: start=";
        r6.<init>(r7);	 Catch:{ Exception -> 0x0324 }
        r7 = r9.f735d;	 Catch:{ Exception -> 0x0324 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0324 }
        r7 = ";end =";
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0324 }
        r7 = r9.f736e;	 Catch:{ Exception -> 0x0324 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0324 }
        r7 = ";complete=";
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0324 }
        r7 = r9.f737f;	 Catch:{ Exception -> 0x0324 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0324 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0324 }
        r2.mo4922d(r3, r6);	 Catch:{ Exception -> 0x0324 }
        goto L_0x02cf;
    L_0x0324:
        r2 = move-exception;
        r3 = com.baidu.mobads.p021j.C0338m.m569a();
        r3 = r3.mo5033f();
        r4 = "Downloader";
        r3.mo4923d(r4, r2);
        goto L_0x018d;
    L_0x0334:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x027c;
    L_0x0339:
        r2 = r15.f755l;
        r15.mo5080a(r2);
        r2 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.COMPLETED;
        r15.mo5078a(r2);
        goto L_0x029a;
    L_0x0345:
        r2 = r15.f752i;
        r3 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;
        if (r2 != r3) goto L_0x0352;
    L_0x034b:
        r2 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;
        r15.mo5078a(r2);
        goto L_0x029a;
    L_0x0352:
        r2 = r15.f752i;
        r3 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.CANCELLED;
        if (r2 != r3) goto L_0x0369;
    L_0x0358:
        r2 = com.baidu.mobads.p021j.C0338m.m569a();
        r2 = r2.mo5033f();
        r3 = "Downloader";
        r6 = "Downloader is cancelled";
        r2.mo4922d(r3, r6);
        goto L_0x029a;
    L_0x0369:
        r2 = r15.f752i;
        r3 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.PAUSED;
        if (r2 != r3) goto L_0x029a;
    L_0x036f:
        r2 = com.baidu.mobads.p021j.C0338m.m569a();
        r2 = r2.mo5033f();
        r3 = "Downloader";
        r6 = "Downloader is paused";
        r2.mo4922d(r3, r6);
        goto L_0x029a;
    L_0x0380:
        r2 = r15.f756m;	 Catch:{ Exception -> 0x0324 }
        r2 = r2.mo5097a(r4, r5);	 Catch:{ Exception -> 0x0324 }
        if (r2 == 0) goto L_0x038f;
    L_0x0388:
        r2 = r15.f756m;	 Catch:{ Exception -> 0x0324 }
        r2.mo5099b(r10);	 Catch:{ Exception -> 0x0324 }
        goto L_0x018d;
    L_0x038f:
        r2 = r15.f756m;	 Catch:{ Exception -> 0x0324 }
        r2.mo5096a(r10);	 Catch:{ Exception -> 0x0324 }
        goto L_0x018d;
    L_0x0396:
        r3 = move-exception;
        r14 = r3;
        r3 = r2;
        r2 = r14;
        goto L_0x00f0;
    L_0x039c:
        r2 = r6;
        goto L_0x0293;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.openad.c.a.a(java.net.HttpURLConnection):void");
    }

    /* renamed from: a */
    protected void mo5080a(ArrayList<C0357a> arrayList) {
        C0338m.m569a().mo5038k().renameFile(this.f747d + this.f750g + ".tmp", this.f747d + this.f750g);
    }

    /* renamed from: b */
    protected synchronized void mo5081b() {
        this.f752i = DownloadStatus.ERROR;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f755l.size()) {
                if (!((C0357a) this.f755l.get(i2)).mo5071a()) {
                    ((C0357a) this.f755l.get(i2)).mo5073c();
                }
                i = i2 + 1;
            }
        }
    }

    public void cancel() {
        try {
            C0338m.m569a().mo5033f().mo4922d("Downloader", "execute Cancel; state = " + this.f752i);
            if (this.f752i == DownloadStatus.PAUSED || this.f752i == DownloadStatus.DOWNLOADING) {
                if (this.f755l != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= this.f755l.size()) {
                            break;
                        }
                        if (!((C0357a) this.f755l.get(i2)).mo5071a()) {
                            ((C0357a) this.f755l.get(i2)).mo5073c();
                        }
                        i = i2 + 1;
                    }
                }
                mo5078a(DownloadStatus.CANCELLED);
            }
        } catch (Exception e) {
            C0338m.m569a().mo5033f().mo4922d("Downloader", "cancel exception");
            C0265a.m334a().mo4397a("apk download cancel failed: " + e.toString());
        }
    }

    public int getFileSize() {
        return this.f751h;
    }

    public String getOutputPath() {
        return this.f747d + this.f750g;
    }

    public String getPackageName() {
        return this.f758o;
    }

    public float getProgress() {
        return Math.abs((((float) this.f753j) / ((float) this.f751h)) * 100.0f);
    }

    public DownloadStatus getState() {
        return this.f752i;
    }

    public String getTargetURL() {
        return this.f746c == null ? null : this.f746c.toString();
    }

    public String getTitle() {
        return this.f757n;
    }

    public String getURL() {
        return this.f745b.toString();
    }

    public void pause() {
        try {
            C0338m.m569a().mo5033f().mo4922d("Downloader", "execute Pause; state = " + this.f752i);
            if (this.f752i == DownloadStatus.DOWNLOADING || this.f752i == DownloadStatus.ERROR || this.f752i == DownloadStatus.NONE) {
                if (this.f755l != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= this.f755l.size()) {
                            break;
                        }
                        if (!((C0357a) this.f755l.get(i2)).mo5071a()) {
                            ((C0357a) this.f755l.get(i2)).mo5073c();
                        }
                        i = i2 + 1;
                    }
                }
                mo5078a(DownloadStatus.PAUSED);
            }
        } catch (Exception e) {
            C0338m.m569a().mo5033f().mo4922d("Downloader", "pause exception");
            C0265a.m334a().mo4397a("apk download pause failed: " + e.toString());
        }
    }

    public void removeObservers() {
        deleteObservers();
    }

    public void resume() {
        try {
            C0338m.m569a().mo5033f().mo4922d("Downloader", "execute Resume; state = " + this.f752i);
            if (this.f752i == DownloadStatus.PAUSED || this.f752i == DownloadStatus.ERROR || this.f752i == DownloadStatus.CANCELLED) {
                mo5078a(DownloadStatus.INITING);
                new Thread(this).start();
            }
        } catch (Exception e) {
            C0338m.m569a().mo5033f().mo4922d("Downloader", "resume exception");
            C0265a.m334a().mo4397a("apk download resume failed: " + e.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b7 A:{ExcHandler: java.lang.Exception (e java.lang.Exception), Splitter: B:4:0x0009} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c7  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:42:?, code:
            mo5078a(com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR);
     */
    /* JADX WARNING: Missing block: B:43:0x00bd, code:
            if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Missing block: B:44:0x00c1, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:45:0x00c2, code:
            r4 = r1;
            r1 = r0;
            r0 = r4;
     */
    /* JADX WARNING: Missing block: B:47:0x00c7, code:
            r1.disconnect();
     */
    /* JADX WARNING: Missing block: B:62:?, code:
            return;
     */
    public void run() {
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.f746c;
        if (r1 == 0) goto L_0x0009;
    L_0x0005:
        r1 = r5.f751h;
        if (r1 > 0) goto L_0x00cb;
    L_0x0009:
        r1 = com.baidu.mobads.p021j.C0338m.m569a();	 Catch:{ Exception -> 0x00b7, all -> 0x00c1 }
        r1 = r1.mo5036i();	 Catch:{ Exception -> 0x00b7, all -> 0x00c1 }
        r2 = r5.f745b;	 Catch:{ Exception -> 0x00b7, all -> 0x00c1 }
        r0 = r1.getHttpURLConnection(r2);	 Catch:{ Exception -> 0x00b7, all -> 0x00c1 }
        r1 = "Range";
        r2 = "bytes=0-";
        r0.setRequestProperty(r1, r2);	 Catch:{ Exception -> 0x00b7 }
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0.setConnectTimeout(r1);	 Catch:{ Exception -> 0x00b7 }
        r1 = 1;
        r0.setInstanceFollowRedirects(r1);	 Catch:{ Exception -> 0x00b7 }
        r0.connect();	 Catch:{ Exception -> 0x00b7 }
        r1 = r0.getResponseCode();	 Catch:{ Exception -> 0x00b7 }
        r1 = r1 / 100;
        r2 = 2;
        if (r1 == r2) goto L_0x003e;
    L_0x0033:
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ Exception -> 0x00b7 }
        r5.mo5078a(r1);	 Catch:{ Exception -> 0x00b7 }
        if (r0 == 0) goto L_0x003d;
    L_0x003a:
        r0.disconnect();
    L_0x003d:
        return;
    L_0x003e:
        r1 = r0.getContentType();	 Catch:{ Exception -> 0x00b7 }
        r2 = "text/html";
        r1 = r1.equals(r2);	 Catch:{ Exception -> 0x00b7 }
        if (r1 == 0) goto L_0x0052;
    L_0x004a:
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ Exception -> 0x00b7 }
        r5.mo5078a(r1);	 Catch:{ Exception -> 0x00b7 }
        if (r0 == 0) goto L_0x003d;
    L_0x0051:
        goto L_0x003a;
    L_0x0052:
        r1 = r0.getContentLength();	 Catch:{ Exception -> 0x00b7 }
        if (r1 > 0) goto L_0x0060;
    L_0x0058:
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ Exception -> 0x00b7 }
        r5.mo5078a(r1);	 Catch:{ Exception -> 0x00b7 }
        if (r0 == 0) goto L_0x003d;
    L_0x005f:
        goto L_0x003a;
    L_0x0060:
        r2 = 5120000; // 0x4e2000 float:7.174648E-39 double:2.529616E-317;
        if (r1 >= r2) goto L_0x0068;
    L_0x0065:
        r2 = 1;
        r5.f748e = r2;	 Catch:{ Exception -> 0x00b7 }
    L_0x0068:
        r2 = r0.getURL();	 Catch:{ Exception -> 0x00b7 }
        r5.f746c = r2;	 Catch:{ Exception -> 0x00b7 }
        r2 = "mounted";
        r3 = android.os.Environment.getExternalStorageState();	 Catch:{ Exception -> 0x00b7 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x00b7 }
        if (r2 != 0) goto L_0x0082;
    L_0x007a:
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ Exception -> 0x00b7 }
        r5.mo5078a(r1);	 Catch:{ Exception -> 0x00b7 }
        if (r0 == 0) goto L_0x003d;
    L_0x0081:
        goto L_0x003a;
    L_0x0082:
        r2 = "Content-Range";
        r2 = r0.getHeaderField(r2);	 Catch:{ Exception -> 0x00b7 }
        if (r2 != 0) goto L_0x00aa;
    L_0x008a:
        r2 = "Accept-Ranges";
        r2 = r0.getHeaderField(r2);	 Catch:{ Exception -> 0x00b7 }
        if (r2 == 0) goto L_0x00a0;
    L_0x0092:
        r2 = "Accept-Ranges";
        r2 = r0.getHeaderField(r2);	 Catch:{ Exception -> 0x00b7 }
        r3 = "none";
        r2 = r2.equalsIgnoreCase(r3);	 Catch:{ Exception -> 0x00b7 }
        if (r2 == 0) goto L_0x00aa;
    L_0x00a0:
        r2 = 0;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x00b7 }
        r5.f749f = r2;	 Catch:{ Exception -> 0x00b7 }
        r2 = 1;
        r5.f748e = r2;	 Catch:{ Exception -> 0x00b7 }
    L_0x00aa:
        r2 = r5.f751h;	 Catch:{ Exception -> 0x00b7 }
        r3 = -1;
        if (r2 != r3) goto L_0x00b1;
    L_0x00af:
        r5.f751h = r1;	 Catch:{ Exception -> 0x00b7 }
    L_0x00b1:
        r5.mo5079a(r0);	 Catch:{ Exception -> 0x00b7 }
        if (r0 == 0) goto L_0x003d;
    L_0x00b6:
        goto L_0x003a;
    L_0x00b7:
        r1 = move-exception;
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ all -> 0x00e6 }
        r5.mo5078a(r1);	 Catch:{ all -> 0x00e6 }
        if (r0 == 0) goto L_0x003d;
    L_0x00bf:
        goto L_0x003a;
    L_0x00c1:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x00c5:
        if (r1 == 0) goto L_0x00ca;
    L_0x00c7:
        r1.disconnect();
    L_0x00ca:
        throw r0;
    L_0x00cb:
        r0 = 0;
        r5.mo5079a(r0);	 Catch:{ Exception -> 0x00d1 }
        goto L_0x003d;
    L_0x00d1:
        r0 = move-exception;
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;
        r5.mo5078a(r1);
        r1 = com.baidu.mobads.p021j.C0338m.m569a();
        r1 = r1.mo5033f();
        r2 = "Downloader";
        r1.mo4923d(r2, r0);
        goto L_0x003d;
    L_0x00e6:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x00c5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.openad.c.a.run():void");
    }

    public void start() {
        C0338m.m569a().mo5033f().mo4922d("Downloader", "execute Start; state = " + this.f752i);
        if (this.f752i == DownloadStatus.NONE) {
            mo5078a(DownloadStatus.INITING);
            new Thread(this).start();
        }
    }
}
