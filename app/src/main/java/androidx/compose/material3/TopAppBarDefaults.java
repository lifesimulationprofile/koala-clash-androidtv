package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.material3.tokens.AppBarSmallTokens;
import androidx.compose.material3.tokens.AppBarTokens;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.graphics.Color;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TopAppBarDefaults {
    public static final PaddingValuesImpl ContentPadding;
    public static final float TopAppBarExpandedHeight = AppBarSmallTokens.ContainerHeight;

    static {
        float f = 0;
        ContentPadding = new PaddingValuesImpl(f, f, f, f);
    }

    /* JADX INFO: renamed from: topAppBarColors-5tl4gsc, reason: not valid java name */
    public static TopAppBarColors m278topAppBarColors5tl4gsc(long j, long j2, long j3, long j4, long j5, GapComposer gapComposer, int i) {
        long j6 = (i & 2) != 0 ? Color.Unspecified : j2;
        long j7 = (i & 4) != 0 ? Color.Unspecified : j3;
        long j8 = (i & 8) != 0 ? Color.Unspecified : j4;
        long j9 = (i & 16) != 0 ? Color.Unspecified : j5;
        long j10 = Color.Unspecified;
        ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme;
        TopAppBarColors topAppBarColors = colorScheme.defaultTopAppBarColorsCached;
        if (topAppBarColors == null) {
            int i2 = AppBarTokens.LeadingIconColor;
            TopAppBarColors topAppBarColors2 = new TopAppBarColors(ColorSchemeKt.fromToken(colorScheme, 35), ColorSchemeKt.fromToken(colorScheme, AppBarTokens.OnScrollContainerColor), ColorSchemeKt.fromToken(colorScheme, AppBarTokens.LeadingIconColor), ColorSchemeKt.fromToken(colorScheme, AppBarTokens.TitleColor), ColorSchemeKt.fromToken(colorScheme, AppBarTokens.TrailingIconColor), ColorSchemeKt.fromToken(colorScheme, AppBarTokens.SubtitleColor));
            colorScheme.defaultTopAppBarColorsCached = topAppBarColors2;
            topAppBarColors = topAppBarColors2;
        }
        long j11 = j != 16 ? j : topAppBarColors.containerColor;
        if (j6 == 16) {
            j6 = topAppBarColors.scrolledContainerColor;
        }
        long j12 = j6;
        if (j7 == 16) {
            j7 = topAppBarColors.navigationIconContentColor;
        }
        long j13 = j7;
        if (j8 == 16) {
            j8 = topAppBarColors.titleContentColor;
        }
        long j14 = j8;
        if (j9 == 16) {
            j9 = topAppBarColors.actionIconContentColor;
        }
        long j15 = j9;
        if (j10 == 16) {
            j10 = topAppBarColors.subtitleContentColor;
        }
        return new TopAppBarColors(j11, j12, j13, j14, j15, j10);
    }
}
