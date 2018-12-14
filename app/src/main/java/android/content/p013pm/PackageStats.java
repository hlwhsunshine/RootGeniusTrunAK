package android.content.p013pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.content.pm.PackageStats */
public class PackageStats implements Parcelable {
    public static final Creator<PackageStats> CREATOR = new C00421();
    public long cacheSize;
    public long codeSize;
    public long dataSize;
    public long externalCacheSize;
    public long externalCodeSize;
    public long externalDataSize;
    public long externalMediaSize;
    public long externalObbSize;
    public String packageName;
    public int userHandle;

    /* renamed from: android.content.pm.PackageStats$1 */
    class C00421 implements Creator<PackageStats> {
        C00421() {
        }

        public PackageStats createFromParcel(Parcel parcel) {
            return new PackageStats(parcel);
        }

        public PackageStats[] newArray(int i) {
            return new PackageStats[i];
        }
    }

    public PackageStats(PackageStats packageStats) {
        this.packageName = packageStats.packageName;
        this.userHandle = packageStats.userHandle;
        this.codeSize = packageStats.codeSize;
        this.dataSize = packageStats.dataSize;
        this.cacheSize = packageStats.cacheSize;
        this.externalCodeSize = packageStats.externalCodeSize;
        this.externalDataSize = packageStats.externalDataSize;
        this.externalCacheSize = packageStats.externalCacheSize;
        this.externalMediaSize = packageStats.externalMediaSize;
        this.externalObbSize = packageStats.externalObbSize;
    }

    public PackageStats(Parcel parcel) {
        this.packageName = parcel.readString();
        this.userHandle = parcel.readInt();
        this.codeSize = parcel.readLong();
        this.dataSize = parcel.readLong();
        this.cacheSize = parcel.readLong();
        this.externalCodeSize = parcel.readLong();
        this.externalDataSize = parcel.readLong();
        this.externalCacheSize = parcel.readLong();
        this.externalMediaSize = parcel.readLong();
        this.externalObbSize = parcel.readLong();
    }

    public PackageStats(String str) {
        this.packageName = str;
    }

    public PackageStats(String str, int i) {
        this.packageName = str;
        this.userHandle = i;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PackageStats{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" ");
        stringBuilder.append(this.packageName);
        if (this.codeSize != 0) {
            stringBuilder.append(" code=");
            stringBuilder.append(this.codeSize);
        }
        if (this.dataSize != 0) {
            stringBuilder.append(" data=");
            stringBuilder.append(this.dataSize);
        }
        if (this.cacheSize != 0) {
            stringBuilder.append(" cache=");
            stringBuilder.append(this.cacheSize);
        }
        if (this.externalCodeSize != 0) {
            stringBuilder.append(" extCode=");
            stringBuilder.append(this.externalCodeSize);
        }
        if (this.externalDataSize != 0) {
            stringBuilder.append(" extData=");
            stringBuilder.append(this.externalDataSize);
        }
        if (this.externalCacheSize != 0) {
            stringBuilder.append(" extCache=");
            stringBuilder.append(this.externalCacheSize);
        }
        if (this.externalMediaSize != 0) {
            stringBuilder.append(" media=");
            stringBuilder.append(this.externalMediaSize);
        }
        if (this.externalObbSize != 0) {
            stringBuilder.append(" obb=");
            stringBuilder.append(this.externalObbSize);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.packageName);
        parcel.writeInt(this.userHandle);
        parcel.writeLong(this.codeSize);
        parcel.writeLong(this.dataSize);
        parcel.writeLong(this.cacheSize);
        parcel.writeLong(this.externalCodeSize);
        parcel.writeLong(this.externalDataSize);
        parcel.writeLong(this.externalCacheSize);
        parcel.writeLong(this.externalMediaSize);
        parcel.writeLong(this.externalObbSize);
    }
}
