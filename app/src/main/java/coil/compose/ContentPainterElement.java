package coil.compose;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ContentPainterElement extends ModifierNodeElement {
    public final Alignment alignment;
    public final ContentScale contentScale;
    public final AsyncImagePainter painter;

    public ContentPainterElement(AsyncImagePainter asyncImagePainter, Alignment alignment, ContentScale contentScale) {
        this.painter = asyncImagePainter;
        this.alignment = alignment;
        this.contentScale = contentScale;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        ContentPainterNode contentPainterNode = new ContentPainterNode();
        contentPainterNode.painter = this.painter;
        contentPainterNode.alignment = this.alignment;
        contentPainterNode.contentScale = this.contentScale;
        contentPainterNode.alpha = 1.0f;
        return contentPainterNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContentPainterElement)) {
            return false;
        }
        ContentPainterElement contentPainterElement = (ContentPainterElement) obj;
        return this.painter.equals(contentPainterElement.painter) && Intrinsics.areEqual(this.alignment, contentPainterElement.alignment) && Intrinsics.areEqual(this.contentScale, contentPainterElement.contentScale) && Float.compare(1.0f, 1.0f) == 0;
    }

    public final int hashCode() {
        return ImageAnalysis$$ExternalSyntheticLambda1.m(1.0f, (this.contentScale.hashCode() + ((this.alignment.hashCode() + (this.painter.hashCode() * 31)) * 31)) * 31, 31);
    }

    public final String toString() {
        return "ContentPainterElement(painter=" + this.painter + ", alignment=" + this.alignment + ", contentScale=" + this.contentScale + ", alpha=1.0, colorFilter=null)";
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ContentPainterNode contentPainterNode = (ContentPainterNode) node;
        long jMo492getIntrinsicSizeNHjbRc = contentPainterNode.painter.mo492getIntrinsicSizeNHjbRc();
        AsyncImagePainter asyncImagePainter = this.painter;
        boolean zM384equalsimpl0 = Size.m384equalsimpl0(jMo492getIntrinsicSizeNHjbRc, asyncImagePainter.mo492getIntrinsicSizeNHjbRc());
        contentPainterNode.painter = asyncImagePainter;
        contentPainterNode.alignment = this.alignment;
        contentPainterNode.contentScale = this.contentScale;
        contentPainterNode.alpha = 1.0f;
        if (!zM384equalsimpl0) {
            HitTestResultKt.invalidateMeasurement(contentPainterNode);
        }
        HitTestResultKt.invalidateDraw(contentPainterNode);
    }
}
