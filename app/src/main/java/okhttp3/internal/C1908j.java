package okhttp3.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: okhttp3.internal.j */
final class C1908j<T> {
    /* renamed from: a */
    private final Class<?> f5670a;
    /* renamed from: b */
    private final String f5671b;
    /* renamed from: c */
    private final Class[] f5672c;

    public C1908j(Class<?> cls, String str, Class... clsArr) {
        this.f5670a = cls;
        this.f5671b = str;
        this.f5672c = clsArr;
    }

    /* renamed from: a */
    private Method m5432a(Class<?> cls) {
        if (this.f5671b == null) {
            return null;
        }
        Method a = C1908j.m5433a(cls, this.f5671b, this.f5672c);
        return (a == null || this.f5670a == null || this.f5670a.isAssignableFrom(a.getReturnType())) ? a : null;
    }

    /* renamed from: a */
    private static Method m5433a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                return (method.getModifiers() & 1) == 0 ? null : method;
            } catch (NoSuchMethodException e) {
                return method;
            }
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }

    /* renamed from: c */
    private Object m5434c(T t, Object... objArr) {
        Object obj = null;
        Method a = m5432a(t.getClass());
        if (a == null) {
            return obj;
        }
        try {
            return a.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            return obj;
        }
    }

    /* renamed from: d */
    private Object m5435d(T t, Object... objArr) {
        Object a = m5432a(t.getClass());
        if (a == null) {
            throw new AssertionError("Method " + this.f5671b + " not supported for object " + t);
        }
        try {
            return a.invoke(t, objArr);
        } catch (Throwable e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    /* renamed from: a */
    public final Object mo8874a(T t, Object... objArr) {
        try {
            return m5434c(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: a */
    public final boolean mo8875a(T t) {
        return m5432a(t.getClass()) != null;
    }

    /* renamed from: b */
    public final Object mo8876b(T t, Object... objArr) {
        try {
            return m5435d(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }
}
