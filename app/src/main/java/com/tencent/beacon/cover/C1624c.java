package com.tencent.beacon.cover;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.beacon.cover.c */
public final class C1624c extends BroadcastReceiver implements Runnable {
    /* renamed from: e */
    private static boolean f4600e = false;
    /* renamed from: f */
    private static int f4601f = 0;
    /* renamed from: a */
    private Context f4602a;
    /* renamed from: b */
    private List<C1622a> f4603b = null;
    /* renamed from: c */
    private String f4604c = null;
    /* renamed from: d */
    private boolean f4605d = false;

    public C1624c(Context context) {
        this.f4602a = context;
        this.f4604c = context.getFilesDir().getAbsolutePath() + File.separator + "beacon/comp";
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x0131 A:{SYNTHETIC, Splitter: B:69:0x0131} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0136 A:{Catch:{ Exception -> 0x0160 }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x013b A:{Catch:{ Exception -> 0x0160 }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0131 A:{SYNTHETIC, Splitter: B:69:0x0131} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0136 A:{Catch:{ Exception -> 0x0160 }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x013b A:{Catch:{ Exception -> 0x0160 }} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b8 A:{SYNTHETIC, Splitter: B:41:0x00b8} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bd A:{Catch:{ Exception -> 0x016b }} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c2 A:{Catch:{ Exception -> 0x016b }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0131 A:{SYNTHETIC, Splitter: B:69:0x0131} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0136 A:{Catch:{ Exception -> 0x0160 }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x013b A:{Catch:{ Exception -> 0x0160 }} */
    /* renamed from: a */
    private boolean m4405a(com.tencent.beacon.cover.C1622a r15) {
        /*
        r14 = this;
        r12 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r3 = 0;
        r1 = 0;
        r0 = r15.f4592e;
        if (r0 == 0) goto L_0x015e;
    L_0x0008:
        r0 = "";
        r2 = r15.f4592e;
        r2 = r2.trim();
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x015e;
    L_0x0016:
        r7 = new java.net.URL;	 Catch:{ Exception -> 0x00cb }
        r0 = r15.f4592e;	 Catch:{ Exception -> 0x00cb }
        r7.<init>(r0);	 Catch:{ Exception -> 0x00cb }
        r0 = r1;
    L_0x001e:
        r6 = r0 + 1;
        r2 = 3;
        if (r0 >= r2) goto L_0x015e;
    L_0x0023:
        r0 = r7.openConnection();	 Catch:{ Exception -> 0x00e6 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x00e6 }
        r2 = "Accept-Encoding";
        r4 = "identity";
        r0.setRequestProperty(r2, r4);	 Catch:{ Exception -> 0x00e6 }
        r2 = "GET";
        r0.setRequestMethod(r2);	 Catch:{ Exception -> 0x00e6 }
        r2 = 0;
        r0.setInstanceFollowRedirects(r2);	 Catch:{ Exception -> 0x00e6 }
        r2 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r0.setConnectTimeout(r2);	 Catch:{ Exception -> 0x00e6 }
        r2 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0.setReadTimeout(r2);	 Catch:{ Exception -> 0x00e6 }
        if (r0 == 0) goto L_0x00c5;
    L_0x0045:
        r2 = r0.getResponseCode();	 Catch:{ Exception -> 0x013f }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 != r4) goto L_0x0141;
    L_0x004d:
        r2 = r15.f4593f;	 Catch:{ Exception -> 0x013f }
        if (r2 <= 0) goto L_0x00c5;
    L_0x0051:
        r2 = r15.f4593f;	 Catch:{ Exception -> 0x013f }
        r4 = r0.getContentLength();	 Catch:{ Exception -> 0x013f }
        if (r2 != r4) goto L_0x00c5;
    L_0x0059:
        r4 = r0.getInputStream();	 Catch:{ Exception -> 0x016e, all -> 0x012b }
        if (r4 == 0) goto L_0x0123;
    L_0x005f:
        r0 = r0.getContentEncoding();	 Catch:{ Exception -> 0x0174, all -> 0x0162 }
        if (r0 == 0) goto L_0x00ed;
    L_0x0065:
        r2 = "gzip";
        r0 = r0.contains(r2);	 Catch:{ Exception -> 0x0174, all -> 0x0162 }
        if (r0 == 0) goto L_0x00ed;
    L_0x006d:
        r2 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x0174, all -> 0x0162 }
        r2.<init>(r4);	 Catch:{ Exception -> 0x0174, all -> 0x0162 }
    L_0x0072:
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r0 = new byte[r0];	 Catch:{ Exception -> 0x0179, all -> 0x0166 }
        r5 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0179, all -> 0x0166 }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x0179, all -> 0x0166 }
        r9 = r14.f4604c;	 Catch:{ Exception -> 0x0179, all -> 0x0166 }
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0179, all -> 0x0166 }
        r10.<init>();	 Catch:{ Exception -> 0x0179, all -> 0x0166 }
        r11 = r15.f4591d;	 Catch:{ Exception -> 0x0179, all -> 0x0166 }
        r10 = r10.append(r11);	 Catch:{ Exception -> 0x0179, all -> 0x0166 }
        r11 = ".ziptmp";
        r10 = r10.append(r11);	 Catch:{ Exception -> 0x0179, all -> 0x0166 }
        r10 = r10.toString();	 Catch:{ Exception -> 0x0179, all -> 0x0166 }
        r8.<init>(r9, r10);	 Catch:{ Exception -> 0x0179, all -> 0x0166 }
        r5.<init>(r8);	 Catch:{ Exception -> 0x0179, all -> 0x0166 }
    L_0x0097:
        r8 = 0;
        r9 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r8 = r2.read(r0, r8, r9);	 Catch:{ Exception -> 0x00a8 }
        if (r8 <= 0) goto L_0x00ef;
    L_0x00a0:
        r9 = 0;
        r5.write(r0, r9, r8);	 Catch:{ Exception -> 0x00a8 }
        r5.flush();	 Catch:{ Exception -> 0x00a8 }
        goto L_0x0097;
    L_0x00a8:
        r0 = move-exception;
    L_0x00a9:
        r0.printStackTrace();	 Catch:{ all -> 0x0169 }
        r0 = "E";
        r8 = "read InputStream error!";
        r9 = 0;
        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x0169 }
        com.tencent.beacon.cover.C1627f.m4428a(r0, r8, r9);	 Catch:{ all -> 0x0169 }
        if (r2 == 0) goto L_0x00bb;
    L_0x00b8:
        r2.close();	 Catch:{ Exception -> 0x016b }
    L_0x00bb:
        if (r4 == 0) goto L_0x00c0;
    L_0x00bd:
        r4.close();	 Catch:{ Exception -> 0x016b }
    L_0x00c0:
        if (r5 == 0) goto L_0x00c5;
    L_0x00c2:
        r5.close();	 Catch:{ Exception -> 0x016b }
    L_0x00c5:
        com.tencent.beacon.cover.C1627f.m4426a(r12);
        r0 = r6;
        goto L_0x001e;
    L_0x00cb:
        r0 = move-exception;
        r0 = "W";
        r2 = new java.lang.StringBuilder;
        r3 = "download url is error! ";
        r2.<init>(r3);
        r3 = r15.f4592e;
        r2 = r2.append(r3);
        r2 = r2.toString();
        r3 = new java.lang.Object[r1];
        com.tencent.beacon.cover.C1627f.m4428a(r0, r2, r3);
        r0 = r1;
    L_0x00e5:
        return r0;
    L_0x00e6:
        r0 = move-exception;
        com.tencent.beacon.cover.C1627f.m4426a(r12);
        r0 = r6;
        goto L_0x001e;
    L_0x00ed:
        r2 = r4;
        goto L_0x0072;
    L_0x00ef:
        r0 = "D";
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a8 }
        r9 = "down load file:";
        r8.<init>(r9);	 Catch:{ Exception -> 0x00a8 }
        r9 = r14.f4604c;	 Catch:{ Exception -> 0x00a8 }
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x00a8 }
        r9 = r15.f4591d;	 Catch:{ Exception -> 0x00a8 }
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x00a8 }
        r9 = ".ziptmp";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x00a8 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x00a8 }
        r9 = 0;
        r9 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x00a8 }
        com.tencent.beacon.cover.C1627f.m4428a(r0, r8, r9);	 Catch:{ Exception -> 0x00a8 }
        if (r2 == 0) goto L_0x0119;
    L_0x0116:
        r2.close();	 Catch:{ Exception -> 0x017d }
    L_0x0119:
        if (r4 == 0) goto L_0x011e;
    L_0x011b:
        r4.close();	 Catch:{ Exception -> 0x017d }
    L_0x011e:
        r5.close();	 Catch:{ Exception -> 0x017d }
    L_0x0121:
        r0 = 1;
        goto L_0x00e5;
    L_0x0123:
        if (r4 == 0) goto L_0x00c5;
    L_0x0125:
        r4.close();	 Catch:{ Exception -> 0x0129 }
        goto L_0x00c5;
    L_0x0129:
        r0 = move-exception;
        goto L_0x00c5;
    L_0x012b:
        r0 = move-exception;
        r2 = r3;
        r4 = r3;
        r5 = r3;
    L_0x012f:
        if (r2 == 0) goto L_0x0134;
    L_0x0131:
        r2.close();	 Catch:{ Exception -> 0x0160 }
    L_0x0134:
        if (r4 == 0) goto L_0x0139;
    L_0x0136:
        r4.close();	 Catch:{ Exception -> 0x0160 }
    L_0x0139:
        if (r5 == 0) goto L_0x013e;
    L_0x013b:
        r5.close();	 Catch:{ Exception -> 0x0160 }
    L_0x013e:
        throw r0;	 Catch:{ Exception -> 0x013f }
    L_0x013f:
        r0 = move-exception;
        goto L_0x00c5;
    L_0x0141:
        r2 = "E";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x013f }
        r5 = "http response code: ";
        r4.<init>(r5);	 Catch:{ Exception -> 0x013f }
        r0 = r0.getResponseCode();	 Catch:{ Exception -> 0x013f }
        r0 = r4.append(r0);	 Catch:{ Exception -> 0x013f }
        r0 = r0.toString();	 Catch:{ Exception -> 0x013f }
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x013f }
        com.tencent.beacon.cover.C1627f.m4428a(r2, r0, r4);	 Catch:{ Exception -> 0x013f }
        goto L_0x00c5;
    L_0x015e:
        r0 = r1;
        goto L_0x00e5;
    L_0x0160:
        r2 = move-exception;
        goto L_0x013e;
    L_0x0162:
        r0 = move-exception;
        r2 = r3;
        r5 = r3;
        goto L_0x012f;
    L_0x0166:
        r0 = move-exception;
        r5 = r3;
        goto L_0x012f;
    L_0x0169:
        r0 = move-exception;
        goto L_0x012f;
    L_0x016b:
        r0 = move-exception;
        goto L_0x00c5;
    L_0x016e:
        r0 = move-exception;
        r2 = r3;
        r4 = r3;
        r5 = r3;
        goto L_0x00a9;
    L_0x0174:
        r0 = move-exception;
        r2 = r3;
        r5 = r3;
        goto L_0x00a9;
    L_0x0179:
        r0 = move-exception;
        r5 = r3;
        goto L_0x00a9;
    L_0x017d:
        r0 = move-exception;
        goto L_0x0121;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.beacon.cover.c.a(com.tencent.beacon.cover.a):boolean");
    }

    /* renamed from: b */
    private synchronized void m4406b() {
        if (this.f4603b != null && this.f4603b.size() > 0) {
            f4601f = 1;
            if (!C1627f.m4446g(this.f4602a)) {
                C1627f.m4428a("W", "it's not on wifi stat, cancel!", new Object[0]);
                f4601f = 2;
            } else if (C1627f.m4438c() < 10485760) {
                C1627f.m4428a("W", "Not enough storage, cancel!", new Object[0]);
                C1626e.m4414a(this.f4602a).mo7604b("Not enough storage");
                C1626e.m4414a(this.f4602a).mo7603a(true);
                f4601f = 2;
            } else {
                for (C1622a c1622a : this.f4603b) {
                    if (!m4405a(c1622a)) {
                        f4601f = 2;
                        break;
                    }
                    String str = this.f4604c + "/" + c1622a.f4591d + ".ziptmp";
                    String str2 = this.f4604c + "/" + c1622a.f4591d + ".tmp";
                    boolean a = C1627f.m4431a(str, str2);
                    if (!a) {
                        C1627f.m4428a("E", "unzip file failure: " + str2, new Object[0]);
                    }
                    File file = new File(str2);
                    if (file.exists()) {
                        c1622a.f4593f = (int) file.length();
                        if (c1622a.f4594g.equals(C1627f.m4421a(file))) {
                            a = true;
                        }
                    }
                    if ("libBeacon.so".equals(c1622a.f4591d) || "5.jar".equals(c1622a.f4591d)) {
                        C1627f.m4427a(this.f4602a);
                        continue;
                    }
                    if (!a) {
                        f4601f = 2;
                        break;
                    }
                }
                f4600e = true;
                f4601f = 2;
                m4407c();
            }
        }
    }

    /* renamed from: c */
    private void m4407c() {
        List list;
        String a;
        for (C1622a c1622a : this.f4603b) {
            File file = new File(this.f4604c, c1622a.f4591d);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            new File(this.f4604c, c1622a.f4591d + ".tmp").renameTo(file);
        }
        C1628g a2 = C1628g.m4448a(this.f4602a);
        List arrayList = new ArrayList();
        if (a2 != null) {
            arrayList.addAll(a2.mo7605a());
        }
        if (arrayList.size() == 0) {
            list = this.f4603b;
            a = C1627f.m4424a(this.f4603b);
        } else {
            for (C1622a c1622a2 : this.f4603b) {
                if (c1622a2 != null) {
                    int i;
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        C1622a c1622a3 = (C1622a) arrayList.get(i2);
                        if (c1622a3 != null && c1622a3.f4588a == c1622a2.f4588a) {
                            arrayList.set(i2, c1622a2);
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                    if (i == 0) {
                        arrayList.add(c1622a2);
                    }
                }
            }
            a = C1627f.m4424a(arrayList);
            list = arrayList;
        }
        if (!"".equals(a)) {
            C1627f.m4429a(this.f4602a, "COMP_INFO", a);
            C1627f.m4428a("D", "new config:" + a, new Object[0]);
        }
        C1627f.m4428a("I", "update component success.", new Object[0]);
        C1623b.m4400a(this.f4602a, list).mo7594a();
    }

    /* renamed from: a */
    public final void mo7596a() {
        if (this.f4602a != null && !this.f4605d) {
            this.f4605d = true;
            this.f4602a.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    /* renamed from: a */
    public final void mo7597a(List<C1622a> list) {
        this.f4603b = list;
        if (f4601f != 1 && !f4600e) {
            new Thread(this).start();
        }
    }

    public final void onReceive(Context context, Intent intent) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f4602a.getSystemService("connectivity");
            if (connectivityManager == null) {
                C1627f.m4428a("W", "CompUpdate onReceive ConnectivityManager is null!", new Object[0]);
                return;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            State state = networkInfo != null ? networkInfo.getState() : null;
            if (state != null && state == State.CONNECTED && this.f4603b != null && f4601f != 1 && !f4600e) {
                new Thread(this).start();
            }
        } catch (Exception e) {
            C1627f.m4428a("E", "onReceive has a exception", new Object[0]);
        }
    }

    public final void run() {
        m4406b();
    }
}
