package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.DecayAnimationSpecImpl;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.node.NodeChain;
import androidx.core.view.MenuHostHelper;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt$GlassSnackbarHost$1$2$1$2$1;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultFlingBehavior implements FlingBehavior {
    public DecayAnimationSpecImpl flingDecay;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ float $initialVelocity;
        public final /* synthetic */ int $r8$classId = 0;
        public final /* synthetic */ Object $this_performFling;
        public Object L$0;
        public Object L$1;
        public int label;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(float f, DefaultFlingBehavior defaultFlingBehavior, ScrollScope scrollScope, Continuation continuation) {
            super(2, continuation);
            this.$initialVelocity = f;
            this.this$0 = defaultFlingBehavior;
            this.$this_performFling = scrollScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    return new AnonymousClass2(this.$initialVelocity, (DefaultFlingBehavior) this.this$0, (ScrollScope) this.$this_performFling, continuation);
                case 1:
                    return new AnonymousClass2((SnapFlingBehavior) this.L$1, this.$initialVelocity, (Function1) this.this$0, (ScrollScope) this.$this_performFling, continuation);
                default:
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2((Animatable) this.L$1, (SnackbarHostState.SnackbarDataImpl) this.this$0, (Animatable) this.$this_performFling, this.$initialVelocity, continuation);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
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
            }
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r4v2, types: [androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1$$ExternalSyntheticLambda0] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            float f;
            Ref$FloatRef ref$FloatRef;
            AnimationState animationState;
            final Ref$FloatRef ref$FloatRef2;
            AnonymousClass2 anonymousClass2;
            switch (this.$r8$classId) {
                case 0:
                    int i = this.label;
                    if (i != 0) {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        animationState = (AnimationState) this.L$1;
                        ref$FloatRef = (Ref$FloatRef) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (CancellationException unused) {
                            ref$FloatRef.element = ((Number) animationState.getVelocity()).floatValue();
                        }
                        f = ref$FloatRef.element;
                        break;
                    } else {
                        ResultKt.throwOnFailure(obj);
                        f = this.$initialVelocity;
                        if (Math.abs(f) > 1.0f) {
                            Ref$FloatRef ref$FloatRef3 = new Ref$FloatRef();
                            ref$FloatRef3.element = f;
                            Ref$FloatRef ref$FloatRef4 = new Ref$FloatRef();
                            AnimationState animationStateAnimationState$default = ArcSplineKt.AnimationState$default(0.0f, f, 28);
                            try {
                                DefaultFlingBehavior defaultFlingBehavior = (DefaultFlingBehavior) this.this$0;
                                DecayAnimationSpecImpl decayAnimationSpecImpl = defaultFlingBehavior.flingDecay;
                                LifecycleEffectKt$$ExternalSyntheticLambda1 lifecycleEffectKt$$ExternalSyntheticLambda1 = new LifecycleEffectKt$$ExternalSyntheticLambda1(ref$FloatRef4, (ScrollScope) this.$this_performFling, ref$FloatRef3, defaultFlingBehavior);
                                this.L$0 = ref$FloatRef3;
                                this.L$1 = animationStateAnimationState$default;
                                this.label = 1;
                                Object objAnimateDecay = ArcSplineKt.animateDecay(animationStateAnimationState$default, decayAnimationSpecImpl, false, lifecycleEffectKt$$ExternalSyntheticLambda1, this);
                                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                if (objAnimateDecay == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                                ref$FloatRef = ref$FloatRef3;
                                f = ref$FloatRef.element;
                            } catch (CancellationException unused2) {
                                ref$FloatRef = ref$FloatRef3;
                                animationState = animationStateAnimationState$default;
                                ref$FloatRef.element = ((Number) animationState.getVelocity()).floatValue();
                            }
                        }
                    }
                    return new Float(f);
                case 1:
                    final Function1 function1 = (Function1) this.this$0;
                    SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) this.L$1;
                    int i2 = this.label;
                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        DecayAnimationSpecImpl decayAnimationSpecImpl2 = ScrollableKt.NoOpDecayAnimationSpec;
                        float f2 = this.$initialVelocity;
                        ArcSplineKt.calculateTargetValue(decayAnimationSpecImpl2, 0.0f, f2);
                        if (Float.isNaN(0.0f)) {
                            InlineClassHelperKt.throwIllegalStateException("calculateApproachOffset returned NaN. Please use a valid value.");
                        }
                        final Ref$FloatRef ref$FloatRef5 = new Ref$FloatRef();
                        float fSignum = Math.signum(f2) * Math.abs(0.0f);
                        ref$FloatRef5.element = fSignum;
                        function1.invoke(new Float(fSignum));
                        ScrollScope scrollScope = (ScrollScope) this.$this_performFling;
                        float f3 = ref$FloatRef5.element;
                        final int i3 = 0;
                        ?? r4 = new Function1() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                int i4 = i3;
                                float fFloatValue = ((Float) obj2).floatValue();
                                switch (i4) {
                                    case 0:
                                        Ref$FloatRef ref$FloatRef6 = ref$FloatRef5;
                                        float f4 = ref$FloatRef6.element - fFloatValue;
                                        ref$FloatRef6.element = f4;
                                        function1.invoke(Float.valueOf(f4));
                                        break;
                                    default:
                                        Ref$FloatRef ref$FloatRef7 = ref$FloatRef5;
                                        float f5 = ref$FloatRef7.element - fFloatValue;
                                        ref$FloatRef7.element = f5;
                                        function1.invoke(Float.valueOf(f5));
                                        break;
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        this.L$0 = ref$FloatRef5;
                        this.label = 1;
                        Object objAccess$tryApproach = SnapFlingBehavior.access$tryApproach(snapFlingBehavior, scrollScope, f3, this.$initialVelocity, r4, this);
                        if (objAccess$tryApproach != coroutineSingletons2) {
                            ref$FloatRef2 = ref$FloatRef5;
                            obj = objAccess$tryApproach;
                        }
                        return coroutineSingletons2;
                    }
                    if (i2 != 1) {
                        if (i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    ref$FloatRef2 = (Ref$FloatRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    AnimationState animationState2 = (AnimationState) obj;
                    MenuHostHelper menuHostHelper = snapFlingBehavior.snapLayoutInfoProvider;
                    float fFloatValue = ((Number) animationState2.getVelocity()).floatValue();
                    NodeChain nodeChain = (NodeChain) menuHostHelper.mOnInvalidateMenuCallback;
                    float fRequireOffset = nodeChain.requireOffset();
                    Object objAccess$computeTarget = ScrollableKt.access$computeTarget(nodeChain.getAnchors(), fRequireOffset, fFloatValue, (Function1) menuHostHelper.mMenuProviders, (BasicTextKt$$ExternalSyntheticLambda0) menuHostHelper.mProviderToLifecycleContainers);
                    if (!((Boolean) ((Function1) nodeChain.layoutNode).invoke(objAccess$computeTarget)).booleanValue()) {
                        objAccess$computeTarget = ((ParcelableSnapshotMutableState) nodeChain.outerCoordinator).getValue();
                    }
                    float fPositionOf = nodeChain.getAnchors().positionOf(objAccess$computeTarget) - fRequireOffset;
                    if (Float.isNaN(fPositionOf)) {
                        InlineClassHelperKt.throwIllegalStateException("calculateSnapOffset returned NaN. Please use a valid value.");
                    }
                    ref$FloatRef2.element = fPositionOf;
                    ScrollScope scrollScope2 = (ScrollScope) this.$this_performFling;
                    AnimationState animationStateCopy$default = ArcSplineKt.copy$default(animationState2, 0.0f, 0.0f, 30);
                    AnimationSpec animationSpec = snapFlingBehavior.snapAnimationSpec;
                    final int i4 = 1;
                    Function1 function2 = new Function1() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            int i5 = i4;
                            float fFloatValue2 = ((Float) obj2).floatValue();
                            switch (i5) {
                                case 0:
                                    Ref$FloatRef ref$FloatRef6 = ref$FloatRef2;
                                    float f4 = ref$FloatRef6.element - fFloatValue2;
                                    ref$FloatRef6.element = f4;
                                    function1.invoke(Float.valueOf(f4));
                                    break;
                                default:
                                    Ref$FloatRef ref$FloatRef7 = ref$FloatRef2;
                                    float f5 = ref$FloatRef7.element - fFloatValue2;
                                    ref$FloatRef7.element = f5;
                                    function1.invoke(Float.valueOf(f5));
                                    break;
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    this.L$0 = null;
                    this.label = 2;
                    Object objAccess$animateWithTarget = UuidKt.access$animateWithTarget(scrollScope2, fPositionOf, fPositionOf, animationStateCopy$default, animationSpec, function2, this);
                    if (objAccess$animateWithTarget != coroutineSingletons2) {
                        return objAccess$animateWithTarget;
                    }
                    return coroutineSingletons2;
                default:
                    int i5 = this.label;
                    if (i5 == 0) {
                        ResultKt.throwOnFailure(obj);
                        JobKt.launch$default((CoroutineScope) this.L$0, null, new GlassSnackbarKt$GlassSnackbarHost$1$2$1$2$1((Animatable) this.$this_performFling, this.$initialVelocity, null, 1), 3);
                        Animatable animatable = (Animatable) this.L$1;
                        Float f4 = new Float(0.0f);
                        TweenSpec tweenSpecTween$default = ArcSplineKt.tween$default(200, 6, null);
                        this.label = 1;
                        Object objAnimateTo$default = Animatable.animateTo$default(animatable, f4, tweenSpecTween$default, null, this, 12);
                        anonymousClass2 = this;
                        CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objAnimateTo$default == coroutineSingletons3) {
                            return coroutineSingletons3;
                        }
                    } else {
                        if (i5 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        anonymousClass2 = this;
                    }
                    ((SnackbarHostState.SnackbarDataImpl) anonymousClass2.this$0).dismiss();
                    return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Animatable animatable, SnackbarHostState.SnackbarDataImpl snackbarDataImpl, Animatable animatable2, float f, Continuation continuation) {
            super(2, continuation);
            this.L$1 = animatable;
            this.this$0 = snackbarDataImpl;
            this.$this_performFling = animatable2;
            this.$initialVelocity = f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SnapFlingBehavior snapFlingBehavior, float f, Function1 function1, ScrollScope scrollScope, Continuation continuation) {
            super(2, continuation);
            this.L$1 = snapFlingBehavior;
            this.$initialVelocity = f;
            this.this$0 = function1;
            this.$this_performFling = scrollScope;
        }
    }

    public DefaultFlingBehavior(DecayAnimationSpecImpl decayAnimationSpecImpl) {
        this.flingDecay = decayAnimationSpecImpl;
    }

    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public final Object performFling(ScrollScope scrollScope, float f, Continuation continuation) {
        return JobKt.withContext(ScrollableKt.DefaultScrollMotionDurationScale, new AnonymousClass2(f, this, scrollScope, null), continuation);
    }
}
