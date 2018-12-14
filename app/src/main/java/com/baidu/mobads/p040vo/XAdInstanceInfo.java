package com.baidu.mobads.p040vo;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.p021j.C0338m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.vo.XAdInstanceInfo */
public class XAdInstanceInfo implements Parcelable, IXAdInstanceInfo, Cloneable {
    public static final Creator<XAdInstanceInfo> CREATOR = new C0436a();
    public static final String TAG = "XAdInstanceInfo";
    /* renamed from: A */
    private Set<String> f991A;
    /* renamed from: B */
    private Set<String> f992B;
    /* renamed from: C */
    private Set<String> f993C;
    /* renamed from: D */
    private Set<String> f994D;
    /* renamed from: E */
    private Set<String> f995E;
    /* renamed from: F */
    private Set<String> f996F;
    /* renamed from: G */
    private Set<String> f997G;
    /* renamed from: H */
    private Set<String> f998H;
    /* renamed from: I */
    private Set<String> f999I;
    /* renamed from: J */
    private int f1000J;
    /* renamed from: K */
    private boolean f1001K;
    /* renamed from: L */
    private String f1002L;
    /* renamed from: M */
    private String f1003M;
    /* renamed from: N */
    private String f1004N;
    /* renamed from: O */
    private String f1005O;
    /* renamed from: P */
    private String f1006P;
    /* renamed from: Q */
    private long f1007Q;
    /* renamed from: R */
    private int f1008R;
    /* renamed from: S */
    private String f1009S;
    /* renamed from: T */
    private int f1010T;
    /* renamed from: U */
    private boolean f1011U;
    /* renamed from: V */
    private long f1012V;
    /* renamed from: W */
    private CreativeType f1013W;
    /* renamed from: X */
    private String f1014X;
    /* renamed from: Y */
    private int f1015Y;
    /* renamed from: Z */
    private boolean f1016Z;
    /* renamed from: a */
    private String f1017a;
    /* renamed from: aa */
    private boolean f1018aa;
    /* renamed from: ab */
    private boolean f1019ab;
    /* renamed from: ac */
    private boolean f1020ac;
    /* renamed from: ad */
    private boolean f1021ad;
    /* renamed from: ae */
    private boolean f1022ae;
    /* renamed from: af */
    private boolean f1023af;
    /* renamed from: ag */
    private boolean f1024ag;
    /* renamed from: ah */
    private String f1025ah;
    /* renamed from: ai */
    private String f1026ai;
    /* renamed from: aj */
    private String f1027aj;
    /* renamed from: ak */
    private JSONArray f1028ak;
    /* renamed from: al */
    private boolean f1029al;
    /* renamed from: am */
    private boolean f1030am;
    /* renamed from: an */
    private String f1031an;
    /* renamed from: b */
    private String f1032b;
    /* renamed from: c */
    private String f1033c;
    /* renamed from: d */
    private String f1034d;
    /* renamed from: e */
    private String f1035e;
    /* renamed from: f */
    private String f1036f;
    /* renamed from: g */
    private String f1037g;
    /* renamed from: h */
    private String f1038h;
    /* renamed from: i */
    private String f1039i;
    /* renamed from: j */
    private String f1040j;
    /* renamed from: k */
    private String f1041k;
    /* renamed from: l */
    private int f1042l;
    /* renamed from: m */
    private String f1043m;
    /* renamed from: n */
    private String f1044n;
    /* renamed from: o */
    private boolean f1045o;
    /* renamed from: p */
    private int f1046p;
    @Deprecated
    /* renamed from: q */
    private boolean f1047q;
    @Deprecated
    /* renamed from: r */
    private int f1048r;
    /* renamed from: s */
    private String f1049s;
    /* renamed from: t */
    private String f1050t;
    /* renamed from: u */
    private JSONObject f1051u;
    /* renamed from: v */
    private String f1052v;
    /* renamed from: w */
    private int f1053w;
    /* renamed from: x */
    private int f1054x;
    @Deprecated
    /* renamed from: y */
    private String f1055y;
    /* renamed from: z */
    private Set<String> f1056z;

