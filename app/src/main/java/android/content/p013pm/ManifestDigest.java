package android.content.p013pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import java.util.Arrays;
import java.util.jar.Attributes;

/* renamed from: android.content.pm.ManifestDigest */
public class ManifestDigest implements Parcelable {
    public static final Creator<ManifestDigest> CREATOR = new C00381();
    private static final String[] DIGEST_TYPES = new String[]{"SHA1-Digest", "SHA-Digest", "MD5-Digest"};
    private static final String TO_STRING_PREFIX = "ManifestDigest {mDigest=";
    private final byte[] mDigest;

    /* renamed from: android.content.pm.ManifestDigest$1 */
    class C00381 implements Creator<ManifestDigest> {
        C00381() {
        }

        public ManifestDigest createFromParcel(Parcel parcel) {
            return new ManifestDigest(parcel, null);
        }

        public ManifestDigest[] newArray(int i) {
            return new ManifestDigest[i];
        }
    }

    private ManifestDigest(Parcel parcel) {
        this.mDigest = parcel.createByteArray();
    }

    /* synthetic */ ManifestDigest(Parcel parcel, ManifestDigest manifestDigest) {
        this(parcel);
    }

    ManifestDigest(byte[] bArr) {
        this.mDigest = bArr;
    }

    static ManifestDigest fromAttributes(Attributes attributes) {
        if (attributes == null) {
            return null;
        }
        String str;
        for (String value : DIGEST_TYPES) {
            String value2 = attributes.getValue(value2);
            if (value2 != null) {
                str = value2;
                break;
            }
        }
        str = null;
        return str == null ? null : new ManifestDigest(Base64.decode(str, 0));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ManifestDigest)) {
            return false;
        }
        ManifestDigest manifestDigest = (ManifestDigest) obj;
        return this == manifestDigest || Arrays.equals(this.mDigest, manifestDigest.mDigest);
    }

    public int hashCode() {
        return Arrays.hashCode(this.mDigest);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(((this.mDigest.length * 3) + 24) + 1);
        stringBuilder.append(TO_STRING_PREFIX);
        int length = this.mDigest.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(',');
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.mDigest);
    }
}
