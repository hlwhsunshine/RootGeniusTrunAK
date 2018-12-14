package android.content.p013pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Printer;

/* renamed from: android.content.pm.ActivityInfo */
public class ActivityInfo extends ComponentInfo implements Parcelable {
    public static final int CONFIG_DENSITY = 4096;
    public static final int CONFIG_FONT_SCALE = 1073741824;
    public static final int CONFIG_KEYBOARD = 16;
    public static final int CONFIG_KEYBOARD_HIDDEN = 32;
    public static final int CONFIG_LAYOUT_DIRECTION = 8192;
    public static final int CONFIG_LOCALE = 4;
    public static final int CONFIG_MCC = 1;
    public static final int CONFIG_MNC = 2;
    public static int[] CONFIG_NATIVE_BITS = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 2048, 4096, 512, 8192, 256, 16384};
    public static final int CONFIG_NAVIGATION = 64;
    public static final int CONFIG_ORIENTATION = 128;
    public static final int CONFIG_SCREEN_LAYOUT = 256;
    public static final int CONFIG_SCREEN_SIZE = 1024;
    public static final int CONFIG_SMALLEST_SCREEN_SIZE = 2048;
    public static final int CONFIG_THEME_RESOURCE = 32768;
    public static final int CONFIG_TOUCHSCREEN = 8;
    public static final int CONFIG_UI_MODE = 512;
    public static final Creator<ActivityInfo> CREATOR = new C00311();
    public static final int FLAG_ALLOW_TASK_REPARENTING = 64;
    public static final int FLAG_ALWAYS_RETAIN_TASK_STATE = 8;
    public static final int FLAG_CLEAR_TASK_ON_LAUNCH = 4;
    public static final int FLAG_EXCLUDE_FROM_RECENTS = 32;
    public static final int FLAG_FINISH_ON_CLOSE_SYSTEM_DIALOGS = 256;
    public static final int FLAG_FINISH_ON_TASK_LAUNCH = 2;
    public static final int FLAG_HARDWARE_ACCELERATED = 512;
    public static final int FLAG_IMMERSIVE = 2048;
    public static final int FLAG_MULTIPROCESS = 1;
    public static final int FLAG_NO_HISTORY = 128;
    public static final int FLAG_PRIMARY_USER_ONLY = 536870912;
    public static final int FLAG_SHOW_ON_LOCK_SCREEN = 1024;
    public static final int FLAG_SINGLE_USER = 1073741824;
    public static final int FLAG_STATE_NOT_NEEDED = 16;
    public static final int LAUNCH_MULTIPLE = 0;
    public static final int LAUNCH_SINGLE_INSTANCE = 3;
    public static final int LAUNCH_SINGLE_TASK = 2;
    public static final int LAUNCH_SINGLE_TOP = 1;
    public static final int SCREEN_ORIENTATION_BEHIND = 3;
    public static final int SCREEN_ORIENTATION_FULL_SENSOR = 10;
    public static final int SCREEN_ORIENTATION_LANDSCAPE = 0;
    public static final int SCREEN_ORIENTATION_NOSENSOR = 5;
    public static final int SCREEN_ORIENTATION_PORTRAIT = 1;
    public static final int SCREEN_ORIENTATION_REVERSE_LANDSCAPE = 8;
    public static final int SCREEN_ORIENTATION_REVERSE_PORTRAIT = 9;
    public static final int SCREEN_ORIENTATION_SENSOR = 4;
    public static final int SCREEN_ORIENTATION_SENSOR_LANDSCAPE = 6;
    public static final int SCREEN_ORIENTATION_SENSOR_PORTRAIT = 7;
    public static final int SCREEN_ORIENTATION_UNSPECIFIED = -1;
    public static final int SCREEN_ORIENTATION_USER = 2;
    public static final int UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW = 1;
    public int configChanges;
    public int flags;
    public int launchMode;
    public String parentActivityName;
    public String permission;
    public int screenOrientation;
    public int softInputMode;
    public String targetActivity;
    public String taskAffinity;
    public int theme;
    public int uiOptions;

    /* renamed from: android.content.pm.ActivityInfo$1 */
    class C00311 implements Creator<ActivityInfo> {
        C00311() {
        }

        public ActivityInfo createFromParcel(Parcel parcel) {
            return new ActivityInfo(parcel, null);
        }

        public ActivityInfo[] newArray(int i) {
            return new ActivityInfo[i];
        }
    }

    public ActivityInfo() {
        this.screenOrientation = -1;
        this.uiOptions = 0;
    }

    public ActivityInfo(ActivityInfo activityInfo) {
        super((ComponentInfo) activityInfo);
        this.screenOrientation = -1;
        this.uiOptions = 0;
        this.theme = activityInfo.theme;
        this.launchMode = activityInfo.launchMode;
        this.permission = activityInfo.permission;
        this.taskAffinity = activityInfo.taskAffinity;
        this.targetActivity = activityInfo.targetActivity;
        this.flags = activityInfo.flags;
        this.screenOrientation = activityInfo.screenOrientation;
        this.configChanges = activityInfo.configChanges;
        this.softInputMode = activityInfo.softInputMode;
        this.uiOptions = activityInfo.uiOptions;
        this.parentActivityName = activityInfo.parentActivityName;
    }

    private ActivityInfo(Parcel parcel) {
        super(parcel);
        this.screenOrientation = -1;
        this.uiOptions = 0;
        this.theme = parcel.readInt();
        this.launchMode = parcel.readInt();
        this.permission = parcel.readString();
        this.taskAffinity = parcel.readString();
        this.targetActivity = parcel.readString();
        this.flags = parcel.readInt();
        this.screenOrientation = parcel.readInt();
        this.configChanges = parcel.readInt();
        this.softInputMode = parcel.readInt();
        this.uiOptions = parcel.readInt();
        this.parentActivityName = parcel.readString();
    }

    /* synthetic */ ActivityInfo(Parcel parcel, ActivityInfo activityInfo) {
        this(parcel);
    }

    public static int activityInfoConfigToNative(int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < CONFIG_NATIVE_BITS.length) {
            if (((1 << i2) & i) != 0) {
                i3 |= CONFIG_NATIVE_BITS[i2];
            }
            i2++;
        }
        return i3;
    }

    public int describeContents() {
        return 0;
    }

    public void dump(Printer printer, String str) {
        super.dumpFront(printer, str);
        if (this.permission != null) {
            printer.println(new StringBuilder(String.valueOf(str)).append("permission=").append(this.permission).toString());
        }
        printer.println(new StringBuilder(String.valueOf(str)).append("taskAffinity=").append(this.taskAffinity).append(" targetActivity=").append(this.targetActivity).toString());
        if (!(this.launchMode == 0 && this.flags == 0 && this.theme == 0)) {
            printer.println(new StringBuilder(String.valueOf(str)).append("launchMode=").append(this.launchMode).append(" flags=0x").append(Integer.toHexString(this.flags)).append(" theme=0x").append(Integer.toHexString(this.theme)).toString());
        }
        if (!(this.screenOrientation == -1 && this.configChanges == 0 && this.softInputMode == 0)) {
            printer.println(new StringBuilder(String.valueOf(str)).append("screenOrientation=").append(this.screenOrientation).append(" configChanges=0x").append(Integer.toHexString(this.configChanges)).append(" softInputMode=0x").append(Integer.toHexString(this.softInputMode)).toString());
        }
        if (this.uiOptions != 0) {
            printer.println(new StringBuilder(String.valueOf(str)).append(" uiOptions=0x").append(Integer.toHexString(this.uiOptions)).toString());
        }
        super.dumpBack(printer, str);
    }

    public int getRealConfigChanged() {
        return this.applicationInfo.targetSdkVersion < 13 ? (this.configChanges | 1024) | 2048 : this.configChanges;
    }

    public final int getThemeResource() {
        return this.theme != 0 ? this.theme : this.applicationInfo.theme;
    }

    public String toString() {
        return "ActivityInfo{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.name + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.theme);
        parcel.writeInt(this.launchMode);
        parcel.writeString(this.permission);
        parcel.writeString(this.taskAffinity);
        parcel.writeString(this.targetActivity);
        parcel.writeInt(this.flags);
        parcel.writeInt(this.screenOrientation);
        parcel.writeInt(this.configChanges);
        parcel.writeInt(this.softInputMode);
        parcel.writeInt(this.uiOptions);
        parcel.writeString(this.parentActivityName);
    }
}
