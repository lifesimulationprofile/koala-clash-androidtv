package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SelectableTextAnnotatedStringElement extends ModifierNodeElement {
    public final FontFamily$Resolver fontFamilyResolver;
    public final int maxLines;
    public final int minLines;
    public final Function1 onTextLayout;
    public final int overflow;
    public final SelectionController selectionController;
    public final boolean softWrap;
    public final TextStyle style;
    public final AnnotatedString text;

    public SelectableTextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily$Resolver fontFamily$Resolver, Function1 function1, int i, boolean z, int i2, int i3, SelectionController selectionController) {
        this.text = annotatedString;
        this.style = textStyle;
        this.fontFamilyResolver = fontFamily$Resolver;
        this.onTextLayout = function1;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        this.selectionController = selectionController;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new SelectableTextAnnotatedStringNode(this.text, this.style, this.fontFamilyResolver, this.onTextLayout, this.overflow, this.softWrap, this.maxLines, this.minLines, this.selectionController);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectableTextAnnotatedStringElement)) {
            return false;
        }
        SelectableTextAnnotatedStringElement selectableTextAnnotatedStringElement = (SelectableTextAnnotatedStringElement) obj;
        return this.text.equals(selectableTextAnnotatedStringElement.text) && Intrinsics.areEqual(this.style, selectableTextAnnotatedStringElement.style) && Intrinsics.areEqual(this.fontFamilyResolver, selectableTextAnnotatedStringElement.fontFamilyResolver) && this.onTextLayout == selectableTextAnnotatedStringElement.onTextLayout && this.overflow == selectableTextAnnotatedStringElement.overflow && this.softWrap == selectableTextAnnotatedStringElement.softWrap && this.maxLines == selectableTextAnnotatedStringElement.maxLines && this.minLines == selectableTextAnnotatedStringElement.minLines && this.selectionController.equals(selectableTextAnnotatedStringElement.selectionController);
    }

    public final int hashCode() {
        int iHashCode = (this.fontFamilyResolver.hashCode() + Modifier.CC.m(this.style, this.text.hashCode() * 31, 31)) * 31;
        Function1 function1 = this.onTextLayout;
        return (this.selectionController.hashCode() + ((((((((((iHashCode + (function1 != null ? function1.hashCode() : 0)) * 31) + this.overflow) * 31) + (this.softWrap ? 1231 : 1237)) * 31) + this.maxLines) * 31) + this.minLines) * 29791)) * 961;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        boolean z;
        SelectableTextAnnotatedStringNode selectableTextAnnotatedStringNode = (SelectableTextAnnotatedStringNode) node;
        TextAnnotatedStringNode textAnnotatedStringNode = selectableTextAnnotatedStringNode.textAnnotatedStringNode;
        TextStyle textStyle = textAnnotatedStringNode.style;
        TextStyle textStyle2 = this.style;
        if (textStyle2 != textStyle) {
            if (!textStyle2.spanStyle.hasSameNonLayoutAttributes$ui_text(textStyle.spanStyle)) {
                z = true;
            }
            boolean zUpdateText$foundation = textAnnotatedStringNode.updateText$foundation(this.text);
            boolean zM211updateLayoutRelatedArgsy0kMQk = selectableTextAnnotatedStringNode.textAnnotatedStringNode.m211updateLayoutRelatedArgsy0kMQk(textStyle2, this.minLines, this.maxLines, this.softWrap, this.fontFamilyResolver, this.overflow);
            Function1 function1 = this.onTextLayout;
            SelectionController selectionController = this.selectionController;
            textAnnotatedStringNode.doInvalidations(z, zUpdateText$foundation, zM211updateLayoutRelatedArgsy0kMQk, textAnnotatedStringNode.updateCallbacks(function1, selectionController));
            selectableTextAnnotatedStringNode.selectionController = selectionController;
            HitTestResultKt.invalidateMeasurement(selectableTextAnnotatedStringNode);
        }
        textStyle2.getClass();
        z = false;
        boolean zUpdateText$foundation2 = textAnnotatedStringNode.updateText$foundation(this.text);
        boolean zM211updateLayoutRelatedArgsy0kMQk2 = selectableTextAnnotatedStringNode.textAnnotatedStringNode.m211updateLayoutRelatedArgsy0kMQk(textStyle2, this.minLines, this.maxLines, this.softWrap, this.fontFamilyResolver, this.overflow);
        Function1 function2 = this.onTextLayout;
        SelectionController selectionController2 = this.selectionController;
        textAnnotatedStringNode.doInvalidations(z, zUpdateText$foundation2, zM211updateLayoutRelatedArgsy0kMQk2, textAnnotatedStringNode.updateCallbacks(function2, selectionController2));
        selectableTextAnnotatedStringNode.selectionController = selectionController2;
        HitTestResultKt.invalidateMeasurement(selectableTextAnnotatedStringNode);
    }
}
