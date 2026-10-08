package kotlinx.coroutines.sync;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda5;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class SemaphoreAndMutexImpl {
    private volatile /* synthetic */ int _availablePermits$volatile;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    public final SheetDefaultsKt$$ExternalSyntheticLambda5 onCancellationRelease;
    public final int permits;
    private volatile /* synthetic */ Object tail$volatile;
    public static final /* synthetic */ AtomicReferenceFieldUpdater head$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, Object.class, "head$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater deqIdx$volatile$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "deqIdx$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater tail$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, Object.class, "tail$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater enqIdx$volatile$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "enqIdx$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater _availablePermits$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "_availablePermits$volatile");

    public SemaphoreAndMutexImpl(int i) {
        this.permits = i;
        if (i <= 0) {
            throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m("Semaphore should have at least 1 permit, but had ", i).toString());
        }
        if (i < 0) {
            throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m("The number of acquired permits should be in 0..", i).toString());
        }
        SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0L, null, 2);
        this.head$volatile = semaphoreSegment;
        this.tail$volatile = semaphoreSegment;
        this._availablePermits$volatile = i;
        this.onCancellationRelease = new SheetDefaultsKt$$ExternalSyntheticLambda5(8, this);
    }

    public final boolean addAcquireToQueue(Waiter waiter) {
        Object objFindSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = tail$volatile$FU;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) atomicReferenceFieldUpdater.get(this);
        long andIncrement = enqIdx$volatile$FU.getAndIncrement(this);
        SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 = SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1.INSTANCE;
        long j = andIncrement / ((long) SemaphoreKt.SEGMENT_SIZE);
        loop0: while (true) {
            objFindSegmentInternal = InlineList.findSegmentInternal(semaphoreSegment, j, semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1);
            if (!InlineList.m845isClosedimpl(objFindSegmentInternal)) {
                Segment segmentM844getSegmentimpl = InlineList.m844getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= segmentM844getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!segmentM844getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, segment, segmentM844getSegmentimpl)) {
                            if (!segment.decPointers$kotlinx_coroutines_core()) {
                                break loop0;
                            }
                            segment.remove();
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == segment);
                    if (segmentM844getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        segmentM844getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) InlineList.m844getSegmentimpl(objFindSegmentInternal);
        AtomicReferenceArray atomicReferenceArray = semaphoreSegment2.acquirers;
        int i = (int) (andIncrement % ((long) SemaphoreKt.SEGMENT_SIZE));
        while (!atomicReferenceArray.compareAndSet(i, null, waiter)) {
            if (atomicReferenceArray.get(i) != null) {
                Symbol symbol = SemaphoreKt.PERMIT;
                Symbol symbol2 = SemaphoreKt.TAKEN;
                while (!atomicReferenceArray.compareAndSet(i, symbol, symbol2)) {
                    if (atomicReferenceArray.get(i) != symbol) {
                        return false;
                    }
                }
                ((CancellableContinuation) waiter).resume(Unit.INSTANCE, this.onCancellationRelease);
                return true;
            }
        }
        waiter.invokeOnCancellation(semaphoreSegment2, i);
        return true;
    }

    public final void release() {
        int i;
        Object objFindSegmentInternal;
        boolean z;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _availablePermits$volatile$FU;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            int i2 = this.permits;
            if (andIncrement >= i2) {
                do {
                    i = atomicIntegerFieldUpdater.get(this);
                    if (i <= i2) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, i2));
                throw new IllegalStateException(("The number of released permits cannot be greater than " + i2).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = head$volatile$FU;
            SemaphoreSegment semaphoreSegment = (SemaphoreSegment) atomicReferenceFieldUpdater.get(this);
            long andIncrement2 = deqIdx$volatile$FU.getAndIncrement(this);
            long j = andIncrement2 / ((long) SemaphoreKt.SEGMENT_SIZE);
            SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE;
            while (true) {
                objFindSegmentInternal = InlineList.findSegmentInternal(semaphoreSegment, j, semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1);
                if (!InlineList.m845isClosedimpl(objFindSegmentInternal)) {
                    Segment segmentM844getSegmentimpl = InlineList.m844getSegmentimpl(objFindSegmentInternal);
                    while (true) {
                        Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                        if (segment.id >= segmentM844getSegmentimpl.id) {
                            break;
                        }
                        if (!segmentM844getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                            break;
                        }
                        do {
                            if (atomicReferenceFieldUpdater.compareAndSet(this, segment, segmentM844getSegmentimpl)) {
                                if (!segment.decPointers$kotlinx_coroutines_core()) {
                                    break;
                                }
                                segment.remove();
                                break;
                            }
                        } while (atomicReferenceFieldUpdater.get(this) == segment);
                        if (segmentM844getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                            segmentM844getSegmentimpl.remove();
                        }
                    }
                } else {
                    break;
                }
            }
            SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) InlineList.m844getSegmentimpl(objFindSegmentInternal);
            AtomicReferenceArray atomicReferenceArray = semaphoreSegment2.acquirers;
            semaphoreSegment2.cleanPrev();
            z = false;
            if (semaphoreSegment2.id <= j) {
                int i3 = (int) (andIncrement2 % ((long) SemaphoreKt.SEGMENT_SIZE));
                Object andSet = atomicReferenceArray.getAndSet(i3, SemaphoreKt.PERMIT);
                if (andSet == null) {
                    int i4 = SemaphoreKt.MAX_SPIN_CYCLES;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= i4) {
                            Symbol symbol = SemaphoreKt.PERMIT;
                            Symbol symbol2 = SemaphoreKt.BROKEN;
                            do {
                                if (atomicReferenceArray.compareAndSet(i3, symbol, symbol2)) {
                                    z = true;
                                    break;
                                }
                            } while (atomicReferenceArray.get(i3) == symbol);
                            z = !z;
                            break;
                        }
                        if (atomicReferenceArray.get(i3) == SemaphoreKt.TAKEN) {
                            z = true;
                            break;
                        }
                        i5++;
                    }
                } else if (andSet != SemaphoreKt.CANCELLED) {
                    if (andSet instanceof CancellableContinuation) {
                        CancellableContinuation cancellableContinuation = (CancellableContinuation) andSet;
                        Symbol symbolTryResume = cancellableContinuation.tryResume(Unit.INSTANCE, this.onCancellationRelease);
                        if (symbolTryResume != null) {
                            cancellableContinuation.completeResume(symbolTryResume);
                            z = true;
                            break;
                            break;
                        }
                    } else {
                        if (!(andSet instanceof SelectInstance)) {
                            throw new IllegalStateException(("unexpected: " + andSet).toString());
                        }
                        if (((SelectImplementation) ((SelectInstance) andSet)).trySelectInternal(this, Unit.INSTANCE) == 0) {
                            z = true;
                            break;
                            break;
                        }
                    }
                }
            }
        } while (!z);
    }
}
