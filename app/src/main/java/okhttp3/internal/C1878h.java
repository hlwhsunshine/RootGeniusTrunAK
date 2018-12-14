package okhttp3.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

/* renamed from: okhttp3.internal.h */
final class C1878h extends C1809k {
    /* renamed from: a */
    private final Method f5549a;
    /* renamed from: b */
    private final Method f5550b;
    /* renamed from: c */
    private final Method f5551c;
    /* renamed from: d */
    private final Class<?> f5552d;
    /* renamed from: e */
    private final Class<?> f5553e;

    /* renamed from: okhttp3.internal.h$a */
    private static class C1877a implements InvocationHandler {
        /* renamed from: a */
        private final List<String> f5546a;
        /* renamed from: b */
        private boolean f5547b;
        /* renamed from: c */
        private String f5548c;

        public C1877a(List<String> list) {
            this.f5546a = list;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class returnType = method.getReturnType();
            if (objArr == null) {
                objArr = C1910m.f5675b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.valueOf(true);
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f5547b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f5546a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f5546a.contains(list.get(i))) {
                            name = (String) list.get(i);
                            this.f5548c = name;
                            return name;
                        }
                    }
                    name = (String) this.f5546a.get(0);
                    this.f5548c = name;
                    return name;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f5548c = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    private C1878h(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f5549a = method;
        this.f5550b = method2;
        this.f5551c = method3;
        this.f5552d = cls;
        this.f5553e = cls2;
    }

    /* renamed from: b */
    public static C1809k m5315b() {
        try {
            String str = "org.eclipse.jetty.alpn.ALPN";
            Class cls = Class.forName(str);
            Class cls2 = Class.forName(str + "$Provider");
            Class cls3 = Class.forName(str + "$ClientProvider");
            Class cls4 = Class.forName(str + "$ServerProvider");
            return new C1878h(cls.getMethod("put", new Class[]{SSLSocket.class, cls2}), cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod("remove", new Class[]{SSLSocket.class}), cls3, cls4);
        } catch (ClassNotFoundException e) {
        } catch (NoSuchMethodException e2) {
        }
        return null;
    }

    /* renamed from: a */
    public final String mo8685a(SSLSocket sSLSocket) {
        try {
            C1877a c1877a = (C1877a) Proxy.getInvocationHandler(this.f5550b.invoke(null, new Object[]{sSLSocket}));
            if (c1877a.f5547b || c1877a.f5548c != null) {
                return c1877a.f5547b ? null : c1877a.f5548c;
            } else {
                C1809k.m4984c().mo8687a(4, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?", null);
                return null;
            }
        } catch (InvocationTargetException e) {
            throw new AssertionError();
        } catch (IllegalAccessException e2) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public final void mo8689a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        List a = C1809k.m4983a((List) list);
        Object newProxyInstance;
        try {
            newProxyInstance = Proxy.newProxyInstance(C1809k.class.getClassLoader(), new Class[]{this.f5552d, this.f5553e}, new C1877a(a));
            this.f5549a.invoke(null, new Object[]{sSLSocket, newProxyInstance});
        } catch (InvocationTargetException e) {
            newProxyInstance = e;
            throw new AssertionError(newProxyInstance);
        } catch (IllegalAccessException e2) {
            newProxyInstance = e2;
            throw new AssertionError(newProxyInstance);
        }
    }

    /* renamed from: b */
    public final void mo8691b(SSLSocket sSLSocket) {
        try {
            this.f5551c.invoke(null, new Object[]{sSLSocket});
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        } catch (InvocationTargetException e2) {
            throw new AssertionError();
        }
    }
}
