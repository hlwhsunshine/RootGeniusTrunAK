package android.support.p015v4.app;

import android.app.Notification;
import android.app.NotificationManager;

/* renamed from: android.support.v4.app.NotificationManagerCompatEclair */
class NotificationManagerCompatEclair {
    NotificationManagerCompatEclair() {
    }

    static void cancelNotification(NotificationManager notificationManager, String str, int i) {
        notificationManager.cancel(str, i);
    }

    public static void postNotification(NotificationManager notificationManager, String str, int i, Notification notification) {
        notificationManager.notify(str, i, notification);
    }
}
