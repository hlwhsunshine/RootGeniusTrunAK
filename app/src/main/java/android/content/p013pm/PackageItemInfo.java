package android.content.p013pm;

import android.content.pm.ApplicationInfo;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Printer;
import java.text.Collator;
import java.util.Comparator;

/* renamed from: android.content.pm.PackageItemInfo */
public class PackageItemInfo {
    public int icon;
    public int labelRes;
    public int logo;
    public Bundle metaData;
    public String name;
    public CharSequence nonLocalizedLabel;
    public String packageName;

    /* renamed from: android.content.pm.PackageItemInfo$DisplayNameComparator */
    public static class DisplayNameComparator implements Comparator<PackageItemInfo> {
        private PackageManager mPM;
        private final Collator sCollator = Collator.getInstance();

        public DisplayNameComparator(PackageManager packageManager) {
            this.mPM = packageManager;
        }

        public final int compare(PackageItemInfo packageItemInfo, PackageItemInfo packageItemInfo2) {
            CharSequence loadLabel = packageItemInfo.loadLabel(this.mPM);
            if (loadLabel == null) {
                loadLabel = packageItemInfo.name;
            }
            CharSequence loadLabel2 = packageItemInfo2.loadLabel(this.mPM);
            if (loadLabel2 == null) {
                loadLabel2 = packageItemInfo2.name;
            }
            return this.sCollator.compare(loadLabel.toString(), loadLabel2.toString());
        }
    }

    public PackageItemInfo(PackageItemInfo packageItemInfo) {
        this.name = packageItemInfo.name;
        if (this.name != null) {
            this.name = this.name.trim();
        }
        this.packageName = packageItemInfo.packageName;
        this.labelRes = packageItemInfo.labelRes;
        this.nonLocalizedLabel = packageItemInfo.nonLocalizedLabel;
        if (this.nonLocalizedLabel != null) {
            this.nonLocalizedLabel = this.nonLocalizedLabel.toString().trim();
        }
        this.icon = packageItemInfo.icon;
        this.logo = packageItemInfo.logo;
        this.metaData = packageItemInfo.metaData;
    }

    protected PackageItemInfo(Parcel parcel) {
        this.name = parcel.readString();
        this.packageName = parcel.readString();
        this.labelRes = parcel.readInt();
        this.nonLocalizedLabel = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.icon = parcel.readInt();
        this.logo = parcel.readInt();
        this.metaData = parcel.readBundle();
    }

    protected void dumpBack(Printer printer, String str) {
    }

    protected void dumpFront(Printer printer, String str) {
        if (this.name != null) {
            printer.println(new StringBuilder(String.valueOf(str)).append("name=").append(this.name).toString());
        }
        printer.println(new StringBuilder(String.valueOf(str)).append("packageName=").append(this.packageName).toString());
        if (this.labelRes != 0 || this.nonLocalizedLabel != null || this.icon != 0) {
            printer.println(new StringBuilder(String.valueOf(str)).append("labelRes=0x").append(Integer.toHexString(this.labelRes)).append(" nonLocalizedLabel=").append(this.nonLocalizedLabel).append(" icon=0x").append(Integer.toHexString(this.icon)).toString());
        }
    }

    protected ApplicationInfo getApplicationInfo() {
        return null;
    }

    protected Drawable loadDefaultIcon(PackageManager packageManager) {
        return packageManager.getDefaultActivityIcon();
    }

    protected Drawable loadDefaultLogo(PackageManager packageManager) {
        return null;
    }

    public Drawable loadIcon(PackageManager packageManager) {
        if (this.icon != 0) {
            Drawable drawable = packageManager.getDrawable(this.packageName, this.icon, getApplicationInfo());
            if (drawable != null) {
                return drawable;
            }
        }
        return loadDefaultIcon(packageManager);
    }

    public CharSequence loadLabel(PackageManager packageManager) {
        if (this.nonLocalizedLabel != null) {
            return this.nonLocalizedLabel;
        }
        if (this.labelRes != 0) {
            CharSequence text = packageManager.getText(this.packageName, this.labelRes, getApplicationInfo());
            if (text != null) {
                return text.toString().trim();
            }
        }
        return this.name != null ? this.name : this.packageName;
    }

    public Drawable loadLogo(PackageManager packageManager) {
        if (this.logo != 0) {
            Drawable drawable = packageManager.getDrawable(this.packageName, this.logo, getApplicationInfo());
            if (drawable != null) {
                return drawable;
            }
        }
        return loadDefaultLogo(packageManager);
    }

    public XmlResourceParser loadXmlMetaData(PackageManager packageManager, String str) {
        if (this.metaData != null) {
            int i = this.metaData.getInt(str);
            if (i != 0) {
                return packageManager.getXml(this.packageName, i, getApplicationInfo());
            }
        }
        return null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.packageName);
        parcel.writeInt(this.labelRes);
        TextUtils.writeToParcel(this.nonLocalizedLabel, parcel, i);
        parcel.writeInt(this.icon);
        parcel.writeInt(this.logo);
        parcel.writeBundle(this.metaData);
    }
}
