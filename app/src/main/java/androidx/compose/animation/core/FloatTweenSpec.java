package androidx.compose.animation.core;

import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FloatTweenSpec implements FloatAnimationSpec {
    public final long delayNanos;
    public final int duration;
    public final long durationNanos;
    public final Easing easing;

    public FloatTweenSpec(int i, int i2, Easing easing) {
        this.duration = i;
        this.easing = easing;
        this.durationNanos = ((long) i) * 1000000;
        this.delayNanos = ((long) i2) * 1000000;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final long getDurationNanos(float f, float f2, float f3) {
        return this.delayNanos + this.durationNanos;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final float getEndVelocity(float f, float f2, float f3) {
        return getVelocityFromNanos(getDurationNanos(f, f2, f3), f, f2, f3);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final float getValueFromNanos(long j, float f, float f2, float f3) {
        long j2 = j - this.delayNanos;
        if (j2 < 0) {
            j2 = 0;
        }
        long j3 = this.durationNanos;
        if (j2 > j3) {
            j2 = j3;
        }
        float fTransform = this.easing.transform(this.duration == 0 ? 1.0f : j2 / j3);
        return (f2 * fTransform) + ((1 - fTransform) * f);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final float getVelocityFromNanos(long j, float f, float f2, float f3) {
        long j2 = j - this.delayNanos;
        if (j2 < 0) {
            j2 = 0;
        }
        long j3 = this.durationNanos;
        long j4 = j2 > j3 ? j3 : j2;
        if (j4 == 0) {
            return f3;
        }
        return (getValueFromNanos(j4, f, f2, f3) - getValueFromNanos(j4 - 1000000, f, f2, f3)) * 1000.0f;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public final VectorizedAnimationSpec vectorize(TwoWayConverterImpl twoWayConverterImpl) {
        return new Dispatcher(this);
    }
}
