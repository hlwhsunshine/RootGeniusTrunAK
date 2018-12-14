package android.content.p013pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* renamed from: android.content.pm.ContainerEncryptionParams */
public class ContainerEncryptionParams implements Parcelable {
    public static final Creator<ContainerEncryptionParams> CREATOR = new C00341();
    private static final int ENC_PARAMS_IV_PARAMETERS = 1;
    private static final int MAC_PARAMS_NONE = 1;
    protected static final String TAG = "ContainerEncryptionParams";
    private static final String TO_STRING_PREFIX = "ContainerEncryptionParams{";
    private final long mAuthenticatedDataStart;
    private final long mDataEnd;
    private final long mEncryptedDataStart;
    private final String mEncryptionAlgorithm;
    private final SecretKey mEncryptionKey;
    private final IvParameterSpec mEncryptionSpec;
    private final String mMacAlgorithm;
    private final SecretKey mMacKey;
    private final AlgorithmParameterSpec mMacSpec;
    private final byte[] mMacTag;

    /* renamed from: android.content.pm.ContainerEncryptionParams$1 */
    class C00341 implements Creator<ContainerEncryptionParams> {
        C00341() {
        }

        public ContainerEncryptionParams createFromParcel(Parcel parcel) {
            try {
                return new ContainerEncryptionParams(parcel, null);
            } catch (InvalidAlgorithmParameterException e) {
                return null;
            }
        }

        public ContainerEncryptionParams[] newArray(int i) {
            return new ContainerEncryptionParams[i];
        }
    }

    private ContainerEncryptionParams(Parcel parcel) {
        this.mEncryptionAlgorithm = parcel.readString();
        int readInt = parcel.readInt();
        byte[] createByteArray = parcel.createByteArray();
        this.mEncryptionKey = (SecretKey) parcel.readSerializable();
        this.mMacAlgorithm = parcel.readString();
        int readInt2 = parcel.readInt();
        parcel.createByteArray();
        this.mMacKey = (SecretKey) parcel.readSerializable();
        this.mMacTag = parcel.createByteArray();
        this.mAuthenticatedDataStart = parcel.readLong();
        this.mEncryptedDataStart = parcel.readLong();
        this.mDataEnd = parcel.readLong();
        switch (readInt) {
            case 1:
                this.mEncryptionSpec = new IvParameterSpec(createByteArray);
                switch (readInt2) {
                    case 1:
                        this.mMacSpec = null;
                        if (this.mEncryptionKey == null) {
                            throw new NullPointerException("encryptionKey == null");
                        }
                        return;
                    default:
                        throw new InvalidAlgorithmParameterException("Unknown parameter type " + readInt2);
                }
            default:
                throw new InvalidAlgorithmParameterException("Unknown parameter type " + readInt);
        }
    }

    /* synthetic */ ContainerEncryptionParams(Parcel parcel, ContainerEncryptionParams containerEncryptionParams) {
        this(parcel);
    }

    public ContainerEncryptionParams(String str, AlgorithmParameterSpec algorithmParameterSpec, SecretKey secretKey) {
        this(str, algorithmParameterSpec, secretKey, null, null, null, null, -1, -1, -1);
    }

