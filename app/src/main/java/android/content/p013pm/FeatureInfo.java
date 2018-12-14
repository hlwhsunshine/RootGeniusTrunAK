package android.content.p013pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p015v4.internal.view.SupportMenu;

/* renamed from: android.content.pm.FeatureInfo */
public class FeatureInfo implements Parcelable {
    public static final Creator<FeatureInfo> CREATOR = new C00351();
    public static final int FLAG_REQUIRED = 1;
    public static final int GL_ES_VERSION_UNDEFINED = 0;
    public int flags;
    public String name;
    public int reqGlEsVersion;

    /* renamed from: android.content.pm.FeatureInfo$1 */
    class C00351 implements Creator<FeatureInfo> {
        C00351() {
        }

        public FeatureInfo createFromParcel(Parcel parcel) {
            return new FeatureInfo(parcel, null);
        }

        public FeatureInfo[] newArray(int i) {
            return new FeatureInfo[i];
        }
    }

    public FeatureInfo(FeatureInfo featureInfo) {
        this.name = featureInfo.name;
        this.reqGlEsVersion = featureInfo.reqGlEsVersion;
        this.flags = featureInfo.flags;
    }

    private FeatureInfo(Parcel parcel) {
        this.name = parcel.readString();
        this.reqGlEsVersion = parcel.readInt();
        this.flags = parcel.readInt();
    }

    /* synthetic */ FeatureInfo(Parcel parcel, FeatureInfo featureInfo) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public String getGlEsVersion() {
        return new StringBuilder(String.valueOf(String.valueOf((this.reqGlEsVersion & SupportMenu.CATEGORY_MASK) >> 16))).append(".").append(String.valueOf(this.reqGlEsVersion & SupportMenu.USER_MASK)).toString();
    }

    public String toString() {
        return this.name != null ? "FeatureInfo{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.name + " fl=0x" + Integer.toHexString(this.flags) + "}" : "FeatureInfo{" + Integer.toHexString(System.identityHashCode(this)) + " glEsVers=" + getGlEsVersion() + " fl=0x" + Integer.toHexString(this.flags) + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeInt(this.reqGlEsVersion);
        parcel.writeInt(this.flags);
    }
}
