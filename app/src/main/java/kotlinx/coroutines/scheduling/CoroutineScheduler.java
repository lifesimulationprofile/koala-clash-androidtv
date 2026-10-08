package kotlinx.coroutines.scheduling;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import coil.network.HttpException;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated$volatile;
    private volatile /* synthetic */ long controlState$volatile;
    public final int corePoolSize;
    public final GlobalQueue globalBlockingQueue;
    public final GlobalQueue globalCpuQueue;
    public final long idleWorkerKeepAliveNs;
    public final int maxPoolSize;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;
    public final String schedulerName;
    public final ResizableAtomicArray workers;
    public static final /* synthetic */ AtomicLongFieldUpdater parkedWorkersStack$volatile$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater controlState$volatile$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater _isTerminated$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated$volatile");
    public static final Symbol NOT_IN_STACK = new Symbol("NOT_IN_STACK", 0);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Worker extends Thread {
        public static final /* synthetic */ AtomicIntegerFieldUpdater workerCtl$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl$volatile");
        private volatile int indexInArray;
        public final WorkQueue localQueue;
        public boolean mayHaveLocalTasks;
        public long minDelayUntilStealableTaskNs;
        private volatile Object nextParkedWorker;
        public int rngState;
        public int state;
        public final Ref$ObjectRef stolenTask;
        public long terminationDeadline;
        private volatile /* synthetic */ int workerCtl$volatile;

        public Worker(int i) {
            setDaemon(true);
            setContextClassLoader(CoroutineScheduler.class.getClassLoader());
            this.localQueue = new WorkQueue();
            this.stolenTask = new Ref$ObjectRef();
            this.state = 4;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            int iNanoTime = (int) System.nanoTime();
            this.rngState = iNanoTime == 0 ? 42 : iNanoTime;
            setIndexInArray(i);
        }

        public final Task findTask(boolean z) {
            Task taskPollGlobalQueues;
            Task taskPollGlobalQueues2;
            long j;
            int i = this.state;
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            Task task = null;
            WorkQueue workQueue = this.localQueue;
            if (i != 1) {
                AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.controlState$volatile$FU;
                do {
                    j = atomicLongFieldUpdater.get(coroutineScheduler);
                    if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                        workQueue.getClass();
                        loop1: while (true) {
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = WorkQueue.lastScheduledTask$volatile$FU;
                            Task task2 = (Task) atomicReferenceFieldUpdater.get(workQueue);
                            if (task2 == null || !task2.taskContext) {
                                int i2 = WorkQueue.consumerIndex$volatile$FU.get(workQueue);
                                int i3 = WorkQueue.producerIndex$volatile$FU.get(workQueue);
                                while (i2 != i3 && WorkQueue.blockingTasksInBuffer$volatile$FU.get(workQueue) != 0) {
                                    i3--;
                                    Task taskTryExtractFromTheMiddle = workQueue.tryExtractFromTheMiddle(i3, true);
                                    if (taskTryExtractFromTheMiddle != null) {
                                        task = taskTryExtractFromTheMiddle;
                                        break;
                                    }
                                }
                                break;
                            }
                            do {
                                if (atomicReferenceFieldUpdater.compareAndSet(workQueue, task2, null)) {
                                    task = task2;
                                    break loop1;
                                }
                            } while (atomicReferenceFieldUpdater.get(workQueue) == task2);
                        }
                        if (task != null) {
                            return task;
                        }
                        Task task3 = (Task) coroutineScheduler.globalBlockingQueue.removeFirstOrNull();
                        return task3 == null ? trySteal(1) : task3;
                    }
                } while (!CoroutineScheduler.controlState$volatile$FU.compareAndSet(coroutineScheduler, j, j - 4398046511104L));
                this.state = 1;
            }
            if (z) {
                boolean z2 = nextInt(coroutineScheduler.corePoolSize * 2) == 0;
                if (z2 && (taskPollGlobalQueues2 = pollGlobalQueues()) != null) {
                    return taskPollGlobalQueues2;
                }
                workQueue.getClass();
                Task taskPollBuffer = (Task) WorkQueue.lastScheduledTask$volatile$FU.getAndSet(workQueue, null);
                if (taskPollBuffer == null) {
                    taskPollBuffer = workQueue.pollBuffer();
                }
                if (taskPollBuffer != null) {
                    return taskPollBuffer;
                }
                if (!z2 && (taskPollGlobalQueues = pollGlobalQueues()) != null) {
                    return taskPollGlobalQueues;
                }
            } else {
                Task taskPollGlobalQueues3 = pollGlobalQueues();
                if (taskPollGlobalQueues3 != null) {
                    return taskPollGlobalQueues3;
                }
            }
            return trySteal(3);
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final int nextInt(int i) {
            int i2 = this.rngState;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.rngState = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
        }

        public final Task pollGlobalQueues() {
            int iNextInt = nextInt(2);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            if (iNextInt == 0) {
                Task task = (Task) coroutineScheduler.globalCpuQueue.removeFirstOrNull();
                return task != null ? task : (Task) coroutineScheduler.globalBlockingQueue.removeFirstOrNull();
            }
            Task task2 = (Task) coroutineScheduler.globalBlockingQueue.removeFirstOrNull();
            return task2 != null ? task2 : (Task) coroutineScheduler.globalCpuQueue.removeFirstOrNull();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            long j;
            loop0: while (true) {
                boolean z = false;
                while (true) {
                    if (CoroutineScheduler._isTerminated$volatile$FU.get(CoroutineScheduler.this) == 1 || this.state == 5) {
                        break loop0;
                    }
                    Task taskFindTask = findTask(this.mayHaveLocalTasks);
                    if (taskFindTask != null) {
                        this.minDelayUntilStealableTaskNs = 0L;
                        CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                        this.terminationDeadline = 0L;
                        if (this.state == 3) {
                            this.state = 2;
                        }
                        if (!taskFindTask.taskContext) {
                            try {
                                taskFindTask.run();
                                break;
                            } catch (Throwable th) {
                                Thread threadCurrentThread = Thread.currentThread();
                                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                                break;
                            }
                        }
                        if (tryReleaseCpu(2) && !coroutineScheduler.tryUnpark() && !coroutineScheduler.tryCreateWorker(CoroutineScheduler.controlState$volatile$FU.get(coroutineScheduler))) {
                            coroutineScheduler.tryUnpark();
                        }
                        try {
                            taskFindTask.run();
                        } catch (Throwable th2) {
                            Thread threadCurrentThread2 = Thread.currentThread();
                            threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th2);
                        }
                        CoroutineScheduler.controlState$volatile$FU.addAndGet(coroutineScheduler, -2097152L);
                        if (this.state == 5) {
                            break;
                        }
                        this.state = 4;
                        break;
                    }
                    this.mayHaveLocalTasks = false;
                    if (this.minDelayUntilStealableTaskNs == 0) {
                        Object obj = this.nextParkedWorker;
                        Symbol symbol = CoroutineScheduler.NOT_IN_STACK;
                        if (obj != symbol) {
                            workerCtl$volatile$FU.set(this, -1);
                            while (this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK) {
                                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = workerCtl$volatile$FU;
                                if (atomicIntegerFieldUpdater.get(this) != -1) {
                                    break;
                                }
                                CoroutineScheduler coroutineScheduler2 = CoroutineScheduler.this;
                                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = CoroutineScheduler._isTerminated$volatile$FU;
                                if (atomicIntegerFieldUpdater2.get(coroutineScheduler2) == 1 || this.state == 5) {
                                    break;
                                }
                                tryReleaseCpu(3);
                                Thread.interrupted();
                                if (this.terminationDeadline == 0) {
                                    j = 2097151;
                                    this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
                                } else {
                                    j = 2097151;
                                }
                                LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
                                if (System.nanoTime() - this.terminationDeadline >= 0) {
                                    this.terminationDeadline = 0L;
                                    CoroutineScheduler coroutineScheduler3 = CoroutineScheduler.this;
                                    synchronized (coroutineScheduler3.workers) {
                                        try {
                                            if (!(atomicIntegerFieldUpdater2.get(coroutineScheduler3) == 1)) {
                                                AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.controlState$volatile$FU;
                                                if (((int) (atomicLongFieldUpdater.get(coroutineScheduler3) & j)) > coroutineScheduler3.corePoolSize) {
                                                    if (atomicIntegerFieldUpdater.compareAndSet(this, -1, 1)) {
                                                        int i = this.indexInArray;
                                                        setIndexInArray(0);
                                                        coroutineScheduler3.parkedWorkersStackTopUpdate(this, i, 0);
                                                        int andDecrement = (int) (atomicLongFieldUpdater.getAndDecrement(coroutineScheduler3) & j);
                                                        if (andDecrement != i) {
                                                            Worker worker = (Worker) coroutineScheduler3.workers.get(andDecrement);
                                                            coroutineScheduler3.workers.setSynchronized(i, worker);
                                                            worker.setIndexInArray(i);
                                                            coroutineScheduler3.parkedWorkersStackTopUpdate(worker, andDecrement, i);
                                                        }
                                                        coroutineScheduler3.workers.setSynchronized(andDecrement, null);
                                                        Unit unit = Unit.INSTANCE;
                                                        this.state = 5;
                                                    }
                                                }
                                            }
                                        } catch (Throwable th3) {
                                            throw th3;
                                        }
                                    }
                                }
                            }
                        } else {
                            CoroutineScheduler coroutineScheduler4 = CoroutineScheduler.this;
                            if (this.nextParkedWorker == symbol) {
                                AtomicLongFieldUpdater atomicLongFieldUpdater2 = CoroutineScheduler.parkedWorkersStack$volatile$FU;
                                while (true) {
                                    long j2 = atomicLongFieldUpdater2.get(coroutineScheduler4);
                                    int i2 = this.indexInArray;
                                    this.nextParkedWorker = coroutineScheduler4.workers.get((int) (j2 & 2097151));
                                    CoroutineScheduler coroutineScheduler5 = coroutineScheduler4;
                                    if (CoroutineScheduler.parkedWorkersStack$volatile$FU.compareAndSet(coroutineScheduler5, j2, ((j2 + 2097152) & (-2097152)) | ((long) i2))) {
                                        break;
                                    } else {
                                        coroutineScheduler4 = coroutineScheduler5;
                                    }
                                }
                            }
                        }
                    } else {
                        if (z) {
                            tryReleaseCpu(3);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                            this.minDelayUntilStealableTaskNs = 0L;
                            break;
                        }
                        z = true;
                    }
                }
            }
            tryReleaseCpu(5);
        }

        public final void setIndexInArray(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.schedulerName);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void setNextParkedWorker(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean tryReleaseCpu(int i) {
            int i2 = this.state;
            boolean z = i2 == 1;
            if (z) {
                CoroutineScheduler.controlState$volatile$FU.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (i2 != i) {
                this.state = i;
            }
            return z;
        }

        public final Task trySteal(int i) {
            long j;
            Task taskTryExtractFromTheMiddle;
            long j2;
            long j3;
            Task task;
            AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.controlState$volatile$FU;
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            int i2 = (int) (atomicLongFieldUpdater.get(coroutineScheduler) & 2097151);
            Task task2 = null;
            if (i2 < 2) {
                return null;
            }
            int iNextInt = nextInt(i2);
            int i3 = 0;
            long jMin = Long.MAX_VALUE;
            while (i3 < i2) {
                iNextInt++;
                if (iNextInt > i2) {
                    iNextInt = 1;
                }
                Worker worker = (Worker) coroutineScheduler.workers.get(iNextInt);
                if (worker != null && worker != this) {
                    WorkQueue workQueue = worker.localQueue;
                    if (i != 3) {
                        workQueue.getClass();
                        int i4 = WorkQueue.consumerIndex$volatile$FU.get(workQueue);
                        int i5 = WorkQueue.producerIndex$volatile$FU.get(workQueue);
                        boolean z = i == 1;
                        while (true) {
                            if (i4 != i5) {
                                j = 0;
                                if (!z || WorkQueue.blockingTasksInBuffer$volatile$FU.get(workQueue) != 0) {
                                    int i6 = i4 + 1;
                                    taskTryExtractFromTheMiddle = workQueue.tryExtractFromTheMiddle(i4, z);
                                    if (taskTryExtractFromTheMiddle != null) {
                                        break;
                                    }
                                    i4 = i6;
                                }
                            } else {
                                j = 0;
                            }
                            taskTryExtractFromTheMiddle = task2;
                            break;
                        }
                    } else {
                        taskTryExtractFromTheMiddle = workQueue.pollBuffer();
                        j = 0;
                    }
                    Ref$ObjectRef ref$ObjectRef = this.stolenTask;
                    if (taskTryExtractFromTheMiddle == null) {
                        while (true) {
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = WorkQueue.lastScheduledTask$volatile$FU;
                            Task task3 = (Task) atomicReferenceFieldUpdater.get(workQueue);
                            if (task3 == null) {
                                j2 = -1;
                            } else {
                                j2 = -1;
                                if (((task3.taskContext ? 1 : 2) & i) != 0) {
                                    TasksKt.schedulerTimeSource.getClass();
                                    WorkQueue workQueue2 = workQueue;
                                    long jNanoTime = System.nanoTime() - task3.submissionTime;
                                    long j4 = TasksKt.WORK_STEALING_TIME_RESOLUTION_NS;
                                    if (jNanoTime < j4) {
                                        j3 = j4 - jNanoTime;
                                        task = null;
                                        break;
                                    }
                                    do {
                                        task = null;
                                        if (atomicReferenceFieldUpdater.compareAndSet(workQueue2, task3, null)) {
                                            ref$ObjectRef.element = task3;
                                            j3 = -1;
                                            break;
                                        }
                                    } while (atomicReferenceFieldUpdater.get(workQueue2) == task3);
                                    workQueue = workQueue2;
                                    task2 = null;
                                }
                            }
                            j3 = -2;
                            task = task2;
                            break;
                        }
                    } else {
                        ref$ObjectRef.element = taskTryExtractFromTheMiddle;
                        task = task2;
                        j3 = -1;
                        j2 = -1;
                    }
                    if (j3 == j2) {
                        Task task4 = (Task) ref$ObjectRef.element;
                        ref$ObjectRef.element = task;
                        return task4;
                    }
                    if (j3 > j) {
                        jMin = Math.min(jMin, j3);
                    }
                }
                i3++;
                task2 = null;
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.minDelayUntilStealableTaskNs = jMin;
            return null;
        }
    }

    public CoroutineScheduler(int i, int i2, long j, String str) {
        this.corePoolSize = i;
        this.maxPoolSize = i2;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
        if (i < 1) {
            throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m(i, "Core pool size ", " should be at least 1").toString());
        }
        if (i2 < i) {
            throw new IllegalArgumentException(Modifier.CC.m(i2, i, "Max pool size ", " should be greater than or equals to core pool size ").toString());
        }
        if (i2 > 2097150) {
            throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m(i2, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
        }
        this.globalCpuQueue = new GlobalQueue();
        this.globalBlockingQueue = new GlobalQueue();
        this.workers = new ResizableAtomicArray((i + 1) * 2);
        this.controlState$volatile = ((long) i) << 42;
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, int i) {
        coroutineScheduler.dispatch(runnable, false, (i & 4) == 0);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0087  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws InterruptedException {
        int i;
        Task taskFindTask;
        if (_isTerminated$volatile$FU.compareAndSet(this, 0, 1)) {
            Thread threadCurrentThread = Thread.currentThread();
            Worker worker = threadCurrentThread instanceof Worker ? (Worker) threadCurrentThread : null;
            if (worker == null || !Intrinsics.areEqual(CoroutineScheduler.this, this)) {
                worker = null;
            }
            synchronized (this.workers) {
                i = (int) (controlState$volatile$FU.get(this) & 2097151);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    Worker worker2 = (Worker) this.workers.get(i2);
                    if (worker2 != worker) {
                        while (worker2.getState() != Thread.State.TERMINATED) {
                            LockSupport.unpark(worker2);
                            worker2.join(10000L);
                        }
                        WorkQueue workQueue = worker2.localQueue;
                        GlobalQueue globalQueue = this.globalBlockingQueue;
                        workQueue.getClass();
                        Task task = (Task) WorkQueue.lastScheduledTask$volatile$FU.getAndSet(workQueue, null);
                        if (task != null) {
                            globalQueue.addLast(task);
                        }
                        while (true) {
                            Task taskPollBuffer = workQueue.pollBuffer();
                            if (taskPollBuffer == null) {
                                break;
                            } else {
                                globalQueue.addLast(taskPollBuffer);
                            }
                        }
                    }
                    if (i2 == i) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            this.globalBlockingQueue.close();
            this.globalCpuQueue.close();
            while (true) {
                if (worker != null) {
                    taskFindTask = worker.findTask(true);
                    if (taskFindTask == null) {
                        taskFindTask = (Task) this.globalCpuQueue.removeFirstOrNull();
                        if (taskFindTask == null) {
                            break;
                            break;
                        }
                    }
                } else {
                    taskFindTask = (Task) this.globalCpuQueue.removeFirstOrNull();
                    if (taskFindTask == null && (taskFindTask = (Task) this.globalBlockingQueue.removeFirstOrNull()) == null) {
                        break;
                    }
                }
                try {
                    taskFindTask.run();
                } catch (Throwable th) {
                    Thread threadCurrentThread2 = Thread.currentThread();
                    threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
                }
            }
            if (worker != null) {
                worker.tryReleaseCpu(5);
            }
            parkedWorkersStack$volatile$FU.set(this, 0L);
            controlState$volatile$FU.set(this, 0L);
        }
    }

    public final int createNewWorker() {
        synchronized (this.workers) {
            try {
                if (_isTerminated$volatile$FU.get(this) == 1) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = controlState$volatile$FU;
                long j = atomicLongFieldUpdater.get(this);
                int i = (int) (j & 2097151);
                int i2 = i - ((int) ((j & 4398044413952L) >> 21));
                if (i2 < 0) {
                    i2 = 0;
                }
                if (i2 >= this.corePoolSize) {
                    return 0;
                }
                if (i >= this.maxPoolSize) {
                    return 0;
                }
                int i3 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i3 <= 0 || this.workers.get(i3) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                Worker worker = new Worker(i3);
                this.workers.setSynchronized(i3, worker);
                if (i3 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i4 = i2 + 1;
                worker.start();
                return i4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void dispatch(Runnable runnable, boolean z, boolean z2) {
        Task taskImpl;
        int i;
        TasksKt.schedulerTimeSource.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof Task) {
            taskImpl = (Task) runnable;
            taskImpl.submissionTime = jNanoTime;
            taskImpl.taskContext = z;
        } else {
            taskImpl = new TaskImpl(runnable, jNanoTime, z);
        }
        boolean z3 = taskImpl.taskContext;
        AtomicLongFieldUpdater atomicLongFieldUpdater = controlState$volatile$FU;
        long jAddAndGet = z3 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        Worker worker = threadCurrentThread instanceof Worker ? (Worker) threadCurrentThread : null;
        if (worker == null || !Intrinsics.areEqual(CoroutineScheduler.this, this)) {
            worker = null;
        }
        if (worker != null && (i = worker.state) != 5 && (taskImpl.taskContext || i != 2)) {
            worker.mayHaveLocalTasks = true;
            WorkQueue workQueue = worker.localQueue;
            if (z2) {
                taskImpl = workQueue.addLast(taskImpl);
            } else {
                workQueue.getClass();
                Task task = (Task) WorkQueue.lastScheduledTask$volatile$FU.getAndSet(workQueue, taskImpl);
                taskImpl = task == null ? null : workQueue.addLast(task);
            }
        }
        if (taskImpl != null) {
            if (!(taskImpl.taskContext ? this.globalBlockingQueue.addLast(taskImpl) : this.globalCpuQueue.addLast(taskImpl))) {
                throw new RejectedExecutionException(ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder(), this.schedulerName, " was terminated"));
            }
        }
        if (z3) {
            if (tryUnpark() || tryCreateWorker(jAddAndGet)) {
                return;
            }
            tryUnpark();
            return;
        }
        if (tryUnpark() || tryCreateWorker(atomicLongFieldUpdater.get(this))) {
            return;
        }
        tryUnpark();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        dispatch$default(this, runnable, 6);
    }

    public final void parkedWorkersStackTopUpdate(Worker worker, int i, int i2) {
        while (true) {
            long j = parkedWorkersStack$volatile$FU.get(this);
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (i3 == i) {
                if (i2 == 0) {
                    Object nextParkedWorker = worker.getNextParkedWorker();
                    while (true) {
                        if (nextParkedWorker == NOT_IN_STACK) {
                            i3 = -1;
                            break;
                        }
                        if (nextParkedWorker == null) {
                            i3 = 0;
                            break;
                        }
                        Worker worker2 = (Worker) nextParkedWorker;
                        int indexInArray = worker2.getIndexInArray();
                        if (indexInArray != 0) {
                            i3 = indexInArray;
                            break;
                        }
                        nextParkedWorker = worker2.getNextParkedWorker();
                    }
                } else {
                    i3 = i2;
                }
            }
            if (i3 >= 0) {
                if (parkedWorkersStack$volatile$FU.compareAndSet(this, j, ((long) i3) | j2)) {
                    return;
                }
            }
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        ResizableAtomicArray resizableAtomicArray = this.workers;
        int iCurrentLength = resizableAtomicArray.currentLength();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < iCurrentLength; i6++) {
            Worker worker = (Worker) resizableAtomicArray.get(i6);
            if (worker != null) {
                WorkQueue workQueue = worker.localQueue;
                workQueue.getClass();
                int i7 = WorkQueue.lastScheduledTask$volatile$FU.get(workQueue) != null ? (WorkQueue.producerIndex$volatile$FU.get(workQueue) - WorkQueue.consumerIndex$volatile$FU.get(workQueue)) + 1 : WorkQueue.producerIndex$volatile$FU.get(workQueue) - WorkQueue.consumerIndex$volatile$FU.get(workQueue);
                int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(worker.state);
                if (iOrdinal == 0) {
                    i++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i7);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iOrdinal == 1) {
                    i2++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i7);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 2) {
                    i3++;
                } else if (iOrdinal == 3) {
                    i4++;
                    if (i7 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i7);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    if (iOrdinal != 4) {
                        throw new HttpException();
                    }
                    i5++;
                }
            }
        }
        long j = controlState$volatile$FU.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.schedulerName);
        sb4.append('@');
        sb4.append(JobKt.getHexAddress(this));
        sb4.append("[Pool Size {core = ");
        int i8 = this.corePoolSize;
        sb4.append(i8);
        sb4.append(", max = ");
        sb4.append(this.maxPoolSize);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i);
        sb4.append(", blocking = ");
        sb4.append(i2);
        sb4.append(", parked = ");
        sb4.append(i3);
        sb4.append(", dormant = ");
        sb4.append(i4);
        sb4.append(", terminated = ");
        sb4.append(i5);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.globalCpuQueue.getSize());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.globalBlockingQueue.getSize());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i8 - ((int) ((j & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }

    public final boolean tryCreateWorker(long j) {
        int i = ((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21));
        if (i < 0) {
            i = 0;
        }
        int i2 = this.corePoolSize;
        if (i < i2) {
            int iCreateNewWorker = createNewWorker();
            if (iCreateNewWorker == 1 && i2 > 1) {
                createNewWorker();
            }
            if (iCreateNewWorker > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean tryUnpark() {
        Symbol symbol;
        int indexInArray;
        while (true) {
            long j = parkedWorkersStack$volatile$FU.get(this);
            Worker worker = (Worker) this.workers.get((int) (2097151 & j));
            if (worker == null) {
                worker = null;
            } else {
                long j2 = (2097152 + j) & (-2097152);
                Object nextParkedWorker = worker.getNextParkedWorker();
                while (true) {
                    symbol = NOT_IN_STACK;
                    if (nextParkedWorker == symbol) {
                        indexInArray = -1;
                        break;
                    }
                    if (nextParkedWorker == null) {
                        indexInArray = 0;
                        break;
                    }
                    Worker worker2 = (Worker) nextParkedWorker;
                    indexInArray = worker2.getIndexInArray();
                    if (indexInArray != 0) {
                        break;
                    }
                    nextParkedWorker = worker2.getNextParkedWorker();
                }
                if (indexInArray >= 0) {
                    if (parkedWorkersStack$volatile$FU.compareAndSet(this, j, ((long) indexInArray) | j2)) {
                        worker.setNextParkedWorker(symbol);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (worker == null) {
                return false;
            }
            if (Worker.workerCtl$volatile$FU.compareAndSet(worker, -1, 0)) {
                LockSupport.unpark(worker);
                return true;
            }
        }
    }
}
