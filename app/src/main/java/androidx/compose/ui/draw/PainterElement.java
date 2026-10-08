package androidx.compose.ui.draw;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PainterElement extends ModifierNodeElement {
    public final Alignment alignment;
    public final float alpha;
    public final BlendModeColorFilter colorFilter;
    public final ContentScale contentScale;
    public final Painter painter;

    public PainterElement(Painter painter, Alignment alignment, ContentScale contentScale, float f, BlendModeColorFilter blendModeColorFilter) {
        this.painter = painter;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = blendModeColorFilter;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        PainterNode painterNode = new PainterNode();
        painterNode.painter = this.painter;
        painterNode.sizeToIntrinsics = true;
        painterNode.alignment = this.alignment;
        painterNode.contentScale = this.contentScale;
        painterNode.alpha = this.alpha;
        painterNode.colorFilter = this.colorFilter;
        return painterNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PainterElement)) {
            return false;
        }
        PainterElement painterElement = (PainterElement) obj;
        return Intrinsics.areEqual(this.painter, painterElement.painter) && Intrinsics.areEqual(this.alignment, painterElement.alignment) && Intrinsics.areEqual(this.contentScale, painterElement.contentScale) && Float.compare(this.alpha, painterElement.alpha) == 0 && Intrinsics.areEqual(this.colorFilter, painterElement.colorFilter);
    }

    public final int hashCode() {
        int iM = ImageAnalysis$$ExternalSyntheticLambda1.m(this.alpha, (this.contentScale.hashCode() + ((this.alignment.hashCode() + (((this.painter.hashCode() * 31) + 1231) * 31)) * 31)) * 31, 31);
        BlendModeColorFilter blendModeColorFilter = this.colorFilter;
        return iM + (blendModeColorFilter == null ? 0 : blendModeColorFilter.hashCode());
    }

    public final String toString() {
        return "PainterElement(painter=" + this.painter + ", sizeToIntrinsics=true, alignment=" + this.alignment + ", contentScale=" + this.contentScale + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        PainterNode painterNode = (PainterNode) node;
        boolean z = painterNode.sizeToIntrinsics;
        Painter painter = this.painter;
        boolean z2 = (z && Size.m384equalsimpl0(painterNode.painter.mo492getIntrinsicSizeNHjbRc(), painter.mo492getIntrinsicSizeNHjbRc())) ? false : true;
        painterNode.painter = painter;
        painterNode.sizeToIntrinsics = true;
        painterNode.alignment = this.alignment;
        painterNode.contentScale = this.contentScale;
        painterNode.alpha = this.alpha;
        painterNode.colorFilter = this.colorFilter;
        if (z2) {
            HitTestResultKt.invalidateMeasurement(painterNode);
        }
        HitTestResultKt.invalidateDraw(painterNode);
    }
}
