package p120de.greenrobot.event;

import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* renamed from: de.greenrobot.event.EventBus */
public class EventBus {
    private static /* synthetic */ int[] $SWITCH_TABLE$de$greenrobot$event$ThreadMode = null;
    private static final EventBusBuilder DEFAULT_BUILDER = new EventBusBuilder();
    private static final String DEFAULT_METHOD_NAME = "onEvent";
    public static String TAG = "Event";
    static volatile EventBus defaultInstance;
    private static final Map<Class<?>, List<Class<?>>> eventTypesCache = new HashMap();
    private final AsyncPoster asyncPoster;
    private final BackgroundPoster backgroundPoster;
    private final ThreadLocal<PostingThreadState> currentPostingThreadState;
    private final ExecutorService executorService;
    private final boolean logNoSubscriberMessages;
    private final boolean logSubscriberExceptions;
    private final HandlerPoster mainThreadPoster;
    private final boolean sendNoSubscriberEvent;
    private final boolean sendSubscriberExceptionEvent;
    private final Map<Class<?>, Object> stickyEvents;
    private final SubscriberMethodFinder subscriberMethodFinder;
    private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> subscriptionsByEventType;
    private final boolean throwSubscriberException;
    private final Map<Object, List<Class<?>>> typesBySubscriber;

    /* renamed from: de.greenrobot.event.EventBus$1 */
    class C17711 extends ThreadLocal<PostingThreadState> {
        C17711() {
        }

        protected PostingThreadState initialValue() {
            return new PostingThreadState();
        }
    }

    /* renamed from: de.greenrobot.event.EventBus$PostCallback */
    interface PostCallback {
        void onPostCompleted(List<SubscriberExceptionEvent> list);
    }

    /* renamed from: de.greenrobot.event.EventBus$PostingThreadState */
    static final class PostingThreadState {
        boolean canceled;
        Object event;
        final List<Object> eventQueue = new ArrayList();
        boolean isMainThread;
        boolean isPosting;
        Subscription subscription;

        PostingThreadState() {
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$de$greenrobot$event$ThreadMode() {
        int[] iArr = $SWITCH_TABLE$de$greenrobot$event$ThreadMode;
        if (iArr == null) {
            iArr = new int[ThreadMode.values().length];
            try {
                iArr[ThreadMode.Async.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ThreadMode.BackgroundThread.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ThreadMode.MainThread.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ThreadMode.PostThread.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            $SWITCH_TABLE$de$greenrobot$event$ThreadMode = iArr;
        }
        return iArr;
    }

    public EventBus() {
        this(DEFAULT_BUILDER);
    }

    EventBus(EventBusBuilder eventBusBuilder) {
        this.currentPostingThreadState = new C17711();
        this.subscriptionsByEventType = new HashMap();
        this.typesBySubscriber = new HashMap();
        this.stickyEvents = new ConcurrentHashMap();
        this.mainThreadPoster = new HandlerPoster(this, Looper.getMainLooper(), 10);
        this.backgroundPoster = new BackgroundPoster(this);
        this.asyncPoster = new AsyncPoster(this);
        this.subscriberMethodFinder = new SubscriberMethodFinder(eventBusBuilder.skipMethodVerificationForClasses);
        this.logSubscriberExceptions = eventBusBuilder.logSubscriberExceptions;
        this.logNoSubscriberMessages = eventBusBuilder.logNoSubscriberMessages;
        this.sendSubscriberExceptionEvent = eventBusBuilder.sendSubscriberExceptionEvent;
        this.sendNoSubscriberEvent = eventBusBuilder.sendNoSubscriberEvent;
        this.throwSubscriberException = eventBusBuilder.throwSubscriberException;
        this.executorService = eventBusBuilder.executorService;
    }

    static void addInterfaces(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                EventBus.addInterfaces(list, cls.getInterfaces());
            }
        }
    }

    public static EventBusBuilder builder() {
        return new EventBusBuilder();
    }

    public static void clearCaches() {
        SubscriberMethodFinder.clearCaches();
        eventTypesCache.clear();
    }

    public static EventBus getDefault() {
        if (defaultInstance == null) {
            synchronized (EventBus.class) {
                if (defaultInstance == null) {
                    defaultInstance = new EventBus();
                }
            }
        }
        return defaultInstance;
    }

    private void handleSubscriberException(Subscription subscription, Object obj, Throwable th) {
        if (obj instanceof SubscriberExceptionEvent) {
            if (this.logSubscriberExceptions) {
                new StringBuilder("SubscriberExceptionEvent subscriber ").append(subscription.subscriber.getClass()).append(" threw an exception");
                SubscriberExceptionEvent subscriberExceptionEvent = (SubscriberExceptionEvent) obj;
                new StringBuilder("Initial event ").append(subscriberExceptionEvent.causingEvent).append(" caused exception in ").append(subscriberExceptionEvent.causingSubscriber);
            }
        } else if (this.throwSubscriberException) {
            throw new EventBusException("Invoking subscriber failed", th);
        } else {
            if (this.logSubscriberExceptions) {
                new StringBuilder("Could not dispatch event: ").append(obj.getClass()).append(" to subscribing class ").append(subscription.subscriber.getClass());
            }
            if (this.sendSubscriberExceptionEvent) {
                post(new SubscriberExceptionEvent(this, th, obj, subscription.subscriber));
            }
        }
    }

    private List<Class<?>> lookupAllEventTypes(Class<?> cls) {
        List<Class<?>> list;
        synchronized (eventTypesCache) {
            list = (List) eventTypesCache.get(cls);
            if (list == null) {
                list = new ArrayList();
                for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    EventBus.addInterfaces(list, cls2.getInterfaces());
                }
                eventTypesCache.put(cls, list);
            }
        }
        return list;
    }

