package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SnackbarHostKt$animatedOpacity$2$1 extends SuspendLambda implements Function2 {
    public Object $alpha;
    public final /* synthetic */ Object $animation;
    public final /* synthetic */ Object $onAnimationFinish;
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ boolean $visible;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnackbarHostKt$animatedOpacity$2$1(Animatable animatable, boolean z, AnimationSpec animationSpec, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.$alpha = animatable;
        this.$visible = z;
        this.$animation = animationSpec;
        this.$onAnimationFinish = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new SnackbarHostKt$animatedOpacity$2$1((Animatable) this.$alpha, this.$visible, (AnimationSpec) this.$animation, (Function0) this.$onAnimationFinish, continuation);
            default:
                return new SnackbarHostKt$animatedOpacity$2$1((MutableState) this.$animation, this.$visible, (MutableInteractionSourceImpl) this.$onAnimationFinish, continuation);
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
        return ((SnackbarHostKt$animatedOpacity$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SnackbarHostKt$animatedOpacity$2$1 snackbarHostKt$animatedOpacity$2$1;
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = (Animatable) this.$alpha;
                    Float f = new Float(this.$visible ? 1.0f : 0.0f);
                    AnimationSpec animationSpec = (AnimationSpec) this.$animation;
                    this.label = 1;
                    snackbarHostKt$animatedOpacity$2$1 = this;
                    Object objAnimateTo$default = Animatable.animateTo$default(animatable, f, animationSpec, null, snackbarHostKt$animatedOpacity$2$1, 12);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objAnimateTo$default == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    snackbarHostKt$animatedOpacity$2$1 = this;
                }
                ((Function0) snackbarHostKt$animatedOpacity$2$1.$onAnimationFinish).invoke();
                return Unit.INSTANCE;
            default:
                MutableState mutableState = (MutableState) this.$animation;
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    PressInteraction.Press press = (PressInteraction.Press) mutableState.getValue();
                    if (press != null) {
                        MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) this.$onAnimationFinish;
                        Interaction release = this.$visible ? new PressInteraction.Release(press) : new PressInteraction.Cancel(press);
                        if (mutableInteractionSourceImpl != null) {
                            this.$alpha = mutableState;
                            this.label = 1;
                            Object objEmit = mutableInteractionSourceImpl.emit(release, this);
                            CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                            if (objEmit == coroutineSingletons2) {
                                return coroutineSingletons2;
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableState = (MutableState) this.$alpha;
                ResultKt.throwOnFailure(obj);
                mutableState.setValue(null);
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnackbarHostKt$animatedOpacity$2$1(MutableState mutableState, boolean z, MutableInteractionSourceImpl mutableInteractionSourceImpl, Continuation continuation) {
        super(2, continuation);
        this.$animation = mutableState;
        this.$visible = z;
        this.$onAnimationFinish = mutableInteractionSourceImpl;
    }
}
