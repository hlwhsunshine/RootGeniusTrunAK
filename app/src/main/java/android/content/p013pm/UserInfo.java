package android.content.p013pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.UserHandle;

/* renamed from: android.content.pm.UserInfo */
public class UserInfo implements Parcelable {
    public static final Creator<UserInfo> CREATOR = new C00551();
    public static final int FLAG_ADMIN = 2;
    public static final int FLAG_GUEST = 4;
    public static final int FLAG_INITIALIZED = 16;
    public static final int FLAG_MASK_USER_TYPE = 63;
    public static final int FLAG_PRIMARY = 1;
    public static final int FLAG_RESTRICTED = 8;
    public long creationTime;
    public int flags;
    public String iconPath;
    /* renamed from: id */
    public int f132id;
    public long lastLoggedInTime;
    public String name;
    public boolean partial;
    public int serialNumber;

    /* renamed from: android.content.pm.UserInfo$1 */
    class C00551 implements Creator<UserInfo> {
        C00551() {
        }

        public UserInfo createFromParcel(Parcel parcel) {
            return new UserInfo(parcel, null);
        }

        public UserInfo[] newArray(int i) {
            return new UserInfo[i];
        }
    }

    public UserInfo(int i, String str, int i2) {
        this(i, str, null, i2);
    }

    public UserInfo(int i, String str, String str2, int i2) {
        this.f132id = i;
        this.name = str;
        this.flags = i2;
        this.iconPath = str2;
    }

    public UserInfo(UserInfo userInfo) {
        this.name = userInfo.name;
        this.iconPath = userInfo.iconPath;
        this.f132id = userInfo.f132id;
        this.flags = userInfo.flags;
        this.serialNumber = userInfo.serialNumber;
        this.creationTime = userInfo.creationTime;
        this.lastLoggedInTime = userInfo.lastLoggedInTime;
        this.partial = userInfo.partial;
    }

    private UserInfo(Parcel parcel) {
        this.f132id = parcel.readInt();
        this.name = parcel.readString();
        this.iconPath = parcel.readString();
        this.flags = parcel.readInt();
        this.serialNumber = parcel.readInt();
        this.creationTime = parcel.readLong();
        this.lastLoggedInTime = parcel.readLong();
        this.partial = parcel.readInt() != 0;
    }

    /* synthetic */ UserInfo(Parcel parcel, UserInfo userInfo) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public UserHandle getUserHandle() {
        return null;
    }

    public boolean isAdmin() {
        return (this.flags & 2) == 2;
    }

    public boolean isGuest() {
        return (this.flags & 4) == 4;
    }

    public boolean isPrimary() {
        return (this.flags & 1) == 1;
    }

    public String toString() {
        return "UserInfo{" + this.f132id + ":" + this.name + ":" + Integer.toHexString(this.flags) + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f132id);
        parcel.writeString(this.name);
        parcel.writeString(this.iconPath);
        parcel.writeInt(this.flags);
        parcel.writeInt(this.serialNumber);
        parcel.writeLong(this.creationTime);
        parcel.writeLong(this.lastLoggedInTime);
        parcel.writeInt(this.partial ? 1 : 0);
    }
}
