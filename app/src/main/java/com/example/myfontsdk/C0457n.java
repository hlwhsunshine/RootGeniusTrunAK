package com.example.myfontsdk;

/* renamed from: com.example.myfontsdk.n */
final class C0457n extends Thread {
    /* renamed from: a */
    final /* synthetic */ MainActivity f1221a;

    C0457n(MainActivity mainActivity) {
        this.f1221a = mainActivity;
    }

    public final void run() {
        for (Font font : C0446c.m981a()) {
            font.getFontName();
            font.getDownloadUr();
        }
    }
}
