package androidx.compose.ui.input.pointer;

import androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1$2$1;
import androidx.compose.material3.ThumbNode;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.TouchBoundsExpansion;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.navigation.Navigator;
import coil.network.HttpException;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SuspendingPointerInputModifierNodeImpl extends Modifier.Node implements PointerInputScope, Density, PointerInputModifierNode {
    public PointerInputEventHandler _pointerInputEventHandler;
    public long boundsSize;
    public PointerEvent currentEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
    public final MutableVector dispatchingPointerHandlers;
    public Object key1;
    public Object key2;
    public PointerEvent lastPointerEvent;
    public final MutableVector pointerHandlers;
    public final MutableVector pointerHandlersLock;
    public StandaloneCoroutine pointerInputJob;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class PointerEventHandlerCoroutine implements Density, Continuation {
        public final /* synthetic */ SuspendingPointerInputModifierNodeImpl $$delegate_0;
        public PointerEventPass awaitPass = PointerEventPass.Main;
        public final CancellableContinuationImpl completion;
        public CancellableContinuationImpl pointerAwaiter;

        public PointerEventHandlerCoroutine(CancellableContinuationImpl cancellableContinuationImpl) {
            this.$$delegate_0 = SuspendingPointerInputModifierNodeImpl.this;
            this.completion = cancellableContinuationImpl;
        }

        public final Object awaitPointerEvent(PointerEventPass pointerEventPass, BaseContinuationImpl baseContinuationImpl) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzga.intercepted(baseContinuationImpl));
            cancellableContinuationImpl.initCancellability();
            this.awaitPass = pointerEventPass;
            this.pointerAwaiter = cancellableContinuationImpl;
            return cancellableContinuationImpl.getResult();
        }

        @Override // kotlin.coroutines.Continuation
        public final CoroutineContext getContext() {
            return EmptyCoroutineContext.INSTANCE;
        }

        @Override // androidx.compose.ui.unit.Density
        public final float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
        public final long m514getExtendedTouchPaddingNHjbRc() {
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = SuspendingPointerInputModifierNodeImpl.this;
            suspendingPointerInputModifierNodeImpl.getClass();
            long jM699$default$toSizeXkaWNTQ = Density.CC.m699$default$toSizeXkaWNTQ(HitTestResultKt.requireLayoutNode(suspendingPointerInputModifierNodeImpl).viewConfiguration.mo550getMinimumTouchTargetSizeMYxV2XQ(), suspendingPointerInputModifierNodeImpl);
            long j = suspendingPointerInputModifierNodeImpl.boundsSize;
            return (((long) Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat((int) (jM699$default$toSizeXkaWNTQ >> 32)) - ((int) (j >> 32))) / 2.0f)) << 32) | (((long) Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat((int) (jM699$default$toSizeXkaWNTQ & 4294967295L)) - ((int) (j & 4294967295L))) / 2.0f)) & 4294967295L);
        }

        @Override // androidx.compose.ui.unit.Density
        public final float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        public final ViewConfiguration getViewConfiguration() {
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = SuspendingPointerInputModifierNodeImpl.this;
            suspendingPointerInputModifierNodeImpl.getClass();
            return HitTestResultKt.requireLayoutNode(suspendingPointerInputModifierNodeImpl).viewConfiguration;
        }

        @Override // kotlin.coroutines.Continuation
        public final void resumeWith(Object obj) {
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = SuspendingPointerInputModifierNodeImpl.this;
            synchronized (suspendingPointerInputModifierNodeImpl.pointerHandlersLock) {
                suspendingPointerInputModifierNodeImpl.pointerHandlers.remove(this);
                Unit unit = Unit.INSTANCE;
            }
            this.completion.resumeWith(obj);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: roundToPx-0680j_4 */
        public final int mo86roundToPx0680j_4(float f) {
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = this.$$delegate_0;
            suspendingPointerInputModifierNodeImpl.getClass();
            return Density.CC.m695$default$roundToPx0680j_4(suspendingPointerInputModifierNodeImpl, f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-GaN1DYA */
        public final float mo87toDpGaN1DYA(long j) {
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = this.$$delegate_0;
            suspendingPointerInputModifierNodeImpl.getClass();
            return Density.CC.m696$default$toDpGaN1DYA(j, suspendingPointerInputModifierNodeImpl);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public final float mo89toDpu2uoSUM(int i) {
            return this.$$delegate_0.mo89toDpu2uoSUM(i);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDpSize-k-rfVVM */
        public final long mo90toDpSizekrfVVM(long j) {
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = this.$$delegate_0;
            suspendingPointerInputModifierNodeImpl.getClass();
            return Density.CC.m697$default$toDpSizekrfVVM(j, suspendingPointerInputModifierNodeImpl);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toPx--R2X_6o */
        public final float mo91toPxR2X_6o(long j) {
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = this.$$delegate_0;
            suspendingPointerInputModifierNodeImpl.getClass();
            return Density.CC.m698$default$toPxR2X_6o(j, suspendingPointerInputModifierNodeImpl);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toPx-0680j_4 */
        public final float mo92toPx0680j_4(float f) {
            return this.$$delegate_0.getDensity() * f;
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSize-XkaWNTQ */
        public final long mo93toSizeXkaWNTQ(long j) {
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = this.$$delegate_0;
            suspendingPointerInputModifierNodeImpl.getClass();
            return Density.CC.m699$default$toSizeXkaWNTQ(j, suspendingPointerInputModifierNodeImpl);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public final long mo94toSpkPz2Gy4(float f) {
            return this.$$delegate_0.mo94toSpkPz2Gy4(f);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0, types: [long] */
        /* JADX WARN: Type inference failed for: r6v1, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r6v4, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r6v7 */
        /* JADX WARN: Type inference failed for: r6v8 */
        /* JADX WARN: Type inference failed for: r8v0, types: [kotlin.jvm.functions.Function2] */
        public final Object withTimeout(long j, Function2 function2, BaseContinuationImpl baseContinuationImpl) {
            SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1;
            CancellableContinuationImpl cancellableContinuationImpl;
            if (baseContinuationImpl instanceof SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1) {
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 = (SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1) baseContinuationImpl;
                int i = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.label = i - Integer.MIN_VALUE;
                } else {
                    suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 = new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1(this, baseContinuationImpl);
                }
            } else {
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 = new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1(this, baseContinuationImpl);
            }
            Object objInvoke = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.result;
            int i2 = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.label;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objInvoke);
                    if (j <= 0 && (cancellableContinuationImpl = this.pointerAwaiter) != null) {
                        cancellableContinuationImpl.resumeWith(new Result.Failure(new PointerEventTimeoutCancellationException(j)));
                    }
                    StandaloneCoroutine standaloneCoroutineLaunch$default = JobKt.launch$default(SuspendingPointerInputModifierNodeImpl.this.getCoroutineScope(), null, new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1$2$1((long) j, this, (Continuation) null), 3);
                    suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.L$0 = standaloneCoroutineLaunch$default;
                    suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.label = 1;
                    objInvoke = function2.invoke(this, suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    j = standaloneCoroutineLaunch$default;
                    if (objInvoke == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    StandaloneCoroutine standaloneCoroutine = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.L$0;
                    ResultKt.throwOnFailure(objInvoke);
                    j = standaloneCoroutine;
                }
                j.cancel(CancelTimeoutCancellationException.INSTANCE);
                return objInvoke;
            } catch (Throwable th) {
                j.cancel(CancelTimeoutCancellationException.INSTANCE);
                throw th;
            }
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public final Object withTimeoutOrNull(long j, Function2 function2, ContinuationImpl continuationImpl) {
            SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1;
            if (continuationImpl instanceof SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1) {
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 = (SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1) continuationImpl;
                int i = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.label = i - Integer.MIN_VALUE;
                } else {
                    suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 = new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1(this, continuationImpl);
                }
            } else {
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 = new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1(this, continuationImpl);
            }
            Object obj = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.result;
            int i2 = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.label;
            try {
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.label = 1;
                Object objWithTimeout = withTimeout(j, function2, suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1);
                Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                return objWithTimeout == obj2 ? obj2 : objWithTimeout;
            } catch (PointerEventTimeoutCancellationException unused) {
                return null;
            }
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public final float mo88toDpu2uoSUM(float f) {
            return f / this.$$delegate_0.getDensity();
        }
    }

    public SuspendingPointerInputModifierNodeImpl(Object obj, Object obj2, PointerInputEventHandler pointerInputEventHandler) {
        this.key1 = obj;
        this.key2 = obj2;
        this._pointerInputEventHandler = pointerInputEventHandler;
        MutableVector mutableVector = new MutableVector(new PointerEventHandlerCoroutine[16]);
        this.pointerHandlers = mutableVector;
        this.pointerHandlersLock = mutableVector;
        this.dispatchingPointerHandlers = new MutableVector(new PointerEventHandlerCoroutine[16]);
        this.boundsSize = 0L;
    }

    public final Object awaitPointerEventScope(Function2 function2, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzga.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        PointerEventHandlerCoroutine pointerEventHandlerCoroutine = new PointerEventHandlerCoroutine(cancellableContinuationImpl);
        synchronized (this.pointerHandlersLock) {
            this.pointerHandlers.add(pointerEventHandlerCoroutine);
            new SafeContinuation(zzga.intercepted(zzga.createCoroutineUnintercepted(pointerEventHandlerCoroutine, pointerEventHandlerCoroutine, function2)), CoroutineSingletons.COROUTINE_SUSPENDED).resumeWith(Unit.INSTANCE);
        }
        cancellableContinuationImpl.invokeOnCancellation(new Navigator.AnonymousClass1(13, pointerEventHandlerCoroutine));
        return cancellableContinuationImpl.getResult();
    }

    /* JADX WARN: Code duplicated, block: B:28:0x004c A[Catch: all -> 0x0021, TryCatch #0 {all -> 0x0021, blocks: (B:6:0x000d, B:13:0x001b, B:14:0x0020, B:17:0x0023, B:20:0x002f, B:22:0x0037, B:24:0x003b, B:25:0x0040, B:26:0x0043, B:28:0x004c, B:30:0x0054, B:32:0x0058), top: B:41:0x000d }] */
    public final void dispatchPointerEvent(PointerEvent pointerEvent, PointerEventPass pointerEventPass) {
        Object[] objArr;
        int i;
        int i2;
        PointerEventHandlerCoroutine pointerEventHandlerCoroutine;
        CancellableContinuationImpl cancellableContinuationImpl;
        CancellableContinuationImpl cancellableContinuationImpl2;
        synchronized (this.pointerHandlersLock) {
            MutableVector mutableVector = this.dispatchingPointerHandlers;
            mutableVector.addAll(mutableVector.size, this.pointerHandlers);
        }
        try {
            int iOrdinal = pointerEventPass.ordinal();
            if (iOrdinal == 0) {
                MutableVector mutableVector2 = this.dispatchingPointerHandlers;
                objArr = mutableVector2.content;
                i = mutableVector2.size;
                for (i2 = 0; i2 < i; i2++) {
                    pointerEventHandlerCoroutine = (PointerEventHandlerCoroutine) objArr[i2];
                    if (pointerEventPass != pointerEventHandlerCoroutine.awaitPass && (cancellableContinuationImpl = pointerEventHandlerCoroutine.pointerAwaiter) != null) {
                        pointerEventHandlerCoroutine.pointerAwaiter = null;
                        cancellableContinuationImpl.resumeWith(pointerEvent);
                    }
                }
            } else if (iOrdinal == 1) {
                MutableVector mutableVector3 = this.dispatchingPointerHandlers;
                int i3 = mutableVector3.size - 1;
                Object[] objArr2 = mutableVector3.content;
                if (i3 < objArr2.length) {
                    while (i3 >= 0) {
                        PointerEventHandlerCoroutine pointerEventHandlerCoroutine2 = (PointerEventHandlerCoroutine) objArr2[i3];
                        if (pointerEventPass == pointerEventHandlerCoroutine2.awaitPass && (cancellableContinuationImpl2 = pointerEventHandlerCoroutine2.pointerAwaiter) != null) {
                            pointerEventHandlerCoroutine2.pointerAwaiter = null;
                            cancellableContinuationImpl2.resumeWith(pointerEvent);
                        }
                        i3--;
                    }
                }
            } else {
                if (iOrdinal != 2) {
                    throw new HttpException();
                }
                MutableVector mutableVector4 = this.dispatchingPointerHandlers;
                objArr = mutableVector4.content;
                i = mutableVector4.size;
                while (i2 < i) {
                    pointerEventHandlerCoroutine = (PointerEventHandlerCoroutine) objArr[i2];
                    if (pointerEventPass != pointerEventHandlerCoroutine.awaitPass) {
                    }
                }
            }
            this.dispatchingPointerHandlers.clear();
        } catch (Throwable th) {
            this.dispatchingPointerHandlers.clear();
            throw th;
        }
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return HitTestResultKt.requireLayoutNode(this).density.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return HitTestResultKt.requireLayoutNode(this).density.getFontScale();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: getTouchBoundsExpansion-RZrCHBk */
    public final long mo31getTouchBoundsExpansionRZrCHBk() {
        return TouchBoundsExpansion.None;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        PointerEvent pointerEvent = this.lastPointerEvent;
        if (pointerEvent == null) {
            return;
        }
        ?? r1 = pointerEvent.changes;
        int size = r1.size();
        for (int i = 0; i < size; i++) {
            if (((PointerInputChange) r1.get(i)).pressed) {
                ArrayList arrayList = new ArrayList(r1.size());
                int size2 = r1.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    PointerInputChange pointerInputChange = (PointerInputChange) r1.get(i2);
                    long j = pointerInputChange.id;
                    long j2 = pointerInputChange.position;
                    long j3 = pointerInputChange.uptimeMillis;
                    float f = pointerInputChange.pressure;
                    boolean z = pointerInputChange.pressed;
                    arrayList.add(new PointerInputChange(j, j3, j2, false, f, j3, j2, z, z, pointerInputChange.type, 0L, 1.0f, 0L));
                }
                PointerEvent pointerEvent2 = new PointerEvent(arrayList, null);
                this.currentEvent = pointerEvent2;
                dispatchPointerEvent(pointerEvent2, PointerEventPass.Initial);
                dispatchPointerEvent(pointerEvent2, PointerEventPass.Main);
                dispatchPointerEvent(pointerEvent2, PointerEventPass.Final);
                this.lastPointerEvent = null;
                return;
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDensityChange() {
        resetPointerInputHandler();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        resetPointerInputHandler();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public final void mo36onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        this.boundsSize = j;
        if (pointerEventPass == PointerEventPass.Initial) {
            this.currentEvent = pointerEvent;
        }
        Continuation continuation = null;
        if (this.pointerInputJob == null) {
            this.pointerInputJob = JobKt.launch$default(getCoroutineScope(), null, new ThumbNode.AnonymousClass1(this, continuation, 13), 1);
        }
        dispatchPointerEvent(pointerEvent, pointerEventPass);
        ?? r4 = pointerEvent.changes;
        int size = r4.size();
        for (int i = 0; i < size; i++) {
            if (!PointerId.changedToUpIgnoreConsumed((PointerInputChange) r4.get(i))) {
                this.lastPointerEvent = pointerEvent;
            }
        }
        pointerEvent = null;
        this.lastPointerEvent = pointerEvent;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onViewConfigurationChange() {
        resetPointerInputHandler();
    }

    public final void resetPointerInputHandler() {
        StandaloneCoroutine standaloneCoroutine = this.pointerInputJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancelInternal(new PointerInputResetException("Pointer input was reset", 0));
            this.pointerInputJob = null;
        }
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public final /* synthetic */ int mo86roundToPx0680j_4(float f) {
        return Density.CC.m695$default$roundToPx0680j_4(this, f);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ boolean sharePointerInputWithSiblings() {
        return false;
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public final /* synthetic */ float mo87toDpGaN1DYA(long j) {
        return Density.CC.m696$default$toDpGaN1DYA(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final float mo89toDpu2uoSUM(int i) {
        return i / getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public final /* synthetic */ long mo90toDpSizekrfVVM(long j) {
        return Density.CC.m697$default$toDpSizekrfVVM(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public final /* synthetic */ float mo91toPxR2X_6o(long j) {
        return Density.CC.m698$default$toPxR2X_6o(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public final float mo92toPx0680j_4(float f) {
        return getDensity() * f;
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public final /* synthetic */ long mo93toSizeXkaWNTQ(long j) {
        return Density.CC.m699$default$toSizeXkaWNTQ(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public final long mo94toSpkPz2Gy4(float f) {
        return Density.CC.m700$default$toSp0xMU5do(this, mo88toDpu2uoSUM(f));
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final float mo88toDpu2uoSUM(float f) {
        return f / getDensity();
    }
}
