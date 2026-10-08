package androidx.compose.material3.tokens;

import androidx.compose.animation.core.CubicBezierEasing;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class MotionTokens {
    public static final CubicBezierEasing EasingEmphasizedAccelerateCubicBezier;
    public static final CubicBezierEasing EasingEmphasizedDecelerateCubicBezier;
    public static final CubicBezierEasing EasingStandardCubicBezier;

    static {
        new CubicBezierEasing(0.2f, 0.0f, 0.0f, 1.0f);
        EasingEmphasizedAccelerateCubicBezier = new CubicBezierEasing(0.3f, 0.0f, 0.8f, 0.15f);
        EasingEmphasizedDecelerateCubicBezier = new CubicBezierEasing(0.05f, 0.7f, 0.1f, 1.0f);
        new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
        new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
        new CubicBezierEasing(0.0f, 0.0f, 0.2f, 1.0f);
        new CubicBezierEasing(0.0f, 0.0f, 1.0f, 1.0f);
        EasingStandardCubicBezier = new CubicBezierEasing(0.2f, 0.0f, 0.0f, 1.0f);
        new CubicBezierEasing(0.3f, 0.0f, 1.0f, 1.0f);
        new CubicBezierEasing(0.0f, 0.0f, 0.0f, 1.0f);
    }
}
