package com.kingroot.sdk;

import android.content.Context;
import com.kingroot.sdk.C0667bi.C0647a;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* renamed from: com.kingroot.sdk.ca */
public class C0697ca<T extends C0688cb> extends C0650gj {
    /* renamed from: cF */
    private static final short[] f1710cF = new short[]{(short) 8, (short) 64, (short) 128};
    /* renamed from: cC */
    private String f1711cC;
    /* renamed from: cD */
    private int f1712cD = 307200;
    /* renamed from: cE */
    private C0762dv f1713cE = null;
    /* renamed from: dF */
    private T f1714dF;
    /* renamed from: dM */
    private volatile boolean f1715dM = false;
    /* renamed from: dN */
    private final Object f1716dN = new Object();
    /* renamed from: dO */
    private C0690cc<T> f1717dO = null;
    private Context mContext;

    /* renamed from: com.kingroot.sdk.ca$1 */
    class C06961 implements C0647a<Object> {
        C06961() {
        }

        /* renamed from: a */
        public Object mo5626a(List<Object> list) {
            C0697ca.this.m1675aj();
            return null;
        }
    }

    public C0697ca(Context context, T t, String str) {
        this.mContext = context;
        this.f1714dF = t;
        this.f1711cC = str;
    }

    /* renamed from: a */
    private void m1674a(FileOutputStream fileOutputStream) {
        InputStream inputStream = null;
        try {
            byte[] bArr = new byte[(f1710cF[1] << 10)];
            synchronized (this.f1716dN) {
                if (this.f1713cE == null) {
                    this.f1713cE = C0762dv.m1894u(this.mContext, this.f1714dF.f1685cS);
                    this.f1713cE.mo5774bu();
                }
                if (this.f1713cE.getResponseCode() != 200) {
                    throw new C0763dw(this.f1713cE.getResponseCode() - 3000, "error: response code is not 200.");
                }
                inputStream = this.f1713cE.getInputStream();
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f1714dF.f1684cN;
            byte[] bArr2 = bArr;
            int i = 0;
            while (this.f1715dM && this.f1714dF.f1683bs > 0 && this.f1714dF.f1683bs > this.f1714dF.f1684cN) {
                int read = inputStream.read(bArr2);
                if (read == -1 || !this.f1715dM) {
                    break;
                }
                fileOutputStream.write(bArr2, 0, read);
                fileOutputStream.flush();
                C0688cb c0688cb = this.f1714dF;
                c0688cb.f1684cN += (long) read;
                int i2 = i + read;
                if (this.f1714dF.f1683bs == this.f1714dF.f1684cN) {
                    this.f1714dF.f1686cV = 1.0f;
                    mo5677x(1);
                    break;
                }
                if (this.f1714dF.f1683bs > 0) {
                    this.f1714dF.f1686cV = ((float) this.f1714dF.f1684cN) / ((float) this.f1714dF.f1683bs);
                    mo5677x(1);
                }
                if (i2 > this.f1712cD) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis2 <= 0) {
                        currentTimeMillis2 = 1;
                    }
                    i = (int) ((this.f1714dF.f1684cN - j) / currentTimeMillis2);
                    if (this.f1714dF.f1691dU == 0) {
                        this.f1714dF.f1691dU = i;
                    } else {
                        this.f1714dF.f1691dU = (this.f1714dF.f1691dU + this.f1714dF.f1691dU) / 2;
                    }
                    if (i < 33) {
                        if (bArr2.length != (f1710cF[0] << 10)) {
                            bArr2 = new byte[(f1710cF[0] << 10)];
                            i = i2;
                        }
                    } else if (i < 65) {
                        if (bArr2.length != (f1710cF[1] << 10)) {
                            bArr2 = new byte[(f1710cF[1] << 10)];
                            i = i2;
                        }
                    } else if (bArr2.length != (f1710cF[2] << 10)) {
                        bArr2 = new byte[(f1710cF[2] << 10)];
                    }
                    i = i2;
                } else {
                    i = i2;
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    C0633at.m1459a(e);
                }
            }
        } catch (C0763dw e2) {
            try {
                throw e2;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e3) {
                        C0633at.m1459a(e3);
                    }
                }
            }
        } catch (UnsupportedEncodingException e4) {
            throw new C0763dw(-59, "unbreakable download unsupported encoding: " + e4.getMessage());
        } catch (IOException e5) {
            throw new C0763dw(-7056, "unbreakable download IOException: " + e5.getMessage());
        } catch (Exception e6) {
            throw new C0763dw(-2, "unbreakable download IOException: " + e6.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:147:0x01bc A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0114 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0150 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0187 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01bc A:{SYNTHETIC} */
    /* renamed from: aj */
    private void m1675aj() {
        /*
        r11 = this;
        r1 = 1;
        r8 = 0;
        r7 = 3;
        r6 = 0;
        r0 = 0;
        r11.f1715dM = r1;
        r11.mo5677x(r6);
        r1 = r11.f1714dF;	 Catch:{ FileNotFoundException -> 0x01e3, IOException -> 0x00f4, dw -> 0x012b, Exception -> 0x0167, all -> 0x019e }
        r2 = r1.f1684cN;	 Catch:{ FileNotFoundException -> 0x01e3, IOException -> 0x00f4, dw -> 0x012b, Exception -> 0x0167, all -> 0x019e }
        r1 = r11.f1714dF;	 Catch:{ FileNotFoundException -> 0x01e3, IOException -> 0x00f4, dw -> 0x012b, Exception -> 0x0167, all -> 0x019e }
        r4 = r1.f1683bs;	 Catch:{ FileNotFoundException -> 0x01e3, IOException -> 0x00f4, dw -> 0x012b, Exception -> 0x0167, all -> 0x019e }
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x0059;
    L_0x0017:
        r1 = r11.f1714dF;	 Catch:{ FileNotFoundException -> 0x01e3, IOException -> 0x00f4, dw -> 0x012b, Exception -> 0x0167, all -> 0x019e }
        r2 = r1.f1684cN;	 Catch:{ FileNotFoundException -> 0x01e3, IOException -> 0x00f4, dw -> 0x012b, Exception -> 0x0167, all -> 0x019e }
        r1 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r1 <= 0) goto L_0x0059;
    L_0x001f:
        r1 = r11.f1714dF;	 Catch:{ FileNotFoundException -> 0x01e3, IOException -> 0x00f4, dw -> 0x012b, Exception -> 0x0167, all -> 0x019e }
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r1.f1686cV = r2;	 Catch:{ FileNotFoundException -> 0x01e3, IOException -> 0x00f4, dw -> 0x012b, Exception -> 0x0167, all -> 0x019e }
        r1 = 3;
        r11.mo5677x(r1);	 Catch:{ FileNotFoundException -> 0x01e3, IOException -> 0x00f4, dw -> 0x012b, Exception -> 0x0167, all -> 0x019e }
        r1 = r11.f1714dF;
        r2 = r1.f1684cN;
        r1 = r11.f1714dF;
        r4 = r1.f1683bs;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x0040;
    L_0x0035:
        r1 = r11.f1714dF;
        r2 = r1.f1684cN;
        r1 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r1 <= 0) goto L_0x0040;
    L_0x003d:
        r11.mo5677x(r7);
    L_0x0040:
        r1 = r11.f1716dN;
        monitor-enter(r1);
        r2 = r11.f1713cE;	 Catch:{ all -> 0x0056 }
        if (r2 == 0) goto L_0x004f;
    L_0x0047:
        r2 = r11.f1713cE;	 Catch:{ all -> 0x0056 }
        r2.close();	 Catch:{ all -> 0x0056 }
        r2 = 0;
        r11.f1713cE = r2;	 Catch:{ all -> 0x0056 }
    L_0x004f:
        monitor-exit(r1);	 Catch:{ all -> 0x0056 }
        com.kingroot.sdk.util.C0885e.m2419a(r0);
        r11.f1715dM = r6;
    L_0x0055:
        return;
    L_0x0056:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0056 }
        throw r0;
    L_0x0059:
        r1 = r11.f1714dF;	 Catch:{ FileNotFoundException -> 0x01e3, IOException -> 0x00f4, dw -> 0x012b, Exception -> 0x0167, all -> 0x019e }
        r2 = r1.f1683bs;	 Catch:{ FileNotFoundException -> 0x01e3, IOException -> 0x00f4, dw -> 0x012b, Exception -> 0x0167, all -> 0x019e }
        r4 = -1;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x0066;
    L_0x0063:
        r11.m1676ak();	 Catch:{ FileNotFoundException -> 0x01e3, IOException -> 0x00f4, dw -> 0x012b, Exception -> 0x0167, all -> 0x019e }
    L_0x0066:
        r1 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x01e3, IOException -> 0x00f4, dw -> 0x012b, Exception -> 0x0167, all -> 0x019e }
        r2 = r11.f1711cC;	 Catch:{ FileNotFoundException -> 0x01e3, IOException -> 0x00f4, dw -> 0x012b, Exception -> 0x0167, all -> 0x019e }
        r3 = 1;
        r1.<init>(r2, r3);	 Catch:{ FileNotFoundException -> 0x01e3, IOException -> 0x00f4, dw -> 0x012b, Exception -> 0x0167, all -> 0x019e }
        r0 = r1.getChannel();	 Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x01df, dw -> 0x01dc, Exception -> 0x01d9 }
        r2 = r11.f1714dF;	 Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x01df, dw -> 0x01dc, Exception -> 0x01d9 }
        r2 = r2.f1684cN;	 Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x01df, dw -> 0x01dc, Exception -> 0x01d9 }
        r0.position(r2);	 Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x01df, dw -> 0x01dc, Exception -> 0x01d9 }
        r0 = r11.f1714dF;	 Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x01df, dw -> 0x01dc, Exception -> 0x01d9 }
        r0 = r0.f1688dR;	 Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x01df, dw -> 0x01dc, Exception -> 0x01d9 }
        if (r0 == 0) goto L_0x00b5;
    L_0x007f:
        r11.m1677b(r1);	 Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x01df, dw -> 0x01dc, Exception -> 0x01d9 }
    L_0x0082:
        r1.flush();	 Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x01df, dw -> 0x01dc, Exception -> 0x01d9 }
        r1.close();	 Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x01df, dw -> 0x01dc, Exception -> 0x01d9 }
        r0 = r11.f1714dF;
        r2 = r0.f1684cN;
        r0 = r11.f1714dF;
        r4 = r0.f1683bs;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x009f;
    L_0x0094:
        r0 = r11.f1714dF;
        r2 = r0.f1684cN;
        r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x009f;
    L_0x009c:
        r11.mo5677x(r7);
    L_0x009f:
        r2 = r11.f1716dN;
        monitor-enter(r2);
        r0 = r11.f1713cE;	 Catch:{ all -> 0x00ee }
        if (r0 == 0) goto L_0x00ae;
    L_0x00a6:
        r0 = r11.f1713cE;	 Catch:{ all -> 0x00ee }
        r0.close();	 Catch:{ all -> 0x00ee }
        r0 = 0;
        r11.f1713cE = r0;	 Catch:{ all -> 0x00ee }
    L_0x00ae:
        monitor-exit(r2);	 Catch:{ all -> 0x00ee }
        com.kingroot.sdk.util.C0885e.m2419a(r1);
        r11.f1715dM = r6;
        goto L_0x0055;
    L_0x00b5:
        r11.m1674a(r1);	 Catch:{ FileNotFoundException -> 0x00b9, IOException -> 0x01df, dw -> 0x01dc, Exception -> 0x01d9 }
        goto L_0x0082;
    L_0x00b9:
        r0 = move-exception;
        r0 = r1;
    L_0x00bb:
        r1 = -7001; // 0xffffffffffffe4a7 float:NaN double:NaN;
        r11.m1678y(r1);	 Catch:{ all -> 0x01d4 }
        r1 = r11.f1714dF;
        r2 = r1.f1684cN;
        r1 = r11.f1714dF;
        r4 = r1.f1683bs;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x00d7;
    L_0x00cc:
        r1 = r11.f1714dF;
        r2 = r1.f1684cN;
        r1 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r1 <= 0) goto L_0x00d7;
    L_0x00d4:
        r11.mo5677x(r7);
    L_0x00d7:
        r1 = r11.f1716dN;
        monitor-enter(r1);
        r2 = r11.f1713cE;	 Catch:{ all -> 0x00f1 }
        if (r2 == 0) goto L_0x00e6;
    L_0x00de:
        r2 = r11.f1713cE;	 Catch:{ all -> 0x00f1 }
        r2.close();	 Catch:{ all -> 0x00f1 }
        r2 = 0;
        r11.f1713cE = r2;	 Catch:{ all -> 0x00f1 }
    L_0x00e6:
        monitor-exit(r1);	 Catch:{ all -> 0x00f1 }
        com.kingroot.sdk.util.C0885e.m2419a(r0);
        r11.f1715dM = r6;
        goto L_0x0055;
    L_0x00ee:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00ee }
        throw r0;
    L_0x00f1:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00f1 }
        throw r0;
    L_0x00f4:
        r1 = move-exception;
    L_0x00f5:
        r1 = -7056; // 0xffffffffffffe470 float:NaN double:NaN;
        r11.m1678y(r1);	 Catch:{ all -> 0x01d4 }
        r1 = r11.f1714dF;
        r2 = r1.f1684cN;
        r1 = r11.f1714dF;
        r4 = r1.f1683bs;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x0111;
    L_0x0106:
        r1 = r11.f1714dF;
        r2 = r1.f1684cN;
        r1 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r1 <= 0) goto L_0x0111;
    L_0x010e:
        r11.mo5677x(r7);
    L_0x0111:
        r1 = r11.f1716dN;
        monitor-enter(r1);
        r2 = r11.f1713cE;	 Catch:{ all -> 0x0128 }
        if (r2 == 0) goto L_0x0120;
    L_0x0118:
        r2 = r11.f1713cE;	 Catch:{ all -> 0x0128 }
        r2.close();	 Catch:{ all -> 0x0128 }
        r2 = 0;
        r11.f1713cE = r2;	 Catch:{ all -> 0x0128 }
    L_0x0120:
        monitor-exit(r1);	 Catch:{ all -> 0x0128 }
        com.kingroot.sdk.util.C0885e.m2419a(r0);
        r11.f1715dM = r6;
        goto L_0x0055;
    L_0x0128:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0128 }
        throw r0;
    L_0x012b:
        r1 = move-exception;
        r10 = r1;
        r1 = r0;
        r0 = r10;
    L_0x012f:
        r0 = r0.mo5789bz();	 Catch:{ all -> 0x01d2 }
        r11.m1678y(r0);	 Catch:{ all -> 0x01d2 }
        r0 = r11.f1714dF;
        r2 = r0.f1684cN;
        r0 = r11.f1714dF;
        r4 = r0.f1683bs;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x014d;
    L_0x0142:
        r0 = r11.f1714dF;
        r2 = r0.f1684cN;
        r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x014d;
    L_0x014a:
        r11.mo5677x(r7);
    L_0x014d:
        r2 = r11.f1716dN;
        monitor-enter(r2);
        r0 = r11.f1713cE;	 Catch:{ all -> 0x0164 }
        if (r0 == 0) goto L_0x015c;
    L_0x0154:
        r0 = r11.f1713cE;	 Catch:{ all -> 0x0164 }
        r0.close();	 Catch:{ all -> 0x0164 }
        r0 = 0;
        r11.f1713cE = r0;	 Catch:{ all -> 0x0164 }
    L_0x015c:
        monitor-exit(r2);	 Catch:{ all -> 0x0164 }
        com.kingroot.sdk.util.C0885e.m2419a(r1);
        r11.f1715dM = r6;
        goto L_0x0055;
    L_0x0164:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0164 }
        throw r0;
    L_0x0167:
        r1 = move-exception;
    L_0x0168:
        r1 = -5006; // 0xffffffffffffec72 float:NaN double:NaN;
        r11.m1678y(r1);	 Catch:{ all -> 0x01d4 }
        r1 = r11.f1714dF;
        r2 = r1.f1684cN;
        r1 = r11.f1714dF;
        r4 = r1.f1683bs;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x0184;
    L_0x0179:
        r1 = r11.f1714dF;
        r2 = r1.f1684cN;
        r1 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r1 <= 0) goto L_0x0184;
    L_0x0181:
        r11.mo5677x(r7);
    L_0x0184:
        r1 = r11.f1716dN;
        monitor-enter(r1);
        r2 = r11.f1713cE;	 Catch:{ all -> 0x019b }
        if (r2 == 0) goto L_0x0193;
    L_0x018b:
        r2 = r11.f1713cE;	 Catch:{ all -> 0x019b }
        r2.close();	 Catch:{ all -> 0x019b }
        r2 = 0;
        r11.f1713cE = r2;	 Catch:{ all -> 0x019b }
    L_0x0193:
        monitor-exit(r1);	 Catch:{ all -> 0x019b }
        com.kingroot.sdk.util.C0885e.m2419a(r0);
        r11.f1715dM = r6;
        goto L_0x0055;
    L_0x019b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x019b }
        throw r0;
    L_0x019e:
        r1 = move-exception;
        r10 = r1;
        r1 = r0;
        r0 = r10;
    L_0x01a2:
        r2 = r11.f1714dF;
        r2 = r2.f1684cN;
        r4 = r11.f1714dF;
        r4 = r4.f1683bs;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x01b9;
    L_0x01ae:
        r2 = r11.f1714dF;
        r2 = r2.f1684cN;
        r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x01b9;
    L_0x01b6:
        r11.mo5677x(r7);
    L_0x01b9:
        r2 = r11.f1716dN;
        monitor-enter(r2);
        r3 = r11.f1713cE;	 Catch:{ all -> 0x01cf }
        if (r3 == 0) goto L_0x01c8;
    L_0x01c0:
        r3 = r11.f1713cE;	 Catch:{ all -> 0x01cf }
        r3.close();	 Catch:{ all -> 0x01cf }
        r3 = 0;
        r11.f1713cE = r3;	 Catch:{ all -> 0x01cf }
    L_0x01c8:
        monitor-exit(r2);	 Catch:{ all -> 0x01cf }
        com.kingroot.sdk.util.C0885e.m2419a(r1);
        r11.f1715dM = r6;
        throw r0;
    L_0x01cf:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x01cf }
        throw r0;
    L_0x01d2:
        r0 = move-exception;
        goto L_0x01a2;
    L_0x01d4:
        r1 = move-exception;
        r10 = r1;
        r1 = r0;
        r0 = r10;
        goto L_0x01a2;
    L_0x01d9:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0168;
    L_0x01dc:
        r0 = move-exception;
        goto L_0x012f;
    L_0x01df:
        r0 = move-exception;
        r0 = r1;
        goto L_0x00f5;
    L_0x01e3:
        r1 = move-exception;
        goto L_0x00bb;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.ca.aj():void");
    }

    /* JADX WARNING: Missing block: B:26:?, code:
            return;
     */
    /* renamed from: ak */
    private void m1676ak() {
        /*
        r6 = this;
        r5 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r4 = 1;
        r1 = r6.f1716dN;
        monitor-enter(r1);
        r0 = r6.mContext;	 Catch:{ all -> 0x0093 }
        r2 = r6.f1714dF;	 Catch:{ all -> 0x0093 }
        r2 = r2.f1685cS;	 Catch:{ all -> 0x0093 }
        r0 = com.kingroot.sdk.C0762dv.m1894u(r0, r2);	 Catch:{ all -> 0x0093 }
        r6.f1713cE = r0;	 Catch:{ all -> 0x0093 }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0093 }
        r2 = "bytes=0-";
        r0.<init>(r2);	 Catch:{ all -> 0x0093 }
        r2 = r6.f1712cD;	 Catch:{ all -> 0x0093 }
        r2 = r2 + -1;
        r0 = r0.append(r2);	 Catch:{ all -> 0x0093 }
        r0 = r0.toString();	 Catch:{ all -> 0x0093 }
        r2 = r6.f1713cE;	 Catch:{ all -> 0x0093 }
        r3 = "Range";
        r2.setRequestProperty(r3, r0);	 Catch:{ all -> 0x0093 }
        r0 = r6.f1713cE;	 Catch:{ all -> 0x0093 }
        r0 = r0.mo5774bu();	 Catch:{ all -> 0x0093 }
        if (r0 == r5) goto L_0x004a;
    L_0x0034:
        r0 = r6.f1713cE;	 Catch:{ all -> 0x0093 }
        r0.close();	 Catch:{ all -> 0x0093 }
        r0 = r6.mContext;	 Catch:{ all -> 0x0093 }
        r2 = r6.f1714dF;	 Catch:{ all -> 0x0093 }
        r2 = r2.f1685cS;	 Catch:{ all -> 0x0093 }
        r0 = com.kingroot.sdk.C0762dv.m1894u(r0, r2);	 Catch:{ all -> 0x0093 }
        r6.f1713cE = r0;	 Catch:{ all -> 0x0093 }
        r0 = r6.f1713cE;	 Catch:{ all -> 0x0093 }
        r0.mo5774bu();	 Catch:{ all -> 0x0093 }
    L_0x004a:
        r0 = r6.f1713cE;	 Catch:{ all -> 0x0093 }
        r0 = r0.getResponseCode();	 Catch:{ all -> 0x0093 }
        if (r0 != r5) goto L_0x0072;
    L_0x0052:
        r0 = r6.f1714dF;	 Catch:{ all -> 0x0093 }
        r2 = 1;
        r0.f1688dR = r2;	 Catch:{ all -> 0x0093 }
        r0 = r6.f1714dF;	 Catch:{ all -> 0x0093 }
        r2 = r6.f1713cE;	 Catch:{ all -> 0x0093 }
        r2 = r2.mo5775bv();	 Catch:{ all -> 0x0093 }
        r0.f1683bs = r2;	 Catch:{ all -> 0x0093 }
    L_0x0061:
        r0 = r6.f1714dF;	 Catch:{ all -> 0x0093 }
        r2 = r0.f1683bs;	 Catch:{ all -> 0x0093 }
        r4 = 0;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 > 0) goto L_0x0070;
    L_0x006b:
        r0 = -7001; // 0xffffffffffffe4a7 float:NaN double:NaN;
        r6.m1678y(r0);	 Catch:{ all -> 0x0093 }
    L_0x0070:
        monitor-exit(r1);	 Catch:{ all -> 0x0093 }
    L_0x0071:
        return;
    L_0x0072:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r2) goto L_0x0061;
    L_0x0076:
        r0 = r6.f1713cE;	 Catch:{ all -> 0x0093 }
        r2 = "Content-Type";
        r0 = r0.getHeaderField(r2);	 Catch:{ all -> 0x0093 }
        r2 = r6.f1714dF;	 Catch:{ all -> 0x0093 }
        r2 = r2.f1687dQ;	 Catch:{ all -> 0x0093 }
        if (r2 != r4) goto L_0x0096;
    L_0x0084:
        r2 = "text/html";
        r0 = r0.contentEquals(r2);	 Catch:{ all -> 0x0093 }
        if (r0 == 0) goto L_0x0096;
    L_0x008c:
        r0 = -7007; // 0xffffffffffffe4a1 float:NaN double:NaN;
        r6.m1678y(r0);	 Catch:{ all -> 0x0093 }
        monitor-exit(r1);	 Catch:{ all -> 0x0093 }
        goto L_0x0071;
    L_0x0093:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0093 }
        throw r0;
    L_0x0096:
        r0 = r6.f1714dF;	 Catch:{ all -> 0x0093 }
        r2 = 0;
        r0.f1688dR = r2;	 Catch:{ all -> 0x0093 }
        r0 = r6.f1714dF;	 Catch:{ all -> 0x0093 }
        r2 = r6.f1713cE;	 Catch:{ all -> 0x0093 }
        r2 = r2.getContentLength();	 Catch:{ all -> 0x0093 }
        r0.f1683bs = r2;	 Catch:{ all -> 0x0093 }
        goto L_0x0061;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.ca.ak():void");
    }

    /* JADX WARNING: Missing block: B:44:?, code:
            r6 = java.lang.System.currentTimeMillis();
     */
    /* JADX WARNING: Missing block: B:46:0x0103, code:
            if (r17.f1715dM == false) goto L_0x0153;
     */
    /* JADX WARNING: Missing block: B:48:0x0113, code:
            if (r17.f1714dF.f1683bs <= r17.f1714dF.f1684cN) goto L_0x0153;
     */
    /* JADX WARNING: Missing block: B:49:0x0115, code:
            r3 = r4.read(r2);
     */
    /* JADX WARNING: Missing block: B:50:0x011a, code:
            if (r3 == -1) goto L_0x0153;
     */
    /* JADX WARNING: Missing block: B:52:0x0120, code:
            if (r17.f1715dM == false) goto L_0x0153;
     */
    /* JADX WARNING: Missing block: B:53:0x0122, code:
            r18.write(r2, 0, r3);
            r18.flush();
            r10 = r17.f1714dF;
            r10.f1684cN += (long) r3;
     */
    /* JADX WARNING: Missing block: B:54:0x0143, code:
            if (r17.f1714dF.f1683bs != r17.f1714dF.f1684cN) goto L_0x019a;
     */
    /* JADX WARNING: Missing block: B:55:0x0145, code:
            r17.f1714dF.f1686cV = 1.0f;
            mo5677x(1);
     */
    /* JADX WARNING: Missing block: B:56:0x0153, code:
            r6 = java.lang.System.currentTimeMillis() - r6;
     */
    /* JADX WARNING: Missing block: B:57:0x015d, code:
            if (r6 > 0) goto L_0x0161;
     */
    /* JADX WARNING: Missing block: B:58:0x015f, code:
            r6 = 1;
     */
    /* JADX WARNING: Missing block: B:59:0x0161, code:
            r3 = (int) ((r17.f1714dF.f1684cN - r8) / r6);
     */
    /* JADX WARNING: Missing block: B:60:0x0172, code:
            if (r17.f1714dF.f1691dU != 0) goto L_0x01c6;
     */
    /* JADX WARNING: Missing block: B:61:0x0174, code:
            r17.f1714dF.f1691dU = r3;
     */
    /* JADX WARNING: Missing block: B:63:0x017c, code:
            if (r3 >= 33) goto L_0x01f8;
     */
    /* JADX WARNING: Missing block: B:64:0x017e, code:
            r3 = 1;
     */
    /* JADX WARNING: Missing block: B:65:0x0187, code:
            if (r2.length == (f1710cF[0] << 10)) goto L_0x022c;
     */
    /* JADX WARNING: Missing block: B:66:0x0189, code:
            r2 = new byte[(f1710cF[0] << 10)];
            r6 = null;
            r3 = r4;
            r4 = 1;
     */
    /* JADX WARNING: Missing block: B:68:0x01a4, code:
            if (r17.f1714dF.f1683bs <= 0) goto L_0x00ff;
     */
    /* JADX WARNING: Missing block: B:69:0x01a6, code:
            r17.f1714dF.f1686cV = ((float) r17.f1714dF.f1684cN) / ((float) r17.f1714dF.f1683bs);
            mo5677x(1);
     */
    /* JADX WARNING: Missing block: B:71:0x01c6, code:
            r17.f1714dF.f1691dU = (r17.f1714dF.f1691dU + r17.f1714dF.f1691dU) / 2;
     */
    /* JADX WARNING: Missing block: B:77:0x01fa, code:
            if (r3 >= 65) goto L_0x0218;
     */
    /* JADX WARNING: Missing block: B:78:0x01fc, code:
            r3 = 2;
     */
    /* JADX WARNING: Missing block: B:81:0x0205, code:
            if (r2.length == (f1710cF[1] << 10)) goto L_0x022c;
     */
    /* JADX WARNING: Missing block: B:82:0x0207, code:
            r2 = new byte[(f1710cF[1] << 10)];
            r6 = null;
            r3 = r4;
            r4 = 2;
     */
    /* JADX WARNING: Missing block: B:83:0x0218, code:
            r3 = 3;
     */
    /* JADX WARNING: Missing block: B:84:0x0221, code:
            if (r2.length == (f1710cF[2] << 10)) goto L_0x022c;
     */
    /* JADX WARNING: Missing block: B:85:0x0223, code:
            r2 = new byte[(f1710cF[2] << 10)];
     */
    /* JADX WARNING: Missing block: B:86:0x022c, code:
            r6 = null;
            r16 = r3;
            r3 = r4;
            r4 = r16;
     */
    /* renamed from: b */
    private void m1677b(java.io.FileOutputStream r18) {
        /*
        r17 = this;
        r4 = 0;
        r5 = 1;
        r2 = f1710cF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r3 = 1;
        r2 = r2[r3];	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r2 = r2 << 10;
        r3 = new byte[r2];	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r2 = 1;
        r6 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r5;
    L_0x0010:
        r0 = r17;
        r5 = r0.f1715dM;	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        if (r5 == 0) goto L_0x0234;
    L_0x0016:
        r0 = r17;
        r5 = r0.f1714dF;	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r8 = r5.f1683bs;	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r10 = 0;
        r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r5 <= 0) goto L_0x0234;
    L_0x0022:
        r0 = r17;
        r5 = r0.f1714dF;	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r8 = r5.f1683bs;	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r0 = r17;
        r5 = r0.f1714dF;	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r10 = r5.f1684cN;	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r5 <= 0) goto L_0x0234;
    L_0x0032:
        r0 = r17;
        r5 = r0.f1714dF;	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r8 = r5.f1684cN;	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r10 = 1;
        r0 = r17;
        r5 = r0.f1712cD;	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r12 = (long) r5;	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r10 = r10 * r12;
        r4 = (long) r4;	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r4 = r4 * r10;
        r4 = r4 + r8;
        r10 = 1;
        r4 = r4 - r10;
        r0 = r17;
        r7 = r0.f1714dF;	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r10 = r7.f1683bs;	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r7 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r7 < 0) goto L_0x0059;
    L_0x0050:
        r0 = r17;
        r4 = r0.f1714dF;	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r4 = r4.f1683bs;	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r10 = 1;
        r4 = r4 - r10;
    L_0x0059:
        r7 = new java.lang.StringBuffer;	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r7.<init>();	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r10 = "bytes=";
        r10 = r7.append(r10);	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r10 = r10.append(r8);	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r11 = 45;
        r10 = r10.append(r11);	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r10.append(r4);	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r0 = r17;
        r10 = r0.f1716dN;	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        monitor-enter(r10);	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
        r0 = r17;
        r4 = r0.f1713cE;	 Catch:{ all -> 0x00b7 }
        if (r4 != 0) goto L_0x00c4;
    L_0x007c:
        r0 = r17;
        r4 = r0.mContext;	 Catch:{ all -> 0x00b7 }
        r0 = r17;
        r5 = r0.f1714dF;	 Catch:{ all -> 0x00b7 }
        r5 = r5.f1685cS;	 Catch:{ all -> 0x00b7 }
        r4 = com.kingroot.sdk.C0762dv.m1894u(r4, r5);	 Catch:{ all -> 0x00b7 }
        r0 = r17;
        r0.f1713cE = r4;	 Catch:{ all -> 0x00b7 }
        r0 = r17;
        r4 = r0.f1713cE;	 Catch:{ all -> 0x00b7 }
        r5 = "Range";
        r6 = r7.toString();	 Catch:{ all -> 0x00b7 }
        r4.setRequestProperty(r5, r6);	 Catch:{ all -> 0x00b7 }
        r0 = r17;
        r4 = r0.f1713cE;	 Catch:{ all -> 0x00b7 }
        r4.mo5774bu();	 Catch:{ all -> 0x00b7 }
    L_0x00a2:
        r5 = 0;
        r0 = r17;
        r4 = r0.f1713cE;	 Catch:{ all -> 0x00b7 }
        r4 = r4.getResponseCode();	 Catch:{ all -> 0x00b7 }
        r6 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r4 == r6) goto L_0x00f2;
    L_0x00af:
        r2 = new java.io.IOException;	 Catch:{ all -> 0x00b7 }
        r4 = "response code is not 206 error.";
        r2.<init>(r4);	 Catch:{ all -> 0x00b7 }
        throw r2;	 Catch:{ all -> 0x00b7 }
    L_0x00b7:
        r2 = move-exception;
    L_0x00b8:
        monitor-exit(r10);	 Catch:{ all -> 0x00b7 }
        throw r2;	 Catch:{ dw -> 0x00ba, UnsupportedEncodingException -> 0x0286, IOException -> 0x0283, Exception -> 0x0280, all -> 0x027c }
    L_0x00ba:
        r2 = move-exception;
        r4 = r3;
    L_0x00bc:
        throw r2;	 Catch:{ all -> 0x00bd }
    L_0x00bd:
        r2 = move-exception;
    L_0x00be:
        if (r4 == 0) goto L_0x00c3;
    L_0x00c0:
        r4.close();	 Catch:{ Exception -> 0x0276 }
    L_0x00c3:
        throw r2;
    L_0x00c4:
        if (r6 != 0) goto L_0x00a2;
    L_0x00c6:
        r0 = r17;
        r4 = r0.mContext;	 Catch:{ all -> 0x00b7 }
        r0 = r17;
        r5 = r0.f1713cE;	 Catch:{ all -> 0x00b7 }
        r4 = com.kingroot.sdk.C0762dv.m1890a(r4, r5);	 Catch:{ all -> 0x00b7 }
        r0 = r17;
        r5 = r0.f1713cE;	 Catch:{ all -> 0x00b7 }
        r5.close();	 Catch:{ all -> 0x00b7 }
        r0 = r17;
        r0.f1713cE = r4;	 Catch:{ all -> 0x00b7 }
        r0 = r17;
        r4 = r0.f1713cE;	 Catch:{ all -> 0x00b7 }
        r5 = "Range";
        r6 = r7.toString();	 Catch:{ all -> 0x00b7 }
        r4.setRequestProperty(r5, r6);	 Catch:{ all -> 0x00b7 }
        r0 = r17;
        r4 = r0.f1713cE;	 Catch:{ all -> 0x00b7 }
        r4.mo5774bu();	 Catch:{ all -> 0x00b7 }
        goto L_0x00a2;
    L_0x00f2:
        r0 = r17;
        r4 = r0.f1713cE;	 Catch:{ all -> 0x00b7 }
        r4 = r4.getInputStream();	 Catch:{ all -> 0x00b7 }
        monitor-exit(r10);	 Catch:{ all -> 0x028a }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
    L_0x00ff:
        r0 = r17;
        r3 = r0.f1715dM;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        if (r3 == 0) goto L_0x0153;
    L_0x0105:
        r0 = r17;
        r3 = r0.f1714dF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r10 = r3.f1683bs;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r0 = r17;
        r3 = r0.f1714dF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r12 = r3.f1684cN;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r3 <= 0) goto L_0x0153;
    L_0x0115:
        r3 = r4.read(r2);	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r10 = -1;
        if (r3 == r10) goto L_0x0153;
    L_0x011c:
        r0 = r17;
        r10 = r0.f1715dM;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        if (r10 == 0) goto L_0x0153;
    L_0x0122:
        r10 = 0;
        r0 = r18;
        r0.write(r2, r10, r3);	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r18.flush();	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r0 = r17;
        r10 = r0.f1714dF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r12 = r10.f1684cN;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r14 = (long) r3;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r12 = r12 + r14;
        r10.f1684cN = r12;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r0 = r17;
        r3 = r0.f1714dF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r10 = r3.f1683bs;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r0 = r17;
        r3 = r0.f1714dF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r12 = r3.f1684cN;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r3 != 0) goto L_0x019a;
    L_0x0145:
        r0 = r17;
        r3 = r0.f1714dF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r10 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3.f1686cV = r10;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r3 = 1;
        r0 = r17;
        r0.mo5677x(r3);	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
    L_0x0153:
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r6 = r10 - r6;
        r10 = 0;
        r3 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r3 > 0) goto L_0x0161;
    L_0x015f:
        r6 = 1;
    L_0x0161:
        r0 = r17;
        r3 = r0.f1714dF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r10 = r3.f1684cN;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r8 = r10 - r8;
        r6 = r8 / r6;
        r3 = (int) r6;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r0 = r17;
        r6 = r0.f1714dF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r6 = r6.f1691dU;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        if (r6 != 0) goto L_0x01c6;
    L_0x0174:
        r0 = r17;
        r6 = r0.f1714dF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r6.f1691dU = r3;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
    L_0x017a:
        r6 = 33;
        if (r3 >= r6) goto L_0x01f8;
    L_0x017e:
        r3 = 1;
        r6 = r2.length;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r7 = f1710cF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r8 = 0;
        r7 = r7[r8];	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r7 = r7 << 10;
        if (r6 == r7) goto L_0x022c;
    L_0x0189:
        r2 = f1710cF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r6 = 0;
        r2 = r2[r6];	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r2 = r2 << 10;
        r2 = new byte[r2];	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r6 = r5;
        r16 = r3;
        r3 = r4;
        r4 = r16;
        goto L_0x0010;
    L_0x019a:
        r0 = r17;
        r3 = r0.f1714dF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r10 = r3.f1683bs;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r12 = 0;
        r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r3 <= 0) goto L_0x00ff;
    L_0x01a6:
        r0 = r17;
        r3 = r0.f1714dF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r0 = r17;
        r10 = r0.f1714dF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r10 = r10.f1684cN;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r10 = (float) r10;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r0 = r17;
        r11 = r0.f1714dF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r12 = r11.f1683bs;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r11 = (float) r12;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r10 = r10 / r11;
        r3.f1686cV = r10;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r3 = 1;
        r0 = r17;
        r0.mo5677x(r3);	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        goto L_0x00ff;
    L_0x01c3:
        r2 = move-exception;
        goto L_0x00bc;
    L_0x01c6:
        r0 = r17;
        r6 = r0.f1714dF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r0 = r17;
        r7 = r0.f1714dF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r7 = r7.f1691dU;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r0 = r17;
        r8 = r0.f1714dF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r8 = r8.f1691dU;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r7 = r7 + r8;
        r7 = r7 / 2;
        r6.f1691dU = r7;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        goto L_0x017a;
    L_0x01dc:
        r2 = move-exception;
    L_0x01dd:
        r3 = new com.kingroot.sdk.dw;	 Catch:{ all -> 0x00bd }
        r5 = -59;
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00bd }
        r7 = "unbreakable download unsupported encoding: ";
        r6.<init>(r7);	 Catch:{ all -> 0x00bd }
        r2 = r2.getMessage();	 Catch:{ all -> 0x00bd }
        r2 = r6.append(r2);	 Catch:{ all -> 0x00bd }
        r2 = r2.toString();	 Catch:{ all -> 0x00bd }
        r3.<init>(r5, r2);	 Catch:{ all -> 0x00bd }
        throw r3;	 Catch:{ all -> 0x00bd }
    L_0x01f8:
        r6 = 65;
        if (r3 >= r6) goto L_0x0218;
    L_0x01fc:
        r3 = 2;
        r6 = r2.length;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r7 = f1710cF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r8 = 1;
        r7 = r7[r8];	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r7 = r7 << 10;
        if (r6 == r7) goto L_0x022c;
    L_0x0207:
        r2 = f1710cF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r6 = 1;
        r2 = r2[r6];	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r2 = r2 << 10;
        r2 = new byte[r2];	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r6 = r5;
        r16 = r3;
        r3 = r4;
        r4 = r16;
        goto L_0x0010;
    L_0x0218:
        r3 = 3;
        r6 = r2.length;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r7 = f1710cF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r8 = 2;
        r7 = r7[r8];	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r7 = r7 << 10;
        if (r6 == r7) goto L_0x022c;
    L_0x0223:
        r2 = f1710cF;	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r6 = 2;
        r2 = r2[r6];	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
        r2 = r2 << 10;
        r2 = new byte[r2];	 Catch:{ dw -> 0x01c3, UnsupportedEncodingException -> 0x01dc, IOException -> 0x023f, Exception -> 0x025b }
    L_0x022c:
        r6 = r5;
        r16 = r3;
        r3 = r4;
        r4 = r16;
        goto L_0x0010;
    L_0x0234:
        if (r3 == 0) goto L_0x0239;
    L_0x0236:
        r3.close();	 Catch:{ Exception -> 0x023a }
    L_0x0239:
        return;
    L_0x023a:
        r2 = move-exception;
        com.kingroot.sdk.C0633at.m1459a(r2);
        goto L_0x0239;
    L_0x023f:
        r2 = move-exception;
    L_0x0240:
        r3 = new com.kingroot.sdk.dw;	 Catch:{ all -> 0x00bd }
        r5 = -7056; // 0xffffffffffffe470 float:NaN double:NaN;
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00bd }
        r7 = "unbreakable download IOException: ";
        r6.<init>(r7);	 Catch:{ all -> 0x00bd }
        r2 = r2.getMessage();	 Catch:{ all -> 0x00bd }
        r2 = r6.append(r2);	 Catch:{ all -> 0x00bd }
        r2 = r2.toString();	 Catch:{ all -> 0x00bd }
        r3.<init>(r5, r2);	 Catch:{ all -> 0x00bd }
        throw r3;	 Catch:{ all -> 0x00bd }
    L_0x025b:
        r2 = move-exception;
    L_0x025c:
        r3 = new com.kingroot.sdk.dw;	 Catch:{ all -> 0x00bd }
        r5 = -2;
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00bd }
        r7 = "unbreakable download IOException: ";
        r6.<init>(r7);	 Catch:{ all -> 0x00bd }
        r2 = r2.getMessage();	 Catch:{ all -> 0x00bd }
        r2 = r6.append(r2);	 Catch:{ all -> 0x00bd }
        r2 = r2.toString();	 Catch:{ all -> 0x00bd }
        r3.<init>(r5, r2);	 Catch:{ all -> 0x00bd }
        throw r3;	 Catch:{ all -> 0x00bd }
    L_0x0276:
        r3 = move-exception;
        com.kingroot.sdk.C0633at.m1459a(r3);
        goto L_0x00c3;
    L_0x027c:
        r2 = move-exception;
        r4 = r3;
        goto L_0x00be;
    L_0x0280:
        r2 = move-exception;
        r4 = r3;
        goto L_0x025c;
    L_0x0283:
        r2 = move-exception;
        r4 = r3;
        goto L_0x0240;
    L_0x0286:
        r2 = move-exception;
        r4 = r3;
        goto L_0x01dd;
    L_0x028a:
        r2 = move-exception;
        r3 = r4;
        goto L_0x00b8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.ca.b(java.io.FileOutputStream):void");
    }

    /* renamed from: y */
    private void m1678y(int i) {
        if (this.f1715dM) {
            this.f1714dF.f1693dW = i;
            mo5677x(2);
        }
    }

    /* renamed from: a */
    public void mo5675a(C0690cc<T> c0690cc) {
        this.f1717dO = c0690cc;
    }

    /* renamed from: al */
    public void mo5676al() {
        this.f1715dM = false;
        mo5631ch();
        synchronized (this.f1716dN) {
            if (this.f1713cE != null) {
                try {
                    this.f1713cE.close();
                    this.f1713cE = null;
                } catch (Exception e) {
                }
            }
        }
    }

    public void run() {
        C0667bi.m1577a(new C06961(), new Object[0]);
    }

    /* renamed from: x */
    public void mo5677x(int i) {
        if (this.f1715dM) {
            switch (i) {
                case 0:
                    if (this.f1717dO != null) {
                        this.f1714dF.f1689dS = 0;
                        this.f1717dO.mo5662d(this.f1714dF);
                        return;
                    }
                    return;
                case 1:
                    if (this.f1717dO != null) {
                        this.f1714dF.f1689dS = 0;
                        this.f1717dO.mo5663e(this.f1714dF);
                        return;
                    }
                    return;
                case 2:
                    if (this.f1717dO != null) {
                        this.f1714dF.f1689dS = 2;
                        this.f1717dO.mo5659a(this.f1714dF);
                        return;
                    }
                    return;
                case 3:
                    if (this.f1717dO != null) {
                        this.f1714dF.f1689dS = 3;
                        this.f1717dO.mo5660b(this.f1714dF);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
