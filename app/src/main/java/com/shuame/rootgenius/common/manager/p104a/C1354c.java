package com.shuame.rootgenius.common.manager.p104a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.shuame.rootgenius.common.C1335e.C1332e;
import com.shuame.rootgenius.wxapi.WXEntryActivity;

/* renamed from: com.shuame.rootgenius.common.manager.a.c */
public class C1354c {
    /* renamed from: a */
    public static int f3704a = 1;
    /* renamed from: b */
    private static final String f3705b = C1354c.class.getSimpleName();
    /* renamed from: c */
    private C1350a f3706c;
    /* renamed from: d */
    private String f3707d;
    /* renamed from: e */
    private String f3708e;
    /* renamed from: f */
    private C1352a f3709f;
    /* renamed from: g */
    private final C1352a f3710g;

    /* renamed from: com.shuame.rootgenius.common.manager.a.c$a */
    public interface C1352a {
        void onFailed(int i);

        void onSuccess();
    }

    /* renamed from: com.shuame.rootgenius.common.manager.a.c$b */
    private static class C1353b {
        /* renamed from: a */
        private static final C1354c f3703a = new C1354c();
    }

    private C1354c() {
        this.f3710g = new C1355d(this);
    }

    /* synthetic */ C1354c(byte b) {
        this();
    }

    /* renamed from: a */
    public static C1354c m3794a() {
        return C1353b.f3703a;
    }

    /* renamed from: a */
    public final void mo7042a(Activity activity) {
        if (activity != null) {
            if (this.f3706c != null) {
                this.f3706c.mo7034a();
            }
            this.f3706c = new C1350a(activity, this.f3710g);
            if (this.f3706c.mo7037b()) {
                this.f3706c.mo7036a(this.f3707d, this.f3708e);
                return;
            }
            Toast.makeText(activity, activity.getString(C1332e.toast_wx_not_install), 1).show();
            this.f3706c.mo7034a();
            if (this.f3709f != null) {
                this.f3709f.onFailed(f3704a);
            }
            activity.finish();
        }
    }

    /* renamed from: a */
    public final void mo7043a(Context context, String str, String str2, C1352a c1352a) {
        if (context != null) {
            this.f3707d = str;
            this.f3708e = str2;
            this.f3709f = c1352a;
            new StringBuilder("launch wx mini , mini id = ").append(str).append(" , path = ").append(str2);
            Intent intent = new Intent(context, WXEntryActivity.class);
            intent.putExtra("key_wechat_activity_type", 1000);
            context.startActivity(intent);
        }
    }

    /* renamed from: a */
    public final void mo7044a(Intent intent) {
        if (this.f3706c != null) {
            this.f3706c.mo7035a(intent);
        }
    }
}
