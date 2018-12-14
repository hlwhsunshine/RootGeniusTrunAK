package p120de.greenrobot.event;

import java.lang.reflect.Method;

/* renamed from: de.greenrobot.event.SubscriberMethod */
final class SubscriberMethod {
    final Class<?> eventType;
    final Method method;
    String methodString;
    final ThreadMode threadMode;

    SubscriberMethod(Method method, ThreadMode threadMode, Class<?> cls) {
        this.method = method;
        this.threadMode = threadMode;
        this.eventType = cls;
    }

    private synchronized void checkMethodString() {
        if (this.methodString == null) {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append(this.method.getDeclaringClass().getName());
            stringBuilder.append('#').append(this.method.getName());
            stringBuilder.append('(').append(this.eventType.getName());
            this.methodString = stringBuilder.toString();
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SubscriberMethod)) {
            return false;
        }
        checkMethodString();
        SubscriberMethod subscriberMethod = (SubscriberMethod) obj;
        subscriberMethod.checkMethodString();
        return this.methodString.equals(subscriberMethod.methodString);
    }

    public final int hashCode() {
        return this.method.hashCode();
    }
}
