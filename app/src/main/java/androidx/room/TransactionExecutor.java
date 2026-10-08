package androidx.room;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import com.google.android.gms.tasks.zzi;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TransactionExecutor implements Executor {
    public Runnable mActive;
    public final ArrayDeque mTasks = new ArrayDeque();
    public final ArchTaskExecutor$$ExternalSyntheticLambda0 mExecutor = ArchTaskExecutor.sIOThreadExecutor;

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        this.mTasks.offer(new zzi(9, this, runnable, false));
        if (this.mActive == null) {
            scheduleNext();
        }
    }

    public final synchronized void scheduleNext() {
        Runnable runnable = (Runnable) this.mTasks.poll();
        this.mActive = runnable;
        if (runnable != null) {
            this.mExecutor.execute(runnable);
        }
    }
}
