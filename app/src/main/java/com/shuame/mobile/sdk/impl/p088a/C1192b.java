package com.shuame.mobile.sdk.impl.p088a;

import com.shuame.mobile.sdk.impl.utils.C1228g;
import com.shuame.mobile.sdk.impl.utils.http.DownloadResultCode;
import com.shuame.mobile.sdk.impl.utils.http.HttpDownloader;
import com.shuame.mobile.sdk.impl.utils.http.TaskInfo;
import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaObject;
import org.keplerproject.luajava.LuaState;

/* renamed from: com.shuame.mobile.sdk.impl.a.b */
public class C1192b extends C1185a {
    /* renamed from: a */
    private int f3176a;
    /* renamed from: b */
    private LuaObject f3177b;
    /* renamed from: c */
    private int f3178c;
    /* renamed from: d */
    private Object f3179d = new Object();
    /* renamed from: e */
    private boolean f3180e = false;
    /* renamed from: f */
    private int f3181f;

    public C1192b(LuaState luaState) {
        super(luaState);
    }

    /* renamed from: a */
    public String mo6833a() {
        return "download_file";
    }

    /* renamed from: d */
    public int mo6837d() {
        return this.f3181f;
    }

    public int execute() {
        this.f3176a = -1;
        try {
            String luaState = this.f3172L.toString(2);
            String luaState2 = this.f3172L.toString(3);
            String luaState3 = this.f3172L.toString(4);
            this.f3177b = this.f3172L.getLuaObject(5);
            this.f3181f = DownloadResultCode.f3242OK;
            this.f3178c = 0;
            C1228g.m3458a("JavaFunction", "url:" + luaState + ";path:" + luaState3);
            this.f3180e = false;
            this.f3178c = 0;
            C1228g.m3458a("JavaFunction", "start download");
            TaskInfo taskInfo = new TaskInfo();
            taskInfo.url = luaState;
            taskInfo.path = luaState3;
            taskInfo.md5 = luaState2;
            if (HttpDownloader.getInstance().download(taskInfo, new C1193c(this, luaState3)) > 0) {
                while (!this.f3180e) {
                    try {
                        this.f3177b.call(new Object[]{Integer.valueOf(this.f3178c / 10)}, 0);
                        synchronized (this.f3179d) {
                            if (!this.f3180e) {
                                this.f3179d.wait();
                            }
                        }
                    } catch (LuaException e) {
                        e.printStackTrace();
                    }
                }
            }
            C1228g.m3458a("JavaFunction", "end download");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f3172L.pushInteger(this.f3176a);
        return 1;
    }
}
