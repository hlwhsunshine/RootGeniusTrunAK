package android.content.p013pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.PatternMatcher;

/* renamed from: android.content.pm.ProviderInfo */
public final class ProviderInfo extends ComponentInfo implements Parcelable {
    public static final Creator<ProviderInfo> CREATOR = new C00471();
    public static final int FLAG_SINGLE_USER = 1073741824;
    public String authority;
    public int flags;
    public boolean grantUriPermissions;
    public int initOrder;
    @Deprecated
    public boolean isSyncable;
    public boolean multiprocess;
    public PathPermission[] pathPermissions;
    public String readPermission;
    public PatternMatcher[] uriPermissionPatterns;
    public String writePermission;

    /* renamed from: android.content.pm.ProviderInfo$1 */
    class C00471 implements Creator<ProviderInfo> {
        C00471() {
        }

        public ProviderInfo createFromParcel(Parcel parcel) {
            return new ProviderInfo(parcel, null);
        }

        public ProviderInfo[] newArray(int i) {
            return new ProviderInfo[i];
        }
    }

    public ProviderInfo() {
        this.authority = null;
        this.readPermission = null;
        this.writePermission = null;
        this.grantUriPermissions = false;
        this.uriPermissionPatterns = null;
        this.pathPermissions = null;
        this.multiprocess = false;
        this.initOrder = 0;
        this.flags = 0;
        this.isSyncable = false;
    }

    public ProviderInfo(ProviderInfo providerInfo) {
        super((ComponentInfo) providerInfo);
        this.authority = null;
        this.readPermission = null;
        this.writePermission = null;
        this.grantUriPermissions = false;
        this.uriPermissionPatterns = null;
        this.pathPermissions = null;
        this.multiprocess = false;
        this.initOrder = 0;
        this.flags = 0;
        this.isSyncable = false;
        this.authority = providerInfo.authority;
        this.readPermission = providerInfo.readPermission;
        this.writePermission = providerInfo.writePermission;
        this.grantUriPermissions = providerInfo.grantUriPermissions;
        this.uriPermissionPatterns = providerInfo.uriPermissionPatterns;
        this.pathPermissions = providerInfo.pathPermissions;
        this.multiprocess = providerInfo.multiprocess;
        this.initOrder = providerInfo.initOrder;
        this.flags = providerInfo.flags;
        this.isSyncable = providerInfo.isSyncable;
    }

    private ProviderInfo(Parcel parcel) {
        boolean z = true;
        super(parcel);
        this.authority = null;
        this.readPermission = null;
        this.writePermission = null;
        this.grantUriPermissions = false;
        this.uriPermissionPatterns = null;
        this.pathPermissions = null;
        this.multiprocess = false;
        this.initOrder = 0;
        this.flags = 0;
        this.isSyncable = false;
        this.authority = parcel.readString();
        this.readPermission = parcel.readString();
        this.writePermission = parcel.readString();
        this.grantUriPermissions = parcel.readInt() != 0;
        this.uriPermissionPatterns = (PatternMatcher[]) parcel.createTypedArray(PatternMatcher.CREATOR);
        this.pathPermissions = (PathPermission[]) parcel.createTypedArray(PathPermission.CREATOR);
        this.multiprocess = parcel.readInt() != 0;
        this.initOrder = parcel.readInt();
        this.flags = parcel.readInt();
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.isSyncable = z;
    }

    /* synthetic */ ProviderInfo(Parcel parcel, ProviderInfo providerInfo) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "ContentProviderInfo{name=" + this.authority + " className=" + this.name + "}";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        super.writeToParcel(parcel, i);
        parcel.writeString(this.authority);
        parcel.writeString(this.readPermission);
        parcel.writeString(this.writePermission);
        parcel.writeInt(this.grantUriPermissions ? 1 : 0);
        parcel.writeTypedArray(this.uriPermissionPatterns, i);
        parcel.writeTypedArray(this.pathPermissions, i);
        parcel.writeInt(this.multiprocess ? 1 : 0);
        parcel.writeInt(this.initOrder);
        parcel.writeInt(this.flags);
        if (!this.isSyncable) {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }
}
