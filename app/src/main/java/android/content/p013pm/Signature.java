package android.content.p013pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.ByteArrayInputStream;
import java.lang.ref.SoftReference;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.Arrays;

/* renamed from: android.content.pm.Signature */
public class Signature implements Parcelable {
    public static final Creator<Signature> CREATOR = new C00531();
    private int mHashCode;
    private boolean mHaveHashCode;
    private final byte[] mSignature;
    private SoftReference<String> mStringRef;

    /* renamed from: android.content.pm.Signature$1 */
    class C00531 implements Creator<Signature> {
        C00531() {
        }

        public Signature createFromParcel(Parcel parcel) {
            return new Signature(parcel, null);
        }

        public Signature[] newArray(int i) {
            return new Signature[i];
        }
    }

    private Signature(Parcel parcel) {
        this.mSignature = parcel.createByteArray();
    }

    /* synthetic */ Signature(Parcel parcel, Signature signature) {
        this(parcel);
    }

    public Signature(String str) {
        int i = 0;
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        if (length % 2 != 0) {
            throw new IllegalArgumentException("text size " + length + " is not even");
        }
        byte[] bArr = new byte[(length / 2)];
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            int parseHexDigit = Signature.parseHexDigit(bytes[i]);
            i = i3 + 1;
            int parseHexDigit2 = Signature.parseHexDigit(bytes[i3]);
            i3 = i2 + 1;
            bArr[i2] = (byte) ((parseHexDigit << 4) | parseHexDigit2);
            i2 = i3;
        }
        this.mSignature = bArr;
    }

    public Signature(byte[] bArr) {
        this.mSignature = (byte[]) bArr.clone();
    }

    private static final int parseHexDigit(int i) {
        if (48 <= i && i <= 57) {
            return i - 48;
        }
        if (97 <= i && i <= 102) {
            return (i - 97) + 10;
        }
        if (65 <= i && i <= 70) {
            return (i - 65) + 10;
        }
        throw new IllegalArgumentException("Invalid character " + i + " in hex string");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            Signature signature = (Signature) obj;
            return this == signature || Arrays.equals(this.mSignature, signature.mSignature);
        } catch (ClassCastException e) {
            return false;
        }
    }

    public PublicKey getPublicKey() {
        return CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(this.mSignature)).getPublicKey();
    }

    public int hashCode() {
        if (this.mHaveHashCode) {
            return this.mHashCode;
        }
        this.mHashCode = Arrays.hashCode(this.mSignature);
        this.mHaveHashCode = true;
        return this.mHashCode;
    }

    public byte[] toByteArray() {
        Object obj = new byte[this.mSignature.length];
        System.arraycopy(this.mSignature, 0, obj, 0, this.mSignature.length);
        return obj;
    }

    public char[] toChars() {
        return toChars(null, null);
    }

    public char[] toChars(char[] cArr, int[] iArr) {
        byte[] bArr = this.mSignature;
        int length = bArr.length;
        int i = length * 2;
        if (cArr == null || i > cArr.length) {
            cArr = new char[i];
        }
        for (int i2 = 0; i2 < length; i2++) {
            byte b = bArr[i2];
            i = (b >> 4) & 15;
            cArr[i2 * 2] = (char) (i >= 10 ? (i + 97) - 10 : i + 48);
            i = b & 15;
            cArr[(i2 * 2) + 1] = (char) (i >= 10 ? (i + 97) - 10 : i + 48);
        }
        if (iArr != null) {
            iArr[0] = length;
        }
        return cArr;
    }

    public String toCharsString() {
        String str = this.mStringRef == null ? null : (String) this.mStringRef.get();
        if (str != null) {
            return str;
        }
        str = new String(toChars());
        this.mStringRef = new SoftReference(str);
        return str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.mSignature);
    }
}
