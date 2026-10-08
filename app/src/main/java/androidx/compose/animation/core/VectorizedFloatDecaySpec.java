package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class VectorizedFloatDecaySpec {
    public final float absVelocityThreshold;
    public final FloatDecayAnimationSpec floatDecaySpec;
    public AnimationVector targetVector;
    public AnimationVector valueVector;
    public AnimationVector velocityVector;

    public VectorizedFloatDecaySpec(FloatDecayAnimationSpec floatDecayAnimationSpec) {
        this.floatDecaySpec = floatDecayAnimationSpec;
        this.absVelocityThreshold = floatDecayAnimationSpec.getAbsVelocityThreshold();
    }

    public final AnimationVector getVelocityFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2) {
        if (this.velocityVector == null) {
            this.velocityVector = animationVector.newVector$animation_core();
        }
        AnimationVector animationVector3 = this.velocityVector;
        if (animationVector3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            throw null;
        }
        int size$animation_core = animationVector3.getSize$animation_core();
        for (int i = 0; i < size$animation_core; i++) {
            AnimationVector animationVector4 = this.velocityVector;
            if (animationVector4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                throw null;
            }
            animationVector.getClass();
            animationVector4.set$animation_core(i, this.floatDecaySpec.getVelocityFromNanos(animationVector2.get$animation_core(i), j));
        }
        AnimationVector animationVector5 = this.velocityVector;
        if (animationVector5 != null) {
            return animationVector5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        throw null;
    }
}
