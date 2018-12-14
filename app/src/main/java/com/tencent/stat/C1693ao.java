package com.tencent.stat;

/* renamed from: com.tencent.stat.ao */
class C1693ao implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1692an f4935a;

    C1693ao(C1692an c1692an) {
        this.f4935a = c1692an;
    }

    public void run() {
        try {
            if (StatServiceImpl.f4889v && StatServiceImpl.f4890w) {
                StatServiceImpl.f4889v = false;
                StatServiceImpl.f4884q.mo7904i("went background");
                for (StatActionListener onBecameBackground : StatServiceImpl.f4892y) {
                    onBecameBackground.onBecameBackground();
                }
                return;
            }
            StatServiceImpl.f4884q.mo7904i("still foreground");
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7900e(th);
        }
    }
}
