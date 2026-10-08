package androidx.compose.animation.core;

import android.os.SystemClock;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class VectorizedInfiniteRepeatableSpec implements VectorizedAnimationSpec {
    public final Object animation;
    public final long durationNanos;
    public long initialOffsetNanos;

    public VectorizedInfiniteRepeatableSpec(VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, long j) {
        this.animation = vectorizedDurationBasedAnimationSpec;
        this.durationNanos = ((long) (vectorizedDurationBasedAnimationSpec.getDurationMillis() + vectorizedDurationBasedAnimationSpec.getDelayMillis())) * 1000000;
        this.initialOffsetNanos = j * 1000000;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return Long.MAX_VALUE;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getEndVelocity(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return getVelocityFromNanos(Long.MAX_VALUE, animationVector, animationVector2, animationVector3);
    }

    public int getReopenDelayMs() {
        if (!((Camera2CameraImpl.StateCallback) this.animation).shouldActiveResume()) {
            return 700;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.initialOffsetNanos == -1) {
            this.initialOffsetNanos = jUptimeMillis;
        }
        long j = jUptimeMillis - this.initialOffsetNanos;
        if (j <= 120000) {
            return 1000;
        }
        return j <= 300000 ? 2000 : 4000;
    }

    public int getReopenLimitMs() {
        boolean zShouldActiveResume = ((Camera2CameraImpl.StateCallback) this.animation).shouldActiveResume();
        long j = this.durationNanos;
        if (!zShouldActiveResume) {
            return j > 0 ? Math.min((int) j, ModuleDescriptor.MODULE_VERSION) : ModuleDescriptor.MODULE_VERSION;
        }
        if (j > 0) {
            return Math.min((int) j, 1800000);
        }
        return 1800000;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getValueFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return ((VectorizedDurationBasedAnimationSpec) this.animation).getValueFromNanos(repetitionPlayTimeNanos(j), animationVector, animationVector2, repetitionStartVelocity(j, animationVector, animationVector3, animationVector2));
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getVelocityFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return ((VectorizedDurationBasedAnimationSpec) this.animation).getVelocityFromNanos(repetitionPlayTimeNanos(j), animationVector, animationVector2, repetitionStartVelocity(j, animationVector, animationVector3, animationVector2));
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public boolean isInfinite() {
        return true;
    }

    public long repetitionPlayTimeNanos(long j) {
        long j2 = j + this.initialOffsetNanos;
        if (j2 <= 0) {
            return 0L;
        }
        long j3 = this.durationNanos;
        return j2 - ((j2 / j3) * j3);
    }

    public AnimationVector repetitionStartVelocity(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        long j2 = this.initialOffsetNanos;
        long j3 = j + j2;
        long j4 = this.durationNanos;
        return j3 > j4 ? ((VectorizedDurationBasedAnimationSpec) this.animation).getVelocityFromNanos(j4 - j2, animationVector, animationVector3, animationVector2) : animationVector2;
    }

    public VectorizedInfiniteRepeatableSpec(Camera2CameraImpl.StateCallback stateCallback, long j) {
        this.animation = stateCallback;
        this.initialOffsetNanos = -1L;
        this.durationNanos = j;
    }
}
