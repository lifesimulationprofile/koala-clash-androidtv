package kotlinx.coroutines.internal;

import androidx.compose.runtime.State;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.PropertyReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty0;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class LockFreeLinkedListNode {
    public static final /* synthetic */ AtomicReferenceFieldUpdater _next$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater _prev$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater _removedRef$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    /* JADX INFO: renamed from: kotlinx.coroutines.internal.LockFreeLinkedListNode$toString$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final /* synthetic */ class AnonymousClass1 extends PropertyReference implements KProperty0 {
        public final /* synthetic */ int $r8$classId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(int i, int i2, Class cls, Object obj, String str, String str2) {
            super(obj, cls, str, str2, i);
            this.$r8$classId = i2;
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KCallable computeReflected() {
            Reflection.factory.getClass();
            return this;
        }

        @Override // kotlin.reflect.KProperty0
        public final Object get() {
            switch (this.$r8$classId) {
                case 0:
                    return this.receiver.getClass().getSimpleName();
                default:
                    return ((State) this.receiver).getValue();
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return get();
        }
    }

    public final boolean addLast(LockFreeLinkedListNode lockFreeLinkedListNode, int i) {
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNodeCorrectPrev = correctPrev();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _prev$volatile$FU;
            if (lockFreeLinkedListNodeCorrectPrev == null) {
                Object obj = atomicReferenceFieldUpdater.get(this);
                while (true) {
                    lockFreeLinkedListNodeCorrectPrev = (LockFreeLinkedListNode) obj;
                    if (!lockFreeLinkedListNodeCorrectPrev.isRemoved()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(lockFreeLinkedListNodeCorrectPrev);
                }
            }
            if (lockFreeLinkedListNodeCorrectPrev instanceof ListClosed) {
                return (((ListClosed) lockFreeLinkedListNodeCorrectPrev).forbiddenElementsBitmask & i) == 0 && lockFreeLinkedListNodeCorrectPrev.addLast(lockFreeLinkedListNode, i);
            }
            atomicReferenceFieldUpdater.set(lockFreeLinkedListNode, lockFreeLinkedListNodeCorrectPrev);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _next$volatile$FU;
            atomicReferenceFieldUpdater2.set(lockFreeLinkedListNode, this);
            do {
                if (atomicReferenceFieldUpdater2.compareAndSet(lockFreeLinkedListNodeCorrectPrev, this, lockFreeLinkedListNode)) {
                    lockFreeLinkedListNode.finishAdd(this);
                    return true;
                }
            } while (atomicReferenceFieldUpdater2.get(lockFreeLinkedListNodeCorrectPrev) == this);
        }
    }

    public final LockFreeLinkedListNode correctPrev() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _prev$volatile$FU;
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) atomicReferenceFieldUpdater2.get(this);
            LockFreeLinkedListNode lockFreeLinkedListNode2 = lockFreeLinkedListNode;
            while (true) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = null;
                while (true) {
                    atomicReferenceFieldUpdater = _next$volatile$FU;
                    obj = atomicReferenceFieldUpdater.get(lockFreeLinkedListNode2);
                    if (obj == this) {
                        if (lockFreeLinkedListNode == lockFreeLinkedListNode2) {
                            return lockFreeLinkedListNode2;
                        }
                        while (!atomicReferenceFieldUpdater2.compareAndSet(this, lockFreeLinkedListNode, lockFreeLinkedListNode2)) {
                            if (atomicReferenceFieldUpdater2.get(this) != lockFreeLinkedListNode) {
                                break;
                            }
                        }
                        return lockFreeLinkedListNode2;
                    }
                    if (isRemoved()) {
                        return null;
                    }
                    if (!(obj instanceof Removed)) {
                        lockFreeLinkedListNode3 = lockFreeLinkedListNode2;
                        lockFreeLinkedListNode2 = (LockFreeLinkedListNode) obj;
                    } else {
                        if (lockFreeLinkedListNode3 != null) {
                            break;
                        }
                        lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater2.get(lockFreeLinkedListNode2);
                    }
                }
                LockFreeLinkedListNode lockFreeLinkedListNode4 = ((Removed) obj).ref;
                while (!atomicReferenceFieldUpdater.compareAndSet(lockFreeLinkedListNode3, lockFreeLinkedListNode2, lockFreeLinkedListNode4)) {
                    if (atomicReferenceFieldUpdater.get(lockFreeLinkedListNode3) != lockFreeLinkedListNode2) {
                        break;
                    }
                }
                lockFreeLinkedListNode2 = lockFreeLinkedListNode3;
            }
        }
    }

    public final void finishAdd(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _prev$volatile$FU;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (_next$volatile$FU.get(this) != lockFreeLinkedListNode) {
                return;
            }
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(lockFreeLinkedListNode, lockFreeLinkedListNode2, this)) {
                    if (isRemoved()) {
                        lockFreeLinkedListNode.correctPrev();
                        return;
                    }
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(lockFreeLinkedListNode) == lockFreeLinkedListNode2);
        }
    }

    public final LockFreeLinkedListNode getNextNode() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Object obj = _next$volatile$FU.get(this);
        Removed removed = obj instanceof Removed ? (Removed) obj : null;
        return (removed == null || (lockFreeLinkedListNode = removed.ref) == null) ? (LockFreeLinkedListNode) obj : lockFreeLinkedListNode;
    }

    public boolean isRemoved() {
        return _next$volatile$FU.get(this) instanceof Removed;
    }

    public String toString() {
        return new AnonymousClass1(1, 0, JobKt.class, this, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;") + '@' + JobKt.getHexAddress(this);
    }
}
