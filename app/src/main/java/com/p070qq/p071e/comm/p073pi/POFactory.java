package com.p070qq.p071e.comm.p073pi;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import com.p070qq.p071e.ads.banner.ADSize;
import com.p070qq.p071e.comm.adevent.ADListener;

/* renamed from: com.qq.e.comm.pi.POFactory */
public interface POFactory {
    GWI createGridAppWallView(Activity activity, String str, String str2);

    SVSD getAPKDownloadServiceDelegate(Service service);

    ACTD getActivityDelegate(String str, Activity activity);

    AWI getAppWallView(Context context, String str, String str2);

    BVI getBannerView(Activity activity, ADSize aDSize, String str, String str2);

    IADI getIADView(Activity activity, String str, String str2);

    NADI getNativeADDelegate(Context context, String str, String str2, ADListener aDListener);

    NSPVI getNativeSplashAdView(Context context, String str, String str2);

    NVADI getNativeVideoADDelegate(Context context, String str, String str2, ADListener aDListener);

    SPVI getSplashAdView(Context context, String str, String str2);
}
