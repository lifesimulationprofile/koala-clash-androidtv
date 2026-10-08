package androidx.compose.foundation.style;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class StyleAnimations$Entry$snapOut$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public int label;
    public final /* synthetic */ StyleAnimations.Entry this$0;
    public final /* synthetic */ StyleAnimations this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StyleAnimations$Entry$snapOut$1(StyleAnimations.Entry entry, StyleAnimations styleAnimations, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = entry;
        this.this$1 = styleAnimations;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new StyleAnimations$Entry$snapOut$1(this.this$0, this.this$1, continuation, 0);
            default:
                return new StyleAnimations$Entry$snapOut$1(this.this$0, this.this$1, continuation, 1);
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
        return ((StyleAnimations$Entry$snapOut$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Throwable th;
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                StyleAnimations styleAnimations = this.this$1;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Animatable animatable = this.this$0.anim;
                        Float f = new Float(0.0f);
                        this.label = 1;
                        Object objSnapTo = animatable.snapTo(f, this);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objSnapTo == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    StyleAnimations.access$cleanupAnimations(styleAnimations);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    StyleAnimations.access$cleanupAnimations(styleAnimations);
                    throw th2;
                }
            default:
                StyleAnimations.Entry entry = this.this$0;
                int i2 = this.label;
                StyleAnimations styleAnimations2 = this.this$1;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        Animatable animatable2 = entry.anim;
                        Float f2 = new Float(0.0f);
                        AnimationSpec animationSpec = entry.fromSpec;
                        this.label = 1;
                        try {
                            obj = Animatable.animateTo$default(animatable2, f2, animationSpec, null, this, 12);
                            CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                            if (obj == coroutineSingletons2) {
                                return coroutineSingletons2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            th = th;
                            StyleAnimations.access$cleanupAnimations(styleAnimations2);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        th = th;
                        StyleAnimations.access$cleanupAnimations(styleAnimations2);
                        throw th;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th5) {
                        th = th5;
                        StyleAnimations.access$cleanupAnimations(styleAnimations2);
                        throw th;
                    }
                }
                StyleAnimations.access$cleanupAnimations(styleAnimations2);
                return Unit.INSTANCE;
        }
    }
}
