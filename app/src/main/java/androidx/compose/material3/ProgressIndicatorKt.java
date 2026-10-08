package androidx.compose.material3;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AccessibilityUtilKt;
import androidx.compose.material3.tokens.CircularProgressIndicatorTokens;
import androidx.compose.material3.tokens.LinearProgressIndicatorTokens;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda10;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.MenuHostHelper;
import coil.request.Parameters;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProgressIndicatorKt {
    public static final float CircularIndicatorDiameter;
    public static final CubicBezierEasing CircularProgressEasing;
    public static final CubicBezierEasing LinearIndeterminateProgressEasing;
    public static final float LinearIndicatorHeight;
    public static final float LinearIndicatorWidth = 240;

    static {
        float f = LinearProgressIndicatorTokens.Height;
        LinearIndicatorHeight = LinearProgressIndicatorTokens.Height;
        float f2 = CircularProgressIndicatorTokens.Size;
        CircularIndicatorDiameter = CircularProgressIndicatorTokens.Size;
        CubicBezierEasing cubicBezierEasing = MotionTokens.EasingEmphasizedAccelerateCubicBezier;
        LinearIndeterminateProgressEasing = MotionTokens.EasingEmphasizedAccelerateCubicBezier;
        CircularProgressEasing = MotionTokens.EasingStandardCubicBezier;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0063  */
    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x006e  */
    /* JADX WARN: Code duplicated, block: B:43:0x008b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x008d  */
    /* JADX WARN: Code duplicated, block: B:45:0x0090  */
    /* JADX WARN: Code duplicated, block: B:47:0x0093  */
    /* JADX WARN: Code duplicated, block: B:51:0x0156  */
    /* JADX WARN: Code duplicated, block: B:52:0x0158  */
    /* JADX WARN: Code duplicated, block: B:65:0x0191  */
    /* JADX WARN: Code duplicated, block: B:69:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:72:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: CircularProgressIndicator-4lLiAd8, reason: not valid java name */
    public static final void m256CircularProgressIndicator4lLiAd8(Modifier modifier, final long j, float f, long j2, int i, float f2, GapComposer gapComposer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        float f3;
        int i5;
        boolean z;
        final long j3;
        final float f4;
        final Modifier modifier3;
        final float f5;
        final int i6;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Modifier modifier4;
        int i7;
        int i8;
        float f6;
        float f7;
        final long j4;
        final Stroke stroke;
        int i9;
        final InfiniteTransition.TransitionAnimationState transitionAnimationStateAnimateFloat;
        final InfiniteTransition.TransitionAnimationState transitionAnimationStateAnimateFloat2;
        float f8;
        float f9;
        final InfiniteTransition.TransitionAnimationState transitionAnimationStateAnimateFloat3;
        boolean z2;
        boolean zChanged;
        Object obj;
        final int i10;
        Modifier modifier5;
        final float f10;
        gapComposer.startRestartGroup(333154241);
        int i11 = i3 & 1;
        if (i11 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (gapComposer.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= gapComposer.changed(j) ? 32 : 16;
        }
        int i12 = i3 & 4;
        if (i12 == 0) {
            if ((i2 & 384) == 0) {
                f3 = f;
                i4 |= gapComposer.changed(f3) ? 256 : 128;
            }
            i5 = i4 | 222208;
            if ((74899 & i5) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i5 & 1, z)) {
                gapComposer.startDefaults();
                if ((i2 & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                    if (i11 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i12 != 0) {
                        f3 = ProgressIndicatorDefaults.CircularStrokeWidth;
                    }
                    float f11 = ProgressIndicatorDefaults.CircularStrokeWidth;
                    long j5 = Color.Transparent;
                    i7 = i5 & (-7169);
                    i8 = ProgressIndicatorDefaults.CircularIndeterminateStrokeCap;
                    f6 = ProgressIndicatorDefaults.CircularIndicatorTrackGapSize;
                    f7 = f3;
                    j4 = j5;
                } else {
                    gapComposer.skipToGroupEnd();
                    int i13 = i5 & (-7169);
                    f6 = f2;
                    i7 = i13;
                    modifier4 = modifier2;
                    f7 = f3;
                    j4 = j2;
                    i8 = i;
                }
                gapComposer.endDefaults();
                i9 = i8;
                stroke = new Stroke(((Density) gapComposer.consume(CompositionLocalsKt.LocalDensity)).mo92toPx0680j_4(f7), 0.0f, i9, 0, 26);
                InfiniteTransition infiniteTransitionRememberInfiniteTransition = ArcSplineKt.rememberInfiniteTransition(gapComposer);
                transitionAnimationStateAnimateFloat = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1080.0f, ArcSplineKt.m28infiniteRepeatable9IiC70o$default(ArcSplineKt.tween$default(6000, 2, EasingKt.LinearEasing)), gapComposer);
                SaversKt$$ExternalSyntheticLambda10 saversKt$$ExternalSyntheticLambda10 = new SaversKt$$ExternalSyntheticLambda10(12);
                KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig = new KeyframesSpec.KeyframesSpecConfig();
                saversKt$$ExternalSyntheticLambda10.invoke(keyframesSpecConfig);
                transitionAnimationStateAnimateFloat2 = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 360.0f, ArcSplineKt.m28infiniteRepeatable9IiC70o$default(new KeyframesSpec(keyframesSpecConfig)), gapComposer);
                KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig2 = new KeyframesSpec.KeyframesSpecConfig();
                f8 = f6;
                keyframesSpecConfig2.durationMillis = 6000;
                f9 = f7;
                keyframesSpecConfig2.at(Float.valueOf(0.87f), 3000).easing = CircularProgressEasing;
                keyframesSpecConfig2.at(Float.valueOf(0.1f), 6000);
                Unit unit = Unit.INSTANCE;
                transitionAnimationStateAnimateFloat3 = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.1f, 0.87f, ArcSplineKt.m28infiniteRepeatable9IiC70o$default(new KeyframesSpec(keyframesSpecConfig2)), gapComposer);
                Modifier modifierM140size3ABfNKs = SizeKt.m140size3ABfNKs(SemanticsModifierKt.semantics(modifier4, true, new BorderKt$$ExternalSyntheticLambda1(24)), CircularIndicatorDiameter);
                boolean zChanged2 = gapComposer.changed(transitionAnimationStateAnimateFloat3);
                if ((i7 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged = zChanged2 | z2 | gapComposer.changed(transitionAnimationStateAnimateFloat) | gapComposer.changed(transitionAnimationStateAnimateFloat2) | gapComposer.changed(j4) | gapComposer.changedInstance(stroke) | ((((i7 & 112) ^ 48) <= 32 && gapComposer.changed(j)) || (i7 & 48) == 32);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (!zChanged || objRememberedValue == Composer$Companion.Empty) {
                    i10 = i9;
                    f5 = f9;
                    modifier5 = modifier4;
                    f10 = f8;
                    obj = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) throws Throwable {
                            long j6;
                            long j7 = j4;
                            Stroke stroke2 = stroke;
                            long j8 = j;
                            DrawScope drawScope = (DrawScope) obj2;
                            float fFloatValue = ((Number) transitionAnimationStateAnimateFloat3.getValue()).floatValue() * 360.0f;
                            int i14 = i10;
                            float f12 = f10;
                            if (i14 != 0 && Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() & 4294967295L)) <= Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32))) {
                                f12 += f5;
                            }
                            float fMo88toDpu2uoSUM = (f12 / ((float) (((double) drawScope.mo88toDpu2uoSUM(Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32)))) * 3.141592653589793d))) * 360.0f;
                            float fFloatValue2 = ((Number) transitionAnimationStateAnimateFloat2.getValue()).floatValue() + ((Number) transitionAnimationStateAnimateFloat.getValue()).floatValue();
                            long jMo473getCenterF1C5BW0 = drawScope.mo473getCenterF1C5BW0();
                            MenuHostHelper drawContext = drawScope.getDrawContext();
                            long jM756getSizeNHjbRc = drawContext.m756getSizeNHjbRc();
                            drawContext.getCanvas().save();
                            try {
                                ((Parameters.Builder) drawContext.mOnInvalidateMenuCallback).m791rotateUv8p0NA(fFloatValue2, jMo473getCenterF1C5BW0);
                                ProgressIndicatorKt.m258drawCircularIndicator42QJj7c(drawScope, Math.min(fFloatValue, fMo88toDpu2uoSUM) + fFloatValue, (360.0f - fFloatValue) - (Math.min(fFloatValue, fMo88toDpu2uoSUM) * 2), j7, stroke2);
                                j6 = jM756getSizeNHjbRc;
                                try {
                                    ProgressIndicatorKt.m258drawCircularIndicator42QJj7c(drawScope, 0.0f, fFloatValue, j8, stroke2);
                                    ImageAnalysis$$ExternalSyntheticLambda1.m(drawContext, j6);
                                    return Unit.INSTANCE;
                                } catch (Throwable th) {
                                    th = th;
                                    ImageAnalysis$$ExternalSyntheticLambda1.m(drawContext, j6);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                j6 = jM756getSizeNHjbRc;
                            }
                        }
                    };
                    gapComposer.updateRememberedValue(obj);
                } else {
                    f10 = f8;
                    modifier5 = modifier4;
                    obj = objRememberedValue;
                    i10 = i9;
                    f5 = f9;
                }
                ImageKt.Canvas(modifierM140size3ABfNKs, (Function1) obj, gapComposer, 0);
                j3 = j4;
                modifier3 = modifier5;
                i6 = i10;
                f4 = f10;
            } else {
                gapComposer.skipToGroupEnd();
                j3 = j2;
                f4 = f2;
                modifier3 = modifier2;
                f5 = f3;
                i6 = i;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        ((Integer) obj3).getClass();
                        ProgressIndicatorKt.m256CircularProgressIndicator4lLiAd8(modifier3, j, f5, j3, i6, f4, (GapComposer) obj2, Stack.updateChangedFlags(i2 | 1), i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 |= 384;
        f3 = f;
        i5 = i4 | 222208;
        if ((74899 & i5) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer.shouldExecute(i5 & 1, z)) {
            gapComposer.startDefaults();
            if ((i2 & 1) != 0) {
                if (i11 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i12 != 0) {
                    f3 = ProgressIndicatorDefaults.CircularStrokeWidth;
                }
                float f12 = ProgressIndicatorDefaults.CircularStrokeWidth;
                long j6 = Color.Transparent;
                i7 = i5 & (-7169);
                i8 = ProgressIndicatorDefaults.CircularIndeterminateStrokeCap;
                f6 = ProgressIndicatorDefaults.CircularIndicatorTrackGapSize;
                f7 = f3;
                j4 = j6;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i12 != 0) {
                    f3 = ProgressIndicatorDefaults.CircularStrokeWidth;
                }
                float f13 = ProgressIndicatorDefaults.CircularStrokeWidth;
                long j7 = Color.Transparent;
                i7 = i5 & (-7169);
                i8 = ProgressIndicatorDefaults.CircularIndeterminateStrokeCap;
                f6 = ProgressIndicatorDefaults.CircularIndicatorTrackGapSize;
                f7 = f3;
                j4 = j7;
            }
            gapComposer.endDefaults();
            i9 = i8;
            stroke = new Stroke(((Density) gapComposer.consume(CompositionLocalsKt.LocalDensity)).mo92toPx0680j_4(f7), 0.0f, i9, 0, 26);
            InfiniteTransition infiniteTransitionRememberInfiniteTransition2 = ArcSplineKt.rememberInfiniteTransition(gapComposer);
            transitionAnimationStateAnimateFloat = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 1080.0f, ArcSplineKt.m28infiniteRepeatable9IiC70o$default(ArcSplineKt.tween$default(6000, 2, EasingKt.LinearEasing)), gapComposer);
            SaversKt$$ExternalSyntheticLambda10 saversKt$$ExternalSyntheticLambda11 = new SaversKt$$ExternalSyntheticLambda10(12);
            KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig3 = new KeyframesSpec.KeyframesSpecConfig();
            saversKt$$ExternalSyntheticLambda11.invoke(keyframesSpecConfig3);
            transitionAnimationStateAnimateFloat2 = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 360.0f, ArcSplineKt.m28infiniteRepeatable9IiC70o$default(new KeyframesSpec(keyframesSpecConfig3)), gapComposer);
            KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig4 = new KeyframesSpec.KeyframesSpecConfig();
            f8 = f6;
            keyframesSpecConfig4.durationMillis = 6000;
            f9 = f7;
            keyframesSpecConfig4.at(Float.valueOf(0.87f), 3000).easing = CircularProgressEasing;
            keyframesSpecConfig4.at(Float.valueOf(0.1f), 6000);
            Unit unit2 = Unit.INSTANCE;
            transitionAnimationStateAnimateFloat3 = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.1f, 0.87f, ArcSplineKt.m28infiniteRepeatable9IiC70o$default(new KeyframesSpec(keyframesSpecConfig4)), gapComposer);
            Modifier modifierM140size3ABfNKs2 = SizeKt.m140size3ABfNKs(SemanticsModifierKt.semantics(modifier4, true, new BorderKt$$ExternalSyntheticLambda1(24)), CircularIndicatorDiameter);
            boolean zChanged3 = gapComposer.changed(transitionAnimationStateAnimateFloat3);
            if ((i7 & 896) == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            zChanged = zChanged3 | z2 | gapComposer.changed(transitionAnimationStateAnimateFloat) | gapComposer.changed(transitionAnimationStateAnimateFloat2) | gapComposer.changed(j4) | gapComposer.changedInstance(stroke) | ((((i7 & 112) ^ 48) <= 32 && gapComposer.changed(j)) || (i7 & 48) == 32);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged) {
                i10 = i9;
                f5 = f9;
                modifier5 = modifier4;
                f10 = f8;
                obj = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) throws Throwable {
                        long j8;
                        long j9 = j4;
                        Stroke stroke2 = stroke;
                        long j10 = j;
                        DrawScope drawScope = (DrawScope) obj2;
                        float fFloatValue = ((Number) transitionAnimationStateAnimateFloat3.getValue()).floatValue() * 360.0f;
                        int i14 = i10;
                        float f14 = f10;
                        if (i14 != 0 && Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() & 4294967295L)) <= Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32))) {
                            f14 += f5;
                        }
                        float fMo88toDpu2uoSUM = (f14 / ((float) (((double) drawScope.mo88toDpu2uoSUM(Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32)))) * 3.141592653589793d))) * 360.0f;
                        float fFloatValue2 = ((Number) transitionAnimationStateAnimateFloat2.getValue()).floatValue() + ((Number) transitionAnimationStateAnimateFloat.getValue()).floatValue();
                        long jMo473getCenterF1C5BW0 = drawScope.mo473getCenterF1C5BW0();
                        MenuHostHelper drawContext = drawScope.getDrawContext();
                        long jM756getSizeNHjbRc = drawContext.m756getSizeNHjbRc();
                        drawContext.getCanvas().save();
                        try {
                            ((Parameters.Builder) drawContext.mOnInvalidateMenuCallback).m791rotateUv8p0NA(fFloatValue2, jMo473getCenterF1C5BW0);
                            ProgressIndicatorKt.m258drawCircularIndicator42QJj7c(drawScope, Math.min(fFloatValue, fMo88toDpu2uoSUM) + fFloatValue, (360.0f - fFloatValue) - (Math.min(fFloatValue, fMo88toDpu2uoSUM) * 2), j9, stroke2);
                            j8 = jM756getSizeNHjbRc;
                            try {
                                ProgressIndicatorKt.m258drawCircularIndicator42QJj7c(drawScope, 0.0f, fFloatValue, j10, stroke2);
                                ImageAnalysis$$ExternalSyntheticLambda1.m(drawContext, j8);
                                return Unit.INSTANCE;
                            } catch (Throwable th) {
                                th = th;
                                ImageAnalysis$$ExternalSyntheticLambda1.m(drawContext, j8);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            j8 = jM756getSizeNHjbRc;
                        }
                    }
                };
                gapComposer.updateRememberedValue(obj);
            } else {
                i10 = i9;
                f5 = f9;
                modifier5 = modifier4;
                f10 = f8;
                obj = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) throws Throwable {
                        long j8;
                        long j9 = j4;
                        Stroke stroke2 = stroke;
                        long j10 = j;
                        DrawScope drawScope = (DrawScope) obj2;
                        float fFloatValue = ((Number) transitionAnimationStateAnimateFloat3.getValue()).floatValue() * 360.0f;
                        int i14 = i10;
                        float f14 = f10;
                        if (i14 != 0 && Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() & 4294967295L)) <= Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32))) {
                            f14 += f5;
                        }
                        float fMo88toDpu2uoSUM = (f14 / ((float) (((double) drawScope.mo88toDpu2uoSUM(Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32)))) * 3.141592653589793d))) * 360.0f;
                        float fFloatValue2 = ((Number) transitionAnimationStateAnimateFloat2.getValue()).floatValue() + ((Number) transitionAnimationStateAnimateFloat.getValue()).floatValue();
                        long jMo473getCenterF1C5BW0 = drawScope.mo473getCenterF1C5BW0();
                        MenuHostHelper drawContext = drawScope.getDrawContext();
                        long jM756getSizeNHjbRc = drawContext.m756getSizeNHjbRc();
                        drawContext.getCanvas().save();
                        try {
                            ((Parameters.Builder) drawContext.mOnInvalidateMenuCallback).m791rotateUv8p0NA(fFloatValue2, jMo473getCenterF1C5BW0);
                            ProgressIndicatorKt.m258drawCircularIndicator42QJj7c(drawScope, Math.min(fFloatValue, fMo88toDpu2uoSUM) + fFloatValue, (360.0f - fFloatValue) - (Math.min(fFloatValue, fMo88toDpu2uoSUM) * 2), j9, stroke2);
                            j8 = jM756getSizeNHjbRc;
                            try {
                                ProgressIndicatorKt.m258drawCircularIndicator42QJj7c(drawScope, 0.0f, fFloatValue, j10, stroke2);
                                ImageAnalysis$$ExternalSyntheticLambda1.m(drawContext, j8);
                                return Unit.INSTANCE;
                            } catch (Throwable th) {
                                th = th;
                                ImageAnalysis$$ExternalSyntheticLambda1.m(drawContext, j8);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            j8 = jM756getSizeNHjbRc;
                        }
                    }
                };
                gapComposer.updateRememberedValue(obj);
            }
            ImageKt.Canvas(modifierM140size3ABfNKs2, (Function1) obj, gapComposer, 0);
            j3 = j4;
            modifier3 = modifier5;
            i6 = i10;
            f4 = f10;
        } else {
            gapComposer.skipToGroupEnd();
            j3 = j2;
            f4 = f2;
            modifier3 = modifier2;
            f5 = f3;
            i6 = i;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    ((Integer) obj3).getClass();
                    ProgressIndicatorKt.m256CircularProgressIndicator4lLiAd8(modifier3, j, f5, j3, i6, f4, (GapComposer) obj2, Stack.updateChangedFlags(i2 | 1), i3);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: LinearProgressIndicator-rIrjwxo, reason: not valid java name */
    public static final void m257LinearProgressIndicatorrIrjwxo(final Modifier modifier, final long j, final long j2, int i, float f, GapComposer gapComposer, final int i2) {
        int i3;
        final int i4;
        final float f2;
        int i5;
        float f3;
        final int i6;
        final float f4;
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        gapComposer.startRestartGroup(567589233);
        if ((i2 & 6) == 0) {
            i3 = i2 | (gapComposer.changed(modifier) ? 4 : 2);
        } else {
            i3 = i2;
        }
        int i7 = i3 | (gapComposer.changed(j) ? 32 : 16) | (gapComposer.changed(j2) ? 256 : 128) | 27648;
        if (gapComposer.shouldExecute(i7 & 1, (i7 & 9363) != 9362)) {
            gapComposer.startDefaults();
            if ((i2 & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                i5 = ProgressIndicatorDefaults.LinearStrokeCap;
                f3 = ProgressIndicatorDefaults.LinearIndicatorTrackGapSize;
            } else {
                gapComposer.skipToGroupEnd();
                i5 = i;
                f3 = f;
            }
            gapComposer.endDefaults();
            InfiniteTransition infiniteTransitionRememberInfiniteTransition = ArcSplineKt.rememberInfiniteTransition(gapComposer);
            KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig = new KeyframesSpec.KeyframesSpecConfig();
            keyframesSpecConfig.durationMillis = 1750;
            KeyframesSpec.KeyframeEntity keyframeEntityAt = keyframesSpecConfig.at(fValueOf2, 0);
            CubicBezierEasing cubicBezierEasing = LinearIndeterminateProgressEasing;
            keyframeEntityAt.easing = cubicBezierEasing;
            keyframesSpecConfig.at(fValueOf, 1000);
            Unit unit = Unit.INSTANCE;
            final InfiniteTransition.TransitionAnimationState transitionAnimationStateAnimateFloat = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, ArcSplineKt.m28infiniteRepeatable9IiC70o$default(new KeyframesSpec(keyframesSpecConfig)), gapComposer);
            KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig2 = new KeyframesSpec.KeyframesSpecConfig();
            int i8 = i5;
            keyframesSpecConfig2.durationMillis = 1750;
            keyframesSpecConfig2.at(fValueOf2, 250).easing = cubicBezierEasing;
            keyframesSpecConfig2.at(fValueOf, 1250);
            final InfiniteTransition.TransitionAnimationState transitionAnimationStateAnimateFloat2 = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, ArcSplineKt.m28infiniteRepeatable9IiC70o$default(new KeyframesSpec(keyframesSpecConfig2)), gapComposer);
            KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig3 = new KeyframesSpec.KeyframesSpecConfig();
            float f5 = f3;
            keyframesSpecConfig3.durationMillis = 1750;
            keyframesSpecConfig3.at(fValueOf2, 650).easing = cubicBezierEasing;
            keyframesSpecConfig3.at(fValueOf, 1500);
            final InfiniteTransition.TransitionAnimationState transitionAnimationStateAnimateFloat3 = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, ArcSplineKt.m28infiniteRepeatable9IiC70o$default(new KeyframesSpec(keyframesSpecConfig3)), gapComposer);
            KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig4 = new KeyframesSpec.KeyframesSpecConfig();
            keyframesSpecConfig4.durationMillis = 1750;
            keyframesSpecConfig4.at(fValueOf2, 900).easing = cubicBezierEasing;
            keyframesSpecConfig4.at(fValueOf, 1750);
            final InfiniteTransition.TransitionAnimationState transitionAnimationStateAnimateFloat4 = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, ArcSplineKt.m28infiniteRepeatable9IiC70o$default(new KeyframesSpec(keyframesSpecConfig4)), gapComposer);
            boolean z = true;
            Modifier modifierM141sizeVpY3zN4 = SizeKt.m141sizeVpY3zN4(SemanticsModifierKt.semantics(modifier.then(AccessibilityUtilKt.IncreaseVerticalSemanticsBounds), true, new BorderKt$$ExternalSyntheticLambda1(24)), LinearIndicatorWidth, LinearIndicatorHeight);
            boolean zChanged = gapComposer.changed(transitionAnimationStateAnimateFloat) | ((((i7 & 896) ^ 384) > 256 && gapComposer.changed(j2)) || (i7 & 384) == 256) | gapComposer.changed(transitionAnimationStateAnimateFloat2);
            if ((((i7 & 112) ^ 48) <= 32 || !gapComposer.changed(j)) && (i7 & 48) != 32) {
                z = false;
            }
            boolean zChanged2 = zChanged | z | gapComposer.changed(transitionAnimationStateAnimateFloat3) | gapComposer.changed(transitionAnimationStateAnimateFloat4);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue == Composer$Companion.Empty) {
                i6 = i8;
                f4 = f5;
                Object obj = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        DrawScope drawScope = (DrawScope) obj2;
                        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() & 4294967295L));
                        int i9 = i6;
                        float fMo88toDpu2uoSUM = f4;
                        if (i9 != 0 && Float.intBitsToFloat((int) (4294967295L & drawScope.mo474getSizeNHjbRc())) <= Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32))) {
                            fMo88toDpu2uoSUM += drawScope.mo88toDpu2uoSUM(fIntBitsToFloat);
                        }
                        float fMo88toDpu2uoSUM2 = fMo88toDpu2uoSUM / drawScope.mo88toDpu2uoSUM(Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32)));
                        State state = transitionAnimationStateAnimateFloat;
                        float fFloatValue = ((Number) state.getValue()).floatValue();
                        float f6 = 1.0f - fMo88toDpu2uoSUM2;
                        long j3 = j2;
                        if (fFloatValue < f6) {
                            ProgressIndicatorKt.m259drawLinearIndicatorqYKTg0g(drawScope, ((Number) state.getValue()).floatValue() > 0.0f ? ((Number) state.getValue()).floatValue() + fMo88toDpu2uoSUM2 : 0.0f, 1.0f, j3, fIntBitsToFloat, i9);
                        }
                        long j4 = j3;
                        float fFloatValue2 = ((Number) state.getValue()).floatValue();
                        State state2 = transitionAnimationStateAnimateFloat2;
                        float fFloatValue3 = fFloatValue2 - ((Number) state2.getValue()).floatValue();
                        long j5 = j;
                        if (fFloatValue3 > 0.0f) {
                            ProgressIndicatorKt.m259drawLinearIndicatorqYKTg0g(drawScope, ((Number) state.getValue()).floatValue(), ((Number) state2.getValue()).floatValue(), j5, fIntBitsToFloat, i9);
                        }
                        float fFloatValue4 = ((Number) state2.getValue()).floatValue();
                        State state3 = transitionAnimationStateAnimateFloat3;
                        if (fFloatValue4 > fMo88toDpu2uoSUM2) {
                            ProgressIndicatorKt.m259drawLinearIndicatorqYKTg0g(drawScope, ((Number) state3.getValue()).floatValue() > 0.0f ? ((Number) state3.getValue()).floatValue() + fMo88toDpu2uoSUM2 : 0.0f, ((Number) state2.getValue()).floatValue() < 1.0f ? ((Number) state2.getValue()).floatValue() - fMo88toDpu2uoSUM2 : 1.0f, j4, fIntBitsToFloat, i9);
                            j4 = j4;
                        }
                        float fFloatValue5 = ((Number) state3.getValue()).floatValue();
                        State state4 = transitionAnimationStateAnimateFloat4;
                        if (fFloatValue5 - ((Number) state4.getValue()).floatValue() > 0.0f) {
                            ProgressIndicatorKt.m259drawLinearIndicatorqYKTg0g(drawScope, ((Number) state3.getValue()).floatValue(), ((Number) state4.getValue()).floatValue(), j5, fIntBitsToFloat, i9);
                        }
                        if (((Number) state4.getValue()).floatValue() > fMo88toDpu2uoSUM2) {
                            ProgressIndicatorKt.m259drawLinearIndicatorqYKTg0g(drawScope, 0.0f, ((Number) state4.getValue()).floatValue() < 1.0f ? ((Number) state4.getValue()).floatValue() - fMo88toDpu2uoSUM2 : 1.0f, j4, fIntBitsToFloat, i9);
                        }
                        return Unit.INSTANCE;
                    }
                };
                gapComposer.updateRememberedValue(obj);
                objRememberedValue = obj;
            } else {
                i6 = i8;
                f4 = f5;
            }
            ImageKt.Canvas(modifierM141sizeVpY3zN4, (Function1) objRememberedValue, gapComposer, 0);
            i4 = i6;
            f2 = f4;
        } else {
            gapComposer.skipToGroupEnd();
            i4 = i;
            f2 = f;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    ((Integer) obj3).getClass();
                    ProgressIndicatorKt.m257LinearProgressIndicatorrIrjwxo(modifier, j, j2, i4, f2, (GapComposer) obj2, Stack.updateChangedFlags(i2 | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    public static final void m258drawCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        float f3 = 2;
        float f4 = stroke.width / f3;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32)) - (f3 * f4);
        drawScope.mo462drawArcyD3GUKo(j, f, f2, (((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L), (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L), stroke);
    }

    /* JADX INFO: renamed from: drawLinearIndicator-qYKTg0g, reason: not valid java name */
    public static final void m259drawLinearIndicatorqYKTg0g(DrawScope drawScope, float f, float f2, long j, float f3, int i) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() & 4294967295L));
        float f4 = 2;
        float f5 = fIntBitsToFloat2 / f4;
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Ltr;
        float f6 = (z ? f : 1.0f - f2) * fIntBitsToFloat;
        float f7 = (z ? f2 : 1.0f - f) * fIntBitsToFloat;
        if (i == 0 || fIntBitsToFloat2 > fIntBitsToFloat) {
            drawScope.mo466drawLineNGM6Ib0(j, (((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L), (((long) Float.floatToRawIntBits(f7)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L), f3, (496 & 16) != 0 ? 0 : 0);
            return;
        }
        float f8 = f3 / f4;
        float f9 = fIntBitsToFloat - f8;
        if (f6 < f8) {
            f6 = f8;
        }
        if (f6 > f9) {
            f6 = f9;
        }
        if (f7 < f8) {
            f7 = f8;
        }
        if (f7 <= f9) {
            f9 = f7;
        }
        if (Math.abs(f2 - f) > 0.0f) {
            drawScope.mo466drawLineNGM6Ib0(j, (((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L), (((long) Float.floatToRawIntBits(f9)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L), f3, (496 & 16) != 0 ? 0 : i);
        }
    }
}
