package android.content.p013pm;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.PatternMatcher;

/* renamed from: android.content.pm.PathPermission */
public class PathPermission extends PatternMatcher {
    public static final Creator<PathPermission> CREATOR = new C00441();
    private final String mReadPermission;
    private final String mWritePermission;

    /* renamed from: android.content.pm.PathPermission$1 */
    class C00441 implements Creator<PathPermission> {
        C00441() {
        }

        public PathPermission createFromParcel(Parcel parcel) {
            return new PathPermission(parcel);
        }

        public PathPermission[] newArray(int i) {
            return new PathPermission[i];
        }
    }

    public PathPermission(Parcel parcel) {
        super(parcel);
        this.mReadPermission = parcel.readString();
        this.mWritePermission = parcel.readString();
    }

    public PathPermission(String str, int i, String str2, String str3) {
        super(str, i);
        this.mReadPermission = str2;
        this.mWritePermission = str3;
    }

    public String getReadPermission() {
        return this.mReadPermission;
    }

    public String getWritePermission() {
        return this.mWritePermission;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mReadPermission);
        parcel.writeString(this.mWritePermission);
    }
}
