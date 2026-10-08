package androidx.compose.animation.core;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TargetBasedAnimation implements Animation {
    public long _durationNanos;
    public AnimationVector _endVelocity;
    public final VectorizedAnimationSpec animationSpec;
    public AnimationVector initialValueVector;
    public final AnimationVector initialVelocityVector;
    public Object mutableInitialValue;
    public Object mutableTargetValue;
    public AnimationVector targetValueVector;
    public final TwoWayConverterImpl typeConverter;

    public TargetBasedAnimation(AnimationSpec animationSpec, TwoWayConverterImpl twoWayConverterImpl, Object obj, Object obj2, AnimationVector animationVector) {
        this.animationSpec = animationSpec.vectorize(twoWayConverterImpl);
        this.typeConverter = twoWayConverterImpl;
        this.mutableTargetValue = obj2;
        this.mutableInitialValue = obj;
        this.initialValueVector = (AnimationVector) twoWayConverterImpl.convertToVector.invoke(obj);
        Function1 function1 = twoWayConverterImpl.convertToVector;
        this.targetValueVector = (AnimationVector) function1.invoke(obj2);
        this.initialVelocityVector = animationVector != null ? ArcSplineKt.copy(animationVector) : ((AnimationVector) function1.invoke(obj)).newVector$animation_core();
        this._durationNanos = -1L;
    }

    @Override // androidx.compose.animation.core.Animation
    public final long getDurationNanos() {
        if (this._durationNanos < 0) {
            this._durationNanos = this.animationSpec.getDurationNanos(this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
        }
        return this._durationNanos;
    }

    @Override // androidx.compose.animation.core.Animation
    public final Object getTargetValue() {
        return this.mutableTargetValue;
    }

    @Override // androidx.compose.animation.core.Animation
    public final TwoWayConverterImpl getTypeConverter() {
        return this.typeConverter;
    }

    @Override // androidx.compose.animation.core.Animation
    public final Object getValueFromNanos(long j) {
        if (ImageAnalysis$$ExternalSyntheticLambda1.$default$isFinishedFromNanos(this, j)) {
            return this.mutableTargetValue;
        }
        AnimationVector valueFromNanos = this.animationSpec.getValueFromNanos(j, this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
        int size$animation_core = valueFromNanos.getSize$animation_core();
        for (int i = 0; i < size$animation_core; i++) {
            if (Float.isNaN(valueFromNanos.get$animation_core(i))) {
                PreconditionsKt.throwIllegalStateException("AnimationVector cannot contain a NaN. " + valueFromNanos + ". Animation: " + this + ", playTimeNanos: " + j);
            }
        }
        return this.typeConverter.convertFromVector.invoke(valueFromNanos);
    }

    @Override // androidx.compose.animation.core.Animation
    public final AnimationVector getVelocityVectorFromNanos(long j) {
        if (!ImageAnalysis$$ExternalSyntheticLambda1.$default$isFinishedFromNanos(this, j)) {
            return this.animationSpec.getVelocityFromNanos(j, this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
        }
        AnimationVector animationVector = this._endVelocity;
        if (animationVector != null) {
            return animationVector;
        }
        AnimationVector endVelocity = this.animationSpec.getEndVelocity(this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
        this._endVelocity = endVelocity;
        return endVelocity;
    }

    @Override // androidx.compose.animation.core.Animation
    public final /* synthetic */ boolean isFinishedFromNanos(long j) {
        return ImageAnalysis$$ExternalSyntheticLambda1.$default$isFinishedFromNanos(this, j);
    }

    @Override // androidx.compose.animation.core.Animation
    public final boolean isInfinite() {
        return this.animationSpec.isInfinite();
    }

    public final void setMutableInitialValue$animation_core(Object obj) {
        if (Intrinsics.areEqual(obj, this.mutableInitialValue)) {
            return;
        }
        this.mutableInitialValue = obj;
        this.initialValueVector = (AnimationVector) this.typeConverter.convertToVector.invoke(obj);
        this._endVelocity = null;
        this._durationNanos = -1L;
    }

    public final void setMutableTargetValue$animation_core(Object obj) {
        if (Intrinsics.areEqual(this.mutableTargetValue, obj)) {
            return;
        }
        this.mutableTargetValue = obj;
        this.targetValueVector = (AnimationVector) this.typeConverter.convertToVector.invoke(obj);
        this._endVelocity = null;
        this._durationNanos = -1L;
    }

    public final String toString() {
        return "TargetBasedAnimation: " + this.mutableInitialValue + " -> " + this.mutableTargetValue + ",initial velocity: " + this.initialVelocityVector + ", duration: " + (getDurationNanos() / 1000000) + " ms,animationSpec: " + this.animationSpec;
    }
}
