package android.p014os;

/* renamed from: android.os.SystemProperties */
public class SystemProperties {
    public static final int PROP_NAME_MAX = 31;
    public static final int PROP_VALUE_MAX = 255;
    private static final String TAG = "Shuame SystemProperties";

    public static String get(String str) {
        if (str.length() <= 31) {
            return SystemProperties.native_get(str);
        }
        throw new IllegalArgumentException("key.length > 31");
    }

    public static String get(String str, String str2) {
        if (str.length() <= 31) {
            return SystemProperties.native_get(str, str2);
        }
        throw new IllegalArgumentException("key.length > 31");
    }

    public static boolean getBoolean(String str, boolean z) {
        if (str.length() <= 31) {
            return SystemProperties.native_get_boolean(str, z);
        }
        throw new IllegalArgumentException("key.length > 31");
    }

    public static int getInt(String str, int i) {
        if (str.length() <= 31) {
            return SystemProperties.native_get_int(str, i);
        }
        throw new IllegalArgumentException("key.length > 31");
    }

    public static long getLong(String str, long j) {
        if (str.length() <= 31) {
            return SystemProperties.native_get_long(str, j);
        }
        throw new IllegalArgumentException("key.length > 31");
    }

    private static native String native_get(String str);

    private static native String native_get(String str, String str2);

    private static native boolean native_get_boolean(String str, boolean z);

    private static native int native_get_int(String str, int i);

    private static native long native_get_long(String str, long j);

    private static native void native_set(String str, String str2);

    public static void set(String str, String str2) {
        if (str.length() > 31) {
            throw new IllegalArgumentException("key.length > 31");
        } else if (str2 == null || str2.length() <= 255) {
            SystemProperties.native_set(str, str2);
        } else {
            throw new IllegalArgumentException("val.length > 255");
        }
    }
}
