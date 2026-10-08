package androidx.compose.animation.core;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class InfiniteRepeatableSpec implements AnimationSpec {
    public final DurationBasedAnimationSpec animation;
    public final long initialStartOffset;

    public InfiniteRepeatableSpec(DurationBasedAnimationSpec durationBasedAnimationSpec, long j) {
        this.animation = durationBasedAnimationSpec;
        this.initialStartOffset = j;
        if (durationBasedAnimationSpec instanceof TweenSpec) {
            TweenSpec tweenSpec = (TweenSpec) durationBasedAnimationSpec;
            if (tweenSpec.durationMillis != 0 || tweenSpec.delay != 0) {
                return;
            }
        } else if (durationBasedAnimationSpec instanceof SnapSpec) {
            if (((SnapSpec) durationBasedAnimationSpec).delay != 0) {
                return;
            }
        } else if (!(durationBasedAnimationSpec instanceof KeyframesSpec) || ((KeyframesSpec) durationBasedAnimationSpec).config.durationMillis != 0) {
            return;
        }
        throw new IllegalArgumentException("Animation to be infinitely repeated cannot have a 0-duration");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof InfiniteRepeatableSpec)) {
            return false;
        }
        InfiniteRepeatableSpec infiniteRepeatableSpec = (InfiniteRepeatableSpec) obj;
        return infiniteRepeatableSpec.animation.equals(this.animation) && infiniteRepeatableSpec.initialStartOffset == this.initialStartOffset;
    }

    public final int hashCode() {
        int iM = ImageAnalysis$$ExternalSyntheticLambda1.m(1, this.animation.hashCode() * 31, 31);
        long j = this.initialStartOffset;
        return iM + ((int) (j ^ (j >>> 32)));
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public final VectorizedAnimationSpec vectorize(TwoWayConverterImpl twoWayConverterImpl) {
        return new VectorizedInfiniteRepeatableSpec(this.animation.vectorize(twoWayConverterImpl), this.initialStartOffset);
    }
}
