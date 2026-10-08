package com.github.kr328.clash.design.compose.theme;

import androidx.compose.runtime.StaticProvidableCompositionLocal;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppColorsKt {
    public static final StaticProvidableCompositionLocal LocalAppColors = new StaticProvidableCompositionLocal(new ImageLoader$Builder$$ExternalSyntheticLambda2(28));
    public static final AppColors LightAppColors = new AppColors(AppPalette$Light.AppBackground, AppPalette$Light.CardBackground, AppPalette$Light.CardBorder, AppPalette$Light.AccentBorder, AppPalette$Light.AccentFill, AppPalette$Light.ButtonActiveStart, AppPalette$Light.ButtonActiveEnd, AppPalette$Light.ButtonInactiveStart, AppPalette$Light.ButtonInactiveEnd, AppPalette$Light.ButtonInactiveBorder, AppPalette$Light.ButtonColor, AppPalette$Light.TextPrimary, AppPalette$Light.TextSecondary, AppPalette$Light.StatusActive, AppPalette$Light.StatusClosed, AppPalette$Light.NetworkTcp, AppPalette$Light.NetworkUdp, AppPalette$Light.Destructive);
    public static final AppColors DarkAppColors = new AppColors(AppPalette$Dark.AppBackground, AppPalette$Dark.CardBackground, AppPalette$Dark.CardBorder, AppPalette$Dark.AccentBorder, AppPalette$Dark.AccentFill, AppPalette$Dark.ButtonActiveStart, AppPalette$Dark.ButtonActiveEnd, AppPalette$Dark.ButtonInactiveStart, AppPalette$Dark.ButtonInactiveEnd, AppPalette$Dark.ButtonInactiveBorder, AppPalette$Dark.ButtonColor, AppPalette$Dark.TextPrimary, AppPalette$Dark.TextSecondary, AppPalette$Dark.StatusActive, AppPalette$Dark.StatusClosed, AppPalette$Dark.NetworkTcp, AppPalette$Dark.NetworkUdp, AppPalette$Dark.Destructive);
}
