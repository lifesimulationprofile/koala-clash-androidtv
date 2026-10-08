package androidx.compose.material3;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.material3.tokens.TypographyTokens;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.text.TextStyle;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;
import coil.network.HttpException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TypographyKt {
    public static final TypographyTokens typographyTokens;

    static {
        Stack.staticCompositionLocalOf(new ImageLoader$Builder$$ExternalSyntheticLambda2(5));
        typographyTokens = new TypographyTokens();
    }

    public static final TextStyle getValue(int i, GapComposer gapComposer) {
        Typography typography = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography;
        switch (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i)) {
            case 0:
                return typography.bodyLarge;
            case 1:
                return typography.bodyMedium;
            case 2:
                return typography.bodySmall;
            case 3:
                return typography.displayLarge;
            case 4:
                return typography.displayMedium;
            case 5:
                return typography.displaySmall;
            case 6:
                return typography.headlineLarge;
            case 7:
                return typography.headlineMedium;
            case 8:
                return typography.headlineSmall;
            case 9:
                return typography.labelLarge;
            case 10:
                return typography.labelMedium;
            case 11:
                return typography.labelSmall;
            case 12:
                return typography.titleLarge;
            case 13:
                return typography.titleMedium;
            case 14:
                return typography.titleSmall;
            case 15:
                return typography.bodyLargeEmphasized;
            case 16:
                return typography.bodyMediumEmphasized;
            case 17:
                return typography.bodySmallEmphasized;
            case 18:
                return typography.displayLargeEmphasized;
            case 19:
                return typography.displayMediumEmphasized;
            case 20:
                return typography.displaySmallEmphasized;
            case 21:
                return typography.headlineLargeEmphasized;
            case 22:
                return typography.headlineMediumEmphasized;
            case 23:
                return typography.headlineSmallEmphasized;
            case 24:
                return typography.labelLargeEmphasized;
            case 25:
                return typography.labelMediumEmphasized;
            case 26:
                return typography.labelSmallEmphasized;
            case 27:
                return typography.titleLargeEmphasized;
            case 28:
                return typography.titleMediumEmphasized;
            case 29:
                return typography.titleSmallEmphasized;
            default:
                throw new HttpException();
        }
    }
}
