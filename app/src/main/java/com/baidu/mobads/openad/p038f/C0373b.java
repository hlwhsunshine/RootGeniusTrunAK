package com.baidu.mobads.openad.p038f;

import java.util.TimerTask;

/* renamed from: com.baidu.mobads.openad.f.b */
class C0373b extends TimerTask {
    /* renamed from: a */
    final /* synthetic */ C0372a f808a;

    C0373b(C0372a c0372a) {
        this.f808a = c0372a;
    }

    public void run() {
        if (this.f808a.f807h.get() == 0) {
            if (this.f808a.f802b != null) {
                this.f808a.f805f = this.f808a.f803d - this.f808a.f804e;
                this.f808a.f802b.onTimer(this.f808a.f805f);
            }
            if (this.f808a.f804e > 0) {
                this.f808a.f804e = this.f808a.f804e - 1;
                return;
            }
            this.f808a.stop();
            if (this.f808a.f802b != null) {
                this.f808a.f802b.onTimerComplete();
            }
        }
    }
}
