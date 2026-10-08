package androidx.compose.material3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class RippleDefaults {
    public static final RippleThemeConfiguration InsetFocusRingRippleThemeConfiguration;
    public static final RippleThemeConfiguration OpacityFocusRippleThemeConfiguration;
    public static final RippleThemeConfiguration ThemeConfiguration;

    static {
        RippleThemeConfiguration rippleThemeConfiguration = new RippleThemeConfiguration(new RippleThemeConfiguration$Focus$Opacity());
        OpacityFocusRippleThemeConfiguration = rippleThemeConfiguration;
        InsetFocusRingRippleThemeConfiguration = new RippleThemeConfiguration(new RippleThemeConfiguration$Focus$InsetRing(0, 2, 1, 3));
        ThemeConfiguration = rippleThemeConfiguration;
    }
}
