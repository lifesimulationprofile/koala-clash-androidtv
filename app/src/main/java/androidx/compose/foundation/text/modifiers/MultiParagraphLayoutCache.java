package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MultiParagraphLayoutCache {
    public Density density;
    public FontFamily$Resolver fontFamilyResolver;
    public long historyFlag;
    public LayoutDirection intrinsicsLayoutDirection;
    public TextLayoutResult layoutCache;
    public MinLinesConstrainer mMinLinesConstrainer;
    public int maxLines;
    public int minLines;
    public int overflow;
    public Request paragraphIntrinsics;
    public List placeholders;
    public boolean softWrap;
    public TextStyle style;
    public AnnotatedString text;
    public long lastDensity = InlineDensity.Unspecified;
    public int cachedIntrinsicHeightInputWidth = -1;
    public int cachedIntrinsicHeight = -1;

    public MultiParagraphLayoutCache(AnnotatedString annotatedString, TextStyle textStyle, FontFamily$Resolver fontFamily$Resolver, int i, boolean z, int i2, int i3, EmptyList emptyList) {
        this.text = annotatedString;
        this.fontFamilyResolver = fontFamily$Resolver;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        this.placeholders = emptyList;
        this.style = textStyle;
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
        int iCeilToIntPx = BasicTextKt.ceilToIntPx(m202layoutTextK40F9xA(jConstraints, layoutDirection).height);
        int iM684getMinHeightimpl = Constraints.m684getMinHeightimpl(jConstraints);
        if (iCeilToIntPx < iM684getMinHeightimpl) {
            iCeilToIntPx = iM684getMinHeightimpl;
        }
        this.cachedIntrinsicHeightInputWidth = i;
        this.cachedIntrinsicHeight = iCeilToIntPx;
        return iCeilToIntPx;
    }

    /* JADX INFO: renamed from: layoutText-K40F9xA, reason: not valid java name */
    public final MultiParagraph m202layoutTextK40F9xA(long j, LayoutDirection layoutDirection) {
        Request layoutDirection2 = setLayoutDirection(layoutDirection);
        long jM847finalConstraintstfFHcEY = SerialDescriptorsKt.m847finalConstraintstfFHcEY(j, this.softWrap, this.overflow, layoutDirection2.getMaxIntrinsicWidth());
        boolean z = this.softWrap;
        int i = this.overflow;
        int i2 = this.maxLines;
        return new MultiParagraph(layoutDirection2, jM847finalConstraintstfFHcEY, ((z || !(i == 2 || i == 4 || i == 5)) && i2 >= 1) ? i2 : 1, i);
    }

    /* JADX INFO: renamed from: layoutWithConstraints-K40F9xA, reason: not valid java name */
    public final boolean m203layoutWithConstraintsK40F9xA(long j, LayoutDirection layoutDirection) {
        this.historyFlag = (this.historyFlag << 2) | 3;
        if (this.minLines > 1) {
            MinLinesConstrainer minLinesConstrainerFrom = SerialKind.from(this.mMinLinesConstrainer, layoutDirection, this.style, this.density, this.fontFamilyResolver);
            this.mMinLinesConstrainer = minLinesConstrainerFrom;
            j = minLinesConstrainerFrom.m201coerceMinLinesOh53vG4$foundation(this.minLines, j);
        }
        TextLayoutResult textLayoutResult = this.layoutCache;
        if (textLayoutResult != null) {
            MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
            TextLayoutInput textLayoutInput = textLayoutResult.layoutInput;
            if (!multiParagraph.intrinsics.getHasStaleResolvedFonts()) {
                LayoutDirection layoutDirection2 = textLayoutInput.layoutDirection;
                long j2 = textLayoutInput.constraints;
                if (layoutDirection == layoutDirection2 && (Constraints.m677equalsimpl0(j, j2) || (Constraints.m683getMaxWidthimpl(j) == Constraints.m683getMaxWidthimpl(j2) && Constraints.m685getMinWidthimpl(j) == Constraints.m685getMinWidthimpl(j2) && Constraints.m682getMaxHeightimpl(j) >= multiParagraph.height && !multiParagraph.didExceedMaxLines))) {
                    if (Constraints.m677equalsimpl0(j, this.layoutCache.layoutInput.constraints)) {
                        return false;
                    }
                    this.layoutCache = m204textLayoutResultVKLhPVY(layoutDirection, j, this.layoutCache.multiParagraph);
                    return true;
                }
            }
        }
        this.layoutCache = m204textLayoutResultVKLhPVY(layoutDirection, j, m202layoutTextK40F9xA(j, layoutDirection));
        return true;
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
            this.paragraphIntrinsics = null;
            this.layoutCache = null;
            this.cachedIntrinsicHeight = -1;
            this.cachedIntrinsicHeightInputWidth = -1;
        }
    }

    public final Request setLayoutDirection(LayoutDirection layoutDirection) {
        Request request = this.paragraphIntrinsics;
        if (request == null || layoutDirection != this.intrinsicsLayoutDirection || request.getHasStaleResolvedFonts()) {
            this.intrinsicsLayoutDirection = layoutDirection;
            AnnotatedString annotatedString = this.text;
            TextStyle textStyleResolveDefaults = ParagraphKt.resolveDefaults(this.style, layoutDirection);
            Density density = this.density;
            FontFamily$Resolver fontFamily$Resolver = this.fontFamilyResolver;
            List list = this.placeholders;
            if (list == null) {
                list = EmptyList.INSTANCE;
            }
            request = new Request(annotatedString, textStyleResolveDefaults, list, density, fontFamily$Resolver);
        }
        this.paragraphIntrinsics = request;
        return request;
    }

    /* JADX INFO: renamed from: textLayoutResult-VKLhPVY, reason: not valid java name */
    public final TextLayoutResult m204textLayoutResultVKLhPVY(LayoutDirection layoutDirection, long j, MultiParagraph multiParagraph) {
        float fMin = Math.min(multiParagraph.intrinsics.getMaxIntrinsicWidth(), multiParagraph.width);
        AnnotatedString annotatedString = this.text;
        TextStyle textStyle = this.style;
        List list = this.placeholders;
        if (list == null) {
            list = EmptyList.INSTANCE;
        }
        return new TextLayoutResult(new TextLayoutInput(annotatedString, textStyle, list, this.maxLines, this.softWrap, this.overflow, this.density, layoutDirection, this.fontFamilyResolver, j), multiParagraph, ConstraintsKt.m689constrain4WqzIAM(j, (((long) BasicTextKt.ceilToIntPx(fMin)) << 32) | (((long) BasicTextKt.ceilToIntPx(multiParagraph.height)) & 4294967295L)));
    }

    public final String toString() {
        TextLayoutInput textLayoutInput;
        StringBuilder sb = new StringBuilder("MultiParagraphLayoutCache(textLayoutResult=");
        Object constraints = "null";
        sb.append(this.layoutCache != null ? "<TextLayoutResult>" : "null");
        sb.append(", lastDensity=");
        sb.append((Object) InlineDensity.m200toStringimpl(this.lastDensity));
        sb.append(", history=");
        sb.append(this.historyFlag);
        sb.append(", constraints=");
        TextLayoutResult textLayoutResult = this.layoutCache;
        if (textLayoutResult != null && (textLayoutInput = textLayoutResult.layoutInput) != null) {
            constraints = new Constraints(textLayoutInput.constraints);
        }
        sb.append(constraints);
        sb.append(')');
        return sb.toString();
    }
}
