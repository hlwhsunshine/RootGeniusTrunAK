package android.content.p013pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

/* renamed from: android.content.pm.PermissionGroupInfo */
public class PermissionGroupInfo extends PackageItemInfo implements Parcelable {
    public static final Creator<PermissionGroupInfo> CREATOR = new C00451();
    public static final int FLAG_PERSONAL_INFO = 1;
    public int descriptionRes;
    public int flags;
    public CharSequence nonLocalizedDescription;
    public int priority;

    /* renamed from: android.content.pm.PermissionGroupInfo$1 */
    class C00451 implements Creator<PermissionGroupInfo> {
        C00451() {
        }

        public PermissionGroupInfo createFromParcel(Parcel parcel) {
            return new PermissionGroupInfo(parcel, null);
        }

        public PermissionGroupInfo[] newArray(int i) {
            return new PermissionGroupInfo[i];
        }
    }

    public PermissionGroupInfo(PermissionGroupInfo permissionGroupInfo) {
        super((PackageItemInfo) permissionGroupInfo);
        this.descriptionRes = permissionGroupInfo.descriptionRes;
        this.nonLocalizedDescription = permissionGroupInfo.nonLocalizedDescription;
        this.flags = permissionGroupInfo.flags;
        this.priority = permissionGroupInfo.priority;
    }

    private PermissionGroupInfo(Parcel parcel) {
        super(parcel);
        this.descriptionRes = parcel.readInt();
        this.nonLocalizedDescription = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.flags = parcel.readInt();
        this.priority = parcel.readInt();
    }

    /* synthetic */ PermissionGroupInfo(Parcel parcel, PermissionGroupInfo permissionGroupInfo) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public CharSequence loadDescription(PackageManager packageManager) {
        if (this.nonLocalizedDescription != null) {
            return this.nonLocalizedDescription;
        }
        if (this.descriptionRes != 0) {
            CharSequence text = packageManager.getText(this.packageName, this.descriptionRes, null);
            if (text != null) {
                return text;
            }
        }
        return null;
    }

    public String toString() {
        return "PermissionGroupInfo{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.name + " flgs=0x" + Integer.toHexString(this.flags) + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.descriptionRes);
        TextUtils.writeToParcel(this.nonLocalizedDescription, parcel, i);
        parcel.writeInt(this.flags);
        parcel.writeInt(this.priority);
    }
}
