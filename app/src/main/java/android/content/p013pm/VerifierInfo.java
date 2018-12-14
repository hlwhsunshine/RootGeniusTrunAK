package android.content.p013pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.security.PublicKey;

/* renamed from: android.content.pm.VerifierInfo */
public class VerifierInfo implements Parcelable {
    public static final Creator<VerifierInfo> CREATOR = new C00581();
    public final String packageName;
    public final PublicKey publicKey;

    /* renamed from: android.content.pm.VerifierInfo$1 */
    class C00581 implements Creator<VerifierInfo> {
        C00581() {
        }

        public VerifierInfo createFromParcel(Parcel parcel) {
            return new VerifierInfo(parcel, null);
        }

        public VerifierInfo[] newArray(int i) {
            return new VerifierInfo[i];
        }
    }

    private VerifierInfo(Parcel parcel) {
        this.packageName = parcel.readString();
        this.publicKey = (PublicKey) parcel.readSerializable();
    }

    public VerifierInfo(String str, PublicKey publicKey) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("packageName must not be null or empty");
        } else if (publicKey == null) {
            throw new IllegalArgumentException("publicKey must not be null");
        } else {
            this.packageName = str;
            this.publicKey = publicKey;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.packageName);
        parcel.writeSerializable(this.publicKey);
    }
}
