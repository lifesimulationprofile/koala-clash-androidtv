package okhttp3.internal.concurrent;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.google.android.gms.tasks.zzg;
import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;
import kotlin.Unit;
import okhttp3.ConnectionPool;
import okhttp3.internal.Util;
import okhttp3.internal.Util$$ExternalSyntheticLambda1;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TaskRunner {
    public static final Path.Companion Companion = new Path.Companion();
    public static final TaskRunner INSTANCE = new TaskRunner(new ConnectionPool(new Util$$ExternalSyntheticLambda1(ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder(), Util.okHttpName, " TaskRunner"), true)));
    public static final Logger logger = Logger.getLogger(TaskRunner.class.getName());
    public final ConnectionPool backend;
    public boolean coordinatorWaiting;
    public long coordinatorWakeUpAt;
    public int nextQueueName = ModuleDescriptor.MODULE_VERSION;
    public final ArrayList busyQueues = new ArrayList();
    public final ArrayList readyQueues = new ArrayList();
    public final zzg runnable = new zzg(26, this);

    public TaskRunner(ConnectionPool connectionPool) {
        this.backend = connectionPool;
    }

    public static final void access$runTask(TaskRunner taskRunner, Task task) {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(task.name);
        try {
            long jRunOnce = task.runOnce();
            synchronized (taskRunner) {
                taskRunner.afterRun(task, jRunOnce);
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            synchronized (taskRunner) {
                taskRunner.afterRun(task, -1L);
                Unit unit2 = Unit.INSTANCE;
                threadCurrentThread.setName(name);
            }
        }
    }

    public final void afterRun(Task task, long j) {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        TaskQueue taskQueue = task.queue;
        if (taskQueue.activeTask != task) {
            throw new IllegalStateException("Check failed.");
        }
        boolean z = taskQueue.cancelActiveTask;
        taskQueue.cancelActiveTask = false;
        taskQueue.activeTask = null;
        this.busyQueues.remove(taskQueue);
        if (j != -1 && !z && !taskQueue.shutdown) {
            taskQueue.scheduleAndDecide$okhttp(task, j, true);
        }
        if (taskQueue.futureTasks.isEmpty()) {
            return;
        }
        this.readyQueues.add(taskQueue);
    }

    public final Task awaitTaskToRun() {
        long j;
        Task task;
        boolean z;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        while (true) {
            ArrayList arrayList = this.readyQueues;
            if (arrayList.isEmpty()) {
                return null;
            }
            long jNanoTime = System.nanoTime();
            int size = arrayList.size();
            long jMin = Long.MAX_VALUE;
            int i = 0;
            Task task2 = null;
            while (true) {
                if (i >= size) {
                    j = jNanoTime;
                    task = null;
                    z = false;
                    break;
                }
                Object obj = arrayList.get(i);
                i++;
                Task task3 = (Task) ((TaskQueue) obj).futureTasks.get(0);
                j = jNanoTime;
                task = null;
                long jMax = Math.max(0L, task3.nextExecuteNanoTime - j);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (task2 != null) {
                        z = true;
                        break;
                    }
                    task2 = task3;
                }
                jNanoTime = j;
            }
            ArrayList arrayList2 = this.busyQueues;
            if (task2 != null) {
                byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
                task2.nextExecuteNanoTime = -1L;
                TaskQueue taskQueue = task2.queue;
                taskQueue.futureTasks.remove(task2);
                arrayList.remove(taskQueue);
                taskQueue.activeTask = task2;
                arrayList2.add(taskQueue);
                if (z || (!this.coordinatorWaiting && !arrayList.isEmpty())) {
                    ((ThreadPoolExecutor) this.backend.delegate).execute(this.runnable);
                }
                return task2;
            }
            if (this.coordinatorWaiting) {
                if (jMin >= this.coordinatorWakeUpAt - j) {
                    return task;
                }
                notify();
                return task;
            }
            this.coordinatorWaiting = true;
            this.coordinatorWakeUpAt = j + jMin;
            try {
                try {
                    long j2 = jMin / 1000000;
                    Long.signum(j2);
                    long j3 = jMin - (1000000 * j2);
                    if (j2 > 0 || jMin > 0) {
                        wait(j2, (int) j3);
                    }
                } catch (InterruptedException unused) {
                    for (int size2 = arrayList2.size() - 1; -1 < size2; size2--) {
                        ((TaskQueue) arrayList2.get(size2)).cancelAllAndDecide$okhttp();
                    }
                    for (int size3 = arrayList.size() - 1; -1 < size3; size3--) {
                        TaskQueue taskQueue2 = (TaskQueue) arrayList.get(size3);
                        taskQueue2.cancelAllAndDecide$okhttp();
                        if (taskQueue2.futureTasks.isEmpty()) {
                            arrayList.remove(size3);
                        }
                    }
                }
                this.coordinatorWaiting = false;
            } catch (Throwable th) {
                this.coordinatorWaiting = false;
                throw th;
            }
        }
    }

    public final void kickCoordinator$okhttp(TaskQueue taskQueue) {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        if (taskQueue.activeTask == null) {
            boolean zIsEmpty = taskQueue.futureTasks.isEmpty();
            ArrayList arrayList = this.readyQueues;
            if (zIsEmpty) {
                arrayList.remove(taskQueue);
            } else if (!arrayList.contains(taskQueue)) {
                arrayList.add(taskQueue);
            }
        }
        if (this.coordinatorWaiting) {
            notify();
        } else {
            ((ThreadPoolExecutor) this.backend.delegate).execute(this.runnable);
        }
    }

    public final TaskQueue newQueue() {
        int i;
        synchronized (this) {
            i = this.nextQueueName;
            this.nextQueueName = i + 1;
        }
        return new TaskQueue(this, ImageAnalysis$$ExternalSyntheticLambda1.m("Q", i));
    }
}
