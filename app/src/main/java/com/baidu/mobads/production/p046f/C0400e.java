package com.baidu.mobads.production.p046f;

import android.os.CountDownTimer;

/* renamed from: com.baidu.mobads.production.f.e */
class C0400e extends CountDownTimer {
    /* renamed from: a */
    final /* synthetic */ C0397b f917a;

    C0400e(C0397b c0397b, long j, long j2) {
        this.f917a = c0397b;
        super(j, j2);
    }

    public void onFinish() {
        this.f917a.f912x.mo4921d("CountDownTimer finished");
        this.f917a.mo5219q();
        this.f917a.f817h.stop();
    }

    public void onTick(long j) {
        int i = 5;
        int i2 = (int) (j / 1000);
        if (i2 <= 5) {
            i = i2;
        }
        this.f917a.f914z.setText(String.valueOf(i));
    }
}
