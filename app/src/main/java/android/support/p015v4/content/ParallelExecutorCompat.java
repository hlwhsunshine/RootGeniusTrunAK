package android.support.p015v4.content;

import android.os.Build.VERSION;
import java.util.concurrent.Executor;

/* renamed from: android.support.v4.content.ParallelExecutorCompat */
public final class ParallelExecutorCompat {
    private ParallelExecutorCompat() {
    }

    public static Executor getParallelExecutor() {
        return VERSION.SDK_INT >= 11 ? ExecutorCompatHoneycomb.getParallelExecutor() : ModernAsyncTask.THREAD_POOL_EXECUTOR;
    }
}
