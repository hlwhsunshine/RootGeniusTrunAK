package com.baidu.mobads.openad.p029c;

import android.content.Context;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.p021j.C0338m;
import java.net.URL;
import java.util.Observable;

/* renamed from: com.baidu.mobads.openad.c.f */
public class C0275f extends Observable implements IOAdDownloader, Runnable {
    /* renamed from: a */
    protected Context f495a;
    /* renamed from: b */
    protected URL f496b;
    /* renamed from: c */
    protected String f497c;
    /* renamed from: d */
    protected String f498d;
    /* renamed from: e */
    protected int f499e;
    /* renamed from: f */
    protected DownloadStatus f500f;
    /* renamed from: g */
    protected int f501g;
    /* renamed from: h */
    protected int f502h;
    /* renamed from: i */
    private boolean f503i = false;

    protected C0275f(Context context, URL url, String str, String str2, boolean z) {
        this.f495a = context;
        this.f496b = url;
        this.f497c = str;
        this.f503i = z;
        if (str2 == null || str2.trim().length() <= 0) {
            String file = url.getFile();
            this.f498d = file.substring(file.lastIndexOf(47) + 1);
        } else {
            this.f498d = str2;
        }
        this.f499e = -1;
        this.f500f = DownloadStatus.DOWNLOADING;
        this.f501g = 0;
        this.f502h = 0;
    }

    /* renamed from: d */
    private void m381d() {
        mo4447a(DownloadStatus.ERROR);
    }

    /* renamed from: a */
    protected void mo4445a() {
        C0338m.m569a().mo5038k().renameFile(this.f497c + this.f498d + ".tmp", this.f497c + this.f498d);
    }

    /* renamed from: a */
    protected void mo4446a(int i, float f) {
        this.f501g += i;
        mo4449c();
    }

    /* renamed from: a */
    protected void mo4447a(DownloadStatus downloadStatus) {
        this.f500f = downloadStatus;
        mo4449c();
    }

    /* renamed from: b */
    protected void mo4448b() {
        new Thread(this).start();
    }

    /* renamed from: c */
    protected void mo4449c() {
        setChanged();
        notifyObservers();
    }

    @Deprecated
    public void cancel() {
    }

    public int getFileSize() {
        return this.f499e;
    }

    public String getOutputPath() {
        return this.f497c + this.f498d;
    }

    @Deprecated
    public String getPackageName() {
        return null;
    }

    public float getProgress() {
        return Math.abs((((float) this.f501g) / ((float) this.f499e)) * 100.0f);
    }

    public DownloadStatus getState() {
        return this.f500f;
    }

    @Deprecated
    public String getTargetURL() {
        return null;
    }

    @Deprecated
    public String getTitle() {
        return null;
    }

    public String getURL() {
        return this.f496b.toString();
    }

    @Deprecated
    public void pause() {
    }

    public void removeObservers() {
    }

