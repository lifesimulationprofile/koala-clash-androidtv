package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Removed;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class JobNode extends LockFreeLinkedListNode implements DisposableHandle, Incomplete {
    public JobSupport job;

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        JobSupport job = getJob();
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = JobSupport._state$volatile$FU;
            Object obj = atomicReferenceFieldUpdater.get(job);
            if (obj instanceof JobNode) {
                if (obj != this) {
                    return;
                }
                Empty empty = JobKt.EMPTY_ACTIVE;
                while (!atomicReferenceFieldUpdater.compareAndSet(job, obj, empty)) {
                    if (atomicReferenceFieldUpdater.get(job) != obj) {
                    }
                }
                return;
            }
            if (!(obj instanceof Incomplete) || ((Incomplete) obj).getList() == null) {
                return;
            }
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = LockFreeLinkedListNode._next$volatile$FU;
                Object obj2 = atomicReferenceFieldUpdater2.get(this);
                if (obj2 instanceof Removed) {
                    return;
                }
                if (obj2 == this) {
                    return;
                }
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj2;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = LockFreeLinkedListNode._removedRef$volatile$FU;
                Removed removed = (Removed) atomicReferenceFieldUpdater3.get(lockFreeLinkedListNode);
                if (removed == null) {
                    removed = new Removed(lockFreeLinkedListNode);
                    atomicReferenceFieldUpdater3.set(lockFreeLinkedListNode, removed);
                }
                do {
                    if (atomicReferenceFieldUpdater2.compareAndSet(this, obj2, removed)) {
                        lockFreeLinkedListNode.correctPrev();
                        return;
                    }
                } while (atomicReferenceFieldUpdater2.get(this) == obj2);
            }
        }
    }

    public final JobSupport getJob() {
        JobSupport jobSupport = this.job;
        if (jobSupport != null) {
            return jobSupport;
        }
        Intrinsics.throwUninitializedPropertyAccessException("job");
        throw null;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final NodeList getList() {
        return null;
    }

    public abstract boolean getOnCancelling();

    public Job getParent() {
        return getJob();
    }

    public abstract void invoke(Throwable th);

    @Override // kotlinx.coroutines.Incomplete
    public final boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final String toString() {
        return getClass().getSimpleName() + '@' + JobKt.getHexAddress(this) + "[job@" + JobKt.getHexAddress(getJob()) + ']';
    }
}
