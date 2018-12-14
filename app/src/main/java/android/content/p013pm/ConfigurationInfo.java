package android.content.p013pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p015v4.internal.view.SupportMenu;

/* renamed from: android.content.pm.ConfigurationInfo */
public class ConfigurationInfo implements Parcelable {
    public static final Creator<ConfigurationInfo> CREATOR = new C00331();
    public static final int GL_ES_VERSION_UNDEFINED = 0;
    public static final int INPUT_FEATURE_FIVE_WAY_NAV = 2;
    public static final int INPUT_FEATURE_HARD_KEYBOARD = 1;
    public int reqGlEsVersion;
    public int reqInputFeatures;
    public int reqKeyboardType;
    public int reqNavigation;
    public int reqTouchScreen;

    /* renamed from: android.content.pm.ConfigurationInfo$1 */
    class C00331 implements Creator<ConfigurationInfo> {
        C00331() {
        }

        public ConfigurationInfo createFromParcel(Parcel parcel) {
            return new ConfigurationInfo(parcel, null);
        }

        public ConfigurationInfo[] newArray(int i) {
            return new ConfigurationInfo[i];
        }
    }

    public ConfigurationInfo() {
        this.reqInputFeatures = 0;
    }

    public ConfigurationInfo(ConfigurationInfo configurationInfo) {
        this.reqInputFeatures = 0;
        this.reqTouchScreen = configurationInfo.reqTouchScreen;
        this.reqKeyboardType = configurationInfo.reqKeyboardType;
        this.reqNavigation = configurationInfo.reqNavigation;
        this.reqInputFeatures = configurationInfo.reqInputFeatures;
        this.reqGlEsVersion = configurationInfo.reqGlEsVersion;
    }

    private ConfigurationInfo(Parcel parcel) {
        this.reqInputFeatures = 0;
        this.reqTouchScreen = parcel.readInt();
        this.reqKeyboardType = parcel.readInt();
        this.reqNavigation = parcel.readInt();
        this.reqInputFeatures = parcel.readInt();
        this.reqGlEsVersion = parcel.readInt();
    }

    /* synthetic */ ConfigurationInfo(Parcel parcel, ConfigurationInfo configurationInfo) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public String getGlEsVersion() {
        return new StringBuilder(String.valueOf(String.valueOf((this.reqGlEsVersion & SupportMenu.CATEGORY_MASK) >> 16))).append(".").append(String.valueOf(this.reqGlEsVersion & SupportMenu.USER_MASK)).toString();
    }

    public String toString() {
        return "ConfigurationInfo{" + Integer.toHexString(System.identityHashCode(this)) + " touchscreen = " + this.reqTouchScreen + " inputMethod = " + this.reqKeyboardType + " navigation = " + this.reqNavigation + " reqInputFeatures = " + this.reqInputFeatures + " reqGlEsVersion = " + this.reqGlEsVersion + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.reqTouchScreen);
        parcel.writeInt(this.reqKeyboardType);
        parcel.writeInt(this.reqNavigation);
        parcel.writeInt(this.reqInputFeatures);
        parcel.writeInt(this.reqGlEsVersion);
    }
}
