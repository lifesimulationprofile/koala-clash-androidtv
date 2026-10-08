package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $animatable;
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ long $targetValue;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1$2$1(long j, SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine, Continuation continuation) {
        super(2, continuation);
        this.$targetValue = j;
        this.$animatable = pointerEventHandlerCoroutine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1$2$1((Animatable) this.$animatable, this.$targetValue, continuation);
            default:
                return new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1$2$1(this.$targetValue, (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.$animatable, continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return ((SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0044  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CancellableContinuationImpl cancellableContinuationImpl;
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = (Animatable) this.$animatable;
                    Offset offset = new Offset(this.$targetValue);
                    SpringSpec springSpec = SelectionMagnifierKt.MagnifierSpringSpec;
                    this.label = 1;
                    Object objAnimateTo$default = Animatable.animateTo$default(animatable, offset, springSpec, null, this, 12);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objAnimateTo$default == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            default:
                int i2 = this.label;
                long j = this.$targetValue;
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (i2 != 0) {
                    if (i2 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    cancellableContinuationImpl = ((SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.$animatable).pointerAwaiter;
                    if (cancellableContinuationImpl != null) {
                        cancellableContinuationImpl.resumeWith(new Result.Failure(new PointerEventTimeoutCancellationException(j)));
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (JobKt.delay(j - 8, this) == coroutineSingletons2) {
                    return coroutineSingletons2;
                }
                this.label = 2;
                if (JobKt.delay(8L, this) == coroutineSingletons2) {
                    return coroutineSingletons2;
                }
                cancellableContinuationImpl = ((SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.$animatable).pointerAwaiter;
                if (cancellableContinuationImpl != null) {
                    cancellableContinuationImpl.resumeWith(new Result.Failure(new PointerEventTimeoutCancellationException(j)));
                }
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1$2$1(Animatable animatable, long j, Continuation continuation) {
        super(2, continuation);
        this.$animatable = animatable;
        this.$targetValue = j;
    }
}
