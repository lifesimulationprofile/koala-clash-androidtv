package androidx.compose.animation.core;

import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class EasingKt {
    public static final CubicBezierEasing FastOutLinearInEasing;
    public static final CubicBezierEasing FastOutSlowInEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
    public static final ZslControlImpl$$ExternalSyntheticLambda0 LinearEasing;

    static {
        new CubicBezierEasing(0.0f, 0.0f, 0.2f, 1.0f);
        FastOutLinearInEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
        LinearEasing = new ZslControlImpl$$ExternalSyntheticLambda0(6);
    }
}
