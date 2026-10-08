package androidx.compose.animation.core;

import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.collection.MutableVector;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class InfiniteTransition {
    public final MutableVector _animations = new MutableVector(new TransitionAnimationState[16]);
    public final ParcelableSnapshotMutableState refreshChildNeeded$delegate = Stack.mutableStateOf$default(Boolean.FALSE);
    public long startTimeNanos = Long.MIN_VALUE;
    public final ParcelableSnapshotMutableState isRunning$delegate = Stack.mutableStateOf$default(Boolean.TRUE);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class TransitionAnimationState implements State {
        public TargetBasedAnimation animation;
        public Float initialValue;
        public boolean isFinished;
        public long playTimeNanosOffset;
        public boolean startOnTheNextFrame;
        public Float targetValue;
        public final /* synthetic */ InfiniteTransition this$0;
        public final ParcelableSnapshotMutableState value$delegate;

        public TransitionAnimationState(InfiniteTransition infiniteTransition, Float f, Float f2, InfiniteRepeatableSpec infiniteRepeatableSpec) {
            TwoWayConverterImpl twoWayConverterImpl = ArcSplineKt.FloatToVector;
            this.this$0 = infiniteTransition;
            this.initialValue = f;
            this.targetValue = f2;
            this.value$delegate = Stack.mutableStateOf$default(f);
            this.animation = new TargetBasedAnimation(infiniteRepeatableSpec, twoWayConverterImpl, this.initialValue, this.targetValue, null);
        }

        @Override // androidx.compose.runtime.State
        public final Object getValue() {
            return this.value$delegate.getValue();
        }
    }

    public final void run$animation_core(int i, GapComposer gapComposer) {
        gapComposer.startRestartGroup(-318043801);
        int i2 = (gapComposer.changedInstance(this) ? 4 : 2) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            Continuation continuation = null;
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            if (((Boolean) this.isRunning$delegate.getValue()).booleanValue() || ((Boolean) this.refreshChildNeeded$delegate.getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(-144841960);
                boolean zChangedInstance = gapComposer.changedInstance(this);
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new NavHostKt$NavHost$29$1(mutableState, this, continuation, 2);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                Stack.LaunchedEffect(gapComposer, this, (Function2) objRememberedValue2);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-143455237);
                gapComposer.end(false);
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Updater$$ExternalSyntheticLambda0(i, 1, this);
        }
    }
}
