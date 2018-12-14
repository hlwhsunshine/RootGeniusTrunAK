package com.shuame.rootgenius.sdk.proto;

import android.content.Context;
import com.shuame.rootgenius.sdk.C1473h;
import com.shuame.rootgenius.sdk.CommUtils;
import com.shuame.rootgenius.sdk.proto.ProtoData.QuerySupportResult;

/* renamed from: com.shuame.rootgenius.sdk.proto.d */
public final class C1478d extends ProtoBase {
    /* renamed from: a */
    private QuerySupportResult f4076a = QuerySupportResult.Fail;

    /* JADX WARNING: Missing block: B:6:0x001f, code:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:7:0x0020, code:
            r0 = r2.next();
     */
    /* renamed from: a */
    private static com.shuame.rootgenius.sdk.proto.ProtoData.QuerySupportResult m4119a(java.lang.String r5) {
        /*
        r1 = com.shuame.rootgenius.sdk.proto.ProtoData.QuerySupportResult.Fail;
        r0 = org.xmlpull.v1.XmlPullParserFactory.newInstance();	 Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x004f }
        r2 = r0.newPullParser();	 Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x004f }
        r0 = new java.io.StringReader;	 Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x004f }
        r0.<init>(r5);	 Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x004f }
        r2.setInput(r0);	 Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x004f }
        r0 = r2.getEventType();	 Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x004f }
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0019:
        r3 = 1;
        if (r1 == r3) goto L_0x004e;
    L_0x001c:
        switch(r1) {
            case 2: goto L_0x0028;
            default: goto L_0x001f;
        };	 Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x004f }
    L_0x001f:
        r1 = r0;
    L_0x0020:
        r0 = r2.next();	 Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x004f }
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0019;
    L_0x0028:
        r1 = r2.getName();	 Catch:{ XmlPullParserException -> 0x0059, IOException -> 0x0057 }
        r3 = "support";
        r1 = r1.equals(r3);	 Catch:{ XmlPullParserException -> 0x0059, IOException -> 0x0057 }
        if (r1 == 0) goto L_0x001f;
    L_0x0034:
        r1 = r2.nextText();	 Catch:{ XmlPullParserException -> 0x0059, IOException -> 0x0057 }
        r3 = "true";
        r1 = r1.equals(r3);	 Catch:{ XmlPullParserException -> 0x0059, IOException -> 0x0057 }
        if (r1 == 0) goto L_0x0044;
    L_0x0040:
        r0 = com.shuame.rootgenius.sdk.proto.ProtoData.QuerySupportResult.Support;	 Catch:{ XmlPullParserException -> 0x0059, IOException -> 0x0057 }
    L_0x0042:
        r1 = r0;
        goto L_0x0020;
    L_0x0044:
        r0 = com.shuame.rootgenius.sdk.proto.ProtoData.QuerySupportResult.Unsupport;	 Catch:{ XmlPullParserException -> 0x0059, IOException -> 0x0057 }
        goto L_0x0042;
    L_0x0047:
        r0 = move-exception;
        r4 = r0;
        r0 = r1;
        r1 = r4;
    L_0x004b:
        r1.printStackTrace();
    L_0x004e:
        return r0;
    L_0x004f:
        r0 = move-exception;
        r4 = r0;
        r0 = r1;
        r1 = r4;
    L_0x0053:
        r1.printStackTrace();
        goto L_0x004e;
    L_0x0057:
        r1 = move-exception;
        goto L_0x0053;
    L_0x0059:
        r1 = move-exception;
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.sdk.proto.d.a(java.lang.String):com.shuame.rootgenius.sdk.proto.ProtoData$QuerySupportResult");
    }

    public final void OnResponse(int i, String str) {
        if (ProtoBase.isSuccess(i)) {
            this.f4076a = C1478d.m4119a(str);
        }
        C1473h.m4103b("QuerySupport", "support:" + this.f4076a);
    }

    /* renamed from: a */
    public final QuerySupportResult mo7292a(Context context) {
        postReq(C1476b.m4113a(CommUtils.parseRootingDev(context)));
        return this.f4076a;
    }

    public final String getServant() {
        return getServant(false, "/root/support");
    }
}
