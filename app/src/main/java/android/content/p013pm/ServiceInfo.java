package android.content.p013pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Printer;

/* renamed from: android.content.pm.ServiceInfo */
public class ServiceInfo extends ComponentInfo implements Parcelable {
    public static final Creator<ServiceInfo> CREATOR = new C00521();
    public static final int FLAG_ISOLATED_PROCESS = 2;
    public static final int FLAG_SINGLE_USER = 1073741824;
    public static final int FLAG_STOP_WITH_TASK = 1;
    public int flags;
    public String permission;

    /* renamed from: android.content.pm.ServiceInfo$1 */
    class C00521 implements Creator<ServiceInfo> {
        C00521() {
        }

        public ServiceInfo createFromParcel(Parcel parcel) {
            return new ServiceInfo(parcel, null);
        }

        public ServiceInfo[] newArray(int i) {
            return new ServiceInfo[i];
        }
    }

    public ServiceInfo(ServiceInfo serviceInfo) {
        super((ComponentInfo) serviceInfo);
        this.permission = serviceInfo.permission;
        this.flags = serviceInfo.flags;
    }

    private ServiceInfo(Parcel parcel) {
        super(parcel);
        this.permission = parcel.readString();
        this.flags = parcel.readInt();
    }

    /* synthetic */ ServiceInfo(Parcel parcel, ServiceInfo serviceInfo) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void dump(Printer printer, String str) {
        super.dumpFront(printer, str);
        printer.println(new StringBuilder(String.valueOf(str)).append("permission=").append(this.permission).toString());
        printer.println(new StringBuilder(String.valueOf(str)).append("flags=0x").append(Integer.toHexString(this.flags)).toString());
    }

    public String toString() {
        return "ServiceInfo{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.name + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.permission);
        parcel.writeInt(this.flags);
    }
}
