package androidx.compose.foundation.style;

import androidx.collection.MutableIntList;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ResolvedStyle implements CompositionLocalAccessorScope, Density {
    public float alpha;
    public boolean animating;
    public Brush backgroundBrush;
    public float baselineShift;
    public Brush borderBrush;
    public float borderWidth;
    public boolean clip;
    public int compositeHash;
    public Brush contentBrush;
    public long contentColor;
    public float contentPaddingBottom;
    public float contentPaddingEnd;
    public float contentPaddingStart;
    public float contentPaddingTop;
    public int currentIndex;
    public Object dropShadow;
    public float externalPaddingBottom;
    public float externalPaddingEnd;
    public float externalPaddingStart;
    public float externalPaddingTop;
    public int flags;
    public SystemFontFamily fontFamily;
    public long fontSize;
    public Brush foregroundBrush;
    public final long foregroundColor;
    public MutableIntList indexStack;
    public Object innerShadow;
    public long letterSpacing;
    public int lineBreak;
    public long lineHeight;
    public StyleOuterNode node;
    public float rotationX;
    public float rotationY;
    public float rotationZ;
    public float scaleX;
    public float scaleY;
    public Shape shape;
    public int textEnums;
    public TextIndent textIndent;
    public long transformOrigin;
    public float translationX;
    public float translationY;
    public float zIndex;
    public float _density = 1.0f;
    public float width = Float.NaN;
    public float height = Float.NaN;
    public float widthFraction = Float.NaN;
    public float heightFraction = Float.NaN;
    public float left = Float.NaN;
    public float top = Float.NaN;
    public float right = Float.NaN;
    public float bottom = Float.NaN;
    public float minHeight = Float.NaN;
    public float maxHeight = Float.NaN;
    public float minWidth = Float.NaN;
    public float maxWidth = Float.NaN;
    public long borderColor = Color.Black;
    public long backgroundColor = Color.Transparent;

    public ResolvedStyle() {
        long j = Color.Unspecified;
        this.foregroundColor = j;
        this.shape = BrushKt.RectangleShape;
        this.alpha = 1.0f;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.transformOrigin = TransformOrigin.Center;
        this.contentColor = j;
        long j2 = TextUnit.Unspecified;
        this.fontSize = j2;
        this.lineHeight = j2;
        this.letterSpacing = j2;
        this.baselineShift = Float.NaN;
        this.lineBreak = 0;
    }

    /* JADX INFO: renamed from: border-cXLIe8U, reason: not valid java name */
    public final void m159bordercXLIe8U(float f, long j) {
        this.flags |= 3;
        float fCeil = 0.0f;
        if (!Dp.m704equalsimpl0(f, Float.NaN)) {
            fCeil = Dp.m704equalsimpl0(f, 0.0f) ? 1.0f : (float) Math.ceil(f * this._density);
        }
        this.borderWidth = fCeil;
        this.flags |= 2;
        this.borderColor = j;
        this.borderBrush = null;
    }

    public final void copyInheritedStylesInto$foundation(ResolvedStyle resolvedStyle) {
        resolvedStyle.contentColor = this.contentColor;
        resolvedStyle.contentBrush = this.contentBrush;
        resolvedStyle.fontFamily = this.fontFamily;
        resolvedStyle.textIndent = this.textIndent;
        resolvedStyle.fontSize = this.fontSize;
        resolvedStyle.lineHeight = this.lineHeight;
        resolvedStyle.letterSpacing = this.letterSpacing;
        resolvedStyle.baselineShift = this.baselineShift;
        resolvedStyle.lineBreak = this.lineBreak;
        resolvedStyle.textEnums = this.textEnums;
    }

    public final void copyInto$foundation(ResolvedStyle resolvedStyle) {
        resolvedStyle.flags = this.flags;
        resolvedStyle.left = this.left;
        resolvedStyle.top = this.top;
        resolvedStyle.right = this.right;
        resolvedStyle.bottom = this.bottom;
        resolvedStyle.minHeight = this.minHeight;
        resolvedStyle.maxHeight = this.maxHeight;
        resolvedStyle.minWidth = this.minWidth;
        resolvedStyle.maxWidth = this.maxWidth;
        resolvedStyle.contentPaddingStart = this.contentPaddingStart;
        resolvedStyle.contentPaddingEnd = this.contentPaddingEnd;
        resolvedStyle.contentPaddingTop = this.contentPaddingTop;
        resolvedStyle.contentPaddingBottom = this.contentPaddingBottom;
        resolvedStyle.externalPaddingStart = this.externalPaddingStart;
        resolvedStyle.externalPaddingEnd = this.externalPaddingEnd;
        resolvedStyle.externalPaddingTop = this.externalPaddingTop;
        resolvedStyle.externalPaddingBottom = this.externalPaddingBottom;
        resolvedStyle.borderWidth = this.borderWidth;
        resolvedStyle.shape = this.shape;
        resolvedStyle.alpha = this.alpha;
        resolvedStyle.scaleX = this.scaleX;
        resolvedStyle.scaleY = this.scaleY;
        resolvedStyle.translationX = this.translationX;
        resolvedStyle.translationY = this.translationY;
        resolvedStyle.rotationX = this.rotationX;
        resolvedStyle.rotationY = this.rotationY;
        resolvedStyle.rotationZ = this.rotationZ;
        resolvedStyle.transformOrigin = this.transformOrigin;
        resolvedStyle.zIndex = this.zIndex;
        resolvedStyle.borderColor = this.borderColor;
        resolvedStyle.borderBrush = this.borderBrush;
        resolvedStyle.backgroundColor = this.backgroundColor;
        resolvedStyle.backgroundBrush = this.backgroundBrush;
        resolvedStyle.foregroundBrush = this.foregroundBrush;
        resolvedStyle.dropShadow = this.dropShadow;
        resolvedStyle.innerShadow = this.innerShadow;
        resolvedStyle.clip = this.clip;
        resolvedStyle.width = this.width;
        resolvedStyle.height = this.height;
        resolvedStyle.widthFraction = this.widthFraction;
        resolvedStyle.heightFraction = this.heightFraction;
        copyInheritedStylesInto$foundation(resolvedStyle);
    }

    public final int diff$foundation(ResolvedStyle resolvedStyle, int i) {
        int i2 = this.flags;
        int i3 = resolvedStyle.flags;
        int i4 = i2 ^ i3;
        int i5 = i & i2 & i3;
        if ((i5 & 1) != 0 && (this.contentPaddingStart != resolvedStyle.contentPaddingStart || this.contentPaddingEnd != resolvedStyle.contentPaddingEnd || this.contentPaddingTop != resolvedStyle.contentPaddingTop || this.contentPaddingBottom != resolvedStyle.contentPaddingBottom || this.borderWidth != resolvedStyle.borderWidth)) {
            i4 |= 1;
        }
        if ((i5 & 8) != 0 && (this.width != resolvedStyle.width || this.height != resolvedStyle.height || this.widthFraction != resolvedStyle.widthFraction || this.heightFraction != resolvedStyle.heightFraction || this.externalPaddingStart != resolvedStyle.externalPaddingStart || this.externalPaddingEnd != resolvedStyle.externalPaddingEnd || this.externalPaddingTop != resolvedStyle.externalPaddingTop || this.externalPaddingBottom != resolvedStyle.externalPaddingBottom || Float.floatToRawIntBits(this.left) != Float.floatToRawIntBits(resolvedStyle.left) || Float.floatToRawIntBits(this.top) != Float.floatToRawIntBits(resolvedStyle.top) || Float.floatToRawIntBits(this.right) != Float.floatToRawIntBits(resolvedStyle.right) || Float.floatToRawIntBits(this.bottom) != Float.floatToRawIntBits(resolvedStyle.bottom) || Float.floatToRawIntBits(this.minWidth) != Float.floatToRawIntBits(resolvedStyle.minWidth) || Float.floatToRawIntBits(this.maxWidth) != Float.floatToRawIntBits(resolvedStyle.maxWidth) || Float.floatToRawIntBits(this.minHeight) != Float.floatToRawIntBits(resolvedStyle.minHeight) || Float.floatToRawIntBits(this.maxHeight) != Float.floatToRawIntBits(resolvedStyle.maxHeight))) {
            i4 |= 8;
        }
        if ((i5 & 2) != 0 && (this.borderWidth != resolvedStyle.borderWidth || !Color.m435equalsimpl0(this.borderColor, resolvedStyle.borderColor) || !Intrinsics.areEqual(this.borderBrush, resolvedStyle.borderBrush) || !Color.m435equalsimpl0(this.backgroundColor, resolvedStyle.backgroundColor) || !Intrinsics.areEqual(this.backgroundBrush, resolvedStyle.backgroundBrush) || !Intrinsics.areEqual(this.foregroundBrush, resolvedStyle.foregroundBrush) || !Intrinsics.areEqual(this.innerShadow, resolvedStyle.innerShadow) || !Intrinsics.areEqual(this.dropShadow, resolvedStyle.dropShadow) || !Intrinsics.areEqual(this.shape, resolvedStyle.shape))) {
            i4 |= 2;
        }
        if ((i5 & 4) != 0 && (this.alpha != resolvedStyle.alpha || this.scaleX != resolvedStyle.scaleX || this.scaleY != resolvedStyle.scaleY || this.translationX != resolvedStyle.translationX || this.translationY != resolvedStyle.translationY || this.rotationX != resolvedStyle.rotationX || this.rotationY != resolvedStyle.rotationY || this.rotationZ != resolvedStyle.rotationZ || !TransformOrigin.m451equalsimpl0(this.transformOrigin, resolvedStyle.transformOrigin) || this.clip != resolvedStyle.clip)) {
            i4 |= 4;
        }
        if (!Intrinsics.areEqual(this.shape, resolvedStyle.shape)) {
            i4 |= 6;
        }
        if ((i5 & 64) != 0 && (!Color.m435equalsimpl0(this.contentColor, resolvedStyle.contentColor) || !Intrinsics.areEqual(this.contentBrush, resolvedStyle.contentBrush))) {
            i4 |= 64;
        }
        return ((i5 & 32) == 0 || (Intrinsics.areEqual(this.fontFamily, resolvedStyle.fontFamily) && Intrinsics.areEqual(this.textIndent, resolvedStyle.textIndent) && TextUnit.m725equalsimpl0(this.fontSize, resolvedStyle.fontSize) && TextUnit.m725equalsimpl0(this.lineHeight, resolvedStyle.lineHeight) && TextUnit.m725equalsimpl0(this.letterSpacing, resolvedStyle.letterSpacing) && Float.compare(this.baselineShift, resolvedStyle.baselineShift) == 0 && this.lineBreak == resolvedStyle.lineBreak && this.textEnums == resolvedStyle.textEnums)) ? i4 : i4 | 96;
    }

    @Override // androidx.compose.runtime.CompositionLocalAccessorScope
    public final Object getCurrentValue(ProvidableCompositionLocal providableCompositionLocal) {
        return HitTestResultKt.currentValueOf(this.node, providableCompositionLocal);
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this._density;
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return 1.0f;
    }

    /* JADX INFO: renamed from: getFontSynthesis-GVVA2EU$foundation, reason: not valid java name */
    public final int m160getFontSynthesisGVVA2EU$foundation() {
        int i = ((this.textEnums & 15360) >> 10) & 7;
        if (i != 0 && i != 1 && i != 2 && i != 65535) {
            InlineClassHelperKt.throwIllegalArgumentException("The given value=" + i + " is not recognized by FontSynthesis.");
        }
        return i;
    }

    /* JADX INFO: renamed from: getHyphens-vmbZdU8$foundation, reason: not valid java name */
    public final int m161getHyphensvmbZdU8$foundation() {
        int i = (this.textEnums & 768) >> 8;
        if (i >= 0 && i < 3) {
            return i;
        }
        InlineClassHelperKt.throwIllegalArgumentException("The given value=" + i + " is not recognized by Hyphens.");
        return i;
    }

    /* JADX INFO: renamed from: getTextAlign-e0LSkKk$foundation, reason: not valid java name */
    public final int m162getTextAligne0LSkKk$foundation() {
        int i = (this.textEnums & 28) >> 2;
        if (i >= 0 && i < 7) {
            return i;
        }
        InlineClassHelperKt.throwIllegalArgumentException("The given value=" + i + " is not recognized by TextAlign.");
        return i;
    }

    public final TextDecoration getTextDecoration$foundation() {
        int i = ((this.textEnums & 114688) >> 14) & 3;
        if (i == 0) {
            return TextDecoration.None;
        }
        if (i != 1) {
            return i != 2 ? new TextDecoration(i) : TextDecoration.LineThrough;
        }
        return TextDecoration.Underline;
    }

    /* JADX INFO: renamed from: getTextDirection-s_7X-co$foundation, reason: not valid java name */
    public final int m163getTextDirections_7Xco$foundation() {
        int i = (this.textEnums & 112) >> 4;
        if (i >= 0 && i < 6) {
            return i;
        }
        InlineClassHelperKt.throwIllegalArgumentException("The given value=" + i + " is not recognized by TextDirection.");
        return i;
    }

    public final void resolve$foundation(Style style, StyleOuterNode styleOuterNode, Density density, boolean z) {
        this.currentIndex = 0;
        this.compositeHash = 0;
        this.node = styleOuterNode;
        this._density = density.getDensity();
        this.animating = z;
        style.applyStyle(this);
        this.node = null;
        this.animating = false;
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public final /* synthetic */ int mo86roundToPx0680j_4(float f) {
        return Density.CC.m695$default$roundToPx0680j_4(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public final /* synthetic */ float mo87toDpGaN1DYA(long j) {
        return Density.CC.m696$default$toDpGaN1DYA(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final float mo89toDpu2uoSUM(int i) {
        return i / getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public final /* synthetic */ long mo90toDpSizekrfVVM(long j) {
        return Density.CC.m697$default$toDpSizekrfVVM(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public final /* synthetic */ float mo91toPxR2X_6o(long j) {
        return Density.CC.m698$default$toPxR2X_6o(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public final float mo92toPx0680j_4(float f) {
        return getDensity() * f;
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public final /* synthetic */ long mo93toSizeXkaWNTQ(long j) {
        return Density.CC.m699$default$toSizeXkaWNTQ(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public final long mo94toSpkPz2Gy4(float f) {
        return Density.CC.m700$default$toSp0xMU5do(this, mo88toDpu2uoSUM(f));
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final float mo88toDpu2uoSUM(float f) {
        return f / getDensity();
    }
}
