package com.baidu.mobads.p040vo;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.p021j.C0338m;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.vo.d */
public abstract class C0378d implements IXAdRequestInfo {
    /* renamed from: a */
    private String f837a = "android";
    /* renamed from: b */
    protected String f838b = "";
    /* renamed from: c */
    protected String f839c = "TODO";
    /* renamed from: d */
    protected Context f840d;
    /* renamed from: e */
    protected Activity f841e;
    /* renamed from: f */
    protected SlotType f842f;
    /* renamed from: g */
    protected IXAdProdInfo f843g;
    /* renamed from: h */
    protected IXAdConstants f844h = C0338m.m569a().mo5043p();
    /* renamed from: i */
    private String f845i = "";
    /* renamed from: j */
    private int f846j;
    /* renamed from: k */
    private int f847k;
    /* renamed from: l */
    private int f848l = C0338m.m569a().mo5043p().getAdCreativeTypeImage();
    /* renamed from: m */
    private String f849m = "LP,DL";
    /* renamed from: n */
    private String f850n = "";
    /* renamed from: o */
    private int f851o;
    /* renamed from: p */
    private int f852p = 0;
    /* renamed from: q */
    private int f853q;
    /* renamed from: r */
    private String f854r = "";
    /* renamed from: s */
    private String f855s = "";
    /* renamed from: t */
    private String f856t = "";
    /* renamed from: u */
    private boolean f857u = true;
    /* renamed from: v */
    private long f858v = System.currentTimeMillis();

    public C0378d(Context context, Activity activity, SlotType slotType) {
        Activity activity2 = null;
        if (context instanceof Activity) {
            activity2 = (Activity) context;
        }
        this.f841e = activity2;
        if (activity2 != null) {
            context = activity2.getApplicationContext();
        }
        this.f840d = context;
        if (this.f841e == null && activity != null) {
            this.f841e = activity;
        }
        this.f842f = slotType;
        this.f843g = new C0437b(this, this.f842f);
        mo5178c(this.f842f.getValue());
    }

    /* renamed from: a */
    protected abstract HashMap<String, String> mo5170a();

    /* renamed from: a */
    public void mo5171a(int i) {
        this.f846j = i;
    }

    /* renamed from: a */
    public void mo5172a(String str) {
        this.f837a = str;
    }

    /* renamed from: a */
    public void mo5173a(boolean z) {
        this.f857u = z;
    }

    /* renamed from: b */
    public String mo5174b() {
        HashMap e = mo5182e();
        e.putAll(mo5170a());
        return C0338m.m569a().mo5036i().getRequestAdUrl(this.f838b, e);
    }

    /* renamed from: b */
    public void mo5175b(int i) {
        this.f847k = i;
    }

    /* renamed from: b */
    public void mo5176b(String str) {
        this.f849m = str;
    }

    /* renamed from: c */
    public void mo5177c(int i) {
        this.f851o = i;
    }

    /* renamed from: c */
    public void mo5178c(String str) {
        this.f850n = str;
    }

    /* renamed from: d */
    public IXAdProdInfo mo5179d() {
        return this.f843g;
    }

    /* renamed from: d */
    public void mo5180d(int i) {
        this.f853q = i;
    }

