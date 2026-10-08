package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.DensityImpl;
import androidx.compose.ui.unit.LayoutDirection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MinLinesConstrainer {
    public static MinLinesConstrainer last;
    public final DensityImpl density;
    public final FontFamily$Resolver fontFamilyResolver;
    public final TextStyle inputTextStyle;
    public final LayoutDirection layoutDirection;
    public float lineHeightCache = Float.NaN;
    public float oneLineHeightCache = Float.NaN;
    public final TextStyle resolvedStyle;

    public MinLinesConstrainer(LayoutDirection layoutDirection, TextStyle textStyle, DensityImpl densityImpl, FontFamily$Resolver fontFamily$Resolver) {
        this.layoutDirection = layoutDirection;
        this.inputTextStyle = textStyle;
        this.density = densityImpl;
        this.fontFamilyResolver = fontFamily$Resolver;
        this.resolvedStyle = ParagraphKt.resolveDefaults(textStyle, layoutDirection);
    }

    /* JADX INFO: renamed from: coerceMinLines-Oh53vG4$foundation, reason: not valid java name */
    public final long m201coerceMinLinesOh53vG4$foundation(int i, long j) {
        int iM684getMinHeightimpl;
        float f = this.oneLineHeightCache;
        float f2 = this.lineHeightCache;
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            String str = MinLinesConstrainerKt.EmptyTextReplacement;
            long jConstraints$default = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15);
            TextStyle textStyle = this.resolvedStyle;
            DensityImpl densityImpl = this.density;
            float height = ParagraphKt.m632ParagraphUl8oQg4$default(str, textStyle, jConstraints$default, densityImpl, this.fontFamilyResolver, 1, 96).getHeight();
            float height2 = ParagraphKt.m632ParagraphUl8oQg4$default(MinLinesConstrainerKt.TwoLineTextReplacement, this.resolvedStyle, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15), densityImpl, this.fontFamilyResolver, 2, 96).getHeight() - height;
            this.oneLineHeightCache = height;
            this.lineHeightCache = height2;
            f2 = height2;
            f = height;
        }
        if (i != 1) {
            int iRound = Math.round((f2 * (i - 1)) + f);
            iM684getMinHeightimpl = iRound >= 0 ? iRound : 0;
            int iM682getMaxHeightimpl = Constraints.m682getMaxHeightimpl(j);
            if (iM684getMinHeightimpl > iM682getMaxHeightimpl) {
                iM684getMinHeightimpl = iM682getMaxHeightimpl;
            }
        } else {
            iM684getMinHeightimpl = Constraints.m684getMinHeightimpl(j);
        }
        return ConstraintsKt.Constraints(Constraints.m685getMinWidthimpl(j), Constraints.m683getMaxWidthimpl(j), iM684getMinHeightimpl, Constraints.m682getMaxHeightimpl(j));
    }
}
