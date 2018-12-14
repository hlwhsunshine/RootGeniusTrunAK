package com.kingroot.sdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kingroot.sdk.fv */
public class C0832fv {
    /* renamed from: jx */
    private C0868j f2079jx;
    private Context mContext = C0823fo.m2083bR();

    /* renamed from: bZ */
    private C0868j m2120bZ() {
        if (this.f2079jx == null) {
            m2121ca();
        }
        return this.f2079jx;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006a A:{SYNTHETIC, Splitter: B:24:0x006a} */
    /* renamed from: ca */
    private void m2121ca() {
        /*
        r4 = this;
        r2 = 0;
        r1 = r4.m2122cb();	 Catch:{ Exception -> 0x0056, all -> 0x0066 }
        com.kingroot.sdk.C0839gc.m2165d(r1);	 Catch:{ Exception -> 0x007a }
        r0 = r1.available();	 Catch:{ Exception -> 0x007a }
        r0 = new byte[r0];	 Catch:{ Exception -> 0x007a }
        r1.read(r0);	 Catch:{ Exception -> 0x007a }
        r3 = r0.length;	 Catch:{ Exception -> 0x007a }
        if (r3 <= 0) goto L_0x001e;
    L_0x0014:
        r2 = com.kingroot.sdk.C0823fo.m2086bU();	 Catch:{ Exception -> 0x007a }
        r3 = r4.mContext;	 Catch:{ Exception -> 0x007a }
        r2 = r2.mo5682a(r3, r0);	 Catch:{ Exception -> 0x007a }
    L_0x001e:
        if (r2 == 0) goto L_0x0050;
    L_0x0020:
        r0 = new com.kingroot.sdk.gp;	 Catch:{ Exception -> 0x007a }
        r0.<init>();	 Catch:{ Exception -> 0x007a }
        r3 = "UTF-8";
        r0.mo5858aq(r3);	 Catch:{ Exception -> 0x007a }
        r0.mo5860m(r2);	 Catch:{ Exception -> 0x007a }
        r2 = "40236";
        r3 = new com.kingroot.sdk.j;	 Catch:{ Exception -> 0x007a }
        r3.<init>();	 Catch:{ Exception -> 0x007a }
        r0 = r0.mo5862a(r2, r3);	 Catch:{ Exception -> 0x007a }
        r0 = (com.kingroot.sdk.C0868j) r0;	 Catch:{ Exception -> 0x007a }
        r4.f2079jx = r0;	 Catch:{ Exception -> 0x007a }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x007a }
        r0.<init>();	 Catch:{ Exception -> 0x007a }
        r2 = r4.f2079jx;	 Catch:{ Exception -> 0x007a }
        r3 = 0;
        r2.mo5571a(r0, r3);	 Catch:{ Exception -> 0x007a }
        r2 = "cl_clean";
        r0 = r0.toString();	 Catch:{ Exception -> 0x007a }
        com.kingroot.sdk.C0825fq.m2099g(r2, r0);	 Catch:{ Exception -> 0x007a }
    L_0x0050:
        if (r1 == 0) goto L_0x0055;
    L_0x0052:
        r1.close();	 Catch:{ IOException -> 0x0073 }
    L_0x0055:
        return;
    L_0x0056:
        r0 = move-exception;
        r1 = r2;
    L_0x0058:
        com.kingroot.sdk.C0825fq.m2096a(r0);	 Catch:{ all -> 0x0078 }
        if (r1 == 0) goto L_0x0055;
    L_0x005d:
        r1.close();	 Catch:{ IOException -> 0x0061 }
        goto L_0x0055;
    L_0x0061:
        r0 = move-exception;
        com.kingroot.sdk.C0825fq.m2096a(r0);
        goto L_0x0055;
    L_0x0066:
        r0 = move-exception;
        r1 = r2;
    L_0x0068:
        if (r1 == 0) goto L_0x006d;
    L_0x006a:
        r1.close();	 Catch:{ IOException -> 0x006e }
    L_0x006d:
        throw r0;
    L_0x006e:
        r1 = move-exception;
        com.kingroot.sdk.C0825fq.m2096a(r1);
        goto L_0x006d;
    L_0x0073:
        r0 = move-exception;
        com.kingroot.sdk.C0825fq.m2096a(r0);
        goto L_0x0055;
    L_0x0078:
        r0 = move-exception;
        goto L_0x0068;
    L_0x007a:
        r0 = move-exception;
        goto L_0x0058;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.fv.ca():void");
    }

    /* renamed from: cb */
    private InputStream m2122cb() {
        String bV = C0823fo.m2087bV();
        if (!TextUtils.isEmpty(bV)) {
            C0825fq.m2099g("cl_clean", "清理名单路径:" + bV);
            InputStream fileInputStream = new FileInputStream(bV);
            if (fileInputStream.available() > 0) {
                return fileInputStream;
            }
        }
        C0825fq.m2099g("cl_clean", "使用默认清理名单：40236.dat");
        return this.mContext.getAssets().open("40236.dat");
    }

    /* renamed from: d */
    private boolean m2123d(int i, int i2) {
        return (i & i2) > 0;
    }

    /* renamed from: e */
    private List<String> m2124e(int i, int i2) {
        C0868j bZ = m2120bZ();
        List arrayList = new ArrayList();
        if (bZ != null) {
            Iterator it = bZ.f2166J.iterator();
            while (it.hasNext()) {
                C0867i c0867i = (C0867i) it.next();
                String str = c0867i.f2157B;
                int ao = C0847gk.m2197ao(c0867i.f2158C);
                int ao2 = C0847gk.m2197ao(c0867i.f2159D);
                if (str != null && ao == i && m2123d(ao2, i2)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: E */
    public List<String> mo5827E(int i) {
        return m2124e(0, i);
    }

    /* renamed from: F */
    public List<String> mo5828F(int i) {
        return m2124e(1, i);
    }

    /* renamed from: G */
    public List<String> mo5829G(int i) {
        return m2124e(2, i);
    }

    /* renamed from: H */
    public List<String> mo5830H(int i) {
        return m2124e(3, i);
    }
}
