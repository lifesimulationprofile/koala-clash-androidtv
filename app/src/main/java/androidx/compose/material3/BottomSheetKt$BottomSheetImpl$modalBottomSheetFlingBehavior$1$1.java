package androidx.compose.material3;

import androidx.camera.core.SurfaceRequest;
import androidx.compose.foundation.gestures.DefaultDraggableAnchors;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1 implements FlingBehavior {
    public final /* synthetic */ SnapFlingBehavior $anchoredDraggableFlingBehavior;
    public final /* synthetic */ Density $density;
    public final /* synthetic */ Function0 $onDismissRequest;
    public final /* synthetic */ SheetState $state;
    public final /* synthetic */ ViewConfiguration $viewConfiguration;

    public BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1(ViewConfiguration viewConfiguration, SheetState sheetState, Density density, SnapFlingBehavior snapFlingBehavior, Function0 function0) {
        this.$viewConfiguration = viewConfiguration;
        this.$state = sheetState;
        this.$density = density;
        this.$anchoredDraggableFlingBehavior = snapFlingBehavior;
        this.$onDismissRequest = function0;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public final Object performFling(ScrollScope scrollScope, float f, Continuation continuation) {
        BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1 bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1;
        SheetState sheetState = this.$state;
        SurfaceRequest.AnonymousClass1 anonymousClass1 = sheetState.anchoredDraggableState;
        if (continuation instanceof BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1) {
            bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1 = (BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1) continuation;
            int i = bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1.label = i - Integer.MIN_VALUE;
            } else {
                bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1 = new BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1(this, (ContinuationImpl) continuation);
            }
        } else {
            bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1 = new BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1(this, (ContinuationImpl) continuation);
        }
        Object objPerformFling = bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1.result;
        int i2 = bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1.label;
        Function0 function0 = this.$onDismissRequest;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objPerformFling);
                float maximumFlingVelocity = this.$viewConfiguration.getMaximumFlingVelocity();
                float fCoerceIn = RangesKt.coerceIn(f, -maximumFlingVelocity, maximumFlingVelocity);
                if (fCoerceIn > 0.0f) {
                    DefaultDraggableAnchors anchors = ((NodeChain) anonymousClass1.val$requestCancellationCompleter).getAnchors();
                    SheetValue sheetValue = SheetValue.Hidden;
                    if (anchors.hasPositionFor(sheetValue)) {
                        float fMax = Math.max(0.0f, ((NodeChain) anonymousClass1.val$requestCancellationCompleter).getAnchors().positionOf(sheetValue) - ((NodeChain) anonymousClass1.val$requestCancellationCompleter).requireOffset());
                        float f2 = BottomSheetDefaults.BoundaryDampeningZone;
                        Density density = this.$density;
                        float fMo92toPx0680j_4 = density.mo92toPx0680j_4(f2);
                        if (fMax < fMo92toPx0680j_4) {
                            fCoerceIn *= fMax / fMo92toPx0680j_4;
                            float fMo92toPx0680j_5 = density.mo92toPx0680j_4(BottomSheetDefaults.VelocityThreshold);
                            if (f >= fMo92toPx0680j_5) {
                                fCoerceIn = Math.max(fCoerceIn, fMo92toPx0680j_5);
                            }
                        }
                    }
                }
                SnapFlingBehavior snapFlingBehavior = this.$anchoredDraggableFlingBehavior;
                bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1.label = 1;
                objPerformFling = snapFlingBehavior.performFling(scrollScope, fCoerceIn, ScrollableKt.NoOnReport, bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1$performFling$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objPerformFling == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objPerformFling);
            }
            float fFloatValue = ((Number) objPerformFling).floatValue();
            if (!sheetState.isVisible()) {
                function0.invoke();
            }
            return new Float(fFloatValue);
        } catch (Throwable th) {
            if (!sheetState.isVisible()) {
                function0.invoke();
            }
            throw th;
        }
    }
}
