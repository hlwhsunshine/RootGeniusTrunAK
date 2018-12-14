package android.content.p013pm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.content.pm.PackageCleanItem */
public class PackageCleanItem {
    public static final Creator<PackageCleanItem> CREATOR = new C00391();
    public final boolean andCode;
    public final String packageName;
    public final int userId;

    /* renamed from: android.content.pm.PackageCleanItem$1 */
    class C00391 implements Creator<PackageCleanItem> {
        C00391() {
        }

        public PackageCleanItem createFromParcel(Parcel parcel) {
            return new PackageCleanItem(parcel, null);
        }

        public PackageCleanItem[] newArray(int i) {
            return new PackageCleanItem[i];
        }
    }

    public PackageCleanItem(int i, String str, boolean z) {
        this.userId = i;
        this.packageName = str;
        this.andCode = z;
    }

    private PackageCleanItem(Parcel parcel) {
        this.userId = parcel.readInt();
        this.packageName = parcel.readString();
        this.andCode = parcel.readInt() != 0;
    }

    /* synthetic */ PackageCleanItem(Parcel parcel, PackageCleanItem packageCleanItem) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            try {
                PackageCleanItem packageCleanItem = (PackageCleanItem) obj;
                return this.userId == packageCleanItem.userId && this.packageName.equals(packageCleanItem.packageName) && this.andCode == packageCleanItem.andCode;
            } catch (ClassCastException e) {
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.andCode ? 1 : 0) + ((((this.userId + 527) * 31) + this.packageName.hashCode()) * 31);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.userId);
        parcel.writeString(this.packageName);
        parcel.writeInt(this.andCode ? 1 : 0);
    }
}
