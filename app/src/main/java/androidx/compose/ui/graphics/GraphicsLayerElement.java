package androidx.compose.ui.graphics;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.navigation.Navigator;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class GraphicsLayerElement extends ModifierNodeElement {
    public final float alpha;
    public final long ambientShadowColor;
    public final boolean clip;
    public final float scaleX;
    public final float scaleY;
    public final float shadowElevation;
    public final Shape shape;
    public final long spotShadowColor;
    public final long transformOrigin;

    public GraphicsLayerElement(float f, float f2, float f3, float f4, long j, Shape shape, boolean z, long j2, long j3) {
        this.scaleX = f;
        this.scaleY = f2;
        this.alpha = f3;
        this.shadowElevation = f4;
        this.transformOrigin = j;
        this.shape = shape;
        this.clip = z;
        this.ambientShadowColor = j2;
        this.spotShadowColor = j3;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        SimpleGraphicsLayerModifier simpleGraphicsLayerModifier = new SimpleGraphicsLayerModifier();
        simpleGraphicsLayerModifier.scaleX = this.scaleX;
        simpleGraphicsLayerModifier.scaleY = this.scaleY;
        simpleGraphicsLayerModifier.alpha = this.alpha;
        simpleGraphicsLayerModifier.shadowElevation = this.shadowElevation;
        simpleGraphicsLayerModifier.cameraDistance = 8.0f;
        simpleGraphicsLayerModifier.transformOrigin = this.transformOrigin;
        simpleGraphicsLayerModifier.shape = this.shape;
        simpleGraphicsLayerModifier.clip = this.clip;
        simpleGraphicsLayerModifier.ambientShadowColor = this.ambientShadowColor;
        simpleGraphicsLayerModifier.spotShadowColor = this.spotShadowColor;
        simpleGraphicsLayerModifier.blendMode = 3;
        simpleGraphicsLayerModifier.layerBlock = new Navigator.AnonymousClass1(10, simpleGraphicsLayerModifier);
        return simpleGraphicsLayerModifier;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GraphicsLayerElement)) {
            return false;
        }
        GraphicsLayerElement graphicsLayerElement = (GraphicsLayerElement) obj;
        return Float.compare(this.scaleX, graphicsLayerElement.scaleX) == 0 && Float.compare(this.scaleY, graphicsLayerElement.scaleY) == 0 && Float.compare(this.alpha, graphicsLayerElement.alpha) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(this.shadowElevation, graphicsLayerElement.shadowElevation) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(8.0f, 8.0f) == 0 && TransformOrigin.m451equalsimpl0(this.transformOrigin, graphicsLayerElement.transformOrigin) && Intrinsics.areEqual(this.shape, graphicsLayerElement.shape) && this.clip == graphicsLayerElement.clip && Color.m435equalsimpl0(this.ambientShadowColor, graphicsLayerElement.ambientShadowColor) && Color.m435equalsimpl0(this.spotShadowColor, graphicsLayerElement.spotShadowColor);
    }

    public final int hashCode() {
        int iM = ImageAnalysis$$ExternalSyntheticLambda1.m(8.0f, ImageAnalysis$$ExternalSyntheticLambda1.m(0.0f, ImageAnalysis$$ExternalSyntheticLambda1.m(0.0f, ImageAnalysis$$ExternalSyntheticLambda1.m(0.0f, ImageAnalysis$$ExternalSyntheticLambda1.m(this.shadowElevation, ImageAnalysis$$ExternalSyntheticLambda1.m(0.0f, ImageAnalysis$$ExternalSyntheticLambda1.m(0.0f, ImageAnalysis$$ExternalSyntheticLambda1.m(this.alpha, ImageAnalysis$$ExternalSyntheticLambda1.m(this.scaleY, Float.floatToIntBits(this.scaleX) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31);
        int i = TransformOrigin.$r8$clinit;
        long j = this.transformOrigin;
        int iHashCode = (((this.shape.hashCode() + ((((int) (j ^ (j >>> 32))) + iM) * 31)) * 31) + (this.clip ? 1231 : 1237)) * 961;
        int i2 = Color.$r8$clinit;
        return (((ULong.m831hashCodeimpl(this.spotShadowColor) + ImageAnalysis$$ExternalSyntheticLambda1.m(iHashCode, 31, this.ambientShadowColor)) * 961) + 3) * 31;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GraphicsLayerElement(scaleX=");
        sb.append(this.scaleX);
        sb.append(", scaleY=");
        sb.append(this.scaleY);
        sb.append(", alpha=");
        sb.append(this.alpha);
        sb.append(", translationX=0.0, translationY=0.0, shadowElevation=");
        sb.append(this.shadowElevation);
        sb.append(", rotationX=0.0, rotationY=0.0, rotationZ=0.0, cameraDistance=8.0, transformOrigin=");
        sb.append((Object) TransformOrigin.m454toStringimpl(this.transformOrigin));
        sb.append(", shape=");
        sb.append(this.shape);
        sb.append(", clip=");
        sb.append(this.clip);
        sb.append(", renderEffect=null, ambientShadowColor=");
        ImageAnalysis$$ExternalSyntheticLambda1.m(this.ambientShadowColor, sb, ", spotShadowColor=");
        sb.append((Object) Color.m441toStringimpl(this.spotShadowColor));
        sb.append(", compositingStrategy=CompositingStrategy(value=0), blendMode=");
        sb.append((Object) BrushKt.m429toStringimpl(3));
        sb.append(", colorFilter=null)");
        return sb.toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        SimpleGraphicsLayerModifier simpleGraphicsLayerModifier = (SimpleGraphicsLayerModifier) node;
        simpleGraphicsLayerModifier.scaleX = this.scaleX;
        simpleGraphicsLayerModifier.scaleY = this.scaleY;
        simpleGraphicsLayerModifier.alpha = this.alpha;
        simpleGraphicsLayerModifier.shadowElevation = this.shadowElevation;
        simpleGraphicsLayerModifier.cameraDistance = 8.0f;
        simpleGraphicsLayerModifier.transformOrigin = this.transformOrigin;
        simpleGraphicsLayerModifier.shape = this.shape;
        simpleGraphicsLayerModifier.clip = this.clip;
        simpleGraphicsLayerModifier.ambientShadowColor = this.ambientShadowColor;
        simpleGraphicsLayerModifier.spotShadowColor = this.spotShadowColor;
        simpleGraphicsLayerModifier.blendMode = 3;
        HitTestResultKt.updateLayerBlock(simpleGraphicsLayerModifier, simpleGraphicsLayerModifier.layerBlock);
    }
}
