package kotlin.uuid;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.DecayAnimationSpecImpl;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.snapping.AnimationResult;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateWithTarget$1;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.text.HexExtensionsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class UuidKt {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object access$animateDecay(ScrollScope scrollScope, float f, AnimationState animationState, DecayAnimationSpecImpl decayAnimationSpecImpl, Function1 function1, ContinuationImpl continuationImpl) {
        SnapFlingBehaviorKt$animateDecay$1 snapFlingBehaviorKt$animateDecay$1;
        float f2;
        Ref$FloatRef ref$FloatRef;
        if (continuationImpl instanceof SnapFlingBehaviorKt$animateDecay$1) {
            snapFlingBehaviorKt$animateDecay$1 = (SnapFlingBehaviorKt$animateDecay$1) continuationImpl;
            int i = snapFlingBehaviorKt$animateDecay$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                snapFlingBehaviorKt$animateDecay$1.label = i - Integer.MIN_VALUE;
            } else {
                snapFlingBehaviorKt$animateDecay$1 = new SnapFlingBehaviorKt$animateDecay$1(continuationImpl);
            }
        } else {
            snapFlingBehaviorKt$animateDecay$1 = new SnapFlingBehaviorKt$animateDecay$1(continuationImpl);
        }
        Object obj = snapFlingBehaviorKt$animateDecay$1.result;
        int i2 = snapFlingBehaviorKt$animateDecay$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
            boolean z = ((Number) animationState.getVelocity()).floatValue() == 0.0f;
            SnapFlingBehaviorKt$$ExternalSyntheticLambda0 snapFlingBehaviorKt$$ExternalSyntheticLambda0 = new SnapFlingBehaviorKt$$ExternalSyntheticLambda0(f, ref$FloatRef2, scrollScope, function1, 0);
            snapFlingBehaviorKt$animateDecay$1.L$0 = animationState;
            snapFlingBehaviorKt$animateDecay$1.L$1 = ref$FloatRef2;
            snapFlingBehaviorKt$animateDecay$1.F$0 = f;
            snapFlingBehaviorKt$animateDecay$1.label = 1;
            Object objAnimateDecay = ArcSplineKt.animateDecay(animationState, decayAnimationSpecImpl, !z, snapFlingBehaviorKt$$ExternalSyntheticLambda0, snapFlingBehaviorKt$animateDecay$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAnimateDecay == coroutineSingletons) {
                return coroutineSingletons;
            }
            f2 = f;
            ref$FloatRef = ref$FloatRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f2 = snapFlingBehaviorKt$animateDecay$1.F$0;
            ref$FloatRef = snapFlingBehaviorKt$animateDecay$1.L$1;
            animationState = snapFlingBehaviorKt$animateDecay$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return new AnimationResult(new Float(f2 - ref$FloatRef.element), animationState);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public static final Object access$animateWithTarget(ScrollScope scrollScope, float f, float f2, AnimationState animationState, AnimationSpec animationSpec, Function1 function1, ContinuationImpl continuationImpl) {
        SnapFlingBehaviorKt$animateWithTarget$1 snapFlingBehaviorKt$animateWithTarget$1;
        float fFloatValue;
        AnimationState animationState2;
        Ref$FloatRef ref$FloatRef;
        float f3 = f;
        if (continuationImpl instanceof SnapFlingBehaviorKt$animateWithTarget$1) {
            snapFlingBehaviorKt$animateWithTarget$1 = (SnapFlingBehaviorKt$animateWithTarget$1) continuationImpl;
            int i = snapFlingBehaviorKt$animateWithTarget$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                snapFlingBehaviorKt$animateWithTarget$1.label = i - Integer.MIN_VALUE;
            } else {
                snapFlingBehaviorKt$animateWithTarget$1 = new SnapFlingBehaviorKt$animateWithTarget$1(continuationImpl);
            }
        } else {
            snapFlingBehaviorKt$animateWithTarget$1 = new SnapFlingBehaviorKt$animateWithTarget$1(continuationImpl);
        }
        SnapFlingBehaviorKt$animateWithTarget$1 snapFlingBehaviorKt$animateWithTarget$2 = snapFlingBehaviorKt$animateWithTarget$1;
        Object obj = snapFlingBehaviorKt$animateWithTarget$2.result;
        int i2 = snapFlingBehaviorKt$animateWithTarget$2.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
            fFloatValue = ((Number) animationState.getVelocity()).floatValue();
            Float f4 = new Float(f3);
            boolean z = ((Number) animationState.getVelocity()).floatValue() == 0.0f;
            SnapFlingBehaviorKt$$ExternalSyntheticLambda0 snapFlingBehaviorKt$$ExternalSyntheticLambda0 = new SnapFlingBehaviorKt$$ExternalSyntheticLambda0(f2, ref$FloatRef2, scrollScope, function1, 1);
            snapFlingBehaviorKt$animateWithTarget$2.L$0 = animationState;
            snapFlingBehaviorKt$animateWithTarget$2.L$1 = ref$FloatRef2;
            snapFlingBehaviorKt$animateWithTarget$2.F$0 = f3;
            snapFlingBehaviorKt$animateWithTarget$2.F$1 = fFloatValue;
            snapFlingBehaviorKt$animateWithTarget$2.label = 1;
            Object objAnimateTo = ArcSplineKt.animateTo(animationState, f4, animationSpec, !z, snapFlingBehaviorKt$$ExternalSyntheticLambda0, snapFlingBehaviorKt$animateWithTarget$2);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAnimateTo == coroutineSingletons) {
                return coroutineSingletons;
            }
            animationState2 = animationState;
            ref$FloatRef = ref$FloatRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            float f5 = snapFlingBehaviorKt$animateWithTarget$2.F$1;
            float f6 = snapFlingBehaviorKt$animateWithTarget$2.F$0;
            ref$FloatRef = snapFlingBehaviorKt$animateWithTarget$2.L$1;
            animationState2 = snapFlingBehaviorKt$animateWithTarget$2.L$0;
            ResultKt.throwOnFailure(obj);
            fFloatValue = f5;
            f3 = f6;
        }
        return new AnimationResult(new Float(f3 - ref$FloatRef.element), ArcSplineKt.copy$default(animationState2, 0.0f, coerceToTarget(((Number) animationState2.getVelocity()).floatValue(), fFloatValue), 29));
    }

    public static final void animateDecay$consumeDelta(AnimationScope animationScope, ScrollScope scrollScope, Function1 function1, float f) {
        float fScrollBy;
        try {
            fScrollBy = scrollScope.scrollBy(f);
        } catch (CancellationException unused) {
            animationScope.cancelAnimation();
            fScrollBy = 0.0f;
        }
        function1.invoke(Float.valueOf(fScrollBy));
        if (Math.abs(f - fScrollBy) > 0.5f) {
            animationScope.cancelAnimation();
        }
    }

    public static final void checkHyphenAt(String str, int i) {
        if (str.charAt(i) == '-') {
            return;
        }
        StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "Expected '-' (hyphen) at index ", ", but was '");
        sbM.append(str.charAt(i));
        sbM.append('\'');
        throw new IllegalArgumentException(sbM.toString().toString());
    }

    public static final float coerceToTarget(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        return (f2 <= 0.0f ? f >= f2 : f <= f2) ? f : f2;
    }

    public static final void formatBytesInto(long j, byte[] bArr, int i, int i2, int i3) {
        int i4 = 7 - i2;
        int i5 = 8 - i3;
        if (i5 > i4) {
            return;
        }
        while (true) {
            int i6 = HexExtensionsKt.BYTE_TO_LOWER_CASE_HEX_DIGITS[(int) ((j >> (i4 << 3)) & 255)];
            int i7 = i + 1;
            bArr[i] = (byte) (i6 >> 8);
            i += 2;
            bArr[i7] = (byte) i6;
            if (i4 == i5) {
                return;
            } else {
                i4--;
            }
        }
    }
}
