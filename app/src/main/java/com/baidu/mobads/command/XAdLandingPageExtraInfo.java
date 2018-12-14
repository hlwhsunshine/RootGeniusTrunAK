package com.baidu.mobads.command;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.p021j.C0329d;
import com.baidu.mobads.p021j.C0338m;

public class XAdLandingPageExtraInfo extends XAdCommandExtraInfo {
    public static final Creator<XAdLandingPageExtraInfo> CREATOR = new C0274c();
    public int e75;
    public int from;
    public boolean isFullScreen;
    public int orientation;
    /* renamed from: os */
    public int f455os;
    public String prodType;
    /* renamed from: sn */
    public String f456sn;
    public String title;
    /* renamed from: v */
    public String f457v;

    private XAdLandingPageExtraInfo(Parcel parcel) {
        boolean z = true;
        super(parcel);
        this.isFullScreen = false;
        this.orientation = 1;
        this.e75 = 1;
        this.from = 0;
        this.f455os = 1;
        this.url = parcel.readString();
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.isFullScreen = z;
        this.orientation = parcel.readInt();
        this.e75 = parcel.readInt();
        this.from = parcel.readInt();
        this.adid = parcel.readString();
        this.f452qk = parcel.readString();
        this.packageNameOfPubliser = parcel.readString();
        this.appsid = parcel.readString();
        this.appsec = parcel.readString();
        this.f455os = parcel.readInt();
        this.prodType = parcel.readString();
        this.f457v = parcel.readString();
        this.f456sn = parcel.readString();
        this.title = parcel.readString();
    }

    public XAdLandingPageExtraInfo(String str, IXAdInstanceInfo iXAdInstanceInfo) {
        super(str, iXAdInstanceInfo);
        this.isFullScreen = false;
        this.orientation = 1;
        this.e75 = 1;
        this.from = 0;
        this.f455os = 1;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0329d m = C0338m.m569a().mo5040m();
        IXAdSystemUtils n = C0338m.m569a().mo5041n();
        super.writeToParcel(parcel, i);
        parcel.writeString(this.url);
        parcel.writeByte((byte) (this.isFullScreen ? 1 : 0));
        parcel.writeInt(this.orientation);
        parcel.writeInt(this.e75);
        parcel.writeInt(this.from);
        parcel.writeString(this.adid);
        parcel.writeString(this.f452qk);
        parcel.writeString(this.packageNameOfPubliser);
        parcel.writeString(this.appsid);
        parcel.writeString(this.appsec);
        parcel.writeInt(1);
        parcel.writeString(this.mProdType);
        parcel.writeString(m.mo5013a());
        parcel.writeString(n.getEncodedSN(C0338m.m569a().mo5031d()));
        this.title = TextUtils.isEmpty(this.title) ? "" : this.title;
        parcel.writeString(this.title);
    }
}