    private void postSingleEvent(Object obj, PostingThreadState postingThreadState) {
        Class cls = obj.getClass();
        List lookupAllEventTypes = lookupAllEventTypes(cls);
        int size = lookupAllEventTypes.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            CopyOnWriteArrayList copyOnWriteArrayList;
            boolean z2;
            Class cls2 = (Class) lookupAllEventTypes.get(i);
            synchronized (this) {
                copyOnWriteArrayList = (CopyOnWriteArrayList) this.subscriptionsByEventType.get(cls2);
            }
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
                z2 = z;
            } else {
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    Subscription subscription = (Subscription) it.next();
                    postingThreadState.event = obj;
                    postingThreadState.subscription = subscription;
                    try {
                        postToSubscription(subscription, obj, postingThreadState.isMainThread);
                        Object obj2 = postingThreadState.canceled;
                        if (obj2 != null) {
                            break;
                        }
                    } finally {
                        postingThreadState.event = null;
                        postingThreadState.subscription = null;
                        postingThreadState.canceled = false;
                    }
                }
                z2 = true;
            }
            i++;
            z = z2;
        }
        if (!z) {
            if (this.logNoSubscriberMessages) {
                new StringBuilder("No subscribers registered for event ").append(cls);
            }
            if (this.sendNoSubscriberEvent && cls != NoSubscriberEvent.class && cls != SubscriberExceptionEvent.class) {
                post(new NoSubscriberEvent(this, obj));
            }
        }
    }

    private void postToSubscription(Subscription subscription, Object obj, boolean z) {
        switch (EventBus.$SWITCH_TABLE$de$greenrobot$event$ThreadMode()[subscription.subscriberMethod.threadMode.ordinal()]) {
            case 1:
                invokeSubscriber(subscription, obj);
                return;
            case 2:
                if (z) {
                    invokeSubscriber(subscription, obj);
                    return;
                } else {
                    this.mainThreadPoster.enqueue(subscription, obj);
                    return;
                }
            case 3:
                if (z) {
                    this.backgroundPoster.enqueue(subscription, obj);
                    return;
                } else {
                    invokeSubscriber(subscription, obj);
                    return;
                }
            case 4:
                this.asyncPoster.enqueue(subscription, obj);
                return;
            default:
                throw new IllegalStateException("Unknown thread mode: " + subscription.subscriberMethod.threadMode);
        }
    }

    private synchronized void register(Object obj, String str, boolean z, int i) {
        for (SubscriberMethod subscribe : this.subscriberMethodFinder.findSubscriberMethods(obj.getClass(), str)) {
            subscribe(obj, subscribe, z, i);
        }
    }

    private synchronized void register(Object obj, String str, boolean z, Class<?> cls, Class<?>... clsArr) {
        for (SubscriberMethod subscriberMethod : this.subscriberMethodFinder.findSubscriberMethods(obj.getClass(), str)) {
            if (cls == subscriberMethod.eventType) {
                subscribe(obj, subscriberMethod, z, 0);
            } else if (clsArr != null) {
                for (Class<?> cls2 : clsArr) {
                    if (cls2 == subscriberMethod.eventType) {
                        subscribe(obj, subscriberMethod, z, 0);
                        break;
                    }
                }
            } else {
                continue;
            }
        }
    }

    private void subscribe(Object obj, SubscriberMethod subscriberMethod, boolean z, int i) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        Class cls = subscriberMethod.eventType;
        CopyOnWriteArrayList copyOnWriteArrayList2 = (CopyOnWriteArrayList) this.subscriptionsByEventType.get(cls);
        Subscription subscription = new Subscription(obj, subscriberMethod, i);
        if (copyOnWriteArrayList2 == null) {
            copyOnWriteArrayList2 = new CopyOnWriteArrayList();
            this.subscriptionsByEventType.put(cls, copyOnWriteArrayList2);
            copyOnWriteArrayList = copyOnWriteArrayList2;
        } else if (copyOnWriteArrayList2.contains(subscription)) {
            throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
        } else {
            copyOnWriteArrayList = copyOnWriteArrayList2;
        }
        int size = copyOnWriteArrayList.size();
        int i2 = 0;
        while (i2 <= size) {
            if (i2 == size || subscription.priority > ((Subscription) copyOnWriteArrayList.get(i2)).priority) {
                copyOnWriteArrayList.add(i2, subscription);
                break;
            }
            i2++;
        }
        List list = (List) this.typesBySubscriber.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.typesBySubscriber.put(obj, list);
        }
        list.add(cls);
        if (z) {
            Object obj2;
            synchronized (this.stickyEvents) {
                obj2 = this.stickyEvents.get(cls);
            }
            if (obj2 != null) {
                postToSubscription(subscription, obj2, Looper.getMainLooper() == Looper.myLooper());
            }
        }
    }

    private void unubscribeByEventType(Object obj, Class<?> cls) {
        List list = (List) this.subscriptionsByEventType.get(cls);
        if (list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                int i2;
                Subscription subscription = (Subscription) list.get(i);
                if (subscription.subscriber == obj) {
                    subscription.active = false;
                    list.remove(i);
                    i2 = i - 1;
                    i = size - 1;
                } else {
                    i2 = i;
                    i = size;
                }
                size = i;
                i = i2 + 1;
            }
        }
    }

    public void cancelEventDelivery(Object obj) {
        PostingThreadState postingThreadState = (PostingThreadState) this.currentPostingThreadState.get();
        if (!postingThreadState.isPosting) {
            throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
        } else if (obj == null) {
            throw new EventBusException("Event may not be null");
        } else if (postingThreadState.event != obj) {
            throw new EventBusException("Only the currently handled event may be aborted");
        } else if (postingThreadState.subscription.subscriberMethod.threadMode != ThreadMode.PostThread) {
            throw new EventBusException(" event handlers may only abort the incoming event");
        } else {
            postingThreadState.canceled = true;
        }
    }

    ExecutorService getExecutorService() {
        return this.executorService;
    }

    public <T> T getStickyEvent(Class<T> cls) {
        T cast;
        synchronized (this.stickyEvents) {
            cast = cls.cast(this.stickyEvents.get(cls));
        }
        return cast;
    }

    public boolean hasSubscriberForEvent(Class<?> cls) {
        List lookupAllEventTypes = lookupAllEventTypes(cls);
        if (lookupAllEventTypes != null) {
            int size = lookupAllEventTypes.size();
            for (int i = 0; i < size; i++) {
                CopyOnWriteArrayList copyOnWriteArrayList;
                Class cls2 = (Class) lookupAllEventTypes.get(i);
                synchronized (this) {
                    copyOnWriteArrayList = (CopyOnWriteArrayList) this.subscriptionsByEventType.get(cls2);
                }
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    void invokeSubscriber(PendingPost pendingPost) {
        Object obj = pendingPost.event;
        Subscription subscription = pendingPost.subscription;
        PendingPost.releasePendingPost(pendingPost);
        if (subscription.active) {
            invokeSubscriber(subscription, obj);
        }
    }

    void invokeSubscriber(Subscription subscription, Object obj) {
        try {
            subscription.subscriberMethod.method.invoke(subscription.subscriber, new Object[]{obj});
        } catch (InvocationTargetException e) {
            handleSubscriberException(subscription, obj, e.getCause());
        } catch (Throwable e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        }
    }

    public synchronized boolean isRegistered(Object obj) {
        return this.typesBySubscriber.containsKey(obj);
    }

    public void post(Object obj) {
        PostingThreadState postingThreadState = (PostingThreadState) this.currentPostingThreadState.get();
        List list = postingThreadState.eventQueue;
        list.add(obj);
        if (!postingThreadState.isPosting) {
            postingThreadState.isMainThread = Looper.getMainLooper() == Looper.myLooper();
            postingThreadState.isPosting = true;
            if (postingThreadState.canceled) {
                throw new EventBusException("Internal error. Abort state was not reset");
            }
            while (!list.isEmpty()) {
                try {
                    postSingleEvent(list.remove(0), postingThreadState);
                } catch (Throwable th) {
                    postingThreadState.isPosting = false;
                    postingThreadState.isMainThread = false;
                }
            }
            postingThreadState.isPosting = false;
            postingThreadState.isMainThread = false;
        }
    }

    public void postSticky(Object obj) {
        synchronized (this.stickyEvents) {
            this.stickyEvents.put(obj.getClass(), obj);
        }
        post(obj);
    }

    public void register(Object obj) {
        register(obj, DEFAULT_METHOD_NAME, false, 0);
    }

    public void register(Object obj, int i) {
        register(obj, DEFAULT_METHOD_NAME, false, i);
    }

    @Deprecated
    public void register(Object obj, Class<?> cls, Class<?>... clsArr) {
        register(obj, DEFAULT_METHOD_NAME, false, cls, clsArr);
    }

    @Deprecated
    public void register(Object obj, String str) {
        register(obj, str, false, 0);
    }

    @Deprecated
    public void register(Object obj, String str, Class<?> cls, Class<?>... clsArr) {
        register(obj, str, false, cls, clsArr);
    }

    public void registerSticky(Object obj) {
        register(obj, DEFAULT_METHOD_NAME, true, 0);
    }

    public void registerSticky(Object obj, int i) {
        register(obj, DEFAULT_METHOD_NAME, true, i);
    }

    @Deprecated
    public void registerSticky(Object obj, Class<?> cls, Class<?>... clsArr) {
        register(obj, DEFAULT_METHOD_NAME, true, cls, clsArr);
    }

    @Deprecated
    public void registerSticky(Object obj, String str) {
        register(obj, str, true, 0);
    }

    @Deprecated
    public void registerSticky(Object obj, String str, Class<?> cls, Class<?>... clsArr) {
        register(obj, str, true, cls, clsArr);
    }

    public void removeAllStickyEvents() {
        synchronized (this.stickyEvents) {
            this.stickyEvents.clear();
        }
    }

    public <T> T removeStickyEvent(Class<T> cls) {
        T cast;
        synchronized (this.stickyEvents) {
            cast = cls.cast(this.stickyEvents.remove(cls));
        }
        return cast;
    }

    public boolean removeStickyEvent(Object obj) {
        synchronized (this.stickyEvents) {
            Class cls = obj.getClass();
            if (obj.equals(this.stickyEvents.get(cls))) {
                this.stickyEvents.remove(cls);
                return true;
            }
            return false;
        }
    }

    public synchronized void unregister(Object obj) {
        List<Class> list = (List) this.typesBySubscriber.get(obj);
        if (list != null) {
            for (Class unubscribeByEventType : list) {
                unubscribeByEventType(obj, unubscribeByEventType);
            }
            this.typesBySubscriber.remove(obj);
        } else {
            new StringBuilder("Subscriber to unregister was not registered before: ").append(obj.getClass());
        }
    }

    @Deprecated
    public synchronized void unregister(Object obj, Class<?>... clsArr) {
        if (clsArr.length == 0) {
            throw new IllegalArgumentException("Provide at least one event class");
        }
        List list = (List) this.typesBySubscriber.get(obj);
        if (list != null) {
            for (Class cls : clsArr) {
                unubscribeByEventType(obj, cls);
                list.remove(cls);
            }
            if (list.isEmpty()) {
                this.typesBySubscriber.remove(obj);
            }
        } else {
            new StringBuilder("Subscriber to unregister was not registered before: ").append(obj.getClass());
        }
    }
}
