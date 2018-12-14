package android.content.p013pm;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.content.pm.VerificationParams */
public class VerificationParams implements Parcelable {
    public static final Creator<VerificationParams> CREATOR = new C00561();
    public static final int NO_UID = -1;
    private static final String TO_STRING_PREFIX = "VerificationParams{";
    private int mInstallerUid;
    private final ManifestDigest mManifestDigest;
    private final Uri mOriginatingURI;
    private final int mOriginatingUid;
    private final Uri mReferrer;
    private final Uri mVerificationURI;

    /* renamed from: android.content.pm.VerificationParams$1 */
    class C00561 implements Creator<VerificationParams> {
        C00561() {
        }

        public VerificationParams createFromParcel(Parcel parcel) {
            return new VerificationParams(parcel, null);
        }

        public VerificationParams[] newArray(int i) {
            return new VerificationParams[i];
        }
    }

    public VerificationParams(Uri uri, Uri uri2, Uri uri3, int i, ManifestDigest manifestDigest) {
        this.mVerificationURI = uri;
        this.mOriginatingURI = uri2;
        this.mReferrer = uri3;
        this.mOriginatingUid = i;
        this.mManifestDigest = manifestDigest;
        this.mInstallerUid = -1;
    }

    private VerificationParams(Parcel parcel) {
        this.mVerificationURI = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.mOriginatingURI = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.mReferrer = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.mOriginatingUid = parcel.readInt();
        this.mManifestDigest = (ManifestDigest) parcel.readParcelable(ManifestDigest.class.getClassLoader());
        this.mInstallerUid = parcel.readInt();
    }

    /* synthetic */ VerificationParams(Parcel parcel, VerificationParams verificationParams) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerificationParams)) {
            return false;
        }
        VerificationParams verificationParams = (VerificationParams) obj;
        if (this.mVerificationURI == null) {
            if (verificationParams.mVerificationURI != null) {
                return false;
            }
        } else if (!this.mVerificationURI.equals(verificationParams.mVerificationURI)) {
            return false;
        }
        if (this.mOriginatingURI == null) {
            if (verificationParams.mOriginatingURI != null) {
                return false;
            }
        } else if (!this.mOriginatingURI.equals(verificationParams.mOriginatingURI)) {
            return false;
        }
        if (this.mReferrer == null) {
            if (verificationParams.mReferrer != null) {
                return false;
            }
        } else if (!this.mReferrer.equals(verificationParams.mReferrer)) {
            return false;
        }
        if (this.mOriginatingUid != verificationParams.mOriginatingUid) {
            return false;
        }
        if (this.mManifestDigest == null) {
            if (verificationParams.mManifestDigest != null) {
                return false;
            }
        } else if (!this.mManifestDigest.equals(verificationParams.mManifestDigest)) {
            return false;
        }
        return this.mInstallerUid == verificationParams.mInstallerUid;
    }

    public int getInstallerUid() {
        return this.mInstallerUid;
    }

    public ManifestDigest getManifestDigest() {
        return this.mManifestDigest;
    }

    public Uri getOriginatingURI() {
        return this.mOriginatingURI;
    }

    public int getOriginatingUid() {
        return this.mOriginatingUid;
    }

    public Uri getReferrer() {
        return this.mReferrer;
    }

    public Uri getVerificationURI() {
        return this.mVerificationURI;
    }

    public int hashCode() {
        int i = 1;
        int hashCode = (((this.mReferrer == null ? 1 : this.mReferrer.hashCode()) * 11) + ((((this.mVerificationURI == null ? 1 : this.mVerificationURI.hashCode()) * 5) + 3) + ((this.mOriginatingURI == null ? 1 : this.mOriginatingURI.hashCode()) * 7))) + (this.mOriginatingUid * 13);
        if (this.mManifestDigest != null) {
            i = this.mManifestDigest.hashCode();
        }
        return (hashCode + (i * 17)) + (this.mInstallerUid * 19);
    }

    public void setInstallerUid(int i) {
        this.mInstallerUid = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(TO_STRING_PREFIX);
        stringBuilder.append("mVerificationURI=");
        stringBuilder.append(this.mVerificationURI.toString());
        stringBuilder.append(",mOriginatingURI=");
        stringBuilder.append(this.mOriginatingURI.toString());
        stringBuilder.append(",mReferrer=");
        stringBuilder.append(this.mReferrer.toString());
        stringBuilder.append(",mOriginatingUid=");
        stringBuilder.append(this.mOriginatingUid);
        stringBuilder.append(",mManifestDigest=");
        stringBuilder.append(this.mManifestDigest.toString());
        stringBuilder.append(",mInstallerUid=");
        stringBuilder.append(this.mInstallerUid);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mVerificationURI, 0);
        parcel.writeParcelable(this.mOriginatingURI, 0);
        parcel.writeParcelable(this.mReferrer, 0);
        parcel.writeInt(this.mOriginatingUid);
        parcel.writeParcelable(this.mManifestDigest, 0);
        parcel.writeInt(this.mInstallerUid);
    }
}
