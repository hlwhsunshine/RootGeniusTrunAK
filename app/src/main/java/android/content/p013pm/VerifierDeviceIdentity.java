package android.content.p013pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Random;

/* renamed from: android.content.pm.VerifierDeviceIdentity */
public class VerifierDeviceIdentity implements Parcelable {
    public static final Creator<VerifierDeviceIdentity> CREATOR = new C00571();
    private static final char[] ENCODE = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7'};
    private static final int GROUP_SIZE = 4;
    private static final int LONG_SIZE = 13;
    private static final char SEPARATOR = '-';
    private final long mIdentity;
    private final String mIdentityString;

    /* renamed from: android.content.pm.VerifierDeviceIdentity$1 */
    class C00571 implements Creator<VerifierDeviceIdentity> {
        C00571() {
        }

        public VerifierDeviceIdentity createFromParcel(Parcel parcel) {
            return new VerifierDeviceIdentity(parcel, null);
        }

        public VerifierDeviceIdentity[] newArray(int i) {
            return new VerifierDeviceIdentity[i];
        }
    }

    public VerifierDeviceIdentity(long j) {
        this.mIdentity = j;
        this.mIdentityString = VerifierDeviceIdentity.encodeBase32(j);
    }

    private VerifierDeviceIdentity(Parcel parcel) {
        long readLong = parcel.readLong();
        this.mIdentity = readLong;
        this.mIdentityString = VerifierDeviceIdentity.encodeBase32(readLong);
    }

    /* synthetic */ VerifierDeviceIdentity(Parcel parcel, VerifierDeviceIdentity verifierDeviceIdentity) {
        this(parcel);
    }

    private static final long decodeBase32(byte[] bArr) {
        int i = 0;
        long j = 0;
        for (byte b : bArr) {
            int i2;
            if ((byte) 65 <= b && b <= (byte) 90) {
                i2 = b - 65;
            } else if ((byte) 50 <= b && b <= (byte) 55) {
                i2 = b - 24;
            } else if (b == (byte) 45) {
                continue;
            } else if ((byte) 97 <= b && b <= (byte) 122) {
                i2 = b - 97;
            } else if (b == (byte) 48) {
                i2 = 14;
            } else if (b == (byte) 49) {
                i2 = 8;
            } else {
                throw new IllegalArgumentException("base base-32 character: " + b);
            }
            j = (j << 5) | ((long) i2);
            i++;
            if (i == 1) {
                if ((i2 & 15) != i2) {
                    throw new IllegalArgumentException("illegal start character; will overflow");
                }
            } else if (i > 13) {
                throw new IllegalArgumentException("too long; should have 13 characters");
            }
        }
        if (i == 13) {
            return j;
        }
        throw new IllegalArgumentException("too short; should have 13 characters");
    }

    private static final String encodeBase32(long j) {
        char[] cArr = ENCODE;
        char[] cArr2 = new char[16];
        int i = 16;
        int i2 = 0;
        while (i2 < 13) {
            if (i2 > 0 && i2 % 4 == 1) {
                i--;
                cArr2[i] = SEPARATOR;
            }
            j >>>= 5;
            int i3 = i - 1;
            cArr2[i3] = cArr[(int) (31 & j)];
            i2++;
            i = i3;
        }
        return String.valueOf(cArr2);
    }

    public static VerifierDeviceIdentity generate() {
        return VerifierDeviceIdentity.generate(new SecureRandom());
    }

    static VerifierDeviceIdentity generate(Random random) {
        return new VerifierDeviceIdentity(random.nextLong());
    }

    public static VerifierDeviceIdentity parse(String str) {
        try {
            return new VerifierDeviceIdentity(VerifierDeviceIdentity.decodeBase32(str.getBytes("US-ASCII")));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("bad base-32 characters in input");
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof VerifierDeviceIdentity)) {
            return false;
        }
        return this.mIdentity == ((VerifierDeviceIdentity) obj).mIdentity;
    }

    public int hashCode() {
        return (int) this.mIdentity;
    }

    public String toString() {
        return this.mIdentityString;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mIdentity);
    }
}
