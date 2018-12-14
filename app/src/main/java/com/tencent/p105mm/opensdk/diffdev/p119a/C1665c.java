package com.tencent.p105mm.opensdk.diffdev.p119a;

import com.tencent.p105mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.c */
final class C1665c implements Runnable {
    /* renamed from: g */
    final /* synthetic */ C1664b f4745g;

    C1665c(C1664b c1664b) {
        this.f4745g = c1664b;
    }

    public final void run() {
        List<OAuthListener> arrayList = new ArrayList();
        arrayList.addAll(this.f4745g.f4744f.f4741c);
        for (OAuthListener onQrcodeScanned : arrayList) {
            onQrcodeScanned.onQrcodeScanned();
        }
    }
}
