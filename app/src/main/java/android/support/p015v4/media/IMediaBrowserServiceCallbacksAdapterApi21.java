package android.support.p015v4.media;

import android.media.session.MediaSession.Token;
import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.media.IMediaBrowserServiceCallbacksAdapterApi21 */
class IMediaBrowserServiceCallbacksAdapterApi21 {
    private Method mAsBinderMethod;
    Object mCallbackObject;
    private Method mOnConnectFailedMethod;
    private Method mOnConnectMethod;
    private Method mOnLoadChildrenMethod;

    /* renamed from: android.support.v4.media.IMediaBrowserServiceCallbacksAdapterApi21$Stub */
    static class Stub {
        static Method sAsInterfaceMethod;

        static {
            ReflectiveOperationException e;
            try {
                sAsInterfaceMethod = Class.forName("android.service.media.IMediaBrowserServiceCallbacks$Stub").getMethod("asInterface", new Class[]{IBinder.class});
                return;
            } catch (ClassNotFoundException e2) {
                e = e2;
            } catch (NoSuchMethodException e3) {
                e = e3;
            }
            e.printStackTrace();
        }

        Stub() {
        }

        static Object asInterface(IBinder iBinder) {
            ReflectiveOperationException e;
            try {
                return sAsInterfaceMethod.invoke(null, new Object[]{iBinder});
            } catch (IllegalAccessException e2) {
                e = e2;
            } catch (InvocationTargetException e3) {
                e = e3;
            }
            e.printStackTrace();
            return null;
        }
    }

    IMediaBrowserServiceCallbacksAdapterApi21(Object obj) {
        ReflectiveOperationException e;
        this.mCallbackObject = obj;
        try {
            Class cls = Class.forName("android.service.media.IMediaBrowserServiceCallbacks");
            Class cls2 = Class.forName("android.content.pm.ParceledListSlice");
            this.mAsBinderMethod = cls.getMethod("asBinder", new Class[0]);
            this.mOnConnectMethod = cls.getMethod("onConnect", new Class[]{String.class, Token.class, Bundle.class});
            this.mOnConnectFailedMethod = cls.getMethod("onConnectFailed", new Class[0]);
            this.mOnLoadChildrenMethod = cls.getMethod("onLoadChildren", new Class[]{String.class, cls2});
            return;
        } catch (ClassNotFoundException e2) {
            e = e2;
        } catch (NoSuchMethodException e3) {
            e = e3;
        }
        e.printStackTrace();
    }

    IBinder asBinder() {
        ReflectiveOperationException e;
        try {
            return (IBinder) this.mAsBinderMethod.invoke(this.mCallbackObject, new Object[0]);
        } catch (IllegalAccessException e2) {
            e = e2;
        } catch (InvocationTargetException e3) {
            e = e3;
        }
        e.printStackTrace();
        return null;
    }

    void onConnect(String str, Object obj, Bundle bundle) {
        ReflectiveOperationException e;
        try {
            this.mOnConnectMethod.invoke(this.mCallbackObject, new Object[]{str, obj, bundle});
            return;
        } catch (IllegalAccessException e2) {
            e = e2;
        } catch (InvocationTargetException e3) {
            e = e3;
        }
        e.printStackTrace();
    }

    void onConnectFailed() {
        ReflectiveOperationException e;
        try {
            this.mOnConnectFailedMethod.invoke(this.mCallbackObject, new Object[0]);
            return;
        } catch (IllegalAccessException e2) {
            e = e2;
        } catch (InvocationTargetException e3) {
            e = e3;
        }
        e.printStackTrace();
    }

    void onLoadChildren(String str, Object obj) {
        ReflectiveOperationException e;
        try {
            this.mOnLoadChildrenMethod.invoke(this.mCallbackObject, new Object[]{str, obj});
            return;
        } catch (IllegalAccessException e2) {
            e = e2;
        } catch (InvocationTargetException e3) {
            e = e3;
        }
        e.printStackTrace();
    }
}
