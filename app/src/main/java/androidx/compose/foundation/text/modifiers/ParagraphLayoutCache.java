package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.ui.text.AndroidParagraph;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.collections.EmptyList;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ParagraphLayoutCache {
    public Density density;
    public boolean didOverflow;
    public FontFamily$Resolver fontFamilyResolver;
    public long historyFlag;
    public LayoutDirection intrinsicsLayoutDirection;
    public long layoutSize;
    public MinLinesConstrainer mMinLinesConstrainer;
    public int maxLines;
    public int minLines;
    public int overflow;
    public AndroidParagraph paragraph;
    public ParagraphIntrinsics paragraphIntrinsics;
    public boolean softWrap;
    public TextStyle style;
    public String text;
    public long lastDensity = InlineDensity.Unspecified;
    public long prevConstraints = ConstraintsKt.createConstraints(0, 0, 0, 0);
    public int cachedIntrinsicHeightInputWidth = -1;
    public int cachedIntrinsicHeight = -1;

    public ParagraphLayoutCache(String str, TextStyle textStyle, FontFamily$Resolver fontFamily$Resolver, int i, boolean z, int i2, int i3) {
        this.text = str;
        this.style = textStyle;
        this.fontFamilyResolver = fontFamily$Resolver;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        long j = 0;
        this.layoutSize = (j & 4294967295L) | (j << 32);
    }

    public final int intrinsicHeight(int i, LayoutDirection layoutDirection) {
        int i2 = this.cachedIntrinsicHeightInputWidth;
        int i3 = this.cachedIntrinsicHeight;
        if (i == i2 && i2 != -1) {
            return i3;
        }
        long jConstraints = ConstraintsKt.Constraints(0, i, 0, Integer.MAX_VALUE);
        if (this.minLines > 1) {
            MinLinesConstrainer minLinesConstrainerFrom = SerialKind.from(this.mMinLinesConstrainer, layoutDirection, this.style, this.density, this.fontFamilyResolver);
            this.mMinLinesConstrainer = minLinesConstrainerFrom;
            jConstraints = minLinesConstrainerFrom.m201coerceMinLinesOh53vG4$foundation(this.minLines, jConstraints);
        }
        ParagraphIntrinsics layoutDirection2 = setLayoutDirection(layoutDirection);
        long jM847finalConstraintstfFHcEY = SerialDescriptorsKt.m847finalConstraintstfFHcEY(jConstraints, this.softWrap, this.overflow, layoutDirection2.getMaxIntrinsicWidth());
        boolean z = this.softWrap;
        int i4 = this.overflow;
        int i5 = this.maxLines;
        int iCeilToIntPx = BasicTextKt.ceilToIntPx(new AndroidParagraph((AndroidParagraphIntrinsics) layoutDirection2, ((z || !(i4 == 2 || i4 == 4 || i4 == 5)) && i5 >= 1) ? i5 : 1, i4, jM847finalConstraintstfFHcEY).getHeight());
        int iM684getMinHeightimpl = Constraints.m684getMinHeightimpl(jConstraints);
        if (iCeilToIntPx < iM684getMinHeightimpl) {
            iCeilToIntPx = iM684getMinHeightimpl;
        }
        this.cachedIntrinsicHeightInputWidth = i;
        this.cachedIntrinsicHeight = iCeilToIntPx;
        return iCeilToIntPx;
    }

    /* JADX INFO: renamed from: layoutWithConstraints-K40F9xA, reason: not valid java name */
    public final boolean m205layoutWithConstraintsK40F9xA(long j, LayoutDirection layoutDirection) {
        long jM201coerceMinLinesOh53vG4$foundation;
        ParagraphIntrinsics paragraphIntrinsics;
        this.historyFlag = (this.historyFlag << 2) | 3;
        boolean z = true;
        if (this.minLines > 1) {
            MinLinesConstrainer minLinesConstrainerFrom = SerialKind.from(this.mMinLinesConstrainer, layoutDirection, this.style, this.density, this.fontFamilyResolver);
            this.mMinLinesConstrainer = minLinesConstrainerFrom;
            jM201coerceMinLinesOh53vG4$foundation = minLinesConstrainerFrom.m201coerceMinLinesOh53vG4$foundation(this.minLines, j);
        } else {
            jM201coerceMinLinesOh53vG4$foundation = j;
        }
        AndroidParagraph androidParagraph = this.paragraph;
        boolean z2 = false;
        if (androidParagraph != null && (paragraphIntrinsics = this.paragraphIntrinsics) != null && !paragraphIntrinsics.getHasStaleResolvedFonts() && layoutDirection == this.intrinsicsLayoutDirection && (Constraints.m677equalsimpl0(jM201coerceMinLinesOh53vG4$foundation, this.prevConstraints) || (Constraints.m683getMaxWidthimpl(jM201coerceMinLinesOh53vG4$foundation) == Constraints.m683getMaxWidthimpl(this.prevConstraints) && Constraints.m685getMinWidthimpl(jM201coerceMinLinesOh53vG4$foundation) == Constraints.m685getMinWidthimpl(this.prevConstraints) && Constraints.m682getMaxHeightimpl(jM201coerceMinLinesOh53vG4$foundation) >= androidParagraph.getHeight() && !androidParagraph.layout.didExceedMaxLines))) {
            if (!Constraints.m677equalsimpl0(jM201coerceMinLinesOh53vG4$foundation, this.prevConstraints)) {
                AndroidParagraph androidParagraph2 = this.paragraph;
                long jM689constrain4WqzIAM = ConstraintsKt.m689constrain4WqzIAM(jM201coerceMinLinesOh53vG4$foundation, (((long) BasicTextKt.ceilToIntPx(Math.min(androidParagraph2.paragraphIntrinsics.layoutIntrinsics.getMaxIntrinsicWidth(), androidParagraph2.getWidth()))) << 32) | (((long) BasicTextKt.ceilToIntPx(androidParagraph2.getHeight())) & 4294967295L));
                this.layoutSize = jM689constrain4WqzIAM;
                if (this.overflow == 3 || (((int) (jM689constrain4WqzIAM >> 32)) >= androidParagraph2.getWidth() && ((int) (4294967295L & jM689constrain4WqzIAM)) >= androidParagraph2.getHeight())) {
                    z = false;
                }
                this.didOverflow = z;
                this.prevConstraints = jM201coerceMinLinesOh53vG4$foundation;
            }
            return false;
        }
        ParagraphIntrinsics layoutDirection2 = setLayoutDirection(layoutDirection);
        long jM847finalConstraintstfFHcEY = SerialDescriptorsKt.m847finalConstraintstfFHcEY(jM201coerceMinLinesOh53vG4$foundation, this.softWrap, this.overflow, layoutDirection2.getMaxIntrinsicWidth());
        boolean z3 = this.softWrap;
        int i = this.overflow;
        int i2 = this.maxLines;
        AndroidParagraph androidParagraph3 = new AndroidParagraph((AndroidParagraphIntrinsics) layoutDirection2, ((z3 || !(i == 2 || i == 4 || i == 5)) && i2 >= 1) ? i2 : 1, i, jM847finalConstraintstfFHcEY);
        this.prevConstraints = jM201coerceMinLinesOh53vG4$foundation;
        long jM689constrain4WqzIAM2 = ConstraintsKt.m689constrain4WqzIAM(jM201coerceMinLinesOh53vG4$foundation, (((long) BasicTextKt.ceilToIntPx(androidParagraph3.getHeight())) & 4294967295L) | (((long) BasicTextKt.ceilToIntPx(androidParagraph3.getWidth())) << 32));
        this.layoutSize = jM689constrain4WqzIAM2;
        if (this.overflow != 3 && (((int) (jM689constrain4WqzIAM2 >> 32)) < androidParagraph3.getWidth() || ((int) (jM689constrain4WqzIAM2 & 4294967295L)) < androidParagraph3.getHeight())) {
            z2 = true;
        }
        this.didOverflow = z2;
        this.paragraph = androidParagraph3;
        return true;
    }

    public final void markDirty() {
        this.paragraph = null;
        this.paragraphIntrinsics = null;
        this.intrinsicsLayoutDirection = null;
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
        this.prevConstraints = ConstraintsKt.createConstraints(0, 0, 0, 0);
        long j = 0;
        this.layoutSize = (j & 4294967295L) | (j << 32);
        this.didOverflow = false;
    }

    public final void setDensity$foundation(Density density) {
        long jM199constructorimpl;
        Density density2 = this.density;
        if (density != null) {
            int i = InlineDensity.$r8$clinit;
            jM199constructorimpl = InlineDensity.m199constructorimpl(density.getDensity(), density.getFontScale());
        } else {
            jM199constructorimpl = InlineDensity.Unspecified;
        }
        if (density2 == null) {
            this.density = density;
            this.lastDensity = jM199constructorimpl;
        } else if (density == null || this.lastDensity != jM199constructorimpl) {
            this.density = density;
            this.lastDensity = jM199constructorimpl;
            this.historyFlag = (this.historyFlag << 2) | 1;
            markDirty();
        }
    }

    public final ParagraphIntrinsics setLayoutDirection(LayoutDirection layoutDirection) {
        ParagraphIntrinsics androidParagraphIntrinsics = this.paragraphIntrinsics;
        if (androidParagraphIntrinsics == null || layoutDirection != this.intrinsicsLayoutDirection || androidParagraphIntrinsics.getHasStaleResolvedFonts()) {
            this.intrinsicsLayoutDirection = layoutDirection;
            String str = this.text;
            TextStyle textStyleResolveDefaults = ParagraphKt.resolveDefaults(this.style, layoutDirection);
            Density density = this.density;
            FontFamily$Resolver fontFamily$Resolver = this.fontFamilyResolver;
            EmptyList emptyList = EmptyList.INSTANCE;
            androidParagraphIntrinsics = new AndroidParagraphIntrinsics(str, textStyleResolveDefaults, emptyList, emptyList, fontFamily$Resolver, density);
        }
        this.paragraphIntrinsics = androidParagraphIntrinsics;
        return androidParagraphIntrinsics;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ParagraphLayoutCache(paragraph=");
        sb.append(this.paragraph != null ? "<paragraph>" : "null");
        sb.append(", lastDensity=");
        sb.append((Object) InlineDensity.m200toStringimpl(this.lastDensity));
        sb.append(", history=");
        sb.append(this.historyFlag);
        sb.append(", constraints=$)");
        return sb.toString();
    }

    /* JADX INFO: renamed from: update-L6sJoHM, reason: not valid java name */
    public final void m206updateL6sJoHM(String str, TextStyle textStyle, FontFamily$Resolver fontFamily$Resolver, int i, boolean z, int i2, int i3) {
        this.text = str;
        this.style = textStyle;
        this.fontFamilyResolver = fontFamily$Resolver;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        this.historyFlag = (this.historyFlag << 2) | 2;
        markDirty();
    }
}
