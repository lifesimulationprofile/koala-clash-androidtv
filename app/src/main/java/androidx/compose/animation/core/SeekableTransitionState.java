package androidx.compose.animation.core;

import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.collection.MutableObjectList;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.ThumbNode;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavBackStackEntry;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SeekableTransitionState extends Lifecycle {
    public final SeekableTransitionState$$ExternalSyntheticLambda1 animateOneFrameLambda;
    public Object composedTargetState;
    public CancellableContinuationImpl compositionContinuation;
    public final MutexImpl compositionContinuationMutex;
    public SeekingAnimationState currentAnimation;
    public final ParcelableSnapshotMutableState currentState$delegate;
    public float durationScale;
    public final SeekableTransitionState$$ExternalSyntheticLambda1 firstFrameLambda;
    public final ParcelableSnapshotMutableFloatState fraction$delegate;
    public final MutableObjectList initialValueAnimations;
    public long lastFrameTimeNanos;
    public final MutatorMutex mutatorMutex;
    public final BasicTextKt$$ExternalSyntheticLambda0 recalculateTotalDurationNanos;
    public SnapshotStateObserver snapshotStateObserver;
    public final ParcelableSnapshotMutableState targetState$delegate;
    public long totalDurationNanos;
    public Transition transition;
    public static final AnimationVector1D ZeroVelocity = new AnimationVector1D(0.0f);
    public static final AnimationVector1D Target1 = new AnimationVector1D(1.0f);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SeekingAnimationState {
        public VectorizedFiniteAnimationSpec animationSpec;
        public long animationSpecDuration;
        public long durationNanos;
        public AnimationVector1D initialVelocity;
        public boolean isComplete;
        public long progressNanos;
        public final AnimationVector1D start = new AnimationVector1D(0.0f);
        public float value;

        public final String toString() {
            return "progress nanos: " + this.progressNanos + ", animationSpec: " + this.animationSpec + ", isComplete: " + this.isComplete + ", value: " + this.value + ", start: " + this.start + ", initialVelocity: " + this.initialVelocity + ", durationNanos: " + this.durationNanos + ", animationSpecDuration: " + this.animationSpecDuration;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass3 extends SuspendLambda implements Function1 {
        public final /* synthetic */ float $fraction;
        public final /* synthetic */ Object $oldTargetState;
        public final /* synthetic */ Object $targetState;
        public final /* synthetic */ Transition $transition;
        public int label;
        public final /* synthetic */ SeekableTransitionState this$0;

        /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class AnonymousClass1 extends SuspendLambda implements Function2 {
            public final /* synthetic */ float $fraction;
            public final /* synthetic */ Object $oldTargetState;
            public final /* synthetic */ Object $targetState;
            public final /* synthetic */ Transition $transition;
            public /* synthetic */ Object L$0;
            public int label;
            public final /* synthetic */ SeekableTransitionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Object obj, Object obj2, SeekableTransitionState seekableTransitionState, Transition transition, float f, Continuation continuation) {
                super(2, continuation);
                this.$targetState = obj;
                this.$oldTargetState = obj2;
                this.this$0 = seekableTransitionState;
                this.$transition = transition;
                this.$fraction = f;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                int i = this.label;
                SeekableTransitionState seekableTransitionState = this.this$0;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    Object obj2 = this.$targetState;
                    Object obj3 = this.$oldTargetState;
                    Continuation continuation = null;
                    if (Intrinsics.areEqual(obj2, obj3)) {
                        seekableTransitionState.currentAnimation = null;
                        if (Intrinsics.areEqual(seekableTransitionState.currentState$delegate.getValue(), obj2)) {
                            return Unit.INSTANCE;
                        }
                    } else {
                        SeekableTransitionState.access$moveAnimationToInitialState(seekableTransitionState);
                    }
                    boolean zAreEqual = Intrinsics.areEqual(obj2, obj3);
                    float f = this.$fraction;
                    if (!zAreEqual) {
                        Transition transition = this.$transition;
                        transition.updateTarget$animation_core(obj2);
                        transition.setPlayTimeNanos(0L);
                        seekableTransitionState.targetState$delegate.setValue(obj2);
                        transition.resetAnimationFraction$animation_core(f);
                    }
                    seekableTransitionState.setFraction(f);
                    if (seekableTransitionState.initialValueAnimations.isNotEmpty()) {
                        JobKt.launch$default(coroutineScope, null, new ThumbNode.AnonymousClass1(seekableTransitionState, continuation, 1), 3);
                    } else {
                        seekableTransitionState.lastFrameTimeNanos = Long.MIN_VALUE;
                    }
                    this.label = 1;
                    Object objAccess$waitForCompositionAfterTargetStateChange = SeekableTransitionState.access$waitForCompositionAfterTargetStateChange(seekableTransitionState, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objAccess$waitForCompositionAfterTargetStateChange == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                seekableTransitionState.seekToFraction();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Object obj, Object obj2, SeekableTransitionState seekableTransitionState, Transition transition, float f, Continuation continuation) {
            super(1, continuation);
            this.$targetState = obj;
            this.$oldTargetState = obj2;
            this.this$0 = seekableTransitionState;
            this.$transition = transition;
            this.$fraction = f;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            Transition transition = this.$transition;
            float f = this.$fraction;
            return new AnonymousClass3(this.$targetState, this.$oldTargetState, this.this$0, transition, f, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, null);
                this.label = 1;
                Object objCoroutineScope = JobKt.coroutineScope(anonymousClass1, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objCoroutineScope == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [androidx.compose.animation.core.SeekableTransitionState$$ExternalSyntheticLambda1] */
    /* JADX WARN: Type inference failed for: r3v7, types: [androidx.compose.animation.core.SeekableTransitionState$$ExternalSyntheticLambda1] */
    public SeekableTransitionState(NavBackStackEntry navBackStackEntry) {
        super(2);
        this.targetState$delegate = Stack.mutableStateOf$default(navBackStackEntry);
        this.currentState$delegate = Stack.mutableStateOf$default(navBackStackEntry);
        this.composedTargetState = navBackStackEntry;
        this.recalculateTotalDurationNanos = new BasicTextKt$$ExternalSyntheticLambda0(1, this);
        this.fraction$delegate = new ParcelableSnapshotMutableFloatState(0.0f);
        this.compositionContinuationMutex = new MutexImpl();
        this.mutatorMutex = new MutatorMutex();
        this.lastFrameTimeNanos = Long.MIN_VALUE;
        this.initialValueAnimations = new MutableObjectList();
        final int i = 0;
        this.firstFrameLambda = new Function1(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$$ExternalSyntheticLambda1
            public final /* synthetic */ SeekableTransitionState f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Long l = (Long) obj;
                switch (i) {
                    case 0:
                        this.f$0.lastFrameTimeNanos = l.longValue();
                        break;
                    default:
                        long jLongValue = l.longValue();
                        SeekableTransitionState seekableTransitionState = this.f$0;
                        long j = jLongValue - seekableTransitionState.lastFrameTimeNanos;
                        seekableTransitionState.lastFrameTimeNanos = jLongValue;
                        long jRoundToLong = MathKt.roundToLong(j / ((double) seekableTransitionState.durationScale));
                        MutableObjectList mutableObjectList = seekableTransitionState.initialValueAnimations;
                        if (mutableObjectList.isNotEmpty()) {
                            Object[] objArr = mutableObjectList.content;
                            int i2 = mutableObjectList._size;
                            int i3 = 0;
                            for (int i4 = 0; i4 < i2; i4++) {
                                SeekableTransitionState.SeekingAnimationState seekingAnimationState = (SeekableTransitionState.SeekingAnimationState) objArr[i4];
                                SeekableTransitionState.recalculateAnimationValue(seekingAnimationState, jRoundToLong);
                                seekingAnimationState.isComplete = true;
                            }
                            Transition transition = seekableTransitionState.transition;
                            if (transition != null) {
                                transition.updateInitialValues$animation_core();
                            }
                            int i5 = mutableObjectList._size;
                            Object[] objArr2 = mutableObjectList.content;
                            IntRange intRangeUntil = RangesKt.until(0, i5);
                            int i6 = intRangeUntil.first;
                            int i7 = intRangeUntil.last;
                            if (i6 <= i7) {
                                while (true) {
                                    objArr2[i6 - i3] = objArr2[i6];
                                    if (((SeekableTransitionState.SeekingAnimationState) objArr2[i6]).isComplete) {
                                        i3++;
                                    }
                                    if (i6 != i7) {
                                        i6++;
                                    }
                                }
                            }
                            Arrays.fill(objArr2, i5 - i3, i5, (Object) null);
                            mutableObjectList._size -= i3;
                        }
                        SeekableTransitionState.SeekingAnimationState seekingAnimationState2 = seekableTransitionState.currentAnimation;
                        if (seekingAnimationState2 != null) {
                            seekingAnimationState2.durationNanos = seekableTransitionState.totalDurationNanos;
                            SeekableTransitionState.recalculateAnimationValue(seekingAnimationState2, jRoundToLong);
                            seekableTransitionState.setFraction(seekingAnimationState2.value);
                            if (seekingAnimationState2.value == 1.0f) {
                                seekableTransitionState.currentAnimation = null;
                            }
                            seekableTransitionState.seekToFraction();
                        }
                        break;
                }
                return Unit.INSTANCE;
            }
        };
        final int i2 = 1;
        this.animateOneFrameLambda = new Function1(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$$ExternalSyntheticLambda1
            public final /* synthetic */ SeekableTransitionState f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Long l = (Long) obj;
                switch (i2) {
                    case 0:
                        this.f$0.lastFrameTimeNanos = l.longValue();
                        break;
                    default:
                        long jLongValue = l.longValue();
                        SeekableTransitionState seekableTransitionState = this.f$0;
                        long j = jLongValue - seekableTransitionState.lastFrameTimeNanos;
                        seekableTransitionState.lastFrameTimeNanos = jLongValue;
                        long jRoundToLong = MathKt.roundToLong(j / ((double) seekableTransitionState.durationScale));
                        MutableObjectList mutableObjectList = seekableTransitionState.initialValueAnimations;
                        if (mutableObjectList.isNotEmpty()) {
                            Object[] objArr = mutableObjectList.content;
                            int i3 = mutableObjectList._size;
                            int i4 = 0;
                            for (int i5 = 0; i5 < i3; i5++) {
                                SeekableTransitionState.SeekingAnimationState seekingAnimationState = (SeekableTransitionState.SeekingAnimationState) objArr[i5];
                                SeekableTransitionState.recalculateAnimationValue(seekingAnimationState, jRoundToLong);
                                seekingAnimationState.isComplete = true;
                            }
                            Transition transition = seekableTransitionState.transition;
                            if (transition != null) {
                                transition.updateInitialValues$animation_core();
                            }
                            int i6 = mutableObjectList._size;
                            Object[] objArr2 = mutableObjectList.content;
                            IntRange intRangeUntil = RangesKt.until(0, i6);
                            int i7 = intRangeUntil.first;
                            int i8 = intRangeUntil.last;
                            if (i7 <= i8) {
                                while (true) {
                                    objArr2[i7 - i4] = objArr2[i7];
                                    if (((SeekableTransitionState.SeekingAnimationState) objArr2[i7]).isComplete) {
                                        i4++;
                                    }
                                    if (i7 != i8) {
                                        i7++;
                                    }
                                }
                            }
                            Arrays.fill(objArr2, i6 - i4, i6, (Object) null);
                            mutableObjectList._size -= i4;
                        }
                        SeekableTransitionState.SeekingAnimationState seekingAnimationState2 = seekableTransitionState.currentAnimation;
                        if (seekingAnimationState2 != null) {
                            seekingAnimationState2.durationNanos = seekableTransitionState.totalDurationNanos;
                            SeekableTransitionState.recalculateAnimationValue(seekingAnimationState2, jRoundToLong);
                            seekableTransitionState.setFraction(seekingAnimationState2.value);
                            if (seekingAnimationState2.value == 1.0f) {
                                seekableTransitionState.currentAnimation = null;
                            }
                            seekableTransitionState.seekToFraction();
                        }
                        break;
                }
                return Unit.INSTANCE;
            }
        };
    }

    public static final void access$moveAnimationToInitialState(SeekableTransitionState seekableTransitionState) {
        Transition transition = seekableTransitionState.transition;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = seekableTransitionState.fraction$delegate;
        if (transition == null) {
            return;
        }
        SeekingAnimationState seekingAnimationState = seekableTransitionState.currentAnimation;
        if (seekingAnimationState == null) {
            if (seekableTransitionState.totalDurationNanos <= 0 || parcelableSnapshotMutableFloatState.getFloatValue() == 1.0f || Intrinsics.areEqual(seekableTransitionState.currentState$delegate.getValue(), seekableTransitionState.targetState$delegate.getValue())) {
                seekingAnimationState = null;
            } else {
                seekingAnimationState = new SeekingAnimationState();
                seekingAnimationState.value = parcelableSnapshotMutableFloatState.getFloatValue();
                long j = seekableTransitionState.totalDurationNanos;
                seekingAnimationState.durationNanos = j;
                seekingAnimationState.animationSpecDuration = MathKt.roundToLong((1.0d - ((double) parcelableSnapshotMutableFloatState.getFloatValue())) * j);
                seekingAnimationState.start.set$animation_core(0, parcelableSnapshotMutableFloatState.getFloatValue());
            }
        }
        if (seekingAnimationState != null) {
            seekingAnimationState.durationNanos = seekableTransitionState.totalDurationNanos;
            seekableTransitionState.initialValueAnimations.add(seekingAnimationState);
            transition.setInitialAnimations$animation_core(seekingAnimationState);
        }
        seekableTransitionState.currentAnimation = null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public static final Object access$runAnimations(SeekableTransitionState seekableTransitionState, ContinuationImpl continuationImpl) {
        SeekableTransitionState$runAnimations$1 seekableTransitionState$runAnimations$1;
        MutableObjectList mutableObjectList = seekableTransitionState.initialValueAnimations;
        if (continuationImpl instanceof SeekableTransitionState$runAnimations$1) {
            seekableTransitionState$runAnimations$1 = (SeekableTransitionState$runAnimations$1) continuationImpl;
            int i = seekableTransitionState$runAnimations$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                seekableTransitionState$runAnimations$1.label = i - Integer.MIN_VALUE;
            } else {
                seekableTransitionState$runAnimations$1 = new SeekableTransitionState$runAnimations$1(seekableTransitionState, continuationImpl);
            }
        } else {
            seekableTransitionState$runAnimations$1 = new SeekableTransitionState$runAnimations$1(seekableTransitionState, continuationImpl);
        }
        CoroutineContext coroutineContext = seekableTransitionState$runAnimations$1._context;
        Object obj = seekableTransitionState$runAnimations$1.result;
        int i2 = seekableTransitionState$runAnimations$1.label;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (mutableObjectList.isEmpty() && seekableTransitionState.currentAnimation == null) {
                return Unit.INSTANCE;
            }
            if (ArcSplineKt.getDurationScale(coroutineContext) == 0.0f) {
                seekableTransitionState.endAllAnimations();
                seekableTransitionState.lastFrameTimeNanos = Long.MIN_VALUE;
                return Unit.INSTANCE;
            }
            if (seekableTransitionState.lastFrameTimeNanos == Long.MIN_VALUE) {
                SeekableTransitionState$$ExternalSyntheticLambda1 seekableTransitionState$$ExternalSyntheticLambda1 = seekableTransitionState.firstFrameLambda;
                seekableTransitionState$runAnimations$1.label = 1;
                if (Stack.getMonotonicFrameClock(coroutineContext).withFrameNanos(seekableTransitionState$$ExternalSyntheticLambda1, seekableTransitionState$runAnimations$1) != obj2) {
                }
            }
            return obj2;
        }
        if (i2 != 1 && i2 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        do {
            if (!mutableObjectList.isNotEmpty() && seekableTransitionState.currentAnimation == null) {
                seekableTransitionState.lastFrameTimeNanos = Long.MIN_VALUE;
                return Unit.INSTANCE;
            }
            seekableTransitionState$runAnimations$1.label = 2;
        } while (seekableTransitionState.animateOneFrame(seekableTransitionState$runAnimations$1) != obj2);
        return obj2;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0077  */
    /* JADX WARN: Code duplicated, block: B:27:0x007a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public static final Object access$waitForComposition(SeekableTransitionState seekableTransitionState, ContinuationImpl continuationImpl) {
        SeekableTransitionState$waitForComposition$1 seekableTransitionState$waitForComposition$1;
        Object value;
        Object obj;
        MutexImpl mutexImpl = seekableTransitionState.compositionContinuationMutex;
        if (continuationImpl instanceof SeekableTransitionState$waitForComposition$1) {
            seekableTransitionState$waitForComposition$1 = (SeekableTransitionState$waitForComposition$1) continuationImpl;
            int i = seekableTransitionState$waitForComposition$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                seekableTransitionState$waitForComposition$1.label = i - Integer.MIN_VALUE;
            } else {
                seekableTransitionState$waitForComposition$1 = new SeekableTransitionState$waitForComposition$1(seekableTransitionState, continuationImpl);
            }
        } else {
            seekableTransitionState$waitForComposition$1 = new SeekableTransitionState$waitForComposition$1(seekableTransitionState, continuationImpl);
        }
        Object obj2 = seekableTransitionState$waitForComposition$1.result;
        int i2 = seekableTransitionState$waitForComposition$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            value = seekableTransitionState.targetState$delegate.getValue();
            seekableTransitionState$waitForComposition$1.L$0 = value;
            seekableTransitionState$waitForComposition$1.label = 1;
            if (mutexImpl.lock(seekableTransitionState$waitForComposition$1) != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            Object obj3 = seekableTransitionState$waitForComposition$1.L$0;
            ResultKt.throwOnFailure(obj2);
            value = obj3;
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = seekableTransitionState$waitForComposition$1.L$0;
            ResultKt.throwOnFailure(obj2);
        }
        if (Intrinsics.areEqual(obj2, obj)) {
            return Unit.INSTANCE;
        }
        seekableTransitionState.lastFrameTimeNanos = Long.MIN_VALUE;
        throw new CancellationException("targetState while waiting for composition");
        seekableTransitionState$waitForComposition$1.L$0 = value;
        seekableTransitionState$waitForComposition$1.label = 2;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzga.intercepted(seekableTransitionState$waitForComposition$1));
        cancellableContinuationImpl.initCancellability();
        seekableTransitionState.compositionContinuation = cancellableContinuationImpl;
        mutexImpl.unlock(null);
        Object result = cancellableContinuationImpl.getResult();
        if (result != coroutineSingletons) {
            obj = value;
            obj2 = result;
            if (Intrinsics.areEqual(obj2, obj)) {
                return Unit.INSTANCE;
            }
            seekableTransitionState.lastFrameTimeNanos = Long.MIN_VALUE;
            throw new CancellationException("targetState while waiting for composition");
        }
        return coroutineSingletons;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0086  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Instruction removed from duplicated block: B:30:0x0086, please report this as an issue */
    public static final Object access$waitForCompositionAfterTargetStateChange(SeekableTransitionState seekableTransitionState, ContinuationImpl continuationImpl) {
        SeekableTransitionState$waitForCompositionAfterTargetStateChange$1 seekableTransitionState$waitForCompositionAfterTargetStateChange$1;
        Object value;
        Object obj;
        MutexImpl mutexImpl = seekableTransitionState.compositionContinuationMutex;
        if (continuationImpl instanceof SeekableTransitionState$waitForCompositionAfterTargetStateChange$1) {
            seekableTransitionState$waitForCompositionAfterTargetStateChange$1 = (SeekableTransitionState$waitForCompositionAfterTargetStateChange$1) continuationImpl;
            int i = seekableTransitionState$waitForCompositionAfterTargetStateChange$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                seekableTransitionState$waitForCompositionAfterTargetStateChange$1.label = i - Integer.MIN_VALUE;
            } else {
                seekableTransitionState$waitForCompositionAfterTargetStateChange$1 = new SeekableTransitionState$waitForCompositionAfterTargetStateChange$1(seekableTransitionState, continuationImpl);
            }
        } else {
            seekableTransitionState$waitForCompositionAfterTargetStateChange$1 = new SeekableTransitionState$waitForCompositionAfterTargetStateChange$1(seekableTransitionState, continuationImpl);
        }
        Object obj2 = seekableTransitionState$waitForCompositionAfterTargetStateChange$1.result;
        int i2 = seekableTransitionState$waitForCompositionAfterTargetStateChange$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            value = seekableTransitionState.targetState$delegate.getValue();
            seekableTransitionState$waitForCompositionAfterTargetStateChange$1.L$0 = value;
            seekableTransitionState$waitForCompositionAfterTargetStateChange$1.label = 1;
            if (mutexImpl.lock(seekableTransitionState$waitForCompositionAfterTargetStateChange$1) != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            Object obj3 = seekableTransitionState$waitForCompositionAfterTargetStateChange$1.L$0;
            ResultKt.throwOnFailure(obj2);
            value = obj3;
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = seekableTransitionState$waitForCompositionAfterTargetStateChange$1.L$0;
            ResultKt.throwOnFailure(obj2);
        }
        if (!Intrinsics.areEqual(obj2, obj)) {
            seekableTransitionState.lastFrameTimeNanos = Long.MIN_VALUE;
            throw new CancellationException("snapTo() was canceled because state was changed to " + obj2 + " instead of " + obj);
        }
        return Unit.INSTANCE;
        if (!Intrinsics.areEqual(value, seekableTransitionState.composedTargetState)) {
            seekableTransitionState$waitForCompositionAfterTargetStateChange$1.L$0 = value;
            seekableTransitionState$waitForCompositionAfterTargetStateChange$1.label = 2;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzga.intercepted(seekableTransitionState$waitForCompositionAfterTargetStateChange$1));
            cancellableContinuationImpl.initCancellability();
            seekableTransitionState.compositionContinuation = cancellableContinuationImpl;
            mutexImpl.unlock(null);
            Object result = cancellableContinuationImpl.getResult();
            if (result != coroutineSingletons) {
                obj = value;
                obj2 = result;
                if (!Intrinsics.areEqual(obj2, obj)) {
                    seekableTransitionState.lastFrameTimeNanos = Long.MIN_VALUE;
                    throw new CancellationException("snapTo() was canceled because state was changed to " + obj2 + " instead of " + obj);
                }
            }
            return coroutineSingletons;
        }
        mutexImpl.unlock(null);
        return Unit.INSTANCE;
    }

    public static void recalculateAnimationValue(SeekingAnimationState seekingAnimationState, long j) {
        long j2 = seekingAnimationState.progressNanos;
        AnimationVector1D animationVector1D = seekingAnimationState.start;
        long j3 = j2 + j;
        seekingAnimationState.progressNanos = j3;
        long j4 = seekingAnimationState.animationSpecDuration;
        if (j3 >= j4) {
            seekingAnimationState.value = 1.0f;
            return;
        }
        VectorizedFiniteAnimationSpec vectorizedFiniteAnimationSpec = seekingAnimationState.animationSpec;
        if (vectorizedFiniteAnimationSpec == null) {
            float f = j3 / j4;
            seekingAnimationState.value = (f * 1.0f) + ((1 - f) * animationVector1D.get$animation_core(0));
            return;
        }
        AnimationVector1D animationVector1D2 = seekingAnimationState.initialVelocity;
        if (animationVector1D2 == null) {
            animationVector1D2 = ZeroVelocity;
        }
        seekingAnimationState.value = RangesKt.coerceIn(((AnimationVector1D) vectorizedFiniteAnimationSpec.getValueFromNanos(j3, animationVector1D, Target1, animationVector1D2)).get$animation_core(0), 0.0f, 1.0f);
    }

    public final Object animateOneFrame(ContinuationImpl continuationImpl) {
        float durationScale = ArcSplineKt.getDurationScale(continuationImpl.getContext());
        if (durationScale <= 0.0f) {
            endAllAnimations();
            return Unit.INSTANCE;
        }
        this.durationScale = durationScale;
        Object objWithFrameNanos = Stack.getMonotonicFrameClock(continuationImpl.getContext()).withFrameNanos(this.animateOneFrameLambda, continuationImpl);
        return objWithFrameNanos == CoroutineSingletons.COROUTINE_SUSPENDED ? objWithFrameNanos : Unit.INSTANCE;
    }

    public final void endAllAnimations() {
        Transition transition = this.transition;
        if (transition != null) {
            transition.clearInitialAnimations$animation_core();
        }
        this.initialValueAnimations.clear();
        if (this.currentAnimation != null) {
            this.currentAnimation = null;
            setFraction(1.0f);
            seekToFraction();
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    /* JADX INFO: renamed from: getCurrentState */
    public final Object mo773getCurrentState() {
        return this.currentState$delegate.getValue();
    }

    @Override // androidx.lifecycle.Lifecycle
    public final Object getTargetState() {
        return this.targetState$delegate.getValue();
    }

    public final Object seekTo(float f, Object obj, SuspendLambda suspendLambda) {
        if (0.0f > f || f > 1.0f) {
            PreconditionsKt.throwIllegalArgumentException("Expecting fraction between 0 and 1. Got " + f);
        }
        Transition transition = this.transition;
        if (transition == null) {
            return Unit.INSTANCE;
        }
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, new AnonymousClass3(obj, this.targetState$delegate.getValue(), this, transition, f, null), suspendLambda);
        return objMutate$default == CoroutineSingletons.COROUTINE_SUSPENDED ? objMutate$default : Unit.INSTANCE;
    }

    public final void seekToFraction() {
        Transition transition = this.transition;
        if (transition == null) {
            return;
        }
        transition.seekAnimations$animation_core(MathKt.roundToLong(((double) this.fraction$delegate.getFloatValue()) * ((Number) transition.totalDurationNanos$delegate.getValue()).longValue()));
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void setCurrentState$animation_core(Object obj) {
        this.currentState$delegate.setValue(obj);
    }

    public final void setFraction(float f) {
        this.fraction$delegate.setFloatValue(f);
    }

    public final void setSnapshotStateObserver$animation_core(SnapshotStateObserver snapshotStateObserver) {
        OnBackPressedDispatcher$$ExternalSyntheticLambda0 onBackPressedDispatcher$$ExternalSyntheticLambda0;
        if (Intrinsics.areEqual(this.snapshotStateObserver, snapshotStateObserver)) {
            return;
        }
        SnapshotStateObserver snapshotStateObserver2 = this.snapshotStateObserver;
        if (snapshotStateObserver2 != null) {
            snapshotStateObserver2.clear(this);
        }
        SnapshotStateObserver snapshotStateObserver3 = this.snapshotStateObserver;
        if (snapshotStateObserver3 != null && (onBackPressedDispatcher$$ExternalSyntheticLambda0 = snapshotStateObserver3.applyUnsubscribe) != null) {
            onBackPressedDispatcher$$ExternalSyntheticLambda0.dispose();
        }
        this.snapshotStateObserver = snapshotStateObserver;
        if (snapshotStateObserver != null) {
            snapshotStateObserver.start();
        }
        SnapshotStateObserver snapshotStateObserver4 = this.snapshotStateObserver;
        if (snapshotStateObserver4 != null) {
            snapshotStateObserver4.observeReads(this, ArcSplineKt.SeekableTransitionStateTotalDurationChanged, this.recalculateTotalDurationNanos);
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void transitionConfigured$animation_core(Transition transition) {
        Transition transition2 = this.transition;
        if (transition2 != null && !transition.equals(transition2)) {
            PreconditionsKt.throwIllegalStateException("An instance of SeekableTransitionState has been used in different Transitions. Previous instance: " + this.transition + ", new instance: " + transition);
        }
        this.transition = transition;
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void transitionRemoved$animation_core() {
        this.transition = null;
        SnapshotStateObserver snapshotStateObserver = this.snapshotStateObserver;
        if (snapshotStateObserver != null) {
            snapshotStateObserver.clear(this);
        }
    }
}
