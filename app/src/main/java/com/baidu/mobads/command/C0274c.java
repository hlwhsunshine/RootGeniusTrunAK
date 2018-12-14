package com.baidu.mobads.command;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.baidu.mobads.command.c */
final class C0274c implements Creator<XAdLandingPageExtraInfo> {
    C0274c() {
    }

    /* renamed from: a */
    public final XAdLandingPageExtraInfo createFromParcel(Parcel parcel) {
        return new XAdLandingPageExtraInfo(parcel, null);
    }

    /* renamed from: a */
    public final XAdLandingPageExtraInfo[] newArray(int i) {
        return new XAdLandingPageExtraInfo[i];
    }
}
