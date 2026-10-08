package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TweenSpec;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetKt$BottomSheet$settleToDismiss$1$1$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Animatable $predictiveBackProgress;
    public final /* synthetic */ int $r8$classId;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BottomSheetKt$BottomSheet$settleToDismiss$1$1$2(Animatable animatable, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$predictiveBackProgress = animatable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new BottomSheetKt$BottomSheet$settleToDismiss$1$1$2(this.$predictiveBackProgress, continuation, 0);
            case 1:
                return new BottomSheetKt$BottomSheet$settleToDismiss$1$1$2(this.$predictiveBackProgress, continuation, 1);
            case 2:
                return new BottomSheetKt$BottomSheet$settleToDismiss$1$1$2(this.$predictiveBackProgress, continuation, 2);
            default:
                return new BottomSheetKt$BottomSheet$settleToDismiss$1$1$2(this.$predictiveBackProgress, continuation, 3);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
        return ((BottomSheetKt$BottomSheet$settleToDismiss$1$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Float f = new Float(0.0f);
                    this.label = 1;
                    Object objAnimateTo$default = Animatable.animateTo$default(this.$predictiveBackProgress, f, null, null, this, 14);
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
            case 1:
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Float f2 = new Float(1.0f);
                    SpringSpec springSpecSpring$default = ArcSplineKt.spring$default(0.75f, 1500.0f, null, 4);
                    this.label = 1;
                    Object objAnimateTo$default2 = Animatable.animateTo$default(this.$predictiveBackProgress, f2, springSpecSpring$default, null, this, 12);
                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objAnimateTo$default2 == coroutineSingletons2) {
                        return coroutineSingletons2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 2:
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Float f3 = new Float(1.0f);
                    TweenSpec tweenSpecTween$default = ArcSplineKt.tween$default(150, 6, null);
                    this.label = 1;
                    Object objAnimateTo$default3 = Animatable.animateTo$default(this.$predictiveBackProgress, f3, tweenSpecTween$default, null, this, 12);
                    CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objAnimateTo$default3 == coroutineSingletons3) {
                        return coroutineSingletons3;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            default:
                int i4 = this.label;
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Float f4 = new Float(0.0f);
                    SpringSpec springSpecSpring$default2 = ArcSplineKt.spring$default(0.5f, 1500.0f, null, 4);
                    this.label = 1;
                    Object objAnimateTo$default4 = Animatable.animateTo$default(this.$predictiveBackProgress, f4, springSpecSpring$default2, null, this, 12);
                    CoroutineSingletons coroutineSingletons4 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objAnimateTo$default4 == coroutineSingletons4) {
                        return coroutineSingletons4;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
        }
    }
}
