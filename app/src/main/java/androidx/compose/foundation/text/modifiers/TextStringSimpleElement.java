package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextStringSimpleElement extends ModifierNodeElement {
    public final FontFamily$Resolver fontFamilyResolver;
    public final int maxLines;
    public final int minLines;
    public final int overflow;
    public final boolean softWrap;
    public final TextStyle style;
    public final String text;

    public TextStringSimpleElement(String str, TextStyle textStyle, FontFamily$Resolver fontFamily$Resolver, int i, boolean z, int i2, int i3) {
        this.text = str;
        this.style = textStyle;
        this.fontFamilyResolver = fontFamily$Resolver;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        TextStringSimpleNode textStringSimpleNode = new TextStringSimpleNode();
        textStringSimpleNode.text = this.text;
        textStringSimpleNode.style = this.style;
        textStringSimpleNode.fontFamilyResolver = this.fontFamilyResolver;
        textStringSimpleNode.overflow = this.overflow;
        textStringSimpleNode.softWrap = this.softWrap;
        textStringSimpleNode.maxLines = this.maxLines;
        textStringSimpleNode.minLines = this.minLines;
        return textStringSimpleNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStringSimpleElement)) {
            return false;
        }
        TextStringSimpleElement textStringSimpleElement = (TextStringSimpleElement) obj;
        return Intrinsics.areEqual(this.text, textStringSimpleElement.text) && Intrinsics.areEqual(this.style, textStringSimpleElement.style) && Intrinsics.areEqual(this.fontFamilyResolver, textStringSimpleElement.fontFamilyResolver) && this.overflow == textStringSimpleElement.overflow && this.softWrap == textStringSimpleElement.softWrap && this.maxLines == textStringSimpleElement.maxLines && this.minLines == textStringSimpleElement.minLines;
    }

    public final int hashCode() {
        return (((((((((this.fontFamilyResolver.hashCode() + Modifier.CC.m(this.style, this.text.hashCode() * 31, 31)) * 31) + this.overflow) * 31) + (this.softWrap ? 1231 : 1237)) * 31) + this.maxLines) * 31) + this.minLines) * 31;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002e  */
    /* JADX WARN: Code duplicated, block: B:16:0x0042  */
    /* JADX WARN: Code duplicated, block: B:19:0x004b  */
    /* JADX WARN: Code duplicated, block: B:22:0x0054  */
    /* JADX WARN: Code duplicated, block: B:25:0x0061  */
    /* JADX WARN: Code duplicated, block: B:28:0x006a  */
    /* JADX WARN: Code duplicated, block: B:29:0x006c  */
    /* JADX WARN: Code duplicated, block: B:33:0x0074  */
    /* JADX WARN: Code duplicated, block: B:36:0x007a  */
    /* JADX WARN: Code duplicated, block: B:40:0x0096  */
    /* JADX WARN: Code duplicated, block: B:44:0x009e  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:? A[RETURN, SYNTHETIC] */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        boolean z;
        String str;
        String str2;
        boolean z2;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z3;
        boolean z4;
        FontFamily$Resolver fontFamily$Resolver;
        FontFamily$Resolver fontFamily$Resolver2;
        int i5;
        int i6;
        TextStringSimpleNode textStringSimpleNode = (TextStringSimpleNode) node;
        textStringSimpleNode.getClass();
        TextStyle textStyle = textStringSimpleNode.style;
        boolean z5 = false;
        boolean z6 = true;
        TextStyle textStyle2 = this.style;
        if (textStyle2 != textStyle) {
            if (!textStyle2.spanStyle.hasSameNonLayoutAttributes$ui_text(textStyle.spanStyle)) {
                z = true;
            }
            str = textStringSimpleNode.text;
            str2 = this.text;
            if (!Intrinsics.areEqual(str, str2)) {
                textStringSimpleNode.text = str2;
                textStringSimpleNode.textSubstitution = null;
                z5 = true;
            }
            z2 = !textStringSimpleNode.style.hasSameLayoutAffectingAttributes(textStyle2);
            textStringSimpleNode.style = textStyle2;
            i = textStringSimpleNode.minLines;
            i2 = this.minLines;
            if (i != i2) {
                textStringSimpleNode.minLines = i2;
                z2 = true;
            }
            i3 = textStringSimpleNode.maxLines;
            i4 = this.maxLines;
            if (i3 != i4) {
                textStringSimpleNode.maxLines = i4;
                z2 = true;
            }
            z3 = textStringSimpleNode.softWrap;
            z4 = this.softWrap;
            if (z3 != z4) {
                textStringSimpleNode.softWrap = z4;
                z2 = true;
            }
            fontFamily$Resolver = textStringSimpleNode.fontFamilyResolver;
            fontFamily$Resolver2 = this.fontFamilyResolver;
            if (!Intrinsics.areEqual(fontFamily$Resolver, fontFamily$Resolver2)) {
                textStringSimpleNode.fontFamilyResolver = fontFamily$Resolver2;
                z2 = true;
            }
            i5 = textStringSimpleNode.overflow;
            i6 = this.overflow;
            if (i5 == i6) {
                z6 = z2;
            } else {
                textStringSimpleNode.overflow = i6;
            }
            if (z || z5 || z6) {
                textStringSimpleNode.resolvedInheritedStyle = null;
            }
            if (z5 || z6) {
                textStringSimpleNode.getLayoutCache().m206updateL6sJoHM(textStringSimpleNode.text, textStringSimpleNode.style, textStringSimpleNode.fontFamilyResolver, textStringSimpleNode.overflow, textStringSimpleNode.softWrap, textStringSimpleNode.maxLines, textStringSimpleNode.minLines);
            }
            if (textStringSimpleNode.isAttached) {
                if (z5 || (z && textStringSimpleNode.semanticsTextLayoutResult != null)) {
                    HitTestResultKt.invalidateSemantics(textStringSimpleNode);
                }
                if (z5 || z6) {
                    HitTestResultKt.invalidateMeasurement(textStringSimpleNode);
                    HitTestResultKt.invalidateDraw(textStringSimpleNode);
                }
                if (z) {
                    HitTestResultKt.invalidateDraw(textStringSimpleNode);
                }
            }
            return;
        }
        textStyle2.getClass();
        z = false;
        str = textStringSimpleNode.text;
        str2 = this.text;
        if (!Intrinsics.areEqual(str, str2)) {
            textStringSimpleNode.text = str2;
            textStringSimpleNode.textSubstitution = null;
            z5 = true;
        }
        z2 = !textStringSimpleNode.style.hasSameLayoutAffectingAttributes(textStyle2);
        textStringSimpleNode.style = textStyle2;
        i = textStringSimpleNode.minLines;
        i2 = this.minLines;
        if (i != i2) {
            textStringSimpleNode.minLines = i2;
            z2 = true;
        }
        i3 = textStringSimpleNode.maxLines;
        i4 = this.maxLines;
        if (i3 != i4) {
            textStringSimpleNode.maxLines = i4;
            z2 = true;
        }
        z3 = textStringSimpleNode.softWrap;
        z4 = this.softWrap;
        if (z3 != z4) {
            textStringSimpleNode.softWrap = z4;
            z2 = true;
        }
        fontFamily$Resolver = textStringSimpleNode.fontFamilyResolver;
        fontFamily$Resolver2 = this.fontFamilyResolver;
        if (!Intrinsics.areEqual(fontFamily$Resolver, fontFamily$Resolver2)) {
            textStringSimpleNode.fontFamilyResolver = fontFamily$Resolver2;
            z2 = true;
        }
        i5 = textStringSimpleNode.overflow;
        i6 = this.overflow;
        if (i5 == i6) {
            z6 = z2;
        } else {
            textStringSimpleNode.overflow = i6;
        }
        if (z) {
            textStringSimpleNode.resolvedInheritedStyle = null;
        } else {
            textStringSimpleNode.resolvedInheritedStyle = null;
        }
        if (z5) {
            textStringSimpleNode.getLayoutCache().m206updateL6sJoHM(textStringSimpleNode.text, textStringSimpleNode.style, textStringSimpleNode.fontFamilyResolver, textStringSimpleNode.overflow, textStringSimpleNode.softWrap, textStringSimpleNode.maxLines, textStringSimpleNode.minLines);
        } else {
            textStringSimpleNode.getLayoutCache().m206updateL6sJoHM(textStringSimpleNode.text, textStringSimpleNode.style, textStringSimpleNode.fontFamilyResolver, textStringSimpleNode.overflow, textStringSimpleNode.softWrap, textStringSimpleNode.maxLines, textStringSimpleNode.minLines);
        }
        if (textStringSimpleNode.isAttached) {
            return;
        }
        if (z5) {
            HitTestResultKt.invalidateSemantics(textStringSimpleNode);
        } else {
            HitTestResultKt.invalidateSemantics(textStringSimpleNode);
        }
        if (z5) {
            HitTestResultKt.invalidateMeasurement(textStringSimpleNode);
            HitTestResultKt.invalidateDraw(textStringSimpleNode);
        } else {
            HitTestResultKt.invalidateMeasurement(textStringSimpleNode);
            HitTestResultKt.invalidateDraw(textStringSimpleNode);
        }
        if (z) {
            HitTestResultKt.invalidateDraw(textStringSimpleNode);
        }
    }
}
