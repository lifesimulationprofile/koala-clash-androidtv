package com.github.kr328.clash.design.compose.theme;

import android.view.View;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda12;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.tokens.ColorDarkTokens;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.github.kr328.clash.LogcatActivity$$ExternalSyntheticLambda4;
import com.github.kr328.clash.compose.LogsScreenKt;
import com.google.android.gms.internal.mlkit_vision_common.zzjq;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppThemeKt {
    public static final ColorScheme DarkColorScheme;
    public static final ColorScheme LightColorScheme;

    static {
        long j = AppPalette$Light.ButtonActiveEnd;
        long j2 = AppPalette$Light.TextPrimary;
        long j3 = AppPalette$Light.AccentFill;
        long j4 = AppPalette$Light.ButtonActiveStart;
        long j5 = AppPalette$Light.AppBackground;
        long j6 = AppPalette$Light.CardBackground;
        long j7 = AppPalette$Light.TextSecondary;
        long j8 = AppPalette$Light.CardBorder;
        LightColorScheme = ColorSchemeKt.m245lightColorScheme_VG5OTI$default(j, j2, j3, j2, j, j2, j3, j2, j4, j2, 0L, j5, j2, j5, j2, j6, j7, 0L, j8, j8, -201844720);
        long j9 = AppPalette$Dark.ButtonActiveEnd;
        long j10 = AppPalette$Dark.TextPrimary;
        long j11 = AppPalette$Dark.AccentFill;
        long j12 = AppPalette$Dark.ButtonActiveStart;
        long j13 = AppPalette$Dark.AppBackground;
        long j14 = AppPalette$Dark.CardBackground;
        long j15 = AppPalette$Dark.TextSecondary;
        long j16 = AppPalette$Dark.CardBorder;
        DarkColorScheme = new ColorScheme(j9, j10, j11, j10, ColorDarkTokens.InversePrimary, j9, j10, j11, j10, j12, j10, ColorDarkTokens.TertiaryContainer, ColorDarkTokens.OnTertiaryContainer, j13, j10, j13, j10, j14, j15, j9, ColorDarkTokens.InverseSurface, ColorDarkTokens.InverseOnSurface, ColorDarkTokens.Error, ColorDarkTokens.OnError, ColorDarkTokens.ErrorContainer, ColorDarkTokens.OnErrorContainer, j16, j16, ColorDarkTokens.Scrim, ColorDarkTokens.SurfaceBright, ColorDarkTokens.SurfaceDim, ColorDarkTokens.SurfaceContainer, ColorDarkTokens.SurfaceContainerHigh, ColorDarkTokens.SurfaceContainerHighest, ColorDarkTokens.SurfaceContainerLow, ColorDarkTokens.SurfaceContainerLowest, ColorDarkTokens.PrimaryFixed, ColorDarkTokens.PrimaryFixedDim, ColorDarkTokens.OnPrimaryFixed, ColorDarkTokens.OnPrimaryFixedVariant, ColorDarkTokens.SecondaryFixed, ColorDarkTokens.SecondaryFixedDim, ColorDarkTokens.OnSecondaryFixed, ColorDarkTokens.OnSecondaryFixedVariant, ColorDarkTokens.TertiaryFixed, ColorDarkTokens.TertiaryFixedDim, ColorDarkTokens.OnTertiaryFixed, ColorDarkTokens.OnTertiaryFixedVariant);
    }

    public static final void AppTheme(boolean z, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(-1099829715);
        if (((i | 2) & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                z = zzjq.isInDarkTheme(gapComposer);
            } else {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            View view = (View) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalView);
            gapComposer.startReplaceGroup(1867434430);
            if (!view.isInEditMode()) {
                gapComposer.startReplaceGroup(1867435819);
                boolean zChangedInstance = gapComposer.changedInstance(view) | gapComposer.changed(z);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer$Companion.Empty) {
                    objRememberedValue = new CoreTextFieldKt$$ExternalSyntheticLambda12(view, z);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                gapComposer.end(false);
                Stack.SideEffect((Function0) objRememberedValue, gapComposer);
            }
            gapComposer.end(false);
            Stack.CompositionLocalProvider(AppColorsKt.LocalAppColors.defaultProvidedValue$runtime(z ? AppColorsKt.DarkAppColors : AppColorsKt.LightAppColors), Thread_jvmKt.rememberComposableLambda(-1639288467, new LogsScreenKt.AnonymousClass1.AnonymousClass3.AnonymousClass2(8, z ? DarkColorScheme : LightColorScheme, composableLambdaImpl), gapComposer), gapComposer, 56);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LogcatActivity$$ExternalSyntheticLambda4(z, composableLambdaImpl, i, 4);
        }
    }
}
