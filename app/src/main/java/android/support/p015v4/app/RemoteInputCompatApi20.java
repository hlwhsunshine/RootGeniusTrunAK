package android.support.p015v4.app;

import android.app.RemoteInput.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.support.p015v4.app.RemoteInputCompatBase.RemoteInput;
import android.support.p015v4.app.RemoteInputCompatBase.RemoteInput.Factory;

/* renamed from: android.support.v4.app.RemoteInputCompatApi20 */
class RemoteInputCompatApi20 {
    RemoteInputCompatApi20() {
    }

    static void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        android.app.RemoteInput.addResultsToIntent(RemoteInputCompatApi20.fromCompat(remoteInputArr), intent, bundle);
    }

    static android.app.RemoteInput[] fromCompat(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            RemoteInput remoteInput = remoteInputArr[i];
            remoteInputArr2[i] = new Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build();
        }
        return remoteInputArr2;
    }

    static Bundle getResultsFromIntent(Intent intent) {
        return android.app.RemoteInput.getResultsFromIntent(intent);
    }

    static RemoteInput[] toCompat(android.app.RemoteInput[] remoteInputArr, Factory factory) {
        if (remoteInputArr == null) {
            return null;
        }
        RemoteInput[] newArray = factory.newArray(remoteInputArr.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= remoteInputArr.length) {
                return newArray;
            }
            android.app.RemoteInput remoteInput = remoteInputArr[i2];
            newArray[i2] = factory.build(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), remoteInput.getExtras());
            i = i2 + 1;
        }
    }
}
