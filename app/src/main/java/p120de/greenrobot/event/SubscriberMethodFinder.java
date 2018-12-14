package p120de.greenrobot.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: de.greenrobot.event.SubscriberMethodFinder */
class SubscriberMethodFinder {
    private static final int BRIDGE = 64;
    private static final int MODIFIERS_IGNORE = 5192;
    private static final int SYNTHETIC = 4096;
    private static final Map<String, List<SubscriberMethod>> methodCache = new HashMap();
    private final Map<Class<?>, Class<?>> skipMethodVerificationForClasses = new ConcurrentHashMap();

    SubscriberMethodFinder(List<Class<?>> list) {
        if (list != null) {
            for (Class cls : list) {
                this.skipMethodVerificationForClasses.put(cls, cls);
            }
        }
    }

    static void clearCaches() {
        synchronized (methodCache) {
            methodCache.clear();
        }
    }

    List<SubscriberMethod> findSubscriberMethods(Class<?> cls, String str) {
        List<SubscriberMethod> list;
        String str2 = cls.getName() + '.' + str;
        synchronized (methodCache) {
            list = (List) methodCache.get(str2);
        }
        if (list != null) {
            return list;
        }
        List<SubscriberMethod> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder stringBuilder = new StringBuilder();
        for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            String name = cls2.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                break;
            }
            for (Method method : cls2.getDeclaredMethods()) {
                String name2 = method.getName();
                if (name2.startsWith(str)) {
                    int modifiers = method.getModifiers();
                    if ((modifiers & 1) != 0 && (modifiers & MODIFIERS_IGNORE) == 0) {
                        Class[] parameterTypes = method.getParameterTypes();
                        if (parameterTypes.length == 1) {
                            ThreadMode threadMode;
                            name = name2.substring(str.length());
                            if (name.length() == 0) {
                                threadMode = ThreadMode.PostThread;
                            } else if (name.equals("MainThread")) {
                                threadMode = ThreadMode.MainThread;
                            } else if (name.equals("BackgroundThread")) {
                                threadMode = ThreadMode.BackgroundThread;
                            } else if (name.equals("Async")) {
                                threadMode = ThreadMode.Async;
                            } else if (!this.skipMethodVerificationForClasses.containsKey(cls2)) {
                                throw new EventBusException("Illegal onEvent method, check for typos: " + method);
                            }
                            Class cls3 = parameterTypes[0];
                            stringBuilder.setLength(0);
                            stringBuilder.append(name2);
                            stringBuilder.append('>').append(cls3.getName());
                            if (hashSet.add(stringBuilder.toString())) {
                                arrayList.add(new SubscriberMethod(method, threadMode, cls3));
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.skipMethodVerificationForClasses.containsKey(cls2)) {
                        name = EventBus.TAG;
                        new StringBuilder("Skipping method (not public, static or abstract): ").append(cls2).append(".").append(name2);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            throw new EventBusException("Subscriber " + cls + " has no public methods called " + str);
        }
        synchronized (methodCache) {
            methodCache.put(str2, arrayList);
        }
        return arrayList;
    }
}
