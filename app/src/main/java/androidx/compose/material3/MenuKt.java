package androidx.compose.material3;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class MenuKt {
    public static final float DropdownMenuGroupVerticalPadding;
    public static final float DropdownMenuVerticalPadding;
    public static final float MenuVerticalMargin = 48;
    public static final float DropdownMenuItemHorizontalPadding = 12;

    static {
        float f = 2;
        DropdownMenuGroupVerticalPadding = f;
        float f2 = 4;
        OffsetKt.m122PaddingValuesYgX7TsA$default(2, f2);
        OffsetKt.m121PaddingValuesYgX7TsA(f2, f);
        ((Boolean) PrecisionPointer.shouldUsePrecisionPointerComponentSizing.getValue()).getClass();
        DropdownMenuVerticalPadding = 8;
    }

    /* JADX INFO: renamed from: DropdownMenuContent-Qj0Zi0g, reason: not valid java name */
    public static final void m250DropdownMenuContentQj0Zi0g(Modifier modifier, MutableTransitionState mutableTransitionState, MutableState mutableState, ScrollState scrollState, Shape shape, long j, float f, float f2, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        Object objMo773getCurrentState;
        Object objMo773getCurrentState2;
        gapComposer.startRestartGroup(848986741);
        int i2 = i | (gapComposer.changed(modifier) ? 4 : 2) | (gapComposer.changed(mutableTransitionState) ? 32 : 16) | (gapComposer.changed(scrollState) ? 2048 : 1024) | (gapComposer.changed(shape) ? 16384 : 8192) | (gapComposer.changed(j) ? 131072 : 65536) | (gapComposer.changed(f) ? 1048576 : 524288) | (gapComposer.changed(f2) ? 8388608 : 4194304) | (gapComposer.changed((Object) null) ? 67108864 : 33554432) | (gapComposer.changedInstance(composableLambdaImpl) ? 536870912 : 268435456);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 306783379) != 306783378)) {
            Transition transitionRememberTransition = ArcSplineKt.rememberTransition(mutableTransitionState, "DropDownMenu", gapComposer, (((i2 >> 3) & 14) | 48) & 126);
            FiniteAnimationSpec finiteAnimationSpecValue = ScrimKt.value(2, gapComposer);
            FiniteAnimationSpec finiteAnimationSpecValue2 = ScrimKt.value(5, gapComposer);
            TwoWayConverterImpl twoWayConverterImpl = ArcSplineKt.FloatToVector;
            boolean zIsSeeking = transitionRememberTransition.isSeeking();
            Lifecycle lifecycle = transitionRememberTransition.transitionState;
            Object obj = Composer$Companion.Empty;
            if (zIsSeeking) {
                finiteAnimationSpecValue2 = finiteAnimationSpecValue2;
                gapComposer.startReplaceGroup(1666827533);
                gapComposer.end(false);
                objMo773getCurrentState = lifecycle.mo773getCurrentState();
            } else {
                gapComposer.startReplaceGroup(1666573488);
                boolean zChanged = gapComposer.changed(transitionRememberTransition);
                objMo773getCurrentState = gapComposer.rememberedValue();
                if (zChanged || objMo773getCurrentState == obj) {
                    Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                    Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                    Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
                    try {
                        Object objMo773getCurrentState3 = lifecycle.mo773getCurrentState();
                        SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        gapComposer.updateRememberedValue(objMo773getCurrentState3);
                        objMo773getCurrentState = objMo773getCurrentState3;
                    } catch (Throwable th) {
                        SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        throw th;
                    }
                }
                gapComposer.end(false);
            }
            boolean zBooleanValue = ((Boolean) objMo773getCurrentState).booleanValue();
            gapComposer.startReplaceGroup(143964305);
            float f3 = zBooleanValue ? 1.0f : 0.8f;
            gapComposer.end(false);
            Float fValueOf = Float.valueOf(f3);
            boolean zChanged2 = gapComposer.changed(transitionRememberTransition);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue == obj) {
                objRememberedValue = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, 7));
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            boolean zBooleanValue2 = ((Boolean) ((State) objRememberedValue).getValue()).booleanValue();
            gapComposer.startReplaceGroup(143964305);
            float f4 = zBooleanValue2 ? 1.0f : 0.8f;
            gapComposer.end(false);
            Float fValueOf2 = Float.valueOf(f4);
            boolean zChanged3 = gapComposer.changed(transitionRememberTransition);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged3 || objRememberedValue2 == obj) {
                objRememberedValue2 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, 8));
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.startReplaceGroup(-745957716);
            gapComposer.end(false);
            Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transitionRememberTransition, fValueOf, fValueOf2, finiteAnimationSpecValue, twoWayConverterImpl, gapComposer, 0);
            if (transitionRememberTransition.isSeeking()) {
                gapComposer.startReplaceGroup(1666827533);
                gapComposer.end(false);
                objMo773getCurrentState2 = lifecycle.mo773getCurrentState();
            } else {
                gapComposer.startReplaceGroup(1666573488);
                boolean zChanged4 = gapComposer.changed(transitionRememberTransition);
                objMo773getCurrentState2 = gapComposer.rememberedValue();
                if (zChanged4 || objMo773getCurrentState2 == obj) {
                    Snapshot currentThreadSnapshot2 = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                    Function1 readObserver2 = currentThreadSnapshot2 != null ? currentThreadSnapshot2.getReadObserver() : null;
                    Snapshot snapshotMakeCurrentNonObservable2 = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot2);
                    try {
                        Object objMo773getCurrentState4 = lifecycle.mo773getCurrentState();
                        SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                        gapComposer.updateRememberedValue(objMo773getCurrentState4);
                        objMo773getCurrentState2 = objMo773getCurrentState4;
                    } catch (Throwable th2) {
                        SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                        throw th2;
                    }
                }
                gapComposer.end(false);
            }
            boolean zBooleanValue3 = ((Boolean) objMo773getCurrentState2).booleanValue();
            gapComposer.startReplaceGroup(892761509);
            float f5 = zBooleanValue3 ? 1.0f : 0.0f;
            gapComposer.end(false);
            Float fValueOf3 = Float.valueOf(f5);
            boolean zChanged5 = gapComposer.changed(transitionRememberTransition);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged5 || objRememberedValue3 == obj) {
                objRememberedValue3 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, 9));
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            boolean zBooleanValue4 = ((Boolean) ((State) objRememberedValue3).getValue()).booleanValue();
            gapComposer.startReplaceGroup(892761509);
            float f6 = zBooleanValue4 ? 1.0f : 0.0f;
            gapComposer.end(false);
            Float fValueOf4 = Float.valueOf(f6);
            boolean zChanged6 = gapComposer.changed(transitionRememberTransition);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChanged6 || objRememberedValue4 == obj) {
                objRememberedValue4 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, 10));
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            gapComposer.startReplaceGroup(2839488);
            gapComposer.end(false);
            Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation2 = ArcSplineKt.createTransitionAnimation(transitionRememberTransition, fValueOf3, fValueOf4, finiteAnimationSpecValue2, twoWayConverterImpl, gapComposer, 0);
            boolean zBooleanValue5 = ((Boolean) gapComposer.consume(InspectionModeKt.LocalInspectionMode)).booleanValue();
            boolean zChanged7 = gapComposer.changed(zBooleanValue5) | gapComposer.changed(transitionAnimationStateCreateTransitionAnimation) | ((i2 & 112) == 32) | gapComposer.changed(transitionAnimationStateCreateTransitionAnimation2);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (zChanged7 || objRememberedValue5 == obj) {
                Object menuKt$$ExternalSyntheticLambda0 = new MenuKt$$ExternalSyntheticLambda0(zBooleanValue5, mutableTransitionState, mutableState, transitionAnimationStateCreateTransitionAnimation, transitionAnimationStateCreateTransitionAnimation2);
                gapComposer.updateRememberedValue(menuKt$$ExternalSyntheticLambda0);
                objRememberedValue5 = menuKt$$ExternalSyntheticLambda0;
            }
            int i3 = i2 >> 9;
            int i4 = i2 >> 6;
            SurfaceKt.m269SurfaceT9BRK9s(BrushKt.graphicsLayer(Modifier.Companion.$$INSTANCE, (Function1) objRememberedValue5), shape, j, 0L, f, f2, Thread_jvmKt.rememberComposableLambda(-1463404422, new MenuKt$$ExternalSyntheticLambda1(modifier, scrollState, composableLambdaImpl, 0), gapComposer), gapComposer, (i3 & 896) | (i3 & 112) | 12582912 | (57344 & i4) | (458752 & i4) | (i4 & 3670016), 8);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MenuKt$$ExternalSyntheticLambda2(modifier, mutableTransitionState, mutableState, scrollState, shape, j, f, f2, composableLambdaImpl, i);
        }
    }
}
