package android.support.p015v4.app;

import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.app.BundleCompatDonut */
class BundleCompatDonut {
    private static final String TAG = "BundleCompatDonut";
    private static Method sGetIBinderMethod;
    private static boolean sGetIBinderMethodFetched;
    private static Method sPutIBinderMethod;
    private static boolean sPutIBinderMethodFetched;

    BundleCompatDonut() {
    }

    public static IBinder getBinder(Bundle bundle, String str) {
        if (!sGetIBinderMethodFetched) {
            try {
                Method method = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                sGetIBinderMethod = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            sGetIBinderMethodFetched = true;
        }
        if (sGetIBinderMethod != null) {
            try {
                return (IBinder) sGetIBinderMethod.invoke(bundle, new Object[]{str});
            } catch (InvocationTargetException e2) {
            } catch (IllegalAccessException e3) {
            } catch (IllegalArgumentException e4) {
            }
        }
        return null;
        sGetIBinderMethod = null;
        return null;
    }

    public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        if (!sPutIBinderMethodFetched) {
            try {
                Method method = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                sPutIBinderMethod = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            sPutIBinderMethodFetched = true;
        }
        if (sPutIBinderMethod != null) {
            try {
                sPutIBinderMethod.invoke(bundle, new Object[]{str, iBinder});
                return;
            } catch (InvocationTargetException e2) {
            } catch (IllegalAccessException e3) {
            } catch (IllegalArgumentException e4) {
            }
        } else {
            return;
        }
        sPutIBinderMethod = null;
    }
}