    private XAdInstanceInfo(Parcel parcel) {
        this.f1032b = "-1";
        this.f1056z = new HashSet();
        this.f991A = new HashSet();
        this.f992B = new HashSet();
        this.f993C = new HashSet();
        this.f994D = new HashSet();
        this.f995E = new HashSet();
        this.f996F = new HashSet();
        this.f997G = new HashSet();
        this.f998H = new HashSet();
        this.f999I = new HashSet();
        this.f1001K = true;
        this.f1013W = CreativeType.NONE;
        this.f1016Z = true;
        this.f1019ab = true;
        this.f1020ac = true;
        this.f1029al = false;
        this.f1030am = false;
        this.f1031an = null;
        this.f1032b = parcel.readString();
        this.f1033c = parcel.readString();
        this.f1006P = parcel.readString();
        this.f1009S = parcel.readString();
        this.f1005O = parcel.readString();
        this.f1049s = parcel.readString();
        this.f1026ai = parcel.readString();
        this.f1002L = parcel.readString();
        this.f1035e = parcel.readString();
        this.f1041k = parcel.readString();
        this.f1017a = parcel.readString();
        this.f1052v = parcel.readString();
        this.f1040j = parcel.readString();
        this.f1039i = parcel.readString();
        this.f1037g = parcel.readString();
        this.f1054x = parcel.readInt();
        this.f1053w = parcel.readInt();
        this.f1050t = parcel.readString();
        this.f1055y = parcel.readString();
        this.f1038h = parcel.readString();
        this.f1003M = parcel.readString();
        this.f1036f = parcel.readString();
        this.f1034d = parcel.readString();
        this.f1014X = parcel.readString();
        this.f1044n = parcel.readString();
        this.f1046p = parcel.readInt();
        this.f1025ah = parcel.readString();
        this.f1027aj = parcel.readString();
    }

    /* synthetic */ XAdInstanceInfo(Parcel parcel, C0436a c0436a) {
        this(parcel);
    }

