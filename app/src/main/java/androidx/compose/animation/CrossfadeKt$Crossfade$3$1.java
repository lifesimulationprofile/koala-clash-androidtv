package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CrossfadeKt$Crossfade$3$1 extends Lambda implements Function1 {
    public static final CrossfadeKt$Crossfade$3$1 INSTANCE;
    public static final CrossfadeKt$Crossfade$3$1 INSTANCE$1;
    public static final CrossfadeKt$Crossfade$3$1 INSTANCE$2;
    public static final CrossfadeKt$Crossfade$3$1 INSTANCE$3;
    public static final CrossfadeKt$Crossfade$3$1 INSTANCE$4;
    public static final CrossfadeKt$Crossfade$3$1 INSTANCE$5;
    public static final CrossfadeKt$Crossfade$3$1 INSTANCE$6;
    public static final CrossfadeKt$Crossfade$3$1 INSTANCE$7;
    public final /* synthetic */ int $r8$classId;

    static {
        int i = 1;
        INSTANCE$1 = new CrossfadeKt$Crossfade$3$1(i, 1);
        INSTANCE$2 = new CrossfadeKt$Crossfade$3$1(i, 2);
        INSTANCE$3 = new CrossfadeKt$Crossfade$3$1(i, 3);
        INSTANCE = new CrossfadeKt$Crossfade$3$1(i, 0);
        INSTANCE$4 = new CrossfadeKt$Crossfade$3$1(i, 4);
        INSTANCE$5 = new CrossfadeKt$Crossfade$3$1(i, 5);
        INSTANCE$6 = new CrossfadeKt$Crossfade$3$1(i, 6);
        INSTANCE$7 = new CrossfadeKt$Crossfade$3$1(i, 7);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CrossfadeKt$Crossfade$3$1(int i, int i2) {
        super(i);
        this.$r8$classId = i2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
            case 1:
                return obj;
            case 2:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 3:
                long jM433convertvNxB06k = Color.m433convertvNxB06k(((Color) obj).value, ColorSpaces.Oklab);
                return new AnimationVector4D(Color.m436getAlphaimpl(jM433convertvNxB06k), Color.m440getRedimpl(jM433convertvNxB06k), Color.m439getGreenimpl(jM433convertvNxB06k), Color.m437getBlueimpl(jM433convertvNxB06k));
            case 4:
                long j = ((TransformOrigin) obj).packedValue;
                return new AnimationVector2D(TransformOrigin.m452getPivotFractionXimpl(j), TransformOrigin.m453getPivotFractionYimpl(j));
            case 5:
                AnimationVector2D animationVector2D = (AnimationVector2D) obj;
                return new TransformOrigin(BrushKt.TransformOrigin(animationVector2D.v1, animationVector2D.v2));
            case 6:
                return ArcSplineKt.spring$default(0.0f, 0.0f, null, 7);
            case 7:
                return EnterExitTransitionKt.DefaultOffsetAnimationSpec;
            case 8:
                return new IntSize((((long) ((int) (((IntSize) obj).packedValue >> 32))) << 32) | (((long) 0) & 4294967295L));
            default:
                return new IntSize((((long) ((int) (((IntSize) obj).packedValue >> 32))) << 32) | (((long) 0) & 4294967295L));
        }
    }
}
