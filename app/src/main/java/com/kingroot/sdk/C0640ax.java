package com.kingroot.sdk;

import android.content.Context;
import com.kingroot.sdk.util.C0883c;
import com.kingroot.sdk.util.C0886f;
import java.io.File;
import java.io.IOException;

/* renamed from: com.kingroot.sdk.ax */
public class C0640ax {
    /* renamed from: cF */
    private static final short[] f1604cF = new short[]{(short) 8, (short) 64, (short) 128};
    /* renamed from: cC */
    private String f1605cC;
    /* renamed from: cD */
    private int f1606cD = 307200;
    /* renamed from: cE */
    private C0762dv f1607cE = null;
    /* renamed from: cx */
    private C0645bb f1608cx;
    private Context mContext;

    public C0640ax(C0645bb c0645bb, Context context) {
        this.f1608cx = c0645bb;
        this.mContext = context;
        this.f1605cC = c0645bb.f1625cC;
        C0633at.m1464h("DownloadKuUpdate mFilePath = " + this.f1605cC);
        File file = new File(this.f1605cC);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0293 A:{ExcHandler: all (th java.lang.Throwable), Splitter: B:1:0x003f} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x029b  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:64:0x0228, code:
            r21.f1607cE.close();
            r21.f1607cE = null;
     */
    /* JADX WARNING: Missing block: B:72:0x0251, code:
            r21.f1607cE.close();
            r21.f1607cE = null;
     */
    /* JADX WARNING: Missing block: B:80:0x027a, code:
            r21.f1607cE.close();
            r21.f1607cE = null;
     */
    /* JADX WARNING: Missing block: B:82:0x0293, code:
            r2 = th;
     */
    /* JADX WARNING: Missing block: B:83:0x0294, code:
            r8 = null;
     */
    /* JADX WARNING: Missing block: B:86:0x029b, code:
            r21.f1607cE.close();
            r21.f1607cE = null;
     */
    /* JADX WARNING: Missing block: B:92:0x02b3, code:
            r2 = e;
     */
    /* JADX WARNING: Missing block: B:93:0x02b4, code:
            r8 = null;
     */
    /* JADX WARNING: Missing block: B:96:0x02b9, code:
            r2 = e;
     */
    /* JADX WARNING: Missing block: B:97:0x02ba, code:
            r8 = null;
     */
    /* JADX WARNING: Missing block: B:100:0x02bf, code:
            r2 = e;
     */
    /* JADX WARNING: Missing block: B:101:0x02c0, code:
            r6 = null;
     */
    /* renamed from: M */
    public int mo5611M() {
        /*
        r21 = this;
        r2 = new java.lang.StringBuilder;
        r3 = "download begin mCurrentSize = ";
        r2.<init>(r3);
        r0 = r21;
        r3 = r0.f1608cx;
        r4 = r3.f1626cN;
        r2 = r2.append(r4);
        r3 = ", mSize = ";
        r2 = r2.append(r3);
        r0 = r21;
        r3 = r0.f1608cx;
        r4 = r3.f1624bs;
        r2 = r2.append(r4);
        r3 = ", url = ";
        r2 = r2.append(r3);
        r0 = r21;
        r3 = r0.f1608cx;
        r3 = r3.f1631cS;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.kingroot.sdk.C0633at.m1464h(r2);
        r7 = 0;
        r4 = "";
        r3 = 1;
        r5 = 0;
        r6 = 7038; // 0x1b7e float:9.862E-42 double:3.477E-320;
        r0 = r21;
        r2 = r0.mContext;	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r0 = r21;
        r8 = r0.f1608cx;	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r8 = r8.f1631cS;	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r2 = com.kingroot.sdk.C0762dv.m1894u(r2, r8);	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r0 = r21;
        r0.f1607cE = r2;	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r6 = 7039; // 0x1b7f float:9.864E-42 double:3.4777E-320;
        r0 = r21;
        r2 = r0.f1607cE;	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r2.mo5774bu();	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r0 = r21;
        r2 = r0.f1607cE;	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r2 = r2.getResponseCode();	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r8 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 != r8) goto L_0x0076;
    L_0x0066:
        r6 = 7040; // 0x1b80 float:9.865E-42 double:3.478E-320;
        r0 = r21;
        r2 = r0.f1608cx;	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r0 = r21;
        r8 = r0.f1607cE;	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r8 = r8.getContentLength();	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r2.f1624bs = r8;	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
    L_0x0076:
        r2 = new java.lang.StringBuilder;	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r8 = "download mKuUpdateTask.mSize = ";
        r2.<init>(r8);	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r0 = r21;
        r8 = r0.f1608cx;	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r8 = r8.f1624bs;	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r2 = r2.append(r8);	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r2 = r2.toString();	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        com.kingroot.sdk.C0633at.m1464h(r2);	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r0 = r21;
        r2 = r0.f1608cx;	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r8 = r2.f1624bs;	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r10 = 0;
        r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r2 > 0) goto L_0x00bf;
    L_0x009a:
        r4 = 7041; // 0x1b81 float:9.867E-42 double:3.4787E-320;
        r2 = 7041; // 0x1b81 float:9.867E-42 double:3.4787E-320;
        r6 = "";
        com.kingroot.sdk.util.C0886f.set(r2, r6);	 Catch:{ dw -> 0x02bf, FileNotFoundException -> 0x02b9, IOException -> 0x02b3, all -> 0x0293 }
        r0 = r21;
        r2 = r0.f1607cE;
        if (r2 == 0) goto L_0x00b5;
    L_0x00a9:
        r0 = r21;
        r2 = r0.f1607cE;
        r2.close();
        r2 = 0;
        r0 = r21;
        r0.f1607cE = r2;
    L_0x00b5:
        r2 = 0;
        com.kingroot.sdk.util.C0885e.m2419a(r2);
        r2 = 0;
        com.kingroot.sdk.util.C0885e.m2419a(r2);
        r2 = 1;
    L_0x00be:
        return r2;
    L_0x00bf:
        r6 = 7042; // 0x1b82 float:9.868E-42 double:3.479E-320;
        r8 = new java.io.FileOutputStream;	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r0 = r21;
        r2 = r0.f1605cC;	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r9 = 1;
        r8.<init>(r2, r9);	 Catch:{ dw -> 0x0218, FileNotFoundException -> 0x0241, IOException -> 0x026a, all -> 0x0293 }
        r2 = f1604cF;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r7 = 1;
        r2 = r2[r7];	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r2 = r2 << 10;
        r7 = new byte[r2];	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r6 = 7043; // 0x1b83 float:9.87E-42 double:3.4797E-320;
        r0 = r21;
        r2 = r0.f1607cE;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r5 = r2.getInputStream();	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r0 = r21;
        r2 = r0.f1608cx;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r14 = r2.f1626cN;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r2 = 0;
        r6 = 7045; // 0x1b85 float:9.872E-42 double:3.4807E-320;
        r20 = r2;
        r2 = r7;
        r7 = r20;
    L_0x00f0:
        r0 = r21;
        r9 = r0.f1608cx;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r10 = r9.f1624bs;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r16 = 0;
        r9 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1));
        if (r9 <= 0) goto L_0x0148;
    L_0x00fc:
        r0 = r21;
        r9 = r0.f1608cx;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r10 = r9.f1624bs;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r0 = r21;
        r9 = r0.f1608cx;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r0 = r9.f1626cN;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r16 = r0;
        r9 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1));
        if (r9 <= 0) goto L_0x0148;
    L_0x010e:
        r9 = r5.read(r2);	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r10 = -1;
        if (r9 == r10) goto L_0x0148;
    L_0x0115:
        r10 = 0;
        r8.write(r2, r10, r9);	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r8.flush();	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r0 = r21;
        r10 = r0.f1608cx;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r0 = r10.f1626cN;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r16 = r0;
        r0 = (long) r9;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r18 = r0;
        r16 = r16 + r18;
        r0 = r16;
        r10.f1626cN = r0;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r7 = r7 + r9;
        r0 = r21;
        r9 = r0.f1608cx;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r10 = r9.f1624bs;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r0 = r21;
        r9 = r0.f1608cx;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r0 = r9.f1626cN;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r16 = r0;
        r9 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1));
        if (r9 != 0) goto L_0x0174;
    L_0x0140:
        r0 = r21;
        r2 = r0.f1608cx;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r7 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2.f1634cV = r7;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
    L_0x0148:
        r2 = r8.getChannel();	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r7 = 1;
        r2.force(r7);	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r3 = 0;
        r2 = 0;
        r0 = r21;
        r6 = r0.f1607cE;
        if (r6 == 0) goto L_0x0164;
    L_0x0158:
        r0 = r21;
        r6 = r0.f1607cE;
        r6.close();
        r6 = 0;
        r0 = r21;
        r0.f1607cE = r6;
    L_0x0164:
        com.kingroot.sdk.util.C0885e.m2419a(r8);
        com.kingroot.sdk.util.C0885e.m2419a(r5);
        r20 = r4;
        r4 = r3;
        r3 = r20;
    L_0x016f:
        com.kingroot.sdk.util.C0886f.set(r4, r3);
        goto L_0x00be;
    L_0x0174:
        r0 = r21;
        r9 = r0.f1608cx;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r10 = r9.f1624bs;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r16 = 0;
        r9 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1));
        if (r9 <= 0) goto L_0x0199;
    L_0x0180:
        r0 = r21;
        r9 = r0.f1608cx;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r0 = r21;
        r10 = r0.f1608cx;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r10 = r10.f1626cN;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r10 = (float) r10;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r0 = r21;
        r11 = r0.f1608cx;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r0 = r11.f1624bs;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r16 = r0;
        r0 = r16;
        r11 = (float) r0;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r10 = r10 / r11;
        r9.f1634cV = r10;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
    L_0x0199:
        r9 = new java.lang.StringBuilder;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r10 = "download progress = ";
        r9.<init>(r10);	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r0 = r21;
        r10 = r0.f1608cx;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r10 = r10.f1634cV;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r9 = r9.append(r10);	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r9 = r9.toString();	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        com.kingroot.sdk.C0633at.m1464h(r9);	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r0 = r21;
        r9 = r0.f1606cD;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        if (r7 <= r9) goto L_0x00f0;
    L_0x01b7:
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r10 = r10 - r12;
        r16 = 0;
        r9 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1));
        if (r9 >= 0) goto L_0x01c4;
    L_0x01c2:
        r10 = 1;
    L_0x01c4:
        r0 = r21;
        r9 = r0.f1608cx;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r0 = r9.f1626cN;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r16 = r0;
        r16 = r16 - r14;
        r10 = r16 / r10;
        r9 = (int) r10;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r10 = 33;
        if (r9 >= r10) goto L_0x01ea;
    L_0x01d5:
        r9 = r2.length;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r10 = f1604cF;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r11 = 0;
        r10 = r10[r11];	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r10 = r10 << 10;
        if (r9 == r10) goto L_0x00f0;
    L_0x01df:
        r2 = f1604cF;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r9 = 0;
        r2 = r2[r9];	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r2 = r2 << 10;
        r2 = new byte[r2];	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        goto L_0x00f0;
    L_0x01ea:
        r10 = 65;
        if (r9 >= r10) goto L_0x0203;
    L_0x01ee:
        r9 = r2.length;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r10 = f1604cF;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r11 = 1;
        r10 = r10[r11];	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r10 = r10 << 10;
        if (r9 == r10) goto L_0x00f0;
    L_0x01f8:
        r2 = f1604cF;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r9 = 1;
        r2 = r2[r9];	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r2 = r2 << 10;
        r2 = new byte[r2];	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        goto L_0x00f0;
    L_0x0203:
        r9 = r2.length;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r10 = f1604cF;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r11 = 2;
        r10 = r10[r11];	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r10 = r10 << 10;
        if (r9 == r10) goto L_0x00f0;
    L_0x020d:
        r2 = f1604cF;	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r9 = 2;
        r2 = r2[r9];	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        r2 = r2 << 10;
        r2 = new byte[r2];	 Catch:{ dw -> 0x02c3, FileNotFoundException -> 0x02bc, IOException -> 0x02b6 }
        goto L_0x00f0;
    L_0x0218:
        r2 = move-exception;
        r4 = r6;
        r6 = r7;
    L_0x021b:
        r2.printStackTrace();	 Catch:{ all -> 0x02b0 }
        r2 = r2.mo5788bA();	 Catch:{ all -> 0x02b0 }
        r0 = r21;
        r7 = r0.f1607cE;
        if (r7 == 0) goto L_0x0234;
    L_0x0228:
        r0 = r21;
        r7 = r0.f1607cE;
        r7.close();
        r7 = 0;
        r0 = r21;
        r0.f1607cE = r7;
    L_0x0234:
        com.kingroot.sdk.util.C0885e.m2419a(r6);
        com.kingroot.sdk.util.C0885e.m2419a(r5);
        r20 = r3;
        r3 = r2;
        r2 = r20;
        goto L_0x016f;
    L_0x0241:
        r2 = move-exception;
        r4 = r6;
        r8 = r7;
    L_0x0244:
        r2.printStackTrace();	 Catch:{ all -> 0x02ae }
        r2 = r2.getMessage();	 Catch:{ all -> 0x02ae }
        r0 = r21;
        r6 = r0.f1607cE;
        if (r6 == 0) goto L_0x025d;
    L_0x0251:
        r0 = r21;
        r6 = r0.f1607cE;
        r6.close();
        r6 = 0;
        r0 = r21;
        r0.f1607cE = r6;
    L_0x025d:
        com.kingroot.sdk.util.C0885e.m2419a(r8);
        com.kingroot.sdk.util.C0885e.m2419a(r5);
        r20 = r3;
        r3 = r2;
        r2 = r20;
        goto L_0x016f;
    L_0x026a:
        r2 = move-exception;
        r4 = r6;
        r8 = r7;
    L_0x026d:
        r2.printStackTrace();	 Catch:{ all -> 0x02ae }
        r2 = r2.getMessage();	 Catch:{ all -> 0x02ae }
        r0 = r21;
        r6 = r0.f1607cE;
        if (r6 == 0) goto L_0x0286;
    L_0x027a:
        r0 = r21;
        r6 = r0.f1607cE;
        r6.close();
        r6 = 0;
        r0 = r21;
        r0.f1607cE = r6;
    L_0x0286:
        com.kingroot.sdk.util.C0885e.m2419a(r8);
        com.kingroot.sdk.util.C0885e.m2419a(r5);
        r20 = r3;
        r3 = r2;
        r2 = r20;
        goto L_0x016f;
    L_0x0293:
        r2 = move-exception;
        r8 = r7;
    L_0x0295:
        r0 = r21;
        r3 = r0.f1607cE;
        if (r3 == 0) goto L_0x02a7;
    L_0x029b:
        r0 = r21;
        r3 = r0.f1607cE;
        r3.close();
        r3 = 0;
        r0 = r21;
        r0.f1607cE = r3;
    L_0x02a7:
        com.kingroot.sdk.util.C0885e.m2419a(r8);
        com.kingroot.sdk.util.C0885e.m2419a(r5);
        throw r2;
    L_0x02ae:
        r2 = move-exception;
        goto L_0x0295;
    L_0x02b0:
        r2 = move-exception;
        r8 = r6;
        goto L_0x0295;
    L_0x02b3:
        r2 = move-exception;
        r8 = r7;
        goto L_0x026d;
    L_0x02b6:
        r2 = move-exception;
        r4 = r6;
        goto L_0x026d;
    L_0x02b9:
        r2 = move-exception;
        r8 = r7;
        goto L_0x0244;
    L_0x02bc:
        r2 = move-exception;
        r4 = r6;
        goto L_0x0244;
    L_0x02bf:
        r2 = move-exception;
        r6 = r7;
        goto L_0x021b;
    L_0x02c3:
        r2 = move-exception;
        r4 = r6;
        r6 = r8;
        goto L_0x021b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.ax.M():int");
    }

    /* renamed from: u */
    public int mo5612u(String str) {
        int i = 0;
        int i2 = 1;
        File file = new File(str);
        if (!file.exists()) {
            file.delete();
            this.f1608cx.f1633cU = 2;
            i = 7048;
        } else if (file.length() != ((long) this.f1608cx.f1632cT)) {
            file.delete();
            i = 7047;
        } else if (C0883c.m2405g(file).equals(this.f1608cx.f1623O)) {
            this.f1608cx.f1633cU = 4;
            String path = C0741dg.m1804aL().f1806em.workingDir.getPath();
            C0883c.m2403b(str, path, this.mContext);
            File file2 = new File(path + File.separatorChar + "superuser.apk");
            if (file2.exists()) {
                C0633at.m1464h(file2 + " exists!");
                file2.delete();
            }
            file.renameTo(file2);
            C0641ay.m1483b(this.f1608cx.f1627cO, this.mContext);
            i2 = 0;
        } else {
            file.delete();
            i = 7046;
        }
        C0886f.set(i, "");
        C0633at.m1464h("verifyKuFile result = " + i2);
        return i2;
    }
}
