package android.support.p015v4.p017os;

import android.os.Build.VERSION;

/* renamed from: android.support.v4.os.CancellationSignal */
public final class CancellationSignal {
    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;

    /* renamed from: android.support.v4.os.CancellationSignal$OnCancelListener */
    public interface OnCancelListener {
        void onCancel();
    }

    private void waitForCancelFinishedLocked() {
        while (this.mCancelInProgress) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    /* JADX WARNING: Missing block: B:7:0x0012, code:
            if (r0 == null) goto L_0x0017;
     */
    /* JADX WARNING: Missing block: B:9:?, code:
            r0.onCancel();
     */
    /* JADX WARNING: Missing block: B:10:0x0017, code:
            if (r1 == null) goto L_0x001c;
     */
    /* JADX WARNING: Missing block: B:11:0x0019, code:
            android.support.p015v4.p017os.CancellationSignalCompatJellybean.cancel(r1);
     */
    /* JADX WARNING: Missing block: B:12:0x001c, code:
            monitor-enter(r2);
     */
    /* JADX WARNING: Missing block: B:15:?, code:
            r2.mCancelInProgress = false;
            notifyAll();
     */
    /* JADX WARNING: Missing block: B:16:0x0023, code:
            monitor-exit(r2);
     */
    /* JADX WARNING: Missing block: B:25:0x002c, code:
            monitor-enter(r2);
     */
    /* JADX WARNING: Missing block: B:28:?, code:
            r2.mCancelInProgress = false;
            notifyAll();
     */
    /* JADX WARNING: Missing block: B:42:?, code:
            return;
     */
    public final void cancel() {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.mIsCanceled;	 Catch:{ all -> 0x0028 }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r2);	 Catch:{ all -> 0x0028 }
    L_0x0006:
        return;
    L_0x0007:
        r0 = 1;
        r2.mIsCanceled = r0;	 Catch:{ all -> 0x0028 }
        r0 = 1;
        r2.mCancelInProgress = r0;	 Catch:{ all -> 0x0028 }
        r0 = r2.mOnCancelListener;	 Catch:{ all -> 0x0028 }
        r1 = r2.mCancellationSignalObj;	 Catch:{ all -> 0x0028 }
        monitor-exit(r2);	 Catch:{ all -> 0x0028 }
        if (r0 == 0) goto L_0x0017;
    L_0x0014:
        r0.onCancel();	 Catch:{ all -> 0x002b }
    L_0x0017:
        if (r1 == 0) goto L_0x001c;
    L_0x0019:
        android.support.p015v4.p017os.CancellationSignalCompatJellybean.cancel(r1);	 Catch:{ all -> 0x002b }
    L_0x001c:
        monitor-enter(r2);
        r0 = 0;
        r2.mCancelInProgress = r0;	 Catch:{ all -> 0x0025 }
        r2.notifyAll();	 Catch:{ all -> 0x0025 }
        monitor-exit(r2);	 Catch:{ all -> 0x0025 }
        goto L_0x0006;
    L_0x0025:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0025 }
        throw r0;
    L_0x0028:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0028 }
        throw r0;
    L_0x002b:
        r0 = move-exception;
        monitor-enter(r2);
        r1 = 0;
        r2.mCancelInProgress = r1;	 Catch:{ all -> 0x0035 }
        r2.notifyAll();	 Catch:{ all -> 0x0035 }
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
        throw r0;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.os.CancellationSignal.cancel():void");
    }

    public final Object getCancellationSignalObject() {
        if (VERSION.SDK_INT < 16) {
            return null;
        }
        Object obj;
        synchronized (this) {
            if (this.mCancellationSignalObj == null) {
                this.mCancellationSignalObj = CancellationSignalCompatJellybean.create();
                if (this.mIsCanceled) {
                    CancellationSignalCompatJellybean.cancel(this.mCancellationSignalObj);
                }
            }
            obj = this.mCancellationSignalObj;
        }
        return obj;
    }

    public final boolean isCanceled() {
        boolean z;
        synchronized (this) {
            z = this.mIsCanceled;
        }
        return z;
    }

    /* JADX WARNING: Missing block: B:17:?, code:
            return;
     */
    public final void setOnCancelListener(android.support.p015v4.p017os.CancellationSignal.OnCancelListener r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r1.waitForCancelFinishedLocked();	 Catch:{ all -> 0x0014 }
        r0 = r1.mOnCancelListener;	 Catch:{ all -> 0x0014 }
        if (r0 != r2) goto L_0x000a;
    L_0x0008:
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
    L_0x0009:
        return;
    L_0x000a:
        r1.mOnCancelListener = r2;	 Catch:{ all -> 0x0014 }
        r0 = r1.mIsCanceled;	 Catch:{ all -> 0x0014 }
        if (r0 == 0) goto L_0x0012;
    L_0x0010:
        if (r2 != 0) goto L_0x0017;
    L_0x0012:
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
        goto L_0x0009;
    L_0x0014:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
        throw r0;
    L_0x0017:
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
        r2.onCancel();
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.os.CancellationSignal.setOnCancelListener(android.support.v4.os.CancellationSignal$OnCancelListener):void");
    }

    public final void throwIfCanceled() {
        if (isCanceled()) {
            throw new OperationCanceledException();
        }
    }
}
