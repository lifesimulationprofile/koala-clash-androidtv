package androidx.compose.animation;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.core.FloatDecayAnimationSpec;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FlingCalculator implements FloatDecayAnimationSpec {
    public float friction;
    public float magicPhysicalCoefficient;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class FlingInfo {
        public final float distance;
        public final long duration;
        public final float initialVelocity;

        public FlingInfo(float f, float f2, long j) {
            this.initialVelocity = f;
            this.distance = f2;
            this.duration = j;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FlingInfo)) {
                return false;
            }
            FlingInfo flingInfo = (FlingInfo) obj;
            return Float.compare(this.initialVelocity, flingInfo.initialVelocity) == 0 && Float.compare(this.distance, flingInfo.distance) == 0 && this.duration == flingInfo.duration;
        }

        public final int hashCode() {
            int iM = ImageAnalysis$$ExternalSyntheticLambda1.m(this.distance, Float.floatToIntBits(this.initialVelocity) * 31, 31);
            long j = this.duration;
            return iM + ((int) (j ^ (j >>> 32)));
        }

        public final String toString() {
            return "FlingInfo(initialVelocity=" + this.initialVelocity + ", distance=" + this.distance + ", duration=" + this.duration + ')';
        }
    }

    public FlingInfo flingInfo(float f) {
        double splineDeceleration = getSplineDeceleration(f);
        double d = FlingCalculatorKt.DecelerationRate;
        double d2 = d - 1.0d;
        return new FlingInfo(f, (float) (Math.exp((d / d2) * splineDeceleration) * ((double) (this.friction * this.magicPhysicalCoefficient))), (long) (Math.exp(splineDeceleration / d2) * 1000.0d));
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getAbsVelocityThreshold() {
        return this.friction;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public long getDurationNanos(float f) {
        return ((long) ((((float) Math.log(this.friction / Math.abs(f))) * 1000.0f) / this.magicPhysicalCoefficient)) * 1000000;
    }

    public double getSplineDeceleration(float f) {
        float[] fArr = AndroidFlingSpline.SplinePositions;
        return Math.log(((double) (Math.abs(f) * 0.35f)) / ((double) (this.friction * this.magicPhysicalCoefficient)));
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getTargetValue(float f, float f2) {
        float fAbs = Math.abs(f2);
        float f3 = this.friction;
        if (fAbs <= f3) {
            return f;
        }
        double dLog = Math.log(Math.abs(f3 / f2));
        float f4 = this.magicPhysicalCoefficient;
        return ((f2 / f4) * ((float) Math.exp((((double) f4) * ((dLog / ((double) f4)) * ((double) 1000))) / ((double) 1000.0f)))) + (f - (f2 / f4));
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getValueFromNanos(float f, float f2, long j) {
        float f3 = this.magicPhysicalCoefficient;
        return ((f2 / f3) * ((float) Math.exp((f3 * (j / 1000000)) / 1000.0f))) + (f - (f2 / f3));
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getVelocityFromNanos(float f, long j) {
        return f * ((float) Math.exp(((j / 1000000) / 1000.0f) * this.magicPhysicalCoefficient));
    }
}
