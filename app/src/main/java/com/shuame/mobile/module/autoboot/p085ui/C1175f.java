package com.shuame.mobile.module.autoboot.p085ui;

import android.os.Message;
import com.shuame.mobile.module.autoboot.p081b.C1155a.C1153b;

/* renamed from: com.shuame.mobile.module.autoboot.ui.f */
final class C1175f implements C1153b {
    /* renamed from: a */
    final /* synthetic */ AutoBootManagerActivity f3122a;

    C1175f(AutoBootManagerActivity autoBootManagerActivity) {
        this.f3122a = autoBootManagerActivity;
    }

    /* renamed from: a */
    public final void mo6747a(int i, boolean z) {
        AutoBootManagerActivity.f3079a;
        new StringBuilder("progress:").append(i).append(" delay:").append(z);
        Message obtainMessage = this.f3122a.f3095q.obtainMessage(16);
        obtainMessage.arg1 = i;
        if (z) {
            this.f3122a.f3095q.sendMessageDelayed(obtainMessage, 800);
        } else {
            this.f3122a.f3095q.sendMessage(obtainMessage);
        }
    }
}
