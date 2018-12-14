package com.baidu.mobads.p040vo;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.baidu.mobads.vo.a */
final class C0436a implements Creator<XAdInstanceInfo> {
    C0436a() {
    }

    /* renamed from: a */
    public final XAdInstanceInfo createFromParcel(Parcel parcel) {
        return new XAdInstanceInfo(parcel, null);
    }

    /* renamed from: a */
    public final XAdInstanceInfo[] newArray(int i) {
        return new XAdInstanceInfo[i];
    }
}
