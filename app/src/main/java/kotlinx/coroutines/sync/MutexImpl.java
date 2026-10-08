package kotlinx.coroutines.sync;

import androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda5;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MutexImpl extends SemaphoreAndMutexImpl implements Mutex {
    public static final /* synthetic */ AtomicReferenceFieldUpdater owner$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner$volatile");
    private volatile /* synthetic */ Object owner$volatile;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CancellableContinuationWithOwner implements CancellableContinuation, Waiter {
        public final CancellableContinuationImpl cont;

        public CancellableContinuationWithOwner(CancellableContinuationImpl cancellableContinuationImpl) {
            this.cont = cancellableContinuationImpl;
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public final boolean cancel(Throwable th) {
            return this.cont.cancel(th);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public final void completeResume(Object obj) {
            this.cont.completeResume(obj);
        }

        @Override // kotlin.coroutines.Continuation
        public final CoroutineContext getContext() {
            return this.cont.context;
        }

        @Override // kotlinx.coroutines.Waiter
        public final void invokeOnCancellation(Segment segment, int i) {
            this.cont.invokeOnCancellation(segment, i);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public final void resume(Object obj, Function3 function3) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = MutexImpl.owner$volatile$FU;
            MutexImpl mutexImpl = MutexImpl.this;
            atomicReferenceFieldUpdater.set(mutexImpl, null);
            DiskLruCache$$ExternalSyntheticLambda0 diskLruCache$$ExternalSyntheticLambda0 = new DiskLruCache$$ExternalSyntheticLambda0(21, mutexImpl, this);
            CancellableContinuationImpl cancellableContinuationImpl = this.cont;
            cancellableContinuationImpl.resumeImpl$kotlinx_coroutines_core((Unit) obj, cancellableContinuationImpl.resumeMode, new SheetDefaultsKt$$ExternalSyntheticLambda5(6, diskLruCache$$ExternalSyntheticLambda0));
        }

        @Override // kotlin.coroutines.Continuation
        public final void resumeWith(Object obj) {
            this.cont.resumeWith(obj);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public final Symbol tryResume(Object obj, Function3 function3) {
            MutexImpl mutexImpl = MutexImpl.this;
            SheetDefaultsKt$$ExternalSyntheticLambda5 sheetDefaultsKt$$ExternalSyntheticLambda5 = new SheetDefaultsKt$$ExternalSyntheticLambda5(mutexImpl, this);
            Symbol symbolTryResume = this.cont.tryResume((Unit) obj, sheetDefaultsKt$$ExternalSyntheticLambda5);
            if (symbolTryResume != null) {
                MutexImpl.owner$volatile$FU.set(mutexImpl, null);
            }
            return symbolTryResume;
        }
    }

    public MutexImpl() {
        super(1);
        this.owner$volatile = MutexKt.NO_OWNER;
    }

    public final boolean isLocked() {
        return Math.max(SemaphoreAndMutexImpl._availablePermits$volatile$FU.get(this), 0) == 0;
    }

    public final Object lock(Continuation continuation) {
        if (tryLock()) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl orCreateCancellableContinuation = JobKt.getOrCreateCancellableContinuation(zzga.intercepted(continuation));
        try {
            CancellableContinuationWithOwner cancellableContinuationWithOwner = new CancellableContinuationWithOwner(orCreateCancellableContinuation);
            while (true) {
                int andDecrement = SemaphoreAndMutexImpl._availablePermits$volatile$FU.getAndDecrement(this);
                if (andDecrement <= this.permits) {
                    if (andDecrement > 0) {
                        cancellableContinuationWithOwner.resume(Unit.INSTANCE, this.onCancellationRelease);
                        break;
                    }
                    if (addAcquireToQueue(cancellableContinuationWithOwner)) {
                        break;
                    }
                }
            }
            Object result = orCreateCancellableContinuation.getResult();
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (result != coroutineSingletons) {
                result = Unit.INSTANCE;
            }
            return result == coroutineSingletons ? result : Unit.INSTANCE;
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    public final String toString() {
        return "Mutex@" + JobKt.getHexAddress(this) + "[isLocked=" + isLocked() + ",owner=" + owner$volatile$FU.get(this) + ']';
    }

    public final boolean tryLock() {
        int i;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = SemaphoreAndMutexImpl._availablePermits$volatile$FU;
            int i2 = atomicIntegerFieldUpdater.get(this);
            int i3 = this.permits;
            if (i2 > i3) {
                do {
                    i = atomicIntegerFieldUpdater.get(this);
                    if (i <= i3) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, i3));
            } else {
                if (i2 <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i2, i2 - 1)) {
                    owner$volatile$FU.set(this, null);
                    return true;
                }
            }
        }
    }

    public final void unlock(Object obj) {
        while (isLocked()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = owner$volatile$FU;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            Symbol symbol = MutexKt.NO_OWNER;
            if (obj2 != symbol) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, symbol)) {
                        release();
                        return;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == obj2);
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }
}
