package android.content.p013pm;

import android.content.pm.ApplicationInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.content.pm.PackageInfo */
public class PackageInfo implements Parcelable {
    public static final Creator<PackageInfo> CREATOR = new C00401();
    public static final int INSTALL_LOCATION_AUTO = 0;
    public static final int INSTALL_LOCATION_INTERNAL_ONLY = 1;
    public static final int INSTALL_LOCATION_PREFER_EXTERNAL = 2;
    public static final int INSTALL_LOCATION_UNSPECIFIED = -1;
    public static final int REQUESTED_PERMISSION_GRANTED = 2;
    public static final int REQUESTED_PERMISSION_REQUIRED = 1;
    public ActivityInfo[] activities;
    public ApplicationInfo applicationInfo;
    public ConfigurationInfo[] configPreferences;
    private boolean drmProtectedThemeApk;
    public long firstInstallTime;
    public int[] gids;
    public int installLocation;
    public InstrumentationInfo[] instrumentation;
    public boolean isThemeApk;
    public long lastUpdateTime;
    private String lockedZipFilePath;
    public String packageName;
    public PermissionInfo[] permissions;
    public ProviderInfo[] providers;
    public ActivityInfo[] receivers;
    public FeatureInfo[] reqFeatures;
    public String[] requestedPermissions;
    public int[] requestedPermissionsFlags;
    public ServiceInfo[] services;
    public String sharedUserId;
    public int sharedUserLabel;
    public Signature[] signatures;
    public ThemeInfo[] themeInfos;
    public int versionCode;
    public String versionName;

    /* renamed from: android.content.pm.PackageInfo$1 */
    class C00401 implements Creator<PackageInfo> {
        C00401() {
        }

        public PackageInfo createFromParcel(Parcel parcel) {
            return new PackageInfo(parcel, null);
        }

        public PackageInfo[] newArray(int i) {
            return new PackageInfo[i];
        }
    }

    public PackageInfo() {
        this.installLocation = 1;
        this.isThemeApk = false;
        this.drmProtectedThemeApk = false;
    }

    private PackageInfo(Parcel parcel) {
        boolean z = true;
        this.installLocation = 1;
        this.isThemeApk = false;
        this.drmProtectedThemeApk = false;
        this.packageName = parcel.readString();
        this.versionCode = parcel.readInt();
        this.versionName = parcel.readString();
        this.sharedUserId = parcel.readString();
        this.sharedUserLabel = parcel.readInt();
        if (parcel.readInt() != 0) {
            this.applicationInfo = (ApplicationInfo) ApplicationInfo.CREATOR.createFromParcel(parcel);
        }
        this.firstInstallTime = parcel.readLong();
        this.lastUpdateTime = parcel.readLong();
        this.gids = parcel.createIntArray();
        this.activities = (ActivityInfo[]) parcel.createTypedArray(ActivityInfo.CREATOR);
        this.receivers = (ActivityInfo[]) parcel.createTypedArray(ActivityInfo.CREATOR);
        this.services = (ServiceInfo[]) parcel.createTypedArray(ServiceInfo.CREATOR);
        this.providers = (ProviderInfo[]) parcel.createTypedArray(ProviderInfo.CREATOR);
        this.instrumentation = (InstrumentationInfo[]) parcel.createTypedArray(InstrumentationInfo.CREATOR);
        this.permissions = (PermissionInfo[]) parcel.createTypedArray(PermissionInfo.CREATOR);
        this.requestedPermissions = parcel.createStringArray();
        this.requestedPermissionsFlags = parcel.createIntArray();
        this.signatures = (Signature[]) parcel.createTypedArray(Signature.CREATOR);
        this.configPreferences = (ConfigurationInfo[]) parcel.createTypedArray(ConfigurationInfo.CREATOR);
        this.reqFeatures = (FeatureInfo[]) parcel.createTypedArray(FeatureInfo.CREATOR);
        this.installLocation = parcel.readInt();
        this.isThemeApk = parcel.readInt() != 0;
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.drmProtectedThemeApk = z;
        this.themeInfos = (ThemeInfo[]) parcel.createTypedArray(ThemeInfo.CREATOR);
        this.lockedZipFilePath = parcel.readString();
    }

    /* synthetic */ PackageInfo(Parcel parcel, PackageInfo packageInfo) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public String getLockedZipFilePath() {
        return this.lockedZipFilePath;
    }

    public boolean isDrmProtectedThemeApk() {
        return this.drmProtectedThemeApk;
    }

    public void setDrmProtectedThemeApk(boolean z) {
        this.drmProtectedThemeApk = z;
    }

    public void setLockedZipFilePath(String str) {
        this.lockedZipFilePath = str;
    }

    public String toString() {
        return "PackageInfo{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.packageName + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.packageName);
        parcel.writeInt(this.versionCode);
        parcel.writeString(this.versionName);
        parcel.writeString(this.sharedUserId);
        parcel.writeInt(this.sharedUserLabel);
        if (this.applicationInfo != null) {
            parcel.writeInt(1);
            this.applicationInfo.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeLong(this.firstInstallTime);
        parcel.writeLong(this.lastUpdateTime);
        parcel.writeIntArray(this.gids);
        parcel.writeTypedArray(this.activities, i);
        parcel.writeTypedArray(this.receivers, i);
        parcel.writeTypedArray(this.services, i);
        parcel.writeTypedArray(this.providers, i);
        parcel.writeTypedArray(this.instrumentation, i);
        parcel.writeTypedArray(this.permissions, i);
        parcel.writeStringArray(this.requestedPermissions);
        parcel.writeIntArray(this.requestedPermissionsFlags);
        parcel.writeTypedArray(this.signatures, i);
        parcel.writeTypedArray(this.configPreferences, i);
        parcel.writeTypedArray(this.reqFeatures, i);
        parcel.writeInt(this.installLocation);
        parcel.writeInt(this.isThemeApk ? 1 : 0);
        if (!this.drmProtectedThemeApk) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeTypedArray(this.themeInfos, i);
        parcel.writeString(this.lockedZipFilePath);
    }
}
