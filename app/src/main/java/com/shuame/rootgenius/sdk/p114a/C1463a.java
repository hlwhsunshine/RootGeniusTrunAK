package com.shuame.rootgenius.sdk.p114a;

import com.shuame.rootgenius.sdk.CommUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.shuame.rootgenius.sdk.a.a */
public abstract class C1463a {
    /* renamed from: a */
    protected Map f4027a = new HashMap();
    /* renamed from: b */
    public boolean f4028b = true;
    /* renamed from: c */
    public boolean f4029c = true;
    /* renamed from: d */
    private final String f4030d;

    public C1463a(String str) {
        this.f4030d = str;
    }

    /* renamed from: b */
    public static boolean m4035b() {
        String execCmd = CommUtils.execCmd(false, "su -c id", 10000);
        return (execCmd == null || execCmd.isEmpty() || execCmd.indexOf("uid=0") < 0) ? false : true;
    }

    /* renamed from: a */
    protected final String mo7257a() {
        return this.f4030d;
    }

    /* renamed from: a */
    public String mo7258a(String str) {
        return this.f4030d + "Data/sutmp/" + str;
    }

    /* renamed from: c */
    public final void mo7259c() {
        //f4030d 是 getFilesDir().getAbsolutePath() + "/";
        CommUtils.delete(new File(this.f4030d + "Data/.rootgenius"));
    }

    /* renamed from: d */
    public final boolean mo7260d() {
        String readFrom = CommUtils.readFrom(this.f4030d + "Data/.rootgenius");
        mo7259c();
        return readFrom.indexOf("uid=0") >= 0;
    }

    /* renamed from: e */
    public String mo7261e() {
        return "";
    }

    /* renamed from: f */
    public final String mo7262f() {
        return this.f4027a.containsKey("package") ? (String) this.f4027a.get("package") : "";
    }

    /* renamed from: g */
    public final Map mo7263g() {
        return this.f4027a;
    }
}
