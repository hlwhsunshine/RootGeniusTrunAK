package android.content.p013pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.content.pm.InstrumentationInfo */
public class InstrumentationInfo extends PackageItemInfo implements Parcelable {
    public static final Creator<InstrumentationInfo> CREATOR = new C00361();
    public String dataDir;
    public boolean functionalTest;
    public boolean handleProfiling;
    public String nativeLibraryDir;
    public String publicSourceDir;
    public String sourceDir;
    public String targetPackage;

    /* renamed from: android.content.pm.InstrumentationInfo$1 */
    class C00361 implements Creator<InstrumentationInfo> {
        C00361() {
        }

        public InstrumentationInfo createFromParcel(Parcel parcel) {
            return new InstrumentationInfo(parcel, null);
        }

        public InstrumentationInfo[] newArray(int i) {
            return new InstrumentationInfo[i];
        }
    }

    public InstrumentationInfo(InstrumentationInfo instrumentationInfo) {
        super((PackageItemInfo) instrumentationInfo);
        this.targetPackage = instrumentationInfo.targetPackage;
        this.sourceDir = instrumentationInfo.sourceDir;
        this.publicSourceDir = instrumentationInfo.publicSourceDir;
        this.dataDir = instrumentationInfo.dataDir;
        this.nativeLibraryDir = instrumentationInfo.nativeLibraryDir;
        this.handleProfiling = instrumentationInfo.handleProfiling;
        this.functionalTest = instrumentationInfo.functionalTest;
    }

    private InstrumentationInfo(Parcel parcel) {
        boolean z = true;
        super(parcel);
        this.targetPackage = parcel.readString();
        this.sourceDir = parcel.readString();
        this.publicSourceDir = parcel.readString();
        this.dataDir = parcel.readString();
        this.nativeLibraryDir = parcel.readString();
        this.handleProfiling = parcel.readInt() != 0;
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.functionalTest = z;
    }

    /* synthetic */ InstrumentationInfo(Parcel parcel, InstrumentationInfo instrumentationInfo) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "InstrumentationInfo{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.packageName + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        super.writeToParcel(parcel, i);
        parcel.writeString(this.targetPackage);
        parcel.writeString(this.sourceDir);
        parcel.writeString(this.publicSourceDir);
        parcel.writeString(this.dataDir);
        parcel.writeString(this.nativeLibraryDir);
        parcel.writeInt(!this.handleProfiling ? 0 : 1);
        if (this.functionalTest) {
            i2 = 1;
        }
        parcel.writeInt(i2);
    }
}
