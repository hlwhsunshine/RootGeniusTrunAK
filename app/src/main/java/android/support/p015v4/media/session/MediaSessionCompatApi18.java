package android.support.p015v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;
import android.os.SystemClock;

/* renamed from: android.support.v4.media.session.MediaSessionCompatApi18 */
class MediaSessionCompatApi18 {
    private static final long ACTION_SEEK_TO = 256;
    private static final String TAG = "MediaSessionCompatApi18";
    private static boolean sIsMbrPendingIntentSupported = true;

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi18$Callback */
    interface Callback {
        void onSeekTo(long j);
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi18$OnPlaybackPositionUpdateListener */
    static class OnPlaybackPositionUpdateListener<T extends Callback> implements android.media.RemoteControlClient.OnPlaybackPositionUpdateListener {
        protected final T mCallback;

        public OnPlaybackPositionUpdateListener(T t) {
            this.mCallback = t;
        }

        public void onPlaybackPositionUpdate(long j) {
            this.mCallback.onSeekTo(j);
        }
    }

    MediaSessionCompatApi18() {
    }

    public static Object createPlaybackPositionUpdateListener(Callback callback) {
        return new OnPlaybackPositionUpdateListener(callback);
    }

    static int getRccTransportControlFlagsFromActions(long j) {
        int rccTransportControlFlagsFromActions = MediaSessionCompatApi14.getRccTransportControlFlagsFromActions(j);
        return (256 & j) != 0 ? rccTransportControlFlagsFromActions | 256 : rccTransportControlFlagsFromActions;
    }

    public static void registerMediaButtonEventReceiver(Context context, PendingIntent pendingIntent, ComponentName componentName) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (sIsMbrPendingIntentSupported) {
            try {
                audioManager.registerMediaButtonEventReceiver(pendingIntent);
            } catch (NullPointerException e) {
                sIsMbrPendingIntentSupported = false;
            }
        }
        if (!sIsMbrPendingIntentSupported) {
            audioManager.registerMediaButtonEventReceiver(componentName);
        }
    }

    public static void setOnPlaybackPositionUpdateListener(Object obj, Object obj2) {
        ((RemoteControlClient) obj).setPlaybackPositionUpdateListener((OnPlaybackPositionUpdateListener) obj2);
    }

    public static void setState(Object obj, int i, long j, float f, long j2) {
        long j3 = 0;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (i == 3 && j > 0) {
            if (j2 > 0) {
                j3 = elapsedRealtime - j2;
                if (f > 0.0f && f != 1.0f) {
                    j3 = (long) (((float) j3) * f);
                }
            }
            j += j3;
        }
        ((RemoteControlClient) obj).setPlaybackState(MediaSessionCompatApi14.getRccStateFromState(i), j, f);
    }

    public static void setTransportControlFlags(Object obj, long j) {
        ((RemoteControlClient) obj).setTransportControlFlags(MediaSessionCompatApi18.getRccTransportControlFlagsFromActions(j));
    }

    public static void unregisterMediaButtonEventReceiver(Context context, PendingIntent pendingIntent, ComponentName componentName) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (sIsMbrPendingIntentSupported) {
            audioManager.unregisterMediaButtonEventReceiver(pendingIntent);
        } else {
            audioManager.unregisterMediaButtonEventReceiver(componentName);
        }
    }
}
