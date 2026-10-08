package androidx.compose.animation.core;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Animatable {
    public final SpringSpec defaultSpringSpec;
    public final AnimationState internalState;
    public final ParcelableSnapshotMutableState isRunning$delegate;
    public final AnimationVector lowerBoundVector;
    public final MutatorMutex mutatorMutex;
    public final AnimationVector negativeInfinityBounds;
    public final AnimationVector positiveInfinityBounds;
    public final ParcelableSnapshotMutableState targetValue$delegate;
    public final TwoWayConverterImpl typeConverter;
    public final AnimationVector upperBoundVector;
    public final Object visibilityThreshold;

    /* JADX INFO: renamed from: androidx.compose.animation.core.Animatable$snapTo$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 extends SuspendLambda implements Function1 {
        public final /* synthetic */ Object $targetValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Object obj, Continuation continuation) {
            super(1, continuation);
            this.$targetValue = obj;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return Animatable.this.new AnonymousClass2(this.$targetValue, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ResultKt.throwOnFailure(obj);
            Animatable animatable = Animatable.this;
            Animatable.access$endAnimation(animatable);
            Object objAccess$clampToBounds = Animatable.access$clampToBounds(animatable, this.$targetValue);
            animatable.internalState.value$delegate.setValue(objAccess$clampToBounds);
            animatable.targetValue$delegate.setValue(objAccess$clampToBounds);
            return Unit.INSTANCE;
        }
    }

    public Animatable(Object obj, TwoWayConverterImpl twoWayConverterImpl, Object obj2) {
        this.typeConverter = twoWayConverterImpl;
        this.visibilityThreshold = obj2;
        AnimationState animationState = new AnimationState(twoWayConverterImpl, obj, null, 60);
        this.internalState = animationState;
        this.isRunning$delegate = Stack.mutableStateOf$default(Boolean.FALSE);
        this.targetValue$delegate = Stack.mutableStateOf$default(obj);
        this.mutatorMutex = new MutatorMutex();
        this.defaultSpringSpec = new SpringSpec(obj2);
        AnimationVector animationVector = animationState.velocityVector;
        boolean z = animationVector instanceof AnimationVector1D;
        AnimationVector animationVector2 = z ? ArcSplineKt.negativeInfinityBounds1D : animationVector instanceof AnimationVector2D ? ArcSplineKt.negativeInfinityBounds2D : animationVector instanceof AnimationVector3D ? ArcSplineKt.negativeInfinityBounds3D : ArcSplineKt.negativeInfinityBounds4D;
        this.negativeInfinityBounds = animationVector2;
        AnimationVector animationVector3 = z ? ArcSplineKt.positiveInfinityBounds1D : animationVector instanceof AnimationVector2D ? ArcSplineKt.positiveInfinityBounds2D : animationVector instanceof AnimationVector3D ? ArcSplineKt.positiveInfinityBounds3D : ArcSplineKt.positiveInfinityBounds4D;
        this.positiveInfinityBounds = animationVector3;
        this.lowerBoundVector = animationVector2;
        this.upperBoundVector = animationVector3;
    }

    public static final Object access$clampToBounds(Animatable animatable, Object obj) {
        TwoWayConverterImpl twoWayConverterImpl = animatable.typeConverter;
        AnimationVector animationVector = animatable.upperBoundVector;
        AnimationVector animationVector2 = animatable.lowerBoundVector;
        if (!Intrinsics.areEqual(animationVector2, animatable.negativeInfinityBounds) || !Intrinsics.areEqual(animationVector, animatable.positiveInfinityBounds)) {
            AnimationVector animationVector3 = (AnimationVector) twoWayConverterImpl.convertToVector.invoke(obj);
            int size$animation_core = animationVector3.getSize$animation_core();
            boolean z = false;
            for (int i = 0; i < size$animation_core; i++) {
                if (animationVector3.get$animation_core(i) < animationVector2.get$animation_core(i) || animationVector3.get$animation_core(i) > animationVector.get$animation_core(i)) {
                    animationVector3.set$animation_core(i, RangesKt.coerceIn(animationVector3.get$animation_core(i), animationVector2.get$animation_core(i), animationVector.get$animation_core(i)));
                    z = true;
                }
            }
            if (z) {
                return twoWayConverterImpl.convertFromVector.invoke(animationVector3);
            }
        }
        return obj;
    }

    public static final void access$endAnimation(Animatable animatable) {
        AnimationState animationState = animatable.internalState;
        animationState.velocityVector.reset$animation_core();
        animationState.lastFrameTimeNanos = Long.MIN_VALUE;
        animatable.isRunning$delegate.setValue(Boolean.FALSE);
    }

    public static Object animateTo$default(Animatable animatable, Object obj, AnimationSpec animationSpec, Function1 function1, Continuation continuation, int i) {
        if ((i & 2) != 0) {
            animationSpec = animatable.defaultSpringSpec;
        }
        AnimationSpec animationSpec2 = animationSpec;
        Object objInvoke = animatable.typeConverter.convertFromVector.invoke(animatable.internalState.velocityVector);
        if ((i & 8) != 0) {
            function1 = null;
        }
        Function1 function2 = function1;
        Object value = animatable.getValue();
        TwoWayConverterImpl twoWayConverterImpl = animatable.typeConverter;
        return MutatorMutex.mutate$default(animatable.mutatorMutex, new Animatable$runAnimation$2(animatable, objInvoke, new TargetBasedAnimation(animationSpec2, twoWayConverterImpl, value, obj, (AnimationVector) twoWayConverterImpl.convertToVector.invoke(objInvoke)), animatable.internalState.lastFrameTimeNanos, function2, null), continuation);
    }

    public final Object getValue() {
        return this.internalState.value$delegate.getValue();
    }

    public final Object snapTo(Object obj, Continuation continuation) {
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, new AnonymousClass2(obj, null), continuation);
        return objMutate$default == CoroutineSingletons.COROUTINE_SUSPENDED ? objMutate$default : Unit.INSTANCE;
    }

    public /* synthetic */ Animatable(Object obj, TwoWayConverterImpl twoWayConverterImpl, Object obj2, int i) {
        this(obj, twoWayConverterImpl, (i & 4) != 0 ? null : obj2);
    }
}
