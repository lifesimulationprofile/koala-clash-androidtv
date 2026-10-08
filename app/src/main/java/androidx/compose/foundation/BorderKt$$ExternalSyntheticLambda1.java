package androidx.compose.foundation;

import android.content.Context;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BorderKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ BorderKt$$ExternalSyntheticLambda1(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ((LayoutNodeDrawScope) obj).drawContent();
                return Unit.INSTANCE;
            case 1:
                return Unit.INSTANCE;
            case 2:
                SeekableTransitionState seekableTransitionState = (SeekableTransitionState) obj;
                long j = seekableTransitionState.totalDurationNanos;
                SnapshotStateObserver snapshotStateObserver = seekableTransitionState.snapshotStateObserver;
                if (snapshotStateObserver != null) {
                    snapshotStateObserver.observeReads(seekableTransitionState, ArcSplineKt.SeekableTransitionStateTotalDurationChanged, seekableTransitionState.recalculateTotalDurationNanos);
                }
                long j2 = seekableTransitionState.totalDurationNanos;
                if (j != j2) {
                    SeekableTransitionState.SeekingAnimationState seekingAnimationState = seekableTransitionState.currentAnimation;
                    if (seekingAnimationState != null) {
                        if (seekingAnimationState.progressNanos > j2) {
                            seekableTransitionState.endAllAnimations();
                        } else {
                            seekingAnimationState.durationNanos = j2;
                            if (seekingAnimationState.animationSpec == null) {
                                seekingAnimationState.animationSpecDuration = MathKt.roundToLong((1.0d - ((double) seekingAnimationState.start.get$animation_core(0))) * seekableTransitionState.totalDurationNanos);
                            }
                        }
                    } else if (j2 != 0) {
                        seekableTransitionState.seekToFraction();
                    }
                }
                return Unit.INSTANCE;
            case 3:
                return new AnimationVector1D(((Float) obj).floatValue());
            case 4:
                return new AnimationVector1D(((Integer) obj).intValue());
            case 5:
                return Integer.valueOf((int) ((AnimationVector1D) obj).value);
            case 6:
                return new AnimationVector1D(((Dp) obj).value);
            case 7:
                return new Dp(((AnimationVector1D) obj).value);
            case 8:
                DpOffset dpOffset = (DpOffset) obj;
                return new AnimationVector2D(DpOffset.m707getXD9Ej5fM(dpOffset.packedValue), DpOffset.m708getYD9Ej5fM(dpOffset.packedValue));
            case 9:
                AnimationVector2D animationVector2D = (AnimationVector2D) obj;
                return new DpOffset((((long) Float.floatToRawIntBits(animationVector2D.v1)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(animationVector2D.v2))));
            case 10:
                Size size = (Size) obj;
                return new AnimationVector2D(Float.intBitsToFloat((int) (size.packedValue >> 32)), Float.intBitsToFloat((int) (4294967295L & size.packedValue)));
            case 11:
                AnimationVector2D animationVector2D2 = (AnimationVector2D) obj;
                return new Size((((long) Float.floatToRawIntBits(animationVector2D2.v1)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(animationVector2D2.v2))));
            case 12:
                Offset offset = (Offset) obj;
                return new AnimationVector2D(Float.intBitsToFloat((int) (offset.packedValue >> 32)), Float.intBitsToFloat((int) (4294967295L & offset.packedValue)));
            case 13:
                AnimationVector2D animationVector2D3 = (AnimationVector2D) obj;
                return new Offset((((long) Float.floatToRawIntBits(animationVector2D3.v1)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(animationVector2D3.v2))));
            case 14:
                long j3 = ((IntOffset) obj).packedValue;
                return new AnimationVector2D((int) (j3 >> 32), (int) (4294967295L & j3));
            case 15:
                AnimationVector2D animationVector2D4 = (AnimationVector2D) obj;
                return new IntOffset((((long) Math.round(animationVector2D4.v1)) << 32) | (4294967295L & ((long) Math.round(animationVector2D4.v2))));
            case 16:
                long j4 = ((IntSize) obj).packedValue;
                return new AnimationVector2D((int) (j4 >> 32), (int) (4294967295L & j4));
            case 17:
                AnimationVector2D animationVector2D5 = (AnimationVector2D) obj;
                int iRound = Math.round(animationVector2D5.v1);
                if (iRound < 0) {
                    iRound = 0;
                }
                int iRound2 = Math.round(animationVector2D5.v2);
                return new IntSize((((long) (iRound2 >= 0 ? iRound2 : 0)) & 4294967295L) | (((long) iRound) << 32));
            case 18:
                Rect rect = (Rect) obj;
                return new AnimationVector4D(rect.left, rect.top, rect.right, rect.bottom);
            case 19:
                AnimationVector4D animationVector4D = (AnimationVector4D) obj;
                return new Rect(animationVector4D.v1, animationVector4D.v2, animationVector4D.v3, animationVector4D.v4);
            case 20:
                return Float.valueOf(((AnimationVector1D) obj).value);
            case 21:
                return Unit.INSTANCE;
            case 22:
                ((Long) obj).longValue();
                return Unit.INSTANCE;
            case 23:
                CompositionLocalAccessorScope compositionLocalAccessorScope = (CompositionLocalAccessorScope) obj;
                int i = AndroidOverscroll_androidKt.$r8$clinit;
                Context context = (Context) compositionLocalAccessorScope.getCurrentValue(AndroidCompositionLocals_androidKt.LocalContext);
                Density density = (Density) compositionLocalAccessorScope.getCurrentValue(CompositionLocalsKt.LocalDensity);
                OverscrollConfiguration overscrollConfiguration = (OverscrollConfiguration) compositionLocalAccessorScope.getCurrentValue(OverscrollConfiguration_androidKt.LocalOverscrollConfiguration);
                if (overscrollConfiguration == null) {
                    return null;
                }
                return new AndroidEdgeEffectOverscrollFactory(context, density, overscrollConfiguration.glowColor, overscrollConfiguration.drawPadding);
            case 24:
                ProgressBarRangeInfo progressBarRangeInfo = ProgressBarRangeInfo.Indeterminate;
                KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ProgressBarRangeInfo;
                KProperty kProperty = SemanticsPropertiesKt.$$delegatedProperties[1];
                ((SemanticsPropertyReceiver) obj).set(semanticsPropertyKey, progressBarRangeInfo);
                return Unit.INSTANCE;
            case 25:
                return new ScrollState(((Integer) obj).intValue());
            case 26:
                return Float.valueOf(((Float) obj).floatValue() / 2.0f);
            case 27:
                return Boolean.TRUE;
            case 28:
                ((Integer) obj).getClass();
                return Float.valueOf(Float.NaN);
            default:
                return Boolean.TRUE;
        }
    }
}
