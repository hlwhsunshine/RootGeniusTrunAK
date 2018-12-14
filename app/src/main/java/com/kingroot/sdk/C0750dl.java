package com.kingroot.sdk;

import com.kingroot.sdk.C0638av.C0636b;
import com.kingroot.sdk.util.C0886f;
import com.kingroot.sdk.util.C0889i;
import krsdk.RootShell;

/* renamed from: com.kingroot.sdk.dl */
public class C0750dl extends C0730do implements RootShell {
    public C0750dl(C0638av c0638av, boolean z) {
        this.f1779fK = c0638av;
        this.f1730ej = z ? 4 : 3;
    }

    /* renamed from: aQ */
    public static C0750dl m1838aQ() {
        return C0750dl.m1840b(15000, 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
    /* renamed from: aR */
    private static boolean m1839aR() {
        /*
        r0 = 0;
        r2 = 0;
        r1 = new com.kingroot.sdk.av;	 Catch:{ Exception -> 0x005b, all -> 0x0063 }
        r3 = "sh";
        r1.<init>(r3);	 Catch:{ Exception -> 0x005b, all -> 0x0063 }
        r2 = "export PATH=/sbin:/vendor/bin:/system/sbin:/system/bin:/system/xbin:$PATH";
        r1.mo5609t(r2);	 Catch:{ Exception -> 0x006d, all -> 0x006b }
        r2 = "su -v";
        r4 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r2 = r1.mo5606b(r2, r4);	 Catch:{ Exception -> 0x006d, all -> 0x006b }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x006d, all -> 0x006b }
        r4 = "checkIfKuSu : ret = ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x006d, all -> 0x006b }
        r4 = r2.f1587cu;	 Catch:{ Exception -> 0x006d, all -> 0x006b }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x006d, all -> 0x006b }
        r4 = ", stdout = ";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x006d, all -> 0x006b }
        r4 = r2.f1585cs;	 Catch:{ Exception -> 0x006d, all -> 0x006b }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x006d, all -> 0x006b }
        r4 = ", stderr = ";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x006d, all -> 0x006b }
        r4 = r2.f1586ct;	 Catch:{ Exception -> 0x006d, all -> 0x006b }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x006d, all -> 0x006b }
        r3 = r3.toString();	 Catch:{ Exception -> 0x006d, all -> 0x006b }
        com.kingroot.sdk.C0633at.m1464h(r3);	 Catch:{ Exception -> 0x006d, all -> 0x006b }
        r3 = r2.success();	 Catch:{ Exception -> 0x006d, all -> 0x006b }
        if (r3 == 0) goto L_0x0057;
    L_0x0048:
        r3 = r2.f1585cs;	 Catch:{ Exception -> 0x006d, all -> 0x006b }
        if (r3 == 0) goto L_0x0057;
    L_0x004c:
        r2 = r2.f1585cs;	 Catch:{ Exception -> 0x006d, all -> 0x006b }
        r3 = "kinguser";
        r2 = r2.contains(r3);	 Catch:{ Exception -> 0x006d, all -> 0x006b }
        if (r2 == 0) goto L_0x0057;
    L_0x0056:
        r0 = 1;
    L_0x0057:
        r1.shutdown();
    L_0x005a:
        return r0;
    L_0x005b:
        r1 = move-exception;
        r1 = r2;
    L_0x005d:
        if (r1 == 0) goto L_0x005a;
    L_0x005f:
        r1.shutdown();
        goto L_0x005a;
    L_0x0063:
        r0 = move-exception;
        r1 = r2;
    L_0x0065:
        if (r1 == 0) goto L_0x006a;
    L_0x0067:
        r1.shutdown();
    L_0x006a:
        throw r0;
    L_0x006b:
        r0 = move-exception;
        goto L_0x0065;
    L_0x006d:
        r2 = move-exception;
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.dl.aR():boolean");
    }

    /* renamed from: b */
    public static C0750dl m1840b(int i, int i2) {
        C0886f.clean();
        int i3 = 0;
        while (true) {
            i3++;
            try {
                C0633at.m1465i("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                C0638av c0638av = new C0638av("su");
                C0636b b = c0638av.mo5606b("id", (long) i);
                if (b.f1587cu.intValue() == 0 && C0719cs.m1731L(b.f1585cs)) {
                    C0633at.m1465i("VirtualTerminal runCommand ret : " + b.f1587cu + ", stdout : " + b.f1585cs + ", stderr : " + b.f1586ct);
                    return new C0750dl(c0638av, C0750dl.m1839aR());
                }
                C0886f.set(7020, "ret=" + b.f1587cu + ",stdout=" + b.f1585cs + ",stderr=" + b.f1586ct);
                if (i3 >= i2) {
                    return null;
                }
                C0633at.m1464h("再次尝试连su: " + (i3 + 1));
                C0889i.m2429f(1000);
            } catch (Throwable e) {
                C0886f.set(7021, "", e);
            }
        }
    }
}
