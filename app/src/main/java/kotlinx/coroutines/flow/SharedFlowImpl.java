package kotlinx.coroutines.flow;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import coil.network.HttpException;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.DisposeOnCancel;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class SharedFlowImpl extends AbstractSharedFlow implements MutableSharedFlow, Flow, FusibleFlow {
    public Object[] buffer;
    public final int bufferCapacity;
    public int bufferSize;
    public long minCollectorIndex;
    public final int onBufferOverflow;
    public int queueSize;
    public final int replay;
    public long replayIndex;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Emitter implements DisposableHandle {
        public final CancellableContinuationImpl cont;
        public final SharedFlowImpl flow;
        public final long index;
        public final Object value;

        public Emitter(SharedFlowImpl sharedFlowImpl, long j, Object obj, CancellableContinuationImpl cancellableContinuationImpl) {
            this.flow = sharedFlowImpl;
            this.index = j;
            this.value = obj;
            this.cont = cancellableContinuationImpl;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            SharedFlowImpl sharedFlowImpl = this.flow;
            synchronized (sharedFlowImpl) {
                if (this.index < sharedFlowImpl.getHead()) {
                    return;
                }
                Object[] objArr = sharedFlowImpl.buffer;
                long j = this.index;
                if (objArr[((int) j) & (objArr.length - 1)] != this) {
                    return;
                }
                FlowKt.access$setBufferAt(objArr, j, FlowKt.NO_VALUE);
                sharedFlowImpl.cleanupTailLocked();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.SharedFlowImpl$collect$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public SharedFlowImpl L$0;
        public FlowCollector L$1;
        public SharedFlowSlot L$2;
        public Job L$3;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            SharedFlowImpl.collect$suspendImpl(SharedFlowImpl.this, null, this);
            return CoroutineSingletons.COROUTINE_SUSPENDED;
        }
    }

    public SharedFlowImpl(int i, int i2, int i3) {
        this.replay = i;
        this.bufferCapacity = i2;
        this.onBufferOverflow = i3;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x007f A[Catch: all -> 0x0036, TRY_ENTER, TryCatch #0 {all -> 0x0036, blocks: (B:15:0x002f, B:32:0x0075, B:35:0x007f, B:39:0x0092, B:42:0x0099, B:43:0x009d, B:44:0x009e, B:22:0x0049), top: B:51:0x001e }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0092 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:15:0x002f, B:32:0x0075, B:35:0x007f, B:39:0x0092, B:42:0x0099, B:43:0x009d, B:44:0x009e, B:22:0x0049), top: B:51:0x001e }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v4, types: [kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r4v1, types: [kotlinx.coroutines.flow.internal.AbstractSharedFlow] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4, types: [kotlinx.coroutines.flow.SharedFlowImpl] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r9v0, types: [kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v2, types: [kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [kotlinx.coroutines.flow.SharedFlowSlot] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [kotlinx.coroutines.flow.SharedFlowSlot] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00ac -> B:16:0x0032). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:35:0x007f
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static void collect$suspendImpl(kotlinx.coroutines.flow.SharedFlowImpl r8, kotlinx.coroutines.flow.FlowCollector r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.SharedFlowImpl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = (kotlinx.coroutines.flow.SharedFlowImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = new kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            int r1 = r0.label
            r2 = 3
            r3 = 2
            if (r1 == 0) goto L5c
            r8 = 1
            if (r1 == r8) goto L4d
            if (r1 == r3) goto L41
            if (r1 != r2) goto L39
            kotlinx.coroutines.Job r8 = r0.L$3
            kotlinx.coroutines.flow.SharedFlowSlot r9 = r0.L$2
            kotlinx.coroutines.flow.FlowCollector r1 = r0.L$1
            kotlinx.coroutines.flow.SharedFlowImpl r4 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L36
        L32:
            r10 = r1
            r1 = r8
            r8 = r4
            goto L72
        L36:
            r8 = move-exception
            goto Lb2
        L39:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L41:
            kotlinx.coroutines.Job r8 = r0.L$3
            kotlinx.coroutines.flow.SharedFlowSlot r9 = r0.L$2
            kotlinx.coroutines.flow.FlowCollector r1 = r0.L$1
            kotlinx.coroutines.flow.SharedFlowImpl r4 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L36
            goto L75
        L4d:
            kotlinx.coroutines.flow.SharedFlowSlot r9 = r0.L$2
            kotlinx.coroutines.flow.FlowCollector r8 = r0.L$1
            kotlinx.coroutines.flow.SharedFlowImpl r1 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L59
            r10 = r8
            r8 = r1
            goto L68
        L59:
            r8 = move-exception
            r4 = r1
            goto Lb2
        L5c:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot r10 = r8.allocateSlot()
            kotlinx.coroutines.flow.SharedFlowSlot r10 = (kotlinx.coroutines.flow.SharedFlowSlot) r10
            r7 = r10
            r10 = r9
            r9 = r7
        L68:
            kotlin.coroutines.CoroutineContext r1 = r0._context     // Catch: java.lang.Throwable -> Laf
            kotlinx.coroutines.Job$Key r4 = kotlinx.coroutines.Job.Key.$$INSTANCE     // Catch: java.lang.Throwable -> Laf
            kotlin.coroutines.CoroutineContext$Element r1 = r1.get(r4)     // Catch: java.lang.Throwable -> Laf
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1     // Catch: java.lang.Throwable -> Laf
        L72:
            r4 = r8
            r8 = r1
            r1 = r10
        L75:
            java.lang.Object r10 = r4.tryTakeValue(r9)     // Catch: java.lang.Throwable -> L36
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.flow.FlowKt.NO_VALUE     // Catch: java.lang.Throwable -> L36
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r10 != r5) goto L90
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L36
            r0.L$1 = r1     // Catch: java.lang.Throwable -> L36
            r0.L$2 = r9     // Catch: java.lang.Throwable -> L36
            r0.L$3 = r8     // Catch: java.lang.Throwable -> L36
            r0.label = r3     // Catch: java.lang.Throwable -> L36
            java.lang.Object r10 = r4.awaitValue(r9, r0)     // Catch: java.lang.Throwable -> L36
            if (r10 != r6) goto L75
            goto Lae
        L90:
            if (r8 == 0) goto L9e
            boolean r5 = r8.isActive()     // Catch: java.lang.Throwable -> L36
            if (r5 == 0) goto L99
            goto L9e
        L99:
            java.util.concurrent.CancellationException r8 = r8.getCancellationException()     // Catch: java.lang.Throwable -> L36
            throw r8     // Catch: java.lang.Throwable -> L36
        L9e:
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L36
            r0.L$1 = r1     // Catch: java.lang.Throwable -> L36
            r0.L$2 = r9     // Catch: java.lang.Throwable -> L36
            r0.L$3 = r8     // Catch: java.lang.Throwable -> L36
            r0.label = r2     // Catch: java.lang.Throwable -> L36
            java.lang.Object r10 = r1.emit(r10, r0)     // Catch: java.lang.Throwable -> L36
            if (r10 != r6) goto L32
        Lae:
            return
        Laf:
            r10 = move-exception
            r4 = r8
            r8 = r10
        Lb2:
            r4.freeSlot(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.collect$suspendImpl(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):void");
    }

    public final Object awaitValue(SharedFlowSlot sharedFlowSlot, AnonymousClass1 anonymousClass1) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzga.intercepted(anonymousClass1));
        cancellableContinuationImpl.initCancellability();
        synchronized (this) {
            try {
                if (tryPeekLocked(sharedFlowSlot) < 0) {
                    sharedFlowSlot.cont = cancellableContinuationImpl;
                } else {
                    cancellableContinuationImpl.resumeWith(Unit.INSTANCE);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        return result == CoroutineSingletons.COROUTINE_SUSPENDED ? result : Unit.INSTANCE;
    }

    public final void cleanupTailLocked() {
        if (this.bufferCapacity != 0 || this.queueSize > 1) {
            Object[] objArr = this.buffer;
            while (this.queueSize > 0) {
                long head = getHead();
                int i = this.bufferSize;
                int i2 = this.queueSize;
                if (objArr[((int) ((head + ((long) (i + i2))) - 1)) & (objArr.length - 1)] != FlowKt.NO_VALUE) {
                    return;
                }
                this.queueSize = i2 - 1;
                FlowKt.access$setBufferAt(objArr, getHead() + ((long) (this.bufferSize + this.queueSize)), null);
            }
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) throws Throwable {
        collect$suspendImpl(this, flowCollector, continuation);
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public final AbstractSharedFlowSlot createSlot() {
        SharedFlowSlot sharedFlowSlot = new SharedFlowSlot();
        sharedFlowSlot.index = -1L;
        return sharedFlowSlot;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public final AbstractSharedFlowSlot[] createSlotArray() {
        return new SharedFlowSlot[2];
    }

    public final void dropOldestLocked() {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        FlowKt.access$setBufferAt(this.buffer, getHead(), null);
        this.bufferSize--;
        long head = getHead() + 1;
        if (this.replayIndex < head) {
            this.replayIndex = head;
        }
        if (this.minCollectorIndex < head) {
            if (this.nCollectors != 0 && (abstractSharedFlowSlotArr = this.slots) != null) {
                for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                    if (abstractSharedFlowSlot != null) {
                        SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                        long j = sharedFlowSlot.index;
                        if (j >= 0 && j < head) {
                            sharedFlowSlot.index = head;
                        }
                    }
                }
            }
            this.minCollectorIndex = head;
        }
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) throws Throwable {
        Throwable th;
        Continuation[] continuationArrFindSlotsToResumeLocked;
        Emitter emitter;
        if (tryEmit(obj)) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzga.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        Continuation[] continuationArrFindSlotsToResumeLocked2 = ChannelFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            try {
                if (tryEmitLocked(obj)) {
                    try {
                        cancellableContinuationImpl.resumeWith(Unit.INSTANCE);
                        continuationArrFindSlotsToResumeLocked = findSlotsToResumeLocked(continuationArrFindSlotsToResumeLocked2);
                        emitter = null;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    try {
                        Emitter emitter2 = new Emitter(this, getHead() + ((long) (this.bufferSize + this.queueSize)), obj, cancellableContinuationImpl);
                        enqueueLocked(emitter2);
                        this.queueSize++;
                        if (this.bufferCapacity == 0) {
                            continuationArrFindSlotsToResumeLocked2 = findSlotsToResumeLocked(continuationArrFindSlotsToResumeLocked2);
                        }
                        continuationArrFindSlotsToResumeLocked = continuationArrFindSlotsToResumeLocked2;
                        emitter = emitter2;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw th;
                    }
                }
                if (emitter != null) {
                    cancellableContinuationImpl.invokeOnCancellationImpl(new DisposeOnCancel(0, emitter));
                }
                for (Continuation continuation2 : continuationArrFindSlotsToResumeLocked) {
                    if (continuation2 != null) {
                        continuation2.resumeWith(Unit.INSTANCE);
                    }
                }
                Object result = cancellableContinuationImpl.getResult();
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (result != coroutineSingletons) {
                    result = Unit.INSTANCE;
                }
                return result == coroutineSingletons ? result : Unit.INSTANCE;
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public final void enqueueLocked(Object obj) {
        int i = this.bufferSize + this.queueSize;
        Object[] objArrGrowBuffer = this.buffer;
        if (objArrGrowBuffer == null) {
            objArrGrowBuffer = growBuffer(null, 0, 2);
        } else if (i >= objArrGrowBuffer.length) {
            objArrGrowBuffer = growBuffer(objArrGrowBuffer, i, objArrGrowBuffer.length * 2);
        }
        FlowKt.access$setBufferAt(objArrGrowBuffer, getHead() + ((long) i), obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [kotlin.coroutines.Continuation[]] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r6v3 */
    public final Continuation[] findSlotsToResumeLocked(Continuation[] continuationArr) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        SharedFlowSlot sharedFlowSlot;
        CancellableContinuationImpl cancellableContinuationImpl;
        int length = continuationArr.length;
        if (this.nCollectors != 0 && (abstractSharedFlowSlotArr = this.slots) != null) {
            int length2 = abstractSharedFlowSlotArr.length;
            int i = 0;
            while (i < length2) {
                AbstractSharedFlowSlot abstractSharedFlowSlot = abstractSharedFlowSlotArr[i];
                if (abstractSharedFlowSlot == null || (cancellableContinuationImpl = (sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot).cont) == null || tryPeekLocked(sharedFlowSlot) < 0) {
                    continuationArr = continuationArr;
                } else {
                    if (length >= continuationArr.length) {
                        continuationArr = continuationArr;
                        continuationArr = continuationArr;
                        continuationArr = Arrays.copyOf((Object[]) continuationArr, Math.max(2, continuationArr.length * 2));
                    }
                    continuationArr = continuationArr;
                    continuationArr = continuationArr;
                    ((Continuation[]) continuationArr)[length] = cancellableContinuationImpl;
                    sharedFlowSlot.cont = null;
                    length++;
                }
                i++;
                continuationArr = continuationArr;
            }
            continuationArr = continuationArr;
        }
        return (Continuation[]) continuationArr;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow fuse(CoroutineContext coroutineContext, int i, int i2) {
        return FlowKt.fuseSharedFlow(this, coroutineContext, i, i2);
    }

    public final long getHead() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    public final Object[] growBuffer(Object[] objArr, int i, int i2) {
        if (i2 <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr2 = new Object[i2];
        this.buffer = objArr2;
        if (objArr != null) {
            long head = getHead();
            for (int i3 = 0; i3 < i; i3++) {
                long j = ((long) i3) + head;
                FlowKt.access$setBufferAt(objArr2, j, objArr[((int) j) & (objArr.length - 1)]);
            }
        }
        return objArr2;
    }

    public final boolean tryEmit(Object obj) {
        int i;
        boolean z;
        Continuation[] continuationArrFindSlotsToResumeLocked = ChannelFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (tryEmitLocked(obj)) {
                continuationArrFindSlotsToResumeLocked = findSlotsToResumeLocked(continuationArrFindSlotsToResumeLocked);
                z = true;
            } else {
                z = false;
            }
        }
        for (Continuation continuation : continuationArrFindSlotsToResumeLocked) {
            if (continuation != null) {
                continuation.resumeWith(Unit.INSTANCE);
            }
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0047  */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Code duplicated, block: B:30:0x0062  */
    public final boolean tryEmitLocked(Object obj) {
        int i;
        long head;
        long j;
        int i2 = this.nCollectors;
        int i3 = this.replay;
        if (i2 != 0) {
            int i4 = this.bufferSize;
            int i5 = this.bufferCapacity;
            if (i4 < i5 || this.minCollectorIndex > this.replayIndex) {
                enqueueLocked(obj);
                i = this.bufferSize + 1;
                this.bufferSize = i;
                if (i > i5) {
                    dropOldestLocked();
                }
                head = getHead() + ((long) this.bufferSize);
                j = this.replayIndex;
                if (((int) (head - j)) > i3) {
                    updateBufferLocked(1 + j, this.minCollectorIndex, getHead() + ((long) this.bufferSize), getHead() + ((long) this.bufferSize) + ((long) this.queueSize));
                }
            } else {
                int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.onBufferOverflow);
                if (iOrdinal == 0) {
                    return false;
                }
                if (iOrdinal == 1) {
                    enqueueLocked(obj);
                    i = this.bufferSize + 1;
                    this.bufferSize = i;
                    if (i > i5) {
                        dropOldestLocked();
                    }
                    head = getHead() + ((long) this.bufferSize);
                    j = this.replayIndex;
                    if (((int) (head - j)) > i3) {
                        updateBufferLocked(1 + j, this.minCollectorIndex, getHead() + ((long) this.bufferSize), getHead() + ((long) this.bufferSize) + ((long) this.queueSize));
                    }
                } else if (iOrdinal != 2) {
                    throw new HttpException();
                }
            }
        } else if (i3 != 0) {
            enqueueLocked(obj);
            int i6 = this.bufferSize + 1;
            this.bufferSize = i6;
            if (i6 > i3) {
                dropOldestLocked();
            }
            this.minCollectorIndex = getHead() + ((long) this.bufferSize);
            return true;
        }
        return true;
    }

    public final long tryPeekLocked(SharedFlowSlot sharedFlowSlot) {
        long j = sharedFlowSlot.index;
        if (j < getHead() + ((long) this.bufferSize)) {
            return j;
        }
        if (this.bufferCapacity <= 0 && j <= getHead() && this.queueSize != 0) {
            return j;
        }
        return -1L;
    }

    public final Object tryTakeValue(SharedFlowSlot sharedFlowSlot) {
        Object obj;
        Continuation[] continuationArrUpdateCollectorIndexLocked$kotlinx_coroutines_core = ChannelFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            try {
                long jTryPeekLocked = tryPeekLocked(sharedFlowSlot);
                if (jTryPeekLocked < 0) {
                    obj = FlowKt.NO_VALUE;
                } else {
                    long j = sharedFlowSlot.index;
                    Object[] objArr = this.buffer;
                    Object obj2 = objArr[((int) jTryPeekLocked) & (objArr.length - 1)];
                    if (obj2 instanceof Emitter) {
                        obj2 = ((Emitter) obj2).value;
                    }
                    sharedFlowSlot.index = jTryPeekLocked + 1;
                    Object obj3 = obj2;
                    continuationArrUpdateCollectorIndexLocked$kotlinx_coroutines_core = updateCollectorIndexLocked$kotlinx_coroutines_core(j);
                    obj = obj3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation continuation : continuationArrUpdateCollectorIndexLocked$kotlinx_coroutines_core) {
            if (continuation != null) {
                continuation.resumeWith(Unit.INSTANCE);
            }
        }
        return obj;
    }

    public final void updateBufferLocked(long j, long j2, long j3, long j4) {
        long jMin = Math.min(j2, j);
        for (long head = getHead(); head < jMin; head++) {
            FlowKt.access$setBufferAt(this.buffer, head, null);
        }
        this.replayIndex = j;
        this.minCollectorIndex = j2;
        this.bufferSize = (int) (j3 - jMin);
        this.queueSize = (int) (j4 - j3);
    }

    public final Continuation[] updateCollectorIndexLocked$kotlinx_coroutines_core(long j) {
        long j2;
        long j3;
        Continuation[] continuationArr;
        Continuation[] continuationArr2;
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        Symbol symbol = FlowKt.NO_VALUE;
        Continuation[] continuationArr3 = ChannelFlowKt.EMPTY_RESUMES;
        if (j <= this.minCollectorIndex) {
            long head = getHead();
            long j4 = ((long) this.bufferSize) + head;
            int i = this.bufferCapacity;
            if (i == 0 && this.queueSize > 0) {
                j4++;
            }
            int i2 = 0;
            if (this.nCollectors != 0 && (abstractSharedFlowSlotArr = this.slots) != null) {
                for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                    if (abstractSharedFlowSlot != null) {
                        long j5 = ((SharedFlowSlot) abstractSharedFlowSlot).index;
                        if (j5 >= 0 && j5 < j4) {
                            j4 = j5;
                        }
                    }
                }
            }
            if (j4 > this.minCollectorIndex) {
                long head2 = getHead() + ((long) this.bufferSize);
                int iMin = this.nCollectors > 0 ? Math.min(this.queueSize, i - ((int) (head2 - j4))) : this.queueSize;
                long j6 = ((long) this.queueSize) + head2;
                if (iMin > 0) {
                    j3 = 1;
                    Object[] objArr = this.buffer;
                    Continuation[] continuationArr4 = new Continuation[iMin];
                    long j7 = head2;
                    while (true) {
                        if (head2 >= j6) {
                            continuationArr2 = continuationArr4;
                            j2 = j4;
                            break;
                        }
                        continuationArr2 = continuationArr4;
                        Object obj = objArr[(objArr.length - 1) & ((int) head2)];
                        if (obj != symbol) {
                            Emitter emitter = (Emitter) obj;
                            int i3 = i2 + 1;
                            j2 = j4;
                            continuationArr2[i2] = emitter.cont;
                            FlowKt.access$setBufferAt(objArr, head2, symbol);
                            FlowKt.access$setBufferAt(objArr, j7, emitter.value);
                            j7++;
                            if (i3 >= iMin) {
                                break;
                            }
                            i2 = i3;
                        } else {
                            j2 = j4;
                        }
                        head2++;
                        continuationArr4 = continuationArr2;
                        j4 = j2;
                    }
                    head2 = j7;
                    continuationArr = continuationArr2;
                } else {
                    j2 = j4;
                    j3 = 1;
                    continuationArr = continuationArr3;
                }
                int i4 = (int) (head2 - head);
                long j8 = this.nCollectors == 0 ? head2 : j2;
                long jMax = Math.max(this.replayIndex, head2 - ((long) Math.min(this.replay, i4)));
                if (i == 0 && jMax < j6) {
                    Object[] objArr2 = this.buffer;
                    if (Intrinsics.areEqual(objArr2[((int) jMax) & (objArr2.length - 1)], symbol)) {
                        head2 += j3;
                        jMax += j3;
                    }
                }
                updateBufferLocked(jMax, j8, head2, j6);
                cleanupTailLocked();
                return continuationArr.length == 0 ? continuationArr : findSlotsToResumeLocked(continuationArr);
            }
        }
        return continuationArr3;
    }
}
