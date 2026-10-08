package androidx.compose.animation.core;

import com.github.kr328.clash.FilesActivity$$ExternalSyntheticLambda10;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Animatable$runAnimation$2 extends SuspendLambda implements Function1 {
    public final /* synthetic */ TargetBasedAnimation $animation;
    public final /* synthetic */ Function1 $block;
    public final /* synthetic */ Object $initialVelocity;
    public final /* synthetic */ long $startTime;
    public AnimationState L$0;
    public Ref$BooleanRef L$1;
    public int label;
    public final /* synthetic */ Animatable this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Animatable$runAnimation$2(Animatable animatable, Object obj, TargetBasedAnimation targetBasedAnimation, long j, Function1 function1, Continuation continuation) {
        super(1, continuation);
        this.this$0 = animatable;
        this.$initialVelocity = obj;
        this.$animation = targetBasedAnimation;
        this.$startTime = j;
        this.$block = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        long j = this.$startTime;
        Function1 function1 = this.$block;
        return new Animatable$runAnimation$2(this.this$0, this.$initialVelocity, this.$animation, j, function1, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AnimationState animationState;
        Ref$BooleanRef ref$BooleanRef;
        TargetBasedAnimation targetBasedAnimation = this.$animation;
        int i = this.label;
        int i2 = 1;
        Animatable animatable = this.this$0;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                animatable.internalState.velocityVector = (AnimationVector) animatable.typeConverter.convertToVector.invoke(this.$initialVelocity);
                animatable.targetValue$delegate.setValue(targetBasedAnimation.mutableTargetValue);
                animatable.isRunning$delegate.setValue(Boolean.TRUE);
                AnimationState animationState2 = animatable.internalState;
                AnimationState animationState3 = new AnimationState(animationState2.typeConverter, animationState2.value$delegate.getValue(), ArcSplineKt.copy(animationState2.velocityVector), animationState2.lastFrameTimeNanos, Long.MIN_VALUE, animationState2.isRunning);
                Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
                long j = this.$startTime;
                FilesActivity$$ExternalSyntheticLambda10 filesActivity$$ExternalSyntheticLambda10 = new FilesActivity$$ExternalSyntheticLambda10(animatable, animationState3, this.$block, ref$BooleanRef2, 1);
                this.L$0 = animationState3;
                this.L$1 = ref$BooleanRef2;
                this.label = 1;
                Object objAnimate = ArcSplineKt.animate(animationState3, targetBasedAnimation, j, filesActivity$$ExternalSyntheticLambda10, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objAnimate == coroutineSingletons) {
                    return coroutineSingletons;
                }
                animationState = animationState3;
                ref$BooleanRef = ref$BooleanRef2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ref$BooleanRef = this.L$1;
                animationState = this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            if (!ref$BooleanRef.element) {
                i2 = 2;
            }
            Animatable.access$endAnimation(animatable);
            return new AnimationResult(animationState, i2);
        } catch (CancellationException e) {
            Animatable.access$endAnimation(animatable);
            throw e;
        }
    }
}
