package net.tsz.afinal.http;

public abstract class AjaxCallBack<T> {
    private boolean progress = true;
    private int rate = 1000;

    public int getRate() {
        return this.rate;
    }

    public boolean isProgress() {
        return this.progress;
    }

    public void onFailure(Throwable th, int i, String str) {
    }

    public void onLoading(long j, long j2) {
    }

    public void onStart() {
    }

    public void onSuccess(T t) {
    }

    public AjaxCallBack<T> progress(boolean z, int i) {
        this.progress = z;
        this.rate = i;
        return this;
    }
}
