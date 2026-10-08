package androidx.compose.material3;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.material3.tokens.BaselineButtonTokens;
import androidx.compose.material3.tokens.ButtonSmallTokens;
import androidx.compose.material3.tokens.FilledButtonTokens;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ButtonDefaults {
    public static final PaddingValuesImpl ContentPadding;
    public static final float MinHeight;
    public static final float MinWidth;
    public static final PaddingValuesImpl TextButtonContentPadding;

    static {
        float f = BaselineButtonTokens.LeadingSpace;
        float f2 = BaselineButtonTokens.TrailingSpace;
        float f3 = 16;
        float f4 = ButtonSmallTokens.ContainerHeight;
        float f5 = 8;
        ContentPadding = new PaddingValuesImpl(f, f5, f2, f5);
        OffsetKt.m123PaddingValuesa9UjIt4(f3, f5, f2, f5);
        float f6 = 12;
        TextButtonContentPadding = new PaddingValuesImpl(f6, f5, f6, f5);
        OffsetKt.m123PaddingValuesa9UjIt4(f6, f5, f3, f5);
        MinWidth = 58;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = PrecisionPointer.shouldUsePrecisionPointerComponentSizing;
        MinHeight = ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue() ? 36 : ButtonSmallTokens.ContainerHeight;
        ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue();
        ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue();
        ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue();
        ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue();
        ((Boolean) parcelableSnapshotMutableState.getValue()).getClass();
        ((Boolean) parcelableSnapshotMutableState.getValue()).getClass();
        ((Boolean) parcelableSnapshotMutableState.getValue()).getClass();
        ((Boolean) parcelableSnapshotMutableState.getValue()).getClass();
        ((Boolean) parcelableSnapshotMutableState.getValue()).getClass();
        ((Boolean) parcelableSnapshotMutableState.getValue()).getClass();
        ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue();
        ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue();
        ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue();
        ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue();
    }

    /* JADX INFO: renamed from: buttonColors-ro_MJ88, reason: not valid java name */
    public static ButtonColors m243buttonColorsro_MJ88(long j, long j2, GapComposer gapComposer) {
        long j3 = Color.Unspecified;
        ButtonColors defaultButtonColors$material3 = getDefaultButtonColors$material3(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme);
        long j4 = j != 16 ? j : defaultButtonColors$material3.containerColor;
        long j5 = j2 != 16 ? j2 : defaultButtonColors$material3.contentColor;
        long j6 = j3 != 16 ? j3 : defaultButtonColors$material3.disabledContainerColor;
        if (j3 != 16) {
            defaultButtonColors$material3.getClass();
        } else {
            j3 = defaultButtonColors$material3.disabledContentColor;
        }
        return new ButtonColors(j4, j5, j6, j3);
    }

    public static ButtonColors getDefaultButtonColors$material3(ColorScheme colorScheme) {
        ButtonColors buttonColors = colorScheme.defaultButtonColorsCached;
        if (buttonColors != null) {
            return buttonColors;
        }
        float f = FilledButtonTokens.ContainerElevation;
        long jFromToken = ColorSchemeKt.fromToken(colorScheme, 26);
        long jFromToken2 = ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.LabelTextColor);
        long jFromToken3 = ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.DisabledContainerColor);
        long jColor = BrushKt.Color(Color.m440getRedimpl(jFromToken3), Color.m439getGreenimpl(jFromToken3), Color.m437getBlueimpl(jFromToken3), FilledButtonTokens.DisabledContainerOpacity, Color.m438getColorSpaceimpl(jFromToken3));
        long jFromToken4 = ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.DisabledLabelTextColor);
        ButtonColors buttonColors2 = new ButtonColors(jFromToken, jFromToken2, jColor, BrushKt.Color(Color.m440getRedimpl(jFromToken4), Color.m439getGreenimpl(jFromToken4), Color.m437getBlueimpl(jFromToken4), FilledButtonTokens.DisabledLabelTextOpacity, Color.m438getColorSpaceimpl(jFromToken4)));
        colorScheme.defaultButtonColorsCached = buttonColors2;
        return buttonColors2;
    }
}
