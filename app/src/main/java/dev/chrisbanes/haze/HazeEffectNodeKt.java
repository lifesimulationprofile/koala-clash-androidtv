package dev.chrisbanes.haze;

import android.os.Build;
import androidx.compose.ui.unit.Dp;
import coil.network.HttpException;
import java.util.List;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class HazeEffectNodeKt {
    public static final Object renderEffectCache$delegate = LazyKt__LazyJVMKt.lazy(3, new HazeStyleKt$$ExternalSyntheticLambda0(3));

    /* JADX INFO: renamed from: calculateInputScaleFactor-3ABfNKs$default, reason: not valid java name */
    public static float m824calculateInputScaleFactor3ABfNKs$default(HazeEffectNode hazeEffectNode) {
        float fResolveBlurRadius = resolveBlurRadius(hazeEffectNode);
        HazeInputScale$None hazeInputScale$None = hazeEffectNode.inputScale;
        if (Intrinsics.areEqual(hazeInputScale$None, HazeInputScale$None.INSTANCE)) {
            return 1.0f;
        }
        if (Intrinsics.areEqual(hazeInputScale$None, HazeInputScale$Auto.INSTANCE)) {
            return Dp.m703compareTo0680j_4(fResolveBlurRadius, (float) 7) < 0 ? 1.0f : 0.3334f;
        }
        throw new HttpException();
    }

    public static final boolean resolveBlurEnabled(HazeEffectNode hazeEffectNode) {
        HazeState hazeState = hazeEffectNode.state;
        if (hazeState != null) {
            return ((Boolean) hazeState.blurEnabled$delegate.getValue()).booleanValue();
        }
        float f = HazeDefaults.blurRadius;
        return Build.VERSION.SDK_INT >= 31;
    }

    public static final float resolveBlurRadius(HazeEffectNode hazeEffectNode) {
        float f = hazeEffectNode.blurRadius;
        if (Float.isNaN(f)) {
            f = hazeEffectNode.style.blurRadius;
        }
        return !Float.isNaN(f) ? f : hazeEffectNode.compositionLocalStyle.blurRadius;
    }

    public static final float resolveNoiseFactor(HazeEffectNode hazeEffectNode) {
        float f = hazeEffectNode.noiseFactor;
        if (0.0f > f || f > 1.0f) {
            f = hazeEffectNode.style.noiseFactor;
        }
        return (0.0f > f || f > 1.0f) ? hazeEffectNode.compositionLocalStyle.noiseFactor : f;
    }

    public static final List resolveTints(HazeEffectNode hazeEffectNode) {
        hazeEffectNode.tints.getClass();
        List list = hazeEffectNode.style.tints;
        if (list.isEmpty()) {
            list = null;
        }
        if (list != null) {
            return list;
        }
        List list2 = hazeEffectNode.compositionLocalStyle.tints;
        List list3 = list2.isEmpty() ? null : list2;
        return list3 == null ? EmptyList.INSTANCE : list3;
    }
}