    public ContainerEncryptionParams(String str, AlgorithmParameterSpec algorithmParameterSpec, SecretKey secretKey, String str2, AlgorithmParameterSpec algorithmParameterSpec2, SecretKey secretKey2, byte[] bArr, long j, long j2, long j3) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("algorithm == null");
        } else if (algorithmParameterSpec == null) {
            throw new NullPointerException("encryptionSpec == null");
        } else if (secretKey == null) {
            throw new NullPointerException("encryptionKey == null");
        } else if (!TextUtils.isEmpty(str2) && secretKey2 == null) {
            throw new NullPointerException("macKey == null");
        } else if (algorithmParameterSpec instanceof IvParameterSpec) {
            this.mEncryptionAlgorithm = str;
            this.mEncryptionSpec = (IvParameterSpec) algorithmParameterSpec;
            this.mEncryptionKey = secretKey;
            this.mMacAlgorithm = str2;
            this.mMacSpec = algorithmParameterSpec2;
            this.mMacKey = secretKey2;
            this.mMacTag = bArr;
            this.mAuthenticatedDataStart = j;
            this.mEncryptedDataStart = j2;
            this.mDataEnd = j3;
        } else {
            throw new InvalidAlgorithmParameterException("Unknown parameter spec class; must be IvParameters");
        }
    }

    private static final boolean isSecretKeyEqual(SecretKey secretKey, SecretKey secretKey2) {
        String format = secretKey.getFormat();
        String format2 = secretKey2.getFormat();
        if (format == null) {
            if (!(format == format2 && secretKey.getEncoded() == secretKey2.getEncoded())) {
                return false;
            }
        } else if (!(format.equals(secretKey2.getFormat()) && Arrays.equals(secretKey.getEncoded(), secretKey2.getEncoded()))) {
            return false;
        }
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContainerEncryptionParams)) {
            return false;
        }
        ContainerEncryptionParams containerEncryptionParams = (ContainerEncryptionParams) obj;
        return (this.mAuthenticatedDataStart == containerEncryptionParams.mAuthenticatedDataStart && this.mEncryptedDataStart == containerEncryptionParams.mEncryptedDataStart && this.mDataEnd == containerEncryptionParams.mDataEnd) ? (this.mEncryptionAlgorithm.equals(containerEncryptionParams.mEncryptionAlgorithm) && this.mMacAlgorithm.equals(containerEncryptionParams.mMacAlgorithm)) ? (ContainerEncryptionParams.isSecretKeyEqual(this.mEncryptionKey, containerEncryptionParams.mEncryptionKey) && ContainerEncryptionParams.isSecretKeyEqual(this.mMacKey, containerEncryptionParams.mMacKey)) ? Arrays.equals(this.mEncryptionSpec.getIV(), containerEncryptionParams.mEncryptionSpec.getIV()) && Arrays.equals(this.mMacTag, containerEncryptionParams.mMacTag) && this.mMacSpec == containerEncryptionParams.mMacSpec : false : false : false;
    }

    public long getAuthenticatedDataStart() {
        return this.mAuthenticatedDataStart;
    }

    public long getDataEnd() {
        return this.mDataEnd;
    }

    public long getEncryptedDataStart() {
        return this.mEncryptedDataStart;
    }

    public String getEncryptionAlgorithm() {
        return this.mEncryptionAlgorithm;
    }

    public SecretKey getEncryptionKey() {
        return this.mEncryptionKey;
    }

    public AlgorithmParameterSpec getEncryptionSpec() {
        return this.mEncryptionSpec;
    }

    public String getMacAlgorithm() {
        return this.mMacAlgorithm;
    }

    public SecretKey getMacKey() {
        return this.mMacKey;
    }

    public AlgorithmParameterSpec getMacSpec() {
        return this.mMacSpec;
    }

    public byte[] getMacTag() {
        return this.mMacTag;
    }

    public int hashCode() {
        return (int) (((long) ((int) (((long) ((int) (((long) (((((((this.mEncryptionAlgorithm.hashCode() * 5) + 3) + (Arrays.hashCode(this.mEncryptionSpec.getIV()) * 7)) + (this.mEncryptionKey.hashCode() * 11)) + (this.mMacAlgorithm.hashCode() * 13)) + (this.mMacKey.hashCode() * 17)) + (Arrays.hashCode(this.mMacTag) * 19))) + (23 * this.mAuthenticatedDataStart)))) + (29 * this.mEncryptedDataStart)))) + (31 * this.mDataEnd));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(TO_STRING_PREFIX);
        stringBuilder.append("mEncryptionAlgorithm=\"");
        stringBuilder.append(this.mEncryptionAlgorithm);
        stringBuilder.append("\",");
        stringBuilder.append("mEncryptionSpec=");
        stringBuilder.append(this.mEncryptionSpec.toString());
        stringBuilder.append("mEncryptionKey=");
        stringBuilder.append(this.mEncryptionKey.toString());
        stringBuilder.append("mMacAlgorithm=\"");
        stringBuilder.append(this.mMacAlgorithm);
        stringBuilder.append("\",");
        stringBuilder.append("mMacSpec=");
        stringBuilder.append(this.mMacSpec.toString());
        stringBuilder.append("mMacKey=");
        stringBuilder.append(this.mMacKey.toString());
        stringBuilder.append(",mAuthenticatedDataStart=");
        stringBuilder.append(this.mAuthenticatedDataStart);
        stringBuilder.append(",mEncryptedDataStart=");
        stringBuilder.append(this.mEncryptedDataStart);
        stringBuilder.append(",mDataEnd=");
        stringBuilder.append(this.mDataEnd);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mEncryptionAlgorithm);
        parcel.writeInt(1);
        parcel.writeByteArray(this.mEncryptionSpec.getIV());
        parcel.writeSerializable(this.mEncryptionKey);
        parcel.writeString(this.mMacAlgorithm);
        parcel.writeInt(1);
        parcel.writeByteArray(new byte[0]);
        parcel.writeSerializable(this.mMacKey);
        parcel.writeByteArray(this.mMacTag);
        parcel.writeLong(this.mAuthenticatedDataStart);
        parcel.writeLong(this.mEncryptedDataStart);
        parcel.writeLong(this.mDataEnd);
    }
}
