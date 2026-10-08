package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.internal.ripple.AndroidRippleNode;
import androidx.compose.material3.internal.ripple.RippleNodeConfig;
import androidx.compose.material3.internal.ripple.RippleNodeConfig$Focus$InsetRing;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import com.google.android.gms.internal.mlkit_vision_barcode.zzry;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SnackbarHostKt$animatedScale$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $animation;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object $scale;
    public final /* synthetic */ boolean $visible;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SnackbarHostKt$animatedScale$1$1(Object obj, boolean z, Object obj2, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$scale = obj;
        this.$visible = z;
        this.$animation = obj2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new SnackbarHostKt$animatedScale$1$1((Animatable) this.$scale, this.$visible, (AnimationSpec) this.$animation, continuation, 0);
            case 1:
                return new SnackbarHostKt$animatedScale$1$1((AndroidRippleNode) this.$scale, this.$visible, (RippleNodeConfig) this.$animation, continuation, 1);
            case 2:
                return new SnackbarHostKt$animatedScale$1$1(this.$visible, (List) this.$scale, (LazyListState) this.$animation, continuation, 2);
            default:
                return new SnackbarHostKt$animatedScale$1$1(this.$visible, (Long) this.$scale, (MutableState) this.$animation, continuation, 3);
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
        return ((SnackbarHostKt$animatedScale$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objDelay;
        CoroutineSingletons coroutineSingletons;
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = (Animatable) this.$scale;
                    Float f = new Float(this.$visible ? 1.0f : 0.8f);
                    AnimationSpec animationSpec = (AnimationSpec) this.$animation;
                    this.label = 1;
                    Object objAnimateTo$default = Animatable.animateTo$default(animatable, f, animationSpec, null, this, 12);
                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objAnimateTo$default == coroutineSingletons2) {
                        return coroutineSingletons2;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 1:
                zzry zzryVar = ((RippleNodeConfig) this.$animation).focus;
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable2 = ((AndroidRippleNode) this.$scale).animatedFocusRingInterpolation;
                    boolean z = this.$visible;
                    Float f2 = new Float(z ? 1.0f : 0.0f);
                    FiniteAnimationSpec finiteAnimationSpec = z ? ((RippleNodeConfig$Focus$InsetRing) zzryVar).focusingAnimationSpec : ((RippleNodeConfig$Focus$InsetRing) zzryVar).unfocusingAnimationSpec;
                    this.label = 1;
                    Object objAnimateTo$default2 = Animatable.animateTo$default(animatable2, f2, finiteAnimationSpec, null, this, 12);
                    CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objAnimateTo$default2 == coroutineSingletons3) {
                        return coroutineSingletons3;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 2:
                LazyListState lazyListState = (LazyListState) this.$animation;
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.$visible && !((List) this.$scale).isEmpty() && ((ParcelableSnapshotMutableIntState) lazyListState.scrollPosition.call).getIntValue() <= 1) {
                        this.label = 1;
                        Object objScrollToItem$default = LazyListState.scrollToItem$default(lazyListState, 0, this);
                        CoroutineSingletons coroutineSingletons4 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objScrollToItem$default == coroutineSingletons4) {
                            return coroutineSingletons4;
                        }
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
                    if (!this.$visible || ((Long) this.$scale) == null) {
                        return Unit.INSTANCE;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                do {
                    ((MutableState) this.$animation).setValue(Long.valueOf(System.currentTimeMillis()));
                    this.label = 1;
                    objDelay = JobKt.delay(500L, this);
                    coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                } while (objDelay != coroutineSingletons);
                return coroutineSingletons;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SnackbarHostKt$animatedScale$1$1(boolean z, Object obj, Object obj2, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$visible = z;
        this.$scale = obj;
        this.$animation = obj2;
    }
}
