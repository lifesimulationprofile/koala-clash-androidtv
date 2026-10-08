package androidx.compose.ui.scrollcapture;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.CancellationSignal;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureSession;
import androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$$ExternalSyntheticLambda31;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.text.android.CanvasCompatS$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.unit.IntRect;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import coil.RealImageLoader$execute$3;
import coil.memory.MemoryCacheService;
import java.util.function.Consumer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.internal.ContextScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposeScrollCaptureCallback implements ScrollCaptureCallback {
    public final AndroidComposeView composeView;
    public final ContextScope coroutineScope;
    public final MemoryCacheService listener;
    public final SemanticsNode node;
    public final RelativeScroller scrollTracker;
    public final IntRect viewportBoundsInWindow;

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 extends ContinuationImpl {
        public int I$0;
        public int I$1;
        public Object L$0;
        public IntRect L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass2(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ComposeScrollCaptureCallback.access$onScrollCaptureImageRequest(ComposeScrollCaptureCallback.this, null, null, this);
        }
    }

    public ComposeScrollCaptureCallback(SemanticsNode semanticsNode, IntRect intRect, ContextScope contextScope, MemoryCacheService memoryCacheService, AndroidComposeView androidComposeView) {
        this.node = semanticsNode;
        this.viewportBoundsInWindow = intRect;
        this.listener = memoryCacheService;
        this.composeView = androidComposeView;
        this.coroutineScope = new ContextScope(contextScope.coroutineContext.plus(DisableAnimationMotionDurationScale.INSTANCE));
        this.scrollTracker = new RelativeScroller(intRect.getHeight(), new ComposeScrollCaptureCallback$scrollTracker$1(this, null));
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:42:0x00db  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object access$onScrollCaptureImageRequest(ComposeScrollCaptureCallback composeScrollCaptureCallback, ScrollCaptureSession scrollCaptureSession, IntRect intRect, ContinuationImpl continuationImpl) {
        AnonymousClass2 anonymousClass2;
        int i;
        int i2;
        Object objScrollBy;
        ScrollCaptureSession scrollCaptureSessionM;
        int i3;
        IntRect intRect2;
        int i4;
        int iCoerceIn;
        int iCoerceIn2;
        int i5;
        int i6;
        Canvas canvasLockHardwareCanvas;
        if (continuationImpl instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuationImpl;
            int i7 = anonymousClass2.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label = i7 - Integer.MIN_VALUE;
            } else {
                anonymousClass2 = composeScrollCaptureCallback.new AnonymousClass2(continuationImpl);
            }
        } else {
            anonymousClass2 = composeScrollCaptureCallback.new AnonymousClass2(continuationImpl);
        }
        Object obj = anonymousClass2.result;
        int i8 = anonymousClass2.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            i = intRect.top;
            i2 = intRect.bottom;
            RelativeScroller relativeScroller = composeScrollCaptureCallback.scrollTracker;
            anonymousClass2.L$0 = scrollCaptureSession;
            anonymousClass2.L$1 = intRect;
            anonymousClass2.I$0 = i;
            anonymousClass2.I$1 = i2;
            anonymousClass2.label = 1;
            int i9 = relativeScroller.viewportSize;
            if (i > i2) {
                throw new IllegalArgumentException(Modifier.CC.m(i, i2, "Expected min=", " ≤ max=").toString());
            }
            int i10 = i2 - i;
            if (i10 > i9) {
                throw new IllegalArgumentException(Modifier.CC.m(i10, i9, "Expected range (", ") to be ≤ viewportSize=").toString());
            }
            float f = i;
            float f2 = relativeScroller.scrollAmount;
            if (f < f2 || i2 > i9 + f2) {
                objScrollBy = relativeScroller.scrollBy((((i10 / 2) + i) - (i9 / 2)) - f2, anonymousClass2);
                if (objScrollBy != coroutineSingletons) {
                    objScrollBy = Unit.INSTANCE;
                }
                if (objScrollBy != coroutineSingletons) {
                    objScrollBy = Unit.INSTANCE;
                }
            } else {
                objScrollBy = Unit.INSTANCE;
            }
            if (objScrollBy != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i8 == 1) {
            int i11 = anonymousClass2.I$1;
            int i12 = anonymousClass2.I$0;
            IntRect intRect3 = anonymousClass2.L$1;
            ScrollCaptureSession scrollCaptureSessionM2 = CanvasCompatS$$ExternalSyntheticApiModelOutline0.m(anonymousClass2.L$0);
            ResultKt.throwOnFailure(obj);
            i = i12;
            intRect = intRect3;
            i2 = i11;
            scrollCaptureSession = scrollCaptureSessionM2;
        } else {
            if (i8 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i3 = anonymousClass2.I$1;
            i4 = anonymousClass2.I$0;
            intRect2 = anonymousClass2.L$1;
            scrollCaptureSessionM = CanvasCompatS$$ExternalSyntheticApiModelOutline0.m(anonymousClass2.L$0);
            ResultKt.throwOnFailure(obj);
        }
        RelativeScroller relativeScroller2 = composeScrollCaptureCallback.scrollTracker;
        iCoerceIn = RangesKt.coerceIn(i4 - MathKt.roundToInt(relativeScroller2.scrollAmount), 0, relativeScroller2.viewportSize);
        RelativeScroller relativeScroller3 = composeScrollCaptureCallback.scrollTracker;
        iCoerceIn2 = RangesKt.coerceIn(i3 - MathKt.roundToInt(relativeScroller3.scrollAmount), 0, relativeScroller3.viewportSize);
        i5 = intRect2.left;
        i6 = intRect2.right;
        if (iCoerceIn == iCoerceIn2) {
            return IntRect.Zero;
        }
        canvasLockHardwareCanvas = scrollCaptureSessionM.getSurface().lockHardwareCanvas();
        try {
            canvasLockHardwareCanvas.save();
            canvasLockHardwareCanvas.translate(-i5, -iCoerceIn);
            IntRect intRect4 = composeScrollCaptureCallback.viewportBoundsInWindow;
            canvasLockHardwareCanvas.translate(-intRect4.left, -intRect4.top);
            composeScrollCaptureCallback.composeView.getRootView().draw(canvasLockHardwareCanvas);
            int iRoundToInt = MathKt.roundToInt(composeScrollCaptureCallback.scrollTracker.scrollAmount);
            return new IntRect(i5, iCoerceIn + iRoundToInt, i6, iCoerceIn2 + iRoundToInt);
        } finally {
            scrollCaptureSessionM.getSurface().unlockCanvasAndPost(canvasLockHardwareCanvas);
        }
        ScrollCapture$onScrollCaptureSearch$2 scrollCapture$onScrollCaptureSearch$2 = ScrollCapture$onScrollCaptureSearch$2.INSTANCE$1;
        anonymousClass2.L$0 = scrollCaptureSession;
        anonymousClass2.L$1 = intRect;
        anonymousClass2.I$0 = i;
        anonymousClass2.I$1 = i2;
        anonymousClass2.label = 2;
        if (Stack.getMonotonicFrameClock(anonymousClass2._context).withFrameNanos(scrollCapture$onScrollCaptureSearch$2, anonymousClass2) != coroutineSingletons) {
            scrollCaptureSessionM = scrollCaptureSession;
            i3 = i2;
            intRect2 = intRect;
            i4 = i;
            RelativeScroller relativeScroller4 = composeScrollCaptureCallback.scrollTracker;
            iCoerceIn = RangesKt.coerceIn(i4 - MathKt.roundToInt(relativeScroller4.scrollAmount), 0, relativeScroller4.viewportSize);
            RelativeScroller relativeScroller5 = composeScrollCaptureCallback.scrollTracker;
            iCoerceIn2 = RangesKt.coerceIn(i3 - MathKt.roundToInt(relativeScroller5.scrollAmount), 0, relativeScroller5.viewportSize);
            i5 = intRect2.left;
            i6 = intRect2.right;
            if (iCoerceIn == iCoerceIn2) {
                return IntRect.Zero;
            }
            canvasLockHardwareCanvas = scrollCaptureSessionM.getSurface().lockHardwareCanvas();
            canvasLockHardwareCanvas.save();
            canvasLockHardwareCanvas.translate(-i5, -iCoerceIn);
            IntRect intRect5 = composeScrollCaptureCallback.viewportBoundsInWindow;
            canvasLockHardwareCanvas.translate(-intRect5.left, -intRect5.top);
            composeScrollCaptureCallback.composeView.getRootView().draw(canvasLockHardwareCanvas);
            int iRoundToInt2 = MathKt.roundToInt(composeScrollCaptureCallback.scrollTracker.scrollAmount);
            return new IntRect(i5, iCoerceIn + iRoundToInt2, i6, iCoerceIn2 + iRoundToInt2);
        }
        return coroutineSingletons;
    }

    public final void onScrollCaptureEnd(Runnable runnable) {
        JobKt.launch$default(this.coroutineScope, NonCancellable.INSTANCE, new RealImageLoader$execute$3(this, runnable, null, 25), 2);
    }

    public final void onScrollCaptureImageRequest(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Rect rect, Consumer consumer) {
        StandaloneCoroutine standaloneCoroutineLaunch$default = JobKt.launch$default(this.coroutineScope, null, new NavHostKt$NavHost$29$1(this, scrollCaptureSession, rect, consumer, null, 9), 3);
        standaloneCoroutineLaunch$default.invokeOnCompletion(new Navigator.AnonymousClass1(24, cancellationSignal));
        cancellationSignal.setOnCancelListener(new HandwritingGestureApi34$$ExternalSyntheticLambda31(1, standaloneCoroutineLaunch$default));
    }

    public final void onScrollCaptureSearch(CancellationSignal cancellationSignal, Consumer consumer) {
        consumer.accept(BrushKt.toAndroidRect(this.viewportBoundsInWindow));
    }

    public final void onScrollCaptureStart(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Runnable runnable) {
        this.scrollTracker.scrollAmount = 0.0f;
        ((ParcelableSnapshotMutableState) this.listener.imageLoader).setValue(Boolean.TRUE);
        runnable.run();
    }
}
