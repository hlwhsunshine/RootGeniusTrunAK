package com.baidu.mobads.command.p026a;

import android.content.Context;
import com.baidu.mobads.command.C0269b;
import com.baidu.mobads.command.C0271a;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.production.C0375a;
import java.io.File;

/* renamed from: com.baidu.mobads.command.a.a */
public class C0270a extends C0269b {
    public C0270a(IXNonLinearAdSlot iXNonLinearAdSlot, IXAdInstanceInfo iXAdInstanceInfo, IXAdResource iXAdResource) {
        super(iXNonLinearAdSlot, iXAdInstanceInfo, iXAdResource);
    }

    /* renamed from: a */
    public static IXAppInfo m354a(C0271a c0271a) {
        if (c0271a == null) {
            return null;
        }
        IXAdContainerFactory b = C0375a.m682b();
        if (b == null) {
            return null;
        }
        IXAppInfo createAppInfo = b.createAppInfo();
        createAppInfo.setAdId(c0271a.mo4420g());
        createAppInfo.setAppSize(c0271a.mo4418e());
        createAppInfo.setClickTime(c0271a.mo4416c());
        createAppInfo.setPackageName(c0271a.mo4417d());
        createAppInfo.setQk(c0271a.mo4421h());
        createAppInfo.setProd(c0271a.mo4422i());
        createAppInfo.setTooLarge(c0271a.mo4419f());
        return createAppInfo;
    }

    /* renamed from: b */
    private void m355b(C0271a c0271a) {
        if (C0375a.m682b() != null) {
            IXAppInfo a = C0270a.m354a(c0271a);
            if (a != null) {
                C0375a.m682b().getXMonitorActivation(this.f458a, this.f462e).addAppInfoForMonitor(a);
            } else {
                this.f462e.mo4926e("addAppInfoForMonitor error, appInfo is null");
            }
        }
    }

