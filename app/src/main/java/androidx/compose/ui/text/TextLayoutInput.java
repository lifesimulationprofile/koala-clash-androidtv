package androidx.compose.ui.text;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextLayoutInput {
    public final long constraints;
    public final Density density;
    public final FontFamily$Resolver fontFamilyResolver;
    public final LayoutDirection layoutDirection;
    public final int maxLines;
    public final int overflow;
    public final List placeholders;
    public final boolean softWrap;
    public final TextStyle style;
    public final AnnotatedString text;

    public TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List list, int i, boolean z, int i2, Density density, LayoutDirection layoutDirection, FontFamily$Resolver fontFamily$Resolver, long j) {
        this.text = annotatedString;
        this.style = textStyle;
        this.placeholders = list;
        this.maxLines = i;
        this.softWrap = z;
        this.overflow = i2;
        this.density = density;
        this.layoutDirection = layoutDirection;
        this.fontFamilyResolver = fontFamily$Resolver;
        this.constraints = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextLayoutInput)) {
            return false;
        }
        TextLayoutInput textLayoutInput = (TextLayoutInput) obj;
        return Intrinsics.areEqual(this.text, textLayoutInput.text) && Intrinsics.areEqual(this.style, textLayoutInput.style) && Intrinsics.areEqual(this.placeholders, textLayoutInput.placeholders) && this.maxLines == textLayoutInput.maxLines && this.softWrap == textLayoutInput.softWrap && this.overflow == textLayoutInput.overflow && Intrinsics.areEqual(this.density, textLayoutInput.density) && this.layoutDirection == textLayoutInput.layoutDirection && Intrinsics.areEqual(this.fontFamilyResolver, textLayoutInput.fontFamilyResolver) && Constraints.m677equalsimpl0(this.constraints, textLayoutInput.constraints);
    }

    public final int hashCode() {
        int iHashCode = (this.fontFamilyResolver.hashCode() + ((this.layoutDirection.hashCode() + ((this.density.hashCode() + ((((((((this.placeholders.hashCode() + Modifier.CC.m(this.style, this.text.hashCode() * 31, 31)) * 31) + this.maxLines) * 31) + (this.softWrap ? 1231 : 1237)) * 31) + this.overflow) * 31)) * 31)) * 31)) * 31;
        long j = this.constraints;
        return ((int) (j ^ (j >>> 32))) + iHashCode;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("TextLayoutInput(text=");
        sb.append((Object) this.text);
        sb.append(", style=");
        sb.append(this.style);
        sb.append(", placeholders=");
        sb.append(this.placeholders);
        sb.append(", maxLines=");
        sb.append(this.maxLines);
        sb.append(", softWrap=");
        sb.append(this.softWrap);
        sb.append(", overflow=");
        int i = this.overflow;
        if (i == 1) {
            str = "Clip";
        } else if (i == 2) {
            str = "Ellipsis";
        } else if (i == 5) {
            str = "MiddleEllipsis";
        } else if (i == 3) {
            str = "Visible";
        } else {
            str = i == 4 ? "StartEllipsis" : "Invalid";
        }
        sb.append((Object) str);
        sb.append(", density=");
        sb.append(this.density);
        sb.append(", layoutDirection=");
        sb.append(this.layoutDirection);
        sb.append(", fontFamilyResolver=");
        sb.append(this.fontFamilyResolver);
        sb.append(", constraints=");
        sb.append((Object) Constraints.m686toStringimpl(this.constraints));
        sb.append(')');
        return sb.toString();
    }
}
