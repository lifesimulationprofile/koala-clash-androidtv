package androidx.compose.animation.core;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationState implements State {
    public long finishedTimeNanos;
    public boolean isRunning;
    public long lastFrameTimeNanos;
    public final TwoWayConverterImpl typeConverter;
    public final ParcelableSnapshotMutableState value$delegate;
    public AnimationVector velocityVector;

    public /* synthetic */ AnimationState(TwoWayConverterImpl twoWayConverterImpl, Object obj, AnimationVector animationVector, int i) {
        this(twoWayConverterImpl, obj, (i & 4) != 0 ? null : animationVector, Long.MIN_VALUE, Long.MIN_VALUE, false);
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        return this.value$delegate.getValue();
    }

    public final Object getVelocity() {
        return this.typeConverter.convertFromVector.invoke(this.velocityVector);
    }

    public final String toString() {
        return "AnimationState(value=" + this.value$delegate.getValue() + ", velocity=" + getVelocity() + ", isRunning=" + this.isRunning + ", lastFrameTimeNanos=" + this.lastFrameTimeNanos + ", finishedTimeNanos=" + this.finishedTimeNanos + ')';
    }

    public AnimationState(TwoWayConverterImpl twoWayConverterImpl, Object obj, AnimationVector animationVector, long j, long j2, boolean z) {
        AnimationVector animationVectorCopy;
        this.typeConverter = twoWayConverterImpl;
        this.value$delegate = Stack.mutableStateOf$default(obj);
        if (animationVector != null) {
            animationVectorCopy = ArcSplineKt.copy(animationVector);
        } else {
            animationVectorCopy = (AnimationVector) twoWayConverterImpl.convertToVector.invoke(obj);
            animationVectorCopy.reset$animation_core();
        }
        this.velocityVector = animationVectorCopy;
        this.lastFrameTimeNanos = j;
        this.finishedTimeNanos = j2;
        this.isRunning = z;
    }
}
