package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextAnnotatedStringElement extends ModifierNodeElement {
    public final FontFamily$Resolver fontFamilyResolver;
    public final int maxLines;
    public final int minLines;
    public final Function1 onTextLayout;
    public final int overflow;
    public final boolean softWrap;
    public final TextStyle style;
    public final AnnotatedString text;

    public TextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily$Resolver fontFamily$Resolver, Function1 function1, int i, boolean z, int i2, int i3) {
        this.text = annotatedString;
        this.style = textStyle;
        this.fontFamilyResolver = fontFamily$Resolver;
        this.onTextLayout = function1;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new TextAnnotatedStringNode(this.text, this.style, this.fontFamilyResolver, this.onTextLayout, this.overflow, this.softWrap, this.maxLines, this.minLines, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextAnnotatedStringElement)) {
            return false;
        }
        TextAnnotatedStringElement textAnnotatedStringElement = (TextAnnotatedStringElement) obj;
        return this.text.equals(textAnnotatedStringElement.text) && Intrinsics.areEqual(this.style, textAnnotatedStringElement.style) && Intrinsics.areEqual(this.fontFamilyResolver, textAnnotatedStringElement.fontFamilyResolver) && this.onTextLayout == textAnnotatedStringElement.onTextLayout && this.overflow == textAnnotatedStringElement.overflow && this.softWrap == textAnnotatedStringElement.softWrap && this.maxLines == textAnnotatedStringElement.maxLines && this.minLines == textAnnotatedStringElement.minLines;
    }

    public final int hashCode() {
        int iHashCode = (this.fontFamilyResolver.hashCode() + Modifier.CC.m(this.style, this.text.hashCode() * 31, 31)) * 31;
        Function1 function1 = this.onTextLayout;
        return (((((((((iHashCode + (function1 != null ? function1.hashCode() : 0)) * 31) + this.overflow) * 31) + (this.softWrap ? 1231 : 1237)) * 31) + this.maxLines) * 31) + this.minLines) * 28629151;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        boolean z;
        TextAnnotatedStringNode textAnnotatedStringNode = (TextAnnotatedStringNode) node;
        TextStyle textStyle = textAnnotatedStringNode.style;
        TextStyle textStyle2 = this.style;
        if (textStyle2 != textStyle) {
            if (!textStyle2.spanStyle.hasSameNonLayoutAttributes$ui_text(textStyle.spanStyle)) {
                z = true;
            }
            textAnnotatedStringNode.doInvalidations(z, textAnnotatedStringNode.updateText$foundation(this.text), textAnnotatedStringNode.m211updateLayoutRelatedArgsy0kMQk(this.style, this.minLines, this.maxLines, this.softWrap, this.fontFamilyResolver, this.overflow), textAnnotatedStringNode.updateCallbacks(this.onTextLayout, null));
        }
        textStyle2.getClass();
        z = false;
        textAnnotatedStringNode.doInvalidations(z, textAnnotatedStringNode.updateText$foundation(this.text), textAnnotatedStringNode.m211updateLayoutRelatedArgsy0kMQk(this.style, this.minLines, this.maxLines, this.softWrap, this.fontFamilyResolver, this.overflow), textAnnotatedStringNode.updateCallbacks(this.onTextLayout, null));
    }
}
