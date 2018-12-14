package com.shuame.p079ij;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.p014os.ServiceManager;
import com.shuame.p079ij.IIjBridge.Stub;
import java.lang.reflect.Field;

/* renamed from: com.shuame.ij.PMTool */
public class PMTool {
    public static final String TAG = "HookPMTool";
    private static boolean _connected = false;
    private static ServiceConnection _connection = new C11471();
    private static IBinder _defense_binder;
    private static Object _lock = new Object();

    /* renamed from: com.shuame.ij.PMTool$1 */
    final class C11471 implements ServiceConnection {
        C11471() {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (PMTool._lock) {
                PMTool._connected = true;
                PMTool._defense_binder = iBinder;
                PMTool._lock.notifyAll();
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (PMTool._lock) {
                PMTool._connected = false;
                PMTool._defense_binder = null;
                PMTool._lock.notifyAll();
            }
        }
    }

    public static boolean isAllowUninstallPkg(String str) {
        if (!str.startsWith("com.shuame")) {
            return true;
        }
        IBinder service = ServiceManager.getService("package");
        try {
            Class cls;
            service.getClass().getName();
            int i = VERSION.SDK_INT;
            ClassLoader classLoader;
            if (i >= 21) {
                cls = service.getClass();
            } else if (i >= 21 || i <= 10) {
                classLoader = service.getClass().getClassLoader();
                new StringBuilder("pkgBinder classloader : ").append(classLoader.toString());
                cls = classLoader.loadClass("com.android.server.PackageManagerService");
            } else {
                classLoader = service.getClass().getClassLoader();
                new StringBuilder("pkgBinder classloader : ").append(classLoader.toString());
                cls = classLoader.loadClass("com.android.server.pm.PackageManagerService");
            }
            if (!cls.isInstance(service)) {
                return false;
            }
            Field declaredField = cls.getDeclaredField("mContext");
            declaredField.setAccessible(true);
            Context context = (Context) declaredField.get(service);
            Intent intent = new Intent("shuame.intent.action.sysservice");
            intent.setPackage(str);
            context.bindService(intent, _connection, 1);
            synchronized (_lock) {
                while (!_connected) {
                    try {
                        _lock.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
            boolean defense = Stub.asInterface(_defense_binder).defense();
            new StringBuilder(" ======== user  allow : ").append(defense).append("post a runnable to  unbind service");
            context.unbindService(_connection);
            return defense;
        } catch (NoSuchFieldException e2) {
        } catch (IllegalAccessException e3) {
        } catch (IllegalArgumentException e4) {
        } catch (RemoteException e5) {
        } catch (ClassNotFoundException e6) {
        }
        return true;
    }
}
