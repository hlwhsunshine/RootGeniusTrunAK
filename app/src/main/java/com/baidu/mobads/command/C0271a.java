package com.baidu.mobads.command;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Process;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p025c.C0265a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.command.a */
public class C0271a implements Serializable {
    /* renamed from: A */
    private boolean f463A;
    /* renamed from: a */
    public String f464a;
    /* renamed from: b */
    public String f465b;
    /* renamed from: c */
    public String f466c;
    /* renamed from: d */
    public long f467d = -1;
    /* renamed from: e */
    public int f468e = 0;
    /* renamed from: f */
    public int f469f;
    /* renamed from: g */
    public DownloadStatus f470g = DownloadStatus.NONE;
    /* renamed from: h */
    public Object f471h = null;
    /* renamed from: i */
    public String f472i;
    /* renamed from: j */
    public String f473j;
    /* renamed from: k */
    public String f474k;
    /* renamed from: l */
    public boolean f475l;
    /* renamed from: m */
    public String f476m;
    /* renamed from: n */
    public String f477n;
    /* renamed from: o */
    public String f478o;
    /* renamed from: p */
    public String f479p;
    /* renamed from: q */
    public int f480q = 0;
    /* renamed from: r */
    public boolean f481r = false;
    /* renamed from: s */
    public long f482s;
    /* renamed from: t */
    protected long f483t;
    /* renamed from: u */
    protected long f484u;
    /* renamed from: v */
    public boolean f485v = false;
    /* renamed from: w */
    public String f486w = null;
    /* renamed from: x */
    protected final IXAdLogger f487x = C0338m.m569a().mo5033f();
    /* renamed from: y */
    private long f488y;
    /* renamed from: z */
    private long f489z;

    public C0271a(String str, String str2) {
        this.f472i = str;
        this.f464a = str2;
    }

