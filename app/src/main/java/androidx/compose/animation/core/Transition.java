package androidx.compose.animation.core;

import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.lifecycle.Lifecycle;
import com.github.kr328.clash.FilesActivity$$ExternalSyntheticLambda16;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Transition {
    public final SnapshotStateList _animations;
    public final SnapshotStateList _transitions;
    public final ParcelableSnapshotMutableState isSeeking$delegate;
    public final String label;
    public final Transition parentTransition;
    public final ParcelableSnapshotMutableState segment$delegate;
    public final ParcelableSnapshotMutableState targetState$delegate;
    public final DerivedSnapshotState totalDurationNanos$delegate;
    public final Lifecycle transitionState;
    public final ParcelableSnapshotMutableState updateChildrenNeeded$delegate;
    public final ParcelableSnapshotMutableLongState _playTimeNanos$delegate = new ParcelableSnapshotMutableLongState(0);
    public final ParcelableSnapshotMutableLongState startTimeNanos$delegate = new ParcelableSnapshotMutableLongState(Long.MIN_VALUE);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class DeferredAnimation {
        public final ParcelableSnapshotMutableState data$delegate = Stack.mutableStateOf$default(null);
        public final TwoWayConverterImpl typeConverter;

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class DeferredAnimationData implements State {
            public final TransitionAnimationState animation;
            public Lambda targetValueByState;
            public Function1 transitionSpec;

            /* JADX WARN: Multi-variable type inference failed */
            public DeferredAnimationData(TransitionAnimationState transitionAnimationState, Function1 function1, Function1 function2) {
                this.animation = transitionAnimationState;
                this.transitionSpec = function1;
                this.targetValueByState = (Lambda) function2;
            }

            @Override // androidx.compose.runtime.State
            public final Object getValue() {
                updateAnimationStates(Transition.this.getSegment());
                return this.animation.value$delegate.getValue();
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
            /* JADX WARN: Type inference failed for: r1v5, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
            public final void updateAnimationStates(Segment segment) {
                Object objInvoke = this.targetValueByState.invoke(segment.getTargetState());
                boolean zIsSeeking = Transition.this.isSeeking();
                TransitionAnimationState transitionAnimationState = this.animation;
                if (zIsSeeking) {
                    transitionAnimationState.updateInitialAndTargetValue$animation_core(this.targetValueByState.invoke(segment.getInitialState()), objInvoke, (FiniteAnimationSpec) this.transitionSpec.invoke(segment));
                } else {
                    transitionAnimationState.updateTargetValue$animation_core(objInvoke, (FiniteAnimationSpec) this.transitionSpec.invoke(segment));
                }
            }
        }

        public DeferredAnimation(TwoWayConverterImpl twoWayConverterImpl, String str) {
            this.typeConverter = twoWayConverterImpl;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final DeferredAnimationData animate(Function1 function1, Function1 function2) {
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.data$delegate;
            DeferredAnimationData deferredAnimationData = (DeferredAnimationData) parcelableSnapshotMutableState.getValue();
            Transition transition = Transition.this;
            if (deferredAnimationData == null) {
                Object objInvoke = function2.invoke(transition.transitionState.mo773getCurrentState());
                Object objInvoke2 = function2.invoke(transition.transitionState.mo773getCurrentState());
                TwoWayConverterImpl twoWayConverterImpl = this.typeConverter;
                AnimationVector animationVector = (AnimationVector) twoWayConverterImpl.convertToVector.invoke(objInvoke2);
                animationVector.reset$animation_core();
                TransitionAnimationState transitionAnimationState = transition.new TransitionAnimationState(objInvoke, animationVector, twoWayConverterImpl);
                deferredAnimationData = new DeferredAnimationData(transitionAnimationState, function1, function2);
                parcelableSnapshotMutableState.setValue(deferredAnimationData);
                transition._animations.add(transitionAnimationState);
            }
            deferredAnimationData.targetValueByState = (Lambda) function2;
            deferredAnimationData.transitionSpec = function1;
            deferredAnimationData.updateAnimationStates(transition.getSegment());
            return deferredAnimationData;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface Segment {
        Object getInitialState();

        Object getTargetState();

        boolean isTransitioningTo(Enum r1, Enum r2);
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SegmentImpl implements Segment {
        public final Object initialState;
        public final Object targetState;

        public SegmentImpl(Object obj, Object obj2) {
            this.initialState = obj;
            this.targetState = obj2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Segment)) {
                return false;
            }
            Segment segment = (Segment) obj;
            return Intrinsics.areEqual(this.initialState, segment.getInitialState()) && Intrinsics.areEqual(this.targetState, segment.getTargetState());
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public final Object getInitialState() {
            return this.initialState;
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public final Object getTargetState() {
            return this.targetState;
        }

        public final int hashCode() {
            Object obj = this.initialState;
            int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
            Object obj2 = this.targetState;
            return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public final boolean isTransitioningTo(Enum r2, Enum r3) {
            return r2.equals(getInitialState()) && r3.equals(getTargetState());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class TransitionAnimationState implements State {
        public final ParcelableSnapshotMutableState animation$delegate;
        public final ParcelableSnapshotMutableState animationSpec$delegate;
        public final ParcelableSnapshotMutableLongState durationNanos$delegate;
        public TargetBasedAnimation initialValueAnimation;
        public SeekableTransitionState.SeekingAnimationState initialValueState;
        public final SpringSpec interruptionSpec;
        public final ParcelableSnapshotMutableState isFinished$delegate;
        public boolean isSeeking;
        public final ParcelableSnapshotMutableFloatState resetSnapValue$delegate;
        public final ParcelableSnapshotMutableState targetValue$delegate;
        public final TwoWayConverterImpl typeConverter;
        public boolean useOnlyInitialValue;
        public final ParcelableSnapshotMutableState value$delegate;
        public AnimationVector velocityVector;

        /* JADX WARN: Type inference failed for: r10v9, types: [java.lang.Object, java.util.Map] */
        public TransitionAnimationState(Object obj, AnimationVector animationVector, TwoWayConverterImpl twoWayConverterImpl) {
            this.typeConverter = twoWayConverterImpl;
            ParcelableSnapshotMutableState parcelableSnapshotMutableStateMutableStateOf$default = Stack.mutableStateOf$default(obj);
            this.targetValue$delegate = parcelableSnapshotMutableStateMutableStateOf$default;
            Object objInvoke = null;
            ParcelableSnapshotMutableState parcelableSnapshotMutableStateMutableStateOf$default2 = Stack.mutableStateOf$default(ArcSplineKt.spring$default(0.0f, 0.0f, null, 7));
            this.animationSpec$delegate = parcelableSnapshotMutableStateMutableStateOf$default2;
            this.animation$delegate = Stack.mutableStateOf$default(new TargetBasedAnimation((FiniteAnimationSpec) parcelableSnapshotMutableStateMutableStateOf$default2.getValue(), twoWayConverterImpl, obj, parcelableSnapshotMutableStateMutableStateOf$default.getValue(), animationVector));
            this.isFinished$delegate = Stack.mutableStateOf$default(Boolean.TRUE);
            this.resetSnapValue$delegate = new ParcelableSnapshotMutableFloatState(-1.0f);
            this.value$delegate = Stack.mutableStateOf$default(obj);
            this.velocityVector = animationVector;
            this.durationNanos$delegate = new ParcelableSnapshotMutableLongState(getAnimation().getDurationNanos());
            Float f = (Float) VisibilityThresholdsKt.VisibilityThresholdMap.get(twoWayConverterImpl);
            if (f != null) {
                float fFloatValue = f.floatValue();
                AnimationVector animationVector2 = (AnimationVector) twoWayConverterImpl.convertToVector.invoke(obj);
                int size$animation_core = animationVector2.getSize$animation_core();
                for (int i = 0; i < size$animation_core; i++) {
                    animationVector2.set$animation_core(i, fFloatValue);
                }
                objInvoke = this.typeConverter.convertFromVector.invoke(animationVector2);
            }
            this.interruptionSpec = ArcSplineKt.spring$default(0.0f, 0.0f, objInvoke, 3);
        }

        public final TargetBasedAnimation getAnimation() {
            return (TargetBasedAnimation) this.animation$delegate.getValue();
        }

        @Override // androidx.compose.runtime.State
        public final Object getValue() {
            return this.value$delegate.getValue();
        }

        public final void seekTo$animation_core(long j) {
            if (this.resetSnapValue$delegate.getFloatValue() == -1.0f) {
                this.isSeeking = true;
                if (Intrinsics.areEqual(getAnimation().mutableTargetValue, getAnimation().mutableInitialValue)) {
                    setValue$animation_core(getAnimation().mutableTargetValue);
                } else {
                    setValue$animation_core(getAnimation().getValueFromNanos(j));
                    this.velocityVector = getAnimation().getVelocityVectorFromNanos(j);
                }
            }
        }

        public final void setValue$animation_core(Object obj) {
            this.value$delegate.setValue(obj);
        }

        public final String toString() {
            return "current value: " + this.value$delegate.getValue() + ", target: " + this.targetValue$delegate.getValue() + ", spec: " + ((FiniteAnimationSpec) this.animationSpec$delegate.getValue());
        }

        public final void updateAnimation(Object obj, boolean z) {
            TargetBasedAnimation targetBasedAnimation = this.initialValueAnimation;
            Object obj2 = targetBasedAnimation != null ? targetBasedAnimation.mutableTargetValue : null;
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.targetValue$delegate;
            boolean zAreEqual = Intrinsics.areEqual(obj2, parcelableSnapshotMutableState.getValue());
            ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = this.durationNanos$delegate;
            ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = this.animation$delegate;
            FiniteAnimationSpec finiteAnimationSpec = this.interruptionSpec;
            if (zAreEqual) {
                parcelableSnapshotMutableState2.setValue(new TargetBasedAnimation(finiteAnimationSpec, this.typeConverter, obj, obj, this.velocityVector.newVector$animation_core()));
                this.useOnlyInitialValue = true;
                parcelableSnapshotMutableLongState.setLongValue(getAnimation().getDurationNanos());
                return;
            }
            ParcelableSnapshotMutableState parcelableSnapshotMutableState3 = this.animationSpec$delegate;
            if (!z || this.isSeeking || (((FiniteAnimationSpec) parcelableSnapshotMutableState3.getValue()) instanceof SpringSpec)) {
                finiteAnimationSpec = (FiniteAnimationSpec) parcelableSnapshotMutableState3.getValue();
            }
            Transition transition = Transition.this;
            long playTimeNanos = transition.getPlayTimeNanos();
            ParcelableSnapshotMutableState parcelableSnapshotMutableState4 = transition.updateChildrenNeeded$delegate;
            parcelableSnapshotMutableState2.setValue(new TargetBasedAnimation(playTimeNanos <= 0 ? finiteAnimationSpec : new StartDelayAnimationSpec(finiteAnimationSpec, transition.getPlayTimeNanos()), this.typeConverter, obj, parcelableSnapshotMutableState.getValue(), this.velocityVector));
            parcelableSnapshotMutableLongState.setLongValue(getAnimation().getDurationNanos());
            this.useOnlyInitialValue = false;
            parcelableSnapshotMutableState4.setValue(Boolean.TRUE);
            if (transition.isSeeking()) {
                SnapshotStateList snapshotStateList = transition._animations;
                int size = snapshotStateList.size();
                long jMax = 0;
                for (int i = 0; i < size; i++) {
                    TransitionAnimationState transitionAnimationState = (TransitionAnimationState) snapshotStateList.get(i);
                    jMax = Math.max(jMax, transitionAnimationState.durationNanos$delegate.getLongValue());
                    transitionAnimationState.seekTo$animation_core(0L);
                }
                parcelableSnapshotMutableState4.setValue(Boolean.FALSE);
            }
        }

        public final void updateInitialAndTargetValue$animation_core(Object obj, Object obj2, FiniteAnimationSpec finiteAnimationSpec) {
            this.targetValue$delegate.setValue(obj2);
            this.animationSpec$delegate.setValue(finiteAnimationSpec);
            if (Intrinsics.areEqual(getAnimation().mutableInitialValue, obj) && Intrinsics.areEqual(getAnimation().mutableTargetValue, obj2)) {
                return;
            }
            updateAnimation(obj, false);
        }

        public final void updateTargetValue$animation_core(Object obj, FiniteAnimationSpec finiteAnimationSpec) {
            if (this.useOnlyInitialValue) {
                TargetBasedAnimation targetBasedAnimation = this.initialValueAnimation;
                if (Intrinsics.areEqual(obj, targetBasedAnimation != null ? targetBasedAnimation.mutableTargetValue : null)) {
                    return;
                }
            }
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.targetValue$delegate;
            boolean zAreEqual = Intrinsics.areEqual(parcelableSnapshotMutableState.getValue(), obj);
            ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.resetSnapValue$delegate;
            if (zAreEqual && parcelableSnapshotMutableFloatState.getFloatValue() == -1.0f) {
                return;
            }
            parcelableSnapshotMutableState.setValue(obj);
            this.animationSpec$delegate.setValue(finiteAnimationSpec);
            Object value = parcelableSnapshotMutableFloatState.getFloatValue() == -3.0f ? obj : this.value$delegate.getValue();
            ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = this.isFinished$delegate;
            updateAnimation(value, !((Boolean) parcelableSnapshotMutableState2.getValue()).booleanValue());
            parcelableSnapshotMutableState2.setValue(Boolean.valueOf(parcelableSnapshotMutableFloatState.getFloatValue() == -3.0f));
            if (parcelableSnapshotMutableFloatState.getFloatValue() >= 0.0f) {
                setValue$animation_core(getAnimation().getValueFromNanos((long) (parcelableSnapshotMutableFloatState.getFloatValue() * getAnimation().getDurationNanos())));
            } else if (parcelableSnapshotMutableFloatState.getFloatValue() == -3.0f) {
                setValue$animation_core(obj);
            }
            this.useOnlyInitialValue = false;
            parcelableSnapshotMutableFloatState.setFloatValue(-1.0f);
        }
    }

    public Transition(Lifecycle lifecycle, Transition transition, String str) {
        this.transitionState = lifecycle;
        this.parentTransition = transition;
        this.label = str;
        this.targetState$delegate = Stack.mutableStateOf$default(lifecycle.mo773getCurrentState());
        this.segment$delegate = Stack.mutableStateOf$default(new SegmentImpl(lifecycle.mo773getCurrentState(), lifecycle.mo773getCurrentState()));
        Boolean bool = Boolean.FALSE;
        this.updateChildrenNeeded$delegate = Stack.mutableStateOf$default(bool);
        this._animations = new SnapshotStateList();
        this._transitions = new SnapshotStateList();
        this.isSeeking$delegate = Stack.mutableStateOf$default(bool);
        this.totalDurationNanos$delegate = Stack.derivedStateOf(new Transition$$ExternalSyntheticLambda0(this, 1));
        lifecycle.transitionConfigured$animation_core(this);
    }

    public final void animateTo$animation_core(Object obj, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(-1493585151);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? gapComposer.changed(obj) : gapComposer.changedInstance(obj) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(this) ? 32 : 16;
        }
        if (!gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            gapComposer.skipToGroupEnd();
        } else if (isSeeking()) {
            gapComposer.startReplaceGroup(467722849);
            gapComposer.end(false);
        } else {
            gapComposer.startReplaceGroup(466062241);
            updateTarget$animation_core(obj);
            int i3 = i2 & 112;
            boolean z = i3 == 32;
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (z || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.derivedStateOf(new Transition$$ExternalSyntheticLambda0(this, 0));
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            if (((Boolean) ((State) objRememberedValue).getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(466470356);
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
                boolean zChangedInstance = gapComposer.changedInstance(coroutineScope) | (i3 == 32);
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new BackHandlerKt$$ExternalSyntheticLambda2(3, coroutineScope, this);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                Stack.DisposableEffect(coroutineScope, this, (Function1) objRememberedValue3, gapComposer);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(467712929);
                gapComposer.end(false);
            }
            gapComposer.end(false);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FilesActivity$$ExternalSyntheticLambda16(i, 1, this, obj);
        }
    }

    public final long calculateTotalDurationNanos() {
        SnapshotStateList snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        long jMax = 0;
        for (int i = 0; i < size; i++) {
            jMax = Math.max(jMax, ((TransitionAnimationState) snapshotStateList.get(i)).durationNanos$delegate.getLongValue());
        }
        SnapshotStateList snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            jMax = Math.max(jMax, ((Transition) snapshotStateList2.get(i2)).calculateTotalDurationNanos());
        }
        return jMax;
    }

    public final void clearInitialAnimations$animation_core() {
        SnapshotStateList snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            TransitionAnimationState transitionAnimationState = (TransitionAnimationState) snapshotStateList.get(i);
            transitionAnimationState.initialValueAnimation = null;
            transitionAnimationState.initialValueState = null;
            transitionAnimationState.useOnlyInitialValue = false;
        }
        SnapshotStateList snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((Transition) snapshotStateList2.get(i2)).clearInitialAnimations$animation_core();
        }
    }

    public final boolean getHasInitialValueAnimations() {
        SnapshotStateList snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            if (((TransitionAnimationState) snapshotStateList.get(i)).initialValueState != null) {
                return true;
            }
        }
        SnapshotStateList snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (((Transition) snapshotStateList2.get(i2)).getHasInitialValueAnimations()) {
                return true;
            }
        }
        return false;
    }

    public final long getPlayTimeNanos() {
        Transition transition = this.parentTransition;
        return transition != null ? transition.getPlayTimeNanos() : this._playTimeNanos$delegate.getLongValue();
    }

    public final Segment getSegment() {
        return (Segment) this.segment$delegate.getValue();
    }

    public final boolean isSeeking() {
        return ((Boolean) this.isSeeking$delegate.getValue()).booleanValue();
    }

    public final void onFrame$animation_core(long j, boolean z) {
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = this.startTimeNanos$delegate;
        long longValue = parcelableSnapshotMutableLongState.getLongValue();
        Lifecycle lifecycle = this.transitionState;
        if (longValue == Long.MIN_VALUE) {
            parcelableSnapshotMutableLongState.setLongValue(j);
            ((ParcelableSnapshotMutableState) lifecycle.internalScopeRef).setValue(Boolean.TRUE);
        } else if (!((Boolean) ((ParcelableSnapshotMutableState) lifecycle.internalScopeRef).getValue()).booleanValue()) {
            ((ParcelableSnapshotMutableState) lifecycle.internalScopeRef).setValue(Boolean.TRUE);
        }
        this.updateChildrenNeeded$delegate.setValue(Boolean.FALSE);
        SnapshotStateList snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        boolean z2 = true;
        for (int i = 0; i < size; i++) {
            TransitionAnimationState transitionAnimationState = (TransitionAnimationState) snapshotStateList.get(i);
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = transitionAnimationState.isFinished$delegate;
            ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = transitionAnimationState.isFinished$delegate;
            if (!((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
                long durationNanos = z ? transitionAnimationState.getAnimation().getDurationNanos() : j;
                transitionAnimationState.setValue$animation_core(transitionAnimationState.getAnimation().getValueFromNanos(durationNanos));
                transitionAnimationState.velocityVector = transitionAnimationState.getAnimation().getVelocityVectorFromNanos(durationNanos);
                TargetBasedAnimation animation = transitionAnimationState.getAnimation();
                animation.getClass();
                if (ImageAnalysis$$ExternalSyntheticLambda1.$default$isFinishedFromNanos(animation, durationNanos)) {
                    parcelableSnapshotMutableState2.setValue(Boolean.TRUE);
                }
            }
            if (!((Boolean) parcelableSnapshotMutableState2.getValue()).booleanValue()) {
                z2 = false;
            }
        }
        SnapshotStateList snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Transition transition = (Transition) snapshotStateList2.get(i2);
            ParcelableSnapshotMutableState parcelableSnapshotMutableState3 = transition.targetState$delegate;
            Lifecycle lifecycle2 = transition.transitionState;
            if (!Intrinsics.areEqual(parcelableSnapshotMutableState3.getValue(), lifecycle2.mo773getCurrentState())) {
                transition.onFrame$animation_core(j, z);
            }
            if (!Intrinsics.areEqual(transition.targetState$delegate.getValue(), lifecycle2.mo773getCurrentState())) {
                z2 = false;
            }
        }
        if (z2) {
            onTransitionEnd$animation_core();
        }
    }

    public final void onTransitionEnd$animation_core() {
        this.startTimeNanos$delegate.setLongValue(Long.MIN_VALUE);
        Lifecycle lifecycle = this.transitionState;
        if (lifecycle instanceof MutableTransitionState) {
            ((MutableTransitionState) lifecycle).setCurrentState$animation_core(this.targetState$delegate.getValue());
        }
        setPlayTimeNanos(0L);
        ((ParcelableSnapshotMutableState) lifecycle.internalScopeRef).setValue(Boolean.FALSE);
        SnapshotStateList snapshotStateList = this._transitions;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            ((Transition) snapshotStateList.get(i)).onTransitionEnd$animation_core();
        }
    }

    public final void resetAnimationFraction$animation_core(float f) {
        SnapshotStateList snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            TransitionAnimationState transitionAnimationState = (TransitionAnimationState) snapshotStateList.get(i);
            transitionAnimationState.getClass();
            if (f == -4.0f || f == -5.0f) {
                TargetBasedAnimation targetBasedAnimation = transitionAnimationState.initialValueAnimation;
                if (targetBasedAnimation != null) {
                    transitionAnimationState.getAnimation().setMutableInitialValue$animation_core(targetBasedAnimation.mutableTargetValue);
                    transitionAnimationState.initialValueState = null;
                    transitionAnimationState.initialValueAnimation = null;
                }
                Object obj = f == -4.0f ? transitionAnimationState.getAnimation().mutableInitialValue : transitionAnimationState.getAnimation().mutableTargetValue;
                transitionAnimationState.getAnimation().setMutableInitialValue$animation_core(obj);
                transitionAnimationState.getAnimation().setMutableTargetValue$animation_core(obj);
                transitionAnimationState.setValue$animation_core(obj);
                transitionAnimationState.durationNanos$delegate.setLongValue(transitionAnimationState.getAnimation().getDurationNanos());
            } else {
                transitionAnimationState.resetSnapValue$delegate.setFloatValue(f);
            }
        }
        SnapshotStateList snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((Transition) snapshotStateList2.get(i2)).resetAnimationFraction$animation_core(f);
        }
    }

    public final void seek(Object obj, Object obj2) {
        this.startTimeNanos$delegate.setLongValue(Long.MIN_VALUE);
        Lifecycle lifecycle = this.transitionState;
        ((ParcelableSnapshotMutableState) lifecycle.internalScopeRef).setValue(Boolean.FALSE);
        boolean zIsSeeking = isSeeking();
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.targetState$delegate;
        if (!zIsSeeking || !Intrinsics.areEqual(lifecycle.mo773getCurrentState(), obj) || !Intrinsics.areEqual(parcelableSnapshotMutableState.getValue(), obj2)) {
            if (!Intrinsics.areEqual(lifecycle.mo773getCurrentState(), obj) && (lifecycle instanceof MutableTransitionState)) {
                ((MutableTransitionState) lifecycle).setCurrentState$animation_core(obj);
            }
            parcelableSnapshotMutableState.setValue(obj2);
            this.isSeeking$delegate.setValue(Boolean.TRUE);
            this.segment$delegate.setValue(new SegmentImpl(obj, obj2));
        }
        SnapshotStateList snapshotStateList = this._transitions;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            Transition transition = (Transition) snapshotStateList.get(i);
            if (transition.isSeeking()) {
                transition.seek(transition.transitionState.mo773getCurrentState(), transition.targetState$delegate.getValue());
            }
        }
        SnapshotStateList snapshotStateList2 = this._animations;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((TransitionAnimationState) snapshotStateList2.get(i2)).seekTo$animation_core(0L);
        }
    }

    public final void seekAnimations$animation_core(long j) {
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = this.startTimeNanos$delegate;
        if (parcelableSnapshotMutableLongState.getLongValue() == Long.MIN_VALUE) {
            parcelableSnapshotMutableLongState.setLongValue(j);
        }
        setPlayTimeNanos(j);
        this.updateChildrenNeeded$delegate.setValue(Boolean.FALSE);
        SnapshotStateList snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            ((TransitionAnimationState) snapshotStateList.get(i)).seekTo$animation_core(j);
        }
        SnapshotStateList snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Transition transition = (Transition) snapshotStateList2.get(i2);
            if (!Intrinsics.areEqual(transition.targetState$delegate.getValue(), transition.transitionState.mo773getCurrentState())) {
                transition.seekAnimations$animation_core(j);
            }
        }
    }

    public final void setInitialAnimations$animation_core(SeekableTransitionState.SeekingAnimationState seekingAnimationState) {
        SnapshotStateList snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            TransitionAnimationState transitionAnimationState = (TransitionAnimationState) snapshotStateList.get(i);
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = transitionAnimationState.value$delegate;
            if (!Intrinsics.areEqual(transitionAnimationState.getAnimation().mutableTargetValue, transitionAnimationState.getAnimation().mutableInitialValue)) {
                transitionAnimationState.initialValueAnimation = transitionAnimationState.getAnimation();
                transitionAnimationState.initialValueState = seekingAnimationState;
            }
            transitionAnimationState.animation$delegate.setValue(new TargetBasedAnimation(transitionAnimationState.interruptionSpec, transitionAnimationState.typeConverter, parcelableSnapshotMutableState.getValue(), parcelableSnapshotMutableState.getValue(), transitionAnimationState.velocityVector.newVector$animation_core()));
            transitionAnimationState.durationNanos$delegate.setLongValue(transitionAnimationState.getAnimation().getDurationNanos());
            transitionAnimationState.useOnlyInitialValue = true;
        }
        SnapshotStateList snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((Transition) snapshotStateList2.get(i2)).setInitialAnimations$animation_core(seekingAnimationState);
        }
    }

    public final void setPlayTimeNanos(long j) {
        if (this.parentTransition == null) {
            this._playTimeNanos$delegate.setLongValue(j);
        }
    }

    public final String toString() {
        SnapshotStateList snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        String str = "Transition animation values: ";
        for (int i = 0; i < size; i++) {
            str = str + ((TransitionAnimationState) snapshotStateList.get(i)) + ", ";
        }
        return str;
    }

    public final void updateInitialValues$animation_core() {
        TargetBasedAnimation targetBasedAnimation;
        SnapshotStateList snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            TransitionAnimationState transitionAnimationState = (TransitionAnimationState) snapshotStateList.get(i);
            SeekableTransitionState.SeekingAnimationState seekingAnimationState = transitionAnimationState.initialValueState;
            if (seekingAnimationState != null && (targetBasedAnimation = transitionAnimationState.initialValueAnimation) != null) {
                long jRoundToLong = MathKt.roundToLong(seekingAnimationState.durationNanos * ((double) seekingAnimationState.value));
                Object valueFromNanos = targetBasedAnimation.getValueFromNanos(jRoundToLong);
                if (transitionAnimationState.useOnlyInitialValue) {
                    transitionAnimationState.getAnimation().setMutableTargetValue$animation_core(valueFromNanos);
                }
                transitionAnimationState.getAnimation().setMutableInitialValue$animation_core(valueFromNanos);
                transitionAnimationState.durationNanos$delegate.setLongValue(transitionAnimationState.getAnimation().getDurationNanos());
                if (transitionAnimationState.resetSnapValue$delegate.getFloatValue() == -2.0f || transitionAnimationState.useOnlyInitialValue) {
                    transitionAnimationState.setValue$animation_core(valueFromNanos);
                } else {
                    transitionAnimationState.seekTo$animation_core(Transition.this.getPlayTimeNanos());
                }
                if (jRoundToLong >= seekingAnimationState.durationNanos) {
                    transitionAnimationState.initialValueState = null;
                    transitionAnimationState.initialValueAnimation = null;
                } else {
                    seekingAnimationState.isComplete = false;
                }
            }
        }
        SnapshotStateList snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((Transition) snapshotStateList2.get(i2)).updateInitialValues$animation_core();
        }
    }

    public final void updateTarget$animation_core(Object obj) {
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.targetState$delegate;
        if (Intrinsics.areEqual(parcelableSnapshotMutableState.getValue(), obj)) {
            return;
        }
        this.segment$delegate.setValue(new SegmentImpl(parcelableSnapshotMutableState.getValue(), obj));
        Lifecycle lifecycle = this.transitionState;
        if (!Intrinsics.areEqual(lifecycle.mo773getCurrentState(), parcelableSnapshotMutableState.getValue())) {
            lifecycle.setCurrentState$animation_core(parcelableSnapshotMutableState.getValue());
        }
        parcelableSnapshotMutableState.setValue(obj);
        if (this.startTimeNanos$delegate.getLongValue() == Long.MIN_VALUE) {
            this.updateChildrenNeeded$delegate.setValue(Boolean.TRUE);
        }
        SnapshotStateList snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            ((TransitionAnimationState) snapshotStateList.get(i)).resetSnapValue$delegate.setFloatValue(-2.0f);
        }
    }
}
