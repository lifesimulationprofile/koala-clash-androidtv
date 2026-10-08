package kotlinx.coroutines.channels;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class BufferedChannel implements Channel {
    private volatile /* synthetic */ Object _closeCause$volatile;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    public final int capacity;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;
    public static final /* synthetic */ AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater receivers$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater bufferEnd$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater sendSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater receiveSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater bufferEndSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater _closeCause$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater closeHandler$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler$volatile");

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class BufferedChannelIterator implements Waiter {
        public CancellableContinuationImpl continuation;
        public Object receiveResult = BufferedChannelKt.NO_RECEIVE_RESULT;

        public BufferedChannelIterator() {
        }

        public final Object hasNext(ContinuationImpl continuationImpl) throws Throwable {
            ChannelSegment channelSegmentFindSegmentReceive;
            Object obj = this.receiveResult;
            boolean z = true;
            if (obj == BufferedChannelKt.NO_RECEIVE_RESULT || obj == BufferedChannelKt.CHANNEL_CLOSED) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = BufferedChannel.receiveSegment$volatile$FU;
                BufferedChannel bufferedChannel = BufferedChannel.this;
                ChannelSegment channelSegment = (ChannelSegment) atomicReferenceFieldUpdater.get(bufferedChannel);
                while (!bufferedChannel.isClosedForReceive()) {
                    long andIncrement = BufferedChannel.receivers$volatile$FU.getAndIncrement(bufferedChannel);
                    long j = BufferedChannelKt.SEGMENT_SIZE;
                    long j2 = andIncrement / j;
                    int i = (int) (andIncrement % j);
                    if (channelSegment.id != j2) {
                        channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j2, channelSegment);
                        if (channelSegmentFindSegmentReceive == null) {
                            continue;
                        }
                    } else {
                        channelSegmentFindSegmentReceive = channelSegment;
                    }
                    Object objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegmentFindSegmentReceive, i, andIncrement, null);
                    Symbol symbol = BufferedChannelKt.SUSPEND;
                    if (objUpdateCellReceive == symbol) {
                        throw new IllegalStateException("unreachable");
                    }
                    Symbol symbol2 = BufferedChannelKt.FAILED;
                    if (objUpdateCellReceive == symbol2) {
                        if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegmentFindSegmentReceive.cleanPrev();
                        }
                        channelSegment = channelSegmentFindSegmentReceive;
                    } else {
                        if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                            BufferedChannel bufferedChannel2 = BufferedChannel.this;
                            CancellableContinuationImpl orCreateCancellableContinuation = JobKt.getOrCreateCancellableContinuation(zzga.intercepted(continuationImpl));
                            try {
                                this.continuation = orCreateCancellableContinuation;
                                Object objUpdateCellReceive2 = bufferedChannel2.updateCellReceive(channelSegmentFindSegmentReceive, i, andIncrement, this);
                                if (objUpdateCellReceive2 != symbol) {
                                    if (objUpdateCellReceive2 == symbol2) {
                                        if (andIncrement < bufferedChannel2.getSendersCounter$kotlinx_coroutines_core()) {
                                            channelSegmentFindSegmentReceive.cleanPrev();
                                        }
                                        ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.receiveSegment$volatile$FU.get(bufferedChannel2);
                                        while (true) {
                                            if (bufferedChannel2.isClosedForReceive()) {
                                                CancellableContinuationImpl cancellableContinuationImpl = this.continuation;
                                                this.continuation = null;
                                                this.receiveResult = BufferedChannelKt.CHANNEL_CLOSED;
                                                Throwable closeCause = bufferedChannel.getCloseCause();
                                                if (closeCause != null) {
                                                    cancellableContinuationImpl.resumeWith(new Result.Failure(closeCause));
                                                    break;
                                                }
                                                cancellableContinuationImpl.resumeWith(Boolean.FALSE);
                                                break;
                                            }
                                            long andIncrement2 = BufferedChannel.receivers$volatile$FU.getAndIncrement(bufferedChannel2);
                                            long j3 = BufferedChannelKt.SEGMENT_SIZE;
                                            long j4 = andIncrement2 / j3;
                                            int i2 = (int) (andIncrement2 % j3);
                                            if (channelSegment2.id != j4) {
                                                ChannelSegment channelSegmentFindSegmentReceive2 = bufferedChannel2.findSegmentReceive(j4, channelSegment2);
                                                if (channelSegmentFindSegmentReceive2 != null) {
                                                    channelSegment2 = channelSegmentFindSegmentReceive2;
                                                }
                                            }
                                            Object objUpdateCellReceive3 = bufferedChannel2.updateCellReceive(channelSegment2, i2, andIncrement2, this);
                                            if (objUpdateCellReceive3 == BufferedChannelKt.SUSPEND) {
                                                invokeOnCancellation(channelSegment2, i2);
                                                break;
                                            }
                                            if (objUpdateCellReceive3 == BufferedChannelKt.FAILED) {
                                                if (andIncrement2 < bufferedChannel2.getSendersCounter$kotlinx_coroutines_core()) {
                                                    channelSegment2.cleanPrev();
                                                }
                                            } else {
                                                if (objUpdateCellReceive3 == BufferedChannelKt.SUSPEND_NO_WAITER) {
                                                    throw new IllegalStateException("unexpected");
                                                }
                                                channelSegment2.cleanPrev();
                                                this.receiveResult = objUpdateCellReceive3;
                                                this.continuation = null;
                                            }
                                        }
                                    } else {
                                        channelSegmentFindSegmentReceive.cleanPrev();
                                        this.receiveResult = objUpdateCellReceive2;
                                        this.continuation = null;
                                    }
                                    orCreateCancellableContinuation.resume(Boolean.TRUE, null);
                                    break;
                                }
                                invokeOnCancellation(channelSegmentFindSegmentReceive, i);
                                return orCreateCancellableContinuation.getResult();
                            } catch (Throwable th) {
                                orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                                throw th;
                            }
                        }
                        channelSegmentFindSegmentReceive.cleanPrev();
                        this.receiveResult = objUpdateCellReceive;
                    }
                }
                this.receiveResult = BufferedChannelKt.CHANNEL_CLOSED;
                Throwable closeCause2 = bufferedChannel.getCloseCause();
                if (closeCause2 != null) {
                    int i3 = StackTraceRecoveryKt.$r8$clinit;
                    throw closeCause2;
                }
                z = false;
            }
            return Boolean.valueOf(z);
        }

        @Override // kotlinx.coroutines.Waiter
        public final void invokeOnCancellation(Segment segment, int i) {
            CancellableContinuationImpl cancellableContinuationImpl = this.continuation;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.invokeOnCancellation(segment, i);
            }
        }

        public final Object next() throws Throwable {
            Object obj = this.receiveResult;
            Symbol symbol = BufferedChannelKt.NO_RECEIVE_RESULT;
            if (obj == symbol) {
                throw new IllegalStateException("`hasNext()` has not been invoked");
            }
            this.receiveResult = symbol;
            if (obj != BufferedChannelKt.CHANNEL_CLOSED) {
                return obj;
            }
            Throwable receiveException = BufferedChannel.this.getReceiveException();
            int i = StackTraceRecoveryKt.$r8$clinit;
            throw receiveException;
        }
    }

    public BufferedChannel(int i) {
        long j;
        this.capacity = i;
        if (i < 0) {
            throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m(i, "Invalid channel capacity: ", ", should be >=0").toString());
        }
        ChannelSegment channelSegment = BufferedChannelKt.NULL_SEGMENT;
        if (i != 0) {
            j = i != Integer.MAX_VALUE ? i : Long.MAX_VALUE;
        } else {
            j = 0;
        }
        this.bufferEnd$volatile = j;
        this.completedExpandBuffersAndPauseFlag$volatile = bufferEnd$volatile$FU.get(this);
        ChannelSegment channelSegment2 = new ChannelSegment(0L, null, this, 3);
        this.sendSegment$volatile = channelSegment2;
        this.receiveSegment$volatile = channelSegment2;
        this.bufferEndSegment$volatile = isRendezvousOrUnlimited() ? BufferedChannelKt.NULL_SEGMENT : channelSegment2;
        this._closeCause$volatile = BufferedChannelKt.NO_CLOSE_CAUSE;
    }

    public static final ChannelSegment access$findSegmentSend(BufferedChannel bufferedChannel, long j, ChannelSegment channelSegment) {
        Object objFindSegmentInternal;
        BufferedChannel bufferedChannel2;
        ChannelSegment channelSegment2 = BufferedChannelKt.NULL_SEGMENT;
        BufferedChannelKt$createSegmentFunction$1 bufferedChannelKt$createSegmentFunction$1 = BufferedChannelKt$createSegmentFunction$1.INSTANCE;
        loop0: while (true) {
            objFindSegmentInternal = InlineList.findSegmentInternal(channelSegment, j, bufferedChannelKt$createSegmentFunction$1);
            if (!InlineList.m845isClosedimpl(objFindSegmentInternal)) {
                Segment segmentM844getSegmentimpl = InlineList.m844getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = sendSegment$volatile$FU;
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(bufferedChannel);
                    if (segment.id >= segmentM844getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!segmentM844getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(bufferedChannel, segment, segmentM844getSegmentimpl)) {
                            if (!segment.decPointers$kotlinx_coroutines_core()) {
                                break loop0;
                            }
                            segment.remove();
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(bufferedChannel) == segment);
                    if (segmentM844getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        segmentM844getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        boolean zM845isClosedimpl = InlineList.m845isClosedimpl(objFindSegmentInternal);
        AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$volatile$FU;
        if (zM845isClosedimpl) {
            bufferedChannel.isClosedForSend();
            if (channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE) < atomicLongFieldUpdater.get(bufferedChannel)) {
                channelSegment.cleanPrev();
                return null;
            }
        } else {
            ChannelSegment channelSegment3 = (ChannelSegment) InlineList.m844getSegmentimpl(objFindSegmentInternal);
            long j2 = channelSegment3.id;
            if (j2 <= j) {
                return channelSegment3;
            }
            long j3 = ((long) BufferedChannelKt.SEGMENT_SIZE) * j2;
            while (true) {
                long j4 = sendersAndCloseStatus$volatile$FU.get(bufferedChannel);
                long j5 = 1152921504606846975L & j4;
                if (j5 >= j3) {
                    bufferedChannel2 = bufferedChannel;
                    break;
                }
                bufferedChannel2 = bufferedChannel;
                if (sendersAndCloseStatus$volatile$FU.compareAndSet(bufferedChannel2, j4, (((long) ((int) (j4 >> 60))) << 60) + j5)) {
                    break;
                }
                bufferedChannel = bufferedChannel2;
            }
            if (j2 * ((long) BufferedChannelKt.SEGMENT_SIZE) < atomicLongFieldUpdater.get(bufferedChannel2)) {
                channelSegment3.cleanPrev();
            }
        }
        return null;
    }

    public static final void access$onClosedSendOnNoWaiterSuspend(BufferedChannel bufferedChannel, Object obj, CancellableContinuationImpl cancellableContinuationImpl) {
        cancellableContinuationImpl.resumeWith(new Result.Failure(bufferedChannel.getSendException()));
    }

    public static final int access$updateCellSend(BufferedChannel bufferedChannel, ChannelSegment channelSegment, int i, Object obj, long j, Object obj2, boolean z) {
        channelSegment.setElementLazy(i, obj);
        if (z) {
            return bufferedChannel.updateCellSendSlow(channelSegment, i, obj, j, obj2, z);
        }
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
        if (state$kotlinx_coroutines_core == null) {
            if (bufferedChannel.bufferOrRendezvousSend(j)) {
                if (channelSegment.casState$kotlinx_coroutines_core(i, null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(i, null, obj2)) {
                    return 2;
                }
            }
        } else if (state$kotlinx_coroutines_core instanceof Waiter) {
            channelSegment.setElementLazy(i, null);
            if (bufferedChannel.tryResumeReceiver(state$kotlinx_coroutines_core, obj)) {
                channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.DONE_RCV);
                return 0;
            }
            Symbol symbol = BufferedChannelKt.INTERRUPTED_RCV;
            if (channelSegment.data.getAndSet((i * 2) + 1, symbol) == symbol) {
                return 5;
            }
            channelSegment.onCancelledRequest(i, true);
            return 5;
        }
        return bufferedChannel.updateCellSendSlow(channelSegment, i, obj, j, obj2, z);
    }

    public static void incCompletedExpandBufferAttempts$default(BufferedChannel bufferedChannel) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = completedExpandBuffersAndPauseFlag$volatile$FU;
        if ((atomicLongFieldUpdater.addAndGet(bufferedChannel, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(bufferedChannel) & 4611686018427387904L) != 0) {
            }
        }
    }

    public final boolean bufferOrRendezvousSend(long j) {
        return j < bufferEnd$volatile$FU.get(this) || j < receivers$volatile$FU.get(this) + ((long) this.capacity);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        closeOrCancelImpl(cancellationException, true);
    }

    public final boolean closeOrCancelImpl(Throwable th, boolean z) {
        BufferedChannel bufferedChannel;
        boolean z2;
        long j;
        long j2;
        long j3;
        Object obj;
        long j4;
        long j5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        if (!z) {
            bufferedChannel = this;
            break;
        }
        do {
            j5 = atomicLongFieldUpdater.get(this);
            if (((int) (j5 >> 60)) != 0) {
                bufferedChannel = this;
                break;
            }
            ChannelSegment channelSegment = BufferedChannelKt.NULL_SEGMENT;
            bufferedChannel = this;
        } while (!atomicLongFieldUpdater.compareAndSet(bufferedChannel, j5, (j5 & 1152921504606846975L) + (((long) 1) << 60)));
        Symbol symbol = BufferedChannelKt.NO_CLOSE_CAUSE;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _closeCause$volatile$FU;
            if (atomicReferenceFieldUpdater.compareAndSet(this, symbol, th)) {
                z2 = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != symbol) {
                z2 = false;
                break;
            }
        }
        if (z) {
            do {
                j4 = atomicLongFieldUpdater.get(this);
            } while (!atomicLongFieldUpdater.compareAndSet(bufferedChannel, j4, (((long) 3) << 60) + (j4 & 1152921504606846975L)));
        } else {
            do {
                j = atomicLongFieldUpdater.get(this);
                int i = (int) (j >> 60);
                if (i == 0) {
                    j2 = j & 1152921504606846975L;
                    j3 = 2;
                } else {
                    if (i != 1) {
                        break;
                    }
                    j2 = j & 1152921504606846975L;
                    j3 = 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(bufferedChannel, j, (j3 << 60) + j2));
        }
        isClosedForSend();
        if (z2) {
            loop3: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = closeHandler$volatile$FU;
                obj = atomicReferenceFieldUpdater2.get(this);
                Symbol symbol2 = obj == null ? BufferedChannelKt.CLOSE_HANDLER_CLOSED : BufferedChannelKt.CLOSE_HANDLER_INVOKED;
                do {
                    if (atomicReferenceFieldUpdater2.compareAndSet(this, obj, symbol2)) {
                        break loop3;
                    }
                } while (atomicReferenceFieldUpdater2.get(this) == obj);
            }
            if (obj != null) {
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, obj);
                ((Function1) obj).invoke(getCloseCause());
                return z2;
            }
        }
        return z2;
    }

    public final ChannelSegment completeClose(long j) {
        Object objM846plusFjFbRPM;
        long j2;
        Object obj = bufferEndSegment$volatile$FU.get(this);
        ChannelSegment channelSegment = (ChannelSegment) sendSegment$volatile$FU.get(this);
        if (channelSegment.id > ((ChannelSegment) obj).id) {
            obj = channelSegment;
        }
        ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        if (channelSegment2.id > ((ChannelSegment) obj).id) {
            obj = channelSegment2;
        }
        ConcurrentLinkedListNode concurrentLinkedListNode = (ConcurrentLinkedListNode) obj;
        loop0: while (true) {
            concurrentLinkedListNode.getClass();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ConcurrentLinkedListNode._next$volatile$FU;
            Object obj2 = atomicReferenceFieldUpdater.get(concurrentLinkedListNode);
            Symbol symbol = InlineList.CLOSED;
            objM846plusFjFbRPM = null;
            if (obj2 == symbol) {
                break;
            }
            ConcurrentLinkedListNode concurrentLinkedListNode2 = (ConcurrentLinkedListNode) obj2;
            if (concurrentLinkedListNode2 == null) {
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(concurrentLinkedListNode, null, symbol)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(concurrentLinkedListNode) == null);
            } else {
                concurrentLinkedListNode = concurrentLinkedListNode2;
            }
        }
        ChannelSegment channelSegment3 = (ChannelSegment) concurrentLinkedListNode;
        if (isConflatedDropOldest()) {
            ChannelSegment channelSegment4 = channelSegment3;
            loop2: while (true) {
                int i = BufferedChannelKt.SEGMENT_SIZE - 1;
                while (true) {
                    if (-1 < i) {
                        j2 = (channelSegment4.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i);
                        if (j2 >= receivers$volatile$FU.get(this)) {
                            while (true) {
                                Object state$kotlinx_coroutines_core = channelSegment4.getState$kotlinx_coroutines_core(i);
                                if (state$kotlinx_coroutines_core != null && state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                                    if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED) {
                                        break;
                                    }
                                    break loop2;
                                }
                                if (channelSegment4.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.CHANNEL_CLOSED)) {
                                    channelSegment4.onSlotCleaned();
                                    break;
                                }
                            }
                            i--;
                        }
                    } else {
                        channelSegment4 = (ChannelSegment) ((ConcurrentLinkedListNode) ConcurrentLinkedListNode._prev$volatile$FU.get(channelSegment4));
                        if (channelSegment4 == null) {
                        }
                    }
                    j2 = -1;
                    break;
                }
            }
            if (j2 != -1) {
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(j2);
            }
        }
        loop5: for (ChannelSegment channelSegment5 = channelSegment3; channelSegment5 != null; channelSegment5 = (ChannelSegment) ((ConcurrentLinkedListNode) ConcurrentLinkedListNode._prev$volatile$FU.get(channelSegment5))) {
            for (int i2 = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < i2; i2--) {
                if ((channelSegment5.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i2) < j) {
                    break loop5;
                }
                while (true) {
                    Object state$kotlinx_coroutines_core2 = channelSegment5.getState$kotlinx_coroutines_core(i2);
                    if (state$kotlinx_coroutines_core2 != null && state$kotlinx_coroutines_core2 != BufferedChannelKt.IN_BUFFER) {
                        if (!(state$kotlinx_coroutines_core2 instanceof WaiterEB)) {
                            if (!(state$kotlinx_coroutines_core2 instanceof Waiter)) {
                                break;
                            }
                            if (channelSegment5.casState$kotlinx_coroutines_core(i2, state$kotlinx_coroutines_core2, BufferedChannelKt.CHANNEL_CLOSED)) {
                                objM846plusFjFbRPM = InlineList.m846plusFjFbRPM(objM846plusFjFbRPM, state$kotlinx_coroutines_core2);
                                channelSegment5.onCancelledRequest(i2, true);
                                break;
                            }
                        } else {
                            if (channelSegment5.casState$kotlinx_coroutines_core(i2, state$kotlinx_coroutines_core2, BufferedChannelKt.CHANNEL_CLOSED)) {
                                objM846plusFjFbRPM = InlineList.m846plusFjFbRPM(objM846plusFjFbRPM, ((WaiterEB) state$kotlinx_coroutines_core2).waiter);
                                channelSegment5.onCancelledRequest(i2, true);
                                break;
                            }
                        }
                    } else {
                        if (channelSegment5.casState$kotlinx_coroutines_core(i2, state$kotlinx_coroutines_core2, BufferedChannelKt.CHANNEL_CLOSED)) {
                            channelSegment5.onSlotCleaned();
                            break;
                        }
                    }
                }
            }
        }
        if (objM846plusFjFbRPM != null) {
            if (!(objM846plusFjFbRPM instanceof ArrayList)) {
                resumeWaiterOnClosedChannel((Waiter) objM846plusFjFbRPM, true);
                return channelSegment3;
            }
            ArrayList arrayList = (ArrayList) objM846plusFjFbRPM;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                resumeWaiterOnClosedChannel((Waiter) arrayList.get(size), true);
            }
        }
        return channelSegment3;
    }

    public final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long j) {
        ChannelSegment channelSegment = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$volatile$FU;
            long j2 = atomicLongFieldUpdater.get(this);
            if (j < Math.max(((long) this.capacity) + j2, bufferEnd$volatile$FU.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j2, 1 + j2)) {
                long j3 = BufferedChannelKt.SEGMENT_SIZE;
                long j4 = j2 / j3;
                int i = (int) (j2 % j3);
                if (channelSegment.id != j4) {
                    ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j4, channelSegment);
                    if (channelSegmentFindSegmentReceive != null) {
                        channelSegment = channelSegmentFindSegmentReceive;
                    }
                }
                ChannelSegment channelSegment2 = channelSegment;
                if (updateCellReceive(channelSegment2, i, j2, null) != BufferedChannelKt.FAILED || j2 < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment2.cleanPrev();
                }
                channelSegment = channelSegment2;
            }
        }
    }

    public final void expandBuffer() {
        Object objFindSegmentInternal;
        if (isRendezvousOrUnlimited()) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$volatile$FU;
        ChannelSegment channelSegment = (ChannelSegment) atomicReferenceFieldUpdater.get(this);
        while (true) {
            long andIncrement = bufferEnd$volatile$FU.getAndIncrement(this);
            long j = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
            if (getSendersCounter$kotlinx_coroutines_core() <= andIncrement) {
                if (channelSegment.id < j && channelSegment.getNext() != null) {
                    moveSegmentBufferEndToSpecifiedOrLast(j, channelSegment);
                }
                incCompletedExpandBufferAttempts$default(this);
                return;
            }
            if (channelSegment.id != j) {
                BufferedChannelKt$createSegmentFunction$1 bufferedChannelKt$createSegmentFunction$1 = BufferedChannelKt$createSegmentFunction$1.INSTANCE;
                while (true) {
                    objFindSegmentInternal = InlineList.findSegmentInternal(channelSegment, j, bufferedChannelKt$createSegmentFunction$1);
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
                ChannelSegment channelSegment2 = null;
                if (InlineList.m845isClosedimpl(objFindSegmentInternal)) {
                    isClosedForSend();
                    moveSegmentBufferEndToSpecifiedOrLast(j, channelSegment);
                    incCompletedExpandBufferAttempts$default(this);
                } else {
                    ChannelSegment channelSegment3 = (ChannelSegment) InlineList.m844getSegmentimpl(objFindSegmentInternal);
                    long j2 = channelSegment3.id;
                    if (j2 > j) {
                        long j3 = j2 * ((long) BufferedChannelKt.SEGMENT_SIZE);
                        if (bufferEnd$volatile$FU.compareAndSet(this, 1 + andIncrement, j3)) {
                            AtomicLongFieldUpdater atomicLongFieldUpdater = completedExpandBuffersAndPauseFlag$volatile$FU;
                            if ((atomicLongFieldUpdater.addAndGet(this, j3 - andIncrement) & 4611686018427387904L) != 0) {
                                while ((atomicLongFieldUpdater.get(this) & 4611686018427387904L) != 0) {
                                }
                            }
                        } else {
                            incCompletedExpandBufferAttempts$default(this);
                        }
                    } else {
                        channelSegment2 = channelSegment3;
                    }
                }
                if (channelSegment2 == null) {
                    continue;
                } else {
                    channelSegment = channelSegment2;
                }
            }
            int i = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            boolean z = state$kotlinx_coroutines_core instanceof Waiter;
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = receivers$volatile$FU;
            if (!z || andIncrement < atomicLongFieldUpdater2.get(this) || !channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_EB)) {
                while (true) {
                    Object state$kotlinx_coroutines_core2 = channelSegment.getState$kotlinx_coroutines_core(i);
                    if (state$kotlinx_coroutines_core2 instanceof Waiter) {
                        if (andIncrement < atomicLongFieldUpdater2.get(this)) {
                            if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, new WaiterEB((Waiter) state$kotlinx_coroutines_core2))) {
                                incCompletedExpandBufferAttempts$default(this);
                                return;
                            }
                        } else if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, BufferedChannelKt.RESUMING_BY_EB)) {
                            if (!tryResumeSender(state$kotlinx_coroutines_core2, channelSegment, i)) {
                                channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_SEND);
                                channelSegment.onSlotCleaned();
                                break;
                            } else {
                                channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.BUFFERED);
                                incCompletedExpandBufferAttempts$default(this);
                                return;
                            }
                        }
                    } else {
                        if (state$kotlinx_coroutines_core2 == BufferedChannelKt.INTERRUPTED_SEND) {
                            break;
                        }
                        if (state$kotlinx_coroutines_core2 == null) {
                            if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, BufferedChannelKt.IN_BUFFER)) {
                                incCompletedExpandBufferAttempts$default(this);
                                return;
                            }
                        } else if (state$kotlinx_coroutines_core2 == BufferedChannelKt.BUFFERED || state$kotlinx_coroutines_core2 == BufferedChannelKt.POISONED || state$kotlinx_coroutines_core2 == BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core2 == BufferedChannelKt.INTERRUPTED_RCV || state$kotlinx_coroutines_core2 == BufferedChannelKt.CHANNEL_CLOSED) {
                            incCompletedExpandBufferAttempts$default(this);
                            return;
                        } else if (state$kotlinx_coroutines_core2 != BufferedChannelKt.RESUMING_BY_RCV) {
                            throw new IllegalStateException(("Unexpected cell state: " + state$kotlinx_coroutines_core2).toString());
                        }
                    }
                }
                incCompletedExpandBufferAttempts$default(this);
            } else if (tryResumeSender(state$kotlinx_coroutines_core, channelSegment, i)) {
                channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.BUFFERED);
                incCompletedExpandBufferAttempts$default(this);
                return;
            } else {
                channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_SEND);
                channelSegment.onSlotCleaned();
                incCompletedExpandBufferAttempts$default(this);
            }
        }
    }

    public final ChannelSegment findSegmentReceive(long j, ChannelSegment channelSegment) {
        Object objFindSegmentInternal;
        long j2;
        ChannelSegment channelSegment2 = BufferedChannelKt.NULL_SEGMENT;
        BufferedChannelKt$createSegmentFunction$1 bufferedChannelKt$createSegmentFunction$1 = BufferedChannelKt$createSegmentFunction$1.INSTANCE;
        loop0: while (true) {
            objFindSegmentInternal = InlineList.findSegmentInternal(channelSegment, j, bufferedChannelKt$createSegmentFunction$1);
            if (!InlineList.m845isClosedimpl(objFindSegmentInternal)) {
                Segment segmentM844getSegmentimpl = InlineList.m844getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = receiveSegment$volatile$FU;
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
        if (InlineList.m845isClosedimpl(objFindSegmentInternal)) {
            isClosedForSend();
            if (channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE) < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
                return null;
            }
        } else {
            ChannelSegment channelSegment3 = (ChannelSegment) InlineList.m844getSegmentimpl(objFindSegmentInternal);
            long j3 = channelSegment3.id;
            if (!isRendezvousOrUnlimited() && j <= bufferEnd$volatile$FU.get(this) / ((long) BufferedChannelKt.SEGMENT_SIZE)) {
                loop3: while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = bufferEndSegment$volatile$FU;
                    Segment segment2 = (Segment) atomicReferenceFieldUpdater2.get(this);
                    if (segment2.id >= j3 || !channelSegment3.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    do {
                        if (atomicReferenceFieldUpdater2.compareAndSet(this, segment2, channelSegment3)) {
                            if (!segment2.decPointers$kotlinx_coroutines_core()) {
                                break loop3;
                            }
                            segment2.remove();
                            break loop3;
                        }
                    } while (atomicReferenceFieldUpdater2.get(this) == segment2);
                    if (channelSegment3.decPointers$kotlinx_coroutines_core()) {
                        channelSegment3.remove();
                    }
                }
            }
            if (j3 <= j) {
                return channelSegment3;
            }
            long j4 = j3 * ((long) BufferedChannelKt.SEGMENT_SIZE);
            do {
                j2 = receivers$volatile$FU.get(this);
                if (j2 >= j4) {
                    break;
                }
            } while (!receivers$volatile$FU.compareAndSet(this, j2, j4));
            if (j3 * ((long) BufferedChannelKt.SEGMENT_SIZE) < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment3.cleanPrev();
            }
        }
        return null;
    }

    public final Throwable getCloseCause() {
        return (Throwable) _closeCause$volatile$FU.get(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 getOnReceive() {
        BufferedChannel$onReceive$1 bufferedChannel$onReceive$1 = BufferedChannel$onReceive$1.INSTANCE;
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, bufferedChannel$onReceive$1);
        BufferedChannel$onReceive$2 bufferedChannel$onReceive$2 = BufferedChannel$onReceive$2.INSTANCE;
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, bufferedChannel$onReceive$2);
        return new Dispatcher(this, bufferedChannel$onReceive$1, bufferedChannel$onReceive$2, null);
    }

    public final Throwable getReceiveException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedReceiveChannelException("Channel was closed") : closeCause;
    }

    public final Throwable getSendException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedSendChannelException("Channel was closed") : closeCause;
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L;
    }

    public final boolean isClosed(long j, boolean z) {
        int i = (int) (j >> 60);
        if (i != 0 && i != 1) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$volatile$FU;
            if (i == 2) {
                completeClose(1152921504606846975L & j);
                if (z) {
                    while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = receiveSegment$volatile$FU;
                        ChannelSegment channelSegmentFindSegmentReceive = (ChannelSegment) atomicReferenceFieldUpdater.get(this);
                        long j2 = atomicLongFieldUpdater.get(this);
                        if (getSendersCounter$kotlinx_coroutines_core() <= j2) {
                            break;
                        }
                        long j3 = BufferedChannelKt.SEGMENT_SIZE;
                        long j4 = j2 / j3;
                        if (channelSegmentFindSegmentReceive.id != j4 && (channelSegmentFindSegmentReceive = findSegmentReceive(j4, channelSegmentFindSegmentReceive)) == null) {
                            if (((ChannelSegment) atomicReferenceFieldUpdater.get(this)).id < j4) {
                                break;
                            }
                        } else {
                            channelSegmentFindSegmentReceive.cleanPrev();
                            int i2 = (int) (j2 % j3);
                            while (true) {
                                Object state$kotlinx_coroutines_core = channelSegmentFindSegmentReceive.getState$kotlinx_coroutines_core(i2);
                                if (state$kotlinx_coroutines_core != null && state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                                    if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED && (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_SEND || state$kotlinx_coroutines_core == BufferedChannelKt.CHANNEL_CLOSED || state$kotlinx_coroutines_core == BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.POISONED || (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_EB && (state$kotlinx_coroutines_core == BufferedChannelKt.RESUMING_BY_RCV || j2 != atomicLongFieldUpdater.get(this))))) {
                                        break;
                                        break;
                                        break;
                                        break;
                                        break;
                                        break;
                                    }
                                } else if (channelSegmentFindSegmentReceive.casState$kotlinx_coroutines_core(i2, state$kotlinx_coroutines_core, BufferedChannelKt.POISONED)) {
                                    expandBuffer();
                                    break;
                                }
                            }
                            receivers$volatile$FU.compareAndSet(this, j2, j2 + 1);
                        }
                    }
                }
            } else {
                if (i != 3) {
                    throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m("unexpected close status: ", i).toString());
                }
                ChannelSegment channelSegmentCompleteClose = completeClose(1152921504606846975L & j);
                Object objM846plusFjFbRPM = null;
                loop0: do {
                    for (int i3 = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < i3; i3--) {
                        long j5 = (channelSegmentCompleteClose.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i3);
                        while (true) {
                            Object state$kotlinx_coroutines_core2 = channelSegmentCompleteClose.getState$kotlinx_coroutines_core(i3);
                            if (state$kotlinx_coroutines_core2 == BufferedChannelKt.DONE_RCV) {
                                break loop0;
                            }
                            if (state$kotlinx_coroutines_core2 != BufferedChannelKt.BUFFERED) {
                                if (state$kotlinx_coroutines_core2 != BufferedChannelKt.IN_BUFFER && state$kotlinx_coroutines_core2 != null) {
                                    if (!(state$kotlinx_coroutines_core2 instanceof Waiter) && !(state$kotlinx_coroutines_core2 instanceof WaiterEB)) {
                                        Symbol symbol = BufferedChannelKt.RESUMING_BY_EB;
                                        if (state$kotlinx_coroutines_core2 == symbol || state$kotlinx_coroutines_core2 == BufferedChannelKt.RESUMING_BY_RCV) {
                                            break loop0;
                                        }
                                        if (state$kotlinx_coroutines_core2 != symbol) {
                                            break;
                                        }
                                    } else {
                                        if (j5 < atomicLongFieldUpdater.get(this)) {
                                            break loop0;
                                        }
                                        Waiter waiter = state$kotlinx_coroutines_core2 instanceof WaiterEB ? ((WaiterEB) state$kotlinx_coroutines_core2).waiter : (Waiter) state$kotlinx_coroutines_core2;
                                        if (channelSegmentCompleteClose.casState$kotlinx_coroutines_core(i3, state$kotlinx_coroutines_core2, BufferedChannelKt.CHANNEL_CLOSED)) {
                                            objM846plusFjFbRPM = InlineList.m846plusFjFbRPM(objM846plusFjFbRPM, waiter);
                                            channelSegmentCompleteClose.setElementLazy(i3, null);
                                            channelSegmentCompleteClose.onSlotCleaned();
                                            break;
                                        }
                                    }
                                } else {
                                    if (channelSegmentCompleteClose.casState$kotlinx_coroutines_core(i3, state$kotlinx_coroutines_core2, BufferedChannelKt.CHANNEL_CLOSED)) {
                                        channelSegmentCompleteClose.onSlotCleaned();
                                        break;
                                    }
                                }
                            } else {
                                if (j5 < atomicLongFieldUpdater.get(this)) {
                                    break loop0;
                                }
                                if (channelSegmentCompleteClose.casState$kotlinx_coroutines_core(i3, state$kotlinx_coroutines_core2, BufferedChannelKt.CHANNEL_CLOSED)) {
                                    channelSegmentCompleteClose.setElementLazy(i3, null);
                                    channelSegmentCompleteClose.onSlotCleaned();
                                    break;
                                }
                            }
                        }
                    }
                    channelSegmentCompleteClose = (ChannelSegment) ((ConcurrentLinkedListNode) ConcurrentLinkedListNode._prev$volatile$FU.get(channelSegmentCompleteClose));
                } while (channelSegmentCompleteClose != null);
                if (objM846plusFjFbRPM != null) {
                    if (objM846plusFjFbRPM instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) objM846plusFjFbRPM;
                        for (int size = arrayList.size() - 1; -1 < size; size--) {
                            resumeWaiterOnClosedChannel((Waiter) arrayList.get(size), false);
                        }
                    } else {
                        resumeWaiterOnClosedChannel((Waiter) objM846plusFjFbRPM, false);
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final boolean isClosedForReceive() {
        return isClosed(sendersAndCloseStatus$volatile$FU.get(this), true);
    }

    public final boolean isClosedForSend() {
        return isClosed(sendersAndCloseStatus$volatile$FU.get(this), false);
    }

    public boolean isConflatedDropOldest() {
        return false;
    }

    public final boolean isRendezvousOrUnlimited() {
        long j = bufferEnd$volatile$FU.get(this);
        return j == 0 || j == Long.MAX_VALUE;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final BufferedChannelIterator iterator() {
        return new BufferedChannelIterator();
    }

    public final void moveSegmentBufferEndToSpecifiedOrLast(long j, ChannelSegment channelSegment) {
        ChannelSegment channelSegment2;
        ChannelSegment channelSegment3;
        while (channelSegment.id < j && (channelSegment3 = (ChannelSegment) channelSegment.getNext()) != null) {
            channelSegment = channelSegment3;
        }
        while (true) {
            if (!channelSegment.isRemoved() || (channelSegment2 = (ChannelSegment) channelSegment.getNext()) == null) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$volatile$FU;
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= channelSegment.id) {
                        return;
                    }
                    if (!channelSegment.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, segment, channelSegment)) {
                            if (segment.decPointers$kotlinx_coroutines_core()) {
                                segment.remove();
                                return;
                            }
                            return;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == segment);
                    if (channelSegment.decPointers$kotlinx_coroutines_core()) {
                        channelSegment.remove();
                    }
                }
            } else {
                channelSegment = channelSegment2;
            }
        }
    }

    public final Object onClosedSend(Object obj, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzga.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.resumeWith(new Result.Failure(getSendException()));
        Object result = cancellableContinuationImpl.getResult();
        return result == CoroutineSingletons.COROUTINE_SUSPENDED ? result : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receive(Continuation continuation) throws Throwable {
        ChannelSegment channelSegment;
        Throwable th;
        ChannelSegment channelSegment2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = receiveSegment$volatile$FU;
        ChannelSegment channelSegment3 = (ChannelSegment) atomicReferenceFieldUpdater.get(this);
        while (!isClosedForReceive()) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$volatile$FU;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = andIncrement / j;
            int i = (int) (andIncrement % j);
            if (channelSegment3.id != j2) {
                ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j2, channelSegment3);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment3;
            }
            Object objUpdateCellReceive = updateCellReceive(channelSegment, i, andIncrement, null);
            Symbol symbol = BufferedChannelKt.SUSPEND;
            if (objUpdateCellReceive == symbol) {
                throw new IllegalStateException("unexpected");
            }
            Symbol symbol2 = BufferedChannelKt.FAILED;
            if (objUpdateCellReceive == symbol2) {
                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                channelSegment3 = channelSegment;
            } else {
                if (objUpdateCellReceive != BufferedChannelKt.SUSPEND_NO_WAITER) {
                    channelSegment.cleanPrev();
                    return objUpdateCellReceive;
                }
                CancellableContinuationImpl orCreateCancellableContinuation = JobKt.getOrCreateCancellableContinuation(zzga.intercepted(continuation));
                BufferedChannel bufferedChannel = this;
                try {
                    Object objUpdateCellReceive2 = bufferedChannel.updateCellReceive(channelSegment, i, andIncrement, orCreateCancellableContinuation);
                    if (objUpdateCellReceive2 != symbol) {
                        if (objUpdateCellReceive2 == symbol2) {
                            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                                channelSegment.cleanPrev();
                            }
                            ChannelSegment channelSegment4 = (ChannelSegment) atomicReferenceFieldUpdater.get(this);
                            while (true) {
                                if (isClosedForReceive()) {
                                    orCreateCancellableContinuation.resumeWith(new Result.Failure(getReceiveException()));
                                    break;
                                }
                                CancellableContinuationImpl cancellableContinuationImpl = orCreateCancellableContinuation;
                                try {
                                    long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(this);
                                    long j3 = BufferedChannelKt.SEGMENT_SIZE;
                                    long j4 = andIncrement2 / j3;
                                    int i2 = (int) (andIncrement2 % j3);
                                    if (channelSegment4.id != j4) {
                                        try {
                                            ChannelSegment channelSegmentFindSegmentReceive2 = findSegmentReceive(j4, channelSegment4);
                                            if (channelSegmentFindSegmentReceive2 == null) {
                                                orCreateCancellableContinuation = cancellableContinuationImpl;
                                            } else {
                                                channelSegment2 = channelSegmentFindSegmentReceive2;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            orCreateCancellableContinuation = cancellableContinuationImpl;
                                            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                                            throw th;
                                        }
                                    } else {
                                        channelSegment2 = channelSegment4;
                                    }
                                    objUpdateCellReceive2 = bufferedChannel.updateCellReceive(channelSegment2, i2, andIncrement2, cancellableContinuationImpl);
                                    ChannelSegment channelSegment5 = channelSegment2;
                                    orCreateCancellableContinuation = cancellableContinuationImpl;
                                    if (objUpdateCellReceive2 == BufferedChannelKt.SUSPEND) {
                                        orCreateCancellableContinuation.invokeOnCancellation(channelSegment5, i2);
                                        break;
                                    }
                                    if (objUpdateCellReceive2 == BufferedChannelKt.FAILED) {
                                        if (andIncrement2 < getSendersCounter$kotlinx_coroutines_core()) {
                                            channelSegment5.cleanPrev();
                                        }
                                        bufferedChannel = this;
                                        channelSegment4 = channelSegment5;
                                    } else {
                                        if (objUpdateCellReceive2 == BufferedChannelKt.SUSPEND_NO_WAITER) {
                                            throw new IllegalStateException("unexpected");
                                        }
                                        channelSegment5.cleanPrev();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    orCreateCancellableContinuation = cancellableContinuationImpl;
                                    th = th;
                                    orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                                    throw th;
                                }
                            }
                        } else {
                            channelSegment.cleanPrev();
                        }
                        orCreateCancellableContinuation.resume(objUpdateCellReceive2, null);
                        break;
                    }
                    orCreateCancellableContinuation.invokeOnCancellation(channelSegment, i);
                    return orCreateCancellableContinuation.getResult();
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
        Throwable receiveException = getReceiveException();
        int i3 = StackTraceRecoveryKt.$r8$clinit;
        throw receiveException;
    }

    public final void resumeWaiterOnClosedChannel(Waiter waiter, boolean z) {
        if (waiter instanceof CancellableContinuation) {
            ((Continuation) waiter).resumeWith(new Result.Failure(z ? getReceiveException() : getSendException()));
            return;
        }
        if (!(waiter instanceof BufferedChannelIterator)) {
            if (waiter instanceof SelectInstance) {
                ((SelectImplementation) ((SelectInstance) waiter)).trySelectInternal(this, BufferedChannelKt.CHANNEL_CLOSED);
                return;
            } else {
                throw new IllegalStateException(("Unexpected waiter: " + waiter).toString());
            }
        }
        BufferedChannelIterator bufferedChannelIterator = (BufferedChannelIterator) waiter;
        CancellableContinuationImpl cancellableContinuationImpl = bufferedChannelIterator.continuation;
        bufferedChannelIterator.continuation = null;
        bufferedChannelIterator.receiveResult = BufferedChannelKt.CHANNEL_CLOSED;
        Throwable closeCause = BufferedChannel.this.getCloseCause();
        if (closeCause == null) {
            cancellableContinuationImpl.resumeWith(Boolean.FALSE);
        } else {
            cancellableContinuationImpl.resumeWith(new Result.Failure(closeCause));
        }
    }

    /* JADX WARN: Code duplicated, block: B:93:0x016b  */
    /* JADX WARN: Code duplicated, block: B:95:0x016f A[RETURN] */
    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(Object obj, Continuation continuation) throws Throwable {
        Unit unit;
        Object result;
        Object obj2;
        BufferedChannel bufferedChannel;
        ChannelSegment channelSegment;
        boolean z;
        BufferedChannel bufferedChannel2 = this;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = sendSegment$volatile$FU;
        ChannelSegment channelSegment2 = (ChannelSegment) atomicReferenceFieldUpdater.get(bufferedChannel2);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(bufferedChannel2);
            long j = andIncrement & 1152921504606846975L;
            boolean zIsClosed = bufferedChannel2.isClosed(andIncrement, false);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = i;
            long j3 = j / j2;
            int i2 = (int) (j % j2);
            long j4 = channelSegment2.id;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (j4 != j3) {
                ChannelSegment channelSegmentAccess$findSegmentSend = access$findSegmentSend(bufferedChannel2, j3, channelSegment2);
                if (channelSegmentAccess$findSegmentSend != null) {
                    channelSegment2 = channelSegmentAccess$findSegmentSend;
                } else if (zIsClosed) {
                    Object objOnClosedSend = onClosedSend(obj, continuation);
                    if (objOnClosedSend != coroutineSingletons) {
                        break;
                    }
                    return objOnClosedSend;
                }
            }
            int iAccess$updateCellSend = access$updateCellSend(bufferedChannel2, channelSegment2, i2, obj, j, null, zIsClosed);
            if (iAccess$updateCellSend == 0) {
                channelSegment2.cleanPrev();
            } else {
                if (iAccess$updateCellSend == 1) {
                    break;
                }
                if (iAccess$updateCellSend != 2) {
                    AtomicLongFieldUpdater atomicLongFieldUpdater2 = receivers$volatile$FU;
                    if (iAccess$updateCellSend == 3) {
                        CancellableContinuationImpl orCreateCancellableContinuation = JobKt.getOrCreateCancellableContinuation(zzga.intercepted(continuation));
                        Object obj3 = obj;
                        try {
                            int iAccess$updateCellSend2 = access$updateCellSend(bufferedChannel2, channelSegment2, i2, obj3, j, orCreateCancellableContinuation, false);
                            try {
                                if (iAccess$updateCellSend2 != 0) {
                                    if (iAccess$updateCellSend2 == 1) {
                                        unit = Unit.INSTANCE;
                                        orCreateCancellableContinuation.resumeWith(unit);
                                    } else if (iAccess$updateCellSend2 != 2) {
                                        if (iAccess$updateCellSend2 != 4) {
                                            String str = "unexpected";
                                            if (iAccess$updateCellSend2 != 5) {
                                                throw new IllegalStateException("unexpected");
                                            }
                                            channelSegment2.cleanPrev();
                                            ChannelSegment channelSegment3 = (ChannelSegment) atomicReferenceFieldUpdater.get(bufferedChannel2);
                                            while (true) {
                                                long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(bufferedChannel2);
                                                long j5 = andIncrement2 & 1152921504606846975L;
                                                boolean zIsClosed2 = bufferedChannel2.isClosed(andIncrement2, false);
                                                int i3 = BufferedChannelKt.SEGMENT_SIZE;
                                                atomicLongFieldUpdater = atomicLongFieldUpdater;
                                                long j6 = i3;
                                                str = str;
                                                long j7 = j5 / j6;
                                                int i4 = (int) (j5 % j6);
                                                atomicLongFieldUpdater2 = atomicLongFieldUpdater2;
                                                if (channelSegment3.id != j7) {
                                                    ChannelSegment channelSegmentAccess$findSegmentSend2 = access$findSegmentSend(bufferedChannel2, j7, channelSegment3);
                                                    if (channelSegmentAccess$findSegmentSend2 != null) {
                                                        z = zIsClosed2;
                                                        channelSegment = channelSegmentAccess$findSegmentSend2;
                                                    } else if (zIsClosed2) {
                                                        access$onClosedSendOnNoWaiterSuspend(bufferedChannel2, obj3, orCreateCancellableContinuation);
                                                    }
                                                } else {
                                                    channelSegment = channelSegment3;
                                                    z = zIsClosed2;
                                                }
                                                int iAccess$updateCellSend3 = access$updateCellSend(bufferedChannel2, channelSegment, i4, obj3, j5, orCreateCancellableContinuation, z);
                                                Object obj4 = obj3;
                                                bufferedChannel = bufferedChannel2;
                                                ChannelSegment channelSegment4 = channelSegment;
                                                obj2 = obj4;
                                                if (iAccess$updateCellSend3 == 0) {
                                                    channelSegment4.cleanPrev();
                                                } else if (iAccess$updateCellSend3 != 1) {
                                                    if (iAccess$updateCellSend3 != 2) {
                                                        if (iAccess$updateCellSend3 == 3) {
                                                            throw new IllegalStateException(str);
                                                        }
                                                        if (iAccess$updateCellSend3 != 4) {
                                                            if (iAccess$updateCellSend3 == 5) {
                                                                channelSegment4.cleanPrev();
                                                            }
                                                            channelSegment3 = channelSegment4;
                                                            bufferedChannel2 = bufferedChannel;
                                                            obj3 = obj2;
                                                        } else if (j5 < atomicLongFieldUpdater2.get(bufferedChannel)) {
                                                            channelSegment4.cleanPrev();
                                                        }
                                                    } else if (z) {
                                                        channelSegment4.onSlotCleaned();
                                                    } else {
                                                        orCreateCancellableContinuation.invokeOnCancellation(channelSegment4, i4 + i3);
                                                    }
                                                }
                                            }
                                            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                                            throw th;
                                        }
                                        obj2 = obj3;
                                        bufferedChannel = bufferedChannel2;
                                        if (j < atomicLongFieldUpdater2.get(bufferedChannel)) {
                                            channelSegment2.cleanPrev();
                                        }
                                        access$onClosedSendOnNoWaiterSuspend(bufferedChannel, obj2, orCreateCancellableContinuation);
                                    } else {
                                        orCreateCancellableContinuation.invokeOnCancellation(channelSegment2, i2 + i);
                                    }
                                    result = orCreateCancellableContinuation.getResult();
                                    if (result != coroutineSingletons) {
                                        result = Unit.INSTANCE;
                                    }
                                    if (result == coroutineSingletons) {
                                        return result;
                                    }
                                } else {
                                    channelSegment2.cleanPrev();
                                }
                                unit = Unit.INSTANCE;
                                orCreateCancellableContinuation.resumeWith(unit);
                                result = orCreateCancellableContinuation.getResult();
                                if (result != coroutineSingletons) {
                                    result = Unit.INSTANCE;
                                }
                                if (result == coroutineSingletons) {
                                    return result;
                                }
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        if (iAccess$updateCellSend == 4) {
                            if (j < atomicLongFieldUpdater2.get(bufferedChannel2)) {
                                channelSegment2.cleanPrev();
                            }
                            Object objOnClosedSend2 = onClosedSend(obj, continuation);
                            if (objOnClosedSend2 != coroutineSingletons) {
                                break;
                            }
                            return objOnClosedSend2;
                        }
                        if (iAccess$updateCellSend == 5) {
                            channelSegment2.cleanPrev();
                        }
                    }
                } else if (zIsClosed) {
                    channelSegment2.onSlotCleaned();
                    Object objOnClosedSend3 = onClosedSend(obj, continuation);
                    if (objOnClosedSend3 == coroutineSingletons) {
                        return objOnClosedSend3;
                    }
                }
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        String string;
        StringBuilder sb = new StringBuilder();
        int i = (int) (sendersAndCloseStatus$volatile$FU.get(this) >> 60);
        if (i == 2) {
            sb.append("closed,");
        } else if (i == 3) {
            sb.append("cancelled,");
        }
        sb.append("capacity=" + this.capacity + ',');
        sb.append("data=[");
        int i2 = 0;
        boolean z = true;
        List listListOf = AppCompatHintHelper.listOf(receiveSegment$volatile$FU.get(this), sendSegment$volatile$FU.get(this), bufferEndSegment$volatile$FU.get(this));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (((ChannelSegment) obj) != BufferedChannelKt.NULL_SEGMENT) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j = ((ChannelSegment) next).id;
            do {
                Object next2 = it.next();
                long j2 = ((ChannelSegment) next2).id;
                if (j > j2) {
                    next = next2;
                    j = j2;
                }
            } while (it.hasNext());
        }
        ChannelSegment channelSegment = (ChannelSegment) next;
        long j3 = receivers$volatile$FU.get(this);
        long sendersCounter$kotlinx_coroutines_core = getSendersCounter$kotlinx_coroutines_core();
        loop2: while (true) {
            int i3 = BufferedChannelKt.SEGMENT_SIZE;
            int i4 = i2;
            while (i4 < i3) {
                long j4 = (channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i4);
                if (j4 >= sendersCounter$kotlinx_coroutines_core && j4 >= j3) {
                    break loop2;
                }
                Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i4);
                boolean z2 = z;
                Object obj2 = channelSegment.data.get(i4 * 2);
                if (state$kotlinx_coroutines_core instanceof CancellableContinuation) {
                    string = (j4 >= j3 || j4 < sendersCounter$kotlinx_coroutines_core) ? (j4 >= sendersCounter$kotlinx_coroutines_core || j4 < j3) ? "cont" : "send" : "receive";
                } else if (state$kotlinx_coroutines_core instanceof SelectInstance) {
                    string = (j4 >= j3 || j4 < sendersCounter$kotlinx_coroutines_core) ? (j4 >= sendersCounter$kotlinx_coroutines_core || j4 < j3) ? "select" : "onSend" : "onReceive";
                } else if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                    string = "EB(" + state$kotlinx_coroutines_core + ')';
                } else if (Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_RCV) || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_EB)) {
                    string = "resuming_sender";
                } else {
                    if (state$kotlinx_coroutines_core != null && !state$kotlinx_coroutines_core.equals(BufferedChannelKt.IN_BUFFER) && !state$kotlinx_coroutines_core.equals(BufferedChannelKt.DONE_RCV) && !state$kotlinx_coroutines_core.equals(BufferedChannelKt.POISONED) && !state$kotlinx_coroutines_core.equals(BufferedChannelKt.INTERRUPTED_RCV) && !state$kotlinx_coroutines_core.equals(BufferedChannelKt.INTERRUPTED_SEND) && !state$kotlinx_coroutines_core.equals(BufferedChannelKt.CHANNEL_CLOSED)) {
                        string = state$kotlinx_coroutines_core.toString();
                    }
                    i4++;
                    z = z2;
                }
                if (obj2 != null) {
                    sb.append("(" + string + ',' + obj2 + "),");
                } else {
                    sb.append(string + ',');
                }
                i4++;
                z = z2;
            }
            boolean z3 = z;
            channelSegment = (ChannelSegment) channelSegment.getNext();
            if (channelSegment == null) {
                break;
            }
            z = z3;
            i2 = 0;
        }
        if (StringsKt.last(sb) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public final Object mo841tryReceivePtdJZtk() {
        ChannelSegment channelSegment;
        AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$volatile$FU;
        long j = atomicLongFieldUpdater.get(this);
        long j2 = sendersAndCloseStatus$volatile$FU.get(this);
        if (isClosed(j2, true)) {
            return new ChannelResult.Closed(getCloseCause());
        }
        long j3 = j2 & 1152921504606846975L;
        ChannelResult.Failed failed = ChannelResult.failed;
        if (j >= j3) {
            return failed;
        }
        Object obj = BufferedChannelKt.INTERRUPTED_RCV;
        ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        while (!isClosedForReceive()) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j4 = BufferedChannelKt.SEGMENT_SIZE;
            long j5 = andIncrement / j4;
            int i = (int) (andIncrement % j4);
            if (channelSegment2.id != j5) {
                ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j5, channelSegment2);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            Object objUpdateCellReceive = updateCellReceive(channelSegment, i, andIncrement, obj);
            ChannelSegment channelSegment3 = channelSegment;
            if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                Waiter waiter = obj instanceof Waiter ? (Waiter) obj : null;
                if (waiter != null) {
                    waiter.invokeOnCancellation(channelSegment3, i);
                }
                waitExpandBufferCompletion$kotlinx_coroutines_core(andIncrement);
                channelSegment3.onSlotCleaned();
                return failed;
            }
            if (objUpdateCellReceive != BufferedChannelKt.FAILED) {
                if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    throw new IllegalStateException("unexpected");
                }
                channelSegment3.cleanPrev();
                return objUpdateCellReceive;
            }
            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment3.cleanPrev();
            }
            channelSegment2 = channelSegment3;
        }
        return new ChannelResult.Closed(getCloseCause());
    }

    public final boolean tryResumeReceiver(Object obj, Object obj2) {
        if (obj instanceof SelectInstance) {
            return ((SelectImplementation) ((SelectInstance) obj)).trySelectInternal(this, obj2) == 0;
        }
        if (!(obj instanceof BufferedChannelIterator)) {
            if (!(obj instanceof CancellableContinuation)) {
                throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
            }
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            ChannelSegment channelSegment = BufferedChannelKt.NULL_SEGMENT;
            Symbol symbolTryResume = cancellableContinuation.tryResume(obj2, null);
            if (symbolTryResume == null) {
                return false;
            }
            cancellableContinuation.completeResume(symbolTryResume);
            return true;
        }
        BufferedChannelIterator bufferedChannelIterator = (BufferedChannelIterator) obj;
        CancellableContinuationImpl cancellableContinuationImpl = bufferedChannelIterator.continuation;
        bufferedChannelIterator.continuation = null;
        bufferedChannelIterator.receiveResult = obj2;
        Boolean bool = Boolean.TRUE;
        BufferedChannel.this.getClass();
        ChannelSegment channelSegment2 = BufferedChannelKt.NULL_SEGMENT;
        Symbol symbolTryResume2 = cancellableContinuationImpl.tryResume(bool, null);
        if (symbolTryResume2 == null) {
            return false;
        }
        cancellableContinuationImpl.completeResume(symbolTryResume2);
        return true;
    }

    public final boolean tryResumeSender(Object obj, ChannelSegment channelSegment, int i) {
        char c;
        if (obj instanceof CancellableContinuation) {
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            Unit unit = Unit.INSTANCE;
            ChannelSegment channelSegment2 = BufferedChannelKt.NULL_SEGMENT;
            Symbol symbolTryResume = cancellableContinuation.tryResume(unit, null);
            if (symbolTryResume == null) {
                return false;
            }
            cancellableContinuation.completeResume(symbolTryResume);
            return true;
        }
        if (!(obj instanceof SelectInstance)) {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
        int iTrySelectInternal = ((SelectImplementation) obj).trySelectInternal(this, Unit.INSTANCE);
        if (iTrySelectInternal == 0) {
            c = 1;
        } else if (iTrySelectInternal != 1) {
            c = 3;
            if (iTrySelectInternal != 2) {
                if (iTrySelectInternal != 3) {
                    throw new IllegalStateException(("Unexpected internal result: " + iTrySelectInternal).toString());
                }
                c = 4;
            }
        } else {
            c = 2;
        }
        if (c == 2) {
            channelSegment.setElementLazy(i, null);
        }
        return c == 1;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0066  */
    /* JADX WARN: Code duplicated, block: B:24:0x0069  */
    /* JADX WARN: Code duplicated, block: B:26:0x006c  */
    /* JADX WARN: Code duplicated, block: B:28:0x006f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0072  */
    /* JADX WARN: Code duplicated, block: B:33:0x0076  */
    /* JADX WARN: Code duplicated, block: B:37:0x0086  */
    /* JADX WARN: Code duplicated, block: B:43:0x009d  */
    /* JADX WARN: Code duplicated, block: B:45:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:58:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x009b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0093 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x007c A[SYNTHETIC] */
    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU, reason: not valid java name */
    public Object mo842trySendJP2dKIU(Object obj) {
        int iAccess$updateCellSend;
        Waiter waiter;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        long j = atomicLongFieldUpdater.get(this);
        boolean z = false;
        long j2 = 1152921504606846975L;
        boolean z2 = isClosed(j, false) ? false : !bufferOrRendezvousSend(j & 1152921504606846975L);
        ChannelResult.Failed failed = ChannelResult.failed;
        if (z2) {
            return failed;
        }
        SupportSQLiteQuery supportSQLiteQuery = BufferedChannelKt.INTERRUPTED_SEND;
        ChannelSegment channelSegment = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j3 = andIncrement & j2;
            boolean zIsClosed = isClosed(andIncrement, z);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j4 = i;
            long j5 = j3 / j4;
            int i2 = (int) (j3 % j4);
            if (channelSegment.id == j5) {
                iAccess$updateCellSend = access$updateCellSend(this, channelSegment, i2, obj, j3, supportSQLiteQuery, zIsClosed);
                if (iAccess$updateCellSend != 0) {
                    channelSegment.cleanPrev();
                    return Unit.INSTANCE;
                }
                if (iAccess$updateCellSend != 1) {
                    return Unit.INSTANCE;
                }
                if (iAccess$updateCellSend != 2) {
                    if (zIsClosed) {
                        channelSegment.onSlotCleaned();
                        return new ChannelResult.Closed(getSendException());
                    }
                    if (supportSQLiteQuery instanceof Waiter) {
                        waiter = (Waiter) supportSQLiteQuery;
                    } else {
                        waiter = null;
                    }
                    if (waiter != null) {
                        waiter.invokeOnCancellation(channelSegment, i2 + i);
                    }
                    channelSegment.onSlotCleaned();
                    return failed;
                }
                if (iAccess$updateCellSend != 3) {
                    throw new IllegalStateException("unexpected");
                }
                if (iAccess$updateCellSend != 4) {
                    if (j3 < receivers$volatile$FU.get(this)) {
                        channelSegment.cleanPrev();
                    }
                    return new ChannelResult.Closed(getSendException());
                }
                if (iAccess$updateCellSend == 5) {
                    channelSegment.cleanPrev();
                }
                z = false;
            } else {
                ChannelSegment channelSegmentAccess$findSegmentSend = access$findSegmentSend(this, j5, channelSegment);
                if (channelSegmentAccess$findSegmentSend != null) {
                    channelSegment = channelSegmentAccess$findSegmentSend;
                    iAccess$updateCellSend = access$updateCellSend(this, channelSegment, i2, obj, j3, supportSQLiteQuery, zIsClosed);
                    if (iAccess$updateCellSend != 0) {
                        channelSegment.cleanPrev();
                        return Unit.INSTANCE;
                    }
                    if (iAccess$updateCellSend != 1) {
                        return Unit.INSTANCE;
                    }
                    if (iAccess$updateCellSend != 2) {
                        if (zIsClosed) {
                            channelSegment.onSlotCleaned();
                            return new ChannelResult.Closed(getSendException());
                        }
                        if (supportSQLiteQuery instanceof Waiter) {
                            waiter = (Waiter) supportSQLiteQuery;
                        } else {
                            waiter = null;
                        }
                        if (waiter != null) {
                            waiter.invokeOnCancellation(channelSegment, i2 + i);
                        }
                        channelSegment.onSlotCleaned();
                        return failed;
                    }
                    if (iAccess$updateCellSend != 3) {
                        throw new IllegalStateException("unexpected");
                    }
                    if (iAccess$updateCellSend != 4) {
                        if (j3 < receivers$volatile$FU.get(this)) {
                            channelSegment.cleanPrev();
                        }
                        return new ChannelResult.Closed(getSendException());
                    }
                    if (iAccess$updateCellSend == 5) {
                        channelSegment.cleanPrev();
                    }
                    z = false;
                } else {
                    if (zIsClosed) {
                        return new ChannelResult.Closed(getSendException());
                    }
                    z = false;
                }
            }
            j2 = 1152921504606846975L;
        }
    }

    public final Object updateCellReceive(ChannelSegment channelSegment, int i, long j, Object obj) {
        AtomicReferenceArray atomicReferenceArray = channelSegment.data;
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        if (state$kotlinx_coroutines_core == null) {
            if (j >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return BufferedChannelKt.SUSPEND_NO_WAITER;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, obj)) {
                    expandBuffer();
                    return BufferedChannelKt.SUSPEND;
                }
            }
        } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED && channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.DONE_RCV)) {
            expandBuffer();
            Object obj2 = atomicReferenceArray.get(i * 2);
            channelSegment.setElementLazy(i, null);
            return obj2;
        }
        while (true) {
            Object state$kotlinx_coroutines_core2 = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core2 == null || state$kotlinx_coroutines_core2 == BufferedChannelKt.IN_BUFFER) {
                if (j < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, BufferedChannelKt.POISONED)) {
                        expandBuffer();
                        return BufferedChannelKt.FAILED;
                    }
                } else {
                    if (obj == null) {
                        return BufferedChannelKt.SUSPEND_NO_WAITER;
                    }
                    if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, obj)) {
                        expandBuffer();
                        return BufferedChannelKt.SUSPEND;
                    }
                }
            } else if (state$kotlinx_coroutines_core2 != BufferedChannelKt.BUFFERED) {
                Symbol symbol = BufferedChannelKt.INTERRUPTED_SEND;
                if (state$kotlinx_coroutines_core2 == symbol) {
                    return BufferedChannelKt.FAILED;
                }
                if (state$kotlinx_coroutines_core2 == BufferedChannelKt.POISONED) {
                    return BufferedChannelKt.FAILED;
                }
                if (state$kotlinx_coroutines_core2 == BufferedChannelKt.CHANNEL_CLOSED) {
                    expandBuffer();
                    return BufferedChannelKt.FAILED;
                }
                if (state$kotlinx_coroutines_core2 != BufferedChannelKt.RESUMING_BY_EB && channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, BufferedChannelKt.RESUMING_BY_RCV)) {
                    boolean z = state$kotlinx_coroutines_core2 instanceof WaiterEB;
                    if (z) {
                        state$kotlinx_coroutines_core2 = ((WaiterEB) state$kotlinx_coroutines_core2).waiter;
                    }
                    if (tryResumeSender(state$kotlinx_coroutines_core2, channelSegment, i)) {
                        channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.DONE_RCV);
                        expandBuffer();
                        Object obj3 = atomicReferenceArray.get(i * 2);
                        channelSegment.setElementLazy(i, null);
                        return obj3;
                    }
                    channelSegment.setState$kotlinx_coroutines_core(i, symbol);
                    channelSegment.onSlotCleaned();
                    if (z) {
                        expandBuffer();
                    }
                    return BufferedChannelKt.FAILED;
                }
            } else if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, BufferedChannelKt.DONE_RCV)) {
                expandBuffer();
                Object obj4 = atomicReferenceArray.get(i * 2);
                channelSegment.setElementLazy(i, null);
                return obj4;
            }
        }
    }

    public final int updateCellSendSlow(ChannelSegment channelSegment, int i, Object obj, long j, Object obj2, boolean z) {
        while (true) {
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core == null) {
                if (!bufferOrRendezvousSend(j) || z) {
                    if (z) {
                        if (channelSegment.casState$kotlinx_coroutines_core(i, null, BufferedChannelKt.INTERRUPTED_SEND)) {
                            channelSegment.onSlotCleaned();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (channelSegment.casState$kotlinx_coroutines_core(i, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (channelSegment.casState$kotlinx_coroutines_core(i, null, BufferedChannelKt.BUFFERED)) {
                    break;
                }
            } else {
                if (state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                    Symbol symbol = BufferedChannelKt.INTERRUPTED_RCV;
                    if (state$kotlinx_coroutines_core == symbol) {
                        channelSegment.setElementLazy(i, null);
                        return 5;
                    }
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.POISONED) {
                        channelSegment.setElementLazy(i, null);
                        return 5;
                    }
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.CHANNEL_CLOSED) {
                        channelSegment.setElementLazy(i, null);
                        isClosedForSend();
                        return 4;
                    }
                    channelSegment.setElementLazy(i, null);
                    if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                        state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                    }
                    if (tryResumeReceiver(state$kotlinx_coroutines_core, obj)) {
                        channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.DONE_RCV);
                        return 0;
                    }
                    if (channelSegment.data.getAndSet((i * 2) + 1, symbol) != symbol) {
                        channelSegment.onCancelledRequest(i, true);
                    }
                    return 5;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.BUFFERED)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long j) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        BufferedChannel bufferedChannel = this;
        if (bufferedChannel.isRendezvousOrUnlimited()) {
            return;
        }
        while (true) {
            atomicLongFieldUpdater = bufferEnd$volatile$FU;
            if (atomicLongFieldUpdater.get(bufferedChannel) > j) {
                break;
            } else {
                bufferedChannel = this;
            }
        }
        int i = BufferedChannelKt.EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS;
        int i2 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = completedExpandBuffersAndPauseFlag$volatile$FU;
            if (i2 < i) {
                long j2 = atomicLongFieldUpdater.get(bufferedChannel);
                if (j2 == (4611686018427387903L & atomicLongFieldUpdater2.get(bufferedChannel)) && j2 == atomicLongFieldUpdater.get(bufferedChannel)) {
                    return;
                } else {
                    i2++;
                }
            } else {
                while (true) {
                    long j3 = atomicLongFieldUpdater2.get(bufferedChannel);
                    if (atomicLongFieldUpdater2.compareAndSet(bufferedChannel, j3, (j3 & 4611686018427387903L) + 4611686018427387904L)) {
                        break;
                    } else {
                        bufferedChannel = this;
                    }
                }
                while (true) {
                    long j4 = atomicLongFieldUpdater.get(bufferedChannel);
                    long j5 = atomicLongFieldUpdater2.get(bufferedChannel);
                    long j6 = j5 & 4611686018427387903L;
                    boolean z = (j5 & 4611686018427387904L) != 0;
                    if (j4 == j6 && j4 == atomicLongFieldUpdater.get(bufferedChannel)) {
                        break;
                    }
                    if (z) {
                        bufferedChannel = this;
                    } else {
                        bufferedChannel = this;
                        atomicLongFieldUpdater2.compareAndSet(bufferedChannel, j5, 4611686018427387904L + j6);
                    }
                }
                while (true) {
                    long j7 = atomicLongFieldUpdater2.get(bufferedChannel);
                    if (atomicLongFieldUpdater2.compareAndSet(bufferedChannel, j7, j7 & 4611686018427387903L)) {
                        return;
                    } else {
                        bufferedChannel = this;
                    }
                }
            }
        }
    }
}
