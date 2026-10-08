package androidx.camera.core;

import androidx.camera.camera2.internal.Camera2CameraFactory;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CameraExecutor implements Executor {
    public static final AnonymousClass1 THREAD_FACTORY = new AnonymousClass1(0);
    public final Object mExecutorLock = new Object();
    public ThreadPoolExecutor mThreadPoolExecutor;

    /* JADX INFO: renamed from: androidx.camera.core.CameraExecutor$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements ThreadFactory {
        public final /* synthetic */ int $r8$classId;
        public final AtomicInteger mThreadId;

        public AnonymousClass1(int i) {
            this.$r8$classId = i;
            switch (i) {
                case 1:
                    this.mThreadId = new AtomicInteger(0);
                    break;
                case 2:
                    this.mThreadId = new AtomicInteger(0);
                    break;
                default:
                    this.mThreadId = new AtomicInteger(0);
                    break;
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            switch (this.$r8$classId) {
                case 0:
                    Thread thread = new Thread(runnable);
                    Locale locale = Locale.US;
                    thread.setName("CameraX-core_camera_" + this.mThreadId.getAndIncrement());
                    return thread;
                case 1:
                    Thread thread2 = new Thread(runnable);
                    thread2.setName("arch_disk_io_" + this.mThreadId.getAndIncrement());
                    return thread2;
                default:
                    Thread thread3 = new Thread(runnable);
                    Locale locale2 = Locale.US;
                    thread3.setName("CameraX-camerax_io_" + this.mThreadId.getAndIncrement());
                    return thread3;
            }
        }
    }

    public CameraExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), THREAD_FACTORY);
        threadPoolExecutor.setRejectedExecutionHandler(new CameraExecutor$$ExternalSyntheticLambda0());
        this.mThreadPoolExecutor = threadPoolExecutor;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.getClass();
        synchronized (this.mExecutorLock) {
            this.mThreadPoolExecutor.execute(runnable);
        }
    }

    public final void init(Camera2CameraFactory camera2CameraFactory) {
        ThreadPoolExecutor threadPoolExecutor;
        camera2CameraFactory.getClass();
        synchronized (this.mExecutorLock) {
            try {
                if (this.mThreadPoolExecutor.isShutdown()) {
                    ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), THREAD_FACTORY);
                    threadPoolExecutor2.setRejectedExecutionHandler(new CameraExecutor$$ExternalSyntheticLambda0());
                    this.mThreadPoolExecutor = threadPoolExecutor2;
                }
                threadPoolExecutor = this.mThreadPoolExecutor;
            } catch (Throwable th) {
                throw th;
            }
        }
        int iMax = Math.max(1, new LinkedHashSet(camera2CameraFactory.mAvailableCameraIds).size());
        threadPoolExecutor.setMaximumPoolSize(iMax);
        threadPoolExecutor.setCorePoolSize(iMax);
    }
}
