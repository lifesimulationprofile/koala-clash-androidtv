package androidx.compose.animation.core;

import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class VisibilityThresholdsKt {
    public static final Object VisibilityThresholdMap;

    static {
        Float fValueOf = Float.valueOf(1.0f);
        Pair pair = new Pair(ArcSplineKt.IntToVector, fValueOf);
        Pair pair2 = new Pair(ArcSplineKt.IntSizeToVector, fValueOf);
        Pair pair3 = new Pair(ArcSplineKt.IntOffsetToVector, fValueOf);
        Pair pair4 = new Pair(ArcSplineKt.FloatToVector, Float.valueOf(0.01f));
        Pair pair5 = new Pair(ArcSplineKt.RectToVector, fValueOf);
        Pair pair6 = new Pair(ArcSplineKt.SizeToVector, fValueOf);
        Pair pair7 = new Pair(ArcSplineKt.OffsetToVector, fValueOf);
        TwoWayConverterImpl twoWayConverterImpl = ArcSplineKt.DpToVector;
        Float fValueOf2 = Float.valueOf(0.4f);
        VisibilityThresholdMap = MapsKt__MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, new Pair(twoWayConverterImpl, fValueOf2), new Pair(ArcSplineKt.DpOffsetToVector, fValueOf2));
    }
}
