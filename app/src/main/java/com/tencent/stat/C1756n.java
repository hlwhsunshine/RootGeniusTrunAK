package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.event.C1742g;

/* renamed from: com.tencent.stat.n */
final class C1756n implements Runnable {
    /* renamed from: a */
    final /* synthetic */ StatGameUser f5160a;
    /* renamed from: b */
    final /* synthetic */ Context f5161b;
    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f5162c;

    C1756n(StatGameUser statGameUser, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5160a = statGameUser;
        this.f5161b = context;
        this.f5162c = statSpecifyReportedInfo;
    }

    public final void run() {
        if (this.f5160a == null) {
            StatServiceImpl.f4884q.error((Object) "The gameUser of StatService.reportGameUser() can not be null!");
        } else if (this.f5160a.getAccount() == null || this.f5160a.getAccount().length() == 0) {
            StatServiceImpl.f4884q.error((Object) "The account of gameUser on StatService.reportGameUser() can not be null or empty!");
        } else {
            try {
                new C1700av(new C1742g(this.f5161b, StatServiceImpl.m4619a(this.f5161b, false, this.f5162c), this.f5160a, this.f5162c)).mo7867a();
            } catch (Throwable th) {
                StatServiceImpl.f4884q.mo7900e(th);
                StatServiceImpl.m4629a(this.f5161b, th);
            }
        }
    }
}
