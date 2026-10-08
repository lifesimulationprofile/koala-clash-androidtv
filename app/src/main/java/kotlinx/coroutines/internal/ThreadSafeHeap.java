package kotlinx.coroutines.internal;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.EventLoopImplBase;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class ThreadSafeHeap {
    public static final /* synthetic */ AtomicIntegerFieldUpdater _size$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;
    public EventLoopImplBase.DelayedTask[] a;

    public final void addImpl(EventLoopImplBase.DelayedTask delayedTask) {
        delayedTask.setHeap((EventLoopImplBase.DelayedTaskQueue) this);
        EventLoopImplBase.DelayedTask[] delayedTaskArr = this.a;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _size$volatile$FU;
        if (delayedTaskArr == null) {
            delayedTaskArr = new EventLoopImplBase.DelayedTask[4];
            this.a = delayedTaskArr;
        } else if (atomicIntegerFieldUpdater.get(this) >= delayedTaskArr.length) {
            delayedTaskArr = (EventLoopImplBase.DelayedTask[]) Arrays.copyOf(delayedTaskArr, atomicIntegerFieldUpdater.get(this) * 2);
            this.a = delayedTaskArr;
        }
        int i = atomicIntegerFieldUpdater.get(this);
        atomicIntegerFieldUpdater.set(this, i + 1);
        delayedTaskArr[i] = delayedTask;
        delayedTask.index = i;
        while (i > 0) {
            Object[] objArr = this.a;
            int i2 = (i - 1) / 2;
            if (objArr[i2].compareTo(objArr[i]) <= 0) {
                return;
            }
            swap(i, i2);
            i = i2;
        }
    }

    public final void remove(EventLoopImplBase.DelayedTask delayedTask) {
        synchronized (this) {
            if (delayedTask.getHeap() != null) {
                removeAtImpl(delayedTask.index);
            }
        }
    }

    public final EventLoopImplBase.DelayedTask removeAtImpl(int i) {
        Object[] objArr = this.a;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _size$volatile$FU;
        atomicIntegerFieldUpdater.set(this, atomicIntegerFieldUpdater.get(this) - 1);
        if (i < atomicIntegerFieldUpdater.get(this)) {
            swap(i, atomicIntegerFieldUpdater.get(this));
            int i2 = (i - 1) / 2;
            if (i <= 0 || objArr[i].compareTo(objArr[i2]) >= 0) {
                while (true) {
                    int i3 = i * 2;
                    int i4 = i3 + 1;
                    if (i4 >= atomicIntegerFieldUpdater.get(this)) {
                        break;
                    }
                    Object[] objArr2 = this.a;
                    int i5 = i3 + 2;
                    if (i5 >= atomicIntegerFieldUpdater.get(this) || objArr2[i5].compareTo(objArr2[i4]) >= 0) {
                        i5 = i4;
                    }
                    if (objArr2[i].compareTo(objArr2[i5]) <= 0) {
                        break;
                    }
                    swap(i, i5);
                    i = i5;
                }
            } else {
                swap(i, i2);
                while (i2 > 0) {
                    Object[] objArr3 = this.a;
                    int i6 = (i2 - 1) / 2;
                    if (objArr3[i6].compareTo(objArr3[i2]) <= 0) {
                        break;
                    }
                    swap(i2, i6);
                    i2 = i6;
                }
            }
        }
        EventLoopImplBase.DelayedTask delayedTask = objArr[atomicIntegerFieldUpdater.get(this)];
        delayedTask.setHeap(null);
        delayedTask.index = -1;
        objArr[atomicIntegerFieldUpdater.get(this)] = null;
        return delayedTask;
    }

    public final void swap(int i, int i2) {
        EventLoopImplBase.DelayedTask[] delayedTaskArr = this.a;
        EventLoopImplBase.DelayedTask delayedTask = delayedTaskArr[i2];
        EventLoopImplBase.DelayedTask delayedTask2 = delayedTaskArr[i];
        delayedTaskArr[i] = delayedTask;
        delayedTaskArr[i2] = delayedTask2;
        delayedTask.index = i;
        delayedTask2.index = i2;
    }
}
