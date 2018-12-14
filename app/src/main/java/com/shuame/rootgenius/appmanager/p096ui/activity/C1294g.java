package com.shuame.rootgenius.appmanager.p096ui.activity;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.shuame.rootgenius.appmanager.p091b.C1259d;
import com.shuame.rootgenius.appmanager.p095f.C1272b.C1271a;

/* renamed from: com.shuame.rootgenius.appmanager.ui.activity.g */
final class C1294g extends Handler {
    /* renamed from: a */
    final /* synthetic */ RecycleBinActivity f3517a;

    C1294g(RecycleBinActivity recycleBinActivity) {
        this.f3517a = recycleBinActivity;
    }

    public final void handleMessage(Message message) {
        if (message.what == 3) {
            this.f3517a.f3507j = (C1271a) message.obj;
            this.f3517a.f3508k = this.f3517a.f3507j.f3409e;
            new StringBuilder("CommandResult: ").append(this.f3517a.f3507j.f3405a);
            new StringBuilder("CommandResultSuccess: ").append(this.f3517a.f3507j.f3407c);
            new StringBuilder("CommandResultError: ").append(this.f3517a.f3507j.f3408d);
            if (this.f3517a.f3507j.f3406b != 0) {
                this.f3517a.f3504g = C1259d.m3554a(this.f3517a.f3498a);
                this.f3517a.f3504g.mo6899a(this.f3517a.f3508k);
                Toast.makeText(this.f3517a.f3498a, "还原应用\"" + this.f3517a.f3508k.f3339c + "\"失败", 0).show();
                if (this.f3517a.f3503f.isEmpty()) {
                    this.f3517a.f3500c.setVisibility(8);
                    this.f3517a.f3501d.setVisibility(0);
                } else {
                    this.f3517a.f3500c.setVisibility(0);
                    this.f3517a.f3501d.setVisibility(8);
                }
                this.f3517a.f3504g.mo6897a();
                C1259d.f3365g = Boolean.valueOf(false);
            }
        }
    }
}
