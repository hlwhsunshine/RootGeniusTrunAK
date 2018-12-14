package com.shuame.mobile.sdk.impl;

import com.shuame.mobile.sdk.FlashEngine;
import com.shuame.mobile.sdk.FlashEngine.FlashListener;
import com.shuame.mobile.sdk.FlashEngine.FlashResult;
import com.shuame.mobile.sdk.impl.p088a.C1186aa;
import com.shuame.mobile.sdk.impl.p088a.C1187ab;
import com.shuame.mobile.sdk.impl.p088a.C1188ac;
import com.shuame.mobile.sdk.impl.p088a.C1191ae;
import com.shuame.mobile.sdk.impl.p088a.C1192b;
import com.shuame.mobile.sdk.impl.p088a.C1194d;
import com.shuame.mobile.sdk.impl.p088a.C1195e;
import com.shuame.mobile.sdk.impl.p088a.C1196f;
import com.shuame.mobile.sdk.impl.p088a.C1197g;
import com.shuame.mobile.sdk.impl.p088a.C1198h;
import com.shuame.mobile.sdk.impl.p088a.C1199i;
import com.shuame.mobile.sdk.impl.p088a.C1200j;
import com.shuame.mobile.sdk.impl.p088a.C1201k;
import com.shuame.mobile.sdk.impl.p088a.C1202l;
import com.shuame.mobile.sdk.impl.p088a.C1208r;
import com.shuame.mobile.sdk.impl.p088a.C1209s;
import com.shuame.mobile.sdk.impl.p088a.C1210t;
import com.shuame.mobile.sdk.impl.p088a.C1211u;
import com.shuame.mobile.sdk.impl.p088a.C1212v;
import com.shuame.mobile.sdk.impl.p088a.C1214x;
import com.shuame.mobile.sdk.impl.p088a.C1216z;
import com.shuame.mobile.sdk.impl.utils.C1226e;
import com.shuame.mobile.sdk.impl.utils.C1228g;
import com.shuame.mobile.sdk.impl.utils.RomScanner;
import com.shuame.mobile.sdk.impl.utils.http.HttpDownloader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaObject;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

/* renamed from: com.shuame.mobile.sdk.impl.a */
public class C1217a implements FlashEngine {
    /* renamed from: a */
    private static final String f3203a = C1217a.class.getSimpleName();
    /* renamed from: b */
    private LuaState f3204b;
    /* renamed from: c */
    private String f3205c;
    /* renamed from: d */
    private String f3206d;
    /* renamed from: e */
    private String f3207e;
    /* renamed from: f */
    private String f3208f;
    /* renamed from: g */
    private List<FlashListener> f3209g = Collections.synchronizedList(new ArrayList());
    /* renamed from: h */
    private C1210t f3210h;
    /* renamed from: i */
    private C1192b f3211i;
    /* renamed from: j */
    private Object f3212j = new Object();
    /* renamed from: k */
    private int f3213k;

