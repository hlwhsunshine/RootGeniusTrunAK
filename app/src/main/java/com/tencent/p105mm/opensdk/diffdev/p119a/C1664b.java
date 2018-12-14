package com.tencent.p105mm.opensdk.diffdev.p119a;

import com.tencent.p105mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.p105mm.opensdk.diffdev.OAuthListener;
import com.tencent.p105mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.b */
final class C1664b implements OAuthListener {
    /* renamed from: f */
    final /* synthetic */ C1663a f4744f;

    C1664b(C1663a c1663a) {
        this.f4744f = c1663a;
    }

    public final void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
        Log.m4579d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", new Object[]{oAuthErrCode.toString(), str}));
        this.f4744f.f4742d = null;
        List<OAuthListener> arrayList = new ArrayList();
        arrayList.addAll(this.f4744f.f4741c);
        for (OAuthListener onAuthFinish : arrayList) {
            onAuthFinish.onAuthFinish(oAuthErrCode, str);
        }
    }

    public final void onAuthGotQrcode(String str, byte[] bArr) {
        Log.m4579d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = " + str);
        List<OAuthListener> arrayList = new ArrayList();
        arrayList.addAll(this.f4744f.f4741c);
        for (OAuthListener onAuthGotQrcode : arrayList) {
            onAuthGotQrcode.onAuthGotQrcode(str, bArr);
        }
    }

    public final void onQrcodeScanned() {
        Log.m4579d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
        if (this.f4744f.handler != null) {
            this.f4744f.handler.post(new C1665c(this));
        }
    }
}