    /* renamed from: d */
    public void mo5181d(String str) {
        this.f845i = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0413 A:{Catch:{ Exception -> 0x041d }} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x02ac A:{Catch:{ Exception -> 0x041d }} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0416 A:{Catch:{ Exception -> 0x041d }} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x02f6 A:{Catch:{ Exception -> 0x041d }} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x041a A:{Catch:{ Exception -> 0x041d }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0405 A:{Catch:{ Exception -> 0x041d }} */
    @android.annotation.TargetApi(4)
    /* renamed from: e */
    protected java.util.HashMap<java.lang.String, java.lang.String> mo5182e() {
        /*
        r14 = this;
        r2 = 1;
        r3 = 0;
        r0 = com.baidu.mobads.p021j.C0338m.m569a();
        r5 = r0.mo5041n();
        r0 = com.baidu.mobads.p021j.C0338m.m569a();
        r6 = r0.mo5040m();
        r7 = new java.util.HashMap;
        r7.<init>();
        r0 = "net";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x041d }
        r1.<init>();	 Catch:{ Exception -> 0x041d }
        r4 = r14.f840d;	 Catch:{ Exception -> 0x041d }
        r4 = r5.getNetworkCatagory(r4);	 Catch:{ Exception -> 0x041d }
        r1 = r1.append(r4);	 Catch:{ Exception -> 0x041d }
        r1 = r1.toString();	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "u";
        r1 = "default";
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "ie";
        r1 = "1";
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "n";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x041d }
        r1.<init>();	 Catch:{ Exception -> 0x041d }
        r4 = r14.getN();	 Catch:{ Exception -> 0x041d }
        r1 = r1.append(r4);	 Catch:{ Exception -> 0x041d }
        r1 = r1.toString();	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "tm";
        r1 = "512";
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "cm";
        r1 = "512";
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "md";
        r1 = "1";
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "at";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x041d }
        r1.<init>();	 Catch:{ Exception -> 0x041d }
        r4 = r14.getAt();	 Catch:{ Exception -> 0x041d }
        r1 = r1.append(r4);	 Catch:{ Exception -> 0x041d }
        r1 = r1.toString();	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "v";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x041d }
        r1.<init>();	 Catch:{ Exception -> 0x041d }
        r4 = r14.mo5184f();	 Catch:{ Exception -> 0x041d }
        r1 = r1.append(r4);	 Catch:{ Exception -> 0x041d }
        r4 = "_";
        r1 = r1.append(r4);	 Catch:{ Exception -> 0x041d }
        r4 = com.baidu.mobads.p022a.C0238a.f376c;	 Catch:{ Exception -> 0x041d }
        r1 = r1.append(r4);	 Catch:{ Exception -> 0x041d }
        r4 = "_4.1.30";
        r1 = r1.append(r4);	 Catch:{ Exception -> 0x041d }
        r1 = r1.toString();	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "cs";
        r1 = "";
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "pk";
        r1 = r14.f840d;	 Catch:{ Exception -> 0x041d }
        r1 = r6.getAppPackage(r1);	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "trftp";
        r1 = "sdk_8.25";
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = r14.f840d;	 Catch:{ Exception -> 0x041d }
        r0 = r6.getAppId(r0);	 Catch:{ Exception -> 0x041d }
        r1 = "q";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x041d }
        r4.<init>();	 Catch:{ Exception -> 0x041d }
        r4 = r4.append(r0);	 Catch:{ Exception -> 0x041d }
        r8 = "_cpr";
        r4 = r4.append(r8);	 Catch:{ Exception -> 0x041d }
        r4 = r4.toString();	 Catch:{ Exception -> 0x041d }
        r7.put(r1, r4);	 Catch:{ Exception -> 0x041d }
        r1 = "appid";
        r7.put(r1, r0);	 Catch:{ Exception -> 0x041d }
        r0 = "tp";
        r1 = android.os.Build.MODEL;	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "brd";
        r1 = r5.getPhoneOSBrand();	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = r14.f840d;	 Catch:{ Exception -> 0x041d }
        r0 = r6.getDisplayMetrics(r0);	 Catch:{ Exception -> 0x041d }
        r1 = "den";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x041d }
        r4.<init>();	 Catch:{ Exception -> 0x041d }
        r8 = r0.density;	 Catch:{ Exception -> 0x041d }
        r4 = r4.append(r8);	 Catch:{ Exception -> 0x041d }
        r4 = r4.toString();	 Catch:{ Exception -> 0x041d }
        r7.put(r1, r4);	 Catch:{ Exception -> 0x041d }
        r1 = "w";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x041d }
        r4.<init>();	 Catch:{ Exception -> 0x041d }
        r8 = r14.getW();	 Catch:{ Exception -> 0x041d }
        r4 = r4.append(r8);	 Catch:{ Exception -> 0x041d }
        r4 = r4.toString();	 Catch:{ Exception -> 0x041d }
        r7.put(r1, r4);	 Catch:{ Exception -> 0x041d }
        r1 = "h";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x041d }
        r4.<init>();	 Catch:{ Exception -> 0x041d }
        r8 = r14.getH();	 Catch:{ Exception -> 0x041d }
        r4 = r4.append(r8);	 Catch:{ Exception -> 0x041d }
        r4 = r4.toString();	 Catch:{ Exception -> 0x041d }
        r7.put(r1, r4);	 Catch:{ Exception -> 0x041d }
        r1 = r14.f840d;	 Catch:{ Exception -> 0x041d }
        r1 = r6.getScreenRect(r1);	 Catch:{ Exception -> 0x041d }
        r4 = "sw";
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x041d }
        r8.<init>();	 Catch:{ Exception -> 0x041d }
        r9 = r1.width();	 Catch:{ Exception -> 0x041d }
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x041d }
        r8 = r8.toString();	 Catch:{ Exception -> 0x041d }
        r7.put(r4, r8);	 Catch:{ Exception -> 0x041d }
        r4 = "sh";
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x041d }
        r8.<init>();	 Catch:{ Exception -> 0x041d }
        r1 = r1.height();	 Catch:{ Exception -> 0x041d }
        r1 = r8.append(r1);	 Catch:{ Exception -> 0x041d }
        r1 = r1.toString();	 Catch:{ Exception -> 0x041d }
        r7.put(r4, r1);	 Catch:{ Exception -> 0x041d }
        r1 = "lw";
        r4 = r14.getW();	 Catch:{ Exception -> 0x041d }
        r4 = (float) r4;	 Catch:{ Exception -> 0x041d }
        r8 = r0.density;	 Catch:{ Exception -> 0x041d }
        r4 = r4 / r8;
        r4 = java.lang.Math.round(r4);	 Catch:{ Exception -> 0x041d }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ Exception -> 0x041d }
        r7.put(r1, r4);	 Catch:{ Exception -> 0x041d }
        r1 = "lh";
        r4 = r14.getH();	 Catch:{ Exception -> 0x041d }
        r4 = (float) r4;	 Catch:{ Exception -> 0x041d }
        r0 = r0.density;	 Catch:{ Exception -> 0x041d }
        r0 = r4 / r0;
        r0 = java.lang.Math.round(r0);	 Catch:{ Exception -> 0x041d }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ Exception -> 0x041d }
        r7.put(r1, r0);	 Catch:{ Exception -> 0x041d }
        r0 = "sn";
        r1 = r14.f840d;	 Catch:{ Exception -> 0x041d }
        r1 = r5.getSn(r1);	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "";
        r1 = r14.f840d;	 Catch:{ Exception -> 0x027e }
        r4 = r5.getCell(r1);	 Catch:{ Exception -> 0x027e }
        r1 = r4.size();	 Catch:{ Exception -> 0x027e }
        if (r1 <= 0) goto L_0x01ed;
    L_0x01ae:
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x027e }
        r8.<init>();	 Catch:{ Exception -> 0x027e }
        r1 = r3;
    L_0x01b4:
        r0 = r4.size();	 Catch:{ Exception -> 0x027e }
        if (r1 >= r0) goto L_0x01e2;
    L_0x01ba:
        r0 = r4.get(r1);	 Catch:{ Exception -> 0x027e }
        r0 = (java.lang.String[]) r0;	 Catch:{ Exception -> 0x027e }
        r9 = "%s_%s_%s|";
        r10 = 3;
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x027e }
        r11 = 0;
        r12 = 0;
        r12 = r0[r12];	 Catch:{ Exception -> 0x027e }
        r10[r11] = r12;	 Catch:{ Exception -> 0x027e }
        r11 = 1;
        r12 = 1;
        r12 = r0[r12];	 Catch:{ Exception -> 0x027e }
        r10[r11] = r12;	 Catch:{ Exception -> 0x027e }
        r11 = 2;
        r12 = 2;
        r0 = r0[r12];	 Catch:{ Exception -> 0x027e }
        r10[r11] = r0;	 Catch:{ Exception -> 0x027e }
        r0 = java.lang.String.format(r9, r10);	 Catch:{ Exception -> 0x027e }
        r8.append(r0);	 Catch:{ Exception -> 0x027e }
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x01b4;
    L_0x01e2:
        r0 = 0;
        r1 = r8.length();	 Catch:{ Exception -> 0x027e }
        r1 = r1 + -1;
        r0 = r8.substring(r0, r1);	 Catch:{ Exception -> 0x027e }
    L_0x01ed:
        r1 = "cid";
        r7.put(r1, r0);	 Catch:{ Exception -> 0x041d }
        r0 = "nop";
        r1 = r14.f840d;	 Catch:{ Exception -> 0x041d }
        r1 = r5.getNetworkOperator(r1);	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "im";
        r1 = r14.f840d;	 Catch:{ Exception -> 0x041d }
        r1 = r6.getSubscriberId(r1);	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = r14.f840d;	 Catch:{ Exception -> 0x0283 }
        r1 = r5.getGPS(r0);	 Catch:{ Exception -> 0x0283 }
        r0 = "";
        if (r1 == 0) goto L_0x023c;
    L_0x0212:
        java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0283 }
        r0 = "%s_%s_%s";
        r4 = 3;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0283 }
        r8 = 0;
        r9 = 0;
        r10 = r1[r9];	 Catch:{ Exception -> 0x0283 }
        r9 = java.lang.Double.valueOf(r10);	 Catch:{ Exception -> 0x0283 }
        r4[r8] = r9;	 Catch:{ Exception -> 0x0283 }
        r8 = 1;
        r9 = 1;
        r10 = r1[r9];	 Catch:{ Exception -> 0x0283 }
        r9 = java.lang.Double.valueOf(r10);	 Catch:{ Exception -> 0x0283 }
        r4[r8] = r9;	 Catch:{ Exception -> 0x0283 }
        r8 = 2;
        r9 = 2;
        r10 = r1[r9];	 Catch:{ Exception -> 0x0283 }
        r1 = java.lang.Double.valueOf(r10);	 Catch:{ Exception -> 0x0283 }
        r4[r8] = r1;	 Catch:{ Exception -> 0x0283 }
        r0 = java.lang.String.format(r0, r4);	 Catch:{ Exception -> 0x0283 }
    L_0x023c:
        r1 = r0;
    L_0x023d:
        r0 = "g";
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r1 = "";
        r0 = r14.f840d;	 Catch:{ Exception -> 0x040f }
        r8 = r5.getWIFI(r0);	 Catch:{ Exception -> 0x040f }
        r0 = r8.size();	 Catch:{ Exception -> 0x040f }
        if (r0 <= 0) goto L_0x0410;
    L_0x0250:
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x040f }
        r9.<init>();	 Catch:{ Exception -> 0x040f }
        r4 = r3;
    L_0x0256:
        r0 = r8.size();	 Catch:{ Exception -> 0x040f }
        if (r4 >= r0) goto L_0x0287;
    L_0x025c:
        r0 = r8.get(r4);	 Catch:{ Exception -> 0x040f }
        r0 = (java.lang.String[]) r0;	 Catch:{ Exception -> 0x040f }
        r10 = "%s_%s|";
        r11 = 2;
        r11 = new java.lang.Object[r11];	 Catch:{ Exception -> 0x040f }
        r12 = 0;
        r13 = 0;
        r13 = r0[r13];	 Catch:{ Exception -> 0x040f }
        r11[r12] = r13;	 Catch:{ Exception -> 0x040f }
        r12 = 1;
        r13 = 1;
        r0 = r0[r13];	 Catch:{ Exception -> 0x040f }
        r11[r12] = r0;	 Catch:{ Exception -> 0x040f }
        r0 = java.lang.String.format(r10, r11);	 Catch:{ Exception -> 0x040f }
        r9.append(r0);	 Catch:{ Exception -> 0x040f }
        r0 = r4 + 1;
        r4 = r0;
        goto L_0x0256;
    L_0x027e:
        r0 = move-exception;
        r0 = "";
        goto L_0x01ed;
    L_0x0283:
        r0 = move-exception;
        r1 = "";
        goto L_0x023d;
    L_0x0287:
        r0 = 0;
        r4 = r9.length();	 Catch:{ Exception -> 0x040f }
        r4 = r4 + -1;
        r0 = r9.substring(r0, r4);	 Catch:{ Exception -> 0x040f }
    L_0x0292:
        r1 = "wi";
        r7.put(r1, r0);	 Catch:{ Exception -> 0x041d }
        r1 = "swi";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x041d }
        r4.<init>();	 Catch:{ Exception -> 0x041d }
        r0 = "wifi";
        r8 = r14.f840d;	 Catch:{ Exception -> 0x041d }
        r8 = r5.getNetworkType(r8);	 Catch:{ Exception -> 0x041d }
        r0 = r0.equals(r8);	 Catch:{ Exception -> 0x041d }
        if (r0 == 0) goto L_0x0413;
    L_0x02ac:
        r0 = r2;
    L_0x02ad:
        r0 = r4.append(r0);	 Catch:{ Exception -> 0x041d }
        r0 = r0.toString();	 Catch:{ Exception -> 0x041d }
        r7.put(r1, r0);	 Catch:{ Exception -> 0x041d }
        r0 = "tel";
        r1 = "";
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "uk";
        r1 = r14.getUk();	 Catch:{ Exception -> 0x041f }
        r2 = "utf-8";
        r1 = java.net.URLEncoder.encode(r1, r2);	 Catch:{ Exception -> 0x041f }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041f }
        r0 = "sex";
        r1 = r14.getSex();	 Catch:{ Exception -> 0x041f }
        r2 = "utf-8";
        r1 = java.net.URLEncoder.encode(r1, r2);	 Catch:{ Exception -> 0x041f }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041f }
        r0 = "zip";
        r1 = r14.getZip();	 Catch:{ Exception -> 0x041f }
        r2 = "utf-8";
        r1 = java.net.URLEncoder.encode(r1, r2);	 Catch:{ Exception -> 0x041f }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041f }
    L_0x02ec:
        r1 = "tab";
        r0 = r14.f840d;	 Catch:{ Exception -> 0x041d }
        r0 = r5.isTablet(r0);	 Catch:{ Exception -> 0x041d }
        if (r0 == 0) goto L_0x0416;
    L_0x02f6:
        r0 = "1";
    L_0x02f8:
        r7.put(r1, r0);	 Catch:{ Exception -> 0x041d }
        r0 = "sdc";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x041d }
        r1.<init>();	 Catch:{ Exception -> 0x041d }
        r2 = r5.getAppSDC();	 Catch:{ Exception -> 0x041d }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x041d }
        r2 = ",";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x041d }
        r2 = r5.getMem();	 Catch:{ Exception -> 0x041d }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x041d }
        r1 = r1.toString();	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "act";
        r1 = r14.getAct();	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "prod";
        r1 = r14.getProd();	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "os";
        r1 = "android";
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "osv";
        r1 = android.os.Build.VERSION.RELEASE;	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "bdr";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x041d }
        r1.<init>();	 Catch:{ Exception -> 0x041d }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x041d }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x041d }
        r1 = r1.toString();	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "apinfo";
        r1 = r14.f840d;	 Catch:{ Exception -> 0x041d }
        r1 = r6.getBaiduMapsInfo(r1);	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "apid";
        r1 = r14.getApid();	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "chid";
        r1 = r6.getChannelId();	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "apt";
        r1 = "0";
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "ap";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x041d }
        r1.<init>();	 Catch:{ Exception -> 0x041d }
        r2 = r14.getAp();	 Catch:{ Exception -> 0x041d }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x041d }
        r1 = r1.toString();	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "nt";
        r1 = r14.f840d;	 Catch:{ Exception -> 0x041d }
        r1 = r5.getNetType(r1);	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "udid";
        r1 = "";
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "ses";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x041d }
        r1.<init>();	 Catch:{ Exception -> 0x041d }
        r2 = r14.getSes();	 Catch:{ Exception -> 0x041d }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x041d }
        r1 = r1.toString();	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "android_id";
        r1 = r14.f840d;	 Catch:{ Exception -> 0x041d }
        r1 = r5.getAndroidId(r1);	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "imei";
        r1 = r14.f840d;	 Catch:{ Exception -> 0x041d }
        r1 = r5.getIMEI(r1);	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "mac";
        r1 = r14.f840d;	 Catch:{ Exception -> 0x041d }
        r1 = r5.getMacAddress(r1);	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "cuid";
        r1 = r14.f840d;	 Catch:{ Exception -> 0x041d }
        r1 = r5.getCUID(r1);	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "p_ver";
        r1 = "8.25";
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r0 = "req_id";
        r1 = r14.f840d;	 Catch:{ Exception -> 0x041d }
        r2 = r14.getApid();	 Catch:{ Exception -> 0x041d }
        r1 = r6.createRequestId(r1, r2);	 Catch:{ Exception -> 0x041d }
        r7.put(r0, r1);	 Catch:{ Exception -> 0x041d }
        r1 = "cssid";
        r0 = r14.f840d;	 Catch:{ Exception -> 0x041d }
        r0 = r5.isWifiConnected(r0);	 Catch:{ Exception -> 0x041d }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x041d }
        if (r0 == 0) goto L_0x041a;
    L_0x0405:
        r0 = r14.f840d;	 Catch:{ Exception -> 0x041d }
        r0 = r5.getWifiConnected(r0);	 Catch:{ Exception -> 0x041d }
    L_0x040b:
        r7.put(r1, r0);	 Catch:{ Exception -> 0x041d }
    L_0x040e:
        return r7;
    L_0x040f:
        r0 = move-exception;
    L_0x0410:
        r0 = r1;
        goto L_0x0292;
    L_0x0413:
        r0 = r3;
        goto L_0x02ad;
    L_0x0416:
        r0 = "0";
        goto L_0x02f8;
    L_0x041a:
        r0 = "";
        goto L_0x040b;
    L_0x041d:
        r0 = move-exception;
        goto L_0x040e;
    L_0x041f:
        r0 = move-exception;
        goto L_0x02ec;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.vo.d.e():java.util.HashMap<java.lang.String, java.lang.String>");
    }

    /* renamed from: e */
    public void mo5183e(int i) {
        this.f852p = i;
    }

    /* renamed from: f */
    public String mo5184f() {
        return this.f837a;
    }

    /* renamed from: f */
    public void mo5185f(int i) {
        this.f848l = i;
    }

    public String getAct() {
        return this.f849m;
    }

    public int getAp() {
        return this.f852p;
    }

    public String getApid() {
        return this.f845i;
    }

    public int getApt() {
        return this.f851o;
    }

    public int getAt() {
        return this.f848l;
    }

    public int getH() {
        return this.f847k;
    }

    public int getN() {
        return this.f853q;
    }

    public String getProd() {
        return this.f850n;
    }

    public long getSes() {
        return this.f858v;
    }

    public String getSex() {
        return this.f855s;
    }

    public String getUk() {
        return this.f854r;
    }

    public int getW() {
        return this.f846j;
    }

    public String getZip() {
        return this.f856t;
    }

    public boolean isCanClick() {
        return this.f857u;
    }
}
