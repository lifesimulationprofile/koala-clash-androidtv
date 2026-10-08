package androidx.compose.material3;

import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.material3.tokens.ColorLightTokens;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import coil.network.HttpException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ColorSchemeKt {
    public static final StaticProvidableCompositionLocal LocalTonalElevationEnabled = new StaticProvidableCompositionLocal(new ImmLeaksCleaner$$ExternalSyntheticLambda0(22));

    /* JADX WARN: Code duplicated, block: B:34:0x0098  */
    /* JADX INFO: renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m244contentColorForek8zF_U(long j, GapComposer gapComposer) {
        gapComposer.startReplaceGroup(89373914);
        ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme;
        long j2 = colorScheme.primary;
        long j3 = colorScheme.onTertiaryFixed;
        long j4 = colorScheme.onSecondaryFixed;
        long j5 = colorScheme.onPrimaryFixed;
        long j6 = colorScheme.onSurface;
        if (Color.m435equalsimpl0(j, j2)) {
            j3 = colorScheme.onPrimary;
        } else if (Color.m435equalsimpl0(j, colorScheme.secondary)) {
            j3 = colorScheme.onSecondary;
        } else if (Color.m435equalsimpl0(j, colorScheme.tertiary)) {
            j3 = colorScheme.onTertiary;
        } else if (Color.m435equalsimpl0(j, colorScheme.background)) {
            j3 = colorScheme.onBackground;
        } else if (Color.m435equalsimpl0(j, colorScheme.error)) {
            j3 = colorScheme.onError;
        } else if (Color.m435equalsimpl0(j, colorScheme.primaryContainer)) {
            j3 = colorScheme.onPrimaryContainer;
        } else if (Color.m435equalsimpl0(j, colorScheme.secondaryContainer)) {
            j3 = colorScheme.onSecondaryContainer;
        } else if (Color.m435equalsimpl0(j, colorScheme.tertiaryContainer)) {
            j3 = colorScheme.onTertiaryContainer;
        } else if (Color.m435equalsimpl0(j, colorScheme.errorContainer)) {
            j3 = colorScheme.onErrorContainer;
        } else if (Color.m435equalsimpl0(j, colorScheme.inverseSurface)) {
            j3 = colorScheme.inverseOnSurface;
        } else if (Color.m435equalsimpl0(j, colorScheme.surface)) {
            j3 = j6;
        } else if (Color.m435equalsimpl0(j, colorScheme.surfaceVariant)) {
            j3 = colorScheme.onSurfaceVariant;
        } else if (Color.m435equalsimpl0(j, colorScheme.surfaceBright) || Color.m435equalsimpl0(j, colorScheme.surfaceContainer) || Color.m435equalsimpl0(j, colorScheme.surfaceContainerHigh) || Color.m435equalsimpl0(j, colorScheme.surfaceContainerHighest) || Color.m435equalsimpl0(j, colorScheme.surfaceContainerLow) || Color.m435equalsimpl0(j, colorScheme.surfaceContainerLowest) || Color.m435equalsimpl0(j, colorScheme.surfaceDim)) {
            j3 = j6;
        } else if (Color.m435equalsimpl0(j, colorScheme.primaryFixed) || Color.m435equalsimpl0(j, colorScheme.primaryFixedDim)) {
            j3 = j5;
        } else if (Color.m435equalsimpl0(j, colorScheme.secondaryFixed) || Color.m435equalsimpl0(j, colorScheme.secondaryFixedDim)) {
            j3 = j4;
        } else if (!Color.m435equalsimpl0(j, colorScheme.tertiaryFixed) && !Color.m435equalsimpl0(j, colorScheme.tertiaryFixedDim)) {
            j3 = Color.Unspecified;
        }
        if (j3 == 16) {
            j3 = ((Color) gapComposer.consume(ContentColorKt.LocalContentColor)).value;
        }
        gapComposer.end(false);
        return j3;
    }

    public static final long fromToken(ColorScheme colorScheme, int i) {
        switch (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i)) {
            case 0:
                return colorScheme.background;
            case 1:
                return colorScheme.error;
            case 2:
                return colorScheme.errorContainer;
            case 3:
                return colorScheme.inverseOnSurface;
            case 4:
                return colorScheme.inversePrimary;
            case 5:
                return colorScheme.inverseSurface;
            case 6:
                return colorScheme.onBackground;
            case 7:
                return colorScheme.onError;
            case 8:
                return colorScheme.onErrorContainer;
            case 9:
                return colorScheme.onPrimary;
            case 10:
                return colorScheme.onPrimaryContainer;
            case 11:
                return colorScheme.onPrimaryFixed;
            case 12:
                return colorScheme.onPrimaryFixedVariant;
            case 13:
                return colorScheme.onSecondary;
            case 14:
                return colorScheme.onSecondaryContainer;
            case 15:
                return colorScheme.onSecondaryFixed;
            case 16:
                return colorScheme.onSecondaryFixedVariant;
            case 17:
                return colorScheme.onSurface;
            case 18:
                return colorScheme.onSurfaceVariant;
            case 19:
                return colorScheme.onTertiary;
            case 20:
                return colorScheme.onTertiaryContainer;
            case 21:
                return colorScheme.onTertiaryFixed;
            case 22:
                return colorScheme.onTertiaryFixedVariant;
            case 23:
                return colorScheme.outline;
            case 24:
                return colorScheme.outlineVariant;
            case 25:
                return colorScheme.primary;
            case 26:
                return colorScheme.primaryContainer;
            case 27:
                return colorScheme.primaryFixed;
            case 28:
                return colorScheme.primaryFixedDim;
            case 29:
                return colorScheme.scrim;
            case 30:
                return colorScheme.secondary;
            case 31:
                return colorScheme.secondaryContainer;
            case 32:
                return colorScheme.secondaryFixed;
            case 33:
                return colorScheme.secondaryFixedDim;
            case 34:
                return colorScheme.surface;
            case 35:
                return colorScheme.surfaceBright;
            case 36:
                return colorScheme.surfaceContainer;
            case 37:
                return colorScheme.surfaceContainerHigh;
            case 38:
                return colorScheme.surfaceContainerHighest;
            case 39:
                return colorScheme.surfaceContainerLow;
            case 40:
                return colorScheme.surfaceContainerLowest;
            case 41:
                return colorScheme.surfaceDim;
            case 42:
                return colorScheme.surfaceTint;
            case 43:
                return colorScheme.surfaceVariant;
            case 44:
                return colorScheme.tertiary;
            case 45:
                return colorScheme.tertiaryContainer;
            case 46:
                return colorScheme.tertiaryFixed;
            case 47:
                return colorScheme.tertiaryFixedDim;
            default:
                throw new HttpException();
        }
    }

    public static final long getValue(int i, GapComposer gapComposer) {
        return fromToken(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme, i);
    }

    /* JADX INFO: renamed from: lightColorScheme-_VG5OTI$default, reason: not valid java name */
    public static ColorScheme m245lightColorScheme_VG5OTI$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, int i) {
        long j21 = (i & 1) != 0 ? ColorLightTokens.Primary : j;
        return new ColorScheme(j21, (i & 2) != 0 ? ColorLightTokens.OnPrimary : j2, (i & 4) != 0 ? ColorLightTokens.PrimaryContainer : j3, (i & 8) != 0 ? ColorLightTokens.OnPrimaryContainer : j4, ColorLightTokens.InversePrimary, (i & 32) != 0 ? ColorLightTokens.Secondary : j5, (i & 64) != 0 ? ColorLightTokens.OnSecondary : j6, (i & 128) != 0 ? ColorLightTokens.SecondaryContainer : j7, (i & 256) != 0 ? ColorLightTokens.OnSecondaryContainer : j8, (i & 512) != 0 ? ColorLightTokens.Tertiary : j9, (i & 1024) != 0 ? ColorLightTokens.OnTertiary : j10, ColorLightTokens.TertiaryContainer, (i & 4096) != 0 ? ColorLightTokens.OnTertiaryContainer : j11, (i & 8192) != 0 ? ColorLightTokens.Background : j12, (i & 16384) != 0 ? ColorLightTokens.OnBackground : j13, (32768 & i) != 0 ? ColorLightTokens.Surface : j14, (65536 & i) != 0 ? ColorLightTokens.OnSurface : j15, (131072 & i) != 0 ? ColorLightTokens.SurfaceVariant : j16, (262144 & i) != 0 ? ColorLightTokens.OnSurfaceVariant : j17, j21, ColorLightTokens.InverseSurface, ColorLightTokens.InverseOnSurface, ColorLightTokens.Error, ColorLightTokens.OnError, ColorLightTokens.ErrorContainer, (33554432 & i) != 0 ? ColorLightTokens.OnErrorContainer : j18, (67108864 & i) != 0 ? ColorLightTokens.Outline : j19, (i & 134217728) != 0 ? ColorLightTokens.OutlineVariant : j20, ColorLightTokens.Scrim, ColorLightTokens.SurfaceBright, ColorLightTokens.SurfaceDim, ColorLightTokens.SurfaceContainer, ColorLightTokens.SurfaceContainerHigh, ColorLightTokens.SurfaceContainerHighest, ColorLightTokens.SurfaceContainerLow, ColorLightTokens.SurfaceContainerLowest, ColorLightTokens.PrimaryFixed, ColorLightTokens.PrimaryFixedDim, ColorLightTokens.OnPrimaryFixed, ColorLightTokens.OnPrimaryFixedVariant, ColorLightTokens.SecondaryFixed, ColorLightTokens.SecondaryFixedDim, ColorLightTokens.OnSecondaryFixed, ColorLightTokens.OnSecondaryFixedVariant, ColorLightTokens.TertiaryFixed, ColorLightTokens.TertiaryFixedDim, ColorLightTokens.OnTertiaryFixed, ColorLightTokens.OnTertiaryFixedVariant);
    }
}