    @SuppressLint({"DefaultLocale"})
    public XAdInstanceInfo(JSONObject jSONObject) {
        this.f1032b = "-1";
        this.f1056z = new HashSet();
        this.f991A = new HashSet();
        this.f992B = new HashSet();
        this.f993C = new HashSet();
        this.f994D = new HashSet();
        this.f995E = new HashSet();
        this.f996F = new HashSet();
        this.f997G = new HashSet();
        this.f998H = new HashSet();
        this.f999I = new HashSet();
        this.f1001K = true;
        this.f1013W = CreativeType.NONE;
        this.f1016Z = true;
        this.f1019ab = true;
        this.f1020ac = true;
        this.f1029al = false;
        this.f1030am = false;
        this.f1031an = null;
        this.f1051u = jSONObject;
        try {
            String str;
            int i;
            this.f1012V = System.currentTimeMillis();
            this.f1000J = jSONObject.optInt(IXAdRequestInfo.ACT);
            this.f1052v = jSONObject.optString("html", null);
            this.f1032b = jSONObject.optString("id", "-1");
            this.f1033c = jSONObject.optString("src", "");
            this.f1034d = jSONObject.optString("tit", "");
            this.f1035e = jSONObject.optString("desc", "");
            this.f1036f = jSONObject.optString("surl", "");
            this.f1038h = jSONObject.optString("phone", "");
            this.f1039i = jSONObject.optString("w_picurl", "");
            this.f1040j = jSONObject.optString("icon", "");
            this.f1041k = jSONObject.optString("exp2", "{}");
            this.f1042l = jSONObject.optInt("anti_tag");
            this.f1044n = jSONObject.optString("vurl", "");
            this.f1046p = jSONObject.optInt("duration", 0);
            this.f1045o = jSONObject.optInt("sound", 0) != 1;
            this.f1047q = jSONObject.optInt("iv", 0) == 1;
            this.f1048r = jSONObject.optInt("dur", 0);
            this.f1049s = jSONObject.optString("curl", "");
            this.f1050t = jSONObject.optString("ori_curl", "");
            this.f1037g = jSONObject.optString("type");
            if (this.f1052v != null && this.f1052v.length() > 0 && (this.f1052v.contains("html") || this.f1052v.contains("HTML"))) {
                this.f1013W = CreativeType.HTML;
            } else if (this.f1037g != null) {
                if (this.f1037g.equals("text")) {
                    this.f1013W = CreativeType.TEXT;
                } else if (this.f1037g.equals("image")) {
                    if (!(this.f1039i == null || this.f1039i.equals(""))) {
                        int lastIndexOf = this.f1039i.toLowerCase(Locale.getDefault()).lastIndexOf(46);
                        str = "";
                        if (lastIndexOf >= 0) {
                            str = this.f1039i.toLowerCase(Locale.getDefault()).substring(lastIndexOf);
                        }
                        if (str.equals(".gif")) {
                            this.f1013W = CreativeType.GIF;
                        } else {
                            this.f1013W = CreativeType.STATIC_IMAGE;
                        }
                    }
                } else if (this.f1037g.equals("rm")) {
                    this.f1013W = CreativeType.RM;
                } else if (this.f1037g.equals("video")) {
                    this.f1013W = CreativeType.VIDEO;
                }
            }
            this.f1053w = jSONObject.optInt(IXAdRequestInfo.WIDTH);
            this.f1054x = jSONObject.optInt(IXAdRequestInfo.HEIGHT);
            this.f1055y = jSONObject.optString("lb_phone", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("nwinurl");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                str = jSONObject.optString("winurl", "");
                if (!str.equals("")) {
                    this.f1056z.add(str);
                }
            } else {
                for (i = 0; i < optJSONArray.length(); i++) {
                    this.f1056z.add(optJSONArray.getString(i));
                }
            }
            str = jSONObject.optString("clklogurl", "");
            if (!str.equals("")) {
                this.f1056z.add(str);
            }
            optJSONArray = jSONObject.optJSONArray("mon");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString = jSONObject2.optString("s", "");
                    String optString2 = jSONObject2.optString("c", "");
                    mo5248a(optString);
                    mo5256b(optString2);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("monitors");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    str = (String) keys.next();
                    JSONArray optJSONArray2;
                    if (str.equals("s")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            mo5248a(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("vskip")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addSkipMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("scard")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addScardMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("ccard")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addCcardMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("vstart")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addStartMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("vfullscreen")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addFullScreenMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("vclose")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addCloseMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("cstartcard")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addCstartcardMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("c")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            mo5256b(optJSONArray2.optString(i));
                        }
                    }
                }
            }
            this.f1001K = true;
            this.f1002L = jSONObject.optString("cf", "");
            this.f1003M = jSONObject.optString("qk", "");
            this.f1004N = this.f1003M + "_" + new Random().nextLong() + System.currentTimeMillis() + "|";
            this.f1006P = jSONObject.optString("appname", "");
            this.f1005O = jSONObject.optString(IXAdRequestInfo.PACKAGE, "");
            this.f1007Q = jSONObject.optLong("sz", 0);
            this.f1008R = jSONObject.optInt("sb", 0);
            this.f1009S = jSONObject.optString("apo", "");
            this.f1010T = jSONObject.optInt("po", 0);
            this.f1011U = jSONObject.optInt("st", 0) == 1;
        } catch (Exception e) {
            C0338m.m569a().mo5033f().mo4929e(TAG, e.getMessage());
        }
    }

    /* renamed from: a */
    final void mo5248a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f991A.add(str);
        }
    }

    public void addCcardMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f996F.add(str);
        }
    }

    public void addCloseMonitorTrackers(String str) {
        if (str != null && !str.equals("")) {
            this.f998H.add(str);
        }
    }

    public void addCstartcardMonitorTrackers(String str) {
        if (str != null && !str.equals("")) {
            this.f999I.add(str);
        }
    }

    public void addFullScreenMonitorTrackers(String str) {
        if (str != null && !str.equals("")) {
            this.f997G.add(str);
        }
    }

    public void addScardMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f995E.add(str);
        }
    }

    public void addSkipMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f994D.add(str);
        }
    }

    public void addStartMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f993C.add(str);
        }
    }

    /* renamed from: b */
    final void mo5256b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f992B.add(str);
        }
    }

    protected Object clone() {
        return super.clone();
    }

    public int describeContents() {
        return 0;
    }

    public boolean getAPOOpen() {
        return this.f1030am;
    }

    public int getActionType() {
        return this.f1000J;
    }

    public String getAdId() {
        return this.f1032b;
    }

    public String getAdSource() {
        return this.f1033c;
    }

    public int getAntiTag() {
        return this.f1042l;
    }

    public String getAppName() {
        return this.f1006P;
    }

    public String getAppOpenStrs() {
        return this.f1009S;
    }

    public String getAppPackageName() {
        return this.f1005O;
    }

    public long getAppSize() {
        return this.f1007Q;
    }

    public List<String> getCcardTrackers() {
        return new ArrayList(this.f996F);
    }

    public String getClickThroughUrl() {
        return this.f1049s;
    }

    public String getClklogurl() {
        return this.f1026ai;
    }

    public List<String> getCloseTrackers() {
        return new ArrayList(this.f998H);
    }

    public String getConfirmBorderPercent() {
        return this.f1002L;
    }

    public long getCreateTime() {
        return this.f1012V;
    }

    public CreativeType getCreativeType() {
        return this.f1013W;
    }

    public List<String> getCstartcardTrackers() {
        return new ArrayList(this.f999I);
    }

    public String getDescription() {
        return this.f1035e;
    }

    public int getDlTunnel() {
        return this.f1015Y;
    }

    public String getExp2ForSingleAd() {
        return this.f1041k;
    }

    public List<String> getFullScreenTrackers() {
        return new ArrayList(this.f997G);
    }

    public String getFwt() {
        return this.f1017a;
    }

    public int getHoursInADayToShowAd() {
        return this.f1048r;
    }

    public String getHtmlSnippet() {
        return this.f1052v;
    }

    public String getIconUrl() {
        return this.f1040j;
    }

    public Set<String> getImpressionUrls() {
        return this.f1056z;
    }

    public String getLocalCreativeURL() {
        return this.f1043m;
    }

    public int getMainMaterialHeight() {
        return this.f1054x;
    }

    public int getMainMaterialWidth() {
        return this.f1053w;
    }

    public String getMainPictureUrl() {
        return this.f1039i;
    }

    public String getMaterialType() {
        return this.f1037g;
    }

    public JSONArray getNwinurl() {
        return this.f1028ak;
    }

    public String getOriginClickUrl() {
        return this.f1050t;
    }

    public JSONObject getOriginJsonObject() {
        return this.f1051u;
    }

    public String getPage() {
        return this.f1031an;
    }

    public String getPhoneForLocalBranding() {
        return this.f1055y;
    }

    public String getPhoneNumber() {
        return this.f1038h;
    }

    public int getPointsForWall() {
        return this.f1010T;
    }

    public String getQueryKey() {
        return this.f1003M;
    }

    public List<String> getScardTrackers() {
        return new ArrayList(this.f995E);
    }

    public List<String> getSkipTrackers() {
        return new ArrayList(this.f994D);
    }

    public String getSponsorUrl() {
        return this.f1036f;
    }

    public List<String> getStartTrackers() {
        return new ArrayList(this.f993C);
    }

    public int getSwitchButton() {
        return this.f1008R;
    }

    public List<String> getThirdClickTrackingUrls() {
        return new ArrayList(this.f992B);
    }

    public List<String> getThirdImpressionTrackingUrls() {
        return new ArrayList(this.f991A);
    }

    public String getTitle() {
        return this.f1034d;
    }

    public String getUniqueId() {
        return this.f1004N;
    }

    public String getUrl() {
        return this.f1014X;
    }

    public int getVideoDuration() {
        return this.f1046p;
    }

    public String getVideoUrl() {
        return this.f1044n;
    }

    public String getVurl() {
        return this.f1025ah;
    }

    public String getWinurl() {
        return this.f1027aj;
    }

    public boolean isActionOnlyWifi() {
        return this.f1001K;
    }

    public boolean isAutoOpen() {
        return this.f1019ab;
    }

    public boolean isCanCancel() {
        return this.f1023af;
    }

    public boolean isCanDelete() {
        return this.f1024ag;
    }

    public boolean isClose() {
        return this.f1018aa;
    }

    public boolean isIconVisibleForImageType() {
        return this.f1047q;
    }

    public boolean isInapp() {
        return this.f1016Z;
    }

    public boolean isPopNotif() {
        return this.f1020ac;
    }

    public boolean isSecondConfirmed() {
        return this.f1029al;
    }

    public boolean isTaskDoneForWall() {
        return this.f1011U;
    }

    public boolean isTooLarge() {
        return this.f1022ae;
    }

    public Boolean isValid() {
        return Boolean.valueOf(!"-1".equalsIgnoreCase(getAdId()));
    }

    public boolean isVideoMuted() {
        return this.f1045o;
    }

    public boolean isWifiTargeted() {
        return this.f1021ad;
    }

    public void setAPOOpen(boolean z) {
        this.f1030am = z;
    }

    public void setActionOnlyWifi(boolean z) {
        this.f1001K = z;
    }

    public void setActionType(int i) {
        this.f1000J = i;
    }

    public void setAdId(String str) {
        this.f1032b = str;
    }

    public void setAdSource(String str) {
        this.f1033c = str;
    }

    public void setAntiTag(int i) {
        this.f1042l = i;
    }

    public void setAppName(String str) {
        this.f1006P = str;
    }

    public void setAppOpenStrs(String str) {
        this.f1009S = str;
    }

    public void setAppPackageName(String str) {
        this.f1005O = str;
    }

    public void setAppSize(long j) {
        this.f1007Q = j;
    }

    public void setAutoOpen(boolean z) {
        this.f1019ab = z;
    }

    public void setCanCancel(boolean z) {
        this.f1023af = z;
    }

    public void setCanDelete(boolean z) {
        this.f1024ag = z;
    }

    public void setCcardTrackers(List<String> list) {
        this.f996F.addAll(list);
    }

    public void setClickThroughUrl(String str) {
        this.f1049s = str;
    }

    public void setClklogurl(String str) {
        this.f1026ai = str;
    }

    public void setClose(boolean z) {
        this.f1018aa = z;
    }

    public void setCloseTrackers(List<String> list) {
        this.f998H.clear();
        this.f998H.addAll(list);
    }

    public void setConfirmBorderPercent(String str) {
        this.f1002L = str;
    }

    public void setCreateTime(long j) {
        this.f1012V = j;
    }

    public void setCreativeType(CreativeType creativeType) {
        this.f1013W = creativeType;
    }

    public void setCstartcardTrackers(List<String> list) {
        this.f999I.clear();
        this.f999I.addAll(list);
    }

    public void setDescription(String str) {
        this.f1035e = str;
    }

    public void setDlTunnel(int i) {
        this.f1015Y = i;
    }

    public void setExp2ForSingleAd(String str) {
        this.f1041k = str;
    }

    public void setFullScreenTrackers(List<String> list) {
        this.f997G.addAll(list);
    }

    public void setFwt(String str) {
        this.f1017a = str;
    }

    public void setHoursInADayToShowAd(int i) {
        this.f1048r = i;
    }

    public void setHtmlSnippet(String str) {
        this.f1052v = str;
    }

    public void setIconUrl(String str) {
        this.f1040j = str;
    }

    public void setIconVisibleForImageType(boolean z) {
        this.f1047q = z;
    }

    public void setImpressionUrls(Set<String> set) {
        this.f1056z = set;
    }

    public void setInapp(boolean z) {
        this.f1016Z = z;
    }

    public void setLocalCreativeURL(String str) {
        this.f1043m = str;
    }

    public void setMainMaterialHeight(int i) {
        this.f1054x = i;
    }

    public void setMainMaterialWidth(int i) {
        this.f1053w = i;
    }

    public void setMainPictureUrl(String str) {
        this.f1039i = str;
    }

    public void setMaterialType(String str) {
        this.f1037g = str;
    }

    public void setNwinurl(JSONArray jSONArray) {
        this.f1028ak = jSONArray;
    }

    public void setOriginClickUrl(String str) {
        this.f1050t = str;
    }

    public void setPage(String str) {
        this.f1031an = str;
    }

    public void setPhoneForLocalBranding(String str) {
        this.f1055y = str;
    }

    public void setPhoneNumber(String str) {
        this.f1038h = str;
    }

    public void setPointsForWall(int i) {
        this.f1010T = i;
    }

    public void setPopNotif(boolean z) {
        this.f1020ac = z;
    }

    public void setQueryKey(String str) {
        this.f1003M = str;
    }

    public void setScardTrackers(List<String> list) {
        this.f995E.addAll(list);
    }

    public void setSecondConfirmed(boolean z) {
        this.f1029al = z;
    }

    public void setSkipTrackers(List<String> list) {
        this.f994D.addAll(list);
    }

    public void setSponsorUrl(String str) {
        this.f1036f = str;
    }

    public void setStartTrackers(List<String> list) {
        this.f993C.clear();
        this.f993C.addAll(list);
    }

    public void setSwitchButton(int i) {
        this.f1008R = i;
    }

    public void setTaskDoneForWall(boolean z) {
        this.f1011U = z;
    }

    public void setThirdClickTrackingUrls(Set<String> set) {
        this.f992B = set;
    }

    public void setThirdImpressionTrackingUrls(Set<String> set) {
        this.f991A = set;
    }

    public void setTitle(String str) {
        this.f1034d = str;
    }

    public void setTooLarge(boolean z) {
        this.f1022ae = z;
    }

    public void setUrl(String str) {
        this.f1014X = str;
    }

    public void setVideoDuration(int i) {
        this.f1046p = i;
    }

    public void setVideoMuted(boolean z) {
        this.f1045o = z;
    }

    public void setVideoUrl(String str) {
        this.f1044n = str;
    }

    public void setVurl(String str) {
        this.f1025ah = str;
    }

    public void setWifiTargeted(boolean z) {
        this.f1021ad = z;
    }

    public void setWinurl(String str) {
        this.f1027aj = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1032b);
        parcel.writeString(this.f1033c);
        parcel.writeString(this.f1006P);
        parcel.writeString(this.f1009S);
        parcel.writeString(this.f1005O);
        parcel.writeString(this.f1049s);
        parcel.writeString(this.f1026ai);
        parcel.writeString(this.f1002L);
        parcel.writeString(this.f1035e);
        parcel.writeString(this.f1041k);
        parcel.writeString(this.f1017a);
        parcel.writeString(this.f1052v);
        parcel.writeString(this.f1040j);
        parcel.writeString(this.f1039i);
        parcel.writeString(this.f1037g);
        parcel.writeInt(this.f1054x);
        parcel.writeInt(this.f1053w);
        parcel.writeString(this.f1050t);
        parcel.writeString(this.f1055y);
        parcel.writeString(this.f1038h);
        parcel.writeString(this.f1003M);
        parcel.writeString(this.f1036f);
        parcel.writeString(this.f1034d);
        parcel.writeString(this.f1014X);
        parcel.writeString(this.f1044n);
        parcel.writeInt(this.f1046p);
        parcel.writeString(this.f1025ah);
        parcel.writeString(this.f1027aj);
    }
}
