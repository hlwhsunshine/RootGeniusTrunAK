package com.p070qq.p071e.comm.managers.setting;

import android.content.Context;
import android.util.Base64;
import android.util.Pair;
import com.p070qq.p071e.comm.C1058a;
import com.p070qq.p071e.comm.constants.Constants.KEYS;
import com.p070qq.p071e.comm.constants.Constants.SETTING;
import com.p070qq.p071e.comm.util.C1080a;
import com.p070qq.p071e.comm.util.GDTLogger;
import com.p070qq.p071e.comm.util.StringUtil;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.managers.setting.a */
public class C1067a {
    /* renamed from: a */
    private JSONObject f2799a;

    public C1067a() {
        this.f2799a = new JSONObject();
    }

    public C1067a(String str) {
        this();
        GDTLogger.m3130d("Initialize GDTAPPSetting,Json=" + str);
        if (!StringUtil.isEmpty(str)) {
            try {
                this.f2799a = new JSONObject(str);
            } catch (Throwable e) {
                GDTLogger.m3132e("JsonException While build GDTAPPSetting Instance from JSON", e);
            }
        }
    }

    /* renamed from: a */
    private static Pair<String, String> m3096a(Context context, String str) {
        File dir = context.getDir(SETTING.SETTINGDIR, 0);
        if (!dir.exists()) {
            return null;
        }
        File file = new File(dir, str + ".sig");
        File file2 = new File(dir, str + ".cfg");
        if (!file.exists() || !file2.exists()) {
            return null;
        }
        try {
            return new Pair(StringUtil.readAll(file), StringUtil.readAll(file2));
        } catch (IOException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static C1058a m3097a(Context context) {
        Pair a = C1067a.m3096a(context, SETTING.DEV_CLOUD_SETTING);
        if (a == null) {
            return null;
        }
        try {
            if (C1080a.m3136a().mo6628a((String) a.first, (String) a.second)) {
                return new C1058a((String) a.first, new C1067a(new String(Base64.decode((String) a.second, 0), "UTF-8")));
            }
            GDTLogger.m3131e("verify local dev cloud setting fail");
            return null;
        } catch (Throwable th) {
            GDTLogger.m3132e("exception while loading local dev cloud setting", th);
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m3098a(Context context, String str, String str2) {
        return C1067a.m3099a(context, SETTING.SDK_CLOUD_SETTING, str, str2);
    }

    /* renamed from: a */
    private static boolean m3099a(Context context, String str, String str2, String str3) {
        if (StringUtil.isEmpty(str2) || StringUtil.isEmpty(str3)) {
            GDTLogger.m3131e(String.format("Fail to update Cloud setting due to sig or setting is empty,name=%s\tsig=%s\tsetting=%s", new Object[]{str, str2, str3}));
            return false;
        } else if (C1080a.m3136a().mo6628a(str2, str3)) {
            return C1067a.m3102b(context, str, str2, str3);
        } else {
            GDTLogger.m3131e(String.format("Fail to update Cloud setting due to sig verify fail,name=%s\tsig=%s\tsetting=%s", new Object[]{str, str2, str3}));
            return false;
        }
    }

    /* renamed from: b */
    public static C1070d m3100b(Context context) {
        Pair a = C1067a.m3096a(context, SETTING.SDK_CLOUD_SETTING);
        if (a == null) {
            return null;
        }
        try {
            if (C1080a.m3136a().mo6628a((String) a.first, (String) a.second)) {
                return new C1070d((String) a.first, new C1068c(new String(Base64.decode((String) a.second, 0), "UTF-8")), (byte) 0);
            }
            GDTLogger.m3131e("verify local sdk cloud setting fail");
            return null;
        } catch (Throwable th) {
            GDTLogger.m3132e("exception while loading local sdk cloud setting", th);
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m3101b(Context context, String str, String str2) {
        return C1067a.m3099a(context, SETTING.DEV_CLOUD_SETTING, str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063 A:{SYNTHETIC, Splitter: B:18:0x0063} */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0068 A:{Catch:{ Exception -> 0x006c }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072 A:{SYNTHETIC, Splitter: B:26:0x0072} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0077 A:{Catch:{ Exception -> 0x007b }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072 A:{SYNTHETIC, Splitter: B:26:0x0072} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0077 A:{Catch:{ Exception -> 0x007b }} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063 A:{SYNTHETIC, Splitter: B:18:0x0063} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0068 A:{Catch:{ Exception -> 0x006c }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072 A:{SYNTHETIC, Splitter: B:26:0x0072} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0077 A:{Catch:{ Exception -> 0x007b }} */
    /* renamed from: b */
    private static boolean m3102b(android.content.Context r7, java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
        r2 = 0;
        r0 = 0;
        r1 = "e_qq_com_setting";
        r1 = r7.getDir(r1, r0);
        r3 = r1.exists();
        if (r3 != 0) goto L_0x0011;
    L_0x000e:
        r1.mkdirs();
    L_0x0011:
        r4 = new java.io.File;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3 = r3.append(r8);
        r5 = ".cfg";
        r3 = r3.append(r5);
        r3 = r3.toString();
        r4.<init>(r1, r3);
        r5 = new java.io.File;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3 = r3.append(r8);
        r6 = ".sig";
        r3 = r3.append(r6);
        r3 = r3.toString();
        r5.<init>(r1, r3);
        r3 = new java.io.FileWriter;	 Catch:{ Exception -> 0x0059, all -> 0x006e }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0059, all -> 0x006e }
        r3.write(r10);	 Catch:{ Exception -> 0x0086, all -> 0x007d }
        r1 = new java.io.FileWriter;	 Catch:{ Exception -> 0x0086, all -> 0x007d }
        r1.<init>(r5);	 Catch:{ Exception -> 0x0086, all -> 0x007d }
        r1.write(r9);	 Catch:{ Exception -> 0x008a, all -> 0x007f }
        r3.close();	 Catch:{ Exception -> 0x008d }
        r1.close();	 Catch:{ Exception -> 0x008d }
    L_0x0057:
        r0 = 1;
    L_0x0058:
        return r0;
    L_0x0059:
        r1 = move-exception;
        r1 = r2;
    L_0x005b:
        r4.delete();	 Catch:{ all -> 0x0082 }
        r5.delete();	 Catch:{ all -> 0x0082 }
        if (r2 == 0) goto L_0x0066;
    L_0x0063:
        r2.close();	 Catch:{ Exception -> 0x006c }
    L_0x0066:
        if (r1 == 0) goto L_0x0058;
    L_0x0068:
        r1.close();	 Catch:{ Exception -> 0x006c }
        goto L_0x0058;
    L_0x006c:
        r1 = move-exception;
        goto L_0x0058;
    L_0x006e:
        r0 = move-exception;
        r3 = r2;
    L_0x0070:
        if (r3 == 0) goto L_0x0075;
    L_0x0072:
        r3.close();	 Catch:{ Exception -> 0x007b }
    L_0x0075:
        if (r2 == 0) goto L_0x007a;
    L_0x0077:
        r2.close();	 Catch:{ Exception -> 0x007b }
    L_0x007a:
        throw r0;
    L_0x007b:
        r1 = move-exception;
        goto L_0x007a;
    L_0x007d:
        r0 = move-exception;
        goto L_0x0070;
    L_0x007f:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0070;
    L_0x0082:
        r0 = move-exception;
        r3 = r2;
        r2 = r1;
        goto L_0x0070;
    L_0x0086:
        r1 = move-exception;
        r1 = r2;
        r2 = r3;
        goto L_0x005b;
    L_0x008a:
        r2 = move-exception;
        r2 = r3;
        goto L_0x005b;
    L_0x008d:
        r0 = move-exception;
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.setting.a.b(android.content.Context, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: a */
    final Object mo6489a(String str) {
        return this.f2799a.opt(str);
    }

    /* renamed from: a */
    final Object mo6490a(String str, String str2) {
        JSONObject optJSONObject = this.f2799a.optJSONObject(KEYS.PLACEMENTS);
        optJSONObject = optJSONObject != null ? optJSONObject.optJSONObject(str2) : null;
        return optJSONObject != null ? optJSONObject.opt(str) : null;
    }

    /* renamed from: a */
    final void mo6491a(String str, Object obj) {
        try {
            this.f2799a.putOpt(str, obj);
        } catch (Throwable e) {
            GDTLogger.m3132e("Exception while update setting", e);
        }
    }

    /* renamed from: a */
    final void mo6492a(String str, Object obj, String str2) {
        try {
            JSONObject jSONObject;
            JSONObject optJSONObject = this.f2799a.optJSONObject(KEYS.PLACEMENTS);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                this.f2799a.putOpt(KEYS.PLACEMENTS, optJSONObject);
                jSONObject = optJSONObject;
            } else {
                jSONObject = optJSONObject;
            }
            optJSONObject = jSONObject != null ? jSONObject.optJSONObject(str2) : null;
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                jSONObject.putOpt(str2, optJSONObject);
            }
            if (obj == null) {
                optJSONObject.remove(str);
            } else {
                optJSONObject.putOpt(str, obj);
            }
        } catch (Throwable e) {
            GDTLogger.m3132e("Exception while update setting", e);
        }
    }
}
