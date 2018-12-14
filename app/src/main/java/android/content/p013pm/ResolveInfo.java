package android.content.p013pm;

import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Printer;
import java.text.Collator;
import java.util.Comparator;

/* renamed from: android.content.pm.ResolveInfo */
public class ResolveInfo implements Parcelable {
    public static final Creator<ResolveInfo> CREATOR = new C00511();
    public ActivityInfo activityInfo;
    public IntentFilter filter;
    public int icon;
    public boolean isDefault;
    public int labelRes;
    public int match;
    public CharSequence nonLocalizedLabel;
    public int preferredOrder;
    public int priority;
    public String resolvePackageName;
    public ServiceInfo serviceInfo;
    public int specificIndex;
    public boolean system;

    /* renamed from: android.content.pm.ResolveInfo$1 */
    class C00511 implements Creator<ResolveInfo> {
        C00511() {
        }

        public ResolveInfo createFromParcel(Parcel parcel) {
            return new ResolveInfo(parcel, null);
        }

        public ResolveInfo[] newArray(int i) {
            return new ResolveInfo[i];
        }
    }

    /* renamed from: android.content.pm.ResolveInfo$DisplayNameComparator */
    public static class DisplayNameComparator implements Comparator<ResolveInfo> {
        private PackageManager mPM;
        private final Collator sCollator = Collator.getInstance();

        public DisplayNameComparator(PackageManager packageManager) {
            this.mPM = packageManager;
        }

        public final int compare(ResolveInfo resolveInfo, ResolveInfo resolveInfo2) {
            CharSequence loadLabel = resolveInfo.loadLabel(this.mPM);
            if (loadLabel == null) {
                loadLabel = resolveInfo.activityInfo.name;
            }
            CharSequence loadLabel2 = resolveInfo2.loadLabel(this.mPM);
            if (loadLabel2 == null) {
                loadLabel2 = resolveInfo2.activityInfo.name;
            }
            return this.sCollator.compare(loadLabel.toString(), loadLabel2.toString());
        }
    }

    public ResolveInfo() {
        this.specificIndex = -1;
    }

    public ResolveInfo(ResolveInfo resolveInfo) {
        this.specificIndex = -1;
        this.activityInfo = resolveInfo.activityInfo;
        this.serviceInfo = resolveInfo.serviceInfo;
        this.filter = resolveInfo.filter;
        this.priority = resolveInfo.priority;
        this.preferredOrder = resolveInfo.preferredOrder;
        this.match = resolveInfo.match;
        this.specificIndex = resolveInfo.specificIndex;
        this.labelRes = resolveInfo.labelRes;
        this.nonLocalizedLabel = resolveInfo.nonLocalizedLabel;
        this.icon = resolveInfo.icon;
        this.resolvePackageName = resolveInfo.resolvePackageName;
        this.system = resolveInfo.system;
    }

    private ResolveInfo(Parcel parcel) {
        this.specificIndex = -1;
        switch (parcel.readInt()) {
            case 1:
                this.activityInfo = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(parcel);
                this.serviceInfo = null;
                break;
            case 2:
                this.serviceInfo = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(parcel);
                this.activityInfo = null;
                break;
            default:
                this.activityInfo = null;
                this.serviceInfo = null;
                break;
        }
        if (parcel.readInt() != 0) {
            this.filter = (IntentFilter) IntentFilter.CREATOR.createFromParcel(parcel);
        }
        this.priority = parcel.readInt();
        this.preferredOrder = parcel.readInt();
        this.match = parcel.readInt();
        this.specificIndex = parcel.readInt();
        this.labelRes = parcel.readInt();
        this.nonLocalizedLabel = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.icon = parcel.readInt();
        this.resolvePackageName = parcel.readString();
        this.system = parcel.readInt() != 0;
    }

