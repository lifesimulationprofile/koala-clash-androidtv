package androidx.compose.material3;

import androidx.compose.material3.tokens.TypographyTokens;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Typography {
    public final TextStyle bodyLarge;
    public final TextStyle bodyLargeEmphasized;
    public final TextStyle bodyMedium;
    public final TextStyle bodyMediumEmphasized;
    public final TextStyle bodySmall;
    public final TextStyle bodySmallEmphasized;
    public final TextStyle displayLarge;
    public final TextStyle displayLargeEmphasized;
    public final TextStyle displayMedium;
    public final TextStyle displayMediumEmphasized;
    public final TextStyle displaySmall;
    public final TextStyle displaySmallEmphasized;
    public final TextStyle headlineLarge;
    public final TextStyle headlineLargeEmphasized;
    public final TextStyle headlineMedium;
    public final TextStyle headlineMediumEmphasized;
    public final TextStyle headlineSmall;
    public final TextStyle headlineSmallEmphasized;
    public final TextStyle labelLarge;
    public final TextStyle labelLargeEmphasized;
    public final TextStyle labelMedium;
    public final TextStyle labelMediumEmphasized;
    public final TextStyle labelSmall;
    public final TextStyle labelSmallEmphasized;
    public final TextStyle titleLarge;
    public final TextStyle titleLargeEmphasized;
    public final TextStyle titleMedium;
    public final TextStyle titleMediumEmphasized;
    public final TextStyle titleSmall;
    public final TextStyle titleSmallEmphasized;

    public Typography(TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, int i) {
        TypographyTokens typographyTokens = TypographyKt.typographyTokens;
        TextStyle textStyle10 = typographyTokens.DisplayLarge;
        TextStyle textStyle11 = typographyTokens.DisplayMedium;
        TextStyle textStyle12 = typographyTokens.DisplaySmall;
        TextStyle textStyle13 = typographyTokens.HeadlineLarge;
        TextStyle textStyle14 = typographyTokens.HeadlineMedium;
        TextStyle textStyle15 = typographyTokens.HeadlineSmall;
        TextStyle textStyle16 = (i & 64) != 0 ? typographyTokens.TitleLarge : textStyle;
        TextStyle textStyle17 = (i & 128) != 0 ? typographyTokens.TitleMedium : textStyle2;
        TextStyle textStyle18 = (i & 256) != 0 ? typographyTokens.TitleSmall : textStyle3;
        TextStyle textStyle19 = (i & 512) != 0 ? typographyTokens.BodyLarge : textStyle4;
        TextStyle textStyle20 = (i & 1024) != 0 ? typographyTokens.BodyMedium : textStyle5;
        TextStyle textStyle21 = (i & 2048) != 0 ? typographyTokens.BodySmall : textStyle6;
        TextStyle textStyle22 = (i & 4096) != 0 ? typographyTokens.LabelLarge : textStyle7;
        TextStyle textStyle23 = (i & 8192) != 0 ? typographyTokens.LabelMedium : textStyle8;
        TextStyle textStyle24 = (i & 16384) != 0 ? typographyTokens.LabelSmall : textStyle9;
        this.displayLarge = textStyle10;
        this.displayMedium = textStyle11;
        this.displaySmall = textStyle12;
        this.headlineLarge = textStyle13;
        this.headlineMedium = textStyle14;
        this.headlineSmall = textStyle15;
        this.titleLarge = textStyle16;
        this.titleMedium = textStyle17;
        this.titleSmall = textStyle18;
        this.bodyLarge = textStyle19;
        this.bodyMedium = textStyle20;
        this.bodySmall = textStyle21;
        this.labelLarge = textStyle22;
        this.labelMedium = textStyle23;
        this.labelSmall = textStyle24;
        this.displayLargeEmphasized = textStyle10;
        this.displayMediumEmphasized = textStyle11;
        this.displaySmallEmphasized = textStyle12;
        this.headlineLargeEmphasized = textStyle13;
        this.headlineMediumEmphasized = textStyle14;
        this.headlineSmallEmphasized = textStyle15;
        this.titleLargeEmphasized = textStyle16;
        this.titleMediumEmphasized = textStyle17;
        this.titleSmallEmphasized = textStyle18;
        this.bodyLargeEmphasized = textStyle19;
        this.bodyMediumEmphasized = textStyle20;
        this.bodySmallEmphasized = textStyle21;
        this.labelLargeEmphasized = textStyle22;
        this.labelMediumEmphasized = textStyle23;
        this.labelSmallEmphasized = textStyle24;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Typography)) {
            return false;
        }
        Typography typography = (Typography) obj;
        return Intrinsics.areEqual(this.displayLarge, typography.displayLarge) && Intrinsics.areEqual(this.displayMedium, typography.displayMedium) && Intrinsics.areEqual(this.displaySmall, typography.displaySmall) && Intrinsics.areEqual(this.headlineLarge, typography.headlineLarge) && Intrinsics.areEqual(this.headlineMedium, typography.headlineMedium) && Intrinsics.areEqual(this.headlineSmall, typography.headlineSmall) && Intrinsics.areEqual(this.titleLarge, typography.titleLarge) && Intrinsics.areEqual(this.titleMedium, typography.titleMedium) && Intrinsics.areEqual(this.titleSmall, typography.titleSmall) && Intrinsics.areEqual(this.bodyLarge, typography.bodyLarge) && Intrinsics.areEqual(this.bodyMedium, typography.bodyMedium) && Intrinsics.areEqual(this.bodySmall, typography.bodySmall) && Intrinsics.areEqual(this.labelLarge, typography.labelLarge) && Intrinsics.areEqual(this.labelMedium, typography.labelMedium) && Intrinsics.areEqual(this.labelSmall, typography.labelSmall) && Intrinsics.areEqual(this.displayLargeEmphasized, typography.displayLargeEmphasized) && Intrinsics.areEqual(this.displayMediumEmphasized, typography.displayMediumEmphasized) && Intrinsics.areEqual(this.displaySmallEmphasized, typography.displaySmallEmphasized) && Intrinsics.areEqual(this.headlineLargeEmphasized, typography.headlineLargeEmphasized) && Intrinsics.areEqual(this.headlineMediumEmphasized, typography.headlineMediumEmphasized) && Intrinsics.areEqual(this.headlineSmallEmphasized, typography.headlineSmallEmphasized) && Intrinsics.areEqual(this.titleLargeEmphasized, typography.titleLargeEmphasized) && Intrinsics.areEqual(this.titleMediumEmphasized, typography.titleMediumEmphasized) && Intrinsics.areEqual(this.titleSmallEmphasized, typography.titleSmallEmphasized) && Intrinsics.areEqual(this.bodyLargeEmphasized, typography.bodyLargeEmphasized) && Intrinsics.areEqual(this.bodyMediumEmphasized, typography.bodyMediumEmphasized) && Intrinsics.areEqual(this.bodySmallEmphasized, typography.bodySmallEmphasized) && Intrinsics.areEqual(this.labelLargeEmphasized, typography.labelLargeEmphasized) && Intrinsics.areEqual(this.labelMediumEmphasized, typography.labelMediumEmphasized) && Intrinsics.areEqual(this.labelSmallEmphasized, typography.labelSmallEmphasized);
    }

    public final int hashCode() {
        return this.labelSmallEmphasized.hashCode() + Modifier.CC.m(this.labelMediumEmphasized, Modifier.CC.m(this.labelLargeEmphasized, Modifier.CC.m(this.bodySmallEmphasized, Modifier.CC.m(this.bodyMediumEmphasized, Modifier.CC.m(this.bodyLargeEmphasized, Modifier.CC.m(this.titleSmallEmphasized, Modifier.CC.m(this.titleMediumEmphasized, Modifier.CC.m(this.titleLargeEmphasized, Modifier.CC.m(this.headlineSmallEmphasized, Modifier.CC.m(this.headlineMediumEmphasized, Modifier.CC.m(this.headlineLargeEmphasized, Modifier.CC.m(this.displaySmallEmphasized, Modifier.CC.m(this.displayMediumEmphasized, Modifier.CC.m(this.displayLargeEmphasized, Modifier.CC.m(this.labelSmall, Modifier.CC.m(this.labelMedium, Modifier.CC.m(this.labelLarge, Modifier.CC.m(this.bodySmall, Modifier.CC.m(this.bodyMedium, Modifier.CC.m(this.bodyLarge, Modifier.CC.m(this.titleSmall, Modifier.CC.m(this.titleMedium, Modifier.CC.m(this.titleLarge, Modifier.CC.m(this.headlineSmall, Modifier.CC.m(this.headlineMedium, Modifier.CC.m(this.headlineLarge, Modifier.CC.m(this.displaySmall, Modifier.CC.m(this.displayMedium, this.displayLarge.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        return "Typography(displayLarge=" + this.displayLarge + ", displayMedium=" + this.displayMedium + ",displaySmall=" + this.displaySmall + ", headlineLarge=" + this.headlineLarge + ", headlineMedium=" + this.headlineMedium + ", headlineSmall=" + this.headlineSmall + ", titleLarge=" + this.titleLarge + ", titleMedium=" + this.titleMedium + ", titleSmall=" + this.titleSmall + ", bodyLarge=" + this.bodyLarge + ", bodyMedium=" + this.bodyMedium + ", bodySmall=" + this.bodySmall + ", labelLarge=" + this.labelLarge + ", labelMedium=" + this.labelMedium + ", labelSmall=" + this.labelSmall + ", displayLargeEmphasized=" + this.displayLargeEmphasized + ", displayMediumEmphasized=" + this.displayMediumEmphasized + ", displaySmallEmphasized=" + this.displaySmallEmphasized + ", headlineLargeEmphasized=" + this.headlineLargeEmphasized + ", headlineMediumEmphasized=" + this.headlineMediumEmphasized + ", headlineSmallEmphasized=" + this.headlineSmallEmphasized + ", titleLargeEmphasized=" + this.titleLargeEmphasized + ", titleMediumEmphasized=" + this.titleMediumEmphasized + ", titleSmallEmphasized=" + this.titleSmallEmphasized + ", bodyLargeEmphasized=" + this.bodyLargeEmphasized + ", bodyMediumEmphasized=" + this.bodyMediumEmphasized + ", bodySmallEmphasized=" + this.bodySmallEmphasized + ", labelLargeEmphasized=" + this.labelLargeEmphasized + ", labelMediumEmphasized=" + this.labelMediumEmphasized + ", labelSmallEmphasized=" + this.labelSmallEmphasized + ')';
    }
}
