package com.baidu.mobads.production.p044e;

import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: com.baidu.mobads.production.e.c */
class C0392c implements OnTouchListener {
    /* renamed from: a */
    int f890a;
    /* renamed from: b */
    int f891b;
    /* renamed from: c */
    int f892c;
    /* renamed from: d */
    int f893d;
    /* renamed from: e */
    final /* synthetic */ int f894e;
    /* renamed from: f */
    final /* synthetic */ int f895f;
    /* renamed from: g */
    final /* synthetic */ View f896g;
    /* renamed from: h */
    final /* synthetic */ int f897h;
    /* renamed from: i */
    final /* synthetic */ int f898i;
    /* renamed from: j */
    final /* synthetic */ C0391b f899j;

    C0392c(C0391b c0391b, int i, int i2, View view, int i3, int i4) {
        this.f899j = c0391b;
        this.f894e = i;
        this.f895f = i2;
        this.f896g = view;
        this.f897h = i3;
        this.f898i = i4;
    }

    public boolean onTouch(android.view.View r9, android.view.MotionEvent r10) {
        /*
        r8 = this;
        r1 = 0;
        r0 = r8.f899j;
        r3 = r0.f889z;
        r0 = r10.getAction();	 Catch:{ Exception -> 0x0026 }
        switch(r0) {
            case 0: goto L_0x000f;
            case 1: goto L_0x00d3;
            case 2: goto L_0x002f;
            default: goto L_0x000e;
        };	 Catch:{ Exception -> 0x0026 }
    L_0x000e:
        return r1;
    L_0x000f:
        r0 = r10.getRawX();	 Catch:{ Exception -> 0x0026 }
        r0 = (int) r0;	 Catch:{ Exception -> 0x0026 }
        r8.f890a = r0;	 Catch:{ Exception -> 0x0026 }
        r0 = r10.getRawY();	 Catch:{ Exception -> 0x0026 }
        r0 = (int) r0;	 Catch:{ Exception -> 0x0026 }
        r8.f891b = r0;	 Catch:{ Exception -> 0x0026 }
        r0 = r8.f890a;	 Catch:{ Exception -> 0x0026 }
        r8.f892c = r0;	 Catch:{ Exception -> 0x0026 }
        r0 = r8.f891b;	 Catch:{ Exception -> 0x0026 }
        r8.f893d = r0;	 Catch:{ Exception -> 0x0026 }
        goto L_0x000e;
    L_0x0026:
        r0 = move-exception;
        r2 = com.baidu.mobads.p021j.C0336j.m550a();
        r2.mo4928e(r0);
        goto L_0x000e;
    L_0x002f:
        r0 = r10.getRawX();	 Catch:{ Exception -> 0x0026 }
        r0 = (int) r0;	 Catch:{ Exception -> 0x0026 }
        r2 = r8.f890a;	 Catch:{ Exception -> 0x0026 }
        r2 = r0 - r2;
        r0 = r10.getRawY();	 Catch:{ Exception -> 0x0026 }
        r0 = (int) r0;	 Catch:{ Exception -> 0x0026 }
        r3 = r8.f891b;	 Catch:{ Exception -> 0x0026 }
        r5 = r0 - r3;
        r0 = r8.f899j;	 Catch:{ Exception -> 0x0026 }
        r0 = r0.f889z;	 Catch:{ Exception -> 0x0026 }
        r0 = r0.getLeft();	 Catch:{ Exception -> 0x0026 }
        r3 = r0 + r2;
        r0 = r8.f899j;	 Catch:{ Exception -> 0x0026 }
        r0 = r0.f889z;	 Catch:{ Exception -> 0x0026 }
        r0 = r0.getTop();	 Catch:{ Exception -> 0x0026 }
        r0 = r0 + r5;
        r4 = r8.f899j;	 Catch:{ Exception -> 0x0026 }
        r4 = r4.f889z;	 Catch:{ Exception -> 0x0026 }
        r4 = r4.getRight();	 Catch:{ Exception -> 0x0026 }
        r4 = r4 + r2;
        r2 = r8.f899j;	 Catch:{ Exception -> 0x0026 }
        r2 = r2.f889z;	 Catch:{ Exception -> 0x0026 }
        r2 = r2.getBottom();	 Catch:{ Exception -> 0x0026 }
        r2 = r2 + r5;
        if (r3 >= 0) goto L_0x007d;
    L_0x0070:
        r3 = r8.f899j;	 Catch:{ Exception -> 0x0026 }
        r3 = r3.f889z;	 Catch:{ Exception -> 0x0026 }
        r3 = r3.getWidth();	 Catch:{ Exception -> 0x0026 }
        r4 = r3 + 0;
        r3 = r1;
    L_0x007d:
        r5 = r8.f894e;	 Catch:{ Exception -> 0x0026 }
        if (r4 <= r5) goto L_0x008f;
    L_0x0081:
        r4 = r8.f894e;	 Catch:{ Exception -> 0x0026 }
        r3 = r8.f899j;	 Catch:{ Exception -> 0x0026 }
        r3 = r3.f889z;	 Catch:{ Exception -> 0x0026 }
        r3 = r3.getWidth();	 Catch:{ Exception -> 0x0026 }
        r3 = r4 - r3;
    L_0x008f:
        r5 = r8.f899j;	 Catch:{ Exception -> 0x0026 }
        r5 = r5.f883E;	 Catch:{ Exception -> 0x0026 }
        if (r0 >= r5) goto L_0x00a8;
    L_0x0097:
        r0 = r8.f899j;	 Catch:{ Exception -> 0x0026 }
        r0 = r0.f883E;	 Catch:{ Exception -> 0x0026 }
        r2 = r8.f899j;	 Catch:{ Exception -> 0x0026 }
        r2 = r2.f889z;	 Catch:{ Exception -> 0x0026 }
        r2 = r2.getHeight();	 Catch:{ Exception -> 0x0026 }
        r2 = r2 + r0;
    L_0x00a8:
        r5 = r8.f895f;	 Catch:{ Exception -> 0x0026 }
        if (r2 <= r5) goto L_0x00ba;
    L_0x00ac:
        r2 = r8.f895f;	 Catch:{ Exception -> 0x0026 }
        r0 = r8.f899j;	 Catch:{ Exception -> 0x0026 }
        r0 = r0.f889z;	 Catch:{ Exception -> 0x0026 }
        r0 = r0.getHeight();	 Catch:{ Exception -> 0x0026 }
        r0 = r2 - r0;
    L_0x00ba:
        r5 = r8.f899j;	 Catch:{ Exception -> 0x0026 }
        r5 = r5.f889z;	 Catch:{ Exception -> 0x0026 }
        r5.layout(r3, r0, r4, r2);	 Catch:{ Exception -> 0x0026 }
        r0 = r10.getRawX();	 Catch:{ Exception -> 0x0026 }
        r0 = (int) r0;	 Catch:{ Exception -> 0x0026 }
        r8.f890a = r0;	 Catch:{ Exception -> 0x0026 }
        r0 = r10.getRawY();	 Catch:{ Exception -> 0x0026 }
        r0 = (int) r0;	 Catch:{ Exception -> 0x0026 }
        r8.f891b = r0;	 Catch:{ Exception -> 0x0026 }
        goto L_0x000e;
    L_0x00d3:
        r0 = r8.f892c;	 Catch:{ Exception -> 0x0026 }
        r2 = r8.f890a;	 Catch:{ Exception -> 0x0026 }
        r0 = r0 - r2;
        r0 = java.lang.Math.abs(r0);	 Catch:{ Exception -> 0x0026 }
        r2 = 15;
        if (r0 >= r2) goto L_0x00e8;
    L_0x00e0:
        r0 = r8.f893d;	 Catch:{ Exception -> 0x0026 }
        r2 = r8.f891b;	 Catch:{ Exception -> 0x0026 }
        r0 = r0 - r2;
        java.lang.Math.abs(r0);	 Catch:{ Exception -> 0x0026 }
    L_0x00e8:
        r0 = r3.getLeft();	 Catch:{ Exception -> 0x0026 }
        r2 = r3.getWidth();	 Catch:{ Exception -> 0x0026 }
        r2 = r2 / 2;
        r0 = r0 + r2;
        r2 = r8.f894e;	 Catch:{ Exception -> 0x0026 }
        r2 = r2 / 2;
        if (r0 >= r2) goto L_0x0130;
    L_0x00f9:
        r0 = 1;
        r2 = r0;
    L_0x00fb:
        if (r2 == 0) goto L_0x0132;
    L_0x00fd:
        r0 = r1;
    L_0x00fe:
        r4 = new android.view.animation.TranslateAnimation;	 Catch:{ Exception -> 0x0026 }
        r5 = r3.getLeft();	 Catch:{ Exception -> 0x0026 }
        r5 = (float) r5;	 Catch:{ Exception -> 0x0026 }
        r0 = (float) r0;	 Catch:{ Exception -> 0x0026 }
        r6 = 0;
        r7 = 0;
        r4.<init>(r5, r0, r6, r7);	 Catch:{ Exception -> 0x0026 }
        r6 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r4.setDuration(r6);	 Catch:{ Exception -> 0x0026 }
        r0 = r8.f896g;	 Catch:{ Exception -> 0x0026 }
        r0.startAnimation(r4);	 Catch:{ Exception -> 0x0026 }
        r0 = new android.widget.RelativeLayout$LayoutParams;	 Catch:{ Exception -> 0x0026 }
        r4 = r8.f897h;	 Catch:{ Exception -> 0x0026 }
        r5 = r8.f898i;	 Catch:{ Exception -> 0x0026 }
        r0.<init>(r4, r5);	 Catch:{ Exception -> 0x0026 }
        if (r2 == 0) goto L_0x013a;
    L_0x0120:
        r2 = 0;
        r0.leftMargin = r2;	 Catch:{ Exception -> 0x0026 }
        r2 = r3.getTop();	 Catch:{ Exception -> 0x0026 }
        r0.topMargin = r2;	 Catch:{ Exception -> 0x0026 }
        r2 = r8.f896g;	 Catch:{ Exception -> 0x0026 }
        r2.setLayoutParams(r0);	 Catch:{ Exception -> 0x0026 }
        goto L_0x000e;
    L_0x0130:
        r2 = r1;
        goto L_0x00fb;
    L_0x0132:
        r0 = r8.f894e;	 Catch:{ Exception -> 0x0026 }
        r4 = r3.getWidth();	 Catch:{ Exception -> 0x0026 }
        r0 = r0 - r4;
        goto L_0x00fe;
    L_0x013a:
        r2 = 0;
        r0.rightMargin = r2;	 Catch:{ Exception -> 0x0026 }
        r2 = r3.getTop();	 Catch:{ Exception -> 0x0026 }
        r0.topMargin = r2;	 Catch:{ Exception -> 0x0026 }
        r2 = r8.f896g;	 Catch:{ Exception -> 0x0026 }
        r2.setLayoutParams(r0);	 Catch:{ Exception -> 0x0026 }
        r2 = new android.os.Handler;	 Catch:{ Exception -> 0x0026 }
        r2.<init>();	 Catch:{ Exception -> 0x0026 }
        r4 = new com.baidu.mobads.production.e.d;	 Catch:{ Exception -> 0x0026 }
        r4.<init>(r8, r0, r3);	 Catch:{ Exception -> 0x0026 }
        r6 = 501; // 0x1f5 float:7.02E-43 double:2.475E-321;
        r2.postDelayed(r4, r6);	 Catch:{ Exception -> 0x0026 }
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.production.e.c.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
