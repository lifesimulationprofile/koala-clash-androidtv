package androidx.compose.material3.internal;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.MenuKt;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAbsoluteAlignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DropdownMenuPositionProvider implements PopupPositionProvider {
    public final AnchorAlignmentOffsetPosition$Vertical bottomToAnchorTop;
    public final WindowAlignmentMarginPosition$Vertical bottomToWindowBottom;
    public final AnchorAlignmentOffsetPosition$Vertical centerToAnchorTop;
    public final long contentOffset;
    public final Density density;
    public final TextFieldDefaults dropdownMenuAnchorPosition;
    public final AnchorAlignmentOffsetPosition$Horizontal endToAnchorEnd;
    public final WindowAlignmentMarginPosition$Horizontal leftToWindowLeft;
    public final AndroidMenu_androidKt$$ExternalSyntheticLambda0 onPositionCalculated;
    public final WindowAlignmentMarginPosition$Horizontal rightToWindowRight;
    public final AnchorAlignmentOffsetPosition$Horizontal startToAnchorStart;
    public final AnchorAlignmentOffsetPosition$Vertical topToAnchorBottom;
    public final WindowAlignmentMarginPosition$Vertical topToWindowTop;
    public final MutableState transformOriginState;
    public final int verticalMargin;

    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.material3.internal.WindowAlignmentMarginPosition$Horizontal] */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.material3.internal.WindowAlignmentMarginPosition$Horizontal] */
    /* JADX WARN: Type inference failed for: r4v7, types: [androidx.compose.material3.internal.WindowAlignmentMarginPosition$Vertical] */
    /* JADX WARN: Type inference failed for: r4v8, types: [androidx.compose.material3.internal.WindowAlignmentMarginPosition$Vertical] */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Vertical] */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Vertical] */
    /* JADX WARN: Type inference failed for: r5v5, types: [androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Vertical] */
    /* JADX WARN: Type inference failed for: r8v1, types: [androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Horizontal] */
    /* JADX WARN: Type inference failed for: r8v3, types: [androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Horizontal] */
    public DropdownMenuPositionProvider(MutableState mutableState, long j, Density density, AndroidMenu_androidKt$$ExternalSyntheticLambda0 androidMenu_androidKt$$ExternalSyntheticLambda0) {
        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE$1;
        final int iMo86roundToPx0680j_4 = density.mo86roundToPx0680j_4(MenuKt.MenuVerticalMargin);
        this.transformOriginState = mutableState;
        this.contentOffset = j;
        this.density = density;
        this.dropdownMenuAnchorPosition = textFieldDefaults;
        this.verticalMargin = iMo86roundToPx0680j_4;
        this.onPositionCalculated = androidMenu_androidKt$$ExternalSyntheticLambda0;
        final int iMo86roundToPx0680j_5 = density.mo86roundToPx0680j_4(DpOffset.m707getXD9Ej5fM(j));
        final BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
        this.startToAnchorStart = new MenuPosition$Horizontal(horizontal, horizontal, iMo86roundToPx0680j_5) { // from class: androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Horizontal
            public final BiasAlignment.Horizontal anchorAlignment;
            public final BiasAlignment.Horizontal menuAlignment;
            public final int offset;

            {
                this.menuAlignment = horizontal;
                this.anchorAlignment = horizontal;
                this.offset = iMo86roundToPx0680j_5;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AnchorAlignmentOffsetPosition$Horizontal)) {
                    return false;
                }
                AnchorAlignmentOffsetPosition$Horizontal anchorAlignmentOffsetPosition$Horizontal = (AnchorAlignmentOffsetPosition$Horizontal) obj;
                return this.menuAlignment.equals(anchorAlignmentOffsetPosition$Horizontal.menuAlignment) && this.anchorAlignment.equals(anchorAlignmentOffsetPosition$Horizontal.anchorAlignment) && this.offset == anchorAlignmentOffsetPosition$Horizontal.offset;
            }

            public final int hashCode() {
                return ImageAnalysis$$ExternalSyntheticLambda1.m(this.anchorAlignment.bias, Float.floatToIntBits(this.menuAlignment.bias) * 31, 31) + this.offset;
            }

            @Override // androidx.compose.material3.internal.MenuPosition$Horizontal
            /* JADX INFO: renamed from: position-95KtPRI, reason: not valid java name */
            public final int mo279position95KtPRI(IntRect intRect, long j2, int i, LayoutDirection layoutDirection) {
                int iAlign = this.anchorAlignment.align(0, intRect.getWidth(), layoutDirection);
                int i2 = -this.menuAlignment.align(0, i, layoutDirection);
                LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
                int i3 = this.offset;
                if (layoutDirection != layoutDirection2) {
                    i3 = -i3;
                }
                return intRect.left + iAlign + i2 + i3;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Horizontal(menuAlignment=");
                sb.append(this.menuAlignment);
                sb.append(", anchorAlignment=");
                sb.append(this.anchorAlignment);
                sb.append(", offset=");
                return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.offset, ')');
            }
        };
        final BiasAlignment.Horizontal horizontal2 = Alignment.Companion.End;
        new MenuPosition$Horizontal(horizontal2, horizontal, iMo86roundToPx0680j_5) { // from class: androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Horizontal
            public final BiasAlignment.Horizontal anchorAlignment;
            public final BiasAlignment.Horizontal menuAlignment;
            public final int offset;

            {
                this.menuAlignment = horizontal2;
                this.anchorAlignment = horizontal;
                this.offset = iMo86roundToPx0680j_5;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AnchorAlignmentOffsetPosition$Horizontal)) {
                    return false;
                }
                AnchorAlignmentOffsetPosition$Horizontal anchorAlignmentOffsetPosition$Horizontal = (AnchorAlignmentOffsetPosition$Horizontal) obj;
                return this.menuAlignment.equals(anchorAlignmentOffsetPosition$Horizontal.menuAlignment) && this.anchorAlignment.equals(anchorAlignmentOffsetPosition$Horizontal.anchorAlignment) && this.offset == anchorAlignmentOffsetPosition$Horizontal.offset;
            }

            public final int hashCode() {
                return ImageAnalysis$$ExternalSyntheticLambda1.m(this.anchorAlignment.bias, Float.floatToIntBits(this.menuAlignment.bias) * 31, 31) + this.offset;
            }

            @Override // androidx.compose.material3.internal.MenuPosition$Horizontal
            /* JADX INFO: renamed from: position-95KtPRI, reason: not valid java name */
            public final int mo279position95KtPRI(IntRect intRect, long j2, int i, LayoutDirection layoutDirection) {
                int iAlign = this.anchorAlignment.align(0, intRect.getWidth(), layoutDirection);
                int i2 = -this.menuAlignment.align(0, i, layoutDirection);
                LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
                int i3 = this.offset;
                if (layoutDirection != layoutDirection2) {
                    i3 = -i3;
                }
                return intRect.left + iAlign + i2 + i3;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Horizontal(menuAlignment=");
                sb.append(this.menuAlignment);
                sb.append(", anchorAlignment=");
                sb.append(this.anchorAlignment);
                sb.append(", offset=");
                return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.offset, ')');
            }
        };
        this.endToAnchorEnd = new MenuPosition$Horizontal(horizontal2, horizontal2, iMo86roundToPx0680j_5) { // from class: androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Horizontal
            public final BiasAlignment.Horizontal anchorAlignment;
            public final BiasAlignment.Horizontal menuAlignment;
            public final int offset;

            {
                this.menuAlignment = horizontal2;
                this.anchorAlignment = horizontal2;
                this.offset = iMo86roundToPx0680j_5;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AnchorAlignmentOffsetPosition$Horizontal)) {
                    return false;
                }
                AnchorAlignmentOffsetPosition$Horizontal anchorAlignmentOffsetPosition$Horizontal = (AnchorAlignmentOffsetPosition$Horizontal) obj;
                return this.menuAlignment.equals(anchorAlignmentOffsetPosition$Horizontal.menuAlignment) && this.anchorAlignment.equals(anchorAlignmentOffsetPosition$Horizontal.anchorAlignment) && this.offset == anchorAlignmentOffsetPosition$Horizontal.offset;
            }

            public final int hashCode() {
                return ImageAnalysis$$ExternalSyntheticLambda1.m(this.anchorAlignment.bias, Float.floatToIntBits(this.menuAlignment.bias) * 31, 31) + this.offset;
            }

            @Override // androidx.compose.material3.internal.MenuPosition$Horizontal
            /* JADX INFO: renamed from: position-95KtPRI, reason: not valid java name */
            public final int mo279position95KtPRI(IntRect intRect, long j2, int i, LayoutDirection layoutDirection) {
                int iAlign = this.anchorAlignment.align(0, intRect.getWidth(), layoutDirection);
                int i2 = -this.menuAlignment.align(0, i, layoutDirection);
                LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
                int i3 = this.offset;
                if (layoutDirection != layoutDirection2) {
                    i3 = -i3;
                }
                return intRect.left + iAlign + i2 + i3;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Horizontal(menuAlignment=");
                sb.append(this.menuAlignment);
                sb.append(", anchorAlignment=");
                sb.append(this.anchorAlignment);
                sb.append(", offset=");
                return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.offset, ')');
            }
        };
        new MenuPosition$Horizontal(horizontal, horizontal2, iMo86roundToPx0680j_5) { // from class: androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Horizontal
            public final BiasAlignment.Horizontal anchorAlignment;
            public final BiasAlignment.Horizontal menuAlignment;
            public final int offset;

            {
                this.menuAlignment = horizontal;
                this.anchorAlignment = horizontal2;
                this.offset = iMo86roundToPx0680j_5;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AnchorAlignmentOffsetPosition$Horizontal)) {
                    return false;
                }
                AnchorAlignmentOffsetPosition$Horizontal anchorAlignmentOffsetPosition$Horizontal = (AnchorAlignmentOffsetPosition$Horizontal) obj;
                return this.menuAlignment.equals(anchorAlignmentOffsetPosition$Horizontal.menuAlignment) && this.anchorAlignment.equals(anchorAlignmentOffsetPosition$Horizontal.anchorAlignment) && this.offset == anchorAlignmentOffsetPosition$Horizontal.offset;
            }

            public final int hashCode() {
                return ImageAnalysis$$ExternalSyntheticLambda1.m(this.anchorAlignment.bias, Float.floatToIntBits(this.menuAlignment.bias) * 31, 31) + this.offset;
            }

            @Override // androidx.compose.material3.internal.MenuPosition$Horizontal
            /* JADX INFO: renamed from: position-95KtPRI, reason: not valid java name */
            public final int mo279position95KtPRI(IntRect intRect, long j2, int i, LayoutDirection layoutDirection) {
                int iAlign = this.anchorAlignment.align(0, intRect.getWidth(), layoutDirection);
                int i2 = -this.menuAlignment.align(0, i, layoutDirection);
                LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
                int i3 = this.offset;
                if (layoutDirection != layoutDirection2) {
                    i3 = -i3;
                }
                return intRect.left + iAlign + i2 + i3;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Horizontal(menuAlignment=");
                sb.append(this.menuAlignment);
                sb.append(", anchorAlignment=");
                sb.append(this.anchorAlignment);
                sb.append(", offset=");
                return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.offset, ')');
            }
        };
        final BiasAbsoluteAlignment.Horizontal horizontal3 = AbsoluteAlignment.Left;
        this.leftToWindowLeft = new MenuPosition$Horizontal(horizontal3) { // from class: androidx.compose.material3.internal.WindowAlignmentMarginPosition$Horizontal
            public final BiasAbsoluteAlignment.Horizontal alignment;

            {
                this.alignment = horizontal3;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof WindowAlignmentMarginPosition$Horizontal) && this.alignment.equals(((WindowAlignmentMarginPosition$Horizontal) obj).alignment);
            }

            public final int hashCode() {
                return Float.floatToIntBits(this.alignment.bias) * 31;
            }

            @Override // androidx.compose.material3.internal.MenuPosition$Horizontal
            /* JADX INFO: renamed from: position-95KtPRI */
            public final int mo279position95KtPRI(IntRect intRect, long j2, int i, LayoutDirection layoutDirection) {
                int i2 = (int) (j2 >> 32);
                if (i >= i2) {
                    return Math.round((1 + (layoutDirection != LayoutDirection.Ltr ? 0.0f * (-1) : 0.0f)) * ((i2 - i) / 2.0f));
                }
                return RangesKt.coerceIn(this.alignment.align(i, i2, layoutDirection), 0, i2 - i);
            }

            public final String toString() {
                return "Horizontal(alignment=" + this.alignment + ", margin=0)";
            }
        };
        final BiasAbsoluteAlignment.Horizontal horizontal4 = AbsoluteAlignment.Right;
        this.rightToWindowRight = new MenuPosition$Horizontal(horizontal4) { // from class: androidx.compose.material3.internal.WindowAlignmentMarginPosition$Horizontal
            public final BiasAbsoluteAlignment.Horizontal alignment;

            {
                this.alignment = horizontal4;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof WindowAlignmentMarginPosition$Horizontal) && this.alignment.equals(((WindowAlignmentMarginPosition$Horizontal) obj).alignment);
            }

            public final int hashCode() {
                return Float.floatToIntBits(this.alignment.bias) * 31;
            }

            @Override // androidx.compose.material3.internal.MenuPosition$Horizontal
            /* JADX INFO: renamed from: position-95KtPRI */
            public final int mo279position95KtPRI(IntRect intRect, long j2, int i, LayoutDirection layoutDirection) {
                int i2 = (int) (j2 >> 32);
                if (i >= i2) {
                    return Math.round((1 + (layoutDirection != LayoutDirection.Ltr ? 0.0f * (-1) : 0.0f)) * ((i2 - i) / 2.0f));
                }
                return RangesKt.coerceIn(this.alignment.align(i, i2, layoutDirection), 0, i2 - i);
            }

            public final String toString() {
                return "Horizontal(alignment=" + this.alignment + ", margin=0)";
            }
        };
        final int iMo86roundToPx0680j_6 = density.mo86roundToPx0680j_4(DpOffset.m708getYD9Ej5fM(j));
        final BiasAlignment.Vertical vertical = Alignment.Companion.Top;
        final BiasAlignment.Vertical vertical2 = Alignment.Companion.Bottom;
        this.topToAnchorBottom = new MenuPosition$Vertical(vertical, vertical2, iMo86roundToPx0680j_6) { // from class: androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Vertical
            public final BiasAlignment.Vertical anchorAlignment;
            public final BiasAlignment.Vertical menuAlignment;
            public final int offset;

            {
                this.menuAlignment = vertical;
                this.anchorAlignment = vertical2;
                this.offset = iMo86roundToPx0680j_6;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AnchorAlignmentOffsetPosition$Vertical)) {
                    return false;
                }
                AnchorAlignmentOffsetPosition$Vertical anchorAlignmentOffsetPosition$Vertical = (AnchorAlignmentOffsetPosition$Vertical) obj;
                return this.menuAlignment.equals(anchorAlignmentOffsetPosition$Vertical.menuAlignment) && this.anchorAlignment.equals(anchorAlignmentOffsetPosition$Vertical.anchorAlignment) && this.offset == anchorAlignmentOffsetPosition$Vertical.offset;
            }

            public final int hashCode() {
                return ImageAnalysis$$ExternalSyntheticLambda1.m(this.anchorAlignment.bias, Float.floatToIntBits(this.menuAlignment.bias) * 31, 31) + this.offset;
            }

            @Override // androidx.compose.material3.internal.MenuPosition$Vertical
            /* JADX INFO: renamed from: position-JVtK1S4, reason: not valid java name */
            public final int mo280positionJVtK1S4(IntRect intRect, long j2, int i) {
                int iAlign = this.anchorAlignment.align(0, intRect.getHeight());
                return intRect.top + iAlign + (-this.menuAlignment.align(0, i)) + this.offset;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Vertical(menuAlignment=");
                sb.append(this.menuAlignment);
                sb.append(", anchorAlignment=");
                sb.append(this.anchorAlignment);
                sb.append(", offset=");
                return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.offset, ')');
            }
        };
        new MenuPosition$Vertical(vertical, vertical, iMo86roundToPx0680j_6) { // from class: androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Vertical
            public final BiasAlignment.Vertical anchorAlignment;
            public final BiasAlignment.Vertical menuAlignment;
            public final int offset;

            {
                this.menuAlignment = vertical;
                this.anchorAlignment = vertical;
                this.offset = iMo86roundToPx0680j_6;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AnchorAlignmentOffsetPosition$Vertical)) {
                    return false;
                }
                AnchorAlignmentOffsetPosition$Vertical anchorAlignmentOffsetPosition$Vertical = (AnchorAlignmentOffsetPosition$Vertical) obj;
                return this.menuAlignment.equals(anchorAlignmentOffsetPosition$Vertical.menuAlignment) && this.anchorAlignment.equals(anchorAlignmentOffsetPosition$Vertical.anchorAlignment) && this.offset == anchorAlignmentOffsetPosition$Vertical.offset;
            }

            public final int hashCode() {
                return ImageAnalysis$$ExternalSyntheticLambda1.m(this.anchorAlignment.bias, Float.floatToIntBits(this.menuAlignment.bias) * 31, 31) + this.offset;
            }

            @Override // androidx.compose.material3.internal.MenuPosition$Vertical
            /* JADX INFO: renamed from: position-JVtK1S4, reason: not valid java name */
            public final int mo280positionJVtK1S4(IntRect intRect, long j2, int i) {
                int iAlign = this.anchorAlignment.align(0, intRect.getHeight());
                return intRect.top + iAlign + (-this.menuAlignment.align(0, i)) + this.offset;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Vertical(menuAlignment=");
                sb.append(this.menuAlignment);
                sb.append(", anchorAlignment=");
                sb.append(this.anchorAlignment);
                sb.append(", offset=");
                return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.offset, ')');
            }
        };
        this.bottomToAnchorTop = new MenuPosition$Vertical(vertical2, vertical, iMo86roundToPx0680j_6) { // from class: androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Vertical
            public final BiasAlignment.Vertical anchorAlignment;
            public final BiasAlignment.Vertical menuAlignment;
            public final int offset;

            {
                this.menuAlignment = vertical2;
                this.anchorAlignment = vertical;
                this.offset = iMo86roundToPx0680j_6;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AnchorAlignmentOffsetPosition$Vertical)) {
                    return false;
                }
                AnchorAlignmentOffsetPosition$Vertical anchorAlignmentOffsetPosition$Vertical = (AnchorAlignmentOffsetPosition$Vertical) obj;
                return this.menuAlignment.equals(anchorAlignmentOffsetPosition$Vertical.menuAlignment) && this.anchorAlignment.equals(anchorAlignmentOffsetPosition$Vertical.anchorAlignment) && this.offset == anchorAlignmentOffsetPosition$Vertical.offset;
            }

            public final int hashCode() {
                return ImageAnalysis$$ExternalSyntheticLambda1.m(this.anchorAlignment.bias, Float.floatToIntBits(this.menuAlignment.bias) * 31, 31) + this.offset;
            }

            @Override // androidx.compose.material3.internal.MenuPosition$Vertical
            /* JADX INFO: renamed from: position-JVtK1S4, reason: not valid java name */
            public final int mo280positionJVtK1S4(IntRect intRect, long j2, int i) {
                int iAlign = this.anchorAlignment.align(0, intRect.getHeight());
                return intRect.top + iAlign + (-this.menuAlignment.align(0, i)) + this.offset;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Vertical(menuAlignment=");
                sb.append(this.menuAlignment);
                sb.append(", anchorAlignment=");
                sb.append(this.anchorAlignment);
                sb.append(", offset=");
                return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.offset, ')');
            }
        };
        new MenuPosition$Vertical(vertical2, vertical2, iMo86roundToPx0680j_6) { // from class: androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Vertical
            public final BiasAlignment.Vertical anchorAlignment;
            public final BiasAlignment.Vertical menuAlignment;
            public final int offset;

            {
                this.menuAlignment = vertical2;
                this.anchorAlignment = vertical2;
                this.offset = iMo86roundToPx0680j_6;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AnchorAlignmentOffsetPosition$Vertical)) {
                    return false;
                }
                AnchorAlignmentOffsetPosition$Vertical anchorAlignmentOffsetPosition$Vertical = (AnchorAlignmentOffsetPosition$Vertical) obj;
                return this.menuAlignment.equals(anchorAlignmentOffsetPosition$Vertical.menuAlignment) && this.anchorAlignment.equals(anchorAlignmentOffsetPosition$Vertical.anchorAlignment) && this.offset == anchorAlignmentOffsetPosition$Vertical.offset;
            }

            public final int hashCode() {
                return ImageAnalysis$$ExternalSyntheticLambda1.m(this.anchorAlignment.bias, Float.floatToIntBits(this.menuAlignment.bias) * 31, 31) + this.offset;
            }

            @Override // androidx.compose.material3.internal.MenuPosition$Vertical
            /* JADX INFO: renamed from: position-JVtK1S4, reason: not valid java name */
            public final int mo280positionJVtK1S4(IntRect intRect, long j2, int i) {
                int iAlign = this.anchorAlignment.align(0, intRect.getHeight());
                return intRect.top + iAlign + (-this.menuAlignment.align(0, i)) + this.offset;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Vertical(menuAlignment=");
                sb.append(this.menuAlignment);
                sb.append(", anchorAlignment=");
                sb.append(this.anchorAlignment);
                sb.append(", offset=");
                return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.offset, ')');
            }
        };
        final BiasAlignment.Vertical vertical3 = Alignment.Companion.CenterVertically;
        this.centerToAnchorTop = new MenuPosition$Vertical(vertical3, vertical, iMo86roundToPx0680j_6) { // from class: androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Vertical
            public final BiasAlignment.Vertical anchorAlignment;
            public final BiasAlignment.Vertical menuAlignment;
            public final int offset;

            {
                this.menuAlignment = vertical3;
                this.anchorAlignment = vertical;
                this.offset = iMo86roundToPx0680j_6;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AnchorAlignmentOffsetPosition$Vertical)) {
                    return false;
                }
                AnchorAlignmentOffsetPosition$Vertical anchorAlignmentOffsetPosition$Vertical = (AnchorAlignmentOffsetPosition$Vertical) obj;
                return this.menuAlignment.equals(anchorAlignmentOffsetPosition$Vertical.menuAlignment) && this.anchorAlignment.equals(anchorAlignmentOffsetPosition$Vertical.anchorAlignment) && this.offset == anchorAlignmentOffsetPosition$Vertical.offset;
            }

            public final int hashCode() {
                return ImageAnalysis$$ExternalSyntheticLambda1.m(this.anchorAlignment.bias, Float.floatToIntBits(this.menuAlignment.bias) * 31, 31) + this.offset;
            }

            @Override // androidx.compose.material3.internal.MenuPosition$Vertical
            /* JADX INFO: renamed from: position-JVtK1S4, reason: not valid java name */
            public final int mo280positionJVtK1S4(IntRect intRect, long j2, int i) {
                int iAlign = this.anchorAlignment.align(0, intRect.getHeight());
                return intRect.top + iAlign + (-this.menuAlignment.align(0, i)) + this.offset;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Vertical(menuAlignment=");
                sb.append(this.menuAlignment);
                sb.append(", anchorAlignment=");
                sb.append(this.anchorAlignment);
                sb.append(", offset=");
                return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.offset, ')');
            }
        };
        this.topToWindowTop = new MenuPosition$Vertical(vertical, iMo86roundToPx0680j_4) { // from class: androidx.compose.material3.internal.WindowAlignmentMarginPosition$Vertical
            public final BiasAlignment.Vertical alignment;
            public final int margin;

            {
                this.alignment = vertical;
                this.margin = iMo86roundToPx0680j_4;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof WindowAlignmentMarginPosition$Vertical)) {
                    return false;
                }
                WindowAlignmentMarginPosition$Vertical windowAlignmentMarginPosition$Vertical = (WindowAlignmentMarginPosition$Vertical) obj;
                return this.alignment.equals(windowAlignmentMarginPosition$Vertical.alignment) && this.margin == windowAlignmentMarginPosition$Vertical.margin;
            }

            public final int hashCode() {
                return (Float.floatToIntBits(this.alignment.bias) * 31) + this.margin;
            }

            @Override // androidx.compose.material3.internal.MenuPosition$Vertical
            /* JADX INFO: renamed from: position-JVtK1S4 */
            public final int mo280positionJVtK1S4(IntRect intRect, long j2, int i) {
                int i2 = (int) (j2 & 4294967295L);
                int i3 = this.margin;
                if (i < i2 - (i3 * 2)) {
                    return RangesKt.coerceIn(this.alignment.align(i, i2), i3, (i2 - i3) - i);
                }
                return Math.round((1 + 0.0f) * ((i2 - i) / 2.0f));
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Vertical(alignment=");
                sb.append(this.alignment);
                sb.append(", margin=");
                return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.margin, ')');
            }
        };
        this.bottomToWindowBottom = new MenuPosition$Vertical(vertical2, iMo86roundToPx0680j_4) { // from class: androidx.compose.material3.internal.WindowAlignmentMarginPosition$Vertical
            public final BiasAlignment.Vertical alignment;
            public final int margin;

            {
                this.alignment = vertical2;
                this.margin = iMo86roundToPx0680j_4;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof WindowAlignmentMarginPosition$Vertical)) {
                    return false;
                }
                WindowAlignmentMarginPosition$Vertical windowAlignmentMarginPosition$Vertical = (WindowAlignmentMarginPosition$Vertical) obj;
                return this.alignment.equals(windowAlignmentMarginPosition$Vertical.alignment) && this.margin == windowAlignmentMarginPosition$Vertical.margin;
            }

            public final int hashCode() {
                return (Float.floatToIntBits(this.alignment.bias) * 31) + this.margin;
            }

            @Override // androidx.compose.material3.internal.MenuPosition$Vertical
            /* JADX INFO: renamed from: position-JVtK1S4 */
            public final int mo280positionJVtK1S4(IntRect intRect, long j2, int i) {
                int i2 = (int) (j2 & 4294967295L);
                int i3 = this.margin;
                if (i < i2 - (i3 * 2)) {
                    return RangesKt.coerceIn(this.alignment.align(i, i2), i3, (i2 - i3) - i);
                }
                return Math.round((1 + 0.0f) * ((i2 - i) / 2.0f));
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Vertical(alignment=");
                sb.append(this.alignment);
                sb.append(", margin=");
                return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.margin, ')');
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0158 A[LOOP:3: B:52:0x0158->B:62:0x0171, LOOP_START, PHI: r6
      0x0158: PHI (r6v6 int) = (r6v5 int), (r6v7 int) binds: [B:51:0x0156, B:62:0x0171] A[DONT_GENERATE, DONT_INLINE]] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:52:0x0158
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public final long mo10calculatePositionllwVHH4(androidx.compose.ui.unit.IntRect r24, long r25, androidx.compose.ui.unit.LayoutDirection r27, long r28) {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.DropdownMenuPositionProvider.mo10calculatePositionllwVHH4(androidx.compose.ui.unit.IntRect, long, androidx.compose.ui.unit.LayoutDirection, long):long");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DropdownMenuPositionProvider) {
            DropdownMenuPositionProvider dropdownMenuPositionProvider = (DropdownMenuPositionProvider) obj;
            if (Intrinsics.areEqual(this.transformOriginState, dropdownMenuPositionProvider.transformOriginState) && this.contentOffset == dropdownMenuPositionProvider.contentOffset && Intrinsics.areEqual(this.density, dropdownMenuPositionProvider.density) && Intrinsics.areEqual(this.dropdownMenuAnchorPosition, dropdownMenuPositionProvider.dropdownMenuAnchorPosition) && this.verticalMargin == dropdownMenuPositionProvider.verticalMargin && Intrinsics.areEqual(this.onPositionCalculated, dropdownMenuPositionProvider.onPositionCalculated)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.transformOriginState.hashCode() * 31;
        long j = this.contentOffset;
        return this.onPositionCalculated.hashCode() + ((((this.dropdownMenuAnchorPosition.hashCode() + ((this.density.hashCode() + ((((int) (j ^ (j >>> 32))) + iHashCode) * 31)) * 31)) * 31) + this.verticalMargin) * 961);
    }

    public final String toString() {
        return "DropdownMenuPositionProvider(transformOriginState=" + this.transformOriginState + ", contentOffset=" + ((Object) DpOffset.m709toStringimpl(this.contentOffset)) + ", density=" + this.density + ", dropdownMenuAnchorPosition=" + this.dropdownMenuAnchorPosition + ", verticalMargin=" + this.verticalMargin + ", horizontalMargin=0, onPositionCalculated=" + this.onPositionCalculated + ')';
    }
}
