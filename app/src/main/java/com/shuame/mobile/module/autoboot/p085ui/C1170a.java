package com.shuame.mobile.module.autoboot.p085ui;

import android.os.Handler;
import android.os.Message;
import com.shuame.mobile.module.autoboot.p081b.C1155a;

/* renamed from: com.shuame.mobile.module.autoboot.ui.a */
final class C1170a extends Handler {
    /* renamed from: a */
    final /* synthetic */ AutoBootManagerActivity f3117a;

    C1170a(AutoBootManagerActivity autoBootManagerActivity) {
        this.f3117a = autoBootManagerActivity;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 16:
                int i = message.arg1;
                this.f3117a.f3084f.setCheckProgress(i);
                if (i == 100) {
                    C1155a.m3315a().mo6760b(this.f3117a.f3096r);
                    this.f3117a.f3095q.postDelayed(new C1171b(this), 200);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
