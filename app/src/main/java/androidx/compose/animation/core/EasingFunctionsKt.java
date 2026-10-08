package androidx.compose.animation.core;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class EasingFunctionsKt {
    public static final CubicBezierEasing EaseInCubic;
    public static final CubicBezierEasing EaseOutCubic;

    static {
        new CubicBezierEasing(0.25f, 0.1f, 0.25f, 1.0f);
        new CubicBezierEasing(0.0f, 0.0f, 0.58f, 1.0f);
        new CubicBezierEasing(0.42f, 0.0f, 1.0f, 1.0f);
        new CubicBezierEasing(0.42f, 0.0f, 0.58f, 1.0f);
        new CubicBezierEasing(0.12f, 0.0f, 0.39f, 0.0f);
        new CubicBezierEasing(0.61f, 1.0f, 0.88f, 1.0f);
        new CubicBezierEasing(0.37f, 0.0f, 0.63f, 1.0f);
        EaseInCubic = new CubicBezierEasing(0.32f, 0.0f, 0.67f, 0.0f);
        EaseOutCubic = new CubicBezierEasing(0.33f, 1.0f, 0.68f, 1.0f);
        new CubicBezierEasing(0.65f, 0.0f, 0.35f, 1.0f);
        new CubicBezierEasing(0.64f, 0.0f, 0.78f, 0.0f);
        new CubicBezierEasing(0.22f, 1.0f, 0.36f, 1.0f);
        new CubicBezierEasing(0.83f, 0.0f, 0.17f, 1.0f);
        new CubicBezierEasing(0.55f, 0.0f, 1.0f, 0.45f);
        new CubicBezierEasing(0.0f, 0.55f, 0.45f, 1.0f);
        new CubicBezierEasing(0.85f, 0.0f, 0.15f, 1.0f);
        new CubicBezierEasing(0.11f, 0.0f, 0.5f, 0.0f);
        new CubicBezierEasing(0.5f, 1.0f, 0.89f, 1.0f);
        new CubicBezierEasing(0.45f, 0.0f, 0.55f, 1.0f);
        new CubicBezierEasing(0.5f, 0.0f, 0.75f, 0.0f);
        new CubicBezierEasing(0.25f, 1.0f, 0.5f, 1.0f);
        new CubicBezierEasing(0.76f, 0.0f, 0.24f, 1.0f);
        new CubicBezierEasing(0.7f, 0.0f, 0.84f, 0.0f);
        new CubicBezierEasing(0.16f, 1.0f, 0.3f, 1.0f);
        new CubicBezierEasing(0.87f, 0.0f, 0.13f, 1.0f);
        new CubicBezierEasing(0.36f, 0.0f, 0.66f, -0.56f);
        new CubicBezierEasing(0.34f, 1.56f, 0.64f, 1.0f);
        new CubicBezierEasing(0.68f, -0.6f, 0.32f, 1.6f);
    }
}
