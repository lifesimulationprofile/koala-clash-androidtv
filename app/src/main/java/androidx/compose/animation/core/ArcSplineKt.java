package androidx.compose.animation.core;

import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.compose.animation.FlingCalculator;
import androidx.compose.animation.core.Transition.DeferredAnimation;
import androidx.compose.animation.core.Transition.TransitionAnimationState;
import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.BottomSheetKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda5;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.MotionDurationScale;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ArcSplineKt {
    public static final AnimationVector1D positiveInfinityBounds1D = new AnimationVector1D(Float.POSITIVE_INFINITY);
    public static final AnimationVector2D positiveInfinityBounds2D = new AnimationVector2D(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    public static final AnimationVector3D positiveInfinityBounds3D = new AnimationVector3D(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    public static final AnimationVector4D positiveInfinityBounds4D = new AnimationVector4D(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    public static final AnimationVector1D negativeInfinityBounds1D = new AnimationVector1D(Float.NEGATIVE_INFINITY);
    public static final AnimationVector2D negativeInfinityBounds2D = new AnimationVector2D(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    public static final AnimationVector3D negativeInfinityBounds3D = new AnimationVector3D(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    public static final AnimationVector4D negativeInfinityBounds4D = new AnimationVector4D(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    public static final float[] OurPercentCache = new float[91];
    public static final BorderKt$$ExternalSyntheticLambda1 SeekableTransitionStateTotalDurationChanged = new BorderKt$$ExternalSyntheticLambda1(2);
    public static final TwoWayConverterImpl FloatToVector = new TwoWayConverterImpl(new BorderKt$$ExternalSyntheticLambda1(3), new BorderKt$$ExternalSyntheticLambda1(20));
    public static final TwoWayConverterImpl IntToVector = new TwoWayConverterImpl(new BorderKt$$ExternalSyntheticLambda1(4), new BorderKt$$ExternalSyntheticLambda1(5));
    public static final TwoWayConverterImpl DpToVector = new TwoWayConverterImpl(new BorderKt$$ExternalSyntheticLambda1(6), new BorderKt$$ExternalSyntheticLambda1(7));
    public static final TwoWayConverterImpl DpOffsetToVector = new TwoWayConverterImpl(new BorderKt$$ExternalSyntheticLambda1(8), new BorderKt$$ExternalSyntheticLambda1(9));
    public static final TwoWayConverterImpl SizeToVector = new TwoWayConverterImpl(new BorderKt$$ExternalSyntheticLambda1(10), new BorderKt$$ExternalSyntheticLambda1(11));
    public static final TwoWayConverterImpl OffsetToVector = new TwoWayConverterImpl(new BorderKt$$ExternalSyntheticLambda1(12), new BorderKt$$ExternalSyntheticLambda1(13));
    public static final TwoWayConverterImpl IntOffsetToVector = new TwoWayConverterImpl(new BorderKt$$ExternalSyntheticLambda1(14), new BorderKt$$ExternalSyntheticLambda1(15));
    public static final TwoWayConverterImpl IntSizeToVector = new TwoWayConverterImpl(new BorderKt$$ExternalSyntheticLambda1(16), new BorderKt$$ExternalSyntheticLambda1(17));
    public static final TwoWayConverterImpl RectToVector = new TwoWayConverterImpl(new BorderKt$$ExternalSyntheticLambda1(18), new BorderKt$$ExternalSyntheticLambda1(19));

    public static Animatable Animatable$default(float f) {
        return new Animatable(Float.valueOf(f), FloatToVector, Float.valueOf(0.01f), 8);
    }

    public static AnimationState AnimationState$default(float f, float f2, int i) {
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        return new AnimationState(FloatToVector, Float.valueOf(f), new AnimationVector1D(f2), Long.MIN_VALUE, Long.MIN_VALUE, false);
    }

    public static final void UpdateInitialAndTargetValues(Transition transition, Transition.TransitionAnimationState transitionAnimationState, Object obj, Object obj2, FiniteAnimationSpec finiteAnimationSpec, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(867041821);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(transition) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(transitionAnimationState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? gapComposer.changed(obj) : gapComposer.changedInstance(obj) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= (i & 4096) == 0 ? gapComposer.changed(obj2) : gapComposer.changedInstance(obj2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= (32768 & i) == 0 ? gapComposer.changed(finiteAnimationSpec) : gapComposer.changedInstance(finiteAnimationSpec) ? 16384 : 8192;
        }
        if (!gapComposer.shouldExecute(i2 & 1, (i2 & 9363) != 9362)) {
            gapComposer.skipToGroupEnd();
        } else if (transition.isSeeking()) {
            transitionAnimationState.updateInitialAndTargetValue$animation_core(obj, obj2, finiteAnimationSpec);
        } else {
            transitionAnimationState.updateTargetValue$animation_core(obj2, finiteAnimationSpec);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MaterialThemeKt$$ExternalSyntheticLambda5(transition, transitionAnimationState, obj, obj2, finiteAnimationSpec, i, 1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0117 A[Catch: CancellationException -> 0x0180, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x0180, blocks: (B:50:0x0105, B:52:0x0117), top: B:83:0x0105 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0148 A[Catch: CancellationException -> 0x003d, TryCatch #2 {CancellationException -> 0x003d, blocks: (B:14:0x0038, B:56:0x0138, B:58:0x0148, B:60:0x0152, B:61:0x015f, B:62:0x0164, B:63:0x0165), top: B:87:0x0038 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0152 A[Catch: CancellationException -> 0x003d, TryCatch #2 {CancellationException -> 0x003d, blocks: (B:14:0x0038, B:56:0x0138, B:58:0x0148, B:60:0x0152, B:61:0x015f, B:62:0x0164, B:63:0x0165), top: B:87:0x0038 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x015f A[Catch: CancellationException -> 0x003d, TryCatch #2 {CancellationException -> 0x003d, blocks: (B:14:0x0038, B:56:0x0138, B:58:0x0148, B:60:0x0152, B:61:0x015f, B:62:0x0164, B:63:0x0165), top: B:87:0x0038 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0165 A[Catch: CancellationException -> 0x003d, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x003d, blocks: (B:14:0x0038, B:56:0x0138, B:58:0x0148, B:60:0x0152, B:61:0x015f, B:62:0x0164, B:63:0x0165), top: B:87:0x0038 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public static final java.lang.Object animate(androidx.compose.animation.core.AnimationState r23, androidx.compose.animation.core.Animation r24, long r25, final kotlin.jvm.functions.Function1 r27, kotlin.coroutines.jvm.internal.ContinuationImpl r28) {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.ArcSplineKt.animate(androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.Animation, long, kotlin.jvm.functions.Function1, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final Object animateDecay(AnimationState animationState, DecayAnimationSpecImpl decayAnimationSpecImpl, boolean z, Function1 function1, ContinuationImpl continuationImpl) {
        Object objAnimate = animate(animationState, new DecayAnimation(decayAnimationSpecImpl, animationState.typeConverter, animationState.value$delegate.getValue(), animationState.velocityVector), z ? animationState.lastFrameTimeNanos : Long.MIN_VALUE, function1, continuationImpl);
        return objAnimate == CoroutineSingletons.COROUTINE_SUSPENDED ? objAnimate : Unit.INSTANCE;
    }

    public static final InfiniteTransition.TransitionAnimationState animateFloat(InfiniteTransition infiniteTransition, float f, float f2, InfiniteRepeatableSpec infiniteRepeatableSpec, GapComposer gapComposer) {
        Float fValueOf = Float.valueOf(f);
        Float fValueOf2 = Float.valueOf(f2);
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
        if (objRememberedValue == neverEqualPolicy) {
            objRememberedValue = new InfiniteTransition.TransitionAnimationState(infiniteTransition, fValueOf, fValueOf2, infiniteRepeatableSpec);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        InfiniteTransition.TransitionAnimationState transitionAnimationState = (InfiniteTransition.TransitionAnimationState) objRememberedValue;
        boolean zChangedInstance = gapComposer.changedInstance(infiniteRepeatableSpec);
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = new BottomSheetKt$$ExternalSyntheticLambda1(fValueOf, transitionAnimationState, fValueOf2, infiniteRepeatableSpec, 1);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        Stack.SideEffect((Function0) objRememberedValue2, gapComposer);
        boolean zChangedInstance2 = gapComposer.changedInstance(infiniteTransition);
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
            objRememberedValue3 = new BackHandlerKt$$ExternalSyntheticLambda2(2, infiniteTransition, transitionAnimationState);
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        Stack.DisposableEffect(transitionAnimationState, (Function1) objRememberedValue3, gapComposer);
        return transitionAnimationState;
    }

    public static final Object animateTo(AnimationState animationState, Float f, AnimationSpec animationSpec, boolean z, Function1 function1, ContinuationImpl continuationImpl) {
        Object objAnimate = animate(animationState, new TargetBasedAnimation(animationSpec, animationState.typeConverter, animationState.value$delegate.getValue(), f, animationState.velocityVector), z ? animationState.lastFrameTimeNanos : Long.MIN_VALUE, function1, continuationImpl);
        return objAnimate == CoroutineSingletons.COROUTINE_SUSPENDED ? objAnimate : Unit.INSTANCE;
    }

    public static final float calculateTargetValue(DecayAnimationSpecImpl decayAnimationSpecImpl, float f, float f2) {
        FloatDecayAnimationSpec floatDecayAnimationSpec = decayAnimationSpecImpl.floatDecaySpec;
        AnimationVector1D animationVector1D = new AnimationVector1D(0.0f);
        int size$animation_core = animationVector1D.getSize$animation_core();
        int i = 0;
        while (i < size$animation_core) {
            animationVector1D.set$animation_core(i, floatDecayAnimationSpec.getTargetValue(i == 0 ? f : 0.0f, i == 0 ? f2 : 0.0f));
            i++;
        }
        return animationVector1D.value;
    }

    public static final AnimationVector copy(AnimationVector animationVector) {
        AnimationVector animationVectorNewVector$animation_core = animationVector.newVector$animation_core();
        int size$animation_core = animationVectorNewVector$animation_core.getSize$animation_core();
        for (int i = 0; i < size$animation_core; i++) {
            animationVectorNewVector$animation_core.set$animation_core(i, animationVector.get$animation_core(i));
        }
        return animationVectorNewVector$animation_core;
    }

    public static AnimationState copy$default(AnimationState animationState, float f, float f2, int i) {
        if ((i & 1) != 0) {
            f = ((Number) animationState.value$delegate.getValue()).floatValue();
        }
        if ((i & 2) != 0) {
            f2 = ((AnimationVector1D) animationState.velocityVector).value;
        }
        return new AnimationState(animationState.typeConverter, Float.valueOf(f), new AnimationVector1D(f2), animationState.lastFrameTimeNanos, animationState.finishedTimeNanos, animationState.isRunning);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r5v5, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    public static final Transition.DeferredAnimation createDeferredAnimation(Transition transition, TwoWayConverterImpl twoWayConverterImpl, String str, GapComposer gapComposer, int i, int i2) {
        Transition.DeferredAnimation.DeferredAnimationData deferredAnimationData;
        if ((i2 & 2) != 0) {
            str = "DeferredAnimation";
        }
        boolean zChanged = gapComposer.changed(transition);
        Object objRememberedValue = gapComposer.rememberedValue();
        Object obj = Composer$Companion.Empty;
        if (zChanged || objRememberedValue == obj) {
            objRememberedValue = transition.new DeferredAnimation(twoWayConverterImpl, str);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        Transition.DeferredAnimation deferredAnimation = (Transition.DeferredAnimation) objRememberedValue;
        boolean zChanged2 = gapComposer.changed(transition) | gapComposer.changedInstance(deferredAnimation);
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == obj) {
            objRememberedValue2 = new BackHandlerKt$$ExternalSyntheticLambda2(4, transition, deferredAnimation);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        Stack.DisposableEffect(deferredAnimation, (Function1) objRememberedValue2, gapComposer);
        if (transition.isSeeking() && (deferredAnimationData = (Transition.DeferredAnimation.DeferredAnimationData) deferredAnimation.data$delegate.getValue()) != null) {
            Transition transition2 = Transition.this;
            deferredAnimationData.animation.updateInitialAndTargetValue$animation_core(deferredAnimationData.targetValueByState.invoke(transition2.getSegment().getInitialState()), deferredAnimationData.targetValueByState.invoke(transition2.getSegment().getTargetState()), (FiniteAnimationSpec) deferredAnimationData.transitionSpec.invoke(transition2.getSegment()));
        }
        return deferredAnimation;
    }

    public static final Transition.TransitionAnimationState createTransitionAnimation(Transition transition, Object obj, Object obj2, FiniteAnimationSpec finiteAnimationSpec, TwoWayConverterImpl twoWayConverterImpl, GapComposer gapComposer, int i) {
        Object obj3;
        Object obj4;
        int i2 = i & 14;
        int i3 = i2 ^ 6;
        boolean z = true;
        boolean z2 = (i3 > 4 && gapComposer.changed(transition)) || (i & 6) == 4;
        Object objRememberedValue = gapComposer.rememberedValue();
        Object obj5 = Composer$Companion.Empty;
        if (z2 || objRememberedValue == obj5) {
            Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                obj3 = obj2;
                AnimationVector animationVector = (AnimationVector) twoWayConverterImpl.convertToVector.invoke(obj3);
                animationVector.reset$animation_core();
                obj4 = obj;
                Object transitionAnimationState = transition.new TransitionAnimationState(obj4, animationVector, twoWayConverterImpl);
                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                gapComposer.updateRememberedValue(transitionAnimationState);
                objRememberedValue = transitionAnimationState;
            } catch (Throwable th) {
                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                throw th;
            }
        } else {
            obj4 = obj;
            obj3 = obj2;
        }
        Transition.TransitionAnimationState transitionAnimationState2 = (Transition.TransitionAnimationState) objRememberedValue;
        int i4 = (i >> 3) & 8;
        int i5 = i << 3;
        UpdateInitialAndTargetValues(transition, transitionAnimationState2, obj4, obj3, finiteAnimationSpec, gapComposer, i2 | (i4 << 6) | (i5 & 896) | (i4 << 9) | (i5 & 7168) | (57344 & i5));
        if ((i3 <= 4 || !gapComposer.changed(transition)) && (i & 6) != 4) {
            z = false;
        }
        boolean zChanged = gapComposer.changed(transitionAnimationState2) | z;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue2 == obj5) {
            objRememberedValue2 = new BackHandlerKt$$ExternalSyntheticLambda2(8, transition, transitionAnimationState2);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        Stack.DisposableEffect(transitionAnimationState2, (Function1) objRememberedValue2, gapComposer);
        return transitionAnimationState2;
    }

    public static final void doAnimationFrameWithScale(AnimationScope animationScope, long j, float f, Animation animation, AnimationState animationState, Function1 function1) {
        long durationNanos = f == 0.0f ? animation.getDurationNanos() : (long) ((j - animationScope.startTimeNanos) / f);
        animationScope.lastFrameTimeNanos = j;
        animationScope.value$delegate.setValue(animation.getValueFromNanos(durationNanos));
        animationScope.velocityVector = animation.getVelocityVectorFromNanos(durationNanos);
        if (animation.isFinishedFromNanos(durationNanos)) {
            animationScope.finishedTimeNanos = animationScope.lastFrameTimeNanos;
            animationScope.isRunning$delegate.setValue(Boolean.FALSE);
        }
        updateState(animationScope, animationState);
        function1.invoke(animationScope);
    }

    public static DecayAnimationSpecImpl exponentialDecay$default() {
        FlingCalculator flingCalculator = new FlingCalculator();
        flingCalculator.friction = Math.max(1.0E-7f, Math.abs(0.1f));
        flingCalculator.magicPhysicalCoefficient = Math.max(1.0E-4f, 1.0f) * (-4.2f);
        return new DecayAnimationSpecImpl(flingCalculator);
    }

    public static final float getDurationScale(CoroutineContext coroutineContext) {
        MotionDurationScale motionDurationScale = (MotionDurationScale) coroutineContext.get(Alignment.Companion.$$INSTANCE);
        float scaleFactor = motionDurationScale != null ? motionDurationScale.getScaleFactor() : 1.0f;
        if (scaleFactor >= 0.0f) {
            return scaleFactor;
        }
        PreconditionsKt.throwIllegalStateException("negative scale factor");
        return scaleFactor;
    }

    /* JADX INFO: renamed from: infiniteRepeatable-9IiC70o$default, reason: not valid java name */
    public static InfiniteRepeatableSpec m28infiniteRepeatable9IiC70o$default(DurationBasedAnimationSpec durationBasedAnimationSpec) {
        return new InfiniteRepeatableSpec(durationBasedAnimationSpec, 0);
    }

    public static final InfiniteTransition rememberInfiniteTransition(GapComposer gapComposer) {
        Object objRememberedValue = gapComposer.rememberedValue();
        if (objRememberedValue == Composer$Companion.Empty) {
            objRememberedValue = new InfiniteTransition();
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        InfiniteTransition infiniteTransition = (InfiniteTransition) objRememberedValue;
        infiniteTransition.run$animation_core(0, gapComposer);
        return infiniteTransition;
    }

    public static final Transition rememberTransition(Lifecycle lifecycle, String str, GapComposer gapComposer, int i) {
        int i2 = (i & 14) ^ 6;
        boolean z = true;
        boolean z2 = (i2 > 4 && gapComposer.changed(lifecycle)) || (i & 6) == 4;
        Object objRememberedValue = gapComposer.rememberedValue();
        Object obj = Composer$Companion.Empty;
        Continuation continuation = null;
        if (z2 || objRememberedValue == obj) {
            Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                Object transition = new Transition(lifecycle, null, str);
                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                gapComposer.updateRememberedValue(transition);
                objRememberedValue = transition;
            } catch (Throwable th) {
                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                throw th;
            }
        }
        Transition transition2 = (Transition) objRememberedValue;
        if (lifecycle instanceof SeekableTransitionState) {
            gapComposer.startReplaceGroup(-1357590553);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == obj) {
                objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Object obj2 = (CoroutineScope) objRememberedValue2;
            boolean zChangedInstance = gapComposer.changedInstance(obj2) | ((i2 > 4 && gapComposer.changed(lifecycle)) || (i & 6) == 4);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == obj) {
                objRememberedValue3 = new BackHandlerKt$$ExternalSyntheticLambda2(5, lifecycle, obj2);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Stack.DisposableEffect(obj2, (Function1) objRememberedValue3, gapComposer);
            SeekableTransitionState seekableTransitionState = (SeekableTransitionState) lifecycle;
            Object value = seekableTransitionState.currentState$delegate.getValue();
            Object value2 = seekableTransitionState.targetState$delegate.getValue();
            if ((i2 <= 4 || !gapComposer.changed(lifecycle)) && (i & 6) != 4) {
                z = false;
            }
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (z || objRememberedValue4 == obj) {
                objRememberedValue4 = new NavHostKt$NavHost$28$1(lifecycle, continuation, 2);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            Stack.LaunchedEffect(value, value2, (Function2) objRememberedValue4, gapComposer);
            gapComposer.end(false);
        } else {
            gapComposer.startReplaceGroup(-1356604288);
            transition2.animateTo$animation_core(lifecycle.getTargetState(), gapComposer, 0);
            gapComposer.end(false);
        }
        boolean zChanged = gapComposer.changed(transition2);
        Object objRememberedValue5 = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue5 == obj) {
            objRememberedValue5 = new TransitionKt$$ExternalSyntheticLambda1(transition2, 1);
            gapComposer.updateRememberedValue(objRememberedValue5);
        }
        Stack.DisposableEffect(transition2, (Function1) objRememberedValue5, gapComposer);
        return transition2;
    }

    public static SnapSpec snap$default() {
        return new SnapSpec(0);
    }

    public static SpringSpec spring$default(float f, float f2, Object obj, int i) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1500.0f;
        }
        if ((i & 4) != 0) {
            obj = null;
        }
        return new SpringSpec(f, f2, obj);
    }

    public static TweenSpec tween$default(int i, int i2, Easing easing) {
        if ((i2 & 1) != 0) {
            i = 300;
        }
        int i3 = (i2 & 2) != 0 ? 0 : 90;
        if ((i2 & 4) != 0) {
            easing = EasingKt.FastOutSlowInEasing;
        }
        return new TweenSpec(i, i3, easing);
    }

    public static final void updateState(AnimationScope animationScope, AnimationState animationState) {
        animationState.value$delegate.setValue(animationScope.value$delegate.getValue());
        AnimationVector animationVector = animationState.velocityVector;
        AnimationVector animationVector2 = animationScope.velocityVector;
        int size$animation_core = animationVector.getSize$animation_core();
        for (int i = 0; i < size$animation_core; i++) {
            animationVector.set$animation_core(i, animationVector2.get$animation_core(i));
        }
        animationState.finishedTimeNanos = animationScope.finishedTimeNanos;
        animationState.lastFrameTimeNanos = animationScope.lastFrameTimeNanos;
        animationState.isRunning = ((Boolean) animationScope.isRunning$delegate.getValue()).booleanValue();
    }

    public static final Transition updateTransition(Object obj, String str, GapComposer gapComposer, int i, int i2) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
        if (objRememberedValue == neverEqualPolicy) {
            objRememberedValue = new Transition(new MutableTransitionState(obj), null, str);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        Transition transition = (Transition) objRememberedValue;
        transition.animateTo$animation_core(obj, gapComposer, (i & 8) | 48 | (i & 14));
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = new TransitionKt$$ExternalSyntheticLambda1(transition, 0);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        Stack.DisposableEffect(transition, (Function1) objRememberedValue2, gapComposer);
        return transition;
    }

    public static final Object animate(float f, float f2, float f3, AnimationSpec animationSpec, Function2 function2, SuspendLambda suspendLambda) {
        Float f4 = new Float(f);
        Float f5 = new Float(f2);
        Float f6 = new Float(f3);
        TwoWayConverterImpl twoWayConverterImpl = FloatToVector;
        Function1 function1 = twoWayConverterImpl.convertToVector;
        AnimationVector animationVectorNewVector$animation_core = (AnimationVector) function1.invoke(f6);
        if (animationVectorNewVector$animation_core == null) {
            animationVectorNewVector$animation_core = ((AnimationVector) function1.invoke(f4)).newVector$animation_core();
        }
        AnimationVector animationVector = animationVectorNewVector$animation_core;
        Object objAnimate = animate(new AnimationState(twoWayConverterImpl, f4, animationVector, 56), new TargetBasedAnimation(animationSpec, twoWayConverterImpl, f4, f5, animationVector), Long.MIN_VALUE, new Recomposer$$ExternalSyntheticLambda0(1, function2), suspendLambda);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (objAnimate != coroutineSingletons) {
            objAnimate = Unit.INSTANCE;
        }
        return objAnimate == coroutineSingletons ? objAnimate : Unit.INSTANCE;
    }
}
