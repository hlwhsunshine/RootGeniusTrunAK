package com.kingroot.sdk;

import android.content.Context;
import java.io.File;

/* renamed from: com.kingroot.sdk.aw */
public class C0639aw {
    /* renamed from: cA */
    public int f1599cA;
    /* renamed from: cB */
    public C0783ek f1600cB;
    /* renamed from: cx */
    private C0645bb f1601cx;
    /* renamed from: cy */
    public String f1602cy;
    /* renamed from: cz */
    public String f1603cz;
    private Context mContext;

    public C0639aw(C0645bb c0645bb, Context context) {
        this.mContext = context;
        this.f1601cx = c0645bb;
    }

    /* renamed from: L */
    public int mo5610L() {
        C0633at.m1464h("checkUpdate begin >>>>>>>>>>>>>>>>>>");
        this.f1602cy = C0641ay.m1484p(this.mContext);
        this.f1603cz = this.mContext.getDir("krsdk", 0).getPath() + File.separatorChar + "ku-config";
        this.f1599cA = C0641ay.m1482b(this.f1603cz, this.mContext);
        this.f1600cB = C0641ay.m1485v(this.f1602cy);
        int a = C0769dy.m1916a(this.f1600cB, this.f1599cA, this.f1601cx, this.mContext);
        C0633at.m1464h("checkUpdate end errCode = " + a);
        return a;
    }
}
