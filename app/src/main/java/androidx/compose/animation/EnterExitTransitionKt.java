package androidx.compose.animation;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class EnterExitTransitionKt {
    public static final SpringSpec DefaultOffsetAnimationSpec;
    public static final SpringSpec DefaultSizeAnimationSpec;
    public static final TwoWayConverterImpl TransformOriginVectorConverter = new TwoWayConverterImpl(CrossfadeKt$Crossfade$3$1.INSTANCE$4, CrossfadeKt$Crossfade$3$1.INSTANCE$5);
    public static final SpringSpec DefaultAlphaAndScaleSpring = ArcSplineKt.spring$default(0.0f, 400.0f, null, 5);

    static {
        ArcSplineKt.spring$default(0.0f, 400.0f, null, 5);
        long j = 1;
        long j2 = (j & 4294967295L) | (j << 32);
        DefaultOffsetAnimationSpec = ArcSplineKt.spring$default(0.0f, 400.0f, new IntOffset(j2), 1);
        DefaultSizeAnimationSpec = ArcSplineKt.spring$default(0.0f, 400.0f, new IntSize(j2), 1);
    }

    public static EnterTransitionImpl expandVertically$default(TweenSpec tweenSpec, int i) {
        BiasAlignment biasAlignment;
        BiasAlignment.Vertical vertical = Alignment.Companion.Bottom;
        BiasAlignment.Vertical vertical2 = Alignment.Companion.Top;
        int i2 = 1;
        FiniteAnimationSpec finiteAnimationSpecSpring$default = tweenSpec;
        if ((i & 1) != 0) {
            long j = 1;
            finiteAnimationSpecSpring$default = ArcSplineKt.spring$default(0.0f, 400.0f, new IntSize((j & 4294967295L) | (j << 32)), 1);
        }
        BiasAlignment.Vertical vertical3 = (i & 2) != 0 ? vertical : vertical2;
        if (Intrinsics.areEqual(vertical3, vertical2)) {
            biasAlignment = Alignment.Companion.TopCenter;
        } else {
            biasAlignment = Intrinsics.areEqual(vertical3, vertical) ? Alignment.Companion.BottomCenter : Alignment.Companion.Center;
        }
        return new EnterTransitionImpl(new TransitionData((Fade) null, (Slide) null, new ChangeSize(biasAlignment, new CrossfadeKt$Crossfade$3$1(i2, 8), finiteAnimationSpecSpring$default), (Scale) null, (LinkedHashMap) null, 123));
    }

    public static EnterTransitionImpl fadeIn$default(TweenSpec tweenSpec, int i) {
        FiniteAnimationSpec finiteAnimationSpecSpring$default = tweenSpec;
        if ((i & 1) != 0) {
            finiteAnimationSpecSpring$default = ArcSplineKt.spring$default(0.0f, 400.0f, null, 5);
        }
        return new EnterTransitionImpl(new TransitionData(new Fade(finiteAnimationSpecSpring$default), (Slide) null, (ChangeSize) null, (Scale) null, (LinkedHashMap) null, 126));
    }

    public static ExitTransitionImpl fadeOut$default(TweenSpec tweenSpec, int i) {
        FiniteAnimationSpec finiteAnimationSpecSpring$default = tweenSpec;
        if ((i & 1) != 0) {
            finiteAnimationSpecSpring$default = ArcSplineKt.spring$default(0.0f, 400.0f, null, 5);
        }
        return new ExitTransitionImpl(new TransitionData(new Fade(finiteAnimationSpecSpring$default), (Slide) null, (ChangeSize) null, (Scale) null, (LinkedHashMap) null, 126));
    }

    public static ExitTransitionImpl shrinkVertically$default(TweenSpec tweenSpec, int i) {
        BiasAlignment biasAlignment;
        BiasAlignment.Vertical vertical = Alignment.Companion.Bottom;
        BiasAlignment.Vertical vertical2 = Alignment.Companion.Top;
        int i2 = 1;
        FiniteAnimationSpec finiteAnimationSpecSpring$default = tweenSpec;
        if ((i & 1) != 0) {
            long j = 1;
            finiteAnimationSpecSpring$default = ArcSplineKt.spring$default(0.0f, 400.0f, new IntSize((j & 4294967295L) | (j << 32)), 1);
        }
        BiasAlignment.Vertical vertical3 = (i & 2) != 0 ? vertical : vertical2;
        if (Intrinsics.areEqual(vertical3, vertical2)) {
            biasAlignment = Alignment.Companion.TopCenter;
        } else {
            biasAlignment = Intrinsics.areEqual(vertical3, vertical) ? Alignment.Companion.BottomCenter : Alignment.Companion.Center;
        }
        return new ExitTransitionImpl(new TransitionData((Fade) null, (Slide) null, new ChangeSize(biasAlignment, new CrossfadeKt$Crossfade$3$1(i2, 9), finiteAnimationSpecSpring$default), (Scale) null, (LinkedHashMap) null, 123));
    }

    public static EnterTransitionImpl slideInHorizontally$default(Function1 function1) {
        long j = 1;
        return new EnterTransitionImpl(new TransitionData((Fade) null, new Slide(new EnterExitTransitionKt$slideInHorizontally$2(function1, 0), ArcSplineKt.spring$default(0.0f, 400.0f, new IntOffset((j & 4294967295L) | (j << 32)), 1)), (ChangeSize) null, (Scale) null, (LinkedHashMap) null, 125));
    }

    public static ExitTransitionImpl slideOutHorizontally$default(Function1 function1) {
        long j = 1;
        return new ExitTransitionImpl(new TransitionData((Fade) null, new Slide(new EnterExitTransitionKt$slideInHorizontally$2(function1, 1), ArcSplineKt.spring$default(0.0f, 400.0f, new IntOffset((j & 4294967295L) | (j << 32)), 1)), (ChangeSize) null, (Scale) null, (LinkedHashMap) null, 125));
    }
}
