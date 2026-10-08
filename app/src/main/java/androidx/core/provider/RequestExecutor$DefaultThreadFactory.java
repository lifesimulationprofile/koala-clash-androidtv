package androidx.core.provider;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RequestExecutor$DefaultThreadFactory implements ThreadFactory {
    public final /* synthetic */ int $r8$classId;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ProcessPriorityThread extends Thread {
        public final int mPriority;

        public ProcessPriorityThread(Runnable runnable) {
            super(runnable, "fonts-androidx");
            this.mPriority = 10;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(this.mPriority);
            super.run();
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.$r8$classId) {
            case 0:
                return new ProcessPriorityThread(runnable);
            default:
                Thread thread = new Thread(runnable);
                thread.setPriority(10);
                thread.setName("CameraX-camerax_high_priority");
                return thread;
        }
    }
}
