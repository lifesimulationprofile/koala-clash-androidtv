package androidx.compose.foundation.text;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
final class HeightInLinesElement extends ModifierNodeElement {
    public final int maxLines;
    public final int minLines;
    public final TextStyle textStyle;

    public HeightInLinesElement(TextStyle textStyle, int i, int i2) {
        this.textStyle = textStyle;
        this.minLines = i;
        this.maxLines = i2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        HeightInLinesNode heightInLinesNode = new HeightInLinesNode();
        heightInLinesNode.textStyle = this.textStyle;
        heightInLinesNode.minLines = this.minLines;
        heightInLinesNode.maxLines = this.maxLines;
        heightInLinesNode.precomputedMinLinesHeight = -1;
        heightInLinesNode.precomputedMaxLinesHeight = -1;
        return heightInLinesNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeightInLinesElement)) {
            return false;
        }
        HeightInLinesElement heightInLinesElement = (HeightInLinesElement) obj;
        return Intrinsics.areEqual(this.textStyle, heightInLinesElement.textStyle) && this.minLines == heightInLinesElement.minLines && this.maxLines == heightInLinesElement.maxLines;
    }

    public final int hashCode() {
        return (((this.textStyle.hashCode() * 31) + this.minLines) * 31) + this.maxLines;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        HeightInLinesNode heightInLinesNode = (HeightInLinesNode) node;
        TextStyle textStyle = heightInLinesNode.textStyle;
        TextStyle textStyle2 = this.textStyle;
        boolean zAreEqual = Intrinsics.areEqual(textStyle, textStyle2);
        int i = this.minLines;
        int i2 = this.maxLines;
        if (zAreEqual && heightInLinesNode.minLines == i && heightInLinesNode.maxLines == i2) {
            return;
        }
        heightInLinesNode.textStyle = textStyle2;
        heightInLinesNode.minLines = i;
        heightInLinesNode.maxLines = i2;
        heightInLinesNode.resolvedStyle = ParagraphKt.resolveDefaults(textStyle2, HitTestResultKt.requireLayoutNode(heightInLinesNode).layoutDirection);
        heightInLinesNode.dirty = true;
        HitTestResultKt.invalidateMeasurement(heightInLinesNode);
    }
}