    /* renamed from: a */
    private Map<String, Object> m3437a(int i, LuaObject luaObject) {
        Map<String, Object> hashMap = new HashMap();
        LuaObject field;
        int number;
        if (i == 2) {
            String string;
            field = luaObject.getField("src_file_path");
            if (field != null) {
                string = field.getString();
                hashMap.put("src_file_path", string);
                C1228g.m3458a(f3203a, "src_file_path:" + string);
            }
            field = luaObject.getField("dest_file_path");
            if (field != null) {
                string = field.getString();
                hashMap.put("dest_file_path", string);
                C1228g.m3458a(f3203a, "dest_file_path:" + string);
            }
            field = luaObject.getField("progress_start");
            if (field != null) {
                number = (int) field.getNumber();
                hashMap.put("progress_start", Integer.valueOf(number));
                C1228g.m3458a(f3203a, "progress_start:" + number);
            }
            field = luaObject.getField("progress_finish");
            if (field != null) {
                number = (int) field.getNumber();
                hashMap.put("progress_finish", Integer.valueOf(number));
                C1228g.m3458a(f3203a, "progress_finish:" + number);
            }
            field = luaObject.getField("prog");
            if (field != null) {
                number = (int) field.getNumber();
                hashMap.put("prog", Integer.valueOf(number));
                C1228g.m3458a(f3203a, "prog:" + number);
            }
        } else if (i == 7) {
            field = luaObject.getField("second");
            if (field != null) {
                number = (int) field.getNumber();
                hashMap.put("second", Integer.valueOf(number));
                C1228g.m3458a(f3203a, "second:" + number);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private void m3439a() {
        C1200j.f3188a = false;
    }

    /* renamed from: a */
    private void m3440a(String str) {
        this.f3204b.newTable();
        this.f3204b.pushValue(-1);
        this.f3204b.setGlobal(str);
    }

    /* renamed from: b */
    private void m3441b() {
        this.f3204b.pop(1);
    }

    public void cancelFlash() {
        C1228g.m3458a(f3203a, "cancelFlash start");
        C1200j.f3188a = true;
        RomScanner.cancel();
        HttpDownloader.getInstance().cancelAll();
        clickDialogButton(2);
        C1228g.m3458a(f3203a, "cancelFlash end");
    }

    public void clickDialogButton(int i) {
        C1228g.m3458a(f3203a, "clickDialogButton button:" + i);
        this.f3213k = i;
        synchronized (this.f3212j) {
            this.f3212j.notify();
        }
    }

    public int getDownloadResultCode() {
        return this.f3211i != null ? this.f3211i.mo6837d() : 0;
    }

    public String getLuaErrorMsg() {
        return this.f3208f;
    }

    public List<String> getReportList() {
        return this.f3210h != null ? this.f3210h.mo6840d() : null;
    }

    public boolean init(String str, String str2, String str3, Map<String, Object> map) {
        C1228g.m3458a(f3203a, "init");
        this.f3205c = str;
        this.f3206d = str2;
        this.f3207e = str3;
        try {
            this.f3204b = LuaStateFactory.newLuaState();
            this.f3204b.openLibs();
            C1228g.m3458a(f3203a, "init zip_utils");
            m3440a("zip_utils");
            new C1191ae(this.f3204b).mo6834b();
            new C1188ac(this.f3204b).mo6834b();
            new C1187ab(this.f3204b).mo6834b();
            new C1199i(this.f3204b).mo6834b();
            m3441b();
            C1228g.m3458a(f3203a, "init flash_utils");
            m3440a("flash_utils");
            new C1214x(this.f3204b).mo6834b();
            this.f3211i = new C1192b(this.f3204b);
            this.f3211i.mo6834b();
            new C1200j(this.f3204b).mo6834b();
            new C1186aa(this.f3204b, this).mo6834b();
            m3441b();
            C1228g.m3458a(f3203a, "init phone_utils");
            m3440a("phone_utils");
            new C1212v(this.f3204b).mo6834b();
            new C1216z(this.f3204b).mo6834b();
            m3441b();
            C1228g.m3458a(f3203a, "init evn_utils");
            m3440a("evn_utils");
            new C1198h(this.f3204b, 4).mo6834b();
            new C1197g(this.f3204b, 2).mo6834b();
            new C1195e(this.f3204b, map).mo6834b();
            this.f3210h = new C1210t(this.f3204b);
            this.f3210h.mo6834b();
            m3441b();
            C1228g.m3458a(f3203a, "init device_utils");
            m3440a("device_utils");
            new C1196f(this.f3204b).mo6834b();
            new C1194d(this.f3204b).mo6834b();
            new C1201k(this.f3204b).mo6834b();
            new C1208r(this.f3204b).mo6834b();
            m3441b();
            C1228g.m3458a(f3203a, "init global function");
            C1211u.m3429d();
            new C1211u(this.f3204b, this.f3207e).mo6835c();
            new C1209s(this.f3204b).mo6835c();
            new C1202l(this.f3204b).mo6835c();
            m3439a();
            C1228g.m3458a(f3203a, "loadFile:" + this.f3206d);
            return this.f3204b.LdoString(C1226e.m3453a(this.f3206d)) == 0;
        } catch (LuaException e) {
            return false;
        }
    }

    public int preCheck() {
        Exception e;
        m3439a();
        int pcall;
        try {
            this.f3204b.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "flash_evn_check");
            this.f3204b.pushString(this.f3205c);
            pcall = this.f3204b.pcall(1, 1, 0);
            C1228g.m3458a(f3203a, "preCheck isCallOk:" + pcall);
            if (pcall == 0) {
                pcall = this.f3204b.toInteger(-1);
                try {
                    C1228g.m3458a(f3203a, "preCheck isCallOk:0, ret:" + pcall);
                    return pcall;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return pcall;
                }
            }
            this.f3208f = this.f3204b.toString(-1);
            C1228g.m3458a(f3203a, "preCheck lua error:" + this.f3208f);
            return FlashResult.ERROR_EXE_LUA;
        } catch (Exception e3) {
            Exception exception = e3;
            pcall = FlashResult.ERROR_UNKONW;
            e = exception;
            e.printStackTrace();
            return pcall;
        }
    }

    public void registerListener(FlashListener flashListener) {
        if (flashListener != null && !this.f3209g.contains(flashListener)) {
            this.f3209g.add(flashListener);
        }
    }

    public void release() {
        C1228g.m3458a(f3203a, "before release");
        if (this.f3204b != null) {
            this.f3204b.close();
            this.f3204b = null;
        }
        C1228g.m3458a(f3203a, "after release");
        this.f3209g.clear();
        C1211u.m3429d();
        if (this.f3210h != null) {
            this.f3210h.mo6841e();
        }
        HttpDownloader.destroy();
    }

    public int showDialog(String str, int i) {
        C1228g.m3458a(f3203a, "showDialog start");
        int i2 = 2;
        if (!(this.f3209g == null || this.f3209g.isEmpty())) {
            for (FlashListener flashListener : this.f3209g) {
                if (flashListener != null) {
                    flashListener.onDialog(str, i);
                }
            }
            synchronized (this.f3212j) {
                try {
                    this.f3212j.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i2 = this.f3213k;
        }
        C1228g.m3458a(f3203a, "showDialog end, click button:" + i2);
        return i2;
    }

    public int startFlash() {
        LuaException e;
        C1228g.m3458a(f3203a, "startFlash begin");
        m3439a();
        int pcall;
        try {
            this.f3204b.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "flash");
            this.f3204b.pushString(this.f3205c);
            this.f3204b.pushJavaFunction(new C1218b(this, this.f3204b));
            pcall = this.f3204b.pcall(2, 1, 0);
            C1228g.m3458a(f3203a, "startFlash isCallOk:" + pcall);
            if (pcall == 0) {
                pcall = this.f3204b.toInteger(-1);
                try {
                    C1228g.m3458a(f3203a, "startFlash isCallOk:0, ret:" + pcall);
                } catch (LuaException e2) {
                    e = e2;
                }
                C1228g.m3458a(f3203a, "startFlash end");
                return pcall;
            }
            pcall = FlashResult.ERROR_EXE_LUA;
            this.f3208f = this.f3204b.toString(-1);
            C1228g.m3458a(f3203a, "startFlash lua error:" + this.f3208f);
            C1228g.m3458a(f3203a, "startFlash end");
            return pcall;
        } catch (LuaException e3) {
            LuaException luaException = e3;
            pcall = FlashResult.ERROR_UNKONW;
            e = luaException;
            e.printStackTrace();
            C1228g.m3458a(f3203a, "startFlash end");
            return pcall;
        }
    }

    public void unregisterListener(FlashListener flashListener) {
        if (flashListener != null && this.f3209g.contains(flashListener)) {
            this.f3209g.remove(flashListener);
        }
    }
}
