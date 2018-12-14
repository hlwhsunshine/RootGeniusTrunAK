package p120de.greenrobot.event.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import p120de.greenrobot.event.EventBus;

/* renamed from: de.greenrobot.event.util.ExceptionToResourceMapping */
public class ExceptionToResourceMapping {
    public final Map<Class<? extends Throwable>, Integer> throwableToMsgIdMap = new HashMap();

    public ExceptionToResourceMapping addMapping(Class<? extends Throwable> cls, int i) {
        this.throwableToMsgIdMap.put(cls, Integer.valueOf(i));
        return this;
    }

    public Integer mapThrowable(Throwable th) {
        String str;
        int i = 20;
        Throwable th2 = th;
        do {
            Integer mapThrowableFlat = mapThrowableFlat(th2);
            if (mapThrowableFlat != null) {
                return mapThrowableFlat;
            }
            th2 = th2.getCause();
            i--;
            if (i <= 0 || th2 == th) {
                str = EventBus.TAG;
                new StringBuilder("No specific message ressource ID found for ").append(th);
            }
        } while (th2 != null);
        str = EventBus.TAG;
        new StringBuilder("No specific message ressource ID found for ").append(th);
        return null;
    }

    protected Integer mapThrowableFlat(Throwable th) {
        Class cls = th.getClass();
        Integer num = (Integer) this.throwableToMsgIdMap.get(cls);
        if (num != null) {
            return num;
        }
        Class cls2 = null;
        Integer num2 = num;
        for (Entry entry : this.throwableToMsgIdMap.entrySet()) {
            Class cls3 = (Class) entry.getKey();
            if (cls3.isAssignableFrom(cls) && (cls2 == null || cls2.isAssignableFrom(cls3))) {
                cls2 = cls3;
                num2 = (Integer) entry.getValue();
            }
        }
        return num2;
    }
}
