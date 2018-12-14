package android.support.p015v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.ConnectionCallback;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.browse.MediaBrowser.SubscriptionCallback;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.MediaBrowserCompatApi21 */
class MediaBrowserCompatApi21 {
    static final String NULL_MEDIA_ITEM_ID = "android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM";

    /* renamed from: android.support.v4.media.MediaBrowserCompatApi21$ConnectionCallback */
    interface ConnectionCallback {
        void onConnected();

        void onConnectionFailed();

        void onConnectionSuspended();
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompatApi21$SubscriptionCallback */
    interface SubscriptionCallback {
        void onChildrenLoaded(@NonNull String str, List<Parcel> list);

        void onError(@NonNull String str);
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompatApi21$ConnectionCallbackProxy */
    static class ConnectionCallbackProxy<T extends ConnectionCallback> extends ConnectionCallback {
        protected final T mConnectionCallback;

        public ConnectionCallbackProxy(T t) {
            this.mConnectionCallback = t;
        }

        public void onConnected() {
            this.mConnectionCallback.onConnected();
        }

        public void onConnectionFailed() {
            this.mConnectionCallback.onConnectionFailed();
        }

        public void onConnectionSuspended() {
            this.mConnectionCallback.onConnectionSuspended();
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompatApi21$SubscriptionCallbackProxy */
    static class SubscriptionCallbackProxy<T extends SubscriptionCallback> extends SubscriptionCallback {
        protected final T mSubscriptionCallback;

        public SubscriptionCallbackProxy(T t) {
            this.mSubscriptionCallback = t;
        }

        public void onChildrenLoaded(@NonNull String str, List<MediaItem> list) {
            List list2;
            if (list != null && list.size() == 1 && ((MediaItem) list.get(0)).getMediaId().equals(MediaBrowserCompatApi21.NULL_MEDIA_ITEM_ID)) {
                List list3 = null;
            }
            if (list3 != null) {
                List arrayList = new ArrayList();
                for (MediaItem mediaItem : list3) {
                    Parcel obtain = Parcel.obtain();
                    mediaItem.writeToParcel(obtain, 0);
                    arrayList.add(obtain);
                }
                list2 = arrayList;
            } else {
                list2 = null;
            }
            this.mSubscriptionCallback.onChildrenLoaded(str, list2);
        }

        public void onError(@NonNull String str) {
            this.mSubscriptionCallback.onError(str);
        }
    }

    MediaBrowserCompatApi21() {
    }

    public static void connect(Object obj) {
        ((MediaBrowser) obj).connect();
    }

    public static Object createBrowser(Context context, ComponentName componentName, Object obj, Bundle bundle) {
        return new MediaBrowser(context, componentName, (ConnectionCallback) obj, bundle);
    }

    public static Object createConnectionCallback(ConnectionCallback connectionCallback) {
        return new ConnectionCallbackProxy(connectionCallback);
    }

    public static Object createSubscriptionCallback(SubscriptionCallback subscriptionCallback) {
        return new SubscriptionCallbackProxy(subscriptionCallback);
    }

    public static void disconnect(Object obj) {
        ((MediaBrowser) obj).disconnect();
    }

    public static Bundle getExtras(Object obj) {
        return ((MediaBrowser) obj).getExtras();
    }

    public static String getRoot(Object obj) {
        return ((MediaBrowser) obj).getRoot();
    }

    public static ComponentName getServiceComponent(Object obj) {
        return ((MediaBrowser) obj).getServiceComponent();
    }

    public static Object getSessionToken(Object obj) {
        return ((MediaBrowser) obj).getSessionToken();
    }

    public static boolean isConnected(Object obj) {
        return ((MediaBrowser) obj).isConnected();
    }

    public static void subscribe(Object obj, String str, Object obj2) {
        ((MediaBrowser) obj).subscribe(str, (SubscriptionCallback) obj2);
    }

    public static void unsubscribe(Object obj, String str) {
        ((MediaBrowser) obj).unsubscribe(str);
    }
}