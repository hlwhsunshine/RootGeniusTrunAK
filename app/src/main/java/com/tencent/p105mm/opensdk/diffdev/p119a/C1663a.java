package com.tencent.p105mm.opensdk.diffdev.p119a;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.p105mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.p105mm.opensdk.diffdev.OAuthListener;
import com.tencent.p105mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.a */
public final class C1663a implements IDiffDevOAuth {
    /* renamed from: c */
    private List<OAuthListener> f4741c = new ArrayList();
    /* renamed from: d */
    private C1667d f4742d;
    /* renamed from: e */
    private OAuthListener f4743e = new C1664b(this);
    private Handler handler = null;

    public final void addListener(OAuthListener oAuthListener) {
        if (!this.f4741c.contains(oAuthListener)) {
            this.f4741c.add(oAuthListener);
        }
    }

    public final boolean auth(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        Log.m4581i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = " + str);
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            Log.m4579d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", new Object[]{str, str2}));
            return false;
        }
        if (this.handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        }
        addListener(oAuthListener);
        if (this.f4742d != null) {
            Log.m4579d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
            return true;
        }
        this.f4742d = new C1667d(str, str2, str3, str4, str5, this.f4743e);
        C1667d c1667d = this.f4742d;
        if (VERSION.SDK_INT >= 11) {
            c1667d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            c1667d.execute(new Void[0]);
        }
        return true;
    }

    public final void detach() {
        Log.m4581i("MicroMsg.SDK.DiffDevOAuth", "detach");
        this.f4741c.clear();
        stopAuth();
    }

    public final void removeAllListeners() {
        this.f4741c.clear();
    }

    public final void removeListener(OAuthListener oAuthListener) {
        this.f4741c.remove(oAuthListener);
    }

    public final boolean stopAuth() {
        boolean a;
        Log.m4581i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
        try {
            a = this.f4742d == null ? true : this.f4742d.mo7687a();
        } catch (Exception e) {
            Log.m4583w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + e.getMessage());
            a = false;
        }
        this.f4742d = null;
        return a;
    }
}
