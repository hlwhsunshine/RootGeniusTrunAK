package android.content.p013pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.content.pm.PackageInfoLite */
public class PackageInfoLite implements Parcelable {
    public static final Creator<PackageInfoLite> CREATOR = new C00411();
    public int installLocation;
    public String packageName;
    public int recommendedInstallLocation;
    public VerifierInfo[] verifiers;
    public int versionCode;

    /* renamed from: android.content.pm.PackageInfoLite$1 */
    class C00411 implements Creator<PackageInfoLite> {
        C00411() {
        }

        public PackageInfoLite createFromParcel(Parcel parcel) {
            return new PackageInfoLite(parcel, null);
        }

        public PackageInfoLite[] newArray(int i) {
            return new PackageInfoLite[i];
        }
    }

    private PackageInfoLite(Parcel parcel) {
        this.packageName = parcel.readString();
        this.versionCode = parcel.readInt();
        this.recommendedInstallLocation = parcel.readInt();
        this.installLocation = parcel.readInt();
        int readInt = parcel.readInt();
        if (readInt == 0) {
            this.verifiers = new VerifierInfo[0];
            return;
        }
        this.verifiers = new VerifierInfo[readInt];
        parcel.readTypedArray(this.verifiers, VerifierInfo.CREATOR);
    }

    /* synthetic */ PackageInfoLite(Parcel parcel, PackageInfoLite packageInfoLite) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PackageInfoLite{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.packageName + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.packageName);
        parcel.writeInt(this.versionCode);
        parcel.writeInt(this.recommendedInstallLocation);
        parcel.writeInt(this.installLocation);
        if (this.verifiers == null || this.verifiers.length == 0) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(this.verifiers.length);
        parcel.writeTypedArray(this.verifiers, i);
    }
}