    /* renamed from: a */
    public static C0271a m359a(Context context, String str) {
        Throwable e;
        C0271a c0271a = null;
        if (str == null || "".equals(str)) {
            return null;
        }
        try {
            String string = context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_DOWNLOAD, 0).getString(str + "#$#" + C0271a.m361b(), null);
            if (string == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(string);
            String string2 = jSONObject.getString("title");
            String optString = jSONObject.optString("url", jSONObject.getString("turl"));
            C0271a c0271a2 = new C0271a(str, string2);
            try {
                c0271a2.mo4412a(jSONObject.optString("qk"), jSONObject.optString("adid"), optString, jSONObject.optBoolean("autoOpen"));
                c0271a2.mo4411a(jSONObject.getString("filename"), jSONObject.getString("folder"));
                c0271a2.mo4415b(jSONObject.optString("placeId"), jSONObject.optString("prod"));
                int i = jSONObject.getInt(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
                DownloadStatus[] values = DownloadStatus.values();
                DownloadStatus downloadStatus = DownloadStatus.NONE;
                for (int i2 = 0; i2 < values.length; i2++) {
                    if (values[i2].getCode() == i) {
                        downloadStatus = values[i2];
                    }
                }
                c0271a2.f470g = downloadStatus;
                c0271a2.f481r = jSONObject.optBoolean("mnCfm");
                c0271a2.f480q = jSONObject.getInt("dlCnt");
                c0271a2.f482s = jSONObject.optLong("cts");
                c0271a2.f483t = jSONObject.optLong("ts");
                c0271a2.f484u = (long) jSONObject.optInt("clickProcId");
                return c0271a2;
            } catch (Throwable e2) {
                Throwable th = e2;
                c0271a = c0271a2;
                e = th;
                C0338m.m569a().mo5033f().mo4924d(e);
                C0265a.m334a().mo4397a("get stored download info failed: " + e.toString());
                return c0271a;
            }
        } catch (Exception e3) {
            e = e3;
            C0338m.m569a().mo5033f().mo4924d(e);
            C0265a.m334a().mo4397a("get stored download info failed: " + e.toString());
            return c0271a;
        }
    }

    /* renamed from: a */
    public static List<String> m360a(Context context, long j) {
        List<String> arrayList = new ArrayList();
        try {
            for (Entry entry : context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_DOWNLOAD, 0).getAll().entrySet()) {
                try {
                    String str = (String) entry.getKey();
                    if (str.contains("#$#" + C0271a.m361b())) {
                        JSONObject jSONObject = new JSONObject((String) entry.getValue());
                        if (jSONObject.getLong("cts") >= j) {
                            int i = jSONObject.getInt(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
                            if (i == 0 || i == 1 || i == 4) {
                                arrayList.add(str.substring(0, str.indexOf("#$#")));
                            }
                        }
                    }
                } catch (Exception e) {
                    C0338m.m569a().mo5033f().mo4922d("XAdDownloaderManager", e.getMessage());
                }
            }
        } catch (Throwable e2) {
            C0338m.m569a().mo5033f().mo4924d(e2);
        }
        return arrayList;
    }

    /* renamed from: b */
    public static String m361b() {
        return C0338m.m569a().mo5041n().getCurrentProcessName(C0338m.m569a().mo5031d());
    }

    /* renamed from: a */
    public JSONObject mo4408a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS, this.f470g.getCode());
            jSONObject.put("filename", this.f465b);
            jSONObject.put("folder", this.f466c);
            jSONObject.put("title", this.f464a);
            jSONObject.put("contentLength", this.f467d);
            jSONObject.put(IXAdRequestInfo.PACKAGE, this.f472i);
            jSONObject.put("qk", this.f476m);
            jSONObject.put("autoOpen", this.f475l);
            jSONObject.put("adid", this.f477n);
            jSONObject.put("placeId", this.f478o);
            jSONObject.put("prod", this.f479p);
            jSONObject.put("dlTunnel", 4);
            if (this.f474k == null || this.f474k.length() <= 0) {
                jSONObject.put("url", this.f473j);
            } else {
                jSONObject.put("turl", this.f474k);
            }
            jSONObject.put("mnCfm", this.f481r);
            jSONObject.put("dlCnt", this.f480q);
            jSONObject.put("cts", this.f482s);
            if (this.f480q == 1) {
                this.f483t = System.currentTimeMillis();
                this.f484u = (long) Process.myPid();
            }
            jSONObject.put("ts", this.f483t);
            jSONObject.put("clickProcId", this.f484u);
        } catch (Throwable e) {
            this.f487x.mo4924d(e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public void mo4409a(long j) {
        this.f488y = j;
    }

    @TargetApi(9)
    /* renamed from: a */
    public void mo4410a(Context context) {
        if (this.f472i != null && !"".equals(this.f472i)) {
            try {
                Editor edit = context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_DOWNLOAD, 0).edit();
                edit.putString(this.f472i + "#$#" + C0271a.m361b(), mo4408a().toString());
                if (VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
            } catch (Throwable e) {
                C0338m.m569a().mo5033f().mo4923d("XAdAPKDownloadExtraInfo", e);
            }
        }
    }

    /* renamed from: a */
    public void mo4411a(String str, String str2) {
        this.f465b = str;
        this.f466c = str2;
    }

    /* renamed from: a */
    public void mo4412a(String str, String str2, String str3, boolean z) {
        this.f476m = str;
        this.f477n = str2;
        this.f473j = str3;
        this.f475l = z;
    }

    /* renamed from: a */
    public void mo4413a(boolean z) {
        this.f463A = z;
    }

    /* renamed from: b */
    public void mo4414b(long j) {
        this.f489z = j;
    }

    /* renamed from: b */
    public void mo4415b(String str, String str2) {
        this.f478o = str;
        this.f479p = str2;
    }

    /* renamed from: c */
    public long mo4416c() {
        return this.f488y;
    }

    /* renamed from: d */
    public String mo4417d() {
        return this.f472i;
    }

    /* renamed from: e */
    public long mo4418e() {
        return this.f489z;
    }

    /* renamed from: f */
    public boolean mo4419f() {
        return this.f463A;
    }

    /* renamed from: g */
    public String mo4420g() {
        return this.f477n;
    }

    /* renamed from: h */
    public String mo4421h() {
        return this.f476m;
    }

    /* renamed from: i */
    public String mo4422i() {
        return this.f479p;
    }
}
