package com.baidu.mobads.command;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.p040vo.XAdInstanceInfo;

public abstract class XAdCommandExtraInfo implements Parcelable {
    public String adid;
    public String appsec;
    public String appsid;
    public Boolean autoOpen;
    public Boolean canCancel;
    public String canDelete;
    public String iconfrom;
    protected XAdInstanceInfo mAdInstanceInfo;
    public int mIntTesting4LM;
    public String mProdType;
    public String mStringTesting4LM;
    public String packageName;
    public String packageNameOfPubliser;
    public Boolean popNotif;
    /* renamed from: qk */
    public String f452qk;
    /* renamed from: sn */
    public String f453sn;
    public String url;
    /* renamed from: v */
    public String f454v;

    protected XAdCommandExtraInfo(Parcel parcel) {
        this.appsec = "";
        this.appsid = "";
        this.packageNameOfPubliser = "";
        this.adid = "-1";
        this.packageName = "";
        this.f452qk = "";
        this.autoOpen = Boolean.valueOf(true);
        this.f454v = "";
        this.f453sn = "";
        this.iconfrom = "";
        this.canCancel = Boolean.valueOf(true);
        this.canDelete = "";
        this.popNotif = Boolean.valueOf(true);
        this.mAdInstanceInfo = (XAdInstanceInfo) parcel.readParcelable(XAdInstanceInfo.class.getClassLoader());
        this.mProdType = parcel.readString();
        this.mIntTesting4LM = parcel.readInt();
        this.mStringTesting4LM = parcel.readString();
    }

    public XAdCommandExtraInfo(String str, IXAdInstanceInfo iXAdInstanceInfo) {
        this.appsec = "";
        this.appsid = "";
        this.packageNameOfPubliser = "";
        this.adid = "-1";
        this.packageName = "";
        this.f452qk = "";
        this.autoOpen = Boolean.valueOf(true);
        this.f454v = "";
        this.f453sn = "";
        this.iconfrom = "";
        this.canCancel = Boolean.valueOf(true);
        this.canDelete = "";
        this.popNotif = Boolean.valueOf(true);
        this.mIntTesting4LM = 999;
        this.mStringTesting4LM = "this is the test string";
        this.mProdType = str;
        this.mAdInstanceInfo = (XAdInstanceInfo) iXAdInstanceInfo;
    }

    public int describeContents() {
        return 0;
    }

    public IXAdInstanceInfo getAdInstanceInfo() {
        return this.mAdInstanceInfo;
    }

    public Boolean isValid() {
        return Boolean.valueOf("-1".equalsIgnoreCase(this.adid));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mAdInstanceInfo, i);
        parcel.writeString(this.mProdType);
        parcel.writeInt(this.mIntTesting4LM);
        parcel.writeString(this.mStringTesting4LM);
    }
}
