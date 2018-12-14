package android.content.p013pm;

import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.util.Printer;

/* renamed from: android.content.pm.ComponentInfo */
public class ComponentInfo extends PackageItemInfo {
    public ApplicationInfo applicationInfo;
    public int descriptionRes;
    public boolean enabled = true;
    public boolean exported = false;
    public String processName;

    public ComponentInfo(ComponentInfo componentInfo) {
        super((PackageItemInfo) componentInfo);
        this.applicationInfo = componentInfo.applicationInfo;
        this.processName = componentInfo.processName;
        this.descriptionRes = componentInfo.descriptionRes;
        this.enabled = componentInfo.enabled;
        this.exported = componentInfo.exported;
    }

    protected ComponentInfo(Parcel parcel) {
        boolean z = true;
        super(parcel);
        this.applicationInfo = (ApplicationInfo) ApplicationInfo.CREATOR.createFromParcel(parcel);
        this.processName = parcel.readString();
        this.descriptionRes = parcel.readInt();
        this.enabled = parcel.readInt() != 0;
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.exported = z;
    }

    protected void dumpBack(Printer printer, String str) {
        if (this.applicationInfo != null) {
            printer.println(new StringBuilder(String.valueOf(str)).append("ApplicationInfo:").toString());
            this.applicationInfo.dump(printer, new StringBuilder(String.valueOf(str)).append("  ").toString());
        } else {
            printer.println(new StringBuilder(String.valueOf(str)).append("ApplicationInfo: null").toString());
        }
        super.dumpBack(printer, str);
    }

    protected void dumpFront(Printer printer, String str) {
        super.dumpFront(printer, str);
        printer.println(new StringBuilder(String.valueOf(str)).append("enabled=").append(this.enabled).append(" exported=").append(this.exported).append(" processName=").append(this.processName).toString());
        if (this.descriptionRes != 0) {
            printer.println(new StringBuilder(String.valueOf(str)).append("description=").append(this.descriptionRes).toString());
        }
    }

    protected ApplicationInfo getApplicationInfo() {
        return this.applicationInfo;
    }

    public final int getIconResource() {
        return this.icon != 0 ? this.icon : this.applicationInfo.icon;
    }

    public boolean isEnabled() {
        return this.enabled && this.applicationInfo.enabled;
    }

    protected Drawable loadDefaultIcon(PackageManager packageManager) {
        return this.applicationInfo.loadIcon(packageManager);
    }

    protected Drawable loadDefaultLogo(PackageManager packageManager) {
        return this.applicationInfo.loadLogo(packageManager);
    }

    public CharSequence loadLabel(PackageManager packageManager) {
        if (this.nonLocalizedLabel != null) {
            return this.nonLocalizedLabel;
        }
        CharSequence text;
        ApplicationInfo applicationInfo = this.applicationInfo;
        if (this.labelRes != 0) {
            text = packageManager.getText(this.packageName, this.labelRes, applicationInfo);
            if (text != null) {
                return text;
            }
        }
        if (applicationInfo.nonLocalizedLabel != null) {
            return applicationInfo.nonLocalizedLabel;
        }
        if (applicationInfo.labelRes != 0) {
            text = packageManager.getText(this.packageName, applicationInfo.labelRes, applicationInfo);
            if (text != null) {
                return text;
            }
        }
        return this.name;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        super.writeToParcel(parcel, i);
        this.applicationInfo.writeToParcel(parcel, i);
        parcel.writeString(this.processName);
        parcel.writeInt(this.descriptionRes);
        parcel.writeInt(this.enabled ? 1 : 0);
        if (!this.exported) {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }
}
