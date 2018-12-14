package com.baidu.mobad.feeds;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobad.feeds.NativeResponse.MaterialType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.p021j.C0338m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public class XAdNativeResponse implements NativeResponse {
    /* renamed from: a */
    private IXAdInstanceInfo f235a;
    /* renamed from: b */
    private BaiduNative f236b;
    /* renamed from: c */
    private boolean f237c = false;
    /* renamed from: d */
    private IXAdFeedsRequestParameters f238d;
    /* renamed from: e */
    private IXAdContainer f239e;

    /* renamed from: com.baidu.mobad.feeds.XAdNativeResponse$2 */
    class C02282 implements OnClickListener {
        C02282() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public XAdNativeResponse(IXAdInstanceInfo iXAdInstanceInfo, BaiduNative baiduNative, IXAdFeedsRequestParameters iXAdFeedsRequestParameters, IXAdContainer iXAdContainer) {
        this.f235a = iXAdInstanceInfo;
        this.f236b = baiduNative;
        this.f239e = iXAdContainer;
        if (this.f235a.getActionType() == C0338m.m569a().mo5043p().getActTypeDownload()) {
            this.f237c = true;
        }
        this.f238d = iXAdFeedsRequestParameters;
    }

    /* renamed from: a */
    private void m258a(Context context) {
        if (C0338m.m569a().mo5041n().is3GConnected(context).booleanValue()) {
            this.f235a.setActionOnlyWifi(false);
        } else {
            this.f235a.setActionOnlyWifi(true);
        }
    }

    /* renamed from: a */
    private void m259a(final View view, final int i) {
        final Context context = view.getContext();
        Builder builder = new Builder(context);
        builder.setMessage("确认下载\"" + getTitle() + "\"?");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                XAdNativeResponse.this.m258a(context);
                XAdNativeResponse.this.f236b.handleClick(view, XAdNativeResponse.this.f235a, i, XAdNativeResponse.this.f238d);
            }
        });
        builder.setNegativeButton("取消", new C02282());
        builder.create().show();
    }

    public String getAdLogoUrl() {
        return "https://cpro.baidustatic.com/cpro/ui/noexpire/img/mob_adicon.png";
    }

    public String getAppPackage() {
        return this.f235a.getAppPackageName();
    }

    public long getAppSize() {
        return this.f235a.getAppSize();
    }

    public String getBaiduLogoUrl() {
        return "https://cpro.baidustatic.com/cpro/ui/noexpire/img/2.0.1/bd-logo4.png";
    }

    public String getBrandName() {
        return this.f235a.getAppName();
    }

    public String getDesc() {
        return this.f235a.getDescription();
    }

    public int getDuration() {
        return this.f235a.getVideoDuration();
    }

    public Map<String, String> getExtras() {
        return null;
    }

    public String getHtmlSnippet() {
        return this.f235a.getHtmlSnippet();
    }

    public String getIconUrl() {
        String iconUrl = this.f235a.getIconUrl();
        return (iconUrl == null || iconUrl.equals("")) ? this.f235a.getMainPictureUrl() : iconUrl;
    }

    public String getImageUrl() {
        return this.f235a.getMainPictureUrl();
    }

    public int getMainPicHeight() {
        return this.f235a.getMainMaterialHeight();
    }

    public int getMainPicWidth() {
        return this.f235a.getMainMaterialWidth();
    }

    public MaterialType getMaterialType() {
        return this.f235a.getCreativeType() == CreativeType.VIDEO ? MaterialType.VIDEO : this.f235a.getCreativeType() == CreativeType.HTML ? MaterialType.HTML : MaterialType.NORMAL;
    }

    public List<String> getMultiPicUrls() {
        try {
            JSONArray optJSONArray = this.f235a.getOriginJsonObject().optJSONArray("morepics");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return null;
            }
            List<String> arrayList = new ArrayList();
            int i = 0;
            while (i < optJSONArray.length()) {
                try {
                    arrayList.add(optJSONArray.getString(i));
                    i++;
                } catch (Exception e) {
                    return arrayList;
                }
            }
            return arrayList;
        } catch (Exception e2) {
            return null;
        }
    }

    public String getTitle() {
        return this.f235a.getTitle();
    }

    public String getVideoUrl() {
        return this.f235a.getVideoUrl();
    }

    public WebView getWebView() {
        return (WebView) this.f239e.getAdView();
    }

    public void handleClick(View view) {
        handleClick(view, -1);
    }

    public void handleClick(View view, int i) {
        if (isDownloadApp()) {
            Context context = view.getContext();
            if (this.f238d.getAPPConfirmPolicy() == 3) {
                this.f235a.setActionOnlyWifi(false);
            } else {
                if (this.f238d.getAPPConfirmPolicy() != 4) {
                    if (this.f238d.getAPPConfirmPolicy() == 2) {
                        m259a(view, i);
                        return;
                    } else if (this.f238d.getAPPConfirmPolicy() != 1) {
                        return;
                    } else {
                        if (C0338m.m569a().mo5041n().is3GConnected(context).booleanValue()) {
                            m259a(view, i);
                            return;
                        }
                    }
                }
                m258a(context);
                this.f236b.handleClick(view, this.f235a, i, this.f238d);
                return;
            }
        }
        this.f236b.handleClick(view, this.f235a, i, this.f238d);
    }

    public boolean isAdAvailable(Context context) {
        return this.f236b.isAdAvailable(context, this.f235a, this.f238d);
    }

    public boolean isDownloadApp() {
        return this.f237c;
    }

    public void onClickAd(Context context) {
        this.f236b.handleOnClickAd(context, this.f235a, this.f238d);
    }

    public void onClose(Context context, int i) {
        this.f236b.handleOnClose(context, i, this.f235a, this.f238d);
    }

    public void onComplete(Context context) {
        this.f236b.handleOnComplete(context, this.f235a, this.f238d);
    }

    public void onError(Context context, int i, int i2) {
        this.f236b.handleOnError(context, i, i2, this.f235a);
    }

    public void onFullScreen(Context context, int i) {
        this.f236b.handleOnFullScreen(context, i, this.f235a, this.f238d);
    }

    public void onStart(Context context) {
        this.f236b.handleOnStart(context, this.f235a, this.f238d);
    }

    public void recordImpression(View view) {
        this.f236b.recordImpression(view, this.f235a, this.f238d);
    }

    public void setIsDownloadApp(boolean z) {
        this.f237c = z;
    }
}
