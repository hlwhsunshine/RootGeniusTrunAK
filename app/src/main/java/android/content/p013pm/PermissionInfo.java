package android.content.p013pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

/* renamed from: android.content.pm.PermissionInfo */
public class PermissionInfo extends PackageItemInfo implements Parcelable {
    public static final Creator<PermissionInfo> CREATOR = new C00461();
    public static final int FLAG_COSTS_MONEY = 1;
    public static final int PROTECTION_DANGEROUS = 1;
    public static final int PROTECTION_FLAG_DEVELOPMENT = 32;
    public static final int PROTECTION_FLAG_SYSTEM = 16;
    public static final int PROTECTION_MASK_BASE = 15;
    public static final int PROTECTION_MASK_FLAGS = 240;
    public static final int PROTECTION_NORMAL = 0;
    public static final int PROTECTION_SIGNATURE = 2;
    public static final int PROTECTION_SIGNATURE_OR_SYSTEM = 3;
    public int descriptionRes;
    public int flags;
    public String group;
    public CharSequence nonLocalizedDescription;
    public int protectionLevel;

    /* renamed from: android.content.pm.PermissionInfo$1 */
    class C00461 implements Creator<PermissionInfo> {
        C00461() {
        }

        public PermissionInfo createFromParcel(Parcel parcel) {
            return new PermissionInfo(parcel, null);
        }

        public PermissionInfo[] newArray(int i) {
            return new PermissionInfo[i];
        }
    }

    public PermissionInfo(PermissionInfo permissionInfo) {
        super((PackageItemInfo) permissionInfo);
        this.protectionLevel = permissionInfo.protectionLevel;
        this.flags = permissionInfo.flags;
        this.group = permissionInfo.group;
        this.descriptionRes = permissionInfo.descriptionRes;
        this.nonLocalizedDescription = permissionInfo.nonLocalizedDescription;
    }

    private PermissionInfo(Parcel parcel) {
        super(parcel);
        this.protectionLevel = parcel.readInt();
        this.flags = parcel.readInt();
        this.group = parcel.readString();
        this.descriptionRes = parcel.readInt();
        this.nonLocalizedDescription = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    /* synthetic */ PermissionInfo(Parcel parcel, PermissionInfo permissionInfo) {
        this(parcel);
    }

    public static int fixProtectionLevel(int i) {
        return i == 3 ? 18 : i;
    }

    public static String protectionToString(int i) {
        String str = "????";
        switch (i & 15) {
            case 0:
                str = "normal";
                break;
            case 1:
                str = "dangerous";
                break;
            case 2:
                str = "signature";
                break;
            case 3:
                str = "signatureOrSystem";
                break;
        }
        if ((i & 16) != 0) {
            str = new StringBuilder(String.valueOf(str)).append("|system").toString();
        }
        return (i & 32) != 0 ? new StringBuilder(String.valueOf(str)).append("|development").toString() : str;
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
        return "PermissionInfo{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.name + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.protectionLevel);
        parcel.writeInt(this.flags);
        parcel.writeString(this.group);
        parcel.writeInt(this.descriptionRes);
        TextUtils.writeToParcel(this.nonLocalizedDescription, parcel, i);
    }
}