    /* synthetic */ ResolveInfo(Parcel parcel, ResolveInfo resolveInfo) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void dump(Printer printer, String str) {
        if (this.filter != null) {
            printer.println(new StringBuilder(String.valueOf(str)).append("Filter:").toString());
            this.filter.dump(printer, new StringBuilder(String.valueOf(str)).append("  ").toString());
        }
        printer.println(new StringBuilder(String.valueOf(str)).append("priority=").append(this.priority).append(" preferredOrder=").append(this.preferredOrder).append(" match=0x").append(Integer.toHexString(this.match)).append(" specificIndex=").append(this.specificIndex).append(" isDefault=").append(this.isDefault).toString());
        if (this.resolvePackageName != null) {
            printer.println(new StringBuilder(String.valueOf(str)).append("resolvePackageName=").append(this.resolvePackageName).toString());
        }
        if (!(this.labelRes == 0 && this.nonLocalizedLabel == null && this.icon == 0)) {
            printer.println(new StringBuilder(String.valueOf(str)).append("labelRes=0x").append(Integer.toHexString(this.labelRes)).append(" nonLocalizedLabel=").append(this.nonLocalizedLabel).append(" icon=0x").append(Integer.toHexString(this.icon)).toString());
        }
        if (this.activityInfo != null) {
            printer.println(new StringBuilder(String.valueOf(str)).append("ActivityInfo:").toString());
            this.activityInfo.dump(printer, new StringBuilder(String.valueOf(str)).append("  ").toString());
        } else if (this.serviceInfo != null) {
            printer.println(new StringBuilder(String.valueOf(str)).append("ServiceInfo:").toString());
            this.serviceInfo.dump(printer, new StringBuilder(String.valueOf(str)).append("  ").toString());
        }
    }

    public final int getIconResource() {
        return this.icon != 0 ? this.icon : this.activityInfo != null ? this.activityInfo.getIconResource() : this.serviceInfo != null ? this.serviceInfo.getIconResource() : 0;
    }

    public Drawable loadIcon(PackageManager packageManager) {
        if (!(this.resolvePackageName == null || this.icon == 0)) {
            Drawable drawable = packageManager.getDrawable(this.resolvePackageName, this.icon, null);
            if (drawable != null) {
                return drawable;
            }
        }
        ComponentInfo componentInfo = this.activityInfo != null ? this.activityInfo : this.serviceInfo;
        ApplicationInfo applicationInfo = componentInfo.applicationInfo;
        if (this.icon != 0) {
            Drawable drawable2 = packageManager.getDrawable(componentInfo.packageName, this.icon, applicationInfo);
            if (drawable2 != null) {
                return drawable2;
            }
        }
        return componentInfo.loadIcon(packageManager);
    }

    public CharSequence loadLabel(PackageManager packageManager) {
        if (this.nonLocalizedLabel != null) {
            return this.nonLocalizedLabel;
        }
        CharSequence text;
        if (!(this.resolvePackageName == null || this.labelRes == 0)) {
            text = packageManager.getText(this.resolvePackageName, this.labelRes, null);
            if (text != null) {
                return text.toString().trim();
            }
        }
        ComponentInfo componentInfo = this.activityInfo != null ? this.activityInfo : this.serviceInfo;
        ApplicationInfo applicationInfo = componentInfo.applicationInfo;
        if (this.labelRes != 0) {
            CharSequence text2 = packageManager.getText(componentInfo.packageName, this.labelRes, applicationInfo);
            if (text2 != null) {
                return text2.toString().trim();
            }
        }
        text = componentInfo.loadLabel(packageManager);
        return text != null ? text.toString().trim() : text;
    }

    public String toString() {
        return "ResolveInfo{" + Integer.toHexString(System.identityHashCode(this)) + " " + (this.activityInfo != null ? this.activityInfo : this.serviceInfo).name + " p=" + this.priority + " o=" + this.preferredOrder + " m=0x" + Integer.toHexString(this.match) + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        if (this.activityInfo != null) {
            parcel.writeInt(1);
            this.activityInfo.writeToParcel(parcel, i);
        } else if (this.serviceInfo != null) {
            parcel.writeInt(2);
            this.serviceInfo.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        if (this.filter != null) {
            parcel.writeInt(1);
            this.filter.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.priority);
        parcel.writeInt(this.preferredOrder);
        parcel.writeInt(this.match);
        parcel.writeInt(this.specificIndex);
        parcel.writeInt(this.labelRes);
        TextUtils.writeToParcel(this.nonLocalizedLabel, parcel, i);
        parcel.writeInt(this.icon);
        parcel.writeString(this.resolvePackageName);
        if (!this.system) {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }
}
