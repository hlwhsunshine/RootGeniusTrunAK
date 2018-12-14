package okhttp3.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

/* renamed from: okhttp3.internal.g */
final class C1876g extends C1809k {
    /* renamed from: a */
    final Method f5544a;
    /* renamed from: b */
    final Method f5545b;

    private C1876g(Method method, Method method2) {
        this.f5544a = method;
        this.f5545b = method2;
    }

    /* renamed from: b */
    public static C1876g m5310b() {
        try {
            return new C1876g(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    /* renamed from: a */
    public final String mo8685a(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f5545b.invoke(sSLSocket, new Object[0]);
            return (str == null || str.equals("")) ? null : str;
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        } catch (InvocationTargetException e2) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public final void mo8689a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List a = C1809k.m4983a((List) list);
            this.f5544a.invoke(sSLParameters, new Object[]{a.toArray(new String[a.size()])});
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        } catch (InvocationTargetException e2) {
            throw new AssertionError();
        }
    }
}
