package com.kingroot.sdk;

import com.kingroot.sdk.C0650gj.C0651a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.kingroot.sdk.fh */
public class C0816fh {
    /* renamed from: ji */
    private C0716ga f2061ji = null;
    /* renamed from: jj */
    private C0650gj f2062jj = new C08151();

    /* renamed from: com.kingroot.sdk.fh$1 */
    class C08151 extends C0650gj {
        C08151() {
        }

        /* renamed from: a */
        public void mo5628a(C0651a c0651a) {
            Boolean valueOf = Boolean.valueOf(false);
            Boolean valueOf2 = Boolean.valueOf(false);
            if (c0651a != null) {
                List cj = c0651a.mo5635cj();
                if (cj != null && cj.size() >= 2) {
                    valueOf = (Boolean) c0651a.mo5635cj().get(0);
                    valueOf2 = (Boolean) c0651a.mo5635cj().get(1);
                }
            }
            C0816fh.this.mo5818b(valueOf.booleanValue(), valueOf2.booleanValue());
        }
    }

    public C0816fh(C0716ga c0716ga) {
        this.f2061ji = c0716ga;
    }

    /* renamed from: a */
    private void m2071a(boolean z, boolean z2, boolean z3) {
        if (this.f2061ji.mo5684f(true)) {
            int i = 4;
            if (z) {
                i = 2;
            }
            C0832fv c0832fv = new C0832fv();
            List F = c0832fv.mo5828F(i);
            List E = c0832fv.mo5827E(i);
            List H = c0832fv.mo5830H(i);
            List G = c0832fv.mo5829G(i);
            if (!z2) {
                G.add("/system/bin/su");
                G.add("/system/xbin/su");
            }
            List arrayList = new ArrayList();
            Map hashMap = new HashMap();
            new C0814fg(this.f2061ji).mo5817a(F, G, arrayList);
            C0813ff.m2054b(this.f2061ji, H, hashMap);
            if (z3) {
                C0813ff.m2052a(this.f2061ji, E, new HashMap());
                return;
            }
            return;
        }
        C0825fq.m2099g("KuSdkSilentCleaner", "不能拿到root授权,清理daemon进程失败!");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Missing block: B:7:0x0022, code:
            if (com.kingroot.sdk.C0841ge.m2183k(r2) == false) goto L_0x0040;
     */
    /* JADX WARNING: Missing block: B:11:0x002e, code:
            if (com.kingroot.sdk.C0841ge.m2183k(r3) == false) goto L_0x0040;
     */
    /* renamed from: b */
    public void mo5818b(boolean r6, boolean r7) {
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.f2061ji;
        r1 = r1.mo5684f(r0);
        if (r1 == 0) goto L_0x003b;
    L_0x0009:
        r1 = 1;
        r2 = new java.io.File;
        r3 = "/system/bin/su";
        r2.<init>(r3);
        r3 = new java.io.File;
        r4 = "/system/xbin/su";
        r3.<init>(r4);
        r4 = r2.exists();	 Catch:{ IOException -> 0x003c }
        if (r4 == 0) goto L_0x0024;
    L_0x001e:
        r2 = com.kingroot.sdk.C0841ge.m2183k(r2);	 Catch:{ IOException -> 0x003c }
        if (r2 == 0) goto L_0x0040;
    L_0x0024:
        r2 = r3.exists();	 Catch:{ IOException -> 0x003c }
        if (r2 == 0) goto L_0x0030;
    L_0x002a:
        r2 = com.kingroot.sdk.C0841ge.m2183k(r3);	 Catch:{ IOException -> 0x003c }
        if (r2 == 0) goto L_0x0040;
    L_0x0030:
        if (r0 == 0) goto L_0x003b;
    L_0x0032:
        r0 = "su";
        r0 = com.kingroot.sdk.C0827fs.m2105aj(r0);
        r5.m2071a(r6, r0, r7);
    L_0x003b:
        return;
    L_0x003c:
        r0 = move-exception;
        com.kingroot.sdk.C0825fq.m2096a(r0);
    L_0x0040:
        r0 = r1;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.fh.b(boolean, boolean):void");
    }
}
