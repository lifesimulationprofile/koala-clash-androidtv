package androidx.compose.animation.core;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DecayAnimation implements Animation {
    public final VectorizedFloatDecaySpec animationSpec;
    public final long durationNanos;
    public final AnimationVector endVelocity;
    public final Object initialValue;
    public final AnimationVector initialValueVector;
    public final AnimationVector initialVelocityVector;
    public final Object targetValue;
    public final TwoWayConverterImpl typeConverter;

    public DecayAnimation(DecayAnimationSpecImpl decayAnimationSpecImpl, TwoWayConverterImpl twoWayConverterImpl, Object obj, AnimationVector animationVector) {
        VectorizedFloatDecaySpec vectorizedFloatDecaySpec = new VectorizedFloatDecaySpec(decayAnimationSpecImpl.floatDecaySpec);
        this.animationSpec = vectorizedFloatDecaySpec;
        this.typeConverter = twoWayConverterImpl;
        this.initialValue = obj;
        AnimationVector animationVector2 = (AnimationVector) twoWayConverterImpl.convertToVector.invoke(obj);
        this.initialValueVector = animationVector2;
        this.initialVelocityVector = ArcSplineKt.copy(animationVector);
        Function1 function1 = twoWayConverterImpl.convertFromVector;
        if (vectorizedFloatDecaySpec.targetVector == null) {
            vectorizedFloatDecaySpec.targetVector = animationVector2.newVector$animation_core();
        }
        AnimationVector animationVector3 = vectorizedFloatDecaySpec.targetVector;
        if (animationVector3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("targetVector");
            throw null;
        }
        int size$animation_core = animationVector3.getSize$animation_core();
        for (int i = 0; i < size$animation_core; i++) {
            AnimationVector animationVector4 = vectorizedFloatDecaySpec.targetVector;
            if (animationVector4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("targetVector");
                throw null;
            }
            animationVector4.set$animation_core(i, vectorizedFloatDecaySpec.floatDecaySpec.getTargetValue(animationVector2.get$animation_core(i), animationVector.get$animation_core(i)));
        }
        AnimationVector animationVector5 = vectorizedFloatDecaySpec.targetVector;
        if (animationVector5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("targetVector");
            throw null;
        }
        this.targetValue = function1.invoke(animationVector5);
        if (vectorizedFloatDecaySpec.velocityVector == null) {
            vectorizedFloatDecaySpec.velocityVector = animationVector2.newVector$animation_core();
        }
        AnimationVector animationVector6 = vectorizedFloatDecaySpec.velocityVector;
        if (animationVector6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            throw null;
        }
        int size$animation_core2 = animationVector6.getSize$animation_core();
        long jMax = 0;
        for (int i2 = 0; i2 < size$animation_core2; i2++) {
            animationVector2.getClass();
            jMax = Math.max(jMax, vectorizedFloatDecaySpec.floatDecaySpec.getDurationNanos(animationVector.get$animation_core(i2)));
        }
        this.durationNanos = jMax;
        AnimationVector animationVectorCopy = ArcSplineKt.copy(this.animationSpec.getVelocityFromNanos(jMax, this.initialValueVector, animationVector));
        this.endVelocity = animationVectorCopy;
        int size$animation_core3 = animationVectorCopy.getSize$animation_core();
        for (int i3 = 0; i3 < size$animation_core3; i3++) {
            AnimationVector animationVector7 = this.endVelocity;
            float f = animationVector7.get$animation_core(i3);
            float f2 = this.animationSpec.absVelocityThreshold;
            animationVector7.set$animation_core(i3, RangesKt.coerceIn(f, -f2, f2));
        }
    }

    @Override // androidx.compose.animation.core.Animation
    public final long getDurationNanos() {
        return this.durationNanos;
    }

    @Override // androidx.compose.animation.core.Animation
    public final Object getTargetValue() {
        return this.targetValue;
    }

    @Override // androidx.compose.animation.core.Animation
    public final TwoWayConverterImpl getTypeConverter() {
        return this.typeConverter;
    }

    @Override // androidx.compose.animation.core.Animation
    public final Object getValueFromNanos(long j) {
        if (ImageAnalysis$$ExternalSyntheticLambda1.$default$isFinishedFromNanos(this, j)) {
            return this.targetValue;
        }
        Function1 function1 = this.typeConverter.convertFromVector;
        VectorizedFloatDecaySpec vectorizedFloatDecaySpec = this.animationSpec;
        AnimationVector animationVector = vectorizedFloatDecaySpec.valueVector;
        AnimationVector animationVector2 = this.initialValueVector;
        if (animationVector == null) {
            vectorizedFloatDecaySpec.valueVector = animationVector2.newVector$animation_core();
        }
        AnimationVector animationVector3 = vectorizedFloatDecaySpec.valueVector;
        if (animationVector3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            throw null;
        }
        int size$animation_core = animationVector3.getSize$animation_core();
        for (int i = 0; i < size$animation_core; i++) {
            AnimationVector animationVector4 = vectorizedFloatDecaySpec.valueVector;
            if (animationVector4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                throw null;
            }
            animationVector4.set$animation_core(i, vectorizedFloatDecaySpec.floatDecaySpec.getValueFromNanos(animationVector2.get$animation_core(i), this.initialVelocityVector.get$animation_core(i), j));
        }
        AnimationVector animationVector5 = vectorizedFloatDecaySpec.valueVector;
        if (animationVector5 != null) {
            return function1.invoke(animationVector5);
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        throw null;
    }

    @Override // androidx.compose.animation.core.Animation
    public final AnimationVector getVelocityVectorFromNanos(long j) {
        if (ImageAnalysis$$ExternalSyntheticLambda1.$default$isFinishedFromNanos(this, j)) {
            return this.endVelocity;
        }
        return this.animationSpec.getVelocityFromNanos(j, this.initialValueVector, this.initialVelocityVector);
    }

    @Override // androidx.compose.animation.core.Animation
    public final /* synthetic */ boolean isFinishedFromNanos(long j) {
        return ImageAnalysis$$ExternalSyntheticLambda1.$default$isFinishedFromNanos(this, j);
    }

    @Override // androidx.compose.animation.core.Animation
    public final boolean isInfinite() {
        return false;
    }
}
