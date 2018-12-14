package com.baidu.mobads.p034h;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.h.e */
public class C0302e implements Parcelable {
    /* renamed from: a */
    public static final Creator<C0302e> f560a = new C0303f();
    /* renamed from: b */
    private JSONObject f561b;
    /* renamed from: c */
    private double f562c;
    /* renamed from: d */
    private String f563d;
    /* renamed from: e */
    private String f564e;
    /* renamed from: f */
    private String f565f;
    /* renamed from: g */
    private int f566g;
    /* renamed from: h */
    private int f567h;

    private C0302e(Parcel parcel) {
        this.f564e = parcel.readString();
        this.f567h = parcel.readInt();
        this.f563d = parcel.readString();
        this.f562c = parcel.readDouble();
        this.f565f = parcel.readString();
        this.f566g = parcel.readInt();
    }

    /* synthetic */ C0302e(Parcel parcel, C0303f c0303f) {
        this(parcel);
    }

    public C0302e(C0302e c0302e, String str, Boolean bool) {
        int i = 1;
        this.f562c = c0302e.mo4491b();
        this.f563d = c0302e.mo4492c();
        this.f564e = c0302e.mo4493d();
        this.f567h = c0302e.mo4490a().booleanValue() ? 1 : 0;
        this.f565f = str;
        if (!bool.booleanValue()) {
            i = 0;
        }
        this.f566g = i;
    }

    public C0302e(String str) {
        int i = 1;
        try {
            this.f561b = new JSONObject(str);
            this.f562c = this.f561b.getDouble("version");
            this.f563d = this.f561b.getString("url");
            this.f564e = this.f561b.getString("sign");
            this.f567h = 1;
            this.f565f = "";
            this.f566g = 0;
        } catch (JSONException e) {
            this.f567h = 0;
        }
        if (mo4492c() == null) {
            i = 0;
        }
        this.f567h = i;
    }

    /* renamed from: a */
    public Boolean mo4490a() {
        boolean z = true;
        if (this.f567h != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    /* renamed from: b */
    public double mo4491b() {
        return this.f562c;
    }

    /* renamed from: c */
    public String mo4492c() {
        return this.f563d;
    }

    /* renamed from: d */
    public String mo4493d() {
        return this.f564e;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public String mo4495e() {
        return this.f565f;
    }

    public String toString() {
        return this.f561b.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f564e);
        parcel.writeInt(this.f567h);
        parcel.writeString(this.f563d);
        parcel.writeDouble(this.f562c);
        parcel.writeString(this.f565f);
        parcel.writeInt(this.f566g);
    }
}
