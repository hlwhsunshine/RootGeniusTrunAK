package android.content.p013pm;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;

/* renamed from: android.content.pm.BaseThemeInfo */
public class BaseThemeInfo implements Parcelable {
    public static final Creator<BaseThemeInfo> CREATOR = new C00321();
    private static final String LOCKED_NAME = "locked/";
    public String author;
    public String copyright;
    public boolean isDrmProtected = false;
    public String name;
    public String notificationRingtoneFileName;
    public String notificationRingtoneName;
    public int previewResourceId;
    public String ringtoneFileName;
    public String ringtoneName;
    public String soundPackName;
    public int styleResourceId = 0;
    public String themeId;
    public String themeStyleName;
    public int thumbnailResourceId;
    public int wallpaperResourceId;

    /* renamed from: android.content.pm.BaseThemeInfo$1 */
    class C00321 implements Creator<BaseThemeInfo> {
        C00321() {
        }

        public BaseThemeInfo createFromParcel(Parcel parcel) {
            return new BaseThemeInfo(parcel);
        }

        public BaseThemeInfo[] newArray(int i) {
            return new BaseThemeInfo[i];
        }
    }

    protected BaseThemeInfo() {
    }

    protected BaseThemeInfo(Parcel parcel) {
        boolean z = false;
        this.wallpaperResourceId = parcel.readInt();
        this.thumbnailResourceId = parcel.readInt();
        this.themeId = parcel.readString();
        this.styleResourceId = parcel.readInt();
        this.name = parcel.readString();
        this.ringtoneFileName = parcel.readString();
        this.notificationRingtoneFileName = parcel.readString();
        this.ringtoneName = parcel.readString();
        this.notificationRingtoneName = parcel.readString();
        this.author = parcel.readString();
        this.copyright = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        }
        this.isDrmProtected = z;
        this.soundPackName = parcel.readString();
        this.themeStyleName = parcel.readString();
        this.previewResourceId = parcel.readInt();
    }

    protected void changeDrmFlagIfNeeded(String str) {
        if (str != null && str.contains(LOCKED_NAME)) {
            this.isDrmProtected = true;
        }
    }

    public int describeContents() {
        return 0;
    }

    public final String getResolvedString(Resources resources, AttributeSet attributeSet, int i) {
        int attributeResourceValue = attributeSet.getAttributeResourceValue(i, 0);
        return attributeResourceValue != 0 ? resources.getString(attributeResourceValue) : attributeSet.getAttributeValue(i);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.wallpaperResourceId);
        parcel.writeInt(this.thumbnailResourceId);
        parcel.writeString(this.themeId);
        parcel.writeInt(this.styleResourceId);
        parcel.writeString(this.name);
        parcel.writeString(this.ringtoneFileName);
        parcel.writeString(this.notificationRingtoneFileName);
        parcel.writeString(this.ringtoneName);
        parcel.writeString(this.notificationRingtoneName);
        parcel.writeString(this.author);
        parcel.writeString(this.copyright);
        parcel.writeInt(this.isDrmProtected ? 1 : 0);
        parcel.writeString(this.soundPackName);
        parcel.writeString(this.themeStyleName);
        parcel.writeInt(this.previewResourceId);
    }
}