    /* renamed from: b */
    private boolean m356b() {
        return C0338m.m569a().mo5039l().isInstalled(this.f458a, this.f460c.getAppPackageName());
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x02a6 A:{Catch:{ Exception -> 0x00c9 }} */
    /* renamed from: a */
    public void mo4406a() {
        /*
        r15 = this;
        r8 = 1;
        r1 = 0;
        r0 = com.baidu.mobads.p021j.C0338m.m569a();
        r4 = r0.mo5040m();
        r0 = com.baidu.mobads.p021j.C0338m.m569a();
        r5 = r0.mo5038k();
        r0 = com.baidu.mobads.p021j.C0338m.m569a();
        r6 = r0.mo5036i();
        r0 = com.baidu.mobads.p021j.C0338m.m569a();
        r9 = r0.mo5041n();
        r0 = r15.f459b;
        r0 = r0.getCurrentXAdContainer();
        r10 = r0.getAdContainerContext();
        r0 = 0;
        r2 = r15.f460c;	 Catch:{ Exception -> 0x00c9 }
        r2 = r2.getAppPackageName();	 Catch:{ Exception -> 0x00c9 }
        r3 = r15.f462e;	 Catch:{ Exception -> 0x00c9 }
        r7 = "XAdDownloadAPKCommand";
        r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c9 }
        r12 = "download pkg = ";
        r11.<init>(r12);	 Catch:{ Exception -> 0x00c9 }
        r11 = r11.append(r2);	 Catch:{ Exception -> 0x00c9 }
        r11 = r11.toString();	 Catch:{ Exception -> 0x00c9 }
        r3.mo4931i(r7, r11);	 Catch:{ Exception -> 0x00c9 }
        if (r2 == 0) goto L_0x0053;
    L_0x004b:
        r3 = "";
        r3 = r2.equals(r3);	 Catch:{ Exception -> 0x00c9 }
        if (r3 == 0) goto L_0x02cd;
    L_0x0053:
        r2 = r15.f462e;	 Catch:{ Exception -> 0x00c9 }
        r3 = "XAdDownloadAPKCommand";
        r7 = "start to download but package is empty";
        r2.mo4931i(r3, r7);	 Catch:{ Exception -> 0x00c9 }
        r2 = r15.f460c;	 Catch:{ Exception -> 0x00c9 }
        r2 = r2.getOriginClickUrl();	 Catch:{ Exception -> 0x00c9 }
        r2 = r4.getMD5(r2);	 Catch:{ Exception -> 0x00c9 }
        r3 = r2;
    L_0x0067:
        r2 = r15.f458a;	 Catch:{ Exception -> 0x00c9 }
        r2 = com.baidu.mobads.openad.p029c.C0361d.m637a(r2);	 Catch:{ Exception -> 0x00c9 }
        r2 = r2.getAdsApkDownloader(r3);	 Catch:{ Exception -> 0x00c9 }
        r7 = com.baidu.mobads.openad.p029c.C0359b.m626a(r3);	 Catch:{ Exception -> 0x00c9 }
        if (r7 == 0) goto L_0x014c;
    L_0x0077:
        if (r2 == 0) goto L_0x014c;
    L_0x0079:
        r0 = r7.mo5083a();	 Catch:{ Exception -> 0x00c9 }
        r7 = r2.getState();	 Catch:{ Exception -> 0x00c9 }
        r11 = r15.f462e;	 Catch:{ Exception -> 0x00c9 }
        r12 = "XAdDownloadAPKCommand";
        r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c9 }
        r14 = "startDownload>> downloader exist: state=";
        r13.<init>(r14);	 Catch:{ Exception -> 0x00c9 }
        r13 = r13.append(r7);	 Catch:{ Exception -> 0x00c9 }
        r13 = r13.toString();	 Catch:{ Exception -> 0x00c9 }
        r11.mo4922d(r12, r13);	 Catch:{ Exception -> 0x00c9 }
        r11 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.CANCELLED;	 Catch:{ Exception -> 0x00c9 }
        if (r7 == r11) goto L_0x00a3;
    L_0x009b:
        r11 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ Exception -> 0x00c9 }
        if (r7 == r11) goto L_0x00a3;
    L_0x009f:
        r11 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.PAUSED;	 Catch:{ Exception -> 0x00c9 }
        if (r7 != r11) goto L_0x00b0;
    L_0x00a3:
        r2.resume();	 Catch:{ Exception -> 0x00c9 }
        r0 = r15.f460c;	 Catch:{ Exception -> 0x00c9 }
        r0 = r0.getClickThroughUrl();	 Catch:{ Exception -> 0x00c9 }
        r6.pintHttpInNewThread(r0);	 Catch:{ Exception -> 0x00c9 }
    L_0x00af:
        return;
    L_0x00b0:
        r11 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.COMPLETED;	 Catch:{ Exception -> 0x00c9 }
        if (r7 != r11) goto L_0x0119;
    L_0x00b4:
        r7 = r15.f458a;	 Catch:{ Exception -> 0x00c9 }
        r7 = r15.mo4407a(r7, r0);	 Catch:{ Exception -> 0x00c9 }
        if (r7 == 0) goto L_0x00ec;
    L_0x00bc:
        r1 = r15.f460c;	 Catch:{ Exception -> 0x00c9 }
        r1 = r1.getClickThroughUrl();	 Catch:{ Exception -> 0x00c9 }
        r6.pintHttpInNewThread(r1);	 Catch:{ Exception -> 0x00c9 }
        r15.m355b(r0);	 Catch:{ Exception -> 0x00c9 }
        goto L_0x00af;
    L_0x00c9:
        r0 = move-exception;
        r1 = r15.f462e;
        r2 = "XAdDownloadAPKCommand";
        r1.mo4927e(r2, r0);
        r1 = com.baidu.mobads.p025c.C0265a.m334a();
        r2 = new java.lang.StringBuilder;
        r3 = "ad app download failed: ";
        r2.<init>(r3);
        r0 = r0.toString();
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.mo4397a(r0);
        goto L_0x00af;
    L_0x00ec:
        r2.cancel();	 Catch:{ Exception -> 0x00c9 }
        r2.removeObservers();	 Catch:{ Exception -> 0x00c9 }
        com.baidu.mobads.openad.p029c.C0359b.m630b(r3);	 Catch:{ Exception -> 0x00c9 }
        r2 = r15.f458a;	 Catch:{ Exception -> 0x00c9 }
        r2 = com.baidu.mobads.openad.p029c.C0361d.m637a(r2);	 Catch:{ Exception -> 0x00c9 }
        r2.removeAdsApkDownloader(r3);	 Catch:{ Exception -> 0x00c9 }
        r2 = r0;
    L_0x00ff:
        r0 = r15.f458a;	 Catch:{ Exception -> 0x00c9 }
        r0 = com.baidu.mobads.command.C0271a.m359a(r0, r3);	 Catch:{ Exception -> 0x00c9 }
        if (r0 == 0) goto L_0x01f5;
    L_0x0107:
        r1 = r0.f470g;	 Catch:{ Exception -> 0x00c9 }
        r2 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.COMPLETED;	 Catch:{ Exception -> 0x00c9 }
        if (r1 != r2) goto L_0x0162;
    L_0x010d:
        r1 = r15.f458a;	 Catch:{ Exception -> 0x00c9 }
        r1 = r15.mo4407a(r1, r0);	 Catch:{ Exception -> 0x00c9 }
        if (r1 == 0) goto L_0x0162;
    L_0x0115:
        r15.m355b(r0);	 Catch:{ Exception -> 0x00c9 }
        goto L_0x00af;
    L_0x0119:
        r11 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.DOWNLOADING;	 Catch:{ Exception -> 0x00c9 }
        if (r7 == r11) goto L_0x0121;
    L_0x011d:
        r11 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.INITING;	 Catch:{ Exception -> 0x00c9 }
        if (r7 != r11) goto L_0x014a;
    L_0x0121:
        r0 = r15.f458a;	 Catch:{ Exception -> 0x00c9 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c9 }
        r1.<init>();	 Catch:{ Exception -> 0x00c9 }
        r3 = r2.getTitle();	 Catch:{ Exception -> 0x00c9 }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x00c9 }
        r2 = r2.getState();	 Catch:{ Exception -> 0x00c9 }
        r2 = r2.getMessage();	 Catch:{ Exception -> 0x00c9 }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00c9 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00c9 }
        r2 = 0;
        r0 = android.widget.Toast.makeText(r0, r1, r2);	 Catch:{ Exception -> 0x00c9 }
        r0.show();	 Catch:{ Exception -> 0x00c9 }
        goto L_0x00af;
    L_0x014a:
        r2 = r0;
        goto L_0x00ff;
    L_0x014c:
        if (r2 == 0) goto L_0x0154;
    L_0x014e:
        r2.cancel();	 Catch:{ Exception -> 0x00c9 }
        r2.removeObservers();	 Catch:{ Exception -> 0x00c9 }
    L_0x0154:
        com.baidu.mobads.openad.p029c.C0359b.m630b(r3);	 Catch:{ Exception -> 0x00c9 }
        r2 = r15.f458a;	 Catch:{ Exception -> 0x00c9 }
        r2 = com.baidu.mobads.openad.p029c.C0361d.m637a(r2);	 Catch:{ Exception -> 0x00c9 }
        r2.removeAdsApkDownloader(r3);	 Catch:{ Exception -> 0x00c9 }
        r2 = r0;
        goto L_0x00ff;
    L_0x0162:
        r1 = r15.f460c;	 Catch:{ Exception -> 0x00c9 }
        r1 = r1.getClickThroughUrl();	 Catch:{ Exception -> 0x00c9 }
        r6.pintHttpInNewThread(r1);	 Catch:{ Exception -> 0x00c9 }
        r7 = r0;
    L_0x016c:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00c9 }
        r7.f482s = r0;	 Catch:{ Exception -> 0x00c9 }
        r0 = r15.f458a;	 Catch:{ Exception -> 0x00c9 }
        r0 = r10.getDownloaderManager(r0);	 Catch:{ Exception -> 0x00c9 }
        r1 = new java.net.URL;	 Catch:{ Exception -> 0x00c9 }
        r2 = r7.f473j;	 Catch:{ Exception -> 0x00c9 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x00c9 }
        r2 = r7.f466c;	 Catch:{ Exception -> 0x00c9 }
        r3 = r7.f465b;	 Catch:{ Exception -> 0x00c9 }
        r4 = 3;
        r5 = r7.f464a;	 Catch:{ Exception -> 0x00c9 }
        r6 = r7.f472i;	 Catch:{ Exception -> 0x00c9 }
        r0 = r0.createAdsApkDownloader(r1, r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x00c9 }
        r1 = r15.f460c;	 Catch:{ Exception -> 0x00c9 }
        r1 = r1.getAPOOpen();	 Catch:{ Exception -> 0x00c9 }
        if (r1 != r8) goto L_0x01b5;
    L_0x0194:
        r1 = r15.f460c;	 Catch:{ Exception -> 0x00c9 }
        r1 = r1.getPage();	 Catch:{ Exception -> 0x00c9 }
        if (r1 == 0) goto L_0x01b5;
    L_0x019c:
        r1 = r15.f460c;	 Catch:{ Exception -> 0x00c9 }
        r1 = r1.getPage();	 Catch:{ Exception -> 0x00c9 }
        r2 = "";
        r1 = r1.equals(r2);	 Catch:{ Exception -> 0x00c9 }
        if (r1 != 0) goto L_0x01b5;
    L_0x01aa:
        r1 = 1;
        r7.f485v = r1;	 Catch:{ Exception -> 0x00c9 }
        r1 = r15.f460c;	 Catch:{ Exception -> 0x00c9 }
        r1 = r1.getPage();	 Catch:{ Exception -> 0x00c9 }
        r7.f486w = r1;	 Catch:{ Exception -> 0x00c9 }
    L_0x01b5:
        r1 = new com.baidu.mobads.openad.c.b;	 Catch:{ Exception -> 0x00c9 }
        r2 = r15.f458a;	 Catch:{ Exception -> 0x00c9 }
        r1.<init>(r2, r7);	 Catch:{ Exception -> 0x00c9 }
        r0.addObserver(r1);	 Catch:{ Exception -> 0x00c9 }
        r1 = r7.f481r;	 Catch:{ Exception -> 0x00c9 }
        if (r1 != 0) goto L_0x02c5;
    L_0x01c3:
        r1 = r15.f458a;	 Catch:{ Exception -> 0x00c9 }
        r1 = r9.is3GConnected(r1);	 Catch:{ Exception -> 0x00c9 }
        r1 = r1.booleanValue();	 Catch:{ Exception -> 0x00c9 }
        if (r1 == 0) goto L_0x02c5;
    L_0x01cf:
        r0.pause();	 Catch:{ Exception -> 0x00c9 }
        r1 = r15.f458a;	 Catch:{ Exception -> 0x00c9 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c9 }
        r2.<init>();	 Catch:{ Exception -> 0x00c9 }
        r0 = r0.getTitle();	 Catch:{ Exception -> 0x00c9 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x00c9 }
        r2 = " 将在连入Wifi后开始下载";
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x00c9 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00c9 }
        r2 = 0;
        r0 = android.widget.Toast.makeText(r1, r0, r2);	 Catch:{ Exception -> 0x00c9 }
        r0.show();	 Catch:{ Exception -> 0x00c9 }
        goto L_0x00af;
    L_0x01f5:
        r0 = r15.m356b();	 Catch:{ Exception -> 0x00c9 }
        if (r0 == 0) goto L_0x021c;
    L_0x01fb:
        r0 = com.baidu.mobads.p021j.C0338m.m569a();	 Catch:{ Exception -> 0x00c9 }
        r0 = r0.mo5039l();	 Catch:{ Exception -> 0x00c9 }
        r1 = r15.f458a;	 Catch:{ Exception -> 0x00c9 }
        r3 = r15.f460c;	 Catch:{ Exception -> 0x00c9 }
        r3 = r3.getAppPackageName();	 Catch:{ Exception -> 0x00c9 }
        r0.openApp(r1, r3);	 Catch:{ Exception -> 0x00c9 }
        r0 = r15.f460c;	 Catch:{ Exception -> 0x00c9 }
        r0 = r0.getClickThroughUrl();	 Catch:{ Exception -> 0x00c9 }
        r6.pintHttpInNewThread(r0);	 Catch:{ Exception -> 0x00c9 }
        r15.m355b(r2);	 Catch:{ Exception -> 0x00c9 }
        goto L_0x00af;
    L_0x021c:
        r0 = r15.f460c;	 Catch:{ Exception -> 0x00c9 }
        r0 = r0.getAppName();	 Catch:{ Exception -> 0x00c9 }
        if (r0 == 0) goto L_0x022c;
    L_0x0224:
        r2 = "";
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x00c9 }
        if (r2 == 0) goto L_0x02ca;
    L_0x022c:
        r0 = r15.f460c;	 Catch:{ Exception -> 0x00c9 }
        r0 = r0.getTitle();	 Catch:{ Exception -> 0x00c9 }
        if (r0 == 0) goto L_0x023c;
    L_0x0234:
        r2 = "";
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x00c9 }
        if (r2 == 0) goto L_0x02ca;
    L_0x023c:
        r0 = "您点击的应用";
        r2 = r0;
    L_0x023f:
        r0 = new com.baidu.mobads.command.a;	 Catch:{ Exception -> 0x00c9 }
        r0.<init>(r3, r2);	 Catch:{ Exception -> 0x00c9 }
        r2 = r15.f460c;	 Catch:{ Exception -> 0x00c9 }
        r2 = r2.getQueryKey();	 Catch:{ Exception -> 0x00c9 }
        r6 = r15.f460c;	 Catch:{ Exception -> 0x00c9 }
        r6 = r6.getAdId();	 Catch:{ Exception -> 0x00c9 }
        r7 = r15.f460c;	 Catch:{ Exception -> 0x00c9 }
        r7 = r7.getClickThroughUrl();	 Catch:{ Exception -> 0x00c9 }
        r11 = r15.f460c;	 Catch:{ Exception -> 0x00c9 }
        r11 = r11.isAutoOpen();	 Catch:{ Exception -> 0x00c9 }
        r0.mo4412a(r2, r6, r7, r11);	 Catch:{ Exception -> 0x00c9 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c9 }
        r2.<init>();	 Catch:{ Exception -> 0x00c9 }
        r6 = r0.f473j;	 Catch:{ Exception -> 0x00c9 }
        r4 = r4.getMD5(r6);	 Catch:{ Exception -> 0x00c9 }
        r2 = r2.append(r4);	 Catch:{ Exception -> 0x00c9 }
        r4 = ".apk";
        r2 = r2.append(r4);	 Catch:{ Exception -> 0x00c9 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00c9 }
        r4 = r15.f458a;	 Catch:{ Exception -> 0x00c9 }
        r4 = r5.getStoreagePath(r4);	 Catch:{ Exception -> 0x00c9 }
        r0.mo4411a(r2, r4);	 Catch:{ Exception -> 0x00c9 }
        r2 = r15.f459b;	 Catch:{ Exception -> 0x00c9 }
        r2 = r2.getAdRequestInfo();	 Catch:{ Exception -> 0x00c9 }
        r2 = r2.getApid();	 Catch:{ Exception -> 0x00c9 }
        r4 = r15.f459b;	 Catch:{ Exception -> 0x00c9 }
        r4 = r4.getProdInfo();	 Catch:{ Exception -> 0x00c9 }
        r4 = r4.getProdType();	 Catch:{ Exception -> 0x00c9 }
        r0.mo4415b(r2, r4);	 Catch:{ Exception -> 0x00c9 }
        r2 = com.baidu.mobads.openad.p029c.C0359b.m631c(r3);	 Catch:{ Exception -> 0x00c9 }
        r0.f469f = r2;	 Catch:{ Exception -> 0x00c9 }
        r2 = r15.f460c;	 Catch:{ Exception -> 0x00c9 }
        r2 = r2.isActionOnlyWifi();	 Catch:{ Exception -> 0x00c9 }
        if (r2 != 0) goto L_0x02a7;
    L_0x02a6:
        r1 = r8;
    L_0x02a7:
        r0.f481r = r1;	 Catch:{ Exception -> 0x00c9 }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00c9 }
        r0.mo4409a(r2);	 Catch:{ Exception -> 0x00c9 }
        r1 = r15.f460c;	 Catch:{ Exception -> 0x00c9 }
        r2 = r1.getAppSize();	 Catch:{ Exception -> 0x00c9 }
        r0.mo4414b(r2);	 Catch:{ Exception -> 0x00c9 }
        r1 = r15.f460c;	 Catch:{ Exception -> 0x00c9 }
        r1 = r1.isTooLarge();	 Catch:{ Exception -> 0x00c9 }
        r0.mo4413a(r1);	 Catch:{ Exception -> 0x00c9 }
        r7 = r0;
        goto L_0x016c;
    L_0x02c5:
        r0.start();	 Catch:{ Exception -> 0x00c9 }
        goto L_0x00af;
    L_0x02ca:
        r2 = r0;
        goto L_0x023f;
    L_0x02cd:
        r3 = r2;
        goto L_0x0067;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.command.a.a.a():void");
    }

    /* renamed from: a */
    protected boolean mo4407a(Context context, C0271a c0271a) {
        if (C0338m.m569a().mo5039l().isInstalled(context, c0271a.f472i)) {
            C0338m.m569a().mo5039l().openApp(context, c0271a.f472i);
            return true;
        }
        String str = c0271a.f466c + c0271a.f465b;
        File file = new File(str);
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        context.startActivity(C0338m.m569a().mo5039l().getInstallIntent(str));
        return true;
    }
}
