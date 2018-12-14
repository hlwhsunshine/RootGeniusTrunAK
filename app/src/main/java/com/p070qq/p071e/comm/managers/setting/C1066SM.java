package com.p070qq.p071e.comm.managers.setting;

import android.content.Context;
import android.util.Base64;
import com.p070qq.p071e.comm.C1058a;
import com.p070qq.p071e.comm.constants.Constants.SETTING;
import com.p070qq.p071e.comm.util.GDTLogger;
import com.p070qq.p071e.comm.util.StringUtil;
import java.io.File;

/* renamed from: com.qq.e.comm.managers.setting.SM */
public class C1066SM {
    /* renamed from: a */
    private C1067a f2789a;
    /* renamed from: b */
    private String f2790b;
    /* renamed from: c */
    private C1067a f2791c;
    /* renamed from: d */
    private C1067a f2792d;
    /* renamed from: e */
    private String f2793e;
    /* renamed from: f */
    private C1068c f2794f;
    /* renamed from: g */
    private C1068c f2795g;
    /* renamed from: h */
    private String f2796h;
    /* renamed from: i */
    private String f2797i = "";
    /* renamed from: j */
    private Context f2798j;

    public C1066SM(Context context) {
        this.f2798j = context;
        this.f2789a = new C1067a();
        this.f2792d = new C1067a();
        this.f2795g = new C1069b();
        try {
            this.f2796h = StringUtil.readAll(new File(this.f2798j.getDir(SETTING.SETTINGDIR, 0), SETTING.SUID_FILE));
        } catch (Throwable th) {
            this.f2796h = null;
            GDTLogger.m3131e("IO Exception while loading suid");
        }
        m3094a();
        m3095b();
    }

    /* renamed from: a */
    private void m3094a() {
        C1070d b = C1067a.m3100b(this.f2798j);
        if (b != null) {
            this.f2793e = b.mo6496a();
            this.f2794f = b.mo6497b();
            return;
        }
        GDTLogger.m3130d("Load Local SDK Cloud setting fail");
    }

    /* renamed from: b */
    private void m3095b() {
        C1058a a = C1067a.m3097a(this.f2798j);
        if (a != null) {
            this.f2791c = a.mo6447b();
            this.f2790b = a.mo6446a();
            return;
        }
        GDTLogger.m3130d("Load Local DEV Cloud setting fail");
    }

    public Object get(String str) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        try {
            Object a;
            if (this.f2789a.mo6489a(str) != null) {
                a = this.f2789a.mo6489a(str);
                if (a != null) {
                    return a;
                }
            }
            if (this.f2791c != null) {
                a = this.f2791c.mo6489a(str);
                if (a != null) {
                    return a;
                }
            }
            if (this.f2792d != null) {
                a = this.f2792d.mo6489a(str);
                if (a != null) {
                    return a;
                }
            }
            if (this.f2794f != null) {
                a = this.f2794f.mo6493a(str);
                if (a != null) {
                    return a;
                }
            }
            return this.f2795g != null ? this.f2795g.mo6493a(str) : null;
        } catch (Throwable th) {
            GDTLogger.report("Exception in settingManager.get Setting for key:" + str, th);
            return null;
        }
    }

    public String getDevCloudSettingSig() {
        return this.f2790b;
    }

    public Object getForPlacement(String str, String str2) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            return null;
        }
        try {
            Object a;
            if (this.f2789a != null) {
                a = this.f2789a.mo6490a(str, str2);
                if (a != null) {
                    return a;
                }
            }
            if (this.f2791c != null) {
                a = this.f2791c.mo6490a(str, str2);
                if (a != null) {
                    return a;
                }
            }
            if (this.f2792d != null) {
                a = this.f2792d.mo6490a(str, str2);
                if (a != null) {
                    return a;
                }
            }
            return get(str);
        } catch (Throwable th) {
            GDTLogger.report("Exception in settingManager.getForPlacement", th);
            return null;
        }
    }

    public int getInteger(String str, int i) {
        Object obj = get(str);
        return (obj == null || !(obj instanceof Integer)) ? i : ((Integer) obj).intValue();
    }

    public int getIntegerForPlacement(String str, String str2, int i) {
        Object forPlacement = getForPlacement(str, str2);
        return (forPlacement == null || !(forPlacement instanceof Integer)) ? i : ((Integer) forPlacement).intValue();
    }

    public String getSdkCloudSettingSig() {
        return this.f2793e;
    }

    public String getSid() {
        return this.f2797i;
    }

    public String getString(String str) {
        Object obj = get(str);
        return obj == null ? null : obj.toString();
    }

    public String getStringForPlacement(String str, String str2) {
        Object forPlacement = getForPlacement(str, str2);
        return forPlacement == null ? null : forPlacement.toString();
    }

    public String getSuid() {
        return this.f2796h;
    }

    public void setDEVCodeSetting(String str, Object obj) {
        this.f2792d.mo6491a(str, obj);
    }

    public void setDEVCodeSetting(String str, Object obj, String str2) {
        this.f2792d.mo6492a(str, obj, str2);
    }

    public void updateContextSetting(String str) {
        try {
            C1067a c1067a = new C1067a();
            if (!StringUtil.isEmpty(str)) {
                c1067a = new C1067a(new String(Base64.decode(str, 0), "UTF-8"));
            }
            this.f2789a = c1067a;
        } catch (Throwable th) {
            GDTLogger.report("Exception while update Context Setting", th);
        }
    }

    public void updateDEVCloudSetting(String str, String str2) {
        if (C1067a.m3101b(this.f2798j, str, str2)) {
            m3095b();
        }
    }

    public void updateSDKCloudSetting(String str, String str2) {
        if (C1067a.m3098a(this.f2798j, str, str2)) {
            m3094a();
        }
    }

    public void updateSID(String str) {
        this.f2797i = str;
    }

    public void updateSUID(String str) {
        if (!StringUtil.isEmpty(str) && !str.equals(this.f2796h)) {
            this.f2796h = str;
            try {
                StringUtil.writeTo(str, new File(this.f2798j.getDir(SETTING.SETTINGDIR, 0), SETTING.SUID_FILE));
            } catch (Throwable e) {
                GDTLogger.report("Exception while persit suid", e);
            }
        }
    }
}
