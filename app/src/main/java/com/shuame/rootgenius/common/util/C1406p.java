package com.shuame.rootgenius.common.util;

import android.content.Intent;
import android.text.TextUtils;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.C1325c;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type;
import com.shuame.rootgenius.sdk.RootGenius;
import com.shuame.rootgenius.sdk.proto.ProtoData.Asset;
import com.shuame.rootgenius.sdk.proto.ProtoData.DeviceSolution;

/* renamed from: com.shuame.rootgenius.common.util.p */
public class C1406p {
    /* renamed from: a */
    private static final String f3890a = C1406p.class.getSimpleName();
    /* renamed from: b */
    private static boolean f3891b = false;

    /* renamed from: a */
    public static String m3910a(boolean z) {
        Exception e;
        C1323b.m3688a();
        String l = C1323b.m3707l();
        if (!f3891b) {
            f3891b = true;
            if ((!C1323b.m3698d() || TextUtils.isEmpty(l)) && (z || TextUtils.isEmpty(l))) {
                try {
                    DeviceSolution preQueryRoot = RootGenius.preQueryRoot();
                    if (preQueryRoot != null) {
                        String str;
                        if (!TextUtils.isEmpty(preQueryRoot.productId)) {
                            str = preQueryRoot.productId;
                            try {
                                C1323b.m3688a();
                                C1323b.m3689a(str);
                                l = str;
                            } catch (Exception e2) {
                                Exception exception = e2;
                                l = str;
                                e = exception;
                                e.printStackTrace();
                                f3891b = false;
                                return l;
                            }
                        }
                        if (!TextUtils.isEmpty(preQueryRoot.productName)) {
                            str = preQueryRoot.productName;
                            C1323b.m3688a();
                            C1323b.m3691b(str);
                        }
                        Asset asset = preQueryRoot.f4066su;
                        String str2 = preQueryRoot.suPath;
                        new StringBuilder("before scan,isSupport:").append(C1323b.m3712q());
                        C1323b.m3699e(preQueryRoot.support);
                        new StringBuilder("after scan,isSupport:").append(C1323b.m3712q());
                        if (C1323b.m3712q()) {
                            if (z) {
                                C1406p.m3911a(asset, str2);
                            }
                        } else if (!C1323b.m3698d()) {
                            C1325c.m3724a().sendBroadcast(new Intent(C1340e.f3638i));
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    f3891b = false;
                    return l;
                }
                f3891b = false;
            }
        }
        return l;
    }

    /* renamed from: a */
    private static void m3911a(Asset asset, String str) {
        if (NetworkUtils.m3854d()) {
            int i = 0;
            while (!C1323b.m3695c()) {
                try {
                    i += 1000;
                    if (i > 20000) {
                        break;
                    }
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (!C1323b.m3698d() && asset != null && !TextUtils.isEmpty(asset.url) && !TextUtils.isEmpty(asset.md5) && !TextUtils.isEmpty(str)) {
                int a = C1361b.m3815a(asset.url);
                QQDownloadFile a2 = C1361b.m3817a().mo7068a(a);
                if (a2 == null) {
                    a2 = new QQDownloadFile();
                    a2.f3722c = a;
                    a2.f3724e = asset.url;
                    a2.f3727h = (long) asset.size;
                    a2.f3726g = asset.md5;
                    a2.f3734o = Type.ROM;
                    a2.f3725f = str;
                }
                C1361b.m3817a().mo7067a(a2, null);
            }
        }
    }
}