    @Deprecated
    public void resume() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x00fc A:{SYNTHETIC, Splitter: B:68:0x00fc} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0101 A:{SYNTHETIC, Splitter: B:71:0x0101} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0106 A:{SYNTHETIC, Splitter: B:74:0x0106} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00fc A:{SYNTHETIC, Splitter: B:68:0x00fc} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0101 A:{SYNTHETIC, Splitter: B:71:0x0101} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0106 A:{SYNTHETIC, Splitter: B:74:0x0106} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bd A:{SYNTHETIC, Splitter: B:38:0x00bd} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c2 A:{SYNTHETIC, Splitter: B:41:0x00c2} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c7 A:{SYNTHETIC, Splitter: B:44:0x00c7} */
    /* JADX WARNING: Removed duplicated region for block: B:117:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00fc A:{SYNTHETIC, Splitter: B:68:0x00fc} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0101 A:{SYNTHETIC, Splitter: B:71:0x0101} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0106 A:{SYNTHETIC, Splitter: B:74:0x0106} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bd A:{SYNTHETIC, Splitter: B:38:0x00bd} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c2 A:{SYNTHETIC, Splitter: B:41:0x00c2} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c7 A:{SYNTHETIC, Splitter: B:44:0x00c7} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:117:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00fc A:{SYNTHETIC, Splitter: B:68:0x00fc} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0101 A:{SYNTHETIC, Splitter: B:71:0x0101} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0106 A:{SYNTHETIC, Splitter: B:74:0x0106} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bd A:{SYNTHETIC, Splitter: B:38:0x00bd} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c2 A:{SYNTHETIC, Splitter: B:41:0x00c2} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c7 A:{SYNTHETIC, Splitter: B:44:0x00c7} */
    /* JADX WARNING: Removed duplicated region for block: B:117:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00fc A:{SYNTHETIC, Splitter: B:68:0x00fc} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0101 A:{SYNTHETIC, Splitter: B:71:0x0101} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0106 A:{SYNTHETIC, Splitter: B:74:0x0106} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x010b  */
    public void run() {
        /*
        r13 = this;
        r2 = 0;
        r11 = 2;
        r10 = 1;
        r5 = 0;
        r0 = r13.f496b;	 Catch:{ Exception -> 0x0219, all -> 0x00f6 }
        r0 = r0.openConnection();	 Catch:{ Exception -> 0x0219, all -> 0x00f6 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0219, all -> 0x00f6 }
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0.setConnectTimeout(r1);	 Catch:{ Exception -> 0x021f, all -> 0x01f6 }
        r1 = 1;
        r0.setInstanceFollowRedirects(r1);	 Catch:{ Exception -> 0x021f, all -> 0x01f6 }
        r0.connect();	 Catch:{ Exception -> 0x021f, all -> 0x01f6 }
        r1 = r0.getResponseCode();	 Catch:{ Exception -> 0x021f, all -> 0x01f6 }
        r1 = r1 / 100;
        if (r1 == r11) goto L_0x0023;
    L_0x0020:
        r13.m381d();	 Catch:{ Exception -> 0x021f, all -> 0x01f6 }
    L_0x0023:
        r1 = r0.getContentLength();	 Catch:{ Exception -> 0x021f, all -> 0x01f6 }
        if (r1 <= 0) goto L_0x002b;
    L_0x0029:
        r13.f499e = r1;	 Catch:{ Exception -> 0x021f, all -> 0x01f6 }
    L_0x002b:
        r1 = new java.io.File;	 Catch:{ Exception -> 0x021f, all -> 0x01f6 }
        r3 = r13.f497c;	 Catch:{ Exception -> 0x021f, all -> 0x01f6 }
        r1.<init>(r3);	 Catch:{ Exception -> 0x021f, all -> 0x01f6 }
        r3 = r1.exists();	 Catch:{ Exception -> 0x021f, all -> 0x01f6 }
        if (r3 != 0) goto L_0x003b;
    L_0x0038:
        r1.mkdirs();	 Catch:{ Exception -> 0x021f, all -> 0x01f6 }
    L_0x003b:
        r4 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x021f, all -> 0x01f6 }
        r1 = r0.getInputStream();	 Catch:{ Exception -> 0x021f, all -> 0x01f6 }
        r4.<init>(r1);	 Catch:{ Exception -> 0x021f, all -> 0x01f6 }
        r3 = new java.io.BufferedOutputStream;	 Catch:{ Exception -> 0x0226, all -> 0x01fe }
        r1 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0226, all -> 0x01fe }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0226, all -> 0x01fe }
        r6.<init>();	 Catch:{ Exception -> 0x0226, all -> 0x01fe }
        r7 = r13.getOutputPath();	 Catch:{ Exception -> 0x0226, all -> 0x01fe }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0226, all -> 0x01fe }
        r7 = ".tmp";
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0226, all -> 0x01fe }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0226, all -> 0x01fe }
        r1.<init>(r6);	 Catch:{ Exception -> 0x0226, all -> 0x01fe }
        r3.<init>(r1);	 Catch:{ Exception -> 0x0226, all -> 0x01fe }
        r1 = 10240; // 0x2800 float:1.4349E-41 double:5.059E-320;
        r6 = new byte[r1];	 Catch:{ Exception -> 0x022d, all -> 0x0205 }
        r1 = r13.f503i;	 Catch:{ Exception -> 0x022d, all -> 0x0205 }
        if (r1 == 0) goto L_0x0235;
    L_0x006d:
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x022d, all -> 0x0205 }
        r1.<init>();	 Catch:{ Exception -> 0x022d, all -> 0x0205 }
    L_0x0072:
        r2 = r5;
    L_0x0073:
        r7 = r13.f500f;	 Catch:{ Exception -> 0x0097, all -> 0x020b }
        r8 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.DOWNLOADING;	 Catch:{ Exception -> 0x0097, all -> 0x020b }
        if (r7 != r8) goto L_0x00d0;
    L_0x0079:
        r7 = 0;
        r8 = 10240; // 0x2800 float:1.4349E-41 double:5.059E-320;
        r7 = r4.read(r6, r7, r8);	 Catch:{ Exception -> 0x0097, all -> 0x020b }
        r8 = -1;
        if (r7 == r8) goto L_0x00d0;
    L_0x0083:
        r8 = 0;
        r3.write(r6, r8, r7);	 Catch:{ Exception -> 0x0097, all -> 0x020b }
        if (r1 == 0) goto L_0x008d;
    L_0x0089:
        r8 = 0;
        r1.write(r6, r8, r7);	 Catch:{ Exception -> 0x0097, all -> 0x020b }
    L_0x008d:
        r2 = r2 + r7;
        r8 = (float) r2;	 Catch:{ Exception -> 0x0097, all -> 0x020b }
        r9 = r13.f499e;	 Catch:{ Exception -> 0x0097, all -> 0x020b }
        r9 = (float) r9;	 Catch:{ Exception -> 0x0097, all -> 0x020b }
        r8 = r8 / r9;
        r13.mo4446a(r7, r8);	 Catch:{ Exception -> 0x0097, all -> 0x020b }
        goto L_0x0073;
    L_0x0097:
        r2 = move-exception;
        r12 = r2;
        r2 = r1;
        r1 = r3;
        r3 = r4;
        r4 = r0;
        r0 = r12;
    L_0x009e:
        r6 = com.baidu.mobads.p021j.C0338m.m569a();	 Catch:{ all -> 0x0212 }
        r6 = r6.mo5033f();	 Catch:{ all -> 0x0212 }
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0212 }
        r8 = 0;
        r9 = "OAdSimpleFileDownloader";
        r7[r8] = r9;	 Catch:{ all -> 0x0212 }
        r8 = 1;
        r0 = r0.getMessage();	 Catch:{ all -> 0x0212 }
        r7[r8] = r0;	 Catch:{ all -> 0x0212 }
        r6.mo4929e(r7);	 Catch:{ all -> 0x0212 }
        r13.m381d();	 Catch:{ all -> 0x0212 }
        if (r1 == 0) goto L_0x00c0;
    L_0x00bd:
        r1.close();	 Catch:{ IOException -> 0x015a }
    L_0x00c0:
        if (r2 == 0) goto L_0x00c5;
    L_0x00c2:
        r2.close();	 Catch:{ IOException -> 0x0174 }
    L_0x00c5:
        if (r3 == 0) goto L_0x00ca;
    L_0x00c7:
        r3.close();	 Catch:{ IOException -> 0x018e }
    L_0x00ca:
        if (r4 == 0) goto L_0x00cf;
    L_0x00cc:
        r4.disconnect();
    L_0x00cf:
        return;
    L_0x00d0:
        r2 = r13.f500f;	 Catch:{ Exception -> 0x0097, all -> 0x020b }
        r6 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.DOWNLOADING;	 Catch:{ Exception -> 0x0097, all -> 0x020b }
        if (r2 != r6) goto L_0x00f3;
    L_0x00d6:
        r13.mo4445a();	 Catch:{ Exception -> 0x0097, all -> 0x020b }
        r2 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.COMPLETED;	 Catch:{ Exception -> 0x0097, all -> 0x020b }
        r13.mo4447a(r2);	 Catch:{ Exception -> 0x0097, all -> 0x020b }
    L_0x00de:
        if (r3 == 0) goto L_0x00e3;
    L_0x00e0:
        r3.close();	 Catch:{ IOException -> 0x01a8 }
    L_0x00e3:
        if (r1 == 0) goto L_0x00e8;
    L_0x00e5:
        r1.close();	 Catch:{ IOException -> 0x01c2 }
    L_0x00e8:
        if (r4 == 0) goto L_0x00ed;
    L_0x00ea:
        r4.close();	 Catch:{ IOException -> 0x01dc }
    L_0x00ed:
        if (r0 == 0) goto L_0x00cf;
    L_0x00ef:
        r0.disconnect();
        goto L_0x00cf;
    L_0x00f3:
        r2 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ Exception -> 0x0097, all -> 0x020b }
        goto L_0x00de;
    L_0x00f6:
        r0 = move-exception;
        r3 = r2;
        r4 = r2;
        r1 = r2;
    L_0x00fa:
        if (r3 == 0) goto L_0x00ff;
    L_0x00fc:
        r3.close();	 Catch:{ IOException -> 0x010f }
    L_0x00ff:
        if (r2 == 0) goto L_0x0104;
    L_0x0101:
        r2.close();	 Catch:{ IOException -> 0x0128 }
    L_0x0104:
        if (r4 == 0) goto L_0x0109;
    L_0x0106:
        r4.close();	 Catch:{ IOException -> 0x0141 }
    L_0x0109:
        if (r1 == 0) goto L_0x010e;
    L_0x010b:
        r1.disconnect();
    L_0x010e:
        throw r0;
    L_0x010f:
        r3 = move-exception;
        r6 = com.baidu.mobads.p021j.C0338m.m569a();
        r6 = r6.mo5033f();
        r7 = new java.lang.Object[r11];
        r8 = "OAdSimpleFileDownloader";
        r7[r5] = r8;
        r3 = r3.getMessage();
        r7[r10] = r3;
        r6.mo4929e(r7);
        goto L_0x00ff;
    L_0x0128:
        r2 = move-exception;
        r3 = com.baidu.mobads.p021j.C0338m.m569a();
        r3 = r3.mo5033f();
        r6 = new java.lang.Object[r11];
        r7 = "OAdSimpleFileDownloader";
        r6[r5] = r7;
        r2 = r2.getMessage();
        r6[r10] = r2;
        r3.mo4929e(r6);
        goto L_0x0104;
    L_0x0141:
        r2 = move-exception;
        r3 = com.baidu.mobads.p021j.C0338m.m569a();
        r3 = r3.mo5033f();
        r4 = new java.lang.Object[r11];
        r6 = "OAdSimpleFileDownloader";
        r4[r5] = r6;
        r2 = r2.getMessage();
        r4[r10] = r2;
        r3.mo4929e(r4);
        goto L_0x0109;
    L_0x015a:
        r0 = move-exception;
        r1 = com.baidu.mobads.p021j.C0338m.m569a();
        r1 = r1.mo5033f();
        r6 = new java.lang.Object[r11];
        r7 = "OAdSimpleFileDownloader";
        r6[r5] = r7;
        r0 = r0.getMessage();
        r6[r10] = r0;
        r1.mo4929e(r6);
        goto L_0x00c0;
    L_0x0174:
        r0 = move-exception;
        r1 = com.baidu.mobads.p021j.C0338m.m569a();
        r1 = r1.mo5033f();
        r2 = new java.lang.Object[r11];
        r6 = "OAdSimpleFileDownloader";
        r2[r5] = r6;
        r0 = r0.getMessage();
        r2[r10] = r0;
        r1.mo4929e(r2);
        goto L_0x00c5;
    L_0x018e:
        r0 = move-exception;
        r1 = com.baidu.mobads.p021j.C0338m.m569a();
        r1 = r1.mo5033f();
        r2 = new java.lang.Object[r11];
        r3 = "OAdSimpleFileDownloader";
        r2[r5] = r3;
        r0 = r0.getMessage();
        r2[r10] = r0;
        r1.mo4929e(r2);
        goto L_0x00ca;
    L_0x01a8:
        r2 = move-exception;
        r3 = com.baidu.mobads.p021j.C0338m.m569a();
        r3 = r3.mo5033f();
        r6 = new java.lang.Object[r11];
        r7 = "OAdSimpleFileDownloader";
        r6[r5] = r7;
        r2 = r2.getMessage();
        r6[r10] = r2;
        r3.mo4929e(r6);
        goto L_0x00e3;
    L_0x01c2:
        r1 = move-exception;
        r2 = com.baidu.mobads.p021j.C0338m.m569a();
        r2 = r2.mo5033f();
        r3 = new java.lang.Object[r11];
        r6 = "OAdSimpleFileDownloader";
        r3[r5] = r6;
        r1 = r1.getMessage();
        r3[r10] = r1;
        r2.mo4929e(r3);
        goto L_0x00e8;
    L_0x01dc:
        r1 = move-exception;
        r2 = com.baidu.mobads.p021j.C0338m.m569a();
        r2 = r2.mo5033f();
        r3 = new java.lang.Object[r11];
        r4 = "OAdSimpleFileDownloader";
        r3[r5] = r4;
        r1 = r1.getMessage();
        r3[r10] = r1;
        r2.mo4929e(r3);
        goto L_0x00ed;
    L_0x01f6:
        r1 = move-exception;
        r3 = r2;
        r4 = r2;
        r12 = r1;
        r1 = r0;
        r0 = r12;
        goto L_0x00fa;
    L_0x01fe:
        r1 = move-exception;
        r3 = r2;
        r12 = r1;
        r1 = r0;
        r0 = r12;
        goto L_0x00fa;
    L_0x0205:
        r1 = move-exception;
        r12 = r1;
        r1 = r0;
        r0 = r12;
        goto L_0x00fa;
    L_0x020b:
        r2 = move-exception;
        r12 = r2;
        r2 = r1;
        r1 = r0;
        r0 = r12;
        goto L_0x00fa;
    L_0x0212:
        r0 = move-exception;
        r12 = r1;
        r1 = r4;
        r4 = r3;
        r3 = r12;
        goto L_0x00fa;
    L_0x0219:
        r0 = move-exception;
        r1 = r2;
        r3 = r2;
        r4 = r2;
        goto L_0x009e;
    L_0x021f:
        r1 = move-exception;
        r3 = r2;
        r4 = r0;
        r0 = r1;
        r1 = r2;
        goto L_0x009e;
    L_0x0226:
        r1 = move-exception;
        r3 = r4;
        r4 = r0;
        r0 = r1;
        r1 = r2;
        goto L_0x009e;
    L_0x022d:
        r1 = move-exception;
        r12 = r1;
        r1 = r3;
        r3 = r4;
        r4 = r0;
        r0 = r12;
        goto L_0x009e;
    L_0x0235:
        r1 = r2;
        goto L_0x0072;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.openad.c.f.run():void");
    }

    public void start() {
        mo4447a(DownloadStatus.DOWNLOADING);
        mo4448b();
    }
}
