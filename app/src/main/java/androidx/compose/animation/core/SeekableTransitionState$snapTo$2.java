package androidx.compose.animation.core;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import coil.RealImageLoader$executeMain$result$1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SeekableTransitionState$snapTo$2 extends SuspendLambda implements Function1 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object $targetState;
    public final /* synthetic */ Transition $transition;
    public int label;
    public final /* synthetic */ SeekableTransitionState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeekableTransitionState$snapTo$2(SeekableTransitionState seekableTransitionState, Object obj, Transition transition, Continuation continuation) {
        super(1, continuation);
        this.this$0 = seekableTransitionState;
        this.$targetState = obj;
        this.$transition = transition;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Continuation continuation = (Continuation) obj;
        switch (this.$r8$classId) {
            case 0:
                return new SeekableTransitionState$snapTo$2(this.this$0, this.$targetState, this.$transition, continuation).invokeSuspend(Unit.INSTANCE);
            default:
                return new SeekableTransitionState$snapTo$2(this.$transition, this.this$0, this.$targetState, continuation).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        float f;
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                Transition transition = this.$transition;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SeekableTransitionState seekableTransitionState = this.this$0;
                    seekableTransitionState.endAllAnimations();
                    ParcelableSnapshotMutableState parcelableSnapshotMutableState = seekableTransitionState.targetState$delegate;
                    seekableTransitionState.lastFrameTimeNanos = Long.MIN_VALUE;
                    seekableTransitionState.setFraction(0.0f);
                    Object value = seekableTransitionState.currentState$delegate.getValue();
                    Object obj2 = this.$targetState;
                    if (obj2.equals(value)) {
                        f = -4.0f;
                    } else {
                        f = obj2.equals(parcelableSnapshotMutableState.getValue()) ? -5.0f : -3.0f;
                    }
                    transition.updateTarget$animation_core(obj2);
                    transition.setPlayTimeNanos(0L);
                    parcelableSnapshotMutableState.setValue(obj2);
                    seekableTransitionState.setFraction(0.0f);
                    seekableTransitionState.setCurrentState$animation_core(obj2);
                    transition.resetAnimationFraction$animation_core(f);
                    if (f == -3.0f) {
                        this.label = 1;
                        Object objAccess$waitForCompositionAfterTargetStateChange = SeekableTransitionState.access$waitForCompositionAfterTargetStateChange(seekableTransitionState, this);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objAccess$waitForCompositionAfterTargetStateChange == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                transition.onTransitionEnd$animation_core();
                return Unit.INSTANCE;
            default:
                int i2 = this.label;
                Transition transition2 = this.$transition;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$1 = new RealImageLoader$executeMain$result$1(this.this$0, this.$targetState, transition2, null, 1);
                    this.label = 1;
                    Object objCoroutineScope = JobKt.coroutineScope(realImageLoader$executeMain$result$1, this);
                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objCoroutineScope == coroutineSingletons2) {
                        return coroutineSingletons2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                transition2.onTransitionEnd$animation_core();
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeekableTransitionState$snapTo$2(Transition transition, SeekableTransitionState seekableTransitionState, Object obj, Continuation continuation) {
        super(1, continuation);
        this.$transition = transition;
        this.this$0 = seekableTransitionState;
        this.$targetState = obj;
    }
}
